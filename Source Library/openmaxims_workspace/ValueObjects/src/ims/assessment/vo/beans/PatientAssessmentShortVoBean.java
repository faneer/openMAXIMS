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

package ims.assessment.vo.beans;

public class PatientAssessmentShortVoBean extends ims.vo.ValueObjectBean
{
	public PatientAssessmentShortVoBean()
	{
	}
	public PatientAssessmentShortVoBean(ims.assessment.vo.PatientAssessmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.completedhcp = vo.getCompletedHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getCompletedHCP().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.assessmentdata = vo.getAssessmentData() == null ? null : (ims.assessment.vo.beans.PatientAssessmentDataLiteVoBean)vo.getAssessmentData().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.PatientAssessmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.completedhcp = vo.getCompletedHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getCompletedHCP().getBean(map);
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.assessmentdata = vo.getAssessmentData() == null ? null : (ims.assessment.vo.beans.PatientAssessmentDataLiteVoBean)vo.getAssessmentData().getBean(map);
	}

	public ims.assessment.vo.PatientAssessmentShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.PatientAssessmentShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.PatientAssessmentShortVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.PatientAssessmentShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.PatientAssessmentShortVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getCompletedHCP()
	{
		return this.completedhcp;
	}
	public void setCompletedHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.completedhcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentDataLiteVoBean getAssessmentData()
	{
		return this.assessmentdata;
	}
	public void setAssessmentData(ims.assessment.vo.beans.PatientAssessmentDataLiteVoBean value)
	{
		this.assessmentdata = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean status;
	private ims.core.vo.beans.HcpLiteVoBean completedhcp;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.vo.SysInfoBean sysinfo;
	private ims.assessment.vo.beans.PatientAssessmentDataLiteVoBean assessmentdata;
}
