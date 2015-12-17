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

package ims.racpc.vo.beans;

public class PatientDocumentForRACPCSummaryVoBean extends ims.vo.ValueObjectBean
{
	public PatientDocumentForRACPCSummaryVoBean()
	{
	}
	public PatientDocumentForRACPCSummaryVoBean(ims.racpc.vo.PatientDocumentForRACPCSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episodeofcare = vo.getEpisodeofCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeofCare().getBoId(), vo.getEpisodeofCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.name = vo.getName();
		this.serverdocument = vo.getServerDocument() == null ? null : (ims.core.vo.beans.ServerDocumentVoBean)vo.getServerDocument().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleHCP().getBoId(), vo.getResponsibleHCP().getBoVersion());
		this.creationtype = vo.getCreationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCreationType().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : new ims.vo.RefVoBean(vo.getRecordingUser().getBoId(), vo.getRecordingUser().getBoVersion());
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringHCP().getBoId(), vo.getAuthoringHCP().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.racpc.vo.PatientDocumentForRACPCSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episodeofcare = vo.getEpisodeofCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeofCare().getBoId(), vo.getEpisodeofCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.name = vo.getName();
		this.serverdocument = vo.getServerDocument() == null ? null : (ims.core.vo.beans.ServerDocumentVoBean)vo.getServerDocument().getBean(map);
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleHCP().getBoId(), vo.getResponsibleHCP().getBoVersion());
		this.creationtype = vo.getCreationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCreationType().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : new ims.vo.RefVoBean(vo.getRecordingUser().getBoId(), vo.getRecordingUser().getBoVersion());
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringHCP().getBoId(), vo.getAuthoringHCP().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
	}

	public ims.racpc.vo.PatientDocumentForRACPCSummaryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.racpc.vo.PatientDocumentForRACPCSummaryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.racpc.vo.PatientDocumentForRACPCSummaryVo vo = null;
		if(map != null)
			vo = (ims.racpc.vo.PatientDocumentForRACPCSummaryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.racpc.vo.PatientDocumentForRACPCSummaryVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisodeofCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeofCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.core.vo.beans.ServerDocumentVoBean getServerDocument()
	{
		return this.serverdocument;
	}
	public void setServerDocument(ims.core.vo.beans.ServerDocumentVoBean value)
	{
		this.serverdocument = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getDocumentDate()
	{
		return this.documentdate;
	}
	public void setDocumentDate(ims.framework.utils.beans.DateBean value)
	{
		this.documentdate = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.RefVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.vo.RefVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.LookupInstanceBean getCreationType()
	{
		return this.creationtype;
	}
	public void setCreationType(ims.vo.LookupInstanceBean value)
	{
		this.creationtype = value;
	}
	public ims.vo.RefVoBean getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.vo.RefVoBean value)
	{
		this.recordinguser = value;
	}
	public ims.vo.RefVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.vo.RefVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalcontact;
	private String name;
	private ims.core.vo.beans.ServerDocumentVoBean serverdocument;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean status;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
	private ims.framework.utils.beans.DateBean documentdate;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.RefVoBean responsiblehcp;
	private ims.vo.LookupInstanceBean creationtype;
	private ims.vo.RefVoBean recordinguser;
	private ims.vo.RefVoBean authoringhcp;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
}
