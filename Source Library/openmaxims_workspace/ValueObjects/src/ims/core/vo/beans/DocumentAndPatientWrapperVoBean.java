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

public class DocumentAndPatientWrapperVoBean extends ims.vo.ValueObjectBean
{
	public DocumentAndPatientWrapperVoBean()
	{
	}
	public DocumentAndPatientWrapperVoBean(ims.core.vo.DocumentAndPatientWrapperVo vo)
	{
		this.document = vo.getDocument() == null ? null : (ims.core.vo.beans.PatientDocumentVoBean)vo.getDocument().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForDocumentWorklistVoBean)vo.getPatient().getBean();
		this.isstale = vo.getIsStale();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DocumentAndPatientWrapperVo vo)
	{
		this.document = vo.getDocument() == null ? null : (ims.core.vo.beans.PatientDocumentVoBean)vo.getDocument().getBean(map);
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForDocumentWorklistVoBean)vo.getPatient().getBean(map);
		this.isstale = vo.getIsStale();
	}

	public ims.core.vo.DocumentAndPatientWrapperVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DocumentAndPatientWrapperVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DocumentAndPatientWrapperVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DocumentAndPatientWrapperVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DocumentAndPatientWrapperVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PatientDocumentVoBean getDocument()
	{
		return this.document;
	}
	public void setDocument(ims.core.vo.beans.PatientDocumentVoBean value)
	{
		this.document = value;
	}
	public ims.core.vo.beans.PatientForDocumentWorklistVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientForDocumentWorklistVoBean value)
	{
		this.patient = value;
	}
	public Boolean getIsStale()
	{
		return this.isstale;
	}
	public void setIsStale(Boolean value)
	{
		this.isstale = value;
	}

	private ims.core.vo.beans.PatientDocumentVoBean document;
	private ims.core.vo.beans.PatientForDocumentWorklistVoBean patient;
	private Boolean isstale;
}
