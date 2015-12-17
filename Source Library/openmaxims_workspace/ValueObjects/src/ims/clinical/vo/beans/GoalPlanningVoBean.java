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

package ims.clinical.vo.beans;

public class GoalPlanningVoBean extends ims.vo.ValueObjectBean
{
	public GoalPlanningVoBean()
	{
	}
	public GoalPlanningVoBean(ims.clinical.vo.GoalPlanningVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.goalplanningdate = vo.getGoalPlanningDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getGoalPlanningDate().getBean();
		this.predicateddischargedate = vo.getPredicatedDischargeDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPredicatedDischargeDate().getBean();
		this.goalplanningoutcome = vo.getGoalPlanningOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getGoalPlanningOutcome().getBean();
		this.primecancelreason = vo.getPrimeCancelReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimeCancelReason().getBean();
		this.predictednextgoalplanning = vo.getPredictedNextGoalPlanning() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPredictedNextGoalPlanning().getBean();
		this.dischargedelayvalue = vo.getDischargeDelayValue();
		this.dischargedelayunit = vo.getDischargeDelayUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDelayUnit().getBean();
		this.isgoalplanningconf = vo.getIsGoalPlanningConf();
		this.minutes = vo.getMinutes();
		this.comments = vo.getComments();
		this.invitees = vo.getInvitees() == null ? null : vo.getInvitees().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.GoalPlanningVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.goalplanningdate = vo.getGoalPlanningDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getGoalPlanningDate().getBean();
		this.predicateddischargedate = vo.getPredicatedDischargeDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPredicatedDischargeDate().getBean();
		this.goalplanningoutcome = vo.getGoalPlanningOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getGoalPlanningOutcome().getBean();
		this.primecancelreason = vo.getPrimeCancelReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimeCancelReason().getBean();
		this.predictednextgoalplanning = vo.getPredictedNextGoalPlanning() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPredictedNextGoalPlanning().getBean();
		this.dischargedelayvalue = vo.getDischargeDelayValue();
		this.dischargedelayunit = vo.getDischargeDelayUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDelayUnit().getBean();
		this.isgoalplanningconf = vo.getIsGoalPlanningConf();
		this.minutes = vo.getMinutes();
		this.comments = vo.getComments();
		this.invitees = vo.getInvitees() == null ? null : vo.getInvitees().getBeanCollection();
	}

	public ims.clinical.vo.GoalPlanningVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.GoalPlanningVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.GoalPlanningVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.GoalPlanningVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.GoalPlanningVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateBean getGoalPlanningDate()
	{
		return this.goalplanningdate;
	}
	public void setGoalPlanningDate(ims.framework.utils.beans.DateBean value)
	{
		this.goalplanningdate = value;
	}
	public ims.framework.utils.beans.PartialDateBean getPredicatedDischargeDate()
	{
		return this.predicateddischargedate;
	}
	public void setPredicatedDischargeDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.predicateddischargedate = value;
	}
	public ims.vo.LookupInstanceBean getGoalPlanningOutcome()
	{
		return this.goalplanningoutcome;
	}
	public void setGoalPlanningOutcome(ims.vo.LookupInstanceBean value)
	{
		this.goalplanningoutcome = value;
	}
	public ims.vo.LookupInstanceBean getPrimeCancelReason()
	{
		return this.primecancelreason;
	}
	public void setPrimeCancelReason(ims.vo.LookupInstanceBean value)
	{
		this.primecancelreason = value;
	}
	public ims.framework.utils.beans.PartialDateBean getPredictedNextGoalPlanning()
	{
		return this.predictednextgoalplanning;
	}
	public void setPredictedNextGoalPlanning(ims.framework.utils.beans.PartialDateBean value)
	{
		this.predictednextgoalplanning = value;
	}
	public Integer getDischargeDelayValue()
	{
		return this.dischargedelayvalue;
	}
	public void setDischargeDelayValue(Integer value)
	{
		this.dischargedelayvalue = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDelayUnit()
	{
		return this.dischargedelayunit;
	}
	public void setDischargeDelayUnit(ims.vo.LookupInstanceBean value)
	{
		this.dischargedelayunit = value;
	}
	public Boolean getIsGoalPlanningConf()
	{
		return this.isgoalplanningconf;
	}
	public void setIsGoalPlanningConf(Boolean value)
	{
		this.isgoalplanningconf = value;
	}
	public String getMinutes()
	{
		return this.minutes;
	}
	public void setMinutes(String value)
	{
		this.minutes = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean[] getInvitees()
	{
		return this.invitees;
	}
	public void setInvitees(ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean[] value)
	{
		this.invitees = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.framework.utils.beans.DateBean goalplanningdate;
	private ims.framework.utils.beans.PartialDateBean predicateddischargedate;
	private ims.vo.LookupInstanceBean goalplanningoutcome;
	private ims.vo.LookupInstanceBean primecancelreason;
	private ims.framework.utils.beans.PartialDateBean predictednextgoalplanning;
	private Integer dischargedelayvalue;
	private ims.vo.LookupInstanceBean dischargedelayunit;
	private Boolean isgoalplanningconf;
	private String minutes;
	private String comments;
	private ims.clinical.vo.beans.GoalPlanningMeetingAttendeeVoBean[] invitees;
}
