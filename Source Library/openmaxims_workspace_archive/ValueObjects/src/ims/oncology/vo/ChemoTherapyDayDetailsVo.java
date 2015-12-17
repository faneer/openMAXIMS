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

package ims.oncology.vo;

/**
 * Linked to Oncology.ChemoTherapyDayDetails business object (ID: 1074100033).
 */
public class ChemoTherapyDayDetailsVo extends ims.oncology.vo.ChemoTherapyDayDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemoTherapyDayDetailsVo()
	{
	}
	public ChemoTherapyDayDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemoTherapyDayDetailsVo(ims.oncology.vo.beans.ChemoTherapyDayDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.daynumber = bean.getDayNumber();
		this.daydate = bean.getDayDate() == null ? null : bean.getDayDate().buildDate();
		this.dosagedetails = ims.oncology.vo.ChemoDosageDetailsVoCollection.buildFromBeanCollection(bean.getDosageDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ChemoTherapyDayDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.daynumber = bean.getDayNumber();
		this.daydate = bean.getDayDate() == null ? null : bean.getDayDate().buildDate();
		this.dosagedetails = ims.oncology.vo.ChemoDosageDetailsVoCollection.buildFromBeanCollection(bean.getDosageDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ChemoTherapyDayDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ChemoTherapyDayDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ChemoTherapyDayDetailsVoBean();
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
		if(fieldName.equals("DAYNUMBER"))
			return getDayNumber();
		if(fieldName.equals("DAYDATE"))
			return getDayDate();
		if(fieldName.equals("DOSAGEDETAILS"))
			return getDosageDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDayNumberIsNotNull()
	{
		return this.daynumber != null;
	}
	public Integer getDayNumber()
	{
		return this.daynumber;
	}
	public void setDayNumber(Integer value)
	{
		this.isValidated = false;
		this.daynumber = value;
	}
	public boolean getDayDateIsNotNull()
	{
		return this.daydate != null;
	}
	public ims.framework.utils.Date getDayDate()
	{
		return this.daydate;
	}
	public void setDayDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.daydate = value;
	}
	public boolean getDosageDetailsIsNotNull()
	{
		return this.dosagedetails != null;
	}
	public ims.oncology.vo.ChemoDosageDetailsVoCollection getDosageDetails()
	{
		return this.dosagedetails;
	}
	public void setDosageDetails(ims.oncology.vo.ChemoDosageDetailsVoCollection value)
	{
		this.isValidated = false;
		this.dosagedetails = value;
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
		if(this.dosagedetails != null)
		{
			if(!this.dosagedetails.isValidated())
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
		if(this.daynumber == null)
			listOfErrors.add("DayNumber is mandatory");
		if(this.dosagedetails != null)
		{
			String[] listOfOtherErrors = this.dosagedetails.validate();
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
	
		ChemoTherapyDayDetailsVo clone = new ChemoTherapyDayDetailsVo(this.id, this.version);
		
		clone.daynumber = this.daynumber;
		if(this.daydate == null)
			clone.daydate = null;
		else
			clone.daydate = (ims.framework.utils.Date)this.daydate.clone();
		if(this.dosagedetails == null)
			clone.dosagedetails = null;
		else
			clone.dosagedetails = (ims.oncology.vo.ChemoDosageDetailsVoCollection)this.dosagedetails.clone();
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
		if (!(ChemoTherapyDayDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemoTherapyDayDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChemoTherapyDayDetailsVo compareObj = (ChemoTherapyDayDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDayDate() == null && compareObj.getDayDate() != null)
				return -1;
			if(this.getDayDate() != null && compareObj.getDayDate() == null)
				return 1;
			if(this.getDayDate() != null && compareObj.getDayDate() != null)
				retVal = this.getDayDate().compareTo(compareObj.getDayDate());
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
		if(this.daynumber != null)
			count++;
		if(this.daydate != null)
			count++;
		if(this.dosagedetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer daynumber;
	protected ims.framework.utils.Date daydate;
	protected ims.oncology.vo.ChemoDosageDetailsVoCollection dosagedetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
