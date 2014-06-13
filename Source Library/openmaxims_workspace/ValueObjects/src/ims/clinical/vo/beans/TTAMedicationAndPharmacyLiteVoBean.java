//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.beans;

public class TTAMedicationAndPharmacyLiteVoBean extends ims.vo.ValueObjectBean
{
	public TTAMedicationAndPharmacyLiteVoBean()
	{
	}
	public TTAMedicationAndPharmacyLiteVoBean(ims.clinical.vo.TTAMedicationAndPharmacyLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean();
		this.bodyweightkg = vo.getBodyWeightKg();
		this.clinicalcommentstopharmacy = vo.getClinicalCommentsToPharmacy();
		this.orderingdatetime = vo.getOrderingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getOrderingDateTime().getBean();
		this.clinicianbleepno = vo.getClinicianBleepNo();
		this.currentttastatus = vo.getCurrentTTAStatus() == null ? null : (ims.clinical.vo.beans.TTAStatusVoBean)vo.getCurrentTTAStatus().getBean();
		this.datesubmittedtopharmacy = vo.getDateSubmittedToPharmacy() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSubmittedToPharmacy().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.TTAMedicationAndPharmacyLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean(map);
		this.bodyweightkg = vo.getBodyWeightKg();
		this.clinicalcommentstopharmacy = vo.getClinicalCommentsToPharmacy();
		this.orderingdatetime = vo.getOrderingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getOrderingDateTime().getBean();
		this.clinicianbleepno = vo.getClinicianBleepNo();
		this.currentttastatus = vo.getCurrentTTAStatus() == null ? null : (ims.clinical.vo.beans.TTAStatusVoBean)vo.getCurrentTTAStatus().getBean(map);
		this.datesubmittedtopharmacy = vo.getDateSubmittedToPharmacy() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSubmittedToPharmacy().getBean();
	}

	public ims.clinical.vo.TTAMedicationAndPharmacyLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.TTAMedicationAndPharmacyLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.TTAMedicationAndPharmacyLiteVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.TTAMedicationAndPharmacyLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.TTAMedicationAndPharmacyLiteVo();
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
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.CareContextLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextLiteVoBean value)
	{
		this.carecontext = value;
	}
	public Float getBodyWeightKg()
	{
		return this.bodyweightkg;
	}
	public void setBodyWeightKg(Float value)
	{
		this.bodyweightkg = value;
	}
	public String getClinicalCommentsToPharmacy()
	{
		return this.clinicalcommentstopharmacy;
	}
	public void setClinicalCommentsToPharmacy(String value)
	{
		this.clinicalcommentstopharmacy = value;
	}
	public ims.framework.utils.beans.DateTimeBean getOrderingDateTime()
	{
		return this.orderingdatetime;
	}
	public void setOrderingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.orderingdatetime = value;
	}
	public String getClinicianBleepNo()
	{
		return this.clinicianbleepno;
	}
	public void setClinicianBleepNo(String value)
	{
		this.clinicianbleepno = value;
	}
	public ims.clinical.vo.beans.TTAStatusVoBean getCurrentTTAStatus()
	{
		return this.currentttastatus;
	}
	public void setCurrentTTAStatus(ims.clinical.vo.beans.TTAStatusVoBean value)
	{
		this.currentttastatus = value;
	}
	public ims.framework.utils.beans.DateBean getDateSubmittedToPharmacy()
	{
		return this.datesubmittedtopharmacy;
	}
	public void setDateSubmittedToPharmacy(ims.framework.utils.beans.DateBean value)
	{
		this.datesubmittedtopharmacy = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.CareContextLiteVoBean carecontext;
	private Float bodyweightkg;
	private String clinicalcommentstopharmacy;
	private ims.framework.utils.beans.DateTimeBean orderingdatetime;
	private String clinicianbleepno;
	private ims.clinical.vo.beans.TTAStatusVoBean currentttastatus;
	private ims.framework.utils.beans.DateBean datesubmittedtopharmacy;
}