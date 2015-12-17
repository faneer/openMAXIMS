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

package ims.emergency.vo;

/**
 * Linked to emergency.TrackingAttendanceStatus business object (ID: 1086100013).
 */
public class TrackingAttendanceStatusForEventHistoryVo extends ims.emergency.vo.TrackingAttendanceStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingAttendanceStatusForEventHistoryVo()
	{
	}
	public TrackingAttendanceStatusForEventHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingAttendanceStatusForEventHistoryVo(ims.emergency.vo.beans.TrackingAttendanceStatusForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : bean.getTrackingArea().buildVo();
		this.statusdatetime = bean.getStatusDatetime() == null ? null : bean.getStatusDatetime().buildDateTime();
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingAttendanceStatusForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : bean.getTrackingArea().buildVo(map);
		this.statusdatetime = bean.getStatusDatetime() == null ? null : bean.getStatusDatetime().buildDateTime();
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingAttendanceStatusForEventHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingAttendanceStatusForEventHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingAttendanceStatusForEventHistoryVoBean();
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
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("TRACKINGAREA"))
			return getTrackingArea();
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDatetime();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getTrackingAreaIsNotNull()
	{
		return this.trackingarea != null;
	}
	public ims.emergency.vo.TrackingAreaLiteVo getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.emergency.vo.TrackingAreaLiteVo value)
	{
		this.isValidated = false;
		this.trackingarea = value;
	}
	public boolean getStatusDatetimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDatetime()
	{
		return this.statusdatetime;
	}
	public void setStatusDatetime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.emergency.vo.lookups.TrackingStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.emergency.vo.lookups.TrackingStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.trackingarea == null)
			listOfErrors.add("TrackingArea is mandatory");
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDatetime is mandatory");
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
	
		TrackingAttendanceStatusForEventHistoryVo clone = new TrackingAttendanceStatusForEventHistoryVo(this.id, this.version);
		
		clone.attendance = this.attendance;
		if(this.trackingarea == null)
			clone.trackingarea = null;
		else
			clone.trackingarea = (ims.emergency.vo.TrackingAreaLiteVo)this.trackingarea.clone();
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.emergency.vo.lookups.TrackingStatus)this.status.clone();
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
		if (!(TrackingAttendanceStatusForEventHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingAttendanceStatusForEventHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingAttendanceStatusForEventHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingAttendanceStatusForEventHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.attendance != null)
			count++;
		if(this.trackingarea != null)
			count++;
		if(this.statusdatetime != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.vo.TrackingAreaLiteVo trackingarea;
	protected ims.framework.utils.DateTime statusdatetime;
	protected ims.emergency.vo.lookups.TrackingStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
