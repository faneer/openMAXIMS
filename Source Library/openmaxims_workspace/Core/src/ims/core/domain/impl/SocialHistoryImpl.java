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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.25 build 1950.14314)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientProblem;
import ims.core.clinical.domain.objects.SocialHistory;
import ims.core.clinical.vo.SocialHistoryRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.SocialHistoryLiteVoCollection;
import ims.core.vo.SocialHistoryVo;
import ims.core.vo.SocialHistoryVoCollection;
import ims.core.vo.domain.SocialHistoryLiteVoAssembler;
import ims.core.vo.domain.SocialHistoryVoAssembler;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.generalmedical.vo.MedicalProbOnAdmisVoCollection;
import ims.generalmedical.vo.domain.MedicalProbOnAdmisVoAssembler;

public class SocialHistoryImpl extends DomainImpl implements ims.core.domain.SocialHistory, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SocialHistoryVo saveSocialHistory(SocialHistoryVo voSocialHistory) throws StaleObjectException
	{
		if(voSocialHistory == null || !voSocialHistory.isValidated())
			throw new CodingRuntimeException("Social History Value Object is null or has not been validated");
		
		if (voSocialHistory.getID_SocialHistory() == null && getSocialHistoryByCareContext(voSocialHistory.getCareContext()) != null)
			throw new StaleObjectException(null, "A Social History record already exists for this Care Context, the screen will be refreshed.");

		DomainFactory factory = getDomainFactory();
		SocialHistory domSocialHistory = SocialHistoryVoAssembler.extractSocialHistory(factory,voSocialHistory);
		factory.save(domSocialHistory);
		
		return SocialHistoryVoAssembler.create(domSocialHistory);
	}

	public MedicalProbOnAdmisVoCollection getProblems(ClinicalContactShortVo voClinicalContactShort) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = " from PatientProblem medicalProbOnAdmis "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voClinicalContactShort.getID_ClinicalContactIsNotNull())
		{
			condStr.append(andStr + " medicalProbOnAdmis.clinicalContact.id = :id_ClinicalContact"); 
			markers.add("id_ClinicalContact");
			values.add(voClinicalContactShort.getID_ClinicalContact());
			andStr = " and ";
		}	
		
		condStr.append(andStr + " medicalProbOnAdmis.problemContext = :problemContext"); 
		markers.add("problemContext");
		values.add("Social History");
		andStr = " and ";
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		return MedicalProbOnAdmisVoAssembler.createMedicalProbOnAdmisVoCollectionFromPatientProblem(factory.find(hql, markers, values));
	}

	public MedicalProbOnAdmisVoCollection saveProblemsOnAdmis(MedicalProbOnAdmisVoCollection collProblemsOnAdmis) throws StaleObjectException 
	{
		//Ensure the value object has been validated
		if (!collProblemsOnAdmis.isValidated())
			throw new DomainRuntimeException("Problems on Admission has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = new MedicalProbOnAdmisVoCollection(); 
		
		for(int i=0; i<collProblemsOnAdmis.size(); i++)
		{
			PatientProblem doMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.extractPatientProblem(factory, collProblemsOnAdmis.get(i));
			try 
			{
				factory.save(doMedicalProbOnAdmis);
			} 
			catch (DomainException e) 
			{
				throw new DomainRuntimeException("Error saving Problems on Admission " + e.getMessage(),e);	
			} 	
			
			collMedicalProbOnAdmis.add(MedicalProbOnAdmisVoAssembler.create(doMedicalProbOnAdmis));
		}
		
		return collMedicalProbOnAdmis;
	}

	public SocialHistoryVo getSocialHistoryByCareContext(CareContextRefVo voCareContextRef)
	{
		if(voCareContextRef == null)
			throw new CodingRuntimeException("Contact not Provided");
		
		DomainFactory factory = getDomainFactory();

		//the following query retrievs the one and only contact of type spinalmedicaladmission if it has been instantiated
		List socialHistory =   factory.find(" from SocialHistory sc where sc.careContext.id = :idCareContext order by sc.systemInformation.creationDateTime desc )",
				new String[]{"idCareContext" },
				new Object[]{ voCareContextRef.getID_CareContext()});

		SocialHistoryVoCollection voCollSocialHistory = SocialHistoryVoAssembler.createSocialHistoryVoCollectionFromSocialHistory(socialHistory);
		
		if(voCollSocialHistory.size()>0)
			return voCollSocialHistory.get(0);
		else 
			return null;
		
	}

	public SocialHistoryVo getSocialHistoryByPatient(PatientRefVo patient)
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Patient not Provided to retrive Core Clinical - Social History record");
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "from SocialHistory socHist where socHist.careContext.episodeOfCare.careSpell.patient.id = :idPatient order by socHist.systemInformation.creationDateTime desc";
		List socialHistory = factory.find(hql, new String[] {"idPatient"}, new Object[] {patient.getID_Patient()});
		if (socialHistory != null && socialHistory.size() > 0)
			return SocialHistoryVoAssembler.create((SocialHistory) socialHistory.get(0));
		
		return null;
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}

	
	public SocialHistoryVoCollection getSocialHistoryByCareContextCollection( CareContextRefVo voCareContextRef) 
	{
		if(voCareContextRef == null)
			throw new CodingRuntimeException("Contact not Provided");
		
		DomainFactory factory = getDomainFactory();

		//the following query retrievs the one and only contact of type spinalmedicaladmission if it has been instantiated
		List socialHistory =   factory.find(" from SocialHistory sc where sc.careContext.id = :idCareContext ",
				new String[]{"idCareContext" },
				new Object[]{ voCareContextRef.getID_CareContext()});

		SocialHistoryVoCollection voCollSocialHistory = SocialHistoryVoAssembler.createSocialHistoryVoCollectionFromSocialHistory(socialHistory);
		
		if(voCollSocialHistory.size()>0)
			return voCollSocialHistory;
		else 
			return null;

	}

	
	public SocialHistoryLiteVoCollection getSocialHistoryByPatientColl(	PatientRefVo patient) 
	{
		if(patient == null || patient.getID_Patient() == null)
			return null;
			
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "from SocialHistory socHist where socHist.careContext.episodeOfCare.careSpell.patient.id = :idPatient order by socHist.authoringInformation.authoringDateTime desc";
		List socialHistory = factory.find(hql, new String[] {"idPatient"}, new Object[] {patient.getID_Patient()});
		if (socialHistory != null && socialHistory.size() > 0)
			return SocialHistoryLiteVoAssembler.createSocialHistoryLiteVoCollectionFromSocialHistory(socialHistory);
		
		return null;
	}
	
	public SocialHistoryVo getSocialHistoryById(SocialHistoryRefVo socialhostoryref) 
	{
		if(socialhostoryref == null || !socialhostoryref.getID_SocialHistoryIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();

		
		List socialHistory =   factory.find(" from SocialHistory sc where sc.id = :idSocialHistory ",
				new String[]{"idSocialHistory" },
				new Object[]{ socialhostoryref.getID_SocialHistory()});

		SocialHistoryVoCollection voCollSocialHistory = SocialHistoryVoAssembler.createSocialHistoryVoCollectionFromSocialHistory(socialHistory);
		
		if(voCollSocialHistory.size()>0)
			return voCollSocialHistory.get(0);
		else 
			return null;
	}

	
	/*public ClinicalAdmissionVo getClinicalAdmission(CareContextRefVo careContextRefvo) 
	{
		if(careContextRefvo == null || !careContextRefvo.getID_CareContextIsNotNull() )
			return null;

		if(careContextRefvo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from ClinicalAdmission ca where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " ca.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContextRefvo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				ClinicalAdmissionVoCollection voColl = ClinicalAdmissionVoAssembler.createClinicalAdmissionVoCollectionFromClinicalAdmission(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}*/
}
