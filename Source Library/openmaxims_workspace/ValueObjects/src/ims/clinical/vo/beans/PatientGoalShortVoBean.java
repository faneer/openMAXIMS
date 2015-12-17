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

public class PatientGoalShortVoBean extends ims.vo.ValueObjectBean
{
	public PatientGoalShortVoBean()
	{
	}
	public PatientGoalShortVoBean(ims.clinical.vo.PatientGoalShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.goaltype = vo.getGoalType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGoalType().getBean();
		this.areaofneed = vo.getAreaOfNeed() == null ? null : (ims.vo.LookupInstanceBean)vo.getAreaOfNeed().getBean();
		this.goaltext = vo.getGoalText();
		this.createddatetime = vo.getCreatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreatedDateTime().getBean();
		this.dateachieved = vo.getDateAchieved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateAchieved().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientGoalShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.goaltype = vo.getGoalType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGoalType().getBean();
		this.areaofneed = vo.getAreaOfNeed() == null ? null : (ims.vo.LookupInstanceBean)vo.getAreaOfNeed().getBean();
		this.goaltext = vo.getGoalText();
		this.createddatetime = vo.getCreatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreatedDateTime().getBean();
		this.dateachieved = vo.getDateAchieved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateAchieved().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.PatientGoalShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientGoalShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientGoalShortVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientGoalShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientGoalShortVo();
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
	public ims.vo.LookupInstanceBean getGoalType()
	{
		return this.goaltype;
	}
	public void setGoalType(ims.vo.LookupInstanceBean value)
	{
		this.goaltype = value;
	}
	public ims.vo.LookupInstanceBean getAreaOfNeed()
	{
		return this.areaofneed;
	}
	public void setAreaOfNeed(ims.vo.LookupInstanceBean value)
	{
		this.areaofneed = value;
	}
	public String getGoalText()
	{
		return this.goaltext;
	}
	public void setGoalText(String value)
	{
		this.goaltext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCreatedDateTime()
	{
		return this.createddatetime;
	}
	public void setCreatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.createddatetime = value;
	}
	public ims.framework.utils.beans.DateBean getDateAchieved()
	{
		return this.dateachieved;
	}
	public void setDateAchieved(ims.framework.utils.beans.DateBean value)
	{
		this.dateachieved = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean goaltype;
	private ims.vo.LookupInstanceBean areaofneed;
	private String goaltext;
	private ims.framework.utils.beans.DateTimeBean createddatetime;
	private ims.framework.utils.beans.DateBean dateachieved;
	private ims.vo.RefVoBean carecontext;
}
