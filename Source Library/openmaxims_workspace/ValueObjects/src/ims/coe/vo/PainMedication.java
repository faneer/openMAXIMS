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
 * Linked to coe.assessment.Pain Medication business object (ID: 1012100033).
 */
public class PainMedication extends ims.coe.assessment.vo.PainMedicationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PainMedication()
	{
	}
	public PainMedication(Integer id, int version)
	{
		super(id, version);
	}
	public PainMedication(ims.coe.vo.beans.PainMedicationBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : ims.coe.vo.lookups.PainMedication.buildLookup(bean.getMedication());
		this.other = bean.getOther();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.dose = bean.getDose();
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequency());
		this.takenwithanything = bean.getTakenWithAnything();
		this.effectivefor = bean.getEffectiveFor();
		this.iscurrentlyactive = bean.getIsCurrentlyActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.PainMedicationBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : ims.coe.vo.lookups.PainMedication.buildLookup(bean.getMedication());
		this.other = bean.getOther();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.dose = bean.getDose();
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequency());
		this.takenwithanything = bean.getTakenWithAnything();
		this.effectivefor = bean.getEffectiveFor();
		this.iscurrentlyactive = bean.getIsCurrentlyActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.PainMedicationBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.PainMedicationBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.PainMedicationBean();
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
		if(fieldName.equals("MEDICATION"))
			return getMedication();
		if(fieldName.equals("OTHER"))
			return getOther();
		if(fieldName.equals("ROUTE"))
			return getRoute();
		if(fieldName.equals("DOSE"))
			return getDose();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("TAKENWITHANYTHING"))
			return getTakenWithAnything();
		if(fieldName.equals("EFFECTIVEFOR"))
			return getEffectiveFor();
		if(fieldName.equals("ISCURRENTLYACTIVE"))
			return getIsCurrentlyActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public ims.coe.vo.lookups.PainMedication getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.coe.vo.lookups.PainMedication value)
	{
		this.isValidated = false;
		this.medication = value;
	}
	public boolean getOtherIsNotNull()
	{
		return this.other != null;
	}
	public String getOther()
	{
		return this.other;
	}
	public static int getOtherMaxLength()
	{
		return 255;
	}
	public void setOther(String value)
	{
		this.isValidated = false;
		this.other = value;
	}
	public boolean getRouteIsNotNull()
	{
		return this.route != null;
	}
	public ims.core.vo.lookups.MedicationRoute getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.core.vo.lookups.MedicationRoute value)
	{
		this.isValidated = false;
		this.route = value;
	}
	public boolean getDoseIsNotNull()
	{
		return this.dose != null;
	}
	public String getDose()
	{
		return this.dose;
	}
	public static int getDoseMaxLength()
	{
		return 255;
	}
	public void setDose(String value)
	{
		this.isValidated = false;
		this.dose = value;
	}
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public ims.core.vo.lookups.MedicationFrequency getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.core.vo.lookups.MedicationFrequency value)
	{
		this.isValidated = false;
		this.frequency = value;
	}
	public boolean getTakenWithAnythingIsNotNull()
	{
		return this.takenwithanything != null;
	}
	public String getTakenWithAnything()
	{
		return this.takenwithanything;
	}
	public static int getTakenWithAnythingMaxLength()
	{
		return 255;
	}
	public void setTakenWithAnything(String value)
	{
		this.isValidated = false;
		this.takenwithanything = value;
	}
	public boolean getEffectiveForIsNotNull()
	{
		return this.effectivefor != null;
	}
	public String getEffectiveFor()
	{
		return this.effectivefor;
	}
	public static int getEffectiveForMaxLength()
	{
		return 255;
	}
	public void setEffectiveFor(String value)
	{
		this.isValidated = false;
		this.effectivefor = value;
	}
	public boolean getIsCurrentlyActiveIsNotNull()
	{
		return this.iscurrentlyactive != null;
	}
	public Boolean getIsCurrentlyActive()
	{
		return this.iscurrentlyactive;
	}
	public void setIsCurrentlyActive(Boolean value)
	{
		this.isValidated = false;
		this.iscurrentlyactive = value;
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
	
		PainMedication clone = new PainMedication(this.id, this.version);
		
		if(this.medication == null)
			clone.medication = null;
		else
			clone.medication = (ims.coe.vo.lookups.PainMedication)this.medication.clone();
		clone.other = this.other;
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
		clone.dose = this.dose;
		if(this.frequency == null)
			clone.frequency = null;
		else
			clone.frequency = (ims.core.vo.lookups.MedicationFrequency)this.frequency.clone();
		clone.takenwithanything = this.takenwithanything;
		clone.effectivefor = this.effectivefor;
		clone.iscurrentlyactive = this.iscurrentlyactive;
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
		if (!(PainMedication.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PainMedication object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PainMedication compareObj = (PainMedication)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMedication() == null && compareObj.getMedication() != null)
				return -1;
			if(this.getMedication() != null && compareObj.getMedication() == null)
				return 1;
			if(this.getMedication() != null && compareObj.getMedication() != null)
				retVal = this.getMedication().compareTo(compareObj.getMedication());
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
		if(this.medication != null)
			count++;
		if(this.other != null)
			count++;
		if(this.route != null)
			count++;
		if(this.dose != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.takenwithanything != null)
			count++;
		if(this.effectivefor != null)
			count++;
		if(this.iscurrentlyactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.coe.vo.lookups.PainMedication medication;
	protected String other;
	protected ims.core.vo.lookups.MedicationRoute route;
	protected String dose;
	protected ims.core.vo.lookups.MedicationFrequency frequency;
	protected String takenwithanything;
	protected String effectivefor;
	protected Boolean iscurrentlyactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
