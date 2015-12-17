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
 * Linked to Assessment.Instantiation.PatientAnswerDetails business object (ID: 1003100052).
 */
public class AnswerDetailsVo extends ims.assessment.instantiation.vo.PatientAnswerDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AnswerDetailsVo()
	{
	}
	public AnswerDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public AnswerDetailsVo(ims.core.vo.beans.AnswerDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answertype = bean.getAnswerType() == null ? null : bean.getAnswerType().buildVo();
		this.multiselectanswers = ims.core.vo.AnswerOptionVoCollection.buildFromBeanCollection(bean.getMultiSelectAnswers());
		this.picklist = bean.getPicklist() == null ? null : bean.getPicklist().buildVo();
		this.calculatedscore = bean.getCalculatedScore();
		this.boolvalueanswer = bean.getBoolValueAnswer();
		this.dateanswer = bean.getDateAnswer() == null ? null : bean.getDateAnswer().buildDate();
		this.timeanswer = bean.getTimeAnswer() == null ? null : bean.getTimeAnswer().buildTime();
		this.stringanswer = bean.getStringAnswer();
		this.integeranswer = bean.getIntegerAnswer();
		this.decimalanswer = bean.getDecimalAnswer();
		this.partialdate = bean.getPartialDate() == null ? null : bean.getPartialDate().buildPartialDate();
		this.maxmultiselectallowed = bean.getMaxMultiselectAllowed();
		this.answerwidth = bean.getAnswerWidth();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AnswerDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answertype = bean.getAnswerType() == null ? null : bean.getAnswerType().buildVo(map);
		this.multiselectanswers = ims.core.vo.AnswerOptionVoCollection.buildFromBeanCollection(bean.getMultiSelectAnswers());
		this.picklist = bean.getPicklist() == null ? null : bean.getPicklist().buildVo(map);
		this.calculatedscore = bean.getCalculatedScore();
		this.boolvalueanswer = bean.getBoolValueAnswer();
		this.dateanswer = bean.getDateAnswer() == null ? null : bean.getDateAnswer().buildDate();
		this.timeanswer = bean.getTimeAnswer() == null ? null : bean.getTimeAnswer().buildTime();
		this.stringanswer = bean.getStringAnswer();
		this.integeranswer = bean.getIntegerAnswer();
		this.decimalanswer = bean.getDecimalAnswer();
		this.partialdate = bean.getPartialDate() == null ? null : bean.getPartialDate().buildPartialDate();
		this.maxmultiselectallowed = bean.getMaxMultiselectAllowed();
		this.answerwidth = bean.getAnswerWidth();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AnswerDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AnswerDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AnswerDetailsVoBean();
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
		if(fieldName.equals("ANSWERTYPE"))
			return getAnswerType();
		if(fieldName.equals("MULTISELECTANSWERS"))
			return getMultiSelectAnswers();
		if(fieldName.equals("PICKLIST"))
			return getPicklist();
		if(fieldName.equals("CALCULATEDSCORE"))
			return getCalculatedScore();
		if(fieldName.equals("BOOLVALUEANSWER"))
			return getBoolValueAnswer();
		if(fieldName.equals("DATEANSWER"))
			return getDateAnswer();
		if(fieldName.equals("TIMEANSWER"))
			return getTimeAnswer();
		if(fieldName.equals("STRINGANSWER"))
			return getStringAnswer();
		if(fieldName.equals("INTEGERANSWER"))
			return getIntegerAnswer();
		if(fieldName.equals("DECIMALANSWER"))
			return getDecimalAnswer();
		if(fieldName.equals("PARTIALDATE"))
			return getPartialDate();
		if(fieldName.equals("MAXMULTISELECTALLOWED"))
			return getMaxMultiselectAllowed();
		if(fieldName.equals("ANSWERWIDTH"))
			return getAnswerWidth();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnswerTypeIsNotNull()
	{
		return this.answertype != null;
	}
	public ims.core.vo.QuestionAnswerTypeVo getAnswerType()
	{
		return this.answertype;
	}
	public void setAnswerType(ims.core.vo.QuestionAnswerTypeVo value)
	{
		this.isValidated = false;
		this.answertype = value;
	}
	public boolean getMultiSelectAnswersIsNotNull()
	{
		return this.multiselectanswers != null;
	}
	public ims.core.vo.AnswerOptionVoCollection getMultiSelectAnswers()
	{
		return this.multiselectanswers;
	}
	public void setMultiSelectAnswers(ims.core.vo.AnswerOptionVoCollection value)
	{
		this.isValidated = false;
		this.multiselectanswers = value;
	}
	public boolean getPicklistIsNotNull()
	{
		return this.picklist != null;
	}
	public ims.core.vo.AnswerOptionVo getPicklist()
	{
		return this.picklist;
	}
	public void setPicklist(ims.core.vo.AnswerOptionVo value)
	{
		this.isValidated = false;
		this.picklist = value;
	}
	public boolean getCalculatedScoreIsNotNull()
	{
		return this.calculatedscore != null;
	}
	public Float getCalculatedScore()
	{
		return this.calculatedscore;
	}
	public void setCalculatedScore(Float value)
	{
		this.isValidated = false;
		this.calculatedscore = value;
	}
	public boolean getBoolValueAnswerIsNotNull()
	{
		return this.boolvalueanswer != null;
	}
	public Boolean getBoolValueAnswer()
	{
		return this.boolvalueanswer;
	}
	public void setBoolValueAnswer(Boolean value)
	{
		this.isValidated = false;
		this.boolvalueanswer = value;
	}
	public boolean getDateAnswerIsNotNull()
	{
		return this.dateanswer != null;
	}
	public ims.framework.utils.Date getDateAnswer()
	{
		return this.dateanswer;
	}
	public void setDateAnswer(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateanswer = value;
	}
	public boolean getTimeAnswerIsNotNull()
	{
		return this.timeanswer != null;
	}
	public ims.framework.utils.Time getTimeAnswer()
	{
		return this.timeanswer;
	}
	public void setTimeAnswer(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.timeanswer = value;
	}
	public boolean getStringAnswerIsNotNull()
	{
		return this.stringanswer != null;
	}
	public String getStringAnswer()
	{
		return this.stringanswer;
	}
	public static int getStringAnswerMaxLength()
	{
		return 4000;
	}
	public void setStringAnswer(String value)
	{
		this.isValidated = false;
		this.stringanswer = value;
	}
	public boolean getIntegerAnswerIsNotNull()
	{
		return this.integeranswer != null;
	}
	public Integer getIntegerAnswer()
	{
		return this.integeranswer;
	}
	public void setIntegerAnswer(Integer value)
	{
		this.isValidated = false;
		this.integeranswer = value;
	}
	public boolean getDecimalAnswerIsNotNull()
	{
		return this.decimalanswer != null;
	}
	public Float getDecimalAnswer()
	{
		return this.decimalanswer;
	}
	public void setDecimalAnswer(Float value)
	{
		this.isValidated = false;
		this.decimalanswer = value;
	}
	public boolean getPartialDateIsNotNull()
	{
		return this.partialdate != null;
	}
	public ims.framework.utils.PartialDate getPartialDate()
	{
		return this.partialdate;
	}
	public void setPartialDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.partialdate = value;
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
	
		AnswerDetailsVo clone = new AnswerDetailsVo(this.id, this.version);
		
		if(this.answertype == null)
			clone.answertype = null;
		else
			clone.answertype = (ims.core.vo.QuestionAnswerTypeVo)this.answertype.clone();
		if(this.multiselectanswers == null)
			clone.multiselectanswers = null;
		else
			clone.multiselectanswers = (ims.core.vo.AnswerOptionVoCollection)this.multiselectanswers.clone();
		if(this.picklist == null)
			clone.picklist = null;
		else
			clone.picklist = (ims.core.vo.AnswerOptionVo)this.picklist.clone();
		clone.calculatedscore = this.calculatedscore;
		clone.boolvalueanswer = this.boolvalueanswer;
		if(this.dateanswer == null)
			clone.dateanswer = null;
		else
			clone.dateanswer = (ims.framework.utils.Date)this.dateanswer.clone();
		if(this.timeanswer == null)
			clone.timeanswer = null;
		else
			clone.timeanswer = (ims.framework.utils.Time)this.timeanswer.clone();
		clone.stringanswer = this.stringanswer;
		clone.integeranswer = this.integeranswer;
		clone.decimalanswer = this.decimalanswer;
		if(this.partialdate == null)
			clone.partialdate = null;
		else
			clone.partialdate = (ims.framework.utils.PartialDate)this.partialdate.clone();
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
		if (!(AnswerDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AnswerDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AnswerDetailsVo compareObj = (AnswerDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientAnswerDetails() == null && compareObj.getID_PatientAnswerDetails() != null)
				return -1;
			if(this.getID_PatientAnswerDetails() != null && compareObj.getID_PatientAnswerDetails() == null)
				return 1;
			if(this.getID_PatientAnswerDetails() != null && compareObj.getID_PatientAnswerDetails() != null)
				retVal = this.getID_PatientAnswerDetails().compareTo(compareObj.getID_PatientAnswerDetails());
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
		if(this.answertype != null)
			count++;
		if(this.multiselectanswers != null)
			count++;
		if(this.picklist != null)
			count++;
		if(this.calculatedscore != null)
			count++;
		if(this.boolvalueanswer != null)
			count++;
		if(this.dateanswer != null)
			count++;
		if(this.timeanswer != null)
			count++;
		if(this.stringanswer != null)
			count++;
		if(this.integeranswer != null)
			count++;
		if(this.decimalanswer != null)
			count++;
		if(this.partialdate != null)
			count++;
		if(this.maxmultiselectallowed != null)
			count++;
		if(this.answerwidth != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.vo.QuestionAnswerTypeVo answertype;
	protected ims.core.vo.AnswerOptionVoCollection multiselectanswers;
	protected ims.core.vo.AnswerOptionVo picklist;
	protected Float calculatedscore;
	protected Boolean boolvalueanswer;
	protected ims.framework.utils.Date dateanswer;
	protected ims.framework.utils.Time timeanswer;
	protected String stringanswer;
	protected Integer integeranswer;
	protected Float decimalanswer;
	protected ims.framework.utils.PartialDate partialdate;
	protected Integer maxmultiselectallowed;
	protected Integer answerwidth;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
