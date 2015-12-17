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

package ims.ccosched.forms.treatmentplancomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		CcoSched = new CcoSchedContext(context);
		Core = new CoreContext(context);
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
			public boolean getTreatmentPlanDetailsIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanTreatmentPlanDetails.getValueIsNull(context);
			}
			public ims.dto.client.Go_ptreatpl.Go_ptreatplRecord getTreatmentPlanDetails()
			{
				return (ims.dto.client.Go_ptreatpl.Go_ptreatplRecord)cx_CcoSchedTreatmentPlanTreatmentPlanDetails.getValue(context);
			}
		public void setTreatmentPlanDetails(ims.dto.client.Go_ptreatpl.Go_ptreatplRecord value)
		{
				cx_CcoSchedTreatmentPlanTreatmentPlanDetails.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanTreatmentPlanDetails = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.TreatmentPlanDetails", "_cv_CcoSched.TreatmentPlan.TreatmentPlanDetails");
			public boolean getAnaestheticIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanAnaesthetic.getValueIsNull(context);
			}
			public ims.dto.client.Lkup getAnaesthetic()
			{
				return (ims.dto.client.Lkup)cx_CcoSchedTreatmentPlanAnaesthetic.getValue(context);
			}
		public void setAnaesthetic(ims.dto.client.Lkup value)
		{
				cx_CcoSchedTreatmentPlanAnaesthetic.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanAnaesthetic = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.Anaesthetic", "_cv_CcoSched.TreatmentPlan.Anaesthetic");
			public boolean getTechniqueIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanTechnique.getValueIsNull(context);
			}
			public ims.dto.client.Lkup getTechnique()
			{
				return (ims.dto.client.Lkup)cx_CcoSchedTreatmentPlanTechnique.getValue(context);
			}
		public void setTechnique(ims.dto.client.Lkup value)
		{
				cx_CcoSchedTreatmentPlanTechnique.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanTechnique = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.Technique", "_cv_CcoSched.TreatmentPlan.Technique");
			private ims.framework.Context context;
		}
		public final class ActionUpdateContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ActionUpdateContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getTreatmentPlanActionsIsNotNull()
			{
				return !cx_CcoSchedActionUpdateTreatmentPlanActions.getValueIsNull(context);
			}
			public ims.ccosched.vo.PatTreatPlanActionVoCollection getTreatmentPlanActions()
			{
				return (ims.ccosched.vo.PatTreatPlanActionVoCollection)cx_CcoSchedActionUpdateTreatmentPlanActions.getValue(context);
			}
		public void setTreatmentPlanActions(ims.ccosched.vo.PatTreatPlanActionVoCollection value)
		{
				cx_CcoSchedActionUpdateTreatmentPlanActions.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActionUpdateTreatmentPlanActions = new ims.framework.ContextVariable("CcoSched.ActionUpdate.TreatmentPlanActions", "_cv_CcoSched.ActionUpdate.TreatmentPlanActions");
			private ims.framework.Context context;
		}


		public TreatmentPlanContext TreatmentPlan;
		public ActionUpdateContext ActionUpdate;
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
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
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

	public CcoSchedContext CcoSched;
	public CoreContext Core;
}
