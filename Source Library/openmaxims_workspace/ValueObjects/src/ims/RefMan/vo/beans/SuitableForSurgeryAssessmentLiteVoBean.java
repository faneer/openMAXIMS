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

package ims.RefMan.vo.beans;

public class SuitableForSurgeryAssessmentLiteVoBean extends ims.vo.ValueObjectBean
{
	public SuitableForSurgeryAssessmentLiteVoBean()
	{
	}
	public SuitableForSurgeryAssessmentLiteVoBean(ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureLiteVoBean)vo.getProcedure().getBean();
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.historyprescomplaint = vo.getHistoryPresComplaint();
		this.examination = vo.getExamination();
		this.conclusions = vo.getConclusions();
		this.notsuitableforsurgeycomments = vo.getNotSuitableForSurgeyComments();
		this.suitableforsurgery = vo.getSuitableForSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuitableForSurgery().getBean();
		this.reasonnotsuitable = vo.getReasonNotSuitable() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonNotSuitable().getBean();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.procedureperformed = vo.getProcedurePerformed();
		this.suitableforsurgerydate = vo.getSuitableForSurgeryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSuitableForSurgeryDate().getBean();
		this.requireddurationinmins = vo.getRequiredDurationInMins();
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.namedsurgeon = vo.getNamedSurgeon() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getNamedSurgeon().getBean();
		this.specialequipmentrequired = vo.getSpecialEquipmentRequired();
		this.specialequipmentcomments = vo.getSpecialEquipmentComments();
		this.specialinstructionsrequired = vo.getSpecialInstructionsRequired();
		this.specialinstructionscomments = vo.getSpecialInstructionsComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.historyprescomplaint = vo.getHistoryPresComplaint();
		this.examination = vo.getExamination();
		this.conclusions = vo.getConclusions();
		this.notsuitableforsurgeycomments = vo.getNotSuitableForSurgeyComments();
		this.suitableforsurgery = vo.getSuitableForSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuitableForSurgery().getBean();
		this.reasonnotsuitable = vo.getReasonNotSuitable() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonNotSuitable().getBean();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.procedureperformed = vo.getProcedurePerformed();
		this.suitableforsurgerydate = vo.getSuitableForSurgeryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSuitableForSurgeryDate().getBean();
		this.requireddurationinmins = vo.getRequiredDurationInMins();
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.namedsurgeon = vo.getNamedSurgeon() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getNamedSurgeon().getBean(map);
		this.specialequipmentrequired = vo.getSpecialEquipmentRequired();
		this.specialequipmentcomments = vo.getSpecialEquipmentComments();
		this.specialinstructionsrequired = vo.getSpecialInstructionsRequired();
		this.specialinstructionscomments = vo.getSpecialInstructionsComments();
	}

	public ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.PatientProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.PatientProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public ims.vo.LookupInstanceBean getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.vo.LookupInstanceBean value)
	{
		this.theatretype = value;
	}
	public String getHistoryPresComplaint()
	{
		return this.historyprescomplaint;
	}
	public void setHistoryPresComplaint(String value)
	{
		this.historyprescomplaint = value;
	}
	public String getExamination()
	{
		return this.examination;
	}
	public void setExamination(String value)
	{
		this.examination = value;
	}
	public String getConclusions()
	{
		return this.conclusions;
	}
	public void setConclusions(String value)
	{
		this.conclusions = value;
	}
	public String getNotSuitableForSurgeyComments()
	{
		return this.notsuitableforsurgeycomments;
	}
	public void setNotSuitableForSurgeyComments(String value)
	{
		this.notsuitableforsurgeycomments = value;
	}
	public ims.vo.LookupInstanceBean getSuitableForSurgery()
	{
		return this.suitableforsurgery;
	}
	public void setSuitableForSurgery(ims.vo.LookupInstanceBean value)
	{
		this.suitableforsurgery = value;
	}
	public ims.vo.LookupInstanceBean getReasonNotSuitable()
	{
		return this.reasonnotsuitable;
	}
	public void setReasonNotSuitable(ims.vo.LookupInstanceBean value)
	{
		this.reasonnotsuitable = value;
	}
	public ims.RefMan.vo.beans.SuitableForSurgeryCommentVoBean[] getComments()
	{
		return this.comments;
	}
	public void setComments(ims.RefMan.vo.beans.SuitableForSurgeryCommentVoBean[] value)
	{
		this.comments = value;
	}
	public Boolean getProcedurePerformed()
	{
		return this.procedureperformed;
	}
	public void setProcedurePerformed(Boolean value)
	{
		this.procedureperformed = value;
	}
	public ims.framework.utils.beans.DateBean getSuitableForSurgeryDate()
	{
		return this.suitableforsurgerydate;
	}
	public void setSuitableForSurgeryDate(ims.framework.utils.beans.DateBean value)
	{
		this.suitableforsurgerydate = value;
	}
	public Integer getRequiredDurationInMins()
	{
		return this.requireddurationinmins;
	}
	public void setRequiredDurationInMins(Integer value)
	{
		this.requireddurationinmins = value;
	}
	public ims.vo.LookupInstanceBean getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.vo.LookupInstanceBean value)
	{
		this.anaesthetictype = value;
	}
	public ims.core.vo.beans.MedicLiteVoBean getNamedSurgeon()
	{
		return this.namedsurgeon;
	}
	public void setNamedSurgeon(ims.core.vo.beans.MedicLiteVoBean value)
	{
		this.namedsurgeon = value;
	}
	public Boolean getSpecialEquipmentRequired()
	{
		return this.specialequipmentrequired;
	}
	public void setSpecialEquipmentRequired(Boolean value)
	{
		this.specialequipmentrequired = value;
	}
	public String getSpecialEquipmentComments()
	{
		return this.specialequipmentcomments;
	}
	public void setSpecialEquipmentComments(String value)
	{
		this.specialequipmentcomments = value;
	}
	public Boolean getSpecialInstructionsRequired()
	{
		return this.specialinstructionsrequired;
	}
	public void setSpecialInstructionsRequired(Boolean value)
	{
		this.specialinstructionsrequired = value;
	}
	public String getSpecialInstructionsComments()
	{
		return this.specialinstructionscomments;
	}
	public void setSpecialInstructionsComments(String value)
	{
		this.specialinstructionscomments = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.PatientProcedureLiteVoBean procedure;
	private ims.vo.LookupInstanceBean theatretype;
	private String historyprescomplaint;
	private String examination;
	private String conclusions;
	private String notsuitableforsurgeycomments;
	private ims.vo.LookupInstanceBean suitableforsurgery;
	private ims.vo.LookupInstanceBean reasonnotsuitable;
	private ims.RefMan.vo.beans.SuitableForSurgeryCommentVoBean[] comments;
	private Boolean procedureperformed;
	private ims.framework.utils.beans.DateBean suitableforsurgerydate;
	private Integer requireddurationinmins;
	private ims.vo.LookupInstanceBean anaesthetictype;
	private ims.core.vo.beans.MedicLiteVoBean namedsurgeon;
	private Boolean specialequipmentrequired;
	private String specialequipmentcomments;
	private Boolean specialinstructionsrequired;
	private String specialinstructionscomments;
}
