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
 * Linked to core.admin.pas.Historic Outpatient Attendance business object (ID: 1014100007).
 */
public class HistoricOutPatientAttendanceVo extends ims.core.admin.pas.vo.HistoricOutpatientAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HistoricOutPatientAttendanceVo()
	{
	}
	public HistoricOutPatientAttendanceVo(Integer id, int version)
	{
		super(id, version);
	}
	public HistoricOutPatientAttendanceVo(ims.core.vo.beans.HistoricOutPatientAttendanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdatetime = bean.getAppointmentDateTime() == null ? null : bean.getAppointmentDateTime().buildDateTime();
		this.appointmentstatus = bean.getAppointmentStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getAppointmentStatus());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getCancellationReason());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.isactive = bean.getIsActive();
		this.clinic = bean.getClinic() == null ? null : new ims.core.resource.place.vo.ClinicRefVo(new Integer(bean.getClinic().getId()), bean.getClinic().getVersion());
		this.datemoved = bean.getDateMoved() == null ? null : bean.getDateMoved().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.HistoricOutPatientAttendanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdatetime = bean.getAppointmentDateTime() == null ? null : bean.getAppointmentDateTime().buildDateTime();
		this.appointmentstatus = bean.getAppointmentStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getAppointmentStatus());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getCancellationReason());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.isactive = bean.getIsActive();
		this.clinic = bean.getClinic() == null ? null : new ims.core.resource.place.vo.ClinicRefVo(new Integer(bean.getClinic().getId()), bean.getClinic().getVersion());
		this.datemoved = bean.getDateMoved() == null ? null : bean.getDateMoved().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.HistoricOutPatientAttendanceVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.HistoricOutPatientAttendanceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.HistoricOutPatientAttendanceVoBean();
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
		if(fieldName.equals("APPOINTMENTDATETIME"))
			return getAppointmentDateTime();
		if(fieldName.equals("APPOINTMENTSTATUS"))
			return getAppointmentStatus();
		if(fieldName.equals("CANCELLATIONREASON"))
			return getCancellationReason();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("CLINIC"))
			return getClinic();
		if(fieldName.equals("DATEMOVED"))
			return getDateMoved();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentDateTimeIsNotNull()
	{
		return this.appointmentdatetime != null;
	}
	public ims.framework.utils.DateTime getAppointmentDateTime()
	{
		return this.appointmentdatetime;
	}
	public void setAppointmentDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.appointmentdatetime = value;
	}
	public boolean getAppointmentStatusIsNotNull()
	{
		return this.appointmentstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getAppointmentStatus()
	{
		return this.appointmentstatus;
	}
	public void setAppointmentStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.appointmentstatus = value;
	}
	public boolean getCancellationReasonIsNotNull()
	{
		return this.cancellationreason != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.cancellationreason = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.admin.pas.vo.PASEventRefVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.admin.pas.vo.PASEventRefVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
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
	public boolean getClinicIsNotNull()
	{
		return this.clinic != null;
	}
	public ims.core.resource.place.vo.ClinicRefVo getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.resource.place.vo.ClinicRefVo value)
	{
		this.isValidated = false;
		this.clinic = value;
	}
	public boolean getDateMovedIsNotNull()
	{
		return this.datemoved != null;
	}
	public ims.framework.utils.DateTime getDateMoved()
	{
		return this.datemoved;
	}
	public void setDateMoved(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datemoved = value;
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
	
		HistoricOutPatientAttendanceVo clone = new HistoricOutPatientAttendanceVo(this.id, this.version);
		
		if(this.appointmentdatetime == null)
			clone.appointmentdatetime = null;
		else
			clone.appointmentdatetime = (ims.framework.utils.DateTime)this.appointmentdatetime.clone();
		if(this.appointmentstatus == null)
			clone.appointmentstatus = null;
		else
			clone.appointmentstatus = (ims.scheduling.vo.lookups.Status_Reason)this.appointmentstatus.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.scheduling.vo.lookups.Status_Reason)this.cancellationreason.clone();
		clone.pasevent = this.pasevent;
		clone.isactive = this.isactive;
		clone.clinic = this.clinic;
		if(this.datemoved == null)
			clone.datemoved = null;
		else
			clone.datemoved = (ims.framework.utils.DateTime)this.datemoved.clone();
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
		if (!(HistoricOutPatientAttendanceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HistoricOutPatientAttendanceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		HistoricOutPatientAttendanceVo compareObj = (HistoricOutPatientAttendanceVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPasEvent() == null && compareObj.getPasEvent() != null)
				return -1;
			if(this.getPasEvent() != null && compareObj.getPasEvent() == null)
				return 1;
			if(this.getPasEvent() != null && compareObj.getPasEvent() != null)
				retVal = this.getPasEvent().compareTo(compareObj.getPasEvent());
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
		if(this.appointmentdatetime != null)
			count++;
		if(this.appointmentstatus != null)
			count++;
		if(this.cancellationreason != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.clinic != null)
			count++;
		if(this.datemoved != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.framework.utils.DateTime appointmentdatetime;
	protected ims.scheduling.vo.lookups.Status_Reason appointmentstatus;
	protected ims.scheduling.vo.lookups.Status_Reason cancellationreason;
	protected ims.core.admin.pas.vo.PASEventRefVo pasevent;
	protected Boolean isactive;
	protected ims.core.resource.place.vo.ClinicRefVo clinic;
	protected ims.framework.utils.DateTime datemoved;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
