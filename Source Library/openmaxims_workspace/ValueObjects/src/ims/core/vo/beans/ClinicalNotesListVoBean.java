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

package ims.core.vo.beans;

public class ClinicalNotesListVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalNotesListVoBean()
	{
	}
	public ClinicalNotesListVoBean(ims.core.vo.ClinicalNotesListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote();
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.isderivednote = vo.getIsDerivedNote();
		this.forreview = vo.getForReview();
		this.forreviewdiscipline = vo.getForReviewDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getForReviewDiscipline().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean();
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.ClinicalNoteStatusVoBean)vo.getCurrentStatus().getBean();
		this.iscorrected = vo.getIsCorrected();
		this.istranscribed = vo.getIsTranscribed();
		this.sourceofnote = vo.getSourceOfNote() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfNote().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.systeminfo = vo.getSystemInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClinicalNotesListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote();
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.isderivednote = vo.getIsDerivedNote();
		this.forreview = vo.getForReview();
		this.forreviewdiscipline = vo.getForReviewDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getForReviewDiscipline().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean(map);
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.ClinicalNoteStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.iscorrected = vo.getIsCorrected();
		this.istranscribed = vo.getIsTranscribed();
		this.sourceofnote = vo.getSourceOfNote() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfNote().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean(map);
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.systeminfo = vo.getSystemInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInfo().getBean();
	}

	public ims.core.vo.ClinicalNotesListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClinicalNotesListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClinicalNotesListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClinicalNotesListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClinicalNotesListVo();
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
	public String getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(String value)
	{
		this.clinicalnote = value;
	}
	public ims.vo.LookupInstanceBean getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.vo.LookupInstanceBean value)
	{
		this.notetype = value;
	}
	public ims.vo.LookupInstanceBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.vo.LookupInstanceBean value)
	{
		this.discipline = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public Boolean getIsDerivedNote()
	{
		return this.isderivednote;
	}
	public void setIsDerivedNote(Boolean value)
	{
		this.isderivednote = value;
	}
	public Boolean getForReview()
	{
		return this.forreview;
	}
	public void setForReview(Boolean value)
	{
		this.forreview = value;
	}
	public ims.vo.LookupInstanceBean getForReviewDiscipline()
	{
		return this.forreviewdiscipline;
	}
	public void setForReviewDiscipline(ims.vo.LookupInstanceBean value)
	{
		this.forreviewdiscipline = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReviewingHCP()
	{
		return this.reviewinghcp;
	}
	public void setReviewingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.reviewinghcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReviewingDateTime()
	{
		return this.reviewingdatetime;
	}
	public void setReviewingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.reviewingdatetime = value;
	}
	public ims.core.vo.beans.ClinicalNoteStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.beans.ClinicalNoteStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public Boolean getIsCorrected()
	{
		return this.iscorrected;
	}
	public void setIsCorrected(Boolean value)
	{
		this.iscorrected = value;
	}
	public Boolean getIsTranscribed()
	{
		return this.istranscribed;
	}
	public void setIsTranscribed(Boolean value)
	{
		this.istranscribed = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfNote()
	{
		return this.sourceofnote;
	}
	public void setSourceOfNote(ims.vo.LookupInstanceBean value)
	{
		this.sourceofnote = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.recordinguser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}
	public ims.vo.SysInfoBean getSystemInfo()
	{
		return this.systeminfo;
	}
	public void setSystemInfo(ims.vo.SysInfoBean value)
	{
		this.systeminfo = value;
	}

	private Integer id;
	private int version;
	private String clinicalnote;
	private ims.vo.LookupInstanceBean notetype;
	private ims.vo.LookupInstanceBean discipline;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private Boolean isderivednote;
	private Boolean forreview;
	private ims.vo.LookupInstanceBean forreviewdiscipline;
	private ims.core.vo.beans.HcpLiteVoBean reviewinghcp;
	private ims.framework.utils.beans.DateTimeBean reviewingdatetime;
	private ims.core.vo.beans.ClinicalNoteStatusVoBean currentstatus;
	private Boolean iscorrected;
	private Boolean istranscribed;
	private ims.vo.LookupInstanceBean sourceofnote;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean recordinguser;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
	private ims.vo.SysInfoBean systeminfo;
}
