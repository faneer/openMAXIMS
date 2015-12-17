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

package ims.assessment.vo.beans;

public class UserAssessmentFavouritesShortVoBean extends ims.vo.ValueObjectBean
{
	public UserAssessmentFavouritesShortVoBean()
	{
	}
	public UserAssessmentFavouritesShortVoBean(ims.assessment.vo.UserAssessmentFavouritesShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringHCP().getBoId(), vo.getAuthoringHCP().getBoVersion());
		this.assessmentfolder = vo.getAssessmentFolder() == null ? null : vo.getAssessmentFolder().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.UserAssessmentFavouritesShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringHCP().getBoId(), vo.getAuthoringHCP().getBoVersion());
		this.assessmentfolder = vo.getAssessmentFolder() == null ? null : vo.getAssessmentFolder().getBeanCollection();
	}

	public ims.assessment.vo.UserAssessmentFavouritesShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.UserAssessmentFavouritesShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.UserAssessmentFavouritesShortVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.UserAssessmentFavouritesShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.UserAssessmentFavouritesShortVo();
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
	public ims.vo.RefVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.vo.RefVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.core.vo.beans.AssessmentFolderShortVoBean[] getAssessmentFolder()
	{
		return this.assessmentfolder;
	}
	public void setAssessmentFolder(ims.core.vo.beans.AssessmentFolderShortVoBean[] value)
	{
		this.assessmentfolder = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean authoringhcp;
	private ims.core.vo.beans.AssessmentFolderShortVoBean[] assessmentfolder;
}
