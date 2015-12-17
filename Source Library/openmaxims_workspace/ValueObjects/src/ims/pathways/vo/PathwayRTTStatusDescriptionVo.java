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

package ims.pathways.vo;

/**
 * Linked to Pathways.Configuration.RTTStatusPoint business object (ID: 1089100012).
 */
public class PathwayRTTStatusDescriptionVo extends ims.pathways.configuration.vo.RTTStatusPointRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathwayRTTStatusDescriptionVo()
	{
	}
	public PathwayRTTStatusDescriptionVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathwayRTTStatusDescriptionVo(ims.pathways.vo.beans.PathwayRTTStatusDescriptionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.nationalcode = bean.getNationalCode();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PathwayRTTStatusDescriptionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.nationalcode = bean.getNationalCode();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PathwayRTTStatusDescriptionVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PathwayRTTStatusDescriptionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PathwayRTTStatusDescriptionVoBean();
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
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("NATIONALCODE"))
			return getNationalCode();
		return super.getFieldValueByFieldName(fieldName);
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
		return 250;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getNationalCodeIsNotNull()
	{
		return this.nationalcode != null;
	}
	public Integer getNationalCode()
	{
		return this.nationalcode;
	}
	public void setNationalCode(Integer value)
	{
		this.isValidated = false;
		this.nationalcode = value;
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
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 250)
			listOfErrors.add("The length of the field [description] in the value object [ims.pathways.vo.PathwayRTTStatusDescriptionVo] is too big. It should be less or equal to 250");
		if(this.nationalcode == null)
			listOfErrors.add("NationalCode is mandatory");
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
	
		PathwayRTTStatusDescriptionVo clone = new PathwayRTTStatusDescriptionVo(this.id, this.version);
		
		clone.description = this.description;
		clone.nationalcode = this.nationalcode;
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
		if (!(PathwayRTTStatusDescriptionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayRTTStatusDescriptionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathwayRTTStatusDescriptionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathwayRTTStatusDescriptionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.description != null)
			count++;
		if(this.nationalcode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String description;
	protected Integer nationalcode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
