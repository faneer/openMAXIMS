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

public class OrderResultHistoryVoBean extends ims.vo.ValueObjectBean
{
	public OrderResultHistoryVoBean()
	{
	}
	public OrderResultHistoryVoBean(ims.ocrr.vo.OrderResultHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.ordinvstatus = vo.getOrdInvStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrdInvStatus().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.historydatetime = vo.getHistoryDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getHistoryDateTime().getBean();
		this.investigationname = vo.getInvestigationName();
		this.orderability = vo.getOrderAbility() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderAbility().getBean();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRequestedLocation().getBean();
		this.confidentialtest = vo.getConfidentialTest();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.specimentype = vo.getSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenType().getBean();
		this.resultdetail = vo.getResultDetail() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForOrderResultHistoryVoBean)vo.getResultDetail().getBean();
		this.invtype = vo.getInvType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvType().getBean();
		this.inveventtype = vo.getInvEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvEventType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderResultHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.ordinvstatus = vo.getOrdInvStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrdInvStatus().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.historydatetime = vo.getHistoryDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getHistoryDateTime().getBean();
		this.investigationname = vo.getInvestigationName();
		this.orderability = vo.getOrderAbility() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderAbility().getBean();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRequestedLocation().getBean(map);
		this.confidentialtest = vo.getConfidentialTest();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.specimentype = vo.getSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenType().getBean();
		this.resultdetail = vo.getResultDetail() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForOrderResultHistoryVoBean)vo.getResultDetail().getBean(map);
		this.invtype = vo.getInvType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvType().getBean();
		this.inveventtype = vo.getInvEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvEventType().getBean();
	}

	public ims.ocrr.vo.OrderResultHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderResultHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderResultHistoryVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderResultHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderResultHistoryVo();
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
	public ims.framework.utils.beans.DateTimeBean getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.repdatetime = value;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.reptimesupplied = value;
	}
	public ims.vo.LookupInstanceBean getOrdInvStatus()
	{
		return this.ordinvstatus;
	}
	public void setOrdInvStatus(ims.vo.LookupInstanceBean value)
	{
		this.ordinvstatus = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getHistoryDateTime()
	{
		return this.historydatetime;
	}
	public void setHistoryDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.historydatetime = value;
	}
	public String getInvestigationName()
	{
		return this.investigationname;
	}
	public void setInvestigationName(String value)
	{
		this.investigationname = value;
	}
	public ims.vo.LookupInstanceBean getOrderAbility()
	{
		return this.orderability;
	}
	public void setOrderAbility(ims.vo.LookupInstanceBean value)
	{
		this.orderability = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getRequestedLocation()
	{
		return this.requestedlocation;
	}
	public void setRequestedLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.requestedlocation = value;
	}
	public Boolean getConfidentialTest()
	{
		return this.confidentialtest;
	}
	public void setConfidentialTest(Boolean value)
	{
		this.confidentialtest = value;
	}
	public ims.ocrr.vo.beans.SpecimenNameVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.beans.SpecimenNameVoBean[] value)
	{
		this.specimen = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenType()
	{
		return this.specimentype;
	}
	public void setSpecimenType(ims.vo.LookupInstanceBean value)
	{
		this.specimentype = value;
	}
	public ims.ocrr.vo.beans.ResultDetailsForOrderResultHistoryVoBean getResultDetail()
	{
		return this.resultdetail;
	}
	public void setResultDetail(ims.ocrr.vo.beans.ResultDetailsForOrderResultHistoryVoBean value)
	{
		this.resultdetail = value;
	}
	public ims.vo.LookupInstanceBean getInvType()
	{
		return this.invtype;
	}
	public void setInvType(ims.vo.LookupInstanceBean value)
	{
		this.invtype = value;
	}
	public ims.vo.LookupInstanceBean getInvEventType()
	{
		return this.inveventtype;
	}
	public void setInvEventType(ims.vo.LookupInstanceBean value)
	{
		this.inveventtype = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean repdatetime;
	private Boolean reptimesupplied;
	private ims.vo.LookupInstanceBean ordinvstatus;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.framework.utils.beans.DateTimeBean historydatetime;
	private String investigationname;
	private ims.vo.LookupInstanceBean orderability;
	private ims.core.vo.beans.LocationLiteVoBean requestedlocation;
	private Boolean confidentialtest;
	private ims.ocrr.vo.beans.SpecimenNameVoBean[] specimen;
	private ims.vo.LookupInstanceBean specimentype;
	private ims.ocrr.vo.beans.ResultDetailsForOrderResultHistoryVoBean resultdetail;
	private ims.vo.LookupInstanceBean invtype;
	private ims.vo.LookupInstanceBean inveventtype;
}
