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

package ims.RefMan.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentForPatientCodingListVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BookingAppointmentForPatientCodingListVo()
	{
	}
	public BookingAppointmentForPatientCodingListVo(Integer id, int version)
	{
		super(id, version);
	}
	public BookingAppointmentForPatientCodingListVo(ims.RefMan.vo.beans.BookingAppointmentForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.pasevent = bean.getPASEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPASEvent().getId()), bean.getPASEvent().getVersion());
		this.theatrebooking = bean.getTheatreBooking() == null ? null : new ims.scheduling.vo.TheatreBookingRefVo(new Integer(bean.getTheatreBooking().getId()), bean.getTheatreBooking().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
		this.sessionslot = bean.getSessionSlot() == null ? null : bean.getSessionSlot().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.BookingAppointmentForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.pasevent = bean.getPASEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPASEvent().getId()), bean.getPASEvent().getVersion());
		this.theatrebooking = bean.getTheatreBooking() == null ? null : new ims.scheduling.vo.TheatreBookingRefVo(new Integer(bean.getTheatreBooking().getId()), bean.getTheatreBooking().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
		this.sessionslot = bean.getSessionSlot() == null ? null : bean.getSessionSlot().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.BookingAppointmentForPatientCodingListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.BookingAppointmentForPatientCodingListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.BookingAppointmentForPatientCodingListVoBean();
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
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("PASEVENT"))
			return getPASEvent();
		if(fieldName.equals("THEATREBOOKING"))
			return getTheatreBooking();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("SESSIONSLOT"))
			return getSessionSlot();
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
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.RefMan.vo.ActivityForPatientCodingListVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.RefMan.vo.ActivityForPatientCodingListVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getPASEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.admin.pas.vo.PASEventRefVo getPASEvent()
	{
		return this.pasevent;
	}
	public void setPASEvent(ims.core.admin.pas.vo.PASEventRefVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getTheatreBookingIsNotNull()
	{
		return this.theatrebooking != null;
	}
	public ims.scheduling.vo.TheatreBookingRefVo getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.TheatreBookingRefVo value)
	{
		this.isValidated = false;
		this.theatrebooking = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.RefMan.vo.Sch_SessionForPatientCodingListVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.RefMan.vo.Sch_SessionForPatientCodingListVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getSessionSlotIsNotNull()
	{
		return this.sessionslot != null;
	}
	public ims.RefMan.vo.SessionSlotForPatientCodingListVo getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.RefMan.vo.SessionSlotForPatientCodingListVo value)
	{
		this.isValidated = false;
		this.sessionslot = value;
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
		if(this.activity != null)
		{
			if(!this.activity.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.activity != null)
		{
			String[] listOfOtherErrors = this.activity.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		BookingAppointmentForPatientCodingListVo clone = new BookingAppointmentForPatientCodingListVo(this.id, this.version);
		
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
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.RefMan.vo.ActivityForPatientCodingListVo)this.activity.clone();
		clone.pasevent = this.pasevent;
		clone.theatrebooking = this.theatrebooking;
		clone.patient = this.patient;
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.RefMan.vo.Sch_SessionForPatientCodingListVo)this.session.clone();
		if(this.sessionslot == null)
			clone.sessionslot = null;
		else
			clone.sessionslot = (ims.RefMan.vo.SessionSlotForPatientCodingListVo)this.sessionslot.clone();
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
		if (!(BookingAppointmentForPatientCodingListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookingAppointmentForPatientCodingListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BookingAppointmentForPatientCodingListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BookingAppointmentForPatientCodingListVo)obj).getBoId());
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
		if(this.activity != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.theatrebooking != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.session != null)
			count++;
		if(this.sessionslot != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.framework.utils.Date appointmentdate;
	protected ims.framework.utils.Time apptstarttime;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.RefMan.vo.ActivityForPatientCodingListVo activity;
	protected ims.core.admin.pas.vo.PASEventRefVo pasevent;
	protected ims.scheduling.vo.TheatreBookingRefVo theatrebooking;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.RefMan.vo.Sch_SessionForPatientCodingListVo session;
	protected ims.RefMan.vo.SessionSlotForPatientCodingListVo sessionslot;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
