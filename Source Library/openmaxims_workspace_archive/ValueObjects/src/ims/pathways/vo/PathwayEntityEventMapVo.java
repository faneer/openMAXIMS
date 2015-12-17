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

package ims.pathways.vo;


public class PathwayEntityEventMapVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathwayEntityEventMapVo()
	{
	}
	public PathwayEntityEventMapVo(ims.pathways.vo.beans.PathwayEntityEventMapVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.entity = bean.getEntity();
		this.eventid = bean.getEventId();
		this.active = bean.getActive();
		this.scheduleddatetimefield = bean.getScheduledDateTimeField();
		this.description = bean.getDescription();
		this.rule = bean.getRule();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PathwayEntityEventMapVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.entity = bean.getEntity();
		this.eventid = bean.getEventId();
		this.active = bean.getActive();
		this.scheduleddatetimefield = bean.getScheduledDateTimeField();
		this.description = bean.getDescription();
		this.rule = bean.getRule();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PathwayEntityEventMapVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PathwayEntityEventMapVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PathwayEntityEventMapVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIdIsNotNull()
	{
		return this.id != null;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public boolean getVersionIsNotNull()
	{
		return this.version != null;
	}
	public Integer getVersion()
	{
		return this.version;
	}
	public void setVersion(Integer value)
	{
		this.isValidated = false;
		this.version = value;
	}
	public boolean getEntityIsNotNull()
	{
		return this.entity != null;
	}
	public String getEntity()
	{
		return this.entity;
	}
	public static int getEntityMaxLength()
	{
		return 255;
	}
	public void setEntity(String value)
	{
		this.isValidated = false;
		this.entity = value;
	}
	public boolean getEventIdIsNotNull()
	{
		return this.eventid != null;
	}
	public Integer getEventId()
	{
		return this.eventid;
	}
	public void setEventId(Integer value)
	{
		this.isValidated = false;
		this.eventid = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getScheduledDateTimeFieldIsNotNull()
	{
		return this.scheduleddatetimefield != null;
	}
	public String getScheduledDateTimeField()
	{
		return this.scheduleddatetimefield;
	}
	public static int getScheduledDateTimeFieldMaxLength()
	{
		return 255;
	}
	public void setScheduledDateTimeField(String value)
	{
		this.isValidated = false;
		this.scheduleddatetimefield = value;
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
	public boolean getRuleIsNotNull()
	{
		return this.rule != null;
	}
	public String getRule()
	{
		return this.rule;
	}
	public static int getRuleMaxLength()
	{
		return 255;
	}
	public void setRule(String value)
	{
		this.isValidated = false;
		this.rule = value;
	}
	public boolean getEventIsNotNull()
	{
		return this.event != null;
	}
	public ims.pathways.vo.EventLiteVo getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.EventLiteVo value)
	{
		this.isValidated = false;
		this.event = value;
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
		if(!(obj instanceof PathwayEntityEventMapVo))
			return false;
		PathwayEntityEventMapVo compareObj = (PathwayEntityEventMapVo)obj;
		if(this.getId() == null && compareObj.getId() != null)
			return false;
		if(this.getId() != null && compareObj.getId() == null)
			return false;
		if(this.getId() != null && compareObj.getId() != null)
			return this.getId().equals(compareObj.getId());
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
	
		PathwayEntityEventMapVo clone = new PathwayEntityEventMapVo();
		
		clone.id = this.id;
		clone.version = this.version;
		clone.entity = this.entity;
		clone.eventid = this.eventid;
		clone.active = this.active;
		clone.scheduleddatetimefield = this.scheduleddatetimefield;
		clone.description = this.description;
		clone.rule = this.rule;
		if(this.event == null)
			clone.event = null;
		else
			clone.event = (ims.pathways.vo.EventLiteVo)this.event.clone();
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
		if (!(PathwayEntityEventMapVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayEntityEventMapVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathwayEntityEventMapVo compareObj = (PathwayEntityEventMapVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getEntity() == null && compareObj.getEntity() != null)
				return -1;
			if(this.getEntity() != null && compareObj.getEntity() == null)
				return 1;
			if(this.getEntity() != null && compareObj.getEntity() != null)
			{
				if(caseInsensitive)
					retVal = this.getEntity().toLowerCase().compareTo(compareObj.getEntity().toLowerCase());
				else
					retVal = this.getEntity().compareTo(compareObj.getEntity());
			}
		}
		if (retVal == 0)
		{
			if(this.getEvent() == null && compareObj.getEvent() != null)
				return -1;
			if(this.getEvent() != null && compareObj.getEvent() == null)
				return 1;
			if(this.getEvent() != null && compareObj.getEvent() != null)
				retVal = this.getEvent().compareTo(compareObj.getEvent());
		}
		if (retVal == 0)
		{
			if(this.getActive() == null && compareObj.getActive() != null)
				return -1;
			if(this.getActive() != null && compareObj.getActive() == null)
				return 1;
			if(this.getActive() != null && compareObj.getActive() != null)
				retVal = this.getActive().compareTo(compareObj.getActive());
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
		if(this.id != null)
			count++;
		if(this.version != null)
			count++;
		if(this.entity != null)
			count++;
		if(this.eventid != null)
			count++;
		if(this.active != null)
			count++;
		if(this.scheduleddatetimefield != null)
			count++;
		if(this.description != null)
			count++;
		if(this.rule != null)
			count++;
		if(this.event != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected Integer id;
	protected Integer version;
	protected String entity;
	protected Integer eventid;
	protected Boolean active;
	protected String scheduleddatetimefield;
	protected String description;
	protected String rule;
	protected ims.pathways.vo.EventLiteVo event;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
