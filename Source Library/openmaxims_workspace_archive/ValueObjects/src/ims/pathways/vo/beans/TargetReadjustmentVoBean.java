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

package ims.pathways.vo.beans;

public class TargetReadjustmentVoBean extends ims.vo.ValueObjectBean
{
	public TargetReadjustmentVoBean()
	{
	}
	public TargetReadjustmentVoBean(ims.pathways.vo.TargetReadjustmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.noofdays = vo.getNoOfDays();
		this.reason = vo.getReason();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.targetreadjustment = vo.getTargetReadjustment() == null ? null : (ims.vo.LookupInstanceBean)vo.getTargetReadjustment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.TargetReadjustmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.noofdays = vo.getNoOfDays();
		this.reason = vo.getReason();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.targetreadjustment = vo.getTargetReadjustment() == null ? null : (ims.vo.LookupInstanceBean)vo.getTargetReadjustment().getBean();
	}

	public ims.pathways.vo.TargetReadjustmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.TargetReadjustmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.TargetReadjustmentVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.TargetReadjustmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.TargetReadjustmentVo();
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
	public Integer getNoOfDays()
	{
		return this.noofdays;
	}
	public void setNoOfDays(Integer value)
	{
		this.noofdays = value;
	}
	public String getReason()
	{
		return this.reason;
	}
	public void setReason(String value)
	{
		this.reason = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}
	public ims.vo.LookupInstanceBean getTargetReadjustment()
	{
		return this.targetreadjustment;
	}
	public void setTargetReadjustment(ims.vo.LookupInstanceBean value)
	{
		this.targetreadjustment = value;
	}

	private Integer id;
	private int version;
	private Integer noofdays;
	private String reason;
	private ims.vo.SysInfoBean systeminformation;
	private ims.vo.LookupInstanceBean targetreadjustment;
}
