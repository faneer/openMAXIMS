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

package ims.nursing.vo.beans;

public class CarePlanEvaluationNoteListVoBean extends ims.vo.ValueObjectBean
{
	public CarePlanEvaluationNoteListVoBean()
	{
	}
	public CarePlanEvaluationNoteListVoBean(ims.nursing.vo.CarePlanEvaluationNoteListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.recordeddatetime = vo.getRecordedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordedDateTime().getBean();
		this.recordedby = vo.getRecordedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRecordedBy().getBean();
		this.note = vo.getNote();
		this.active = vo.getActive();
		this.careplan = vo.getCarePlan() == null ? null : (ims.nursing.vo.beans.CarePlanTitleBean)vo.getCarePlan().getBean();
		this.correctedby = vo.getCorrectedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getCorrectedBy().getBean();
		this.correctiondatetime = vo.getCorrectionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCorrectionDateTime().getBean();
		this.correctionreason = vo.getCorrectionReason();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.CarePlanEvaluationNoteListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.recordeddatetime = vo.getRecordedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordedDateTime().getBean();
		this.recordedby = vo.getRecordedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRecordedBy().getBean(map);
		this.note = vo.getNote();
		this.active = vo.getActive();
		this.careplan = vo.getCarePlan() == null ? null : (ims.nursing.vo.beans.CarePlanTitleBean)vo.getCarePlan().getBean(map);
		this.correctedby = vo.getCorrectedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getCorrectedBy().getBean(map);
		this.correctiondatetime = vo.getCorrectionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCorrectionDateTime().getBean();
		this.correctionreason = vo.getCorrectionReason();
	}

	public ims.nursing.vo.CarePlanEvaluationNoteListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.CarePlanEvaluationNoteListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.CarePlanEvaluationNoteListVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.CarePlanEvaluationNoteListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.CarePlanEvaluationNoteListVo();
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
	public ims.framework.utils.beans.DateTimeBean getRecordedDateTime()
	{
		return this.recordeddatetime;
	}
	public void setRecordedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordeddatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getRecordedBy()
	{
		return this.recordedby;
	}
	public void setRecordedBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.recordedby = value;
	}
	public String getNote()
	{
		return this.note;
	}
	public void setNote(String value)
	{
		this.note = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public ims.nursing.vo.beans.CarePlanTitleBean getCarePlan()
	{
		return this.careplan;
	}
	public void setCarePlan(ims.nursing.vo.beans.CarePlanTitleBean value)
	{
		this.careplan = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getCorrectedBy()
	{
		return this.correctedby;
	}
	public void setCorrectedBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.correctedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCorrectionDateTime()
	{
		return this.correctiondatetime;
	}
	public void setCorrectionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.correctiondatetime = value;
	}
	public String getCorrectionReason()
	{
		return this.correctionreason;
	}
	public void setCorrectionReason(String value)
	{
		this.correctionreason = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean recordeddatetime;
	private ims.core.vo.beans.HcpLiteVoBean recordedby;
	private String note;
	private Boolean active;
	private ims.nursing.vo.beans.CarePlanTitleBean careplan;
	private ims.core.vo.beans.HcpLiteVoBean correctedby;
	private ims.framework.utils.beans.DateTimeBean correctiondatetime;
	private String correctionreason;
}
