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
 * Linked to core.vitals.SignatoryShiftDetails business object (ID: 1022100020).
 */
public class SignatoryShiftDetailsVo extends ims.core.vitals.vo.SignatoryShiftDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SignatoryShiftDetailsVo()
	{
	}
	public SignatoryShiftDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public SignatoryShiftDetailsVo(ims.core.vo.beans.SignatoryShiftDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetimesigned = bean.getDateTimeSigned() == null ? null : bean.getDateTimeSigned().buildDateTime();
		this.signedoffby = bean.getSignedOffBy() == null ? null : bean.getSignedOffBy().buildVo();
		this.starttime = bean.getStartTime() == null ? null : ims.core.vo.lookups.DailyTimePeriods.buildLookup(bean.getStartTime());
		this.endtime = bean.getEndTime() == null ? null : ims.core.vo.lookups.DailyTimePeriods.buildLookup(bean.getEndTime());
		this.shiftstartdatetime = bean.getShiftStartDateTime() == null ? null : bean.getShiftStartDateTime().buildDateTime();
		this.shiftenddatetime = bean.getShiftEndDateTime() == null ? null : bean.getShiftEndDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SignatoryShiftDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetimesigned = bean.getDateTimeSigned() == null ? null : bean.getDateTimeSigned().buildDateTime();
		this.signedoffby = bean.getSignedOffBy() == null ? null : bean.getSignedOffBy().buildVo(map);
		this.starttime = bean.getStartTime() == null ? null : ims.core.vo.lookups.DailyTimePeriods.buildLookup(bean.getStartTime());
		this.endtime = bean.getEndTime() == null ? null : ims.core.vo.lookups.DailyTimePeriods.buildLookup(bean.getEndTime());
		this.shiftstartdatetime = bean.getShiftStartDateTime() == null ? null : bean.getShiftStartDateTime().buildDateTime();
		this.shiftenddatetime = bean.getShiftEndDateTime() == null ? null : bean.getShiftEndDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SignatoryShiftDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SignatoryShiftDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SignatoryShiftDetailsVoBean();
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
		if(fieldName.equals("DATETIMESIGNED"))
			return getDateTimeSigned();
		if(fieldName.equals("SIGNEDOFFBY"))
			return getSignedOffBy();
		if(fieldName.equals("STARTTIME"))
			return getStartTime();
		if(fieldName.equals("ENDTIME"))
			return getEndTime();
		if(fieldName.equals("SHIFTSTARTDATETIME"))
			return getShiftStartDateTime();
		if(fieldName.equals("SHIFTENDDATETIME"))
			return getShiftEndDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeSignedIsNotNull()
	{
		return this.datetimesigned != null;
	}
	public ims.framework.utils.DateTime getDateTimeSigned()
	{
		return this.datetimesigned;
	}
	public void setDateTimeSigned(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetimesigned = value;
	}
	public boolean getSignedOffByIsNotNull()
	{
		return this.signedoffby != null;
	}
	public ims.core.vo.HcpLiteVo getSignedOffBy()
	{
		return this.signedoffby;
	}
	public void setSignedOffBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.signedoffby = value;
	}
	public boolean getStartTimeIsNotNull()
	{
		return this.starttime != null;
	}
	public ims.core.vo.lookups.DailyTimePeriods getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.core.vo.lookups.DailyTimePeriods value)
	{
		this.isValidated = false;
		this.starttime = value;
	}
	public boolean getEndTimeIsNotNull()
	{
		return this.endtime != null;
	}
	public ims.core.vo.lookups.DailyTimePeriods getEndTime()
	{
		return this.endtime;
	}
	public void setEndTime(ims.core.vo.lookups.DailyTimePeriods value)
	{
		this.isValidated = false;
		this.endtime = value;
	}
	public boolean getShiftStartDateTimeIsNotNull()
	{
		return this.shiftstartdatetime != null;
	}
	public ims.framework.utils.DateTime getShiftStartDateTime()
	{
		return this.shiftstartdatetime;
	}
	public void setShiftStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.shiftstartdatetime = value;
	}
	public boolean getShiftEndDateTimeIsNotNull()
	{
		return this.shiftenddatetime != null;
	}
	public ims.framework.utils.DateTime getShiftEndDateTime()
	{
		return this.shiftenddatetime;
	}
	public void setShiftEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.shiftenddatetime = value;
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
		if(this.signedoffby != null)
		{
			if(!this.signedoffby.isValidated())
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
		if(this.signedoffby != null)
		{
			String[] listOfOtherErrors = this.signedoffby.validate();
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
	
		SignatoryShiftDetailsVo clone = new SignatoryShiftDetailsVo(this.id, this.version);
		
		if(this.datetimesigned == null)
			clone.datetimesigned = null;
		else
			clone.datetimesigned = (ims.framework.utils.DateTime)this.datetimesigned.clone();
		if(this.signedoffby == null)
			clone.signedoffby = null;
		else
			clone.signedoffby = (ims.core.vo.HcpLiteVo)this.signedoffby.clone();
		if(this.starttime == null)
			clone.starttime = null;
		else
			clone.starttime = (ims.core.vo.lookups.DailyTimePeriods)this.starttime.clone();
		if(this.endtime == null)
			clone.endtime = null;
		else
			clone.endtime = (ims.core.vo.lookups.DailyTimePeriods)this.endtime.clone();
		if(this.shiftstartdatetime == null)
			clone.shiftstartdatetime = null;
		else
			clone.shiftstartdatetime = (ims.framework.utils.DateTime)this.shiftstartdatetime.clone();
		if(this.shiftenddatetime == null)
			clone.shiftenddatetime = null;
		else
			clone.shiftenddatetime = (ims.framework.utils.DateTime)this.shiftenddatetime.clone();
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
		if (!(SignatoryShiftDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SignatoryShiftDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SignatoryShiftDetailsVo compareObj = (SignatoryShiftDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getShiftStartDateTime() == null && compareObj.getShiftStartDateTime() != null)
				return -1;
			if(this.getShiftStartDateTime() != null && compareObj.getShiftStartDateTime() == null)
				return 1;
			if(this.getShiftStartDateTime() != null && compareObj.getShiftStartDateTime() != null)
				retVal = this.getShiftStartDateTime().compareTo(compareObj.getShiftStartDateTime());
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
		if(this.datetimesigned != null)
			count++;
		if(this.signedoffby != null)
			count++;
		if(this.starttime != null)
			count++;
		if(this.endtime != null)
			count++;
		if(this.shiftstartdatetime != null)
			count++;
		if(this.shiftenddatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.DateTime datetimesigned;
	protected ims.core.vo.HcpLiteVo signedoffby;
	protected ims.core.vo.lookups.DailyTimePeriods starttime;
	protected ims.core.vo.lookups.DailyTimePeriods endtime;
	protected ims.framework.utils.DateTime shiftstartdatetime;
	protected ims.framework.utils.DateTime shiftenddatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
