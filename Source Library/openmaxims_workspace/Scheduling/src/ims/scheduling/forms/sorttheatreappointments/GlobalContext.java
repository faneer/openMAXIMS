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

package ims.scheduling.forms.sorttheatreappointments;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Scheduling = new SchedulingContext(context);
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAppointmentIdsIsNotNull()
		{
			return !cx_SchedulingAppointmentIds.getValueIsNull(context);
		}
		public java.util.ArrayList getAppointmentIds()
		{
			return (java.util.ArrayList)cx_SchedulingAppointmentIds.getValue(context);
		}

		private ims.framework.ContextVariable cx_SchedulingAppointmentIds = new ims.framework.ContextVariable("Scheduling.AppointmentIds", "_cv_Scheduling.AppointmentIds");
		public boolean getTheatreSessionIsNotNull()
		{
			return !cx_SchedulingTheatreSession.getValueIsNull(context);
		}
		public ims.scheduling.vo.Sch_SessionRefVo getTheatreSession()
		{
			return (ims.scheduling.vo.Sch_SessionRefVo)cx_SchedulingTheatreSession.getValue(context);
		}

		private ims.framework.ContextVariable cx_SchedulingTheatreSession = new ims.framework.ContextVariable("Scheduling.TheatreSession", "_cv_Scheduling.TheatreSession");

		private ims.framework.Context context;
	}

	public SchedulingContext Scheduling;
}
