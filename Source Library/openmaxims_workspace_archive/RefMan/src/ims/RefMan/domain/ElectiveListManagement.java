// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface ElectiveListManagement extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElevectiveListManagementVoCollection getElectiveListEntries(ims.admin.vo.ServiceForElectiveListConfigVo service, String electivelistname, String electivelistcode, ims.core.vo.HcpLiteVo consultant, ims.framework.utils.Date datefrom, ims.framework.utils.Date dateto, ims.core.vo.lookups.WaitingListStatus status, Boolean showAdmitted, Boolean showSuspended, Boolean show28Day, ims.core.vo.ProcedureLiteVo procedure);

	// Generated from form domain interface definition
	public ims.admin.vo.ServiceForElectiveListConfigVoCollection listServices(String name);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listConsultants(String name);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListForTCIDetailsDialogVo save(ims.RefMan.vo.PatientElectiveListForTCIDetailsDialogVo record) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListForTCIDetailsDialogVo getPatientElecticeList(ims.RefMan.vo.PatientElectiveListRefVo record);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralERODWithElectiveOnlyVo getCatsReferralErod(ims.RefMan.vo.CatsReferralRefVo catsRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionServiceAndSlotActivityVo getServiceAndActivityByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt, Boolean isFlexible);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionSlotVo getSessionSlot(ims.scheduling.vo.Session_SlotRefVo slotRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralListVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voReferralRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void updateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void updateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferralForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionShortVo getSessionShortVo(ims.scheduling.vo.Sch_SessionRefVo sessVo);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public void cancelReferralEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo apptRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentTheatreVo getTheatreAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo getTheatreServiceProcedureAndConsultant(ims.scheduling.vo.Booking_AppointmentRefVo voAppt);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralVo getCatsReferralVo(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShortVo(ims.core.admin.vo.EpisodeOfCareRefVo episode);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextShortVo(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	public ims.admin.vo.ElectiveListConfigLiteVoCollection getElectiveListConfigurations(String value);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListDetailsToSaveVo getPatientElectiveListDetailsToSaveVo(ims.RefMan.vo.PatientElectiveListRefVo record);

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureLiteVoCollection listProcedures(String name) throws ims.domain.exceptions.DomainInterfaceException;
}
