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

package ims.coe.vo.beans;

public class PersonalHygieneFeetVoBean extends ims.vo.ValueObjectBean
{
	public PersonalHygieneFeetVoBean()
	{
	}
	public PersonalHygieneFeetVoBean(ims.coe.vo.PersonalHygieneFeetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.conditionoffeet = vo.getConditionOfFeet() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfFeet().getBean();
		this.patientbathefeet = vo.getPatientBatheFeet() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientBatheFeet().getBean();
		this.patientattendchiropodist = vo.getPatientAttendChiropodist() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAttendChiropodist().getBean();
		this.referraltochiropodist = vo.getReferralToChiropodist() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralToChiropodist().getBean();
		this.feetfindings = vo.getFeetFindings() == null ? null : vo.getFeetFindings().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.PersonalHygieneFeetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.conditionoffeet = vo.getConditionOfFeet() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfFeet().getBean();
		this.patientbathefeet = vo.getPatientBatheFeet() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientBatheFeet().getBean();
		this.patientattendchiropodist = vo.getPatientAttendChiropodist() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAttendChiropodist().getBean();
		this.referraltochiropodist = vo.getReferralToChiropodist() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralToChiropodist().getBean();
		this.feetfindings = vo.getFeetFindings() == null ? null : vo.getFeetFindings().getBeanCollection();
	}

	public ims.coe.vo.PersonalHygieneFeetVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.PersonalHygieneFeetVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.PersonalHygieneFeetVo vo = null;
		if(map != null)
			vo = (ims.coe.vo.PersonalHygieneFeetVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.PersonalHygieneFeetVo();
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
	public ims.vo.LookupInstanceBean getConditionOfFeet()
	{
		return this.conditionoffeet;
	}
	public void setConditionOfFeet(ims.vo.LookupInstanceBean value)
	{
		this.conditionoffeet = value;
	}
	public ims.vo.LookupInstanceBean getPatientBatheFeet()
	{
		return this.patientbathefeet;
	}
	public void setPatientBatheFeet(ims.vo.LookupInstanceBean value)
	{
		this.patientbathefeet = value;
	}
	public ims.vo.LookupInstanceBean getPatientAttendChiropodist()
	{
		return this.patientattendchiropodist;
	}
	public void setPatientAttendChiropodist(ims.vo.LookupInstanceBean value)
	{
		this.patientattendchiropodist = value;
	}
	public ims.framework.utils.beans.DateBean getReferralToChiropodist()
	{
		return this.referraltochiropodist;
	}
	public void setReferralToChiropodist(ims.framework.utils.beans.DateBean value)
	{
		this.referraltochiropodist = value;
	}
	public ims.coe.vo.beans.FeetFindingsBean[] getFeetFindings()
	{
		return this.feetfindings;
	}
	public void setFeetFindings(ims.coe.vo.beans.FeetFindingsBean[] value)
	{
		this.feetfindings = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean conditionoffeet;
	private ims.vo.LookupInstanceBean patientbathefeet;
	private ims.vo.LookupInstanceBean patientattendchiropodist;
	private ims.framework.utils.beans.DateBean referraltochiropodist;
	private ims.coe.vo.beans.FeetFindingsBean[] feetfindings;
}
