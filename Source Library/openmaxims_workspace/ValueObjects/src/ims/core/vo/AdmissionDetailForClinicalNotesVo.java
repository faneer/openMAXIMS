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

package ims.core.vo;

/**
 * Linked to core.admin.pas.AdmissionDetail business object (ID: 1014100008).
 */
public class AdmissionDetailForClinicalNotesVo extends ims.core.admin.pas.vo.AdmissionDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailForClinicalNotesVo()
	{
	}
	public AdmissionDetailForClinicalNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdmissionDetailForClinicalNotesVo(ims.core.vo.beans.AdmissionDetailForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AdmissionDetailForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AdmissionDetailForClinicalNotesVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AdmissionDetailForClinicalNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AdmissionDetailForClinicalNotesVoBean();
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
		if(fieldName.equals("ADMISSIONDATETIME"))
			return getAdmissionDateTime();
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("ESTDISCHARGEDATE"))
			return getEstDischargeDate();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAdmissionDateTimeIsNotNull()
	{
		return this.admissiondatetime != null;
	}
	public ims.framework.utils.DateTime getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.admissiondatetime = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getEstDischargeDateIsNotNull()
	{
		return this.estdischargedate != null;
	}
	public ims.framework.utils.DateTime getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.estdischargedate = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.admin.pas.vo.PASEventRefVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.admin.pas.vo.PASEventRefVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.MedicLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.MedicLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
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
	
		AdmissionDetailForClinicalNotesVo clone = new AdmissionDetailForClinicalNotesVo(this.id, this.version);
		
		if(this.admissiondatetime == null)
			clone.admissiondatetime = null;
		else
			clone.admissiondatetime = (ims.framework.utils.DateTime)this.admissiondatetime.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.estdischargedate == null)
			clone.estdischargedate = null;
		else
			clone.estdischargedate = (ims.framework.utils.DateTime)this.estdischargedate.clone();
		clone.pasevent = this.pasevent;
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.MedicLiteVo)this.consultant.clone();
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
		if (!(AdmissionDetailForClinicalNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmissionDetailForClinicalNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdmissionDetailForClinicalNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdmissionDetailForClinicalNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.admissiondatetime != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.estdischargedate != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.consultant != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.DateTime admissiondatetime;
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.framework.utils.DateTime estdischargedate;
	protected ims.core.admin.pas.vo.PASEventRefVo pasevent;
	protected ims.core.vo.MedicLiteVo consultant;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
