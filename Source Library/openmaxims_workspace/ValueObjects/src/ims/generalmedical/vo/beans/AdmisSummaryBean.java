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

package ims.generalmedical.vo.beans;

public class AdmisSummaryBean extends ims.vo.ValueObjectBean
{
	public AdmisSummaryBean()
	{
	}
	public AdmisSummaryBean(ims.generalmedical.vo.AdmisSummary vo)
	{
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.dateofinjury = vo.getDateOfInjury() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfInjury().getBean();
		this.sensoryright = vo.getSensoryRight();
		this.sensoryleft = vo.getSensoryLeft();
		this.motorleft = vo.getMotorLeft();
		this.motorright = vo.getMotorRight();
		this.overallneuro = vo.getOverallNeuro();
		this.completeincomplete = vo.getCompleteIncomplete();
		this.asiagrade = vo.getAsiaGrade();
		this.asiascore = vo.getAsiaScore();
		this.franklegrade = vo.getFrankleGrade();
		this.modeofinjury = vo.getModeOfInjury();
		this.causeofinjury = vo.getCauseOfInjury();
		this.mechanismofinjury = vo.getMechanismOfInjury();
		this.levelofinjury = vo.getLevelOfInjury();
		this.spinesyndrome = vo.getSpineSyndrome();
		this.durationsinceinjury = vo.getDurationSinceInjury();
		this.typeofinjury = vo.getTypeOfInjury();
		this.firstadmissiondate = vo.getFirstAdmissionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFirstAdmissionDate().getBean();
		this.mrsastatus = vo.getMRSAStatus();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.AdmisSummary vo)
	{
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.dateofinjury = vo.getDateOfInjury() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfInjury().getBean();
		this.sensoryright = vo.getSensoryRight();
		this.sensoryleft = vo.getSensoryLeft();
		this.motorleft = vo.getMotorLeft();
		this.motorright = vo.getMotorRight();
		this.overallneuro = vo.getOverallNeuro();
		this.completeincomplete = vo.getCompleteIncomplete();
		this.asiagrade = vo.getAsiaGrade();
		this.asiascore = vo.getAsiaScore();
		this.franklegrade = vo.getFrankleGrade();
		this.modeofinjury = vo.getModeOfInjury();
		this.causeofinjury = vo.getCauseOfInjury();
		this.mechanismofinjury = vo.getMechanismOfInjury();
		this.levelofinjury = vo.getLevelOfInjury();
		this.spinesyndrome = vo.getSpineSyndrome();
		this.durationsinceinjury = vo.getDurationSinceInjury();
		this.typeofinjury = vo.getTypeOfInjury();
		this.firstadmissiondate = vo.getFirstAdmissionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFirstAdmissionDate().getBean();
		this.mrsastatus = vo.getMRSAStatus();
	}

	public ims.generalmedical.vo.AdmisSummary buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.AdmisSummary buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.AdmisSummary vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.AdmisSummary)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.AdmisSummary();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfInjury()
	{
		return this.dateofinjury;
	}
	public void setDateOfInjury(ims.framework.utils.beans.DateBean value)
	{
		this.dateofinjury = value;
	}
	public String getSensoryRight()
	{
		return this.sensoryright;
	}
	public void setSensoryRight(String value)
	{
		this.sensoryright = value;
	}
	public String getSensoryLeft()
	{
		return this.sensoryleft;
	}
	public void setSensoryLeft(String value)
	{
		this.sensoryleft = value;
	}
	public String getMotorLeft()
	{
		return this.motorleft;
	}
	public void setMotorLeft(String value)
	{
		this.motorleft = value;
	}
	public String getMotorRight()
	{
		return this.motorright;
	}
	public void setMotorRight(String value)
	{
		this.motorright = value;
	}
	public String getOverallNeuro()
	{
		return this.overallneuro;
	}
	public void setOverallNeuro(String value)
	{
		this.overallneuro = value;
	}
	public String getCompleteIncomplete()
	{
		return this.completeincomplete;
	}
	public void setCompleteIncomplete(String value)
	{
		this.completeincomplete = value;
	}
	public String getAsiaGrade()
	{
		return this.asiagrade;
	}
	public void setAsiaGrade(String value)
	{
		this.asiagrade = value;
	}
	public String getAsiaScore()
	{
		return this.asiascore;
	}
	public void setAsiaScore(String value)
	{
		this.asiascore = value;
	}
	public String getFrankleGrade()
	{
		return this.franklegrade;
	}
	public void setFrankleGrade(String value)
	{
		this.franklegrade = value;
	}
	public String getModeOfInjury()
	{
		return this.modeofinjury;
	}
	public void setModeOfInjury(String value)
	{
		this.modeofinjury = value;
	}
	public String getCauseOfInjury()
	{
		return this.causeofinjury;
	}
	public void setCauseOfInjury(String value)
	{
		this.causeofinjury = value;
	}
	public String getMechanismOfInjury()
	{
		return this.mechanismofinjury;
	}
	public void setMechanismOfInjury(String value)
	{
		this.mechanismofinjury = value;
	}
	public String getLevelOfInjury()
	{
		return this.levelofinjury;
	}
	public void setLevelOfInjury(String value)
	{
		this.levelofinjury = value;
	}
	public String getSpineSyndrome()
	{
		return this.spinesyndrome;
	}
	public void setSpineSyndrome(String value)
	{
		this.spinesyndrome = value;
	}
	public String getDurationSinceInjury()
	{
		return this.durationsinceinjury;
	}
	public void setDurationSinceInjury(String value)
	{
		this.durationsinceinjury = value;
	}
	public String getTypeOfInjury()
	{
		return this.typeofinjury;
	}
	public void setTypeOfInjury(String value)
	{
		this.typeofinjury = value;
	}
	public ims.framework.utils.beans.DateBean getFirstAdmissionDate()
	{
		return this.firstadmissiondate;
	}
	public void setFirstAdmissionDate(ims.framework.utils.beans.DateBean value)
	{
		this.firstadmissiondate = value;
	}
	public Boolean getMRSAStatus()
	{
		return this.mrsastatus;
	}
	public void setMRSAStatus(Boolean value)
	{
		this.mrsastatus = value;
	}

	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
	private ims.framework.utils.beans.DateBean dateofinjury;
	private String sensoryright;
	private String sensoryleft;
	private String motorleft;
	private String motorright;
	private String overallneuro;
	private String completeincomplete;
	private String asiagrade;
	private String asiascore;
	private String franklegrade;
	private String modeofinjury;
	private String causeofinjury;
	private String mechanismofinjury;
	private String levelofinjury;
	private String spinesyndrome;
	private String durationsinceinjury;
	private String typeofinjury;
	private ims.framework.utils.beans.DateBean firstadmissiondate;
	private Boolean mrsastatus;
}
