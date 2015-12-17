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

package ims.clinical.vo.beans;

public class TTAMedicationVoBean extends ims.vo.ValueObjectBean
{
	public TTAMedicationVoBean()
	{
	}
	public TTAMedicationVoBean(ims.clinical.vo.TTAMedicationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medication = vo.getMedication();
		this.datedispensed = vo.getDateDispensed() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateDispensed().getBean();
		this.doseamount = vo.getDoseAmount();
		this.doseunit = vo.getDoseUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDoseUnit().getBean();
		this.dayssupply = vo.getDaysSupply();
		this.frequency = vo.getFrequency();
		this.gptocontinue = vo.getGpToContinue() == null ? null : (ims.vo.LookupInstanceBean)vo.getGpToContinue().getBean();
		this.route = vo.getRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoute().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.TTAMedicationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medication = vo.getMedication();
		this.datedispensed = vo.getDateDispensed() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateDispensed().getBean();
		this.doseamount = vo.getDoseAmount();
		this.doseunit = vo.getDoseUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDoseUnit().getBean();
		this.dayssupply = vo.getDaysSupply();
		this.frequency = vo.getFrequency();
		this.gptocontinue = vo.getGpToContinue() == null ? null : (ims.vo.LookupInstanceBean)vo.getGpToContinue().getBean();
		this.route = vo.getRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoute().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.clinical.vo.TTAMedicationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.TTAMedicationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.TTAMedicationVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.TTAMedicationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.TTAMedicationVo();
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
	public String getMedication()
	{
		return this.medication;
	}
	public void setMedication(String value)
	{
		this.medication = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateDispensed()
	{
		return this.datedispensed;
	}
	public void setDateDispensed(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datedispensed = value;
	}
	public Float getDoseAmount()
	{
		return this.doseamount;
	}
	public void setDoseAmount(Float value)
	{
		this.doseamount = value;
	}
	public ims.vo.LookupInstanceBean getDoseUnit()
	{
		return this.doseunit;
	}
	public void setDoseUnit(ims.vo.LookupInstanceBean value)
	{
		this.doseunit = value;
	}
	public Integer getDaysSupply()
	{
		return this.dayssupply;
	}
	public void setDaysSupply(Integer value)
	{
		this.dayssupply = value;
	}
	public String getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(String value)
	{
		this.frequency = value;
	}
	public ims.vo.LookupInstanceBean getGpToContinue()
	{
		return this.gptocontinue;
	}
	public void setGpToContinue(ims.vo.LookupInstanceBean value)
	{
		this.gptocontinue = value;
	}
	public ims.vo.LookupInstanceBean getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.vo.LookupInstanceBean value)
	{
		this.route = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private String medication;
	private ims.framework.utils.beans.DateTimeBean datedispensed;
	private Float doseamount;
	private ims.vo.LookupInstanceBean doseunit;
	private Integer dayssupply;
	private String frequency;
	private ims.vo.LookupInstanceBean gptocontinue;
	private ims.vo.LookupInstanceBean route;
	private ims.vo.SysInfoBean sysinfo;
}
