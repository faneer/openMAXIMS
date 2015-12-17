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

package ims.emergency.vo;

/**
 * Linked to emergency.TrackingAttendanceStatus business object (ID: 1086100013).
 */
public class TrackingAttendanceStatusVo extends ims.emergency.vo.TrackingAttendanceStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingAttendanceStatusVo()
	{
	}
	public TrackingAttendanceStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingAttendanceStatusVo(ims.emergency.vo.beans.TrackingAttendanceStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getTrackingArea().getId()), bean.getTrackingArea().getVersion());
		this.statusdatetime = bean.getStatusDatetime() == null ? null : bean.getStatusDatetime().buildDateTime();
		this.createdby = bean.getCreatedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getCreatedBy().getId()), bean.getCreatedBy().getVersion());
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getStatus());
		this.prevstatus = bean.getPrevStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getPrevStatus());
		this.prevtrackingarea = bean.getPrevTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getPrevTrackingArea().getId()), bean.getPrevTrackingArea().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingAttendanceStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getTrackingArea().getId()), bean.getTrackingArea().getVersion());
		this.statusdatetime = bean.getStatusDatetime() == null ? null : bean.getStatusDatetime().buildDateTime();
		this.createdby = bean.getCreatedBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getCreatedBy().getId()), bean.getCreatedBy().getVersion());
		this.status = bean.getStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getStatus());
		this.prevstatus = bean.getPrevStatus() == null ? null : ims.emergency.vo.lookups.TrackingStatus.buildLookup(bean.getPrevStatus());
		this.prevtrackingarea = bean.getPrevTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getPrevTrackingArea().getId()), bean.getPrevTrackingArea().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingAttendanceStatusVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingAttendanceStatusVoBean();
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
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("TRACKINGAREA"))
			return getTrackingArea();
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDatetime();
		if(fieldName.equals("CREATEDBY"))
			return getCreatedBy();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("PREVSTATUS"))
			return getPrevStatus();
		if(fieldName.equals("PREVTRACKINGAREA"))
			return getPrevTrackingArea();
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
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
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
	public boolean getTrackingAreaIsNotNull()
	{
		return this.trackingarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.trackingarea = value;
	}
	public boolean getStatusDatetimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDatetime()
	{
		return this.statusdatetime;
	}
	public void setStatusDatetime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
	}
	public boolean getCreatedByIsNotNull()
	{
		return this.createdby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getCreatedBy()
	{
		return this.createdby;
	}
	public void setCreatedBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.createdby = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.emergency.vo.lookups.TrackingStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.emergency.vo.lookups.TrackingStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getPrevStatusIsNotNull()
	{
		return this.prevstatus != null;
	}
	public ims.emergency.vo.lookups.TrackingStatus getPrevStatus()
	{
		return this.prevstatus;
	}
	public void setPrevStatus(ims.emergency.vo.lookups.TrackingStatus value)
	{
		this.isValidated = false;
		this.prevstatus = value;
	}
	public boolean getPrevTrackingAreaIsNotNull()
	{
		return this.prevtrackingarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getPrevTrackingArea()
	{
		return this.prevtrackingarea;
	}
	public void setPrevTrackingArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.prevtrackingarea = value;
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
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.trackingarea == null)
			listOfErrors.add("TrackingArea is mandatory");
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDatetime is mandatory");
		if(this.createdby == null)
			listOfErrors.add("Logged in user must be a member of staff.");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		TrackingAttendanceStatusVo clone = new TrackingAttendanceStatusVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		clone.trackingarea = this.trackingarea;
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		clone.createdby = this.createdby;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.emergency.vo.lookups.TrackingStatus)this.status.clone();
		if(this.prevstatus == null)
			clone.prevstatus = null;
		else
			clone.prevstatus = (ims.emergency.vo.lookups.TrackingStatus)this.prevstatus.clone();
		clone.prevtrackingarea = this.prevtrackingarea;
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
		if (!(TrackingAttendanceStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingAttendanceStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingAttendanceStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingAttendanceStatusVo)obj).getBoId());
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
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.trackingarea != null)
			count++;
		if(this.statusdatetime != null)
			count++;
		if(this.createdby != null)
			count++;
		if(this.status != null)
			count++;
		if(this.prevstatus != null)
			count++;
		if(this.prevtrackingarea != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.configuration.vo.TrackingAreaRefVo trackingarea;
	protected ims.framework.utils.DateTime statusdatetime;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo createdby;
	protected ims.emergency.vo.lookups.TrackingStatus status;
	protected ims.emergency.vo.lookups.TrackingStatus prevstatus;
	protected ims.emergency.configuration.vo.TrackingAreaRefVo prevtrackingarea;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
