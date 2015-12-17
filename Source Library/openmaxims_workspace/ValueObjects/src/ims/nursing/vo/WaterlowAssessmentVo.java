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
 * Linked to core.clinical.Assessment business object (ID: 1003100002).
 */
public class WaterlowAssessmentVo extends ims.core.vo.AssessmentToolVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WaterlowAssessmentVo()
	{
	}
	public WaterlowAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public WaterlowAssessmentVo(ims.nursing.vo.beans.WaterlowAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo();
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.assessmentdetails = ims.nursing.vo.WaterlowAssessmentDetailsVoCollection.buildFromBeanCollection(bean.getAssessmentDetails());
		this.comment = bean.getComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.WaterlowAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo(map);
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.assessmentdetails = ims.nursing.vo.WaterlowAssessmentDetailsVoCollection.buildFromBeanCollection(bean.getAssessmentDetails());
		this.comment = bean.getComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.WaterlowAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.WaterlowAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.WaterlowAssessmentVoBean();
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
		if(fieldName.equals("ASSESSMENTDETAILS"))
			return getAssessmentDetails();
		if(fieldName.equals("COMMENT"))
			return getComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssessmentDetailsIsNotNull()
	{
		return this.assessmentdetails != null;
	}
	public ims.nursing.vo.WaterlowAssessmentDetailsVoCollection getAssessmentDetails()
	{
		return this.assessmentdetails;
	}
	public void setAssessmentDetails(ims.nursing.vo.WaterlowAssessmentDetailsVoCollection value)
	{
		this.isValidated = false;
		this.assessmentdetails = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 250;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
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
		if(this.assessmentdetails != null)
		{
			if(!this.assessmentdetails.isValidated())
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
		if(this.assessmentdetails != null)
		{
			String[] listOfOtherErrors = this.assessmentdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comment != null)
			if(this.comment.length() > 250)
				listOfErrors.add("The length of the field [comment] in the value object [ims.nursing.vo.WaterlowAssessmentVo] is too big. It should be less or equal to 250");
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
	
		WaterlowAssessmentVo clone = new WaterlowAssessmentVo(this.id, this.version);
		
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
		if(this.assessmentdetails == null)
			clone.assessmentdetails = null;
		else
			clone.assessmentdetails = (ims.nursing.vo.WaterlowAssessmentDetailsVoCollection)this.assessmentdetails.clone();
		clone.comment = this.comment;
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
		if (!(WaterlowAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WaterlowAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WaterlowAssessmentVo compareObj = (WaterlowAssessmentVo)obj;
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
		if(this.assessmentdetails != null)
			count++;
		if(this.comment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.nursing.vo.WaterlowAssessmentDetailsVoCollection assessmentdetails;
	protected String comment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
