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

package ims.scheduling.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicListImpl extends DomainImpl implements ims.scheduling.domain.ClinicList, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistSession(ims.core.vo.ServiceShortVo service, ims.core.vo.ServiceFunctionVoCollection functionColl, ims.scheduling.vo.ProfileShortVo profile, ims.framework.utils.Date sessionDate,  ims.scheduling.vo.lookups.ProfileListType listtype)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistService(ims.core.vo.ServiceShortVo serviceShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServiceFunctions(ims.core.vo.ServiceShortVo serviceShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSessionSlots(ims.scheduling.vo.SessionShortVo session, Integer[] sessionIds)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBookingPatient(ims.scheduling.vo.Booking_AppointmentVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProfiles(ims.core.vo.ServiceShortVo service, ims.scheduling.vo.DirectoryOfServiceVo directoryOfService, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatednaAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.RefMan.vo.CatsReferralForClinicListVo catsReferral, ims.chooseandbook.vo.lookups.ActionRequestType requestType, ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo electiveList, Boolean isFirstAppointmentActivity)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelSlot(ims.scheduling.vo.SessionSlotVo sessionSlot, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validatereOpenSlot(ims.scheduling.vo.SessionSlotVo sessionSlot)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistFlexibleBookings(ims.scheduling.vo.Sch_SessionRefVo session)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAppointments(ims.scheduling.vo.Sch_SessionRefVo session, Integer[] sessionIds, ims.scheduling.vo.lookups.Status_Reason apptType)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAppointment(ims.scheduling.vo.Booking_AppointmentVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveCareSpell(ims.core.vo.CareSpellVo voCareSpell)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPASCode(ims.core.vo.ActivityVo activity)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateAndSaveEvent(ims.pathways.configuration.domain.objects.Event event, ims.scheduling.domain.objects.Booking_Appointment appt, ims.pathways.vo.PatientJourneyVo journey)
	{
		if(event == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'event' of type 'ims.pathways.configuration.domain.objects.Event' cannot be null.");
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.domain.objects.Booking_Appointment' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateupdateJourney(ims.scheduling.domain.objects.Booking_Appointment doAppt, Boolean isCancel)
	{
		if(doAppt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'doAppt' of type 'ims.scheduling.domain.objects.Booking_Appointment' cannot be null.");
		if(isCancel == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'isCancel' of type 'Boolean' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesendRequestandUpdateReferences(ims.domain.DomainFactory factory, ims.chooseandbook.vo.lookups.ActionRequestType requestType, ims.domain.DomainObject domObject, String requestSource)
	{
		if(factory == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'factory' of type 'ims.domain.DomainFactory' cannot be null.");
		if(requestType == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'requestType' of type 'ims.chooseandbook.vo.lookups.ActionRequestType' cannot be null.");
		if(domObject == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'domObject' of type 'ims.domain.DomainObject' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetAppointment(ims.scheduling.vo.Session_SlotRefVo sessionSlot)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasTCI(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientElectiveList(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}
}
