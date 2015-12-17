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

package ims.dtomove.vo.beans;

public class ActivityActionVoBean extends ims.vo.ValueObjectBean
{
	public ActivityActionVoBean()
	{
	}
	public ActivityActionVoBean(ims.dtomove.vo.ActivityActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.active = vo.getActive();
		this.requirement = vo.getRequirement();
		this.action = vo.getAction() == null ? null : (ims.dtomove.vo.beans.ActionVoBean)vo.getAction().getBean();
		this.group = vo.getGroup() == null ? null : (ims.dtomove.vo.beans.ActivityGroupVoBean)vo.getGroup().getBean();
		this.activityid = vo.getActivityId();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.ActivityActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.active = vo.getActive();
		this.requirement = vo.getRequirement();
		this.action = vo.getAction() == null ? null : (ims.dtomove.vo.beans.ActionVoBean)vo.getAction().getBean(map);
		this.group = vo.getGroup() == null ? null : (ims.dtomove.vo.beans.ActivityGroupVoBean)vo.getGroup().getBean(map);
		this.activityid = vo.getActivityId();
	}

	public ims.dtomove.vo.ActivityActionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.dtomove.vo.ActivityActionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.ActivityActionVo vo = null;
		if(map != null)
			vo = (ims.dtomove.vo.ActivityActionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.dtomove.vo.ActivityActionVo();
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
	public String getActive()
	{
		return this.active;
	}
	public void setActive(String value)
	{
		this.active = value;
	}
	public Integer getRequirement()
	{
		return this.requirement;
	}
	public void setRequirement(Integer value)
	{
		this.requirement = value;
	}
	public ims.dtomove.vo.beans.ActionVoBean getAction()
	{
		return this.action;
	}
	public void setAction(ims.dtomove.vo.beans.ActionVoBean value)
	{
		this.action = value;
	}
	public ims.dtomove.vo.beans.ActivityGroupVoBean getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.dtomove.vo.beans.ActivityGroupVoBean value)
	{
		this.group = value;
	}
	public Integer getActivityId()
	{
		return this.activityid;
	}
	public void setActivityId(Integer value)
	{
		this.activityid = value;
	}

	private Integer id;
	private int version;
	private String active;
	private Integer requirement;
	private ims.dtomove.vo.beans.ActionVoBean action;
	private ims.dtomove.vo.beans.ActivityGroupVoBean group;
	private Integer activityid;
}
