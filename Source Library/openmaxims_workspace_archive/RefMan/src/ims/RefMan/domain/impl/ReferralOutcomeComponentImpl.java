// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.65 build 3160.29066)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.helper.MedicationManagement;
import ims.RefMan.domain.ReferralWizard;
import ims.RefMan.domain.base.impl.BaseReferralOutcomeComponentImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.DischargeOutcome;
import ims.RefMan.domain.objects.ReferralOutcome;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralReportsVo;
import ims.RefMan.vo.CatsReferralStatusLiteVo;
import ims.RefMan.vo.CatsReferralStatusLiteVoCollection;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.ReferralDischargeVo;
import ims.RefMan.vo.ReferralOutcomeRefVo;
import ims.RefMan.vo.ReferralOutcomeVo;
import ims.RefMan.vo.ReferralOutcomeVoCollection;
import ims.RefMan.vo.domain.CatsReferralListVoAssembler;
import ims.RefMan.vo.domain.CatsReferralReportsVoAssembler;
import ims.RefMan.vo.domain.CatsReferralStatusLiteVoAssembler;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.domain.ReferralDischargeVoAssembler;
import ims.RefMan.vo.domain.ReferralOutcomeVoAssembler;
import ims.RefMan.vo.lookups.ReportStatus;
import ims.clinical.domain.ClinicalCoding;
import ims.clinical.domain.impl.ClinicalCodingImpl;
import ims.core.clinical.domain.objects.Service;
import ims.core.vo.MedicationVo;
import ims.core.vo.OrgLiteVoCollection;
import ims.core.vo.PatientDiagnosisLiteVoCollection;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.ServiceVo;
import ims.core.vo.domain.OrgLiteVoAssembler;
import ims.core.vo.domain.PatientDiagnosisLiteVoAssembler;
import ims.core.vo.domain.ServiceVoAssembler;
import ims.core.vo.lookups.OrganisationType;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.vo.OrderInvestigationListVoCollection;
import ims.ocrr.vo.domain.OrderInvestigationListVoAssembler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReferralOutcomeComponentImpl extends BaseReferralOutcomeComponentImpl
{
	private static final long serialVersionUID = 1L;

	public ProcedureLiteVoCollection listHotlistProcedureShort(String procedureName, Specialty specialty) throws DomainInterfaceException 
	{
		ClinicalCoding impl = (ClinicalCoding) getDomainImpl(ClinicalCodingImpl.class);
		return impl.listHotlistProcedureShort(procedureName, specialty);
	}

	public ServiceVo getCatsReferralService(CatsReferralRefVo voCatsReferralRef) 
	{
		CatsReferralListVo voCatsReferral = CatsReferralListVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsReferralRef.getID_CatsReferral()));
		if (voCatsReferral != null
			&& voCatsReferral.getReferralDetailsIsNotNull()
			&& voCatsReferral.getReferralDetails().getServiceIsNotNull())
			return ServiceVoAssembler.create((Service)getDomainFactory().getDomainObject(Service.class, voCatsReferral.getReferralDetails().getService().getID_Service()));

		return null;
	}

	public ReferralOutcomeVo saveReferralOutcome(ReferralOutcomeVo voReferralOutcome) throws StaleObjectException 
	{
		if(voReferralOutcome == null)
			throw new CodingRuntimeException("Invalid voReferralOutcome");
		if(!voReferralOutcome.isValidated())
			throw new CodingRuntimeException("voReferralOutcome not validated");
		
		DomainFactory factory = getDomainFactory();
		ReferralOutcome domainObject = ReferralOutcomeVoAssembler.extractReferralOutcome(factory, voReferralOutcome);
		
		//	WDEV-15465
		if(voReferralOutcome.getID_ReferralOutcome() == null && voReferralOutcome.getCatsReferral() != null && voReferralOutcome.getCatsReferral().getID_CatsReferral() != null)
		{
			CatsReferralRefVo catReferral = voReferralOutcome.getCatsReferral();
			String query = "select count(ro.id) from ReferralOutcome as ro where ro.catsReferral.id = :CatsReferral";
			
			long count = factory.countWithHQL(query, new String[] {"CatsReferral"}, new Object[] {catReferral.getID_CatsReferral()});
			
			if(count > 0)
				throw new StaleObjectException(domainObject);
		}
		
		factory.save(domainObject);
		
		return ReferralOutcomeVoAssembler.create(domainObject);
	}

	@SuppressWarnings("unchecked")
	public ReferralOutcomeVo getReferralOutcome(CatsReferralRefVo voCATSRef) 
	{
		if(voCATSRef != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from ReferralOutcome ro where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " ro.catsReferral.id = :cats order by ro.authoringInformation.authoringDateTime desc");
 			markers.add("cats");
			values.add(voCATSRef.getID_CatsReferral());
			andStr = " and ";	

			List listAdditional = factory.find(hql.toString(), markers,values);
			if(listAdditional != null && listAdditional.size() > 0)
			{ 
				ReferralOutcomeVoCollection voColl = ReferralOutcomeVoAssembler.createReferralOutcomeVoCollectionFromReferralOutcome(listAdditional);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public OrgLiteVoCollection listAllSuppliers() 
	{
		DomainFactory factory = getDomainFactory();

		String hql = " from Organisation org ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(andStr + " org.type.id = " + OrganisationType.SUPPLIER.getID());
		andStr = " and ";

		condStr.append(andStr + "org.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);	

		hql += " where ";
		hql += condStr.toString();

		List locations = factory.find(hql, markers, values, 1000);

		return OrgLiteVoAssembler.createOrgLiteVoCollectionFromOrganisation(locations).sort();

	}

	public CatsReferralWizardVo getCatsReferral(CatsReferralRefVo voCatsRef) 
	{
		ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
		return impl.getCatsReferral(voCatsRef);
	}

	public ims.RefMan.vo.CatsReferralReportsVo getCatsReferralReports(ims.RefMan.vo.CatsReferralRefVo voCatsRef)
	{
		return CatsReferralReportsVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}
	
	public CatsReferralWizardVo saveCatsReferral(CatsReferralWizardVo record) throws DomainInterfaceException, StaleObjectException 
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid referral wizard to save");
		if(!record.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral domainObject = CatsReferralWizardVoAssembler.extractCatsReferral(factory, record);		
		factory.save(domainObject);
		return CatsReferralWizardVoAssembler.create(domainObject);
	}
	
	public CatsReferralReportsVo saveCatsReferralReport(CatsReferralReportsVo record) throws DomainInterfaceException, StaleObjectException 
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid CatsReferralReportsVo to save");
		if(!record.isValidated())
			throw new DomainRuntimeException("CatsReferralReportsVo not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral domainObject = CatsReferralReportsVoAssembler.extractCatsReferral(factory, record);		
		factory.save(domainObject);
		return CatsReferralReportsVoAssembler.create(domainObject);
	}
	
	public MedicationVo createOrUpdateMedication(MedicationVo value) throws StaleObjectException 
	{
		return new MedicationManagement(getDomainFactory()).createOrUpdateMedication(value);
	}
	
	public CatsReferralStatusLiteVo getCatsReferralStatus(CatsReferralRefVo catsRefVo)
	{
		if(catsRefVo == null || catsRefVo.getID_CatsReferral() == null) {
			throw new CodingRuntimeException("CatsReferralVo is null or id not provided");
		}
				
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select status from CatsReferral cr left join cr.currentStatus as status ");
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		hql.append("  where cr.id = :idCatsRefferal");
		names.add("idCatsRefferal");
		values.add(catsRefVo.getID_CatsReferral());	
		
		List result = factory.find(hql.toString(),names,values);
		
		if (result != null) {
			CatsReferralStatusLiteVoCollection voColl = CatsReferralStatusLiteVoAssembler.createCatsReferralStatusLiteVoCollectionFromCATSReferralStatus(result);
			if(voColl != null && voColl.size() > 0)
				return voColl.get(0);
		}
		
		return null;
		
	}
	
	public CatsReferralWizardVo updateReferralOutcome(CatsReferralWizardVo record) throws StaleObjectException, ForeignKeyViolationException 
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid referral wizard to save");
		if(!record.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral cats = CatsReferralWizardVoAssembler.extractCatsReferral(factory, record);		
		
		ReferralOutcomeVo currentReferralOutcome = getReferralOutcome(record);
		
		
		if (currentReferralOutcome != null) 
		{	
			String[] str = currentReferralOutcome.validate();
			if (str != null && str.length > 0)
			{
				throw new CodingRuntimeException("ReferralOutcomeVo not validated");
			}
			
			ReferralDischargeVo currentReferralDischarge = currentReferralOutcome.getReferralDischarge();
			DischargeOutcome referralDischargeBO = ReferralDischargeVoAssembler.extractDischargeOutcome(factory, currentReferralDischarge);
					
			ReferralOutcome  referralOutcomeBO = ReferralOutcomeVoAssembler.extractReferralOutcome(factory, currentReferralOutcome);
			Set<DischargeOutcome> referralDischargeList = referralOutcomeBO.getReferralDischargeHistory();
			
			if (referralDischargeList != null) {
				referralDischargeList.add(referralDischargeBO);
				referralOutcomeBO.setReferralDischargeHistory(referralDischargeList);
			}
			
			referralOutcomeBO.setReferralDischarge(null);
			
			
			if (referralOutcomeBO.getCatsFinalReportStatus() != null)
			{
				if (referralOutcomeBO.getCatsFinalReportStatus().getId() == (ReportStatus.REQUIRED.getID())) 
				{
					cats.setIsFinalReportRequired(null);
					referralOutcomeBO.setCatsFinalReportStatus(null);
				}
				else 
				{
					cats.setIsFinalReportRequired(referralOutcomeBO.getCatsFinalReportStatus());
				}
			}

			factory.save(cats);
			factory.save(referralOutcomeBO);
			return CatsReferralWizardVoAssembler.create(cats);
		}		
		return null;
	}
	
	public ims.RefMan.vo.ReferralOutcomeVo getOutcome(ReferralOutcomeRefVo outcome)
	{
		if (outcome == null)
			throw new RuntimeException("Cannot get ReferralOutcomeVo for null ReferralOutcomeRefVo");

		ReferralOutcome doReferralOutcome = (ReferralOutcome) getDomainFactory().getDomainObject(ReferralOutcome.class, outcome.getID_ReferralOutcome());
		return ReferralOutcomeVoAssembler.create(doReferralOutcome);		
	}

	/**
	 * WDEV-12345
	 * Retrieve completed OrderInvestigations for provided Cats Referral record
	 */
	public OrderInvestigationListVoCollection getInvestigation(CatsReferralRefVo referral)
	{
		if (referral == null || !referral.getID_CatsReferralIsNotNull())
			return null;
		
		String query = "select investig from CatsReferral as cats left join cats.investigationOrders as orders left join orders.investigations as investig left join investig.resultDetails as resDet left join resDet.pathologyResultDetails as pathRes where cats.id = :ID and (resDet.clinicalResultDetails is not null or pathRes.id is not null)";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return OrderInvestigationListVoAssembler.createOrderInvestigationListVoCollectionFromOrderInvestigation(getDomainFactory().find(query, paramNames, paramValues));
	}

	/**
	 * WDEV-12345
	 * Retrieve PatientDiagnosis for provided Cats Referral record
	 * (PatientDiagnosis records that have the same CareContext as CatsReferral record)
	 */
	public PatientDiagnosisLiteVoCollection getDiagnosis(CatsReferralRefVo referral)
	{
		if (referral == null || !referral.getID_CatsReferralIsNotNull())
			return null;
		
		String query = "select diag from CatsReferral as cats left join cats.careContext as cc1, PatientDiagnosis as diag left join diag.careContext as cc2 where cats.id = :ID and cc1.id = cc2.id";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return PatientDiagnosisLiteVoAssembler.createPatientDiagnosisLiteVoCollectionFromPatientDiagnosis(getDomainFactory().find(query, paramNames, paramValues));
	}
}
