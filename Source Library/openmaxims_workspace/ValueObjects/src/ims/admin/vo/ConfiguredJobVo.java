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

package ims.admin.vo;

/**
 * Linked to core.configuration.ConfiguredJob business object (ID: 1028100057).
 */
public class ConfiguredJobVo extends ims.core.configuration.vo.ConfiguredJobRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IConfiguredScheduledJob
{
	private static final long serialVersionUID = 1L;

	public ConfiguredJobVo()
	{
	}
	public ConfiguredJobVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConfiguredJobVo(ims.admin.vo.beans.ConfiguredJobVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.iscrontrigger = bean.getIsCronTrigger();
		this.cronexpression = bean.getCronExpression();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.cronexpressiondisplay = bean.getCronExpressionDisplay();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.isactive = bean.getIsActive();
		this.description = bean.getDescription();
		this.scheduledjob = bean.getScheduledJob() == null ? null : bean.getScheduledJob().buildVo();
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.JobRunningFrequency.buildLookup(bean.getFrequency());
		this.notificationsonsuccess = ims.core.vo.ConfiguredJobNotificationVoCollection.buildFromBeanCollection(bean.getNotificationsOnSuccess());
		this.notificationsonfailure = ims.core.vo.ConfiguredJobNotificationVoCollection.buildFromBeanCollection(bean.getNotificationsOnFailure());
		this.name = bean.getName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.ConfiguredJobVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.iscrontrigger = bean.getIsCronTrigger();
		this.cronexpression = bean.getCronExpression();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.cronexpressiondisplay = bean.getCronExpressionDisplay();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.isactive = bean.getIsActive();
		this.description = bean.getDescription();
		this.scheduledjob = bean.getScheduledJob() == null ? null : bean.getScheduledJob().buildVo(map);
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.JobRunningFrequency.buildLookup(bean.getFrequency());
		this.notificationsonsuccess = ims.core.vo.ConfiguredJobNotificationVoCollection.buildFromBeanCollection(bean.getNotificationsOnSuccess());
		this.notificationsonfailure = ims.core.vo.ConfiguredJobNotificationVoCollection.buildFromBeanCollection(bean.getNotificationsOnFailure());
		this.name = bean.getName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.ConfiguredJobVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.ConfiguredJobVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.ConfiguredJobVoBean();
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
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("ENDDATETIME"))
			return getEndDateTime();
		if(fieldName.equals("ISCRONTRIGGER"))
			return getIsCronTrigger();
		if(fieldName.equals("CRONEXPRESSION"))
			return getCronExpression();
		if(fieldName.equals("LASTRUN"))
			return getLastRun();
		if(fieldName.equals("NEXTRUN"))
			return getNextRun();
		if(fieldName.equals("CRONEXPRESSIONDISPLAY"))
			return getCronExpressionDisplay();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("SCHEDULEDJOB"))
			return getScheduledJob();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("NOTIFICATIONSONSUCCESS"))
			return getNotificationsOnSuccess();
		if(fieldName.equals("NOTIFICATIONSONFAILURE"))
			return getNotificationsOnFailure();
		if(fieldName.equals("NAME"))
			return getName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getEndDateTimeIsNotNull()
	{
		return this.enddatetime != null;
	}
	public ims.framework.utils.DateTime getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.enddatetime = value;
	}
	public boolean getIsCronTriggerIsNotNull()
	{
		return this.iscrontrigger != null;
	}
	public Boolean getIsCronTrigger()
	{
		return this.iscrontrigger;
	}
	public void setIsCronTrigger(Boolean value)
	{
		this.isValidated = false;
		this.iscrontrigger = value;
	}
	public boolean getCronExpressionIsNotNull()
	{
		return this.cronexpression != null;
	}
	public String getCronExpression()
	{
		return this.cronexpression;
	}
	public static int getCronExpressionMaxLength()
	{
		return 1000;
	}
	public void setCronExpression(String value)
	{
		this.isValidated = false;
		this.cronexpression = value;
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
	public boolean getCronExpressionDisplayIsNotNull()
	{
		return this.cronexpressiondisplay != null;
	}
	public String getCronExpressionDisplay()
	{
		return this.cronexpressiondisplay;
	}
	public static int getCronExpressionDisplayMaxLength()
	{
		return 1000;
	}
	public void setCronExpressionDisplay(String value)
	{
		this.isValidated = false;
		this.cronexpressiondisplay = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getScheduledJobIsNotNull()
	{
		return this.scheduledjob != null;
	}
	public ims.admin.vo.SystemJobVo getScheduledJob()
	{
		return this.scheduledjob;
	}
	public void setScheduledJob(ims.admin.vo.SystemJobVo value)
	{
		this.isValidated = false;
		this.scheduledjob = value;
	}
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public ims.core.vo.lookups.JobRunningFrequency getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.core.vo.lookups.JobRunningFrequency value)
	{
		this.isValidated = false;
		this.frequency = value;
	}
	public boolean getNotificationsOnSuccessIsNotNull()
	{
		return this.notificationsonsuccess != null;
	}
	public ims.core.vo.ConfiguredJobNotificationVoCollection getNotificationsOnSuccess()
	{
		return this.notificationsonsuccess;
	}
	public void setNotificationsOnSuccess(ims.core.vo.ConfiguredJobNotificationVoCollection value)
	{
		this.isValidated = false;
		this.notificationsonsuccess = value;
	}
	public boolean getNotificationsOnFailureIsNotNull()
	{
		return this.notificationsonfailure != null;
	}
	public ims.core.vo.ConfiguredJobNotificationVoCollection getNotificationsOnFailure()
	{
		return this.notificationsonfailure;
	}
	public void setNotificationsOnFailure(ims.core.vo.ConfiguredJobNotificationVoCollection value)
	{
		this.isValidated = false;
		this.notificationsonfailure = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	/**
	* IConfiguredScheduledJob
	*/
			public ims.framework.utils.DateTime getConfiguredScheduledEndDateTime() 
			{
				return enddatetime;
			}
			public String getConfiguredScheduledJobCronExpression() 
			{
				return cronexpression;
			}
			public String getConfiguredScheduledJobCronExpressionText() 
			{
				return cronexpressiondisplay;
			}
			public String getConfiguredScheduledJobDescription() 
			{
				return description;
			}
			public String getConfiguredScheduledJobName() 
			{
				return name;
			}
			public ims.framework.enumerations.SchedulerJobFrequency getConfiguredScheduledJobFrequency() 
			{
				if(frequency == null)
					return null;
				
				if(frequency.equals(ims.core.vo.lookups.JobRunningFrequency.DAILY))
					return ims.framework.enumerations.SchedulerJobFrequency.DAILY;
				else if(frequency.equals(ims.core.vo.lookups.JobRunningFrequency.WEEKLY))
					return ims.framework.enumerations.SchedulerJobFrequency.WEEKLY;
				else if(frequency.equals(ims.core.vo.lookups.JobRunningFrequency.MONTHLY))
					return ims.framework.enumerations.SchedulerJobFrequency.MONTHLY;
				else if(frequency.equals(ims.core.vo.lookups.JobRunningFrequency.CUSTOM))
					return ims.framework.enumerations.SchedulerJobFrequency.CUSTOM;
				
				return null;
			}
			public int getConfiguredScheduledJobID() 
			{
				return id;
			}
			public ims.framework.utils.DateTime getConfiguredScheduledStartDateTime() 
			{
				return startdatetime;
			}
			public boolean isConfiguredScheduledJobCronTrigger() 
			{
				return iscrontrigger == null ? false : iscrontrigger; 
			}
			public ims.framework.interfaces.IQueuedNotification[] getNotificationOnSuccess() 
			{
				return getQueuedNotifications(notificationsonsuccess);
			}
			public ims.framework.interfaces.IQueuedNotification[] getNotificationOnFailure() 
			{
				return getQueuedNotifications(notificationsonfailure);
			}
			private ims.framework.interfaces.IQueuedNotification[] getQueuedNotifications(ims.core.vo.ConfiguredJobNotificationVoCollection notifications) 
			{
				if(notifications == null)
					return new ims.framework.interfaces.IQueuedNotification[0];
								
				java.util.ArrayList<ims.framework.interfaces.IQueuedNotification> result = new java.util.ArrayList<ims.framework.interfaces.IQueuedNotification>();
				for(int x = 0; x < notifications.size(); x++)
				{
					ims.core.vo.ConfiguredJobNotificationVo notification = notifications.get(x);
					
					if(notification.getUser() == null || notification.getDelivery() == null || notification.getDelivery().size() == 0)
						continue;
					for(int y = 0; y < notification.getDelivery().size(); y++)
					{
						ims.framework.utils.QueuedNotification item = new ims.framework.utils.QueuedNotification();
						
						item.setINotificationMessage(notification.getUserMessage());
						item.setINotificationUserId(notification.getUser().getBoId());
						
						if(notification.getDelivery().get(y).equals(ims.admin.vo.lookups.NotificationDelivery.UI))
								item.setIQueuedNotificationDelivery(ims.framework.enumerations.NotificationDelivery.UI);
							else if(notification.getDelivery().get(y).equals(ims.admin.vo.lookups.NotificationDelivery.EMAIL))
								item.setIQueuedNotificationDelivery(ims.framework.enumerations.NotificationDelivery.EMAIL);
							else if(notification.getDelivery().get(y).equals(ims.admin.vo.lookups.NotificationDelivery.PUSH))
								item.setIQueuedNotificationDelivery(ims.framework.enumerations.NotificationDelivery.PUSH);
							else if(notification.getDelivery().get(y).equals(ims.admin.vo.lookups.NotificationDelivery.SMS))
								item.setIQueuedNotificationDelivery(ims.framework.enumerations.NotificationDelivery.SMS);
	
							if(notification.getPriority().equals(ims.admin.vo.lookups.NotificationPriority.CRITICAL))
								item.setINotificationPriority(ims.framework.enumerations.NotificationPriority.CRITICAL);
							else if(notification.getPriority().equals(ims.admin.vo.lookups.NotificationPriority.HIGH))
								item.setINotificationPriority(ims.framework.enumerations.NotificationPriority.HIGH);
							else if(notification.getPriority().equals(ims.admin.vo.lookups.NotificationPriority.LOW))
								item.setINotificationPriority(ims.framework.enumerations.NotificationPriority.LOW);
							else if(notification.getPriority().equals(ims.admin.vo.lookups.NotificationPriority.NORMAL))
								item.setINotificationPriority(ims.framework.enumerations.NotificationPriority.NORMAL);
						
						result.add(item);
					}					
				}
				
				ims.framework.interfaces.IQueuedNotification[] typedResult = new ims.framework.interfaces.IQueuedNotification[result.size()];
				result.toArray(typedResult);
				return typedResult;
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
		if(this.notificationsonsuccess != null)
		{
			if(!this.notificationsonsuccess.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.notificationsonfailure != null)
		{
			if(!this.notificationsonfailure.isValidated())
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
		if(this.cronexpression == null || this.cronexpression.length() == 0)
			listOfErrors.add("CronExpression is mandatory");
		else if(this.cronexpression.length() > 1000)
			listOfErrors.add("The length of the field [cronexpression] in the value object [ims.admin.vo.ConfiguredJobVo] is too big. It should be less or equal to 1000");
		if(this.cronexpressiondisplay != null)
			if(this.cronexpressiondisplay.length() > 1000)
				listOfErrors.add("The length of the field [cronexpressiondisplay] in the value object [ims.admin.vo.ConfiguredJobVo] is too big. It should be less or equal to 1000");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.admin.vo.ConfiguredJobVo] is too big. It should be less or equal to 255");
		if(this.scheduledjob == null)
			listOfErrors.add("ScheduledJob is mandatory");
		if(this.frequency == null)
			listOfErrors.add("Frequency is mandatory");
		if(this.notificationsonsuccess != null)
		{
			String[] listOfOtherErrors = this.notificationsonsuccess.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.notificationsonfailure != null)
		{
			String[] listOfOtherErrors = this.notificationsonfailure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.admin.vo.ConfiguredJobVo] is too big. It should be less or equal to 255");
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
	
		ConfiguredJobVo clone = new ConfiguredJobVo(this.id, this.version);
		
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.enddatetime == null)
			clone.enddatetime = null;
		else
			clone.enddatetime = (ims.framework.utils.DateTime)this.enddatetime.clone();
		clone.iscrontrigger = this.iscrontrigger;
		clone.cronexpression = this.cronexpression;
		if(this.lastrun == null)
			clone.lastrun = null;
		else
			clone.lastrun = (ims.framework.utils.DateTime)this.lastrun.clone();
		if(this.nextrun == null)
			clone.nextrun = null;
		else
			clone.nextrun = (ims.framework.utils.DateTime)this.nextrun.clone();
		clone.cronexpressiondisplay = this.cronexpressiondisplay;
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		clone.isactive = this.isactive;
		clone.description = this.description;
		if(this.scheduledjob == null)
			clone.scheduledjob = null;
		else
			clone.scheduledjob = (ims.admin.vo.SystemJobVo)this.scheduledjob.clone();
		if(this.frequency == null)
			clone.frequency = null;
		else
			clone.frequency = (ims.core.vo.lookups.JobRunningFrequency)this.frequency.clone();
		if(this.notificationsonsuccess == null)
			clone.notificationsonsuccess = null;
		else
			clone.notificationsonsuccess = (ims.core.vo.ConfiguredJobNotificationVoCollection)this.notificationsonsuccess.clone();
		if(this.notificationsonfailure == null)
			clone.notificationsonfailure = null;
		else
			clone.notificationsonfailure = (ims.core.vo.ConfiguredJobNotificationVoCollection)this.notificationsonfailure.clone();
		clone.name = this.name;
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
		if (!(ConfiguredJobVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConfiguredJobVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ConfiguredJobVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ConfiguredJobVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.startdatetime != null)
			count++;
		if(this.enddatetime != null)
			count++;
		if(this.iscrontrigger != null)
			count++;
		if(this.cronexpression != null)
			count++;
		if(this.lastrun != null)
			count++;
		if(this.nextrun != null)
			count++;
		if(this.cronexpressiondisplay != null)
			count++;
		if(this.systeminformation != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.description != null)
			count++;
		if(this.scheduledjob != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.notificationsonsuccess != null)
			count++;
		if(this.notificationsonfailure != null)
			count++;
		if(this.name != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.framework.utils.DateTime enddatetime;
	protected Boolean iscrontrigger;
	protected String cronexpression;
	protected ims.framework.utils.DateTime lastrun;
	protected ims.framework.utils.DateTime nextrun;
	protected String cronexpressiondisplay;
	protected ims.vo.SystemInformation systeminformation;
	protected Boolean isactive;
	protected String description;
	protected ims.admin.vo.SystemJobVo scheduledjob;
	protected ims.core.vo.lookups.JobRunningFrequency frequency;
	protected ims.core.vo.ConfiguredJobNotificationVoCollection notificationsonsuccess;
	protected ims.core.vo.ConfiguredJobNotificationVoCollection notificationsonfailure;
	protected String name;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
