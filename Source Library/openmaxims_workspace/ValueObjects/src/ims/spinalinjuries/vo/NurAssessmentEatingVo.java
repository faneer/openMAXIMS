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

package ims.spinalinjuries.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class NurAssessmentEatingVo extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurAssessmentEatingVo()
	{
	}
	public NurAssessmentEatingVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurAssessmentEatingVo(ims.spinalinjuries.vo.beans.NurAssessmentEatingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo();
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.patientrequireassistance = bean.getPatientRequireAssistance() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientRequireAssistance());
		this.nutritionalmethod = ims.nursing.vo.NutritionalMethodVoCollection.buildFromBeanCollection(bean.getNutritionalMethod());
		this.oralassessment = ims.nursing.vo.OralAssessmentCollection.buildFromBeanCollection(bean.getOralAssessment());
		this.difficultiesinswallowing = bean.getDifficultiesInSwallowing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultiesInSwallowing());
		this.referralspeechandlanguagetherapist = bean.getReferralSpeechAndLanguageTherapist() == null ? null : bean.getReferralSpeechAndLanguageTherapist().buildDate();
		this.referraldietitian = bean.getReferralDietitian() == null ? null : bean.getReferralDietitian().buildDate();
		this.specialdiet = ims.nursing.vo.lookups.SpecialDietCollection.buildFromBeanCollection(bean.getSpecialDiet());
		this.alcoholunits = bean.getAlcoholUnits();
		this.nutritionalriskassessment = bean.getNutritionalRiskAssessment() == null ? null : bean.getNutritionalRiskAssessment().buildVo();
		this.nutritionalriskscore = bean.getNutritionalRiskScore();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.NurAssessmentEatingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo(map);
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.patientrequireassistance = bean.getPatientRequireAssistance() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientRequireAssistance());
		this.nutritionalmethod = ims.nursing.vo.NutritionalMethodVoCollection.buildFromBeanCollection(bean.getNutritionalMethod());
		this.oralassessment = ims.nursing.vo.OralAssessmentCollection.buildFromBeanCollection(bean.getOralAssessment());
		this.difficultiesinswallowing = bean.getDifficultiesInSwallowing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultiesInSwallowing());
		this.referralspeechandlanguagetherapist = bean.getReferralSpeechAndLanguageTherapist() == null ? null : bean.getReferralSpeechAndLanguageTherapist().buildDate();
		this.referraldietitian = bean.getReferralDietitian() == null ? null : bean.getReferralDietitian().buildDate();
		this.specialdiet = ims.nursing.vo.lookups.SpecialDietCollection.buildFromBeanCollection(bean.getSpecialDiet());
		this.alcoholunits = bean.getAlcoholUnits();
		this.nutritionalriskassessment = bean.getNutritionalRiskAssessment() == null ? null : bean.getNutritionalRiskAssessment().buildVo(map);
		this.nutritionalriskscore = bean.getNutritionalRiskScore();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.NurAssessmentEatingVoBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.NurAssessmentEatingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.NurAssessmentEatingVoBean();
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
		if(fieldName.equals("PATIENTREQUIREASSISTANCE"))
			return getPatientRequireAssistance();
		if(fieldName.equals("NUTRITIONALMETHOD"))
			return getNutritionalMethod();
		if(fieldName.equals("ORALASSESSMENT"))
			return getOralAssessment();
		if(fieldName.equals("DIFFICULTIESINSWALLOWING"))
			return getDifficultiesInSwallowing();
		if(fieldName.equals("REFERRALSPEECHANDLANGUAGETHERAPIST"))
			return getReferralSpeechAndLanguageTherapist();
		if(fieldName.equals("REFERRALDIETITIAN"))
			return getReferralDietitian();
		if(fieldName.equals("SPECIALDIET"))
			return getSpecialDiet();
		if(fieldName.equals("ALCOHOLUNITS"))
			return getAlcoholUnits();
		if(fieldName.equals("NUTRITIONALRISKASSESSMENT"))
			return getNutritionalRiskAssessment();
		if(fieldName.equals("NUTRITIONALRISKSCORE"))
			return getNutritionalRiskScore();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientRequireAssistanceIsNotNull()
	{
		return this.patientrequireassistance != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPatientRequireAssistance()
	{
		return this.patientrequireassistance;
	}
	public void setPatientRequireAssistance(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.patientrequireassistance = value;
	}
	public boolean getNutritionalMethodIsNotNull()
	{
		return this.nutritionalmethod != null;
	}
	public ims.nursing.vo.NutritionalMethodVoCollection getNutritionalMethod()
	{
		return this.nutritionalmethod;
	}
	public void setNutritionalMethod(ims.nursing.vo.NutritionalMethodVoCollection value)
	{
		this.isValidated = false;
		this.nutritionalmethod = value;
	}
	public boolean getOralAssessmentIsNotNull()
	{
		return this.oralassessment != null;
	}
	public ims.nursing.vo.OralAssessmentCollection getOralAssessment()
	{
		return this.oralassessment;
	}
	public void setOralAssessment(ims.nursing.vo.OralAssessmentCollection value)
	{
		this.isValidated = false;
		this.oralassessment = value;
	}
	public boolean getDifficultiesInSwallowingIsNotNull()
	{
		return this.difficultiesinswallowing != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDifficultiesInSwallowing()
	{
		return this.difficultiesinswallowing;
	}
	public void setDifficultiesInSwallowing(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.difficultiesinswallowing = value;
	}
	public boolean getReferralSpeechAndLanguageTherapistIsNotNull()
	{
		return this.referralspeechandlanguagetherapist != null;
	}
	public ims.framework.utils.Date getReferralSpeechAndLanguageTherapist()
	{
		return this.referralspeechandlanguagetherapist;
	}
	public void setReferralSpeechAndLanguageTherapist(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.referralspeechandlanguagetherapist = value;
	}
	public boolean getReferralDietitianIsNotNull()
	{
		return this.referraldietitian != null;
	}
	public ims.framework.utils.Date getReferralDietitian()
	{
		return this.referraldietitian;
	}
	public void setReferralDietitian(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.referraldietitian = value;
	}
	public boolean getSpecialDietIsNotNull()
	{
		return this.specialdiet != null;
	}
	public ims.nursing.vo.lookups.SpecialDietCollection getSpecialDiet()
	{
		return this.specialdiet;
	}
	public void setSpecialDiet(ims.nursing.vo.lookups.SpecialDietCollection value)
	{
		this.isValidated = false;
		this.specialdiet = value;
	}
	public boolean getAlcoholUnitsIsNotNull()
	{
		return this.alcoholunits != null;
	}
	public Integer getAlcoholUnits()
	{
		return this.alcoholunits;
	}
	public void setAlcoholUnits(Integer value)
	{
		this.isValidated = false;
		this.alcoholunits = value;
	}
	public boolean getNutritionalRiskAssessmentIsNotNull()
	{
		return this.nutritionalriskassessment != null;
	}
	public ims.nursing.vo.NutritionalRiskAssessmentVo getNutritionalRiskAssessment()
	{
		return this.nutritionalriskassessment;
	}
	public void setNutritionalRiskAssessment(ims.nursing.vo.NutritionalRiskAssessmentVo value)
	{
		this.isValidated = false;
		this.nutritionalriskassessment = value;
	}
	public boolean getNutritionalRiskScoreIsNotNull()
	{
		return this.nutritionalriskscore != null;
	}
	public Integer getNutritionalRiskScore()
	{
		return this.nutritionalriskscore;
	}
	public void setNutritionalRiskScore(Integer value)
	{
		this.isValidated = false;
		this.nutritionalriskscore = value;
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
		if(this.assessmentinfo != null)
		{
			if(!this.assessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastassessmentinfo != null)
		{
			if(!this.lastassessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplantemplate != null)
		{
			if(!this.careplantemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplans != null)
		{
			if(!this.careplans.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.nutritionalmethod != null)
		{
			if(!this.nutritionalmethod.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.oralassessment != null)
		{
			if(!this.oralassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.nutritionalriskassessment != null)
		{
			if(!this.nutritionalriskassessment.isValidated())
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
		if(this.assessmentinfo != null)
		{
			String[] listOfOtherErrors = this.assessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastassessmentinfo != null)
		{
			String[] listOfOtherErrors = this.lastassessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplantemplate != null)
		{
			String[] listOfOtherErrors = this.careplantemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplans != null)
		{
			String[] listOfOtherErrors = this.careplans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.nutritionalmethod != null)
		{
			String[] listOfOtherErrors = this.nutritionalmethod.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.oralassessment != null)
		{
			String[] listOfOtherErrors = this.oralassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.nutritionalriskassessment != null)
		{
			String[] listOfOtherErrors = this.nutritionalriskassessment.validate();
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
	
		NurAssessmentEatingVo clone = new NurAssessmentEatingVo(this.id, this.version);
		
		clone.iscomplete = this.iscomplete;
		if(this.assessmentinfo == null)
			clone.assessmentinfo = null;
		else
			clone.assessmentinfo = (ims.nursing.vo.AssessmentInfoCollection)this.assessmentinfo.clone();
		clone.copy = this.copy;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.nursing.vo.lookups.AssessmentComponentType)this.componenttype.clone();
		if(this.lastassessmentinfo == null)
			clone.lastassessmentinfo = null;
		else
			clone.lastassessmentinfo = (ims.nursing.vo.AssessmentInfo)this.lastassessmentinfo.clone();
		if(this.careplantemplate == null)
			clone.careplantemplate = null;
		else
			clone.careplantemplate = (ims.nursing.vo.CarePlanTemplateCollection)this.careplantemplate.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanCollection)this.careplans.clone();
		if(this.patientrequireassistance == null)
			clone.patientrequireassistance = null;
		else
			clone.patientrequireassistance = (ims.core.vo.lookups.YesNoUnknown)this.patientrequireassistance.clone();
		if(this.nutritionalmethod == null)
			clone.nutritionalmethod = null;
		else
			clone.nutritionalmethod = (ims.nursing.vo.NutritionalMethodVoCollection)this.nutritionalmethod.clone();
		if(this.oralassessment == null)
			clone.oralassessment = null;
		else
			clone.oralassessment = (ims.nursing.vo.OralAssessmentCollection)this.oralassessment.clone();
		if(this.difficultiesinswallowing == null)
			clone.difficultiesinswallowing = null;
		else
			clone.difficultiesinswallowing = (ims.core.vo.lookups.YesNoUnknown)this.difficultiesinswallowing.clone();
		if(this.referralspeechandlanguagetherapist == null)
			clone.referralspeechandlanguagetherapist = null;
		else
			clone.referralspeechandlanguagetherapist = (ims.framework.utils.Date)this.referralspeechandlanguagetherapist.clone();
		if(this.referraldietitian == null)
			clone.referraldietitian = null;
		else
			clone.referraldietitian = (ims.framework.utils.Date)this.referraldietitian.clone();
		if(this.specialdiet == null)
			clone.specialdiet = null;
		else
			clone.specialdiet = (ims.nursing.vo.lookups.SpecialDietCollection)this.specialdiet.clone();
		clone.alcoholunits = this.alcoholunits;
		if(this.nutritionalriskassessment == null)
			clone.nutritionalriskassessment = null;
		else
			clone.nutritionalriskassessment = (ims.nursing.vo.NutritionalRiskAssessmentVo)this.nutritionalriskassessment.clone();
		clone.nutritionalriskscore = this.nutritionalriskscore;
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
		if (!(NurAssessmentEatingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurAssessmentEatingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NurAssessmentEatingVo compareObj = (NurAssessmentEatingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_AssessmentComponent() == null && compareObj.getID_AssessmentComponent() != null)
				return -1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() == null)
				return 1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() != null)
				retVal = this.getID_AssessmentComponent().compareTo(compareObj.getID_AssessmentComponent());
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
		if(this.patientrequireassistance != null)
			count++;
		if(this.nutritionalmethod != null)
			count++;
		if(this.oralassessment != null)
			count++;
		if(this.difficultiesinswallowing != null)
			count++;
		if(this.referralspeechandlanguagetherapist != null)
			count++;
		if(this.referraldietitian != null)
			count++;
		if(this.specialdiet != null)
			count++;
		if(this.alcoholunits != null)
			count++;
		if(this.nutritionalriskassessment != null)
			count++;
		if(this.nutritionalriskscore != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 10;
	}
	protected ims.core.vo.lookups.YesNoUnknown patientrequireassistance;
	protected ims.nursing.vo.NutritionalMethodVoCollection nutritionalmethod;
	protected ims.nursing.vo.OralAssessmentCollection oralassessment;
	protected ims.core.vo.lookups.YesNoUnknown difficultiesinswallowing;
	protected ims.framework.utils.Date referralspeechandlanguagetherapist;
	protected ims.framework.utils.Date referraldietitian;
	protected ims.nursing.vo.lookups.SpecialDietCollection specialdiet;
	protected Integer alcoholunits;
	protected ims.nursing.vo.NutritionalRiskAssessmentVo nutritionalriskassessment;
	protected Integer nutritionalriskscore;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
