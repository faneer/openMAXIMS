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

package ims.core.vo.beans;

public class RecentDischargesFilterVoBean extends ims.vo.ValueObjectBean
{
	public RecentDischargesFilterVoBean()
	{
	}
	public RecentDischargesFilterVoBean(ims.core.vo.RecentDischargesFilterVo vo)
	{
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.hospnum = vo.getHospNum();
		this.ward = vo.getWard() == null ? null : new ims.vo.RefVoBean(vo.getWard().getBoId(), vo.getWard().getBoVersion());
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
		this.alert = vo.getAlert() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlert().getBean();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.dischdestination = vo.getDischDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischDestination().getBean();
		this.idtype = vo.getIDType() == null ? null : (ims.vo.LookupInstanceBean)vo.getIDType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.RecentDischargesFilterVo vo)
	{
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.hospnum = vo.getHospNum();
		this.ward = vo.getWard() == null ? null : new ims.vo.RefVoBean(vo.getWard().getBoId(), vo.getWard().getBoVersion());
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
		this.alert = vo.getAlert() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlert().getBean();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.dischdestination = vo.getDischDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischDestination().getBean();
		this.idtype = vo.getIDType() == null ? null : (ims.vo.LookupInstanceBean)vo.getIDType().getBean();
	}

	public ims.core.vo.RecentDischargesFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.RecentDischargesFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.RecentDischargesFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.RecentDischargesFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.RecentDischargesFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String value)
	{
		this.surname = value;
	}
	public String getForename()
	{
		return this.forename;
	}
	public void setForename(String value)
	{
		this.forename = value;
	}
	public String getHospNum()
	{
		return this.hospnum;
	}
	public void setHospNum(String value)
	{
		this.hospnum = value;
	}
	public ims.vo.RefVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.vo.RefVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.RefVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.vo.RefVoBean value)
	{
		this.consultant = value;
	}
	public ims.vo.LookupInstanceBean getAlert()
	{
		return this.alert;
	}
	public void setAlert(ims.vo.LookupInstanceBean value)
	{
		this.alert = value;
	}
	public ims.vo.RefVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.vo.RefVoBean value)
	{
		this.hospital = value;
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
	public ims.vo.LookupInstanceBean getDischDestination()
	{
		return this.dischdestination;
	}
	public void setDischDestination(ims.vo.LookupInstanceBean value)
	{
		this.dischdestination = value;
	}
	public ims.vo.LookupInstanceBean getIDType()
	{
		return this.idtype;
	}
	public void setIDType(ims.vo.LookupInstanceBean value)
	{
		this.idtype = value;
	}

	private String surname;
	private String forename;
	private String hospnum;
	private ims.vo.RefVoBean ward;
	private ims.vo.RefVoBean consultant;
	private ims.vo.LookupInstanceBean alert;
	private ims.vo.RefVoBean hospital;
	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
	private ims.vo.LookupInstanceBean dischdestination;
	private ims.vo.LookupInstanceBean idtype;
}
