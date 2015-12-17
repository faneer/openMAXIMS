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

package ims.admin.vo.beans;

public class DateExpressionVoBean extends ims.vo.ValueObjectBean
{
	public DateExpressionVoBean()
	{
	}
	public DateExpressionVoBean(ims.admin.vo.DateExpressionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.numberofunits = vo.getNumberofUnits();
		this.menuid = vo.getMenuId();
		this.name = vo.getName();
		this.startexprdate = vo.getStartExprDate();
		this.addoperator = vo.getAddOperator();
		this.rangeunit = vo.getRangeUnit();
		this.forms = vo.getForms() == null ? null : vo.getForms().getBeanCollection();
		this.active = vo.getActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.DateExpressionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.numberofunits = vo.getNumberofUnits();
		this.menuid = vo.getMenuId();
		this.name = vo.getName();
		this.startexprdate = vo.getStartExprDate();
		this.addoperator = vo.getAddOperator();
		this.rangeunit = vo.getRangeUnit();
		this.forms = vo.getForms() == null ? null : vo.getForms().getBeanCollection();
		this.active = vo.getActive();
	}

	public ims.admin.vo.DateExpressionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.DateExpressionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.DateExpressionVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.DateExpressionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.DateExpressionVo();
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
	public Integer getNumberofUnits()
	{
		return this.numberofunits;
	}
	public void setNumberofUnits(Integer value)
	{
		this.numberofunits = value;
	}
	public Integer getMenuId()
	{
		return this.menuid;
	}
	public void setMenuId(Integer value)
	{
		this.menuid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Integer getStartExprDate()
	{
		return this.startexprdate;
	}
	public void setStartExprDate(Integer value)
	{
		this.startexprdate = value;
	}
	public Boolean getAddOperator()
	{
		return this.addoperator;
	}
	public void setAddOperator(Boolean value)
	{
		this.addoperator = value;
	}
	public Integer getRangeUnit()
	{
		return this.rangeunit;
	}
	public void setRangeUnit(Integer value)
	{
		this.rangeunit = value;
	}
	public ims.admin.vo.beans.DateFormVoBean[] getForms()
	{
		return this.forms;
	}
	public void setForms(ims.admin.vo.beans.DateFormVoBean[] value)
	{
		this.forms = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}

	private Integer id;
	private int version;
	private Integer numberofunits;
	private Integer menuid;
	private String name;
	private Integer startexprdate;
	private Boolean addoperator;
	private Integer rangeunit;
	private ims.admin.vo.beans.DateFormVoBean[] forms;
	private Boolean active;
}
