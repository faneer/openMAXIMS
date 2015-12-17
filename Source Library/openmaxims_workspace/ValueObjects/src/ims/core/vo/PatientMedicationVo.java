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
public class PatientMedicationVo extends ims.core.vo.PatientMedicationLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientMedicationVo()
	{
	}
	public PatientMedicationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientMedicationVo(ims.core.vo.beans.PatientMedicationVoBean bean)
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
		this.difficultieswithmed = bean.getDifficultiesWithMed();
		this.supplied = bean.getSupplied() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSupplied());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.inpossession = bean.getInPossession();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.ismedicationonadmission = bean.getIsMedicationonAdmission();
		this.isdischargemedication = bean.getIsDischargeMedication();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.hcpcommenced = bean.getHcpCommenced() == null ? null : bean.getHcpCommenced().buildVo();
		this.isintto = bean.getIsInTTO();
		this.isdiscontinuedhcp = bean.getIsDiscontinuedHcp() == null ? null : bean.getIsDiscontinuedHcp().buildVo();
		this.isdiscontinueddate = bean.getIsDiscontinuedDate() == null ? null : bean.getIsDiscontinuedDate().buildDate();
		this.isdiscontinuedreason = bean.getIsDiscontinuedReason() == null ? null : ims.core.vo.lookups.MedicationDoseReasonStopped.buildLookup(bean.getIsDiscontinuedReason());
		this.isdiscontinuedreasontext = bean.getIsDiscontinuedReasonText();
		this.iscopied = bean.getIsCopied();
		this.commencedbytype = bean.getCommencedByType() == null ? null : ims.core.vo.lookups.MedicationCommencedDiscontinuedType.buildLookup(bean.getCommencedByType());
		this.discontinuedbytype = bean.getDiscontinuedByType() == null ? null : ims.core.vo.lookups.MedicationCommencedDiscontinuedType.buildLookup(bean.getDiscontinuedByType());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.selfmedicating = bean.getSelfMedicating();
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
		this.comment = bean.getComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientMedicationVoBean bean)
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
		this.difficultieswithmed = bean.getDifficultiesWithMed();
		this.supplied = bean.getSupplied() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSupplied());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.inpossession = bean.getInPossession();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.ismedicationonadmission = bean.getIsMedicationonAdmission();
		this.isdischargemedication = bean.getIsDischargeMedication();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.hcpcommenced = bean.getHcpCommenced() == null ? null : bean.getHcpCommenced().buildVo(map);
		this.isintto = bean.getIsInTTO();
		this.isdiscontinuedhcp = bean.getIsDiscontinuedHcp() == null ? null : bean.getIsDiscontinuedHcp().buildVo(map);
		this.isdiscontinueddate = bean.getIsDiscontinuedDate() == null ? null : bean.getIsDiscontinuedDate().buildDate();
		this.isdiscontinuedreason = bean.getIsDiscontinuedReason() == null ? null : ims.core.vo.lookups.MedicationDoseReasonStopped.buildLookup(bean.getIsDiscontinuedReason());
		this.isdiscontinuedreasontext = bean.getIsDiscontinuedReasonText();
		this.iscopied = bean.getIsCopied();
		this.commencedbytype = bean.getCommencedByType() == null ? null : ims.core.vo.lookups.MedicationCommencedDiscontinuedType.buildLookup(bean.getCommencedByType());
		this.discontinuedbytype = bean.getDiscontinuedByType() == null ? null : ims.core.vo.lookups.MedicationCommencedDiscontinuedType.buildLookup(bean.getDiscontinuedByType());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.selfmedicating = bean.getSelfMedicating();
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
		this.comment = bean.getComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientMedicationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientMedicationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientMedicationVoBean();
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
		if(fieldName.equals("DIFFICULTIESWITHMED"))
			return getDifficultiesWithMed();
		if(fieldName.equals("SUPPLIED"))
			return getSupplied();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("INPOSSESSION"))
			return getInPossession();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("ISMEDICATIONONADMISSION"))
			return getIsMedicationonAdmission();
		if(fieldName.equals("ISDISCHARGEMEDICATION"))
			return getIsDischargeMedication();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("HCPCOMMENCED"))
			return getHcpCommenced();
		if(fieldName.equals("ISINTTO"))
			return getIsInTTO();
		if(fieldName.equals("ISDISCONTINUEDHCP"))
			return getIsDiscontinuedHcp();
		if(fieldName.equals("ISDISCONTINUEDDATE"))
			return getIsDiscontinuedDate();
		if(fieldName.equals("ISDISCONTINUEDREASON"))
			return getIsDiscontinuedReason();
		if(fieldName.equals("ISDISCONTINUEDREASONTEXT"))
			return getIsDiscontinuedReasonText();
		if(fieldName.equals("ISCOPIED"))
			return getIsCopied();
		if(fieldName.equals("COMMENCEDBYTYPE"))
			return getCommencedByType();
		if(fieldName.equals("DISCONTINUEDBYTYPE"))
			return getDiscontinuedByType();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("SELFMEDICATING"))
			return getSelfMedicating();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		if(fieldName.equals("COMMENT"))
			return getComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDifficultiesWithMedIsNotNull()
	{
		return this.difficultieswithmed != null;
	}
	public String getDifficultiesWithMed()
	{
		return this.difficultieswithmed;
	}
	public static int getDifficultiesWithMedMaxLength()
	{
		return 255;
	}
	public void setDifficultiesWithMed(String value)
	{
		this.isValidated = false;
		this.difficultieswithmed = value;
	}
	public boolean getSuppliedIsNotNull()
	{
		return this.supplied != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getSupplied()
	{
		return this.supplied;
	}
	public void setSupplied(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.supplied = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getInPossessionIsNotNull()
	{
		return this.inpossession != null;
	}
	public Boolean getInPossession()
	{
		return this.inpossession;
	}
	public void setInPossession(Boolean value)
	{
		this.isValidated = false;
		this.inpossession = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getIsMedicationonAdmissionIsNotNull()
	{
		return this.ismedicationonadmission != null;
	}
	public Boolean getIsMedicationonAdmission()
	{
		return this.ismedicationonadmission;
	}
	public void setIsMedicationonAdmission(Boolean value)
	{
		this.isValidated = false;
		this.ismedicationonadmission = value;
	}
	public boolean getIsDischargeMedicationIsNotNull()
	{
		return this.isdischargemedication != null;
	}
	public Boolean getIsDischargeMedication()
	{
		return this.isdischargemedication;
	}
	public void setIsDischargeMedication(Boolean value)
	{
		this.isValidated = false;
		this.isdischargemedication = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getHcpCommencedIsNotNull()
	{
		return this.hcpcommenced != null;
	}
	public ims.core.vo.Hcp getHcpCommenced()
	{
		return this.hcpcommenced;
	}
	public void setHcpCommenced(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.hcpcommenced = value;
	}
	public boolean getIsInTTOIsNotNull()
	{
		return this.isintto != null;
	}
	public Boolean getIsInTTO()
	{
		return this.isintto;
	}
	public void setIsInTTO(Boolean value)
	{
		this.isValidated = false;
		this.isintto = value;
	}
	public boolean getIsDiscontinuedHcpIsNotNull()
	{
		return this.isdiscontinuedhcp != null;
	}
	public ims.core.vo.Hcp getIsDiscontinuedHcp()
	{
		return this.isdiscontinuedhcp;
	}
	public void setIsDiscontinuedHcp(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.isdiscontinuedhcp = value;
	}
	public boolean getIsDiscontinuedDateIsNotNull()
	{
		return this.isdiscontinueddate != null;
	}
	public ims.framework.utils.Date getIsDiscontinuedDate()
	{
		return this.isdiscontinueddate;
	}
	public void setIsDiscontinuedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.isdiscontinueddate = value;
	}
	public boolean getIsDiscontinuedReasonIsNotNull()
	{
		return this.isdiscontinuedreason != null;
	}
	public ims.core.vo.lookups.MedicationDoseReasonStopped getIsDiscontinuedReason()
	{
		return this.isdiscontinuedreason;
	}
	public void setIsDiscontinuedReason(ims.core.vo.lookups.MedicationDoseReasonStopped value)
	{
		this.isValidated = false;
		this.isdiscontinuedreason = value;
	}
	public boolean getIsDiscontinuedReasonTextIsNotNull()
	{
		return this.isdiscontinuedreasontext != null;
	}
	public String getIsDiscontinuedReasonText()
	{
		return this.isdiscontinuedreasontext;
	}
	public static int getIsDiscontinuedReasonTextMaxLength()
	{
		return 200;
	}
	public void setIsDiscontinuedReasonText(String value)
	{
		this.isValidated = false;
		this.isdiscontinuedreasontext = value;
	}
	public boolean getIsCopiedIsNotNull()
	{
		return this.iscopied != null;
	}
	public Boolean getIsCopied()
	{
		return this.iscopied;
	}
	public void setIsCopied(Boolean value)
	{
		this.isValidated = false;
		this.iscopied = value;
	}
	public boolean getCommencedByTypeIsNotNull()
	{
		return this.commencedbytype != null;
	}
	public ims.core.vo.lookups.MedicationCommencedDiscontinuedType getCommencedByType()
	{
		return this.commencedbytype;
	}
	public void setCommencedByType(ims.core.vo.lookups.MedicationCommencedDiscontinuedType value)
	{
		this.isValidated = false;
		this.commencedbytype = value;
	}
	public boolean getDiscontinuedByTypeIsNotNull()
	{
		return this.discontinuedbytype != null;
	}
	public ims.core.vo.lookups.MedicationCommencedDiscontinuedType getDiscontinuedByType()
	{
		return this.discontinuedbytype;
	}
	public void setDiscontinuedByType(ims.core.vo.lookups.MedicationCommencedDiscontinuedType value)
	{
		this.isValidated = false;
		this.discontinuedbytype = value;
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
	public boolean getSelfMedicatingIsNotNull()
	{
		return this.selfmedicating != null;
	}
	public Boolean getSelfMedicating()
	{
		return this.selfmedicating;
	}
	public void setSelfMedicating(Boolean value)
	{
		this.isValidated = false;
		this.selfmedicating = value;
	}
	public boolean getRecordingInformationIsNotNull()
	{
		return this.recordinginformation != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginformation = value;
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
	/**
	* getTotalDuration
	*/
	public int getTotalDuration()
	{
		int nRet = 0;
		for (int i = 0; i < this.getPrescribedDoses().size(); i++)		
		{
			if (this.getPrescribedDoses().get(i).getDurationIsNotNull())
				nRet += this.getPrescribedDoses().get(i).getDuration().intValue();
		}
	
		return nRet;		
	}		
	/**
	* getDiscontinuedTooltip - returns a textile formatted string when medication is discontinued
	*/
	public String getDiscontinuedTooltip()
	{
		if(this != null && this.getIsDiscontinuedIsNotNull() && this.getIsDiscontinued().booleanValue())
		{
			StringBuffer tooltip = new StringBuffer();
			final String CR = "\n";
			if(this.getIsDiscontinuedDateIsNotNull())
			{
				tooltip.append("*Date Discontinued: *");
				tooltip.append(this.getIsDiscontinuedDate().toString());
				tooltip.append(CR);
			}
			
			if(this.getIsDiscontinuedHcpIsNotNull())
			{
				tooltip.append("*Discontinued By: *");
				tooltip.append(this.getIsDiscontinuedHcp().toString());
				tooltip.append(CR);
			}
			
			if(this.getIsDiscontinuedReasonIsNotNull())
			{
				tooltip.append("*Discontinued Reason: *");
				tooltip.append(this.getIsDiscontinuedReason().toString());
				tooltip.append(CR);
			}
			
			if(this.getIsDiscontinuedReasonTextIsNotNull())
			{
				tooltip.append("*Discontinued Reason Description: *");
				tooltip.append(this.getIsDiscontinuedReasonText());
			}
			
			return new ims.utils.textile.Textile().process(tooltip.toString());
		}
		
		return "";
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
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
			listOfErrors.add("The length of the field [othermedicationtext] in the value object [ims.core.vo.PatientMedicationVo] is too big. It should be less or equal to 700");
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
				listOfErrors.add("The length of the field [batchno] in the value object [ims.core.vo.PatientMedicationVo] is too big. It should be less or equal to 25");
		if(this.difficultieswithmed != null)
			if(this.difficultieswithmed.length() > 255)
				listOfErrors.add("The length of the field [difficultieswithmed] in the value object [ims.core.vo.PatientMedicationVo] is too big. It should be less or equal to 255");
		if(this.isdiscontinuedreasontext != null)
			if(this.isdiscontinuedreasontext.length() > 200)
				listOfErrors.add("The length of the field [isdiscontinuedreasontext] in the value object [ims.core.vo.PatientMedicationVo] is too big. It should be less or equal to 200");
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
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.PatientMedicationVo] is too big. It should be less or equal to 255");
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
	
		PatientMedicationVo clone = new PatientMedicationVo(this.id, this.version);
		
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
		clone.difficultieswithmed = this.difficultieswithmed;
		if(this.supplied == null)
			clone.supplied = null;
		else
			clone.supplied = (ims.core.vo.lookups.YesNoUnknown)this.supplied.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		clone.inpossession = this.inpossession;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.ismedicationonadmission = this.ismedicationonadmission;
		clone.isdischargemedication = this.isdischargemedication;
		clone.carecontext = this.carecontext;
		if(this.hcpcommenced == null)
			clone.hcpcommenced = null;
		else
			clone.hcpcommenced = (ims.core.vo.Hcp)this.hcpcommenced.clone();
		clone.isintto = this.isintto;
		if(this.isdiscontinuedhcp == null)
			clone.isdiscontinuedhcp = null;
		else
			clone.isdiscontinuedhcp = (ims.core.vo.Hcp)this.isdiscontinuedhcp.clone();
		if(this.isdiscontinueddate == null)
			clone.isdiscontinueddate = null;
		else
			clone.isdiscontinueddate = (ims.framework.utils.Date)this.isdiscontinueddate.clone();
		if(this.isdiscontinuedreason == null)
			clone.isdiscontinuedreason = null;
		else
			clone.isdiscontinuedreason = (ims.core.vo.lookups.MedicationDoseReasonStopped)this.isdiscontinuedreason.clone();
		clone.isdiscontinuedreasontext = this.isdiscontinuedreasontext;
		clone.iscopied = this.iscopied;
		if(this.commencedbytype == null)
			clone.commencedbytype = null;
		else
			clone.commencedbytype = (ims.core.vo.lookups.MedicationCommencedDiscontinuedType)this.commencedbytype.clone();
		if(this.discontinuedbytype == null)
			clone.discontinuedbytype = null;
		else
			clone.discontinuedbytype = (ims.core.vo.lookups.MedicationCommencedDiscontinuedType)this.discontinuedbytype.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.selfmedicating = this.selfmedicating;
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.RecordingUserInformationVo)this.recordinginformation.clone();
		clone.comment = this.comment;
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
		if (!(PatientMedicationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientMedicationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientMedicationVo compareObj = (PatientMedicationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.difficultieswithmed != null)
			count++;
		if(this.supplied != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.inpossession != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.ismedicationonadmission != null)
			count++;
		if(this.isdischargemedication != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.hcpcommenced != null)
			count++;
		if(this.isintto != null)
			count++;
		if(this.isdiscontinuedhcp != null)
			count++;
		if(this.isdiscontinueddate != null)
			count++;
		if(this.isdiscontinuedreason != null)
			count++;
		if(this.isdiscontinuedreasontext != null)
			count++;
		if(this.iscopied != null)
			count++;
		if(this.commencedbytype != null)
			count++;
		if(this.discontinuedbytype != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.selfmedicating != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		if(this.comment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 21;
	}
	protected String difficultieswithmed;
	protected ims.core.vo.lookups.YesNoUnknown supplied;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected Boolean inpossession;
	protected ims.vo.SystemInformation sysinfo;
	protected Boolean ismedicationonadmission;
	protected Boolean isdischargemedication;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.Hcp hcpcommenced;
	protected Boolean isintto;
	protected ims.core.vo.Hcp isdiscontinuedhcp;
	protected ims.framework.utils.Date isdiscontinueddate;
	protected ims.core.vo.lookups.MedicationDoseReasonStopped isdiscontinuedreason;
	protected String isdiscontinuedreasontext;
	protected Boolean iscopied;
	protected ims.core.vo.lookups.MedicationCommencedDiscontinuedType commencedbytype;
	protected ims.core.vo.lookups.MedicationCommencedDiscontinuedType discontinuedbytype;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected Boolean selfmedicating;
	protected ims.core.vo.RecordingUserInformationVo recordinginformation;
	protected String comment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
