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
 * Linked to core.Documents.DocumentStatus business object (ID: 1068100006).
 */
public class PatientDocumentStatusVo extends ims.core.documents.vo.DocumentStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDocumentStatusVo()
	{
	}
	public PatientDocumentStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDocumentStatusVo(ims.core.vo.beans.PatientDocumentStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.correspondencestatus = bean.getCorrespondenceStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getCorrespondenceStatus());
		this.recordinguser = bean.getRecordingUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordingUser().getId()), bean.getRecordingUser().getVersion());
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientDocumentStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.correspondencestatus = bean.getCorrespondenceStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getCorrespondenceStatus());
		this.recordinguser = bean.getRecordingUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordingUser().getId()), bean.getRecordingUser().getVersion());
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientDocumentStatusVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientDocumentStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientDocumentStatusVoBean();
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
		if(fieldName.equals("CORRESPONDENCESTATUS"))
			return getCorrespondenceStatus();
		if(fieldName.equals("RECORDINGUSER"))
			return getRecordingUser();
		if(fieldName.equals("RECORDINGDATETIME"))
			return getRecordingDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCorrespondenceStatusIsNotNull()
	{
		return this.correspondencestatus != null;
	}
	public ims.core.vo.lookups.DocumentStatus getCorrespondenceStatus()
	{
		return this.correspondencestatus;
	}
	public void setCorrespondenceStatus(ims.core.vo.lookups.DocumentStatus value)
	{
		this.isValidated = false;
		this.correspondencestatus = value;
	}
	public boolean getRecordingUserIsNotNull()
	{
		return this.recordinguser != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.recordinguser = value;
	}
	public boolean getRecordingDateTimeIsNotNull()
	{
		return this.recordingdatetime != null;
	}
	public ims.framework.utils.DateTime getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.recordingdatetime = value;
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
		if(this.correspondencestatus == null)
			listOfErrors.add("CorrespondenceStatus is mandatory");
		if(this.recordinguser == null)
			listOfErrors.add("RecordingUser is mandatory");
		if(this.recordingdatetime == null)
			listOfErrors.add("RecordingDateTime is mandatory");
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
	
		PatientDocumentStatusVo clone = new PatientDocumentStatusVo(this.id, this.version);
		
		if(this.correspondencestatus == null)
			clone.correspondencestatus = null;
		else
			clone.correspondencestatus = (ims.core.vo.lookups.DocumentStatus)this.correspondencestatus.clone();
		clone.recordinguser = this.recordinguser;
		if(this.recordingdatetime == null)
			clone.recordingdatetime = null;
		else
			clone.recordingdatetime = (ims.framework.utils.DateTime)this.recordingdatetime.clone();
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
		if (!(PatientDocumentStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDocumentStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDocumentStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDocumentStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.correspondencestatus != null)
			count++;
		if(this.recordinguser != null)
			count++;
		if(this.recordingdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.DocumentStatus correspondencestatus;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo recordinguser;
	protected ims.framework.utils.DateTime recordingdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
