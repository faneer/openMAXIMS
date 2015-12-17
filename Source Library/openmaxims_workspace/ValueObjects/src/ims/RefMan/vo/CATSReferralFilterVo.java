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


public class CATSReferralFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CATSReferralFilterVo()
	{
	}
	public CATSReferralFilterVo(ims.RefMan.vo.beans.CATSReferralFilterVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.status = bean.getStatus() == null ? null : ims.RefMan.vo.lookups.ReferralWorklistStatus.buildLookup(bean.getStatus());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.clinictype = bean.getClinicType() == null ? null : bean.getClinicType().buildVo();
		this.dos = bean.getDOS() == null ? null : bean.getDOS().buildVo();
		this.iscab = bean.getIsCAB();
		this.ismanual = bean.getIsManual();
		this.isdad = bean.getIsDAD();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ReviewType.buildLookup(bean.getReviewType());
		this.excludeprovidercancellation = bean.getExcludeProviderCancellation();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.allocatedto = bean.getAllocatedTo() == null ? null : bean.getAllocatedTo().buildVo();
		this.reportsubcategory = bean.getReportSubCategory() == null ? null : ims.RefMan.vo.lookups.ReportsRequiredSubCategory.buildLookup(bean.getReportSubCategory());
		this.tlttype = bean.getTLTType() == null ? null : ims.RefMan.vo.lookups.TLTType.buildLookup(bean.getTLTType());
		this.onwardreferralreason = bean.getOnwardReferralReason() == null ? null : ims.RefMan.vo.lookups.OnwardReferralReason.buildLookup(bean.getOnwardReferralReason());
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo();
		this.secondopinionreason = bean.getSecondOpinionReason() == null ? null : ims.RefMan.vo.lookups.SecondOpinionCategory.buildLookup(bean.getSecondOpinionReason());
		this.opdsite = bean.getOPDSite() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getOPDSite().getId()), bean.getOPDSite().getVersion());
		this.sfsfromdate = bean.getSfSFromDate() == null ? null : bean.getSfSFromDate().buildDate();
		this.sfstodate = bean.getSfSToDate() == null ? null : bean.getSfSToDate().buildDate();
		this.nhsnumber = bean.getNHSNumber();
		this.procedure = bean.getProcedure() == null ? null : new ims.core.clinical.vo.ProcedureRefVo(new Integer(bean.getProcedure().getId()), bean.getProcedure().getVersion());
		this.dischargefromdate = bean.getDischargeFromDate() == null ? null : bean.getDischargeFromDate().buildDate();
		this.dischargetodate = bean.getDischargeToDate() == null ? null : bean.getDischargeToDate().buildDate();
		if(bean.getContractsForOrg() != null)
		{
			this.contractsfororg = new ims.core.configuration.vo.ContractConfigRefVoCollection();
			for(int contractsfororg_i = 0; contractsfororg_i < bean.getContractsForOrg().length; contractsfororg_i++)
			{
				this.contractsfororg.add(new ims.core.configuration.vo.ContractConfigRefVo(new Integer(bean.getContractsForOrg()[contractsfororg_i].getId()), bean.getContractsForOrg()[contractsfororg_i].getVersion()));
			}
		}
		this.treatmentcenter = bean.getTreatmentCenter() == null ? null : bean.getTreatmentCenter().buildVo();
		// Interface field type not supported.
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.referralurgencies = ims.RefMan.vo.lookups.ReferralUrgencyCollection.buildFromBeanCollection(bean.getReferralUrgencies());
		this.noresponsiblehcp = bean.getNoResponsibleHCP();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CATSReferralFilterVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.status = bean.getStatus() == null ? null : ims.RefMan.vo.lookups.ReferralWorklistStatus.buildLookup(bean.getStatus());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.clinictype = bean.getClinicType() == null ? null : bean.getClinicType().buildVo(map);
		this.dos = bean.getDOS() == null ? null : bean.getDOS().buildVo(map);
		this.iscab = bean.getIsCAB();
		this.ismanual = bean.getIsManual();
		this.isdad = bean.getIsDAD();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ReviewType.buildLookup(bean.getReviewType());
		this.excludeprovidercancellation = bean.getExcludeProviderCancellation();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.allocatedto = bean.getAllocatedTo() == null ? null : bean.getAllocatedTo().buildVo(map);
		this.reportsubcategory = bean.getReportSubCategory() == null ? null : ims.RefMan.vo.lookups.ReportsRequiredSubCategory.buildLookup(bean.getReportSubCategory());
		this.tlttype = bean.getTLTType() == null ? null : ims.RefMan.vo.lookups.TLTType.buildLookup(bean.getTLTType());
		this.onwardreferralreason = bean.getOnwardReferralReason() == null ? null : ims.RefMan.vo.lookups.OnwardReferralReason.buildLookup(bean.getOnwardReferralReason());
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo(map);
		this.secondopinionreason = bean.getSecondOpinionReason() == null ? null : ims.RefMan.vo.lookups.SecondOpinionCategory.buildLookup(bean.getSecondOpinionReason());
		this.opdsite = bean.getOPDSite() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getOPDSite().getId()), bean.getOPDSite().getVersion());
		this.sfsfromdate = bean.getSfSFromDate() == null ? null : bean.getSfSFromDate().buildDate();
		this.sfstodate = bean.getSfSToDate() == null ? null : bean.getSfSToDate().buildDate();
		this.nhsnumber = bean.getNHSNumber();
		this.procedure = bean.getProcedure() == null ? null : new ims.core.clinical.vo.ProcedureRefVo(new Integer(bean.getProcedure().getId()), bean.getProcedure().getVersion());
		this.dischargefromdate = bean.getDischargeFromDate() == null ? null : bean.getDischargeFromDate().buildDate();
		this.dischargetodate = bean.getDischargeToDate() == null ? null : bean.getDischargeToDate().buildDate();
		if(bean.getContractsForOrg() != null)
		{
			this.contractsfororg = new ims.core.configuration.vo.ContractConfigRefVoCollection();
			for(int contractsfororg_i = 0; contractsfororg_i < bean.getContractsForOrg().length; contractsfororg_i++)
			{
				this.contractsfororg.add(new ims.core.configuration.vo.ContractConfigRefVo(new Integer(bean.getContractsForOrg()[contractsfororg_i].getId()), bean.getContractsForOrg()[contractsfororg_i].getVersion()));
			}
		}
		this.treatmentcenter = bean.getTreatmentCenter() == null ? null : bean.getTreatmentCenter().buildVo(map);
		// Interface field type not supported.
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.referralurgencies = ims.RefMan.vo.lookups.ReferralUrgencyCollection.buildFromBeanCollection(bean.getReferralUrgencies());
		this.noresponsiblehcp = bean.getNoResponsibleHCP();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CATSReferralFilterVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CATSReferralFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CATSReferralFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.Date getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.Date getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todate = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.RefMan.vo.lookups.ReferralWorklistStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.RefMan.vo.lookups.ReferralWorklistStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceShortVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceShortVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getClinicTypeIsNotNull()
	{
		return this.clinictype != null;
	}
	public ims.core.vo.ServiceFunctionLiteVo getClinicType()
	{
		return this.clinictype;
	}
	public void setClinicType(ims.core.vo.ServiceFunctionLiteVo value)
	{
		this.isValidated = false;
		this.clinictype = value;
	}
	public boolean getDOSIsNotNull()
	{
		return this.dos != null;
	}
	public ims.scheduling.vo.DirectoryOfServiceLiteVo getDOS()
	{
		return this.dos;
	}
	public void setDOS(ims.scheduling.vo.DirectoryOfServiceLiteVo value)
	{
		this.isValidated = false;
		this.dos = value;
	}
	public boolean getIsCABIsNotNull()
	{
		return this.iscab != null;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.isValidated = false;
		this.iscab = value;
	}
	public boolean getIsManualIsNotNull()
	{
		return this.ismanual != null;
	}
	public Boolean getIsManual()
	{
		return this.ismanual;
	}
	public void setIsManual(Boolean value)
	{
		this.isValidated = false;
		this.ismanual = value;
	}
	public boolean getIsDADIsNotNull()
	{
		return this.isdad != null;
	}
	public Boolean getIsDAD()
	{
		return this.isdad;
	}
	public void setIsDAD(Boolean value)
	{
		this.isValidated = false;
		this.isdad = value;
	}
	public boolean getReviewTypeIsNotNull()
	{
		return this.reviewtype != null;
	}
	public ims.RefMan.vo.lookups.ReviewType getReviewType()
	{
		return this.reviewtype;
	}
	public void setReviewType(ims.RefMan.vo.lookups.ReviewType value)
	{
		this.isValidated = false;
		this.reviewtype = value;
	}
	public boolean getExcludeProviderCancellationIsNotNull()
	{
		return this.excludeprovidercancellation != null;
	}
	public Boolean getExcludeProviderCancellation()
	{
		return this.excludeprovidercancellation;
	}
	public void setExcludeProviderCancellation(Boolean value)
	{
		this.isValidated = false;
		this.excludeprovidercancellation = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getAllocatedToIsNotNull()
	{
		return this.allocatedto != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAllocatedTo()
	{
		return this.allocatedto;
	}
	public void setAllocatedTo(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.allocatedto = value;
	}
	public boolean getReportSubCategoryIsNotNull()
	{
		return this.reportsubcategory != null;
	}
	public ims.RefMan.vo.lookups.ReportsRequiredSubCategory getReportSubCategory()
	{
		return this.reportsubcategory;
	}
	public void setReportSubCategory(ims.RefMan.vo.lookups.ReportsRequiredSubCategory value)
	{
		this.isValidated = false;
		this.reportsubcategory = value;
	}
	public boolean getTLTTypeIsNotNull()
	{
		return this.tlttype != null;
	}
	public ims.RefMan.vo.lookups.TLTType getTLTType()
	{
		return this.tlttype;
	}
	public void setTLTType(ims.RefMan.vo.lookups.TLTType value)
	{
		this.isValidated = false;
		this.tlttype = value;
	}
	public boolean getOnwardReferralReasonIsNotNull()
	{
		return this.onwardreferralreason != null;
	}
	public ims.RefMan.vo.lookups.OnwardReferralReason getOnwardReferralReason()
	{
		return this.onwardreferralreason;
	}
	public void setOnwardReferralReason(ims.RefMan.vo.lookups.OnwardReferralReason value)
	{
		this.isValidated = false;
		this.onwardreferralreason = value;
	}
	public boolean getNoteTypeIsNotNull()
	{
		return this.notetype != null;
	}
	public ims.RefMan.vo.lookups.ReportNoteType getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.RefMan.vo.lookups.ReportNoteType value)
	{
		this.isValidated = false;
		this.notetype = value;
	}
	public boolean getContractIsNotNull()
	{
		return this.contract != null;
	}
	public ims.RefMan.vo.ContractConfigForReferralDetailsComponentVo getContract()
	{
		return this.contract;
	}
	public void setContract(ims.RefMan.vo.ContractConfigForReferralDetailsComponentVo value)
	{
		this.isValidated = false;
		this.contract = value;
	}
	public boolean getSecondOpinionReasonIsNotNull()
	{
		return this.secondopinionreason != null;
	}
	public ims.RefMan.vo.lookups.SecondOpinionCategory getSecondOpinionReason()
	{
		return this.secondopinionreason;
	}
	public void setSecondOpinionReason(ims.RefMan.vo.lookups.SecondOpinionCategory value)
	{
		this.isValidated = false;
		this.secondopinionreason = value;
	}
	public boolean getOPDSiteIsNotNull()
	{
		return this.opdsite != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getOPDSite()
	{
		return this.opdsite;
	}
	public void setOPDSite(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.opdsite = value;
	}
	public boolean getSfSFromDateIsNotNull()
	{
		return this.sfsfromdate != null;
	}
	public ims.framework.utils.Date getSfSFromDate()
	{
		return this.sfsfromdate;
	}
	public void setSfSFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.sfsfromdate = value;
	}
	public boolean getSfSToDateIsNotNull()
	{
		return this.sfstodate != null;
	}
	public ims.framework.utils.Date getSfSToDate()
	{
		return this.sfstodate;
	}
	public void setSfSToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.sfstodate = value;
	}
	public boolean getNHSNumberIsNotNull()
	{
		return this.nhsnumber != null;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public static int getNHSNumberMaxLength()
	{
		return 255;
	}
	public void setNHSNumber(String value)
	{
		this.isValidated = false;
		this.nhsnumber = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.clinical.vo.ProcedureRefVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.clinical.vo.ProcedureRefVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getDischargeFromDateIsNotNull()
	{
		return this.dischargefromdate != null;
	}
	public ims.framework.utils.Date getDischargeFromDate()
	{
		return this.dischargefromdate;
	}
	public void setDischargeFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargefromdate = value;
	}
	public boolean getDischargeToDateIsNotNull()
	{
		return this.dischargetodate != null;
	}
	public ims.framework.utils.Date getDischargeToDate()
	{
		return this.dischargetodate;
	}
	public void setDischargeToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargetodate = value;
	}
	public boolean getContractsForOrgIsNotNull()
	{
		return this.contractsfororg != null;
	}
	public ims.core.configuration.vo.ContractConfigRefVoCollection getContractsForOrg()
	{
		return this.contractsfororg;
	}
	public void setContractsForOrg(ims.core.configuration.vo.ContractConfigRefVoCollection value)
	{
		this.isValidated = false;
		this.contractsfororg = value;
	}
	public boolean getTreatmentCenterIsNotNull()
	{
		return this.treatmentcenter != null;
	}
	public ims.RefMan.vo.ContractServiceLocationsConfigVo getTreatmentCenter()
	{
		return this.treatmentcenter;
	}
	public void setTreatmentCenter(ims.RefMan.vo.ContractServiceLocationsConfigVo value)
	{
		this.isValidated = false;
		this.treatmentcenter = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.vo.interfaces.IMos getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getServicesIsNotNull()
	{
		return this.services != null;
	}
	public ims.core.vo.ServiceShortVoCollection getServices()
	{
		return this.services;
	}
	public void setServices(ims.core.vo.ServiceShortVoCollection value)
	{
		this.isValidated = false;
		this.services = value;
	}
	public boolean getReferralUrgenciesIsNotNull()
	{
		return this.referralurgencies != null;
	}
	public ims.RefMan.vo.lookups.ReferralUrgencyCollection getReferralUrgencies()
	{
		return this.referralurgencies;
	}
	public void setReferralUrgencies(ims.RefMan.vo.lookups.ReferralUrgencyCollection value)
	{
		this.isValidated = false;
		this.referralurgencies = value;
	}
	public boolean getNoResponsibleHCPIsNotNull()
	{
		return this.noresponsiblehcp != null;
	}
	public Boolean getNoResponsibleHCP()
	{
		return this.noresponsiblehcp;
	}
	public void setNoResponsibleHCP(Boolean value)
	{
		this.isValidated = false;
		this.noresponsiblehcp = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof CATSReferralFilterVo))
			return false;
		CATSReferralFilterVo compareObj = (CATSReferralFilterVo)obj;
		if(this.getPatient() == null && compareObj.getPatient() != null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() == null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() != null)
			return this.getPatient().equals(compareObj.getPatient());
		return super.equals(obj);
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinictype != null)
		{
			if(!this.clinictype.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.dos != null)
		{
			if(!this.dos.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.location != null)
		{
			if(!this.location.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.allocatedto != null)
		{
			if(!this.allocatedto.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.contract != null)
		{
			if(!this.contract.isValidated())
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
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinictype != null)
		{
			String[] listOfOtherErrors = this.clinictype.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dos != null)
		{
			String[] listOfOtherErrors = this.dos.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allocatedto != null)
		{
			String[] listOfOtherErrors = this.allocatedto.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.contract != null)
		{
			String[] listOfOtherErrors = this.contract.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CATSReferralFilterVo clone = new CATSReferralFilterVo();
		
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.Date)this.fromdate.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.Date)this.todate.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.RefMan.vo.lookups.ReferralWorklistStatus)this.status.clone();
		clone.patient = this.patient;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.clinictype == null)
			clone.clinictype = null;
		else
			clone.clinictype = (ims.core.vo.ServiceFunctionLiteVo)this.clinictype.clone();
		if(this.dos == null)
			clone.dos = null;
		else
			clone.dos = (ims.scheduling.vo.DirectoryOfServiceLiteVo)this.dos.clone();
		clone.iscab = this.iscab;
		clone.ismanual = this.ismanual;
		clone.isdad = this.isdad;
		if(this.reviewtype == null)
			clone.reviewtype = null;
		else
			clone.reviewtype = (ims.RefMan.vo.lookups.ReviewType)this.reviewtype.clone();
		clone.excludeprovidercancellation = this.excludeprovidercancellation;
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
		if(this.allocatedto == null)
			clone.allocatedto = null;
		else
			clone.allocatedto = (ims.core.vo.MemberOfStaffLiteVo)this.allocatedto.clone();
		if(this.reportsubcategory == null)
			clone.reportsubcategory = null;
		else
			clone.reportsubcategory = (ims.RefMan.vo.lookups.ReportsRequiredSubCategory)this.reportsubcategory.clone();
		if(this.tlttype == null)
			clone.tlttype = null;
		else
			clone.tlttype = (ims.RefMan.vo.lookups.TLTType)this.tlttype.clone();
		if(this.onwardreferralreason == null)
			clone.onwardreferralreason = null;
		else
			clone.onwardreferralreason = (ims.RefMan.vo.lookups.OnwardReferralReason)this.onwardreferralreason.clone();
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.RefMan.vo.lookups.ReportNoteType)this.notetype.clone();
		if(this.contract == null)
			clone.contract = null;
		else
			clone.contract = (ims.RefMan.vo.ContractConfigForReferralDetailsComponentVo)this.contract.clone();
		if(this.secondopinionreason == null)
			clone.secondopinionreason = null;
		else
			clone.secondopinionreason = (ims.RefMan.vo.lookups.SecondOpinionCategory)this.secondopinionreason.clone();
		clone.opdsite = this.opdsite;
		if(this.sfsfromdate == null)
			clone.sfsfromdate = null;
		else
			clone.sfsfromdate = (ims.framework.utils.Date)this.sfsfromdate.clone();
		if(this.sfstodate == null)
			clone.sfstodate = null;
		else
			clone.sfstodate = (ims.framework.utils.Date)this.sfstodate.clone();
		clone.nhsnumber = this.nhsnumber;
		clone.procedure = this.procedure;
		if(this.dischargefromdate == null)
			clone.dischargefromdate = null;
		else
			clone.dischargefromdate = (ims.framework.utils.Date)this.dischargefromdate.clone();
		if(this.dischargetodate == null)
			clone.dischargetodate = null;
		else
			clone.dischargetodate = (ims.framework.utils.Date)this.dischargetodate.clone();
		clone.contractsfororg = this.contractsfororg;
		if(this.treatmentcenter == null)
			clone.treatmentcenter = null;
		else
			clone.treatmentcenter = (ims.RefMan.vo.ContractServiceLocationsConfigVo)this.treatmentcenter.clone();
		clone.responsiblehcp = this.responsiblehcp;
		if(this.services == null)
			clone.services = null;
		else
			clone.services = (ims.core.vo.ServiceShortVoCollection)this.services.clone();
		if(this.referralurgencies == null)
			clone.referralurgencies = null;
		else
			clone.referralurgencies = (ims.RefMan.vo.lookups.ReferralUrgencyCollection)this.referralurgencies.clone();
		clone.noresponsiblehcp = this.noresponsiblehcp;
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
		if (!(CATSReferralFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CATSReferralFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CATSReferralFilterVo compareObj = (CATSReferralFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
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
		if(this.fromdate != null)
			count++;
		if(this.todate != null)
			count++;
		if(this.status != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.service != null)
			count++;
		if(this.clinictype != null)
			count++;
		if(this.dos != null)
			count++;
		if(this.iscab != null)
			count++;
		if(this.ismanual != null)
			count++;
		if(this.isdad != null)
			count++;
		if(this.reviewtype != null)
			count++;
		if(this.excludeprovidercancellation != null)
			count++;
		if(this.location != null)
			count++;
		if(this.allocatedto != null)
			count++;
		if(this.reportsubcategory != null)
			count++;
		if(this.tlttype != null)
			count++;
		if(this.onwardreferralreason != null)
			count++;
		if(this.notetype != null)
			count++;
		if(this.contract != null)
			count++;
		if(this.secondopinionreason != null)
			count++;
		if(this.opdsite != null)
			count++;
		if(this.sfsfromdate != null)
			count++;
		if(this.sfstodate != null)
			count++;
		if(this.nhsnumber != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.dischargefromdate != null)
			count++;
		if(this.dischargetodate != null)
			count++;
		if(this.contractsfororg != null)
			count++;
		if(this.treatmentcenter != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.services != null)
			count++;
		if(this.referralurgencies != null)
			count++;
		if(this.noresponsiblehcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 33;
	}
	protected ims.framework.utils.Date fromdate;
	protected ims.framework.utils.Date todate;
	protected ims.RefMan.vo.lookups.ReferralWorklistStatus status;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.ServiceShortVo service;
	protected ims.core.vo.ServiceFunctionLiteVo clinictype;
	protected ims.scheduling.vo.DirectoryOfServiceLiteVo dos;
	protected Boolean iscab;
	protected Boolean ismanual;
	protected Boolean isdad;
	protected ims.RefMan.vo.lookups.ReviewType reviewtype;
	protected Boolean excludeprovidercancellation;
	protected ims.core.vo.LocationLiteVo location;
	protected ims.core.vo.MemberOfStaffLiteVo allocatedto;
	protected ims.RefMan.vo.lookups.ReportsRequiredSubCategory reportsubcategory;
	protected ims.RefMan.vo.lookups.TLTType tlttype;
	protected ims.RefMan.vo.lookups.OnwardReferralReason onwardreferralreason;
	protected ims.RefMan.vo.lookups.ReportNoteType notetype;
	protected ims.RefMan.vo.ContractConfigForReferralDetailsComponentVo contract;
	protected ims.RefMan.vo.lookups.SecondOpinionCategory secondopinionreason;
	protected ims.core.resource.place.vo.LocationRefVo opdsite;
	protected ims.framework.utils.Date sfsfromdate;
	protected ims.framework.utils.Date sfstodate;
	protected String nhsnumber;
	protected ims.core.clinical.vo.ProcedureRefVo procedure;
	protected ims.framework.utils.Date dischargefromdate;
	protected ims.framework.utils.Date dischargetodate;
	protected ims.core.configuration.vo.ContractConfigRefVoCollection contractsfororg;
	protected ims.RefMan.vo.ContractServiceLocationsConfigVo treatmentcenter;
	protected ims.vo.interfaces.IMos responsiblehcp;
	protected ims.core.vo.ServiceShortVoCollection services;
	protected ims.RefMan.vo.lookups.ReferralUrgencyCollection referralurgencies;
	protected Boolean noresponsiblehcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
