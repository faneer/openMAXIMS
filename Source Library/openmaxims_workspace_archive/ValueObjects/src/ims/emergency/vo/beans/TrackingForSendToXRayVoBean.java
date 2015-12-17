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

package ims.emergency.vo.beans;

public class TrackingForSendToXRayVoBean extends ims.vo.ValueObjectBean
{
	public TrackingForSendToXRayVoBean()
	{
	}
	public TrackingForSendToXRayVoBean(ims.emergency.vo.TrackingForSendToXRayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.isdischarged = vo.getIsDischarged();
		this.iscurrentlyinxray = vo.getIsCurrentlyInXray();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingForSendToXRayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.isdischarged = vo.getIsDischarged();
		this.iscurrentlyinxray = vo.getIsCurrentlyInXray();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean(map);
	}

	public ims.emergency.vo.TrackingForSendToXRayVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingForSendToXRayVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingForSendToXRayVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingForSendToXRayVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingForSendToXRayVo();
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
	public Boolean getIsCurrentlyInXray()
	{
		return this.iscurrentlyinxray;
	}
	public void setIsCurrentlyInXray(Boolean value)
	{
		this.iscurrentlyinxray = value;
	}
	public ims.emergency.vo.beans.TrackingAttendanceStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.beans.TrackingAttendanceStatusVoBean value)
	{
		this.currentstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean currentarea;
	private Boolean isdischarged;
	private Boolean iscurrentlyinxray;
	private ims.emergency.vo.beans.TrackingAttendanceStatusVoBean currentstatus;
}
