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
 * Linked to OCRR.Configuration.CategoryQuestion business object (ID: 1061100011).
 */
public class CategoryQuestionLiteVo extends ims.ocrr.configuration.vo.CategoryQuestionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CategoryQuestionLiteVo()
	{
	}
	public CategoryQuestionLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public CategoryQuestionLiteVo(ims.ocrr.vo.beans.CategoryQuestionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ocrrcategory = bean.getOCRRCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getOCRRCategory());
		this.ismandatory = bean.getIsMandatory();
		this.questioninformation = bean.getQuestionInformation() == null ? null : new ims.core.clinical.vo.QuestionInformationRefVo(new Integer(bean.getQuestionInformation().getId()), bean.getQuestionInformation().getVersion());
		this.askforinvestigations = bean.getAskForInvestigations();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.CategoryQuestionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ocrrcategory = bean.getOCRRCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getOCRRCategory());
		this.ismandatory = bean.getIsMandatory();
		this.questioninformation = bean.getQuestionInformation() == null ? null : new ims.core.clinical.vo.QuestionInformationRefVo(new Integer(bean.getQuestionInformation().getId()), bean.getQuestionInformation().getVersion());
		this.askforinvestigations = bean.getAskForInvestigations();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.CategoryQuestionLiteVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.CategoryQuestionLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.CategoryQuestionLiteVoBean();
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
		if(fieldName.equals("OCRRCATEGORY"))
			return getOCRRCategory();
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("QUESTIONINFORMATION"))
			return getQuestionInformation();
		if(fieldName.equals("ASKFORINVESTIGATIONS"))
			return getAskForInvestigations();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOCRRCategoryIsNotNull()
	{
		return this.ocrrcategory != null;
	}
	public ims.ocrr.vo.lookups.Category getOCRRCategory()
	{
		return this.ocrrcategory;
	}
	public void setOCRRCategory(ims.ocrr.vo.lookups.Category value)
	{
		this.isValidated = false;
		this.ocrrcategory = value;
	}
	public boolean getIsMandatoryIsNotNull()
	{
		return this.ismandatory != null;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.isValidated = false;
		this.ismandatory = value;
	}
	public boolean getQuestionInformationIsNotNull()
	{
		return this.questioninformation != null;
	}
	public ims.core.clinical.vo.QuestionInformationRefVo getQuestionInformation()
	{
		return this.questioninformation;
	}
	public void setQuestionInformation(ims.core.clinical.vo.QuestionInformationRefVo value)
	{
		this.isValidated = false;
		this.questioninformation = value;
	}
	public boolean getAskForInvestigationsIsNotNull()
	{
		return this.askforinvestigations != null;
	}
	public Boolean getAskForInvestigations()
	{
		return this.askforinvestigations;
	}
	public void setAskForInvestigations(Boolean value)
	{
		this.isValidated = false;
		this.askforinvestigations = value;
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
		if(this.ocrrcategory == null)
			listOfErrors.add("OCRRCategory is mandatory");
		if(this.questioninformation == null)
			listOfErrors.add("QuestionInformation is mandatory");
		if(this.askforinvestigations == null)
			listOfErrors.add("askForInvestigations is mandatory");
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
	
		CategoryQuestionLiteVo clone = new CategoryQuestionLiteVo(this.id, this.version);
		
		if(this.ocrrcategory == null)
			clone.ocrrcategory = null;
		else
			clone.ocrrcategory = (ims.ocrr.vo.lookups.Category)this.ocrrcategory.clone();
		clone.ismandatory = this.ismandatory;
		clone.questioninformation = this.questioninformation;
		clone.askforinvestigations = this.askforinvestigations;
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
		if (!(CategoryQuestionLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CategoryQuestionLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CategoryQuestionLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CategoryQuestionLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ocrrcategory != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.questioninformation != null)
			count++;
		if(this.askforinvestigations != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.ocrr.vo.lookups.Category ocrrcategory;
	protected Boolean ismandatory;
	protected ims.core.clinical.vo.QuestionInformationRefVo questioninformation;
	protected Boolean askforinvestigations;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
