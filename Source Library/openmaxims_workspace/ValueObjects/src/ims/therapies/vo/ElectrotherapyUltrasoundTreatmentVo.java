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
 * Linked to therapies.treatment.ElectrotherapyUltrasoundTreatment business object (ID: 1019100027).
 */
public class ElectrotherapyUltrasoundTreatmentVo extends ims.therapies.treatment.vo.ElectrotherapyUltrasoundTreatmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ElectrotherapyUltrasoundTreatmentVo()
	{
	}
	public ElectrotherapyUltrasoundTreatmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public ElectrotherapyUltrasoundTreatmentVo(ims.therapies.vo.beans.ElectrotherapyUltrasoundTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.target = bean.getTarget() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea.buildLookup(bean.getTarget());
		this.areatreated = bean.getAreaTreated() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea.buildLookup(bean.getAreaTreated());
		this.muscleaspect = bean.getMuscleAspect() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect.buildLookup(bean.getMuscleAspect());
		this.wave = bean.getWave() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundWave.buildLookup(bean.getWave());
		this.pulse = bean.getPulse() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundPulse.buildLookup(bean.getPulse());
		this.duration = bean.getDuration();
		this.frequency = bean.getFrequency() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundFreq.buildLookup(bean.getFrequency());
		this.intensity = bean.getIntensity() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundIntensity.buildLookup(bean.getIntensity());
		this.comment = bean.getComment();
		this.machineused = bean.getMachineUsed() == null ? null : bean.getMachineUsed().buildVo();
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.ElectrotherapyUltrasoundTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.target = bean.getTarget() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea.buildLookup(bean.getTarget());
		this.areatreated = bean.getAreaTreated() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea.buildLookup(bean.getAreaTreated());
		this.muscleaspect = bean.getMuscleAspect() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect.buildLookup(bean.getMuscleAspect());
		this.wave = bean.getWave() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundWave.buildLookup(bean.getWave());
		this.pulse = bean.getPulse() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundPulse.buildLookup(bean.getPulse());
		this.duration = bean.getDuration();
		this.frequency = bean.getFrequency() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundFreq.buildLookup(bean.getFrequency());
		this.intensity = bean.getIntensity() == null ? null : ims.spinalinjuries.vo.lookups.UltrasoundIntensity.buildLookup(bean.getIntensity());
		this.comment = bean.getComment();
		this.machineused = bean.getMachineUsed() == null ? null : bean.getMachineUsed().buildVo(map);
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.ElectrotherapyUltrasoundTreatmentVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.ElectrotherapyUltrasoundTreatmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.ElectrotherapyUltrasoundTreatmentVoBean();
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
		if(fieldName.equals("AREATREATED"))
			return getAreaTreated();
		if(fieldName.equals("MUSCLEASPECT"))
			return getMuscleAspect();
		if(fieldName.equals("WAVE"))
			return getWave();
		if(fieldName.equals("PULSE"))
			return getPulse();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("INTENSITY"))
			return getIntensity();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("MACHINEUSED"))
			return getMachineUsed();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTargetIsNotNull()
	{
		return this.target != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea getTarget()
	{
		return this.target;
	}
	public void setTarget(ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea value)
	{
		this.isValidated = false;
		this.target = value;
	}
	public boolean getAreaTreatedIsNotNull()
	{
		return this.areatreated != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea getAreaTreated()
	{
		return this.areatreated;
	}
	public void setAreaTreated(ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea value)
	{
		this.isValidated = false;
		this.areatreated = value;
	}
	public boolean getMuscleAspectIsNotNull()
	{
		return this.muscleaspect != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect getMuscleAspect()
	{
		return this.muscleaspect;
	}
	public void setMuscleAspect(ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect value)
	{
		this.isValidated = false;
		this.muscleaspect = value;
	}
	public boolean getWaveIsNotNull()
	{
		return this.wave != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundWave getWave()
	{
		return this.wave;
	}
	public void setWave(ims.spinalinjuries.vo.lookups.UltrasoundWave value)
	{
		this.isValidated = false;
		this.wave = value;
	}
	public boolean getPulseIsNotNull()
	{
		return this.pulse != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundPulse getPulse()
	{
		return this.pulse;
	}
	public void setPulse(ims.spinalinjuries.vo.lookups.UltrasoundPulse value)
	{
		this.isValidated = false;
		this.pulse = value;
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
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundFreq getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.spinalinjuries.vo.lookups.UltrasoundFreq value)
	{
		this.isValidated = false;
		this.frequency = value;
	}
	public boolean getIntensityIsNotNull()
	{
		return this.intensity != null;
	}
	public ims.spinalinjuries.vo.lookups.UltrasoundIntensity getIntensity()
	{
		return this.intensity;
	}
	public void setIntensity(ims.spinalinjuries.vo.lookups.UltrasoundIntensity value)
	{
		this.isValidated = false;
		this.intensity = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getMachineUsedIsNotNull()
	{
		return this.machineused != null;
	}
	public ims.therapies.vo.TreatmentEquipmentConfigVo getMachineUsed()
	{
		return this.machineused;
	}
	public void setMachineUsed(ims.therapies.vo.TreatmentEquipmentConfigVo value)
	{
		this.isValidated = false;
		this.machineused = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRB getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRB value)
	{
		this.isValidated = false;
		this.laterality = value;
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
		if(this.machineused != null)
		{
			if(!this.machineused.isValidated())
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
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.therapies.vo.ElectrotherapyUltrasoundTreatmentVo] is too big. It should be less or equal to 255");
		if(this.machineused != null)
		{
			String[] listOfOtherErrors = this.machineused.validate();
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
	
		ElectrotherapyUltrasoundTreatmentVo clone = new ElectrotherapyUltrasoundTreatmentVo(this.id, this.version);
		
		if(this.target == null)
			clone.target = null;
		else
			clone.target = (ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea)this.target.clone();
		if(this.areatreated == null)
			clone.areatreated = null;
		else
			clone.areatreated = (ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea)this.areatreated.clone();
		if(this.muscleaspect == null)
			clone.muscleaspect = null;
		else
			clone.muscleaspect = (ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)this.muscleaspect.clone();
		if(this.wave == null)
			clone.wave = null;
		else
			clone.wave = (ims.spinalinjuries.vo.lookups.UltrasoundWave)this.wave.clone();
		if(this.pulse == null)
			clone.pulse = null;
		else
			clone.pulse = (ims.spinalinjuries.vo.lookups.UltrasoundPulse)this.pulse.clone();
		clone.duration = this.duration;
		if(this.frequency == null)
			clone.frequency = null;
		else
			clone.frequency = (ims.spinalinjuries.vo.lookups.UltrasoundFreq)this.frequency.clone();
		if(this.intensity == null)
			clone.intensity = null;
		else
			clone.intensity = (ims.spinalinjuries.vo.lookups.UltrasoundIntensity)this.intensity.clone();
		clone.comment = this.comment;
		if(this.machineused == null)
			clone.machineused = null;
		else
			clone.machineused = (ims.therapies.vo.TreatmentEquipmentConfigVo)this.machineused.clone();
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRB)this.laterality.clone();
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
		if (!(ElectrotherapyUltrasoundTreatmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ElectrotherapyUltrasoundTreatmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ElectrotherapyUltrasoundTreatmentVo compareObj = (ElectrotherapyUltrasoundTreatmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ElectrotherapyUltrasoundTreatment() == null && compareObj.getID_ElectrotherapyUltrasoundTreatment() != null)
				return -1;
			if(this.getID_ElectrotherapyUltrasoundTreatment() != null && compareObj.getID_ElectrotherapyUltrasoundTreatment() == null)
				return 1;
			if(this.getID_ElectrotherapyUltrasoundTreatment() != null && compareObj.getID_ElectrotherapyUltrasoundTreatment() != null)
				retVal = this.getID_ElectrotherapyUltrasoundTreatment().compareTo(compareObj.getID_ElectrotherapyUltrasoundTreatment());
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
		if(this.areatreated != null)
			count++;
		if(this.muscleaspect != null)
			count++;
		if(this.wave != null)
			count++;
		if(this.pulse != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.intensity != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.machineused != null)
			count++;
		if(this.laterality != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea target;
	protected ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea areatreated;
	protected ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect muscleaspect;
	protected ims.spinalinjuries.vo.lookups.UltrasoundWave wave;
	protected ims.spinalinjuries.vo.lookups.UltrasoundPulse pulse;
	protected Integer duration;
	protected ims.spinalinjuries.vo.lookups.UltrasoundFreq frequency;
	protected ims.spinalinjuries.vo.lookups.UltrasoundIntensity intensity;
	protected String comment;
	protected ims.therapies.vo.TreatmentEquipmentConfigVo machineused;
	protected ims.core.vo.lookups.LateralityLRB laterality;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
