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

package ims.oncology.vo.beans;

public class CancerContactSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public CancerContactSearchCriteriaVoBean()
	{
	}
	public CancerContactSearchCriteriaVoBean(ims.oncology.vo.CancerContactSearchCriteriaVo vo)
	{
		this.hcplite = vo.getHcpLite() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpLite().getBean();
		this.hcpdiscipline = vo.getHCPDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getHCPDiscipline().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.carecontextref = vo.getCareContextRef() == null ? null : new ims.vo.RefVoBean(vo.getCareContextRef().getBoId(), vo.getCareContextRef().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.CancerContactSearchCriteriaVo vo)
	{
		this.hcplite = vo.getHcpLite() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpLite().getBean(map);
		this.hcpdiscipline = vo.getHCPDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getHCPDiscipline().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.carecontextref = vo.getCareContextRef() == null ? null : new ims.vo.RefVoBean(vo.getCareContextRef().getBoId(), vo.getCareContextRef().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.oncology.vo.CancerContactSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.CancerContactSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.CancerContactSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.CancerContactSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.CancerContactSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.HcpLiteVoBean getHcpLite()
	{
		return this.hcplite;
	}
	public void setHcpLite(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcplite = value;
	}
	public ims.vo.LookupInstanceBean getHCPDiscipline()
	{
		return this.hcpdiscipline;
	}
	public void setHCPDiscipline(ims.vo.LookupInstanceBean value)
	{
		this.hcpdiscipline = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}
	public ims.vo.RefVoBean getCareContextRef()
	{
		return this.carecontextref;
	}
	public void setCareContextRef(ims.vo.RefVoBean value)
	{
		this.carecontextref = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}

	private ims.core.vo.beans.HcpLiteVoBean hcplite;
	private ims.vo.LookupInstanceBean hcpdiscipline;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
	private ims.vo.RefVoBean carecontextref;
	private ims.vo.RefVoBean episodeofcare;
}
