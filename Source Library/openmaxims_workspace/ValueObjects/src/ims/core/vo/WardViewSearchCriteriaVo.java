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

package ims.core.vo;


public class WardViewSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardViewSearchCriteriaVo()
	{
	}
	public WardViewSearchCriteriaVo(ims.core.vo.beans.WardViewSearchCriteriaVoBean bean)
	{
		// Interface field type not supported.
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardViewSearchCriteriaVoBean bean)
	{
		// Interface field type not supported.
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardViewSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardViewSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardViewSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.framework.interfaces.ILocation getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.framework.interfaces.ILocation value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getBayIsNotNull()
	{
		return this.bay != null;
	}
	public ims.core.vo.LocationLiteVo getBay()
	{
		return this.bay;
	}
	public void setBay(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.bay = value;
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
		if(!(obj instanceof WardViewSearchCriteriaVo))
			return false;
		WardViewSearchCriteriaVo compareObj = (WardViewSearchCriteriaVo)obj;
		if(this.getWard() == null && compareObj.getWard() != null)
			return false;
		if(this.getWard() != null && compareObj.getWard() == null)
			return false;
		if(this.getWard() != null && compareObj.getWard() != null)
			if(!this.getWard().equals(compareObj.getWard()))
				return false;
		if(this.getBay() == null && compareObj.getBay() != null)
			return false;
		if(this.getBay() != null && compareObj.getBay() == null)
			return false;
		if(this.getBay() != null && compareObj.getBay() != null)
			return this.getBay().equals(compareObj.getBay());
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
	
		WardViewSearchCriteriaVo clone = new WardViewSearchCriteriaVo();
		
		clone.hospital = this.hospital;
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.bay == null)
			clone.bay = null;
		else
			clone.bay = (ims.core.vo.LocationLiteVo)this.bay.clone();
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
		if (!(WardViewSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardViewSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardViewSearchCriteriaVo compareObj = (WardViewSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWard() == null && compareObj.getWard() != null)
				return -1;
			if(this.getWard() != null && compareObj.getWard() == null)
				return 1;
			if(this.getWard() != null && compareObj.getWard() != null)
				retVal = this.getWard().compareTo(compareObj.getWard());
		}
		if (retVal == 0)
		{
			if(this.getBay() == null && compareObj.getBay() != null)
				return -1;
			if(this.getBay() != null && compareObj.getBay() == null)
				return 1;
			if(this.getBay() != null && compareObj.getBay() != null)
				retVal = this.getBay().compareTo(compareObj.getBay());
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
		if(this.hospital != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.bay != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.interfaces.ILocation hospital;
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.LocationLiteVo bay;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
