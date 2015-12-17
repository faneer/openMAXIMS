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

package ims.nursing.vo;


public class LastHeightMetricRecordVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LastHeightMetricRecordVo()
	{
	}
	public LastHeightMetricRecordVo(ims.nursing.vo.beans.LastHeightMetricRecordVoBean bean)
	{
		this.value = bean.getValue();
		this.measured = bean.getMeasured();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.LastHeightMetricRecordVoBean bean)
	{
		this.value = bean.getValue();
		this.measured = bean.getMeasured();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.LastHeightMetricRecordVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.LastHeightMetricRecordVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.LastHeightMetricRecordVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getValueIsNotNull()
	{
		return this.value != null;
	}
	public Float getValue()
	{
		return this.value;
	}
	public void setValue(Float value)
	{
		this.isValidated = false;
		this.value = value;
	}
	public boolean getMeasuredIsNotNull()
	{
		return this.measured != null;
	}
	public Boolean getMeasured()
	{
		return this.measured;
	}
	public void setMeasured(Boolean value)
	{
		this.isValidated = false;
		this.measured = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof LastHeightMetricRecordVo))
			return false;
		LastHeightMetricRecordVo compareObj = (LastHeightMetricRecordVo)obj;
		if(this.getValue() == null && compareObj.getValue() != null)
			return false;
		if(this.getValue() != null && compareObj.getValue() == null)
			return false;
		if(this.getValue() != null && compareObj.getValue() != null)
			if(!this.getValue().equals(compareObj.getValue()))
				return false;
		if(this.getMeasured() == null && compareObj.getMeasured() != null)
			return false;
		if(this.getMeasured() != null && compareObj.getMeasured() == null)
			return false;
		if(this.getMeasured() != null && compareObj.getMeasured() != null)
			return this.getMeasured().equals(compareObj.getMeasured());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		LastHeightMetricRecordVo clone = new LastHeightMetricRecordVo();
		
		clone.value = this.value;
		clone.measured = this.measured;
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
		if (!(LastHeightMetricRecordVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LastHeightMetricRecordVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LastHeightMetricRecordVo compareObj = (LastHeightMetricRecordVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getValue() == null && compareObj.getValue() != null)
				return -1;
			if(this.getValue() != null && compareObj.getValue() == null)
				return 1;
			if(this.getValue() != null && compareObj.getValue() != null)
				retVal = this.getValue().compareTo(compareObj.getValue());
		}
		if (retVal == 0)
		{
			if(this.getMeasured() == null && compareObj.getMeasured() != null)
				return -1;
			if(this.getMeasured() != null && compareObj.getMeasured() == null)
				return 1;
			if(this.getMeasured() != null && compareObj.getMeasured() != null)
				retVal = this.getMeasured().compareTo(compareObj.getMeasured());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.value != null)
			count++;
		if(this.measured != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Float value;
	protected Boolean measured;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
