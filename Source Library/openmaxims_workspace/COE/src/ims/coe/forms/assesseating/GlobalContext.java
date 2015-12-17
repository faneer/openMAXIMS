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

package ims.coe.forms.assesseating;

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

		public boolean getAssessmentScoreIsNotNull()
		{
			return !cx_COEAssessmentScore.getValueIsNull(context);
		}
		public Float getAssessmentScore()
		{
			return (Float)cx_COEAssessmentScore.getValue(context);
		}
		public void setAssessmentScore(Float value)
		{
			cx_COEAssessmentScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEAssessmentScore = new ims.framework.ContextVariable("COE.AssessmentScore", "_cv_COE.AssessmentScore");
		public boolean getDisplayScoreIsNotNull()
		{
			return !cx_COEDisplayScore.getValueIsNull(context);
		}
		public Boolean getDisplayScore()
		{
			return (Boolean)cx_COEDisplayScore.getValue(context);
		}
		public void setDisplayScore(Boolean value)
		{
			cx_COEDisplayScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEDisplayScore = new ims.framework.ContextVariable("COE.DisplayScore", "_cv_COE.DisplayScore");
		public boolean getMNARecordIsNotNull()
		{
			return !cx_COEMNARecord.getValueIsNull(context);
		}
		public ims.nursing.vo.MiniNutritionalAssessment getMNARecord()
		{
			return (ims.nursing.vo.MiniNutritionalAssessment)cx_COEMNARecord.getValue(context);
		}
		public void setMNARecord(ims.nursing.vo.MiniNutritionalAssessment value)
		{
			cx_COEMNARecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEMNARecord = new ims.framework.ContextVariable("COE.MNARecord", "_cv_COE.MNARecord");
		public boolean getAssessmentEatingAndDrinkingIsNotNull()
		{
			return !cx_COEAssessmentEatingAndDrinking.getValueIsNull(context);
		}
		public ims.coe.vo.AssessmentEatingAndDrinking getAssessmentEatingAndDrinking()
		{
			return (ims.coe.vo.AssessmentEatingAndDrinking)cx_COEAssessmentEatingAndDrinking.getValue(context);
		}
		public void setAssessmentEatingAndDrinking(ims.coe.vo.AssessmentEatingAndDrinking value)
		{
			cx_COEAssessmentEatingAndDrinking.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEAssessmentEatingAndDrinking = new ims.framework.ContextVariable("COE.AssessmentEatingAndDrinking", "_cv_COE.AssessmentEatingAndDrinking");
		public boolean getMNAAssessmentsIsNotNull()
		{
			return !cx_COEMNAAssessments.getValueIsNull(context);
		}
		public ims.coe.vo.RiskAssessmentCollection getMNAAssessments()
		{
			return (ims.coe.vo.RiskAssessmentCollection)cx_COEMNAAssessments.getValue(context);
		}
		public void setMNAAssessments(ims.coe.vo.RiskAssessmentCollection value)
		{
			cx_COEMNAAssessments.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COEMNAAssessments = new ims.framework.ContextVariable("COE.MNAAssessments", "_cv_COE.MNAAssessments");

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

		private ims.framework.Context context;
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

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
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
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public NursingContext Nursing;
	public CoreContext Core;
}
