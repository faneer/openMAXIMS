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

package ims.generalmedical.vo.beans;

public class InvPlanVoBean extends ims.vo.ValueObjectBean
{
	public InvPlanVoBean()
	{
	}
	public InvPlanVoBean(ims.generalmedical.vo.InvPlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigationordered = vo.getInvestigationOrdered() == null ? null : vo.getInvestigationOrdered().getBeanCollection();
		this.medicalplan = vo.getMedicalPlan();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.InvPlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigationordered = vo.getInvestigationOrdered() == null ? null : vo.getInvestigationOrdered().getBeanCollection();
		this.medicalplan = vo.getMedicalPlan();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
	}

	public ims.generalmedical.vo.InvPlanVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.InvPlanVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.InvPlanVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.InvPlanVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.InvPlanVo();
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
	public java.util.Collection getInvestigationOrdered()
	{
		return this.investigationordered;
	}
	public void setInvestigationOrdered(java.util.Collection value)
	{
		this.investigationordered = value;
	}
	public void addInvestigationOrdered(java.util.Collection value)
	{
		if(this.investigationordered == null)
			this.investigationordered = new java.util.ArrayList();
		this.investigationordered.add(value);
	}
	public String getMedicalPlan()
	{
		return this.medicalplan;
	}
	public void setMedicalPlan(String value)
	{
		this.medicalplan = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}

	private Integer id;
	private int version;
	private java.util.Collection investigationordered;
	private String medicalplan;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
}
