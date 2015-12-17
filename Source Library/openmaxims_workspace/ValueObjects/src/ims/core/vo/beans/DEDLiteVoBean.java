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

public class DEDLiteVoBean extends ims.vo.ValueObjectBean
{
	public DEDLiteVoBean()
	{
	}
	public DEDLiteVoBean(ims.core.vo.DEDLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.isactive = vo.getIsActive();
		this.uppername = vo.getUpperName();
		this.county = vo.getCounty() == null ? null : (ims.vo.LookupInstanceBean)vo.getCounty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DEDLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.isactive = vo.getIsActive();
		this.uppername = vo.getUpperName();
		this.county = vo.getCounty() == null ? null : (ims.vo.LookupInstanceBean)vo.getCounty().getBean();
	}

	public ims.core.vo.DEDLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DEDLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DEDLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DEDLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DEDLiteVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public String getUpperName()
	{
		return this.uppername;
	}
	public void setUpperName(String value)
	{
		this.uppername = value;
	}
	public ims.vo.LookupInstanceBean getCounty()
	{
		return this.county;
	}
	public void setCounty(ims.vo.LookupInstanceBean value)
	{
		this.county = value;
	}

	private Integer id;
	private int version;
	private String name;
	private Boolean isactive;
	private String uppername;
	private ims.vo.LookupInstanceBean county;
}
