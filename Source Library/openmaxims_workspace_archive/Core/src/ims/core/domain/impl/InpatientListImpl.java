//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.42 build 2221.27776)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.configuration.InitConfig;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.vo.InpatientEpisodeRefVo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.domain.ADT;
import ims.core.domain.InpatientList;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.InpatientEpisodeVoCollection;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicWithMappingsLiteVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.PatientId;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.InpatientEpisodeVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.MedicWithMappingsLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.Sex;
import ims.core.vo.lookups.Specialty;
import ims.correspondence.configuration.domain.objects.UserAccess;
import ims.correspondence.vo.CorrespondenceDetailsVo;
import ims.correspondence.vo.UserAccessVo;
import ims.correspondence.vo.domain.UserAccessVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupMapping;
import ims.dto.DTODomainImplementation;
import ims.dto.client.Inpatientlist;
import ims.dto.client.Inpatientlist.InpatientlistRecord;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.icp.vo.InpatientEpisodeWithICPInfoVo;
import ims.icp.vo.domain.InpatientEpisodeWithICPInfoVoAssembler;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class InpatientListImpl extends DTODomainImplementation implements InpatientList
{
	//	wdev-4210 need to mark this impl as a mix of both dto and hibernate
	public boolean dtoOnly()
	{
		return InitConfig.getConfigType().equals("DTO");
	}

	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}
	
	/**
	* listInpatients By Ward
	*/
	public ims.core.vo.InpatientEpisodeVoCollection listInpatientsByWard(LocShortMappingsVo ward)
	{	
		return listInpatients(null, null,ward, null, null,null); //m
	}

	/**
	* listInpatients By Ward or Hospital
	*/
	public ims.core.vo.InpatientEpisodeVoCollection listInpatientsByHospital(LocationRefVo hospital)
	{
		return listInpatients(null, hospital, null, null, null,null);//m
	}
	
	/**
	* list all Wards for the supplied Hospital. For each Ward retrieved get the PAS Mapping. Return a delimiter string of Ward Mappings 
	*/
	private String listWardMappingsForHospital(LocationRefVo hospital)
	{
		String strListLocalCodes = "";
		OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		LocShortMappingsVoCollection voLocShortColl = locImpl.listActiveWardsForHospital(hospital);
		
		if (voLocShortColl != null && voLocShortColl.size() > 0)
		{
			String delim = "|";
			
			for(int i=0; i<voLocShortColl.size(); i++)
			{
				LocShortMappingsVo voLocShort = voLocShortColl.get(i);
				strListLocalCodes += voLocShort.getPasMapping();
				if(voLocShortColl.size() - i == 2)
					strListLocalCodes += delim;
			}
		}
		return strListLocalCodes;
	}
	
	public ims.core.vo.LocShortMappingsVoCollection listActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
		OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return locImpl.listActiveWardsForHospital(hospital);
	}

	
	private InpatientEpisodeVoCollection listInpatients(PatientRefVo patient, LocationRefVo hospital, LocationRefVo ward, HcpRefVo consultant, MedicLiteVo voMedic,Specialty specialty)//m
	{
		if(ConfigFlag.DOM.INPATIENT_SEARCH_TYPE.getValue().equals("LOCAL"))   
			return listInpatientsHibernate(patient, hospital, ward, consultant,specialty);
		else if(ConfigFlag.DOM.INPATIENT_SEARCH_TYPE.getValue().equals("DTO"))
			return listInpatientsDTO(patient, hospital, ward, consultant,specialty);
		
		return null;
	}

	private InpatientEpisodeVoCollection listInpatientsDTO(PatientRefVo patient, LocationRefVo hospital, LocationRefVo ward, HcpRefVo consultant,Specialty specialty) 
	{
		//WDEV-15526
		return listInpatientsDTOBySearchCriteria(null, null, null, null, hospital, ward, consultant, specialty,patient);
	}

	
	private String getPASMappingForSpecialty(Specialty specialty)
	{
		String strListLocalCodes = "";
		if(specialty == null)
			return strListLocalCodes;
		LookupMappingVoCollection voSpeccol = getMappings(specialty.getID());
		if(voSpeccol != null && voSpeccol.size() > 0)
		{
			for(int i=0; i<voSpeccol.size(); i++)
			{
				LookupMappingVo voSpec = voSpeccol.get(i);
				if(voSpec != null && voSpec.getExtSystem() != null && voSpec.getExtSystem().equals(ims.core.vo.lookups.TaxonomyType.PAS.toString()))
				{
					strListLocalCodes += voSpec.getExtCode();
					return strListLocalCodes;
				}
				
			}
				
		}
		return strListLocalCodes;
		
	}
	
	public LookupMappingVoCollection getMappings(int instanceid)
	{
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.LookupInstance doInst = factory.getLookupInstance(instanceid);
		if(doInst == null)
			return null;
		Set mappings = doInst.getMappings();
		LookupMappingVoCollection mapColl = new LookupMappingVoCollection();
		Iterator iter = mappings.iterator();
		LookupMapping doMapping;
		while (iter.hasNext())
		{
			doMapping = (LookupMapping) iter.next();
			mapColl.add(new LookupMappingVo(doMapping.getExtSystem(), doMapping.getExtCode()));
		}
		mapColl.sort();
		return mapColl;
	}

	private MedicWithMappingsLiteVo getMedicWithMappingsLiteVo(HcpRefVo consultant) {
		DomainFactory factory = getDomainFactory();
		if(consultant != null && consultant.getID_HcpIsNotNull()){
			DomainObject medic = factory.getDomainObject(Medic.class, consultant.getID_Hcp());
			if(medic!=null)
				return MedicWithMappingsLiteVoAssembler.create((Medic)medic);
		}

		return null;
	}

	private InpatientEpisodeVoCollection listInpatientsHibernate(PatientRefVo patient, LocationRefVo hospital, LocationRefVo voWard, HcpRefVo voMedic,Specialty specialty) //m 
	{
		//WDEV-15526
		return listInpatientsHibernateBySearchCriteria(null, null, null, null, hospital, voWard, voMedic, specialty,patient);
		
		//code was moved to listInpatientsHibernateBySearchCriteria();
		/*
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql = " from InpatientEpisode ip "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		if (voWard != null)
		{
			condStr.append(andStr + " ip.pasEvent.location.id = :ward");
			markers.add("ward");
			values.add(voWard.getID_Location());
			andStr = " and ";
		}
		else if(hospital != null)
		{
			condStr.append(andStr + " ip.pasEvent.location.parentLocation.id = :hospital");
			markers.add("hospital");
			values.add(hospital.getID_Location());
			andStr = " and ";
		}
		if (voMedic != null)
		{
			condStr.append(andStr + " ip.pasEvent.consultant.id = :cons");
			markers.add("cons");
			values.add(voMedic.getID_Hcp());
			andStr = " and ";
		}
		if(specialty != null)
		{
			condStr.append(andStr + " ip.pasEvent.specialty.id = :idSpecialty");
			markers.add("idSpecialty");
			values.add(specialty.getID());
			andStr = " and ";
		}
	

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		
		hql += condStr.toString();
		List ips = factory.find(hql, markers, values);
		
		return InpatientEpisodeVoAssembler.createInpatientEpisodeVoCollectionFromInpatientEpisode(ips);
		*/
	}

	public CorrespondenceDetailsVo getCorrespondenceDetailsByPasEvent(PASEventRefVo pasEventRef) 
	{
		return null;
	}

	public MedicLiteVoCollection listActiveMedics(String strMedicName) {
		
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
        return hcpAdmin.listActiveMedics(strMedicName);

	}

	public UserAccessVo getUserAccess(Integer userID) 
	{
		if (userID == null)
			throw new CodingRuntimeException("Can not search on null user");
		
		DomainFactory factory = getDomainFactory();
		return UserAccessVoAssembler.create(UserAccess.getUserAccessFromAppUser(factory, userID));	
	}

	public HcpLiteVo getHCP(Integer idHCP) 
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		HcpFilter voFilter = new HcpFilter();
		voFilter.setID_Hcp(idHCP);
		return implHcpAdmin.getHcpLite(voFilter);
	}

	public LocationLiteVo getWard(LocationRefVo voWardRef)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return implLoc.getLocation(voWardRef.getID_Location());
	}

	public LocationLiteVo getHospital(LocationRefVo locationRefvo)
	{
		DomainFactory factory = getDomainFactory();
		return LocationLiteVoAssembler.create((Location) factory.getDomainObject(Location.class, locationRefvo.getID_Location()));
	}

/*	public LocShortMappingsVoCollection listActiveHospitals() 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitals();
	}
*/
	public LocationLiteVoCollection listActiveHospitals() 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();		
	}


	public HcpLiteVoCollection listHCPs(HcpFilter filter) 
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return implHcpAdmin.listHcpLite(filter);
	}
	
	public InpatientEpisodeVoCollection listInPatients(LocationLiteVo voHospital, LocationLiteVo voWard, HcpLiteVo voHcp,Specialty specialty) //m
	{
		 return listInpatients(null, voHospital,voWard, voHcp, null,specialty); //m
	}

	public InpatientEpisodeVoCollection listInPatients(LocShortMappingsVo voWard, MedicLiteVo voMedic) 
	{
		return listInpatients(null, null,voWard, null, voMedic,null); //m
		
	}

	public void dischargePatient(PatientShort patient, DischargedEpisodeVo discharge) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException 
	{
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		impl.dischargePatient(patient, discharge, null);
	}

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}
	
	//WDEV-15526
	public InpatientEpisodeVoCollection listInpatientsBySearchCriteria(PatIdType idType, String idValue, String surname, String forename, LocationLiteVo hospital, LocationLiteVo ward, HcpLiteVo hcp, Specialty specialty)
	{
		if(ConfigFlag.DOM.INPATIENT_SEARCH_TYPE.getValue().equals("LOCAL"))   
			return listInpatientsHibernateBySearchCriteria(idType,idValue,surname,forename,hospital,ward,hcp,specialty,null);
		else if(ConfigFlag.DOM.INPATIENT_SEARCH_TYPE.getValue().equals("DTO"))
			return listInpatientsDTOBySearchCriteria(idType,idValue,surname,forename,hospital,ward,hcp,specialty,null);
		
		return null;
	}
	
	//WDEV-15526
	private InpatientEpisodeVoCollection listInpatientsDTOBySearchCriteria(PatIdType idType, String idValue, String surname, String forename, LocationRefVo hospital, LocationRefVo ward, HcpRefVo consultant,Specialty specialty, PatientRefVo patient)
	{
		
		String extSystem = ConfigFlag.DOM.DEMOGRAPHICS_EXT_SYSTEM.getValue();
		boolean addWildcard = ConfigFlag.DTO.PAT_SEARCH_ADD_WILDCARD.getValue();

		PatientShort psIn = (PatientShort)patient;
		LocShortMappingsVo voWard = (LocShortMappingsVo)ward;
		MedicWithMappingsLiteVo voCons = getMedicWithMappingsLiteVo(consultant);
		
		ims.core.vo.InpatientEpisodeVoCollection inpColl = new ims.core.vo.InpatientEpisodeVoCollection();
		Inpatientlist inpat = (Inpatientlist) getDTOInstance(Inpatientlist.class);
		inpat.Filter.clear();

		//Identifiers
		if (idType != null)
		{
			if (idType.equals(PatIdType.HOSPNUM))
			{
				inpat.Filter.Hospnum = idValue;
			}
			else if (idType.equals(PatIdType.CHARTNUM))
			{
				inpat.Filter.Chartnum = idValue.toUpperCase();
			}
			
		}
		
		//Surname
		
		if (surname!=null)
		{
			String strSurname = removeWildCards(surname.trim());
			if (addWildcard)
				strSurname += "?";
			inpat.Filter.Snm=surname;
		}
		
		//Forename
		
		if (forename!=null)
		{
			String strSurname = removeWildCards(surname.trim());
			if (addWildcard)
				strSurname += "?";
			inpat.Filter.Fnm1=forename;
		}
		
		//now is the code from listInpatientsHibernate() -->
		
		if (psIn != null)
		{
			PatientId intfId = psIn.getInterfaceId();
			if (intfId == null)
			{
				throw new DomainRuntimeException("InPatient Episode List call must contain valid interface patient identifier");
			}

			if (intfId.getType().equals(PatIdType.HOSPNUM))
			{
				inpat.Filter.Hospnum = psIn.getInterfaceId().getValue();
			}
			else if (intfId.getType().equals(PatIdType.CHARTNUM))
			{
				inpat.Filter.Chartnum = psIn.getInterfaceId().getValue();
			}
		}
		if (voWard != null && voWard.getPasMapping() != null && voWard.getPasMapping().getTaxonomyCode() != null)
		{
			inpat.Filter.Rescode = voWard.getPasMapping().getTaxonomyCode();
		}
		else if (hospital != null)
		{
			inpat.Filter.Rescode = listWardMappingsForHospital(hospital);
		}
		if (voCons != null)
		{
			inpat.Filter.Hcpcode = voCons.getMos().getPasCode();
		}
		if(specialty != null)
		{
			inpat.Filter.Specialty = getPASMappingForSpecialty(specialty);
		}
		inpat.list();

		InpatientlistRecord inp;
		InpatientEpisodeVo voInpatientEpisode;
		PasEventVo voPasEvent;
		PatientShort psOut;

		for (int i = 0; i < inpat.DataCollection.count(); i++)
		{
			inp = inpat.DataCollection.get(i);
			voInpatientEpisode = new InpatientEpisodeVo();
			voPasEvent = new PasEventVo();
			// Ward
			if (voWard != null)
			{
				voPasEvent.setLocation(voWard);
			}
			else
			{
				OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
				voPasEvent.setLocation(locImpl.getLocationByLocalCode(inp.Rescode, LocationType.WARD));
			}

			// Consultant
			if (voCons != null)
			{
				voPasEvent.setConsultant(voCons);
			}
			else
			{
				HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);

				voCons = hcpAdmin.getMedicMedicMappingsByPasCode(inp.Hcpcode);
				if (voCons != null)
				{
					voPasEvent.setConsultant(voCons);
				}
			}

			try
			{
				DateTime datetime = new DateTime(inp.Addt, inp.Adtm);
				voPasEvent.setEventDateTime(datetime);
			}
			catch (ParseException e)
			{
				voPasEvent.setEventDateTime(null);
			}

			if (psIn != null)
			{
				voPasEvent.setPatient(psIn);
				// cw need to set voInpatientEpisode
				voInpatientEpisode.setPasEvent(voPasEvent);
			}
			else
			{
				psOut = new PatientShort();
				psOut.setName(inp.Snm, inp.Fnm1, null);

				psOut.addId(PatIdType.HOSPNUM, inp.Hospnum);
				psOut.addId(PatIdType.CHARTNUM, inp.Chartnum);

				psOut.setDob(new PartialDate(inp.Dob));

				if (inp.Dod != null && inp.Dod != "")
				{
					try
					{
						psOut.setDod(new Date(inp.Dod, DateFormat.ISO));
					}
					catch (ParseException e2)
					{
						e2.printStackTrace();
					}
				}

				psOut.calculateAge();

				// cw need to set voInpatientEpisode here, or crash will occur
				voInpatientEpisode.setPasEvent(voPasEvent);
				psOut.setWard(voInpatientEpisode.getPasEvent().getLocation());
				// WDEV-17867 - Set Current Responsible Clinician to Patient record
				psOut.setCurrentResponsibleConsultant(voInpatientEpisode.getPasEvent().getConsultant());

				psOut.setSex((Sex) getLookupService().getLocalLookup(Sex.class, Sex.TYPE_ID, extSystem, inp.Sex));

				voInpatientEpisode.getPasEvent().setPatient(psOut);
			}
			inpColl.add(voInpatientEpisode);
			// cw needed to set voInpatientEpisode before this line, or crash
			// occurred
			// voInpatientEpisode.setPasEvent(voPasEvent);
		}
		return inpColl.sort();

	}
	
	private String removeWildCards(String strToBeFormated)
	{
		if (strToBeFormated != null)
		{
			strToBeFormated = strToBeFormated.toUpperCase();
			strToBeFormated = strToBeFormated.replace("%","");
			strToBeFormated = strToBeFormated.replace("?","");
		}
		return strToBeFormated;

	}
	
	
	//WDEV-15526
	private InpatientEpisodeVoCollection listInpatientsHibernateBySearchCriteria(PatIdType idType, String idValue, String surname, String forename, LocationRefVo hospital, LocationRefVo ward, HcpRefVo hcp,Specialty specialty, PatientRefVo patient)
	{
		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		//hql = " from InpatientEpisode ip  "; 
		String hql = " select ip from InpatientEpisode as ip left join ip.pasEvent as pasEvent left join pasEvent.patient as patient ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		
		if (idType!=null && idValue!=null)
		{
			hql += " left join patient.identifiers as identifiers ";
			condStr.append(andStr+" identifiers.type = :idType and identifiers.value = :idValue ");
			markers.add("idType");
			values.add(getDomLookup(idType));
			markers.add("idValue");
			values.add(idValue);
			andStr = " and ";
		}
		else
		{
			if (surname!=null)
			{
				condStr.append(andStr+" ip.pasEvent.patient.name.upperSurname like :msurname ");
				markers.add("msurname");
				values.add(surname.toUpperCase() + "%");
				andStr = " and ";
			}

			String ret = "";
			if (forename!=null)
				ret = forename.replaceAll("%", "");

			if (forename!=null && ret.length() != 0)
			{
				condStr.append(andStr+" ip.pasEvent.patient.name.upperForename like :mforename ");
				markers.add("mforename");
				values.add(forename.toUpperCase() + "%");
				andStr = " and ";
			}
			
			if (ward != null)
			{
				condStr.append(andStr + " ip.pasEvent.location.id = :ward");
				markers.add("ward");
				values.add(ward.getID_Location());
				andStr = " and ";
			}
			else if(hospital != null)
			{
				condStr.append(andStr + " ip.pasEvent.location.parentLocation.id = :hospital");
				markers.add("hospital");
				values.add(hospital.getID_Location());
				andStr = " and ";
			}
			if (hcp != null)
			{
				condStr.append(andStr + " ip.pasEvent.consultant.id = :cons");
				markers.add("cons");
				values.add(hcp.getID_Hcp());
				andStr = " and ";
			}
			if(specialty != null)
			{
				condStr.append(andStr + " ip.pasEvent.specialty.id = :idSpecialty");
				markers.add("idSpecialty");
				values.add(specialty.getID());
				andStr = " and ";
			}
		
		}
		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		
		hql += condStr.toString();
		List <?> ips = factory.find(hql, markers, values);
		
		return InpatientEpisodeVoAssembler.createInpatientEpisodeVoCollectionFromInpatientEpisode(ips);
	}

	//wdev-15823
	public Boolean inpatientWasDischarged(PatientRefVo patRef) 
	{
		if (patRef == null)
		{
			throw new DomainRuntimeException("Patient cannot be null!");
		}
		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient domPatient = (ims.core.patient.domain.objects.Patient)factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, patRef.getID_Patient().intValue());
		String hql = "from InpatientEpisode ip where ip.pasEvent.patient.id = :pat";
		List<?> l = factory.find(hql, new String[] {"pat"}, new Object[] {domPatient.getId()});		
		if (l != null && l.size() > 0)
		{
			return false;
		}
		return true;
	}

	public Boolean cancelAdmission(PatientShort patVo) throws StaleObjectException, ForeignKeyViolationException
	{
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		return impl.cancelAdmission(patVo);
	}

	public InpatientEpisodeWithICPInfoVo getInpatientEpisodeWithICPInfo(InpatientEpisodeRefVo ipRefvo)
	{
		if (ipRefvo == null)
			throw new CodingRuntimeException("Can not search on ipRefvo value");
		
		DomainFactory factory = getDomainFactory();
		return InpatientEpisodeWithICPInfoVoAssembler.create((InpatientEpisode) factory.getDomainObject(InpatientEpisode.class, ipRefvo.getID_InpatientEpisode()));
	}

	public InpatientEpisodeVo getInpatientEpisode(InpatientEpisodeRefVo iprefVo)
	{
		if (iprefVo == null)
			throw new CodingRuntimeException("Can not search on ipRefvo value");
		
		DomainFactory factory = getDomainFactory();
		return InpatientEpisodeVoAssembler.create((InpatientEpisode) factory.getDomainObject(InpatientEpisode.class, iprefVo.getID_InpatientEpisode()));
	}

	//wdev-16427
	public CareContextShortVo getCareContextShortVoByPasEventId(PASEventRefVo pasEventRef)
	{
		if (pasEventRef == null || pasEventRef.getID_PASEvent() == null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");

		StringBuffer hql = new StringBuffer("select careContext from CareContext as careContext left join careContext.pasEvent as pasEvent where pasEvent.id = :pasEventID) ");

		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find(hql.toString(), new String[] { "pasEventID" }, new Object[] { pasEventRef.getID_PASEvent() });

		if (list != null && list.size() > 0)
			return CareContextShortVoAssembler.create((CareContext) list.get(0));

		return null;
	}

	public PatientShort getPatient(PatientRefVo patRefVo) throws DomainInterfaceException
	{
		if (patRefVo == null)
			throw new CodingRuntimeException("Can not search on patRefVo value");
		
		DomainFactory factory = getDomainFactory();
		return PatientShortAssembler.create((Patient) factory.getDomainObject(Patient.class, patRefVo.getID_Patient()));
	}

}
