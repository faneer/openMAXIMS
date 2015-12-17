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

package ims.correspondence.vo.beans;

public class ClinicCorrespondenceListSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public ClinicCorrespondenceListSearchCriteriaVoBean()
	{
	}
	public ClinicCorrespondenceListSearchCriteriaVoBean(ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo vo)
	{
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getConsultant().getBean();
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo vo)
	{
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean(map);
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getConsultant().getBean(map);
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.ClinicCorrespondenceListSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.clinic = value;
	}
	public ims.core.vo.beans.MedicLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.framework.utils.beans.DateBean getClinicDate()
	{
		return this.clinicdate;
	}
	public void setClinicDate(ims.framework.utils.beans.DateBean value)
	{
		this.clinicdate = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}

	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.core.vo.beans.ClinicLiteVoBean clinic;
	private ims.core.vo.beans.MedicLiteVoBean consultant;
	private ims.framework.utils.beans.DateBean clinicdate;
	private ims.vo.LookupInstanceBean specialty;
}
