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
 * Linked to core.clinical.Alcohol business object (ID: 1003100037).
 */
public class AlcoholVo extends ims.core.clinical.vo.AlcoholRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AlcoholVo()
	{
	}
	public AlcoholVo(Integer id, int version)
	{
		super(id, version);
	}
	public AlcoholVo(ims.core.vo.beans.AlcoholVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.doyoudrinkalcohol = bean.getDoYouDrinkAlcohol() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDoYouDrinkAlcohol());
		this.unitsperday = bean.getUnitsPerDay();
		this.descriptivehistory = bean.getDescriptiveHistory();
		this.unitsperweek = bean.getUnitsPerWeek() == null ? null : ims.core.vo.lookups.UnitsPerWeek.buildLookup(bean.getUnitsPerWeek());
		this.unitsperweekvalue = bean.getUnitsPerWeekValue();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AlcoholVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.doyoudrinkalcohol = bean.getDoYouDrinkAlcohol() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDoYouDrinkAlcohol());
		this.unitsperday = bean.getUnitsPerDay();
		this.descriptivehistory = bean.getDescriptiveHistory();
		this.unitsperweek = bean.getUnitsPerWeek() == null ? null : ims.core.vo.lookups.UnitsPerWeek.buildLookup(bean.getUnitsPerWeek());
		this.unitsperweekvalue = bean.getUnitsPerWeekValue();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AlcoholVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AlcoholVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AlcoholVoBean();
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
		if(fieldName.equals("DOYOUDRINKALCOHOL"))
			return getDoYouDrinkAlcohol();
		if(fieldName.equals("UNITSPERDAY"))
			return getUnitsPerDay();
		if(fieldName.equals("DESCRIPTIVEHISTORY"))
			return getDescriptiveHistory();
		if(fieldName.equals("UNITSPERWEEK"))
			return getUnitsPerWeek();
		if(fieldName.equals("UNITSPERWEEKVALUE"))
			return getUnitsPerWeekValue();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDoYouDrinkAlcoholIsNotNull()
	{
		return this.doyoudrinkalcohol != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDoYouDrinkAlcohol()
	{
		return this.doyoudrinkalcohol;
	}
	public void setDoYouDrinkAlcohol(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.doyoudrinkalcohol = value;
	}
	public boolean getUnitsPerDayIsNotNull()
	{
		return this.unitsperday != null;
	}
	public Integer getUnitsPerDay()
	{
		return this.unitsperday;
	}
	public void setUnitsPerDay(Integer value)
	{
		this.isValidated = false;
		this.unitsperday = value;
	}
	public boolean getDescriptiveHistoryIsNotNull()
	{
		return this.descriptivehistory != null;
	}
	public String getDescriptiveHistory()
	{
		return this.descriptivehistory;
	}
	public static int getDescriptiveHistoryMaxLength()
	{
		return 500;
	}
	public void setDescriptiveHistory(String value)
	{
		this.isValidated = false;
		this.descriptivehistory = value;
	}
	public boolean getUnitsPerWeekIsNotNull()
	{
		return this.unitsperweek != null;
	}
	public ims.core.vo.lookups.UnitsPerWeek getUnitsPerWeek()
	{
		return this.unitsperweek;
	}
	public void setUnitsPerWeek(ims.core.vo.lookups.UnitsPerWeek value)
	{
		this.isValidated = false;
		this.unitsperweek = value;
	}
	public boolean getUnitsPerWeekValueIsNotNull()
	{
		return this.unitsperweekvalue != null;
	}
	public Integer getUnitsPerWeekValue()
	{
		return this.unitsperweekvalue;
	}
	public void setUnitsPerWeekValue(Integer value)
	{
		this.isValidated = false;
		this.unitsperweekvalue = value;
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
		if(this.descriptivehistory != null)
			if(this.descriptivehistory.length() > 500)
				listOfErrors.add("The length of the field [descriptivehistory] in the value object [ims.core.vo.AlcoholVo] is too big. It should be less or equal to 500");
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
	
		AlcoholVo clone = new AlcoholVo(this.id, this.version);
		
		if(this.doyoudrinkalcohol == null)
			clone.doyoudrinkalcohol = null;
		else
			clone.doyoudrinkalcohol = (ims.core.vo.lookups.YesNoUnknown)this.doyoudrinkalcohol.clone();
		clone.unitsperday = this.unitsperday;
		clone.descriptivehistory = this.descriptivehistory;
		if(this.unitsperweek == null)
			clone.unitsperweek = null;
		else
			clone.unitsperweek = (ims.core.vo.lookups.UnitsPerWeek)this.unitsperweek.clone();
		clone.unitsperweekvalue = this.unitsperweekvalue;
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
		if (!(AlcoholVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AlcoholVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AlcoholVo compareObj = (AlcoholVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Alcohol() == null && compareObj.getID_Alcohol() != null)
				return -1;
			if(this.getID_Alcohol() != null && compareObj.getID_Alcohol() == null)
				return 1;
			if(this.getID_Alcohol() != null && compareObj.getID_Alcohol() != null)
				retVal = this.getID_Alcohol().compareTo(compareObj.getID_Alcohol());
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
		if(this.doyoudrinkalcohol != null)
			count++;
		if(this.unitsperday != null)
			count++;
		if(this.descriptivehistory != null)
			count++;
		if(this.unitsperweek != null)
			count++;
		if(this.unitsperweekvalue != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.YesNoUnknown doyoudrinkalcohol;
	protected Integer unitsperday;
	protected String descriptivehistory;
	protected ims.core.vo.lookups.UnitsPerWeek unitsperweek;
	protected Integer unitsperweekvalue;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
