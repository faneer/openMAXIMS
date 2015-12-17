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

package ims.generalmedical.vo;

/**
 * Linked to medical.OPDSpasticityAssessTreat business object (ID: 1031100005).
 */
public class OPDSpasticityAssessTreatVo extends ims.medical.vo.OPDSpasticityAssessTreatRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OPDSpasticityAssessTreatVo()
	{
	}
	public OPDSpasticityAssessTreatVo(Integer id, int version)
	{
		super(id, version);
	}
	public OPDSpasticityAssessTreatVo(ims.generalmedical.vo.beans.OPDSpasticityAssessTreatVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatgoals = ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection.buildFromBeanCollection(bean.getTreatGoals());
		this.treatmentplan = ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection.buildFromBeanCollection(bean.getTreatmentPlan());
		this.botulismtreatment = ims.spinalinjuries.vo.lookups.SABotulinmCollection.buildFromBeanCollection(bean.getBotulismTreatment());
		this.jointcontracture = bean.getJointContracture();
		this.limbfinding = ims.generalmedical.vo.OPDSpasAssLimbsVoCollection.buildFromBeanCollection(bean.getLimbFinding());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.OPDSpasticityAssessTreatVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatgoals = ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection.buildFromBeanCollection(bean.getTreatGoals());
		this.treatmentplan = ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection.buildFromBeanCollection(bean.getTreatmentPlan());
		this.botulismtreatment = ims.spinalinjuries.vo.lookups.SABotulinmCollection.buildFromBeanCollection(bean.getBotulismTreatment());
		this.jointcontracture = bean.getJointContracture();
		this.limbfinding = ims.generalmedical.vo.OPDSpasAssLimbsVoCollection.buildFromBeanCollection(bean.getLimbFinding());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.OPDSpasticityAssessTreatVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.OPDSpasticityAssessTreatVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.OPDSpasticityAssessTreatVoBean();
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
		if(fieldName.equals("TREATGOALS"))
			return getTreatGoals();
		if(fieldName.equals("TREATMENTPLAN"))
			return getTreatmentPlan();
		if(fieldName.equals("BOTULISMTREATMENT"))
			return getBotulismTreatment();
		if(fieldName.equals("JOINTCONTRACTURE"))
			return getJointContracture();
		if(fieldName.equals("LIMBFINDING"))
			return getLimbFinding();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatGoalsIsNotNull()
	{
		return this.treatgoals != null;
	}
	public ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection getTreatGoals()
	{
		return this.treatgoals;
	}
	public void setTreatGoals(ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection value)
	{
		this.isValidated = false;
		this.treatgoals = value;
	}
	public boolean getTreatmentPlanIsNotNull()
	{
		return this.treatmentplan != null;
	}
	public ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection getTreatmentPlan()
	{
		return this.treatmentplan;
	}
	public void setTreatmentPlan(ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection value)
	{
		this.isValidated = false;
		this.treatmentplan = value;
	}
	public boolean getBotulismTreatmentIsNotNull()
	{
		return this.botulismtreatment != null;
	}
	public ims.spinalinjuries.vo.lookups.SABotulinmCollection getBotulismTreatment()
	{
		return this.botulismtreatment;
	}
	public void setBotulismTreatment(ims.spinalinjuries.vo.lookups.SABotulinmCollection value)
	{
		this.isValidated = false;
		this.botulismtreatment = value;
	}
	public boolean getJointContractureIsNotNull()
	{
		return this.jointcontracture != null;
	}
	public String getJointContracture()
	{
		return this.jointcontracture;
	}
	public static int getJointContractureMaxLength()
	{
		return 500;
	}
	public void setJointContracture(String value)
	{
		this.isValidated = false;
		this.jointcontracture = value;
	}
	public boolean getLimbFindingIsNotNull()
	{
		return this.limbfinding != null;
	}
	public ims.generalmedical.vo.OPDSpasAssLimbsVoCollection getLimbFinding()
	{
		return this.limbfinding;
	}
	public void setLimbFinding(ims.generalmedical.vo.OPDSpasAssLimbsVoCollection value)
	{
		this.isValidated = false;
		this.limbfinding = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(this.treatgoals != null)
		{
			if(!this.treatgoals.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.limbfinding != null)
		{
			if(!this.limbfinding.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.treatgoals != null)
		{
			String[] listOfOtherErrors = this.treatgoals.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.jointcontracture != null)
			if(this.jointcontracture.length() > 500)
				listOfErrors.add("The length of the field [jointcontracture] in the value object [ims.generalmedical.vo.OPDSpasticityAssessTreatVo] is too big. It should be less or equal to 500");
		if(this.limbfinding != null)
		{
			String[] listOfOtherErrors = this.limbfinding.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		OPDSpasticityAssessTreatVo clone = new OPDSpasticityAssessTreatVo(this.id, this.version);
		
		if(this.treatgoals == null)
			clone.treatgoals = null;
		else
			clone.treatgoals = (ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection)this.treatgoals.clone();
		if(this.treatmentplan == null)
			clone.treatmentplan = null;
		else
			clone.treatmentplan = (ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection)this.treatmentplan.clone();
		if(this.botulismtreatment == null)
			clone.botulismtreatment = null;
		else
			clone.botulismtreatment = (ims.spinalinjuries.vo.lookups.SABotulinmCollection)this.botulismtreatment.clone();
		clone.jointcontracture = this.jointcontracture;
		if(this.limbfinding == null)
			clone.limbfinding = null;
		else
			clone.limbfinding = (ims.generalmedical.vo.OPDSpasAssLimbsVoCollection)this.limbfinding.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(OPDSpasticityAssessTreatVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OPDSpasticityAssessTreatVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OPDSpasticityAssessTreatVo compareObj = (OPDSpasticityAssessTreatVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OPDSpasticityAssessTreat() == null && compareObj.getID_OPDSpasticityAssessTreat() != null)
				return -1;
			if(this.getID_OPDSpasticityAssessTreat() != null && compareObj.getID_OPDSpasticityAssessTreat() == null)
				return 1;
			if(this.getID_OPDSpasticityAssessTreat() != null && compareObj.getID_OPDSpasticityAssessTreat() != null)
				retVal = this.getID_OPDSpasticityAssessTreat().compareTo(compareObj.getID_OPDSpasticityAssessTreat());
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
		if(this.treatgoals != null)
			count++;
		if(this.treatmentplan != null)
			count++;
		if(this.botulismtreatment != null)
			count++;
		if(this.jointcontracture != null)
			count++;
		if(this.limbfinding != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection treatgoals;
	protected ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection treatmentplan;
	protected ims.spinalinjuries.vo.lookups.SABotulinmCollection botulismtreatment;
	protected String jointcontracture;
	protected ims.generalmedical.vo.OPDSpasAssLimbsVoCollection limbfinding;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
