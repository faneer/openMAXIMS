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

package ims.RefMan.vo;

/**
 * Linked to RefMan.FitForSurgeryAssesment business object (ID: 1096100024).
 */
public class FitForSurgeryAssesmentVo extends ims.RefMan.vo.FitForSurgeryAssessmentLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FitForSurgeryAssesmentVo()
	{
	}
	public FitForSurgeryAssesmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public FitForSurgeryAssesmentVo(ims.RefMan.vo.beans.FitForSurgeryAssesmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.asascore = bean.getASAScore();
		this.comments = bean.getComments();
		this.fitforsurgery = bean.getFitForSurgery();
		this.notfitreason = bean.getNotFitReason() == null ? null : ims.clinical.vo.lookups.ReasonNotFitForSurgery.buildLookup(bean.getNotFitReason());
		this.fitcomments = ims.RefMan.vo.FitForSurgeryCommentVoCollection.buildFromBeanCollection(bean.getFitComments());
		this.opdappt = bean.getOPDAppt() == null ? null : bean.getOPDAppt().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.FitForSurgeryAssesmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.asascore = bean.getASAScore();
		this.comments = bean.getComments();
		this.fitforsurgery = bean.getFitForSurgery();
		this.notfitreason = bean.getNotFitReason() == null ? null : ims.clinical.vo.lookups.ReasonNotFitForSurgery.buildLookup(bean.getNotFitReason());
		this.fitcomments = ims.RefMan.vo.FitForSurgeryCommentVoCollection.buildFromBeanCollection(bean.getFitComments());
		this.opdappt = bean.getOPDAppt() == null ? null : bean.getOPDAppt().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.FitForSurgeryAssesmentVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.FitForSurgeryAssesmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.FitForSurgeryAssesmentVoBean();
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
		if(fieldName.equals("ASASCORE"))
			return getASAScore();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("FITFORSURGERY"))
			return getFitForSurgery();
		if(fieldName.equals("NOTFITREASON"))
			return getNotFitReason();
		if(fieldName.equals("FITCOMMENTS"))
			return getFitComments();
		if(fieldName.equals("OPDAPPT"))
			return getOPDAppt();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getASAScoreIsNotNull()
	{
		return this.asascore != null;
	}
	public Integer getASAScore()
	{
		return this.asascore;
	}
	public void setASAScore(Integer value)
	{
		this.isValidated = false;
		this.asascore = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 10000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getFitForSurgeryIsNotNull()
	{
		return this.fitforsurgery != null;
	}
	public Boolean getFitForSurgery()
	{
		return this.fitforsurgery;
	}
	public void setFitForSurgery(Boolean value)
	{
		this.isValidated = false;
		this.fitforsurgery = value;
	}
	public boolean getNotFitReasonIsNotNull()
	{
		return this.notfitreason != null;
	}
	public ims.clinical.vo.lookups.ReasonNotFitForSurgery getNotFitReason()
	{
		return this.notfitreason;
	}
	public void setNotFitReason(ims.clinical.vo.lookups.ReasonNotFitForSurgery value)
	{
		this.isValidated = false;
		this.notfitreason = value;
	}
	public boolean getFitCommentsIsNotNull()
	{
		return this.fitcomments != null;
	}
	public ims.RefMan.vo.FitForSurgeryCommentVoCollection getFitComments()
	{
		return this.fitcomments;
	}
	public void setFitComments(ims.RefMan.vo.FitForSurgeryCommentVoCollection value)
	{
		this.isValidated = false;
		this.fitcomments = value;
	}
	public boolean getOPDApptIsNotNull()
	{
		return this.opdappt != null;
	}
	public ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo getOPDAppt()
	{
		return this.opdappt;
	}
	public void setOPDAppt(ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo value)
	{
		this.isValidated = false;
		this.opdappt = value;
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
		if(this.fitcomments != null)
		{
			if(!this.fitcomments.isValidated())
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
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
		if(this.fitcomments != null)
		{
			String[] listOfOtherErrors = this.fitcomments.validate();
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
	
		FitForSurgeryAssesmentVo clone = new FitForSurgeryAssesmentVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		clone.asascore = this.asascore;
		clone.comments = this.comments;
		clone.fitforsurgery = this.fitforsurgery;
		if(this.notfitreason == null)
			clone.notfitreason = null;
		else
			clone.notfitreason = (ims.clinical.vo.lookups.ReasonNotFitForSurgery)this.notfitreason.clone();
		if(this.fitcomments == null)
			clone.fitcomments = null;
		else
			clone.fitcomments = (ims.RefMan.vo.FitForSurgeryCommentVoCollection)this.fitcomments.clone();
		if(this.opdappt == null)
			clone.opdappt = null;
		else
			clone.opdappt = (ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo)this.opdappt.clone();
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
		if (!(FitForSurgeryAssesmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FitForSurgeryAssesmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((FitForSurgeryAssesmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((FitForSurgeryAssesmentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.asascore != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.fitforsurgery != null)
			count++;
		if(this.notfitreason != null)
			count++;
		if(this.fitcomments != null)
			count++;
		if(this.opdappt != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected Integer asascore;
	protected String comments;
	protected Boolean fitforsurgery;
	protected ims.clinical.vo.lookups.ReasonNotFitForSurgery notfitreason;
	protected ims.RefMan.vo.FitForSurgeryCommentVoCollection fitcomments;
	protected ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo opdappt;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
