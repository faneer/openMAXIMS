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

public class DementiaFindVoBean extends ims.vo.ValueObjectBean
{
	public DementiaFindVoBean()
	{
	}
	public DementiaFindVoBean(ims.clinical.vo.DementiaFindVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.hasformaldiagnosisofdementia = vo.getHasFormalDiagnosisOfDementia() == null ? null : (ims.vo.LookupInstanceBean)vo.getHasFormalDiagnosisOfDementia().getBean();
		this.camsacuteonset = vo.getCAMSAcuteOnset() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSAcuteOnset().getBean();
		this.camsinattention = vo.getCAMSInattention() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSInattention().getBean();
		this.camsdisorganisedthinking = vo.getCAMSDisorganisedThinking() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSDisorganisedThinking().getBean();
		this.camsalteredlevel = vo.getCAMSAlteredLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSAlteredLevel().getBean();
		this.deliriumconfirmed = vo.getDeliriumConfirmed() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeliriumConfirmed().getBean();
		this.awarenessquestion = vo.getAwarenessQuestion() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwarenessQuestion().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DementiaFindVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.hasformaldiagnosisofdementia = vo.getHasFormalDiagnosisOfDementia() == null ? null : (ims.vo.LookupInstanceBean)vo.getHasFormalDiagnosisOfDementia().getBean();
		this.camsacuteonset = vo.getCAMSAcuteOnset() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSAcuteOnset().getBean();
		this.camsinattention = vo.getCAMSInattention() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSInattention().getBean();
		this.camsdisorganisedthinking = vo.getCAMSDisorganisedThinking() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSDisorganisedThinking().getBean();
		this.camsalteredlevel = vo.getCAMSAlteredLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getCAMSAlteredLevel().getBean();
		this.deliriumconfirmed = vo.getDeliriumConfirmed() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeliriumConfirmed().getBean();
		this.awarenessquestion = vo.getAwarenessQuestion() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwarenessQuestion().getBean();
	}

	public ims.clinical.vo.DementiaFindVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DementiaFindVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DementiaFindVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DementiaFindVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DementiaFindVo();
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
	public ims.vo.LookupInstanceBean getHasFormalDiagnosisOfDementia()
	{
		return this.hasformaldiagnosisofdementia;
	}
	public void setHasFormalDiagnosisOfDementia(ims.vo.LookupInstanceBean value)
	{
		this.hasformaldiagnosisofdementia = value;
	}
	public ims.vo.LookupInstanceBean getCAMSAcuteOnset()
	{
		return this.camsacuteonset;
	}
	public void setCAMSAcuteOnset(ims.vo.LookupInstanceBean value)
	{
		this.camsacuteonset = value;
	}
	public ims.vo.LookupInstanceBean getCAMSInattention()
	{
		return this.camsinattention;
	}
	public void setCAMSInattention(ims.vo.LookupInstanceBean value)
	{
		this.camsinattention = value;
	}
	public ims.vo.LookupInstanceBean getCAMSDisorganisedThinking()
	{
		return this.camsdisorganisedthinking;
	}
	public void setCAMSDisorganisedThinking(ims.vo.LookupInstanceBean value)
	{
		this.camsdisorganisedthinking = value;
	}
	public ims.vo.LookupInstanceBean getCAMSAlteredLevel()
	{
		return this.camsalteredlevel;
	}
	public void setCAMSAlteredLevel(ims.vo.LookupInstanceBean value)
	{
		this.camsalteredlevel = value;
	}
	public ims.vo.LookupInstanceBean getDeliriumConfirmed()
	{
		return this.deliriumconfirmed;
	}
	public void setDeliriumConfirmed(ims.vo.LookupInstanceBean value)
	{
		this.deliriumconfirmed = value;
	}
	public ims.vo.LookupInstanceBean getAwarenessQuestion()
	{
		return this.awarenessquestion;
	}
	public void setAwarenessQuestion(ims.vo.LookupInstanceBean value)
	{
		this.awarenessquestion = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean hasformaldiagnosisofdementia;
	private ims.vo.LookupInstanceBean camsacuteonset;
	private ims.vo.LookupInstanceBean camsinattention;
	private ims.vo.LookupInstanceBean camsdisorganisedthinking;
	private ims.vo.LookupInstanceBean camsalteredlevel;
	private ims.vo.LookupInstanceBean deliriumconfirmed;
	private ims.vo.LookupInstanceBean awarenessquestion;
}
