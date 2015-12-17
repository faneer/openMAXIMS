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

public class DementiaAssessAndInvestigateVoBean extends ims.vo.ValueObjectBean
{
	public DementiaAssessAndInvestigateVoBean()
	{
	}
	public DementiaAssessAndInvestigateVoBean(ims.clinical.vo.DementiaAssessAndInvestigateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.q1age = vo.getQ1Age() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ1Age().getBean();
		this.q2dob = vo.getQ2DOB() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ2DOB().getBean();
		this.q3currentyear = vo.getQ3CurrentYear() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ3CurrentYear().getBean();
		this.q4currenttime = vo.getQ4CurrentTime() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ4CurrentTime().getBean();
		this.q5nameofhospital = vo.getQ5NameOfHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ5NameOfHospital().getBean();
		this.q6recognisepeople = vo.getQ6RecognisePeople() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ6RecognisePeople().getBean();
		this.q7yearww2ended = vo.getQ7YearWW2Ended() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ7YearWW2Ended().getBean();
		this.q8monarch = vo.getQ8Monarch() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ8Monarch().getBean();
		this.q9countbackwards = vo.getQ9CountBackwards() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ9CountBackwards().getBean();
		this.q10recall = vo.getQ10Recall() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ10Recall().getBean();
		this.amtsscore = vo.getAMTSScore();
		this.confirmtrustsprotocol = vo.getConfirmTrustsProtocol() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmTrustsProtocol().getBean();
		this.confirmmedicationreview = vo.getConfirmMedicationReview() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmMedicationReview().getBean();
		this.steptwoassessnote = vo.getStepTwoAssessNote() == null ? null : (ims.clinical.vo.beans.DementiaAssessInvestigateNoteVoBean)vo.getStepTwoAssessNote().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DementiaAssessAndInvestigateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.q1age = vo.getQ1Age() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ1Age().getBean();
		this.q2dob = vo.getQ2DOB() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ2DOB().getBean();
		this.q3currentyear = vo.getQ3CurrentYear() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ3CurrentYear().getBean();
		this.q4currenttime = vo.getQ4CurrentTime() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ4CurrentTime().getBean();
		this.q5nameofhospital = vo.getQ5NameOfHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ5NameOfHospital().getBean();
		this.q6recognisepeople = vo.getQ6RecognisePeople() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ6RecognisePeople().getBean();
		this.q7yearww2ended = vo.getQ7YearWW2Ended() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ7YearWW2Ended().getBean();
		this.q8monarch = vo.getQ8Monarch() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ8Monarch().getBean();
		this.q9countbackwards = vo.getQ9CountBackwards() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ9CountBackwards().getBean();
		this.q10recall = vo.getQ10Recall() == null ? null : (ims.vo.LookupInstanceBean)vo.getQ10Recall().getBean();
		this.amtsscore = vo.getAMTSScore();
		this.confirmtrustsprotocol = vo.getConfirmTrustsProtocol() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmTrustsProtocol().getBean();
		this.confirmmedicationreview = vo.getConfirmMedicationReview() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmMedicationReview().getBean();
		this.steptwoassessnote = vo.getStepTwoAssessNote() == null ? null : (ims.clinical.vo.beans.DementiaAssessInvestigateNoteVoBean)vo.getStepTwoAssessNote().getBean(map);
	}

	public ims.clinical.vo.DementiaAssessAndInvestigateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DementiaAssessAndInvestigateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DementiaAssessAndInvestigateVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DementiaAssessAndInvestigateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DementiaAssessAndInvestigateVo();
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
	public ims.vo.LookupInstanceBean getQ1Age()
	{
		return this.q1age;
	}
	public void setQ1Age(ims.vo.LookupInstanceBean value)
	{
		this.q1age = value;
	}
	public ims.vo.LookupInstanceBean getQ2DOB()
	{
		return this.q2dob;
	}
	public void setQ2DOB(ims.vo.LookupInstanceBean value)
	{
		this.q2dob = value;
	}
	public ims.vo.LookupInstanceBean getQ3CurrentYear()
	{
		return this.q3currentyear;
	}
	public void setQ3CurrentYear(ims.vo.LookupInstanceBean value)
	{
		this.q3currentyear = value;
	}
	public ims.vo.LookupInstanceBean getQ4CurrentTime()
	{
		return this.q4currenttime;
	}
	public void setQ4CurrentTime(ims.vo.LookupInstanceBean value)
	{
		this.q4currenttime = value;
	}
	public ims.vo.LookupInstanceBean getQ5NameOfHospital()
	{
		return this.q5nameofhospital;
	}
	public void setQ5NameOfHospital(ims.vo.LookupInstanceBean value)
	{
		this.q5nameofhospital = value;
	}
	public ims.vo.LookupInstanceBean getQ6RecognisePeople()
	{
		return this.q6recognisepeople;
	}
	public void setQ6RecognisePeople(ims.vo.LookupInstanceBean value)
	{
		this.q6recognisepeople = value;
	}
	public ims.vo.LookupInstanceBean getQ7YearWW2Ended()
	{
		return this.q7yearww2ended;
	}
	public void setQ7YearWW2Ended(ims.vo.LookupInstanceBean value)
	{
		this.q7yearww2ended = value;
	}
	public ims.vo.LookupInstanceBean getQ8Monarch()
	{
		return this.q8monarch;
	}
	public void setQ8Monarch(ims.vo.LookupInstanceBean value)
	{
		this.q8monarch = value;
	}
	public ims.vo.LookupInstanceBean getQ9CountBackwards()
	{
		return this.q9countbackwards;
	}
	public void setQ9CountBackwards(ims.vo.LookupInstanceBean value)
	{
		this.q9countbackwards = value;
	}
	public ims.vo.LookupInstanceBean getQ10Recall()
	{
		return this.q10recall;
	}
	public void setQ10Recall(ims.vo.LookupInstanceBean value)
	{
		this.q10recall = value;
	}
	public Integer getAMTSScore()
	{
		return this.amtsscore;
	}
	public void setAMTSScore(Integer value)
	{
		this.amtsscore = value;
	}
	public ims.vo.LookupInstanceBean getConfirmTrustsProtocol()
	{
		return this.confirmtrustsprotocol;
	}
	public void setConfirmTrustsProtocol(ims.vo.LookupInstanceBean value)
	{
		this.confirmtrustsprotocol = value;
	}
	public ims.vo.LookupInstanceBean getConfirmMedicationReview()
	{
		return this.confirmmedicationreview;
	}
	public void setConfirmMedicationReview(ims.vo.LookupInstanceBean value)
	{
		this.confirmmedicationreview = value;
	}
	public ims.clinical.vo.beans.DementiaAssessInvestigateNoteVoBean getStepTwoAssessNote()
	{
		return this.steptwoassessnote;
	}
	public void setStepTwoAssessNote(ims.clinical.vo.beans.DementiaAssessInvestigateNoteVoBean value)
	{
		this.steptwoassessnote = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean q1age;
	private ims.vo.LookupInstanceBean q2dob;
	private ims.vo.LookupInstanceBean q3currentyear;
	private ims.vo.LookupInstanceBean q4currenttime;
	private ims.vo.LookupInstanceBean q5nameofhospital;
	private ims.vo.LookupInstanceBean q6recognisepeople;
	private ims.vo.LookupInstanceBean q7yearww2ended;
	private ims.vo.LookupInstanceBean q8monarch;
	private ims.vo.LookupInstanceBean q9countbackwards;
	private ims.vo.LookupInstanceBean q10recall;
	private Integer amtsscore;
	private ims.vo.LookupInstanceBean confirmtrustsprotocol;
	private ims.vo.LookupInstanceBean confirmmedicationreview;
	private ims.clinical.vo.beans.DementiaAssessInvestigateNoteVoBean steptwoassessnote;
}
