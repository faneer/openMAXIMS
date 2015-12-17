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

public class RACPPlanAdviceVoBean extends ims.vo.ValueObjectBean
{
	public RACPPlanAdviceVoBean()
	{
	}
	public RACPPlanAdviceVoBean(ims.clinical.vo.RACPPlanAdviceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primaryplan = vo.getPrimaryPlan() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryPlan().getBean();
		this.overallimpression = vo.getOverallImpression() == null ? null : (ims.vo.LookupInstanceBean)vo.getOverallImpression().getBean();
		this.otherdetails = vo.getOtherDetails();
		this.secondaryplans = vo.getSecondaryPlans() == null ? null : vo.getSecondaryPlans().getBeanCollection();
		this.advicegivenpatient = vo.getAdviceGivenPatient() == null ? null : vo.getAdviceGivenPatient().getBeanCollection();
		this.advicegiventogp = vo.getAdviceGivenToGP() == null ? null : vo.getAdviceGivenToGP().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.RACPPlanAdviceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primaryplan = vo.getPrimaryPlan() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryPlan().getBean();
		this.overallimpression = vo.getOverallImpression() == null ? null : (ims.vo.LookupInstanceBean)vo.getOverallImpression().getBean();
		this.otherdetails = vo.getOtherDetails();
		this.secondaryplans = vo.getSecondaryPlans() == null ? null : vo.getSecondaryPlans().getBeanCollection();
		this.advicegivenpatient = vo.getAdviceGivenPatient() == null ? null : vo.getAdviceGivenPatient().getBeanCollection();
		this.advicegiventogp = vo.getAdviceGivenToGP() == null ? null : vo.getAdviceGivenToGP().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.RACPPlanAdviceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.RACPPlanAdviceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.RACPPlanAdviceVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.RACPPlanAdviceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.RACPPlanAdviceVo();
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
	public ims.vo.LookupInstanceBean getPrimaryPlan()
	{
		return this.primaryplan;
	}
	public void setPrimaryPlan(ims.vo.LookupInstanceBean value)
	{
		this.primaryplan = value;
	}
	public ims.vo.LookupInstanceBean getOverallImpression()
	{
		return this.overallimpression;
	}
	public void setOverallImpression(ims.vo.LookupInstanceBean value)
	{
		this.overallimpression = value;
	}
	public String getOtherDetails()
	{
		return this.otherdetails;
	}
	public void setOtherDetails(String value)
	{
		this.otherdetails = value;
	}
	public java.util.Collection getSecondaryPlans()
	{
		return this.secondaryplans;
	}
	public void setSecondaryPlans(java.util.Collection value)
	{
		this.secondaryplans = value;
	}
	public void addSecondaryPlans(java.util.Collection value)
	{
		if(this.secondaryplans == null)
			this.secondaryplans = new java.util.ArrayList();
		this.secondaryplans.add(value);
	}
	public java.util.Collection getAdviceGivenPatient()
	{
		return this.advicegivenpatient;
	}
	public void setAdviceGivenPatient(java.util.Collection value)
	{
		this.advicegivenpatient = value;
	}
	public void addAdviceGivenPatient(java.util.Collection value)
	{
		if(this.advicegivenpatient == null)
			this.advicegivenpatient = new java.util.ArrayList();
		this.advicegivenpatient.add(value);
	}
	public java.util.Collection getAdviceGivenToGP()
	{
		return this.advicegiventogp;
	}
	public void setAdviceGivenToGP(java.util.Collection value)
	{
		this.advicegiventogp = value;
	}
	public void addAdviceGivenToGP(java.util.Collection value)
	{
		if(this.advicegiventogp == null)
			this.advicegiventogp = new java.util.ArrayList();
		this.advicegiventogp.add(value);
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
	private ims.vo.LookupInstanceBean primaryplan;
	private ims.vo.LookupInstanceBean overallimpression;
	private String otherdetails;
	private java.util.Collection secondaryplans;
	private java.util.Collection advicegivenpatient;
	private java.util.Collection advicegiventogp;
	private ims.vo.RefVoBean carecontext;
}
