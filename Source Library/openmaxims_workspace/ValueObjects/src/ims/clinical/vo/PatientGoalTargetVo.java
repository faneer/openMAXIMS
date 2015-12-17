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
 * Linked to clinical.PatientGoalTarget business object (ID: 1072100020).
 */
public class PatientGoalTargetVo extends ims.clinical.vo.PatientGoalTargetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientGoalTargetVo()
	{
	}
	public PatientGoalTargetVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientGoalTargetVo(ims.clinical.vo.beans.PatientGoalTargetVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.target = bean.getTarget();
		this.targetdate = bean.getTargetDate() == null ? null : bean.getTargetDate().buildDate();
		this.dateachieved = bean.getDateAchieved() == null ? null : bean.getDateAchieved().buildDate();
		this.loa = bean.getLOA() == null ? null : ims.clinical.vo.lookups.LevelOfAchievement.buildLookup(bean.getLOA());
		this.reasonfornona = bean.getReasonForNonA();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientGoalTargetVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.target = bean.getTarget();
		this.targetdate = bean.getTargetDate() == null ? null : bean.getTargetDate().buildDate();
		this.dateachieved = bean.getDateAchieved() == null ? null : bean.getDateAchieved().buildDate();
		this.loa = bean.getLOA() == null ? null : ims.clinical.vo.lookups.LevelOfAchievement.buildLookup(bean.getLOA());
		this.reasonfornona = bean.getReasonForNonA();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientGoalTargetVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientGoalTargetVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientGoalTargetVoBean();
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
		if(fieldName.equals("TARGETDATE"))
			return getTargetDate();
		if(fieldName.equals("DATEACHIEVED"))
			return getDateAchieved();
		if(fieldName.equals("LOA"))
			return getLOA();
		if(fieldName.equals("REASONFORNONA"))
			return getReasonForNonA();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTargetIsNotNull()
	{
		return this.target != null;
	}
	public String getTarget()
	{
		return this.target;
	}
	public static int getTargetMaxLength()
	{
		return 500;
	}
	public void setTarget(String value)
	{
		this.isValidated = false;
		this.target = value;
	}
	public boolean getTargetDateIsNotNull()
	{
		return this.targetdate != null;
	}
	public ims.framework.utils.Date getTargetDate()
	{
		return this.targetdate;
	}
	public void setTargetDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.targetdate = value;
	}
	public boolean getDateAchievedIsNotNull()
	{
		return this.dateachieved != null;
	}
	public ims.framework.utils.Date getDateAchieved()
	{
		return this.dateachieved;
	}
	public void setDateAchieved(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateachieved = value;
	}
	public boolean getLOAIsNotNull()
	{
		return this.loa != null;
	}
	public ims.clinical.vo.lookups.LevelOfAchievement getLOA()
	{
		return this.loa;
	}
	public void setLOA(ims.clinical.vo.lookups.LevelOfAchievement value)
	{
		this.isValidated = false;
		this.loa = value;
	}
	public boolean getReasonForNonAIsNotNull()
	{
		return this.reasonfornona != null;
	}
	public String getReasonForNonA()
	{
		return this.reasonfornona;
	}
	public static int getReasonForNonAMaxLength()
	{
		return 500;
	}
	public void setReasonForNonA(String value)
	{
		this.isValidated = false;
		this.reasonfornona = value;
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
		if(this.target == null || this.target.length() == 0)
			listOfErrors.add("Target is mandatory");
		else if(this.target.length() > 500)
			listOfErrors.add("The length of the field [target] in the value object [ims.clinical.vo.PatientGoalTargetVo] is too big. It should be less or equal to 500");
		if(this.reasonfornona != null)
			if(this.reasonfornona.length() > 500)
				listOfErrors.add("The length of the field [reasonfornona] in the value object [ims.clinical.vo.PatientGoalTargetVo] is too big. It should be less or equal to 500");
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
	
		PatientGoalTargetVo clone = new PatientGoalTargetVo(this.id, this.version);
		
		clone.target = this.target;
		if(this.targetdate == null)
			clone.targetdate = null;
		else
			clone.targetdate = (ims.framework.utils.Date)this.targetdate.clone();
		if(this.dateachieved == null)
			clone.dateachieved = null;
		else
			clone.dateachieved = (ims.framework.utils.Date)this.dateachieved.clone();
		if(this.loa == null)
			clone.loa = null;
		else
			clone.loa = (ims.clinical.vo.lookups.LevelOfAchievement)this.loa.clone();
		clone.reasonfornona = this.reasonfornona;
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
		if (!(PatientGoalTargetVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientGoalTargetVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientGoalTargetVo compareObj = (PatientGoalTargetVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientGoalTarget() == null && compareObj.getID_PatientGoalTarget() != null)
				return -1;
			if(this.getID_PatientGoalTarget() != null && compareObj.getID_PatientGoalTarget() == null)
				return 1;
			if(this.getID_PatientGoalTarget() != null && compareObj.getID_PatientGoalTarget() != null)
				retVal = this.getID_PatientGoalTarget().compareTo(compareObj.getID_PatientGoalTarget());
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
		if(this.target != null)
			count++;
		if(this.targetdate != null)
			count++;
		if(this.dateachieved != null)
			count++;
		if(this.loa != null)
			count++;
		if(this.reasonfornona != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String target;
	protected ims.framework.utils.Date targetdate;
	protected ims.framework.utils.Date dateachieved;
	protected ims.clinical.vo.lookups.LevelOfAchievement loa;
	protected String reasonfornona;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
