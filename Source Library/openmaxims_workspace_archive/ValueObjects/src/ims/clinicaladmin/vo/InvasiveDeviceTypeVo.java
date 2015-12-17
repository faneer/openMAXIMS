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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.InvasiveDeviceType business object (ID: 1073100016).
 */
public class InvasiveDeviceTypeVo extends ims.clinical.configuration.vo.InvasiveDeviceTypeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InvasiveDeviceTypeVo()
	{
	}
	public InvasiveDeviceTypeVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvasiveDeviceTypeVo(ims.clinicaladmin.vo.beans.InvasiveDeviceTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType();
		this.durationint = bean.getDurationInt();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getDurationUnit());
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.InvasiveDeviceTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType();
		this.durationint = bean.getDurationInt();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getDurationUnit());
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.InvasiveDeviceTypeVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.InvasiveDeviceTypeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.InvasiveDeviceTypeVoBean();
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
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("DURATIONINT"))
			return getDurationInt();
		if(fieldName.equals("DURATIONUNIT"))
			return getDurationUnit();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public String getType()
	{
		return this.type;
	}
	public static int getTypeMaxLength()
	{
		return 50;
	}
	public void setType(String value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getDurationIntIsNotNull()
	{
		return this.durationint != null;
	}
	public Integer getDurationInt()
	{
		return this.durationint;
	}
	public void setDurationInt(Integer value)
	{
		this.isValidated = false;
		this.durationint = value;
	}
	public boolean getDurationUnitIsNotNull()
	{
		return this.durationunit != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToMonths getDurationUnit()
	{
		return this.durationunit;
	}
	public void setDurationUnit(ims.core.vo.lookups.TimeUnitsSecondsToMonths value)
	{
		this.isValidated = false;
		this.durationunit = value;
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
		if(this.type == null || this.type.length() == 0)
			listOfErrors.add("Type is mandatory");
		else if(this.type.length() > 50)
			listOfErrors.add("The length of the field [type] in the value object [ims.clinicaladmin.vo.InvasiveDeviceTypeVo] is too big. It should be less or equal to 50");
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
	
		InvasiveDeviceTypeVo clone = new InvasiveDeviceTypeVo(this.id, this.version);
		
		clone.type = this.type;
		clone.durationint = this.durationint;
		if(this.durationunit == null)
			clone.durationunit = null;
		else
			clone.durationunit = (ims.core.vo.lookups.TimeUnitsSecondsToMonths)this.durationunit.clone();
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
		if (!(InvasiveDeviceTypeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvasiveDeviceTypeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InvasiveDeviceTypeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InvasiveDeviceTypeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.type != null)
			count++;
		if(this.durationint != null)
			count++;
		if(this.durationunit != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String type;
	protected Integer durationint;
	protected ims.core.vo.lookups.TimeUnitsSecondsToMonths durationunit;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
