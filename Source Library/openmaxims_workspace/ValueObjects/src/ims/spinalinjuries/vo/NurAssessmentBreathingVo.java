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
public class NurAssessmentBreathingVo extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurAssessmentBreathingVo()
	{
	}
	public NurAssessmentBreathingVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurAssessmentBreathingVo(ims.spinalinjuries.vo.beans.NurAssessmentBreathingVoBean bean)
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
		this.smoking = bean.getSmoking() == null ? null : bean.getSmoking().buildVo();
		this.ventilationtrachyeostomy = bean.getVentilationTrachyeostomy() == null ? null : bean.getVentilationTrachyeostomy().buildVo();
		this.breathingmedication = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getBreathingMedication());
		this.difficultybreathing = bean.getDifficultyBreathing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultyBreathing());
		this.breathingdyspnoea = ims.nursing.vo.lookups.BreathingDyspnoeaCollection.buildFromBeanCollection(bean.getBreathingDyspnoea());
		this.acutechronic = bean.getAcuteChronic() == null ? null : ims.nursing.vo.lookups.BreathingAcuteChronic.buildLookup(bean.getAcuteChronic());
		this.breathingtreatment = ims.nursing.vo.lookups.BreathingTreatmentCollection.buildFromBeanCollection(bean.getBreathingTreatment());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.NurAssessmentBreathingVoBean bean)
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
		this.smoking = bean.getSmoking() == null ? null : bean.getSmoking().buildVo(map);
		this.ventilationtrachyeostomy = bean.getVentilationTrachyeostomy() == null ? null : bean.getVentilationTrachyeostomy().buildVo(map);
		this.breathingmedication = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getBreathingMedication());
		this.difficultybreathing = bean.getDifficultyBreathing() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultyBreathing());
		this.breathingdyspnoea = ims.nursing.vo.lookups.BreathingDyspnoeaCollection.buildFromBeanCollection(bean.getBreathingDyspnoea());
		this.acutechronic = bean.getAcuteChronic() == null ? null : ims.nursing.vo.lookups.BreathingAcuteChronic.buildLookup(bean.getAcuteChronic());
		this.breathingtreatment = ims.nursing.vo.lookups.BreathingTreatmentCollection.buildFromBeanCollection(bean.getBreathingTreatment());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.NurAssessmentBreathingVoBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.NurAssessmentBreathingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.NurAssessmentBreathingVoBean();
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
		if(fieldName.equals("SMOKING"))
			return getSmoking();
		if(fieldName.equals("VENTILATIONTRACHYEOSTOMY"))
			return getVentilationTrachyeostomy();
		if(fieldName.equals("BREATHINGMEDICATION"))
			return getBreathingMedication();
		if(fieldName.equals("DIFFICULTYBREATHING"))
			return getDifficultyBreathing();
		if(fieldName.equals("BREATHINGDYSPNOEA"))
			return getBreathingDyspnoea();
		if(fieldName.equals("ACUTECHRONIC"))
			return getAcuteChronic();
		if(fieldName.equals("BREATHINGTREATMENT"))
			return getBreathingTreatment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSmokingIsNotNull()
	{
		return this.smoking != null;
	}
	public ims.core.vo.Smoking getSmoking()
	{
		return this.smoking;
	}
	public void setSmoking(ims.core.vo.Smoking value)
	{
		this.isValidated = false;
		this.smoking = value;
	}
	public boolean getVentilationTrachyeostomyIsNotNull()
	{
		return this.ventilationtrachyeostomy != null;
	}
	public ims.core.vo.VentilationTracheostomyVo getVentilationTrachyeostomy()
	{
		return this.ventilationtrachyeostomy;
	}
	public void setVentilationTrachyeostomy(ims.core.vo.VentilationTracheostomyVo value)
	{
		this.isValidated = false;
		this.ventilationtrachyeostomy = value;
	}
	public boolean getBreathingMedicationIsNotNull()
	{
		return this.breathingmedication != null;
	}
	public ims.core.vo.PatientMedicationVoCollection getBreathingMedication()
	{
		return this.breathingmedication;
	}
	public void setBreathingMedication(ims.core.vo.PatientMedicationVoCollection value)
	{
		this.isValidated = false;
		this.breathingmedication = value;
	}
	public boolean getDifficultyBreathingIsNotNull()
	{
		return this.difficultybreathing != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDifficultyBreathing()
	{
		return this.difficultybreathing;
	}
	public void setDifficultyBreathing(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.difficultybreathing = value;
	}
	public boolean getBreathingDyspnoeaIsNotNull()
	{
		return this.breathingdyspnoea != null;
	}
	public ims.nursing.vo.lookups.BreathingDyspnoeaCollection getBreathingDyspnoea()
	{
		return this.breathingdyspnoea;
	}
	public void setBreathingDyspnoea(ims.nursing.vo.lookups.BreathingDyspnoeaCollection value)
	{
		this.isValidated = false;
		this.breathingdyspnoea = value;
	}
	public boolean getAcuteChronicIsNotNull()
	{
		return this.acutechronic != null;
	}
	public ims.nursing.vo.lookups.BreathingAcuteChronic getAcuteChronic()
	{
		return this.acutechronic;
	}
	public void setAcuteChronic(ims.nursing.vo.lookups.BreathingAcuteChronic value)
	{
		this.isValidated = false;
		this.acutechronic = value;
	}
	public boolean getBreathingTreatmentIsNotNull()
	{
		return this.breathingtreatment != null;
	}
	public ims.nursing.vo.lookups.BreathingTreatmentCollection getBreathingTreatment()
	{
		return this.breathingtreatment;
	}
	public void setBreathingTreatment(ims.nursing.vo.lookups.BreathingTreatmentCollection value)
	{
		this.isValidated = false;
		this.breathingtreatment = value;
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
		if(this.smoking != null)
		{
			if(!this.smoking.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ventilationtrachyeostomy != null)
		{
			if(!this.ventilationtrachyeostomy.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.breathingmedication != null)
		{
			if(!this.breathingmedication.isValidated())
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
		if(this.smoking != null)
		{
			String[] listOfOtherErrors = this.smoking.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ventilationtrachyeostomy != null)
		{
			String[] listOfOtherErrors = this.ventilationtrachyeostomy.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.breathingmedication != null)
		{
			String[] listOfOtherErrors = this.breathingmedication.validate();
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
	
		NurAssessmentBreathingVo clone = new NurAssessmentBreathingVo(this.id, this.version);
		
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
		if(this.smoking == null)
			clone.smoking = null;
		else
			clone.smoking = (ims.core.vo.Smoking)this.smoking.clone();
		if(this.ventilationtrachyeostomy == null)
			clone.ventilationtrachyeostomy = null;
		else
			clone.ventilationtrachyeostomy = (ims.core.vo.VentilationTracheostomyVo)this.ventilationtrachyeostomy.clone();
		if(this.breathingmedication == null)
			clone.breathingmedication = null;
		else
			clone.breathingmedication = (ims.core.vo.PatientMedicationVoCollection)this.breathingmedication.clone();
		if(this.difficultybreathing == null)
			clone.difficultybreathing = null;
		else
			clone.difficultybreathing = (ims.core.vo.lookups.YesNoUnknown)this.difficultybreathing.clone();
		if(this.breathingdyspnoea == null)
			clone.breathingdyspnoea = null;
		else
			clone.breathingdyspnoea = (ims.nursing.vo.lookups.BreathingDyspnoeaCollection)this.breathingdyspnoea.clone();
		if(this.acutechronic == null)
			clone.acutechronic = null;
		else
			clone.acutechronic = (ims.nursing.vo.lookups.BreathingAcuteChronic)this.acutechronic.clone();
		if(this.breathingtreatment == null)
			clone.breathingtreatment = null;
		else
			clone.breathingtreatment = (ims.nursing.vo.lookups.BreathingTreatmentCollection)this.breathingtreatment.clone();
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
		if (!(NurAssessmentBreathingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurAssessmentBreathingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NurAssessmentBreathingVo compareObj = (NurAssessmentBreathingVo)obj;
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
		if(this.smoking != null)
			count++;
		if(this.ventilationtrachyeostomy != null)
			count++;
		if(this.breathingmedication != null)
			count++;
		if(this.difficultybreathing != null)
			count++;
		if(this.breathingdyspnoea != null)
			count++;
		if(this.acutechronic != null)
			count++;
		if(this.breathingtreatment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.core.vo.Smoking smoking;
	protected ims.core.vo.VentilationTracheostomyVo ventilationtrachyeostomy;
	protected ims.core.vo.PatientMedicationVoCollection breathingmedication;
	protected ims.core.vo.lookups.YesNoUnknown difficultybreathing;
	protected ims.nursing.vo.lookups.BreathingDyspnoeaCollection breathingdyspnoea;
	protected ims.nursing.vo.lookups.BreathingAcuteChronic acutechronic;
	protected ims.nursing.vo.lookups.BreathingTreatmentCollection breathingtreatment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
