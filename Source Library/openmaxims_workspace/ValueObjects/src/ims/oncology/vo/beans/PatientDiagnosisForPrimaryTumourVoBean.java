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

package ims.oncology.vo.beans;

public class PatientDiagnosisForPrimaryTumourVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisForPrimaryTumourVoBean()
	{
	}
	public PatientDiagnosisForPrimaryTumourVoBean(ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean();
		this.basisofdiagnosis = vo.getBasisofDiagnosis() == null ? null : vo.getBasisofDiagnosis().getBeanCollection();
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.basisofdiagnosis = vo.getBasisofDiagnosis() == null ? null : vo.getBasisofDiagnosis().getBeanCollection();
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
	}

	public ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo();
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
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.diagnoseddate = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public ims.clinical.vo.beans.PatientDiagnosisStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.clinical.vo.beans.PatientDiagnosisStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public java.util.Collection getBasisofDiagnosis()
	{
		return this.basisofdiagnosis;
	}
	public void setBasisofDiagnosis(java.util.Collection value)
	{
		this.basisofdiagnosis = value;
	}
	public void addBasisofDiagnosis(java.util.Collection value)
	{
		if(this.basisofdiagnosis == null)
			this.basisofdiagnosis = new java.util.ArrayList();
		this.basisofdiagnosis.add(value);
	}
	public ims.vo.LookupInstanceBean getDiagLaterality()
	{
		return this.diaglaterality;
	}
	public void setDiagLaterality(ims.vo.LookupInstanceBean value)
	{
		this.diaglaterality = value;
	}

	private Integer id;
	private int version;
	private String diagnosisdescription;
	private ims.framework.utils.beans.PartialDateBean diagnoseddate;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.clinical.vo.beans.PatientDiagnosisStatusVoBean currentstatus;
	private java.util.Collection basisofdiagnosis;
	private ims.vo.LookupInstanceBean diaglaterality;
}
