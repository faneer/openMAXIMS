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
 * Linked to OCRR.Configuration.InvestigationQuestion business object (ID: 1061100002).
 */
public class InvestigationQuestionShortVo extends ims.ocrr.configuration.vo.InvestigationQuestionRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IQuestionType
{
	private static final long serialVersionUID = 1L;

	public InvestigationQuestionShortVo()
	{
	}
	public InvestigationQuestionShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvestigationQuestionShortVo(ims.ocrr.vo.beans.InvestigationQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.question = bean.getQuestion() == null ? null : bean.getQuestion().buildVo();
		this.ismandatory = bean.getIsMandatory();
		this.investigationname = bean.getInvestigationName();
		this.investigaionid = bean.getInvestigaionId();
		this.parentid = bean.getParentId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.InvestigationQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.question = bean.getQuestion() == null ? null : bean.getQuestion().buildVo(map);
		this.ismandatory = bean.getIsMandatory();
		this.investigationname = bean.getInvestigationName();
		this.investigaionid = bean.getInvestigaionId();
		this.parentid = bean.getParentId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.InvestigationQuestionShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.InvestigationQuestionShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.InvestigationQuestionShortVoBean();
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
		if(fieldName.equals("QUESTION"))
			return getQuestion();
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("INVESTIGATIONNAME"))
			return getInvestigationName();
		if(fieldName.equals("INVESTIGAIONID"))
			return getInvestigaionId();
		if(fieldName.equals("PARENTID"))
			return getParentId();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getQuestionIsNotNull()
	{
		return this.question != null;
	}
	public ims.core.vo.QuestionInformationShortVo getQuestion()
	{
		return this.question;
	}
	public void setQuestion(ims.core.vo.QuestionInformationShortVo value)
	{
		this.isValidated = false;
		this.question = value;
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
	public boolean getInvestigationNameIsNotNull()
	{
		return this.investigationname != null;
	}
	public String getInvestigationName()
	{
		return this.investigationname;
	}
	public static int getInvestigationNameMaxLength()
	{
		return 255;
	}
	public void setInvestigationName(String value)
	{
		this.isValidated = false;
		this.investigationname = value;
	}
	public boolean getInvestigaionIdIsNotNull()
	{
		return this.investigaionid != null;
	}
	public Integer getInvestigaionId()
	{
		return this.investigaionid;
	}
	public void setInvestigaionId(Integer value)
	{
		this.isValidated = false;
		this.investigaionid = value;
	}
	public boolean getParentIdIsNotNull()
	{
		return this.parentid != null;
	}
	public Integer getParentId()
	{
		return this.parentid;
	}
	public void setParentId(Integer value)
	{
		this.isValidated = false;
		this.parentid = value;
	}
	/**
	* IQuestionType Interface methods
	*/
	public ims.core.vo.QuestionInformationShortVo getIQuestionTypeQuestion() 
	{
		return this.question;
	}
	public ims.ocrr.vo.lookups.OrderQuestionType getIQuestionTypeOrderQuestionType() 
	{
		return ims.ocrr.vo.lookups.OrderQuestionType.INVESTIGATION;
	}
	public Boolean getIQuestionTypeIsMandatory()
	{
		return getIsMandatory();
	}
	public String getIQuestionTypeItemName()
	{
		return  this.investigationname;
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
		if(this.question != null)
		{
			if(!this.question.isValidated())
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
		if(this.question != null)
		{
			String[] listOfOtherErrors = this.question.validate();
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
	
		InvestigationQuestionShortVo clone = new InvestigationQuestionShortVo(this.id, this.version);
		
		if(this.question == null)
			clone.question = null;
		else
			clone.question = (ims.core.vo.QuestionInformationShortVo)this.question.clone();
		clone.ismandatory = this.ismandatory;
		clone.investigationname = this.investigationname;
		clone.investigaionid = this.investigaionid;
		clone.parentid = this.parentid;
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
		if (!(InvestigationQuestionShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvestigationQuestionShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InvestigationQuestionShortVo compareObj = (InvestigationQuestionShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_InvestigationQuestion() == null && compareObj.getID_InvestigationQuestion() != null)
				return -1;
			if(this.getID_InvestigationQuestion() != null && compareObj.getID_InvestigationQuestion() == null)
				return 1;
			if(this.getID_InvestigationQuestion() != null && compareObj.getID_InvestigationQuestion() != null)
				retVal = this.getID_InvestigationQuestion().compareTo(compareObj.getID_InvestigationQuestion());
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
		if(this.question != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.investigationname != null)
			count++;
		if(this.investigaionid != null)
			count++;
		if(this.parentid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.QuestionInformationShortVo question;
	protected Boolean ismandatory;
	protected String investigationname;
	protected Integer investigaionid;
	protected Integer parentid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
