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

public class DrawingGroupVoBean extends ims.vo.ValueObjectBean
{
	public DrawingGroupVoBean()
	{
	}
	public DrawingGroupVoBean(ims.core.vo.DrawingGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.groupid = vo.getGroupID();
		this.groupname = vo.getGroupName();
		this.areacollection = vo.getAreaCollection() == null ? null : vo.getAreaCollection().getBeanCollection();
		this.childgroups = vo.getChildGroups() == null ? null : vo.getChildGroups().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DrawingGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.groupid = vo.getGroupID();
		this.groupname = vo.getGroupName();
		this.areacollection = vo.getAreaCollection() == null ? null : vo.getAreaCollection().getBeanCollection();
		this.childgroups = vo.getChildGroups() == null ? null : vo.getChildGroups().getBeanCollection();
	}

	public ims.core.vo.DrawingGroupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DrawingGroupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DrawingGroupVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DrawingGroupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DrawingGroupVo();
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
	public Integer getGroupID()
	{
		return this.groupid;
	}
	public void setGroupID(Integer value)
	{
		this.groupid = value;
	}
	public String getGroupName()
	{
		return this.groupname;
	}
	public void setGroupName(String value)
	{
		this.groupname = value;
	}
	public ims.core.vo.beans.DrawingAreaVoBean[] getAreaCollection()
	{
		return this.areacollection;
	}
	public void setAreaCollection(ims.core.vo.beans.DrawingAreaVoBean[] value)
	{
		this.areacollection = value;
	}
	public ims.core.vo.beans.DrawingGroupVoBean[] getChildGroups()
	{
		return this.childgroups;
	}
	public void setChildGroups(ims.core.vo.beans.DrawingGroupVoBean[] value)
	{
		this.childgroups = value;
	}

	private Integer id;
	private int version;
	private Integer groupid;
	private String groupname;
	private ims.core.vo.beans.DrawingAreaVoBean[] areacollection;
	private ims.core.vo.beans.DrawingGroupVoBean[] childgroups;
}
