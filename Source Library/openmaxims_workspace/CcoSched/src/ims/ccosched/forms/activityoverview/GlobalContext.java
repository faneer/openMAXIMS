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

package ims.ccosched.forms.activityoverview;

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

			ActivityView = new ActivityViewContext(context);
			Booking = new BookingContext(context);
		}
		public final class ActivityViewContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ActivityViewContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActivitiesIsNotNull()
			{
				return !cx_CcoSchedActivityViewActivities.getValueIsNull(context);
			}
			public ims.dto.client.Sd_activity getActivities()
			{
				return (ims.dto.client.Sd_activity)cx_CcoSchedActivityViewActivities.getValue(context);
			}
		public void setActivities(ims.dto.client.Sd_activity value)
		{
				cx_CcoSchedActivityViewActivities.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActivityViewActivities = new ims.framework.ContextVariable("CcoSched.ActivityView.Activities", "_cv_CcoSched.ActivityView.Activities");
			public boolean getActivityGroupsIsNotNull()
			{
				return !cx_CcoSchedActivityViewActivityGroups.getValueIsNull(context);
			}
			public ims.dto.client.Sd_activity_grp getActivityGroups()
			{
				return (ims.dto.client.Sd_activity_grp)cx_CcoSchedActivityViewActivityGroups.getValue(context);
			}
		public void setActivityGroups(ims.dto.client.Sd_activity_grp value)
		{
				cx_CcoSchedActivityViewActivityGroups.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActivityViewActivityGroups = new ims.framework.ContextVariable("CcoSched.ActivityView.ActivityGroups", "_cv_CcoSched.ActivityView.ActivityGroups");
			private ims.framework.Context context;
		}
		public final class BookingContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private BookingContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectedDateIsNotNull()
			{
				return !cx_CcoSchedBookingSelectedDate.getValueIsNull(context);
			}
			public ims.framework.utils.Date getSelectedDate()
			{
				return (ims.framework.utils.Date)cx_CcoSchedBookingSelectedDate.getValue(context);
			}
		public void setSelectedDate(ims.framework.utils.Date value)
		{
				cx_CcoSchedBookingSelectedDate.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedBookingSelectedDate = new ims.framework.ContextVariable("CcoSched.Booking.SelectedDate", "_cv_CcoSched.Booking.SelectedDate");
			public boolean getSessionDetailsIdIsNotNull()
			{
				return !cx_CcoSchedBookingSessionDetailsId.getValueIsNull(context);
			}
			public String getSessionDetailsId()
			{
				return (String)cx_CcoSchedBookingSessionDetailsId.getValue(context);
			}
		public void setSessionDetailsId(String value)
		{
				cx_CcoSchedBookingSessionDetailsId.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedBookingSessionDetailsId = new ims.framework.ContextVariable("CcoSched.Booking.SessionDetailsId", "_cv_CcoSched.Booking.SessionDetailsId");
			public boolean getSessionIdIsNotNull()
			{
				return !cx_CcoSchedBookingSessionId.getValueIsNull(context);
			}
			public String getSessionId()
			{
				return (String)cx_CcoSchedBookingSessionId.getValue(context);
			}
		public void setSessionId(String value)
		{
				cx_CcoSchedBookingSessionId.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedBookingSessionId = new ims.framework.ContextVariable("CcoSched.Booking.SessionId", "_cv_CcoSched.Booking.SessionId");
			private ims.framework.Context context;
		}


		public ActivityViewContext ActivityView;
		public BookingContext Booking;
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

	public CcoSchedContext CcoSched;
	public CoreContext Core;
}
