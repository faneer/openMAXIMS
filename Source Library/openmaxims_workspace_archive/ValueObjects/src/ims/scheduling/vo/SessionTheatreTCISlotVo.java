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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.vo;

/**
 * Linked to Scheduling.SessionTheatreTCISlot business object (ID: 1090100017).
 */
public class SessionTheatreTCISlotVo extends ims.scheduling.vo.SessionTheatreTCISlotLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionTheatreTCISlotVo()
	{
	}
	public SessionTheatreTCISlotVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionTheatreTCISlotVo(ims.scheduling.vo.beans.SessionTheatreTCISlotVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tocomeintime = bean.getToComeInTime() == null ? null : bean.getToComeInTime().buildTime();
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.isactive = bean.getIsActive();
		this.profileslot = bean.getProfileSlot() == null ? null : new ims.scheduling.vo.ProfileTheatreTCISlotRefVo(new Integer(bean.getProfileSlot().getId()), bean.getProfileSlot().getVersion());
		this.sessdatetime = bean.getSessDateTime() == null ? null : bean.getSessDateTime().buildDateTime();
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatusReason());
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionTheatreTCISlotVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tocomeintime = bean.getToComeInTime() == null ? null : bean.getToComeInTime().buildTime();
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.isactive = bean.getIsActive();
		this.profileslot = bean.getProfileSlot() == null ? null : new ims.scheduling.vo.ProfileTheatreTCISlotRefVo(new Integer(bean.getProfileSlot().getId()), bean.getProfileSlot().getVersion());
		this.sessdatetime = bean.getSessDateTime() == null ? null : bean.getSessDateTime().buildDateTime();
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatusReason());
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionTheatreTCISlotVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionTheatreTCISlotVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionTheatreTCISlotVoBean();
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
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("PROFILESLOT"))
			return getProfileSlot();
		if(fieldName.equals("SESSDATETIME"))
			return getSessDateTime();
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("SESSION"))
			return getSession();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getProfileSlotIsNotNull()
	{
		return this.profileslot != null;
	}
	public ims.scheduling.vo.ProfileTheatreTCISlotRefVo getProfileSlot()
	{
		return this.profileslot;
	}
	public void setProfileSlot(ims.scheduling.vo.ProfileTheatreTCISlotRefVo value)
	{
		this.isValidated = false;
		this.profileslot = value;
	}
	public boolean getSessDateTimeIsNotNull()
	{
		return this.sessdatetime != null;
	}
	public ims.framework.utils.DateTime getSessDateTime()
	{
		return this.sessdatetime;
	}
	public void setSessDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.sessdatetime = value;
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.Sch_SessionRefVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.Sch_SessionRefVo value)
	{
		this.isValidated = false;
		this.session = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		SessionTheatreTCISlotVo clone = new SessionTheatreTCISlotVo(this.id, this.version);
		
		if(this.tocomeintime == null)
			clone.tocomeintime = null;
		else
			clone.tocomeintime = (ims.framework.utils.Time)this.tocomeintime.clone();
		clone.appointment = this.appointment;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		clone.isactive = this.isactive;
		clone.profileslot = this.profileslot;
		if(this.sessdatetime == null)
			clone.sessdatetime = null;
		else
			clone.sessdatetime = (ims.framework.utils.DateTime)this.sessdatetime.clone();
		if(this.statusreason == null)
			clone.statusreason = null;
		else
			clone.statusreason = (ims.scheduling.vo.lookups.Status_Reason)this.statusreason.clone();
		clone.session = this.session;
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
		if (!(SessionTheatreTCISlotVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionTheatreTCISlotVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SessionTheatreTCISlotVo compareObj = (SessionTheatreTCISlotVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getToComeInTime() == null && compareObj.getToComeInTime() != null)
				return -1;
			if(this.getToComeInTime() != null && compareObj.getToComeInTime() == null)
				return 1;
			if(this.getToComeInTime() != null && compareObj.getToComeInTime() != null)
				retVal = this.getToComeInTime().compareTo(compareObj.getToComeInTime());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.isactive != null)
			count++;
		if(this.profileslot != null)
			count++;
		if(this.sessdatetime != null)
			count++;
		if(this.statusreason != null)
			count++;
		if(this.session != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected Boolean isactive;
	protected ims.scheduling.vo.ProfileTheatreTCISlotRefVo profileslot;
	protected ims.framework.utils.DateTime sessdatetime;
	protected ims.scheduling.vo.lookups.Status_Reason statusreason;
	protected ims.scheduling.vo.Sch_SessionRefVo session;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
