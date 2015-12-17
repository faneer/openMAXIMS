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

package ims.ccosched.forms.pattreatmentplanaction;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		CcoSched = new CcoSchedContext(context);
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

		private ims.framework.Context context;
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			TreatmentPlan = new TreatmentPlanContext(context);
			ActionUpdate = new ActionUpdateContext(context);
		}
		public final class TreatmentPlanContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private TreatmentPlanContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActionUpdateModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanActionUpdateMode.getValueIsNull(context);
			}
			public Integer getActionUpdateMode()
			{
				return (Integer)cx_CcoSchedTreatmentPlanActionUpdateMode.getValue(context);
			}
		public void setActionUpdateMode(Integer value)
		{
				cx_CcoSchedTreatmentPlanActionUpdateMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanActionUpdateMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.ActionUpdateMode", "_cv_CcoSched.TreatmentPlan.ActionUpdateMode");
			public boolean getActionModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanActionMode.getValueIsNull(context);
			}
			public Boolean getActionMode()
			{
				return (Boolean)cx_CcoSchedTreatmentPlanActionMode.getValue(context);
			}
		public void setActionMode(Boolean value)
		{
				cx_CcoSchedTreatmentPlanActionMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanActionMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.ActionMode", "_cv_CcoSched.TreatmentPlan.ActionMode");
			private ims.framework.Context context;
		}
		public final class ActionUpdateContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ActionUpdateContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActionInsertedIdIsNotNull()
			{
				return !cx_CcoSchedActionUpdateActionInsertedId.getValueIsNull(context);
			}
			public String getActionInsertedId()
			{
				return (String)cx_CcoSchedActionUpdateActionInsertedId.getValue(context);
			}
		public void setActionInsertedId(String value)
		{
				cx_CcoSchedActionUpdateActionInsertedId.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActionUpdateActionInsertedId = new ims.framework.ContextVariable("CcoSched.ActionUpdate.ActionInsertedId", "_cv_CcoSched.ActionUpdate.ActionInsertedId");
			private ims.framework.Context context;
		}


		public TreatmentPlanContext TreatmentPlan;
		public ActionUpdateContext ActionUpdate;
		private ims.framework.Context context;
	}
	public boolean getPatTreatmentPlanActionIsNotNull()
	{
		return !cx_PatTreatmentPlanAction.getValueIsNull(context);
	}
	public ims.ccosched.vo.PatTreatPlanActionVo getPatTreatmentPlanAction()
	{
		return (ims.ccosched.vo.PatTreatPlanActionVo)cx_PatTreatmentPlanAction.getValue(context);
	}
		public void setPatTreatmentPlanAction(ims.ccosched.vo.PatTreatPlanActionVo value)
		{
		cx_PatTreatmentPlanAction.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PatTreatmentPlanAction = new ims.framework.ContextVariable("PatTreatmentPlanAction", "_cv_PatTreatmentPlanAction");
	public boolean getPatTreatmentPlanIsNotNull()
	{
		return !cx_PatTreatmentPlan.getValueIsNull(context);
	}
	public ims.ccosched.vo.PatTreatmentPlanLiteVo getPatTreatmentPlan()
	{
		return (ims.ccosched.vo.PatTreatmentPlanLiteVo)cx_PatTreatmentPlan.getValue(context);
	}
		public void setPatTreatmentPlan(ims.ccosched.vo.PatTreatmentPlanLiteVo value)
		{
		cx_PatTreatmentPlan.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PatTreatmentPlan = new ims.framework.ContextVariable("PatTreatmentPlan", "_cv_PatTreatmentPlan");

	public CoreContext Core;
	public CcoSchedContext CcoSched;
}
