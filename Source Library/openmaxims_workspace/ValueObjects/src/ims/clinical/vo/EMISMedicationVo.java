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

package ims.clinical.vo;


public class EMISMedicationVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISMedicationVo()
	{
	}
	public EMISMedicationVo(ims.clinical.vo.beans.EMISMedicationVoBean bean)
	{
		this.drugrecord = bean.getDrugRecord();
		this.mostrecentissuedate = bean.getMostRecentIssueDate();
		this.prescriptiontype = bean.getPrescriptionType();
		this.drugname = bean.getDrugName();
		this.originalterm = bean.getOriginalTerm();
		this.dosage = bean.getDosage();
		this.quantityrepresentation = bean.getQuantityRepresentation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISMedicationVoBean bean)
	{
		this.drugrecord = bean.getDrugRecord();
		this.mostrecentissuedate = bean.getMostRecentIssueDate();
		this.prescriptiontype = bean.getPrescriptionType();
		this.drugname = bean.getDrugName();
		this.originalterm = bean.getOriginalTerm();
		this.dosage = bean.getDosage();
		this.quantityrepresentation = bean.getQuantityRepresentation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISMedicationVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISMedicationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISMedicationVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getDrugRecordIsNotNull()
	{
		return this.drugrecord != null;
	}
	public String getDrugRecord()
	{
		return this.drugrecord;
	}
	public static int getDrugRecordMaxLength()
	{
		return 255;
	}
	public void setDrugRecord(String value)
	{
		this.isValidated = false;
		this.drugrecord = value;
	}
	public boolean getMostRecentIssueDateIsNotNull()
	{
		return this.mostrecentissuedate != null;
	}
	public String getMostRecentIssueDate()
	{
		return this.mostrecentissuedate;
	}
	public static int getMostRecentIssueDateMaxLength()
	{
		return 255;
	}
	public void setMostRecentIssueDate(String value)
	{
		this.isValidated = false;
		this.mostrecentissuedate = value;
	}
	public boolean getPrescriptionTypeIsNotNull()
	{
		return this.prescriptiontype != null;
	}
	public String getPrescriptionType()
	{
		return this.prescriptiontype;
	}
	public static int getPrescriptionTypeMaxLength()
	{
		return 255;
	}
	public void setPrescriptionType(String value)
	{
		this.isValidated = false;
		this.prescriptiontype = value;
	}
	public boolean getDrugNameIsNotNull()
	{
		return this.drugname != null;
	}
	public String getDrugName()
	{
		return this.drugname;
	}
	public static int getDrugNameMaxLength()
	{
		return 255;
	}
	public void setDrugName(String value)
	{
		this.isValidated = false;
		this.drugname = value;
	}
	public boolean getOriginalTermIsNotNull()
	{
		return this.originalterm != null;
	}
	public String getOriginalTerm()
	{
		return this.originalterm;
	}
	public static int getOriginalTermMaxLength()
	{
		return 255;
	}
	public void setOriginalTerm(String value)
	{
		this.isValidated = false;
		this.originalterm = value;
	}
	public boolean getDosageIsNotNull()
	{
		return this.dosage != null;
	}
	public String getDosage()
	{
		return this.dosage;
	}
	public static int getDosageMaxLength()
	{
		return 255;
	}
	public void setDosage(String value)
	{
		this.isValidated = false;
		this.dosage = value;
	}
	public boolean getQuantityRepresentationIsNotNull()
	{
		return this.quantityrepresentation != null;
	}
	public String getQuantityRepresentation()
	{
		return this.quantityrepresentation;
	}
	public static int getQuantityRepresentationMaxLength()
	{
		return 255;
	}
	public void setQuantityRepresentation(String value)
	{
		this.isValidated = false;
		this.quantityrepresentation = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof EMISMedicationVo))
			return false;
		EMISMedicationVo compareObj = (EMISMedicationVo)obj;
		if(this.getDrugRecord() == null && compareObj.getDrugRecord() != null)
			return false;
		if(this.getDrugRecord() != null && compareObj.getDrugRecord() == null)
			return false;
		if(this.getDrugRecord() != null && compareObj.getDrugRecord() != null)
			return this.getDrugRecord().equals(compareObj.getDrugRecord());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		EMISMedicationVo clone = new EMISMedicationVo();
		
		clone.drugrecord = this.drugrecord;
		clone.mostrecentissuedate = this.mostrecentissuedate;
		clone.prescriptiontype = this.prescriptiontype;
		clone.drugname = this.drugname;
		clone.originalterm = this.originalterm;
		clone.dosage = this.dosage;
		clone.quantityrepresentation = this.quantityrepresentation;
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
		if (!(EMISMedicationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISMedicationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISMedicationVo compareObj = (EMISMedicationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDrugRecord() == null && compareObj.getDrugRecord() != null)
				return -1;
			if(this.getDrugRecord() != null && compareObj.getDrugRecord() == null)
				return 1;
			if(this.getDrugRecord() != null && compareObj.getDrugRecord() != null)
			{
				if(caseInsensitive)
					retVal = this.getDrugRecord().toLowerCase().compareTo(compareObj.getDrugRecord().toLowerCase());
				else
					retVal = this.getDrugRecord().compareTo(compareObj.getDrugRecord());
			}
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
		if(this.drugrecord != null)
			count++;
		if(this.mostrecentissuedate != null)
			count++;
		if(this.prescriptiontype != null)
			count++;
		if(this.drugname != null)
			count++;
		if(this.originalterm != null)
			count++;
		if(this.dosage != null)
			count++;
		if(this.quantityrepresentation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String drugrecord;
	protected String mostrecentissuedate;
	protected String prescriptiontype;
	protected String drugname;
	protected String originalterm;
	protected String dosage;
	protected String quantityrepresentation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
