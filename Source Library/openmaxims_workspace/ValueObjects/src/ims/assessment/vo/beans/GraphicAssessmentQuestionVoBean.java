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

public class GraphicAssessmentQuestionVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAssessmentQuestionVoBean()
	{
	}
	public GraphicAssessmentQuestionVoBean(ims.assessment.vo.GraphicAssessmentQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.core.vo.beans.QuestionInformationVoBean)vo.getQuestion().getBean();
		this.ismandatory = vo.getIsMandatory();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.sequence = vo.getSequence();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.GraphicAssessmentQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.core.vo.beans.QuestionInformationVoBean)vo.getQuestion().getBean(map);
		this.ismandatory = vo.getIsMandatory();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.sequence = vo.getSequence();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
	}

	public ims.assessment.vo.GraphicAssessmentQuestionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.GraphicAssessmentQuestionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.GraphicAssessmentQuestionVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.GraphicAssessmentQuestionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.GraphicAssessmentQuestionVo();
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
	public ims.core.vo.beans.QuestionInformationVoBean getQuestion()
	{
		return this.question;
	}
	public void setQuestion(ims.core.vo.beans.QuestionInformationVoBean value)
	{
		this.question = value;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.ismandatory = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
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
	private ims.core.vo.beans.QuestionInformationVoBean question;
	private Boolean ismandatory;
	private ims.vo.LookupInstanceBean activestatus;
	private Integer sequence;
	private Boolean allowsmultipleanswers;
}
