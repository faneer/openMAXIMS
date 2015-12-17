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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class AssessmentEatingAndDrinking extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentEatingAndDrinking()
	{
	}
	public AssessmentEatingAndDrinking(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentEatingAndDrinking(ims.coe.vo.beans.AssessmentEatingAndDrinkingBean bean)
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
		this.nutritionalmethod = ims.nursing.vo.lookups.NutritionalMethodCollection.buildFromBeanCollection(bean.getNutritionalMethod());
		this.oralassessment = ims.nursing.vo.OralAssessmentCollection.buildFromBeanCollection(bean.getOralAssessment());
		this.difficultieswithswallowing = bean.getDifficultiesWithSwallowing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultiesWithSwallowing());
		this.swallowing = ims.coe.vo.SwallowingAssessmentCollection.buildFromBeanCollection(bean.getSwallowing());
		this.manualdexterity = ims.coe.vo.ManualDexterityCollection.buildFromBeanCollection(bean.getManualDexterity());
		this.describeappetite = bean.getDescribeAppetite() == null ? null : ims.coe.vo.lookups.DescribeAppetite.buildLookup(bean.getDescribeAppetite());
		this.anyspecialdiet = bean.getAnySpecialDiet() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAnySpecialDiet());
		this.specialdiet = bean.getSpecialDiet() == null ? null : ims.nursing.vo.lookups.SpecialDiet.buildLookup(bean.getSpecialDiet());
		this.foodpatientlikes = bean.getFoodPatientLikes();
		this.foodpatientdislikes = bean.getFoodPatientDislikes();
		this.foodpatientfavourite = bean.getFoodPatientFavourite();
		this.requireassistance = bean.getRequireAssistance() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRequireAssistance());
		this.mininutritionalassessment = bean.getMiniNutritionalAssessment() == null ? null : bean.getMiniNutritionalAssessment().buildVo();
		this.mnascore = bean.getMNAScore();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentEatingAndDrinkingBean bean)
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
		this.nutritionalmethod = ims.nursing.vo.lookups.NutritionalMethodCollection.buildFromBeanCollection(bean.getNutritionalMethod());
		this.oralassessment = ims.nursing.vo.OralAssessmentCollection.buildFromBeanCollection(bean.getOralAssessment());
		this.difficultieswithswallowing = bean.getDifficultiesWithSwallowing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultiesWithSwallowing());
		this.swallowing = ims.coe.vo.SwallowingAssessmentCollection.buildFromBeanCollection(bean.getSwallowing());
		this.manualdexterity = ims.coe.vo.ManualDexterityCollection.buildFromBeanCollection(bean.getManualDexterity());
		this.describeappetite = bean.getDescribeAppetite() == null ? null : ims.coe.vo.lookups.DescribeAppetite.buildLookup(bean.getDescribeAppetite());
		this.anyspecialdiet = bean.getAnySpecialDiet() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAnySpecialDiet());
		this.specialdiet = bean.getSpecialDiet() == null ? null : ims.nursing.vo.lookups.SpecialDiet.buildLookup(bean.getSpecialDiet());
		this.foodpatientlikes = bean.getFoodPatientLikes();
		this.foodpatientdislikes = bean.getFoodPatientDislikes();
		this.foodpatientfavourite = bean.getFoodPatientFavourite();
		this.requireassistance = bean.getRequireAssistance() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRequireAssistance());
		this.mininutritionalassessment = bean.getMiniNutritionalAssessment() == null ? null : bean.getMiniNutritionalAssessment().buildVo(map);
		this.mnascore = bean.getMNAScore();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentEatingAndDrinkingBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentEatingAndDrinkingBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentEatingAndDrinkingBean();
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
		if(fieldName.equals("NUTRITIONALMETHOD"))
			return getNutritionalMethod();
		if(fieldName.equals("ORALASSESSMENT"))
			return getOralAssessment();
		if(fieldName.equals("DIFFICULTIESWITHSWALLOWING"))
			return getDifficultiesWithSwallowing();
		if(fieldName.equals("SWALLOWING"))
			return getSwallowing();
		if(fieldName.equals("MANUALDEXTERITY"))
			return getManualDexterity();
		if(fieldName.equals("DESCRIBEAPPETITE"))
			return getDescribeAppetite();
		if(fieldName.equals("ANYSPECIALDIET"))
			return getAnySpecialDiet();
		if(fieldName.equals("SPECIALDIET"))
			return getSpecialDiet();
		if(fieldName.equals("FOODPATIENTLIKES"))
			return getFoodPatientLikes();
		if(fieldName.equals("FOODPATIENTDISLIKES"))
			return getFoodPatientDislikes();
		if(fieldName.equals("FOODPATIENTFAVOURITE"))
			return getFoodPatientFavourite();
		if(fieldName.equals("REQUIREASSISTANCE"))
			return getRequireAssistance();
		if(fieldName.equals("MININUTRITIONALASSESSMENT"))
			return getMiniNutritionalAssessment();
		if(fieldName.equals("MNASCORE"))
			return getMNAScore();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNutritionalMethodIsNotNull()
	{
		return this.nutritionalmethod != null;
	}
	public ims.nursing.vo.lookups.NutritionalMethodCollection getNutritionalMethod()
	{
		return this.nutritionalmethod;
	}
	public void setNutritionalMethod(ims.nursing.vo.lookups.NutritionalMethodCollection value)
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
	public boolean getDifficultiesWithSwallowingIsNotNull()
	{
		return this.difficultieswithswallowing != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDifficultiesWithSwallowing()
	{
		return this.difficultieswithswallowing;
	}
	public void setDifficultiesWithSwallowing(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.difficultieswithswallowing = value;
	}
	public boolean getSwallowingIsNotNull()
	{
		return this.swallowing != null;
	}
	public ims.coe.vo.SwallowingAssessmentCollection getSwallowing()
	{
		return this.swallowing;
	}
	public void setSwallowing(ims.coe.vo.SwallowingAssessmentCollection value)
	{
		this.isValidated = false;
		this.swallowing = value;
	}
	public boolean getManualDexterityIsNotNull()
	{
		return this.manualdexterity != null;
	}
	public ims.coe.vo.ManualDexterityCollection getManualDexterity()
	{
		return this.manualdexterity;
	}
	public void setManualDexterity(ims.coe.vo.ManualDexterityCollection value)
	{
		this.isValidated = false;
		this.manualdexterity = value;
	}
	public boolean getDescribeAppetiteIsNotNull()
	{
		return this.describeappetite != null;
	}
	public ims.coe.vo.lookups.DescribeAppetite getDescribeAppetite()
	{
		return this.describeappetite;
	}
	public void setDescribeAppetite(ims.coe.vo.lookups.DescribeAppetite value)
	{
		this.isValidated = false;
		this.describeappetite = value;
	}
	public boolean getAnySpecialDietIsNotNull()
	{
		return this.anyspecialdiet != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAnySpecialDiet()
	{
		return this.anyspecialdiet;
	}
	public void setAnySpecialDiet(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.anyspecialdiet = value;
	}
	public boolean getSpecialDietIsNotNull()
	{
		return this.specialdiet != null;
	}
	public ims.nursing.vo.lookups.SpecialDiet getSpecialDiet()
	{
		return this.specialdiet;
	}
	public void setSpecialDiet(ims.nursing.vo.lookups.SpecialDiet value)
	{
		this.isValidated = false;
		this.specialdiet = value;
	}
	public boolean getFoodPatientLikesIsNotNull()
	{
		return this.foodpatientlikes != null;
	}
	public String getFoodPatientLikes()
	{
		return this.foodpatientlikes;
	}
	public static int getFoodPatientLikesMaxLength()
	{
		return 255;
	}
	public void setFoodPatientLikes(String value)
	{
		this.isValidated = false;
		this.foodpatientlikes = value;
	}
	public boolean getFoodPatientDislikesIsNotNull()
	{
		return this.foodpatientdislikes != null;
	}
	public String getFoodPatientDislikes()
	{
		return this.foodpatientdislikes;
	}
	public static int getFoodPatientDislikesMaxLength()
	{
		return 255;
	}
	public void setFoodPatientDislikes(String value)
	{
		this.isValidated = false;
		this.foodpatientdislikes = value;
	}
	public boolean getFoodPatientFavouriteIsNotNull()
	{
		return this.foodpatientfavourite != null;
	}
	public String getFoodPatientFavourite()
	{
		return this.foodpatientfavourite;
	}
	public static int getFoodPatientFavouriteMaxLength()
	{
		return 255;
	}
	public void setFoodPatientFavourite(String value)
	{
		this.isValidated = false;
		this.foodpatientfavourite = value;
	}
	public boolean getRequireAssistanceIsNotNull()
	{
		return this.requireassistance != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getRequireAssistance()
	{
		return this.requireassistance;
	}
	public void setRequireAssistance(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.requireassistance = value;
	}
	public boolean getMiniNutritionalAssessmentIsNotNull()
	{
		return this.mininutritionalassessment != null;
	}
	public ims.nursing.vo.MiniNutritionalAssessment getMiniNutritionalAssessment()
	{
		return this.mininutritionalassessment;
	}
	public void setMiniNutritionalAssessment(ims.nursing.vo.MiniNutritionalAssessment value)
	{
		this.isValidated = false;
		this.mininutritionalassessment = value;
	}
	public boolean getMNAScoreIsNotNull()
	{
		return this.mnascore != null;
	}
	public Float getMNAScore()
	{
		return this.mnascore;
	}
	public void setMNAScore(Float value)
	{
		this.isValidated = false;
		this.mnascore = value;
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
		if(this.oralassessment != null)
		{
			if(!this.oralassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.swallowing != null)
		{
			if(!this.swallowing.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.manualdexterity != null)
		{
			if(!this.manualdexterity.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.mininutritionalassessment != null)
		{
			if(!this.mininutritionalassessment.isValidated())
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
		if(this.swallowing != null)
		{
			String[] listOfOtherErrors = this.swallowing.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.manualdexterity != null)
		{
			String[] listOfOtherErrors = this.manualdexterity.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mininutritionalassessment != null)
		{
			String[] listOfOtherErrors = this.mininutritionalassessment.validate();
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
	
		AssessmentEatingAndDrinking clone = new AssessmentEatingAndDrinking(this.id, this.version);
		
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
		if(this.nutritionalmethod == null)
			clone.nutritionalmethod = null;
		else
			clone.nutritionalmethod = (ims.nursing.vo.lookups.NutritionalMethodCollection)this.nutritionalmethod.clone();
		if(this.oralassessment == null)
			clone.oralassessment = null;
		else
			clone.oralassessment = (ims.nursing.vo.OralAssessmentCollection)this.oralassessment.clone();
		if(this.difficultieswithswallowing == null)
			clone.difficultieswithswallowing = null;
		else
			clone.difficultieswithswallowing = (ims.core.vo.lookups.YesNoUnknown)this.difficultieswithswallowing.clone();
		if(this.swallowing == null)
			clone.swallowing = null;
		else
			clone.swallowing = (ims.coe.vo.SwallowingAssessmentCollection)this.swallowing.clone();
		if(this.manualdexterity == null)
			clone.manualdexterity = null;
		else
			clone.manualdexterity = (ims.coe.vo.ManualDexterityCollection)this.manualdexterity.clone();
		if(this.describeappetite == null)
			clone.describeappetite = null;
		else
			clone.describeappetite = (ims.coe.vo.lookups.DescribeAppetite)this.describeappetite.clone();
		if(this.anyspecialdiet == null)
			clone.anyspecialdiet = null;
		else
			clone.anyspecialdiet = (ims.core.vo.lookups.YesNoUnknown)this.anyspecialdiet.clone();
		if(this.specialdiet == null)
			clone.specialdiet = null;
		else
			clone.specialdiet = (ims.nursing.vo.lookups.SpecialDiet)this.specialdiet.clone();
		clone.foodpatientlikes = this.foodpatientlikes;
		clone.foodpatientdislikes = this.foodpatientdislikes;
		clone.foodpatientfavourite = this.foodpatientfavourite;
		if(this.requireassistance == null)
			clone.requireassistance = null;
		else
			clone.requireassistance = (ims.core.vo.lookups.YesNoUnknown)this.requireassistance.clone();
		if(this.mininutritionalassessment == null)
			clone.mininutritionalassessment = null;
		else
			clone.mininutritionalassessment = (ims.nursing.vo.MiniNutritionalAssessment)this.mininutritionalassessment.clone();
		clone.mnascore = this.mnascore;
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
		if (!(AssessmentEatingAndDrinking.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentEatingAndDrinking object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentEatingAndDrinking compareObj = (AssessmentEatingAndDrinking)obj;
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
		if(this.nutritionalmethod != null)
			count++;
		if(this.oralassessment != null)
			count++;
		if(this.difficultieswithswallowing != null)
			count++;
		if(this.swallowing != null)
			count++;
		if(this.manualdexterity != null)
			count++;
		if(this.describeappetite != null)
			count++;
		if(this.anyspecialdiet != null)
			count++;
		if(this.specialdiet != null)
			count++;
		if(this.foodpatientlikes != null)
			count++;
		if(this.foodpatientdislikes != null)
			count++;
		if(this.foodpatientfavourite != null)
			count++;
		if(this.requireassistance != null)
			count++;
		if(this.mininutritionalassessment != null)
			count++;
		if(this.mnascore != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 14;
	}
	protected ims.nursing.vo.lookups.NutritionalMethodCollection nutritionalmethod;
	protected ims.nursing.vo.OralAssessmentCollection oralassessment;
	protected ims.core.vo.lookups.YesNoUnknown difficultieswithswallowing;
	protected ims.coe.vo.SwallowingAssessmentCollection swallowing;
	protected ims.coe.vo.ManualDexterityCollection manualdexterity;
	protected ims.coe.vo.lookups.DescribeAppetite describeappetite;
	protected ims.core.vo.lookups.YesNoUnknown anyspecialdiet;
	protected ims.nursing.vo.lookups.SpecialDiet specialdiet;
	protected String foodpatientlikes;
	protected String foodpatientdislikes;
	protected String foodpatientfavourite;
	protected ims.core.vo.lookups.YesNoUnknown requireassistance;
	protected ims.nursing.vo.MiniNutritionalAssessment mininutritionalassessment;
	protected Float mnascore;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
