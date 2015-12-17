//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by John MacEnri using IMS Development Environment (version 1.17 build 40519.1300)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.domain.objects.Nurse;
import ims.core.resource.people.domain.objects.Therapist;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.MedicWithLocationsVo;
import ims.core.vo.MedicWithLocationsVoCollection;
import ims.core.vo.MedicWithMappingsLiteVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.NurseVo;
import ims.core.vo.PersonName;
import ims.core.vo.TherapistVo;
import ims.core.vo.domain.HcpAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.MedicWithMappingsLiteVoAssembler;
import ims.core.vo.domain.NurseVoAssembler;
import ims.core.vo.domain.TherapistVoAssembler;
import ims.core.vo.lookups.AccreditationLocationStatus;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.domain.lookups.LookupInstance;
import ims.framework.enumerations.SortOrder;
import ims.ntpf.vo.lookups.CaseType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class HcpAdminImpl extends DomainImpl implements HcpAdmin, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	* Get a list of HCP's 
	*/
	public ims.core.vo.HcpCollection listHCPs(HcpFilter filter)
	{
		return listHCPs(filter, null);
	}

	public HcpCollection listExternalHcps(HcpFilter filter) 
	{
		return this.listHCPs(filter, null);
	}		
	
	private List listHCPList(HcpFilter filter, String subClass, int max) //WDEV-11656
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (filter == null) filter = new HcpFilter();
		
		hql = " from Hcp h "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		if (filter.getQueryName() != null)
		{
			if (filter.getQueryName().getSurname() != null && filter.getQueryName().getSurname().length() > 0)
			{
				condStr.append(" h.mos.name.upperSurname like :hcpSname");
				markers.add("hcpSname");
				values.add(filter.getQueryName().getSurname().toUpperCase().replace("_", "") + "%");
				andStr = " and ";
			}
			if (filter.getQueryName().getForename() != null && filter.getQueryName().getForename().length() > 0)
			{
				condStr.append(andStr + " h.mos.name.upperForename like :hcpFname");
				markers.add("hcpFname");
				values.add(filter.getQueryName().getForename().toUpperCase().replace("_", "") + "%");
				andStr = " and ";
			}
		}
		
		if (subClass != null)
		{
			condStr.append(andStr + " h.class = " + subClass);
			andStr = " and ";																	
			
		}
		else 
		{
			if (filter.getHcpType() != null)
			{
				//If the hcpType = HcpDisType.OTHER we must allow for that field being null or it's parent == OTHER
				if (filter.getHcpType().equals(HcpDisType.OTHER))
				{
					condStr.append(andStr + " ( h.hcpType is null or h.hcpType.parent =  :hcpType) ");														
				}
				else
				{
					condStr.append(andStr + " h.hcpType = :hcpType");									
				}
				markers.add("hcpType");
				values.add(getDomLookup(filter.getHcpType()));
				andStr = " and ";		
			}
		}
		
		condStr.append(andStr + " h.isActive =:active");
		markers.add("active");
		values.add(Boolean.TRUE);
		
		//WDEV-4463
		/*if (andStr.equals(" and "))
		{*/
			hql += " where ";
		//}
		
		hql += condStr.toString();
		//-----------------------wdev-8356
		hql += " order by mos.name.upperSurname,mos.name.upperForename";
		//-----------------------
		
		//WDEV-11656
		if(max != -1)
			return factory.find(hql, markers, values, max);		
		else
			return factory.find(hql, markers, values);
	}
	private HcpCollection listHCPs(HcpFilter filter, String subClass)
	{
		List hcps = listHCPList(filter,subClass,-1); //WDEV-11656
		
		//iterate through domainlist and use each subclasses respective assembler to convert and add to voCollHcps
		//Using arraylist so can sort it locally. Not sort won't work as collection is mixed type.
		ArrayList hcpList = new ArrayList();
		if(hcps != null)
		{			
			for(int i=0;i<hcps.size();i++)
			{
				Hcp hcp = (Hcp) hcps.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass())){
					hcpList.add(MedicVoAssembler.create((Medic)hcp));
				}
				
				else if (Therapist.class.isAssignableFrom(hcp.getClass()))
					hcpList.add(TherapistVoAssembler.create((Therapist)hcps.get(i)));
				else if (Nurse.class.isAssignableFrom(hcp.getClass()))
					hcpList.add(NurseVoAssembler.create((Nurse)hcps.get(i)));
				else
					hcpList.add(HcpAssembler.create((Hcp)hcps.get(i)));				
			}
		}
		Collections.sort(hcpList, new HcpAdminComparator(SortOrder.ASCENDING));		
		HcpCollection voCollHcps = new HcpCollection();
		for(int i=0; i < hcpList.size(); i++)
		{
			voCollHcps.add((ims.core.vo.Hcp)hcpList.get(i));
		}
		return voCollHcps;		
	}

	/**
	* Creates a new HCP or updates if it already exists
	*/
	public ims.core.vo.Hcp saveHCP(ims.core.vo.Hcp hcp) throws StaleObjectException
	{
		if (!hcp.isValidated())
		{
			throw new DomainRuntimeException("HCP VO has not been validated.");
		}
		DomainFactory factory = getDomainFactory();
		
		hcp.getName().setUppers();
		Hcp doHcp = null;
		
		if (hcp instanceof MedicVo)
		{
			doHcp = MedicVoAssembler.extractMedic(factory, (MedicVo)hcp);
		}
		else if (hcp instanceof TherapistVo)
		{
			doHcp = TherapistVoAssembler.extractTherapist(factory, (TherapistVo)hcp);					
		}
		else if (hcp instanceof NurseVo)
		{
			doHcp = NurseVoAssembler.extractNurse(factory, (NurseVo)hcp);		
		}
		else
		{
			doHcp = HcpAssembler.extractHcp(factory, hcp);		
		}

		factory.save(doHcp);
		hcp.setID_Hcp(doHcp.getId());
		return hcp;
	}
	
	private List getDomHcpByExternalCode(TaxonomyType taxType, String codeVal)
	{
		if (codeVal == null) return null;

		DomainFactory factory = getDomainFactory();
		String hql = " from Hcp h " +
		" join h.mos.codeMappings as cm" +
		" where cm.taxonomyName = :taxType " + 
		" and cm.taxonomyCode = :codeVal ";

		String[] names = new String[]{"taxType","codeVal"};
		Object[] vals = new Object[]{getDomLookup(taxType), codeVal};
		return factory.find(hql,names, vals);

	}
	
	public ims.core.vo.Hcp getHcpByExternalCode(TaxonomyType taxType, String codeVal)
	{
		if (codeVal == null) return null;
		
		List hcpList = getDomHcpByExternalCode(taxType, codeVal);

		if (hcpList != null && hcpList.size() > 0)
		{
			Hcp hcp = (Hcp)hcpList.get(0);
			if (hcp instanceof Medic)
			{
				return MedicVoAssembler.create((Medic)hcp);
			}
			else if (hcp instanceof Therapist)
			{
				return TherapistVoAssembler.create((Therapist)hcp);
			}
			else if (hcp instanceof Nurse)
			{
				return NurseVoAssembler.create((Nurse)hcp);
			}
			else
			{
				return HcpAssembler.create((Hcp)hcpList.get(0));
			}
		}
		return null;
		
	}
	
	public ims.core.vo.HcpLiteVo getHcpLiteByExternalCode(TaxonomyType taxType, String codeVal)
	{
	if (codeVal == null) return null;
		
		List hcpList = getDomHcpByExternalCode(taxType, codeVal);

		if (hcpList != null && hcpList.size() > 0)
		{
			
			return HcpLiteVoAssembler.create((Hcp)hcpList.get(0));
		}
		return null;
		
	}

	public ims.core.vo.Hcp getHcpByPasId(String hcpCode) 
	{
		return getHcpByExternalCode(TaxonomyType.PAS, hcpCode);
	}

	public MedicVo getMedicByNationalCode(String natCode) 
	{
		ims.core.vo.Hcp hcp = getHcpByExternalCode(TaxonomyType.NAT_CONS_CODE, natCode);
		if (hcp == null) return null;
		if (hcp instanceof MedicVo)
			return (MedicVo)hcp;
		else 
			return null;
	}

	public HcpCollection listMedics(HcpFilter filter) 
	{
		return this.listHCPs(filter, "Medic");
	}

	public HcpLiteVoCollection listResponsibleMedics(HcpFilter filter) 
	{
		List hcps = listResponsibleMedics(filter.getQueryName());
		HcpLiteVoCollection result = HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(hcps);
		return result;
	}
	private List listResponsibleMedics(PersonName personName )
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		String andStr = " ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		hql = " from Medic m "; 
		StringBuffer condStr = new StringBuffer();
		condStr.append(" m.isHCPaResponsibleHCP = 1");
		
		andStr = " and ";
		
		if (personName != null)
		{
			if (personName.getSurname() != null && personName.getSurname().length() > 0)
			{
				condStr.append(andStr + " m.mos.name.upperSurname like :hcpSname");
				markers.add("hcpSname");
				values.add(personName.getSurname().toUpperCase().replace("_", "") + "%");
				andStr = " and ";
			}
			if (personName.getForename() != null && personName.getForename().length() > 0)
			{
				condStr.append(andStr + " m.mos.name.upperForename like :hcpFname");
				markers.add("hcpFname");
				values.add(personName.getForename().toUpperCase().replace("_", "") + "%");
				andStr = " and ";
			}
		}
		
		condStr.append(andStr + " m.isActive =:active");
		markers.add("active");
		values.add(Boolean.TRUE);
		
		
		
		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		
		hql += condStr.toString();
		
		hql += " order by mos.name.upperSurname,mos.name.upperForename";
				
		return factory.find(hql, markers, values);
	}
	private Hcp getHcp(Integer hcpId) 
	{
		DomainFactory factory = getDomainFactory();
		Hcp doHcp = (Hcp) factory.getDomainObject(Hcp.class, hcpId);

		return doHcp;		
	}
	public HcpCollection listHcps(HcpFilter filter, HcpDisType subType) 
	{
		DomainFactory factory = getDomainFactory();
		
		if(filter.getHcpType() == null)
			return listHCPs(filter);
			
		List hcps = null;
		String hql = "";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();	
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";	
		String objectAlias = "";
	
		if(filter.getHcpType().equals(HcpDisType.MEDICAL))
		{
			objectAlias = "m";
			hql = " from Medic ";
			hql += objectAlias;
			if(subType != null)
			{
				condStr.append(andStr);
				condStr.append(objectAlias + ".medicType = :medicType");
				markers.add("medicType");
				values.add(getDomLookup(subType));
				andStr = " and ";
			}
								
		}
		else if(filter.getHcpType().equals(HcpDisType.NURSING))
		{
			objectAlias = "n"; 
			hql = " from Nurse ";
			hql += objectAlias;
			if(subType != null)
			{
				condStr.append(andStr + objectAlias + ".nurseType = :nurseType");
				markers.add("nurseType");
				values.add(getDomLookup(subType));
				andStr = " and ";
			}	
		} 
		else if(filter.getHcpType().equals(HcpDisType.THERAPY))
		{
			objectAlias = "t"; 
			hql = " from Therapist ";
			hql += objectAlias;
			if(subType != null)
			{
				condStr.append(andStr + objectAlias + ".therapistType = :therapistType");
				markers.add("therapistType");
				values.add(getDomLookup(subType));
				andStr = " and ";
			}
		} 
		else if(filter.getHcpType().equals(HcpDisType.OTHER))
		{
			objectAlias = "h";  
			hql = " from Hcp ";		
			hql += objectAlias;
			
			//If the hcpType = HcpDisType.OTHER we must allow for that field being null or it's parent == OTHER
			if (subType != null)
			{
				condStr.append(andStr +  " h.hcpType = :hcpType ");
				markers.add("hcpType");
				values.add(getDomLookup(subType));
				andStr = " and ";																
			}
			else
			{
				condStr.append(andStr + " (h.hcpType is null or h.hcpType.id > 0)  ");
				andStr = " and ";											
			}

		}			
		
		if (filter.getQueryName() != null)
		{
			if (filter.getQueryName().getSurname() != null && filter.getQueryName().getSurname().length() > 0)
			{
				condStr.append(andStr);
				condStr.append(objectAlias + ".name.upperSurname like :hcpSname");//here
				markers.add("hcpSname");
				values.add(filter.getQueryName().getSurname().toUpperCase() + "%");
				andStr = " and ";
			}
		}		
		
		condStr.append(andStr);
		condStr.append(objectAlias + " .isActive =:active");
		markers.add("active");
		values.add(Boolean.TRUE);
		
		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		
		hql += condStr.toString();
		hcps = factory.find(hql, markers, values);

		HcpCollection voCollHcps = new HcpCollection();
		if(hcps != null)
		{			
			for(int i=0;i<hcps.size();i++)
			{
				Hcp hcp = (Hcp)hcps.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass()))
					voCollHcps.add(MedicVoAssembler.create((Medic)hcp));
				else if (hcp instanceof Therapist)
					voCollHcps.add(TherapistVoAssembler.create((Therapist)hcp));
				else if (hcp instanceof Nurse)
					voCollHcps.add(NurseVoAssembler.create((Nurse)hcp));
				else
					voCollHcps.add(HcpAssembler.create(hcp));				
			}
		}
		
		return voCollHcps;
	}	
	
	private class HcpAdminComparator implements Comparator
	{
		private int direction = 1;
		public HcpAdminComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public HcpAdminComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ims.core.vo.Hcp voObj1 = (ims.core.vo.Hcp)obj1;
			ims.core.vo.Hcp voObj2 = (ims.core.vo.Hcp)obj2;
			return direction*(voObj1.getName().compareTo(voObj2.getName()));
		}
	}
	// WDEV-8204
	private class HcpLiteAdminComparator implements Comparator
	{
		private int direction = 1;
		public HcpLiteAdminComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public HcpLiteAdminComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ims.core.vo.HcpLiteVo voObj1 = (ims.core.vo.HcpLiteVo)obj1;
			ims.core.vo.HcpLiteVo voObj2 = (ims.core.vo.HcpLiteVo)obj2;
			return direction*(voObj1.getName().compareTo(voObj2.getName()));
		}
	}
	
	public ims.core.vo.Hcp getHcp(HcpFilter filter) 
	{
		DomainFactory factory = getDomainFactory();
		Hcp doHcp = (Hcp) factory.getDomainObject(Hcp.class, filter.getID_Hcp());

		if (Medic.class.isAssignableFrom(doHcp.getClass()))
			return MedicVoAssembler.create((Medic) doHcp);
		else if (doHcp instanceof Therapist)
			return TherapistVoAssembler.create((Therapist)doHcp);
		else if (doHcp instanceof Nurse)
			return NurseVoAssembler.create((Nurse) doHcp);
		
		return HcpAssembler.create(doHcp);		
	}
	
	public MedicWithLocationsVoCollection listMedicsForLocation(LocationRefVo location) 
	{
		DomainFactory factory = getDomainFactory();
		java.util.List medics = null;
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		String hql =  "select distinct mos, hcpLoc.accreditationStatus " + 
		" from MemberOfStaff as mos left join mos.hcp as hcp left join mos.locations as hcpLoc " +
		" where (hcpLoc.location.id = :idLocation and mos.isActive = :isActive and hcp.hcpType = :medical)";
		
		medics = factory.find(hql, new String[]{"idLocation","isActive", "medical"}, new Object[]{location.getID_Location(), Boolean.TRUE, getDomLookup(HcpDisType.MEDICAL)});
		
		MedicWithLocationsVoCollection voCollMedic = new MedicWithLocationsVoCollection();
		Iterator it = medics.iterator();
		while(it.hasNext())
		{
			MedicWithLocationsVo voMedicWithLoc = new MedicWithLocationsVo();
			Object[] lstItem = (Object[]) it.next();

			MemberOfStaff doMos = (MemberOfStaff) lstItem[0];
			
			MemberOfStaffVo voMos = new MemberOfStaffVo();
			MedicVo voMedic = new MedicVo();
			voMos.setID_MemberOfStaff(doMos.getId());
			voMedic.setID_Hcp(doMos.getHcp().getId());

			ims.core.vo.PersonName pn = new ims.core.vo.PersonName();
			pn.setForename(doMos.getName().getForename());
			pn.setSurname(doMos.getName().getSurname());
			pn.setMiddleName(doMos.getName().getMiddleName());
			if (doMos.getName().getTitle() != null)
				pn.setTitle(LookupHelper.getPersonTitleInstance(getLookupService(),doMos.getName().getTitle().getId()));
			voMos.setName(pn);
			voMedic.setMos(voMos);
			voMedicWithLoc.setMedicVo(voMedic);
			voMedicWithLoc.setAccreditationStatus(createAccreditationLookupInstance((LookupInstance)lstItem[1]));
			
			voCollMedic.add(voMedicWithLoc);
		}
		return voCollMedic.sort();	
	}
	
	public MedicWithLocationsVoCollection listMedicsForLocation(LocationRefVo location, CaseType caseType) 
	{
		DomainFactory factory = getDomainFactory();
		java.util.List medics = null;
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		String hql =  "select distinct mos, hcpLoc.accreditationStatus " + 
		" from MemberOfStaff as mos left join mos.hcp as hcp left join mos.locations as hcpLoc ";
		if (caseType != null)
			hql += " left join hcpLoc.caseTypes as casTyp "; 
		
		hql += " where (hcpLoc.location.id = :idLocation and mos.isActive = :isActive and hcp.hcpType = :medical ";
		
		if (caseType != null)
			hql += " and ( hcpLoc.accreditationStatus in (:id1, :id4, :id5, :id6) or (casTyp.instance = :caseType and hcpLoc.accreditationStatus in (:id2, :id3) ) )";
		else
			hql += "and hcpLoc.accreditationStatus in (:accredStat, :id4, :id5, :id6)";
		hql += ")";

		if (caseType != null)
			medics = factory.find(hql, new String[]{"idLocation","isActive", "medical", "caseType", "id1", "id2", "id3", "id4", "id5", "id6"}, 
					new Object[]{location.getID_Location(), Boolean.TRUE, getDomLookup(HcpDisType.MEDICAL), 
					getDomLookup(caseType), getDomLookup(AccreditationLocationStatus.ACCREDITED), 
					getDomLookup(AccreditationLocationStatus.RESTICT_ACCRED), 
					getDomLookup(AccreditationLocationStatus.RESTRICT_ACCRED_REFERRING),
					getDomLookup(AccreditationLocationStatus.ACCREDITATIONSUSPENDED), getDomLookup(AccreditationLocationStatus.NOTACCREDITED), 
					getDomLookup(AccreditationLocationStatus.REFERRINGCONSULTANT)});
		else
			medics = factory.find(hql, new String[]{"idLocation","isActive", "medical", "accredStat", "id4", "id5", "id6" }, 
					new Object[]{location.getID_Location(), Boolean.TRUE, getDomLookup(HcpDisType.MEDICAL), 
					getDomLookup(AccreditationLocationStatus.ACCREDITED), 
					getDomLookup(AccreditationLocationStatus.ACCREDITATIONSUSPENDED), getDomLookup(AccreditationLocationStatus.NOTACCREDITED), 
					getDomLookup(AccreditationLocationStatus.REFERRINGCONSULTANT)});
		
		MedicWithLocationsVoCollection voCollMedic = new MedicWithLocationsVoCollection();
		Iterator it = medics.iterator();
		while(it.hasNext())
		{
			MedicWithLocationsVo voMedicWithLoc = new MedicWithLocationsVo();
			Object[] lstItem = (Object[]) it.next();

			MemberOfStaff doMos = (MemberOfStaff) lstItem[0];
			
			MemberOfStaffVo voMos = new MemberOfStaffVo();
			MedicVo voMedic = new MedicVo();
			voMos.setID_MemberOfStaff(doMos.getId());
			voMedic.setID_Hcp(doMos.getHcp().getId());

			ims.core.vo.PersonName pn = new ims.core.vo.PersonName();
			pn.setForename(doMos.getName().getForename());
			pn.setSurname(doMos.getName().getSurname());
			pn.setMiddleName(doMos.getName().getMiddleName());
			if (doMos.getName().getTitle() != null)
				pn.setTitle(LookupHelper.getPersonTitleInstance(getLookupService(),doMos.getName().getTitle().getId()));
			voMos.setName(pn);
			voMedic.setMos(voMos);
			voMedicWithLoc.setMedicVo(voMedic);
			voMedicWithLoc.setAccreditationStatus(createAccreditationLookupInstance((LookupInstance)lstItem[1]));
			
			voCollMedic.add(voMedicWithLoc);
		}
		return voCollMedic.sort();	
	}

	private AccreditationLocationStatus createAccreditationLookupInstance(LookupInstance lookupInstance)
	{
		ims.framework.utils.ImagePath img = null;
		ims.framework.utils.Color color = null;		
		img = null;
		if (lookupInstance.getImage() != null) 
		{
			img = new ims.framework.utils.ImagePath(lookupInstance.getImage().getImageId(), lookupInstance.getImage().getImagePath());
		}
		color = lookupInstance.getColor();
		if (color != null) 
			color.getValue();

		AccreditationLocationStatus statusInst = new AccreditationLocationStatus(lookupInstance.getId(),lookupInstance.getText(), lookupInstance.isActive(), null, img, color);
		return statusInst;
	}

	public MedicLiteVoCollection listActiveMedics(String strMedicName)
	{
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(strMedicName);
		filter.setQueryName(name);
		filter.setHcpType(HcpDisType.MEDICAL);
		
		List hcps = listHCPList(filter,null,-1); //WDEV-11656
		
		return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(hcps);
	}

	public HcpLiteVoCollection listHcpLiteByNameAndDisciplineType(String hcpName, HcpDisType hcpDisciplineType)
	{
		if (hcpName == null || hcpName.length() == 0)
			throw new DomainRuntimeException("Name not supplied");
	
		HcpFilter filter = new HcpFilter();
		filter.setQueryName(new PersonName());
		filter.getQueryName().setSurname(hcpName);
		if(hcpDisciplineType != null)
			filter.setHcpType(hcpDisciplineType);

		return listHcpLite(filter);

	}
	
	public HcpLiteVoCollection listHcpLiteByDisciplineType(HcpDisType hcpDisciplineType)
	{
		if (hcpDisciplineType == null)
			throw new DomainRuntimeException("HcpDisType not supplied");
	
		HcpFilter filter = new HcpFilter();
		filter.setQueryName(new PersonName());
		if(hcpDisciplineType != null)
			filter.setHcpType(hcpDisciplineType);

		return listHcpLite(filter);
	}
	
	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		return listHcpLiteByNameAndDisciplineType(hcpName, null);
	}
	
	public HcpLiteVoCollection listHcpLite(HcpFilter filter)
	{
		List l = this.listHCPList(filter, null, -1); //WDEV-11656
		// 	 WDEV-8204
		HcpLiteVoCollection result = HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(l);
		//----WDEV-8356
		//result.sort(new HcpLiteAdminComparator());
		//-----------
		return result;
	}
	
	public MedicWithMappingsLiteVo getMedicMedicMappingsByExternalCode(TaxonomyType taxType, String codeVal)
	{
		if (taxType == null || codeVal == null) 
			throw new DomainRuntimeException("External Code and type not supplied for Medic");
		
		List hcpList = getDomHcpByExternalCode(taxType, codeVal);
		if (hcpList != null && hcpList.size() > 0)
		{
			Hcp hcp = (Hcp)hcpList.get(0);
			if (hcp instanceof Medic)
			{
				return MedicWithMappingsLiteVoAssembler.create((Medic)hcp);
			}
		}
		return null;
	}
	
	public MedicLiteVo getMedicLiteByExternalCode(TaxonomyType taxType, String codeVal)
	{
		if (taxType == null || codeVal == null) 
			throw new DomainRuntimeException("External Code and type not supplied for Medic");
		
		List hcpList = getDomHcpByExternalCode(taxType, codeVal);
		if (hcpList != null && hcpList.size() > 0)
		{
			Hcp hcp = (Hcp)hcpList.get(0);
			if (hcp instanceof Medic)
			{
				return MedicLiteVoAssembler.create((Medic)hcp);
			}
		}
		return null;
	}

	public MedicWithMappingsLiteVo getMedicMedicMappingsByPasCode(String pasCode)
	{
		return getMedicMedicMappingsByExternalCode(TaxonomyType.PAS, pasCode);
	}

	public HcpLiteVo getHcpLite(HcpFilter filter) 
	{
		DomainFactory factory = getDomainFactory();
		Hcp doHcp = (Hcp) factory.getDomainObject(Hcp.class, filter.getID_Hcp());
		return HcpLiteVoAssembler.create(doHcp);		
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName, Integer max)
	{
		HcpFilter filter = new HcpFilter();
		filter.setQueryName(new PersonName());
		filter.getQueryName().setSurname(hcpName);
		
		List hcps = this.listHCPList(filter, null, max);
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(hcps);
	}

	public MedicWithLocationsVoCollection listMedicsForLocation()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public MedicWithLocationsVoCollection listReferringMedicsForLocation(LocationRefVo location)
	{
		DomainFactory factory = getDomainFactory();
		java.util.List medics = null;
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		String hql =  "select distinct mos, hcpLoc.accreditationStatus " + 
		" from MemberOfStaff as mos left join mos.hcp as hcp left join mos.locations as hcpLoc ";
		hql += " where (hcpLoc.location.id = :idLocation and mos.isActive = :isActive and hcp.hcpType = :medical ";
		hql += " and ( hcpLoc.accreditationStatus in (:id1, :id2, :id3) ) )";

		medics = factory.find(hql, new String[]{"idLocation","isActive", "medical", "id1", "id2", "id3"}, new Object[]{location.getID_Location(), Boolean.TRUE, getDomLookup(HcpDisType.MEDICAL), getDomLookup(AccreditationLocationStatus.ACCREDITED), getDomLookup(AccreditationLocationStatus.REFERRINGCONSULTANT), getDomLookup(AccreditationLocationStatus.RESTRICT_ACCRED_REFERRING)});
		
		MedicWithLocationsVoCollection voCollMedic = new MedicWithLocationsVoCollection();
		Iterator it = medics.iterator();
		while(it.hasNext())
		{
			MedicWithLocationsVo voMedicWithLoc = new MedicWithLocationsVo();
			Object[] lstItem = (Object[]) it.next();

			MemberOfStaff doMos = (MemberOfStaff) lstItem[0];
			
			MemberOfStaffVo voMos = new MemberOfStaffVo();
			MedicVo voMedic = new MedicVo();
			voMos.setID_MemberOfStaff(doMos.getId());
			voMedic.setID_Hcp(doMos.getHcp().getId());

			ims.core.vo.PersonName pn = new ims.core.vo.PersonName();
			pn.setForename(doMos.getName().getForename());
			pn.setSurname(doMos.getName().getSurname());
			pn.setMiddleName(doMos.getName().getMiddleName());
			if (doMos.getName().getTitle() != null)
				pn.setTitle(LookupHelper.getPersonTitleInstance(getLookupService(),doMos.getName().getTitle().getId()));
			voMos.setName(pn);
			voMedic.setMos(voMos);
			voMedicWithLoc.setMedicVo(voMedic);
			voMedicWithLoc.setAccreditationStatus(createAccreditationLookupInstance((LookupInstance)lstItem[1]));
			
			voCollMedic.add(voMedicWithLoc);
		}
		return voCollMedic.sort();	
	}

}
