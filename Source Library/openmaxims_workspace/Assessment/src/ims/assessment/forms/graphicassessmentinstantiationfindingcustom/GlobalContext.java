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

package ims.assessment.forms.graphicassessmentinstantiationfindingcustom;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Assessment = new AssessmentContext(context);
		Core = new CoreContext(context);
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientGraphicalAssessmentStageIsNotNull()
		{
			return !cx_AssessmentPatientGraphicalAssessmentStage.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientGraphicalAssessmentStageVo getPatientGraphicalAssessmentStage()
		{
			return (ims.assessment.vo.PatientGraphicalAssessmentStageVo)cx_AssessmentPatientGraphicalAssessmentStage.getValue(context);
		}
		public void setPatientGraphicalAssessmentStage(ims.assessment.vo.PatientGraphicalAssessmentStageVo value)
		{
			cx_AssessmentPatientGraphicalAssessmentStage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentPatientGraphicalAssessmentStage = new ims.framework.ContextVariable("Assessment.PatientGraphicalAssessmentStage", "_cv_Assessment.PatientGraphicalAssessmentStage");
		public boolean getAutoSubmitIsNotNull()
		{
			return !cx_AssessmentAutoSubmit.getValueIsNull(context);
		}
		public Boolean getAutoSubmit()
		{
			return (Boolean)cx_AssessmentAutoSubmit.getValue(context);
		}
		public void setAutoSubmit(Boolean value)
		{
			cx_AssessmentAutoSubmit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentAutoSubmit = new ims.framework.ContextVariable("Assessment.AutoSubmit", "_cv_Assessment.AutoSubmit");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientAssessmentFullIsNotNull()
		{
			return !cx_CorePatientAssessmentFull.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentFull()
		{
			return (ims.assessment.vo.PatientAssessmentVo)cx_CorePatientAssessmentFull.getValue(context);
		}
		public void setPatientAssessmentFull(ims.assessment.vo.PatientAssessmentVo value)
		{
			cx_CorePatientAssessmentFull.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientAssessmentFull = new ims.framework.ContextVariable("Core.PatientAssessmentFull", "_cv_Core.PatientAssessmentFull");
		public boolean getPatientGraphicAssessmentFindingIsNotNull()
		{
			return !cx_CorePatientGraphicAssessmentFinding.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientGraphicAssessmentFindingVo getPatientGraphicAssessmentFinding()
		{
			return (ims.assessment.vo.PatientGraphicAssessmentFindingVo)cx_CorePatientGraphicAssessmentFinding.getValue(context);
		}
		public void setPatientGraphicAssessmentFinding(ims.assessment.vo.PatientGraphicAssessmentFindingVo value)
		{
			cx_CorePatientGraphicAssessmentFinding.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientGraphicAssessmentFinding = new ims.framework.ContextVariable("Core.PatientGraphicAssessmentFinding", "_cv_Core.PatientGraphicAssessmentFinding");

		private ims.framework.Context context;
	}

	public AssessmentContext Assessment;
	public CoreContext Core;
}
