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
 * Linked to core.clinical.IntraOperativeCareRecord business object (ID: 1072100081).
 */
public class IntraOperativeCareRecordVo extends ims.clinical.vo.IntraOperativeCareRecordMinVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IntraOperativeCareRecordVo()
	{
	}
	public IntraOperativeCareRecordVo(Integer id, int version)
	{
		super(id, version);
	}
	public IntraOperativeCareRecordVo(ims.clinical.vo.beans.IntraOperativeCareRecordVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.plannedprocedure = bean.getPlannedProcedure() == null ? null : bean.getPlannedProcedure().buildVo();
		this.actualprocedure = bean.getActualProcedure() == null ? null : bean.getActualProcedure().buildVo();
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.intheatretime = bean.getInTheatreTime() == null ? null : bean.getInTheatreTime().buildDateTime();
		this.surgerystarttime = bean.getSurgeryStartTime() == null ? null : bean.getSurgeryStartTime().buildDateTime();
		this.surgeryendtime = bean.getSurgeryEndTime() == null ? null : bean.getSurgeryEndTime().buildDateTime();
		this.anaesthetiststarttime = bean.getAnaesthetistStartTime() == null ? null : bean.getAnaesthetistStartTime().buildDateTime();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo();
		this.surgeonassistant = bean.getSurgeonAssistant() == null ? null : bean.getSurgeonAssistant().buildVo();
		this.anaesthetist = bean.getAnaesthetist() == null ? null : bean.getAnaesthetist().buildVo();
		this.oda = bean.getODA() == null ? null : bean.getODA().buildVo();
		this.scrubnurse = bean.getScrubNurse() == null ? null : bean.getScrubNurse().buildVo();
		this.circulatingnurse = bean.getCirculatingNurse() == null ? null : bean.getCirculatingNurse().buildVo();
		this.other = bean.getOther();
		this.intraoperativedetails = bean.getIntraOperativeDetails() == null ? null : bean.getIntraOperativeDetails().buildVo();
		this.wasplannedprocedure = bean.getWasPlannedProcedure();
		this.wasunplannedprocedure = bean.getWasUnplannedProcedure();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo();
		this.cataractintraoperativedetail = bean.getCataractIntraOperativeDetail() == null ? null : bean.getCataractIntraOperativeDetail().buildVo();
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.readmissiontype = bean.getReadmissionType() == null ? null : ims.core.vo.lookups.ReadmissionType.buildLookup(bean.getReadmissionType());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.intopacutime = bean.getIntoPacuTime() == null ? null : bean.getIntoPacuTime().buildDateTime();
		this.timeintorecovery = bean.getTimeIntoRecovery() == null ? null : bean.getTimeIntoRecovery().buildDateTime();
		this.timeoutofrecovery = bean.getTimeOutOfRecovery() == null ? null : bean.getTimeOutOfRecovery().buildDateTime();
		this.anaestheticused = bean.getAnaestheticUsed() == null ? null : ims.clinical.vo.lookups.AnaestheticUsed.buildLookup(bean.getAnaestheticUsed());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.IntraOperativeCareRecordVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.plannedprocedure = bean.getPlannedProcedure() == null ? null : bean.getPlannedProcedure().buildVo(map);
		this.actualprocedure = bean.getActualProcedure() == null ? null : bean.getActualProcedure().buildVo(map);
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.intheatretime = bean.getInTheatreTime() == null ? null : bean.getInTheatreTime().buildDateTime();
		this.surgerystarttime = bean.getSurgeryStartTime() == null ? null : bean.getSurgeryStartTime().buildDateTime();
		this.surgeryendtime = bean.getSurgeryEndTime() == null ? null : bean.getSurgeryEndTime().buildDateTime();
		this.anaesthetiststarttime = bean.getAnaesthetistStartTime() == null ? null : bean.getAnaesthetistStartTime().buildDateTime();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo(map);
		this.surgeonassistant = bean.getSurgeonAssistant() == null ? null : bean.getSurgeonAssistant().buildVo(map);
		this.anaesthetist = bean.getAnaesthetist() == null ? null : bean.getAnaesthetist().buildVo(map);
		this.oda = bean.getODA() == null ? null : bean.getODA().buildVo(map);
		this.scrubnurse = bean.getScrubNurse() == null ? null : bean.getScrubNurse().buildVo(map);
		this.circulatingnurse = bean.getCirculatingNurse() == null ? null : bean.getCirculatingNurse().buildVo(map);
		this.other = bean.getOther();
		this.intraoperativedetails = bean.getIntraOperativeDetails() == null ? null : bean.getIntraOperativeDetails().buildVo(map);
		this.wasplannedprocedure = bean.getWasPlannedProcedure();
		this.wasunplannedprocedure = bean.getWasUnplannedProcedure();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo(map);
		this.cataractintraoperativedetail = bean.getCataractIntraOperativeDetail() == null ? null : bean.getCataractIntraOperativeDetail().buildVo(map);
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.readmissiontype = bean.getReadmissionType() == null ? null : ims.core.vo.lookups.ReadmissionType.buildLookup(bean.getReadmissionType());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.intopacutime = bean.getIntoPacuTime() == null ? null : bean.getIntoPacuTime().buildDateTime();
		this.timeintorecovery = bean.getTimeIntoRecovery() == null ? null : bean.getTimeIntoRecovery().buildDateTime();
		this.timeoutofrecovery = bean.getTimeOutOfRecovery() == null ? null : bean.getTimeOutOfRecovery().buildDateTime();
		this.anaestheticused = bean.getAnaestheticUsed() == null ? null : ims.clinical.vo.lookups.AnaestheticUsed.buildLookup(bean.getAnaestheticUsed());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.IntraOperativeCareRecordVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.IntraOperativeCareRecordVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.IntraOperativeCareRecordVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PLANNEDPROCEDURE"))
			return getPlannedProcedure();
		if(fieldName.equals("ACTUALPROCEDURE"))
			return getActualProcedure();
		if(fieldName.equals("PROCEDUREDATE"))
			return getProcedureDate();
		if(fieldName.equals("INTHEATRETIME"))
			return getInTheatreTime();
		if(fieldName.equals("SURGERYSTARTTIME"))
			return getSurgeryStartTime();
		if(fieldName.equals("SURGERYENDTIME"))
			return getSurgeryEndTime();
		if(fieldName.equals("ANAESTHETISTSTARTTIME"))
			return getAnaesthetistStartTime();
		if(fieldName.equals("SURGEON"))
			return getSurgeon();
		if(fieldName.equals("SURGEONASSISTANT"))
			return getSurgeonAssistant();
		if(fieldName.equals("ANAESTHETIST"))
			return getAnaesthetist();
		if(fieldName.equals("ODA"))
			return getODA();
		if(fieldName.equals("SCRUBNURSE"))
			return getScrubNurse();
		if(fieldName.equals("CIRCULATINGNURSE"))
			return getCirculatingNurse();
		if(fieldName.equals("OTHER"))
			return getOther();
		if(fieldName.equals("INTRAOPERATIVEDETAILS"))
			return getIntraOperativeDetails();
		if(fieldName.equals("WASPLANNEDPROCEDURE"))
			return getWasPlannedProcedure();
		if(fieldName.equals("WASUNPLANNEDPROCEDURE"))
			return getWasUnplannedProcedure();
		if(fieldName.equals("THEATRE"))
			return getTheatre();
		if(fieldName.equals("CATARACTINTRAOPERATIVEDETAIL"))
			return getCataractIntraOperativeDetail();
		if(fieldName.equals("ADMISSIONTYPE"))
			return getAdmissionType();
		if(fieldName.equals("READMISSIONTYPE"))
			return getReadmissionType();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("INTOPACUTIME"))
			return getIntoPacuTime();
		if(fieldName.equals("TIMEINTORECOVERY"))
			return getTimeIntoRecovery();
		if(fieldName.equals("TIMEOUTOFRECOVERY"))
			return getTimeOutOfRecovery();
		if(fieldName.equals("ANAESTHETICUSED"))
			return getAnaestheticUsed();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPlannedProcedureIsNotNull()
	{
		return this.plannedprocedure != null;
	}
	public ims.core.vo.PatientProcedureShortVo getPlannedProcedure()
	{
		return this.plannedprocedure;
	}
	public void setPlannedProcedure(ims.core.vo.PatientProcedureShortVo value)
	{
		this.isValidated = false;
		this.plannedprocedure = value;
	}
	public boolean getActualProcedureIsNotNull()
	{
		return this.actualprocedure != null;
	}
	public ims.core.vo.PatientProcedureLiteVo getActualProcedure()
	{
		return this.actualprocedure;
	}
	public void setActualProcedure(ims.core.vo.PatientProcedureLiteVo value)
	{
		this.isValidated = false;
		this.actualprocedure = value;
	}
	public boolean getProcedureDateIsNotNull()
	{
		return this.proceduredate != null;
	}
	public ims.framework.utils.Date getProcedureDate()
	{
		return this.proceduredate;
	}
	public void setProcedureDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.proceduredate = value;
	}
	public boolean getInTheatreTimeIsNotNull()
	{
		return this.intheatretime != null;
	}
	public ims.framework.utils.DateTime getInTheatreTime()
	{
		return this.intheatretime;
	}
	public void setInTheatreTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.intheatretime = value;
	}
	public boolean getSurgeryStartTimeIsNotNull()
	{
		return this.surgerystarttime != null;
	}
	public ims.framework.utils.DateTime getSurgeryStartTime()
	{
		return this.surgerystarttime;
	}
	public void setSurgeryStartTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.surgerystarttime = value;
	}
	public boolean getSurgeryEndTimeIsNotNull()
	{
		return this.surgeryendtime != null;
	}
	public ims.framework.utils.DateTime getSurgeryEndTime()
	{
		return this.surgeryendtime;
	}
	public void setSurgeryEndTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.surgeryendtime = value;
	}
	public boolean getAnaesthetistStartTimeIsNotNull()
	{
		return this.anaesthetiststarttime != null;
	}
	public ims.framework.utils.DateTime getAnaesthetistStartTime()
	{
		return this.anaesthetiststarttime;
	}
	public void setAnaesthetistStartTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.anaesthetiststarttime = value;
	}
	public boolean getSurgeonIsNotNull()
	{
		return this.surgeon != null;
	}
	public ims.core.vo.HcpLiteVo getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.surgeon = value;
	}
	public boolean getSurgeonAssistantIsNotNull()
	{
		return this.surgeonassistant != null;
	}
	public ims.core.vo.HcpLiteVo getSurgeonAssistant()
	{
		return this.surgeonassistant;
	}
	public void setSurgeonAssistant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.surgeonassistant = value;
	}
	public boolean getAnaesthetistIsNotNull()
	{
		return this.anaesthetist != null;
	}
	public ims.core.vo.HcpLiteVo getAnaesthetist()
	{
		return this.anaesthetist;
	}
	public void setAnaesthetist(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.anaesthetist = value;
	}
	public boolean getODAIsNotNull()
	{
		return this.oda != null;
	}
	public ims.core.vo.HcpLiteVo getODA()
	{
		return this.oda;
	}
	public void setODA(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.oda = value;
	}
	public boolean getScrubNurseIsNotNull()
	{
		return this.scrubnurse != null;
	}
	public ims.core.vo.NurseVo getScrubNurse()
	{
		return this.scrubnurse;
	}
	public void setScrubNurse(ims.core.vo.NurseVo value)
	{
		this.isValidated = false;
		this.scrubnurse = value;
	}
	public boolean getCirculatingNurseIsNotNull()
	{
		return this.circulatingnurse != null;
	}
	public ims.core.vo.NurseVo getCirculatingNurse()
	{
		return this.circulatingnurse;
	}
	public void setCirculatingNurse(ims.core.vo.NurseVo value)
	{
		this.isValidated = false;
		this.circulatingnurse = value;
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
	public boolean getIntraOperativeDetailsIsNotNull()
	{
		return this.intraoperativedetails != null;
	}
	public ims.clinical.vo.IntraOperativeDetailsVo getIntraOperativeDetails()
	{
		return this.intraoperativedetails;
	}
	public void setIntraOperativeDetails(ims.clinical.vo.IntraOperativeDetailsVo value)
	{
		this.isValidated = false;
		this.intraoperativedetails = value;
	}
	public boolean getWasPlannedProcedureIsNotNull()
	{
		return this.wasplannedprocedure != null;
	}
	public Boolean getWasPlannedProcedure()
	{
		return this.wasplannedprocedure;
	}
	public void setWasPlannedProcedure(Boolean value)
	{
		this.isValidated = false;
		this.wasplannedprocedure = value;
	}
	public boolean getWasUnplannedProcedureIsNotNull()
	{
		return this.wasunplannedprocedure != null;
	}
	public Boolean getWasUnplannedProcedure()
	{
		return this.wasunplannedprocedure;
	}
	public void setWasUnplannedProcedure(Boolean value)
	{
		this.isValidated = false;
		this.wasunplannedprocedure = value;
	}
	public boolean getTheatreIsNotNull()
	{
		return this.theatre != null;
	}
	public ims.core.vo.LocShortVo getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.theatre = value;
	}
	public boolean getCataractIntraOperativeDetailIsNotNull()
	{
		return this.cataractintraoperativedetail != null;
	}
	public ims.clinical.vo.CataractIntraOperativeDetailVo getCataractIntraOperativeDetail()
	{
		return this.cataractintraoperativedetail;
	}
	public void setCataractIntraOperativeDetail(ims.clinical.vo.CataractIntraOperativeDetailVo value)
	{
		this.isValidated = false;
		this.cataractintraoperativedetail = value;
	}
	public boolean getAdmissionTypeIsNotNull()
	{
		return this.admissiontype != null;
	}
	public ims.core.vo.lookups.AdmissionType getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.core.vo.lookups.AdmissionType value)
	{
		this.isValidated = false;
		this.admissiontype = value;
	}
	public boolean getReadmissionTypeIsNotNull()
	{
		return this.readmissiontype != null;
	}
	public ims.core.vo.lookups.ReadmissionType getReadmissionType()
	{
		return this.readmissiontype;
	}
	public void setReadmissionType(ims.core.vo.lookups.ReadmissionType value)
	{
		this.isValidated = false;
		this.readmissiontype = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.admin.pas.vo.PASEventRefVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.admin.pas.vo.PASEventRefVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getIntoPacuTimeIsNotNull()
	{
		return this.intopacutime != null;
	}
	public ims.framework.utils.DateTime getIntoPacuTime()
	{
		return this.intopacutime;
	}
	public void setIntoPacuTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.intopacutime = value;
	}
	public boolean getTimeIntoRecoveryIsNotNull()
	{
		return this.timeintorecovery != null;
	}
	public ims.framework.utils.DateTime getTimeIntoRecovery()
	{
		return this.timeintorecovery;
	}
	public void setTimeIntoRecovery(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeintorecovery = value;
	}
	public boolean getTimeOutOfRecoveryIsNotNull()
	{
		return this.timeoutofrecovery != null;
	}
	public ims.framework.utils.DateTime getTimeOutOfRecovery()
	{
		return this.timeoutofrecovery;
	}
	public void setTimeOutOfRecovery(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.timeoutofrecovery = value;
	}
	public boolean getAnaestheticUsedIsNotNull()
	{
		return this.anaestheticused != null;
	}
	public ims.clinical.vo.lookups.AnaestheticUsed getAnaestheticUsed()
	{
		return this.anaestheticused;
	}
	public void setAnaestheticUsed(ims.clinical.vo.lookups.AnaestheticUsed value)
	{
		this.isValidated = false;
		this.anaestheticused = value;
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
		if(this.plannedprocedure != null)
		{
			if(!this.plannedprocedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.actualprocedure != null)
		{
			if(!this.actualprocedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.intraoperativedetails != null)
		{
			if(!this.intraoperativedetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.cataractintraoperativedetail != null)
		{
			if(!this.cataractintraoperativedetail.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
		if(this.plannedprocedure == null)
			listOfErrors.add("PlannedProcedure is mandatory");
		if(this.plannedprocedure != null)
		{
			String[] listOfOtherErrors = this.plannedprocedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.actualprocedure == null)
			listOfErrors.add("ActualProcedure is mandatory");
		if(this.actualprocedure != null)
		{
			String[] listOfOtherErrors = this.actualprocedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.proceduredate == null)
			listOfErrors.add("ProcedureDate is mandatory");
		if(this.other != null)
			if(this.other.length() > 255)
				listOfErrors.add("The length of the field [other] in the value object [ims.clinical.vo.IntraOperativeCareRecordVo] is too big. It should be less or equal to 255");
		if(this.intraoperativedetails != null)
		{
			String[] listOfOtherErrors = this.intraoperativedetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.theatre == null)
			listOfErrors.add("Theatre is mandatory");
		if(this.cataractintraoperativedetail != null)
		{
			String[] listOfOtherErrors = this.cataractintraoperativedetail.validate();
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
	
		IntraOperativeCareRecordVo clone = new IntraOperativeCareRecordVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.plannedprocedure == null)
			clone.plannedprocedure = null;
		else
			clone.plannedprocedure = (ims.core.vo.PatientProcedureShortVo)this.plannedprocedure.clone();
		if(this.actualprocedure == null)
			clone.actualprocedure = null;
		else
			clone.actualprocedure = (ims.core.vo.PatientProcedureLiteVo)this.actualprocedure.clone();
		if(this.proceduredate == null)
			clone.proceduredate = null;
		else
			clone.proceduredate = (ims.framework.utils.Date)this.proceduredate.clone();
		if(this.intheatretime == null)
			clone.intheatretime = null;
		else
			clone.intheatretime = (ims.framework.utils.DateTime)this.intheatretime.clone();
		if(this.surgerystarttime == null)
			clone.surgerystarttime = null;
		else
			clone.surgerystarttime = (ims.framework.utils.DateTime)this.surgerystarttime.clone();
		if(this.surgeryendtime == null)
			clone.surgeryendtime = null;
		else
			clone.surgeryendtime = (ims.framework.utils.DateTime)this.surgeryendtime.clone();
		if(this.anaesthetiststarttime == null)
			clone.anaesthetiststarttime = null;
		else
			clone.anaesthetiststarttime = (ims.framework.utils.DateTime)this.anaesthetiststarttime.clone();
		if(this.surgeon == null)
			clone.surgeon = null;
		else
			clone.surgeon = (ims.core.vo.HcpLiteVo)this.surgeon.clone();
		if(this.surgeonassistant == null)
			clone.surgeonassistant = null;
		else
			clone.surgeonassistant = (ims.core.vo.HcpLiteVo)this.surgeonassistant.clone();
		if(this.anaesthetist == null)
			clone.anaesthetist = null;
		else
			clone.anaesthetist = (ims.core.vo.HcpLiteVo)this.anaesthetist.clone();
		if(this.oda == null)
			clone.oda = null;
		else
			clone.oda = (ims.core.vo.HcpLiteVo)this.oda.clone();
		if(this.scrubnurse == null)
			clone.scrubnurse = null;
		else
			clone.scrubnurse = (ims.core.vo.NurseVo)this.scrubnurse.clone();
		if(this.circulatingnurse == null)
			clone.circulatingnurse = null;
		else
			clone.circulatingnurse = (ims.core.vo.NurseVo)this.circulatingnurse.clone();
		clone.other = this.other;
		if(this.intraoperativedetails == null)
			clone.intraoperativedetails = null;
		else
			clone.intraoperativedetails = (ims.clinical.vo.IntraOperativeDetailsVo)this.intraoperativedetails.clone();
		clone.wasplannedprocedure = this.wasplannedprocedure;
		clone.wasunplannedprocedure = this.wasunplannedprocedure;
		if(this.theatre == null)
			clone.theatre = null;
		else
			clone.theatre = (ims.core.vo.LocShortVo)this.theatre.clone();
		if(this.cataractintraoperativedetail == null)
			clone.cataractintraoperativedetail = null;
		else
			clone.cataractintraoperativedetail = (ims.clinical.vo.CataractIntraOperativeDetailVo)this.cataractintraoperativedetail.clone();
		if(this.admissiontype == null)
			clone.admissiontype = null;
		else
			clone.admissiontype = (ims.core.vo.lookups.AdmissionType)this.admissiontype.clone();
		if(this.readmissiontype == null)
			clone.readmissiontype = null;
		else
			clone.readmissiontype = (ims.core.vo.lookups.ReadmissionType)this.readmissiontype.clone();
		clone.pasevent = this.pasevent;
		if(this.intopacutime == null)
			clone.intopacutime = null;
		else
			clone.intopacutime = (ims.framework.utils.DateTime)this.intopacutime.clone();
		if(this.timeintorecovery == null)
			clone.timeintorecovery = null;
		else
			clone.timeintorecovery = (ims.framework.utils.DateTime)this.timeintorecovery.clone();
		if(this.timeoutofrecovery == null)
			clone.timeoutofrecovery = null;
		else
			clone.timeoutofrecovery = (ims.framework.utils.DateTime)this.timeoutofrecovery.clone();
		if(this.anaestheticused == null)
			clone.anaestheticused = null;
		else
			clone.anaestheticused = (ims.clinical.vo.lookups.AnaestheticUsed)this.anaestheticused.clone();
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
		if (!(IntraOperativeCareRecordVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IntraOperativeCareRecordVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IntraOperativeCareRecordVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IntraOperativeCareRecordVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.authoringinformation != null)
			count++;
		if(this.plannedprocedure != null)
			count++;
		if(this.actualprocedure != null)
			count++;
		if(this.proceduredate != null)
			count++;
		if(this.intheatretime != null)
			count++;
		if(this.surgerystarttime != null)
			count++;
		if(this.surgeryendtime != null)
			count++;
		if(this.anaesthetiststarttime != null)
			count++;
		if(this.surgeon != null)
			count++;
		if(this.surgeonassistant != null)
			count++;
		if(this.anaesthetist != null)
			count++;
		if(this.oda != null)
			count++;
		if(this.scrubnurse != null)
			count++;
		if(this.circulatingnurse != null)
			count++;
		if(this.other != null)
			count++;
		if(this.intraoperativedetails != null)
			count++;
		if(this.wasplannedprocedure != null)
			count++;
		if(this.wasunplannedprocedure != null)
			count++;
		if(this.theatre != null)
			count++;
		if(this.cataractintraoperativedetail != null)
			count++;
		if(this.admissiontype != null)
			count++;
		if(this.readmissiontype != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.intopacutime != null)
			count++;
		if(this.timeintorecovery != null)
			count++;
		if(this.timeoutofrecovery != null)
			count++;
		if(this.anaestheticused != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 27;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.PatientProcedureShortVo plannedprocedure;
	protected ims.core.vo.PatientProcedureLiteVo actualprocedure;
	protected ims.framework.utils.Date proceduredate;
	protected ims.framework.utils.DateTime intheatretime;
	protected ims.framework.utils.DateTime surgerystarttime;
	protected ims.framework.utils.DateTime surgeryendtime;
	protected ims.framework.utils.DateTime anaesthetiststarttime;
	protected ims.core.vo.HcpLiteVo surgeon;
	protected ims.core.vo.HcpLiteVo surgeonassistant;
	protected ims.core.vo.HcpLiteVo anaesthetist;
	protected ims.core.vo.HcpLiteVo oda;
	protected ims.core.vo.NurseVo scrubnurse;
	protected ims.core.vo.NurseVo circulatingnurse;
	protected String other;
	protected ims.clinical.vo.IntraOperativeDetailsVo intraoperativedetails;
	protected Boolean wasplannedprocedure;
	protected Boolean wasunplannedprocedure;
	protected ims.core.vo.LocShortVo theatre;
	protected ims.clinical.vo.CataractIntraOperativeDetailVo cataractintraoperativedetail;
	protected ims.core.vo.lookups.AdmissionType admissiontype;
	protected ims.core.vo.lookups.ReadmissionType readmissiontype;
	protected ims.core.admin.pas.vo.PASEventRefVo pasevent;
	protected ims.framework.utils.DateTime intopacutime;
	protected ims.framework.utils.DateTime timeintorecovery;
	protected ims.framework.utils.DateTime timeoutofrecovery;
	protected ims.clinical.vo.lookups.AnaestheticUsed anaestheticused;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
