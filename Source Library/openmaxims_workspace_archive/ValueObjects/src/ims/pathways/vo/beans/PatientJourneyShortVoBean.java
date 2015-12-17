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

package ims.pathways.vo.beans;

public class PatientJourneyShortVoBean extends ims.vo.ValueObjectBean
{
	public PatientJourneyShortVoBean()
	{
	}
	public PatientJourneyShortVoBean(ims.pathways.vo.PatientJourneyShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathway = vo.getPathway() == null ? null : (ims.pathways.vo.beans.PathwayLiteVoBean)vo.getPathway().getBean();
		this.pathwayhistory = vo.getPathwayHistory() == null ? null : vo.getPathwayHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.PatientJourneyShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathway = vo.getPathway() == null ? null : (ims.pathways.vo.beans.PathwayLiteVoBean)vo.getPathway().getBean(map);
		this.pathwayhistory = vo.getPathwayHistory() == null ? null : vo.getPathwayHistory().getBeanCollection();
	}

	public ims.pathways.vo.PatientJourneyShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.PatientJourneyShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.PatientJourneyShortVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.PatientJourneyShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.PatientJourneyShortVo();
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
	public ims.pathways.vo.beans.PathwayLiteVoBean getPathway()
	{
		return this.pathway;
	}
	public void setPathway(ims.pathways.vo.beans.PathwayLiteVoBean value)
	{
		this.pathway = value;
	}
	public ims.pathways.vo.beans.PathwayHistoryVoBean[] getPathwayHistory()
	{
		return this.pathwayhistory;
	}
	public void setPathwayHistory(ims.pathways.vo.beans.PathwayHistoryVoBean[] value)
	{
		this.pathwayhistory = value;
	}

	private Integer id;
	private int version;
	private ims.pathways.vo.beans.PathwayLiteVoBean pathway;
	private ims.pathways.vo.beans.PathwayHistoryVoBean[] pathwayhistory;
}
