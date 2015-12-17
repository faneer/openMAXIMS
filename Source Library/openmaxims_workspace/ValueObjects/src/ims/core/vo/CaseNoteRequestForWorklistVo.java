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
 * Linked to core.clinical.PatientCaseNoteRequest business object (ID: 1003100131).
 */
public class CaseNoteRequestForWorklistVo extends ims.core.clinical.vo.PatientCaseNoteRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CaseNoteRequestForWorklistVo()
	{
	}
	public CaseNoteRequestForWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public CaseNoteRequestForWorklistVo(ims.core.vo.beans.CaseNoteRequestForWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requestedforlocation = bean.getRequestedForLocation() == null ? null : bean.getRequestedForLocation().buildVo();
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo();
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CaseNoteRequestForWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requestedforlocation = bean.getRequestedForLocation() == null ? null : bean.getRequestedForLocation().buildVo(map);
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo(map);
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CaseNoteRequestForWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CaseNoteRequestForWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CaseNoteRequestForWorklistVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REQUESTSTATUS"))
			return getRequestStatus();
		if(fieldName.equals("REQUESTEDFORLOCATION"))
			return getRequestedForLocation();
		if(fieldName.equals("REQUESTEDBY"))
			return getRequestedBy();
		if(fieldName.equals("REQUIREDBYDATE"))
			return getRequiredByDate();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getRequestStatusIsNotNull()
	{
		return this.requeststatus != null;
	}
	public ims.core.vo.lookups.CaseNoteRequestStatus getRequestStatus()
	{
		return this.requeststatus;
	}
	public void setRequestStatus(ims.core.vo.lookups.CaseNoteRequestStatus value)
	{
		this.isValidated = false;
		this.requeststatus = value;
	}
	public boolean getRequestedForLocationIsNotNull()
	{
		return this.requestedforlocation != null;
	}
	public ims.core.vo.LocationForCaseNoteWorklistVo getRequestedForLocation()
	{
		return this.requestedforlocation;
	}
	public void setRequestedForLocation(ims.core.vo.LocationForCaseNoteWorklistVo value)
	{
		this.isValidated = false;
		this.requestedforlocation = value;
	}
	public boolean getRequestedByIsNotNull()
	{
		return this.requestedby != null;
	}
	public ims.core.vo.MemberOfStaffMinVo getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.MemberOfStaffMinVo value)
	{
		this.isValidated = false;
		this.requestedby = value;
	}
	public boolean getRequiredByDateIsNotNull()
	{
		return this.requiredbydate != null;
	}
	public ims.framework.utils.DateTime getRequiredByDate()
	{
		return this.requiredbydate;
	}
	public void setRequiredByDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.requiredbydate = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.requeststatus == null)
			listOfErrors.add("RequestStatus is mandatory");
		if(this.requestedforlocation == null)
			listOfErrors.add("RequestedForLocation is mandatory");
		if(this.requestedby == null)
			listOfErrors.add("RequestedBy is mandatory");
		if(this.requiredbydate == null)
			listOfErrors.add("RequiredByDate is mandatory");
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
	
		CaseNoteRequestForWorklistVo clone = new CaseNoteRequestForWorklistVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.requeststatus == null)
			clone.requeststatus = null;
		else
			clone.requeststatus = (ims.core.vo.lookups.CaseNoteRequestStatus)this.requeststatus.clone();
		if(this.requestedforlocation == null)
			clone.requestedforlocation = null;
		else
			clone.requestedforlocation = (ims.core.vo.LocationForCaseNoteWorklistVo)this.requestedforlocation.clone();
		if(this.requestedby == null)
			clone.requestedby = null;
		else
			clone.requestedby = (ims.core.vo.MemberOfStaffMinVo)this.requestedby.clone();
		if(this.requiredbydate == null)
			clone.requiredbydate = null;
		else
			clone.requiredbydate = (ims.framework.utils.DateTime)this.requiredbydate.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(CaseNoteRequestForWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CaseNoteRequestForWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CaseNoteRequestForWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CaseNoteRequestForWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.requeststatus != null)
			count++;
		if(this.requestedforlocation != null)
			count++;
		if(this.requestedby != null)
			count++;
		if(this.requiredbydate != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.lookups.CaseNoteRequestStatus requeststatus;
	protected ims.core.vo.LocationForCaseNoteWorklistVo requestedforlocation;
	protected ims.core.vo.MemberOfStaffMinVo requestedby;
	protected ims.framework.utils.DateTime requiredbydate;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
