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
 * Linked to emergency.Tracking business object (ID: 1086100005).
 */
public class TrackingForClinicianWorklistAndTriageVo extends ims.emergency.vo.TrackingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingForClinicianWorklistAndTriageVo()
	{
	}
	public TrackingForClinicianWorklistAndTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingForClinicianWorklistAndTriageVo(ims.emergency.vo.beans.TrackingForClinicianWorklistAndTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo();
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo();
		this.triagedetails = bean.getTriageDetails() == null ? null : bean.getTriageDetails().buildVo();
		this.currentarea = bean.getCurrentArea() == null ? null : bean.getCurrentArea().buildVo();
		this.isdischarged = bean.getIsDischarged();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.currentreferral = bean.getCurrentReferral() == null ? null : bean.getCurrentReferral().buildVo();
		this.seenbynurse = bean.getSeenByNurse() == null ? null : bean.getSeenByNurse().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingForClinicianWorklistAndTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo(map);
		this.episode = bean.getEpisode() == null ? null : bean.getEpisode().buildVo(map);
		this.triagedetails = bean.getTriageDetails() == null ? null : bean.getTriageDetails().buildVo(map);
		this.currentarea = bean.getCurrentArea() == null ? null : bean.getCurrentArea().buildVo(map);
		this.isdischarged = bean.getIsDischarged();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.currentreferral = bean.getCurrentReferral() == null ? null : bean.getCurrentReferral().buildVo(map);
		this.seenbynurse = bean.getSeenByNurse() == null ? null : bean.getSeenByNurse().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingForClinicianWorklistAndTriageVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingForClinicianWorklistAndTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingForClinicianWorklistAndTriageVoBean();
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
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("TRIAGEDETAILS"))
			return getTriageDetails();
		if(fieldName.equals("CURRENTAREA"))
			return getCurrentArea();
		if(fieldName.equals("ISDISCHARGED"))
			return getIsDischarged();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("CURRENTREFERRAL"))
			return getCurrentReferral();
		if(fieldName.equals("SEENBYNURSE"))
			return getSeenByNurse();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.emergency.vo.PatientForTriageVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.emergency.vo.PatientForTriageVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.emergency.vo.EmergencyAttendanceForTriageLiteVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.EmergencyAttendanceForTriageLiteVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.emergency.vo.EmergencyEpisodeForTriageLiteVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.EmergencyEpisodeForTriageLiteVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getTriageDetailsIsNotNull()
	{
		return this.triagedetails != null;
	}
	public ims.emergency.vo.TriageForClinicianWorklistVo getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.emergency.vo.TriageForClinicianWorklistVo value)
	{
		this.isValidated = false;
		this.triagedetails = value;
	}
	public boolean getCurrentAreaIsNotNull()
	{
		return this.currentarea != null;
	}
	public ims.emergency.vo.TrackingAreaLiteVo getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.vo.TrackingAreaLiteVo value)
	{
		this.isValidated = false;
		this.currentarea = value;
	}
	public boolean getIsDischargedIsNotNull()
	{
		return this.isdischarged != null;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isValidated = false;
		this.isdischarged = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.emergency.vo.TrackingAttendanceStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.TrackingAttendanceStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getSeenByIsNotNull()
	{
		return this.seenby != null;
	}
	public ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo value)
	{
		this.isValidated = false;
		this.seenby = value;
	}
	public boolean getCurrentReferralIsNotNull()
	{
		return this.currentreferral != null;
	}
	public ims.emergency.vo.ReferralToSpecialtyTeamForEDAssessmentComponentVo getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.emergency.vo.ReferralToSpecialtyTeamForEDAssessmentComponentVo value)
	{
		this.isValidated = false;
		this.currentreferral = value;
	}
	public boolean getSeenByNurseIsNotNull()
	{
		return this.seenbynurse != null;
	}
	public ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo getSeenByNurse()
	{
		return this.seenbynurse;
	}
	public void setSeenByNurse(ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo value)
	{
		this.isValidated = false;
		this.seenbynurse = value;
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
		if(this.attendance != null)
		{
			if(!this.attendance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentarea != null)
		{
			if(!this.currentarea.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.attendance != null)
		{
			String[] listOfOtherErrors = this.attendance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.currentarea != null)
		{
			String[] listOfOtherErrors = this.currentarea.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
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
	
		TrackingForClinicianWorklistAndTriageVo clone = new TrackingForClinicianWorklistAndTriageVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.emergency.vo.PatientForTriageVo)this.patient.clone();
		if(this.attendance == null)
			clone.attendance = null;
		else
			clone.attendance = (ims.emergency.vo.EmergencyAttendanceForTriageLiteVo)this.attendance.clone();
		if(this.episode == null)
			clone.episode = null;
		else
			clone.episode = (ims.emergency.vo.EmergencyEpisodeForTriageLiteVo)this.episode.clone();
		if(this.triagedetails == null)
			clone.triagedetails = null;
		else
			clone.triagedetails = (ims.emergency.vo.TriageForClinicianWorklistVo)this.triagedetails.clone();
		if(this.currentarea == null)
			clone.currentarea = null;
		else
			clone.currentarea = (ims.emergency.vo.TrackingAreaLiteVo)this.currentarea.clone();
		clone.isdischarged = this.isdischarged;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.emergency.vo.TrackingAttendanceStatusVo)this.currentstatus.clone();
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo)this.seenby.clone();
		if(this.currentreferral == null)
			clone.currentreferral = null;
		else
			clone.currentreferral = (ims.emergency.vo.ReferralToSpecialtyTeamForEDAssessmentComponentVo)this.currentreferral.clone();
		if(this.seenbynurse == null)
			clone.seenbynurse = null;
		else
			clone.seenbynurse = (ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo)this.seenbynurse.clone();
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
		if (!(TrackingForClinicianWorklistAndTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingForClinicianWorklistAndTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingForClinicianWorklistAndTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingForClinicianWorklistAndTriageVo)obj).getBoId());
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
		if(this.attendance != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.triagedetails != null)
			count++;
		if(this.currentarea != null)
			count++;
		if(this.isdischarged != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.currentreferral != null)
			count++;
		if(this.seenbynurse != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.emergency.vo.PatientForTriageVo patient;
	protected ims.emergency.vo.EmergencyAttendanceForTriageLiteVo attendance;
	protected ims.emergency.vo.EmergencyEpisodeForTriageLiteVo episode;
	protected ims.emergency.vo.TriageForClinicianWorklistVo triagedetails;
	protected ims.emergency.vo.TrackingAreaLiteVo currentarea;
	protected Boolean isdischarged;
	protected ims.emergency.vo.TrackingAttendanceStatusVo currentstatus;
	protected ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo seenby;
	protected ims.emergency.vo.ReferralToSpecialtyTeamForEDAssessmentComponentVo currentreferral;
	protected ims.emergency.vo.SeenByHCPForEDAssessmentComponentVo seenbynurse;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
