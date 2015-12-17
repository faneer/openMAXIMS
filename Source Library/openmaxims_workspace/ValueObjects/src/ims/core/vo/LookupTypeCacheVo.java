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


public class LookupTypeCacheVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LookupTypeCacheVo()
	{
	}
	public LookupTypeCacheVo(ims.core.vo.beans.LookupTypeCacheVoBean bean)
	{
		this.lookuptype = bean.getLookupType() == null ? null : bean.getLookupType().buildLookupTypeVo();
		this.lookupinstances = ims.vo.LookupInstanceBean.buildLookupInstanceVoCollection(bean.getLookupInstances());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.LookupTypeCacheVoBean bean)
	{
		this.lookuptype = bean.getLookupType() == null ? null : bean.getLookupType().buildLookupTypeVo();
		this.lookupinstances = ims.vo.LookupInstanceBean.buildLookupInstanceVoCollection(bean.getLookupInstances());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.LookupTypeCacheVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.LookupTypeCacheVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.LookupTypeCacheVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getLookupTypeIsNotNull()
	{
		return this.lookuptype != null;
	}
	public ims.vo.LookupTypeVo getLookupType()
	{
		return this.lookuptype;
	}
	public void setLookupType(ims.vo.LookupTypeVo value)
	{
		this.isValidated = false;
		this.lookuptype = value;
	}
	public boolean getLookupInstancesIsNotNull()
	{
		return this.lookupinstances != null;
	}
	public ims.vo.LookupInstanceCollection getLookupInstances()
	{
		return this.lookupinstances;
	}
	public void setLookupInstances(ims.vo.LookupInstanceCollection value)
	{
		this.isValidated = false;
		this.lookupinstances = value;
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
		if(!(obj instanceof LookupTypeCacheVo))
			return false;
		LookupTypeCacheVo compareObj = (LookupTypeCacheVo)obj;
		if(this.getLookupType() == null && compareObj.getLookupType() != null)
			return false;
		if(this.getLookupType() != null && compareObj.getLookupType() == null)
			return false;
		if(this.getLookupType() != null && compareObj.getLookupType() != null)
			return this.getLookupType().equals(compareObj.getLookupType());
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
	
		LookupTypeCacheVo clone = new LookupTypeCacheVo();
		
		if(this.lookuptype == null)
			clone.lookuptype = null;
		else
			clone.lookuptype = (ims.vo.LookupTypeVo)this.lookuptype.clone();
		clone.lookupinstances = this.lookupinstances;
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
		if (!(LookupTypeCacheVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LookupTypeCacheVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LookupTypeCacheVo compareObj = (LookupTypeCacheVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getLookupType() == null && compareObj.getLookupType() != null)
				return -1;
			if(this.getLookupType() != null && compareObj.getLookupType() == null)
				return 1;
			if(this.getLookupType() != null && compareObj.getLookupType() != null)
				retVal = this.getLookupType().compareTo(compareObj.getLookupType());
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
		if(this.lookuptype != null)
			count++;
		if(this.lookupinstances != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.vo.LookupTypeVo lookuptype;
	protected ims.vo.LookupInstanceCollection lookupinstances;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
