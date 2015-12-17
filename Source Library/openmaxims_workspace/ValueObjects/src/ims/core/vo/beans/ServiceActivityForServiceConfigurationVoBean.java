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

public class ServiceActivityForServiceConfigurationVoBean extends ims.vo.ValueObjectBean
{
	public ServiceActivityForServiceConfigurationVoBean()
	{
	}
	public ServiceActivityForServiceConfigurationVoBean(ims.core.vo.ServiceActivityForServiceConfigurationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
		this.isactive = vo.getIsActive();
		this.isflexible = vo.getIsFlexible();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ServiceActivityForServiceConfigurationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
		this.isactive = vo.getIsActive();
		this.isflexible = vo.getIsFlexible();
	}

	public ims.core.vo.ServiceActivityForServiceConfigurationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ServiceActivityForServiceConfigurationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ServiceActivityForServiceConfigurationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ServiceActivityForServiceConfigurationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ServiceActivityForServiceConfigurationVo();
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
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.taxonomymap = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public Boolean getIsFlexible()
	{
		return this.isflexible;
	}
	public void setIsFlexible(Boolean value)
	{
		this.isflexible = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean service;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private ims.core.vo.beans.TaxonomyMapBean[] taxonomymap;
	private Boolean isactive;
	private Boolean isflexible;
}
