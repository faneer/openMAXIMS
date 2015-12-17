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

package ims.core.vo.beans;

public class ClinicalNoteStatusVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalNoteStatusVoBean()
	{
	}
	public ClinicalNoteStatusVoBean(ims.core.vo.ClinicalNoteStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.mos = vo.getMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMOS().getBean();
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.clinicalnote = vo.getClinicalNote();
		this.correctionreason = vo.getCorrectionReason();
		this.correctionconfirmed = vo.getCorrectionConfirmed();
		this.correctedby = vo.getCorrectedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCorrectedBy().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClinicalNoteStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.mos = vo.getMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMOS().getBean(map);
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.clinicalnote = vo.getClinicalNote();
		this.correctionreason = vo.getCorrectionReason();
		this.correctionconfirmed = vo.getCorrectionConfirmed();
		this.correctedby = vo.getCorrectedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCorrectedBy().getBean(map);
	}

	public ims.core.vo.ClinicalNoteStatusVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClinicalNoteStatusVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClinicalNoteStatusVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClinicalNoteStatusVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClinicalNoteStatusVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getMOS()
	{
		return this.mos;
	}
	public void setMOS(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.mos = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetime = value;
	}
	public String getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(String value)
	{
		this.clinicalnote = value;
	}
	public String getCorrectionReason()
	{
		return this.correctionreason;
	}
	public void setCorrectionReason(String value)
	{
		this.correctionreason = value;
	}
	public Boolean getCorrectionConfirmed()
	{
		return this.correctionconfirmed;
	}
	public void setCorrectionConfirmed(Boolean value)
	{
		this.correctionconfirmed = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getCorrectedBy()
	{
		return this.correctedby;
	}
	public void setCorrectedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.correctedby = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean mos;
	private ims.framework.utils.beans.DateTimeBean datetime;
	private String clinicalnote;
	private String correctionreason;
	private Boolean correctionconfirmed;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean correctedby;
}
