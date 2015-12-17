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

public class PendingEmergencyAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public PendingEmergencyAdmissionVoBean()
	{
	}
	public PendingEmergencyAdmissionVoBean(ims.core.vo.PendingEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissionstatus = vo.getAdmissionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionStatus().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.dtadatetime = vo.getDTADateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDTADateTime().getBean();
		this.conclusiondate = vo.getConclusionDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDate().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : new ims.vo.RefVoBean(vo.getCurrentLocation().getBoId(), vo.getCurrentLocation().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PendingEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissionstatus = vo.getAdmissionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionStatus().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.dtadatetime = vo.getDTADateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDTADateTime().getBean();
		this.conclusiondate = vo.getConclusionDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDate().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : new ims.vo.RefVoBean(vo.getCurrentLocation().getBoId(), vo.getCurrentLocation().getBoVersion());
	}

	public ims.core.vo.PendingEmergencyAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PendingEmergencyAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PendingEmergencyAdmissionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PendingEmergencyAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PendingEmergencyAdmissionVo();
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
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionStatus()
	{
		return this.admissionstatus;
	}
	public void setAdmissionStatus(ims.vo.LookupInstanceBean value)
	{
		this.admissionstatus = value;
	}
	public String getReasonForAdmission()
	{
		return this.reasonforadmission;
	}
	public void setReasonForAdmission(String value)
	{
		this.reasonforadmission = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDTADateTime()
	{
		return this.dtadatetime;
	}
	public void setDTADateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dtadatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConclusionDate()
	{
		return this.conclusiondate;
	}
	public void setConclusionDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.conclusiondate = value;
	}
	public ims.vo.RefVoBean getCurrentLocation()
	{
		return this.currentlocation;
	}
	public void setCurrentLocation(ims.vo.RefVoBean value)
	{
		this.currentlocation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean pasevent;
	private ims.vo.LookupInstanceBean admissionstatus;
	private String reasonforadmission;
	private ims.framework.utils.beans.DateTimeBean dtadatetime;
	private ims.framework.utils.beans.DateTimeBean conclusiondate;
	private ims.vo.RefVoBean currentlocation;
}
