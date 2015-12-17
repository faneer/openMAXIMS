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

package ims.ccosched.forms.patientappointmentsdates;

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

		public boolean getTemplateIsNotNull()
		{
			return !cx_CoreTemplate.getValueIsNull(context);
		}
		public String getTemplate()
		{
			return (String)cx_CoreTemplate.getValue(context);
		}
		public void setTemplate(String value)
		{
			cx_CoreTemplate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplate = new ims.framework.ContextVariable("Core.Template", "_cv_Core.Template");

		private ims.framework.Context context;
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			PatientAppointments = new PatientAppointmentsContext(context);
		}
		public final class PatientAppointmentsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientAppointmentsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getApptEndDateIsNotNull()
			{
				return !cx_CcoSchedPatientAppointmentsApptEndDate.getValueIsNull(context);
			}
			public String getApptEndDate()
			{
				return (String)cx_CcoSchedPatientAppointmentsApptEndDate.getValue(context);
			}
		public void setApptEndDate(String value)
		{
				cx_CcoSchedPatientAppointmentsApptEndDate.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedPatientAppointmentsApptEndDate = new ims.framework.ContextVariable("CcoSched.PatientAppointments.ApptEndDate", "_cv_CcoSched.PatientAppointments.ApptEndDate");
			public boolean getApptStartDateIsNotNull()
			{
				return !cx_CcoSchedPatientAppointmentsApptStartDate.getValueIsNull(context);
			}
			public String getApptStartDate()
			{
				return (String)cx_CcoSchedPatientAppointmentsApptStartDate.getValue(context);
			}
		public void setApptStartDate(String value)
		{
				cx_CcoSchedPatientAppointmentsApptStartDate.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedPatientAppointmentsApptStartDate = new ims.framework.ContextVariable("CcoSched.PatientAppointments.ApptStartDate", "_cv_CcoSched.PatientAppointments.ApptStartDate");
			private ims.framework.Context context;
		}


		public PatientAppointmentsContext PatientAppointments;
		private ims.framework.Context context;
	}

	public CoreContext Core;
	public CcoSchedContext CcoSched;
}
