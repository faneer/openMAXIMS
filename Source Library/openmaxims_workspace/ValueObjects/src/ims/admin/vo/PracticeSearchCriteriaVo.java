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

package ims.admin.vo;


public class PracticeSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PracticeSearchCriteriaVo()
	{
	}
	public PracticeSearchCriteriaVo(ims.admin.vo.beans.PracticeSearchCriteriaVoBean bean)
	{
		this.name = bean.getName();
		this.address = bean.getAddress();
		this.taxonomytype = bean.getTaxonomyType() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getTaxonomyType());
		this.taxonomycode = bean.getTaxonomyCode();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.PracticeSearchCriteriaVoBean bean)
	{
		this.name = bean.getName();
		this.address = bean.getAddress();
		this.taxonomytype = bean.getTaxonomyType() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getTaxonomyType());
		this.taxonomycode = bean.getTaxonomyCode();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.PracticeSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.PracticeSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.PracticeSearchCriteriaVoBean();
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
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public String getAddress()
	{
		return this.address;
	}
	public static int getAddressMaxLength()
	{
		return 255;
	}
	public void setAddress(String value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getTaxonomyTypeIsNotNull()
	{
		return this.taxonomytype != null;
	}
	public ims.core.vo.lookups.TaxonomyType getTaxonomyType()
	{
		return this.taxonomytype;
	}
	public void setTaxonomyType(ims.core.vo.lookups.TaxonomyType value)
	{
		this.isValidated = false;
		this.taxonomytype = value;
	}
	public boolean getTaxonomyCodeIsNotNull()
	{
		return this.taxonomycode != null;
	}
	public String getTaxonomyCode()
	{
		return this.taxonomycode;
	}
	public static int getTaxonomyCodeMaxLength()
	{
		return 255;
	}
	public void setTaxonomyCode(String value)
	{
		this.isValidated = false;
		this.taxonomycode = value;
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
		if(!(obj instanceof PracticeSearchCriteriaVo))
			return false;
		PracticeSearchCriteriaVo compareObj = (PracticeSearchCriteriaVo)obj;
		if(this.getName() == null && compareObj.getName() != null)
			return false;
		if(this.getName() != null && compareObj.getName() == null)
			return false;
		if(this.getName() != null && compareObj.getName() != null)
			if(!this.getName().equals(compareObj.getName()))
				return false;
		if(this.getAddress() == null && compareObj.getAddress() != null)
			return false;
		if(this.getAddress() != null && compareObj.getAddress() == null)
			return false;
		if(this.getAddress() != null && compareObj.getAddress() != null)
			return this.getAddress().equals(compareObj.getAddress());
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
	
		PracticeSearchCriteriaVo clone = new PracticeSearchCriteriaVo();
		
		clone.name = this.name;
		clone.address = this.address;
		if(this.taxonomytype == null)
			clone.taxonomytype = null;
		else
			clone.taxonomytype = (ims.core.vo.lookups.TaxonomyType)this.taxonomytype.clone();
		clone.taxonomycode = this.taxonomycode;
		clone.isactive = this.isactive;
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
		if (!(PracticeSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PracticeSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PracticeSearchCriteriaVo compareObj = (PracticeSearchCriteriaVo)obj;
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
		if(this.address != null)
			count++;
		if(this.taxonomytype != null)
			count++;
		if(this.taxonomycode != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected String address;
	protected ims.core.vo.lookups.TaxonomyType taxonomytype;
	protected String taxonomycode;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
