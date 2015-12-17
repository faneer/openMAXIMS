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

package ims.RefMan.vo;


public class LinkedAppointmentVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LinkedAppointmentVo()
	{
	}
	public LinkedAppointmentVo(ims.RefMan.vo.beans.LinkedAppointmentVoBean bean)
	{
		this.sequence = bean.getSequence();
		this.periodvalue = bean.getPeriodValue();
		this.periodtype = bean.getPeriodType() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getPeriodType());
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
		this.opa = bean.getOPA() == null ? null : bean.getOPA().buildVo();
		this.apptdate = bean.getApptDate() == null ? null : bean.getApptDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.LinkedAppointmentVoBean bean)
	{
		this.sequence = bean.getSequence();
		this.periodvalue = bean.getPeriodValue();
		this.periodtype = bean.getPeriodType() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getPeriodType());
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
		this.opa = bean.getOPA() == null ? null : bean.getOPA().buildVo(map);
		this.apptdate = bean.getApptDate() == null ? null : bean.getApptDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.LinkedAppointmentVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.LinkedAppointmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.LinkedAppointmentVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getPeriodValueIsNotNull()
	{
		return this.periodvalue != null;
	}
	public Integer getPeriodValue()
	{
		return this.periodvalue;
	}
	public void setPeriodValue(Integer value)
	{
		this.isValidated = false;
		this.periodvalue = value;
	}
	public boolean getPeriodTypeIsNotNull()
	{
		return this.periodtype != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToMonths getPeriodType()
	{
		return this.periodtype;
	}
	public void setPeriodType(ims.core.vo.lookups.TimeUnitsSecondsToMonths value)
	{
		this.isValidated = false;
		this.periodtype = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getFunctionIsNotNull()
	{
		return this.function != null;
	}
	public ims.core.vo.lookups.ServiceFunction getFunction()
	{
		return this.function;
	}
	public void setFunction(ims.core.vo.lookups.ServiceFunction value)
	{
		this.isValidated = false;
		this.function = value;
	}
	public boolean getOPAIsNotNull()
	{
		return this.opa != null;
	}
	public ims.RefMan.vo.OPAVo getOPA()
	{
		return this.opa;
	}
	public void setOPA(ims.RefMan.vo.OPAVo value)
	{
		this.isValidated = false;
		this.opa = value;
	}
	public boolean getApptDateIsNotNull()
	{
		return this.apptdate != null;
	}
	public ims.framework.utils.Date getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.apptdate = value;
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
		if(!(obj instanceof LinkedAppointmentVo))
			return false;
		LinkedAppointmentVo compareObj = (LinkedAppointmentVo)obj;
		if(this.getSequence() == null && compareObj.getSequence() != null)
			return false;
		if(this.getSequence() != null && compareObj.getSequence() == null)
			return false;
		if(this.getSequence() != null && compareObj.getSequence() != null)
			if(!this.getSequence().equals(compareObj.getSequence()))
				return false;
		if(this.getPeriodValue() == null && compareObj.getPeriodValue() != null)
			return false;
		if(this.getPeriodValue() != null && compareObj.getPeriodValue() == null)
			return false;
		if(this.getPeriodValue() != null && compareObj.getPeriodValue() != null)
			if(!this.getPeriodValue().equals(compareObj.getPeriodValue()))
				return false;
		if(this.getPeriodType() == null && compareObj.getPeriodType() != null)
			return false;
		if(this.getPeriodType() != null && compareObj.getPeriodType() == null)
			return false;
		if(this.getPeriodType() != null && compareObj.getPeriodType() != null)
			if(!this.getPeriodType().equals(compareObj.getPeriodType()))
				return false;
		if(this.getService() == null && compareObj.getService() != null)
			return false;
		if(this.getService() != null && compareObj.getService() == null)
			return false;
		if(this.getService() != null && compareObj.getService() != null)
			if(!this.getService().equals(compareObj.getService()))
				return false;
		if(this.getFunction() == null && compareObj.getFunction() != null)
			return false;
		if(this.getFunction() != null && compareObj.getFunction() == null)
			return false;
		if(this.getFunction() != null && compareObj.getFunction() != null)
			if(!this.getFunction().equals(compareObj.getFunction()))
				return false;
		if(this.getOPA() == null && compareObj.getOPA() != null)
			return false;
		if(this.getOPA() != null && compareObj.getOPA() == null)
			return false;
		if(this.getOPA() != null && compareObj.getOPA() != null)
			return this.getOPA().equals(compareObj.getOPA());
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
	
		LinkedAppointmentVo clone = new LinkedAppointmentVo();
		
		clone.sequence = this.sequence;
		clone.periodvalue = this.periodvalue;
		if(this.periodtype == null)
			clone.periodtype = null;
		else
			clone.periodtype = (ims.core.vo.lookups.TimeUnitsSecondsToMonths)this.periodtype.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.function == null)
			clone.function = null;
		else
			clone.function = (ims.core.vo.lookups.ServiceFunction)this.function.clone();
		if(this.opa == null)
			clone.opa = null;
		else
			clone.opa = (ims.RefMan.vo.OPAVo)this.opa.clone();
		if(this.apptdate == null)
			clone.apptdate = null;
		else
			clone.apptdate = (ims.framework.utils.Date)this.apptdate.clone();
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
		if (!(LinkedAppointmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LinkedAppointmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LinkedAppointmentVo compareObj = (LinkedAppointmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
		}
		if (retVal == 0)
		{
			if(this.getPeriodValue() == null && compareObj.getPeriodValue() != null)
				return -1;
			if(this.getPeriodValue() != null && compareObj.getPeriodValue() == null)
				return 1;
			if(this.getPeriodValue() != null && compareObj.getPeriodValue() != null)
				retVal = this.getPeriodValue().compareTo(compareObj.getPeriodValue());
		}
		if (retVal == 0)
		{
			if(this.getPeriodType() == null && compareObj.getPeriodType() != null)
				return -1;
			if(this.getPeriodType() != null && compareObj.getPeriodType() == null)
				return 1;
			if(this.getPeriodType() != null && compareObj.getPeriodType() != null)
				retVal = this.getPeriodType().compareTo(compareObj.getPeriodType());
		}
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
		}
		if (retVal == 0)
		{
			if(this.getFunction() == null && compareObj.getFunction() != null)
				return -1;
			if(this.getFunction() != null && compareObj.getFunction() == null)
				return 1;
			if(this.getFunction() != null && compareObj.getFunction() != null)
				retVal = this.getFunction().compareTo(compareObj.getFunction());
		}
		if (retVal == 0)
		{
			if(this.getOPA() == null && compareObj.getOPA() != null)
				return -1;
			if(this.getOPA() != null && compareObj.getOPA() == null)
				return 1;
			if(this.getOPA() != null && compareObj.getOPA() != null)
				retVal = this.getOPA().compareTo(compareObj.getOPA());
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
		if(this.sequence != null)
			count++;
		if(this.periodvalue != null)
			count++;
		if(this.periodtype != null)
			count++;
		if(this.service != null)
			count++;
		if(this.function != null)
			count++;
		if(this.opa != null)
			count++;
		if(this.apptdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected Integer sequence;
	protected Integer periodvalue;
	protected ims.core.vo.lookups.TimeUnitsSecondsToMonths periodtype;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.lookups.ServiceFunction function;
	protected ims.RefMan.vo.OPAVo opa;
	protected ims.framework.utils.Date apptdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
