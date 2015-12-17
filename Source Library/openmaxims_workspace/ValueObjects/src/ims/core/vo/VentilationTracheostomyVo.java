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

package ims.core.vo;

/**
 * Linked to core.vitals.VentilationTracheostomy business object (ID: 1022100013).
 */
public class VentilationTracheostomyVo extends ims.core.vitals.vo.VentilationTracheostomyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VentilationTracheostomyVo()
	{
	}
	public VentilationTracheostomyVo(Integer id, int version)
	{
		super(id, version);
	}
	public VentilationTracheostomyVo(ims.core.vo.beans.VentilationTracheostomyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.breathsspontaneously = bean.getBreathsSpontaneously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBreathsSpontaneously());
		this.patientintubated = bean.getPatientIntubated() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientIntubated());
		this.intubationmethod = bean.getIntubationMethod();
		this.patientventilated = bean.getPatientVentilated() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientVentilated());
		this.typeofventilator = bean.getTypeOfVentilator() == null ? null : ims.core.vo.lookups.VentilatorType.buildLookup(bean.getTypeOfVentilator());
		this.modeofventilation = bean.getModeOfVentilation() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getModeOfVentilation());
		this.requiresatracheostomy = bean.getRequiresATracheostomy() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRequiresATracheostomy());
		this.tracheostomytype = bean.getTracheostomyType() == null ? null : ims.core.vo.lookups.TracheostomyType.buildLookup(bean.getTracheostomyType());
		this.tracheostomyaccessories = bean.getTracheostomyAccessories() == null ? null : ims.core.vo.lookups.TracheostomyAccessories.buildLookup(bean.getTracheostomyAccessories());
		this.sizecpapvalve = bean.getSizeCPAPValve();
		this.sizeoftracheostomy = bean.getSizeOfTracheostomy();
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.datelastchange = bean.getDateLastChange() == null ? null : bean.getDateLastChange().buildDate();
		this.datenextchange = bean.getDateNextChange() == null ? null : bean.getDateNextChange().buildDate();
		this.dateremoved = bean.getDateRemoved() == null ? null : bean.getDateRemoved().buildDate();
		this.notes = bean.getNotes();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VentilationTracheostomyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.breathsspontaneously = bean.getBreathsSpontaneously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBreathsSpontaneously());
		this.patientintubated = bean.getPatientIntubated() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientIntubated());
		this.intubationmethod = bean.getIntubationMethod();
		this.patientventilated = bean.getPatientVentilated() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPatientVentilated());
		this.typeofventilator = bean.getTypeOfVentilator() == null ? null : ims.core.vo.lookups.VentilatorType.buildLookup(bean.getTypeOfVentilator());
		this.modeofventilation = bean.getModeOfVentilation() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getModeOfVentilation());
		this.requiresatracheostomy = bean.getRequiresATracheostomy() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getRequiresATracheostomy());
		this.tracheostomytype = bean.getTracheostomyType() == null ? null : ims.core.vo.lookups.TracheostomyType.buildLookup(bean.getTracheostomyType());
		this.tracheostomyaccessories = bean.getTracheostomyAccessories() == null ? null : ims.core.vo.lookups.TracheostomyAccessories.buildLookup(bean.getTracheostomyAccessories());
		this.sizecpapvalve = bean.getSizeCPAPValve();
		this.sizeoftracheostomy = bean.getSizeOfTracheostomy();
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.datelastchange = bean.getDateLastChange() == null ? null : bean.getDateLastChange().buildDate();
		this.datenextchange = bean.getDateNextChange() == null ? null : bean.getDateNextChange().buildDate();
		this.dateremoved = bean.getDateRemoved() == null ? null : bean.getDateRemoved().buildDate();
		this.notes = bean.getNotes();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VentilationTracheostomyVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VentilationTracheostomyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VentilationTracheostomyVoBean();
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
		if(fieldName.equals("BREATHSSPONTANEOUSLY"))
			return getBreathsSpontaneously();
		if(fieldName.equals("PATIENTINTUBATED"))
			return getPatientIntubated();
		if(fieldName.equals("INTUBATIONMETHOD"))
			return getIntubationMethod();
		if(fieldName.equals("PATIENTVENTILATED"))
			return getPatientVentilated();
		if(fieldName.equals("TYPEOFVENTILATOR"))
			return getTypeOfVentilator();
		if(fieldName.equals("MODEOFVENTILATION"))
			return getModeOfVentilation();
		if(fieldName.equals("REQUIRESATRACHEOSTOMY"))
			return getRequiresATracheostomy();
		if(fieldName.equals("TRACHEOSTOMYTYPE"))
			return getTracheostomyType();
		if(fieldName.equals("TRACHEOSTOMYACCESSORIES"))
			return getTracheostomyAccessories();
		if(fieldName.equals("SIZECPAPVALVE"))
			return getSizeCPAPValve();
		if(fieldName.equals("SIZEOFTRACHEOSTOMY"))
			return getSizeOfTracheostomy();
		if(fieldName.equals("DATEINSERTED"))
			return getDateInserted();
		if(fieldName.equals("DATELASTCHANGE"))
			return getDateLastChange();
		if(fieldName.equals("DATENEXTCHANGE"))
			return getDateNextChange();
		if(fieldName.equals("DATEREMOVED"))
			return getDateRemoved();
		if(fieldName.equals("NOTES"))
			return getNotes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBreathsSpontaneouslyIsNotNull()
	{
		return this.breathsspontaneously != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getBreathsSpontaneously()
	{
		return this.breathsspontaneously;
	}
	public void setBreathsSpontaneously(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.breathsspontaneously = value;
	}
	public boolean getPatientIntubatedIsNotNull()
	{
		return this.patientintubated != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPatientIntubated()
	{
		return this.patientintubated;
	}
	public void setPatientIntubated(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.patientintubated = value;
	}
	public boolean getIntubationMethodIsNotNull()
	{
		return this.intubationmethod != null;
	}
	public String getIntubationMethod()
	{
		return this.intubationmethod;
	}
	public static int getIntubationMethodMaxLength()
	{
		return 255;
	}
	public void setIntubationMethod(String value)
	{
		this.isValidated = false;
		this.intubationmethod = value;
	}
	public boolean getPatientVentilatedIsNotNull()
	{
		return this.patientventilated != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPatientVentilated()
	{
		return this.patientventilated;
	}
	public void setPatientVentilated(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.patientventilated = value;
	}
	public boolean getTypeOfVentilatorIsNotNull()
	{
		return this.typeofventilator != null;
	}
	public ims.core.vo.lookups.VentilatorType getTypeOfVentilator()
	{
		return this.typeofventilator;
	}
	public void setTypeOfVentilator(ims.core.vo.lookups.VentilatorType value)
	{
		this.isValidated = false;
		this.typeofventilator = value;
	}
	public boolean getModeOfVentilationIsNotNull()
	{
		return this.modeofventilation != null;
	}
	public ims.core.vo.lookups.VentilationMode getModeOfVentilation()
	{
		return this.modeofventilation;
	}
	public void setModeOfVentilation(ims.core.vo.lookups.VentilationMode value)
	{
		this.isValidated = false;
		this.modeofventilation = value;
	}
	public boolean getRequiresATracheostomyIsNotNull()
	{
		return this.requiresatracheostomy != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getRequiresATracheostomy()
	{
		return this.requiresatracheostomy;
	}
	public void setRequiresATracheostomy(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.requiresatracheostomy = value;
	}
	public boolean getTracheostomyTypeIsNotNull()
	{
		return this.tracheostomytype != null;
	}
	public ims.core.vo.lookups.TracheostomyType getTracheostomyType()
	{
		return this.tracheostomytype;
	}
	public void setTracheostomyType(ims.core.vo.lookups.TracheostomyType value)
	{
		this.isValidated = false;
		this.tracheostomytype = value;
	}
	public boolean getTracheostomyAccessoriesIsNotNull()
	{
		return this.tracheostomyaccessories != null;
	}
	public ims.core.vo.lookups.TracheostomyAccessories getTracheostomyAccessories()
	{
		return this.tracheostomyaccessories;
	}
	public void setTracheostomyAccessories(ims.core.vo.lookups.TracheostomyAccessories value)
	{
		this.isValidated = false;
		this.tracheostomyaccessories = value;
	}
	public boolean getSizeCPAPValveIsNotNull()
	{
		return this.sizecpapvalve != null;
	}
	public String getSizeCPAPValve()
	{
		return this.sizecpapvalve;
	}
	public static int getSizeCPAPValveMaxLength()
	{
		return 255;
	}
	public void setSizeCPAPValve(String value)
	{
		this.isValidated = false;
		this.sizecpapvalve = value;
	}
	public boolean getSizeOfTracheostomyIsNotNull()
	{
		return this.sizeoftracheostomy != null;
	}
	public String getSizeOfTracheostomy()
	{
		return this.sizeoftracheostomy;
	}
	public static int getSizeOfTracheostomyMaxLength()
	{
		return 255;
	}
	public void setSizeOfTracheostomy(String value)
	{
		this.isValidated = false;
		this.sizeoftracheostomy = value;
	}
	public boolean getDateInsertedIsNotNull()
	{
		return this.dateinserted != null;
	}
	public ims.framework.utils.Date getDateInserted()
	{
		return this.dateinserted;
	}
	public void setDateInserted(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateinserted = value;
	}
	public boolean getDateLastChangeIsNotNull()
	{
		return this.datelastchange != null;
	}
	public ims.framework.utils.Date getDateLastChange()
	{
		return this.datelastchange;
	}
	public void setDateLastChange(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datelastchange = value;
	}
	public boolean getDateNextChangeIsNotNull()
	{
		return this.datenextchange != null;
	}
	public ims.framework.utils.Date getDateNextChange()
	{
		return this.datenextchange;
	}
	public void setDateNextChange(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datenextchange = value;
	}
	public boolean getDateRemovedIsNotNull()
	{
		return this.dateremoved != null;
	}
	public ims.framework.utils.Date getDateRemoved()
	{
		return this.dateremoved;
	}
	public void setDateRemoved(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateremoved = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 500;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
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
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.core.vo.VentilationTracheostomyVo] is too big. It should be less or equal to 500");
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
	
		VentilationTracheostomyVo clone = new VentilationTracheostomyVo(this.id, this.version);
		
		if(this.breathsspontaneously == null)
			clone.breathsspontaneously = null;
		else
			clone.breathsspontaneously = (ims.core.vo.lookups.YesNoUnknown)this.breathsspontaneously.clone();
		if(this.patientintubated == null)
			clone.patientintubated = null;
		else
			clone.patientintubated = (ims.core.vo.lookups.YesNoUnknown)this.patientintubated.clone();
		clone.intubationmethod = this.intubationmethod;
		if(this.patientventilated == null)
			clone.patientventilated = null;
		else
			clone.patientventilated = (ims.core.vo.lookups.YesNoUnknown)this.patientventilated.clone();
		if(this.typeofventilator == null)
			clone.typeofventilator = null;
		else
			clone.typeofventilator = (ims.core.vo.lookups.VentilatorType)this.typeofventilator.clone();
		if(this.modeofventilation == null)
			clone.modeofventilation = null;
		else
			clone.modeofventilation = (ims.core.vo.lookups.VentilationMode)this.modeofventilation.clone();
		if(this.requiresatracheostomy == null)
			clone.requiresatracheostomy = null;
		else
			clone.requiresatracheostomy = (ims.core.vo.lookups.YesNoUnknown)this.requiresatracheostomy.clone();
		if(this.tracheostomytype == null)
			clone.tracheostomytype = null;
		else
			clone.tracheostomytype = (ims.core.vo.lookups.TracheostomyType)this.tracheostomytype.clone();
		if(this.tracheostomyaccessories == null)
			clone.tracheostomyaccessories = null;
		else
			clone.tracheostomyaccessories = (ims.core.vo.lookups.TracheostomyAccessories)this.tracheostomyaccessories.clone();
		clone.sizecpapvalve = this.sizecpapvalve;
		clone.sizeoftracheostomy = this.sizeoftracheostomy;
		if(this.dateinserted == null)
			clone.dateinserted = null;
		else
			clone.dateinserted = (ims.framework.utils.Date)this.dateinserted.clone();
		if(this.datelastchange == null)
			clone.datelastchange = null;
		else
			clone.datelastchange = (ims.framework.utils.Date)this.datelastchange.clone();
		if(this.datenextchange == null)
			clone.datenextchange = null;
		else
			clone.datenextchange = (ims.framework.utils.Date)this.datenextchange.clone();
		if(this.dateremoved == null)
			clone.dateremoved = null;
		else
			clone.dateremoved = (ims.framework.utils.Date)this.dateremoved.clone();
		clone.notes = this.notes;
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
		if (!(VentilationTracheostomyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VentilationTracheostomyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VentilationTracheostomyVo compareObj = (VentilationTracheostomyVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_VentilationTracheostomy() == null && compareObj.getID_VentilationTracheostomy() != null)
				return -1;
			if(this.getID_VentilationTracheostomy() != null && compareObj.getID_VentilationTracheostomy() == null)
				return 1;
			if(this.getID_VentilationTracheostomy() != null && compareObj.getID_VentilationTracheostomy() != null)
				retVal = this.getID_VentilationTracheostomy().compareTo(compareObj.getID_VentilationTracheostomy());
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
		if(this.breathsspontaneously != null)
			count++;
		if(this.patientintubated != null)
			count++;
		if(this.intubationmethod != null)
			count++;
		if(this.patientventilated != null)
			count++;
		if(this.typeofventilator != null)
			count++;
		if(this.modeofventilation != null)
			count++;
		if(this.requiresatracheostomy != null)
			count++;
		if(this.tracheostomytype != null)
			count++;
		if(this.tracheostomyaccessories != null)
			count++;
		if(this.sizecpapvalve != null)
			count++;
		if(this.sizeoftracheostomy != null)
			count++;
		if(this.dateinserted != null)
			count++;
		if(this.datelastchange != null)
			count++;
		if(this.datenextchange != null)
			count++;
		if(this.dateremoved != null)
			count++;
		if(this.notes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 16;
	}
	protected ims.core.vo.lookups.YesNoUnknown breathsspontaneously;
	protected ims.core.vo.lookups.YesNoUnknown patientintubated;
	protected String intubationmethod;
	protected ims.core.vo.lookups.YesNoUnknown patientventilated;
	protected ims.core.vo.lookups.VentilatorType typeofventilator;
	protected ims.core.vo.lookups.VentilationMode modeofventilation;
	protected ims.core.vo.lookups.YesNoUnknown requiresatracheostomy;
	protected ims.core.vo.lookups.TracheostomyType tracheostomytype;
	protected ims.core.vo.lookups.TracheostomyAccessories tracheostomyaccessories;
	protected String sizecpapvalve;
	protected String sizeoftracheostomy;
	protected ims.framework.utils.Date dateinserted;
	protected ims.framework.utils.Date datelastchange;
	protected ims.framework.utils.Date datenextchange;
	protected ims.framework.utils.Date dateremoved;
	protected String notes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
