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

package ims.core.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class WardAttenderAppointmentVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardAttenderAppointmentVo()
	{
	}
	public WardAttenderAppointmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardAttenderAppointmentVo(ims.core.vo.beans.WardAttenderAppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.comments = bean.getComments();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
		this.iscabbooking = bean.getIsCABBooking();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.haselectivelist = bean.getHasElectiveList();
		this.wasprinted = bean.getWasPrinted();
		this.bookingletter = bean.getBookingLetter() == null ? null : bean.getBookingLetter().buildVo();
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo();
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo();
		this.bookingcomments = bean.getBookingComments();
		this.currentappttrakingstatus = bean.getCurrentApptTrakingStatus() == null ? null : bean.getCurrentApptTrakingStatus().buildVo();
		this.appointmenttrackingstatus = bean.getAppointmentTrackingStatus() == null ? null : bean.getAppointmentTrackingStatus().buildVo();
		this.iswardattendance = bean.getIsWardAttendance();
		this.wardattendanceoutcome = bean.getWardAttendanceOutcome() == null ? null : ims.core.vo.lookups.WardAttendanceOutcome.buildLookup(bean.getWardAttendanceOutcome());
		this.wardattendanceoutcomecomment = bean.getWardAttendanceOutcomeComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardAttenderAppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.comments = bean.getComments();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
		this.iscabbooking = bean.getIsCABBooking();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.haselectivelist = bean.getHasElectiveList();
		this.wasprinted = bean.getWasPrinted();
		this.bookingletter = bean.getBookingLetter() == null ? null : bean.getBookingLetter().buildVo(map);
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo(map);
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo(map);
		this.bookingcomments = bean.getBookingComments();
		this.currentappttrakingstatus = bean.getCurrentApptTrakingStatus() == null ? null : bean.getCurrentApptTrakingStatus().buildVo(map);
		this.appointmenttrackingstatus = bean.getAppointmentTrackingStatus() == null ? null : bean.getAppointmentTrackingStatus().buildVo(map);
		this.iswardattendance = bean.getIsWardAttendance();
		this.wardattendanceoutcome = bean.getWardAttendanceOutcome() == null ? null : ims.core.vo.lookups.WardAttendanceOutcome.buildLookup(bean.getWardAttendanceOutcome());
		this.wardattendanceoutcomecomment = bean.getWardAttendanceOutcomeComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardAttenderAppointmentVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardAttenderAppointmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardAttenderAppointmentVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("APPTSTARTTIME"))
			return getApptStartTime();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("ISCABBOOKING"))
			return getIsCABBooking();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("HASELECTIVELIST"))
			return getHasElectiveList();
		if(fieldName.equals("WASPRINTED"))
			return getWasPrinted();
		if(fieldName.equals("BOOKINGLETTER"))
			return getBookingLetter();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("ICPINFO"))
			return getICPInfo();
		if(fieldName.equals("BOOKINGCOMMENTS"))
			return getBookingComments();
		if(fieldName.equals("CURRENTAPPTTRAKINGSTATUS"))
			return getCurrentApptTrakingStatus();
		if(fieldName.equals("APPOINTMENTTRACKINGSTATUS"))
			return getAppointmentTrackingStatus();
		if(fieldName.equals("ISWARDATTENDANCE"))
			return getIsWardAttendance();
		if(fieldName.equals("WARDATTENDANCEOUTCOME"))
			return getWardAttendanceOutcome();
		if(fieldName.equals("WARDATTENDANCEOUTCOMECOMMENT"))
			return getWardAttendanceOutcomeComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.Date getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
	}
	public boolean getApptStartTimeIsNotNull()
	{
		return this.apptstarttime != null;
	}
	public ims.framework.utils.Time getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptstarttime = value;
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatus = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityWithImageLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityWithImageLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.SessionLiteWithListOwnerLiteVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.SessionLiteWithListOwnerLiteVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getIsCABBookingIsNotNull()
	{
		return this.iscabbooking != null;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.isValidated = false;
		this.iscabbooking = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getHasElectiveListIsNotNull()
	{
		return this.haselectivelist != null;
	}
	public Boolean getHasElectiveList()
	{
		return this.haselectivelist;
	}
	public void setHasElectiveList(Boolean value)
	{
		this.isValidated = false;
		this.haselectivelist = value;
	}
	public boolean getWasPrintedIsNotNull()
	{
		return this.wasprinted != null;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.isValidated = false;
		this.wasprinted = value;
	}
	public boolean getBookingLetterIsNotNull()
	{
		return this.bookingletter != null;
	}
	public ims.core.vo.PatientDocumentLiteVo getBookingLetter()
	{
		return this.bookingletter;
	}
	public void setBookingLetter(ims.core.vo.PatientDocumentLiteVo value)
	{
		this.isValidated = false;
		this.bookingletter = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.RefMan.vo.CatsReferralBreachDatesVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.CatsReferralBreachDatesVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getICPInfoIsNotNull()
	{
		return this.icpinfo != null;
	}
	public ims.icp.vo.PatientICPLiteVo getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.PatientICPLiteVo value)
	{
		this.isValidated = false;
		this.icpinfo = value;
	}
	public boolean getBookingCommentsIsNotNull()
	{
		return this.bookingcomments != null;
	}
	public String getBookingComments()
	{
		return this.bookingcomments;
	}
	public static int getBookingCommentsMaxLength()
	{
		return 255;
	}
	public void setBookingComments(String value)
	{
		this.isValidated = false;
		this.bookingcomments = value;
	}
	public boolean getCurrentApptTrakingStatusIsNotNull()
	{
		return this.currentappttrakingstatus != null;
	}
	public ims.scheduling.vo.Appt_Tracking_Status_HistoryVo getCurrentApptTrakingStatus()
	{
		return this.currentappttrakingstatus;
	}
	public void setCurrentApptTrakingStatus(ims.scheduling.vo.Appt_Tracking_Status_HistoryVo value)
	{
		this.isValidated = false;
		this.currentappttrakingstatus = value;
	}
	public boolean getAppointmentTrackingStatusIsNotNull()
	{
		return this.appointmenttrackingstatus != null;
	}
	public ims.admin.vo.AppointmentTrackingstatusColourConfigVo getAppointmentTrackingStatus()
	{
		return this.appointmenttrackingstatus;
	}
	public void setAppointmentTrackingStatus(ims.admin.vo.AppointmentTrackingstatusColourConfigVo value)
	{
		this.isValidated = false;
		this.appointmenttrackingstatus = value;
	}
	public boolean getIsWardAttendanceIsNotNull()
	{
		return this.iswardattendance != null;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.isValidated = false;
		this.iswardattendance = value;
	}
	public boolean getWardAttendanceOutcomeIsNotNull()
	{
		return this.wardattendanceoutcome != null;
	}
	public ims.core.vo.lookups.WardAttendanceOutcome getWardAttendanceOutcome()
	{
		return this.wardattendanceoutcome;
	}
	public void setWardAttendanceOutcome(ims.core.vo.lookups.WardAttendanceOutcome value)
	{
		this.isValidated = false;
		this.wardattendanceoutcome = value;
	}
	public boolean getWardAttendanceOutcomeCommentIsNotNull()
	{
		return this.wardattendanceoutcomecomment != null;
	}
	public String getWardAttendanceOutcomeComment()
	{
		return this.wardattendanceoutcomecomment;
	}
	public static int getWardAttendanceOutcomeCommentMaxLength()
	{
		return 1500;
	}
	public void setWardAttendanceOutcomeComment(String value)
	{
		this.isValidated = false;
		this.wardattendanceoutcomecomment = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.WardAttenderAppointmentVo] is too big. It should be less or equal to 500");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.wardattendanceoutcomecomment != null)
			if(this.wardattendanceoutcomecomment.length() > 1500)
				listOfErrors.add("The length of the field [wardattendanceoutcomecomment] in the value object [ims.core.vo.WardAttenderAppointmentVo] is too big. It should be less or equal to 1500");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		WardAttenderAppointmentVo clone = new WardAttenderAppointmentVo(this.id, this.version);
		
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		clone.comments = this.comments;
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityWithImageLiteVo)this.activity.clone();
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.scheduling.vo.SessionLiteWithListOwnerLiteVo)this.session.clone();
		clone.iscabbooking = this.iscabbooking;
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		clone.haselectivelist = this.haselectivelist;
		clone.wasprinted = this.wasprinted;
		if(this.bookingletter == null)
			clone.bookingletter = null;
		else
			clone.bookingletter = (ims.core.vo.PatientDocumentLiteVo)this.bookingletter.clone();
		if(this.referral == null)
			clone.referral = null;
		else
			clone.referral = (ims.RefMan.vo.CatsReferralBreachDatesVo)this.referral.clone();
		if(this.icpinfo == null)
			clone.icpinfo = null;
		else
			clone.icpinfo = (ims.icp.vo.PatientICPLiteVo)this.icpinfo.clone();
		clone.bookingcomments = this.bookingcomments;
		if(this.currentappttrakingstatus == null)
			clone.currentappttrakingstatus = null;
		else
			clone.currentappttrakingstatus = (ims.scheduling.vo.Appt_Tracking_Status_HistoryVo)this.currentappttrakingstatus.clone();
		if(this.appointmenttrackingstatus == null)
			clone.appointmenttrackingstatus = null;
		else
			clone.appointmenttrackingstatus = (ims.admin.vo.AppointmentTrackingstatusColourConfigVo)this.appointmenttrackingstatus.clone();
		clone.iswardattendance = this.iswardattendance;
		if(this.wardattendanceoutcome == null)
			clone.wardattendanceoutcome = null;
		else
			clone.wardattendanceoutcome = (ims.core.vo.lookups.WardAttendanceOutcome)this.wardattendanceoutcome.clone();
		clone.wardattendanceoutcomecomment = this.wardattendanceoutcomecomment;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(WardAttenderAppointmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardAttenderAppointmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WardAttenderAppointmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WardAttenderAppointmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.appointmentdate != null)
			count++;
		if(this.apptstarttime != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.session != null)
			count++;
		if(this.iscabbooking != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.haselectivelist != null)
			count++;
		if(this.wasprinted != null)
			count++;
		if(this.bookingletter != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.icpinfo != null)
			count++;
		if(this.bookingcomments != null)
			count++;
		if(this.currentappttrakingstatus != null)
			count++;
		if(this.appointmenttrackingstatus != null)
			count++;
		if(this.iswardattendance != null)
			count++;
		if(this.wardattendanceoutcome != null)
			count++;
		if(this.wardattendanceoutcomecomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 19;
	}
	protected ims.framework.utils.Date appointmentdate;
	protected ims.framework.utils.Time apptstarttime;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected String comments;
	protected ims.core.vo.ActivityWithImageLiteVo activity;
	protected ims.scheduling.vo.SessionLiteWithListOwnerLiteVo session;
	protected Boolean iscabbooking;
	protected ims.core.vo.PatientShort patient;
	protected Boolean haselectivelist;
	protected Boolean wasprinted;
	protected ims.core.vo.PatientDocumentLiteVo bookingletter;
	protected ims.RefMan.vo.CatsReferralBreachDatesVo referral;
	protected ims.icp.vo.PatientICPLiteVo icpinfo;
	protected String bookingcomments;
	protected ims.scheduling.vo.Appt_Tracking_Status_HistoryVo currentappttrakingstatus;
	protected ims.admin.vo.AppointmentTrackingstatusColourConfigVo appointmenttrackingstatus;
	protected Boolean iswardattendance;
	protected ims.core.vo.lookups.WardAttendanceOutcome wardattendanceoutcome;
	protected String wardattendanceoutcomecomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
