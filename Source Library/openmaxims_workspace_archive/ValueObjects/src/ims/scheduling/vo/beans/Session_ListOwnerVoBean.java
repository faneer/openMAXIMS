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

package ims.scheduling.vo.beans;

public class Session_ListOwnerVoBean extends ims.vo.ValueObjectBean
{
	public Session_ListOwnerVoBean()
	{
	}
	public Session_ListOwnerVoBean(ims.scheduling.vo.Session_ListOwnerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.maxnoappts = vo.getMaxNoAppts();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcp().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.Session_ListOwnerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.maxnoappts = vo.getMaxNoAppts();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcp().getBean(map);
	}

	public ims.scheduling.vo.Session_ListOwnerVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.Session_ListOwnerVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.Session_ListOwnerVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.Session_ListOwnerVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.Session_ListOwnerVo();
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
	public Integer getMaxNoAppts()
	{
		return this.maxnoappts;
	}
	public void setMaxNoAppts(Integer value)
	{
		this.maxnoappts = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.TimeBean starttime;
	private ims.framework.utils.beans.TimeBean endtime;
	private Integer maxnoappts;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
}
