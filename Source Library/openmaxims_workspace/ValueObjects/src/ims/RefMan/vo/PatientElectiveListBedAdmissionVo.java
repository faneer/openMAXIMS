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

package ims.RefMan.vo;

/**
 * Linked to RefMan.PatientElectiveList business object (ID: 1014100020).
 */
public class PatientElectiveListBedAdmissionVo extends ims.RefMan.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPendingAdmissionDetails
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListBedAdmissionVo()
	{
	}
	public PatientElectiveListBedAdmissionVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListBedAdmissionVo(ims.RefMan.vo.beans.PatientElectiveListBedAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo();
		this.bed = bean.getBed();
		this.anticipatedstay = bean.getAnticipatedStay();
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo();
		if(bean.getElectiveListStatusHistory() != null)
		{
			this.electiveliststatushistory = new ims.RefMan.vo.ElectiveListStatusRefVoCollection();
			for(int electiveliststatushistory_i = 0; electiveliststatushistory_i < bean.getElectiveListStatusHistory().length; electiveliststatushistory_i++)
			{
				this.electiveliststatushistory.add(new ims.RefMan.vo.ElectiveListStatusRefVo(new Integer(bean.getElectiveListStatusHistory()[electiveliststatushistory_i].getId()), bean.getElectiveListStatusHistory()[electiveliststatushistory_i].getVersion()));
			}
		}
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo();
		this.erod = bean.getEROD() == null ? null : bean.getEROD().buildVo();
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.RefMan.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.RefMan.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.pathwayclock = bean.getPathwayClock() == null ? null : bean.getPathwayClock().buildVo();
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo();
		if(bean.getAdmissions() != null)
		{
			this.admissions = new ims.core.admin.pas.vo.AdmissionDetailRefVoCollection();
			for(int admissions_i = 0; admissions_i < bean.getAdmissions().length; admissions_i++)
			{
				this.admissions.add(new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissions()[admissions_i].getId()), bean.getAdmissions()[admissions_i].getVersion()));
			}
		}
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.RefMan.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.was28dayruleapplied = bean.getWas28DayRuleApplied();
		this.subjectto28dayrule = bean.getSubjectTo28DayRule();
		this.rule28daystatus = bean.getRule28DayStatus() == null ? null : ims.scheduling.vo.lookups.Rule28DayStatus.buildLookup(bean.getRule28DayStatus());
		this.rule28dayperiodstart = bean.getRule28DayPeriodStart() == null ? null : bean.getRule28DayPeriodStart().buildDate();
		this.patientcategory = bean.getPatientCategory() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientCategory());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientElectiveListBedAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo(map);
		this.bed = bean.getBed();
		this.anticipatedstay = bean.getAnticipatedStay();
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo(map);
		if(bean.getElectiveListStatusHistory() != null)
		{
			this.electiveliststatushistory = new ims.RefMan.vo.ElectiveListStatusRefVoCollection();
			for(int electiveliststatushistory_i = 0; electiveliststatushistory_i < bean.getElectiveListStatusHistory().length; electiveliststatushistory_i++)
			{
				this.electiveliststatushistory.add(new ims.RefMan.vo.ElectiveListStatusRefVo(new Integer(bean.getElectiveListStatusHistory()[electiveliststatushistory_i].getId()), bean.getElectiveListStatusHistory()[electiveliststatushistory_i].getVersion()));
			}
		}
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo(map);
		this.erod = bean.getEROD() == null ? null : bean.getEROD().buildVo(map);
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.RefMan.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.RefMan.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.pathwayclock = bean.getPathwayClock() == null ? null : bean.getPathwayClock().buildVo(map);
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo(map);
		if(bean.getAdmissions() != null)
		{
			this.admissions = new ims.core.admin.pas.vo.AdmissionDetailRefVoCollection();
			for(int admissions_i = 0; admissions_i < bean.getAdmissions().length; admissions_i++)
			{
				this.admissions.add(new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissions()[admissions_i].getId()), bean.getAdmissions()[admissions_i].getVersion()));
			}
		}
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.RefMan.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.was28dayruleapplied = bean.getWas28DayRuleApplied();
		this.subjectto28dayrule = bean.getSubjectTo28DayRule();
		this.rule28daystatus = bean.getRule28DayStatus() == null ? null : ims.scheduling.vo.lookups.Rule28DayStatus.buildLookup(bean.getRule28DayStatus());
		this.rule28dayperiodstart = bean.getRule28DayPeriodStart() == null ? null : bean.getRule28DayPeriodStart().buildDate();
		this.patientcategory = bean.getPatientCategory() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientCategory());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientElectiveListBedAdmissionVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientElectiveListBedAdmissionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientElectiveListBedAdmissionVoBean();
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
		if(fieldName.equals("ELECTIVELIST"))
			return getElectiveList();
		if(fieldName.equals("BED"))
			return getBed();
		if(fieldName.equals("ANTICIPATEDSTAY"))
			return getAnticipatedStay();
		if(fieldName.equals("TCIDETAILS"))
			return getTCIDetails();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("ELECTIVELISTSTATUS"))
			return getElectiveListStatus();
		if(fieldName.equals("ELECTIVELISTSTATUSHISTORY"))
			return getElectiveListStatusHistory();
		if(fieldName.equals("ELECTIVELISTREASON"))
			return getElectiveListReason();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("EROD"))
			return getEROD();
		if(fieldName.equals("ERODHISTORY"))
			return getERODHistory();
		if(fieldName.equals("PATHWAYCLOCK"))
			return getPathwayClock();
		if(fieldName.equals("DATEONLIST"))
			return getDateOnList();
		if(fieldName.equals("PRIMARYPROCEDURE"))
			return getPrimaryProcedure();
		if(fieldName.equals("ADMISSIONS"))
			return getAdmissions();
		if(fieldName.equals("ELECTIVEADMISSIONTYPE"))
			return getElectiveAdmissionType();
		if(fieldName.equals("WAS28DAYRULEAPPLIED"))
			return getWas28DayRuleApplied();
		if(fieldName.equals("SUBJECTTO28DAYRULE"))
			return getSubjectTo28DayRule();
		if(fieldName.equals("RULE28DAYSTATUS"))
			return getRule28DayStatus();
		if(fieldName.equals("RULE28DAYPERIODSTART"))
			return getRule28DayPeriodStart();
		if(fieldName.equals("PATIENTCATEGORY"))
			return getPatientCategory();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getElectiveListIsNotNull()
	{
		return this.electivelist != null;
	}
	public ims.RefMan.vo.ElectiveListConfigurationLiteVo getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.RefMan.vo.ElectiveListConfigurationLiteVo value)
	{
		this.isValidated = false;
		this.electivelist = value;
	}
	public boolean getBedIsNotNull()
	{
		return this.bed != null;
	}
	public String getBed()
	{
		return this.bed;
	}
	public static int getBedMaxLength()
	{
		return 50;
	}
	public void setBed(String value)
	{
		this.isValidated = false;
		this.bed = value;
	}
	public boolean getAnticipatedStayIsNotNull()
	{
		return this.anticipatedstay != null;
	}
	public Integer getAnticipatedStay()
	{
		return this.anticipatedstay;
	}
	public void setAnticipatedStay(Integer value)
	{
		this.isValidated = false;
		this.anticipatedstay = value;
	}
	public boolean getTCIDetailsIsNotNull()
	{
		return this.tcidetails != null;
	}
	public ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo value)
	{
		this.isValidated = false;
		this.tcidetails = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getElectiveListStatusIsNotNull()
	{
		return this.electiveliststatus != null;
	}
	public ims.RefMan.vo.ElectiveListStatusVo getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.RefMan.vo.ElectiveListStatusVo value)
	{
		this.isValidated = false;
		this.electiveliststatus = value;
	}
	public boolean getElectiveListStatusHistoryIsNotNull()
	{
		return this.electiveliststatushistory != null;
	}
	public ims.RefMan.vo.ElectiveListStatusRefVoCollection getElectiveListStatusHistory()
	{
		return this.electiveliststatushistory;
	}
	public void setElectiveListStatusHistory(ims.RefMan.vo.ElectiveListStatusRefVoCollection value)
	{
		this.isValidated = false;
		this.electiveliststatushistory = value;
	}
	public boolean getElectiveListReasonIsNotNull()
	{
		return this.electivelistreason != null;
	}
	public ims.emergency.vo.lookups.ElectiveListReason getElectiveListReason()
	{
		return this.electivelistreason;
	}
	public void setElectiveListReason(ims.emergency.vo.lookups.ElectiveListReason value)
	{
		this.isValidated = false;
		this.electivelistreason = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.RefMan.vo.CATSReferralWithContextPasVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.CATSReferralWithContextPasVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getERODIsNotNull()
	{
		return this.erod != null;
	}
	public ims.RefMan.vo.ReferralErodForCancellationVo getEROD()
	{
		return this.erod;
	}
	public void setEROD(ims.RefMan.vo.ReferralErodForCancellationVo value)
	{
		this.isValidated = false;
		this.erod = value;
	}
	public boolean getERODHistoryIsNotNull()
	{
		return this.erodhistory != null;
	}
	public ims.RefMan.vo.ReferralERODRefVoCollection getERODHistory()
	{
		return this.erodhistory;
	}
	public void setERODHistory(ims.RefMan.vo.ReferralERODRefVoCollection value)
	{
		this.isValidated = false;
		this.erodhistory = value;
	}
	public boolean getPathwayClockIsNotNull()
	{
		return this.pathwayclock != null;
	}
	public ims.pathways.vo.PathwayClockVo getPathwayClock()
	{
		return this.pathwayclock;
	}
	public void setPathwayClock(ims.pathways.vo.PathwayClockVo value)
	{
		this.isValidated = false;
		this.pathwayclock = value;
	}
	public boolean getDateOnListIsNotNull()
	{
		return this.dateonlist != null;
	}
	public ims.framework.utils.Date getDateOnList()
	{
		return this.dateonlist;
	}
	public void setDateOnList(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateonlist = value;
	}
	public boolean getPrimaryProcedureIsNotNull()
	{
		return this.primaryprocedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.primaryprocedure = value;
	}
	public boolean getAdmissionsIsNotNull()
	{
		return this.admissions != null;
	}
	public ims.core.admin.pas.vo.AdmissionDetailRefVoCollection getAdmissions()
	{
		return this.admissions;
	}
	public void setAdmissions(ims.core.admin.pas.vo.AdmissionDetailRefVoCollection value)
	{
		this.isValidated = false;
		this.admissions = value;
	}
	public boolean getElectiveAdmissionTypeIsNotNull()
	{
		return this.electiveadmissiontype != null;
	}
	public ims.RefMan.vo.lookups.ElectiveAdmissionType getElectiveAdmissionType()
	{
		return this.electiveadmissiontype;
	}
	public void setElectiveAdmissionType(ims.RefMan.vo.lookups.ElectiveAdmissionType value)
	{
		this.isValidated = false;
		this.electiveadmissiontype = value;
	}
	public boolean getWas28DayRuleAppliedIsNotNull()
	{
		return this.was28dayruleapplied != null;
	}
	public Boolean getWas28DayRuleApplied()
	{
		return this.was28dayruleapplied;
	}
	public void setWas28DayRuleApplied(Boolean value)
	{
		this.isValidated = false;
		this.was28dayruleapplied = value;
	}
	public boolean getSubjectTo28DayRuleIsNotNull()
	{
		return this.subjectto28dayrule != null;
	}
	public Boolean getSubjectTo28DayRule()
	{
		return this.subjectto28dayrule;
	}
	public void setSubjectTo28DayRule(Boolean value)
	{
		this.isValidated = false;
		this.subjectto28dayrule = value;
	}
	public boolean getRule28DayStatusIsNotNull()
	{
		return this.rule28daystatus != null;
	}
	public ims.scheduling.vo.lookups.Rule28DayStatus getRule28DayStatus()
	{
		return this.rule28daystatus;
	}
	public void setRule28DayStatus(ims.scheduling.vo.lookups.Rule28DayStatus value)
	{
		this.isValidated = false;
		this.rule28daystatus = value;
	}
	public boolean getRule28DayPeriodStartIsNotNull()
	{
		return this.rule28dayperiodstart != null;
	}
	public ims.framework.utils.Date getRule28DayPeriodStart()
	{
		return this.rule28dayperiodstart;
	}
	public void setRule28DayPeriodStart(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rule28dayperiodstart = value;
	}
	public boolean getPatientCategoryIsNotNull()
	{
		return this.patientcategory != null;
	}
	public ims.core.vo.lookups.PatientStatus getPatientCategory()
	{
		return this.patientcategory;
	}
	public void setPatientCategory(ims.core.vo.lookups.PatientStatus value)
	{
		this.isValidated = false;
		this.patientcategory = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	/**
	* IPendingAdmissionDetails implementation
	*/
	public String getPatientSurname()
	{
		if (this.patient != null)
			return this.patient.getPatientSurname();
	
		return null;
	}
	
	public String getPatientForename()
	{
		if (this.patient != null)
			return this.patient.getPatientForename();
	
		return null;
	}
	
	public ims.core.vo.PatientId getPatientDisplayIdentifier()
	{
		if (this.patient != null)
			return this.patient.getPatientDisplayIdentifier();
	
		return null;
	}
	
	public ims.core.vo.lookups.Sex getPatientSex()
	{
		if (this.patient != null)
			return this.patient.getPatientSex();
	
		return null;
	}
	
	public Integer getPatientAge()
	{
		if (this.patient != null)
			return this.patient.getPatientAge();
	
		return null;
	}
	
	public ims.framework.utils.PartialDate getPatientDoB()
	{
		if (this.patient != null)
			return this.patient.getPatientDoB();
	
		return null;
	}
	
	public String getLengthOfStay()
	{
		return null;
	}
	
	public ims.framework.utils.DateTime getTCIDateTime()
	{
		if (this.tcidetails == null)
			return null;
			
		if (this.tcidetails.getTCIDate() != null && this.tcidetails.getTCITime() != null)
			return new ims.framework.utils.DateTime(this.tcidetails.getTCIDate(), this.tcidetails.getTCITime());
			
		if (this.tcidetails.getTCIDate() != null)
			return new ims.framework.utils.DateTime(this.tcidetails.getTCIDate(), new ims.framework.utils.Time());
			
		return null;
	}
	
	public Boolean hasTCIComments()
	{
		return null;
	}
	
	public ims.framework.utils.Time getWardAttendanceAppointmentTime()
	{
		return null;
	}
	
	public ims.core.vo.ServiceLiteVo getPendingAdmissionService()
	{
		if (this.electivelist != null)
			return this.electivelist.service;
	
		return null;
	}
	
	public ims.core.vo.lookups.Specialty getPendingAdmissionSpecialty()
	{
		if (this.electivelist != null && this.electivelist.service != null)
			return this.electivelist.service.getSpecialty();
	
		return null;
	}
	
	public ims.core.vo.MemberOfStaffLiteVo getPendingAdmissionConsultant()
	{
		if (this.responsiblehcp!= null)
			return this.responsiblehcp.getMos();
	
		return null;
	}
	
	public ims.core.vo.lookups.MethodOfAdmission getPendingAdmissionMethodOfAdmission()
	{
		if (this.electiveadmissiontype == null)
			return null;
		
		if (ims.RefMan.vo.lookups.ElectiveAdmissionType.ELECTIVE_TYPE11.equals(this.electiveadmissiontype))
			return ims.core.vo.lookups.MethodOfAdmission.WAITING_LIST;
		
		if (ims.RefMan.vo.lookups.ElectiveAdmissionType.BOOKED_TYPE12.equals(this.electiveadmissiontype))
			return ims.core.vo.lookups.MethodOfAdmission.BOOKED;
		
		if (ims.RefMan.vo.lookups.ElectiveAdmissionType.PLANNED_TYPE13.equals(this.electiveadmissiontype))
			return ims.core.vo.lookups.MethodOfAdmission.PLANNED;
	
		return null;
	}
	
	public ims.core.vo.lookups.PatientStatus getPendingAdmissionPatientCategory()
	{
		return this.patientcategory;
	}
	
	public Integer getPendingAdmissionAnticipatedStay()
	{
		return this.anticipatedstay;
	}
	
	public ims.core.vo.lookups.SourceOfEmergencyReferral getPendingAdmissionSourceOfEmergencyReferral()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfReferral getPendingAdmissionSourceOfReferral()
	{
		return null;
	}
	
	public String getPendingAdmissionReasonForAdmission()
	{
		return null;
	}
	
	public ims.core.vo.MedicLiteVo getPendingAdmissionReferringConsultant()
	{
		return null;
	}
	
	public Boolean getPendingAdmissionSelfAdmit()
	{
		return null;
	}
	
	public ims.framework.utils.Date getPatientDod()
	{
		return this.patient.getDod();
	}
	
	public ims.core.patient.vo.PatientRefVo getPatientAssociatedPatient()
	{
		return this.patient.getAssociatedPatient();
	}
	
	public ims.framework.utils.Time getPatientTimeOfDeath()
	{
		return this.patient.getTimeOfDeath();
	}
	
	public String getPatientAgeText()
	{
		return this.patient.calculateAgeText();
	}
	
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return (ims.RefMan.vo.CatsReferralRefVo)this.referral;
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
		if(this.tcidetails != null)
		{
			if(!this.tcidetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.electiveliststatus != null)
		{
			if(!this.electiveliststatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.referral != null)
		{
			if(!this.referral.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.pathwayclock != null)
		{
			if(!this.pathwayclock.isValidated())
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
		if(this.bed != null)
			if(this.bed.length() > 50)
				listOfErrors.add("The length of the field [bed] in the value object [ims.RefMan.vo.PatientElectiveListBedAdmissionVo] is too big. It should be less or equal to 50");
		if(this.tcidetails != null)
		{
			String[] listOfOtherErrors = this.tcidetails.validate();
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
		if(this.electiveliststatus == null)
			listOfErrors.add("ElectiveListStatus is mandatory");
		if(this.electiveliststatus != null)
		{
			String[] listOfOtherErrors = this.electiveliststatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.electivelistreason == null)
			listOfErrors.add("ElectiveListReason is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.referral != null)
		{
			String[] listOfOtherErrors = this.referral.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.pathwayclock != null)
		{
			String[] listOfOtherErrors = this.pathwayclock.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dateonlist == null)
			listOfErrors.add("DateOnList is mandatory");
		if(this.electiveadmissiontype == null)
			listOfErrors.add("ElectiveAdmissionType is mandatory");
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
	
		PatientElectiveListBedAdmissionVo clone = new PatientElectiveListBedAdmissionVo(this.id, this.version);
		
		if(this.electivelist == null)
			clone.electivelist = null;
		else
			clone.electivelist = (ims.RefMan.vo.ElectiveListConfigurationLiteVo)this.electivelist.clone();
		clone.bed = this.bed;
		clone.anticipatedstay = this.anticipatedstay;
		if(this.tcidetails == null)
			clone.tcidetails = null;
		else
			clone.tcidetails = (ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo)this.tcidetails.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.electiveliststatus == null)
			clone.electiveliststatus = null;
		else
			clone.electiveliststatus = (ims.RefMan.vo.ElectiveListStatusVo)this.electiveliststatus.clone();
		clone.electiveliststatushistory = this.electiveliststatushistory;
		if(this.electivelistreason == null)
			clone.electivelistreason = null;
		else
			clone.electivelistreason = (ims.emergency.vo.lookups.ElectiveListReason)this.electivelistreason.clone();
		if(this.referral == null)
			clone.referral = null;
		else
			clone.referral = (ims.RefMan.vo.CATSReferralWithContextPasVo)this.referral.clone();
		if(this.erod == null)
			clone.erod = null;
		else
			clone.erod = (ims.RefMan.vo.ReferralErodForCancellationVo)this.erod.clone();
		clone.erodhistory = this.erodhistory;
		if(this.pathwayclock == null)
			clone.pathwayclock = null;
		else
			clone.pathwayclock = (ims.pathways.vo.PathwayClockVo)this.pathwayclock.clone();
		if(this.dateonlist == null)
			clone.dateonlist = null;
		else
			clone.dateonlist = (ims.framework.utils.Date)this.dateonlist.clone();
		if(this.primaryprocedure == null)
			clone.primaryprocedure = null;
		else
			clone.primaryprocedure = (ims.core.vo.ProcedureLiteVo)this.primaryprocedure.clone();
		clone.admissions = this.admissions;
		if(this.electiveadmissiontype == null)
			clone.electiveadmissiontype = null;
		else
			clone.electiveadmissiontype = (ims.RefMan.vo.lookups.ElectiveAdmissionType)this.electiveadmissiontype.clone();
		clone.was28dayruleapplied = this.was28dayruleapplied;
		clone.subjectto28dayrule = this.subjectto28dayrule;
		if(this.rule28daystatus == null)
			clone.rule28daystatus = null;
		else
			clone.rule28daystatus = (ims.scheduling.vo.lookups.Rule28DayStatus)this.rule28daystatus.clone();
		if(this.rule28dayperiodstart == null)
			clone.rule28dayperiodstart = null;
		else
			clone.rule28dayperiodstart = (ims.framework.utils.Date)this.rule28dayperiodstart.clone();
		if(this.patientcategory == null)
			clone.patientcategory = null;
		else
			clone.patientcategory = (ims.core.vo.lookups.PatientStatus)this.patientcategory.clone();
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
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
		if (!(PatientElectiveListBedAdmissionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListBedAdmissionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListBedAdmissionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListBedAdmissionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.electivelist != null)
			count++;
		if(this.bed != null)
			count++;
		if(this.anticipatedstay != null)
			count++;
		if(this.tcidetails != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.electiveliststatus != null)
			count++;
		if(this.electiveliststatushistory != null)
			count++;
		if(this.electivelistreason != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.erod != null)
			count++;
		if(this.erodhistory != null)
			count++;
		if(this.pathwayclock != null)
			count++;
		if(this.dateonlist != null)
			count++;
		if(this.primaryprocedure != null)
			count++;
		if(this.admissions != null)
			count++;
		if(this.electiveadmissiontype != null)
			count++;
		if(this.was28dayruleapplied != null)
			count++;
		if(this.subjectto28dayrule != null)
			count++;
		if(this.rule28daystatus != null)
			count++;
		if(this.rule28dayperiodstart != null)
			count++;
		if(this.patientcategory != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 22;
	}
	protected ims.RefMan.vo.ElectiveListConfigurationLiteVo electivelist;
	protected String bed;
	protected Integer anticipatedstay;
	protected ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo tcidetails;
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.RefMan.vo.ElectiveListStatusVo electiveliststatus;
	protected ims.RefMan.vo.ElectiveListStatusRefVoCollection electiveliststatushistory;
	protected ims.emergency.vo.lookups.ElectiveListReason electivelistreason;
	protected ims.RefMan.vo.CATSReferralWithContextPasVo referral;
	protected ims.RefMan.vo.ReferralErodForCancellationVo erod;
	protected ims.RefMan.vo.ReferralERODRefVoCollection erodhistory;
	protected ims.pathways.vo.PathwayClockVo pathwayclock;
	protected ims.framework.utils.Date dateonlist;
	protected ims.core.vo.ProcedureLiteVo primaryprocedure;
	protected ims.core.admin.pas.vo.AdmissionDetailRefVoCollection admissions;
	protected ims.RefMan.vo.lookups.ElectiveAdmissionType electiveadmissiontype;
	protected Boolean was28dayruleapplied;
	protected Boolean subjectto28dayrule;
	protected ims.scheduling.vo.lookups.Rule28DayStatus rule28daystatus;
	protected ims.framework.utils.Date rule28dayperiodstart;
	protected ims.core.vo.lookups.PatientStatus patientcategory;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
