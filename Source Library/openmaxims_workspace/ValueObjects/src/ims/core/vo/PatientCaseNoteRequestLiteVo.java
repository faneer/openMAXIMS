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
public class PatientCaseNoteRequestLiteVo extends ims.core.clinical.vo.PatientCaseNoteRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteRequestLiteVo()
	{
	}
	public PatientCaseNoteRequestLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCaseNoteRequestLiteVo(ims.core.vo.beans.PatientCaseNoteRequestLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.reasonforrequest = bean.getReasonForRequest() == null ? null : ims.core.vo.lookups.CaseNoteReasonForRequest.buildLookup(bean.getReasonForRequest());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCaseNoteRequestLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.reasonforrequest = bean.getReasonForRequest() == null ? null : ims.core.vo.lookups.CaseNoteReasonForRequest.buildLookup(bean.getReasonForRequest());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCaseNoteRequestLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCaseNoteRequestLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCaseNoteRequestLiteVoBean();
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
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("REQUESTSTATUS"))
			return getRequestStatus();
		if(fieldName.equals("REQUIREDBYDATE"))
			return getRequiredByDate();
		if(fieldName.equals("REASONFORREQUEST"))
			return getReasonForRequest();
		if(fieldName.equals("CANCELLEDDATE"))
			return getCancelledDate();
		if(fieldName.equals("CANCELLATIONREASON"))
			return getCancellationReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.DateTime getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.creationdate = value;
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
	public boolean getReasonForRequestIsNotNull()
	{
		return this.reasonforrequest != null;
	}
	public ims.core.vo.lookups.CaseNoteReasonForRequest getReasonForRequest()
	{
		return this.reasonforrequest;
	}
	public void setReasonForRequest(ims.core.vo.lookups.CaseNoteReasonForRequest value)
	{
		this.isValidated = false;
		this.reasonforrequest = value;
	}
	public boolean getCancelledDateIsNotNull()
	{
		return this.cancelleddate != null;
	}
	public ims.framework.utils.DateTime getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.cancelleddate = value;
	}
	public boolean getCancellationReasonIsNotNull()
	{
		return this.cancellationreason != null;
	}
	public ims.core.vo.lookups.CaseNoteRequestCancellationReason getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.core.vo.lookups.CaseNoteRequestCancellationReason value)
	{
		this.isValidated = false;
		this.cancellationreason = value;
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
		if(this.creationdate == null)
			listOfErrors.add("CreationDate is mandatory");
		if(this.requeststatus == null)
			listOfErrors.add("RequestStatus is mandatory");
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
	
		PatientCaseNoteRequestLiteVo clone = new PatientCaseNoteRequestLiteVo(this.id, this.version);
		
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.DateTime)this.creationdate.clone();
		if(this.requeststatus == null)
			clone.requeststatus = null;
		else
			clone.requeststatus = (ims.core.vo.lookups.CaseNoteRequestStatus)this.requeststatus.clone();
		if(this.requiredbydate == null)
			clone.requiredbydate = null;
		else
			clone.requiredbydate = (ims.framework.utils.DateTime)this.requiredbydate.clone();
		if(this.reasonforrequest == null)
			clone.reasonforrequest = null;
		else
			clone.reasonforrequest = (ims.core.vo.lookups.CaseNoteReasonForRequest)this.reasonforrequest.clone();
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.DateTime)this.cancelleddate.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.core.vo.lookups.CaseNoteRequestCancellationReason)this.cancellationreason.clone();
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
		if (!(PatientCaseNoteRequestLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCaseNoteRequestLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCaseNoteRequestLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCaseNoteRequestLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.creationdate != null)
			count++;
		if(this.requeststatus != null)
			count++;
		if(this.requiredbydate != null)
			count++;
		if(this.reasonforrequest != null)
			count++;
		if(this.cancelleddate != null)
			count++;
		if(this.cancellationreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.DateTime creationdate;
	protected ims.core.vo.lookups.CaseNoteRequestStatus requeststatus;
	protected ims.framework.utils.DateTime requiredbydate;
	protected ims.core.vo.lookups.CaseNoteReasonForRequest reasonforrequest;
	protected ims.framework.utils.DateTime cancelleddate;
	protected ims.core.vo.lookups.CaseNoteRequestCancellationReason cancellationreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
