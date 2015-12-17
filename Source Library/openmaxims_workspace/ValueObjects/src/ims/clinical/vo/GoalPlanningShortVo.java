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
 * Linked to clinical.GoalPlanning business object (ID: 1072100059).
 */
public class GoalPlanningShortVo extends ims.clinical.vo.GoalPlanningRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GoalPlanningShortVo()
	{
	}
	public GoalPlanningShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public GoalPlanningShortVo(ims.clinical.vo.beans.GoalPlanningShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goalplanningdate = bean.getGoalPlanningDate() == null ? null : bean.getGoalPlanningDate().buildDate();
		this.goalplanningoutcome = bean.getGoalPlanningOutcome() == null ? null : ims.clinical.vo.lookups.GoalPlanningOutcome.buildLookup(bean.getGoalPlanningOutcome());
		this.comments = bean.getComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.GoalPlanningShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goalplanningdate = bean.getGoalPlanningDate() == null ? null : bean.getGoalPlanningDate().buildDate();
		this.goalplanningoutcome = bean.getGoalPlanningOutcome() == null ? null : ims.clinical.vo.lookups.GoalPlanningOutcome.buildLookup(bean.getGoalPlanningOutcome());
		this.comments = bean.getComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.GoalPlanningShortVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.GoalPlanningShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.GoalPlanningShortVoBean();
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
		if(fieldName.equals("GOALPLANNINGDATE"))
			return getGoalPlanningDate();
		if(fieldName.equals("GOALPLANNINGOUTCOME"))
			return getGoalPlanningOutcome();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGoalPlanningDateIsNotNull()
	{
		return this.goalplanningdate != null;
	}
	public ims.framework.utils.Date getGoalPlanningDate()
	{
		return this.goalplanningdate;
	}
	public void setGoalPlanningDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.goalplanningdate = value;
	}
	public boolean getGoalPlanningOutcomeIsNotNull()
	{
		return this.goalplanningoutcome != null;
	}
	public ims.clinical.vo.lookups.GoalPlanningOutcome getGoalPlanningOutcome()
	{
		return this.goalplanningoutcome;
	}
	public void setGoalPlanningOutcome(ims.clinical.vo.lookups.GoalPlanningOutcome value)
	{
		this.isValidated = false;
		this.goalplanningoutcome = value;
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
		return 2000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
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
		if(this.goalplanningdate == null)
			listOfErrors.add("GoalPlanningDate is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 2000)
				listOfErrors.add("The length of the field [comments] in the value object [ims.clinical.vo.GoalPlanningShortVo] is too big. It should be less or equal to 2000");
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
	
		GoalPlanningShortVo clone = new GoalPlanningShortVo(this.id, this.version);
		
		if(this.goalplanningdate == null)
			clone.goalplanningdate = null;
		else
			clone.goalplanningdate = (ims.framework.utils.Date)this.goalplanningdate.clone();
		if(this.goalplanningoutcome == null)
			clone.goalplanningoutcome = null;
		else
			clone.goalplanningoutcome = (ims.clinical.vo.lookups.GoalPlanningOutcome)this.goalplanningoutcome.clone();
		clone.comments = this.comments;
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
		if (!(GoalPlanningShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GoalPlanningShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GoalPlanningShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GoalPlanningShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.goalplanningdate != null)
			count++;
		if(this.goalplanningoutcome != null)
			count++;
		if(this.comments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Date goalplanningdate;
	protected ims.clinical.vo.lookups.GoalPlanningOutcome goalplanningoutcome;
	protected String comments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
