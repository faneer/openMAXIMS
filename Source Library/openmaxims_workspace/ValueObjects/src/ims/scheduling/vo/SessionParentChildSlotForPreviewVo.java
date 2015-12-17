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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.SessionParentChildSlot business object (ID: 1090100019).
 */
public class SessionParentChildSlotForPreviewVo extends ims.scheduling.vo.SessionParentChildSlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionParentChildSlotForPreviewVo()
	{
	}
	public SessionParentChildSlotForPreviewVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionParentChildSlotForPreviewVo(ims.scheduling.vo.beans.SessionParentChildSlotForPreviewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.sessdatetime = bean.getSessDateTime() == null ? null : bean.getSessDateTime().buildDateTime();
		this.duration = bean.getDuration();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionParentChildSlotForPreviewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.sessdatetime = bean.getSessDateTime() == null ? null : bean.getSessDateTime().buildDateTime();
		this.duration = bean.getDuration();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionParentChildSlotForPreviewVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionParentChildSlotForPreviewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionParentChildSlotForPreviewVoBean();
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
		if(fieldName.equals("STARTTIME"))
			return getStartTime();
		if(fieldName.equals("SESSDATETIME"))
			return getSessDateTime();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("SLOTRESP"))
			return getSlotResp();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartTimeIsNotNull()
	{
		return this.starttime != null;
	}
	public ims.framework.utils.Time getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttime = value;
	}
	public boolean getSessDateTimeIsNotNull()
	{
		return this.sessdatetime != null;
	}
	public ims.framework.utils.DateTime getSessDateTime()
	{
		return this.sessdatetime;
	}
	public void setSessDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.sessdatetime = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.scheduling.vo.lookups.SchedulingPriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.scheduling.vo.lookups.SchedulingPriority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getSlotRespIsNotNull()
	{
		return this.slotresp != null;
	}
	public ims.scheduling.vo.SessionListOwnerLiteVo getSlotResp()
	{
		return this.slotresp;
	}
	public void setSlotResp(ims.scheduling.vo.SessionListOwnerLiteVo value)
	{
		this.isValidated = false;
		this.slotresp = value;
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
	
		SessionParentChildSlotForPreviewVo clone = new SessionParentChildSlotForPreviewVo(this.id, this.version);
		
		if(this.starttime == null)
			clone.starttime = null;
		else
			clone.starttime = (ims.framework.utils.Time)this.starttime.clone();
		if(this.sessdatetime == null)
			clone.sessdatetime = null;
		else
			clone.sessdatetime = (ims.framework.utils.DateTime)this.sessdatetime.clone();
		clone.duration = this.duration;
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		if(this.slotresp == null)
			clone.slotresp = null;
		else
			clone.slotresp = (ims.scheduling.vo.SessionListOwnerLiteVo)this.slotresp.clone();
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
		if (!(SessionParentChildSlotForPreviewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionParentChildSlotForPreviewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionParentChildSlotForPreviewVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionParentChildSlotForPreviewVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.starttime != null)
			count++;
		if(this.sessdatetime != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.slotresp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.framework.utils.Time starttime;
	protected ims.framework.utils.DateTime sessdatetime;
	protected Integer duration;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected ims.scheduling.vo.SessionListOwnerLiteVo slotresp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
