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
 * Linked to eDischarge.TTAMedicationDetail business object (ID: 1099100016).
 */
public class TTAMedicationDetailVo extends ims.clinical.vo.TTAMedicationDetailLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public TTAMedicationDetailVo()
	{
	}
	public TTAMedicationDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public TTAMedicationDetailVo(ims.clinical.vo.beans.TTAMedicationDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermedicationtext = bean.getOtherMedicationText();
		this.dosevalue = bean.getDoseValue();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.form = bean.getForm() == null ? null : ims.clinical.vo.lookups.DoseFormIndicator.buildLookup(bean.getForm());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.frequencyvalue = bean.getFrequencyValue();
		this.frequencyunit = bean.getFrequencyUnit() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyUnit());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo();
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.clinical.vo.lookups.MedicationDuration.buildLookup(bean.getDurationUnit());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.clinicalcommentsforpharmacy = bean.getClinicalCommentsForPharmacy();
		this.medicationinstructionsforpatient = bean.getMedicationInstructionsForPatient();
		this.prescribercontacted = bean.getPrescriberContacted();
		this.unittext = bean.getUnitText();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TTAMedicationDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermedicationtext = bean.getOtherMedicationText();
		this.dosevalue = bean.getDoseValue();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.form = bean.getForm() == null ? null : ims.clinical.vo.lookups.DoseFormIndicator.buildLookup(bean.getForm());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.frequencyvalue = bean.getFrequencyValue();
		this.frequencyunit = bean.getFrequencyUnit() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyUnit());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo(map);
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.clinical.vo.lookups.MedicationDuration.buildLookup(bean.getDurationUnit());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.clinicalcommentsforpharmacy = bean.getClinicalCommentsForPharmacy();
		this.medicationinstructionsforpatient = bean.getMedicationInstructionsForPatient();
		this.prescribercontacted = bean.getPrescriberContacted();
		this.unittext = bean.getUnitText();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TTAMedicationDetailVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TTAMedicationDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TTAMedicationDetailVoBean();
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
		if(fieldName.equals("DURATIONVALUE"))
			return getDurationValue();
		if(fieldName.equals("DURATIONUNIT"))
			return getDurationUnit();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CLINICALCOMMENTSFORPHARMACY"))
			return getClinicalCommentsForPharmacy();
		if(fieldName.equals("MEDICATIONINSTRUCTIONSFORPATIENT"))
			return getMedicationInstructionsForPatient();
		if(fieldName.equals("PRESCRIBERCONTACTED"))
			return getPrescriberContacted();
		if(fieldName.equals("UNITTEXT"))
			return getUnitText();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDurationValueIsNotNull()
	{
		return this.durationvalue != null;
	}
	public Integer getDurationValue()
	{
		return this.durationvalue;
	}
	public void setDurationValue(Integer value)
	{
		this.isValidated = false;
		this.durationvalue = value;
	}
	public boolean getDurationUnitIsNotNull()
	{
		return this.durationunit != null;
	}
	public ims.clinical.vo.lookups.MedicationDuration getDurationUnit()
	{
		return this.durationunit;
	}
	public void setDurationUnit(ims.clinical.vo.lookups.MedicationDuration value)
	{
		this.isValidated = false;
		this.durationunit = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getClinicalCommentsForPharmacyIsNotNull()
	{
		return this.clinicalcommentsforpharmacy != null;
	}
	public String getClinicalCommentsForPharmacy()
	{
		return this.clinicalcommentsforpharmacy;
	}
	public static int getClinicalCommentsForPharmacyMaxLength()
	{
		return 1000;
	}
	public void setClinicalCommentsForPharmacy(String value)
	{
		this.isValidated = false;
		this.clinicalcommentsforpharmacy = value;
	}
	public boolean getMedicationInstructionsForPatientIsNotNull()
	{
		return this.medicationinstructionsforpatient != null;
	}
	public String getMedicationInstructionsForPatient()
	{
		return this.medicationinstructionsforpatient;
	}
	public static int getMedicationInstructionsForPatientMaxLength()
	{
		return 1000;
	}
	public void setMedicationInstructionsForPatient(String value)
	{
		this.isValidated = false;
		this.medicationinstructionsforpatient = value;
	}
	public boolean getPrescriberContactedIsNotNull()
	{
		return this.prescribercontacted != null;
	}
	public Boolean getPrescriberContacted()
	{
		return this.prescribercontacted;
	}
	public void setPrescriberContacted(Boolean value)
	{
		this.isValidated = false;
		this.prescribercontacted = value;
	}
	public boolean getUnitTextIsNotNull()
	{
		return this.unittext != null;
	}
	public String getUnitText()
	{
		return this.unittext;
	}
	public static int getUnitTextMaxLength()
	{
		return 40;
	}
	public void setUnitText(String value)
	{
		this.isValidated = false;
		this.unittext = value;
	}
	/**
	* IClinicalCodingValue Interface Methods
	*/
	public ims.vo.ValueObject getIClinicalCodingValue() 
	{
		return this.medication;
	}
	public void setIClinicalCodingValue(ims.vo.ValueObject vo) 
	{
		this.medication = (ims.core.vo.MedicationLiteVo) vo;
	}
	public String getIClinicalCodingValueDescription() 
	{
		return this.othermedicationtext;
	}
	public void setIClinicalCodingValueDescription(String value) 
	{
		this.othermedicationtext = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.othermedicationtext == null || this.othermedicationtext.length() == 0)
			listOfErrors.add("OtherMedicationText is mandatory");
		else if(this.othermedicationtext.length() > 700)
			listOfErrors.add("The length of the field [othermedicationtext] in the value object [ims.clinical.vo.TTAMedicationDetailVo] is too big. It should be less or equal to 700");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalcommentsforpharmacy != null)
			if(this.clinicalcommentsforpharmacy.length() > 1000)
				listOfErrors.add("The length of the field [clinicalcommentsforpharmacy] in the value object [ims.clinical.vo.TTAMedicationDetailVo] is too big. It should be less or equal to 1000");
		if(this.medicationinstructionsforpatient != null)
			if(this.medicationinstructionsforpatient.length() > 1000)
				listOfErrors.add("The length of the field [medicationinstructionsforpatient] in the value object [ims.clinical.vo.TTAMedicationDetailVo] is too big. It should be less or equal to 1000");
		if(this.unittext != null)
			if(this.unittext.length() > 40)
				listOfErrors.add("The length of the field [unittext] in the value object [ims.clinical.vo.TTAMedicationDetailVo] is too big. It should be less or equal to 40");
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
	
		TTAMedicationDetailVo clone = new TTAMedicationDetailVo(this.id, this.version);
		
		clone.othermedicationtext = this.othermedicationtext;
		clone.dosevalue = this.dosevalue;
		if(this.doseunit == null)
			clone.doseunit = null;
		else
			clone.doseunit = (ims.core.vo.lookups.MedicationDoseUnit)this.doseunit.clone();
		if(this.form == null)
			clone.form = null;
		else
			clone.form = (ims.clinical.vo.lookups.DoseFormIndicator)this.form.clone();
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
		clone.frequencyvalue = this.frequencyvalue;
		if(this.frequencyunit == null)
			clone.frequencyunit = null;
		else
			clone.frequencyunit = (ims.core.vo.lookups.MedicationFrequency)this.frequencyunit.clone();
		if(this.commenceddate == null)
			clone.commenceddate = null;
		else
			clone.commenceddate = (ims.framework.utils.Date)this.commenceddate.clone();
		if(this.medication == null)
			clone.medication = null;
		else
			clone.medication = (ims.core.vo.MedicationLiteVo)this.medication.clone();
		clone.durationvalue = this.durationvalue;
		if(this.durationunit == null)
			clone.durationunit = null;
		else
			clone.durationunit = (ims.clinical.vo.lookups.MedicationDuration)this.durationunit.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.clinicalcommentsforpharmacy = this.clinicalcommentsforpharmacy;
		clone.medicationinstructionsforpatient = this.medicationinstructionsforpatient;
		clone.prescribercontacted = this.prescribercontacted;
		clone.unittext = this.unittext;
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
		if (!(TTAMedicationDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TTAMedicationDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TTAMedicationDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TTAMedicationDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.durationvalue != null)
			count++;
		if(this.durationunit != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.clinicalcommentsforpharmacy != null)
			count++;
		if(this.medicationinstructionsforpatient != null)
			count++;
		if(this.prescribercontacted != null)
			count++;
		if(this.unittext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected Integer durationvalue;
	protected ims.clinical.vo.lookups.MedicationDuration durationunit;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected String clinicalcommentsforpharmacy;
	protected String medicationinstructionsforpatient;
	protected Boolean prescribercontacted;
	protected String unittext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
