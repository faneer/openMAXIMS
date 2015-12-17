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

public class AppointmentForOutpatientClinicListVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentForOutpatientClinicListVoBean()
	{
	}
	public AppointmentForOutpatientClinicListVoBean(ims.scheduling.vo.AppointmentForOutpatientClinicListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityForOutpatientClinicListVoBean)vo.getActivity().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForOutpatientClinicListVoBean)vo.getSession().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteClinicListVoBean)vo.getPatient().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.outcomecomments = vo.getOutcomeComments();
		this.haselectivelist = vo.getHasElectiveList();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentForOutpatientClinicListVoBean)vo.getBookingLetter().getBean();
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.electivelist = vo.getElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getElectiveList().getBoId(), vo.getElectiveList().getBoVersion());
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean();
		this.trackingstatuscolour = vo.getTrackingStatusColour() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getTrackingStatusColour().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean();
		this.bookingcomments = vo.getBookingComments();
		this.comments = vo.getComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.AppointmentForOutpatientClinicListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityForOutpatientClinicListVoBean)vo.getActivity().getBean(map);
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForOutpatientClinicListVoBean)vo.getSession().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteClinicListVoBean)vo.getPatient().getBean(map);
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.outcomecomments = vo.getOutcomeComments();
		this.haselectivelist = vo.getHasElectiveList();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentForOutpatientClinicListVoBean)vo.getBookingLetter().getBean(map);
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.electivelist = vo.getElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getElectiveList().getBoId(), vo.getElectiveList().getBoVersion());
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean(map);
		this.trackingstatuscolour = vo.getTrackingStatusColour() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getTrackingStatusColour().getBean(map);
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean(map);
		this.bookingcomments = vo.getBookingComments();
		this.comments = vo.getComments();
	}

	public ims.scheduling.vo.AppointmentForOutpatientClinicListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.AppointmentForOutpatientClinicListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.AppointmentForOutpatientClinicListVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.AppointmentForOutpatientClinicListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.AppointmentForOutpatientClinicListVo();
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
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
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
	public ims.core.vo.beans.ActivityForOutpatientClinicListVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityForOutpatientClinicListVoBean value)
	{
		this.activity = value;
	}
	public ims.scheduling.vo.beans.SessionForOutpatientClinicListVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionForOutpatientClinicListVoBean value)
	{
		this.session = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.core.vo.beans.PatientLiteClinicListVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLiteClinicListVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public String getOutcomeComments()
	{
		return this.outcomecomments;
	}
	public void setOutcomeComments(String value)
	{
		this.outcomecomments = value;
	}
	public Boolean getHasElectiveList()
	{
		return this.haselectivelist;
	}
	public void setHasElectiveList(Boolean value)
	{
		this.haselectivelist = value;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.wasprinted = value;
	}
	public ims.core.vo.beans.PatientDocumentForOutpatientClinicListVoBean getBookingLetter()
	{
		return this.bookingletter;
	}
	public void setBookingLetter(ims.core.vo.beans.PatientDocumentForOutpatientClinicListVoBean value)
	{
		this.bookingletter = value;
	}
	public ims.scheduling.vo.beans.LinkedAppointmentsForClinicListWithICPActionsVoBean[] getLinkedAppointments()
	{
		return this.linkedappointments;
	}
	public void setLinkedAppointments(ims.scheduling.vo.beans.LinkedAppointmentsForClinicListWithICPActionsVoBean[] value)
	{
		this.linkedappointments = value;
	}
	public ims.vo.RefVoBean getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.vo.RefVoBean value)
	{
		this.electivelist = value;
	}
	public ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean getCurrentApptTrakingStatus()
	{
		return this.currentappttrakingstatus;
	}
	public void setCurrentApptTrakingStatus(ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean value)
	{
		this.currentappttrakingstatus = value;
	}
	public ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean getTrackingStatusColour()
	{
		return this.trackingstatuscolour;
	}
	public void setTrackingStatusColour(ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean value)
	{
		this.trackingstatuscolour = value;
	}
	public ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean value)
	{
		this.referral = value;
	}
	public String getBookingComments()
	{
		return this.bookingcomments;
	}
	public void setBookingComments(String value)
	{
		this.bookingcomments = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.core.vo.beans.ActivityForOutpatientClinicListVoBean activity;
	private ims.scheduling.vo.beans.SessionForOutpatientClinicListVoBean session;
	private Boolean iscabbooking;
	private ims.core.vo.beans.PatientLiteClinicListVoBean patient;
	private ims.vo.LookupInstanceBean outcome;
	private String outcomecomments;
	private Boolean haselectivelist;
	private Boolean wasprinted;
	private ims.core.vo.beans.PatientDocumentForOutpatientClinicListVoBean bookingletter;
	private ims.scheduling.vo.beans.LinkedAppointmentsForClinicListWithICPActionsVoBean[] linkedappointments;
	private ims.vo.RefVoBean electivelist;
	private ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean currentappttrakingstatus;
	private ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean trackingstatuscolour;
	private ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean referral;
	private String bookingcomments;
	private String comments;
}
