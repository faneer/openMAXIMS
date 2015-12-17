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

package ims.nursing.vo;

/**
 * Linked to nursing.assessment.Eating Oral Assessment business object (ID: 1012100031).
 */
public class OralAssessment extends ims.nursing.assessment.vo.EatingOralAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OralAssessment()
	{
	}
	public OralAssessment(Integer id, int version)
	{
		super(id, version);
	}
	public OralAssessment(ims.nursing.vo.beans.OralAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.oralassessment = bean.getOralAssessment() == null ? null : ims.coe.vo.lookups.OralAssessment.buildLookup(bean.getOralAssessment());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.OralAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.oralassessment = bean.getOralAssessment() == null ? null : ims.coe.vo.lookups.OralAssessment.buildLookup(bean.getOralAssessment());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.OralAssessmentBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.OralAssessmentBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.OralAssessmentBean();
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
		if(fieldName.equals("ORALASSESSMENT"))
			return getOralAssessment();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOralAssessmentIsNotNull()
	{
		return this.oralassessment != null;
	}
	public ims.coe.vo.lookups.OralAssessment getOralAssessment()
	{
		return this.oralassessment;
	}
	public void setOralAssessment(ims.coe.vo.lookups.OralAssessment value)
	{
		this.isValidated = false;
		this.oralassessment = value;
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
	
		OralAssessment clone = new OralAssessment(this.id, this.version);
		
		if(this.oralassessment == null)
			clone.oralassessment = null;
		else
			clone.oralassessment = (ims.coe.vo.lookups.OralAssessment)this.oralassessment.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.YesNoUnknown)this.status.clone();
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
		if (!(OralAssessment.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OralAssessment object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OralAssessment compareObj = (OralAssessment)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_EatingOralAssessment() == null && compareObj.getID_EatingOralAssessment() != null)
				return -1;
			if(this.getID_EatingOralAssessment() != null && compareObj.getID_EatingOralAssessment() == null)
				return 1;
			if(this.getID_EatingOralAssessment() != null && compareObj.getID_EatingOralAssessment() != null)
				retVal = this.getID_EatingOralAssessment().compareTo(compareObj.getID_EatingOralAssessment());
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
		if(this.oralassessment != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.coe.vo.lookups.OralAssessment oralassessment;
	protected ims.core.vo.lookups.YesNoUnknown status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
