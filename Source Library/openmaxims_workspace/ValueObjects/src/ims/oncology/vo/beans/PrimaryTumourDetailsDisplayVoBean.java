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

public class PrimaryTumourDetailsDisplayVoBean extends ims.vo.ValueObjectBean
{
	public PrimaryTumourDetailsDisplayVoBean()
	{
	}
	public PrimaryTumourDetailsDisplayVoBean(ims.oncology.vo.PrimaryTumourDetailsDisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tumourgroup = vo.getTumourGroup() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean)vo.getTumourGroup().getBean();
		this.pretreatmenttval = vo.getPreTreatmentTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentTVal().getBean();
		this.pretreatmentnval = vo.getPreTreatmentNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentNVal().getBean();
		this.pretreatmentmval = vo.getPreTreatmentMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentMVal().getBean();
		this.pretreatmentoverall = vo.getPreTreatmentOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean)vo.getPreTreatmentOverall().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.PrimaryTumourDetailsDisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tumourgroup = vo.getTumourGroup() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean)vo.getTumourGroup().getBean(map);
		this.pretreatmenttval = vo.getPreTreatmentTVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentTVal().getBean(map);
		this.pretreatmentnval = vo.getPreTreatmentNVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentNVal().getBean(map);
		this.pretreatmentmval = vo.getPreTreatmentMVal() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean)vo.getPreTreatmentMVal().getBean(map);
		this.pretreatmentoverall = vo.getPreTreatmentOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean)vo.getPreTreatmentOverall().getBean(map);
	}

	public ims.oncology.vo.PrimaryTumourDetailsDisplayVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.PrimaryTumourDetailsDisplayVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.PrimaryTumourDetailsDisplayVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.PrimaryTumourDetailsDisplayVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.PrimaryTumourDetailsDisplayVo();
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
	public ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean getTumourGroup()
	{
		return this.tumourgroup;
	}
	public void setTumourGroup(ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean value)
	{
		this.tumourgroup = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getPreTreatmentTVal()
	{
		return this.pretreatmenttval;
	}
	public void setPreTreatmentTVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.pretreatmenttval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getPreTreatmentNVal()
	{
		return this.pretreatmentnval;
	}
	public void setPreTreatmentNVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.pretreatmentnval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean getPreTreatmentMVal()
	{
		return this.pretreatmentmval;
	}
	public void setPreTreatmentMVal(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean value)
	{
		this.pretreatmentmval = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean getPreTreatmentOverall()
	{
		return this.pretreatmentoverall;
	}
	public void setPreTreatmentOverall(ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean value)
	{
		this.pretreatmentoverall = value;
	}

	private Integer id;
	private int version;
	private ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean tumourgroup;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean pretreatmenttval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean pretreatmentnval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean pretreatmentmval;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingLiteVoBean pretreatmentoverall;
}
