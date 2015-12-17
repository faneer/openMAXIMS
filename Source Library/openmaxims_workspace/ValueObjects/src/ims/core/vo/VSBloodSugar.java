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

package ims.core.vo;

/**
 * Linked to core.vitals.BloodSugar business object (ID: 1022100005).
 */
public class VSBloodSugar extends ims.core.vitals.vo.BloodSugarRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VSBloodSugar()
	{
	}
	public VSBloodSugar(Integer id, int version)
	{
		super(id, version);
	}
	public VSBloodSugar(ims.core.vo.beans.VSBloodSugarBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.CBGType.buildLookup(bean.getType());
		this.timeperiod = bean.getTimePeriod() == null ? null : ims.core.vo.lookups.CBGMTimePeriod.buildLookup(bean.getTimePeriod());
		this.bloodsugarvalue = bean.getBloodSugarValue();
		this.postbloodsugarvalue = bean.getPostBloodSugarValue();
		this.timeinterval = bean.getTimeInterval();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VSBloodSugarBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.CBGType.buildLookup(bean.getType());
		this.timeperiod = bean.getTimePeriod() == null ? null : ims.core.vo.lookups.CBGMTimePeriod.buildLookup(bean.getTimePeriod());
		this.bloodsugarvalue = bean.getBloodSugarValue();
		this.postbloodsugarvalue = bean.getPostBloodSugarValue();
		this.timeinterval = bean.getTimeInterval();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VSBloodSugarBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VSBloodSugarBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VSBloodSugarBean();
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
		if(fieldName.equals("TIMEPERIOD"))
			return getTimePeriod();
		if(fieldName.equals("BLOODSUGARVALUE"))
			return getBloodSugarValue();
		if(fieldName.equals("POSTBLOODSUGARVALUE"))
			return getPostBloodSugarValue();
		if(fieldName.equals("TIMEINTERVAL"))
			return getTimeInterval();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.core.vo.lookups.CBGType getType()
	{
		return this.type;
	}
	public void setType(ims.core.vo.lookups.CBGType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getTimePeriodIsNotNull()
	{
		return this.timeperiod != null;
	}
	public ims.core.vo.lookups.CBGMTimePeriod getTimePeriod()
	{
		return this.timeperiod;
	}
	public void setTimePeriod(ims.core.vo.lookups.CBGMTimePeriod value)
	{
		this.isValidated = false;
		this.timeperiod = value;
	}
	public boolean getBloodSugarValueIsNotNull()
	{
		return this.bloodsugarvalue != null;
	}
	public Float getBloodSugarValue()
	{
		return this.bloodsugarvalue;
	}
	public void setBloodSugarValue(Float value)
	{
		this.isValidated = false;
		this.bloodsugarvalue = value;
	}
	public boolean getPostBloodSugarValueIsNotNull()
	{
		return this.postbloodsugarvalue != null;
	}
	public Float getPostBloodSugarValue()
	{
		return this.postbloodsugarvalue;
	}
	public void setPostBloodSugarValue(Float value)
	{
		this.isValidated = false;
		this.postbloodsugarvalue = value;
	}
	public boolean getTimeIntervalIsNotNull()
	{
		return this.timeinterval != null;
	}
	public Integer getTimeInterval()
	{
		return this.timeinterval;
	}
	public void setTimeInterval(Integer value)
	{
		this.isValidated = false;
		this.timeinterval = value;
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
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.bloodsugarvalue == null)
			listOfErrors.add("BloodSugarValue is mandatory");
		if(this.bloodsugarvalue != null && (this.bloodsugarvalue.floatValue() < 0 || this.bloodsugarvalue.floatValue() > 44))
			listOfErrors.add("A Blood Glucose field has an invalid value. The valid range of values is between 0 and 44.");
		if(this.postbloodsugarvalue != null && (this.postbloodsugarvalue.floatValue() < 0 || this.postbloodsugarvalue.floatValue() > 44))
			listOfErrors.add("A Blood Glucose field has an invalid value. The valid range of values is between 0 and 44.");
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
	
		VSBloodSugar clone = new VSBloodSugar(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.CBGType)this.type.clone();
		if(this.timeperiod == null)
			clone.timeperiod = null;
		else
			clone.timeperiod = (ims.core.vo.lookups.CBGMTimePeriod)this.timeperiod.clone();
		clone.bloodsugarvalue = this.bloodsugarvalue;
		clone.postbloodsugarvalue = this.postbloodsugarvalue;
		clone.timeinterval = this.timeinterval;
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
		if (!(VSBloodSugar.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VSBloodSugar object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VSBloodSugar compareObj = (VSBloodSugar)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_BloodSugar() == null && compareObj.getID_BloodSugar() != null)
				return -1;
			if(this.getID_BloodSugar() != null && compareObj.getID_BloodSugar() == null)
				return 1;
			if(this.getID_BloodSugar() != null && compareObj.getID_BloodSugar() != null)
				retVal = this.getID_BloodSugar().compareTo(compareObj.getID_BloodSugar());
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
		if(this.type != null)
			count++;
		if(this.timeperiod != null)
			count++;
		if(this.bloodsugarvalue != null)
			count++;
		if(this.postbloodsugarvalue != null)
			count++;
		if(this.timeinterval != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.CBGType type;
	protected ims.core.vo.lookups.CBGMTimePeriod timeperiod;
	protected Float bloodsugarvalue;
	protected Float postbloodsugarvalue;
	protected Integer timeinterval;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
