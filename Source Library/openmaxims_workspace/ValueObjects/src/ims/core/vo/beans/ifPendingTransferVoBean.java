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

public class ifPendingTransferVoBean extends ims.vo.ValueObjectBean
{
	public ifPendingTransferVoBean()
	{
	}
	public ifPendingTransferVoBean(ims.core.vo.ifPendingTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.transferrequestdatetime = vo.getTransferRequestDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferRequestDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.transfercomment = vo.getTransferComment();
		this.destinationward = vo.getDestinationWard() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getDestinationWard().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ifPendingTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.transferrequestdatetime = vo.getTransferRequestDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferRequestDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.transfercomment = vo.getTransferComment();
		this.destinationward = vo.getDestinationWard() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getDestinationWard().getBean(map);
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.core.vo.ifPendingTransferVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ifPendingTransferVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ifPendingTransferVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ifPendingTransferVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ifPendingTransferVo();
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
	public ims.vo.LookupInstanceBean getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.vo.LookupInstanceBean value)
	{
		this.wardtype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTransferRequestDateTime()
	{
		return this.transferrequestdatetime;
	}
	public void setTransferRequestDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.transferrequestdatetime = value;
	}
	public ims.vo.LookupInstanceBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.vo.LookupInstanceBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.LookupInstanceBean getTransferReason()
	{
		return this.transferreason;
	}
	public void setTransferReason(ims.vo.LookupInstanceBean value)
	{
		this.transferreason = value;
	}
	public String getTransferComment()
	{
		return this.transfercomment;
	}
	public void setTransferComment(String value)
	{
		this.transfercomment = value;
	}
	public ims.core.vo.beans.LocMostVoBean getDestinationWard()
	{
		return this.destinationward;
	}
	public void setDestinationWard(ims.core.vo.beans.LocMostVoBean value)
	{
		this.destinationward = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean wardtype;
	private ims.framework.utils.beans.DateTimeBean transferrequestdatetime;
	private ims.vo.LookupInstanceBean currentstatus;
	private ims.vo.LookupInstanceBean transferreason;
	private String transfercomment;
	private ims.core.vo.beans.LocMostVoBean destinationward;
	private ims.vo.LookupInstanceBean patientstatus;
	private ims.vo.SysInfoBean sysinfo;
}
