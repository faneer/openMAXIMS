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

package ims.core.vo.beans;

public class PasEventAdmitVoBean extends ims.vo.ValueObjectBean
{
	public PasEventAdmitVoBean()
	{
	}
	public PasEventAdmitVoBean(ims.core.vo.PasEventAdmitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.paseventid = vo.getPasEventId();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.location = vo.getLocation() == null ? null : new ims.vo.RefVoBean(vo.getLocation().getBoId(), vo.getLocation().getBoVersion());
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.passpecialty = vo.getPASSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASSpecialty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PasEventAdmitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.paseventid = vo.getPasEventId();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.location = vo.getLocation() == null ? null : new ims.vo.RefVoBean(vo.getLocation().getBoId(), vo.getLocation().getBoVersion());
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.passpecialty = vo.getPASSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASSpecialty().getBean();
	}

	public ims.core.vo.PasEventAdmitVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PasEventAdmitVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PasEventAdmitVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PasEventAdmitVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PasEventAdmitVo();
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
	public ims.framework.utils.beans.DateTimeBean getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.eventdatetime = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public String getPasEventId()
	{
		return this.paseventid;
	}
	public void setPasEventId(String value)
	{
		this.paseventid = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.vo.RefVoBean value)
	{
		this.location = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public ims.vo.LookupInstanceBean getPASSpecialty()
	{
		return this.passpecialty;
	}
	public void setPASSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.passpecialty = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean eventdatetime;
	private ims.core.vo.beans.PatientShortBean patient;
	private String paseventid;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.RefVoBean location;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private ims.vo.LookupInstanceBean passpecialty;
}
