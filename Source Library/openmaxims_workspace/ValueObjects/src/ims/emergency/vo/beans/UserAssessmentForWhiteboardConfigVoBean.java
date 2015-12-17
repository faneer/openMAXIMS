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

package ims.emergency.vo.beans;

public class UserAssessmentForWhiteboardConfigVoBean extends ims.vo.ValueObjectBean
{
	public UserAssessmentForWhiteboardConfigVoBean()
	{
	}
	public UserAssessmentForWhiteboardConfigVoBean(ims.emergency.vo.UserAssessmentForWhiteboardConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		if(vo.getTaxonomyMap() != null)
		{
			this.taxonomymap = new ims.vo.RefVoBean[vo.getTaxonomyMap().size()];
			for(int taxonomymap_i = 0; taxonomymap_i < vo.getTaxonomyMap().size(); taxonomymap_i++)
			{
				this.taxonomymap[taxonomymap_i] = new ims.vo.RefVoBean(vo.getTaxonomyMap().get(taxonomymap_i).getBoId(),vo.getTaxonomyMap().get(taxonomymap_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.UserAssessmentForWhiteboardConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		if(vo.getTaxonomyMap() != null)
		{
			this.taxonomymap = new ims.vo.RefVoBean[vo.getTaxonomyMap().size()];
			for(int taxonomymap_i = 0; taxonomymap_i < vo.getTaxonomyMap().size(); taxonomymap_i++)
			{
				this.taxonomymap[taxonomymap_i] = new ims.vo.RefVoBean(vo.getTaxonomyMap().get(taxonomymap_i).getBoId(),vo.getTaxonomyMap().get(taxonomymap_i).getBoVersion());
			}
		}
	}

	public ims.emergency.vo.UserAssessmentForWhiteboardConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.UserAssessmentForWhiteboardConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.UserAssessmentForWhiteboardConfigVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.UserAssessmentForWhiteboardConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.UserAssessmentForWhiteboardConfigVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.vo.LookupInstanceBean getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.vo.LookupInstanceBean value)
	{
		this.assessmenttype = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.vo.RefVoBean[] getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.vo.RefVoBean[] value)
	{
		this.taxonomymap = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private ims.vo.LookupInstanceBean assessmenttype;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.vo.RefVoBean[] taxonomymap;
}
