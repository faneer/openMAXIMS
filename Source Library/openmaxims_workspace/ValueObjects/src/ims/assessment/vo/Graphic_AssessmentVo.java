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
 * Linked to Assessment.Configuration.GraphicAssessment business object (ID: 1028100006).
 */
public class Graphic_AssessmentVo extends ims.assessment.vo.GraphicAssessmentShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Graphic_AssessmentVo()
	{
	}
	public Graphic_AssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public Graphic_AssessmentVo(ims.assessment.vo.beans.Graphic_AssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.helpurl = bean.getHelpUrl();
		this.storeprintedreport = bean.getStorePrintedReport();
		this.assessmentspecialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getAssessmentSpecialties());
		this.associatedreportforprinting = bean.getAssociatedReportForPrinting() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getAssociatedReportForPrinting().getId()), bean.getAssociatedReportForPrinting().getVersion());
		this.images = ims.core.vo.DrawingGraphicImageVoCollection.buildFromBeanCollection(bean.getImages());
		this.associatedquestions = ims.assessment.vo.Graphic_AssessmentQuestionVoCollection.buildFromBeanCollection(bean.getAssociatedQuestions());
		this.findingsandquestions = ims.assessment.vo.Graphic_AssessmentFindingVoCollection.buildFromBeanCollection(bean.getFindingsAndQuestions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.Graphic_AssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.helpurl = bean.getHelpUrl();
		this.storeprintedreport = bean.getStorePrintedReport();
		this.assessmentspecialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getAssessmentSpecialties());
		this.associatedreportforprinting = bean.getAssociatedReportForPrinting() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getAssociatedReportForPrinting().getId()), bean.getAssociatedReportForPrinting().getVersion());
		this.images = ims.core.vo.DrawingGraphicImageVoCollection.buildFromBeanCollection(bean.getImages());
		this.associatedquestions = ims.assessment.vo.Graphic_AssessmentQuestionVoCollection.buildFromBeanCollection(bean.getAssociatedQuestions());
		this.findingsandquestions = ims.assessment.vo.Graphic_AssessmentFindingVoCollection.buildFromBeanCollection(bean.getFindingsAndQuestions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.Graphic_AssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.Graphic_AssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.Graphic_AssessmentVoBean();
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
		if(fieldName.equals("IMAGES"))
			return getImages();
		if(fieldName.equals("ASSOCIATEDQUESTIONS"))
			return getAssociatedQuestions();
		if(fieldName.equals("FINDINGSANDQUESTIONS"))
			return getFindingsAndQuestions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getImagesIsNotNull()
	{
		return this.images != null;
	}
	public ims.core.vo.DrawingGraphicImageVoCollection getImages()
	{
		return this.images;
	}
	public void setImages(ims.core.vo.DrawingGraphicImageVoCollection value)
	{
		this.isValidated = false;
		this.images = value;
	}
	public boolean getAssociatedQuestionsIsNotNull()
	{
		return this.associatedquestions != null;
	}
	public ims.assessment.vo.Graphic_AssessmentQuestionVoCollection getAssociatedQuestions()
	{
		return this.associatedquestions;
	}
	public void setAssociatedQuestions(ims.assessment.vo.Graphic_AssessmentQuestionVoCollection value)
	{
		this.isValidated = false;
		this.associatedquestions = value;
	}
	public boolean getFindingsAndQuestionsIsNotNull()
	{
		return this.findingsandquestions != null;
	}
	public ims.assessment.vo.Graphic_AssessmentFindingVoCollection getFindingsAndQuestions()
	{
		return this.findingsandquestions;
	}
	public void setFindingsAndQuestions(ims.assessment.vo.Graphic_AssessmentFindingVoCollection value)
	{
		this.isValidated = false;
		this.findingsandquestions = value;
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
		if(this.associatedquestions != null)
		{
			if(!this.associatedquestions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.findingsandquestions != null)
		{
			if(!this.findingsandquestions.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.assessment.vo.Graphic_AssessmentVo] is too big. It should be less or equal to 50");
		if(this.activestatus == null)
			listOfErrors.add("Status is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 150)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.assessment.vo.Graphic_AssessmentVo] is too big. It should be less or equal to 150");
		if(this.associatedquestions != null)
		{
			String[] listOfOtherErrors = this.associatedquestions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.findingsandquestions != null)
		{
			String[] listOfOtherErrors = this.findingsandquestions.validate();
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
	
		Graphic_AssessmentVo clone = new Graphic_AssessmentVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.assessmenttype == null)
			clone.assessmenttype = null;
		else
			clone.assessmenttype = (ims.core.vo.lookups.UserDefinedAssessmentType)this.assessmenttype.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		clone.helpurl = this.helpurl;
		clone.storeprintedreport = this.storeprintedreport;
		if(this.assessmentspecialties == null)
			clone.assessmentspecialties = null;
		else
			clone.assessmentspecialties = (ims.core.vo.lookups.SpecialtyCollection)this.assessmentspecialties.clone();
		clone.associatedreportforprinting = this.associatedreportforprinting;
		if(this.images == null)
			clone.images = null;
		else
			clone.images = (ims.core.vo.DrawingGraphicImageVoCollection)this.images.clone();
		if(this.associatedquestions == null)
			clone.associatedquestions = null;
		else
			clone.associatedquestions = (ims.assessment.vo.Graphic_AssessmentQuestionVoCollection)this.associatedquestions.clone();
		if(this.findingsandquestions == null)
			clone.findingsandquestions = null;
		else
			clone.findingsandquestions = (ims.assessment.vo.Graphic_AssessmentFindingVoCollection)this.findingsandquestions.clone();
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
		if (!(Graphic_AssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Graphic_AssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Graphic_AssessmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Graphic_AssessmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.images != null)
			count++;
		if(this.associatedquestions != null)
			count++;
		if(this.findingsandquestions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.core.vo.DrawingGraphicImageVoCollection images;
	protected ims.assessment.vo.Graphic_AssessmentQuestionVoCollection associatedquestions;
	protected ims.assessment.vo.Graphic_AssessmentFindingVoCollection findingsandquestions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
