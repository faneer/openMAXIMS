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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40726.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.vo.PIDBarOncologyManualVo;
import ims.clinical.vo.PIDBarOncologyManualVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.PatientNoAlertInfo;
import ims.core.clinical.vo.PatientAlertRefVo;
import ims.core.domain.Demographics;
import ims.core.helper.PIDBarOncologyManualClass;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PatientAlert;
import ims.core.vo.PatientAlertCollection;
import ims.core.vo.PatientNoAlertInfoVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PatientAlertAssembler;
import ims.core.vo.domain.PatientNoAlertInfoVoAssembler;
import ims.core.vo.lookups.PatientAlertStatus;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.lookups.LookupInstance;
import ims.domain.lookups.LookupMapping;
import ims.dto.DTODomainImplementation;
import ims.dto.Result;
import ims.dto.ResultException;
import ims.dto.client.Halerts;
import ims.dto.client.Halerts.HalertsRecord;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.LookupInstVo;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AlertsImpl extends DTODomainImplementation implements ims.core.domain.Alerts, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	public PatientAlertCollection listPatientAlerts(ims.core.vo.PatientShort patient, Boolean active) 
	{
		
		if(patient == null)
			throw new CodingRuntimeException("Mandatory parameter - Patient not supplied");
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientAlert patAlrt ");
		hql.append(" where patAlrt.patient.id = :patient");
		names.add("patient");
		values.add(patient.getID_Patient());
		
		if (active.equals(Boolean.TRUE))
		{
			hql.append (" and patAlrt.isCurrentlyActiveAlert = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		List list = factory.find(hql.toString(), names,values);
		return(PatientAlertAssembler.createPatientAlertCollectionFromPatientAlert(list).sort());
		
	}
	public Boolean saveHeartsAlert(PatientRefVo patientRefVo, String pasMapping, Boolean isActive) throws DomainInterfaceException, StaleObjectException
	{
		if (patientRefVo == null || pasMapping == null)
			return false;

		if( ! ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("WST"))
			return false;

		Demographics patIMPL = (Demographics)getDomainImpl(DemographicsImpl.class);
		PatientShort ps = patIMPL.getPatientShort(patientRefVo);
		
		Halerts alRec = null;
		try
		{
			alRec = (Halerts) getDTOInstance(Halerts.class);
		}	
		catch(ResultException e)
		{
			throw new DomainInterfaceException("Failed to Connect to PAS - Please check Configuration", e);
		}
		
		alRec.DataCollection.add();
		HalertsRecord dtoAL = alRec.DataCollection.get(0);

		dtoAL.Hospnum = (ps!=null && ps.getHospnum()!=null ? ps.getHospnum().getIdValue():null);//WDEV-17609
		dtoAL.Alert = pasMapping;
		dtoAL.Active = isActive ? "1" : "0";
		
		dtoAL.Webadt = "Y";				
		
		Result result = alRec.update();
		if(result != null && result.getId() < 0)
			throw new DomainInterfaceException("Attempt to save to Alerts failed " + result.getMessage());
		
		return true;
	}

	public PatientAlert savePatientAlert(ims.core.vo.PatientAlert patientAlertItem) throws StaleObjectException, DomainInterfaceException 
	{
		if(!patientAlertItem.isValidated())
		{
			throw new DomainRuntimeException("PatientAlert Value Object Alert has not been validated");
		}

		DomainFactory factory = getDomainFactory();
		ims.core.clinical.domain.objects.PatientAlert doAlert = PatientAlertAssembler.extractPatientAlert(factory,patientAlertItem);
		
		//check if the alert has a PAS mapping if so try save a hearts alert
		if (patientAlertItem.getAlertTypeIsNotNull())
		{
			LookupInstance alertLookup = factory.getLookupInstance(patientAlertItem.getAlertType().getId());
			
			if (alertLookup.getMappings() !=null
				&& alertLookup.getMappings().size() > 0)
			{
				Set mappings = alertLookup.getMappings();
				Iterator iter = mappings.iterator();
				
				LookupMapping doMapping;
				while (iter.hasNext())
				{
					doMapping = (LookupMapping) iter.next();
					if (doMapping.getExtSystem().equals("PAS"))
					{
						try
						{
							saveHeartsAlert(patientAlertItem.getPatient(), doMapping.getExtCode(), patientAlertItem.getIsCurrentlyActiveAlert());
						}
						catch (DomainInterfaceException e)
						{
							throw new DomainInterfaceException("Save of Hearts alert has not succeeded.");
						}
						break;
					}
				}

			}
		}

		factory.save(doAlert);
		return PatientAlertAssembler.create(doAlert);
	}

	public PatientAlert savePatientAlert(ims.core.vo.PatientAlert patientAlertItem, PatientNoAlertInfoVo patientNoAlertInfo) throws StaleObjectException, UniqueKeyViolationException, DomainInterfaceException 
	{
		if(!patientAlertItem.isValidated())
		{
			throw new DomainRuntimeException("PatientAlert Value Object Alert has not been validated");
		}
		if(!patientNoAlertInfo.isValidated())
		{
			throw new CodingRuntimeException("PatientNoAlertInfoVo Value Object Alert has not been validated");
		}


		DomainFactory factory = getDomainFactory();
		ims.core.clinical.domain.objects.PatientAlert doAlert = PatientAlertAssembler.extractPatientAlert(factory,patientAlertItem);
		
		
		
		if (!patientAlertItem.getID_PatientAlertIsNotNull())
		{
			String hqlQuery = "select p1_1.alertStatus from PatientNoAlertInfo as p1_1 where (p1_1.patient.id = :Patient_id and p1_1.isRIE is null)";
			List<?> list = factory.find(hqlQuery,"Patient_id",patientAlertItem.getPatient().getID_Patient());
			//If there is no PatientNoAlertInfo record, or the record exists and the status is NOKNOWNALERTS
			if ((list == null || list.size() == 0) || (getDomLookup(PatientAlertStatus.NOKNOWNALERTS).equals(list.get(0))))
			{

				savePatientCoreClinicalData(patientNoAlertInfo);
			}
			
			
		}
			
		factory.save(doAlert);

		//need to do dto save here if the alert has a PAS mapping.
		//check if the alert has a PAS mapping if so try save a hearts alert
		if (patientAlertItem.getAlertTypeIsNotNull())
		{
			LookupInstance alertLookup = factory.getLookupInstance(patientAlertItem.getAlertType().getId());
			
			if (alertLookup.getMappings() !=null
				&& alertLookup.getMappings().size() > 0)
			{
				Set mappings = alertLookup.getMappings();
				Iterator iter = mappings.iterator();
				
				LookupMapping doMapping;
				while (iter.hasNext())
				{
					doMapping = (LookupMapping) iter.next();
					if (doMapping.getExtSystem().equals("PAS"))
					{
						try
						{
							saveHeartsAlert(patientAlertItem.getPatient(), doMapping.getExtCode(), patientAlertItem.getIsCurrentlyActiveAlert());
						}
						catch (DomainInterfaceException e)
						{
							throw new DomainInterfaceException("Save of Hearts alert has not succeeded.");
						}
						break;
					}
				}

			}
		}
	
		
		return PatientAlertAssembler.create(doAlert);
	}

	public HcpCollection listHCPs(HcpFilter hcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(hcpFilter);
	} 

	public PatientAlert getPatientAlert(PatientAlertRefVo patientalertRefVo) 
	{
		if(patientalertRefVo == null)
			throw new DomainRuntimeException("PatientAlert Filter not provided for list call. ");

		DomainFactory factory = getDomainFactory();
		ims.core.clinical.domain.objects.PatientAlert doPA = (ims.core.clinical.domain.objects.PatientAlert)factory.getDomainObject(ims.core.clinical.domain.objects.PatientAlert.class, patientalertRefVo.getID_PatientAlert());
		return PatientAlertAssembler.create(doPA);		
	}

	public PatientNoAlertInfoVo getPatientNoAlertInfo(PatientRefVo patientRefVo) 
	{
		DomainFactory factory = getDomainFactory();
	
		PatientNoAlertInfo patientNoAlertInfo = PatientNoAlertInfo.getPatientNoAlertInfoFromPatient(factory, patientRefVo.getID_Patient());
		return PatientNoAlertInfoVoAssembler.create(patientNoAlertInfo);
	}

	public PatientNoAlertInfoVo savePatientCoreClinicalData(PatientNoAlertInfoVo patientNoAlertInfo) throws StaleObjectException, UniqueKeyViolationException 
	{
		if(!patientNoAlertInfo.isValidated())
		{
			throw new CodingRuntimeException("PatientNoAlertInfoVo Value Object Alert has not been validated");
		}

		DomainFactory factory = getDomainFactory();
		PatientNoAlertInfo doPatientNoAlertInfo = PatientNoAlertInfoVoAssembler.extractPatientNoAlertInfo(factory, patientNoAlertInfo);
			
		try
		{
			factory.save(doPatientNoAlertInfo);
		} 
		catch(UnqViolationUncheckedException e)
		{		
			PatientNoAlertInfo noAlertInfo = PatientNoAlertInfo.getPatientNoAlertInfoFromPatient(factory, patientNoAlertInfo.getPatient().getID_Patient());
			if (noAlertInfo != null && noAlertInfo.getId() != null && !(noAlertInfo.getId().equals(patientNoAlertInfo.getID_PatientNoAlertInfo())))
			{
				throw new UniqueKeyViolationException(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue(), e);					
			}

			throw (e);
		}
		return (PatientNoAlertInfoVoAssembler.create(doPatientNoAlertInfo));		
	}

	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		if (careContextRefVo == null && episodeRefVo == null)
			return "";
		
		String hqlSB = "select new ims.core.helper.PIDBarOncologyManualClass( " +
			"p2_1.id, p2_1.diagnosisDescription, e1_1.startDate, e1_1.endDate, m1_1.name.surname, m1_1.name.forename, l1_1.text )" +
			"from PatientDiagnosis as p2_1 left join p2_1.episodeOfCare as e1_1 left join e1_1.responsibleHCP as h1_1 left join h1_1.mos as m1_1 " +
			"left join m1_1.name.title as l1_1 left join p2_1.primaryForCareSpells as c2_1 where ( c2_1.isActive = :ACTIVE and c2_1.isRIE is null and c2_1.diagnosis.isRIE is null";
		
			
		List lstRecs = null;
		DomainFactory factory = getDomainFactory();
		if (careContextRefVo != null)
		{
			String hqlCC = hqlSB;
			hqlCC += " and c2_1.careContext.id = :careContextId )";
			hqlCC += " order by p2_1.diagnosedDate desc";
			lstRecs = factory.find(hqlCC.toString(), new String[] {"careContextId","ACTIVE"}, new Object[] {careContextRefVo.getID_CareContext(), Boolean.TRUE});
			
			if (lstRecs.size() == 0
				&& episodeRefVo != null)
			{
				String hqlEP = hqlSB;

				hqlEP += "  and c2_1.episodeOfCare.id = :episodeID )";
				hqlEP += " order by p2_1.diagnosedDate desc";
				lstRecs = factory.find(hqlEP.toString(), new String[] {"episodeID","ACTIVE"}, new Object[] {episodeRefVo.getID_EpisodeOfCare(), Boolean.TRUE});
			}
		}
		else if ( careContextRefVo == null && episodeRefVo != null)
		{
			String hqlEP = hqlSB;

			hqlEP += "  and c2_1.episodeOfCare.id = :episodeID )";				//wdev-14053
			hqlEP += " order by p2_1.diagnosedDate desc";
			lstRecs = factory.find(hqlEP.toString(), new String[] {"episodeID","ACTIVE"}, new Object[] {episodeRefVo.getID_EpisodeOfCare(), Boolean.TRUE});
			
		}
		
		PIDBarOncologyManualVo voItem = null;
		PIDBarOncologyManualVoCollection voColl = new PIDBarOncologyManualVoCollection();
		for (int i = 0 ; lstRecs != null && i < lstRecs.size(); i ++)
		{
			PIDBarOncologyManualClass doPID = (PIDBarOncologyManualClass)lstRecs.get(i);
			voItem = new PIDBarOncologyManualVo();
	
			voItem.setDiagnosisDesc(doPID.getDiagnosisDesc());
			voItem.setStartDate(doPID.getStartdate() != null ? new ims.framework.utils.Date(doPID.getStartdate()) : null);
			voItem.setEndDate(doPID.getEnddate() != null ? new ims.framework.utils.Date(doPID.getEnddate()) : null);
			voItem.setHCPName(doPID.getHcpName());
			
			voColl.add(voItem);
		}
		
		if (voColl == null)
			return "";
		
		StringBuffer sb = new StringBuffer();
		
		if (voColl.size() > 1)
		{
			sb.append(" : ");
			sb.append(" > 1 linked primary diagnosis");
		}
		else if(voColl != null && voColl.size() == 1)
		{
			sb.append(" : ");
			if (voColl.get(0).getStartDateIsNotNull())
			{
				sb.append(voColl.get(0).getStartDate().toString());
				sb.append(" - ");
			}
			if (voColl.get(0).getEndDateIsNotNull())
			{
				sb.append(voColl.get(0).getEndDate().toString());
				sb.append(", ");
			}
			if (voColl.get(0).getDiagnosisDescIsNotNull())
			{
				sb.append(voColl.get(0).getDiagnosisDesc());
				sb.append(", ");
			}
			if (voColl.get(0).getHCPNameIsNotNull())
				sb.append(voColl.get(0).getHCPName());
		}
		return sb.toString();

	}


	public String[] listPatientAlertsTextByTaxonomy(PatientRefVo patient,
			Boolean active, TaxonomyType type) {
		if(patient == null)
			throw new CodingRuntimeException("Mandatory parameter - Patient not supplied");
		if(type == null)
			throw new CodingRuntimeException("Mandatory parameter - TaxonomyType not supplied");
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select patAlrt.alertType.text from PatientAlert patAlrt join patAlrt.alertType.mappings maps");
		hql.append(" where patAlrt.patient.id = :patient and maps.extSystem = :type and ( patAlrt.isRIE = false or patAlrt.isRIE is null )");
		names.add("patient");
		values.add(patient.getID_Patient());
		names.add("type");
		values.add(type.getIItemText());
		
		if (active.equals(Boolean.TRUE))
		{
			hql.append (" and patAlrt.isCurrentlyActiveAlert = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		
		List<String> list = factory.find(hql.toString(), names,values);
		return list.toArray(new String[list.size()]) ;
	}

	public LookupInstVo getMappings(LookupInstVo instance)
	{
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.LookupInstance doInst = factory.getLookupInstance(instance.getId());
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
		instance.setMappings(mapColl);
		return instance;
	}

}
