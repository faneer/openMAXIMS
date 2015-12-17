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

package ims.emergency.vo.beans;

public class EmergencyAttendanceForPatientMedsVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceForPatientMedsVoBean()
	{
	}
	public EmergencyAttendanceForPatientMedsVoBean(ims.emergency.vo.EmergencyAttendanceForPatientMedsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceForPatientMedsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.emergency.vo.EmergencyAttendanceForPatientMedsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceForPatientMedsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceForPatientMedsVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceForPatientMedsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceForPatientMedsVo();
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
	public ims.framework.utils.beans.DateTimeBean getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.arrivaldatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
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
	private ims.framework.utils.beans.DateTimeBean arrivaldatetime;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private ims.vo.RefVoBean carecontext;
}
