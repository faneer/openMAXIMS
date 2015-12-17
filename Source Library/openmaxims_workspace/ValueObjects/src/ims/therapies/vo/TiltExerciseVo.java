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
 * Linked to therapies.treatment.TiltExercise business object (ID: 1019100074).
 */
public class TiltExerciseVo extends ims.therapies.treatment.vo.TiltExerciseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TiltExerciseVo()
	{
	}
	public TiltExerciseVo(Integer id, int version)
	{
		super(id, version);
	}
	public TiltExerciseVo(ims.therapies.vo.beans.TiltExerciseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.supporttype = bean.getSupportType() == null ? null : ims.therapies.vo.lookups.StandingSupportTypeExercise.buildLookup(bean.getSupportType());
		this.tiltsupportexercise = ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection.buildFromBeanCollection(bean.getTiltSupportExercise());
		this.degrees = bean.getDegrees();
		this.duration = bean.getDuration();
		this.tiltexercisedetails = bean.getTiltExerciseDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.TiltExerciseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.supporttype = bean.getSupportType() == null ? null : ims.therapies.vo.lookups.StandingSupportTypeExercise.buildLookup(bean.getSupportType());
		this.tiltsupportexercise = ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection.buildFromBeanCollection(bean.getTiltSupportExercise());
		this.degrees = bean.getDegrees();
		this.duration = bean.getDuration();
		this.tiltexercisedetails = bean.getTiltExerciseDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.TiltExerciseVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.TiltExerciseVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.TiltExerciseVoBean();
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
		if(fieldName.equals("SUPPORTTYPE"))
			return getSupportType();
		if(fieldName.equals("TILTSUPPORTEXERCISE"))
			return getTiltSupportExercise();
		if(fieldName.equals("DEGREES"))
			return getDegrees();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("TILTEXERCISEDETAILS"))
			return getTiltExerciseDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSupportTypeIsNotNull()
	{
		return this.supporttype != null;
	}
	public ims.therapies.vo.lookups.StandingSupportTypeExercise getSupportType()
	{
		return this.supporttype;
	}
	public void setSupportType(ims.therapies.vo.lookups.StandingSupportTypeExercise value)
	{
		this.isValidated = false;
		this.supporttype = value;
	}
	public boolean getTiltSupportExerciseIsNotNull()
	{
		return this.tiltsupportexercise != null;
	}
	public ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection getTiltSupportExercise()
	{
		return this.tiltsupportexercise;
	}
	public void setTiltSupportExercise(ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection value)
	{
		this.isValidated = false;
		this.tiltsupportexercise = value;
	}
	public boolean getDegreesIsNotNull()
	{
		return this.degrees != null;
	}
	public Integer getDegrees()
	{
		return this.degrees;
	}
	public void setDegrees(Integer value)
	{
		this.isValidated = false;
		this.degrees = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getTiltExerciseDetailsIsNotNull()
	{
		return this.tiltexercisedetails != null;
	}
	public String getTiltExerciseDetails()
	{
		return this.tiltexercisedetails;
	}
	public static int getTiltExerciseDetailsMaxLength()
	{
		return 255;
	}
	public void setTiltExerciseDetails(String value)
	{
		this.isValidated = false;
		this.tiltexercisedetails = value;
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
		if(this.tiltexercisedetails != null)
			if(this.tiltexercisedetails.length() > 255)
				listOfErrors.add("The length of the field [tiltexercisedetails] in the value object [ims.therapies.vo.TiltExerciseVo] is too big. It should be less or equal to 255");
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
	
		TiltExerciseVo clone = new TiltExerciseVo(this.id, this.version);
		
		if(this.supporttype == null)
			clone.supporttype = null;
		else
			clone.supporttype = (ims.therapies.vo.lookups.StandingSupportTypeExercise)this.supporttype.clone();
		if(this.tiltsupportexercise == null)
			clone.tiltsupportexercise = null;
		else
			clone.tiltsupportexercise = (ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection)this.tiltsupportexercise.clone();
		clone.degrees = this.degrees;
		clone.duration = this.duration;
		clone.tiltexercisedetails = this.tiltexercisedetails;
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
		if (!(TiltExerciseVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TiltExerciseVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TiltExerciseVo compareObj = (TiltExerciseVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_TiltExercise() == null && compareObj.getID_TiltExercise() != null)
				return -1;
			if(this.getID_TiltExercise() != null && compareObj.getID_TiltExercise() == null)
				return 1;
			if(this.getID_TiltExercise() != null && compareObj.getID_TiltExercise() != null)
				retVal = this.getID_TiltExercise().compareTo(compareObj.getID_TiltExercise());
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
		if(this.supporttype != null)
			count++;
		if(this.tiltsupportexercise != null)
			count++;
		if(this.degrees != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.tiltexercisedetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.therapies.vo.lookups.StandingSupportTypeExercise supporttype;
	protected ims.therapies.vo.lookups.StandingSupportTypeExerciseCollection tiltsupportexercise;
	protected Integer degrees;
	protected Integer duration;
	protected String tiltexercisedetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
