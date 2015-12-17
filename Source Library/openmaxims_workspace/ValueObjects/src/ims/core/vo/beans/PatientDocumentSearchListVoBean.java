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

public class PatientDocumentSearchListVoBean extends ims.vo.ValueObjectBean
{
	public PatientDocumentSearchListVoBean()
	{
	}
	public PatientDocumentSearchListVoBean(ims.core.vo.PatientDocumentSearchListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.creationtype = vo.getCreationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCreationType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean();
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.currentdocumentstatus = vo.getCurrentDocumentStatus() == null ? null : (ims.core.vo.beans.PatientDocumentStatusVoBean)vo.getCurrentDocumentStatus().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean();
		this.correspondencestatus = vo.getCorrespondenceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCorrespondenceStatus().getBean();
		this.name = vo.getName();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDocumentSearchListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.creationtype = vo.getCreationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCreationType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean(map);
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.currentdocumentstatus = vo.getCurrentDocumentStatus() == null ? null : (ims.core.vo.beans.PatientDocumentStatusVoBean)vo.getCurrentDocumentStatus().getBean(map);
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean(map);
		this.correspondencestatus = vo.getCorrespondenceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCorrespondenceStatus().getBean();
		this.name = vo.getName();
	}

	public ims.core.vo.PatientDocumentSearchListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDocumentSearchListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDocumentSearchListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDocumentSearchListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDocumentSearchListVo();
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
	public ims.vo.LookupInstanceBean getCreationType()
	{
		return this.creationtype;
	}
	public void setCreationType(ims.vo.LookupInstanceBean value)
	{
		this.creationtype = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.framework.utils.beans.DateBean getDocumentDate()
	{
		return this.documentdate;
	}
	public void setDocumentDate(ims.framework.utils.beans.DateBean value)
	{
		this.documentdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}
	public ims.core.vo.beans.PatientDocumentStatusVoBean getCurrentDocumentStatus()
	{
		return this.currentdocumentstatus;
	}
	public void setCurrentDocumentStatus(ims.core.vo.beans.PatientDocumentStatusVoBean value)
	{
		this.currentdocumentstatus = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.LookupInstanceBean getCorrespondenceStatus()
	{
		return this.correspondencestatus;
	}
	public void setCorrespondenceStatus(ims.vo.LookupInstanceBean value)
	{
		this.correspondencestatus = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean creationtype;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean specialty;
	private ims.core.vo.beans.HcpLiteVoBean authoringhcp;
	private ims.framework.utils.beans.DateBean documentdate;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
	private ims.core.vo.beans.PatientDocumentStatusVoBean currentdocumentstatus;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private ims.vo.LookupInstanceBean correspondencestatus;
	private String name;
}
