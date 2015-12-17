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

package ims.core.forms.pendingemergencyadmissions;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		STHK = new STHKContext(context);
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
		public boolean getADTPendingEmergencyAdmissionIsNotNull()
		{
			return !cx_CoreADTPendingEmergencyAdmission.getValueIsNull(context);
		}
		public ims.core.vo.PendingEmergencyAdmissionLiteVo getADTPendingEmergencyAdmission()
		{
			return (ims.core.vo.PendingEmergencyAdmissionLiteVo)cx_CoreADTPendingEmergencyAdmission.getValue(context);
		}
		public void setADTPendingEmergencyAdmission(ims.core.vo.PendingEmergencyAdmissionLiteVo value)
		{
			cx_CoreADTPendingEmergencyAdmission.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTPendingEmergencyAdmission = new ims.framework.ContextVariable("Core.ADTPendingEmergencyAdmission", "_cv_Core.ADTPendingEmergencyAdmission");
		public boolean getPatientToBeDisplayedIsNotNull()
		{
			return !cx_CorePatientToBeDisplayed.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientToBeDisplayed()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientToBeDisplayed.getValue(context);
		}
		public void setPatientToBeDisplayed(ims.core.vo.PatientShort value)
		{
			cx_CorePatientToBeDisplayed.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientToBeDisplayed = new ims.framework.ContextVariable("Core.PatientToBeDisplayed", "_cv_Core.PatientToBeDisplayed");
		public boolean getSelectingPatientFormIsNotNull()
		{
			return !cx_CoreSelectingPatientForm.getValueIsNull(context);
		}
		public ims.framework.FormName getSelectingPatientForm()
		{
			return (ims.framework.FormName)cx_CoreSelectingPatientForm.getValue(context);
		}
		public void setSelectingPatientForm(ims.framework.FormName value)
		{
			cx_CoreSelectingPatientForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectingPatientForm = new ims.framework.ContextVariable("Core.SelectingPatientForm", "_cvp_Core.SelectingPatientForm");

		private ims.framework.Context context;
	}
	public final class STHKContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private STHKContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPendingEmergencyAdmissionsFilterIsNotNull()
		{
			return !cx_STHKPendingEmergencyAdmissionsFilter.getValueIsNull(context);
		}
		public ims.core.vo.PendingEmergencyAdmissionsDataVo getPendingEmergencyAdmissionsFilter()
		{
			return (ims.core.vo.PendingEmergencyAdmissionsDataVo)cx_STHKPendingEmergencyAdmissionsFilter.getValue(context);
		}
		public void setPendingEmergencyAdmissionsFilter(ims.core.vo.PendingEmergencyAdmissionsDataVo value)
		{
			cx_STHKPendingEmergencyAdmissionsFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_STHKPendingEmergencyAdmissionsFilter = new ims.framework.ContextVariable("STHK.PendingEmergencyAdmissionsFilter", "_cvp_STHK.PendingEmergencyAdmissionsFilter");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public STHKContext STHK;
}
