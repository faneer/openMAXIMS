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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.35 build 2098.19654)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.SocialHistory;
import ims.core.domain.impl.SocialHistoryImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.CareContextVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.SocialHistoryVo;
import ims.core.vo.SocialHistoryVoCollection;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.SocialHistoryVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.generalmedical.vo.OPDErectDysfxnVo;
import ims.generalmedical.vo.OPDErectDysfxnVoCollection;
import ims.generalmedical.vo.domain.OPDErectDysfxnVoAssembler;
import ims.medical.domain.objects.OPDErectDysfxn;

public class OPDEDClinicNotesImpl extends DomainImpl implements ims.spinalinjuries.domain.OPDEDClinicNotes, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void saveOPDEDVo(ims.generalmedical.vo.OPDErectDysfxnVo voOPDED) throws StaleObjectException, UniqueKeyViolationException
	{
		// Ensure the value object has been validated
		if (!voOPDED.isValidated())
			throw new DomainRuntimeException("OPD Erectile Dysfunction has not been validated");

		DomainFactory factory = getDomainFactory();
		if (voOPDED.getID_OPDErectDysfxn() == null)//Inserting a record
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from OPDErectDysfxn as o where o.careContext.id = :CCID and o.isRIE is null");
			java.util.List list = getDomainFactory().find(hql.toString(), "CCID",voOPDED.getCareContext().getID_CareContext());
			if (list == null || list.size() > 0)
				throw new UniqueKeyViolationException(" The screen will be refreshed");
		}
		OPDErectDysfxn doOPDED = OPDErectDysfxnVoAssembler.extractOPDErectDysfxn(factory, voOPDED);
		factory.save(doOPDED);
		return;
	}

	/**
	 * Get OPDEDVo
	 */
	public ims.generalmedical.vo.OPDErectDysfxnVo getOPDEDVo(Integer contactId)
	{
		OPDErectDysfxnVoCollection voCollOPDED = new OPDErectDysfxnVoCollection();

		DomainFactory factory = getDomainFactory();

		String hql = " from OPDErectDysfxn opdED ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (contactId != null)
		{
			condStr.append(andStr + " opdED.clinicalContact.id = :id_ClinicalContact");
			markers.add("id_ClinicalContact");
			values.add(contactId);
			andStr = " and ";
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		voCollOPDED = OPDErectDysfxnVoAssembler.createOPDErectDysfxnVoCollectionFromOPDErectDysfxn(factory.find(hql, markers, values));
		if (voCollOPDED.size() > 0)
			return voCollOPDED.get(0);
		else
			return null;
	}

	public SocialHistoryVo getMedSocialHistory(ClinicalContactShortVo voClinicalContactShort)
	{
		SocialHistoryVoCollection voCollSocHist = new SocialHistoryVoCollection();

		DomainFactory factory = getDomainFactory();

		String hql = " from SocialHistory socHist ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (voClinicalContactShort.getID_ClinicalContactIsNotNull())
		{
			condStr.append(andStr + " socHist.clinicalContact.id = :id_ClinicalContact");
			markers.add("id_ClinicalContact");
			values.add(voClinicalContactShort.getID_ClinicalContact().toString());
			andStr = " and ";
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		voCollSocHist = SocialHistoryVoAssembler.createSocialHistoryVoCollectionFromSocialHistory(factory.find(hql, markers, values));
		if (voCollSocHist.size() > 0)
			return voCollSocHist.get(0);
		else
			return null;
	}

	public void saveMedSocialHistory(SocialHistoryVo voSocialHistory) throws StaleObjectException
	{
		// Ensure the value object has been validated
		if (!voSocialHistory.isValidated())
			throw new DomainRuntimeException("Social History has not been validated");

		DomainFactory factory = getDomainFactory();
		SocialHistory doSocHist = SocialHistoryVoAssembler.extractSocialHistory(factory, voSocialHistory);
		factory.save(doSocHist);
		return;
	}

	public OPDErectDysfxnVoCollection listByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from OPDErectDysfxn ed ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " ed.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List edList = factory.find(query,markers,values);
		OPDErectDysfxnVoCollection voOPDErectDysfxnVoColl = OPDErectDysfxnVoAssembler.createOPDErectDysfxnVoCollectionFromOPDErectDysfxn(edList);
		
		if(voOPDErectDysfxnVoColl.size()>0)
			return voOPDErectDysfxnVoColl;
		else
			return null;
	}

	public OPDErectDysfxnVo getOPDEDVo(ClinicalContactShortVo voClinicalContact)
	{
		OPDErectDysfxnVoCollection voCollOPDED = new OPDErectDysfxnVoCollection();

		DomainFactory factory = getDomainFactory();

		String hql = " from OPDErectDysfxn opdED ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (voClinicalContact.getID_ClinicalContact() != null)
		{
			condStr.append(andStr + " opdED.clinicalContact.id = :id_ClinicalContact");
			markers.add("id_ClinicalContact");
			values.add(voClinicalContact.getID_ClinicalContact());
			andStr = " and ";
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		hql += " and ed.isRIE is null";
		voCollOPDED = OPDErectDysfxnVoAssembler.createOPDErectDysfxnVoCollectionFromOPDErectDysfxn(factory.find(hql, markers, values));
		if (voCollOPDED.size() > 0)
			return voCollOPDED.get(0);
		else
			return null;
	}

	public OPDErectDysfxnVoCollection getOPDErectDysfxnByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from OPDErectDysfxn ed ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " ed.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List edList = factory.find(query,markers,values);
		OPDErectDysfxnVoCollection voOPDErectDysfxnVoColl = OPDErectDysfxnVoAssembler.createOPDErectDysfxnVoCollectionFromOPDErectDysfxn(edList);
		
		return voOPDErectDysfxnVoColl;
	}

	public SocialHistoryVo getMedSocialHistoryByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from SocialHistory socHist ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " socHist.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		query += " and socHist.isRIE is null";
		
		java.util.List socHistList = factory.find(query,markers,values);
		SocialHistoryVoCollection voCollSocHist  = SocialHistoryVoAssembler.createSocialHistoryVoCollectionFromSocialHistory(socHistList);
		
		if(voCollSocHist.size()>0)
			return voCollSocHist.get(0);
		else
			return null;
	}

	public CareContextShortVoCollection listOPEDCareContextsByEpisodeOfCare(EpisodeOfCareRefVo refEpisodeOfCare) {
		
		DomainFactory factory = getDomainFactory();
		List OPDList  = factory.find(" from OPDErectDysfxn opd where opd.careContext.episodeOfCare.id = :ecId and opd.isRIE is null order by opd.careContext.startDateTime desc",
				new String[]{"ecId"},
				new Integer[]{refEpisodeOfCare.getID_EpisodeOfCare()});
	
		CareContextShortVoCollection voCareContextList = new CareContextShortVoCollection();
		for (int x = 0; x < OPDList.size(); x++)
		{
			OPDErectDysfxn domOPD = (OPDErectDysfxn) OPDList.get(x);
	
			CareContextVo voCareContext = CareContextVoAssembler.create(domOPD.getCareContext());
				
			voCareContextList.add(voCareContext);
		}
	
		return voCareContextList;
		
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}

	public SocialHistoryVo getSocialHistoryByPatient(PatientRefVo patient) 
	{
		ims.core.domain.SocialHistory social = (ims.core.domain.SocialHistory)getDomainImpl(SocialHistoryImpl.class);
		return social.getSocialHistoryByPatient(patient);
	}

}
