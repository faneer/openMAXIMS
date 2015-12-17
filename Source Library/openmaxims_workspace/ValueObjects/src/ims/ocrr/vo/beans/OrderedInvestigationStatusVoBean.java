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

public class OrderedInvestigationStatusVoBean extends ims.vo.ValueObjectBean
{
	public OrderedInvestigationStatusVoBean()
	{
	}
	public OrderedInvestigationStatusVoBean(ims.ocrr.vo.OrderedInvestigationStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ordinvstatus = vo.getOrdInvStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrdInvStatus().getBean();
		this.changedatetime = vo.getChangeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getChangeDateTime().getBean();
		this.changeuser = vo.getChangeUser();
		this.statusreason = vo.getStatusReason();
		this.statuschangereason = vo.getStatusChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusChangeReason().getBean();
		this.processeddatetime = vo.getProcessedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getProcessedDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderedInvestigationStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ordinvstatus = vo.getOrdInvStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrdInvStatus().getBean();
		this.changedatetime = vo.getChangeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getChangeDateTime().getBean();
		this.changeuser = vo.getChangeUser();
		this.statusreason = vo.getStatusReason();
		this.statuschangereason = vo.getStatusChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusChangeReason().getBean();
		this.processeddatetime = vo.getProcessedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getProcessedDateTime().getBean();
	}

	public ims.ocrr.vo.OrderedInvestigationStatusVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderedInvestigationStatusVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderedInvestigationStatusVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderedInvestigationStatusVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderedInvestigationStatusVo();
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
	public ims.vo.LookupInstanceBean getOrdInvStatus()
	{
		return this.ordinvstatus;
	}
	public void setOrdInvStatus(ims.vo.LookupInstanceBean value)
	{
		this.ordinvstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getChangeDateTime()
	{
		return this.changedatetime;
	}
	public void setChangeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.changedatetime = value;
	}
	public String getChangeUser()
	{
		return this.changeuser;
	}
	public void setChangeUser(String value)
	{
		this.changeuser = value;
	}
	public String getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(String value)
	{
		this.statusreason = value;
	}
	public ims.vo.LookupInstanceBean getStatusChangeReason()
	{
		return this.statuschangereason;
	}
	public void setStatusChangeReason(ims.vo.LookupInstanceBean value)
	{
		this.statuschangereason = value;
	}
	public ims.framework.utils.beans.DateTimeBean getProcessedDateTime()
	{
		return this.processeddatetime;
	}
	public void setProcessedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.processeddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean ordinvstatus;
	private ims.framework.utils.beans.DateTimeBean changedatetime;
	private String changeuser;
	private String statusreason;
	private ims.vo.LookupInstanceBean statuschangereason;
	private ims.framework.utils.beans.DateTimeBean processeddatetime;
}
