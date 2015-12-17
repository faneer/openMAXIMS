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

package ims.assessment.forms.patientassessmentcomp;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
		Assessment = new AssessmentContext(context);
		Core = new CoreContext(context);
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
			public boolean getEditedComponentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentEditedComponent.getValueIsNull(context);
			}
			public ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo getEditedComponent()
			{
				return (ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo)cx_ClinicalPatientAssessmentEditedComponent.getValue(context);
			}
		public void setEditedComponent(ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo value)
		{
				cx_ClinicalPatientAssessmentEditedComponent.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentEditedComponent = new ims.framework.ContextVariable("Clinical.PatientAssessment.EditedComponent", "_cv_Clinical.PatientAssessment.EditedComponent");
			public boolean getEditComponentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentEditComponent.getValueIsNull(context);
			}
			public Boolean getEditComponent()
			{
				return (Boolean)cx_ClinicalPatientAssessmentEditComponent.getValue(context);
			}
		public void setEditComponent(Boolean value)
		{
				cx_ClinicalPatientAssessmentEditComponent.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentEditComponent = new ims.framework.ContextVariable("Clinical.PatientAssessment.EditComponent", "_cv_Clinical.PatientAssessment.EditComponent");
			private ims.framework.Context context;
		}

		public boolean getReturnToFormNameIsNotNull()
		{
			return !cx_ClinicalReturnToFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getReturnToFormName()
		{
			return (ims.framework.FormName)cx_ClinicalReturnToFormName.getValue(context);
		}
		public void setReturnToFormName(ims.framework.FormName value)
		{
			cx_ClinicalReturnToFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormName = new ims.framework.ContextVariable("Clinical.ReturnToFormName", "_cv_Clinical.ReturnToFormName");

		public PatientAssessmentContext PatientAssessment;
		private ims.framework.Context context;
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientUserDefinedObjectIsNotNull()
		{
			return !cx_AssessmentPatientUserDefinedObject.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientUserDefinedObjectVo getPatientUserDefinedObject()
		{
			return (ims.assessment.vo.PatientUserDefinedObjectVo)cx_AssessmentPatientUserDefinedObject.getValue(context);
		}
		public void setPatientUserDefinedObject(ims.assessment.vo.PatientUserDefinedObjectVo value)
		{
			cx_AssessmentPatientUserDefinedObject.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentPatientUserDefinedObject = new ims.framework.ContextVariable("Assessment.PatientUserDefinedObject", "_cv_Assessment.PatientUserDefinedObject");

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

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getUserDefinedObjectSelectedIsNotNull()
		{
			return !cx_CoreUserDefinedObjectSelected.getValueIsNull(context);
		}
		public ims.assessment.vo.UserDefinedObjectVo getUserDefinedObjectSelected()
		{
			return (ims.assessment.vo.UserDefinedObjectVo)cx_CoreUserDefinedObjectSelected.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreUserDefinedObjectSelected = new ims.framework.ContextVariable("Core.UserDefinedObjectSelected", "_cv_Core.UserDefinedObjectSelected");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public AssessmentContext Assessment;
	public CoreContext Core;
}
