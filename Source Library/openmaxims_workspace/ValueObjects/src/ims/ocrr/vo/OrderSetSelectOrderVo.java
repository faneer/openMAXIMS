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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.OrderSet business object (ID: 1058100008).
 */
public class OrderSetSelectOrderVo extends ims.ocrr.configuration.vo.OrderSetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderSetSelectOrderVo()
	{
	}
	public OrderSetSelectOrderVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderSetSelectOrderVo(ims.ocrr.vo.beans.OrderSetSelectOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.components = ims.ocrr.vo.ComponentSelectOrderVoCollection.buildFromBeanCollection(bean.getComponents());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderSetSelectOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.components = ims.ocrr.vo.ComponentSelectOrderVoCollection.buildFromBeanCollection(bean.getComponents());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderSetSelectOrderVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderSetSelectOrderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderSetSelectOrderVoBean();
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
		if(fieldName.equals("COMPONENTS"))
			return getComponents();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getComponentsIsNotNull()
	{
		return this.components != null;
	}
	public ims.ocrr.vo.ComponentSelectOrderVoCollection getComponents()
	{
		return this.components;
	}
	public void setComponents(ims.ocrr.vo.ComponentSelectOrderVoCollection value)
	{
		this.isValidated = false;
		this.components = value;
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
		if(this.components != null)
		{
			if(!this.components.isValidated())
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
		if(this.components != null)
		{
			String[] listOfOtherErrors = this.components.validate();
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
	
		OrderSetSelectOrderVo clone = new OrderSetSelectOrderVo(this.id, this.version);
		
		if(this.components == null)
			clone.components = null;
		else
			clone.components = (ims.ocrr.vo.ComponentSelectOrderVoCollection)this.components.clone();
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
		if (!(OrderSetSelectOrderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderSetSelectOrderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OrderSetSelectOrderVo compareObj = (OrderSetSelectOrderVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OrderSet() == null && compareObj.getID_OrderSet() != null)
				return -1;
			if(this.getID_OrderSet() != null && compareObj.getID_OrderSet() == null)
				return 1;
			if(this.getID_OrderSet() != null && compareObj.getID_OrderSet() != null)
				retVal = this.getID_OrderSet().compareTo(compareObj.getID_OrderSet());
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
		if(this.components != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.ocrr.vo.ComponentSelectOrderVoCollection components;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
