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

package ims.RefMan.vo.beans;

public class ReferralDetailsForPatientJouneyVoBean extends ims.vo.ValueObjectBean
{
	public ReferralDetailsForPatientJouneyVoBean()
	{
	}
	public ReferralDetailsForPatientJouneyVoBean(ims.RefMan.vo.ReferralDetailsForPatientJouneyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceNameForReferralDetailsVoBean)vo.getService().getBean();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferringConsultant().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralDetailsForPatientJouneyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceNameForReferralDetailsVoBean)vo.getService().getBean(map);
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferringConsultant().getBean(map);
	}

	public ims.RefMan.vo.ReferralDetailsForPatientJouneyVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralDetailsForPatientJouneyVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralDetailsForPatientJouneyVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralDetailsForPatientJouneyVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralDetailsForPatientJouneyVo();
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
	public ims.core.vo.beans.ServiceNameForReferralDetailsVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceNameForReferralDetailsVoBean value)
	{
		this.service = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.dateofreferral = value;
	}
	public ims.framework.utils.beans.DateBean getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.beans.DateBean value)
	{
		this.end18ww = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.referringconsultant = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceNameForReferralDetailsVoBean service;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private ims.framework.utils.beans.DateBean end18ww;
	private ims.core.vo.beans.HcpLiteVoBean referringconsultant;
}
