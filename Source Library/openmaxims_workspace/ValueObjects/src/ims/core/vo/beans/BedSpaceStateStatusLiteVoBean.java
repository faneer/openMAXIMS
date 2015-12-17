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

public class BedSpaceStateStatusLiteVoBean extends ims.vo.ValueObjectBean
{
	public BedSpaceStateStatusLiteVoBean()
	{
	}
	public BedSpaceStateStatusLiteVoBean(ims.core.vo.BedSpaceStateStatusLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedstatus = vo.getBedStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedStatus().getBean();
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.reasonforclosure = vo.getReasonForClosure() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForClosure().getBean();
		this.estreopeningdatetime = vo.getEstReopeningDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstReopeningDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.BedSpaceStateStatusLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.bedstatus = vo.getBedStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedStatus().getBean();
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.reasonforclosure = vo.getReasonForClosure() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForClosure().getBean();
		this.estreopeningdatetime = vo.getEstReopeningDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstReopeningDateTime().getBean();
	}

	public ims.core.vo.BedSpaceStateStatusLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.BedSpaceStateStatusLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.BedSpaceStateStatusLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.BedSpaceStateStatusLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.BedSpaceStateStatusLiteVo();
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
	public ims.vo.LookupInstanceBean getBedStatus()
	{
		return this.bedstatus;
	}
	public void setBedStatus(ims.vo.LookupInstanceBean value)
	{
		this.bedstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statusdatetime = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.LookupInstanceBean getReasonForClosure()
	{
		return this.reasonforclosure;
	}
	public void setReasonForClosure(ims.vo.LookupInstanceBean value)
	{
		this.reasonforclosure = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEstReopeningDateTime()
	{
		return this.estreopeningdatetime;
	}
	public void setEstReopeningDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estreopeningdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean bedstatus;
	private ims.framework.utils.beans.DateTimeBean statusdatetime;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.LookupInstanceBean reasonforclosure;
	private ims.framework.utils.beans.DateTimeBean estreopeningdatetime;
}
