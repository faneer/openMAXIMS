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

package ims.core.vo;

/**
 * Linked to core.resource.place.LocationServiceFunction business object (ID: 1007100006).
 */
public class LocationServiceFunctionsVo extends ims.core.resource.place.vo.LocationServiceFunctionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LocationServiceFunctionsVo()
	{
	}
	public LocationServiceFunctionsVo(Integer id, int version)
	{
		super(id, version);
	}
	public LocationServiceFunctionsVo(ims.core.vo.beans.LocationServiceFunctionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicefunction = bean.getServiceFunction() == null ? null : bean.getServiceFunction().buildVo();
		this.isactive = bean.getIsActive();
		this.activities = ims.core.vo.LocationServiceActivityVoCollection.buildFromBeanCollection(bean.getActivities());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.LocationServiceFunctionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicefunction = bean.getServiceFunction() == null ? null : bean.getServiceFunction().buildVo(map);
		this.isactive = bean.getIsActive();
		this.activities = ims.core.vo.LocationServiceActivityVoCollection.buildFromBeanCollection(bean.getActivities());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.LocationServiceFunctionsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.LocationServiceFunctionsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.LocationServiceFunctionsVoBean();
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
		if(fieldName.equals("SERVICEFUNCTION"))
			return getServiceFunction();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceFunctionIsNotNull()
	{
		return this.servicefunction != null;
	}
	public ims.core.vo.ServiceFunctionVo getServiceFunction()
	{
		return this.servicefunction;
	}
	public void setServiceFunction(ims.core.vo.ServiceFunctionVo value)
	{
		this.isValidated = false;
		this.servicefunction = value;
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
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.core.vo.LocationServiceActivityVoCollection getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.core.vo.LocationServiceActivityVoCollection value)
	{
		this.isValidated = false;
		this.activities = value;
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
		if(this.servicefunction != null)
		{
			if(!this.servicefunction.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activities != null)
		{
			if(!this.activities.isValidated())
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
		if(this.servicefunction != null)
		{
			String[] listOfOtherErrors = this.servicefunction.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activities != null)
		{
			String[] listOfOtherErrors = this.activities.validate();
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
	
		LocationServiceFunctionsVo clone = new LocationServiceFunctionsVo(this.id, this.version);
		
		if(this.servicefunction == null)
			clone.servicefunction = null;
		else
			clone.servicefunction = (ims.core.vo.ServiceFunctionVo)this.servicefunction.clone();
		clone.isactive = this.isactive;
		if(this.activities == null)
			clone.activities = null;
		else
			clone.activities = (ims.core.vo.LocationServiceActivityVoCollection)this.activities.clone();
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
		if (!(LocationServiceFunctionsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LocationServiceFunctionsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LocationServiceFunctionsVo compareObj = (LocationServiceFunctionsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_LocationServiceFunction() == null && compareObj.getID_LocationServiceFunction() != null)
				return -1;
			if(this.getID_LocationServiceFunction() != null && compareObj.getID_LocationServiceFunction() == null)
				return 1;
			if(this.getID_LocationServiceFunction() != null && compareObj.getID_LocationServiceFunction() != null)
				retVal = this.getID_LocationServiceFunction().compareTo(compareObj.getID_LocationServiceFunction());
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
		if(this.servicefunction != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.activities != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.ServiceFunctionVo servicefunction;
	protected Boolean isactive;
	protected ims.core.vo.LocationServiceActivityVoCollection activities;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
