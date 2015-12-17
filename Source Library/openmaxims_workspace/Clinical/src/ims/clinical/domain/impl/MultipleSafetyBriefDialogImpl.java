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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.AcuteTheatreList;
import ims.clinical.domain.base.impl.BaseMultipleSafetyBriefDialogImpl;
import ims.clinical.domain.objects.PeriOpSafetyBriefTime;
import ims.clinical.vo.AcuteTheatreListBookingAppointmentVo;
import ims.clinical.vo.AcuteTheatreListBookingAppointmentVoCollection;
import ims.clinical.vo.PeriOpSafetyBriefTimeVo;
import ims.clinical.vo.domain.PeriOpSafetyBriefTimeVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.domain.objects.TheatreBooking;
import ims.scheduling.vo.TheatreBookingRefVo;
import ims.scheduling.vo.lookups.AcuteTheateListBookingState;

import java.util.List;

public class MultipleSafetyBriefDialogImpl extends BaseMultipleSafetyBriefDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * Save Safety Briefs and Update Theatre Booking States
	 */
	public void saveSafetyBriefs(ims.clinical.vo.PeriOpSafetyBriefTimeVoCollection safetyBriefs) throws ims.domain.exceptions.StaleObjectException,UniqueKeyViolationException
	{
		String methodName = "saveSafetyBriefs";
		if (safetyBriefs == null)
			throw new CodingRuntimeException("safetyBriefs is null in method " + methodName);

		DomainFactory factory = getDomainFactory();

		for (PeriOpSafetyBriefTimeVo safetyBrief : safetyBriefs)
		{
			PeriOpSafetyBriefTime doSafetyBrief = PeriOpSafetyBriefTimeVoAssembler.extractPeriOpSafetyBriefTime(factory, safetyBrief);
			factory.save(doSafetyBrief);
			saveBookingState(factory, getTheatreBookingRef(factory, safetyBrief), AcuteTheateListBookingState.SAFETY_BRIEF);
		}
	}

	private TheatreBookingRefVo getTheatreBookingRef(DomainFactory factory, PeriOpSafetyBriefTimeVo safetyBrief)
	{
		String hql = "select appt.theatreBooking from Booking_Appointment appt where appt.id = " + safetyBrief.getTheatreAppointment().getID_Booking_Appointment();
		List data = factory.find(hql);

		if (data.size() == 1)
		{
			return new TheatreBookingRefVo(((TheatreBooking) data.get(0)).getId(), 0);
		}
		return null;
	}

	private void saveBookingState(DomainFactory factory, TheatreBookingRefVo theatreBooking, AcuteTheateListBookingState state) throws StaleObjectException
	{
		TheatreBooking doTheatreBooking = (TheatreBooking) factory.getDomainObject(theatreBooking);
		doTheatreBooking.setState(factory.getLookupInstance(state.getID()));
		factory.save(doTheatreBooking);
	}

	@Override
	public AcuteTheatreListBookingAppointmentVoCollection filterAlreadySafetyBriefedAppointments(AcuteTheatreListBookingAppointmentVoCollection appointments)
	{
		if (appointments == null)
			throw new CodingRuntimeException("appointments is null in method filterAlreadySafetyBriefedAppointments");

		AcuteTheatreListBookingAppointmentVoCollection availableAppointments = new AcuteTheatreListBookingAppointmentVoCollection();

		AcuteTheatreList impl = (AcuteTheatreList) getDomainImpl(AcuteTheatreListImpl.class);
		for (AcuteTheatreListBookingAppointmentVo appt : appointments)
		{
			if (impl.getSafetyBriefByAppointment(appt) == null)
				availableAppointments.add(appt);
		}

		return availableAppointments;
	}
}
