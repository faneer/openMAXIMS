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

package ims.correspondence.vo;

/**
 * Linked to correspondence.configuration.TemplateAssociations business object (ID: 1053100000).
 */
public class TemplateAssociationsVo extends ims.correspondence.configuration.vo.TemplateAssociationsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TemplateAssociationsVo()
	{
	}
	public TemplateAssociationsVo(Integer id, int version)
	{
		super(id, version);
	}
	public TemplateAssociationsVo(ims.correspondence.vo.beans.TemplateAssociationsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getTemplate().getId()), bean.getTemplate().getVersion());
		this.clinics = ims.core.vo.ClinicLiteVoCollection.buildFromBeanCollection(bean.getClinics());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.consultants = ims.core.vo.MedicLiteVoCollection.buildFromBeanCollection(bean.getConsultants());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.TemplateAssociationsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getTemplate().getId()), bean.getTemplate().getVersion());
		this.clinics = ims.core.vo.ClinicLiteVoCollection.buildFromBeanCollection(bean.getClinics());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.consultants = ims.core.vo.MedicLiteVoCollection.buildFromBeanCollection(bean.getConsultants());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.TemplateAssociationsVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.TemplateAssociationsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.TemplateAssociationsVoBean();
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
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		if(fieldName.equals("CLINICS"))
			return getClinics();
		if(fieldName.equals("SPECIALTIES"))
			return getSpecialties();
		if(fieldName.equals("CONSULTANTS"))
			return getConsultants();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.core.admin.vo.TemplateBoRefVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.core.admin.vo.TemplateBoRefVo value)
	{
		this.isValidated = false;
		this.template = value;
	}
	public boolean getClinicsIsNotNull()
	{
		return this.clinics != null;
	}
	public ims.core.vo.ClinicLiteVoCollection getClinics()
	{
		return this.clinics;
	}
	public void setClinics(ims.core.vo.ClinicLiteVoCollection value)
	{
		this.isValidated = false;
		this.clinics = value;
	}
	public boolean getSpecialtiesIsNotNull()
	{
		return this.specialties != null;
	}
	public ims.core.vo.lookups.SpecialtyCollection getSpecialties()
	{
		return this.specialties;
	}
	public void setSpecialties(ims.core.vo.lookups.SpecialtyCollection value)
	{
		this.isValidated = false;
		this.specialties = value;
	}
	public boolean getConsultantsIsNotNull()
	{
		return this.consultants != null;
	}
	public ims.core.vo.MedicLiteVoCollection getConsultants()
	{
		return this.consultants;
	}
	public void setConsultants(ims.core.vo.MedicLiteVoCollection value)
	{
		this.isValidated = false;
		this.consultants = value;
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
		if(this.clinics != null)
		{
			if(!this.clinics.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultants != null)
		{
			if(!this.consultants.isValidated())
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
		if(this.template == null)
			listOfErrors.add("template is mandatory");
		if(this.clinics != null)
		{
			String[] listOfOtherErrors = this.clinics.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultants != null)
		{
			String[] listOfOtherErrors = this.consultants.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		TemplateAssociationsVo clone = new TemplateAssociationsVo(this.id, this.version);
		
		clone.template = this.template;
		if(this.clinics == null)
			clone.clinics = null;
		else
			clone.clinics = (ims.core.vo.ClinicLiteVoCollection)this.clinics.clone();
		if(this.specialties == null)
			clone.specialties = null;
		else
			clone.specialties = (ims.core.vo.lookups.SpecialtyCollection)this.specialties.clone();
		if(this.consultants == null)
			clone.consultants = null;
		else
			clone.consultants = (ims.core.vo.MedicLiteVoCollection)this.consultants.clone();
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
		if (!(TemplateAssociationsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TemplateAssociationsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TemplateAssociationsVo compareObj = (TemplateAssociationsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_TemplateAssociations() == null && compareObj.getID_TemplateAssociations() != null)
				return -1;
			if(this.getID_TemplateAssociations() != null && compareObj.getID_TemplateAssociations() == null)
				return 1;
			if(this.getID_TemplateAssociations() != null && compareObj.getID_TemplateAssociations() != null)
				retVal = this.getID_TemplateAssociations().compareTo(compareObj.getID_TemplateAssociations());
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
		if(this.template != null)
			count++;
		if(this.clinics != null)
			count++;
		if(this.specialties != null)
			count++;
		if(this.consultants != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.admin.vo.TemplateBoRefVo template;
	protected ims.core.vo.ClinicLiteVoCollection clinics;
	protected ims.core.vo.lookups.SpecialtyCollection specialties;
	protected ims.core.vo.MedicLiteVoCollection consultants;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
