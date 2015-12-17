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

public class ElectiveTCIForReferralDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ElectiveTCIForReferralDetailsVoBean()
	{
	}
	public ElectiveTCIForReferralDetailsVoBean(ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)vo.getAppointment().getBean();
		this.isactive = vo.getIsActive();
		this.rttbreachreason = vo.getRTTBreachReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRTTBreachReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)vo.getAppointment().getBean(map);
		this.isactive = vo.getIsActive();
		this.rttbreachreason = vo.getRTTBreachReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRTTBreachReason().getBean();
	}

	public ims.RefMan.vo.ElectiveTCIForReferralDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ElectiveTCIForReferralDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ElectiveTCIForReferralDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ElectiveTCIForReferralDetailsVo();
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
	public ims.framework.utils.beans.DateBean getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.beans.DateBean value)
	{
		this.tcidate = value;
	}
	public ims.framework.utils.beans.TimeBean getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.beans.TimeBean value)
	{
		this.tcitime = value;
	}
	public ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean value)
	{
		this.appointment = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getRTTBreachReason()
	{
		return this.rttbreachreason;
	}
	public void setRTTBreachReason(ims.vo.LookupInstanceBean value)
	{
		this.rttbreachreason = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean tcidate;
	private ims.framework.utils.beans.TimeBean tcitime;
	private ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean appointment;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean rttbreachreason;
}
