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

package ims.assessment.vo.beans;

public class Graphic_AssessmentFindingQuestionVoBean extends ims.vo.ValueObjectBean
{
	public Graphic_AssessmentFindingQuestionVoBean()
	{
	}
	public Graphic_AssessmentFindingQuestionVoBean(ims.assessment.vo.Graphic_AssessmentFindingQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.assessment.vo.beans.Question_InformationVoBean)vo.getQuestion().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.ismandatory = vo.getIsMandatory();
		this.sequence = vo.getSequence();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Graphic_AssessmentFindingQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.assessment.vo.beans.Question_InformationVoBean)vo.getQuestion().getBean(map);
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.ismandatory = vo.getIsMandatory();
		this.sequence = vo.getSequence();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
	}

	public ims.assessment.vo.Graphic_AssessmentFindingQuestionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Graphic_AssessmentFindingQuestionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Graphic_AssessmentFindingQuestionVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Graphic_AssessmentFindingQuestionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Graphic_AssessmentFindingQuestionVo();
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
	public ims.assessment.vo.beans.Question_InformationVoBean getQuestion()
	{
		return this.question;
	}
	public void setQuestion(ims.assessment.vo.beans.Question_InformationVoBean value)
	{
		this.question = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.ismandatory = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public Boolean getAllowsMultipleAnswers()
	{
		return this.allowsmultipleanswers;
	}
	public void setAllowsMultipleAnswers(Boolean value)
	{
		this.allowsmultipleanswers = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.Question_InformationVoBean question;
	private ims.vo.LookupInstanceBean activestatus;
	private Boolean ismandatory;
	private Integer sequence;
	private Boolean allowsmultipleanswers;
}
