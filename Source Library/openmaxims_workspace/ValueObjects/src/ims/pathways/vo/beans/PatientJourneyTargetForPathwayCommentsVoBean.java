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

package ims.pathways.vo.beans;

public class PatientJourneyTargetForPathwayCommentsVoBean extends ims.vo.ValueObjectBean
{
	public PatientJourneyTargetForPathwayCommentsVoBean()
	{
	}
	public PatientJourneyTargetForPathwayCommentsVoBean(ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathwaytarget = vo.getPathwayTarget() == null ? null : (ims.pathways.vo.beans.PathwayTargetShortVoBean)vo.getPathwayTarget().getBean();
		this.weeknumber = vo.getWeekNumber();
		this.targetdate = vo.getTargetDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.JourneyTargetStatusVoBean)vo.getCurrentStatus().getBean();
		this.displayticked = vo.getDisplayTicked();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathwaytarget = vo.getPathwayTarget() == null ? null : (ims.pathways.vo.beans.PathwayTargetShortVoBean)vo.getPathwayTarget().getBean(map);
		this.weeknumber = vo.getWeekNumber();
		this.targetdate = vo.getTargetDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.JourneyTargetStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.displayticked = vo.getDisplayTicked();
	}

	public ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.PatientJourneyTargetForPathwayCommentsVo();
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
	public ims.pathways.vo.beans.PathwayTargetShortVoBean getPathwayTarget()
	{
		return this.pathwaytarget;
	}
	public void setPathwayTarget(ims.pathways.vo.beans.PathwayTargetShortVoBean value)
	{
		this.pathwaytarget = value;
	}
	public Integer getWeekNumber()
	{
		return this.weeknumber;
	}
	public void setWeekNumber(Integer value)
	{
		this.weeknumber = value;
	}
	public ims.framework.utils.beans.DateBean getTargetDate()
	{
		return this.targetdate;
	}
	public void setTargetDate(ims.framework.utils.beans.DateBean value)
	{
		this.targetdate = value;
	}
	public ims.pathways.vo.beans.JourneyTargetStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.pathways.vo.beans.JourneyTargetStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public Boolean getDisplayTicked()
	{
		return this.displayticked;
	}
	public void setDisplayTicked(Boolean value)
	{
		this.displayticked = value;
	}

	private Integer id;
	private int version;
	private ims.pathways.vo.beans.PathwayTargetShortVoBean pathwaytarget;
	private Integer weeknumber;
	private ims.framework.utils.beans.DateBean targetdate;
	private ims.pathways.vo.beans.JourneyTargetStatusVoBean currentstatus;
	private Boolean displayticked;
}
