//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.beans;

public class SoapNoteVoBean extends ims.vo.ValueObjectBean
{
	public SoapNoteVoBean()
	{
	}
	public SoapNoteVoBean(ims.clinical.vo.SoapNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.subjectivenote = vo.getSubjectiveNote();
		this.objectivenote = vo.getObjectiveNote();
		this.analysisnote = vo.getAnalysisNote();
		this.plannote = vo.getPlanNote();
		this.clinicalnote = vo.getClinicalNote() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getClinicalNote().getBean();
		this.areaofneed = vo.getAreaofNeed() == null ? null : vo.getAreaofNeed().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SoapNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.subjectivenote = vo.getSubjectiveNote();
		this.objectivenote = vo.getObjectiveNote();
		this.analysisnote = vo.getAnalysisNote();
		this.plannote = vo.getPlanNote();
		this.clinicalnote = vo.getClinicalNote() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getClinicalNote().getBean(map);
		this.areaofneed = vo.getAreaofNeed() == null ? null : vo.getAreaofNeed().getBeanCollection();
	}

	public ims.clinical.vo.SoapNoteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SoapNoteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SoapNoteVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SoapNoteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SoapNoteVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public String getSubjectiveNote()
	{
		return this.subjectivenote;
	}
	public void setSubjectiveNote(String value)
	{
		this.subjectivenote = value;
	}
	public String getObjectiveNote()
	{
		return this.objectivenote;
	}
	public void setObjectiveNote(String value)
	{
		this.objectivenote = value;
	}
	public String getAnalysisNote()
	{
		return this.analysisnote;
	}
	public void setAnalysisNote(String value)
	{
		this.analysisnote = value;
	}
	public String getPlanNote()
	{
		return this.plannote;
	}
	public void setPlanNote(String value)
	{
		this.plannote = value;
	}
	public ims.core.vo.beans.ClinicalNotesVoBean getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(ims.core.vo.beans.ClinicalNotesVoBean value)
	{
		this.clinicalnote = value;
	}
	public java.util.Collection getAreaofNeed()
	{
		return this.areaofneed;
	}
	public void setAreaofNeed(java.util.Collection value)
	{
		this.areaofneed = value;
	}
	public void addAreaofNeed(java.util.Collection value)
	{
		if(this.areaofneed == null)
			this.areaofneed = new java.util.ArrayList();
		this.areaofneed.add(value);
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private String subjectivenote;
	private String objectivenote;
	private String analysisnote;
	private String plannote;
	private ims.core.vo.beans.ClinicalNotesVoBean clinicalnote;
	private java.util.Collection areaofneed;
}
