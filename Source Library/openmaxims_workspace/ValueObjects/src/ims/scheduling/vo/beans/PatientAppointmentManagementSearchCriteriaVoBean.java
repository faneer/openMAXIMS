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

package ims.scheduling.vo.beans;

public class PatientAppointmentManagementSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PatientAppointmentManagementSearchCriteriaVoBean()
	{
	}
	public PatientAppointmentManagementSearchCriteriaVoBean(ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo vo)
	{
		this.idvalue = vo.getIDValue();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.dob = vo.getDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDOB().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo vo)
	{
		this.idvalue = vo.getIDValue();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.dob = vo.getDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDOB().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
	}

	public ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.PatientAppointmentManagementSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getIDValue()
	{
		return this.idvalue;
	}
	public void setIDValue(String value)
	{
		this.idvalue = value;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String value)
	{
		this.surname = value;
	}
	public String getForename()
	{
		return this.forename;
	}
	public void setForename(String value)
	{
		this.forename = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDOB()
	{
		return this.dob;
	}
	public void setDOB(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}

	private String idvalue;
	private String surname;
	private String forename;
	private ims.framework.utils.beans.PartialDateBean dob;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.framework.utils.beans.DateBean date;
}
