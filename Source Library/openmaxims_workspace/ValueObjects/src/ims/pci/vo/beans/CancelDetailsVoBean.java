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

package ims.pci.vo.beans;

public class CancelDetailsVoBean extends ims.vo.ValueObjectBean
{
	public CancelDetailsVoBean()
	{
	}
	public CancelDetailsVoBean(ims.pci.vo.CancelDetailsVo vo)
	{
		this.cancelledby = vo.getCancelledBy() == null ? null : new ims.vo.RefVoBean(vo.getCancelledBy().getBoId(), vo.getCancelledBy().getBoVersion());
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.cancellationdatetime = vo.getCancellationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCancellationDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.CancelDetailsVo vo)
	{
		this.cancelledby = vo.getCancelledBy() == null ? null : new ims.vo.RefVoBean(vo.getCancelledBy().getBoId(), vo.getCancelledBy().getBoVersion());
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.cancellationdatetime = vo.getCancellationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCancellationDateTime().getBean();
	}

	public ims.pci.vo.CancelDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.CancelDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.CancelDetailsVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.CancelDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.CancelDetailsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.RefVoBean getCancelledBy()
	{
		return this.cancelledby;
	}
	public void setCancelledBy(ims.vo.RefVoBean value)
	{
		this.cancelledby = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCancellationDateTime()
	{
		return this.cancellationdatetime;
	}
	public void setCancellationDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.cancellationdatetime = value;
	}

	private ims.vo.RefVoBean cancelledby;
	private ims.vo.LookupInstanceBean cancellationreason;
	private ims.framework.utils.beans.DateTimeBean cancellationdatetime;
}
