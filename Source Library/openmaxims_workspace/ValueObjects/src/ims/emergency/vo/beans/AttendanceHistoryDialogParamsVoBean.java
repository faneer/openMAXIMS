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

public class AttendanceHistoryDialogParamsVoBean extends ims.vo.ValueObjectBean
{
	public AttendanceHistoryDialogParamsVoBean()
	{
	}
	public AttendanceHistoryDialogParamsVoBean(ims.emergency.vo.AttendanceHistoryDialogParamsVo vo)
	{
		this.patientrefvo = vo.getPatientRefVo() == null ? null : new ims.vo.RefVoBean(vo.getPatientRefVo().getBoId(), vo.getPatientRefVo().getBoVersion());
		this.maxrecords = vo.getMaxRecords();
		this.type = vo.getType();
		this.scheduleddate = vo.getScheduledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getScheduledDate().getBean();
		this.unscheduleddate = vo.getUnscheduledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getUnscheduledDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AttendanceHistoryDialogParamsVo vo)
	{
		this.patientrefvo = vo.getPatientRefVo() == null ? null : new ims.vo.RefVoBean(vo.getPatientRefVo().getBoId(), vo.getPatientRefVo().getBoVersion());
		this.maxrecords = vo.getMaxRecords();
		this.type = vo.getType();
		this.scheduleddate = vo.getScheduledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getScheduledDate().getBean();
		this.unscheduleddate = vo.getUnscheduledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getUnscheduledDate().getBean();
	}

	public ims.emergency.vo.AttendanceHistoryDialogParamsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AttendanceHistoryDialogParamsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AttendanceHistoryDialogParamsVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AttendanceHistoryDialogParamsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AttendanceHistoryDialogParamsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.RefVoBean getPatientRefVo()
	{
		return this.patientrefvo;
	}
	public void setPatientRefVo(ims.vo.RefVoBean value)
	{
		this.patientrefvo = value;
	}
	public Integer getMaxRecords()
	{
		return this.maxrecords;
	}
	public void setMaxRecords(Integer value)
	{
		this.maxrecords = value;
	}
	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer value)
	{
		this.type = value;
	}
	public ims.framework.utils.beans.DateTimeBean getScheduledDate()
	{
		return this.scheduleddate;
	}
	public void setScheduledDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.scheduleddate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getUnscheduledDate()
	{
		return this.unscheduleddate;
	}
	public void setUnscheduledDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.unscheduleddate = value;
	}

	private ims.vo.RefVoBean patientrefvo;
	private Integer maxrecords;
	private Integer type;
	private ims.framework.utils.beans.DateTimeBean scheduleddate;
	private ims.framework.utils.beans.DateTimeBean unscheduleddate;
}
