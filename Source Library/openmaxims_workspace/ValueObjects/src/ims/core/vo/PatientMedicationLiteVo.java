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
 * Linked to core.clinical.PatientMedication business object (ID: 1003100014).
 */
public class PatientMedicationLiteVo extends ims.core.clinical.vo.PatientMedicationRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientMedicationLiteVo()
	{
	}
	public PatientMedicationLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientMedicationLiteVo(ims.core.vo.beans.PatientMedicationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo();
		this.othermedicationtext = bean.getOtherMedicationText();
		this.prescribeddoses = ims.core.vo.MedicationDoseCollection.buildFromBeanCollection(bean.getPrescribedDoses());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequency());
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.nodayssupply = bean.getNoDaysSupply();
		this.batchno = bean.getBatchNo();
		this.expirydate = bean.getExpiryDate() == null ? null : bean.getExpiryDate().buildDate();
		this.isdiscontinued = bean.getIsDiscontinued();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientMedicationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo(map);
		this.othermedicationtext = bean.getOtherMedicationText();
		this.prescribeddoses = ims.core.vo.MedicationDoseCollection.buildFromBeanCollection(bean.getPrescribedDoses());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.frequency = bean.getFrequency() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequency());
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.nodayssupply = bean.getNoDaysSupply();
		this.batchno = bean.getBatchNo();
		this.expirydate = bean.getExpiryDate() == null ? null : bean.getExpiryDate().buildDate();
		this.isdiscontinued = bean.getIsDiscontinued();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientMedicationLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientMedicationLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientMedicationLiteVoBean();
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
		if(fieldName.equals("OTHERMEDICATIONTEXT"))
			return getOtherMedicationText();
		if(fieldName.equals("PRESCRIBEDDOSES"))
			return getPrescribedDoses();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		if(fieldName.equals("COMMENCEDDATE"))
			return getCommencedDate();
		if(fieldName.equals("NODAYSSUPPLY"))
			return getNoDaysSupply();
		if(fieldName.equals("BATCHNO"))
			return getBatchNo();
		if(fieldName.equals("EXPIRYDATE"))
			return getExpiryDate();
		if(fieldName.equals("ISDISCONTINUED"))
			return getIsDiscontinued();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public ims.core.vo.MedicationLiteVo getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.core.vo.MedicationLiteVo value)
	{
		this.isValidated = false;
		this.medication = value;
	}
	public boolean getOtherMedicationTextIsNotNull()
	{
		return this.othermedicationtext != null;
	}
	public String getOtherMedicationText()
	{
		return this.othermedicationtext;
	}
	public static int getOtherMedicationTextMaxLength()
	{
		return 700;
	}
	public void setOtherMedicationText(String value)
	{
		this.isValidated = false;
		this.othermedicationtext = value;
	}
	public boolean getPrescribedDosesIsNotNull()
	{
		return this.prescribeddoses != null;
	}
	public ims.core.vo.MedicationDoseCollection getPrescribedDoses()
	{
		return this.prescribeddoses;
	}
	public void setPrescribedDoses(ims.core.vo.MedicationDoseCollection value)
	{
		this.isValidated = false;
		this.prescribeddoses = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
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
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
	}
	public boolean getCommencedDateIsNotNull()
	{
		return this.commenceddate != null;
	}
	public ims.framework.utils.Date getCommencedDate()
	{
		return this.commenceddate;
	}
	public void setCommencedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.commenceddate = value;
	}
	public boolean getNoDaysSupplyIsNotNull()
	{
		return this.nodayssupply != null;
	}
	public Integer getNoDaysSupply()
	{
		return this.nodayssupply;
	}
	public void setNoDaysSupply(Integer value)
	{
		this.isValidated = false;
		this.nodayssupply = value;
	}
	public boolean getBatchNoIsNotNull()
	{
		return this.batchno != null;
	}
	public String getBatchNo()
	{
		return this.batchno;
	}
	public static int getBatchNoMaxLength()
	{
		return 25;
	}
	public void setBatchNo(String value)
	{
		this.isValidated = false;
		this.batchno = value;
	}
	public boolean getExpiryDateIsNotNull()
	{
		return this.expirydate != null;
	}
	public ims.framework.utils.Date getExpiryDate()
	{
		return this.expirydate;
	}
	public void setExpiryDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.expirydate = value;
	}
	public boolean getIsDiscontinuedIsNotNull()
	{
		return this.isdiscontinued != null;
	}
	public Boolean getIsDiscontinued()
	{
		return this.isdiscontinued;
	}
	public void setIsDiscontinued(Boolean value)
	{
		this.isValidated = false;
		this.isdiscontinued = value;
	}
	/**
	* IClinicalCoding methods
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
		if(this.prescribeddoses != null)
		{
			if(!this.prescribeddoses.isValidated())
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
			listOfErrors.add("Medication description is mandatory.");
		else if(this.othermedicationtext.length() > 700)
			listOfErrors.add("The length of the field [othermedicationtext] in the value object [ims.core.vo.PatientMedicationLiteVo] is too big. It should be less or equal to 700");
		if(this.prescribeddoses != null)
		{
			String[] listOfOtherErrors = this.prescribeddoses.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.batchno != null)
			if(this.batchno.length() > 25)
				listOfErrors.add("The length of the field [batchno] in the value object [ims.core.vo.PatientMedicationLiteVo] is too big. It should be less or equal to 25");
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
	
		PatientMedicationLiteVo clone = new PatientMedicationLiteVo(this.id, this.version);
		
		if(this.medication == null)
			clone.medication = null;
		else
			clone.medication = (ims.core.vo.MedicationLiteVo)this.medication.clone();
		clone.othermedicationtext = this.othermedicationtext;
		if(this.prescribeddoses == null)
			clone.prescribeddoses = null;
		else
			clone.prescribeddoses = (ims.core.vo.MedicationDoseCollection)this.prescribeddoses.clone();
		clone.patient = this.patient;
		if(this.frequency == null)
			clone.frequency = null;
		else
			clone.frequency = (ims.core.vo.lookups.MedicationFrequency)this.frequency.clone();
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		if(this.commenceddate == null)
			clone.commenceddate = null;
		else
			clone.commenceddate = (ims.framework.utils.Date)this.commenceddate.clone();
		clone.nodayssupply = this.nodayssupply;
		clone.batchno = this.batchno;
		if(this.expirydate == null)
			clone.expirydate = null;
		else
			clone.expirydate = (ims.framework.utils.Date)this.expirydate.clone();
		clone.isdiscontinued = this.isdiscontinued;
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
		if (!(PatientMedicationLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientMedicationLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientMedicationLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientMedicationLiteVo)obj).getBoId());
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
		if(this.othermedicationtext != null)
			count++;
		if(this.prescribeddoses != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		if(this.commenceddate != null)
			count++;
		if(this.nodayssupply != null)
			count++;
		if(this.batchno != null)
			count++;
		if(this.expirydate != null)
			count++;
		if(this.isdiscontinued != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.MedicationLiteVo medication;
	protected String othermedicationtext;
	protected ims.core.vo.MedicationDoseCollection prescribeddoses;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.lookups.MedicationFrequency frequency;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	protected ims.framework.utils.Date commenceddate;
	protected Integer nodayssupply;
	protected String batchno;
	protected ims.framework.utils.Date expirydate;
	protected Boolean isdiscontinued;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
