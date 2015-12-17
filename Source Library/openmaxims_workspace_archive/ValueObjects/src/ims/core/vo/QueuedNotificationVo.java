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

package ims.core.vo;

/**
 * Linked to core.admin.QueuedNotification business object (ID: 1004100047).
 */
public class QueuedNotificationVo extends ims.core.admin.vo.QueuedNotificationRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IQueuedNotification
{
	private static final long serialVersionUID = 1L;

	public QueuedNotificationVo()
	{
	}
	public QueuedNotificationVo(Integer id, int version)
	{
		super(id, version);
	}
	public QueuedNotificationVo(ims.core.vo.beans.QueuedNotificationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.message = bean.getMessage();
		this.priority = bean.getPriority();
		this.entitytype = bean.getEntityType();
		this.entityid = bean.getEntityId();
		this.source = bean.getSource();
		this.userid = bean.getUserId();
		this.deliverymethod = bean.getDeliveryMethod();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.QueuedNotificationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.message = bean.getMessage();
		this.priority = bean.getPriority();
		this.entitytype = bean.getEntityType();
		this.entityid = bean.getEntityId();
		this.source = bean.getSource();
		this.userid = bean.getUserId();
		this.deliverymethod = bean.getDeliveryMethod();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.QueuedNotificationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.QueuedNotificationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.QueuedNotificationVoBean();
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
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("MESSAGE"))
			return getMessage();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("ENTITYTYPE"))
			return getEntityType();
		if(fieldName.equals("ENTITYID"))
			return getEntityId();
		if(fieldName.equals("SOURCE"))
			return getSource();
		if(fieldName.equals("USERID"))
			return getUserId();
		if(fieldName.equals("DELIVERYMETHOD"))
			return getDeliveryMethod();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
	}
	public boolean getMessageIsNotNull()
	{
		return this.message != null;
	}
	public String getMessage()
	{
		return this.message;
	}
	public static int getMessageMaxLength()
	{
		return 10000;
	}
	public void setMessage(String value)
	{
		this.isValidated = false;
		this.message = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public Integer getPriority()
	{
		return this.priority;
	}
	public void setPriority(Integer value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getEntityTypeIsNotNull()
	{
		return this.entitytype != null;
	}
	public String getEntityType()
	{
		return this.entitytype;
	}
	public static int getEntityTypeMaxLength()
	{
		return 500;
	}
	public void setEntityType(String value)
	{
		this.isValidated = false;
		this.entitytype = value;
	}
	public boolean getEntityIdIsNotNull()
	{
		return this.entityid != null;
	}
	public Integer getEntityId()
	{
		return this.entityid;
	}
	public void setEntityId(Integer value)
	{
		this.isValidated = false;
		this.entityid = value;
	}
	public boolean getSourceIsNotNull()
	{
		return this.source != null;
	}
	public String getSource()
	{
		return this.source;
	}
	public static int getSourceMaxLength()
	{
		return 255;
	}
	public void setSource(String value)
	{
		this.isValidated = false;
		this.source = value;
	}
	public boolean getUserIdIsNotNull()
	{
		return this.userid != null;
	}
	public Integer getUserId()
	{
		return this.userid;
	}
	public void setUserId(Integer value)
	{
		this.isValidated = false;
		this.userid = value;
	}
	public boolean getDeliveryMethodIsNotNull()
	{
		return this.deliverymethod != null;
	}
	public Integer getDeliveryMethod()
	{
		return this.deliverymethod;
	}
	public void setDeliveryMethod(Integer value)
	{
		this.isValidated = false;
		this.deliverymethod = value;
	}
	/**
	* IQueuedNotification
	*/
		public int getINotificationId()
		{
			return getBoId() == null ? 0 : getBoId().intValue();
		}
		public int getINotificationUserId()
		{
			return userid == null ? 0 : userid;
		}
		public ims.framework.utils.DateTime getINotificationDateTime()
		{
			return datetime;
		}
		public ims.framework.enumerations.NotificationPriority getINotificationPriority()
		{
			if(priority == null)
				return ims.framework.enumerations.NotificationPriority.NORMAL;
			return ims.framework.enumerations.NotificationPriority.parse(priority);
		}
		public String getINotificationMessage()
		{
			return message;
		}
		public String getINotificationEntityType()
		{
			return entitytype;
		}
		public Integer getINotificationEntityId()
		{
			return entityid;
		}
		public String getINotificationSource()
		{
			return source;
		}
		public ims.framework.enumerations.NotificationDelivery getIQueuedNotificationDelivery() 
		{
			if(deliverymethod == null)
				return null;
			return ims.framework.enumerations.NotificationDelivery.parse(deliverymethod);
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
		if(this.datetime == null)
			listOfErrors.add("DateTime is mandatory");
		if(this.message == null || this.message.length() == 0)
			listOfErrors.add("Message is mandatory");
		if(this.priority == null)
			listOfErrors.add("Priority is mandatory");
		if(this.entitytype != null)
			if(this.entitytype.length() > 500)
				listOfErrors.add("The length of the field [entitytype] in the value object [ims.core.vo.QueuedNotificationVo] is too big. It should be less or equal to 500");
		if(this.source != null)
			if(this.source.length() > 255)
				listOfErrors.add("The length of the field [source] in the value object [ims.core.vo.QueuedNotificationVo] is too big. It should be less or equal to 255");
		if(this.userid == null)
			listOfErrors.add("userId is mandatory");
		if(this.deliverymethod == null)
			listOfErrors.add("deliveryMethod is mandatory");
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
	
		QueuedNotificationVo clone = new QueuedNotificationVo(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		clone.message = this.message;
		clone.priority = this.priority;
		clone.entitytype = this.entitytype;
		clone.entityid = this.entityid;
		clone.source = this.source;
		clone.userid = this.userid;
		clone.deliverymethod = this.deliverymethod;
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
		if (!(QueuedNotificationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A QueuedNotificationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((QueuedNotificationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((QueuedNotificationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datetime != null)
			count++;
		if(this.message != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.entitytype != null)
			count++;
		if(this.entityid != null)
			count++;
		if(this.source != null)
			count++;
		if(this.userid != null)
			count++;
		if(this.deliverymethod != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.framework.utils.DateTime datetime;
	protected String message;
	protected Integer priority;
	protected String entitytype;
	protected Integer entityid;
	protected String source;
	protected Integer userid;
	protected Integer deliverymethod;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
