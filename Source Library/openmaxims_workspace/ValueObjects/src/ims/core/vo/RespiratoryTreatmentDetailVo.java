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
 * Linked to core.clinical.RespiratoryTreatmentDetail business object (ID: 1019100102).
 */
public class RespiratoryTreatmentDetailVo extends ims.core.clinical.vo.RespiratoryTreatmentDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RespiratoryTreatmentDetailVo()
	{
	}
	public RespiratoryTreatmentDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public RespiratoryTreatmentDetailVo(ims.core.vo.beans.RespiratoryTreatmentDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatment = bean.getTreatment() == null ? null : ims.spinalinjuries.vo.lookups.RespiratoryTreatment.buildLookup(bean.getTreatment());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.details = bean.getDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.RespiratoryTreatmentDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatment = bean.getTreatment() == null ? null : ims.spinalinjuries.vo.lookups.RespiratoryTreatment.buildLookup(bean.getTreatment());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.details = bean.getDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.RespiratoryTreatmentDetailVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.RespiratoryTreatmentDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.RespiratoryTreatmentDetailVoBean();
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
		if(fieldName.equals("TREATMENT"))
			return getTreatment();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentIsNotNull()
	{
		return this.treatment != null;
	}
	public ims.spinalinjuries.vo.lookups.RespiratoryTreatment getTreatment()
	{
		return this.treatment;
	}
	public void setTreatment(ims.spinalinjuries.vo.lookups.RespiratoryTreatment value)
	{
		this.isValidated = false;
		this.treatment = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
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
		if(this.treatment == null)
			listOfErrors.add("Treatment is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is a mandatory field");
		if(this.details != null)
			if(this.details.length() > 255)
				listOfErrors.add("The length of the field [details] in the value object [ims.core.vo.RespiratoryTreatmentDetailVo] is too big. It should be less or equal to 255");
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
	
		RespiratoryTreatmentDetailVo clone = new RespiratoryTreatmentDetailVo(this.id, this.version);
		
		if(this.treatment == null)
			clone.treatment = null;
		else
			clone.treatment = (ims.spinalinjuries.vo.lookups.RespiratoryTreatment)this.treatment.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.YesNoUnknown)this.status.clone();
		clone.details = this.details;
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
		if (!(RespiratoryTreatmentDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RespiratoryTreatmentDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		RespiratoryTreatmentDetailVo compareObj = (RespiratoryTreatmentDetailVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTreatment() == null && compareObj.getTreatment() != null)
				return -1;
			if(this.getTreatment() != null && compareObj.getTreatment() == null)
				return 1;
			if(this.getTreatment() != null && compareObj.getTreatment() != null)
				retVal = this.getTreatment().compareTo(compareObj.getTreatment());
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
		if(this.treatment != null)
			count++;
		if(this.status != null)
			count++;
		if(this.details != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.RespiratoryTreatment treatment;
	protected ims.core.vo.lookups.YesNoUnknown status;
	protected String details;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
