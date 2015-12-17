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

package ims.clinical.vo.beans;

public class VTERiskAssessmentWorklistCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public VTERiskAssessmentWorklistCriteriaVoBean()
	{
	}
	public VTERiskAssessmentWorklistCriteriaVoBean(ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo vo)
	{
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospital().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.admissiondatefrom = vo.getAdmissionDateFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateFrom().getBean();
		this.admissiondateto = vo.getAdmissionDateTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTo().getBean();
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.patidtype = vo.getPatIdType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatIdType().getBean();
		this.patidvalue = vo.getPatIdValue();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.dob = vo.getDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDOB().getBean();
		this.vtestatus = vo.getVTEStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEStatus().getBean();
		this.over24hours = vo.getOver24Hours();
		this.wastimeron = vo.getWasTimerOn();
		this.currentward = vo.getCurrentWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentWard().getBean();
		this.currentinpatients = vo.getCurrentInpatients();
		this.dischargedpatients = vo.getDischargedPatients();
		this.tcifortoday = vo.getTciForToday();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo vo)
	{
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospital().getBean(map);
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.admissiondatefrom = vo.getAdmissionDateFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateFrom().getBean();
		this.admissiondateto = vo.getAdmissionDateTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTo().getBean();
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.patidtype = vo.getPatIdType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatIdType().getBean();
		this.patidvalue = vo.getPatIdValue();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.dob = vo.getDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDOB().getBean();
		this.vtestatus = vo.getVTEStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEStatus().getBean();
		this.over24hours = vo.getOver24Hours();
		this.wastimeron = vo.getWasTimerOn();
		this.currentward = vo.getCurrentWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentWard().getBean(map);
		this.currentinpatients = vo.getCurrentInpatients();
		this.dischargedpatients = vo.getDischargedPatients();
		this.tcifortoday = vo.getTciForToday();
	}

	public ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.LocSiteLiteVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocSiteLiteVoBean value)
	{
		this.hospital = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.ward = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateFrom()
	{
		return this.admissiondatefrom;
	}
	public void setAdmissionDateFrom(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatefrom = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTo()
	{
		return this.admissiondateto;
	}
	public void setAdmissionDateTo(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondateto = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getPatIdType()
	{
		return this.patidtype;
	}
	public void setPatIdType(ims.vo.LookupInstanceBean value)
	{
		this.patidtype = value;
	}
	public String getPatIdValue()
	{
		return this.patidvalue;
	}
	public void setPatIdValue(String value)
	{
		this.patidvalue = value;
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
	public ims.vo.LookupInstanceBean getVTEStatus()
	{
		return this.vtestatus;
	}
	public void setVTEStatus(ims.vo.LookupInstanceBean value)
	{
		this.vtestatus = value;
	}
	public Boolean getOver24Hours()
	{
		return this.over24hours;
	}
	public void setOver24Hours(Boolean value)
	{
		this.over24hours = value;
	}
	public Boolean getWasTimerOn()
	{
		return this.wastimeron;
	}
	public void setWasTimerOn(Boolean value)
	{
		this.wastimeron = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getCurrentWard()
	{
		return this.currentward;
	}
	public void setCurrentWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.currentward = value;
	}
	public Boolean getCurrentInpatients()
	{
		return this.currentinpatients;
	}
	public void setCurrentInpatients(Boolean value)
	{
		this.currentinpatients = value;
	}
	public Boolean getDischargedPatients()
	{
		return this.dischargedpatients;
	}
	public void setDischargedPatients(Boolean value)
	{
		this.dischargedpatients = value;
	}
	public Boolean getTciForToday()
	{
		return this.tcifortoday;
	}
	public void setTciForToday(Boolean value)
	{
		this.tcifortoday = value;
	}

	private ims.core.vo.beans.LocSiteLiteVoBean hospital;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private ims.framework.utils.beans.DateTimeBean admissiondatefrom;
	private ims.framework.utils.beans.DateTimeBean admissiondateto;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean patidtype;
	private String patidvalue;
	private String surname;
	private String forename;
	private ims.framework.utils.beans.PartialDateBean dob;
	private ims.vo.LookupInstanceBean vtestatus;
	private Boolean over24hours;
	private Boolean wastimeron;
	private ims.core.vo.beans.LocationLiteVoBean currentward;
	private Boolean currentinpatients;
	private Boolean dischargedpatients;
	private Boolean tcifortoday;
}
