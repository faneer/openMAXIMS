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
 * Linked to Hl7ADTOut.InPatientADTMessageQueue business object (ID: 1103100003).
 */
public class ifInpatientADTVo extends ims.hl7adtout.vo.InPatientADTMessageQueueRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ifInpatientADTVo()
	{
	}
	public ifInpatientADTVo(Integer id, int version)
	{
		super(id, version);
	}
	public ifInpatientADTVo(ims.emergency.vo.beans.ifInpatientADTVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo();
		this.partialadmission = bean.getPartialAdmission() == null ? null : bean.getPartialAdmission().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ifInpatientADTVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo(map);
		this.partialadmission = bean.getPartialAdmission() == null ? null : bean.getPartialAdmission().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ifInpatientADTVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ifInpatientADTVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ifInpatientADTVoBean();
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
		if(fieldName.equals("PARTIALADMISSION"))
			return getPartialAdmission();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.emergency.vo.ifEDAttendanceVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.ifEDAttendanceVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getPartialAdmissionIsNotNull()
	{
		return this.partialadmission != null;
	}
	public ims.emergency.vo.ifPartialAdmissionVo getPartialAdmission()
	{
		return this.partialadmission;
	}
	public void setPartialAdmission(ims.emergency.vo.ifPartialAdmissionVo value)
	{
		this.isValidated = false;
		this.partialadmission = value;
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
	
		ifInpatientADTVo clone = new ifInpatientADTVo(this.id, this.version);
		
		if(this.attendance == null)
			clone.attendance = null;
		else
			clone.attendance = (ims.emergency.vo.ifEDAttendanceVo)this.attendance.clone();
		if(this.partialadmission == null)
			clone.partialadmission = null;
		else
			clone.partialadmission = (ims.emergency.vo.ifPartialAdmissionVo)this.partialadmission.clone();
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
		if (!(ifInpatientADTVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ifInpatientADTVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ifInpatientADTVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ifInpatientADTVo)obj).getBoId());
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
		if(this.partialadmission != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.emergency.vo.ifEDAttendanceVo attendance;
	protected ims.emergency.vo.ifPartialAdmissionVo partialadmission;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
