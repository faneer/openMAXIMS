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

package ims.scheduling.domain;

// Generated from form domain impl
public interface ClinicList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionShortVoCollection listSession(ims.core.vo.ServiceShortVo service, ims.core.vo.ServiceFunctionVoCollection functionColl, ims.scheduling.vo.ProfileShortVo profile, ims.framework.utils.Date sessionDate,  ims.scheduling.vo.lookups.ProfileListType listtype);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceShortVoCollection listService(ims.core.vo.ServiceShortVo serviceShort);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceFunctionVoCollection listServiceFunctions(ims.core.vo.ServiceShortVo serviceShort);

	// Generated from form domain interface definition
	/**
	* one of the parameters can only be used at any time
	*/
	public ims.scheduling.vo.SessionSlotVoCollection listSessionSlots(ims.scheduling.vo.SessionShortVo session, Integer[] sessionIds);

	// Generated from form domain interface definition
	/**
	* retrieve the patient for this appt through the parent Sch_Booking
	*/
	public ims.core.vo.PatientShort getBookingPatient(ims.scheduling.vo.Booking_AppointmentVo appointment);

	// Generated from form domain interface definition
	/**
	* Lists all profiles
	*/
	public ims.scheduling.vo.ProfileShortVoCollection listProfiles(ims.core.vo.ServiceShortVo service, ims.scheduling.vo.DirectoryOfServiceVo directoryOfService, Boolean activeOnly);

	// Generated from form domain interface definition
	public void dnaAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.RefMan.vo.CatsReferralForClinicListVo catsReferral, ims.chooseandbook.vo.lookups.ActionRequestType requestType, ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo electiveList, Boolean isFirstAppointmentActivity) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void cancelSlot(ims.scheduling.vo.SessionSlotVo sessionSlot, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void reOpenSlot(ims.scheduling.vo.SessionSlotVo sessionSlot) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* listFlexibleBookings
	*/
	public ims.scheduling.vo.Sch_BookingVoCollection listFlexibleBookings(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.scheduling.vo.SessionSlotVoCollection listAppointments(ims.scheduling.vo.Sch_SessionRefVo session, Integer[] sessionIds, ims.scheduling.vo.lookups.Status_Reason apptType);

	// Generated from form domain interface definition
	/**
	* saveAppointment
	*/
	public void saveAppointment(ims.scheduling.vo.Booking_AppointmentVo appt) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVo saveCareSpell(ims.core.vo.CareSpellVo voCareSpell) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getPASCode
	*/
	public ims.core.vo.lookups.ContextType getPASCode(ims.core.vo.ActivityVo activity);

	// Generated from form domain interface definition
	/**
	* createAndSaveEvent - Pathways Event - after call has been made add resulting patient event to collection of patient events hanging off appointment
	*/
	public ims.pathways.vo.PatientEventVo createAndSaveEvent(ims.pathways.configuration.domain.objects.Event event, ims.scheduling.domain.objects.Booking_Appointment appt, ims.pathways.vo.PatientJourneyVo journey) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateJourney - get the journey associated with appt if any and create an event for the status from the config if any
	*/
	public void updateJourney(ims.scheduling.domain.objects.Booking_Appointment doAppt, Boolean isCancel) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Communicates with CabGW interface
	*/
	public ims.scheduling.domain.objects.Booking_Appointment sendRequestandUpdateReferences(ims.domain.DomainFactory factory, ims.chooseandbook.vo.lookups.ActionRequestType requestType, ims.domain.DomainObject domObject, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getAppointment(ims.scheduling.vo.Session_SlotRefVo sessionSlot);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForClinicListVo getCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public Boolean hasTCI(ims.scheduling.vo.Booking_AppointmentRefVo appointment);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo getPatientElectiveList(ims.scheduling.vo.Booking_AppointmentRefVo appointment);
}
