// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.booktheatreslotdetaildialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Scheduling = new SchedulingContext(context);
		Core = new CoreContext(context);
		RefMan = new RefManContext(context);
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSch_BookingTheatreIsNotNull()
		{
			return !cx_SchedulingSch_BookingTheatre.getValueIsNull(context);
		}
		public ims.scheduling.vo.Sch_BookingTheatreVo getSch_BookingTheatre()
		{
			return (ims.scheduling.vo.Sch_BookingTheatreVo)cx_SchedulingSch_BookingTheatre.getValue(context);
		}
		public void setSch_BookingTheatre(ims.scheduling.vo.Sch_BookingTheatreVo value)
		{
			cx_SchedulingSch_BookingTheatre.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSch_BookingTheatre = new ims.framework.ContextVariable("Scheduling.Sch_BookingTheatre", "_cv_Scheduling.Sch_BookingTheatre");
		public boolean getBookTheatreSlotDialogDataIsNotNull()
		{
			return !cx_SchedulingBookTheatreSlotDialogData.getValueIsNull(context);
		}
		public ims.scheduling.vo.BookTheatreSlotDialogVo getBookTheatreSlotDialogData()
		{
			return (ims.scheduling.vo.BookTheatreSlotDialogVo)cx_SchedulingBookTheatreSlotDialogData.getValue(context);
		}
		public void setBookTheatreSlotDialogData(ims.scheduling.vo.BookTheatreSlotDialogVo value)
		{
			cx_SchedulingBookTheatreSlotDialogData.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookTheatreSlotDialogData = new ims.framework.ContextVariable("Scheduling.BookTheatreSlotDialogData", "_cv_Scheduling.BookTheatreSlotDialogData");
		public boolean getAppointmentIdsIsNotNull()
		{
			return !cx_SchedulingAppointmentIds.getValueIsNull(context);
		}
		public java.util.ArrayList getAppointmentIds()
		{
			return (java.util.ArrayList)cx_SchedulingAppointmentIds.getValue(context);
		}
		public void setAppointmentIds(java.util.ArrayList value)
		{
			cx_SchedulingAppointmentIds.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingAppointmentIds = new ims.framework.ContextVariable("Scheduling.AppointmentIds", "_cv_Scheduling.AppointmentIds");

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
		public boolean getSelectedPatientElectiveListIsNotNull()
		{
			return !cx_RefManSelectedPatientElectiveList.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientElectiveListVo getSelectedPatientElectiveList()
		{
			return (ims.RefMan.vo.PatientElectiveListVo)cx_RefManSelectedPatientElectiveList.getValue(context);
		}
		public void setSelectedPatientElectiveList(ims.RefMan.vo.PatientElectiveListVo value)
		{
			cx_RefManSelectedPatientElectiveList.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSelectedPatientElectiveList = new ims.framework.ContextVariable("RefMan.SelectedPatientElectiveList", "_cv_RefMan.SelectedPatientElectiveList");
		public boolean getSelectedWaitingListConfigIsNotNull()
		{
			return !cx_RefManSelectedWaitingListConfig.getValueIsNull(context);
		}
		public ims.admin.vo.ElectiveListConfigurationVo getSelectedWaitingListConfig()
		{
			return (ims.admin.vo.ElectiveListConfigurationVo)cx_RefManSelectedWaitingListConfig.getValue(context);
		}
		public void setSelectedWaitingListConfig(ims.admin.vo.ElectiveListConfigurationVo value)
		{
			cx_RefManSelectedWaitingListConfig.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSelectedWaitingListConfig = new ims.framework.ContextVariable("RefMan.SelectedWaitingListConfig", "_cv_RefMan.SelectedWaitingListConfig");
		public boolean getReferralERODIsNotNull()
		{
			return !cx_RefManReferralEROD.getValueIsNull(context);
		}
		public ims.RefMan.vo.ReferralERODVo getReferralEROD()
		{
			return (ims.RefMan.vo.ReferralERODVo)cx_RefManReferralEROD.getValue(context);
		}
		public void setReferralEROD(ims.RefMan.vo.ReferralERODVo value)
		{
			cx_RefManReferralEROD.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralEROD = new ims.framework.ContextVariable("RefMan.ReferralEROD", "_cv_RefMan.ReferralEROD");

		private ims.framework.Context context;
	}

	public SchedulingContext Scheduling;
	public CoreContext Core;
	public RefManContext RefMan;
}
