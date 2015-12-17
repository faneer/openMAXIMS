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

package ims.RefMan.vo;

/**
 * Linked to RefMan.ConsultationOutcome business object (ID: 1096100028).
 */
public class ConsultationOutcomeVo extends ims.RefMan.vo.ConsultationOutcomeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ConsultationOutcomeVo()
	{
	}
	public ConsultationOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConsultationOutcomeVo(ims.RefMan.vo.beans.ConsultationOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.furthermanagement = bean.getFurtherManagement();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargetype = bean.getDischargeType() == null ? null : ims.RefMan.vo.lookups.ConsultationOutcomeType.buildLookup(bean.getDischargeType());
		this.followuptype = bean.getFollowupType() == null ? null : ims.RefMan.vo.lookups.FollowupManagementType.buildLookup(bean.getFollowupType());
		this.dischargemethod = bean.getDischargeMethod() == null ? null : ims.core.vo.lookups.DischargeMethod.buildLookup(bean.getDischargeMethod());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ConsultationOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.furthermanagement = bean.getFurtherManagement();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargetype = bean.getDischargeType() == null ? null : ims.RefMan.vo.lookups.ConsultationOutcomeType.buildLookup(bean.getDischargeType());
		this.followuptype = bean.getFollowupType() == null ? null : ims.RefMan.vo.lookups.FollowupManagementType.buildLookup(bean.getFollowupType());
		this.dischargemethod = bean.getDischargeMethod() == null ? null : ims.core.vo.lookups.DischargeMethod.buildLookup(bean.getDischargeMethod());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ConsultationOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ConsultationOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ConsultationOutcomeVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("FURTHERMANAGEMENT"))
			return getFurtherManagement();
		if(fieldName.equals("DISCHARGEDATE"))
			return getDischargeDate();
		if(fieldName.equals("DISCHARGETYPE"))
			return getDischargeType();
		if(fieldName.equals("FOLLOWUPTYPE"))
			return getFollowupType();
		if(fieldName.equals("DISCHARGEMETHOD"))
			return getDischargeMethod();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getFurtherManagementIsNotNull()
	{
		return this.furthermanagement != null;
	}
	public String getFurtherManagement()
	{
		return this.furthermanagement;
	}
	public static int getFurtherManagementMaxLength()
	{
		return 3000;
	}
	public void setFurtherManagement(String value)
	{
		this.isValidated = false;
		this.furthermanagement = value;
	}
	public boolean getDischargeDateIsNotNull()
	{
		return this.dischargedate != null;
	}
	public ims.framework.utils.Date getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargedate = value;
	}
	public boolean getDischargeTypeIsNotNull()
	{
		return this.dischargetype != null;
	}
	public ims.RefMan.vo.lookups.ConsultationOutcomeType getDischargeType()
	{
		return this.dischargetype;
	}
	public void setDischargeType(ims.RefMan.vo.lookups.ConsultationOutcomeType value)
	{
		this.isValidated = false;
		this.dischargetype = value;
	}
	public boolean getFollowupTypeIsNotNull()
	{
		return this.followuptype != null;
	}
	public ims.RefMan.vo.lookups.FollowupManagementType getFollowupType()
	{
		return this.followuptype;
	}
	public void setFollowupType(ims.RefMan.vo.lookups.FollowupManagementType value)
	{
		this.isValidated = false;
		this.followuptype = value;
	}
	public boolean getDischargeMethodIsNotNull()
	{
		return this.dischargemethod != null;
	}
	public ims.core.vo.lookups.DischargeMethod getDischargeMethod()
	{
		return this.dischargemethod;
	}
	public void setDischargeMethod(ims.core.vo.lookups.DischargeMethod value)
	{
		this.isValidated = false;
		this.dischargemethod = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.furthermanagement != null)
			if(this.furthermanagement.length() > 3000)
				listOfErrors.add("The length of the field [furthermanagement] in the value object [ims.RefMan.vo.ConsultationOutcomeVo] is too big. It should be less or equal to 3000");
		if(this.dischargedate == null)
			listOfErrors.add("DischargeDate is mandatory");
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
	
		ConsultationOutcomeVo clone = new ConsultationOutcomeVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.patient = this.patient;
		clone.carecontext = this.carecontext;
		clone.furthermanagement = this.furthermanagement;
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.Date)this.dischargedate.clone();
		if(this.dischargetype == null)
			clone.dischargetype = null;
		else
			clone.dischargetype = (ims.RefMan.vo.lookups.ConsultationOutcomeType)this.dischargetype.clone();
		if(this.followuptype == null)
			clone.followuptype = null;
		else
			clone.followuptype = (ims.RefMan.vo.lookups.FollowupManagementType)this.followuptype.clone();
		if(this.dischargemethod == null)
			clone.dischargemethod = null;
		else
			clone.dischargemethod = (ims.core.vo.lookups.DischargeMethod)this.dischargemethod.clone();
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
		if (!(ConsultationOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConsultationOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ConsultationOutcomeVo compareObj = (ConsultationOutcomeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDischargeDate() == null && compareObj.getDischargeDate() != null)
				return -1;
			if(this.getDischargeDate() != null && compareObj.getDischargeDate() == null)
				return 1;
			if(this.getDischargeDate() != null && compareObj.getDischargeDate() != null)
				retVal = this.getDischargeDate().compareTo(compareObj.getDischargeDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.furthermanagement != null)
			count++;
		if(this.dischargedate != null)
			count++;
		if(this.dischargetype != null)
			count++;
		if(this.followuptype != null)
			count++;
		if(this.dischargemethod != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected String furthermanagement;
	protected ims.framework.utils.Date dischargedate;
	protected ims.RefMan.vo.lookups.ConsultationOutcomeType dischargetype;
	protected ims.RefMan.vo.lookups.FollowupManagementType followuptype;
	protected ims.core.vo.lookups.DischargeMethod dischargemethod;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
