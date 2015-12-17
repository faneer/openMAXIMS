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

public class PatientProcedureSurgicalOpVoBean extends ims.vo.ValueObjectBean
{
	public PatientProcedureSurgicalOpVoBean()
	{
	}
	public PatientProcedureSurgicalOpVoBean(ims.core.vo.PatientProcedureSurgicalOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.procdate = vo.getProcDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcDate().getBean();
		this.peformedby = vo.getPeformedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getPeformedBy().getBean();
		this.infosource = vo.getInfoSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getInfoSource().getBean();
		this.hcppresent = vo.getHCPPresent() == null ? null : vo.getHCPPresent().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.includeindischargeletter = vo.getIncludeInDischargeLetter();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.proceduredescription = vo.getProcedureDescription();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientProcedureSurgicalOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.procdate = vo.getProcDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcDate().getBean();
		this.peformedby = vo.getPeformedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getPeformedBy().getBean(map);
		this.infosource = vo.getInfoSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getInfoSource().getBean();
		this.hcppresent = vo.getHCPPresent() == null ? null : vo.getHCPPresent().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.includeindischargeletter = vo.getIncludeInDischargeLetter();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.proceduredescription = vo.getProcedureDescription();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.core.vo.PatientProcedureSurgicalOpVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientProcedureSurgicalOpVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientProcedureSurgicalOpVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientProcedureSurgicalOpVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientProcedureSurgicalOpVo();
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
	public ims.vo.LookupInstanceBean getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.vo.LookupInstanceBean value)
	{
		this.procedurestatus = value;
	}
	public ims.framework.utils.beans.PartialDateBean getProcDate()
	{
		return this.procdate;
	}
	public void setProcDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.procdate = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getPeformedBy()
	{
		return this.peformedby;
	}
	public void setPeformedBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.peformedby = value;
	}
	public ims.vo.LookupInstanceBean getInfoSource()
	{
		return this.infosource;
	}
	public void setInfoSource(ims.vo.LookupInstanceBean value)
	{
		this.infosource = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean[] getHCPPresent()
	{
		return this.hcppresent;
	}
	public void setHCPPresent(ims.core.vo.beans.HcpLiteVoBean[] value)
	{
		this.hcppresent = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIncludeInDischargeLetter()
	{
		return this.includeindischargeletter;
	}
	public void setIncludeInDischargeLetter(Boolean value)
	{
		this.includeindischargeletter = value;
	}
	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public void setProcedureDescription(String value)
	{
		this.proceduredescription = value;
	}
	public ims.vo.LookupInstanceBean getProcedureUrgency()
	{
		return this.procedureurgency;
	}
	public void setProcedureUrgency(ims.vo.LookupInstanceBean value)
	{
		this.procedureurgency = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean procedurestatus;
	private ims.framework.utils.beans.PartialDateBean procdate;
	private ims.core.vo.beans.HcpLiteVoBean peformedby;
	private ims.vo.LookupInstanceBean infosource;
	private ims.core.vo.beans.HcpLiteVoBean[] hcppresent;
	private ims.vo.RefVoBean carecontext;
	private Boolean includeindischargeletter;
	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private String proceduredescription;
	private ims.vo.LookupInstanceBean procedureurgency;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.RefVoBean episodeofcare;
}
