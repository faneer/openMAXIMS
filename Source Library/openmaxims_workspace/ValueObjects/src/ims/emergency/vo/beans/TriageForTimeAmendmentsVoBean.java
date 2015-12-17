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

package ims.emergency.vo.beans;

public class TriageForTimeAmendmentsVoBean extends ims.vo.ValueObjectBean
{
	public TriageForTimeAmendmentsVoBean()
	{
	}
	public TriageForTimeAmendmentsVoBean(ims.emergency.vo.TriageForTimeAmendmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagestartdatetime = vo.getTriageStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageStartDateTime().getBean();
		this.currenttriagepriority = vo.getCurrentTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentTriagePriority().getBean();
		this.triagecompletiontime = vo.getTriageCompletionTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageCompletionTime().getBean();
		this.medicinterventionstartdatetime = vo.getMedicInterventionStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMedicInterventionStartDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TriageForTimeAmendmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagestartdatetime = vo.getTriageStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageStartDateTime().getBean();
		this.currenttriagepriority = vo.getCurrentTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentTriagePriority().getBean();
		this.triagecompletiontime = vo.getTriageCompletionTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageCompletionTime().getBean();
		this.medicinterventionstartdatetime = vo.getMedicInterventionStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMedicInterventionStartDateTime().getBean();
	}

	public ims.emergency.vo.TriageForTimeAmendmentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TriageForTimeAmendmentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TriageForTimeAmendmentsVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TriageForTimeAmendmentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TriageForTimeAmendmentsVo();
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
	public ims.framework.utils.beans.DateTimeBean getTriageStartDateTime()
	{
		return this.triagestartdatetime;
	}
	public void setTriageStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.triagestartdatetime = value;
	}
	public ims.vo.LookupInstanceBean getCurrentTriagePriority()
	{
		return this.currenttriagepriority;
	}
	public void setCurrentTriagePriority(ims.vo.LookupInstanceBean value)
	{
		this.currenttriagepriority = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTriageCompletionTime()
	{
		return this.triagecompletiontime;
	}
	public void setTriageCompletionTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.triagecompletiontime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMedicInterventionStartDateTime()
	{
		return this.medicinterventionstartdatetime;
	}
	public void setMedicInterventionStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.medicinterventionstartdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean triagestartdatetime;
	private ims.vo.LookupInstanceBean currenttriagepriority;
	private ims.framework.utils.beans.DateTimeBean triagecompletiontime;
	private ims.framework.utils.beans.DateTimeBean medicinterventionstartdatetime;
}
