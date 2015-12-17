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

package ims.scheduling.vo.beans;

public class ReferralAppointmentDetailsBookingAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public ReferralAppointmentDetailsBookingAppointmentVoBean()
	{
	}
	public ReferralAppointmentDetailsBookingAppointmentVoBean(ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotVoBean)vo.getSessionSlot().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean();
		this.theatreslot = vo.getTheatreSlot() == null ? null : (ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean)vo.getTheatreSlot().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean(map);
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotVoBean)vo.getSessionSlot().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean(map);
		this.theatreslot = vo.getTheatreSlot() == null ? null : (ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean)vo.getTheatreSlot().getBean(map);
	}

	public ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo();
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
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.scheduling.vo.beans.SessionLiteVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionLiteVoBean value)
	{
		this.session = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.requiresrebook = value;
	}
	public ims.scheduling.vo.beans.SessionSlotVoBean getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.scheduling.vo.beans.SessionSlotVoBean value)
	{
		this.sessionslot = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.scheduling.vo.beans.TheatreBookingBaseVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.beans.TheatreBookingBaseVoBean value)
	{
		this.theatrebooking = value;
	}
	public ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean getTheatreSlot()
	{
		return this.theatreslot;
	}
	public void setTheatreSlot(ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean value)
	{
		this.theatreslot = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.scheduling.vo.beans.SessionLiteVoBean session;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private Boolean requiresrebook;
	private ims.scheduling.vo.beans.SessionSlotVoBean sessionslot;
	private Boolean iscabbooking;
	private ims.scheduling.vo.beans.TheatreBookingBaseVoBean theatrebooking;
	private ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean theatreslot;
}
