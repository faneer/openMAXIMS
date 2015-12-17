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

public class DocumentWorklistSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public DocumentWorklistSearchCriteriaVoBean()
	{
	}
	public DocumentWorklistSearchCriteriaVoBean(ims.core.vo.DocumentWorklistSearchCriteriaVo vo)
	{
		this.author = vo.getAuthor() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthor().getBean();
		// Interface field type not supported.
		// Interface field type not supported.
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean();
		this.documentstatus = vo.getDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentStatus().getBean();
		this.documenttype = vo.getDocumentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentType().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.responsible = vo.getResponsible() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsible().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.patientid = vo.getPatientId() == null ? null : (ims.core.vo.beans.PatientIdListVoBean)vo.getPatientId().getBean();
		this.excludecompleted = vo.getExcludeCompleted();
		this.columnsortorder = vo.getColumnSortOrder() == null ? null : (ims.core.vo.beans.ColumnSortOrderVoBean)vo.getColumnSortOrder().getBean();
		this.searchtype = vo.getSearchType();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DocumentWorklistSearchCriteriaVo vo)
	{
		this.author = vo.getAuthor() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthor().getBean(map);
		// Interface field type not supported.
		// Interface field type not supported.
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean(map);
		this.documentstatus = vo.getDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentStatus().getBean();
		this.documenttype = vo.getDocumentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentType().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.responsible = vo.getResponsible() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsible().getBean(map);
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.patientid = vo.getPatientId() == null ? null : (ims.core.vo.beans.PatientIdListVoBean)vo.getPatientId().getBean(map);
		this.excludecompleted = vo.getExcludeCompleted();
		this.columnsortorder = vo.getColumnSortOrder() == null ? null : (ims.core.vo.beans.ColumnSortOrderVoBean)vo.getColumnSortOrder().getBean(map);
		this.searchtype = vo.getSearchType();
	}

	public ims.core.vo.DocumentWorklistSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DocumentWorklistSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DocumentWorklistSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DocumentWorklistSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DocumentWorklistSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.HcpLiteVoBean getAuthor()
	{
		return this.author;
	}
	public void setAuthor(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.author = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.clinic = value;
	}
	public ims.vo.LookupInstanceBean getDocumentStatus()
	{
		return this.documentstatus;
	}
	public void setDocumentStatus(ims.vo.LookupInstanceBean value)
	{
		this.documentstatus = value;
	}
	public ims.vo.LookupInstanceBean getDocumentType()
	{
		return this.documenttype;
	}
	public void setDocumentType(ims.vo.LookupInstanceBean value)
	{
		this.documenttype = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsible()
	{
		return this.responsible;
	}
	public void setResponsible(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsible = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.PatientIdListVoBean getPatientId()
	{
		return this.patientid;
	}
	public void setPatientId(ims.core.vo.beans.PatientIdListVoBean value)
	{
		this.patientid = value;
	}
	public Boolean getExcludeCompleted()
	{
		return this.excludecompleted;
	}
	public void setExcludeCompleted(Boolean value)
	{
		this.excludecompleted = value;
	}
	public ims.core.vo.beans.ColumnSortOrderVoBean getColumnSortOrder()
	{
		return this.columnsortorder;
	}
	public void setColumnSortOrder(ims.core.vo.beans.ColumnSortOrderVoBean value)
	{
		this.columnsortorder = value;
	}
	public Integer getSearchType()
	{
		return this.searchtype;
	}
	public void setSearchType(Integer value)
	{
		this.searchtype = value;
	}

	private ims.core.vo.beans.HcpLiteVoBean author;
	private ims.core.vo.beans.ClinicLiteVoBean clinic;
	private ims.vo.LookupInstanceBean documentstatus;
	private ims.vo.LookupInstanceBean documenttype;
	private ims.vo.LookupInstanceBean specialty;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
	private ims.core.vo.beans.HcpLiteVoBean responsible;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.PatientIdListVoBean patientid;
	private Boolean excludecompleted;
	private ims.core.vo.beans.ColumnSortOrderVoBean columnsortorder;
	private Integer searchtype;
}
