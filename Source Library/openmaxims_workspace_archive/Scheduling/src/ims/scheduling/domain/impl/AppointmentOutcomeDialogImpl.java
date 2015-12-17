//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3324.28499)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.domain.AppointmentOutcomeConfig;
import ims.admin.domain.impl.AppointmentOutcomeConfigImpl;
import ims.admin.vo.AppointmentOutcomeConfigVo;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.PatientElectiveListDetailsToSaveVo;
import ims.RefMan.vo.PatientProcedureForAppointmentOutcomeVo;
import ims.RefMan.vo.domain.PatientElectiveListDetailsToSaveVoAssembler;
import ims.RefMan.vo.domain.PatientProcedureForAppointmentOutcomeVoAssembler;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.clinical.vo.PatientDiagnosisOpNotesVo;
import ims.clinical.vo.domain.PatientDiagnosisOpNotesVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.lookups.TaxonomyType;
import ims.core.vo.lookups.WaitingListStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.configuration.vo.TargetRefVo;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.domain.objects.RTTStatusEventMap;
import ims.pathways.vo.EventLiteVo;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.RTTStatusPointVo;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTStatusEventMapVoAssembler;
import ims.pathways.vo.domain.RTTStatusPointVoAssembler;
import ims.pathways.vo.lookups.EventEncounterType;
import ims.pathways.vo.lookups.EventStatus;
import ims.scheduling.domain.BookAppointment;
import ims.scheduling.domain.base.impl.BaseAppointmentOutcomeDialogImpl;
import ims.scheduling.domain.objects.Appointment_Status;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.BookingAppointmentOutcomeVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.domain.BookingAppointmentOutcomeVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.lookups.ApptOutcome;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AppointmentOutcomeDialogImpl extends BaseAppointmentOutcomeDialogImpl
{
	private static final long serialVersionUID = 1L;
	
	private RTTStatusEventMapVo getRTTStatusEventMapByEncounter(ApptOutcome apptOutcome)
	{
		String query = "select rttMap from RTTStatusEventMap as rttMap left join rttMap.encounterType as encType left join rttMap.encounterInstance as encInstance where encType.id = :EncounterType and encInstance.id = :EncounterInstance and rttMap.active = 1";
		List<?> listRTTMap = getDomainFactory().find(query, new String[] {"EncounterType", "EncounterInstance"}, new Object[] {EventEncounterType.CLINICAL_APPOINTMENT.getID(), apptOutcome.getID()});
		
		if(listRTTMap != null && listRTTMap.size() > 0 && listRTTMap.get(0) instanceof RTTStatusEventMap)
		{
			return RTTStatusEventMapVoAssembler.create((RTTStatusEventMap) listRTTMap.get(0));
		}
		
		return null;
	}

	private int getNumberOfClocks(Set clockHistory)
	{
		int X = 0;
		
		if(clockHistory == null || clockHistory.size() == 0)
			return ++X;
		
		Iterator iterator = clockHistory.iterator();
		while(iterator.hasNext()) 
		{
			X++;
			iterator.next();
		}
		
		return ++X;
	}

	/**
	* getBookingAppointment
	*/
	public ims.scheduling.vo.BookingAppointmentOutcomeVo getBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided in method getBookingAppointment");
		
		return BookingAppointmentOutcomeVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(appt));
	}

	//WDEV-18083
	public Boolean thereAreActivePatientElectiveListsForCurrentCatsReferral(CatsReferralRefVo catsRef)
	{
		if (catsRef == null || catsRef.getID_CatsReferral() == null)
			throw new CodingRuntimeException("catsRef is null");
		
		StringBuilder hqlBuilder = new StringBuilder("select pel from PatientElectiveList as pel left join pel.referral as cats left join pel.electiveListStatus as els left join els.electiveListStatus as status where cats.id=:CATS_ID and (status is null or status.id <> :STATUS)");
		List <?> list = getDomainFactory().find(hqlBuilder.toString(),new String[]{"CATS_ID","STATUS"},new Object[]{catsRef.getID_CatsReferral(),WaitingListStatus.REMOVED.getID()} );
		
		if (list == null || list.size() == 0)
			return false;
		
		return true;
	}

	public Boolean isCurrentPathwayClockActive(Booking_AppointmentRefVo bookAppointment)
	{
		if(bookAppointment == null || bookAppointment.getID_Booking_Appointment() == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select catsClock from CatsReferral as cats left join cats.appointments as appts left join cats.journey as catsJourney left join catsJourney.currentClock as catsClock where appts.id = :BookAppointment";
		List<?> currentClockList = factory.find(query, new String[] {"BookAppointment"}, new Object[] {bookAppointment.getID_Booking_Appointment()});
		
		if(currentClockList == null || currentClockList.size() == 0 || currentClockList.get(0) == null)
			return false;
		
		if(currentClockList.get(0) instanceof PathwayClock)
		{
			PathwayClock currentClock = (PathwayClock) currentClockList.get(0);
			
			if(currentClock.getStopDate() != null)
				return false;
		}
		
		return true;
	}

	public void saveBookingAppointment(BookingAppointmentOutcomeVo appt, PatientElectiveListDetailsToSaveVo patientElectiveListToSave, EventLiteVo firstDefinitiveTreatmentEvent) throws DomainInterfaceException, StaleObjectException 
	{
		if (appt == null)
			throw new CodingRuntimeException("appt is null in method saveBookingAppointment");
		if (!appt.isValidated())
			throw new CodingRuntimeException("appt has not been validated in method saveBookingAppointment");
		
		DomainFactory factory = getDomainFactory();
		
		Booking_Appointment previuosVersionOfAppt = (Booking_Appointment) factory.getDomainObject(Booking_Appointment.class, appt.getID_Booking_Appointment());
		LookupInstance previousVersionOfOutcome = previuosVersionOfAppt.getOutcome();
		Boolean previousVersionOfFirstDefinitiveTreatment = previuosVersionOfAppt.isWasFirstDefinitiveTreatment();
		
		Booking_Appointment doAppt = BookingAppointmentOutcomeVoAssembler.extractBooking_Appointment(getDomainFactory(), appt);
		
		boolean isOutcomeSavedForFirstTime = previousVersionOfOutcome == null && doAppt.getOutcome() != null;
		boolean isFirstDefinitiveTreatmentSavedForFirstTime =  (previousVersionOfFirstDefinitiveTreatment == null || Boolean.FALSE.equals(previousVersionOfFirstDefinitiveTreatment)) && Boolean.TRUE.equals(doAppt.isWasFirstDefinitiveTreatment());
		
		Appointment_Status doStatus = new Appointment_Status();
		doStatus.setStatus(doAppt.getApptStatus());
		doStatus.setApptDate(doAppt.getAppointmentDate());
		doStatus.setApptTime(doAppt.getApptStartTime());
		doAppt.getApptStatusHistory().add(doStatus);
		
		factory.save(doAppt);
		
		
		// WDEV-15944 Is it possible to create a pathway event based on this booking?
		if (ConfigFlag.DOM.INSTANTIATE_EVENT_FROM_SCHEDULING.getValue())
		{
			BookAppointment impl = (BookAppointment) getDomainImpl(BookAppointmentImpl.class);
			impl.instantiateEvent(Booking_AppointmentVoAssembler.create(doAppt), "A", "Recorded on Appointment Outcome Dialog");
		}

		//WDEV-18083
		if (patientElectiveListToSave!=null)
		{
			PatientElectiveList domPatientElectiveList = PatientElectiveListDetailsToSaveVoAssembler.extractPatientElectiveList(factory, patientElectiveListToSave);//WDEV-18345
			factory.save(domPatientElectiveList);
		}
		
		CatsReferral doCats = null;
		
		String query = "select cats from CatsReferral as cats left join cats.appointments as appts where appts.id = :BookAppointment";
		List<?> doCatsList = factory.find(query, new String[] {"BookAppointment"}, new Object[] {appt.getID_Booking_Appointment()});
		
		if(doCatsList == null || doCatsList.size() == 0 || doCatsList.get(0) == null)
			return;
		
		if(doCatsList.get(0) instanceof CatsReferral)
		{
			doCats = (CatsReferral) doCatsList.get(0);
		}
		
		boolean wasCatsReferralModified = false;
		
		if(doCats != null && ApptOutcome.DECISIONTREATACTIVEMONITORING.equals(appt.getOutcome()))
		{	
			if(doCats.getJourney() != null)
			{
				PatientPathwayJourney journey = doCats.getJourney();
					
				int X = getNumberOfClocks(journey.getClockHistory());
					
				PathwayClock clock = new PathwayClock();
				clock.setExtClockId("MAXIMS_" + X);
				clock.setExtClockName("MaximsClock_" + X);
				clock.setStartDate(new Date());
					
				journey.setCurrentClock(clock);
					
				if (journey.getClockHistory() == null)
					journey.setClockHistory(new HashSet());
					
				journey.getClockHistory().add(clock);
				
				wasCatsReferralModified = true;
			}
		}
		
		// WDEV-18475 // WDEV-18602 
		// If this is a cancer pathway or Referral Urgency is 'Two Week Wait' or 'Consultant Upgrade'
		// and decision to treat or waiting list outcome, we want the 31 day target
		if (doCats != null && doAppt.getOutcome() != null && (doAppt.getOutcome().getId() == ApptOutcome.DECISION_TO_TREAT.getId() ||
											doAppt.getOutcome().getId() == ApptOutcome.DECISIONTREATACTIVEMONITORING.getId() ||
											doAppt.getOutcome().getId() == ApptOutcome.ADDTOBOOKEDLIST.getId() ||
											doAppt.getOutcome().getId() == ApptOutcome.ADDTOPLANNEDLIST.getId() ||
											doAppt.getOutcome().getId() == ApptOutcome.ADDTOWAITINGLIST.getId()))
		{
				// Is this a Cancer Pathway and non-diagnostic
				if (doAppt.getActivity() != null && doAppt.getActivity().isDiagnostic() != null && !doAppt.getActivity().isDiagnostic())
				{
					if ((doCats.getJourney() != null && doCats.getJourney().isIsCancerPathway() != null && doCats.getJourney().isIsCancerPathway()) ||
						(doCats.getUrgency() != null && (doCats.getUrgency().getId() == ReferralUrgency.CONSULTANT_UPGRADE.getID() || doCats.getUrgency().getId() == ReferralUrgency.TWO_WEEK_WAIT.getID())))
					{
						// Find the Target 31Day
						HL7PathwayIf hl7Impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
						try 
						{
							TargetRefVo target = hl7Impl.getTargetByTaxonomyMap(TaxonomyType.PAS, "31D");
							if (target != null)
								hl7Impl.bringTargetIntoScopeWithoutEvent(target, new PatientPathwayJourneyRefVo(doCats.getJourney().getId(), doCats.getJourney().getVersion()), new ims.framework.utils.Date());
							
						}
						catch (DomainInterfaceException e) 
						{
							super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, e.getMessage());
						}
					}
				}
		}
		// WDEV-18475 end
		//WDEV-18553 - previous form related paramater removed
		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && doCats != null && Boolean.TRUE.equals(doCats.isRTTClockImpact()))
		{
			if(firstDefinitiveTreatmentEvent != null && isFirstDefinitiveTreatmentSavedForFirstTime)
			{
				createAndInstantiatePatientEvent(doCats, firstDefinitiveTreatmentEvent);
			}
			
			if(isOutcomeSavedForFirstTime)
			{
    			RTTStatusEventMapVo rttMap = getRTTStatusEventMapByEncounter(appt.getOutcome());
    			
    			if(rttMap == null)
    			{
    				if(doCats.getJourney() != null && doCats.getJourney().getCurrentClock() != null && doCats.getJourney().getCurrentClock().getCurrentRTTStatus() != null && doCats.getJourney().getCurrentClock().getCurrentRTTStatus().getRTTStatus() != null)
    				{
    					rttMap = getRTTStatusEventMap(doCats.getJourney().getCurrentClock().getCurrentRTTStatus().getRTTStatus());
    				}
    			}
    			
    			if(rttMap != null)
    			{
        			createPathwayRTTStatus(rttMap.getTargetRTTStatus(), doCats);
        			
        			if(rttMap.getEvent() != null)
        			{
        				createAndInstantiatePatientEvent(doCats, rttMap.getEvent());
        			}
        			
        			wasCatsReferralModified = true;
    			}
			}
		}
		
		if(doCats != null && wasCatsReferralModified)
			factory.save(doCats);
	}

	private void createAndInstantiatePatientEvent(CatsReferral doCats, EventLiteVo eventLiteVo) throws DomainInterfaceException, StaleObjectException
	{
		PatientEventVo patEvent = new PatientEventVo();
		patEvent.setPatient(new PatientRefVo(doCats.getPatient().getId(), doCats.getPatient().getVersion()));
		patEvent.setEvent(eventLiteVo);
		patEvent.setEventDateTime(new DateTime());
		patEvent.setEventStatus(EventStatus.ACTIVE);
		patEvent.setJourney(PatientJourneyVoAssembler.create(doCats.getJourney()));
		
		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
		impl.instantiatePatientEvent(patEvent);
	}
	
	private RTTStatusEventMapVo getRTTStatusEventMap(RTTStatusPoint rttStatusPoint)
	{
		if(rttStatusPoint == null)
			return null;
		
		String query = "select rttMap from RTTStatusEventMap as rttMap left join rttMap.currentRTTStatus as rtt where rtt.id = :RTTStatusPoint and rttMap.event is not null and rttMap.active = 1";
		List<?> listRTTMap = getDomainFactory().find(query, new String[] {"RTTStatusPoint"}, new Object[] {rttStatusPoint.getId()});
		
		if(listRTTMap != null && listRTTMap.size() > 0 && listRTTMap.get(0) instanceof RTTStatusEventMap)
		{
			return RTTStatusEventMapVoAssembler.create((RTTStatusEventMap) listRTTMap.get(0));
		}
		
		return null;
	}

	private void createPathwayRTTStatus(RTTStatusPointVo rttStatusPointVo, CatsReferral doCats)
	{
		if(doCats == null || rttStatusPointVo == null)
			return;
		
		
		Object mos = getMosUser();
		MemberOfStaff doMos = null;
		
		if(mos instanceof MemberOfStaffLiteVo)
		{
			doMos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(getDomainFactory(), (MemberOfStaffLiteVo) mos);
		}
		
		PathwayRTTStatus pathwayRTTStatus = new PathwayRTTStatus();
		pathwayRTTStatus.setRTTStatus(RTTStatusPointVoAssembler.extractRTTStatusPoint(getDomainFactory(), rttStatusPointVo));
		pathwayRTTStatus.setStatusBy(doMos);
		pathwayRTTStatus.setStatusDateTime(new Date());
		
		doCats.setCurrentRTTStatus(pathwayRTTStatus);
		if(doCats.getJourney() != null && doCats.getJourney().getCurrentClock() != null)
    	{
			doCats.getJourney().getCurrentClock().setCurrentRTTStatus(pathwayRTTStatus);
    			
    		if(doCats.getJourney().getCurrentClock().getRTTStatusHistory() == null)
    			doCats.getJourney().getCurrentClock().setRTTStatusHistory(new java.util.ArrayList());
    			
    		doCats.getJourney().getCurrentClock().getRTTStatusHistory().add(pathwayRTTStatus);
    	}
	}

	public PatientProcedureForAppointmentOutcomeVo getPatientProcedure(PatientProcedureRefVo patientProcedureRef)
	{
		if(patientProcedureRef == null || patientProcedureRef.getID_PatientProcedure() == null)
			return null;
		
		PatientProcedure doPatientProcedure = (PatientProcedure) getDomainFactory().getDomainObject(PatientProcedure.class, patientProcedureRef.getID_PatientProcedure());
		
		return PatientProcedureForAppointmentOutcomeVoAssembler.create(doPatientProcedure);
	}

	public CareContextShortVo getCareContext(Booking_AppointmentRefVo bookApptId)
	{
		if(bookApptId == null || bookApptId.getID_Booking_Appointment() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select cc from CatsReferral as cats left join cats.appointments as appt left join cats.careContext as cc where appt.id = :ApptId";
		
		List<?> careContextList = factory.find(query, new String[] {"ApptId"}, new Object[] {bookApptId.getID_Booking_Appointment()});
		
		if(careContextList != null && careContextList.size() > 0)
			return CareContextShortVoAssembler.create((CareContext) careContextList.get(0));
		
		return null;
	}

	public AppointmentOutcomeConfigVo getAppointmentOutcomeConfigByApptOutcomeLookup(ApptOutcome apptOutcomeLookup)
	{
		if(apptOutcomeLookup == null)
			return null;
		
		AppointmentOutcomeConfig impl = (AppointmentOutcomeConfig) getDomainImpl(AppointmentOutcomeConfigImpl.class);
		return impl.getAppointmentOutcomeConfigByApptOutcomeLookup(apptOutcomeLookup);
	}

	public Boolean hasReferralActivePatientElectiveList(Booking_AppointmentRefVo bookApptRef)
	{
		if(bookApptRef == null || bookApptRef.getID_Booking_Appointment() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select count(pEl) from PatientElectiveList as pEl left join pEl.electiveListStatus as es left join es.electiveListStatus as s left join pEl.referral as c left join c.appointments as a where a.id = :BookAppointmentId and s.id not in (:RemovedStatus)";
		
		Object[] count = factory.find(query, new String[] {"BookAppointmentId", "RemovedStatus"}, new Object[] {bookApptRef.getID_Booking_Appointment(), WaitingListStatus.REMOVED.getID()}).toArray();
		
		if(count != null && count.length > 0 && ((Long) count[0]).intValue() > 0)
			return true;
		
		return false;	
	}

	public PatientDiagnosisOpNotesVo getPatientDiagnosis(PatientDiagnosisRefVo patientDiagnosisRef)
	{
		if(patientDiagnosisRef == null || patientDiagnosisRef.getID_PatientDiagnosis() == null)
			return null;
		
		PatientDiagnosis doPatientDiagnosis = (PatientDiagnosis) getDomainFactory().getDomainObject(PatientDiagnosis.class, patientDiagnosisRef.getID_PatientDiagnosis());
		
		return PatientDiagnosisOpNotesVoAssembler.create(doPatientDiagnosis);
	}

	public CatsReferralRefVo getCatsReferral(Booking_AppointmentRefVo bookApptRef)
	{
		if(bookApptRef == null || bookApptRef.getID_Booking_Appointment() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select cats from CatsReferral as cats left join cats.appointments as appt where appt.id = :ApptId";
		
		List<?> catsReferralList = factory.find(query, new String[] {"ApptId"}, new Object[] {bookApptRef.getID_Booking_Appointment()});
		
		if(catsReferralList != null && catsReferralList.size() > 0 && catsReferralList.get(0) instanceof CatsReferral)
		{
			return new CatsReferralRefVo(((CatsReferral) catsReferralList.get(0)).getId(), ((CatsReferral) catsReferralList.get(0)).getVersion());
		}
		
		return null;
	}
}
