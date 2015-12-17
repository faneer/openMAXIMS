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

public class ElectiveListConfigSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public ElectiveListConfigSearchCriteriaVoBean()
	{
	}
	public ElectiveListConfigSearchCriteriaVoBean(ims.admin.vo.ElectiveListConfigSearchCriteriaVo vo)
	{
		this.waitinglistname = vo.getWaitingListName();
		this.service = vo.getService() == null ? null : (ims.admin.vo.beans.ServiceForElectiveListConfigVoBean)vo.getService().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConsultant().getBean();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospital().getBean();
		this.active = vo.getActive();
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ElectiveListConfigSearchCriteriaVo vo)
	{
		this.waitinglistname = vo.getWaitingListName();
		this.service = vo.getService() == null ? null : (ims.admin.vo.beans.ServiceForElectiveListConfigVoBean)vo.getService().getBean(map);
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConsultant().getBean(map);
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospital().getBean(map);
		this.active = vo.getActive();
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
	}

	public ims.admin.vo.ElectiveListConfigSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ElectiveListConfigSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ElectiveListConfigSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ElectiveListConfigSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ElectiveListConfigSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getWaitingListName()
	{
		return this.waitinglistname;
	}
	public void setWaitingListName(String value)
	{
		this.waitinglistname = value;
	}
	public ims.admin.vo.beans.ServiceForElectiveListConfigVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.admin.vo.beans.ServiceForElectiveListConfigVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.core.vo.beans.LocSiteLiteVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocSiteLiteVoBean value)
	{
		this.hospital = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}

	private String waitinglistname;
	private ims.admin.vo.beans.ServiceForElectiveListConfigVoBean service;
	private ims.core.vo.beans.HcpLiteVoBean consultant;
	private ims.core.vo.beans.LocSiteLiteVoBean hospital;
	private Boolean active;
	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
}
