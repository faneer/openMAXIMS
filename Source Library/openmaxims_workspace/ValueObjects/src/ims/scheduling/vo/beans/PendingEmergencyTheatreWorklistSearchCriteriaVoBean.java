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

public class PendingEmergencyTheatreWorklistSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PendingEmergencyTheatreWorklistSearchCriteriaVoBean()
	{
	}
	public PendingEmergencyTheatreWorklistSearchCriteriaVoBean(ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo vo)
	{
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleHCP().getBean();
		this.urgencycategory = vo.getUrgencyCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgencyCategory().getBean();
		this.inpatientsonly = vo.getInpatientsOnly();
		this.notcurrentlyaninpatient = vo.getNotCurrentlyAnInpatient();
		this.expectedhospital = vo.getExpectedHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getExpectedHospital().getBean();
		this.expectedward = vo.getExpectedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getExpectedWard().getBean();
		this.expecteddate = vo.getExpectedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDate().getBean();
		this.excludeendoscopyprocedures = vo.getExcludeEndoscopyProcedures();
		this.listonlyendoscopyprocedures = vo.getListOnlyEndoscopyProcedures();
		this.services = vo.getServices() == null ? null : vo.getServices().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo vo)
	{
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleHCP().getBean(map);
		this.urgencycategory = vo.getUrgencyCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgencyCategory().getBean();
		this.inpatientsonly = vo.getInpatientsOnly();
		this.notcurrentlyaninpatient = vo.getNotCurrentlyAnInpatient();
		this.expectedhospital = vo.getExpectedHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getExpectedHospital().getBean(map);
		this.expectedward = vo.getExpectedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getExpectedWard().getBean(map);
		this.expecteddate = vo.getExpectedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDate().getBean();
		this.excludeendoscopyprocedures = vo.getExcludeEndoscopyProcedures();
		this.listonlyendoscopyprocedures = vo.getListOnlyEndoscopyProcedures();
		this.services = vo.getServices() == null ? null : vo.getServices().getBeanCollection();
	}

	public ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.PendingEmergencyTheatreWorklistSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.HcpBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.LookupInstanceBean getUrgencyCategory()
	{
		return this.urgencycategory;
	}
	public void setUrgencyCategory(ims.vo.LookupInstanceBean value)
	{
		this.urgencycategory = value;
	}
	public Boolean getInpatientsOnly()
	{
		return this.inpatientsonly;
	}
	public void setInpatientsOnly(Boolean value)
	{
		this.inpatientsonly = value;
	}
	public Boolean getNotCurrentlyAnInpatient()
	{
		return this.notcurrentlyaninpatient;
	}
	public void setNotCurrentlyAnInpatient(Boolean value)
	{
		this.notcurrentlyaninpatient = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getExpectedHospital()
	{
		return this.expectedhospital;
	}
	public void setExpectedHospital(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.expectedhospital = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getExpectedWard()
	{
		return this.expectedward;
	}
	public void setExpectedWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.expectedward = value;
	}
	public ims.framework.utils.beans.DateBean getExpectedDate()
	{
		return this.expecteddate;
	}
	public void setExpectedDate(ims.framework.utils.beans.DateBean value)
	{
		this.expecteddate = value;
	}
	public Boolean getExcludeEndoscopyProcedures()
	{
		return this.excludeendoscopyprocedures;
	}
	public void setExcludeEndoscopyProcedures(Boolean value)
	{
		this.excludeendoscopyprocedures = value;
	}
	public Boolean getListOnlyEndoscopyProcedures()
	{
		return this.listonlyendoscopyprocedures;
	}
	public void setListOnlyEndoscopyProcedures(Boolean value)
	{
		this.listonlyendoscopyprocedures = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean[] getServices()
	{
		return this.services;
	}
	public void setServices(ims.core.vo.beans.ServiceShortVoBean[] value)
	{
		this.services = value;
	}

	private ims.core.vo.beans.HcpBean responsiblehcp;
	private ims.vo.LookupInstanceBean urgencycategory;
	private Boolean inpatientsonly;
	private Boolean notcurrentlyaninpatient;
	private ims.core.vo.beans.LocationLiteVoBean expectedhospital;
	private ims.core.vo.beans.LocationLiteVoBean expectedward;
	private ims.framework.utils.beans.DateBean expecteddate;
	private Boolean excludeendoscopyprocedures;
	private Boolean listonlyendoscopyprocedures;
	private ims.core.vo.beans.ServiceShortVoBean[] services;
}