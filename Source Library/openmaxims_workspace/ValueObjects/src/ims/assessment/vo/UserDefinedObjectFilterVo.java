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

package ims.assessment.vo;


public class UserDefinedObjectFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserDefinedObjectFilterVo()
	{
	}
	public UserDefinedObjectFilterVo(ims.assessment.vo.beans.UserDefinedObjectFilterVoBean bean)
	{
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserDefinedObjectType.buildLookup(bean.getCategory());
		this.beginswith = bean.getBeginsWith();
		this.contains = bean.getContains();
		this.exacttext = bean.getExactText();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.UserDefinedObjectFilterVoBean bean)
	{
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserDefinedObjectType.buildLookup(bean.getCategory());
		this.beginswith = bean.getBeginsWith();
		this.contains = bean.getContains();
		this.exacttext = bean.getExactText();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.UserDefinedObjectFilterVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.UserDefinedObjectFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.UserDefinedObjectFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.UserDefinedObjectType getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.UserDefinedObjectType value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getBeginsWithIsNotNull()
	{
		return this.beginswith != null;
	}
	public Boolean getBeginsWith()
	{
		return this.beginswith;
	}
	public void setBeginsWith(Boolean value)
	{
		this.isValidated = false;
		this.beginswith = value;
	}
	public boolean getContainsIsNotNull()
	{
		return this.contains != null;
	}
	public Boolean getContains()
	{
		return this.contains;
	}
	public void setContains(Boolean value)
	{
		this.isValidated = false;
		this.contains = value;
	}
	public boolean getExactTextIsNotNull()
	{
		return this.exacttext != null;
	}
	public Boolean getExactText()
	{
		return this.exacttext;
	}
	public void setExactText(Boolean value)
	{
		this.isValidated = false;
		this.exacttext = value;
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
		if(!(obj instanceof UserDefinedObjectFilterVo))
			return false;
		UserDefinedObjectFilterVo compareObj = (UserDefinedObjectFilterVo)obj;
		if(this.getName() == null && compareObj.getName() != null)
			return false;
		if(this.getName() != null && compareObj.getName() == null)
			return false;
		if(this.getName() != null && compareObj.getName() != null)
			return this.getName().equals(compareObj.getName());
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
	
		UserDefinedObjectFilterVo clone = new UserDefinedObjectFilterVo();
		
		clone.name = this.name;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.UserDefinedObjectType)this.category.clone();
		clone.beginswith = this.beginswith;
		clone.contains = this.contains;
		clone.exacttext = this.exacttext;
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
		if (!(UserDefinedObjectFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserDefinedObjectFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserDefinedObjectFilterVo compareObj = (UserDefinedObjectFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.category != null)
			count++;
		if(this.beginswith != null)
			count++;
		if(this.contains != null)
			count++;
		if(this.exacttext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected ims.core.vo.lookups.UserDefinedObjectType category;
	protected Boolean beginswith;
	protected Boolean contains;
	protected Boolean exacttext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
