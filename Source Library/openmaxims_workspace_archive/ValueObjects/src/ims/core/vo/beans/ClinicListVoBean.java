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

package ims.core.vo.beans;

public class ClinicListVoBean extends ims.vo.ValueObjectBean
{
	public ClinicListVoBean()
	{
	}
	public ClinicListVoBean(ims.core.vo.ClinicListVo vo)
	{
		this.compositeid = vo.getCompositeID();
		this.name = vo.getName();
		this.boolvalue = vo.getBoolValue();
		this.singleid = vo.getSingleID();
		this.description = vo.getDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClinicListVo vo)
	{
		this.compositeid = vo.getCompositeID();
		this.name = vo.getName();
		this.boolvalue = vo.getBoolValue();
		this.singleid = vo.getSingleID();
		this.description = vo.getDescription();
	}

	public ims.core.vo.ClinicListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClinicListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClinicListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClinicListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClinicListVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getCompositeID()
	{
		return this.compositeid;
	}
	public void setCompositeID(Integer value)
	{
		this.compositeid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Boolean getBoolValue()
	{
		return this.boolvalue;
	}
	public void setBoolValue(Boolean value)
	{
		this.boolvalue = value;
	}
	public Integer getSingleID()
	{
		return this.singleid;
	}
	public void setSingleID(Integer value)
	{
		this.singleid = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}

	private Integer compositeid;
	private String name;
	private Boolean boolvalue;
	private Integer singleid;
	private String description;
}
