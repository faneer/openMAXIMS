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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.InvasiveDeviceConfig business object (ID: 1073100015).
 */
public class InvasiveDeviceConfigVo extends ims.clinicaladmin.vo.InvasiveDeviceConfigShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InvasiveDeviceConfigVo()
	{
	}
	public InvasiveDeviceConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvasiveDeviceConfigVo(ims.clinicaladmin.vo.beans.InvasiveDeviceConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.invasivedevice = bean.getInvasiveDevice();
		this.durationint = bean.getDurationInt();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getDurationUnit());
		this.isactive = bean.getIsActive();
		this.size = ims.clinicaladmin.vo.InvasiveDeviceConfigSizeVoCollection.buildFromBeanCollection(bean.getSize());
		this.requiresvip = bean.getRequiresVIP();
		this.hassite = bean.getHasSite();
		this.type = ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection.buildFromBeanCollection(bean.getType());
		this.hastypes = bean.getHasTypes();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.InvasiveDeviceConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.invasivedevice = bean.getInvasiveDevice();
		this.durationint = bean.getDurationInt();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getDurationUnit());
		this.isactive = bean.getIsActive();
		this.size = ims.clinicaladmin.vo.InvasiveDeviceConfigSizeVoCollection.buildFromBeanCollection(bean.getSize());
		this.requiresvip = bean.getRequiresVIP();
		this.hassite = bean.getHasSite();
		this.type = ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection.buildFromBeanCollection(bean.getType());
		this.hastypes = bean.getHasTypes();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.InvasiveDeviceConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.InvasiveDeviceConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.InvasiveDeviceConfigVoBean();
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
		if(fieldName.equals("HASTYPES"))
			return getHasTypes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection getType()
	{
		return this.type;
	}
	public void setType(ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getHasTypesIsNotNull()
	{
		return this.hastypes != null;
	}
	public Boolean getHasTypes()
	{
		return this.hastypes;
	}
	public void setHasTypes(Boolean value)
	{
		this.isValidated = false;
		this.hastypes = value;
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
		if(this.size != null)
		{
			if(!this.size.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.type != null)
		{
			if(!this.type.isValidated())
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
		if(this.invasivedevice == null || this.invasivedevice.length() == 0)
			listOfErrors.add("InvasiveDevice is mandatory");
		else if(this.invasivedevice.length() > 255)
			listOfErrors.add("The length of the field [invasivedevice] in the value object [ims.clinicaladmin.vo.InvasiveDeviceConfigVo] is too big. It should be less or equal to 255");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.size != null)
		{
			String[] listOfOtherErrors = this.size.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.type != null)
		{
			String[] listOfOtherErrors = this.type.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		InvasiveDeviceConfigVo clone = new InvasiveDeviceConfigVo(this.id, this.version);
		
		clone.invasivedevice = this.invasivedevice;
		clone.durationint = this.durationint;
		if(this.durationunit == null)
			clone.durationunit = null;
		else
			clone.durationunit = (ims.core.vo.lookups.TimeUnitsSecondsToMonths)this.durationunit.clone();
		clone.isactive = this.isactive;
		if(this.size == null)
			clone.size = null;
		else
			clone.size = (ims.clinicaladmin.vo.InvasiveDeviceConfigSizeVoCollection)this.size.clone();
		clone.requiresvip = this.requiresvip;
		clone.hassite = this.hassite;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection)this.type.clone();
		clone.hastypes = this.hastypes;
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
		if (!(InvasiveDeviceConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvasiveDeviceConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InvasiveDeviceConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InvasiveDeviceConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.type != null)
			count++;
		if(this.hastypes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.clinicaladmin.vo.InvasiveDeviceTypeVoCollection type;
	protected Boolean hastypes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
