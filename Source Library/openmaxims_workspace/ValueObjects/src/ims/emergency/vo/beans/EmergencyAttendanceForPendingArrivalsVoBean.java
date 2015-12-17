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

public class EmergencyAttendanceForPendingArrivalsVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceForPendingArrivalsVoBean()
	{
	}
	public EmergencyAttendanceForPendingArrivalsVoBean(ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean();
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.comments = vo.getComments();
		this.registrationlocation = vo.getRegistrationLocation() == null ? null : new ims.vo.RefVoBean(vo.getRegistrationLocation().getBoId(), vo.getRegistrationLocation().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForPendingArrivalsVoBean)vo.getEpisode().getBean();
		this.expectedarrivaldatetime = vo.getExpectedArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedArrivalDateTime().getBean();
		this.registrationdatetime = vo.getRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRegistrationDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean(map);
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.comments = vo.getComments();
		this.registrationlocation = vo.getRegistrationLocation() == null ? null : new ims.vo.RefVoBean(vo.getRegistrationLocation().getBoId(), vo.getRegistrationLocation().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForPendingArrivalsVoBean)vo.getEpisode().getBean(map);
		this.expectedarrivaldatetime = vo.getExpectedArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedArrivalDateTime().getBean();
		this.registrationdatetime = vo.getRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRegistrationDateTime().getBean();
	}

	public ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.PatientLiteVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLiteVoBean value)
	{
		this.patient = value;
	}
	public ims.framework.utils.beans.DateTimeBean getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.arrivaldatetime = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.vo.RefVoBean getRegistrationLocation()
	{
		return this.registrationlocation;
	}
	public void setRegistrationLocation(ims.vo.RefVoBean value)
	{
		this.registrationlocation = value;
	}
	public ims.emergency.vo.beans.EmergencyEpisodeForPendingArrivalsVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.beans.EmergencyEpisodeForPendingArrivalsVoBean value)
	{
		this.episode = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExpectedArrivalDateTime()
	{
		return this.expectedarrivaldatetime;
	}
	public void setExpectedArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.expectedarrivaldatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRegistrationDateTime()
	{
		return this.registrationdatetime;
	}
	public void setRegistrationDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.registrationdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.PatientLiteVoBean patient;
	private ims.framework.utils.beans.DateTimeBean arrivaldatetime;
	private String comments;
	private ims.vo.RefVoBean registrationlocation;
	private ims.emergency.vo.beans.EmergencyEpisodeForPendingArrivalsVoBean episode;
	private ims.framework.utils.beans.DateTimeBean expectedarrivaldatetime;
	private ims.framework.utils.beans.DateTimeBean registrationdatetime;
}
