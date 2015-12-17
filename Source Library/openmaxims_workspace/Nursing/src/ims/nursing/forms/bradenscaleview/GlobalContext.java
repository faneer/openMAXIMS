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

package ims.nursing.forms.bradenscaleview;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		COE = new COEContext(context);
		Nursing = new NursingContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getReportIDIsNotNull()
		{
			return !cx_CoreReportID.getValueIsNull(context);
		}
		public Integer getReportID()
		{
			return (Integer)cx_CoreReportID.getValue(context);
		}
		public void setReportID(Integer value)
		{
			cx_CoreReportID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportID = new ims.framework.ContextVariable("Core.ReportID", "_cv_Core.ReportID");
		public boolean getTemplateIDIsNotNull()
		{
			return !cx_CoreTemplateID.getValueIsNull(context);
		}
		public Integer getTemplateID()
		{
			return (Integer)cx_CoreTemplateID.getValue(context);
		}
		public void setTemplateID(Integer value)
		{
			cx_CoreTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplateID = new ims.framework.ContextVariable("Core.TemplateID", "_cv_Core.TemplateID");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBradenAssessmentsIsNotNull()
		{
			return !cx_COEBradenAssessments.getValueIsNull(context);
		}
		public ims.coe.vo.RiskAssessmentCollection getBradenAssessments()
		{
			return (ims.coe.vo.RiskAssessmentCollection)cx_COEBradenAssessments.getValue(context);
		}
		public void setBradenAssessments(ims.coe.vo.RiskAssessmentCollection value)
		{
			cx_COEBradenAssessments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEBradenAssessments = new ims.framework.ContextVariable("COE.BradenAssessments", "_cv_COE.BradenAssessments");
		public boolean getAddNewIsNotNull()
		{
			return !cx_COEAddNew.getValueIsNull(context);
		}
		public Boolean getAddNew()
		{
			return (Boolean)cx_COEAddNew.getValue(context);
		}
		public void setAddNew(Boolean value)
		{
			cx_COEAddNew.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEAddNew = new ims.framework.ContextVariable("COE.AddNew", "_cv_COE.AddNew");
		public boolean getBradenScaleRecordIsNotNull()
		{
			return !cx_COEBradenScaleRecord.getValueIsNull(context);
		}
		public ims.nursing.vo.BradenScale getBradenScaleRecord()
		{
			return (ims.nursing.vo.BradenScale)cx_COEBradenScaleRecord.getValue(context);
		}
		public void setBradenScaleRecord(ims.nursing.vo.BradenScale value)
		{
			cx_COEBradenScaleRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEBradenScaleRecord = new ims.framework.ContextVariable("COE.BradenScaleRecord", "_cv_COE.BradenScaleRecord");

		private ims.framework.Context context;
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBradenScaleSearchCriteriaIsNotNull()
		{
			return !cx_NursingBradenScaleSearchCriteria.getValueIsNull(context);
		}
		public ims.nursing.vo.BradenScaleSearchCriteriaVo getBradenScaleSearchCriteria()
		{
			return (ims.nursing.vo.BradenScaleSearchCriteriaVo)cx_NursingBradenScaleSearchCriteria.getValue(context);
		}
		public void setBradenScaleSearchCriteria(ims.nursing.vo.BradenScaleSearchCriteriaVo value)
		{
			cx_NursingBradenScaleSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingBradenScaleSearchCriteria = new ims.framework.ContextVariable("Nursing.BradenScaleSearchCriteria", "_cvp_Nursing.BradenScaleSearchCriteria");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public COEContext COE;
	public NursingContext Nursing;
}
