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

package ims.emergency.vo;

/**
 * Linked to emergency.Tracking business object (ID: 1086100005).
 */
public class TrackingForTransferVo extends ims.emergency.vo.TrackingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingForTransferVo()
	{
	}
	public TrackingForTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingForTransferVo(ims.emergency.vo.beans.TrackingForTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.currenttransferrecord = bean.getCurrentTransferRecord() == null ? null : bean.getCurrentTransferRecord().buildVo();
		this.isdischarged = bean.getIsDischarged();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo();
		this.currentreferral = bean.getCurrentReferral() == null ? null : bean.getCurrentReferral().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingForTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.currenttransferrecord = bean.getCurrentTransferRecord() == null ? null : bean.getCurrentTransferRecord().buildVo(map);
		this.isdischarged = bean.getIsDischarged();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo(map);
		this.currentreferral = bean.getCurrentReferral() == null ? null : bean.getCurrentReferral().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingForTransferVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingForTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingForTransferVoBean();
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
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("CURRENTTRANSFERRECORD"))
			return getCurrentTransferRecord();
		if(fieldName.equals("ISDISCHARGED"))
			return getIsDischarged();
		if(fieldName.equals("CURRENTAREA"))
			return getCurrentArea();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("CURRENTREFERRAL"))
			return getCurrentReferral();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.emergency.vo.TrackingAttendanceStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.TrackingAttendanceStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getCurrentTransferRecordIsNotNull()
	{
		return this.currenttransferrecord != null;
	}
	public ims.emergency.vo.EDTransferVo getCurrentTransferRecord()
	{
		return this.currenttransferrecord;
	}
	public void setCurrentTransferRecord(ims.emergency.vo.EDTransferVo value)
	{
		this.isValidated = false;
		this.currenttransferrecord = value;
	}
	public boolean getIsDischargedIsNotNull()
	{
		return this.isdischarged != null;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isValidated = false;
		this.isdischarged = value;
	}
	public boolean getCurrentAreaIsNotNull()
	{
		return this.currentarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.currentarea = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.emergency.vo.AttendanceDetailsForTransferVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.AttendanceDetailsForTransferVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getCurrentReferralIsNotNull()
	{
		return this.currentreferral != null;
	}
	public ims.emergency.vo.ReferralToSpecialtyTeamVo getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.emergency.vo.ReferralToSpecialtyTeamVo value)
	{
		this.isValidated = false;
		this.currentreferral = value;
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
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currenttransferrecord != null)
		{
			if(!this.currenttransferrecord.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.attendance != null)
		{
			if(!this.attendance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentreferral != null)
		{
			if(!this.currentreferral.isValidated())
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
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currenttransferrecord != null)
		{
			String[] listOfOtherErrors = this.currenttransferrecord.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.attendance != null)
		{
			String[] listOfOtherErrors = this.attendance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentreferral != null)
		{
			String[] listOfOtherErrors = this.currentreferral.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		TrackingForTransferVo clone = new TrackingForTransferVo(this.id, this.version);
		
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.emergency.vo.TrackingAttendanceStatusVo)this.currentstatus.clone();
		if(this.currenttransferrecord == null)
			clone.currenttransferrecord = null;
		else
			clone.currenttransferrecord = (ims.emergency.vo.EDTransferVo)this.currenttransferrecord.clone();
		clone.isdischarged = this.isdischarged;
		clone.currentarea = this.currentarea;
		if(this.attendance == null)
			clone.attendance = null;
		else
			clone.attendance = (ims.emergency.vo.AttendanceDetailsForTransferVo)this.attendance.clone();
		if(this.currentreferral == null)
			clone.currentreferral = null;
		else
			clone.currentreferral = (ims.emergency.vo.ReferralToSpecialtyTeamVo)this.currentreferral.clone();
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
		if (!(TrackingForTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingForTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingForTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingForTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentstatus != null)
			count++;
		if(this.currenttransferrecord != null)
			count++;
		if(this.isdischarged != null)
			count++;
		if(this.currentarea != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.currentreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.emergency.vo.TrackingAttendanceStatusVo currentstatus;
	protected ims.emergency.vo.EDTransferVo currenttransferrecord;
	protected Boolean isdischarged;
	protected ims.emergency.configuration.vo.TrackingAreaRefVo currentarea;
	protected ims.emergency.vo.AttendanceDetailsForTransferVo attendance;
	protected ims.emergency.vo.ReferralToSpecialtyTeamVo currentreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
