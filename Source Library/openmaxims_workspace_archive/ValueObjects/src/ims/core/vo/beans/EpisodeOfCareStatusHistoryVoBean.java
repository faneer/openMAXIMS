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

public class EpisodeOfCareStatusHistoryVoBean extends ims.vo.ValueObjectBean
{
	public EpisodeOfCareStatusHistoryVoBean()
	{
	}
	public EpisodeOfCareStatusHistoryVoBean(ims.core.vo.EpisodeOfCareStatusHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.EpisodeOfCareStatusHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.statusdatetime = vo.getStatusDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDateTime().getBean();
	}

	public ims.core.vo.EpisodeOfCareStatusHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.EpisodeOfCareStatusHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.EpisodeOfCareStatusHistoryVo vo = null;
		if(map != null)
			vo = (ims.core.vo.EpisodeOfCareStatusHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.EpisodeOfCareStatusHistoryVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statusdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private ims.framework.utils.beans.DateTimeBean statusdatetime;
}
