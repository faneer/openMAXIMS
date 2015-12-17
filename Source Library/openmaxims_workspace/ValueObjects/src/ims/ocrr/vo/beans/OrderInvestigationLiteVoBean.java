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

public class OrderInvestigationLiteVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationLiteVoBean()
	{
	}
	public OrderInvestigationLiteVoBean(ims.ocrr.vo.OrderInvestigationLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationListVoBean)vo.getInvestigation().getBean();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderLiteVoBean)vo.getOrderDetails().getBean();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean)vo.getResultDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderInvestigationLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationListVoBean)vo.getInvestigation().getBean(map);
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderLiteVoBean)vo.getOrderDetails().getBean(map);
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean)vo.getResultDetails().getBean(map);
	}

	public ims.ocrr.vo.OrderInvestigationLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderInvestigationLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderInvestigationLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderInvestigationLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderInvestigationLiteVo();
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
	public ims.ocrr.vo.beans.InvestigationListVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationListVoBean value)
	{
		this.investigation = value;
	}
	public ims.ocrr.vo.beans.OrderSpecimenLiteVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.beans.OrderSpecimenLiteVoBean[] value)
	{
		this.specimen = value;
	}
	public ims.ocrr.vo.beans.OcsOrderLiteVoBean getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.beans.OcsOrderLiteVoBean value)
	{
		this.orderdetails = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.repdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.vo.LookupInstanceBean getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.vo.LookupInstanceBean value)
	{
		this.displayflag = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.appointmentdate = value;
	}
	public ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean value)
	{
		this.resultdetails = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationListVoBean investigation;
	private ims.ocrr.vo.beans.OrderSpecimenLiteVoBean[] specimen;
	private ims.ocrr.vo.beans.OcsOrderLiteVoBean orderdetails;
	private ims.framework.utils.beans.DateTimeBean repdatetime;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean ordinvcurrentstatus;
	private ims.vo.LookupInstanceBean displayflag;
	private ims.vo.SysInfoBean sysinfo;
	private ims.framework.utils.beans.DateTimeBean appointmentdate;
	private ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean resultdetails;
}
