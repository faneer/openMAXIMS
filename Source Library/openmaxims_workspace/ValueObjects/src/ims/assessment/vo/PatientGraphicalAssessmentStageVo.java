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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientGraphicalAssessmentStage business object (ID: 1085100002).
 */
public class PatientGraphicalAssessmentStageVo extends ims.assessment.instantiation.vo.PatientGraphicalAssessmentStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientGraphicalAssessmentStageVo()
	{
	}
	public PatientGraphicalAssessmentStageVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientGraphicalAssessmentStageVo(ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.findingquestion = ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection.buildFromBeanCollection(bean.getFindingQuestion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.findingquestion = ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection.buildFromBeanCollection(bean.getFindingQuestion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean();
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
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("FINDINGQUESTION"))
			return getFindingQuestion();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.assessment.vo.FindingStageQuestionsVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.assessment.vo.FindingStageQuestionsVo value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getFindingQuestionIsNotNull()
	{
		return this.findingquestion != null;
	}
	public ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection getFindingQuestion()
	{
		return this.findingquestion;
	}
	public void setFindingQuestion(ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection value)
	{
		this.isValidated = false;
		this.findingquestion = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.findingquestion != null)
		{
			if(!this.findingquestion.isValidated())
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
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.findingquestion != null)
		{
			String[] listOfOtherErrors = this.findingquestion.validate();
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
	
		PatientGraphicalAssessmentStageVo clone = new PatientGraphicalAssessmentStageVo(this.id, this.version);
		
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.assessment.vo.FindingStageQuestionsVo)this.stage.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.findingquestion == null)
			clone.findingquestion = null;
		else
			clone.findingquestion = (ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection)this.findingquestion.clone();
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
		if (!(PatientGraphicalAssessmentStageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientGraphicalAssessmentStageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientGraphicalAssessmentStageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientGraphicalAssessmentStageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.stage != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.findingquestion != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.assessment.vo.FindingStageQuestionsVo stage;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.assessment.vo.PatientGraphicAssessmentFindingQuestionAnswerVoCollection findingquestion;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
