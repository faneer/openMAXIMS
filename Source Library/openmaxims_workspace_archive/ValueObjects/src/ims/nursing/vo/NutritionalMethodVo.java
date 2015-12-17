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

/**
 * Linked to nursing.assessment.Nutritional Method business object (ID: 1015100022).
 */
public class NutritionalMethodVo extends ims.nursing.assessment.vo.NutritionalMethodRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NutritionalMethodVo()
	{
	}
	public NutritionalMethodVo(Integer id, int version)
	{
		super(id, version);
	}
	public NutritionalMethodVo(ims.nursing.vo.beans.NutritionalMethodVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nutritionalmethod = bean.getNutritionalMethod() == null ? null : ims.nursing.vo.lookups.NutritionalMethod.buildLookup(bean.getNutritionalMethod());
		this.site = bean.getSite() == null ? null : ims.nursing.vo.lookups.NutritionalMethodSite.buildLookup(bean.getSite());
		this.size = bean.getSize();
		this.type = bean.getType() == null ? null : ims.nursing.vo.lookups.NutritionalMethodType.buildLookup(bean.getType());
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.datechangedue = bean.getDateChangeDue() == null ? null : bean.getDateChangeDue().buildDate();
		this.details = bean.getDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.NutritionalMethodVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nutritionalmethod = bean.getNutritionalMethod() == null ? null : ims.nursing.vo.lookups.NutritionalMethod.buildLookup(bean.getNutritionalMethod());
		this.site = bean.getSite() == null ? null : ims.nursing.vo.lookups.NutritionalMethodSite.buildLookup(bean.getSite());
		this.size = bean.getSize();
		this.type = bean.getType() == null ? null : ims.nursing.vo.lookups.NutritionalMethodType.buildLookup(bean.getType());
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.datechangedue = bean.getDateChangeDue() == null ? null : bean.getDateChangeDue().buildDate();
		this.details = bean.getDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.NutritionalMethodVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.NutritionalMethodVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.NutritionalMethodVoBean();
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
		if(fieldName.equals("NUTRITIONALMETHOD"))
			return getNutritionalMethod();
		if(fieldName.equals("SITE"))
			return getSite();
		if(fieldName.equals("SIZE"))
			return getSize();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("DATEINSERTED"))
			return getDateInserted();
		if(fieldName.equals("DATECHANGEDUE"))
			return getDateChangeDue();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNutritionalMethodIsNotNull()
	{
		return this.nutritionalmethod != null;
	}
	public ims.nursing.vo.lookups.NutritionalMethod getNutritionalMethod()
	{
		return this.nutritionalmethod;
	}
	public void setNutritionalMethod(ims.nursing.vo.lookups.NutritionalMethod value)
	{
		this.isValidated = false;
		this.nutritionalmethod = value;
	}
	public boolean getSiteIsNotNull()
	{
		return this.site != null;
	}
	public ims.nursing.vo.lookups.NutritionalMethodSite getSite()
	{
		return this.site;
	}
	public void setSite(ims.nursing.vo.lookups.NutritionalMethodSite value)
	{
		this.isValidated = false;
		this.site = value;
	}
	public boolean getSizeIsNotNull()
	{
		return this.size != null;
	}
	public String getSize()
	{
		return this.size;
	}
	public static int getSizeMaxLength()
	{
		return 255;
	}
	public void setSize(String value)
	{
		this.isValidated = false;
		this.size = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.nursing.vo.lookups.NutritionalMethodType getType()
	{
		return this.type;
	}
	public void setType(ims.nursing.vo.lookups.NutritionalMethodType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getDateInsertedIsNotNull()
	{
		return this.dateinserted != null;
	}
	public ims.framework.utils.Date getDateInserted()
	{
		return this.dateinserted;
	}
	public void setDateInserted(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateinserted = value;
	}
	public boolean getDateChangeDueIsNotNull()
	{
		return this.datechangedue != null;
	}
	public ims.framework.utils.Date getDateChangeDue()
	{
		return this.datechangedue;
	}
	public void setDateChangeDue(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datechangedue = value;
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
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
	
		NutritionalMethodVo clone = new NutritionalMethodVo(this.id, this.version);
		
		if(this.nutritionalmethod == null)
			clone.nutritionalmethod = null;
		else
			clone.nutritionalmethod = (ims.nursing.vo.lookups.NutritionalMethod)this.nutritionalmethod.clone();
		if(this.site == null)
			clone.site = null;
		else
			clone.site = (ims.nursing.vo.lookups.NutritionalMethodSite)this.site.clone();
		clone.size = this.size;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.nursing.vo.lookups.NutritionalMethodType)this.type.clone();
		if(this.dateinserted == null)
			clone.dateinserted = null;
		else
			clone.dateinserted = (ims.framework.utils.Date)this.dateinserted.clone();
		if(this.datechangedue == null)
			clone.datechangedue = null;
		else
			clone.datechangedue = (ims.framework.utils.Date)this.datechangedue.clone();
		clone.details = this.details;
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
		if (!(NutritionalMethodVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NutritionalMethodVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NutritionalMethodVo compareObj = (NutritionalMethodVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_NutritionalMethod() == null && compareObj.getID_NutritionalMethod() != null)
				return -1;
			if(this.getID_NutritionalMethod() != null && compareObj.getID_NutritionalMethod() == null)
				return 1;
			if(this.getID_NutritionalMethod() != null && compareObj.getID_NutritionalMethod() != null)
				retVal = this.getID_NutritionalMethod().compareTo(compareObj.getID_NutritionalMethod());
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
		if(this.nutritionalmethod != null)
			count++;
		if(this.site != null)
			count++;
		if(this.size != null)
			count++;
		if(this.type != null)
			count++;
		if(this.dateinserted != null)
			count++;
		if(this.datechangedue != null)
			count++;
		if(this.details != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.nursing.vo.lookups.NutritionalMethod nutritionalmethod;
	protected ims.nursing.vo.lookups.NutritionalMethodSite site;
	protected String size;
	protected ims.nursing.vo.lookups.NutritionalMethodType type;
	protected ims.framework.utils.Date dateinserted;
	protected ims.framework.utils.Date datechangedue;
	protected String details;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
