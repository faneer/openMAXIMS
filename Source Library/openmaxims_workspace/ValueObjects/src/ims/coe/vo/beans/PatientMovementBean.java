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

package ims.coe.vo.beans;

public class PatientMovementBean extends ims.vo.ValueObjectBean
{
	public PatientMovementBean()
	{
	}
	public PatientMovementBean(ims.coe.vo.PatientMovement vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpInitiated().getBean();
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.tempfield = vo.getTempField();
		this.patientmovementdetails = vo.getPatientMovementDetails() == null ? null : vo.getPatientMovementDetails().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.PatientMovement vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpInitiated().getBean(map);
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.tempfield = vo.getTempField();
		this.patientmovementdetails = vo.getPatientMovementDetails() == null ? null : vo.getPatientMovementDetails().getBeanCollection();
	}

	public ims.coe.vo.PatientMovement buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.PatientMovement buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.PatientMovement vo = null;
		if(map != null)
			vo = (ims.coe.vo.PatientMovement)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.PatientMovement();
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
	public ims.core.vo.beans.HcpLiteVoBean getHcpInitiated()
	{
		return this.hcpinitiated;
	}
	public void setHcpInitiated(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcpinitiated = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeInitiated()
	{
		return this.datetimeinitiated;
	}
	public void setDateTimeInitiated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeinitiated = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public String getTempField()
	{
		return this.tempfield;
	}
	public void setTempField(String value)
	{
		this.tempfield = value;
	}
	public ims.coe.vo.beans.PatientMovementDetailsBean[] getPatientMovementDetails()
	{
		return this.patientmovementdetails;
	}
	public void setPatientMovementDetails(ims.coe.vo.beans.PatientMovementDetailsBean[] value)
	{
		this.patientmovementdetails = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean hcpinitiated;
	private ims.framework.utils.beans.DateTimeBean datetimeinitiated;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private String tempfield;
	private ims.coe.vo.beans.PatientMovementDetailsBean[] patientmovementdetails;
}
