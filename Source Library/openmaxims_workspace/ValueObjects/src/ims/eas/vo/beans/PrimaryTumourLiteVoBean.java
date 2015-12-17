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

package ims.eas.vo.beans;

public class PrimaryTumourLiteVoBean extends ims.vo.ValueObjectBean
{
	public PrimaryTumourLiteVoBean()
	{
	}
	public PrimaryTumourLiteVoBean(ims.eas.vo.PrimaryTumourLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryTumour().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.treatmentsites = vo.getTreatmentSites() == null ? null : vo.getTreatmentSites().getBeanCollection();
		this.clinicaltrials = vo.getClinicalTrials() == null ? null : vo.getClinicalTrials().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.PrimaryTumourLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryTumour().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.treatmentsites = vo.getTreatmentSites() == null ? null : vo.getTreatmentSites().getBeanCollection();
		this.clinicaltrials = vo.getClinicalTrials() == null ? null : vo.getClinicalTrials().getBeanCollection();
	}

	public ims.eas.vo.PrimaryTumourLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.PrimaryTumourLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.PrimaryTumourLiteVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.PrimaryTumourLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.PrimaryTumourLiteVo();
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
	public ims.vo.LookupInstanceBean getPrimaryTumour()
	{
		return this.primarytumour;
	}
	public void setPrimaryTumour(ims.vo.LookupInstanceBean value)
	{
		this.primarytumour = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.eas.vo.beans.TreatmentSiteNameVoBean[] getTreatmentSites()
	{
		return this.treatmentsites;
	}
	public void setTreatmentSites(ims.eas.vo.beans.TreatmentSiteNameVoBean[] value)
	{
		this.treatmentsites = value;
	}
	public ims.eas.vo.beans.ClinicalTrialLinkVoBean[] getClinicalTrials()
	{
		return this.clinicaltrials;
	}
	public void setClinicalTrials(ims.eas.vo.beans.ClinicalTrialLinkVoBean[] value)
	{
		this.clinicaltrials = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean primarytumour;
	private ims.vo.LookupInstanceBean status;
	private ims.eas.vo.beans.TreatmentSiteNameVoBean[] treatmentsites;
	private ims.eas.vo.beans.ClinicalTrialLinkVoBean[] clinicaltrials;
}
