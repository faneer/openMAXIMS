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
 * Linked to OCRR.Configuration.TemplateLocation business object (ID: 1061100007).
 */
public class TemplateLocationShortVo extends ims.ocrr.configuration.vo.TemplateLocationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TemplateLocationShortVo()
	{
	}
	public TemplateLocationShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public TemplateLocationShortVo(ims.ocrr.vo.beans.TemplateLocationShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.oetemplate = bean.getOETemplate() == null ? null : bean.getOETemplate().buildVo();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.TemplateLocationShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.oetemplate = bean.getOETemplate() == null ? null : bean.getOETemplate().buildVo(map);
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.TemplateLocationShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.TemplateLocationShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.TemplateLocationShortVoBean();
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
		if(fieldName.equals("OETEMPLATE"))
			return getOETemplate();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOETemplateIsNotNull()
	{
		return this.oetemplate != null;
	}
	public ims.ocrr.vo.OrderEntryTemplateBaseVo getOETemplate()
	{
		return this.oetemplate;
	}
	public void setOETemplate(ims.ocrr.vo.OrderEntryTemplateBaseVo value)
	{
		this.isValidated = false;
		this.oetemplate = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocSiteShortVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocSiteShortVo value)
	{
		this.isValidated = false;
		this.location = value;
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
		if(this.oetemplate != null)
		{
			if(!this.oetemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.location != null)
		{
			if(!this.location.isValidated())
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
		if(this.oetemplate == null)
			listOfErrors.add("OETemplate is mandatory");
		if(this.oetemplate != null)
		{
			String[] listOfOtherErrors = this.oetemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.location == null)
			listOfErrors.add("Location is mandatory");
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		TemplateLocationShortVo clone = new TemplateLocationShortVo(this.id, this.version);
		
		if(this.oetemplate == null)
			clone.oetemplate = null;
		else
			clone.oetemplate = (ims.ocrr.vo.OrderEntryTemplateBaseVo)this.oetemplate.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocSiteShortVo)this.location.clone();
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
		if (!(TemplateLocationShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TemplateLocationShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TemplateLocationShortVo compareObj = (TemplateLocationShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getLocation() == null && compareObj.getLocation() != null)
				return -1;
			if(this.getLocation() != null && compareObj.getLocation() == null)
				return 1;
			if(this.getLocation() != null && compareObj.getLocation() != null)
				retVal = this.getLocation().compareTo(compareObj.getLocation());
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
		if(this.oetemplate != null)
			count++;
		if(this.location != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.ocrr.vo.OrderEntryTemplateBaseVo oetemplate;
	protected ims.core.vo.LocSiteShortVo location;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
