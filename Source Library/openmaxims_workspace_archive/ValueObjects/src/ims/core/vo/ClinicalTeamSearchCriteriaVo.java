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


public class ClinicalTeamSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalTeamSearchCriteriaVo()
	{
	}
	public ClinicalTeamSearchCriteriaVo(ims.core.vo.beans.ClinicalTeamSearchCriteriaVoBean bean)
	{
		this.teamtype = bean.getTeamType() == null ? null : ims.core.vo.lookups.ClinicalTeamType.buildLookup(bean.getTeamType());
		this.teamname = bean.getTeamName();
		this.active = bean.getActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ClinicalTeamSearchCriteriaVoBean bean)
	{
		this.teamtype = bean.getTeamType() == null ? null : ims.core.vo.lookups.ClinicalTeamType.buildLookup(bean.getTeamType());
		this.teamname = bean.getTeamName();
		this.active = bean.getActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ClinicalTeamSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ClinicalTeamSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ClinicalTeamSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getTeamTypeIsNotNull()
	{
		return this.teamtype != null;
	}
	public ims.core.vo.lookups.ClinicalTeamType getTeamType()
	{
		return this.teamtype;
	}
	public void setTeamType(ims.core.vo.lookups.ClinicalTeamType value)
	{
		this.isValidated = false;
		this.teamtype = value;
	}
	public boolean getTeamNameIsNotNull()
	{
		return this.teamname != null;
	}
	public String getTeamName()
	{
		return this.teamname;
	}
	public static int getTeamNameMaxLength()
	{
		return 255;
	}
	public void setTeamName(String value)
	{
		this.isValidated = false;
		this.teamname = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
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
		if(!(obj instanceof ClinicalTeamSearchCriteriaVo))
			return false;
		ClinicalTeamSearchCriteriaVo compareObj = (ClinicalTeamSearchCriteriaVo)obj;
		if(this.getTeamName() == null && compareObj.getTeamName() != null)
			return false;
		if(this.getTeamName() != null && compareObj.getTeamName() == null)
			return false;
		if(this.getTeamName() != null && compareObj.getTeamName() != null)
			return this.getTeamName().equals(compareObj.getTeamName());
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
	
		ClinicalTeamSearchCriteriaVo clone = new ClinicalTeamSearchCriteriaVo();
		
		if(this.teamtype == null)
			clone.teamtype = null;
		else
			clone.teamtype = (ims.core.vo.lookups.ClinicalTeamType)this.teamtype.clone();
		clone.teamname = this.teamname;
		clone.active = this.active;
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
		if (!(ClinicalTeamSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalTeamSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalTeamSearchCriteriaVo compareObj = (ClinicalTeamSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTeamName() == null && compareObj.getTeamName() != null)
				return -1;
			if(this.getTeamName() != null && compareObj.getTeamName() == null)
				return 1;
			if(this.getTeamName() != null && compareObj.getTeamName() != null)
			{
				if(caseInsensitive)
					retVal = this.getTeamName().toLowerCase().compareTo(compareObj.getTeamName().toLowerCase());
				else
					retVal = this.getTeamName().compareTo(compareObj.getTeamName());
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
		if(this.teamtype != null)
			count++;
		if(this.teamname != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.ClinicalTeamType teamtype;
	protected String teamname;
	protected Boolean active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
