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

package ims.ntpf.vo;

/**
 * Linked to NTPF.LoCall.PatientCheckList business object (ID: 1039100005).
 */
public class PatientCheckListVo extends ims.ntpf.locall.vo.PatientCheckListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCheckListVo()
	{
	}
	public PatientCheckListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCheckListVo(ims.ntpf.vo.beans.PatientCheckListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.checklist = bean.getCheckList() == null ? null : ims.ntpf.vo.lookups.PatientCheckList.buildLookup(bean.getCheckList());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ntpf.vo.beans.PatientCheckListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.checklist = bean.getCheckList() == null ? null : ims.ntpf.vo.lookups.PatientCheckList.buildLookup(bean.getCheckList());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ntpf.vo.beans.PatientCheckListVoBean bean = null;
		if(map != null)
			bean = (ims.ntpf.vo.beans.PatientCheckListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ntpf.vo.beans.PatientCheckListVoBean();
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
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("CHECKLIST"))
			return getCheckList();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getCheckListIsNotNull()
	{
		return this.checklist != null;
	}
	public ims.ntpf.vo.lookups.PatientCheckList getCheckList()
	{
		return this.checklist;
	}
	public void setCheckList(ims.ntpf.vo.lookups.PatientCheckList value)
	{
		this.isValidated = false;
		this.checklist = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	/**
	* BuildDisplayString
	*/
	public String BuildDisplayString()
	{
		StringBuffer detail = new StringBuffer();
		if (this.getAuthoringCPIsNotNull())
			detail.append(this.getAuthoringCP().toString() + " - ");
							
		if (this.getAuthoringDateTimeIsNotNull())
			detail.append(this.getAuthoringDateTime().toString(ims.framework.utils.DateTimeFormat.STANDARD) + "hrs");
	
		return detail.toString();
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
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
	
		PatientCheckListVo clone = new PatientCheckListVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.checklist == null)
			clone.checklist = null;
		else
			clone.checklist = (ims.ntpf.vo.lookups.PatientCheckList)this.checklist.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.YesNoUnknown)this.status.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.MemberOfStaffShortVo)this.authoringcp.clone();
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
		if (!(PatientCheckListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCheckListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientCheckListVo compareObj = (PatientCheckListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientCheckList() == null && compareObj.getID_PatientCheckList() != null)
				return -1;
			if(this.getID_PatientCheckList() != null && compareObj.getID_PatientCheckList() == null)
				return 1;
			if(this.getID_PatientCheckList() != null && compareObj.getID_PatientCheckList() != null)
				retVal = this.getID_PatientCheckList().compareTo(compareObj.getID_PatientCheckList());
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
		if(this.authoringdatetime != null)
			count++;
		if(this.checklist != null)
			count++;
		if(this.status != null)
			count++;
		if(this.authoringcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.ntpf.vo.lookups.PatientCheckList checklist;
	protected ims.core.vo.lookups.YesNoUnknown status;
	protected ims.core.vo.MemberOfStaffShortVo authoringcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
