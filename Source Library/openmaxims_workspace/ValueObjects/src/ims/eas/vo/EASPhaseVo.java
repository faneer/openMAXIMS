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

package ims.eas.vo;

/**
 * Linked to EAS.EASPhase business object (ID: 1113100002).
 */
public class EASPhaseVo extends ims.eas.vo.EASPhaseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EASPhaseVo()
	{
	}
	public EASPhaseVo(Integer id, int version)
	{
		super(id, version);
	}
	public EASPhaseVo(ims.eas.vo.beans.EASPhaseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phasename = bean.getPhaseName() == null ? null : ims.eas.vo.lookups.PhaseNames.buildLookup(bean.getPhaseName());
		this.dose = bean.getDose();
		this.fractions = bean.getFractions();
		this.days = bean.getDays();
		this.energy = bean.getEnergy();
		this.units = bean.getUnits() == null ? null : ims.ccosched.vo.lookups.Unit.buildLookup(bean.getUnits());
		this.modality = bean.getModality() == null ? null : ims.ccosched.vo.lookups.Modality.buildLookup(bean.getModality());
		this.preferred = bean.getPreferred();
		this.provisional = bean.getProvisional();
		this.selected = bean.getSelected();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.EASPhaseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phasename = bean.getPhaseName() == null ? null : ims.eas.vo.lookups.PhaseNames.buildLookup(bean.getPhaseName());
		this.dose = bean.getDose();
		this.fractions = bean.getFractions();
		this.days = bean.getDays();
		this.energy = bean.getEnergy();
		this.units = bean.getUnits() == null ? null : ims.ccosched.vo.lookups.Unit.buildLookup(bean.getUnits());
		this.modality = bean.getModality() == null ? null : ims.ccosched.vo.lookups.Modality.buildLookup(bean.getModality());
		this.preferred = bean.getPreferred();
		this.provisional = bean.getProvisional();
		this.selected = bean.getSelected();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.EASPhaseVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.EASPhaseVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.EASPhaseVoBean();
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
		if(fieldName.equals("PHASENAME"))
			return getPhaseName();
		if(fieldName.equals("DOSE"))
			return getDose();
		if(fieldName.equals("FRACTIONS"))
			return getFractions();
		if(fieldName.equals("DAYS"))
			return getDays();
		if(fieldName.equals("ENERGY"))
			return getEnergy();
		if(fieldName.equals("UNITS"))
			return getUnits();
		if(fieldName.equals("MODALITY"))
			return getModality();
		if(fieldName.equals("PREFERRED"))
			return getPreferred();
		if(fieldName.equals("PROVISIONAL"))
			return getProvisional();
		if(fieldName.equals("SELECTED"))
			return getSelected();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPhaseNameIsNotNull()
	{
		return this.phasename != null;
	}
	public ims.eas.vo.lookups.PhaseNames getPhaseName()
	{
		return this.phasename;
	}
	public void setPhaseName(ims.eas.vo.lookups.PhaseNames value)
	{
		this.isValidated = false;
		this.phasename = value;
	}
	public boolean getDoseIsNotNull()
	{
		return this.dose != null;
	}
	public Float getDose()
	{
		return this.dose;
	}
	public void setDose(Float value)
	{
		this.isValidated = false;
		this.dose = value;
	}
	public boolean getFractionsIsNotNull()
	{
		return this.fractions != null;
	}
	public Integer getFractions()
	{
		return this.fractions;
	}
	public void setFractions(Integer value)
	{
		this.isValidated = false;
		this.fractions = value;
	}
	public boolean getDaysIsNotNull()
	{
		return this.days != null;
	}
	public Integer getDays()
	{
		return this.days;
	}
	public void setDays(Integer value)
	{
		this.isValidated = false;
		this.days = value;
	}
	public boolean getEnergyIsNotNull()
	{
		return this.energy != null;
	}
	public Float getEnergy()
	{
		return this.energy;
	}
	public void setEnergy(Float value)
	{
		this.isValidated = false;
		this.energy = value;
	}
	public boolean getUnitsIsNotNull()
	{
		return this.units != null;
	}
	public ims.ccosched.vo.lookups.Unit getUnits()
	{
		return this.units;
	}
	public void setUnits(ims.ccosched.vo.lookups.Unit value)
	{
		this.isValidated = false;
		this.units = value;
	}
	public boolean getModalityIsNotNull()
	{
		return this.modality != null;
	}
	public ims.ccosched.vo.lookups.Modality getModality()
	{
		return this.modality;
	}
	public void setModality(ims.ccosched.vo.lookups.Modality value)
	{
		this.isValidated = false;
		this.modality = value;
	}
	public boolean getPreferredIsNotNull()
	{
		return this.preferred != null;
	}
	public Boolean getPreferred()
	{
		return this.preferred;
	}
	public void setPreferred(Boolean value)
	{
		this.isValidated = false;
		this.preferred = value;
	}
	public boolean getProvisionalIsNotNull()
	{
		return this.provisional != null;
	}
	public Boolean getProvisional()
	{
		return this.provisional;
	}
	public void setProvisional(Boolean value)
	{
		this.isValidated = false;
		this.provisional = value;
	}
	public boolean getSelectedIsNotNull()
	{
		return this.selected != null;
	}
	public Boolean getSelected()
	{
		return this.selected;
	}
	public void setSelected(Boolean value)
	{
		this.isValidated = false;
		this.selected = value;
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
		if(this.phasename == null)
			listOfErrors.add("PhaseName is mandatory");
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
	
		EASPhaseVo clone = new EASPhaseVo(this.id, this.version);
		
		if(this.phasename == null)
			clone.phasename = null;
		else
			clone.phasename = (ims.eas.vo.lookups.PhaseNames)this.phasename.clone();
		clone.dose = this.dose;
		clone.fractions = this.fractions;
		clone.days = this.days;
		clone.energy = this.energy;
		if(this.units == null)
			clone.units = null;
		else
			clone.units = (ims.ccosched.vo.lookups.Unit)this.units.clone();
		if(this.modality == null)
			clone.modality = null;
		else
			clone.modality = (ims.ccosched.vo.lookups.Modality)this.modality.clone();
		clone.preferred = this.preferred;
		clone.provisional = this.provisional;
		clone.selected = this.selected;
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
		if (!(EASPhaseVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EASPhaseVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EASPhaseVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EASPhaseVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.phasename != null)
			count++;
		if(this.dose != null)
			count++;
		if(this.fractions != null)
			count++;
		if(this.days != null)
			count++;
		if(this.energy != null)
			count++;
		if(this.units != null)
			count++;
		if(this.modality != null)
			count++;
		if(this.preferred != null)
			count++;
		if(this.provisional != null)
			count++;
		if(this.selected != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.eas.vo.lookups.PhaseNames phasename;
	protected Float dose;
	protected Integer fractions;
	protected Integer days;
	protected Float energy;
	protected ims.ccosched.vo.lookups.Unit units;
	protected ims.ccosched.vo.lookups.Modality modality;
	protected Boolean preferred;
	protected Boolean provisional;
	protected Boolean selected;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
