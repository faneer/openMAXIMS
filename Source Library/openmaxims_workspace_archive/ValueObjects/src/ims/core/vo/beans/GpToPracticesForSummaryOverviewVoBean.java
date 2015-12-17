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

public class GpToPracticesForSummaryOverviewVoBean extends ims.vo.ValueObjectBean
{
	public GpToPracticesForSummaryOverviewVoBean()
	{
	}
	public GpToPracticesForSummaryOverviewVoBean(ims.core.vo.GpToPracticesForSummaryOverviewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getGp().getBean();
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getPractice().getBean();
		this.isprimarypractice = vo.getIsPrimaryPractice();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.GpToPracticesForSummaryOverviewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getGp().getBean(map);
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getPractice().getBean(map);
		this.isprimarypractice = vo.getIsPrimaryPractice();
	}

	public ims.core.vo.GpToPracticesForSummaryOverviewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.GpToPracticesForSummaryOverviewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.GpToPracticesForSummaryOverviewVo vo = null;
		if(map != null)
			vo = (ims.core.vo.GpToPracticesForSummaryOverviewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.GpToPracticesForSummaryOverviewVo();
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
	public ims.core.vo.beans.GpLiteVoBean getGp()
	{
		return this.gp;
	}
	public void setGp(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.gp = value;
	}
	public ims.core.vo.beans.OrganisationLiteVoBean getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.vo.beans.OrganisationLiteVoBean value)
	{
		this.practice = value;
	}
	public Boolean getIsPrimaryPractice()
	{
		return this.isprimarypractice;
	}
	public void setIsPrimaryPractice(Boolean value)
	{
		this.isprimarypractice = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.GpLiteVoBean gp;
	private ims.core.vo.beans.OrganisationLiteVoBean practice;
	private Boolean isprimarypractice;
}
