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

package ims.core.vo.beans;

public class WardDataViewVoBean extends ims.vo.ValueObjectBean
{
	public WardDataViewVoBean()
	{
	}
	public WardDataViewVoBean(ims.core.vo.WardDataViewVo vo)
	{
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.bay = vo.getBay() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getBay().getBean();
		this.bed = vo.getBed() == null ? null : (ims.core.vo.beans.BedSpaceVoBean)vo.getBed().getBean();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean();
		this.inpatepisode = vo.getInpatEpisode() == null ? null : (ims.clinical.vo.beans.InpatientEpisodeForVTERiskAsessmentVoBean)vo.getInpatEpisode().getBean();
		this.bedspacestate = vo.getBedSpaceState() == null ? null : (ims.core.vo.beans.BedSpaceStateListVoBean)vo.getBedSpaceState().getBean();
		this.pendingtransfer = vo.getPendingTransfer() == null ? null : (ims.core.vo.beans.PendingTransferForBedReadyDetailsVoBean)vo.getPendingTransfer().getBean();
		this.healthylodgerdetails = vo.getHealthyLodgerDetails() == null ? null : (ims.core.vo.beans.HealthyLodgerVoBean)vo.getHealthyLodgerDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.WardDataViewVo vo)
	{
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.bay = vo.getBay() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getBay().getBean(map);
		this.bed = vo.getBed() == null ? null : (ims.core.vo.beans.BedSpaceVoBean)vo.getBed().getBean(map);
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean(map);
		this.inpatepisode = vo.getInpatEpisode() == null ? null : (ims.clinical.vo.beans.InpatientEpisodeForVTERiskAsessmentVoBean)vo.getInpatEpisode().getBean(map);
		this.bedspacestate = vo.getBedSpaceState() == null ? null : (ims.core.vo.beans.BedSpaceStateListVoBean)vo.getBedSpaceState().getBean(map);
		this.pendingtransfer = vo.getPendingTransfer() == null ? null : (ims.core.vo.beans.PendingTransferForBedReadyDetailsVoBean)vo.getPendingTransfer().getBean(map);
		this.healthylodgerdetails = vo.getHealthyLodgerDetails() == null ? null : (ims.core.vo.beans.HealthyLodgerVoBean)vo.getHealthyLodgerDetails().getBean(map);
	}

	public ims.core.vo.WardDataViewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.WardDataViewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.WardDataViewVo vo = null;
		if(map != null)
			vo = (ims.core.vo.WardDataViewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.WardDataViewVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PatientLite_IdentifiersVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLite_IdentifiersVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getBay()
	{
		return this.bay;
	}
	public void setBay(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.bay = value;
	}
	public ims.core.vo.beans.BedSpaceVoBean getBed()
	{
		return this.bed;
	}
	public void setBed(ims.core.vo.beans.BedSpaceVoBean value)
	{
		this.bed = value;
	}
	public ims.core.vo.beans.PasEventADTVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventADTVoBean value)
	{
		this.pasevent = value;
	}
	public ims.clinical.vo.beans.InpatientEpisodeForVTERiskAsessmentVoBean getInpatEpisode()
	{
		return this.inpatepisode;
	}
	public void setInpatEpisode(ims.clinical.vo.beans.InpatientEpisodeForVTERiskAsessmentVoBean value)
	{
		this.inpatepisode = value;
	}
	public ims.core.vo.beans.BedSpaceStateListVoBean getBedSpaceState()
	{
		return this.bedspacestate;
	}
	public void setBedSpaceState(ims.core.vo.beans.BedSpaceStateListVoBean value)
	{
		this.bedspacestate = value;
	}
	public ims.core.vo.beans.PendingTransferForBedReadyDetailsVoBean getPendingTransfer()
	{
		return this.pendingtransfer;
	}
	public void setPendingTransfer(ims.core.vo.beans.PendingTransferForBedReadyDetailsVoBean value)
	{
		this.pendingtransfer = value;
	}
	public ims.core.vo.beans.HealthyLodgerVoBean getHealthyLodgerDetails()
	{
		return this.healthylodgerdetails;
	}
	public void setHealthyLodgerDetails(ims.core.vo.beans.HealthyLodgerVoBean value)
	{
		this.healthylodgerdetails = value;
	}

	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.core.vo.beans.LocationLiteVoBean bay;
	private ims.core.vo.beans.BedSpaceVoBean bed;
	private ims.core.vo.beans.PasEventADTVoBean pasevent;
	private ims.clinical.vo.beans.InpatientEpisodeForVTERiskAsessmentVoBean inpatepisode;
	private ims.core.vo.beans.BedSpaceStateListVoBean bedspacestate;
	private ims.core.vo.beans.PendingTransferForBedReadyDetailsVoBean pendingtransfer;
	private ims.core.vo.beans.HealthyLodgerVoBean healthylodgerdetails;
}
