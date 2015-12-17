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

package ims.nursing.vo.beans;

public class ValuableVoBean extends ims.vo.ValueObjectBean
{
	public ValuableVoBean()
	{
	}
	public ValuableVoBean(ims.nursing.vo.ValuableVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.valuable = vo.getValuable() == null ? null : (ims.vo.LookupInstanceBean)vo.getValuable().getBean();
		this.hasvaluable = vo.getHasValuable() == null ? null : (ims.vo.LookupInstanceBean)vo.getHasValuable().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.ValuableVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.valuable = vo.getValuable() == null ? null : (ims.vo.LookupInstanceBean)vo.getValuable().getBean();
		this.hasvaluable = vo.getHasValuable() == null ? null : (ims.vo.LookupInstanceBean)vo.getHasValuable().getBean();
	}

	public ims.nursing.vo.ValuableVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.ValuableVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.ValuableVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.ValuableVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.ValuableVo();
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
	public ims.vo.LookupInstanceBean getValuable()
	{
		return this.valuable;
	}
	public void setValuable(ims.vo.LookupInstanceBean value)
	{
		this.valuable = value;
	}
	public ims.vo.LookupInstanceBean getHasValuable()
	{
		return this.hasvaluable;
	}
	public void setHasValuable(ims.vo.LookupInstanceBean value)
	{
		this.hasvaluable = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean valuable;
	private ims.vo.LookupInstanceBean hasvaluable;
}
