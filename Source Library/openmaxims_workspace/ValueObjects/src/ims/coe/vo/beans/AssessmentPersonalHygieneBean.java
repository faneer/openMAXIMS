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

public class AssessmentPersonalHygieneBean extends ims.vo.ValueObjectBean
{
	public AssessmentPersonalHygieneBean()
	{
	}
	public AssessmentPersonalHygieneBean(ims.coe.vo.AssessmentPersonalHygiene vo)
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
		this.preferredbathingpattern = vo.getPreferredBathingPattern();
		this.assisstancewithpersonalhygiene = vo.getAssisstanceWithPersonalHygiene() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssisstanceWithPersonalHygiene().getBean();
		this.hygieneactivities = vo.getHygieneActivities() == null ? null : vo.getHygieneActivities().getBeanCollection();
		this.personalhygienefeet = vo.getPersonalHygieneFeet() == null ? null : (ims.coe.vo.beans.PersonalHygieneFeetVoBean)vo.getPersonalHygieneFeet().getBean();
		this.conditionofhair = vo.getConditionOfHair() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfHair().getBean();
		this.evidenceofhairinfestation = vo.getEvidenceOfHairInfestation() == null ? null : (ims.vo.LookupInstanceBean)vo.getEvidenceOfHairInfestation().getBean();
		this.conditionofnails = vo.getConditionOfNails() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfNails().getBean();
		this.conditionofskin = vo.getConditionOfSkin();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.AssessmentPersonalHygiene vo)
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
		this.preferredbathingpattern = vo.getPreferredBathingPattern();
		this.assisstancewithpersonalhygiene = vo.getAssisstanceWithPersonalHygiene() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssisstanceWithPersonalHygiene().getBean();
		this.hygieneactivities = vo.getHygieneActivities() == null ? null : vo.getHygieneActivities().getBeanCollection();
		this.personalhygienefeet = vo.getPersonalHygieneFeet() == null ? null : (ims.coe.vo.beans.PersonalHygieneFeetVoBean)vo.getPersonalHygieneFeet().getBean(map);
		this.conditionofhair = vo.getConditionOfHair() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfHair().getBean();
		this.evidenceofhairinfestation = vo.getEvidenceOfHairInfestation() == null ? null : (ims.vo.LookupInstanceBean)vo.getEvidenceOfHairInfestation().getBean();
		this.conditionofnails = vo.getConditionOfNails() == null ? null : (ims.vo.LookupInstanceBean)vo.getConditionOfNails().getBean();
		this.conditionofskin = vo.getConditionOfSkin();
	}

	public ims.coe.vo.AssessmentPersonalHygiene buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.AssessmentPersonalHygiene buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.AssessmentPersonalHygiene vo = null;
		if(map != null)
			vo = (ims.coe.vo.AssessmentPersonalHygiene)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.AssessmentPersonalHygiene();
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
	public String getPreferredBathingPattern()
	{
		return this.preferredbathingpattern;
	}
	public void setPreferredBathingPattern(String value)
	{
		this.preferredbathingpattern = value;
	}
	public ims.vo.LookupInstanceBean getAssisstanceWithPersonalHygiene()
	{
		return this.assisstancewithpersonalhygiene;
	}
	public void setAssisstanceWithPersonalHygiene(ims.vo.LookupInstanceBean value)
	{
		this.assisstancewithpersonalhygiene = value;
	}
	public ims.nursing.vo.beans.HygieneActivitiesBean[] getHygieneActivities()
	{
		return this.hygieneactivities;
	}
	public void setHygieneActivities(ims.nursing.vo.beans.HygieneActivitiesBean[] value)
	{
		this.hygieneactivities = value;
	}
	public ims.coe.vo.beans.PersonalHygieneFeetVoBean getPersonalHygieneFeet()
	{
		return this.personalhygienefeet;
	}
	public void setPersonalHygieneFeet(ims.coe.vo.beans.PersonalHygieneFeetVoBean value)
	{
		this.personalhygienefeet = value;
	}
	public ims.vo.LookupInstanceBean getConditionOfHair()
	{
		return this.conditionofhair;
	}
	public void setConditionOfHair(ims.vo.LookupInstanceBean value)
	{
		this.conditionofhair = value;
	}
	public ims.vo.LookupInstanceBean getEvidenceOfHairInfestation()
	{
		return this.evidenceofhairinfestation;
	}
	public void setEvidenceOfHairInfestation(ims.vo.LookupInstanceBean value)
	{
		this.evidenceofhairinfestation = value;
	}
	public ims.vo.LookupInstanceBean getConditionOfNails()
	{
		return this.conditionofnails;
	}
	public void setConditionOfNails(ims.vo.LookupInstanceBean value)
	{
		this.conditionofnails = value;
	}
	public String getConditionOfSkin()
	{
		return this.conditionofskin;
	}
	public void setConditionOfSkin(String value)
	{
		this.conditionofskin = value;
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
	private String preferredbathingpattern;
	private ims.vo.LookupInstanceBean assisstancewithpersonalhygiene;
	private ims.nursing.vo.beans.HygieneActivitiesBean[] hygieneactivities;
	private ims.coe.vo.beans.PersonalHygieneFeetVoBean personalhygienefeet;
	private ims.vo.LookupInstanceBean conditionofhair;
	private ims.vo.LookupInstanceBean evidenceofhairinfestation;
	private ims.vo.LookupInstanceBean conditionofnails;
	private String conditionofskin;
}
