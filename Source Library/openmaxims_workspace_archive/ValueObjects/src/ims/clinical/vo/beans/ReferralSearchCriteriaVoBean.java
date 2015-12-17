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

package ims.clinical.vo.beans;

public class ReferralSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public ReferralSearchCriteriaVoBean()
	{
	}
	public ReferralSearchCriteriaVoBean(ims.clinical.vo.ReferralSearchCriteriaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referralsource = vo.getReferralSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralSource().getBean();
		this.referralhcp = vo.getReferralHCP() == null ? null : new ims.vo.RefVoBean(vo.getReferralHCP().getBoId(), vo.getReferralHCP().getBoVersion());
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
		this.referralpriority = vo.getReferralPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralPriority().getBean();
		this.specialtyfunctioncode = vo.getSpecialtyFunctionCode() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialtyFunctionCode().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.ReferralSearchCriteriaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referralsource = vo.getReferralSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralSource().getBean();
		this.referralhcp = vo.getReferralHCP() == null ? null : new ims.vo.RefVoBean(vo.getReferralHCP().getBoId(), vo.getReferralHCP().getBoVersion());
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
		this.referralpriority = vo.getReferralPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralPriority().getBean();
		this.specialtyfunctioncode = vo.getSpecialtyFunctionCode() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialtyFunctionCode().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
	}

	public ims.clinical.vo.ReferralSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.ReferralSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.ReferralSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.ReferralSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.ReferralSearchCriteriaVo();
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
	public ims.vo.LookupInstanceBean getReferralSource()
	{
		return this.referralsource;
	}
	public void setReferralSource(ims.vo.LookupInstanceBean value)
	{
		this.referralsource = value;
	}
	public ims.vo.RefVoBean getReferralHCP()
	{
		return this.referralhcp;
	}
	public void setReferralHCP(ims.vo.RefVoBean value)
	{
		this.referralhcp = value;
	}
	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.vo.LookupInstanceBean getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.vo.LookupInstanceBean value)
	{
		this.referralstatus = value;
	}
	public ims.vo.LookupInstanceBean getReferralPriority()
	{
		return this.referralpriority;
	}
	public void setReferralPriority(ims.vo.LookupInstanceBean value)
	{
		this.referralpriority = value;
	}
	public ims.vo.LookupInstanceBean getSpecialtyFunctionCode()
	{
		return this.specialtyfunctioncode;
	}
	public void setSpecialtyFunctionCode(ims.vo.LookupInstanceBean value)
	{
		this.specialtyfunctioncode = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}
	public ims.vo.LookupInstanceBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.vo.LookupInstanceBean value)
	{
		this.discipline = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean referralsource;
	private ims.vo.RefVoBean referralhcp;
	private ims.framework.utils.beans.DateBean fromdate;
	private ims.vo.LookupInstanceBean referralstatus;
	private ims.vo.LookupInstanceBean referralpriority;
	private ims.vo.LookupInstanceBean specialtyfunctioncode;
	private ims.vo.RefVoBean patient;
	private ims.framework.utils.beans.DateBean todate;
	private ims.vo.LookupInstanceBean discipline;
}
