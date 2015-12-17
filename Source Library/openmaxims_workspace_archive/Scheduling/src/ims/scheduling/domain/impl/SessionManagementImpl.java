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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5196.22631)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.LocationService;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.LocationServiceImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.OrderInvAppt;
import ims.RefMan.vo.CatsReferralForSessionManagementVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.domain.CatsReferralForSessionManagementVoAssembler;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.configuration.gen.ConfigFlag;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.ServiceVoCollection;
import ims.core.vo.domain.LocShortMappingsVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.vo.domain.OrderInvestigationBookingVoAssembler;
import ims.scheduling.domain.PatientAppointmentManagement;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.base.impl.BaseSessionManagementImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.Sch_Session;
import ims.scheduling.domain.objects.Session_Slot;
import ims.scheduling.vo.Appointment_StatusVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.ProfileLiteVoCollection;
import ims.scheduling.vo.Sch_SessionRefVo;
import ims.scheduling.vo.SessionManagementSearchCriteriaVo;
import ims.scheduling.vo.SessionManagementVo;
import ims.scheduling.vo.SessionManagementVoCollection;
import ims.scheduling.vo.SessionParentChildSlotVoCollection;
import ims.scheduling.vo.SessionServiceAndSlotActivityVo;
import ims.scheduling.vo.SessionShortVo;
import ims.scheduling.vo.SessionSlotForSessionManagementVoCollection;
import ims.scheduling.vo.SessionSlotVo;
import ims.scheduling.vo.SessionVo;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.domain.ProfileLiteVoAssembler;
import ims.scheduling.vo.domain.SessionManagementVoAssembler;
import ims.scheduling.vo.domain.SessionShortVoAssembler;
import ims.scheduling.vo.domain.SessionSlotForSessionManagementVoAssembler;
import ims.scheduling.vo.domain.SessionSlotVoAssembler;
import ims.scheduling.vo.domain.SessionVoAssembler;
import ims.scheduling.vo.lookups.SchedCABSlotType;

import java.util.ArrayList;
import java.util.List;

public class SessionManagementImpl extends BaseSessionManagementImpl
{

	private static final long serialVersionUID = 1L;

	public ProfileLiteVoCollection listProfiles(String profileName)
	{
		if (profileName == null || profileName.length() == 0)
			throw new CodingRuntimeException("Cannot search on a null ProfileName");

		String query = "SELECT profile FROM Sch_Profile AS profile WHERE upper(profile.name) like :ProfileName and profile.isActive = 1 and (profile.isTheatreProfile is null OR profile.isTheatreProfile = 0) ORDER BY UPPER(profile.name) ASC";

		return ProfileLiteVoAssembler.createProfileLiteVoCollectionFromSch_Profile(getDomainFactory().find(query, new String[] { "ProfileName" }, new Object[] { profileName.toUpperCase() + "%" }));
	}

	public LocationLiteVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();
	}

	public LocationLiteVo getHospitalForCurrentLocation(Integer locId)
	{
		if (locId == null)
			throw new CodingRuntimeException("Cannot get the Hospital for a null Location.");

		DomainFactory factory = getDomainFactory();
		Location doLocation = (Location) factory.getDomainObject(Location.class, locId);

		return getHospital(doLocation);
	}

	private LocationLiteVo getHospital(Location doLocation)
	{
		if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
		{
			return LocShortMappingsVoAssembler.create((LocSite) doLocation);
		}

		while (doLocation.getParentLocation() != null)
		{
			doLocation = doLocation.getParentLocation();

			if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			{
				return LocShortMappingsVoAssembler.create((LocSite) doLocation);
			}
		}

		return null;
	}

	public LocShortMappingsVoCollection listActiveWardsForHospital(LocationLiteVo location)
	{
		OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return locImpl.listActiveWardsForHospital(location);
	}

	public HcpLiteVoCollection listHcpLite(HcpFilter filter)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLite(filter);
	}

	public ServiceVoCollection listServices()
	{
		LocationService impl = (LocationService) getDomainImpl(LocationServiceImpl.class);
		return impl.listService(Boolean.TRUE);
	}

	public SessionManagementVoCollection listSessions(SessionManagementSearchCriteriaVo searchCriteria)
	{

		DomainFactory factory = getDomainFactory();

		String hql = " select sess from Sch_Session as sess ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " where ";
		StringBuffer condStr = new StringBuffer();

		if (searchCriteria != null)
		{

			if (searchCriteria.getLocation() != null)
			{
				hql += " left join sess.schLocation as location ";

				condStr.append(andStr + " location.id = :locationID ");
				markers.add("locationID");
				values.add(searchCriteria.getLocation().getID_Location());
				andStr = " and ";
			}
			else if (searchCriteria.getHospital() != null)
			{
				hql += " left join sess.schLocation as location ";

				condStr.append(andStr + " location.id = :hospitalID ");
				markers.add("hospitalID");
				values.add(searchCriteria.getHospital().getID_Location());
				andStr = " and ";
			}

			if (searchCriteria.getService() != null)
			{
				hql += " left join sess.service as serv ";

				condStr.append(andStr + " serv.id = :serviceID ");
				markers.add("serviceID");
				values.add(searchCriteria.getService().getID_Service());
				andStr = " and ";

			}

			if (searchCriteria.getListOwners() != null && searchCriteria.getListOwners().size() > 0)
			{
				String ownersIDs = getListOwnersIDs(searchCriteria.getListOwners());

				hql += " left join sess.listOwners as owners ";

				condStr.append(andStr + " owners.hcp in ( " + ownersIDs + " ) ");

				andStr = " and ";
			}

			if (searchCriteria.getProfile() != null)
			{
				hql += " left join sess.sch_Profile as profile ";

				condStr.append(andStr + " profile.id = :profileID ");
				markers.add("profileID");
				values.add(searchCriteria.getProfile().getID_Sch_Profile());
				andStr = " and ";
			}

			if (searchCriteria.getDateFrom() != null)
			{
				condStr.append(andStr + " sess.sessionDate >= :startDate ");
				markers.add("startDate");
				values.add(searchCriteria.getDateFrom().getDate());
				andStr = " and ";
			}

			if (searchCriteria.getDateTo() != null)
			{
				condStr.append(andStr + " sess.sessionDate <= :endDate ");
				markers.add("endDate");
				values.add(searchCriteria.getDateTo().getDate());
				andStr = " and ";
			}
		}
		
		condStr.append(andStr + " (sess.isTheatreSession is null OR sess.isTheatreSession = 0) ");

		condStr.append(" order by sess.sessionDate asc ");

		hql += condStr.toString();

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

	public SessionSlotForSessionManagementVoCollection getSlotsForSession(Sch_SessionRefVo sessionRef)
	{
		if (sessionRef == null)
		{
			throw new CodingRuntimeException("Cannot get Slots on null SessionID");
		}

		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();
		hql.append("select slots from Sch_Session as session left join session.sessionSlots as slots where session.id = :sessionID order by slots.startTm asc");

		markers.add("sessionID");
		values.add(sessionRef.getID_Sch_Session());

		return SessionSlotForSessionManagementVoAssembler.createSessionSlotForSessionManagementVoCollectionFromSession_Slot(factory.find(hql.toString(), markers, values));
	}

	public CatsReferralForSessionManagementVo getCatsReferralForAppointment(Booking_AppointmentRefVo appointmentRef)
	{
		if (appointmentRef == null || appointmentRef.getID_Booking_Appointment() == null)
			return null;

		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();
		hql.append("select referral from CatsReferral as referral left join referral.appointments as appt where appt.id = :apptID");

		markers.add("apptID");
		values.add(appointmentRef.getID_Booking_Appointment());

		List list = factory.find(hql.toString(), markers, values);

		if (list == null || list.size() == 0)
			return null;

		return CatsReferralForSessionManagementVoAssembler.create((CatsReferral) list.get(0));
	}

	public SessionShortVo getSessionShortVo(Sch_SessionRefVo sessionRef)
	{
		if (sessionRef == null || sessionRef.getID_Sch_Session() == null)
			return null;

		return SessionShortVoAssembler.create((Sch_Session) getDomainFactory().getDomainObject(Sch_Session.class, sessionRef.getID_Sch_Session()));
	}

	public void addSlotToSession(SessionManagementVo session, SessionSlotVo slot) throws StaleObjectException
	{
		if (session == null || slot == null)
			throw new CodingRuntimeException("session or slot is null in method addSlotToSession");

		DomainFactory factory = getDomainFactory();
		Session_Slot doSlot = SessionSlotVoAssembler.extractSession_Slot(factory, slot);
		doSlot.setDirectAccessSlot(getDomLookup(SchedCABSlotType.LOCAL));

		Sch_Session doSession = (Sch_Session) factory.getDomainObject(Sch_Session.class, session.getID_Sch_Session());

		doSlot.setSession(doSession);
		doSlot.setIsActive(true);
		doSession.getSessionSlots().add(doSlot);

		// update remaining slots
		int remainingSlots = doSession.getRemainingSlots();
		remainingSlots += 1;
		int totalslots = doSession.getTotalSlots();
		totalslots += 1;

		doSession.setRemainingSlots(remainingSlots);
		doSession.setTotalSlots(totalslots);

		factory.save(doSession);

	}

	public void cancelSession(Sch_SessionRefVo session, Appointment_StatusVo voApptCancelStatus, Boolean cancelAppointment, Boolean isFlexible) throws DomainInterfaceException, StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.cancelSession(session, voApptCancelStatus, cancelAppointment, isFlexible);

	}

	public SessionVo getSessionVo(Sch_SessionRefVo sessionRef)
	{
		if (sessionRef == null || sessionRef.getID_Sch_Session() == null)
			return null;

		return SessionVoAssembler.create((Sch_Session) getDomainFactory().getDomainObject(Sch_Session.class, sessionRef.getID_Sch_Session()));
	}

	public SessionManagementVo getSessionManagementVo(Sch_SessionRefVo sessionRef)
	{
		if (sessionRef == null || sessionRef.getID_Sch_Session() == null)
			return null;

		return SessionManagementVoAssembler.create((Sch_Session) getDomainFactory().getDomainObject(Sch_Session.class, sessionRef.getID_Sch_Session()));
	}

	public SessionVo saveSession(SessionVo session, Boolean editingSlots) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		return impl.saveSession(session, editingSlots);
	}

	public SessionParentChildSlotVoCollection getTheatreSlots(Sch_SessionRefVo sessionRef)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isReferralICPCompleted(CatsReferralRefVo catsReferral)
	{
		if (!ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue())
		{
			return false;
		}
		
		if (catsReferral == null || !catsReferral.getID_CatsReferralIsNotNull())
			return false;
		
		String hql = "select count(patICP.id) from PatientICP as patICP left join patICP.careContext as careC," +
				" CatsReferral as cats left join cats.careContext as catsCC " +
				"where (cats.id = :catsId and patICP.completedDateTime is not null and catsCC.id = careC.id)";
		
		long count = getDomainFactory().countWithHQL(hql,new String[]{"catsId"},new Object[]{catsReferral.getID_CatsReferral()});
		
		return count > 0;
	}

	public Booking_AppointmentVo getBookingAppointment(Booking_AppointmentRefVo appt)
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided for method getBookingAppointment");

		Booking_AppointmentVo voAppt = Booking_AppointmentVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(appt));
		// SITE-508 get the associatedOrderInv at this point if any
		setOrderInvAppt(voAppt);

		return voAppt;
	}

	private void setOrderInvAppt(Booking_AppointmentVo voAppt)
	{
		if (voAppt == null)
			return;

		List ordInvAppts = getDomainFactory().find("from OrderInvAppt invAppt where invAppt.appointment.id = '" + voAppt.getID_Booking_Appointment() + "'");
		if (ordInvAppts != null && ordInvAppts.size() == 1)
		{
			OrderInvAppt doOrdInvAppt = (OrderInvAppt) ordInvAppts.get(0);
			voAppt.setOrderInvestigation(OrderInvestigationBookingVoAssembler.create(doOrdInvAppt.getOrderInvestigation()));
		}
	}

	public SessionServiceAndSlotActivityVo getServiceAndActivityByAppt(Booking_AppointmentRefVo appt, Boolean isFlexible)
	{
		PatientAppointmentManagement impl = (PatientAppointmentManagement) getDomainImpl(PatientAppointmentMangementRefManImpl.class);
		return impl.getServiceAndActivityByAppt(appt, isFlexible);
	}

	public Booking_AppointmentVo cancelAppt(Booking_AppointmentVo appt, ActionRequestType requestType, String requestSource) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		return impl.cancelAppt(appt, requestType, requestSource);
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralAdditionalInvStatus(catsReferral);
		
	}

	public void updateCatsReferralCancelStatus(CatsReferralRefVo catsReferral) throws StaleObjectException
	{
		if(catsReferral == null || catsReferral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("catsReferral is null or id not provided in method updateCatsReferralAdditionalInvStatus");
		
		DomainFactory factory = getDomainFactory();
		
		CatsReferral doCatsReferral = (CatsReferral) factory.getDomainObject(catsReferral);
		
		doCatsReferral.setHasCancelledApptsForReview(true);
		factory.save(doCatsReferral);
		
	}

	public PatientShort getPatientShort(PatientRefVo patientRef)
	{
		if(patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot get Patient on null Id.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient()));
	}
	
}
