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
 * Linked to core.Documents.ConversionDetails business object (ID: 1068100003).
 */
public class ConversionDetailsVo extends ims.core.documents.vo.ConversionDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ConversionDetailsVo()
	{
	}
	public ConversionDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConversionDetailsVo(ims.core.vo.beans.ConversionDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lastunid = bean.getLastUnid();
		this.lastupdateddatetime = bean.getLastUpdatedDateTime() == null ? null : bean.getLastUpdatedDateTime().buildDateTime();
		this.totalconversions = bean.getTotalConversions();
		this.timeforoneconversion = bean.getTimeForOneConversion();
		this.oneminuteaverage = bean.getOneMinuteAverage();
		this.onehouraverage = bean.getOneHourAverage();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.triggerfrequency = bean.getTriggerFrequency();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.repeatinterval = bean.getRepeatInterval();
		this.configuredscheduledjobid = bean.getConfiguredScheduledJobID();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ConversionDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lastunid = bean.getLastUnid();
		this.lastupdateddatetime = bean.getLastUpdatedDateTime() == null ? null : bean.getLastUpdatedDateTime().buildDateTime();
		this.totalconversions = bean.getTotalConversions();
		this.timeforoneconversion = bean.getTimeForOneConversion();
		this.oneminuteaverage = bean.getOneMinuteAverage();
		this.onehouraverage = bean.getOneHourAverage();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.triggerfrequency = bean.getTriggerFrequency();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.repeatinterval = bean.getRepeatInterval();
		this.configuredscheduledjobid = bean.getConfiguredScheduledJobID();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ConversionDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ConversionDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ConversionDetailsVoBean();
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
		if(fieldName.equals("LASTUNID"))
			return getLastUnid();
		if(fieldName.equals("LASTUPDATEDDATETIME"))
			return getLastUpdatedDateTime();
		if(fieldName.equals("TOTALCONVERSIONS"))
			return getTotalConversions();
		if(fieldName.equals("TIMEFORONECONVERSION"))
			return getTimeForOneConversion();
		if(fieldName.equals("ONEMINUTEAVERAGE"))
			return getOneMinuteAverage();
		if(fieldName.equals("ONEHOURAVERAGE"))
			return getOneHourAverage();
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("TRIGGERFREQUENCY"))
			return getTriggerFrequency();
		if(fieldName.equals("LASTRUN"))
			return getLastRun();
		if(fieldName.equals("NEXTRUN"))
			return getNextRun();
		if(fieldName.equals("REPEATINTERVAL"))
			return getRepeatInterval();
		if(fieldName.equals("CONFIGUREDSCHEDULEDJOBID"))
			return getConfiguredScheduledJobID();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLastUnidIsNotNull()
	{
		return this.lastunid != null;
	}
	public Integer getLastUnid()
	{
		return this.lastunid;
	}
	public void setLastUnid(Integer value)
	{
		this.isValidated = false;
		this.lastunid = value;
	}
	public boolean getLastUpdatedDateTimeIsNotNull()
	{
		return this.lastupdateddatetime != null;
	}
	public ims.framework.utils.DateTime getLastUpdatedDateTime()
	{
		return this.lastupdateddatetime;
	}
	public void setLastUpdatedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastupdateddatetime = value;
	}
	public boolean getTotalConversionsIsNotNull()
	{
		return this.totalconversions != null;
	}
	public Integer getTotalConversions()
	{
		return this.totalconversions;
	}
	public void setTotalConversions(Integer value)
	{
		this.isValidated = false;
		this.totalconversions = value;
	}
	public boolean getTimeForOneConversionIsNotNull()
	{
		return this.timeforoneconversion != null;
	}
	public Integer getTimeForOneConversion()
	{
		return this.timeforoneconversion;
	}
	public void setTimeForOneConversion(Integer value)
	{
		this.isValidated = false;
		this.timeforoneconversion = value;
	}
	public boolean getOneMinuteAverageIsNotNull()
	{
		return this.oneminuteaverage != null;
	}
	public Integer getOneMinuteAverage()
	{
		return this.oneminuteaverage;
	}
	public void setOneMinuteAverage(Integer value)
	{
		this.isValidated = false;
		this.oneminuteaverage = value;
	}
	public boolean getOneHourAverageIsNotNull()
	{
		return this.onehouraverage != null;
	}
	public Integer getOneHourAverage()
	{
		return this.onehouraverage;
	}
	public void setOneHourAverage(Integer value)
	{
		this.isValidated = false;
		this.onehouraverage = value;
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.DateTime getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.creationdate = value;
	}
	public boolean getTriggerFrequencyIsNotNull()
	{
		return this.triggerfrequency != null;
	}
	public String getTriggerFrequency()
	{
		return this.triggerfrequency;
	}
	public static int getTriggerFrequencyMaxLength()
	{
		return 255;
	}
	public void setTriggerFrequency(String value)
	{
		this.isValidated = false;
		this.triggerfrequency = value;
	}
	public boolean getLastRunIsNotNull()
	{
		return this.lastrun != null;
	}
	public ims.framework.utils.DateTime getLastRun()
	{
		return this.lastrun;
	}
	public void setLastRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastrun = value;
	}
	public boolean getNextRunIsNotNull()
	{
		return this.nextrun != null;
	}
	public ims.framework.utils.DateTime getNextRun()
	{
		return this.nextrun;
	}
	public void setNextRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.nextrun = value;
	}
	public boolean getRepeatIntervalIsNotNull()
	{
		return this.repeatinterval != null;
	}
	public String getRepeatInterval()
	{
		return this.repeatinterval;
	}
	public static int getRepeatIntervalMaxLength()
	{
		return 255;
	}
	public void setRepeatInterval(String value)
	{
		this.isValidated = false;
		this.repeatinterval = value;
	}
	public boolean getConfiguredScheduledJobIDIsNotNull()
	{
		return this.configuredscheduledjobid != null;
	}
	public Integer getConfiguredScheduledJobID()
	{
		return this.configuredscheduledjobid;
	}
	public void setConfiguredScheduledJobID(Integer value)
	{
		this.isValidated = false;
		this.configuredscheduledjobid = value;
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
		if(this.triggerfrequency != null)
			if(this.triggerfrequency.length() > 255)
				listOfErrors.add("The length of the field [triggerfrequency] in the value object [ims.core.vo.ConversionDetailsVo] is too big. It should be less or equal to 255");
		if(this.repeatinterval != null)
			if(this.repeatinterval.length() > 255)
				listOfErrors.add("The length of the field [repeatinterval] in the value object [ims.core.vo.ConversionDetailsVo] is too big. It should be less or equal to 255");
		if(this.configuredscheduledjobid == null)
			listOfErrors.add("ConfiguredScheduledJobID is mandatory");
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
	
		ConversionDetailsVo clone = new ConversionDetailsVo(this.id, this.version);
		
		clone.lastunid = this.lastunid;
		if(this.lastupdateddatetime == null)
			clone.lastupdateddatetime = null;
		else
			clone.lastupdateddatetime = (ims.framework.utils.DateTime)this.lastupdateddatetime.clone();
		clone.totalconversions = this.totalconversions;
		clone.timeforoneconversion = this.timeforoneconversion;
		clone.oneminuteaverage = this.oneminuteaverage;
		clone.onehouraverage = this.onehouraverage;
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.DateTime)this.creationdate.clone();
		clone.triggerfrequency = this.triggerfrequency;
		if(this.lastrun == null)
			clone.lastrun = null;
		else
			clone.lastrun = (ims.framework.utils.DateTime)this.lastrun.clone();
		if(this.nextrun == null)
			clone.nextrun = null;
		else
			clone.nextrun = (ims.framework.utils.DateTime)this.nextrun.clone();
		clone.repeatinterval = this.repeatinterval;
		clone.configuredscheduledjobid = this.configuredscheduledjobid;
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
		if (!(ConversionDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConversionDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ConversionDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ConversionDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.lastunid != null)
			count++;
		if(this.lastupdateddatetime != null)
			count++;
		if(this.totalconversions != null)
			count++;
		if(this.timeforoneconversion != null)
			count++;
		if(this.oneminuteaverage != null)
			count++;
		if(this.onehouraverage != null)
			count++;
		if(this.creationdate != null)
			count++;
		if(this.triggerfrequency != null)
			count++;
		if(this.lastrun != null)
			count++;
		if(this.nextrun != null)
			count++;
		if(this.repeatinterval != null)
			count++;
		if(this.configuredscheduledjobid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected Integer lastunid;
	protected ims.framework.utils.DateTime lastupdateddatetime;
	protected Integer totalconversions;
	protected Integer timeforoneconversion;
	protected Integer oneminuteaverage;
	protected Integer onehouraverage;
	protected ims.framework.utils.DateTime creationdate;
	protected String triggerfrequency;
	protected ims.framework.utils.DateTime lastrun;
	protected ims.framework.utils.DateTime nextrun;
	protected String repeatinterval;
	protected Integer configuredscheduledjobid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
