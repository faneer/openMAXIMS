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

package ims.coe.vo;

/**
 * Linked to core.clinical.Assessment business object (ID: 1003100002).
 */
public class InfectionControlRepeatableAssessmentVo extends ims.core.vo.AssessmentToolVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InfectionControlRepeatableAssessmentVo()
	{
	}
	public InfectionControlRepeatableAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public InfectionControlRepeatableAssessmentVo(ims.coe.vo.beans.InfectionControlRepeatableAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo();
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.infectioncontroldetails = ims.coe.vo.InfectionControlDetailsVoCollection.buildFromBeanCollection(bean.getInfectionControlDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.InfectionControlRepeatableAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo(map);
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.infectioncontroldetails = ims.coe.vo.InfectionControlDetailsVoCollection.buildFromBeanCollection(bean.getInfectionControlDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.InfectionControlRepeatableAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.InfectionControlRepeatableAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.InfectionControlRepeatableAssessmentVoBean();
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
		if(fieldName.equals("INFECTIONCONTROLDETAILS"))
			return getInfectionControlDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInfectionControlDetailsIsNotNull()
	{
		return this.infectioncontroldetails != null;
	}
	public ims.coe.vo.InfectionControlDetailsVoCollection getInfectionControlDetails()
	{
		return this.infectioncontroldetails;
	}
	public void setInfectionControlDetails(ims.coe.vo.InfectionControlDetailsVoCollection value)
	{
		this.isValidated = false;
		this.infectioncontroldetails = value;
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
		if(this.infectioncontroldetails != null)
		{
			if(!this.infectioncontroldetails.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.infectioncontroldetails == null || this.infectioncontroldetails.size() == 0)
			listOfErrors.add("InfectionControlDetails are mandatory");
		if(this.infectioncontroldetails != null)
		{
			String[] listOfOtherErrors = this.infectioncontroldetails.validate();
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
	
		InfectionControlRepeatableAssessmentVo clone = new InfectionControlRepeatableAssessmentVo(this.id, this.version);
		
		if(this.hcpinitiated == null)
			clone.hcpinitiated = null;
		else
			clone.hcpinitiated = (ims.core.vo.HcpLiteVo)this.hcpinitiated.clone();
		if(this.datetimeinitiated == null)
			clone.datetimeinitiated = null;
		else
			clone.datetimeinitiated = (ims.framework.utils.DateTime)this.datetimeinitiated.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.infectioncontroldetails == null)
			clone.infectioncontroldetails = null;
		else
			clone.infectioncontroldetails = (ims.coe.vo.InfectionControlDetailsVoCollection)this.infectioncontroldetails.clone();
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
		if (!(InfectionControlRepeatableAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InfectionControlRepeatableAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InfectionControlRepeatableAssessmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InfectionControlRepeatableAssessmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.infectioncontroldetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.coe.vo.InfectionControlDetailsVoCollection infectioncontroldetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
