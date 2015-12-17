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

public class OrderInvestigationForAttendenceNotesCcVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationForAttendenceNotesCcVoBean()
	{
	}
	public OrderInvestigationForAttendenceNotesCcVoBean(ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.emergency.vo.beans.InvestigationForAttendenceNotesCcVoBean)vo.getInvestigation().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.emergency.vo.beans.OrderedInvestigationStatusForAttendanceVoBean)vo.getOrdInvCurrentStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.emergency.vo.beans.InvestigationForAttendenceNotesCcVoBean)vo.getInvestigation().getBean(map);
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.emergency.vo.beans.OrderedInvestigationStatusForAttendanceVoBean)vo.getOrdInvCurrentStatus().getBean(map);
	}

	public ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVo();
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
	public ims.emergency.vo.beans.InvestigationForAttendenceNotesCcVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.emergency.vo.beans.InvestigationForAttendenceNotesCcVoBean value)
	{
		this.investigation = value;
	}
	public ims.emergency.vo.beans.OrderedInvestigationStatusForAttendanceVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.emergency.vo.beans.OrderedInvestigationStatusForAttendanceVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.InvestigationForAttendenceNotesCcVoBean investigation;
	private ims.emergency.vo.beans.OrderedInvestigationStatusForAttendanceVoBean ordinvcurrentstatus;
}
