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

package ims.emergency.forms.sendtoareadialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Emergency = new EmergencyContext(context);
		Core = new CoreContext(context);
	}
	public final class EmergencyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EmergencyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTrackingAreaForSendToAreaVoIsNotNull()
		{
			return !cx_EmergencyTrackingAreaForSendToAreaVo.getValueIsNull(context);
		}
		public ims.emergency.vo.TrackingAreaVo getTrackingAreaForSendToAreaVo()
		{
			return (ims.emergency.vo.TrackingAreaVo)cx_EmergencyTrackingAreaForSendToAreaVo.getValue(context);
		}
		public void setTrackingAreaForSendToAreaVo(ims.emergency.vo.TrackingAreaVo value)
		{
			cx_EmergencyTrackingAreaForSendToAreaVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTrackingAreaForSendToAreaVo = new ims.framework.ContextVariable("Emergency.TrackingAreaForSendToAreaVo", "_cv_Emergency.TrackingAreaForSendToAreaVo");
		public boolean getTrackingIsNotNull()
		{
			return !cx_EmergencyTracking.getValueIsNull(context);
		}
		public ims.emergency.vo.TrackingRefVo getTracking()
		{
			return (ims.emergency.vo.TrackingRefVo)cx_EmergencyTracking.getValue(context);
		}
		public void setTracking(ims.emergency.vo.TrackingRefVo value)
		{
			cx_EmergencyTracking.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTracking = new ims.framework.ContextVariable("Emergency.Tracking", "_cv_Emergency.Tracking");
		public boolean getDisplayTriageEndTimeIsNotNull()
		{
			return !cx_EmergencyDisplayTriageEndTime.getValueIsNull(context);
		}
		public Boolean getDisplayTriageEndTime()
		{
			return (Boolean)cx_EmergencyDisplayTriageEndTime.getValue(context);
		}
		public void setDisplayTriageEndTime(Boolean value)
		{
			cx_EmergencyDisplayTriageEndTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyDisplayTriageEndTime = new ims.framework.ContextVariable("Emergency.DisplayTriageEndTime", "_cv_Emergency.DisplayTriageEndTime");
		public boolean getStartTriageDateTimeIsNotNull()
		{
			return !cx_EmergencyStartTriageDateTime.getValueIsNull(context);
		}
		public ims.framework.utils.DateTime getStartTriageDateTime()
		{
			return (ims.framework.utils.DateTime)cx_EmergencyStartTriageDateTime.getValue(context);
		}
		public void setStartTriageDateTime(ims.framework.utils.DateTime value)
		{
			cx_EmergencyStartTriageDateTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyStartTriageDateTime = new ims.framework.ContextVariable("Emergency.StartTriageDateTime", "_cv_Emergency.StartTriageDateTime");
		public boolean getAmbulanceDetailsIsNotNull()
		{
			return !cx_EmergencyAmbulanceDetails.getValueIsNull(context);
		}
		public ims.emergency.vo.AmbulanceDetailsVo getAmbulanceDetails()
		{
			return (ims.emergency.vo.AmbulanceDetailsVo)cx_EmergencyAmbulanceDetails.getValue(context);
		}
		public void setAmbulanceDetails(ims.emergency.vo.AmbulanceDetailsVo value)
		{
			cx_EmergencyAmbulanceDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyAmbulanceDetails = new ims.framework.ContextVariable("Emergency.AmbulanceDetails", "_cv_Emergency.AmbulanceDetails");
		public boolean getTriageCompletedDateTimeIsNotNull()
		{
			return !cx_EmergencyTriageCompletedDateTime.getValueIsNull(context);
		}
		public ims.framework.utils.DateTime getTriageCompletedDateTime()
		{
			return (ims.framework.utils.DateTime)cx_EmergencyTriageCompletedDateTime.getValue(context);
		}
		public void setTriageCompletedDateTime(ims.framework.utils.DateTime value)
		{
			cx_EmergencyTriageCompletedDateTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTriageCompletedDateTime = new ims.framework.ContextVariable("Emergency.TriageCompletedDateTime", "_cv_Emergency.TriageCompletedDateTime");

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
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
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
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}
		public void setEpisodeofCareShort(ims.core.vo.EpisodeofCareShortVo value)
		{
			cx_CoreEpisodeofCareShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");

		private ims.framework.Context context;
	}

	public EmergencyContext Emergency;
	public CoreContext Core;
}
