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

package ims.RefMan.vo.beans;

public class CATSReferralManualRTTClockStatusVoBean extends ims.vo.ValueObjectBean
{
	public CATSReferralManualRTTClockStatusVoBean()
	{
	}
	public CATSReferralManualRTTClockStatusVoBean(ims.RefMan.vo.CATSReferralManualRTTClockStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.CATSReferralDetailsForRTTMaintainanceVoBean)vo.getReferralDetails().getBean();
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.PathwayRTTStatusVoBean)vo.getCurrentRTTStatus().getBean();
		this.journey = vo.getJourney() == null ? null : (ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean)vo.getJourney().getBean();
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CATSReferralManualRTTClockStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.CATSReferralDetailsForRTTMaintainanceVoBean)vo.getReferralDetails().getBean(map);
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.PathwayRTTStatusVoBean)vo.getCurrentRTTStatus().getBean(map);
		this.journey = vo.getJourney() == null ? null : (ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean)vo.getJourney().getBean(map);
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
	}

	public ims.RefMan.vo.CATSReferralManualRTTClockStatusVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CATSReferralManualRTTClockStatusVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CATSReferralManualRTTClockStatusVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CATSReferralManualRTTClockStatusVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CATSReferralManualRTTClockStatusVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.RefMan.vo.beans.CATSReferralDetailsForRTTMaintainanceVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.beans.CATSReferralDetailsForRTTMaintainanceVoBean value)
	{
		this.referraldetails = value;
	}
	public ims.pathways.vo.beans.PathwayRTTStatusVoBean getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.beans.PathwayRTTStatusVoBean value)
	{
		this.currentrttstatus = value;
	}
	public ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean value)
	{
		this.journey = value;
	}
	public ims.vo.LookupInstanceBean getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.vo.LookupInstanceBean value)
	{
		this.urgency = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.RefMan.vo.beans.CATSReferralDetailsForRTTMaintainanceVoBean referraldetails;
	private ims.pathways.vo.beans.PathwayRTTStatusVoBean currentrttstatus;
	private ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean journey;
	private ims.vo.LookupInstanceBean urgency;
}
