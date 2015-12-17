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

package ims.core.vo.beans;

public class PatientManuallyAssembledVoBean extends ims.vo.ValueObjectBean
{
	public PatientManuallyAssembledVoBean()
	{
	}
	public PatientManuallyAssembledVoBean(ims.core.vo.PatientManuallyAssembledVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.sex = vo.getSex();
		this.displayid = vo.getDisplayID();
		this.hascommunicationchannel = vo.getHasCommunicationChannel();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientManuallyAssembledVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.sex = vo.getSex();
		this.displayid = vo.getDisplayID();
		this.hascommunicationchannel = vo.getHasCommunicationChannel();
	}

	public ims.core.vo.PatientManuallyAssembledVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientManuallyAssembledVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientManuallyAssembledVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientManuallyAssembledVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientManuallyAssembledVo();
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
	public ims.framework.utils.beans.PartialDateBean getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String value)
	{
		this.surname = value;
	}
	public String getForename()
	{
		return this.forename;
	}
	public void setForename(String value)
	{
		this.forename = value;
	}
	public String getSex()
	{
		return this.sex;
	}
	public void setSex(String value)
	{
		this.sex = value;
	}
	public String getDisplayID()
	{
		return this.displayid;
	}
	public void setDisplayID(String value)
	{
		this.displayid = value;
	}
	public Boolean getHasCommunicationChannel()
	{
		return this.hascommunicationchannel;
	}
	public void setHasCommunicationChannel(Boolean value)
	{
		this.hascommunicationchannel = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.PartialDateBean dob;
	private String surname;
	private String forename;
	private String sex;
	private String displayid;
	private Boolean hascommunicationchannel;
}
