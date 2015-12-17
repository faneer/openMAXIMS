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

package ims.clinical.vo;

/**
 * Linked to clinical.PatientGoal business object (ID: 1072100019).
 */
public class PatientGoalVo extends ims.clinical.vo.PatientGoalShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientGoalVo()
	{
	}
	public PatientGoalVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientGoalVo(ims.clinical.vo.beans.PatientGoalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goaltype = bean.getGoalType() == null ? null : ims.clinical.vo.lookups.GoalTerm.buildLookup(bean.getGoalType());
		this.areaofneed = bean.getAreaOfNeed() == null ? null : ims.clinical.vo.lookups.GoalAreaOfNeed.buildLookup(bean.getAreaOfNeed());
		this.goaltext = bean.getGoalText();
		this.createddatetime = bean.getCreatedDateTime() == null ? null : bean.getCreatedDateTime().buildDateTime();
		this.dateachieved = bean.getDateAchieved() == null ? null : bean.getDateAchieved().buildDate();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.target = ims.clinical.vo.PatientGoalTargetVoCollection.buildFromBeanCollection(bean.getTarget());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientGoalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goaltype = bean.getGoalType() == null ? null : ims.clinical.vo.lookups.GoalTerm.buildLookup(bean.getGoalType());
		this.areaofneed = bean.getAreaOfNeed() == null ? null : ims.clinical.vo.lookups.GoalAreaOfNeed.buildLookup(bean.getAreaOfNeed());
		this.goaltext = bean.getGoalText();
		this.createddatetime = bean.getCreatedDateTime() == null ? null : bean.getCreatedDateTime().buildDateTime();
		this.dateachieved = bean.getDateAchieved() == null ? null : bean.getDateAchieved().buildDate();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.target = ims.clinical.vo.PatientGoalTargetVoCollection.buildFromBeanCollection(bean.getTarget());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientGoalVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientGoalVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientGoalVoBean();
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
		if(fieldName.equals("TARGET"))
			return getTarget();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTargetIsNotNull()
	{
		return this.target != null;
	}
	public ims.clinical.vo.PatientGoalTargetVoCollection getTarget()
	{
		return this.target;
	}
	public void setTarget(ims.clinical.vo.PatientGoalTargetVoCollection value)
	{
		this.isValidated = false;
		this.target = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.Hcp getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
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
		if(this.target != null)
		{
			if(!this.target.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
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
		if(this.goaltype == null)
			listOfErrors.add("GoalType is mandatory");
		if(this.areaofneed == null)
			listOfErrors.add("AreaOfNeed is mandatory");
		if(this.goaltext != null)
			if(this.goaltext.length() > 255)
				listOfErrors.add("The length of the field [goaltext] in the value object [ims.clinical.vo.PatientGoalVo] is too big. It should be less or equal to 255");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.target != null)
		{
			String[] listOfOtherErrors = this.target.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
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
	
		PatientGoalVo clone = new PatientGoalVo(this.id, this.version);
		
		if(this.goaltype == null)
			clone.goaltype = null;
		else
			clone.goaltype = (ims.clinical.vo.lookups.GoalTerm)this.goaltype.clone();
		if(this.areaofneed == null)
			clone.areaofneed = null;
		else
			clone.areaofneed = (ims.clinical.vo.lookups.GoalAreaOfNeed)this.areaofneed.clone();
		clone.goaltext = this.goaltext;
		if(this.createddatetime == null)
			clone.createddatetime = null;
		else
			clone.createddatetime = (ims.framework.utils.DateTime)this.createddatetime.clone();
		if(this.dateachieved == null)
			clone.dateachieved = null;
		else
			clone.dateachieved = (ims.framework.utils.Date)this.dateachieved.clone();
		clone.carecontext = this.carecontext;
		if(this.target == null)
			clone.target = null;
		else
			clone.target = (ims.clinical.vo.PatientGoalTargetVoCollection)this.target.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.Hcp)this.authoringhcp.clone();
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
		if (!(PatientGoalVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientGoalVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientGoalVo compareObj = (PatientGoalVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientGoal() == null && compareObj.getID_PatientGoal() != null)
				return -1;
			if(this.getID_PatientGoal() != null && compareObj.getID_PatientGoal() == null)
				return 1;
			if(this.getID_PatientGoal() != null && compareObj.getID_PatientGoal() != null)
				retVal = this.getID_PatientGoal().compareTo(compareObj.getID_PatientGoal());
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
		if(this.target != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.clinical.vo.PatientGoalTargetVoCollection target;
	protected ims.core.vo.Hcp authoringhcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
