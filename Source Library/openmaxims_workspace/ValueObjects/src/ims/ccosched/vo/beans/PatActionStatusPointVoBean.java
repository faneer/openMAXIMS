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

package ims.ccosched.vo.beans;

public class PatActionStatusPointVoBean extends ims.vo.ValueObjectBean
{
	public PatActionStatusPointVoBean()
	{
	}
	public PatActionStatusPointVoBean(ims.ccosched.vo.PatActionStatusPointVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.actionstatusreason = vo.getActionStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatusReason().getBean();
		this.spenddate = vo.getSpEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSpEndDate().getBean();
		this.spstartdate = vo.getSpStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSpStartDate().getBean();
		this.actionstatus = vo.getActionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.PatActionStatusPointVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.actionstatusreason = vo.getActionStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatusReason().getBean();
		this.spenddate = vo.getSpEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSpEndDate().getBean();
		this.spstartdate = vo.getSpStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSpStartDate().getBean();
		this.actionstatus = vo.getActionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatus().getBean();
	}

	public ims.ccosched.vo.PatActionStatusPointVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ccosched.vo.PatActionStatusPointVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.PatActionStatusPointVo vo = null;
		if(map != null)
			vo = (ims.ccosched.vo.PatActionStatusPointVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ccosched.vo.PatActionStatusPointVo();
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
	public ims.vo.LookupInstanceBean getActionStatusReason()
	{
		return this.actionstatusreason;
	}
	public void setActionStatusReason(ims.vo.LookupInstanceBean value)
	{
		this.actionstatusreason = value;
	}
	public ims.framework.utils.beans.DateBean getSpEndDate()
	{
		return this.spenddate;
	}
	public void setSpEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.spenddate = value;
	}
	public ims.framework.utils.beans.DateBean getSpStartDate()
	{
		return this.spstartdate;
	}
	public void setSpStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.spstartdate = value;
	}
	public ims.vo.LookupInstanceBean getActionStatus()
	{
		return this.actionstatus;
	}
	public void setActionStatus(ims.vo.LookupInstanceBean value)
	{
		this.actionstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean actionstatusreason;
	private ims.framework.utils.beans.DateBean spenddate;
	private ims.framework.utils.beans.DateBean spstartdate;
	private ims.vo.LookupInstanceBean actionstatus;
}
