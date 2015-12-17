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

public class PatientPastMedicalHistoryVoBean extends ims.vo.ValueObjectBean
{
	public PatientPastMedicalHistoryVoBean()
	{
	}
	public PatientPastMedicalHistoryVoBean(ims.core.vo.PatientPastMedicalHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : vo.getDiagnosis().getBeanCollection();
		this.procedure = vo.getProcedure() == null ? null : vo.getProcedure().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientPastMedicalHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : vo.getDiagnosis().getBeanCollection();
		this.procedure = vo.getProcedure() == null ? null : vo.getProcedure().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
	}

	public ims.core.vo.PatientPastMedicalHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientPastMedicalHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientPastMedicalHistoryVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientPastMedicalHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientPastMedicalHistoryVo();
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
	public ims.core.vo.beans.PatientDiagnosisVoBean[] getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.PatientDiagnosisVoBean[] value)
	{
		this.diagnosis = value;
	}
	public ims.core.vo.beans.PatientProcedureShortVoBean[] getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.PatientProcedureShortVoBean[] value)
	{
		this.procedure = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientDiagnosisVoBean[] diagnosis;
	private ims.core.vo.beans.PatientProcedureShortVoBean[] procedure;
	private ims.vo.RefVoBean patient;
}
