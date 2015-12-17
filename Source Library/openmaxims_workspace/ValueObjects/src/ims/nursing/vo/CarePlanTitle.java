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

package ims.nursing.vo;

/**
 * Linked to nursing.care plans.Care Plan business object (ID: 1010100003).
 */
public class CarePlanTitle extends ims.nursing.careplans.vo.CarePlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CarePlanTitle()
	{
	}
	public CarePlanTitle(Integer id, int version)
	{
		super(id, version);
	}
	public CarePlanTitle(ims.nursing.vo.beans.CarePlanTitleBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.CarePlanTitleBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.CarePlanTitleBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.CarePlanTitleBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.CarePlanTitleBean();
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
		if(fieldName.equals("TITLE"))
			return getTitle();
		if(fieldName.equals("CURRENTCAREPLANSTATUS"))
			return getCurrentCarePlanStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public String getTitle()
	{
		return this.title;
	}
	public static int getTitleMaxLength()
	{
		return 255;
	}
	public void setTitle(String value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getCurrentCarePlanStatusIsNotNull()
	{
		return this.currentcareplanstatus != null;
	}
	public ims.nursing.vo.CarePlanStatus getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.CarePlanStatus value)
	{
		this.isValidated = false;
		this.currentcareplanstatus = value;
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
		if(this.currentcareplanstatus != null)
		{
			if(!this.currentcareplanstatus.isValidated())
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
		if(this.title != null)
			if(this.title.length() > 255)
				listOfErrors.add("The length of the field [title] in the value object [ims.nursing.vo.CarePlanTitle] is too big. It should be less or equal to 255");
		if(this.currentcareplanstatus != null)
		{
			String[] listOfOtherErrors = this.currentcareplanstatus.validate();
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
	
		CarePlanTitle clone = new CarePlanTitle(this.id, this.version);
		
		clone.title = this.title;
		if(this.currentcareplanstatus == null)
			clone.currentcareplanstatus = null;
		else
			clone.currentcareplanstatus = (ims.nursing.vo.CarePlanStatus)this.currentcareplanstatus.clone();
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
		if (!(CarePlanTitle.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CarePlanTitle object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CarePlanTitle compareObj = (CarePlanTitle)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_CarePlan() == null && compareObj.getID_CarePlan() != null)
				return -1;
			if(this.getID_CarePlan() != null && compareObj.getID_CarePlan() == null)
				return 1;
			if(this.getID_CarePlan() != null && compareObj.getID_CarePlan() != null)
				retVal = this.getID_CarePlan().compareTo(compareObj.getID_CarePlan());
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
		if(this.title != null)
			count++;
		if(this.currentcareplanstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String title;
	protected ims.nursing.vo.CarePlanStatus currentcareplanstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
