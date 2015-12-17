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


public class IfLookupInstanceVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfLookupInstanceVo()
	{
	}
	public IfLookupInstanceVo(ims.core.vo.beans.IfLookupInstanceVoBean bean)
	{
		this.verb = bean.getVerb();
		this.instancename = bean.getInstanceName();
		this.code = bean.getCode();
		this.system = bean.getSystem();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.IfLookupInstanceVoBean bean)
	{
		this.verb = bean.getVerb();
		this.instancename = bean.getInstanceName();
		this.code = bean.getCode();
		this.system = bean.getSystem();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.IfLookupInstanceVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.IfLookupInstanceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.IfLookupInstanceVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getVerbIsNotNull()
	{
		return this.verb != null;
	}
	public String getVerb()
	{
		return this.verb;
	}
	public static int getVerbMaxLength()
	{
		return 255;
	}
	public void setVerb(String value)
	{
		this.isValidated = false;
		this.verb = value;
	}
	public boolean getInstanceNameIsNotNull()
	{
		return this.instancename != null;
	}
	public String getInstanceName()
	{
		return this.instancename;
	}
	public static int getInstanceNameMaxLength()
	{
		return 255;
	}
	public void setInstanceName(String value)
	{
		this.isValidated = false;
		this.instancename = value;
	}
	public boolean getCodeIsNotNull()
	{
		return this.code != null;
	}
	public String getCode()
	{
		return this.code;
	}
	public static int getCodeMaxLength()
	{
		return 255;
	}
	public void setCode(String value)
	{
		this.isValidated = false;
		this.code = value;
	}
	public boolean getSystemIsNotNull()
	{
		return this.system != null;
	}
	public String getSystem()
	{
		return this.system;
	}
	public static int getSystemMaxLength()
	{
		return 255;
	}
	public void setSystem(String value)
	{
		this.isValidated = false;
		this.system = value;
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
		if(!(obj instanceof IfLookupInstanceVo))
			return false;
		IfLookupInstanceVo compareObj = (IfLookupInstanceVo)obj;
		if(this.getVerb() == null && compareObj.getVerb() != null)
			return false;
		if(this.getVerb() != null && compareObj.getVerb() == null)
			return false;
		if(this.getVerb() != null && compareObj.getVerb() != null)
			if(!this.getVerb().equals(compareObj.getVerb()))
				return false;
		if(this.getInstanceName() == null && compareObj.getInstanceName() != null)
			return false;
		if(this.getInstanceName() != null && compareObj.getInstanceName() == null)
			return false;
		if(this.getInstanceName() != null && compareObj.getInstanceName() != null)
			if(!this.getInstanceName().equals(compareObj.getInstanceName()))
				return false;
		if(this.getCode() == null && compareObj.getCode() != null)
			return false;
		if(this.getCode() != null && compareObj.getCode() == null)
			return false;
		if(this.getCode() != null && compareObj.getCode() != null)
			if(!this.getCode().equals(compareObj.getCode()))
				return false;
		if(this.getSystem() == null && compareObj.getSystem() != null)
			return false;
		if(this.getSystem() != null && compareObj.getSystem() == null)
			return false;
		if(this.getSystem() != null && compareObj.getSystem() != null)
			return this.getSystem().equals(compareObj.getSystem());
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
	
		IfLookupInstanceVo clone = new IfLookupInstanceVo();
		
		clone.verb = this.verb;
		clone.instancename = this.instancename;
		clone.code = this.code;
		clone.system = this.system;
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
		if (!(IfLookupInstanceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfLookupInstanceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		IfLookupInstanceVo compareObj = (IfLookupInstanceVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getVerb() == null && compareObj.getVerb() != null)
				return -1;
			if(this.getVerb() != null && compareObj.getVerb() == null)
				return 1;
			if(this.getVerb() != null && compareObj.getVerb() != null)
			{
				if(caseInsensitive)
					retVal = this.getVerb().toLowerCase().compareTo(compareObj.getVerb().toLowerCase());
				else
					retVal = this.getVerb().compareTo(compareObj.getVerb());
			}
		}
		if (retVal == 0)
		{
			if(this.getInstanceName() == null && compareObj.getInstanceName() != null)
				return -1;
			if(this.getInstanceName() != null && compareObj.getInstanceName() == null)
				return 1;
			if(this.getInstanceName() != null && compareObj.getInstanceName() != null)
			{
				if(caseInsensitive)
					retVal = this.getInstanceName().toLowerCase().compareTo(compareObj.getInstanceName().toLowerCase());
				else
					retVal = this.getInstanceName().compareTo(compareObj.getInstanceName());
			}
		}
		if (retVal == 0)
		{
			if(this.getCode() == null && compareObj.getCode() != null)
				return -1;
			if(this.getCode() != null && compareObj.getCode() == null)
				return 1;
			if(this.getCode() != null && compareObj.getCode() != null)
			{
				if(caseInsensitive)
					retVal = this.getCode().toLowerCase().compareTo(compareObj.getCode().toLowerCase());
				else
					retVal = this.getCode().compareTo(compareObj.getCode());
			}
		}
		if (retVal == 0)
		{
			if(this.getSystem() == null && compareObj.getSystem() != null)
				return -1;
			if(this.getSystem() != null && compareObj.getSystem() == null)
				return 1;
			if(this.getSystem() != null && compareObj.getSystem() != null)
			{
				if(caseInsensitive)
					retVal = this.getSystem().toLowerCase().compareTo(compareObj.getSystem().toLowerCase());
				else
					retVal = this.getSystem().compareTo(compareObj.getSystem());
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
		if(this.verb != null)
			count++;
		if(this.instancename != null)
			count++;
		if(this.code != null)
			count++;
		if(this.system != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String verb;
	protected String instancename;
	protected String code;
	protected String system;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
