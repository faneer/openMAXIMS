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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.internalreferralsincominglistcomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getPatientDocumentsCollectionForClinicalReferralIsNotNull()
		{
			return !cx_CorePatientDocumentsCollectionForClinicalReferral.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVoCollection getPatientDocumentsCollectionForClinicalReferral()
		{
			return (ims.core.vo.PatientDocumentVoCollection)cx_CorePatientDocumentsCollectionForClinicalReferral.getValue(context);
		}
		public void setPatientDocumentsCollectionForClinicalReferral(ims.core.vo.PatientDocumentVoCollection value)
		{
			cx_CorePatientDocumentsCollectionForClinicalReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocumentsCollectionForClinicalReferral = new ims.framework.ContextVariable("Core.PatientDocumentsCollectionForClinicalReferral", "_cv_Core.PatientDocumentsCollectionForClinicalReferral");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getClinicalReferralRefIsNotNull()
		{
			return !cx_ClinicalClinicalReferralRef.getValueIsNull(context);
		}
		public ims.clinical.vo.ClinicalReferralsRefVo getClinicalReferralRef()
		{
			return (ims.clinical.vo.ClinicalReferralsRefVo)cx_ClinicalClinicalReferralRef.getValue(context);
		}
		public void setClinicalReferralRef(ims.clinical.vo.ClinicalReferralsRefVo value)
		{
			cx_ClinicalClinicalReferralRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalReferralRef = new ims.framework.ContextVariable("Clinical.ClinicalReferralRef", "_cv_Clinical.ClinicalReferralRef");
		public boolean getReferralIHaveReceivedCriteriaIsNotNull()
		{
			return !cx_ClinicalReferralIHaveReceivedCriteria.getValueIsNull(context);
		}
		public ims.clinical.vo.IncomingReferralListCriteriaVo getReferralIHaveReceivedCriteria()
		{
			return (ims.clinical.vo.IncomingReferralListCriteriaVo)cx_ClinicalReferralIHaveReceivedCriteria.getValue(context);
		}
		public void setReferralIHaveReceivedCriteria(ims.clinical.vo.IncomingReferralListCriteriaVo value)
		{
			cx_ClinicalReferralIHaveReceivedCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReferralIHaveReceivedCriteria = new ims.framework.ContextVariable("Clinical.ReferralIHaveReceivedCriteria", "_cvp_Clinical.ReferralIHaveReceivedCriteria");
		public boolean getIncomingReferralListCriteriaIsNotNull()
		{
			return !cx_ClinicalIncomingReferralListCriteria.getValueIsNull(context);
		}
		public ims.clinical.vo.IncomingReferralListCriteriaVo getIncomingReferralListCriteria()
		{
			return (ims.clinical.vo.IncomingReferralListCriteriaVo)cx_ClinicalIncomingReferralListCriteria.getValue(context);
		}
		public void setIncomingReferralListCriteria(ims.clinical.vo.IncomingReferralListCriteriaVo value)
		{
			cx_ClinicalIncomingReferralListCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalIncomingReferralListCriteria = new ims.framework.ContextVariable("Clinical.IncomingReferralListCriteria", "_cvp_Clinical.IncomingReferralListCriteria");
		public boolean getServiceConfigSearchListIsNotNull()
		{
			return !cx_ClinicalServiceConfigSearchList.getValueIsNull(context);
		}
		public ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection getServiceConfigSearchList()
		{
			return (ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection)cx_ClinicalServiceConfigSearchList.getValue(context);
		}
		public void setServiceConfigSearchList(ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection value)
		{
			cx_ClinicalServiceConfigSearchList.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalServiceConfigSearchList = new ims.framework.ContextVariable("Clinical.ServiceConfigSearchList", "_cv_Clinical.ServiceConfigSearchList");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public ClinicalContext Clinical;
}
