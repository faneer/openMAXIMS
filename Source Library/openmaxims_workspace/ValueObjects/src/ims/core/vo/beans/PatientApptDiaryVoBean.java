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

public class PatientApptDiaryVoBean extends ims.vo.ValueObjectBean
{
	public PatientApptDiaryVoBean()
	{
	}
	public PatientApptDiaryVoBean(ims.core.vo.PatientApptDiaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentid = vo.getAppointmentId();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.clinicname = vo.getClinicName();
		this.clinic = vo.getClinic() == null ? null : new ims.vo.RefVoBean(vo.getClinic().getBoId(), vo.getClinic().getBoVersion());
		this.source = vo.getSource();
		this.appttype = vo.getApptType();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.status = vo.getStatus();
		this.statusdate = vo.getStatusDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDate().getBean();
		this.bookedby = vo.getBookedBy();
		this.bookeddate = vo.getBookedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBookedDate().getBean();
		this.pkey = vo.getPkey();
		this.appointheaderid = vo.getAppointHeaderId();
		this.active = vo.getActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientApptDiaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentid = vo.getAppointmentId();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean(map);
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.clinicname = vo.getClinicName();
		this.clinic = vo.getClinic() == null ? null : new ims.vo.RefVoBean(vo.getClinic().getBoId(), vo.getClinic().getBoVersion());
		this.source = vo.getSource();
		this.appttype = vo.getApptType();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.status = vo.getStatus();
		this.statusdate = vo.getStatusDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDate().getBean();
		this.bookedby = vo.getBookedBy();
		this.bookeddate = vo.getBookedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBookedDate().getBean();
		this.pkey = vo.getPkey();
		this.appointheaderid = vo.getAppointHeaderId();
		this.active = vo.getActive();
	}

	public ims.core.vo.PatientApptDiaryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientApptDiaryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientApptDiaryVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientApptDiaryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientApptDiaryVo();
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
	public Integer getAppointmentId()
	{
		return this.appointmentid;
	}
	public void setAppointmentId(Integer value)
	{
		this.appointmentid = value;
	}
	public ims.core.vo.beans.PasEventADTVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventADTVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateBean getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.beans.DateBean value)
	{
		this.apptdate = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.starttime = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTime()
	{
		return this.endtime;
	}
	public void setEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.endtime = value;
	}
	public String getClinicName()
	{
		return this.clinicname;
	}
	public void setClinicName(String value)
	{
		this.clinicname = value;
	}
	public ims.vo.RefVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.vo.RefVoBean value)
	{
		this.clinic = value;
	}
	public String getSource()
	{
		return this.source;
	}
	public void setSource(String value)
	{
		this.source = value;
	}
	public String getApptType()
	{
		return this.appttype;
	}
	public void setApptType(String value)
	{
		this.appttype = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getStatus()
	{
		return this.status;
	}
	public void setStatus(String value)
	{
		this.status = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStatusDate()
	{
		return this.statusdate;
	}
	public void setStatusDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statusdate = value;
	}
	public String getBookedBy()
	{
		return this.bookedby;
	}
	public void setBookedBy(String value)
	{
		this.bookedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getBookedDate()
	{
		return this.bookeddate;
	}
	public void setBookedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.bookeddate = value;
	}
	public Integer getPkey()
	{
		return this.pkey;
	}
	public void setPkey(Integer value)
	{
		this.pkey = value;
	}
	public Integer getAppointHeaderId()
	{
		return this.appointheaderid;
	}
	public void setAppointHeaderId(Integer value)
	{
		this.appointheaderid = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}

	private Integer id;
	private int version;
	private Integer appointmentid;
	private ims.core.vo.beans.PasEventADTVoBean pasevent;
	private ims.framework.utils.beans.DateBean apptdate;
	private ims.framework.utils.beans.TimeBean starttime;
	private ims.framework.utils.beans.TimeBean endtime;
	private String clinicname;
	private ims.vo.RefVoBean clinic;
	private String source;
	private String appttype;
	private ims.vo.RefVoBean patient;
	private String status;
	private ims.framework.utils.beans.DateTimeBean statusdate;
	private String bookedby;
	private ims.framework.utils.beans.DateTimeBean bookeddate;
	private Integer pkey;
	private Integer appointheaderid;
	private Boolean active;
}
