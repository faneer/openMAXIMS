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

package ims.ccosched.vo;


public class ActivityViewFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActivityViewFilterVo()
	{
	}
	public ActivityViewFilterVo(ims.ccosched.vo.beans.ActivityViewFilterVoBean bean)
	{
		this.activitygroup = bean.getActivityGroup();
		this.activity = bean.getActivity();
		this.action = bean.getAction();
		this.priority = bean.getPriority();
		this.hcp = bean.getHCP();
		this.dayswaiting = bean.getDaysWaiting();
		this.eststartdate = bean.getEstStartDate();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.excludedelayed = bean.getExcludeDelayed();
		this.furtherbooking = bean.getFurtherBooking();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.beans.ActivityViewFilterVoBean bean)
	{
		this.activitygroup = bean.getActivityGroup();
		this.activity = bean.getActivity();
		this.action = bean.getAction();
		this.priority = bean.getPriority();
		this.hcp = bean.getHCP();
		this.dayswaiting = bean.getDaysWaiting();
		this.eststartdate = bean.getEstStartDate();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.excludedelayed = bean.getExcludeDelayed();
		this.furtherbooking = bean.getFurtherBooking();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.beans.ActivityViewFilterVoBean bean = null;
		if(map != null)
			bean = (ims.ccosched.vo.beans.ActivityViewFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ccosched.vo.beans.ActivityViewFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getActivityGroupIsNotNull()
	{
		return this.activitygroup != null;
	}
	public String getActivityGroup()
	{
		return this.activitygroup;
	}
	public static int getActivityGroupMaxLength()
	{
		return 255;
	}
	public void setActivityGroup(String value)
	{
		this.isValidated = false;
		this.activitygroup = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public String getActivity()
	{
		return this.activity;
	}
	public static int getActivityMaxLength()
	{
		return 255;
	}
	public void setActivity(String value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getActionIsNotNull()
	{
		return this.action != null;
	}
	public String getAction()
	{
		return this.action;
	}
	public static int getActionMaxLength()
	{
		return 255;
	}
	public void setAction(String value)
	{
		this.isValidated = false;
		this.action = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public String getPriority()
	{
		return this.priority;
	}
	public static int getPriorityMaxLength()
	{
		return 255;
	}
	public void setPriority(String value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getHCPIsNotNull()
	{
		return this.hcp != null;
	}
	public String getHCP()
	{
		return this.hcp;
	}
	public static int getHCPMaxLength()
	{
		return 255;
	}
	public void setHCP(String value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getDaysWaitingIsNotNull()
	{
		return this.dayswaiting != null;
	}
	public Boolean getDaysWaiting()
	{
		return this.dayswaiting;
	}
	public void setDaysWaiting(Boolean value)
	{
		this.isValidated = false;
		this.dayswaiting = value;
	}
	public boolean getEstStartDateIsNotNull()
	{
		return this.eststartdate != null;
	}
	public Boolean getEstStartDate()
	{
		return this.eststartdate;
	}
	public void setEstStartDate(Boolean value)
	{
		this.isValidated = false;
		this.eststartdate = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.Date getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public boolean getExcludeDelayedIsNotNull()
	{
		return this.excludedelayed != null;
	}
	public Boolean getExcludeDelayed()
	{
		return this.excludedelayed;
	}
	public void setExcludeDelayed(Boolean value)
	{
		this.isValidated = false;
		this.excludedelayed = value;
	}
	public boolean getFurtherBookingIsNotNull()
	{
		return this.furtherbooking != null;
	}
	public Boolean getFurtherBooking()
	{
		return this.furtherbooking;
	}
	public void setFurtherBooking(Boolean value)
	{
		this.isValidated = false;
		this.furtherbooking = value;
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
		if(!(obj instanceof ActivityViewFilterVo))
			return false;
		ActivityViewFilterVo compareObj = (ActivityViewFilterVo)obj;
		if(this.getActivityGroup() == null && compareObj.getActivityGroup() != null)
			return false;
		if(this.getActivityGroup() != null && compareObj.getActivityGroup() == null)
			return false;
		if(this.getActivityGroup() != null && compareObj.getActivityGroup() != null)
			return this.getActivityGroup().equals(compareObj.getActivityGroup());
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
	
		ActivityViewFilterVo clone = new ActivityViewFilterVo();
		
		clone.activitygroup = this.activitygroup;
		clone.activity = this.activity;
		clone.action = this.action;
		clone.priority = this.priority;
		clone.hcp = this.hcp;
		clone.dayswaiting = this.dayswaiting;
		clone.eststartdate = this.eststartdate;
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		clone.excludedelayed = this.excludedelayed;
		clone.furtherbooking = this.furtherbooking;
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
		if (!(ActivityViewFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActivityViewFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ActivityViewFilterVo compareObj = (ActivityViewFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getActivityGroup() == null && compareObj.getActivityGroup() != null)
				return -1;
			if(this.getActivityGroup() != null && compareObj.getActivityGroup() == null)
				return 1;
			if(this.getActivityGroup() != null && compareObj.getActivityGroup() != null)
			{
				if(caseInsensitive)
					retVal = this.getActivityGroup().toLowerCase().compareTo(compareObj.getActivityGroup().toLowerCase());
				else
					retVal = this.getActivityGroup().compareTo(compareObj.getActivityGroup());
			}
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
		if(this.activitygroup != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.action != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.dayswaiting != null)
			count++;
		if(this.eststartdate != null)
			count++;
		if(this.date != null)
			count++;
		if(this.excludedelayed != null)
			count++;
		if(this.furtherbooking != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected String activitygroup;
	protected String activity;
	protected String action;
	protected String priority;
	protected String hcp;
	protected Boolean dayswaiting;
	protected Boolean eststartdate;
	protected ims.framework.utils.Date date;
	protected Boolean excludedelayed;
	protected Boolean furtherbooking;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
