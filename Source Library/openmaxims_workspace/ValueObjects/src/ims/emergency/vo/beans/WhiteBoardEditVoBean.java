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

public class WhiteBoardEditVoBean extends ims.vo.ValueObjectBean
{
	public WhiteBoardEditVoBean()
	{
	}
	public WhiteBoardEditVoBean(ims.emergency.vo.WhiteBoardEditVo vo)
	{
		this.obsrequired = vo.getObsRequired();
		this.medsgiven = vo.getMedsGiven();
		this.ecg = vo.getECG();
		this.npo = vo.getNPO();
		this.isolation = vo.getIsolation();
		this.painassessments = vo.getPainAssessments();
		this.waterlowassessments = vo.getWaterlowAssessments();
		this.fallsassessment = vo.getFallsAssessment();
		this.isarassessments = vo.getIsarAssessments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.WhiteBoardEditVo vo)
	{
		this.obsrequired = vo.getObsRequired();
		this.medsgiven = vo.getMedsGiven();
		this.ecg = vo.getECG();
		this.npo = vo.getNPO();
		this.isolation = vo.getIsolation();
		this.painassessments = vo.getPainAssessments();
		this.waterlowassessments = vo.getWaterlowAssessments();
		this.fallsassessment = vo.getFallsAssessment();
		this.isarassessments = vo.getIsarAssessments();
	}

	public ims.emergency.vo.WhiteBoardEditVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.WhiteBoardEditVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.WhiteBoardEditVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.WhiteBoardEditVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.WhiteBoardEditVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getObsRequired()
	{
		return this.obsrequired;
	}
	public void setObsRequired(Integer value)
	{
		this.obsrequired = value;
	}
	public Integer getMedsGiven()
	{
		return this.medsgiven;
	}
	public void setMedsGiven(Integer value)
	{
		this.medsgiven = value;
	}
	public Boolean getECG()
	{
		return this.ecg;
	}
	public void setECG(Boolean value)
	{
		this.ecg = value;
	}
	public Boolean getNPO()
	{
		return this.npo;
	}
	public void setNPO(Boolean value)
	{
		this.npo = value;
	}
	public Boolean getIsolation()
	{
		return this.isolation;
	}
	public void setIsolation(Boolean value)
	{
		this.isolation = value;
	}
	public Integer getPainAssessments()
	{
		return this.painassessments;
	}
	public void setPainAssessments(Integer value)
	{
		this.painassessments = value;
	}
	public Integer getWaterlowAssessments()
	{
		return this.waterlowassessments;
	}
	public void setWaterlowAssessments(Integer value)
	{
		this.waterlowassessments = value;
	}
	public Integer getFallsAssessment()
	{
		return this.fallsassessment;
	}
	public void setFallsAssessment(Integer value)
	{
		this.fallsassessment = value;
	}
	public Integer getIsarAssessments()
	{
		return this.isarassessments;
	}
	public void setIsarAssessments(Integer value)
	{
		this.isarassessments = value;
	}

	private Integer obsrequired;
	private Integer medsgiven;
	private Boolean ecg;
	private Boolean npo;
	private Boolean isolation;
	private Integer painassessments;
	private Integer waterlowassessments;
	private Integer fallsassessment;
	private Integer isarassessments;
}
