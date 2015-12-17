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

package ims.ccosched.vo.beans;

public class PatTrPlanGroupSiteTechVoBean extends ims.vo.ValueObjectBean
{
	public PatTrPlanGroupSiteTechVoBean()
	{
	}
	public PatTrPlanGroupSiteTechVoBean(ims.ccosched.vo.PatTrPlanGroupSiteTechVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.treatmentgroupsite = vo.getTreatmentGroupSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentGroupSite().getBean();
		this.treatmenttechnique = vo.getTreatmentTechnique() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentTechnique().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.PatTrPlanGroupSiteTechVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.treatmentgroupsite = vo.getTreatmentGroupSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentGroupSite().getBean();
		this.treatmenttechnique = vo.getTreatmentTechnique() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentTechnique().getBean();
	}

	public ims.ccosched.vo.PatTrPlanGroupSiteTechVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ccosched.vo.PatTrPlanGroupSiteTechVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.PatTrPlanGroupSiteTechVo vo = null;
		if(map != null)
			vo = (ims.ccosched.vo.PatTrPlanGroupSiteTechVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ccosched.vo.PatTrPlanGroupSiteTechVo();
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
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentGroupSite()
	{
		return this.treatmentgroupsite;
	}
	public void setTreatmentGroupSite(ims.vo.LookupInstanceBean value)
	{
		this.treatmentgroupsite = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentTechnique()
	{
		return this.treatmenttechnique;
	}
	public void setTreatmentTechnique(ims.vo.LookupInstanceBean value)
	{
		this.treatmenttechnique = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.vo.LookupInstanceBean treatmentgroupsite;
	private ims.vo.LookupInstanceBean treatmenttechnique;
}
