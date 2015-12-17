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


public class MoveAppointmentDataVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MoveAppointmentDataVo()
	{
	}
	public MoveAppointmentDataVo(ims.scheduling.vo.beans.MoveAppointmentDataVoBean bean)
	{
		this.fromslot = bean.getFromSlot() == null ? null : bean.getFromSlot().buildVo();
		this.toslot = bean.getToSlot() == null ? null : bean.getToSlot().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.MoveAppointmentDataVoBean bean)
	{
		this.fromslot = bean.getFromSlot() == null ? null : bean.getFromSlot().buildVo(map);
		this.toslot = bean.getToSlot() == null ? null : bean.getToSlot().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.MoveAppointmentDataVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.MoveAppointmentDataVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.MoveAppointmentDataVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getFromSlotIsNotNull()
	{
		return this.fromslot != null;
	}
	public ims.scheduling.vo.SessionParentChildSlotVo getFromSlot()
	{
		return this.fromslot;
	}
	public void setFromSlot(ims.scheduling.vo.SessionParentChildSlotVo value)
	{
		this.isValidated = false;
		this.fromslot = value;
	}
	public boolean getToSlotIsNotNull()
	{
		return this.toslot != null;
	}
	public ims.scheduling.vo.SessionParentChildSlotVo getToSlot()
	{
		return this.toslot;
	}
	public void setToSlot(ims.scheduling.vo.SessionParentChildSlotVo value)
	{
		this.isValidated = false;
		this.toslot = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof MoveAppointmentDataVo))
			return false;
		MoveAppointmentDataVo compareObj = (MoveAppointmentDataVo)obj;
		if(this.getFromSlot() == null && compareObj.getFromSlot() != null)
			return false;
		if(this.getFromSlot() != null && compareObj.getFromSlot() == null)
			return false;
		if(this.getFromSlot() != null && compareObj.getFromSlot() != null)
			return this.getFromSlot().equals(compareObj.getFromSlot());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		MoveAppointmentDataVo clone = new MoveAppointmentDataVo();
		
		if(this.fromslot == null)
			clone.fromslot = null;
		else
			clone.fromslot = (ims.scheduling.vo.SessionParentChildSlotVo)this.fromslot.clone();
		if(this.toslot == null)
			clone.toslot = null;
		else
			clone.toslot = (ims.scheduling.vo.SessionParentChildSlotVo)this.toslot.clone();
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
		if (!(MoveAppointmentDataVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MoveAppointmentDataVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MoveAppointmentDataVo compareObj = (MoveAppointmentDataVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getFromSlot() == null && compareObj.getFromSlot() != null)
				return -1;
			if(this.getFromSlot() != null && compareObj.getFromSlot() == null)
				return 1;
			if(this.getFromSlot() != null && compareObj.getFromSlot() != null)
				retVal = this.getFromSlot().compareTo(compareObj.getFromSlot());
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
		if(this.fromslot != null)
			count++;
		if(this.toslot != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.scheduling.vo.SessionParentChildSlotVo fromslot;
	protected ims.scheduling.vo.SessionParentChildSlotVo toslot;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
