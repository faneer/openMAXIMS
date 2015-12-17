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

package ims.ocrr.vo.beans;

public class ReOrderPeriodMessageVoBean extends ims.vo.ValueObjectBean
{
	public ReOrderPeriodMessageVoBean()
	{
	}
	public ReOrderPeriodMessageVoBean(ims.ocrr.vo.ReOrderPeriodMessageVo vo)
	{
		this.itemname = vo.getItemName();
		this.amount = vo.getAmount();
		this.unit = vo.getUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnit().getBean();
		this.ordereddatetime = vo.getOrderedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getOrderedDateTime().getBean();
		this.investigationid = vo.getInvestigationId();
		this.parentid = vo.getParentId();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.ReOrderPeriodMessageVo vo)
	{
		this.itemname = vo.getItemName();
		this.amount = vo.getAmount();
		this.unit = vo.getUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnit().getBean();
		this.ordereddatetime = vo.getOrderedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getOrderedDateTime().getBean();
		this.investigationid = vo.getInvestigationId();
		this.parentid = vo.getParentId();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
	}

	public ims.ocrr.vo.ReOrderPeriodMessageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.ReOrderPeriodMessageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.ReOrderPeriodMessageVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.ReOrderPeriodMessageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.ReOrderPeriodMessageVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getItemName()
	{
		return this.itemname;
	}
	public void setItemName(String value)
	{
		this.itemname = value;
	}
	public Integer getAmount()
	{
		return this.amount;
	}
	public void setAmount(Integer value)
	{
		this.amount = value;
	}
	public ims.vo.LookupInstanceBean getUnit()
	{
		return this.unit;
	}
	public void setUnit(ims.vo.LookupInstanceBean value)
	{
		this.unit = value;
	}
	public ims.framework.utils.beans.DateTimeBean getOrderedDateTime()
	{
		return this.ordereddatetime;
	}
	public void setOrderedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.ordereddatetime = value;
	}
	public Integer getInvestigationId()
	{
		return this.investigationid;
	}
	public void setInvestigationId(Integer value)
	{
		this.investigationid = value;
	}
	public Integer getParentId()
	{
		return this.parentid;
	}
	public void setParentId(Integer value)
	{
		this.parentid = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRequiredByDate()
	{
		return this.requiredbydate;
	}
	public void setRequiredByDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requiredbydate = value;
	}

	private String itemname;
	private Integer amount;
	private ims.vo.LookupInstanceBean unit;
	private ims.framework.utils.beans.DateTimeBean ordereddatetime;
	private Integer investigationid;
	private Integer parentid;
	private ims.framework.utils.beans.DateTimeBean requiredbydate;
}
