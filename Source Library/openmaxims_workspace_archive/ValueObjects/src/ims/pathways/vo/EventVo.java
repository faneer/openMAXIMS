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

/**
 * Linked to Pathways.Configuration.Event business object (ID: 1089100000).
 */
public class EventVo extends ims.pathways.vo.EventLiteVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IRecordStatusTree
{
	private static final long serialVersionUID = 1L;

	public EventVo()
	{
	}
	public EventVo(Integer id, int version)
	{
		super(id, version);
	}
	public EventVo(ims.pathways.vo.beans.EventVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.icon = bean.getIcon() == null ? null : bean.getIcon().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.actioningroles = ims.admin.vo.AppRoleShortVoCollection.buildFromBeanCollection(bean.getActioningRoles());
		this.patientdiaryimpact = bean.getPatientDiaryImpact();
		this.eventtype = bean.getEventType() == null ? null : ims.pathways.vo.lookups.EventCreationType.buildLookup(bean.getEventType());
		this.startsclock = bean.getStartsClock();
		this.stopsclock = bean.getStopsClock();
		this.endspathway = bean.getEndsPathway();
		this.ismanualscheduledevent = bean.getIsManualScheduledEvent();
		this.taxonomymaps = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMaps());
		// Interface field type not supported.
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.EventVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.icon = bean.getIcon() == null ? null : bean.getIcon().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.actioningroles = ims.admin.vo.AppRoleShortVoCollection.buildFromBeanCollection(bean.getActioningRoles());
		this.patientdiaryimpact = bean.getPatientDiaryImpact();
		this.eventtype = bean.getEventType() == null ? null : ims.pathways.vo.lookups.EventCreationType.buildLookup(bean.getEventType());
		this.startsclock = bean.getStartsClock();
		this.stopsclock = bean.getStopsClock();
		this.endspathway = bean.getEndsPathway();
		this.ismanualscheduledevent = bean.getIsManualScheduledEvent();
		this.taxonomymaps = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMaps());
		// Interface field type not supported.
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.EventVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.EventVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.EventVoBean();
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
		if(fieldName.equals("TAXONOMYMAPS"))
			return getTaxonomyMaps();
		if(fieldName.equals("EVENTTARGETS"))
			return getEventTargets();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTaxonomyMapsIsNotNull()
	{
		return this.taxonomymaps != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMaps()
	{
		return this.taxonomymaps;
	}
	public void setTaxonomyMaps(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymaps = value;
	}
	public boolean getEventTargetsIsNotNull()
	{
		return this.eventtargets != null;
	}
	public ims.framework.interfaces.IRecordStatusTree[] getEventTargets()
	{
		return this.eventtargets;
	}
	public void setEventTargets(ims.framework.interfaces.IRecordStatusTree[] value)
	{
		this.isValidated = false;
		this.eventtargets = value;
	}
	/**
	* toString
	*/
	public String toString()
	{
		return this.name;
	}
	/**
	* IRecordStatusTree interface methods
	*/
		public ims.framework.interfaces.IRecordStatusTree[] getChildren()
		{
			return this.eventtargets;
		}
		public ims.framework.RecordStatus getIRecordStatusTreeStatus()
		{
			if(status != null)
			{
				if(status.equals(ims.core.vo.lookups.PreActiveActiveInactiveStatus.ACTIVE))
					return ims.framework.RecordStatus.ACTIVE;
				else if(status.equals(ims.core.vo.lookups.PreActiveActiveInactiveStatus.PREACTIVE))
					return ims.framework.RecordStatus.PREACTIVE;
				else if(status.equals(ims.core.vo.lookups.PreActiveActiveInactiveStatus.INACTIVE))
					return ims.framework.RecordStatus.INACTIVE;
			}
			
			return null;
		}
		public boolean isNew()
		{
			return this.id == null;
		}
		public void setChildren(ims.framework.interfaces.IRecordStatusTree[] children)
		{
			this.eventtargets = children;
		}
		public String getDomainObjectName()
		{
			return "Event";
		}
	      public String getStatusMethodName()
		{
			return "getStatus";
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
		if(this.icon != null)
		{
			if(!this.icon.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.actioningroles != null)
		{
			if(!this.actioningroles.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.taxonomymaps != null)
		{
			if(!this.taxonomymaps.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.pathways.vo.EventVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.pathways.vo.EventVo] is too big. It should be less or equal to 255");
		if(this.icon != null)
		{
			String[] listOfOtherErrors = this.icon.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.actioningroles != null)
		{
			String[] listOfOtherErrors = this.actioningroles.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.eventtype == null)
			listOfErrors.add("Event Type is mandatory");
		if(this.taxonomymaps != null)
		{
			String[] listOfOtherErrors = this.taxonomymaps.validate();
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
	
		EventVo clone = new EventVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.icon == null)
			clone.icon = null;
		else
			clone.icon = (ims.admin.vo.AppImageVo)this.icon.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.actioningroles == null)
			clone.actioningroles = null;
		else
			clone.actioningroles = (ims.admin.vo.AppRoleShortVoCollection)this.actioningroles.clone();
		clone.patientdiaryimpact = this.patientdiaryimpact;
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.pathways.vo.lookups.EventCreationType)this.eventtype.clone();
		clone.startsclock = this.startsclock;
		clone.stopsclock = this.stopsclock;
		clone.endspathway = this.endspathway;
		clone.ismanualscheduledevent = this.ismanualscheduledevent;
		if(this.taxonomymaps == null)
			clone.taxonomymaps = null;
		else
			clone.taxonomymaps = (ims.core.vo.TaxonomyMapCollection)this.taxonomymaps.clone();
		clone.eventtargets = this.eventtargets;
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
		if (!(EventVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EventVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EventVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EventVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.taxonomymaps != null)
			count++;
		if(this.eventtargets != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.core.vo.TaxonomyMapCollection taxonomymaps;
	protected ims.framework.interfaces.IRecordStatusTree[] eventtargets;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
