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
 * Linked to core.clinical.QuestionAnswerType business object (ID: 1003100041).
 */
public class QuestionAnswerTypeVo extends ims.core.vo.QuestionAnswerTypeShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public QuestionAnswerTypeVo()
	{
	}
	public QuestionAnswerTypeVo(Integer id, int version)
	{
		super(id, version);
	}
	public QuestionAnswerTypeVo(ims.core.vo.beans.QuestionAnswerTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answertype = bean.getAnswerType() == null ? null : ims.core.vo.lookups.QuestionAnswerType.buildLookup(bean.getAnswerType());
		this.activestatus = bean.getActiveStatus();
		this.separatortext = bean.getSeparatorText();
		this.ismandatory = bean.getIsMandatory();
		this.mandatoryvalmessage = bean.getMandatoryValMessage();
		this.options = ims.core.vo.AnswerOptionVoCollection.buildFromBeanCollection(bean.getOptions());
		this.maxmultiselectallowed = bean.getMaxMultiselectAllowed();
		this.answerwidth = bean.getAnswerWidth();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.QuestionAnswerTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answertype = bean.getAnswerType() == null ? null : ims.core.vo.lookups.QuestionAnswerType.buildLookup(bean.getAnswerType());
		this.activestatus = bean.getActiveStatus();
		this.separatortext = bean.getSeparatorText();
		this.ismandatory = bean.getIsMandatory();
		this.mandatoryvalmessage = bean.getMandatoryValMessage();
		this.options = ims.core.vo.AnswerOptionVoCollection.buildFromBeanCollection(bean.getOptions());
		this.maxmultiselectallowed = bean.getMaxMultiselectAllowed();
		this.answerwidth = bean.getAnswerWidth();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.QuestionAnswerTypeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.QuestionAnswerTypeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.QuestionAnswerTypeVoBean();
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
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("SEPARATORTEXT"))
			return getSeparatorText();
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("MANDATORYVALMESSAGE"))
			return getMandatoryValMessage();
		if(fieldName.equals("OPTIONS"))
			return getOptions();
		if(fieldName.equals("MAXMULTISELECTALLOWED"))
			return getMaxMultiselectAllowed();
		if(fieldName.equals("ANSWERWIDTH"))
			return getAnswerWidth();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public Boolean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(Boolean value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getSeparatorTextIsNotNull()
	{
		return this.separatortext != null;
	}
	public String getSeparatorText()
	{
		return this.separatortext;
	}
	public static int getSeparatorTextMaxLength()
	{
		return 70;
	}
	public void setSeparatorText(String value)
	{
		this.isValidated = false;
		this.separatortext = value;
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
	public boolean getMandatoryValMessageIsNotNull()
	{
		return this.mandatoryvalmessage != null;
	}
	public String getMandatoryValMessage()
	{
		return this.mandatoryvalmessage;
	}
	public static int getMandatoryValMessageMaxLength()
	{
		return 150;
	}
	public void setMandatoryValMessage(String value)
	{
		this.isValidated = false;
		this.mandatoryvalmessage = value;
	}
	public boolean getOptionsIsNotNull()
	{
		return this.options != null;
	}
	public ims.core.vo.AnswerOptionVoCollection getOptions()
	{
		return this.options;
	}
	public void setOptions(ims.core.vo.AnswerOptionVoCollection value)
	{
		this.isValidated = false;
		this.options = value;
	}
	public boolean getMaxMultiselectAllowedIsNotNull()
	{
		return this.maxmultiselectallowed != null;
	}
	public Integer getMaxMultiselectAllowed()
	{
		return this.maxmultiselectallowed;
	}
	public void setMaxMultiselectAllowed(Integer value)
	{
		this.isValidated = false;
		this.maxmultiselectallowed = value;
	}
	public boolean getAnswerWidthIsNotNull()
	{
		return this.answerwidth != null;
	}
	public Integer getAnswerWidth()
	{
		return this.answerwidth;
	}
	public void setAnswerWidth(Integer value)
	{
		this.isValidated = false;
		this.answerwidth = value;
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
		if(this.options != null)
		{
			if(!this.options.isValidated())
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
		if(this.answertype == null)
			listOfErrors.add("AnswerType is mandatory");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.separatortext != null)
			if(this.separatortext.length() > 70)
				listOfErrors.add("The length of the field [separatortext] in the value object [ims.core.vo.QuestionAnswerTypeVo] is too big. It should be less or equal to 70");
		if(this.ismandatory == null)
			listOfErrors.add("isMandatory is mandatory");
		if(this.mandatoryvalmessage != null)
			if(this.mandatoryvalmessage.length() > 150)
				listOfErrors.add("The length of the field [mandatoryvalmessage] in the value object [ims.core.vo.QuestionAnswerTypeVo] is too big. It should be less or equal to 150");
		if(this.options != null)
		{
			String[] listOfOtherErrors = this.options.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.answerwidth != null && (this.answerwidth.intValue() < 50 || this.answerwidth.intValue() > 500))
			listOfErrors.add("Custom Width has an invalid value. The valid range of values is between 50 and 500");
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
	
		QuestionAnswerTypeVo clone = new QuestionAnswerTypeVo(this.id, this.version);
		
		if(this.answertype == null)
			clone.answertype = null;
		else
			clone.answertype = (ims.core.vo.lookups.QuestionAnswerType)this.answertype.clone();
		clone.activestatus = this.activestatus;
		clone.separatortext = this.separatortext;
		clone.ismandatory = this.ismandatory;
		clone.mandatoryvalmessage = this.mandatoryvalmessage;
		if(this.options == null)
			clone.options = null;
		else
			clone.options = (ims.core.vo.AnswerOptionVoCollection)this.options.clone();
		clone.maxmultiselectallowed = this.maxmultiselectallowed;
		clone.answerwidth = this.answerwidth;
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
		if (!(QuestionAnswerTypeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A QuestionAnswerTypeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		QuestionAnswerTypeVo compareObj = (QuestionAnswerTypeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_QuestionAnswerType() == null && compareObj.getID_QuestionAnswerType() != null)
				return -1;
			if(this.getID_QuestionAnswerType() != null && compareObj.getID_QuestionAnswerType() == null)
				return 1;
			if(this.getID_QuestionAnswerType() != null && compareObj.getID_QuestionAnswerType() != null)
				retVal = this.getID_QuestionAnswerType().compareTo(compareObj.getID_QuestionAnswerType());
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
		if(this.activestatus != null)
			count++;
		if(this.separatortext != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.mandatoryvalmessage != null)
			count++;
		if(this.options != null)
			count++;
		if(this.maxmultiselectallowed != null)
			count++;
		if(this.answerwidth != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected Boolean activestatus;
	protected String separatortext;
	protected Boolean ismandatory;
	protected String mandatoryvalmessage;
	protected ims.core.vo.AnswerOptionVoCollection options;
	protected Integer maxmultiselectallowed;
	protected Integer answerwidth;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
