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

public class EDAttendanceformsConfigVoBean extends ims.vo.ValueObjectBean
{
	public EDAttendanceformsConfigVoBean()
	{
	}
	public EDAttendanceformsConfigVoBean(ims.core.vo.EDAttendanceformsConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.chartrequestedtabvisible = vo.getChartRequestedTabVisible();
		this.invoicesbillingtabvisible = vo.getInvoicesBillingTabVisible();
		this.controlsconfigitems = vo.getControlsConfigItems() == null ? null : vo.getControlsConfigItems().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.EDAttendanceformsConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.chartrequestedtabvisible = vo.getChartRequestedTabVisible();
		this.invoicesbillingtabvisible = vo.getInvoicesBillingTabVisible();
		this.controlsconfigitems = vo.getControlsConfigItems() == null ? null : vo.getControlsConfigItems().getBeanCollection();
	}

	public ims.core.vo.EDAttendanceformsConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.EDAttendanceformsConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.EDAttendanceformsConfigVo vo = null;
		if(map != null)
			vo = (ims.core.vo.EDAttendanceformsConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.EDAttendanceformsConfigVo();
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
	public Boolean getChartRequestedTabVisible()
	{
		return this.chartrequestedtabvisible;
	}
	public void setChartRequestedTabVisible(Boolean value)
	{
		this.chartrequestedtabvisible = value;
	}
	public Boolean getInvoicesBillingTabVisible()
	{
		return this.invoicesbillingtabvisible;
	}
	public void setInvoicesBillingTabVisible(Boolean value)
	{
		this.invoicesbillingtabvisible = value;
	}
	public ims.admin.vo.beans.EDAttendanceControlsConfigVoBean[] getControlsConfigItems()
	{
		return this.controlsconfigitems;
	}
	public void setControlsConfigItems(ims.admin.vo.beans.EDAttendanceControlsConfigVoBean[] value)
	{
		this.controlsconfigitems = value;
	}

	private Integer id;
	private int version;
	private Boolean chartrequestedtabvisible;
	private Boolean invoicesbillingtabvisible;
	private ims.admin.vo.beans.EDAttendanceControlsConfigVoBean[] controlsconfigitems;
}
