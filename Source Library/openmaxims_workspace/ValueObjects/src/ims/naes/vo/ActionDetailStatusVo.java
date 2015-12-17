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

package ims.naes.vo;

/**
 * Linked to NAES.ActionDetailStatus business object (ID: 1097100003).
 */
public class ActionDetailStatusVo extends ims.naes.vo.ActionDetailStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionDetailStatusVo()
	{
	}
	public ActionDetailStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActionDetailStatusVo(ims.naes.vo.beans.ActionDetailStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.naes.vo.lookups.NaesActionStatus.buildLookup(bean.getStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.technician = bean.getTechnician() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getTechnician().getId()), bean.getTechnician().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.naes.vo.beans.ActionDetailStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.naes.vo.lookups.NaesActionStatus.buildLookup(bean.getStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.technician = bean.getTechnician() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getTechnician().getId()), bean.getTechnician().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.naes.vo.beans.ActionDetailStatusVoBean bean = null;
		if(map != null)
			bean = (ims.naes.vo.beans.ActionDetailStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.naes.vo.beans.ActionDetailStatusVoBean();
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
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDateTime();
		if(fieldName.equals("TECHNICIAN"))
			return getTechnician();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.naes.vo.lookups.NaesActionStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.naes.vo.lookups.NaesActionStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getStatusDateTimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
	}
	public boolean getTechnicianIsNotNull()
	{
		return this.technician != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getTechnician()
	{
		return this.technician;
	}
	public void setTechnician(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.technician = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDateTime is mandatory");
		if(this.technician == null)
			listOfErrors.add("Responsible MOS is mandatory");
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
	
		ActionDetailStatusVo clone = new ActionDetailStatusVo(this.id, this.version);
		
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.naes.vo.lookups.NaesActionStatus)this.status.clone();
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		clone.technician = this.technician;
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
		if (!(ActionDetailStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionDetailStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ActionDetailStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ActionDetailStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.status != null)
			count++;
		if(this.statusdatetime != null)
			count++;
		if(this.technician != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.naes.vo.lookups.NaesActionStatus status;
	protected ims.framework.utils.DateTime statusdatetime;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo technician;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
