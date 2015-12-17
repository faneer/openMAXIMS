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

package ims.scheduling.vo.beans;

public class BookingAppointmentForFitForSurgeryAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public BookingAppointmentForFitForSurgeryAssessmentVoBean()
	{
	}
	public BookingAppointmentForFitForSurgeryAssessmentVoBean(ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteVoBean)vo.getSession().getBean(map);
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean(map);
	}

	public ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo();
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
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
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
	public ims.scheduling.vo.beans.TheatreBookingBaseVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.beans.TheatreBookingBaseVoBean value)
	{
		this.theatrebooking = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.scheduling.vo.beans.SessionLiteVoBean session;
	private ims.scheduling.vo.beans.TheatreBookingBaseVoBean theatrebooking;
}
