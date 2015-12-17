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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.ExternalSystemEvent business object (ID: 1096100008).
 */
public class ExternalEventVo extends ims.scheduling.vo.ExternalSystemEventRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHL7OutboundMessageHandler
{
	private static final long serialVersionUID = 1L;

	public ExternalEventVo()
	{
	}
	public ExternalEventVo(Integer id, int version)
	{
		super(id, version);
	}
	public ExternalEventVo(ims.scheduling.vo.beans.ExternalEventVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventtype = bean.getEventType() == null ? null : ims.scheduling.vo.lookups.ExternalSystemEventTypes.buildLookup(bean.getEventType());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.wasprocessed = bean.getWasProcessed();
		this.providersystem = bean.getProviderSystem() == null ? null : bean.getProviderSystem().buildVo();
		this.messagestatus = bean.getMessageStatus() == null ? null : ims.ocrr.vo.lookups.OrderMessageStatus.buildLookup(bean.getMessageStatus());
		this.msgtext = bean.getMsgText();
		this.failuremsg = bean.getFailureMsg();
		this.processeddatetime = bean.getProcessedDateTime() == null ? null : bean.getProcessedDateTime().buildDateTime();
		this.investigation = bean.getInvestigation() == null ? null : new ims.ocrr.orderingresults.vo.OrderInvestigationRefVo(new Integer(bean.getInvestigation().getId()), bean.getInvestigation().getVersion());
		this.acktext = bean.getAckText();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.ExternalEventVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventtype = bean.getEventType() == null ? null : ims.scheduling.vo.lookups.ExternalSystemEventTypes.buildLookup(bean.getEventType());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.wasprocessed = bean.getWasProcessed();
		this.providersystem = bean.getProviderSystem() == null ? null : bean.getProviderSystem().buildVo(map);
		this.messagestatus = bean.getMessageStatus() == null ? null : ims.ocrr.vo.lookups.OrderMessageStatus.buildLookup(bean.getMessageStatus());
		this.msgtext = bean.getMsgText();
		this.failuremsg = bean.getFailureMsg();
		this.processeddatetime = bean.getProcessedDateTime() == null ? null : bean.getProcessedDateTime().buildDateTime();
		this.investigation = bean.getInvestigation() == null ? null : new ims.ocrr.orderingresults.vo.OrderInvestigationRefVo(new Integer(bean.getInvestigation().getId()), bean.getInvestigation().getVersion());
		this.acktext = bean.getAckText();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.ExternalEventVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.ExternalEventVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.ExternalEventVoBean();
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
		if(fieldName.equals("EVENTTYPE"))
			return getEventType();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("WASPROCESSED"))
			return getWasProcessed();
		if(fieldName.equals("PROVIDERSYSTEM"))
			return getProviderSystem();
		if(fieldName.equals("MESSAGESTATUS"))
			return getMessageStatus();
		if(fieldName.equals("MSGTEXT"))
			return getMsgText();
		if(fieldName.equals("FAILUREMSG"))
			return getFailureMsg();
		if(fieldName.equals("PROCESSEDDATETIME"))
			return getProcessedDateTime();
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ACKTEXT"))
			return getAckText();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEventTypeIsNotNull()
	{
		return this.eventtype != null;
	}
	public ims.scheduling.vo.lookups.ExternalSystemEventTypes getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.scheduling.vo.lookups.ExternalSystemEventTypes value)
	{
		this.isValidated = false;
		this.eventtype = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getWasProcessedIsNotNull()
	{
		return this.wasprocessed != null;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.isValidated = false;
		this.wasprocessed = value;
	}
	public boolean getProviderSystemIsNotNull()
	{
		return this.providersystem != null;
	}
	public ims.ocrr.vo.ProviderSystemVo getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.ProviderSystemVo value)
	{
		this.isValidated = false;
		this.providersystem = value;
	}
	public boolean getMessageStatusIsNotNull()
	{
		return this.messagestatus != null;
	}
	public ims.ocrr.vo.lookups.OrderMessageStatus getMessageStatus()
	{
		return this.messagestatus;
	}
	public void setMessageStatus(ims.ocrr.vo.lookups.OrderMessageStatus value)
	{
		this.isValidated = false;
		this.messagestatus = value;
	}
	public boolean getMsgTextIsNotNull()
	{
		return this.msgtext != null;
	}
	public String getMsgText()
	{
		return this.msgtext;
	}
	public static int getMsgTextMaxLength()
	{
		return 4000;
	}
	public void setMsgText(String value)
	{
		this.isValidated = false;
		this.msgtext = value;
	}
	public boolean getFailureMsgIsNotNull()
	{
		return this.failuremsg != null;
	}
	public String getFailureMsg()
	{
		return this.failuremsg;
	}
	public static int getFailureMsgMaxLength()
	{
		return 1000;
	}
	public void setFailureMsg(String value)
	{
		this.isValidated = false;
		this.failuremsg = value;
	}
	public boolean getProcessedDateTimeIsNotNull()
	{
		return this.processeddatetime != null;
	}
	public ims.framework.utils.DateTime getProcessedDateTime()
	{
		return this.processeddatetime;
	}
	public void setProcessedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.processeddatetime = value;
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.orderingresults.vo.OrderInvestigationRefVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getAckTextIsNotNull()
	{
		return this.acktext != null;
	}
	public String getAckText()
	{
		return this.acktext;
	}
	public static int getAckTextMaxLength()
	{
		return 1000;
	}
	public void setAckText(String value)
	{
		this.isValidated = false;
		this.acktext = value;
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
		if(this.providersystem != null)
		{
			if(!this.providersystem.isValidated())
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
		if(this.appointment == null)
			listOfErrors.add("Appointment is mandatory");
		if(this.wasprocessed == null)
			listOfErrors.add("wasProcessed is mandatory");
		if(this.providersystem != null)
		{
			String[] listOfOtherErrors = this.providersystem.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.messagestatus == null)
			listOfErrors.add("messageStatus is mandatory");
		if(this.failuremsg != null)
			if(this.failuremsg.length() > 1000)
				listOfErrors.add("The length of the field [failuremsg] in the value object [ims.scheduling.vo.ExternalEventVo] is too big. It should be less or equal to 1000");
		if(this.acktext != null)
			if(this.acktext.length() > 1000)
				listOfErrors.add("The length of the field [acktext] in the value object [ims.scheduling.vo.ExternalEventVo] is too big. It should be less or equal to 1000");
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
	
		ExternalEventVo clone = new ExternalEventVo(this.id, this.version);
		
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.scheduling.vo.lookups.ExternalSystemEventTypes)this.eventtype.clone();
		clone.appointment = this.appointment;
		clone.wasprocessed = this.wasprocessed;
		if(this.providersystem == null)
			clone.providersystem = null;
		else
			clone.providersystem = (ims.ocrr.vo.ProviderSystemVo)this.providersystem.clone();
		if(this.messagestatus == null)
			clone.messagestatus = null;
		else
			clone.messagestatus = (ims.ocrr.vo.lookups.OrderMessageStatus)this.messagestatus.clone();
		clone.msgtext = this.msgtext;
		clone.failuremsg = this.failuremsg;
		if(this.processeddatetime == null)
			clone.processeddatetime = null;
		else
			clone.processeddatetime = (ims.framework.utils.DateTime)this.processeddatetime.clone();
		clone.investigation = this.investigation;
		clone.acktext = this.acktext;
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
		if (!(ExternalEventVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ExternalEventVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ExternalEventVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ExternalEventVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.eventtype != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.wasprocessed != null)
			count++;
		if(this.providersystem != null)
			count++;
		if(this.messagestatus != null)
			count++;
		if(this.msgtext != null)
			count++;
		if(this.failuremsg != null)
			count++;
		if(this.processeddatetime != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.acktext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.scheduling.vo.lookups.ExternalSystemEventTypes eventtype;
	protected ims.scheduling.vo.Booking_AppointmentRefVo appointment;
	protected Boolean wasprocessed;
	protected ims.ocrr.vo.ProviderSystemVo providersystem;
	protected ims.ocrr.vo.lookups.OrderMessageStatus messagestatus;
	protected String msgtext;
	protected String failuremsg;
	protected ims.framework.utils.DateTime processeddatetime;
	protected ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation;
	protected String acktext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
