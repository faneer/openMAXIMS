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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.FrameExercise business object (ID: 1019100073).
 */
public class FrameExerciseVo extends ims.therapies.treatment.vo.FrameExerciseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FrameExerciseVo()
	{
	}
	public FrameExerciseVo(Integer id, int version)
	{
		super(id, version);
	}
	public FrameExerciseVo(ims.therapies.vo.beans.FrameExerciseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.frameexercisesupporttype = bean.getFrameExerciseSupportType() == null ? null : ims.therapies.vo.lookups.StandingSupportTypeExercise.buildLookup(bean.getFrameExerciseSupportType());
		this.frameexercisesupport = ims.therapies.vo.FrameExerciseSupportVoCollection.buildFromBeanCollection(bean.getFrameExerciseSupport());
		this.frameexercisedetails = bean.getFrameExerciseDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.FrameExerciseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.frameexercisesupporttype = bean.getFrameExerciseSupportType() == null ? null : ims.therapies.vo.lookups.StandingSupportTypeExercise.buildLookup(bean.getFrameExerciseSupportType());
		this.frameexercisesupport = ims.therapies.vo.FrameExerciseSupportVoCollection.buildFromBeanCollection(bean.getFrameExerciseSupport());
		this.frameexercisedetails = bean.getFrameExerciseDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.FrameExerciseVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.FrameExerciseVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.FrameExerciseVoBean();
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
		if(fieldName.equals("FRAMEEXERCISESUPPORTTYPE"))
			return getFrameExerciseSupportType();
		if(fieldName.equals("FRAMEEXERCISESUPPORT"))
			return getFrameExerciseSupport();
		if(fieldName.equals("FRAMEEXERCISEDETAILS"))
			return getFrameExerciseDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFrameExerciseSupportTypeIsNotNull()
	{
		return this.frameexercisesupporttype != null;
	}
	public ims.therapies.vo.lookups.StandingSupportTypeExercise getFrameExerciseSupportType()
	{
		return this.frameexercisesupporttype;
	}
	public void setFrameExerciseSupportType(ims.therapies.vo.lookups.StandingSupportTypeExercise value)
	{
		this.isValidated = false;
		this.frameexercisesupporttype = value;
	}
	public boolean getFrameExerciseSupportIsNotNull()
	{
		return this.frameexercisesupport != null;
	}
	public ims.therapies.vo.FrameExerciseSupportVoCollection getFrameExerciseSupport()
	{
		return this.frameexercisesupport;
	}
	public void setFrameExerciseSupport(ims.therapies.vo.FrameExerciseSupportVoCollection value)
	{
		this.isValidated = false;
		this.frameexercisesupport = value;
	}
	public boolean getFrameExerciseDetailsIsNotNull()
	{
		return this.frameexercisedetails != null;
	}
	public String getFrameExerciseDetails()
	{
		return this.frameexercisedetails;
	}
	public static int getFrameExerciseDetailsMaxLength()
	{
		return 255;
	}
	public void setFrameExerciseDetails(String value)
	{
		this.isValidated = false;
		this.frameexercisedetails = value;
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
		if(this.frameexercisesupport != null)
		{
			if(!this.frameexercisesupport.isValidated())
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
		if(this.frameexercisesupport != null)
		{
			String[] listOfOtherErrors = this.frameexercisesupport.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.frameexercisedetails != null)
			if(this.frameexercisedetails.length() > 255)
				listOfErrors.add("The length of the field [frameexercisedetails] in the value object [ims.therapies.vo.FrameExerciseVo] is too big. It should be less or equal to 255");
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
	
		FrameExerciseVo clone = new FrameExerciseVo(this.id, this.version);
		
		if(this.frameexercisesupporttype == null)
			clone.frameexercisesupporttype = null;
		else
			clone.frameexercisesupporttype = (ims.therapies.vo.lookups.StandingSupportTypeExercise)this.frameexercisesupporttype.clone();
		if(this.frameexercisesupport == null)
			clone.frameexercisesupport = null;
		else
			clone.frameexercisesupport = (ims.therapies.vo.FrameExerciseSupportVoCollection)this.frameexercisesupport.clone();
		clone.frameexercisedetails = this.frameexercisedetails;
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
		if (!(FrameExerciseVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FrameExerciseVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FrameExerciseVo compareObj = (FrameExerciseVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_FrameExercise() == null && compareObj.getID_FrameExercise() != null)
				return -1;
			if(this.getID_FrameExercise() != null && compareObj.getID_FrameExercise() == null)
				return 1;
			if(this.getID_FrameExercise() != null && compareObj.getID_FrameExercise() != null)
				retVal = this.getID_FrameExercise().compareTo(compareObj.getID_FrameExercise());
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
		if(this.frameexercisesupporttype != null)
			count++;
		if(this.frameexercisesupport != null)
			count++;
		if(this.frameexercisedetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.therapies.vo.lookups.StandingSupportTypeExercise frameexercisesupporttype;
	protected ims.therapies.vo.FrameExerciseSupportVoCollection frameexercisesupport;
	protected String frameexercisedetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
