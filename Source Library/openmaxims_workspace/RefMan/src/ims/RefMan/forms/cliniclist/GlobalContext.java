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

package ims.RefMan.forms.cliniclist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
		Scheduling = new SchedulingContext(context);
		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
		ChooseAndBook = new ChooseAndBookContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getIsClinicalContactStartedIsNotNull()
		{
			return !cx_RefManIsClinicalContactStarted.getValueIsNull(context);
		}
		public Boolean getIsClinicalContactStarted()
		{
			return (Boolean)cx_RefManIsClinicalContactStarted.getValue(context);
		}
		public void setIsClinicalContactStarted(Boolean value)
		{
			cx_RefManIsClinicalContactStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsClinicalContactStarted = new ims.framework.ContextVariable("RefMan.IsClinicalContactStarted", "_cv_RefMan.IsClinicalContactStarted");
		public boolean getIsProviderCancellationIsNotNull()
		{
			return !cx_RefManIsProviderCancellation.getValueIsNull(context);
		}
		public Boolean getIsProviderCancellation()
		{
			return (Boolean)cx_RefManIsProviderCancellation.getValue(context);
		}
		public void setIsProviderCancellation(Boolean value)
		{
			cx_RefManIsProviderCancellation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsProviderCancellation = new ims.framework.ContextVariable("RefMan.IsProviderCancellation", "_cvp_RefMan.IsProviderCancellation");
		public boolean getClinicListFilterIsNotNull()
		{
			return !cx_RefManClinicListFilter.getValueIsNull(context);
		}
		public ims.RefMan.vo.ClinicListFilterVo getClinicListFilter()
		{
			return (ims.RefMan.vo.ClinicListFilterVo)cx_RefManClinicListFilter.getValue(context);
		}
		public void setClinicListFilter(ims.RefMan.vo.ClinicListFilterVo value)
		{
			cx_RefManClinicListFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManClinicListFilter = new ims.framework.ContextVariable("RefMan.ClinicListFilter", "_cvp_RefMan.ClinicListFilter");
		public boolean getIsConsultationStartedIsNotNull()
		{
			return !cx_RefManIsConsultationStarted.getValueIsNull(context);
		}
		public Boolean getIsConsultationStarted()
		{
			return (Boolean)cx_RefManIsConsultationStarted.getValue(context);
		}
		public void setIsConsultationStarted(Boolean value)
		{
			cx_RefManIsConsultationStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsConsultationStarted = new ims.framework.ContextVariable("RefMan.IsConsultationStarted", "_cv_RefMan.IsConsultationStarted");
		public boolean getChosenTimeIsNotNull()
		{
			return !cx_RefManChosenTime.getValueIsNull(context);
		}
		public ims.framework.utils.Time getChosenTime()
		{
			return (ims.framework.utils.Time)cx_RefManChosenTime.getValue(context);
		}
		public void setChosenTime(ims.framework.utils.Time value)
		{
			cx_RefManChosenTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManChosenTime = new ims.framework.ContextVariable("RefMan.ChosenTime", "_cv_RefMan.ChosenTime");
		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_RefManReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_RefManReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_RefManReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralContractTypeForPatient = new ims.framework.ContextVariable("RefMan.ReferralContractTypeForPatient", "_cvp_RefMan.ReferralContractTypeForPatient");
		public boolean getDiagnosticReferralForApplicationIsNotNull()
		{
			return !cx_RefManDiagnosticReferralForApplication.getValueIsNull(context);
		}
		public Boolean getDiagnosticReferralForApplication()
		{
			return (Boolean)cx_RefManDiagnosticReferralForApplication.getValue(context);
		}
		public void setDiagnosticReferralForApplication(Boolean value)
		{
			cx_RefManDiagnosticReferralForApplication.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManDiagnosticReferralForApplication = new ims.framework.ContextVariable("RefMan.DiagnosticReferralForApplication", "_cvp_RefMan.DiagnosticReferralForApplication");
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
		public boolean getSpecimenWorkListItemForReportsIsNotNull()
		{
			return !cx_RefManSpecimenWorkListItemForReports.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenWorkListItemVo getSpecimenWorkListItemForReports()
		{
			return (ims.ocrr.vo.SpecimenWorkListItemVo)cx_RefManSpecimenWorkListItemForReports.getValue(context);
		}
		public void setSpecimenWorkListItemForReports(ims.ocrr.vo.SpecimenWorkListItemVo value)
		{
			cx_RefManSpecimenWorkListItemForReports.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSpecimenWorkListItemForReports = new ims.framework.ContextVariable("RefMan.SpecimenWorkListItemForReports", "_cv_RefMan.SpecimenWorkListItemForReports");
		public boolean getLinkedAppointmentsCollectionIsNotNull()
		{
			return !cx_RefManLinkedAppointmentsCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection getLinkedAppointmentsCollection()
		{
			return (ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection)cx_RefManLinkedAppointmentsCollection.getValue(context);
		}
		public void setLinkedAppointmentsCollection(ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection value)
		{
			cx_RefManLinkedAppointmentsCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManLinkedAppointmentsCollection = new ims.framework.ContextVariable("RefMan.LinkedAppointmentsCollection", "_cv_RefMan.LinkedAppointmentsCollection");

		private ims.framework.Context context;
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBookingAppointmentRefIsNotNull()
		{
			return !cx_SchedulingBookingAppointmentRef.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getBookingAppointmentRef()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_SchedulingBookingAppointmentRef.getValue(context);
		}
		public void setBookingAppointmentRef(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_SchedulingBookingAppointmentRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointmentRef = new ims.framework.ContextVariable("Scheduling.BookingAppointmentRef", "_cv_Scheduling.BookingAppointmentRef");
		public boolean getApptCancelStatusIsNotNull()
		{
			return !cx_SchedulingApptCancelStatus.getValueIsNull(context);
		}
		public ims.scheduling.vo.Appointment_StatusVo getApptCancelStatus()
		{
			return (ims.scheduling.vo.Appointment_StatusVo)cx_SchedulingApptCancelStatus.getValue(context);
		}
		public void setApptCancelStatus(ims.scheduling.vo.Appointment_StatusVo value)
		{
			cx_SchedulingApptCancelStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingApptCancelStatus = new ims.framework.ContextVariable("Scheduling.ApptCancelStatus", "_cv_Scheduling.ApptCancelStatus");
		public boolean getBookingActivityIsNotNull()
		{
			return !cx_SchedulingBookingActivity.getValueIsNull(context);
		}
		public ims.core.resource.place.vo.ActivityRefVo getBookingActivity()
		{
			return (ims.core.resource.place.vo.ActivityRefVo)cx_SchedulingBookingActivity.getValue(context);
		}
		public void setBookingActivity(ims.core.resource.place.vo.ActivityRefVo value)
		{
			cx_SchedulingBookingActivity.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingActivity = new ims.framework.ContextVariable("Scheduling.BookingActivity", "_cv_Scheduling.BookingActivity");
		public boolean getBookingAppointmentIsNotNull()
		{
			return !cx_SchedulingBookingAppointment.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment()
		{
			return (ims.scheduling.vo.Booking_AppointmentVo)cx_SchedulingBookingAppointment.getValue(context);
		}
		public void setBookingAppointment(ims.scheduling.vo.Booking_AppointmentVo value)
		{
			cx_SchedulingBookingAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointment = new ims.framework.ContextVariable("Scheduling.BookingAppointment", "_cv_Scheduling.BookingAppointment");
		public boolean getBookingServiceIsNotNull()
		{
			return !cx_SchedulingBookingService.getValueIsNull(context);
		}
		public ims.core.clinical.vo.ServiceRefVo getBookingService()
		{
			return (ims.core.clinical.vo.ServiceRefVo)cx_SchedulingBookingService.getValue(context);
		}
		public void setBookingService(ims.core.clinical.vo.ServiceRefVo value)
		{
			cx_SchedulingBookingService.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingService = new ims.framework.ContextVariable("Scheduling.BookingService", "_cv_Scheduling.BookingService");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientSummary = new PatientSummaryContext(context);
		}
		public final class PatientSummaryContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientSummaryContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getCareContextIsNotNull()
			{
				return !cx_ClinicalPatientSummaryCareContext.getValueIsNull(context);
			}
			public ims.core.admin.vo.CareContextRefVo getCareContext()
			{
				return (ims.core.admin.vo.CareContextRefVo)cx_ClinicalPatientSummaryCareContext.getValue(context);
			}
		public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
		{
				cx_ClinicalPatientSummaryCareContext.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryCareContext = new ims.framework.ContextVariable("Clinical.PatientSummary.CareContext", "_cv_Clinical.PatientSummary.CareContext");
			private ims.framework.Context context;
		}


		public PatientSummaryContext PatientSummary;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			CurrentCareContext = new CurrentCareContextContext(context);
		}
		public final class CurrentCareContextContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CurrentCareContextContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getContextTypeIsNotNull()
			{
				return !cx_CoreCurrentCareContextContextType.getValueIsNull(context);
			}
			public Integer getContextType()
			{
				return (Integer)cx_CoreCurrentCareContextContextType.getValue(context);
			}
		public void setContextType(Integer value)
		{
				cx_CoreCurrentCareContextContextType.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CoreCurrentCareContextContextType = new ims.framework.ContextVariable("Core.CurrentCareContext.ContextType", "_cvp_Core.CurrentCareContext.ContextType");
			private ims.framework.Context context;
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

		public CurrentCareContextContext CurrentCareContext;
		private ims.framework.Context context;
	}
	public final class ChooseAndBookContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ChooseAndBookContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getisCABApptIsNotNull()
		{
			return !cx_ChooseAndBookisCABAppt.getValueIsNull(context);
		}
		public Boolean getisCABAppt()
		{
			return (Boolean)cx_ChooseAndBookisCABAppt.getValue(context);
		}
		public void setisCABAppt(Boolean value)
		{
			cx_ChooseAndBookisCABAppt.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ChooseAndBookisCABAppt = new ims.framework.ContextVariable("ChooseAndBook.isCABAppt", "_cv_ChooseAndBook.isCABAppt");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
	public SchedulingContext Scheduling;
	public ClinicalContext Clinical;
	public CoreContext Core;
	public ChooseAndBookContext ChooseAndBook;
}
