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

package ims.pathways.vo;

/**
 * Linked to Pathways.Configuration.EventExternalEventMapping business object (ID: 1089100008).
 */
public class EventExternalEventMappingVo extends ims.pathways.configuration.vo.EventExternalEventMappingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EventExternalEventMappingVo()
	{
	}
	public EventExternalEventMappingVo(Integer id, int version)
	{
		super(id, version);
	}
	public EventExternalEventMappingVo(ims.pathways.vo.beans.EventExternalEventMappingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo();
		this.externaleventmapping = bean.getExternalEventMapping() == null ? null : bean.getExternalEventMapping().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.activatedby = bean.getActivatedBy() == null ? null : bean.getActivatedBy().buildVo();
		this.activateddatetime = bean.getActivatedDateTime() == null ? null : bean.getActivatedDateTime().buildDateTime();
		this.inactivatedby = bean.getInactivatedBy() == null ? null : bean.getInactivatedBy().buildVo();
		this.inactivateddatetime = bean.getInactivatedDateTime() == null ? null : bean.getInactivatedDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.EventExternalEventMappingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo(map);
		this.externaleventmapping = bean.getExternalEventMapping() == null ? null : bean.getExternalEventMapping().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.activatedby = bean.getActivatedBy() == null ? null : bean.getActivatedBy().buildVo(map);
		this.activateddatetime = bean.getActivatedDateTime() == null ? null : bean.getActivatedDateTime().buildDateTime();
		this.inactivatedby = bean.getInactivatedBy() == null ? null : bean.getInactivatedBy().buildVo(map);
		this.inactivateddatetime = bean.getInactivatedDateTime() == null ? null : bean.getInactivatedDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.EventExternalEventMappingVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.EventExternalEventMappingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.EventExternalEventMappingVoBean();
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
		if(fieldName.equals("EVENT"))
			return getEvent();
		if(fieldName.equals("EXTERNALEVENTMAPPING"))
			return getExternalEventMapping();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("ACTIVATEDBY"))
			return getActivatedBy();
		if(fieldName.equals("ACTIVATEDDATETIME"))
			return getActivatedDateTime();
		if(fieldName.equals("INACTIVATEDBY"))
			return getInactivatedBy();
		if(fieldName.equals("INACTIVATEDDATETIME"))
			return getInactivatedDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEventIsNotNull()
	{
		return this.event != null;
	}
	public ims.pathways.vo.EventVo getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.EventVo value)
	{
		this.isValidated = false;
		this.event = value;
	}
	public boolean getExternalEventMappingIsNotNull()
	{
		return this.externaleventmapping != null;
	}
	public ims.pathways.vo.ExternalEventMappingVo getExternalEventMapping()
	{
		return this.externaleventmapping;
	}
	public void setExternalEventMapping(ims.pathways.vo.ExternalEventMappingVo value)
	{
		this.isValidated = false;
		this.externaleventmapping = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getActivatedByIsNotNull()
	{
		return this.activatedby != null;
	}
	public ims.admin.vo.AppUserShortVo getActivatedBy()
	{
		return this.activatedby;
	}
	public void setActivatedBy(ims.admin.vo.AppUserShortVo value)
	{
		this.isValidated = false;
		this.activatedby = value;
	}
	public boolean getActivatedDateTimeIsNotNull()
	{
		return this.activateddatetime != null;
	}
	public ims.framework.utils.DateTime getActivatedDateTime()
	{
		return this.activateddatetime;
	}
	public void setActivatedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.activateddatetime = value;
	}
	public boolean getInactivatedByIsNotNull()
	{
		return this.inactivatedby != null;
	}
	public ims.admin.vo.AppUserShortVo getInactivatedBy()
	{
		return this.inactivatedby;
	}
	public void setInactivatedBy(ims.admin.vo.AppUserShortVo value)
	{
		this.isValidated = false;
		this.inactivatedby = value;
	}
	public boolean getInactivatedDateTimeIsNotNull()
	{
		return this.inactivateddatetime != null;
	}
	public ims.framework.utils.DateTime getInactivatedDateTime()
	{
		return this.inactivateddatetime;
	}
	public void setInactivatedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.inactivateddatetime = value;
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
		if(this.event == null)
			listOfErrors.add("Event is mandatory");
		if(this.externaleventmapping == null)
			listOfErrors.add("ExternalEventMapping is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		EventExternalEventMappingVo clone = new EventExternalEventMappingVo(this.id, this.version);
		
		if(this.event == null)
			clone.event = null;
		else
			clone.event = (ims.pathways.vo.EventVo)this.event.clone();
		if(this.externaleventmapping == null)
			clone.externaleventmapping = null;
		else
			clone.externaleventmapping = (ims.pathways.vo.ExternalEventMappingVo)this.externaleventmapping.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.activatedby == null)
			clone.activatedby = null;
		else
			clone.activatedby = (ims.admin.vo.AppUserShortVo)this.activatedby.clone();
		if(this.activateddatetime == null)
			clone.activateddatetime = null;
		else
			clone.activateddatetime = (ims.framework.utils.DateTime)this.activateddatetime.clone();
		if(this.inactivatedby == null)
			clone.inactivatedby = null;
		else
			clone.inactivatedby = (ims.admin.vo.AppUserShortVo)this.inactivatedby.clone();
		if(this.inactivateddatetime == null)
			clone.inactivateddatetime = null;
		else
			clone.inactivateddatetime = (ims.framework.utils.DateTime)this.inactivateddatetime.clone();
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
		if (!(EventExternalEventMappingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EventExternalEventMappingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EventExternalEventMappingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EventExternalEventMappingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.event != null)
			count++;
		if(this.externaleventmapping != null)
			count++;
		if(this.status != null)
			count++;
		if(this.activatedby != null)
			count++;
		if(this.activateddatetime != null)
			count++;
		if(this.inactivatedby != null)
			count++;
		if(this.inactivateddatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.pathways.vo.EventVo event;
	protected ims.pathways.vo.ExternalEventMappingVo externaleventmapping;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected ims.admin.vo.AppUserShortVo activatedby;
	protected ims.framework.utils.DateTime activateddatetime;
	protected ims.admin.vo.AppUserShortVo inactivatedby;
	protected ims.framework.utils.DateTime inactivateddatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
