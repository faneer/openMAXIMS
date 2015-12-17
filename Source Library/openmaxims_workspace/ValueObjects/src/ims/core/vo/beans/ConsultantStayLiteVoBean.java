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

public class ConsultantStayLiteVoBean extends ims.vo.ValueObjectBean
{
	public ConsultantStayLiteVoBean()
	{
	}
	public ConsultantStayLiteVoBean(ims.core.vo.ConsultantStayLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.transferdatetime = vo.getTransferDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getConsultant().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ConsultantStayLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.transferdatetime = vo.getTransferDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getConsultant().getBean(map);
	}

	public ims.core.vo.ConsultantStayLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ConsultantStayLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ConsultantStayLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ConsultantStayLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ConsultantStayLiteVo();
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
	public ims.framework.utils.beans.DateTimeBean getTransferDateTime()
	{
		return this.transferdatetime;
	}
	public void setTransferDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.transferdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.enddatetime = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public ims.core.vo.beans.MedicVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicVoBean value)
	{
		this.consultant = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean transferdatetime;
	private ims.framework.utils.beans.DateTimeBean enddatetime;
	private ims.vo.LookupInstanceBean specialty;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean patientstatus;
	private ims.core.vo.beans.MedicVoBean consultant;
}
