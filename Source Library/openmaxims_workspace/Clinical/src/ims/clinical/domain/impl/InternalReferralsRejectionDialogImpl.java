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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.clinical.domain.base.impl.BaseInternalReferralsRejectionDialogImpl;
import ims.clinical.domain.objects.ClinicalReferrals;
import ims.clinical.vo.ClinicalReferralForRejectionVo;
import ims.clinical.vo.PatientDocumentForClinicalReferralVo;
import ims.clinical.vo.domain.ClinicalReferralForRejectionVoAssembler;
import ims.clinical.vo.domain.PatientDocumentForClinicalReferralVoAssembler;
import ims.core.documents.domain.objects.PatientDocument;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class InternalReferralsRejectionDialogImpl extends BaseInternalReferralsRejectionDialogImpl
{
	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.ClinicalReferralForRejectionVo getClinicalReferral(ims.clinical.vo.ClinicalReferralsRefVo clinicalReferralRef)
	{
		if(clinicalReferralRef == null || clinicalReferralRef.getID_ClinicalReferrals() == null)
			throw new CodingRuntimeException("Cannor get ClinicalReferrals for a null ClinicalReferralsId.");
		
		DomainFactory factory = getDomainFactory();
		ClinicalReferrals doClinicalReferrals = (ClinicalReferrals) factory.getDomainObject(ClinicalReferrals.class, clinicalReferralRef.getID_ClinicalReferrals());
		
		return ClinicalReferralForRejectionVoAssembler.create(doClinicalReferrals);
	}

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List<?> lst = factory.find("select r.reportXml, t.templateXml from ReportBo as r left join r.templates as t where (r.imsId= :imsid) order by t.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}

	public ClinicalReferralForRejectionVo save(ClinicalReferralForRejectionVo clinicalReferral,	PatientDocumentForClinicalReferralVo patientDocument) throws StaleObjectException 
	{
		if(clinicalReferral == null)
			throw new CodingRuntimeException("Cannot save a null ClinicalReferralForRejectionVo");
		
		if(!clinicalReferral.isValidated())
			throw new CodingRuntimeException("ClinicalReferralForRejectionVo is not validated");
		
		if(patientDocument == null)
			throw new CodingRuntimeException("Cannot save a null PatientDocumentForClinicalReferralVo");
		
		if(!patientDocument.isValidated())
			throw new CodingRuntimeException("PatientDocumentForClinicalReferralVo is not validated");
		
		DomainFactory factory = getDomainFactory();
		
		ClinicalReferrals doClinicalReferral = ClinicalReferralForRejectionVoAssembler.extractClinicalReferrals(factory, clinicalReferral);
		factory.save(doClinicalReferral);
		
		PatientDocument doPatientDocument = PatientDocumentForClinicalReferralVoAssembler.extractPatientDocument(factory, patientDocument);
		factory.save(doPatientDocument);
		
		return ClinicalReferralForRejectionVoAssembler.create(doClinicalReferral);
	}

	//wdev-20960
	public ClinicalReferralForRejectionVo saveClinicalreferral(ClinicalReferralForRejectionVo record) throws StaleObjectException
	{
		if(	record == null)
			throw new CodingRuntimeException("Cannot save a null ClinicalReferralForRejectionVo");
	
		if(	!record.isValidated())
			throw new CodingRuntimeException("ClinicalReferralForRejectionVo is not validated");
		
		DomainFactory factory = getDomainFactory();
		
		ClinicalReferrals doClinicalReferral = ClinicalReferralForRejectionVoAssembler.extractClinicalReferrals(factory, record);
		factory.save(doClinicalReferral);
		return ClinicalReferralForRejectionVoAssembler.create(doClinicalReferral);
	}

	//wdev-20960
	public void saveDocument(PatientDocumentForClinicalReferralVo record) throws StaleObjectException
	{
		if( record == null)
			throw new CodingRuntimeException("Cannot save a null PatientDocumentForClinicalReferralVo");
		
		if( !record.isValidated())
			throw new CodingRuntimeException("PatientDocumentForClinicalReferralVo is not validated");
		
		DomainFactory factory = getDomainFactory();
		PatientDocument doPatientDocument = PatientDocumentForClinicalReferralVoAssembler.extractPatientDocument(factory, record);
		factory.save(doPatientDocument);
		
	}
}
