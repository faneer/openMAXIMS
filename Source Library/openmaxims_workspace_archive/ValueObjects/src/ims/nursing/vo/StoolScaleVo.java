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

package ims.nursing.vo;

/**
 * Linked to core.clinical.Assessment business object (ID: 1003100002).
 */
public class StoolScaleVo extends ims.core.vo.AssessmentToolVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StoolScaleVo()
	{
	}
	public StoolScaleVo(Integer id, int version)
	{
		super(id, version);
	}
	public StoolScaleVo(ims.nursing.vo.beans.StoolScaleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo();
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.stooltype = bean.getStoolType() == null ? null : ims.nursing.vo.lookups.StoolType.buildLookup(bean.getStoolType());
		this.details = bean.getDetails();
		this.result = bean.getResult() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getResult());
		this.frequency = bean.getFrequency();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.StoolScaleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo(map);
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.stooltype = bean.getStoolType() == null ? null : ims.nursing.vo.lookups.StoolType.buildLookup(bean.getStoolType());
		this.details = bean.getDetails();
		this.result = bean.getResult() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getResult());
		this.frequency = bean.getFrequency();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.StoolScaleVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.StoolScaleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.StoolScaleVoBean();
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
		if(fieldName.equals("STOOLTYPE"))
			return getStoolType();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		if(fieldName.equals("RESULT"))
			return getResult();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStoolTypeIsNotNull()
	{
		return this.stooltype != null;
	}
	public ims.nursing.vo.lookups.StoolType getStoolType()
	{
		return this.stooltype;
	}
	public void setStoolType(ims.nursing.vo.lookups.StoolType value)
	{
		this.isValidated = false;
		this.stooltype = value;
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
	public boolean getResultIsNotNull()
	{
		return this.result != null;
	}
	public ims.core.vo.lookups.YesNo getResult()
	{
		return this.result;
	}
	public void setResult(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.result = value;
	}
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public String getFrequency()
	{
		return this.frequency;
	}
	public static int getFrequencyMaxLength()
	{
		return 255;
	}
	public void setFrequency(String value)
	{
		this.isValidated = false;
		this.frequency = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.countFieldsWithValue() < 3)
		{
			listOfErrors.add("A minimum of 3 data fields must be entered");
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
	
		StoolScaleVo clone = new StoolScaleVo(this.id, this.version);
		
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
		if(this.stooltype == null)
			clone.stooltype = null;
		else
			clone.stooltype = (ims.nursing.vo.lookups.StoolType)this.stooltype.clone();
		clone.details = this.details;
		if(this.result == null)
			clone.result = null;
		else
			clone.result = (ims.core.vo.lookups.YesNo)this.result.clone();
		clone.frequency = this.frequency;
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
		if (!(StoolScaleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StoolScaleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		StoolScaleVo compareObj = (StoolScaleVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDateTimeInitiated() == null && compareObj.getDateTimeInitiated() != null)
				return -1;
			if(this.getDateTimeInitiated() != null && compareObj.getDateTimeInitiated() == null)
				return 1;
			if(this.getDateTimeInitiated() != null && compareObj.getDateTimeInitiated() != null)
				retVal = this.getDateTimeInitiated().compareTo(compareObj.getDateTimeInitiated());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.stooltype != null)
			count++;
		if(this.details != null)
			count++;
		if(this.result != null)
			count++;
		if(this.frequency != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.nursing.vo.lookups.StoolType stooltype;
	protected String details;
	protected ims.core.vo.lookups.YesNo result;
	protected String frequency;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
