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

package ims.oncology.vo.beans;

public class WaitingTimeFailuresVoBean extends ims.vo.ValueObjectBean
{
	public WaitingTimeFailuresVoBean()
	{
	}
	public WaitingTimeFailuresVoBean(ims.oncology.vo.WaitingTimeFailuresVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.nhsnumber = vo.getNHSNumber();
		this.reason = vo.getReason();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.WaitingTimeFailuresVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.nhsnumber = vo.getNHSNumber();
		this.reason = vo.getReason();
	}

	public ims.oncology.vo.WaitingTimeFailuresVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.WaitingTimeFailuresVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.WaitingTimeFailuresVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.WaitingTimeFailuresVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.WaitingTimeFailuresVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public void setNHSNumber(String value)
	{
		this.nhsnumber = value;
	}
	public String getReason()
	{
		return this.reason;
	}
	public void setReason(String value)
	{
		this.reason = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean patient;
	private String nhsnumber;
	private String reason;
}
