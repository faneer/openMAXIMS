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

public class GmsPaymentsVoBean extends ims.vo.ValueObjectBean
{
	public GmsPaymentsVoBean()
	{
	}
	public GmsPaymentsVoBean(ims.pci.vo.GmsPaymentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.gpcontract = vo.getGPContract() == null ? null : new ims.vo.RefVoBean(vo.getGPContract().getBoId(), vo.getGPContract().getBoVersion());
		this.yearmonth = vo.getYearMonth();
		this.amountpaid = vo.getAmountPaid();
		this.gmspaymenttype = vo.getGMSPaymentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGMSPaymentType().getBean();
		this.importdate = vo.getImportDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getImportDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.GmsPaymentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.gpcontract = vo.getGPContract() == null ? null : new ims.vo.RefVoBean(vo.getGPContract().getBoId(), vo.getGPContract().getBoVersion());
		this.yearmonth = vo.getYearMonth();
		this.amountpaid = vo.getAmountPaid();
		this.gmspaymenttype = vo.getGMSPaymentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGMSPaymentType().getBean();
		this.importdate = vo.getImportDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getImportDate().getBean();
	}

	public ims.pci.vo.GmsPaymentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.GmsPaymentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.GmsPaymentsVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.GmsPaymentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.GmsPaymentsVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getGPContract()
	{
		return this.gpcontract;
	}
	public void setGPContract(ims.vo.RefVoBean value)
	{
		this.gpcontract = value;
	}
	public Integer getYearMonth()
	{
		return this.yearmonth;
	}
	public void setYearMonth(Integer value)
	{
		this.yearmonth = value;
	}
	public Float getAmountPaid()
	{
		return this.amountpaid;
	}
	public void setAmountPaid(Float value)
	{
		this.amountpaid = value;
	}
	public ims.vo.LookupInstanceBean getGMSPaymentType()
	{
		return this.gmspaymenttype;
	}
	public void setGMSPaymentType(ims.vo.LookupInstanceBean value)
	{
		this.gmspaymenttype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getImportDate()
	{
		return this.importdate;
	}
	public void setImportDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.importdate = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean gpcontract;
	private Integer yearmonth;
	private Float amountpaid;
	private ims.vo.LookupInstanceBean gmspaymenttype;
	private ims.framework.utils.beans.DateTimeBean importdate;
}
