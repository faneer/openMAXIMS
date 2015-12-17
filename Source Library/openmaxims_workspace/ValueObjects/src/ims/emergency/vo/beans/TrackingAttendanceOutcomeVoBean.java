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

package ims.emergency.vo.beans;

public class TrackingAttendanceOutcomeVoBean extends ims.vo.ValueObjectBean
{
	public TrackingAttendanceOutcomeVoBean()
	{
	}
	public TrackingAttendanceOutcomeVoBean(ims.emergency.vo.TrackingAttendanceOutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean)vo.getAttendance().getBean();
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.isdischarged = vo.getIsDischarged();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean();
		this.associatedpendingemergencyadmission = vo.getAssociatedPendingEmergencyAdmission() == null ? null : (ims.emergency.vo.beans.PendingEmergencyAdmissionForDischargeVoBean)vo.getAssociatedPendingEmergencyAdmission().getBean();
		this.bedavailability = vo.getBedAvailability() == null ? null : (ims.emergency.vo.beans.BedAvailabilityVoBean)vo.getBedAvailability().getBean();
		this.currentdnw = vo.getCurrentDNW() == null ? null : (ims.emergency.vo.beans.DNWForOutcomeVoBean)vo.getCurrentDNW().getBean();
		this.reasonforbreach = vo.getReasonForBreach() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBreach().getBean();
		this.currentpartialadmission = vo.getCurrentPartialAdmission() == null ? null : (ims.emergency.vo.beans.EDPartialAdmissionForDischargeDetailOutcomeVoBean)vo.getCurrentPartialAdmission().getBean();
		this.displayined = vo.getDisplayInED();
		this.reasonforbreachcomments = vo.getReasonForBreachComments();
		this.requiringdischargedocumentationreview = vo.getRequiringDischargeDocumentationReview();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingAttendanceOutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean)vo.getAttendance().getBean(map);
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.isdischarged = vo.getIsDischarged();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.associatedpendingemergencyadmission = vo.getAssociatedPendingEmergencyAdmission() == null ? null : (ims.emergency.vo.beans.PendingEmergencyAdmissionForDischargeVoBean)vo.getAssociatedPendingEmergencyAdmission().getBean(map);
		this.bedavailability = vo.getBedAvailability() == null ? null : (ims.emergency.vo.beans.BedAvailabilityVoBean)vo.getBedAvailability().getBean(map);
		this.currentdnw = vo.getCurrentDNW() == null ? null : (ims.emergency.vo.beans.DNWForOutcomeVoBean)vo.getCurrentDNW().getBean(map);
		this.reasonforbreach = vo.getReasonForBreach() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBreach().getBean();
		this.currentpartialadmission = vo.getCurrentPartialAdmission() == null ? null : (ims.emergency.vo.beans.EDPartialAdmissionForDischargeDetailOutcomeVoBean)vo.getCurrentPartialAdmission().getBean(map);
		this.displayined = vo.getDisplayInED();
		this.reasonforbreachcomments = vo.getReasonForBreachComments();
		this.requiringdischargedocumentationreview = vo.getRequiringDischargeDocumentationReview();
	}

	public ims.emergency.vo.TrackingAttendanceOutcomeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingAttendanceOutcomeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingAttendanceOutcomeVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingAttendanceOutcomeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingAttendanceOutcomeVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.RefVoBean getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.vo.RefVoBean value)
	{
		this.currentarea = value;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isdischarged = value;
	}
	public ims.emergency.vo.beans.TrackingAttendanceStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.beans.TrackingAttendanceStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.emergency.vo.beans.PendingEmergencyAdmissionForDischargeVoBean getAssociatedPendingEmergencyAdmission()
	{
		return this.associatedpendingemergencyadmission;
	}
	public void setAssociatedPendingEmergencyAdmission(ims.emergency.vo.beans.PendingEmergencyAdmissionForDischargeVoBean value)
	{
		this.associatedpendingemergencyadmission = value;
	}
	public ims.emergency.vo.beans.BedAvailabilityVoBean getBedAvailability()
	{
		return this.bedavailability;
	}
	public void setBedAvailability(ims.emergency.vo.beans.BedAvailabilityVoBean value)
	{
		this.bedavailability = value;
	}
	public ims.emergency.vo.beans.DNWForOutcomeVoBean getCurrentDNW()
	{
		return this.currentdnw;
	}
	public void setCurrentDNW(ims.emergency.vo.beans.DNWForOutcomeVoBean value)
	{
		this.currentdnw = value;
	}
	public ims.vo.LookupInstanceBean getReasonForBreach()
	{
		return this.reasonforbreach;
	}
	public void setReasonForBreach(ims.vo.LookupInstanceBean value)
	{
		this.reasonforbreach = value;
	}
	public ims.emergency.vo.beans.EDPartialAdmissionForDischargeDetailOutcomeVoBean getCurrentPartialAdmission()
	{
		return this.currentpartialadmission;
	}
	public void setCurrentPartialAdmission(ims.emergency.vo.beans.EDPartialAdmissionForDischargeDetailOutcomeVoBean value)
	{
		this.currentpartialadmission = value;
	}
	public Boolean getDisplayInED()
	{
		return this.displayined;
	}
	public void setDisplayInED(Boolean value)
	{
		this.displayined = value;
	}
	public String getReasonForBreachComments()
	{
		return this.reasonforbreachcomments;
	}
	public void setReasonForBreachComments(String value)
	{
		this.reasonforbreachcomments = value;
	}
	public Boolean getRequiringDischargeDocumentationReview()
	{
		return this.requiringdischargedocumentationreview;
	}
	public void setRequiringDischargeDocumentationReview(Boolean value)
	{
		this.requiringdischargedocumentationreview = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean attendance;
	private ims.vo.RefVoBean currentarea;
	private Boolean isdischarged;
	private ims.emergency.vo.beans.TrackingAttendanceStatusVoBean currentstatus;
	private ims.emergency.vo.beans.PendingEmergencyAdmissionForDischargeVoBean associatedpendingemergencyadmission;
	private ims.emergency.vo.beans.BedAvailabilityVoBean bedavailability;
	private ims.emergency.vo.beans.DNWForOutcomeVoBean currentdnw;
	private ims.vo.LookupInstanceBean reasonforbreach;
	private ims.emergency.vo.beans.EDPartialAdmissionForDischargeDetailOutcomeVoBean currentpartialadmission;
	private Boolean displayined;
	private String reasonforbreachcomments;
	private Boolean requiringdischargedocumentationreview;
}
