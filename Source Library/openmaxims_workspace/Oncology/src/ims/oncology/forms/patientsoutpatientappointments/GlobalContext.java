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

package ims.oncology.forms.patientsoutpatientappointments;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Oncology = new OncologyContext(context);
		Core = new CoreContext(context);
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getChosenOPAppointmentIsNotNull()
		{
			return !cx_OncologyChosenOPAppointment.getValueIsNull(context);
		}
		public ims.core.vo.OutPatientAttendanceVo getChosenOPAppointment()
		{
			return (ims.core.vo.OutPatientAttendanceVo)cx_OncologyChosenOPAppointment.getValue(context);
		}
		public void setChosenOPAppointment(ims.core.vo.OutPatientAttendanceVo value)
		{
			cx_OncologyChosenOPAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyChosenOPAppointment = new ims.framework.ContextVariable("Oncology.ChosenOPAppointment", "_cv_Oncology.ChosenOPAppointment");
		public boolean getChosenCCOOPAppointmentIsNotNull()
		{
			return !cx_OncologyChosenCCOOPAppointment.getValueIsNull(context);
		}
		public ims.core.vo.PatientApptDiaryVo getChosenCCOOPAppointment()
		{
			return (ims.core.vo.PatientApptDiaryVo)cx_OncologyChosenCCOOPAppointment.getValue(context);
		}
		public void setChosenCCOOPAppointment(ims.core.vo.PatientApptDiaryVo value)
		{
			cx_OncologyChosenCCOOPAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyChosenCCOOPAppointment = new ims.framework.ContextVariable("Oncology.ChosenCCOOPAppointment", "_cv_Oncology.ChosenCCOOPAppointment");

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

	public OncologyContext Oncology;
	public CoreContext Core;
}
