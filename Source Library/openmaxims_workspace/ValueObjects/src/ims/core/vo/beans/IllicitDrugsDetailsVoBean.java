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

public class IllicitDrugsDetailsVoBean extends ims.vo.ValueObjectBean
{
	public IllicitDrugsDetailsVoBean()
	{
	}
	public IllicitDrugsDetailsVoBean(ims.core.vo.IllicitDrugsDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.substance = vo.getSubstance() == null ? null : (ims.vo.LookupInstanceBean)vo.getSubstance().getBean();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.lastused = vo.getLastUsed() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getLastUsed().getBean();
		this.urinetestresult = vo.getUrineTestResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrineTestResult().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.IllicitDrugsDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.substance = vo.getSubstance() == null ? null : (ims.vo.LookupInstanceBean)vo.getSubstance().getBean();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.lastused = vo.getLastUsed() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getLastUsed().getBean();
		this.urinetestresult = vo.getUrineTestResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrineTestResult().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
	}

	public ims.core.vo.IllicitDrugsDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.IllicitDrugsDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.IllicitDrugsDetailsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.IllicitDrugsDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.IllicitDrugsDetailsVo();
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
	public ims.vo.LookupInstanceBean getSubstance()
	{
		return this.substance;
	}
	public void setSubstance(ims.vo.LookupInstanceBean value)
	{
		this.substance = value;
	}
	public ims.vo.LookupInstanceBean getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.vo.LookupInstanceBean value)
	{
		this.frequency = value;
	}
	public ims.framework.utils.beans.PartialDateBean getLastUsed()
	{
		return this.lastused;
	}
	public void setLastUsed(ims.framework.utils.beans.PartialDateBean value)
	{
		this.lastused = value;
	}
	public ims.vo.LookupInstanceBean getUrineTestResult()
	{
		return this.urinetestresult;
	}
	public void setUrineTestResult(ims.vo.LookupInstanceBean value)
	{
		this.urinetestresult = value;
	}
	public ims.vo.LookupInstanceBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.vo.LookupInstanceBean value)
	{
		this.currentstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean substance;
	private ims.vo.LookupInstanceBean frequency;
	private ims.framework.utils.beans.PartialDateBean lastused;
	private ims.vo.LookupInstanceBean urinetestresult;
	private ims.vo.LookupInstanceBean currentstatus;
}
