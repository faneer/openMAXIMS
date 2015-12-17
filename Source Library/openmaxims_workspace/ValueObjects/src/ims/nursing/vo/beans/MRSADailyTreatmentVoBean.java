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

package ims.nursing.vo.beans;

public class MRSADailyTreatmentVoBean extends ims.vo.ValueObjectBean
{
	public MRSADailyTreatmentVoBean()
	{
	}
	public MRSADailyTreatmentVoBean(ims.nursing.vo.MRSADailyTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.treatmentdatetime = vo.getTreatmentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTreatmentDateTime().getBean();
		this.day = vo.getDay() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDay().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.MRSADailyTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean(map);
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.treatmentdatetime = vo.getTreatmentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTreatmentDateTime().getBean();
		this.day = vo.getDay() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDay().getBean();
	}

	public ims.nursing.vo.MRSADailyTreatmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.MRSADailyTreatmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.MRSADailyTreatmentVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.MRSADailyTreatmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.MRSADailyTreatmentVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTreatmentDateTime()
	{
		return this.treatmentdatetime;
	}
	public void setTreatmentDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.treatmentdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getDay()
	{
		return this.day;
	}
	public void setDay(ims.framework.utils.beans.DateBean value)
	{
		this.day = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
	private ims.vo.SysInfoBean sysinfo;
	private ims.framework.utils.beans.DateTimeBean treatmentdatetime;
	private ims.framework.utils.beans.DateBean day;
}
