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

public class TrackingStatusWorkflowVoBean extends ims.vo.ValueObjectBean
{
	public TrackingStatusWorkflowVoBean()
	{
	}
	public TrackingStatusWorkflowVoBean(ims.emergency.vo.TrackingStatusWorkflowVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.trackingstatus = vo.getTrackingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTrackingStatus().getBean();
		this.recordsconclusiondatetime = vo.getRecordsConclusionDateTime();
		this.triggerspreadmissionpas = vo.getTriggersPreAdmissionPas();
		this.continuedisplayintracking = vo.getContinueDisplayInTracking();
		this.createnewcarecontext = vo.getCreateNewCareContext();
		this.dischargeoutcome = vo.getDischargeOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeOutcome().getBean();
		this.recordsedattendancedeparture = vo.getRecordsEdAttendanceDeparture();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingStatusWorkflowVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.trackingstatus = vo.getTrackingStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTrackingStatus().getBean();
		this.recordsconclusiondatetime = vo.getRecordsConclusionDateTime();
		this.triggerspreadmissionpas = vo.getTriggersPreAdmissionPas();
		this.continuedisplayintracking = vo.getContinueDisplayInTracking();
		this.createnewcarecontext = vo.getCreateNewCareContext();
		this.dischargeoutcome = vo.getDischargeOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeOutcome().getBean();
		this.recordsedattendancedeparture = vo.getRecordsEdAttendanceDeparture();
	}

	public ims.emergency.vo.TrackingStatusWorkflowVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingStatusWorkflowVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingStatusWorkflowVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingStatusWorkflowVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingStatusWorkflowVo();
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
	public ims.vo.LookupInstanceBean getTrackingStatus()
	{
		return this.trackingstatus;
	}
	public void setTrackingStatus(ims.vo.LookupInstanceBean value)
	{
		this.trackingstatus = value;
	}
	public Boolean getRecordsConclusionDateTime()
	{
		return this.recordsconclusiondatetime;
	}
	public void setRecordsConclusionDateTime(Boolean value)
	{
		this.recordsconclusiondatetime = value;
	}
	public Boolean getTriggersPreAdmissionPas()
	{
		return this.triggerspreadmissionpas;
	}
	public void setTriggersPreAdmissionPas(Boolean value)
	{
		this.triggerspreadmissionpas = value;
	}
	public Boolean getContinueDisplayInTracking()
	{
		return this.continuedisplayintracking;
	}
	public void setContinueDisplayInTracking(Boolean value)
	{
		this.continuedisplayintracking = value;
	}
	public Boolean getCreateNewCareContext()
	{
		return this.createnewcarecontext;
	}
	public void setCreateNewCareContext(Boolean value)
	{
		this.createnewcarecontext = value;
	}
	public ims.vo.LookupInstanceBean getDischargeOutcome()
	{
		return this.dischargeoutcome;
	}
	public void setDischargeOutcome(ims.vo.LookupInstanceBean value)
	{
		this.dischargeoutcome = value;
	}
	public Boolean getRecordsEdAttendanceDeparture()
	{
		return this.recordsedattendancedeparture;
	}
	public void setRecordsEdAttendanceDeparture(Boolean value)
	{
		this.recordsedattendancedeparture = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean trackingstatus;
	private Boolean recordsconclusiondatetime;
	private Boolean triggerspreadmissionpas;
	private Boolean continuedisplayintracking;
	private Boolean createnewcarecontext;
	private ims.vo.LookupInstanceBean dischargeoutcome;
	private Boolean recordsedattendancedeparture;
}
