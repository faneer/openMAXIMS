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

package ims.oncology.vo;

/**
 * Linked to Oncology.ChemoCycleDetailsCCO business object (ID: 1074100047).
 */
public class ChemoCycleDetailsCCOVo extends ims.oncology.vo.ChemoCycleDetailsCCORefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemoCycleDetailsCCOVo()
	{
	}
	public ChemoCycleDetailsCCOVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemoCycleDetailsCCOVo(ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cyclenumber = bean.getCycleNumber();
		this.cyclestartdate = bean.getCycleStartDate() == null ? null : bean.getCycleStartDate().buildDate();
		this.cycleduration = bean.getCycleDuration();
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.oncology.vo.lookups.ChemoCycleTreatmentType.buildLookup(bean.getTreatmentType());
		this.regimen = bean.getRegimen() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimen());
		this.procurementcode = bean.getProcurementCode() == null ? null : ims.oncology.vo.lookups.ProcurementCode.buildLookup(bean.getProcurementCode());
		this.dayonedeliverycode = bean.getDayOneDeliveryCode() == null ? null : ims.oncology.vo.lookups.DayOneDeliveryCode.buildLookup(bean.getDayOneDeliveryCode());
		this.deliverycodeallotherdays = bean.getDeliveryCodeAllOtherDays() == null ? null : ims.oncology.vo.lookups.DeliveryCodeAllOtherDays.buildLookup(bean.getDeliveryCodeAllOtherDays());
		this.daynumber = bean.getDayNumber();
		this.isactive = bean.getIsActive();
		this.weight = bean.getWeight();
		this.performancestatus = bean.getPerformanceStatus() == null ? null : ims.medicaloncology.vo.lookups.PerformanceStatus.buildLookup(bean.getPerformanceStatus());
		this.diaryentry = bean.getDiaryEntry() == null ? null : bean.getDiaryEntry().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cyclenumber = bean.getCycleNumber();
		this.cyclestartdate = bean.getCycleStartDate() == null ? null : bean.getCycleStartDate().buildDate();
		this.cycleduration = bean.getCycleDuration();
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.oncology.vo.lookups.ChemoCycleTreatmentType.buildLookup(bean.getTreatmentType());
		this.regimen = bean.getRegimen() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimen());
		this.procurementcode = bean.getProcurementCode() == null ? null : ims.oncology.vo.lookups.ProcurementCode.buildLookup(bean.getProcurementCode());
		this.dayonedeliverycode = bean.getDayOneDeliveryCode() == null ? null : ims.oncology.vo.lookups.DayOneDeliveryCode.buildLookup(bean.getDayOneDeliveryCode());
		this.deliverycodeallotherdays = bean.getDeliveryCodeAllOtherDays() == null ? null : ims.oncology.vo.lookups.DeliveryCodeAllOtherDays.buildLookup(bean.getDeliveryCodeAllOtherDays());
		this.daynumber = bean.getDayNumber();
		this.isactive = bean.getIsActive();
		this.weight = bean.getWeight();
		this.performancestatus = bean.getPerformanceStatus() == null ? null : ims.medicaloncology.vo.lookups.PerformanceStatus.buildLookup(bean.getPerformanceStatus());
		this.diaryentry = bean.getDiaryEntry() == null ? null : bean.getDiaryEntry().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean();
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
		if(fieldName.equals("CYCLENUMBER"))
			return getCycleNumber();
		if(fieldName.equals("CYCLESTARTDATE"))
			return getCycleStartDate();
		if(fieldName.equals("CYCLEDURATION"))
			return getCycleDuration();
		if(fieldName.equals("TREATMENTTYPE"))
			return getTreatmentType();
		if(fieldName.equals("REGIMEN"))
			return getRegimen();
		if(fieldName.equals("PROCUREMENTCODE"))
			return getProcurementCode();
		if(fieldName.equals("DAYONEDELIVERYCODE"))
			return getDayOneDeliveryCode();
		if(fieldName.equals("DELIVERYCODEALLOTHERDAYS"))
			return getDeliveryCodeAllOtherDays();
		if(fieldName.equals("DAYNUMBER"))
			return getDayNumber();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("WEIGHT"))
			return getWeight();
		if(fieldName.equals("PERFORMANCESTATUS"))
			return getPerformanceStatus();
		if(fieldName.equals("DIARYENTRY"))
			return getDiaryEntry();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCycleNumberIsNotNull()
	{
		return this.cyclenumber != null;
	}
	public Integer getCycleNumber()
	{
		return this.cyclenumber;
	}
	public void setCycleNumber(Integer value)
	{
		this.isValidated = false;
		this.cyclenumber = value;
	}
	public boolean getCycleStartDateIsNotNull()
	{
		return this.cyclestartdate != null;
	}
	public ims.framework.utils.Date getCycleStartDate()
	{
		return this.cyclestartdate;
	}
	public void setCycleStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.cyclestartdate = value;
	}
	public boolean getCycleDurationIsNotNull()
	{
		return this.cycleduration != null;
	}
	public Integer getCycleDuration()
	{
		return this.cycleduration;
	}
	public void setCycleDuration(Integer value)
	{
		this.isValidated = false;
		this.cycleduration = value;
	}
	public boolean getTreatmentTypeIsNotNull()
	{
		return this.treatmenttype != null;
	}
	public ims.oncology.vo.lookups.ChemoCycleTreatmentType getTreatmentType()
	{
		return this.treatmenttype;
	}
	public void setTreatmentType(ims.oncology.vo.lookups.ChemoCycleTreatmentType value)
	{
		this.isValidated = false;
		this.treatmenttype = value;
	}
	public boolean getRegimenIsNotNull()
	{
		return this.regimen != null;
	}
	public ims.oncology.vo.lookups.RegimenAcronym getRegimen()
	{
		return this.regimen;
	}
	public void setRegimen(ims.oncology.vo.lookups.RegimenAcronym value)
	{
		this.isValidated = false;
		this.regimen = value;
	}
	public boolean getProcurementCodeIsNotNull()
	{
		return this.procurementcode != null;
	}
	public ims.oncology.vo.lookups.ProcurementCode getProcurementCode()
	{
		return this.procurementcode;
	}
	public void setProcurementCode(ims.oncology.vo.lookups.ProcurementCode value)
	{
		this.isValidated = false;
		this.procurementcode = value;
	}
	public boolean getDayOneDeliveryCodeIsNotNull()
	{
		return this.dayonedeliverycode != null;
	}
	public ims.oncology.vo.lookups.DayOneDeliveryCode getDayOneDeliveryCode()
	{
		return this.dayonedeliverycode;
	}
	public void setDayOneDeliveryCode(ims.oncology.vo.lookups.DayOneDeliveryCode value)
	{
		this.isValidated = false;
		this.dayonedeliverycode = value;
	}
	public boolean getDeliveryCodeAllOtherDaysIsNotNull()
	{
		return this.deliverycodeallotherdays != null;
	}
	public ims.oncology.vo.lookups.DeliveryCodeAllOtherDays getDeliveryCodeAllOtherDays()
	{
		return this.deliverycodeallotherdays;
	}
	public void setDeliveryCodeAllOtherDays(ims.oncology.vo.lookups.DeliveryCodeAllOtherDays value)
	{
		this.isValidated = false;
		this.deliverycodeallotherdays = value;
	}
	public boolean getDayNumberIsNotNull()
	{
		return this.daynumber != null;
	}
	public Integer getDayNumber()
	{
		return this.daynumber;
	}
	public void setDayNumber(Integer value)
	{
		this.isValidated = false;
		this.daynumber = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getWeightIsNotNull()
	{
		return this.weight != null;
	}
	public Integer getWeight()
	{
		return this.weight;
	}
	public void setWeight(Integer value)
	{
		this.isValidated = false;
		this.weight = value;
	}
	public boolean getPerformanceStatusIsNotNull()
	{
		return this.performancestatus != null;
	}
	public ims.medicaloncology.vo.lookups.PerformanceStatus getPerformanceStatus()
	{
		return this.performancestatus;
	}
	public void setPerformanceStatus(ims.medicaloncology.vo.lookups.PerformanceStatus value)
	{
		this.isValidated = false;
		this.performancestatus = value;
	}
	public boolean getDiaryEntryIsNotNull()
	{
		return this.diaryentry != null;
	}
	public ims.core.vo.PatientApptDiaryVo getDiaryEntry()
	{
		return this.diaryentry;
	}
	public void setDiaryEntry(ims.core.vo.PatientApptDiaryVo value)
	{
		this.isValidated = false;
		this.diaryentry = value;
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
		if(this.diaryentry != null)
		{
			if(!this.diaryentry.isValidated())
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
		if(this.cyclenumber == null)
			listOfErrors.add("CycleNumber is mandatory");
		if(this.cyclestartdate == null)
			listOfErrors.add("CycleStartDate is mandatory");
		if(this.treatmenttype == null)
			listOfErrors.add("TreatmentType is mandatory");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.diaryentry != null)
		{
			String[] listOfOtherErrors = this.diaryentry.validate();
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
	
		ChemoCycleDetailsCCOVo clone = new ChemoCycleDetailsCCOVo(this.id, this.version);
		
		clone.cyclenumber = this.cyclenumber;
		if(this.cyclestartdate == null)
			clone.cyclestartdate = null;
		else
			clone.cyclestartdate = (ims.framework.utils.Date)this.cyclestartdate.clone();
		clone.cycleduration = this.cycleduration;
		if(this.treatmenttype == null)
			clone.treatmenttype = null;
		else
			clone.treatmenttype = (ims.oncology.vo.lookups.ChemoCycleTreatmentType)this.treatmenttype.clone();
		if(this.regimen == null)
			clone.regimen = null;
		else
			clone.regimen = (ims.oncology.vo.lookups.RegimenAcronym)this.regimen.clone();
		if(this.procurementcode == null)
			clone.procurementcode = null;
		else
			clone.procurementcode = (ims.oncology.vo.lookups.ProcurementCode)this.procurementcode.clone();
		if(this.dayonedeliverycode == null)
			clone.dayonedeliverycode = null;
		else
			clone.dayonedeliverycode = (ims.oncology.vo.lookups.DayOneDeliveryCode)this.dayonedeliverycode.clone();
		if(this.deliverycodeallotherdays == null)
			clone.deliverycodeallotherdays = null;
		else
			clone.deliverycodeallotherdays = (ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)this.deliverycodeallotherdays.clone();
		clone.daynumber = this.daynumber;
		clone.isactive = this.isactive;
		clone.weight = this.weight;
		if(this.performancestatus == null)
			clone.performancestatus = null;
		else
			clone.performancestatus = (ims.medicaloncology.vo.lookups.PerformanceStatus)this.performancestatus.clone();
		if(this.diaryentry == null)
			clone.diaryentry = null;
		else
			clone.diaryentry = (ims.core.vo.PatientApptDiaryVo)this.diaryentry.clone();
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
		if (!(ChemoCycleDetailsCCOVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemoCycleDetailsCCOVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChemoCycleDetailsCCOVo compareObj = (ChemoCycleDetailsCCOVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCycleStartDate() == null && compareObj.getCycleStartDate() != null)
				return -1;
			if(this.getCycleStartDate() != null && compareObj.getCycleStartDate() == null)
				return 1;
			if(this.getCycleStartDate() != null && compareObj.getCycleStartDate() != null)
				retVal = this.getCycleStartDate().compareTo(compareObj.getCycleStartDate());
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
		if(this.cyclenumber != null)
			count++;
		if(this.cyclestartdate != null)
			count++;
		if(this.cycleduration != null)
			count++;
		if(this.treatmenttype != null)
			count++;
		if(this.regimen != null)
			count++;
		if(this.procurementcode != null)
			count++;
		if(this.dayonedeliverycode != null)
			count++;
		if(this.deliverycodeallotherdays != null)
			count++;
		if(this.daynumber != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.weight != null)
			count++;
		if(this.performancestatus != null)
			count++;
		if(this.diaryentry != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected Integer cyclenumber;
	protected ims.framework.utils.Date cyclestartdate;
	protected Integer cycleduration;
	protected ims.oncology.vo.lookups.ChemoCycleTreatmentType treatmenttype;
	protected ims.oncology.vo.lookups.RegimenAcronym regimen;
	protected ims.oncology.vo.lookups.ProcurementCode procurementcode;
	protected ims.oncology.vo.lookups.DayOneDeliveryCode dayonedeliverycode;
	protected ims.oncology.vo.lookups.DeliveryCodeAllOtherDays deliverycodeallotherdays;
	protected Integer daynumber;
	protected Boolean isactive;
	protected Integer weight;
	protected ims.medicaloncology.vo.lookups.PerformanceStatus performancestatus;
	protected ims.core.vo.PatientApptDiaryVo diaryentry;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
