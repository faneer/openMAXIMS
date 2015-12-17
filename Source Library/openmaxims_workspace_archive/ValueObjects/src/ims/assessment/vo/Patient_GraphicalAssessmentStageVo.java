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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientGraphicalAssessmentStage business object (ID: 1085100002).
 */
public class Patient_GraphicalAssessmentStageVo extends ims.assessment.instantiation.vo.PatientGraphicalAssessmentStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Patient_GraphicalAssessmentStageVo()
	{
	}
	public Patient_GraphicalAssessmentStageVo(Integer id, int version)
	{
		super(id, version);
	}
	public Patient_GraphicalAssessmentStageVo(ims.assessment.vo.beans.Patient_GraphicalAssessmentStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo();
		this.findingquestion = ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection.buildFromBeanCollection(bean.getFindingQuestion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.Patient_GraphicalAssessmentStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo(map);
		this.findingquestion = ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection.buildFromBeanCollection(bean.getFindingQuestion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.Patient_GraphicalAssessmentStageVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.Patient_GraphicalAssessmentStageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.Patient_GraphicalAssessmentStageVoBean();
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
		if(fieldName.equals("FINDINGQUESTION"))
			return getFindingQuestion();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.assessment.vo.Finding_StageQuestionsVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.assessment.vo.Finding_StageQuestionsVo value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getFindingQuestionIsNotNull()
	{
		return this.findingquestion != null;
	}
	public ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection getFindingQuestion()
	{
		return this.findingquestion;
	}
	public void setFindingQuestion(ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection value)
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
	
		Patient_GraphicalAssessmentStageVo clone = new Patient_GraphicalAssessmentStageVo(this.id, this.version);
		
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.assessment.vo.Finding_StageQuestionsVo)this.stage.clone();
		if(this.findingquestion == null)
			clone.findingquestion = null;
		else
			clone.findingquestion = (ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection)this.findingquestion.clone();
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
		if (!(Patient_GraphicalAssessmentStageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Patient_GraphicalAssessmentStageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Patient_GraphicalAssessmentStageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Patient_GraphicalAssessmentStageVo)obj).getBoId());
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
		if(this.findingquestion != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.assessment.vo.Finding_StageQuestionsVo stage;
	protected ims.assessment.vo.Patient_GraphicAssessmentFindingQuestionAnswerVoCollection findingquestion;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
