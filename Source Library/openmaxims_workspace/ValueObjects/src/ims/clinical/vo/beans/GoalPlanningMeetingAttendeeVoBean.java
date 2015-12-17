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

package ims.clinical.vo.beans;

public class GoalPlanningMeetingAttendeeVoBean extends ims.vo.ValueObjectBean
{
	public GoalPlanningMeetingAttendeeVoBean()
	{
	}
	public GoalPlanningMeetingAttendeeVoBean(ims.clinical.vo.GoalPlanningMeetingAttendeeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcp().getBean();
		this.familymember = vo.getFamilyMember();
		this.note = vo.getNote();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.GoalPlanningMeetingAttendeeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcp = vo.getHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcp().getBean(map);
		this.familymember = vo.getFamilyMember();
		this.note = vo.getNote();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public ims.clinical.vo.GoalPlanningMeetingAttendeeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.GoalPlanningMeetingAttendeeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.GoalPlanningMeetingAttendeeVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.GoalPlanningMeetingAttendeeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.GoalPlanningMeetingAttendeeVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
	}
	public String getFamilyMember()
	{
		return this.familymember;
	}
	public void setFamilyMember(String value)
	{
		this.familymember = value;
	}
	public String getNote()
	{
		return this.note;
	}
	public void setNote(String value)
	{
		this.note = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
	private String familymember;
	private String note;
	private ims.vo.LookupInstanceBean status;
}
