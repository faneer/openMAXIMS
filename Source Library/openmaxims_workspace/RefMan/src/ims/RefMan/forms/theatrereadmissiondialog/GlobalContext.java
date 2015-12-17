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

package ims.RefMan.forms.theatrereadmissiondialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
		Core = new CoreContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");
		public boolean getTheatreAdmitDetailsIsNotNull()
		{
			return !cx_RefManTheatreAdmitDetails.getValueIsNull(context);
		}
		public ims.RefMan.vo.TheatreListBookingDetailVo getTheatreAdmitDetails()
		{
			return (ims.RefMan.vo.TheatreListBookingDetailVo)cx_RefManTheatreAdmitDetails.getValue(context);
		}
		public void setTheatreAdmitDetails(ims.RefMan.vo.TheatreListBookingDetailVo value)
		{
			cx_RefManTheatreAdmitDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManTheatreAdmitDetails = new ims.framework.ContextVariable("RefMan.TheatreAdmitDetails", "_cv_RefMan.TheatreAdmitDetails");
		public boolean getTheatreBookingAppointmentIsNotNull()
		{
			return !cx_RefManTheatreBookingAppointment.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getTheatreBookingAppointment()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_RefManTheatreBookingAppointment.getValue(context);
		}
		public void setTheatreBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_RefManTheatreBookingAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManTheatreBookingAppointment = new ims.framework.ContextVariable("RefMan.TheatreBookingAppointment", "_cv_RefMan.TheatreBookingAppointment");
		public boolean getCatsReferralWizardIsNotNull()
		{
			return !cx_RefManCatsReferralWizard.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralWizardVo getCatsReferralWizard()
		{
			return (ims.RefMan.vo.CatsReferralWizardVo)cx_RefManCatsReferralWizard.getValue(context);
		}
		public void setCatsReferralWizard(ims.RefMan.vo.CatsReferralWizardVo value)
		{
			cx_RefManCatsReferralWizard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferralWizard = new ims.framework.ContextVariable("RefMan.CatsReferralWizard", "_cv_RefMan.CatsReferralWizard");

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

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
	public CoreContext Core;
}
