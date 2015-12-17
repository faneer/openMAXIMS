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

public class ClinicalContactVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalContactVoBean()
	{
	}
	public ClinicalContactVoBean(ims.core.vo.ClinicalContactVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.seenby = vo.getSeenBy() == null ? null : new ims.vo.RefVoBean(vo.getSeenBy().getBoId(), vo.getSeenBy().getBoVersion());
		this.contacttype = vo.getContactType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContactType().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.isclinicalnotecreated = vo.getIsClinicalNoteCreated();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClinicalContactVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.seenby = vo.getSeenBy() == null ? null : new ims.vo.RefVoBean(vo.getSeenBy().getBoId(), vo.getSeenBy().getBoVersion());
		this.contacttype = vo.getContactType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContactType().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.isclinicalnotecreated = vo.getIsClinicalNoteCreated();
	}

	public ims.core.vo.ClinicalContactVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClinicalContactVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClinicalContactVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClinicalContactVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClinicalContactVo();
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
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.vo.RefVoBean value)
	{
		this.seenby = value;
	}
	public ims.vo.LookupInstanceBean getContactType()
	{
		return this.contacttype;
	}
	public void setContactType(ims.vo.LookupInstanceBean value)
	{
		this.contacttype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.enddatetime = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIsClinicalNoteCreated()
	{
		return this.isclinicalnotecreated;
	}
	public void setIsClinicalNoteCreated(Boolean value)
	{
		this.isclinicalnotecreated = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.RefVoBean seenby;
	private ims.vo.LookupInstanceBean contacttype;
	private ims.framework.utils.beans.DateTimeBean startdatetime;
	private ims.framework.utils.beans.DateTimeBean enddatetime;
	private ims.vo.RefVoBean carecontext;
	private Boolean isclinicalnotecreated;
}
