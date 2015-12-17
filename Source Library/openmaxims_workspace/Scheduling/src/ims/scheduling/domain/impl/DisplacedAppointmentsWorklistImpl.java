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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.domain.LocationService;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.LocationServiceImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.RefMan.vo.CatsReferralForSessionManagementVo;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.domain.SessionManagement;
import ims.scheduling.domain.base.impl.BaseDisplacedAppointmentsWorklistImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.Session_Slot;
import ims.scheduling.vo.BookingAppointmentForDisplacedAppointmentVo;
import ims.scheduling.vo.BookingAppointmentForDisplacedAppointmentVoCollection;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.Sch_SessionRefVo;
import ims.scheduling.vo.SessionSlotForDisplacedAppointmentsVo;
import ims.scheduling.vo.SessionSlotForDisplacedAppointmentsVoCollection;
import ims.scheduling.vo.SessionSlotVo;
import ims.scheduling.vo.domain.BookingAppointmentForDisplacedAppointmentVoAssembler;
import ims.scheduling.vo.domain.BookingAppointmentForSessionManagementVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.domain.SessionManagementVoAssembler;
import ims.scheduling.vo.domain.SessionSlotForDisplacedAppointmentsVoAssembler;
import ims.scheduling.vo.domain.SessionSlotVoAssembler;
import ims.scheduling.vo.lookups.SchProfileType;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.ArrayList;

public class DisplacedAppointmentsWorklistImpl extends BaseDisplacedAppointmentsWorklistImpl
{

	private static final long serialVersionUID = 1L;

	public ims.scheduling.vo.ProfileLiteVoCollection listProfiles(String profileName)
	{
		SessionManagement impl = (SessionManagement) getDomainImpl(SessionManagementImpl.class);
		return impl.listProfiles(profileName);
	}

	public ims.core.vo.LocationLiteVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();
	}

	public ims.core.vo.LocShortMappingsVoCollection listActiveLocationsForHospital(ims.core.vo.LocationLiteVo location)
	{
		if (location == null)
			return null;
		//http://jira/browse/WDEV-21222 
		OrganisationAndLocation impl = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveLocationsForHospital(location,new int[]{LocationType.CLINIC.getID(),LocationType.OUTPATIENT_DEPT.getID()});
	}

	public ims.core.vo.ServiceVoCollection listServices()
	{
		LocationService impl = (LocationService) getDomainImpl(LocationServiceImpl.class);
		return impl.listService(Boolean.TRUE).sort();
	}

	public ims.core.vo.LocationLiteVo getHospitalForCurrentLocation(Integer locId)
	{
		SessionManagement impl = (SessionManagement) getDomainImpl(SessionManagementImpl.class);
		return impl.getHospitalForCurrentLocation(locId);
	}

	public ims.scheduling.vo.SessionManagementVoCollection listSessionsWithDisplacedApppointments(ims.scheduling.vo.DisplacedAppointmentsSearchCriteriaVo displacedSearchCriteriaVo)
	{
		DomainFactory factory = getDomainFactory();

		String hql = " select sess from Sch_Session as sess ";

		String hqlSubSelectDisplaced = " sess in (select distinct booking.session from Booking_Appointment as booking left join booking.session as sessSub ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = "";
		StringBuffer condStr = new StringBuffer();
		StringBuffer condStrSubselct = new StringBuffer();

		if (displacedSearchCriteriaVo != null)
		{
			if (displacedSearchCriteriaVo.getLocation() != null)
			{
				
				if (LocationType.CLINIC.equals(displacedSearchCriteriaVo.getLocation().getType()))
				{
					hql += " left join sess.schLocation as location ";
					condStr.append(andStr + " location.id = :locationID ");
					markers.add("locationID");
					values.add(displacedSearchCriteriaVo.getLocation().getID_Location());
					
					andStr = " and ";

					hqlSubSelectDisplaced += " left join sessSub.schLocation as locationSub ";
					condStrSubselct.append(andStr + " locationSub.id = :locationIDSub ");
					markers.add("locationIDSub");
					values.add(displacedSearchCriteriaVo.getLocation().getID_Location());

				}
				else if (LocationType.OUTPATIENT_DEPT.equals(displacedSearchCriteriaVo.getLocation().getType()))
				{
					hql += " left join sess.schLocation as location ";
					condStr.append(andStr + " (location.id = :locationID or (location.parentLocation.id = :locationID)) ");
					markers.add("locationID");
					values.add(displacedSearchCriteriaVo.getLocation().getID_Location());

					andStr = " and ";

					hqlSubSelectDisplaced += " left join sessSub.schLocation as locationSub ";
					condStrSubselct.append(andStr + " (locationSub.id = :locationIDSub or (locationSub.parentLocation.id = :locationIDSub)) ");
					markers.add("locationIDSub");
					values.add(displacedSearchCriteriaVo.getLocation().getID_Location());
				} 
			}
			else if (displacedSearchCriteriaVo.getHospital() != null)
			{
				OrganisationAndLocation impl = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
				String ids = impl.getChildLocationsIdsForLocation(displacedSearchCriteriaVo.getHospital().getBoId(), null, Boolean.TRUE,Boolean.FALSE);
		
				hql += " left join sess.schLocation as location ";

				condStr.append(andStr + " location.id in ( " + ids + " ) ");
				andStr = " and ";
				
				hqlSubSelectDisplaced += " left join sessSub.schLocation as locationSub ";
				condStrSubselct.append(andStr + " locationSub.id in ( " + ids + " ) ");
				andStr = " and ";
	
			}

			if (displacedSearchCriteriaVo.getService() != null)
			{
				hql += " left join sess.service as serv ";
				condStr.append(andStr + " serv.id = :serviceID ");
				markers.add("serviceID");
				values.add(displacedSearchCriteriaVo.getService().getID_Service());

				andStr = " and ";

				hqlSubSelectDisplaced += " left join sessSub.service as servSub ";
				condStrSubselct.append(andStr + " servSub.id = :serviceIDSub ");
				markers.add("serviceIDSub");
				values.add(displacedSearchCriteriaVo.getService().getID_Service());
			}

			if (displacedSearchCriteriaVo.getListOwners() != null && displacedSearchCriteriaVo.getListOwners().size() > 0)
			{
				String ownersIDs = getListOwnersIDs(displacedSearchCriteriaVo.getListOwners());

				hql += " left join sess.listOwners as owners ";
				condStr.append(andStr + " owners.hcp.id in ( " + ownersIDs + " )  and owners.listOwner = 1 "); 

				andStr = " and ";

				hqlSubSelectDisplaced += " left join sessSub.listOwners as ownersSub ";
				condStrSubselct.append(andStr + " ownersSub.hcp.id in ( " + ownersIDs + " )  and ownersSub.listOwner = 1 "); 
			}

			if (displacedSearchCriteriaVo.getProfile() != null)
			{
				hql += " left join sess.sch_Profile as profile ";
				condStr.append(andStr + " profile.id = :profileID ");
				markers.add("profileID");
				values.add(displacedSearchCriteriaVo.getProfile().getID_Sch_Profile());

				andStr = " and ";

				hqlSubSelectDisplaced += " left join sessSub.sch_Profile as profileSub ";
				condStrSubselct.append(andStr + " profileSub.id = :profileIDSub ");
				markers.add("profileIDSub");
				values.add(displacedSearchCriteriaVo.getProfile().getID_Sch_Profile());
			}

			if (displacedSearchCriteriaVo.getDateFrom() != null)
			{
				condStr.append(andStr + " sess.sessionDate >= :startDate ");
				markers.add("startDate");
				values.add(displacedSearchCriteriaVo.getDateFrom().getDate());
				
				andStr = " and ";

				condStrSubselct.append(andStr + " sessSub.sessionDate >= :startDateSub ");
				markers.add("startDateSub");
				values.add(displacedSearchCriteriaVo.getDateFrom().getDate());
			}

			if (displacedSearchCriteriaVo.getDateTo() != null)
			{
				condStr.append(andStr + " sess.sessionDate <= :endDate ");
				markers.add("endDate");
				values.add(displacedSearchCriteriaVo.getDateTo().getDate());

				andStr = " and ";

				condStrSubselct.append(andStr + " sessSub.sessionDate <= :endDateSub ");
				markers.add("endDateSub");
				values.add(displacedSearchCriteriaVo.getDateTo().getDate());
			}

			if( displacedSearchCriteriaVo.getListType() != null)
			{
				condStr.append(andStr + " sess.listType.id = :listtypeId ");
				markers.add("listtypeId");
				values.add(getDomLookup(displacedSearchCriteriaVo.getListType()).getId());
				
				andStr = " and ";

				condStrSubselct.append(andStr + " sessSub.listType.id = :listtypeIdSub ");
				markers.add("listtypeIdSub");
				values.add(getDomLookup(displacedSearchCriteriaVo.getListType()).getId());
				}
		}
		
		condStr.append(andStr + " (sess.sessionProfileType.id = :OUTPATIENT_SESSION) ");
		markers.add("OUTPATIENT_SESSION");
		values.add(SchProfileType.OUTPATIENT.getID());

		condStrSubselct.append(" and (sessSub.sessionProfileType.id = :OUTPATIENT_SESSIONSUB) ");
		markers.add("OUTPATIENT_SESSIONSUB");
		values.add(SchProfileType.OUTPATIENT.getID());

	//	condStrSubselct.append(" and (bstatus.id = :statusID) ");
	//	markers.add("statusID");
	//	values.add(Status_Reason.CANCELLED.getId());

		hqlSubSelectDisplaced += " left join booking.apptStatus as bstatus where booking.isDisplaced = 1 " + condStrSubselct;

		hql += "where ";
		
		if (condStr.length() > 0)
			hql += condStr.toString() + " and ";
		
		hql += hqlSubSelectDisplaced + " ) order by sess.sessionDate asc";
	
		return SessionManagementVoAssembler.createSessionManagementVoCollectionFromSch_Session(factory.find(hql, markers, values));
	}
	
	private String getListOwnersIDs(HcpLiteVoCollection listOwners)
	{
		String ids = "";

		for (int i = 0; i < listOwners.size(); i++)
		{

			if (listOwners.get(i) == null || listOwners.get(i).getID_Hcp() == null)
				continue;

			if (ids == "")
				ids += listOwners.get(i).getID_Hcp().toString();
			else
				ids += ", " + listOwners.get(i).getID_Hcp().toString();

		}

		return ids;
	}

	@Override
	public BookingAppointmentForDisplacedAppointmentVoCollection getDisplacedAppointmentsForSession(Sch_SessionRefVo session) 
	{
		if (session == null || session.getID_Sch_Session() == null)
			return null;

		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();
		hql.append("select appt from Booking_Appointment as appt left join appt.session as sess left join appt.apptStatus as status where sess.id = :sessionID and appt.isDisplaced = 1 "); //and status.id = :statusID ");

		markers.add("sessionID");
		values.add(session.getID_Sch_Session());
		
//		markers.add("statusID");
	//	values.add(Status_Reason.CANCELLED.getId());

		return BookingAppointmentForDisplacedAppointmentVoAssembler.createBookingAppointmentForDisplacedAppointmentVoCollectionFromBooking_Appointment(factory.find(hql.toString(), markers, values));
		
	}

	@Override
	public CatsReferralForSessionManagementVo getCatsReferralForAppointment(Booking_AppointmentRefVo appointmentRef) 
	{
		SessionManagement impl = (SessionManagement) getDomainImpl(SessionManagementImpl.class);
		return impl.getCatsReferralForAppointment(appointmentRef);
	}

	@Override
	public PatientShort getPatientShort(PatientRefVo patientRef) 
	{
		if(patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot get Patient on null Id.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient()));
	}

	@Override
	public Booking_AppointmentVo getBookingAppointment(Booking_AppointmentRefVo appt) 
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided for method getBookingAppointment");

		return Booking_AppointmentVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(appt));
	}

	@Override
	public void saveAppointment(BookingAppointmentForDisplacedAppointmentVo appointmentToSave) throws StaleObjectException 
	{
		if (appointmentToSave == null)
			throw new CodingRuntimeException("Cannot save null Appointment");

		DomainFactory factory = getDomainFactory();

		if(appointmentToSave.getSessionSlotIsNotNull())
		{
			SessionSlotForDisplacedAppointmentsVo sessionSlot = appointmentToSave.getSessionSlot();
			 
			sessionSlot.setAppointment(null);
			Session_Slot doSessionSlot = SessionSlotForDisplacedAppointmentsVoAssembler.extractSession_Slot(factory, sessionSlot);
			factory.save(doSessionSlot);
			
			appointmentToSave.setSessionSlot(null);
			appointmentToSave.validate();
		}

		Booking_Appointment domainAppointment = BookingAppointmentForDisplacedAppointmentVoAssembler.extractBooking_Appointment(factory, appointmentToSave);
		factory.save(domainAppointment);
		
	}

	@Override
	public BookingAppointmentForDisplacedAppointmentVo getDisplacedBookingAppointment(Booking_AppointmentRefVo appt) 
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided for method getBookingAppointment");

		return BookingAppointmentForDisplacedAppointmentVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(appt));
	}

	@Override
	public CareContextShortVo getCareContextShort(CareContextRefVo voCareContextRef) 
	{
		if (voCareContextRef == null)
			throw new RuntimeException("Cannot get CareContextShortVo for null CareContextRefVo");

		CareContext doCareContext = (CareContext) getDomainFactory().getDomainObject(CareContext.class, voCareContextRef.getID_CareContext());
		return CareContextShortVoAssembler.create(doCareContext);
	}

	@Override
	//WDEV-22521
	public CareContextShortVo getCareContextFromCatsReferral(Booking_AppointmentRefVo appRef)
	{
		if (appRef == null)
			throw new CodingRuntimeException("appt is null in method getCareContextFromCatsReferral");
		
		DomainFactory factory = getDomainFactory();
		
		DomainObject list = factory.findFirst("SELECT cats.careContext FROM CatsReferral AS cats LEFT JOIN cats.appointments AS appt WHERE appt.id = :idAppt ", new String[] { "idAppt" }, new Object[] { appRef.getID_Booking_Appointment() });
		
		if (list == null)
			return null;
		
		return CareContextShortVoAssembler.create((CareContext) list);
	}
	

	public void removeFromDisplacedWorklist(Booking_AppointmentRefVo appt) throws StaleObjectException
	{
		if(appt == null || appt.getID_Booking_Appointment() == null)
			return;
		
		DomainFactory factory = getDomainFactory();
		Booking_Appointment doAppt = (Booking_Appointment) factory.getDomainObject(Booking_Appointment.class, appt.getID_Booking_Appointment());
		
		if(doAppt == null)
			return;
		
		doAppt.setIsDisplaced(false);
		doAppt.setRequiresRebook(false);
		
		factory.save(doAppt);
	}
}
