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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.spinalinjuries.forms.nurassessmentskin;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		COE = new COEContext(context);
		Nursing = new NursingContext(context);
		Core = new CoreContext(context);
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

			CarePlan = new CarePlanContext(context);
		}
		public final class CarePlanContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CarePlanContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getTemplateListIsNotNull()
			{
				return !cx_COECarePlanTemplateList.getValueIsNull(context);
			}
			public ims.nursing.vo.CarePlanTemplateTitleCollection getTemplateList()
			{
				return (ims.nursing.vo.CarePlanTemplateTitleCollection)cx_COECarePlanTemplateList.getValue(context);
			}
		public void setTemplateList(ims.nursing.vo.CarePlanTemplateTitleCollection value)
		{
				cx_COECarePlanTemplateList.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COECarePlanTemplateList = new ims.framework.ContextVariable("COE.CarePlan.TemplateList", "_cv_COE.CarePlan.TemplateList");
			private ims.framework.Context context;
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

		public CarePlanContext CarePlan;
		private ims.framework.Context context;
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAssessmentInfoIsNotNull()
		{
			return !cx_NursingAssessmentInfo.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentInfoCollection getAssessmentInfo()
		{
			return (ims.nursing.vo.AssessmentInfoCollection)cx_NursingAssessmentInfo.getValue(context);
		}
		public void setAssessmentInfo(ims.nursing.vo.AssessmentInfoCollection value)
		{
			cx_NursingAssessmentInfo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentInfo = new ims.framework.ContextVariable("Nursing.AssessmentInfo", "_cv_Nursing.AssessmentInfo");
		public boolean getWaterlowAssessmentsIsNotNull()
		{
			return !cx_NursingWaterlowAssessments.getValueIsNull(context);
		}
		public ims.coe.vo.RiskAssessmentCollection getWaterlowAssessments()
		{
			return (ims.coe.vo.RiskAssessmentCollection)cx_NursingWaterlowAssessments.getValue(context);
		}
		public void setWaterlowAssessments(ims.coe.vo.RiskAssessmentCollection value)
		{
			cx_NursingWaterlowAssessments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingWaterlowAssessments = new ims.framework.ContextVariable("Nursing.WaterlowAssessments", "_cv_Nursing.WaterlowAssessments");
		public boolean getWaterlowRecordIsNotNull()
		{
			return !cx_NursingWaterlowRecord.getValueIsNull(context);
		}
		public ims.nursing.vo.WaterlowAssessmentVo getWaterlowRecord()
		{
			return (ims.nursing.vo.WaterlowAssessmentVo)cx_NursingWaterlowRecord.getValue(context);
		}
		public void setWaterlowRecord(ims.nursing.vo.WaterlowAssessmentVo value)
		{
			cx_NursingWaterlowRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingWaterlowRecord = new ims.framework.ContextVariable("Nursing.WaterlowRecord", "_cv_Nursing.WaterlowRecord");
		public boolean getAssessmentComponentIsNotNull()
		{
			return !cx_NursingAssessmentComponent.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentComponent getAssessmentComponent()
		{
			return (ims.nursing.vo.AssessmentComponent)cx_NursingAssessmentComponent.getValue(context);
		}
		public void setAssessmentComponent(ims.nursing.vo.AssessmentComponent value)
		{
			cx_NursingAssessmentComponent.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentComponent = new ims.framework.ContextVariable("Nursing.AssessmentComponent", "_cv_Nursing.AssessmentComponent");
		public boolean getAssessmentHeaderInfoIsNotNull()
		{
			return !cx_NursingAssessmentHeaderInfo.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentHeaderInfo getAssessmentHeaderInfo()
		{
			return (ims.nursing.vo.AssessmentHeaderInfo)cx_NursingAssessmentHeaderInfo.getValue(context);
		}
		public void setAssessmentHeaderInfo(ims.nursing.vo.AssessmentHeaderInfo value)
		{
			cx_NursingAssessmentHeaderInfo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentHeaderInfo = new ims.framework.ContextVariable("Nursing.AssessmentHeaderInfo", "_cv_Nursing.AssessmentHeaderInfo");
		public boolean getEditIsNotNull()
		{
			return !cx_NursingEdit.getValueIsNull(context);
		}
		public Boolean getEdit()
		{
			return (Boolean)cx_NursingEdit.getValue(context);
		}
		public void setEdit(Boolean value)
		{
			cx_NursingEdit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingEdit = new ims.framework.ContextVariable("Nursing.Edit", "_cv_Nursing.Edit");
		public boolean getDisplayScoreIsNotNull()
		{
			return !cx_NursingDisplayScore.getValueIsNull(context);
		}
		public Boolean getDisplayScore()
		{
			return (Boolean)cx_NursingDisplayScore.getValue(context);
		}
		public void setDisplayScore(Boolean value)
		{
			cx_NursingDisplayScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingDisplayScore = new ims.framework.ContextVariable("Nursing.DisplayScore", "_cv_Nursing.DisplayScore");
		public boolean getAssessmentScoreIsNotNull()
		{
			return !cx_NursingAssessmentScore.getValueIsNull(context);
		}
		public Float getAssessmentScore()
		{
			return (Float)cx_NursingAssessmentScore.getValue(context);
		}
		public void setAssessmentScore(Float value)
		{
			cx_NursingAssessmentScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentScore = new ims.framework.ContextVariable("Nursing.AssessmentScore", "_cv_Nursing.AssessmentScore");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getAssessmentIsReadOnlyIsNotNull()
		{
			return !cx_CoreAssessmentIsReadOnly.getValueIsNull(context);
		}
		public Boolean getAssessmentIsReadOnly()
		{
			return (Boolean)cx_CoreAssessmentIsReadOnly.getValue(context);
		}
		public void setAssessmentIsReadOnly(Boolean value)
		{
			cx_CoreAssessmentIsReadOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreAssessmentIsReadOnly = new ims.framework.ContextVariable("Core.AssessmentIsReadOnly", "_cv_Core.AssessmentIsReadOnly");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public NursingContext Nursing;
	public CoreContext Core;
}
