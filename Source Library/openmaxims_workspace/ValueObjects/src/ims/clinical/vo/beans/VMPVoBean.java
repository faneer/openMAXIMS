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

package ims.clinical.vo.beans;

public class VMPVoBean extends ims.vo.ValueObjectBean
{
	public VMPVoBean()
	{
	}
	public VMPVoBean(ims.clinical.vo.VMPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.productidentifier = vo.getProductIdentifier();
		this.vtm = vo.getVTM() == null ? null : new ims.vo.RefVoBean(vo.getVTM().getBoId(), vo.getVTM().getBoVersion());
		this.invalid = vo.getInvalid();
		this.name = vo.getName();
		this.abbreviatedname = vo.getAbbreviatedName();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.VMPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.productidentifier = vo.getProductIdentifier();
		this.vtm = vo.getVTM() == null ? null : new ims.vo.RefVoBean(vo.getVTM().getBoId(), vo.getVTM().getBoVersion());
		this.invalid = vo.getInvalid();
		this.name = vo.getName();
		this.abbreviatedname = vo.getAbbreviatedName();
	}

	public ims.clinical.vo.VMPVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.VMPVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.VMPVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.VMPVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.VMPVo();
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
	public String getProductIdentifier()
	{
		return this.productidentifier;
	}
	public void setProductIdentifier(String value)
	{
		this.productidentifier = value;
	}
	public ims.vo.RefVoBean getVTM()
	{
		return this.vtm;
	}
	public void setVTM(ims.vo.RefVoBean value)
	{
		this.vtm = value;
	}
	public Boolean getInvalid()
	{
		return this.invalid;
	}
	public void setInvalid(Boolean value)
	{
		this.invalid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getAbbreviatedName()
	{
		return this.abbreviatedname;
	}
	public void setAbbreviatedName(String value)
	{
		this.abbreviatedname = value;
	}

	private Integer id;
	private int version;
	private String productidentifier;
	private ims.vo.RefVoBean vtm;
	private Boolean invalid;
	private String name;
	private String abbreviatedname;
}
