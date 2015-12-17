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

package ims.clinical.vo;

/**
 * Linked to clinical.PeriOpSurgeryStartTime business object (ID: 1072100124).
 */
public class PeriOpSurgeryStartTimeVo extends ims.clinical.vo.PeriOpSurgeryStartTimeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PeriOpSurgeryStartTimeVo()
	{
	}
	public PeriOpSurgeryStartTimeVo(Integer id, int version)
	{
		super(id, version);
	}
	public PeriOpSurgeryStartTimeVo(ims.clinical.vo.beans.PeriOpSurgeryStartTimeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.surgerystarttime = bean.getSurgeryStartTime() == null ? null : bean.getSurgeryStartTime().buildDateTime();
		this.recordedby = bean.getRecordedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordedBy().getId()), bean.getRecordedBy().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PeriOpSurgeryStartTimeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.surgerystarttime = bean.getSurgeryStartTime() == null ? null : bean.getSurgeryStartTime().buildDateTime();
		this.recordedby = bean.getRecordedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordedBy().getId()), bean.getRecordedBy().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PeriOpSurgeryStartTimeVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PeriOpSurgeryStartTimeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PeriOpSurgeryStartTimeVoBean();
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
		if(fieldName.equals("THEATREAPPOINTMENT"))
			return getTheatreAppointment();
		if(fieldName.equals("SURGERYSTARTTIME"))
			return getSurgeryStartTime();
		if(fieldName.equals("RECORDEDBY"))
			return getRecordedBy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTheatreAppointmentIsNotNull()
	{
		return this.theatreappointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.theatreappointment = value;
	}
	public boolean getSurgeryStartTimeIsNotNull()
	{
		return this.surgerystarttime != null;
	}
	public ims.framework.utils.DateTime getSurgeryStartTime()
	{
		return this.surgerystarttime;
	}
	public void setSurgeryStartTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.surgerystarttime = value;
	}
	public boolean getRecordedByIsNotNull()
	{
		return this.recordedby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getRecordedBy()
	{
		return this.recordedby;
	}
	public void setRecordedBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.recordedby = value;
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
		if(this.theatreappointment == null)
			listOfErrors.add("TheatreAppointment is mandatory");
		if(this.surgerystarttime == null)
			listOfErrors.add("SurgeryStartTime is mandatory");
		if(this.recordedby == null)
			listOfErrors.add("RecordedBy is mandatory");
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
	
		PeriOpSurgeryStartTimeVo clone = new PeriOpSurgeryStartTimeVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		if(this.surgerystarttime == null)
			clone.surgerystarttime = null;
		else
			clone.surgerystarttime = (ims.framework.utils.DateTime)this.surgerystarttime.clone();
		clone.recordedby = this.recordedby;
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
		if (!(PeriOpSurgeryStartTimeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PeriOpSurgeryStartTimeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PeriOpSurgeryStartTimeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PeriOpSurgeryStartTimeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.theatreappointment != null)
			count++;
		if(this.surgerystarttime != null)
			count++;
		if(this.recordedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected ims.framework.utils.DateTime surgerystarttime;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo recordedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
