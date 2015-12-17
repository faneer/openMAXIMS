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

public class OutpatientBookingWorklistSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public OutpatientBookingWorklistSearchCriteriaVoBean()
	{
	}
	public OutpatientBookingWorklistSearchCriteriaVoBean(ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo vo)
	{
		this.requiredappointment = vo.getRequiredAppointment();
		this.service = vo.getService() == null ? null : (ims.clinical.vo.beans.ServiceShortForClinicalInternalReferralsVoBean)vo.getService().getBean();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean();
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo vo)
	{
		this.requiredappointment = vo.getRequiredAppointment();
		this.service = vo.getService() == null ? null : (ims.clinical.vo.beans.ServiceShortForClinicalInternalReferralsVoBean)vo.getService().getBean(map);
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean(map);
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.OutpatientBookingWorklistSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getRequiredAppointment()
	{
		return this.requiredappointment;
	}
	public void setRequiredAppointment(Integer value)
	{
		this.requiredappointment = value;
	}
	public ims.clinical.vo.beans.ServiceShortForClinicalInternalReferralsVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.clinical.vo.beans.ServiceShortForClinicalInternalReferralsVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
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
	public ims.vo.LookupInstanceBean getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.vo.LookupInstanceBean value)
	{
		this.referralstatus = value;
	}

	private Integer requiredappointment;
	private ims.clinical.vo.beans.ServiceShortForClinicalInternalReferralsVoBean service;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
	private ims.vo.LookupInstanceBean referralstatus;
}
