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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.39 build 2153.19769)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.clinicaladmin.domain.PMHChecklistConfig;
import ims.clinicaladmin.domain.impl.PMHChecklistConfigImpl;
import ims.clinical.domain.objects.PatientPMHChecklist;
import ims.clinicaladmin.vo.PMHChecklistConfigVo;
import ims.clinicaladmin.vo.domain.PMHChecklistConfigVoAssembler;
import ims.clinical.vo.PatientPMHChecklistVo;
import ims.clinical.vo.domain.PatientPMHChecklistVoAssembler;
import ims.clinical.domain.PastMedicalHistory;
import ims.clinical.domain.impl.PastMedicalHistoryImpl;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.domain.EpisodeofCareVoAssembler;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.PatientDiagnosisVo;
import ims.core.vo.PatientDiagnosisVoCollection;
import ims.core.vo.PatientPastMedicalHistoryVo;
import ims.core.vo.PatientProcedureShortVo;
import ims.core.vo.PatientProcedureShortVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;

public class PMHCheckListImpl extends DomainImpl implements ims.clinical.domain.PMHCheckList, ims.domain.impl.Transactional
{
	public PatientPMHChecklistVo getPatientPMHChecklist(CareContextRefVo refVoCareContext) 
	{
		if(refVoCareContext == null || refVoCareContext.getID_CareContext() == null)
			throw new DomainRuntimeException("Contact not provided for get call. ");

		DomainFactory factory = getDomainFactory();

		java.util.List patientPMHChecklist = factory.find("from  PatientPMHChecklist pmhlist where pmhlist.careContext.id = :contactId", new String[]{"contactId"}, new Object[]{refVoCareContext.getID_CareContext()});
		
		if (patientPMHChecklist.size()>0)
			return PatientPMHChecklistVoAssembler.createPatientPMHChecklistVoCollectionFromPatientPMHChecklist(patientPMHChecklist).get(0);
		else
			return null;
	}

	public PatientPMHChecklistVo savePatientPMHChecklist(PatientPMHChecklistVo voPatientPMHChecklist, PatientShort voPatientShort) throws StaleObjectException,UniqueKeyViolationException
	{
		if(!voPatientPMHChecklist.isValidated())
		{
			throw new DomainRuntimeException("PatientPMHChecklist Value Object has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();
		PatientPMHChecklist domPatientPMHChecklist = PatientPMHChecklistVoAssembler.extractPatientPMHChecklist(factory,voPatientPMHChecklist);

		factory.save(domPatientPMHChecklist);
		PatientPMHChecklistVo pmhCheckListVo = PatientPMHChecklistVoAssembler.create(domPatientPMHChecklist);
		
		PatientPastMedicalHistoryVo pmhVo = getPastMedicalHistory(voPatientShort);
		if(pmhVo == null)
			pmhVo = new PatientPastMedicalHistoryVo();
		
		int nAdded = addNewlyCreatedRecordsToPMH(pmhVo, pmhCheckListVo);
		
		if (!pmhVo.getPatientIsNotNull())
			pmhVo.setPatient(voPatientShort);
		
		if(nAdded > 0)
		{
			String[] errors = pmhVo.validate();
			if (errors != null)
			{
				throw new DomainRuntimeException(errors[0]);
			}

			savePMH(pmhVo);
		}
					
		return pmhCheckListVo;		
	}

	private int addNewlyCreatedRecordsToPMH(PatientPastMedicalHistoryVo pmhVo, PatientPMHChecklistVo pmhCheckListVo)
	{
		int nCount = 0;
		
		if(!pmhVo.getDiagnosisIsNotNull())
			pmhVo.setDiagnosis(new PatientDiagnosisVoCollection());
		if(!pmhVo.getProcedureIsNotNull())
			pmhVo.setProcedure(new PatientProcedureShortVoCollection());
		
	
		
		//check for Diagnosis
		for(int i = 0; i < pmhCheckListVo.getPositiveDiagnosis().size(); i++)
		{
			PatientDiagnosisVo diagCheckList = pmhCheckListVo.getPositiveDiagnosis().get(i);
			
			boolean bFound = false;
			for (int j = 0; j < pmhVo.getDiagnosis().size(); j++)
			{
				PatientDiagnosisVo diagPmh = pmhVo.getDiagnosis().get(j);
				
				if(diagPmh.getID_PatientDiagnosis().equals(diagCheckList.getID_PatientDiagnosis()))
				{
					bFound = true;
					break;
				}
			}
			
			if(bFound == false)
			{
				pmhVo.getDiagnosis().add(diagCheckList);
				nCount++;
			}
		}

		//check for Procedures
		for(int i = 0; i < pmhCheckListVo.getPositiveProcedure().size(); i++)
		{
			PatientProcedureShortVo procCheckList = pmhCheckListVo.getPositiveProcedure().get(i);
			
			boolean bFound = false;
			for (int j = 0; j < pmhVo.getProcedure().size(); j++)
			{
				PatientProcedureShortVo procPmh = pmhVo.getProcedure().get(j);
				
				if(procPmh.getID_PatientProcedure().equals(procCheckList.getID_PatientProcedure()))
				{
					bFound = true;
					break;
				}
			}
			
			if(bFound == false)
			{
				pmhVo.getProcedure().add(procCheckList);
				nCount++;
			}
		}
		
		return nCount;
	}

	public PMHChecklistConfigVo getPMHCheckListConfig() 
	{
		PMHChecklistConfig checkList = (PMHChecklistConfig) getDomainImpl(PMHChecklistConfigImpl.class);
		return checkList.getPMHCheckListConfig(null);
	}

	public PatientPastMedicalHistoryVo getPastMedicalHistory(PatientShort patient)
	{
		PastMedicalHistory impl = (PastMedicalHistory)getDomainImpl(PastMedicalHistoryImpl.class); 
		return impl.getPastMedicalHistory(patient);
	}

	public PatientPastMedicalHistoryVo savePMH(PatientPastMedicalHistoryVo pmh) throws StaleObjectException,UniqueKeyViolationException
	{
		PastMedicalHistory impl = (PastMedicalHistory)getDomainImpl(PastMedicalHistoryImpl.class); 
		return impl.savePMH(pmh);
	}

	public PMHChecklistConfigVo getPMHCheckListConfigForSpecialty(ClinicalContactShortVo clinicalcontactVo) 
	{
		DomainFactory factory = getDomainFactory();
		if (clinicalcontactVo != null)//Where we are not coding Specialties.
		{
			String hql = " from PMHChecklistConfig config where config.specialty = :spec "; 
		
			List configs = factory.find(hql, new String[]{"spec"}, new Object[]{getDomLookup(clinicalcontactVo.getSpecialty())});
			if(configs.size() == 0)
				return null;
			
			return PMHChecklistConfigVoAssembler.create((ims.clinical.configuration.domain.objects.PMHChecklistConfig)configs.get(0));
		}
		return null;
	}
	
	public PMHChecklistConfigVo getPMHCheckListConfigForSpecialty(Specialty lkupSpecialty) 
	{
		DomainFactory factory = getDomainFactory();
		if (lkupSpecialty != null)//Where we are not coding Specialties.
		{
			String hql = " from PMHChecklistConfig config where config.specialty = :spec "; 
		
			List configs = factory.find(hql, new String[]{"spec"}, new Object[]{getDomLookup(lkupSpecialty)});
			if(configs.size() == 0)
				return null;
			
			return PMHChecklistConfigVoAssembler.create((ims.clinical.configuration.domain.objects.PMHChecklistConfig)configs.get(0));
		}
		return null;
	}

	public Specialty getSpecialtyForEpisodeOfCare(EpisodeOfCareRefVo refVoEpisodeOfCare) {
		EpisodeOfCare episodeOfCare = (EpisodeOfCare)getDomainFactory().getDomainObject(EpisodeOfCare.class, refVoEpisodeOfCare.getID_EpisodeOfCare());
		EpisodeofCareVo voEpisodeofCare = EpisodeofCareVoAssembler.create(episodeOfCare);
		return voEpisodeofCare.getSpecialty();
	}

}
