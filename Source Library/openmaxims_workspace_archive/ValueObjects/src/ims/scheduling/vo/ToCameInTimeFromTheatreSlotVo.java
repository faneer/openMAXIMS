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
public class ToCameInTimeFromTheatreSlotVo extends ims.scheduling.vo.SessionTheatreTCISlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ToCameInTimeFromTheatreSlotVo()
	{
	}
	public ToCameInTimeFromTheatreSlotVo(Integer id, int version)
	{
		super(id, version);
	}
	public ToCameInTimeFromTheatreSlotVo(ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tocomeintime = bean.getToComeInTime() == null ? null : bean.getToComeInTime().buildTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tocomeintime = bean.getToComeInTime() == null ? null : bean.getToComeInTime().buildTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean();
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
		if(fieldName.equals("TOCOMEINTIME"))
			return getToComeInTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getToComeInTimeIsNotNull()
	{
		return this.tocomeintime != null;
	}
	public ims.framework.utils.Time getToComeInTime()
	{
		return this.tocomeintime;
	}
	public void setToComeInTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tocomeintime = value;
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
	
		ToCameInTimeFromTheatreSlotVo clone = new ToCameInTimeFromTheatreSlotVo(this.id, this.version);
		
		if(this.tocomeintime == null)
			clone.tocomeintime = null;
		else
			clone.tocomeintime = (ims.framework.utils.Time)this.tocomeintime.clone();
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
		if (!(ToCameInTimeFromTheatreSlotVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ToCameInTimeFromTheatreSlotVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ToCameInTimeFromTheatreSlotVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ToCameInTimeFromTheatreSlotVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tocomeintime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.framework.utils.Time tocomeintime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
