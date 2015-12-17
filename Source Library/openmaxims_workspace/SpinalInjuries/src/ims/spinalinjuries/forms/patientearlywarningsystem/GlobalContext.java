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

package ims.spinalinjuries.forms.patientearlywarningsystem;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Assessment = new AssessmentContext(context);
		Clinical = new ClinicalContext(context);
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

		private ims.framework.Context context;
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getOpenDynamicAssessmentDialogInViewModeIsNotNull()
		{
			return !cx_AssessmentOpenDynamicAssessmentDialogInViewMode.getValueIsNull(context);
		}
		public Boolean getOpenDynamicAssessmentDialogInViewMode()
		{
			return (Boolean)cx_AssessmentOpenDynamicAssessmentDialogInViewMode.getValue(context);
		}
		public void setOpenDynamicAssessmentDialogInViewMode(Boolean value)
		{
			cx_AssessmentOpenDynamicAssessmentDialogInViewMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentOpenDynamicAssessmentDialogInViewMode = new ims.framework.ContextVariable("Assessment.OpenDynamicAssessmentDialogInViewMode", "_cv_Assessment.OpenDynamicAssessmentDialogInViewMode");
		public boolean getIsDynamicAssessmentOpenedForPreviewIsNotNull()
		{
			return !cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValueIsNull(context);
		}
		public Boolean getIsDynamicAssessmentOpenedForPreview()
		{
			return (Boolean)cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValue(context);
		}
		public void setIsDynamicAssessmentOpenedForPreview(Boolean value)
		{
			cx_AssessmentIsDynamicAssessmentOpenedForPreview.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentIsDynamicAssessmentOpenedForPreview = new ims.framework.ContextVariable("Assessment.IsDynamicAssessmentOpenedForPreview", "_cv_Assessment.IsDynamicAssessmentOpenedForPreview");
		public boolean getDynamicAssessmentIsNotNull()
		{
			return !cx_AssessmentDynamicAssessment.getValueIsNull(context);
		}
		public ims.vo.ValueObjectRef getDynamicAssessment()
		{
			return (ims.vo.ValueObjectRef)cx_AssessmentDynamicAssessment.getValue(context);
		}
		public void setDynamicAssessment(ims.vo.ValueObjectRef value)
		{
			cx_AssessmentDynamicAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentDynamicAssessment = new ims.framework.ContextVariable("Assessment.DynamicAssessment", "_cv_Assessment.DynamicAssessment");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientAssessment = new PatientAssessmentContext(context);
		}
		public final class PatientAssessmentContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientAssessmentContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectedAssessmentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentSelectedAssessment.getValueIsNull(context);
			}
			public ims.assessment.instantiation.vo.PatientAssessmentRefVo getSelectedAssessment()
			{
				return (ims.assessment.instantiation.vo.PatientAssessmentRefVo)cx_ClinicalPatientAssessmentSelectedAssessment.getValue(context);
			}
		public void setSelectedAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo value)
		{
				cx_ClinicalPatientAssessmentSelectedAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentSelectedAssessment = new ims.framework.ContextVariable("Clinical.PatientAssessment.SelectedAssessment", "_cv_Clinical.PatientAssessment.SelectedAssessment");
			private ims.framework.Context context;
		}


		public PatientAssessmentContext PatientAssessment;
		private ims.framework.Context context;
	}

	public CoreContext Core;
	public AssessmentContext Assessment;
	public ClinicalContext Clinical;
}
