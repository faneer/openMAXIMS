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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OcsOrderSession business object (ID: 1070100000).
 */
public class NewResultsSearchOrderSessionVo extends ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewResultsSearchOrderSessionVo()
	{
	}
	public NewResultsSearchOrderSessionVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewResultsSearchOrderSessionVo(ims.ocrr.vo.beans.NewResultsSearchOrderSessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo();
		this.responsiblegp = bean.getResponsibleGp() == null ? null : bean.getResponsibleGp().buildVo();
		this.patientlocation = bean.getPatientLocation() == null ? null : bean.getPatientLocation().buildVo();
		this.patientclinic = bean.getPatientClinic() == null ? null : bean.getPatientClinic().buildVo();
		this.outpatientdept = bean.getOutpatientDept() == null ? null : bean.getOutpatientDept().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NewResultsSearchOrderSessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo(map);
		this.responsiblegp = bean.getResponsibleGp() == null ? null : bean.getResponsibleGp().buildVo(map);
		this.patientlocation = bean.getPatientLocation() == null ? null : bean.getPatientLocation().buildVo(map);
		this.patientclinic = bean.getPatientClinic() == null ? null : bean.getPatientClinic().buildVo(map);
		this.outpatientdept = bean.getOutpatientDept() == null ? null : bean.getOutpatientDept().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NewResultsSearchOrderSessionVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NewResultsSearchOrderSessionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NewResultsSearchOrderSessionVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("RESPONSIBLECLINICIAN"))
			return getResponsibleClinician();
		if(fieldName.equals("RESPONSIBLEGP"))
			return getResponsibleGp();
		if(fieldName.equals("PATIENTLOCATION"))
			return getPatientLocation();
		if(fieldName.equals("PATIENTCLINIC"))
			return getPatientClinic();
		if(fieldName.equals("OUTPATIENTDEPT"))
			return getOutpatientDept();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getResponsibleClinicianIsNotNull()
	{
		return this.responsibleclinician != null;
	}
	public ims.core.vo.HcpMinVo getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.HcpMinVo value)
	{
		this.isValidated = false;
		this.responsibleclinician = value;
	}
	public boolean getResponsibleGpIsNotNull()
	{
		return this.responsiblegp != null;
	}
	public ims.core.vo.GpMinVo getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.core.vo.GpMinVo value)
	{
		this.isValidated = false;
		this.responsiblegp = value;
	}
	public boolean getPatientLocationIsNotNull()
	{
		return this.patientlocation != null;
	}
	public ims.core.vo.LocationMinVo getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.LocationMinVo value)
	{
		this.isValidated = false;
		this.patientlocation = value;
	}
	public boolean getPatientClinicIsNotNull()
	{
		return this.patientclinic != null;
	}
	public ims.core.vo.ClinicMinVo getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.core.vo.ClinicMinVo value)
	{
		this.isValidated = false;
		this.patientclinic = value;
	}
	public boolean getOutpatientDeptIsNotNull()
	{
		return this.outpatientdept != null;
	}
	public ims.core.vo.LocationMinVo getOutpatientDept()
	{
		return this.outpatientdept;
	}
	public void setOutpatientDept(ims.core.vo.LocationMinVo value)
	{
		this.isValidated = false;
		this.outpatientdept = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		NewResultsSearchOrderSessionVo clone = new NewResultsSearchOrderSessionVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.responsibleclinician == null)
			clone.responsibleclinician = null;
		else
			clone.responsibleclinician = (ims.core.vo.HcpMinVo)this.responsibleclinician.clone();
		if(this.responsiblegp == null)
			clone.responsiblegp = null;
		else
			clone.responsiblegp = (ims.core.vo.GpMinVo)this.responsiblegp.clone();
		if(this.patientlocation == null)
			clone.patientlocation = null;
		else
			clone.patientlocation = (ims.core.vo.LocationMinVo)this.patientlocation.clone();
		if(this.patientclinic == null)
			clone.patientclinic = null;
		else
			clone.patientclinic = (ims.core.vo.ClinicMinVo)this.patientclinic.clone();
		if(this.outpatientdept == null)
			clone.outpatientdept = null;
		else
			clone.outpatientdept = (ims.core.vo.LocationMinVo)this.outpatientdept.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(NewResultsSearchOrderSessionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewResultsSearchOrderSessionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewResultsSearchOrderSessionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewResultsSearchOrderSessionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.responsibleclinician != null)
			count++;
		if(this.responsiblegp != null)
			count++;
		if(this.patientlocation != null)
			count++;
		if(this.patientclinic != null)
			count++;
		if(this.outpatientdept != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.core.vo.HcpMinVo responsibleclinician;
	protected ims.core.vo.GpMinVo responsiblegp;
	protected ims.core.vo.LocationMinVo patientlocation;
	protected ims.core.vo.ClinicMinVo patientclinic;
	protected ims.core.vo.LocationMinVo outpatientdept;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
