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

package ims.spinalinjuries.forms.nurassessmenteating;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Nursing = new NursingContext(context);
		COE = new COEContext(context);
		Core = new CoreContext(context);
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getNutritionalRiskAssessmentsIsNotNull()
		{
			return !cx_NursingNutritionalRiskAssessments.getValueIsNull(context);
		}
		public ims.coe.vo.RiskAssessmentCollection getNutritionalRiskAssessments()
		{
			return (ims.coe.vo.RiskAssessmentCollection)cx_NursingNutritionalRiskAssessments.getValue(context);
		}
		public void setNutritionalRiskAssessments(ims.coe.vo.RiskAssessmentCollection value)
		{
			cx_NursingNutritionalRiskAssessments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingNutritionalRiskAssessments = new ims.framework.ContextVariable("Nursing.NutritionalRiskAssessments", "_cv_Nursing.NutritionalRiskAssessments");
		public boolean getNutritionalRiskRecordIsNotNull()
		{
			return !cx_NursingNutritionalRiskRecord.getValueIsNull(context);
		}
		public ims.nursing.vo.NutritionalRiskAssessmentVo getNutritionalRiskRecord()
		{
			return (ims.nursing.vo.NutritionalRiskAssessmentVo)cx_NursingNutritionalRiskRecord.getValue(context);
		}
		public void setNutritionalRiskRecord(ims.nursing.vo.NutritionalRiskAssessmentVo value)
		{
			cx_NursingNutritionalRiskRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingNutritionalRiskRecord = new ims.framework.ContextVariable("Nursing.NutritionalRiskRecord", "_cv_Nursing.NutritionalRiskRecord");
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


		public CarePlanContext CarePlan;
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

	public NursingContext Nursing;
	public COEContext COE;
	public CoreContext Core;
}
