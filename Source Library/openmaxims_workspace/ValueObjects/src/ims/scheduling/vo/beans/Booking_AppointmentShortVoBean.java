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

package ims.scheduling.vo.beans;

public class Booking_AppointmentShortVoBean extends ims.vo.ValueObjectBean
{
	public Booking_AppointmentShortVoBean()
	{
	}
	public Booking_AppointmentShortVoBean(ims.scheduling.vo.Booking_AppointmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.apptstatusreas = vo.getApptStatusReas() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatusReas().getBean();
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.arrivaltime = vo.getArrivalTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getArrivalTime().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.apptcompletetime = vo.getApptCompleteTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptCompleteTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.comments = vo.getComments();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.outcomecomments = vo.getOutcomeComments();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.appttrackingstatushistory = vo.getApptTrackingStatusHistory() == null ? null : vo.getApptTrackingStatusHistory().getBeanCollection();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean();
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotForDNAVoBean)vo.getSessionSlot().getBean();
		this.dummycolour = vo.getDummyColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDummyColour().getBean();
		this.durationhelper = vo.getDurationHelper() == null ? null : (ims.scheduling.vo.beans.AvailableDurationVoBean)vo.getDurationHelper().getBean();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean();
		this.numprovidercancellations = vo.getNumProviderCancellations();
		this.numpatientcancellations = vo.getNumPatientCancellations();
		this.linkedapptstobecancelled = vo.getLinkedApptsToBeCancelled() == null ? null : vo.getLinkedApptsToBeCancelled().getBeanCollection();
		this.date28dayrulebreach = vo.getDate28DayRuleBreach() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate28DayRuleBreach().getBean();
		this.iswardattendance = vo.getIsWardAttendance();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.electivelist = vo.getElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getElectiveList().getBoId(), vo.getElectiveList().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.Booking_AppointmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.apptstatusreas = vo.getApptStatusReas() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatusReas().getBean();
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean(map);
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean(map);
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.arrivaltime = vo.getArrivalTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getArrivalTime().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.apptcompletetime = vo.getApptCompleteTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptCompleteTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean(map);
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.comments = vo.getComments();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.outcomecomments = vo.getOutcomeComments();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.appttrackingstatushistory = vo.getApptTrackingStatusHistory() == null ? null : vo.getApptTrackingStatusHistory().getBeanCollection();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean(map);
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotForDNAVoBean)vo.getSessionSlot().getBean(map);
		this.dummycolour = vo.getDummyColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDummyColour().getBean();
		this.durationhelper = vo.getDurationHelper() == null ? null : (ims.scheduling.vo.beans.AvailableDurationVoBean)vo.getDurationHelper().getBean(map);
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean(map);
		this.numprovidercancellations = vo.getNumProviderCancellations();
		this.numpatientcancellations = vo.getNumPatientCancellations();
		this.linkedapptstobecancelled = vo.getLinkedApptsToBeCancelled() == null ? null : vo.getLinkedApptsToBeCancelled().getBeanCollection();
		this.date28dayrulebreach = vo.getDate28DayRuleBreach() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate28DayRuleBreach().getBean();
		this.iswardattendance = vo.getIsWardAttendance();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.electivelist = vo.getElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getElectiveList().getBoId(), vo.getElectiveList().getBoVersion());
	}

	public ims.scheduling.vo.Booking_AppointmentShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.Booking_AppointmentShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.Booking_AppointmentShortVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.Booking_AppointmentShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.Booking_AppointmentShortVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.vo.LookupInstanceBean getApptStatusReas()
	{
		return this.apptstatusreas;
	}
	public void setApptStatusReas(ims.vo.LookupInstanceBean value)
	{
		this.apptstatusreas = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean[] getApptStatusHistory()
	{
		return this.apptstatushistory;
	}
	public void setApptStatusHistory(ims.scheduling.vo.beans.Appointment_StatusVoBean[] value)
	{
		this.apptstatushistory = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.seenby = value;
	}
	public ims.scheduling.vo.beans.SessionLiteVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionLiteVoBean value)
	{
		this.session = value;
	}
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.TimeBean getArrivalTime()
	{
		return this.arrivaltime;
	}
	public void setArrivalTime(ims.framework.utils.beans.TimeBean value)
	{
		this.arrivaltime = value;
	}
	public ims.framework.utils.beans.TimeBean getSeenTime()
	{
		return this.seentime;
	}
	public void setSeenTime(ims.framework.utils.beans.TimeBean value)
	{
		this.seentime = value;
	}
	public ims.framework.utils.beans.TimeBean getApptCompleteTime()
	{
		return this.apptcompletetime;
	}
	public void setApptCompleteTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptcompletetime = value;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.requiresrebook = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.scheduling.vo.beans.Appointment_StatusVoBean value)
	{
		this.currentstatusrecord = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.framework.utils.beans.TimeBean getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptendtime = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public String getOutcomeComments()
	{
		return this.outcomecomments;
	}
	public void setOutcomeComments(String value)
	{
		this.outcomecomments = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] getApptTrackingStatusHistory()
	{
		return this.appttrackingstatushistory;
	}
	public void setApptTrackingStatusHistory(ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] value)
	{
		this.appttrackingstatushistory = value;
	}
	public ims.scheduling.vo.beans.TheatreBookingBaseVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.beans.TheatreBookingBaseVoBean value)
	{
		this.theatrebooking = value;
	}
	public ims.scheduling.vo.beans.SessionSlotForDNAVoBean getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.scheduling.vo.beans.SessionSlotForDNAVoBean value)
	{
		this.sessionslot = value;
	}
	public ims.framework.utils.beans.ColorBean getDummyColour()
	{
		return this.dummycolour;
	}
	public void setDummyColour(ims.framework.utils.beans.ColorBean value)
	{
		this.dummycolour = value;
	}
	public ims.scheduling.vo.beans.AvailableDurationVoBean getDurationHelper()
	{
		return this.durationhelper;
	}
	public void setDurationHelper(ims.scheduling.vo.beans.AvailableDurationVoBean value)
	{
		this.durationhelper = value;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.wasprinted = value;
	}
	public ims.core.vo.beans.PatientDocumentLiteVoBean getBookingLetter()
	{
		return this.bookingletter;
	}
	public void setBookingLetter(ims.core.vo.beans.PatientDocumentLiteVoBean value)
	{
		this.bookingletter = value;
	}
	public Integer getNumProviderCancellations()
	{
		return this.numprovidercancellations;
	}
	public void setNumProviderCancellations(Integer value)
	{
		this.numprovidercancellations = value;
	}
	public Integer getNumPatientCancellations()
	{
		return this.numpatientcancellations;
	}
	public void setNumPatientCancellations(Integer value)
	{
		this.numpatientcancellations = value;
	}
	public ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] getLinkedApptsToBeCancelled()
	{
		return this.linkedapptstobecancelled;
	}
	public void setLinkedApptsToBeCancelled(ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] value)
	{
		this.linkedapptstobecancelled = value;
	}
	public ims.framework.utils.beans.DateBean getDate28DayRuleBreach()
	{
		return this.date28dayrulebreach;
	}
	public void setDate28DayRuleBreach(ims.framework.utils.beans.DateBean value)
	{
		this.date28dayrulebreach = value;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.iswardattendance = value;
	}
	public ims.vo.LookupInstanceBean getWardAttendanceOutcome()
	{
		return this.wardattendanceoutcome;
	}
	public void setWardAttendanceOutcome(ims.vo.LookupInstanceBean value)
	{
		this.wardattendanceoutcome = value;
	}
	public ims.vo.RefVoBean getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.vo.RefVoBean value)
	{
		this.electivelist = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.vo.LookupInstanceBean apptstatusreas;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean[] apptstatushistory;
	private ims.core.vo.beans.HcpLiteVoBean seenby;
	private ims.scheduling.vo.beans.SessionLiteVoBean session;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean arrivaltime;
	private ims.framework.utils.beans.TimeBean seentime;
	private ims.framework.utils.beans.TimeBean apptcompletetime;
	private Boolean requiresrebook;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean currentstatusrecord;
	private ims.vo.LookupInstanceBean outcome;
	private Boolean iscabbooking;
	private ims.framework.utils.beans.TimeBean apptendtime;
	private String comments;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private String outcomecomments;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] appttrackingstatushistory;
	private ims.scheduling.vo.beans.TheatreBookingBaseVoBean theatrebooking;
	private ims.scheduling.vo.beans.SessionSlotForDNAVoBean sessionslot;
	private ims.framework.utils.beans.ColorBean dummycolour;
	private ims.scheduling.vo.beans.AvailableDurationVoBean durationhelper;
	private Boolean wasprinted;
	private ims.core.vo.beans.PatientDocumentLiteVoBean bookingletter;
	private Integer numprovidercancellations;
	private Integer numpatientcancellations;
	private ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] linkedapptstobecancelled;
	private ims.framework.utils.beans.DateBean date28dayrulebreach;
	private Boolean iswardattendance;
	private ims.vo.LookupInstanceBean wardattendanceoutcome;
	private ims.vo.RefVoBean electivelist;
}
