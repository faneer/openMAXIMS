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

package ims.emergency.vo;

/**
 * Linked to emergency.SeenByHCP business object (ID: 1086100034).
 */
public class SeenByHcpForEventHistoryVo extends ims.emergency.vo.SeenByHCPRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SeenByHcpForEventHistoryVo()
	{
	}
	public SeenByHcpForEventHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public SeenByHcpForEventHistoryVo(ims.emergency.vo.beans.SeenByHcpForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.allocateddatetime = bean.getAllocatedDateTime() == null ? null : bean.getAllocatedDateTime().buildDateTime();
		this.allocatedmedic = bean.getAllocatedMedic() == null ? null : bean.getAllocatedMedic().buildVo();
		this.allocatednurse = bean.getAllocatedNurse() == null ? null : bean.getAllocatedNurse().buildVo();
		this.seendatetime = bean.getSeenDateTime() == null ? null : bean.getSeenDateTime().buildDateTime();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.signoff = bean.getSignOff();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.SeenByHcpForEventHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.allocateddatetime = bean.getAllocatedDateTime() == null ? null : bean.getAllocatedDateTime().buildDateTime();
		this.allocatedmedic = bean.getAllocatedMedic() == null ? null : bean.getAllocatedMedic().buildVo(map);
		this.allocatednurse = bean.getAllocatedNurse() == null ? null : bean.getAllocatedNurse().buildVo(map);
		this.seendatetime = bean.getSeenDateTime() == null ? null : bean.getSeenDateTime().buildDateTime();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.signoff = bean.getSignOff();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.SeenByHcpForEventHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.SeenByHcpForEventHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.SeenByHcpForEventHistoryVoBean();
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
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("ALLOCATEDDATETIME"))
			return getAllocatedDateTime();
		if(fieldName.equals("ALLOCATEDMEDIC"))
			return getAllocatedMedic();
		if(fieldName.equals("ALLOCATEDNURSE"))
			return getAllocatedNurse();
		if(fieldName.equals("SEENDATETIME"))
			return getSeenDateTime();
		if(fieldName.equals("COMPLETEDDATETIME"))
			return getCompletedDateTime();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		if(fieldName.equals("SIGNOFF"))
			return getSignOff();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getAllocatedDateTimeIsNotNull()
	{
		return this.allocateddatetime != null;
	}
	public ims.framework.utils.DateTime getAllocatedDateTime()
	{
		return this.allocateddatetime;
	}
	public void setAllocatedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.allocateddatetime = value;
	}
	public boolean getAllocatedMedicIsNotNull()
	{
		return this.allocatedmedic != null;
	}
	public ims.core.vo.MedicVo getAllocatedMedic()
	{
		return this.allocatedmedic;
	}
	public void setAllocatedMedic(ims.core.vo.MedicVo value)
	{
		this.isValidated = false;
		this.allocatedmedic = value;
	}
	public boolean getAllocatedNurseIsNotNull()
	{
		return this.allocatednurse != null;
	}
	public ims.core.vo.NurseVo getAllocatedNurse()
	{
		return this.allocatednurse;
	}
	public void setAllocatedNurse(ims.core.vo.NurseVo value)
	{
		this.isValidated = false;
		this.allocatednurse = value;
	}
	public boolean getSeenDateTimeIsNotNull()
	{
		return this.seendatetime != null;
	}
	public ims.framework.utils.DateTime getSeenDateTime()
	{
		return this.seendatetime;
	}
	public void setSeenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.seendatetime = value;
	}
	public boolean getCompletedDateTimeIsNotNull()
	{
		return this.completeddatetime != null;
	}
	public ims.framework.utils.DateTime getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completeddatetime = value;
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
	public boolean getSignOffIsNotNull()
	{
		return this.signoff != null;
	}
	public Boolean getSignOff()
	{
		return this.signoff;
	}
	public void setSignOff(Boolean value)
	{
		this.isValidated = false;
		this.signoff = value;
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
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.allocateddatetime == null)
			listOfErrors.add("AllocatedDateTime is mandatory");
		if(this.seendatetime == null)
			listOfErrors.add("SeenDateTime is mandatory");
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
	
		SeenByHcpForEventHistoryVo clone = new SeenByHcpForEventHistoryVo(this.id, this.version);
		
		clone.attendance = this.attendance;
		if(this.allocateddatetime == null)
			clone.allocateddatetime = null;
		else
			clone.allocateddatetime = (ims.framework.utils.DateTime)this.allocateddatetime.clone();
		if(this.allocatedmedic == null)
			clone.allocatedmedic = null;
		else
			clone.allocatedmedic = (ims.core.vo.MedicVo)this.allocatedmedic.clone();
		if(this.allocatednurse == null)
			clone.allocatednurse = null;
		else
			clone.allocatednurse = (ims.core.vo.NurseVo)this.allocatednurse.clone();
		if(this.seendatetime == null)
			clone.seendatetime = null;
		else
			clone.seendatetime = (ims.framework.utils.DateTime)this.seendatetime.clone();
		if(this.completeddatetime == null)
			clone.completeddatetime = null;
		else
			clone.completeddatetime = (ims.framework.utils.DateTime)this.completeddatetime.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		clone.signoff = this.signoff;
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
		if (!(SeenByHcpForEventHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SeenByHcpForEventHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SeenByHcpForEventHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SeenByHcpForEventHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.attendance != null)
			count++;
		if(this.allocateddatetime != null)
			count++;
		if(this.allocatedmedic != null)
			count++;
		if(this.allocatednurse != null)
			count++;
		if(this.seendatetime != null)
			count++;
		if(this.completeddatetime != null)
			count++;
		if(this.systeminformation != null)
			count++;
		if(this.signoff != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.framework.utils.DateTime allocateddatetime;
	protected ims.core.vo.MedicVo allocatedmedic;
	protected ims.core.vo.NurseVo allocatednurse;
	protected ims.framework.utils.DateTime seendatetime;
	protected ims.framework.utils.DateTime completeddatetime;
	protected ims.vo.SystemInformation systeminformation;
	protected Boolean signoff;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
