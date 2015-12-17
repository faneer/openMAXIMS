//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo;

/**
 * Linked to clinical.SurgeryDetails business object (ID: 1003100080).
 */
public class SurgeryDetailsVo extends ims.clinical.vo.SurgeryDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgeryDetailsVo()
	{
	}
	public SurgeryDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public SurgeryDetailsVo(ims.clinical.vo.beans.SurgeryDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patientprocedure = bean.getPatientProcedure() == null ? null : bean.getPatientProcedure().buildVo();
		this.hospitalperformed = bean.getHospitalPerformed() == null ? null : bean.getHospitalPerformed().buildVo();
		// Interface field type not supported.
		this.specialtyfunctioncode = bean.getSpecialtyFunctionCode() == null ? null : ims.clinical.vo.lookups.SpecialtyFunctionCode.buildLookup(bean.getSpecialtyFunctionCode());
		this.admissiondate = bean.getAdmissionDate() == null ? null : bean.getAdmissionDate().buildDate();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.clinical.vo.lookups.SurgeryDischargeDestination.buildLookup(bean.getDischargeDestination());
		this.asagrade = bean.getASAGrade() == null ? null : ims.core.vo.lookups.SurgeryASAGrade.buildLookup(bean.getASAGrade());
		this.consultantpresence = bean.getConsultantPresence() == null ? null : ims.core.vo.lookups.ConsultantPresence.buildLookup(bean.getConsultantPresence());
		this.subprocedures = ims.clinical.vo.SubProceduresVoCollection.buildFromBeanCollection(bean.getSubProcedures());
		// Interface field type not supported.
		this.anaesthetistgrade = bean.getAnaesthetistGrade() == null ? null : ims.core.vo.lookups.MedicGrade.buildLookup(bean.getAnaesthetistGrade());
		this.assistants = ims.clinical.vo.SurgeryAssistantsVoCollection.buildFromBeanCollection(bean.getAssistants());
		this.proceduretype = bean.getProcedureType() == null ? null : ims.core.vo.lookups.ProcedureType.buildLookup(bean.getProcedureType());
		this.preoppossum = bean.getPreOpPossum() == null ? null : bean.getPreOpPossum().buildVo();
		this.operativedetailspossum = bean.getOperativeDetailsPossum() == null ? null : bean.getOperativeDetailsPossum().buildVo();
		this.operativefindings = bean.getOperativeFindings() == null ? null : bean.getOperativeFindings().buildVo();
		this.proceduredetails = bean.getProcedureDetails() == null ? null : bean.getProcedureDetails().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SurgeryDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patientprocedure = bean.getPatientProcedure() == null ? null : bean.getPatientProcedure().buildVo(map);
		this.hospitalperformed = bean.getHospitalPerformed() == null ? null : bean.getHospitalPerformed().buildVo(map);
		// Interface field type not supported.
		this.specialtyfunctioncode = bean.getSpecialtyFunctionCode() == null ? null : ims.clinical.vo.lookups.SpecialtyFunctionCode.buildLookup(bean.getSpecialtyFunctionCode());
		this.admissiondate = bean.getAdmissionDate() == null ? null : bean.getAdmissionDate().buildDate();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.clinical.vo.lookups.SurgeryDischargeDestination.buildLookup(bean.getDischargeDestination());
		this.asagrade = bean.getASAGrade() == null ? null : ims.core.vo.lookups.SurgeryASAGrade.buildLookup(bean.getASAGrade());
		this.consultantpresence = bean.getConsultantPresence() == null ? null : ims.core.vo.lookups.ConsultantPresence.buildLookup(bean.getConsultantPresence());
		this.subprocedures = ims.clinical.vo.SubProceduresVoCollection.buildFromBeanCollection(bean.getSubProcedures());
		// Interface field type not supported.
		this.anaesthetistgrade = bean.getAnaesthetistGrade() == null ? null : ims.core.vo.lookups.MedicGrade.buildLookup(bean.getAnaesthetistGrade());
		this.assistants = ims.clinical.vo.SurgeryAssistantsVoCollection.buildFromBeanCollection(bean.getAssistants());
		this.proceduretype = bean.getProcedureType() == null ? null : ims.core.vo.lookups.ProcedureType.buildLookup(bean.getProcedureType());
		this.preoppossum = bean.getPreOpPossum() == null ? null : bean.getPreOpPossum().buildVo(map);
		this.operativedetailspossum = bean.getOperativeDetailsPossum() == null ? null : bean.getOperativeDetailsPossum().buildVo(map);
		this.operativefindings = bean.getOperativeFindings() == null ? null : bean.getOperativeFindings().buildVo(map);
		this.proceduredetails = bean.getProcedureDetails() == null ? null : bean.getProcedureDetails().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SurgeryDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SurgeryDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SurgeryDetailsVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PATIENTPROCEDURE"))
			return getPatientProcedure();
		if(fieldName.equals("HOSPITALPERFORMED"))
			return getHospitalPerformed();
		if(fieldName.equals("RESPONSIBLECONSULTANT"))
			return getResponsibleConsultant();
		if(fieldName.equals("SPECIALTYFUNCTIONCODE"))
			return getSpecialtyFunctionCode();
		if(fieldName.equals("ADMISSIONDATE"))
			return getAdmissionDate();
		if(fieldName.equals("DISCHARGEDATE"))
			return getDischargeDate();
		if(fieldName.equals("DISCHARGEDESTINATION"))
			return getDischargeDestination();
		if(fieldName.equals("ASAGRADE"))
			return getASAGrade();
		if(fieldName.equals("CONSULTANTPRESENCE"))
			return getConsultantPresence();
		if(fieldName.equals("SUBPROCEDURES"))
			return getSubProcedures();
		if(fieldName.equals("ANAESTHETIST"))
			return getAnaesthetist();
		if(fieldName.equals("ANAESTHETISTGRADE"))
			return getAnaesthetistGrade();
		if(fieldName.equals("ASSISTANTS"))
			return getAssistants();
		if(fieldName.equals("PROCEDURETYPE"))
			return getProcedureType();
		if(fieldName.equals("PREOPPOSSUM"))
			return getPreOpPossum();
		if(fieldName.equals("OPERATIVEDETAILSPOSSUM"))
			return getOperativeDetailsPossum();
		if(fieldName.equals("OPERATIVEFINDINGS"))
			return getOperativeFindings();
		if(fieldName.equals("PROCEDUREDETAILS"))
			return getProcedureDetails();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPatientProcedureIsNotNull()
	{
		return this.patientprocedure != null;
	}
	public ims.core.vo.PatientProcedureVo getPatientProcedure()
	{
		return this.patientprocedure;
	}
	public void setPatientProcedure(ims.core.vo.PatientProcedureVo value)
	{
		this.isValidated = false;
		this.patientprocedure = value;
	}
	public boolean getHospitalPerformedIsNotNull()
	{
		return this.hospitalperformed != null;
	}
	public ims.core.vo.OrgLiteVo getHospitalPerformed()
	{
		return this.hospitalperformed;
	}
	public void setHospitalPerformed(ims.core.vo.OrgLiteVo value)
	{
		this.isValidated = false;
		this.hospitalperformed = value;
	}
	public boolean getResponsibleConsultantIsNotNull()
	{
		return this.responsibleconsultant != null;
	}
	public ims.vo.interfaces.IMos getResponsibleConsultant()
	{
		return this.responsibleconsultant;
	}
	public void setResponsibleConsultant(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.responsibleconsultant = (ims.core.vo.HcpLiteVo)value;
	}
	public boolean getSpecialtyFunctionCodeIsNotNull()
	{
		return this.specialtyfunctioncode != null;
	}
	public ims.clinical.vo.lookups.SpecialtyFunctionCode getSpecialtyFunctionCode()
	{
		return this.specialtyfunctioncode;
	}
	public void setSpecialtyFunctionCode(ims.clinical.vo.lookups.SpecialtyFunctionCode value)
	{
		this.isValidated = false;
		this.specialtyfunctioncode = value;
	}
	public boolean getAdmissionDateIsNotNull()
	{
		return this.admissiondate != null;
	}
	public ims.framework.utils.Date getAdmissionDate()
	{
		return this.admissiondate;
	}
	public void setAdmissionDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.admissiondate = value;
	}
	public boolean getDischargeDateIsNotNull()
	{
		return this.dischargedate != null;
	}
	public ims.framework.utils.Date getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargedate = value;
	}
	public boolean getDischargeDestinationIsNotNull()
	{
		return this.dischargedestination != null;
	}
	public ims.clinical.vo.lookups.SurgeryDischargeDestination getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.clinical.vo.lookups.SurgeryDischargeDestination value)
	{
		this.isValidated = false;
		this.dischargedestination = value;
	}
	public boolean getASAGradeIsNotNull()
	{
		return this.asagrade != null;
	}
	public ims.core.vo.lookups.SurgeryASAGrade getASAGrade()
	{
		return this.asagrade;
	}
	public void setASAGrade(ims.core.vo.lookups.SurgeryASAGrade value)
	{
		this.isValidated = false;
		this.asagrade = value;
	}
	public boolean getConsultantPresenceIsNotNull()
	{
		return this.consultantpresence != null;
	}
	public ims.core.vo.lookups.ConsultantPresence getConsultantPresence()
	{
		return this.consultantpresence;
	}
	public void setConsultantPresence(ims.core.vo.lookups.ConsultantPresence value)
	{
		this.isValidated = false;
		this.consultantpresence = value;
	}
	public boolean getSubProceduresIsNotNull()
	{
		return this.subprocedures != null;
	}
	public ims.clinical.vo.SubProceduresVoCollection getSubProcedures()
	{
		return this.subprocedures;
	}
	public void setSubProcedures(ims.clinical.vo.SubProceduresVoCollection value)
	{
		this.isValidated = false;
		this.subprocedures = value;
	}
	public boolean getAnaesthetistIsNotNull()
	{
		return this.anaesthetist != null;
	}
	public ims.vo.interfaces.IMos getAnaesthetist()
	{
		return this.anaesthetist;
	}
	public void setAnaesthetist(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.anaesthetist = (ims.core.vo.HcpLiteVo)value;
	}
	public boolean getAnaesthetistGradeIsNotNull()
	{
		return this.anaesthetistgrade != null;
	}
	public ims.core.vo.lookups.MedicGrade getAnaesthetistGrade()
	{
		return this.anaesthetistgrade;
	}
	public void setAnaesthetistGrade(ims.core.vo.lookups.MedicGrade value)
	{
		this.isValidated = false;
		this.anaesthetistgrade = value;
	}
	public boolean getAssistantsIsNotNull()
	{
		return this.assistants != null;
	}
	public ims.clinical.vo.SurgeryAssistantsVoCollection getAssistants()
	{
		return this.assistants;
	}
	public void setAssistants(ims.clinical.vo.SurgeryAssistantsVoCollection value)
	{
		this.isValidated = false;
		this.assistants = value;
	}
	public boolean getProcedureTypeIsNotNull()
	{
		return this.proceduretype != null;
	}
	public ims.core.vo.lookups.ProcedureType getProcedureType()
	{
		return this.proceduretype;
	}
	public void setProcedureType(ims.core.vo.lookups.ProcedureType value)
	{
		this.isValidated = false;
		this.proceduretype = value;
	}
	public boolean getPreOpPossumIsNotNull()
	{
		return this.preoppossum != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getPreOpPossum()
	{
		return this.preoppossum;
	}
	public void setPreOpPossum(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.preoppossum = value;
	}
	public boolean getOperativeDetailsPossumIsNotNull()
	{
		return this.operativedetailspossum != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getOperativeDetailsPossum()
	{
		return this.operativedetailspossum;
	}
	public void setOperativeDetailsPossum(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.operativedetailspossum = value;
	}
	public boolean getOperativeFindingsIsNotNull()
	{
		return this.operativefindings != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getOperativeFindings()
	{
		return this.operativefindings;
	}
	public void setOperativeFindings(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.operativefindings = value;
	}
	public boolean getProcedureDetailsIsNotNull()
	{
		return this.proceduredetails != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getProcedureDetails()
	{
		return this.proceduredetails;
	}
	public void setProcedureDetails(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.proceduredetails = value;
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
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
		if(this.patientprocedure != null)
		{
			if(!this.patientprocedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.subprocedures != null)
		{
			if(!this.subprocedures.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.assistants != null)
		{
			if(!this.assistants.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.preoppossum != null)
		{
			if(!this.preoppossum.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.operativedetailspossum != null)
		{
			if(!this.operativedetailspossum.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.operativefindings != null)
		{
			if(!this.operativefindings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.proceduredetails != null)
		{
			if(!this.proceduredetails.isValidated())
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
		if(this.patientprocedure == null)
			listOfErrors.add("PatientProcedure is mandatory");
		if(this.patientprocedure != null)
		{
			String[] listOfOtherErrors = this.patientprocedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.subprocedures != null)
		{
			String[] listOfOtherErrors = this.subprocedures.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.assistants != null)
		{
			String[] listOfOtherErrors = this.assistants.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.preoppossum != null)
		{
			String[] listOfOtherErrors = this.preoppossum.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.operativedetailspossum != null)
		{
			String[] listOfOtherErrors = this.operativedetailspossum.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.operativefindings != null)
		{
			String[] listOfOtherErrors = this.operativefindings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.proceduredetails != null)
		{
			String[] listOfOtherErrors = this.proceduredetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
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
	
		SurgeryDetailsVo clone = new SurgeryDetailsVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.patientprocedure == null)
			clone.patientprocedure = null;
		else
			clone.patientprocedure = (ims.core.vo.PatientProcedureVo)this.patientprocedure.clone();
		if(this.hospitalperformed == null)
			clone.hospitalperformed = null;
		else
			clone.hospitalperformed = (ims.core.vo.OrgLiteVo)this.hospitalperformed.clone();
		clone.responsibleconsultant = this.responsibleconsultant;
		if(this.specialtyfunctioncode == null)
			clone.specialtyfunctioncode = null;
		else
			clone.specialtyfunctioncode = (ims.clinical.vo.lookups.SpecialtyFunctionCode)this.specialtyfunctioncode.clone();
		if(this.admissiondate == null)
			clone.admissiondate = null;
		else
			clone.admissiondate = (ims.framework.utils.Date)this.admissiondate.clone();
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.Date)this.dischargedate.clone();
		if(this.dischargedestination == null)
			clone.dischargedestination = null;
		else
			clone.dischargedestination = (ims.clinical.vo.lookups.SurgeryDischargeDestination)this.dischargedestination.clone();
		if(this.asagrade == null)
			clone.asagrade = null;
		else
			clone.asagrade = (ims.core.vo.lookups.SurgeryASAGrade)this.asagrade.clone();
		if(this.consultantpresence == null)
			clone.consultantpresence = null;
		else
			clone.consultantpresence = (ims.core.vo.lookups.ConsultantPresence)this.consultantpresence.clone();
		if(this.subprocedures == null)
			clone.subprocedures = null;
		else
			clone.subprocedures = (ims.clinical.vo.SubProceduresVoCollection)this.subprocedures.clone();
		clone.anaesthetist = this.anaesthetist;
		if(this.anaesthetistgrade == null)
			clone.anaesthetistgrade = null;
		else
			clone.anaesthetistgrade = (ims.core.vo.lookups.MedicGrade)this.anaesthetistgrade.clone();
		if(this.assistants == null)
			clone.assistants = null;
		else
			clone.assistants = (ims.clinical.vo.SurgeryAssistantsVoCollection)this.assistants.clone();
		if(this.proceduretype == null)
			clone.proceduretype = null;
		else
			clone.proceduretype = (ims.core.vo.lookups.ProcedureType)this.proceduretype.clone();
		if(this.preoppossum == null)
			clone.preoppossum = null;
		else
			clone.preoppossum = (ims.assessment.vo.PatientAssessmentVo)this.preoppossum.clone();
		if(this.operativedetailspossum == null)
			clone.operativedetailspossum = null;
		else
			clone.operativedetailspossum = (ims.assessment.vo.PatientAssessmentVo)this.operativedetailspossum.clone();
		if(this.operativefindings == null)
			clone.operativefindings = null;
		else
			clone.operativefindings = (ims.assessment.vo.PatientAssessmentVo)this.operativefindings.clone();
		if(this.proceduredetails == null)
			clone.proceduredetails = null;
		else
			clone.proceduredetails = (ims.assessment.vo.PatientAssessmentVo)this.proceduredetails.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.episodeofcare = this.episodeofcare;
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
		if (!(SurgeryDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgeryDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SurgeryDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SurgeryDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.patientprocedure != null)
			count++;
		if(this.hospitalperformed != null)
			count++;
		if(this.responsibleconsultant != null)
			count++;
		if(this.specialtyfunctioncode != null)
			count++;
		if(this.admissiondate != null)
			count++;
		if(this.dischargedate != null)
			count++;
		if(this.dischargedestination != null)
			count++;
		if(this.asagrade != null)
			count++;
		if(this.consultantpresence != null)
			count++;
		if(this.subprocedures != null)
			count++;
		if(this.anaesthetist != null)
			count++;
		if(this.anaesthetistgrade != null)
			count++;
		if(this.assistants != null)
			count++;
		if(this.proceduretype != null)
			count++;
		if(this.preoppossum != null)
			count++;
		if(this.operativedetailspossum != null)
			count++;
		if(this.operativefindings != null)
			count++;
		if(this.proceduredetails != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 21;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.PatientProcedureVo patientprocedure;
	protected ims.core.vo.OrgLiteVo hospitalperformed;
	protected ims.core.vo.HcpLiteVo responsibleconsultant;
	protected ims.clinical.vo.lookups.SpecialtyFunctionCode specialtyfunctioncode;
	protected ims.framework.utils.Date admissiondate;
	protected ims.framework.utils.Date dischargedate;
	protected ims.clinical.vo.lookups.SurgeryDischargeDestination dischargedestination;
	protected ims.core.vo.lookups.SurgeryASAGrade asagrade;
	protected ims.core.vo.lookups.ConsultantPresence consultantpresence;
	protected ims.clinical.vo.SubProceduresVoCollection subprocedures;
	protected ims.core.vo.HcpLiteVo anaesthetist;
	protected ims.core.vo.lookups.MedicGrade anaesthetistgrade;
	protected ims.clinical.vo.SurgeryAssistantsVoCollection assistants;
	protected ims.core.vo.lookups.ProcedureType proceduretype;
	protected ims.assessment.vo.PatientAssessmentVo preoppossum;
	protected ims.assessment.vo.PatientAssessmentVo operativedetailspossum;
	protected ims.assessment.vo.PatientAssessmentVo operativefindings;
	protected ims.assessment.vo.PatientAssessmentVo proceduredetails;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
