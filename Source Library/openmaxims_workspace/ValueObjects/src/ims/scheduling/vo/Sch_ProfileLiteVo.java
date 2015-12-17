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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Profile business object (ID: 1005100001).
 */
public class Sch_ProfileLiteVo extends ims.scheduling.vo.Sch_ProfileRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Sch_ProfileLiteVo()
	{
	}
	public Sch_ProfileLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public Sch_ProfileLiteVo(ims.scheduling.vo.beans.Sch_ProfileLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.isfixed = bean.getIsFixed();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Sch_ProfileLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.isfixed = bean.getIsFixed();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Sch_ProfileLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Sch_ProfileLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Sch_ProfileLiteVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ISFIXED"))
			return getIsFixed();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getIsFixedIsNotNull()
	{
		return this.isfixed != null;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isValidated = false;
		this.isfixed = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.Sch_ProfileLiteVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.Sch_ProfileLiteVo] is too big. It should be less or equal to 255");
		if(this.isfixed == null)
			listOfErrors.add("isFixed is mandatory");
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
	
		Sch_ProfileLiteVo clone = new Sch_ProfileLiteVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.isfixed = this.isfixed;
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
		if (!(Sch_ProfileLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Sch_ProfileLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Sch_ProfileLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Sch_ProfileLiteVo)obj).getBoId());
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
		if(this.description != null)
			count++;
		if(this.isfixed != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected String description;
	protected Boolean isfixed;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
