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

package ims.coe.vo.beans;

public class AssessmentCommunicationBean extends ims.vo.ValueObjectBean
{
	public AssessmentCommunicationBean()
	{
	}
	public AssessmentCommunicationBean(ims.coe.vo.AssessmentCommunication vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean();
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.difficultyincommunication = vo.getDifficultyInCommunication() == null ? null : (ims.vo.LookupInstanceBean)vo.getDifficultyInCommunication().getBean();
		this.speechandlanguage = vo.getSpeechAndLanguage() == null ? null : (ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean)vo.getSpeechAndLanguage().getBean();
		this.vision = vo.getVision() == null ? null : (ims.coe.vo.beans.CommunicationVisionVoBean)vo.getVision().getBean();
		this.hearing = vo.getHearing() == null ? null : (ims.coe.vo.beans.CommunicationHearingVoBean)vo.getHearing().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.AssessmentCommunication vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean(map);
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.difficultyincommunication = vo.getDifficultyInCommunication() == null ? null : (ims.vo.LookupInstanceBean)vo.getDifficultyInCommunication().getBean();
		this.speechandlanguage = vo.getSpeechAndLanguage() == null ? null : (ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean)vo.getSpeechAndLanguage().getBean(map);
		this.vision = vo.getVision() == null ? null : (ims.coe.vo.beans.CommunicationVisionVoBean)vo.getVision().getBean(map);
		this.hearing = vo.getHearing() == null ? null : (ims.coe.vo.beans.CommunicationHearingVoBean)vo.getHearing().getBean(map);
	}

	public ims.coe.vo.AssessmentCommunication buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.AssessmentCommunication buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.AssessmentCommunication vo = null;
		if(map != null)
			vo = (ims.coe.vo.AssessmentCommunication)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.AssessmentCommunication();
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
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean[] getAssessmentInfo()
	{
		return this.assessmentinfo;
	}
	public void setAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean[] value)
	{
		this.assessmentinfo = value;
	}
	public Boolean getCopy()
	{
		return this.copy;
	}
	public void setCopy(Boolean value)
	{
		this.copy = value;
	}
	public ims.vo.LookupInstanceBean getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.vo.LookupInstanceBean value)
	{
		this.componenttype = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean getLastAssessmentInfo()
	{
		return this.lastassessmentinfo;
	}
	public void setLastAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean value)
	{
		this.lastassessmentinfo = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean[] getCarePlanTemplate()
	{
		return this.careplantemplate;
	}
	public void setCarePlanTemplate(ims.nursing.vo.beans.CarePlanTemplateBean[] value)
	{
		this.careplantemplate = value;
	}
	public ims.nursing.vo.beans.CarePlanBean[] getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.beans.CarePlanBean[] value)
	{
		this.careplans = value;
	}
	public ims.vo.LookupInstanceBean getDifficultyInCommunication()
	{
		return this.difficultyincommunication;
	}
	public void setDifficultyInCommunication(ims.vo.LookupInstanceBean value)
	{
		this.difficultyincommunication = value;
	}
	public ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean getSpeechAndLanguage()
	{
		return this.speechandlanguage;
	}
	public void setSpeechAndLanguage(ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean value)
	{
		this.speechandlanguage = value;
	}
	public ims.coe.vo.beans.CommunicationVisionVoBean getVision()
	{
		return this.vision;
	}
	public void setVision(ims.coe.vo.beans.CommunicationVisionVoBean value)
	{
		this.vision = value;
	}
	public ims.coe.vo.beans.CommunicationHearingVoBean getHearing()
	{
		return this.hearing;
	}
	public void setHearing(ims.coe.vo.beans.CommunicationHearingVoBean value)
	{
		this.hearing = value;
	}

	private Integer id;
	private int version;
	private Boolean iscomplete;
	private ims.nursing.vo.beans.AssessmentInfoBean[] assessmentinfo;
	private Boolean copy;
	private ims.vo.LookupInstanceBean componenttype;
	private ims.nursing.vo.beans.AssessmentInfoBean lastassessmentinfo;
	private ims.nursing.vo.beans.CarePlanTemplateBean[] careplantemplate;
	private ims.nursing.vo.beans.CarePlanBean[] careplans;
	private ims.vo.LookupInstanceBean difficultyincommunication;
	private ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean speechandlanguage;
	private ims.coe.vo.beans.CommunicationVisionVoBean vision;
	private ims.coe.vo.beans.CommunicationHearingVoBean hearing;
}
