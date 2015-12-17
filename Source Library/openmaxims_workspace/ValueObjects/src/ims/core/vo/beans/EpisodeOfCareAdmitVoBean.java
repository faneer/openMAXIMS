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

public class EpisodeOfCareAdmitVoBean extends ims.vo.ValueObjectBean
{
	public EpisodeOfCareAdmitVoBean()
	{
	}
	public EpisodeOfCareAdmitVoBean(ims.core.vo.EpisodeOfCareAdmitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.carespell = vo.getCareSpell() == null ? null : new ims.vo.RefVoBean(vo.getCareSpell().getBoId(), vo.getCareSpell().getBoVersion());
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleHCP().getBoId(), vo.getResponsibleHCP().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.carecontexts = vo.getCareContexts() == null ? null : vo.getCareContexts().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.EpisodeOfCareAdmitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.carespell = vo.getCareSpell() == null ? null : new ims.vo.RefVoBean(vo.getCareSpell().getBoId(), vo.getCareSpell().getBoVersion());
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleHCP().getBoId(), vo.getResponsibleHCP().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.carecontexts = vo.getCareContexts() == null ? null : vo.getCareContexts().getBeanCollection();
	}

	public ims.core.vo.EpisodeOfCareAdmitVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.EpisodeOfCareAdmitVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.EpisodeOfCareAdmitVo vo = null;
		if(map != null)
			vo = (ims.core.vo.EpisodeOfCareAdmitVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.EpisodeOfCareAdmitVo();
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
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public ims.vo.RefVoBean getCareSpell()
	{
		return this.carespell;
	}
	public void setCareSpell(ims.vo.RefVoBean value)
	{
		this.carespell = value;
	}
	public ims.vo.LookupInstanceBean getRelationship()
	{
		return this.relationship;
	}
	public void setRelationship(ims.vo.LookupInstanceBean value)
	{
		this.relationship = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.vo.RefVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.core.vo.beans.CareContextAdmitVoBean[] getCareContexts()
	{
		return this.carecontexts;
	}
	public void setCareContexts(ims.core.vo.beans.CareContextAdmitVoBean[] value)
	{
		this.carecontexts = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
	private ims.vo.RefVoBean carespell;
	private ims.vo.LookupInstanceBean relationship;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.RefVoBean responsiblehcp;
	private ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean currentstatus;
	private ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] statushistory;
	private ims.core.vo.beans.CareContextAdmitVoBean[] carecontexts;
}
