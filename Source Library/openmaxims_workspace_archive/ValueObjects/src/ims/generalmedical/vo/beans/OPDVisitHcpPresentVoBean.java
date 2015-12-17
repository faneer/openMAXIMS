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

package ims.generalmedical.vo.beans;

public class OPDVisitHcpPresentVoBean extends ims.vo.ValueObjectBean
{
	public OPDVisitHcpPresentVoBean()
	{
	}
	public OPDVisitHcpPresentVoBean(ims.generalmedical.vo.OPDVisitHcpPresentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.opdvisitdetails = vo.getOPDVisitDetails() == null ? null : (ims.generalmedical.vo.beans.OPDVisitDetailsVoBean)vo.getOPDVisitDetails().getBean();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean();
		this.isactive = vo.getIsActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.OPDVisitHcpPresentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.opdvisitdetails = vo.getOPDVisitDetails() == null ? null : (ims.generalmedical.vo.beans.OPDVisitDetailsVoBean)vo.getOPDVisitDetails().getBean(map);
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean(map);
		this.isactive = vo.getIsActive();
	}

	public ims.generalmedical.vo.OPDVisitHcpPresentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.OPDVisitHcpPresentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.OPDVisitHcpPresentVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.OPDVisitHcpPresentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.OPDVisitHcpPresentVo();
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
	public ims.generalmedical.vo.beans.OPDVisitDetailsVoBean getOPDVisitDetails()
	{
		return this.opdvisitdetails;
	}
	public void setOPDVisitDetails(ims.generalmedical.vo.beans.OPDVisitDetailsVoBean value)
	{
		this.opdvisitdetails = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}

	private Integer id;
	private int version;
	private ims.generalmedical.vo.beans.OPDVisitDetailsVoBean opdvisitdetails;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
	private Boolean isactive;
}
