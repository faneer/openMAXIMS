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
 * Linked to core.resource.place.Activity business object (ID: 1007100005).
 */
public class ActivityVo extends ims.core.vo.ActivityLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActivityVo()
	{
	}
	public ActivityVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActivityVo(ims.core.vo.beans.ActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.tmreq = bean.getTmReq();
		this.firstappointment = bean.getFirstAppointment();
		this.diagnostic = bean.getDiagnostic();
		this.isactive = bean.getIsActive();
		this.activitytype = bean.getActivityType() == null ? null : ims.core.vo.lookups.ActivityType.buildLookup(bean.getActivityType());
		this.isworkqueue = bean.getIsWorkQueue();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ActivityStatus.buildLookup(bean.getStatus());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.tmreq = bean.getTmReq();
		this.firstappointment = bean.getFirstAppointment();
		this.diagnostic = bean.getDiagnostic();
		this.isactive = bean.getIsActive();
		this.activitytype = bean.getActivityType() == null ? null : ims.core.vo.lookups.ActivityType.buildLookup(bean.getActivityType());
		this.isworkqueue = bean.getIsWorkQueue();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ActivityStatus.buildLookup(bean.getStatus());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ActivityVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ActivityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ActivityVoBean();
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
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ACTIVITYTYPE"))
			return getActivityType();
		if(fieldName.equals("ISWORKQUEUE"))
			return getIsWorkQueue();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("CODEMAPPINGS"))
			return getCodeMappings();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getActivityTypeIsNotNull()
	{
		return this.activitytype != null;
	}
	public ims.core.vo.lookups.ActivityType getActivityType()
	{
		return this.activitytype;
	}
	public void setActivityType(ims.core.vo.lookups.ActivityType value)
	{
		this.isValidated = false;
		this.activitytype = value;
	}
	public boolean getIsWorkQueueIsNotNull()
	{
		return this.isworkqueue != null;
	}
	public Boolean getIsWorkQueue()
	{
		return this.isworkqueue;
	}
	public void setIsWorkQueue(Boolean value)
	{
		this.isValidated = false;
		this.isworkqueue = value;
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
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.ActivityStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.ActivityStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getCodeMappingsIsNotNull()
	{
		return this.codemappings != null;
	}
	public ims.core.vo.TaxonomyMapCollection getCodeMappings()
	{
		return this.codemappings;
	}
	public void setCodeMappings(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.codemappings = value;
	}
	/**
	* toString()
	*/
	public String toString()
	{
		return this.name;
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
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
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
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.ActivityVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.core.vo.ActivityVo] is too big. It should be less or equal to 255");
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
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
	
		ActivityVo clone = new ActivityVo(this.id, this.version);
		
		clone.name = this.name;
		clone.tmreq = this.tmreq;
		clone.firstappointment = this.firstappointment;
		clone.diagnostic = this.diagnostic;
		clone.isactive = this.isactive;
		if(this.activitytype == null)
			clone.activitytype = null;
		else
			clone.activitytype = (ims.core.vo.lookups.ActivityType)this.activitytype.clone();
		clone.isworkqueue = this.isworkqueue;
		clone.description = this.description;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.ActivityStatus)this.status.clone();
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
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
		if (!(ActivityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActivityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ActivityVo compareObj = (ActivityVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
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
		int count = super.countFieldsWithValue();
		if(this.isactive != null)
			count++;
		if(this.activitytype != null)
			count++;
		if(this.isworkqueue != null)
			count++;
		if(this.description != null)
			count++;
		if(this.status != null)
			count++;
		if(this.codemappings != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected Boolean isactive;
	protected ims.core.vo.lookups.ActivityType activitytype;
	protected Boolean isworkqueue;
	protected String description;
	protected ims.core.vo.lookups.ActivityStatus status;
	protected ims.core.vo.TaxonomyMapCollection codemappings;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
