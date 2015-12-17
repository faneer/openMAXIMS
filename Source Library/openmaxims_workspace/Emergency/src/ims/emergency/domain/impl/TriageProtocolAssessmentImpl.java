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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.core.admin.domain.objects.EmergencyEpisode;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.VitalSignsAll;
import ims.core.domain.impl.VitalSignsImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.GpShortVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.VSMetrics;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.StaffType;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration;
import ims.emergency.domain.base.impl.BaseTriageProtocolAssessmentImpl;
import ims.emergency.domain.objects.Triage;
import ims.emergency.domain.objects.TriageProtocolAssessment;
import ims.emergency.vo.EmergencyEpisodeForTriageLiteVo;
import ims.emergency.vo.ManchesterTriageProtocolConfigForTriageProtocolAssessmentVo;
import ims.emergency.vo.TriageForTriageProtocolAssessmentVo;
import ims.emergency.vo.TriageProtocolAssessmentRefVo;
import ims.emergency.vo.TriageProtocolAssessmentVo;
import ims.emergency.vo.TriageRefVo;
import ims.emergency.vo.domain.EmergencyEpisodeForTriageLiteVoAssembler;
import ims.emergency.vo.domain.ManchesterTriageProtocolConfigForTriageProtocolAssessmentVoAssembler;
import ims.emergency.vo.domain.TriageForTriageProtocolAssessmentVoAssembler;
import ims.emergency.vo.domain.TriageProtocolAssessmentVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.helper.PatientICPDomainHelper;
import ims.icp.helper.PatientICPHelperInterface;
import ims.icp.vo.ICPConfiguration_CreateVo;
import ims.icp.vo.PatientICP_CreationVo;
import ims.icp.vo.domain.ICPConfiguration_CreateVoAssembler;
import ims.icp.vo.domain.PatientICP_CreationVoAssembler;
import ims.icps.configuration.domain.objects.ICP;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.vo.PatientICPRefVo;

import java.util.ArrayList;
import java.util.List;


public class TriageProtocolAssessmentImpl extends BaseTriageProtocolAssessmentImpl
{

	private static final long serialVersionUID = 1L;


	public TriageForTriageProtocolAssessmentVo getTriage(TriageRefVo triage)
	{
		if (triage == null || triage.getID_Triage() == null)
			return null;
		
		return TriageForTriageProtocolAssessmentVoAssembler.create((Triage) getDomainFactory().getDomainObject(Triage.class, triage.getID_Triage()));
	}
	

	public TriageProtocolAssessmentVo getTriageProtocolAssessment(TriageProtocolAssessmentRefVo triageProtocol)
	{
		if (triageProtocol == null || triageProtocol.getID_TriageProtocolAssessment() == null)
			return null;
		
		return TriageProtocolAssessmentVoAssembler.create((TriageProtocolAssessment) getDomainFactory().getDomainObject(TriageProtocolAssessment.class, triageProtocol.getID_TriageProtocolAssessment()));
	}

	
	public Boolean getIsPatientInED(TriageRefVo triage)
	{
		if (triage == null || triage.getID_Triage() == null)
			return Boolean.FALSE;
		
		String query = "SELECT tracking.isDischarged FROM Tracking AS tracking LEFT JOIN tracking.triageDetails AS triage WHERE triage.id = :ID_TRIAGE";
		
		List<?> results = getDomainFactory().find(query, "ID_TRIAGE", triage.getID_Triage());
		
		if (results != null && results.size() > 0)
		{
			if (Boolean.TRUE.equals(results.get(0)))
				return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}

	
	public EmergencyEpisodeForTriageLiteVo getEmergencyEpisode(EpisodeOfCareRefVo episodeOfCare)
	{
		if (episodeOfCare == null || episodeOfCare.getID_EpisodeOfCare() == null)
			return null;
		
		String query = "SELECT emerEpisode FROM EmergencyEpisode AS emerEpisode LEFT JOIN emerEpisode.episodeOfCare AS epis WHERE epis.id = :EPIS";
		
		return EmergencyEpisodeForTriageLiteVoAssembler.create((EmergencyEpisode) getDomainFactory().findFirst(query, "EPIS", episodeOfCare.getID_EpisodeOfCare()));
	}


	
	public ClinicalProblemShortVoCollection listProblems(String problemName)
	{
		if(problemName == null)
			return null;
		
		problemName = problemName.trim().toUpperCase();
		
		if(problemName == null || problemName.length() == 0)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select cp from ClinicalProblem as cp left join cp.keywords as k where (UPPER(cp.pCName) like :ClinicalProblemSearchText or UPPER(k.keyword) like :ClinicalProblemSearchText) and cp.isActive = 1 order by upper(cp.pCName) asc";
		
		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem((List<?>) factory.find(query, "ClinicalProblemSearchText", problemName + "%"));
	}

	
	public HcpLiteVoCollection listNurses(String personName)
	{
		if (personName == null)
			return null;
		
		
		String query = "SELECT hcp FROM Hcp AS hcp WHERE hcp.mos.name.upperSurname LIKE :NAME and hcp.mos.staffType.id = :staffType AND hcp.isActive = 1 ORDER BY hcp.mos.name.upperSurname ASC"; //WDEV-17240
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		
		paramNames.add("NAME");				paramValues.add(personName.toUpperCase() + "%");//WDEV-17240
		paramNames.add("staffType");		paramValues.add(StaffType.HCP.getID()); //WDEV-17240

		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(getDomainFactory().find(query, paramNames, paramValues));
	}

	
	public ManchesterTriageProtocolConfigForTriageProtocolAssessmentVo getTriageProtocol(ClinicalProblemRefVo problem)
	{
		if (problem == null)
			return null;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT manTriage FROM ManchesterTriageProtocolConfiguration AS manTriage LEFT JOIN manTriage.problem AS problem LEFT JOIN FETCH manTriage.discriminators AS disc LEFT JOIN FETCH disc.discriminator LEFT JOIN manTriage.activeStatus AS status ");
		query.append(" WHERE problem.id = :PROBLEM AND status.id = :ACTIVE ORDER BY UPPER(manTriage.protocolName) ASC");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("PROBLEM");		paramValues.add(problem.getID_ClinicalProblem());
		paramNames.add("ACTIVE");		paramValues.add(PreActiveActiveInactiveStatus.ACTIVE.getID());
		
		return ManchesterTriageProtocolConfigForTriageProtocolAssessmentVoAssembler.create((ManchesterTriageProtocolConfiguration) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	public void saveTriageWithAssessment(TriageForTriageProtocolAssessmentVo triage, TriageProtocolAssessmentVo triageProtocol) throws StaleObjectException
	{
		if (triage == null)
			throw new CodingRuntimeException("Triage record to save is null.");
		
		if (!triage.isValidated())
			throw new CodingRuntimeException("Triage record is not validated.");
		
		if (triage.getCurrentTriageAssessmentIsNotNull())
		{
			if (Boolean.TRUE.equals(triage.getCurrentTriageAssessment().getIsMain()) && triage.getCurrentTriagePathway() == null)
			{
				PatientRefVo patient = triage.getCurrentTriageAssessment().getPatient();
				CareContextRefVo careContext = triage.getCurrentTriageAssessment().getAttendance();
				HcpLiteVo hcp = triage.getCurrentTriageAssessment().getAssessmentNurse();
				
				triage.setCurrentTriagePathway(createSavePatientICP(triage.getCurrentTriageAssessment().getPatientProblem().getProblem(), patient, careContext, hcp));
			}
		}

		Triage domainTriage = TriageForTriageProtocolAssessmentVoAssembler.extractTriage(getDomainFactory(), triage);
		
		if (triageProtocol != null)
		{
			TriageProtocolAssessment domainTriageProtocol = TriageProtocolAssessmentVoAssembler.extractTriageProtocolAssessment(getDomainFactory(), triageProtocol);
			
			getDomainFactory().save(domainTriageProtocol);
		}
		
		getDomainFactory().save(domainTriage);
	}


	private PatientICPRefVo createSavePatientICP(ClinicalProblemRefVo problem, PatientRefVo patient, CareContextRefVo careContext, HcpLiteVo hcp) throws StaleObjectException
	{
		// Check problem parameter
		if (problem == null)
			return null;

		long startTime = System.currentTimeMillis();

		// Get ICP Configuration for
		StringBuilder query = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("SELECT icp FROM ICP AS icp LEFT JOIN icp.problem AS problem ");
		query.append(" LEFT JOIN FETCH icp.stages AS stage LEFT JOIN FETCH stage.phases AS phase LEFT JOIN FETCH phase.actions");
		query.append(" WHERE problem.id = :PROBLEM AND icp.status.id = :ACTIVE_STATUS");

		paramNames.add("PROBLEM");				paramValues.add(problem.getID_ClinicalProblem());
		paramNames.add("ACTIVE_STATUS");		paramValues.add(PreActiveActiveInactiveStatus.ACTIVE.getID());
		
		ICPConfiguration_CreateVo icpConfig = ICPConfiguration_CreateVoAssembler.create((ICP) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
		
		if (icpConfig == null)
			return null;
		
		// Create Patient ICP record
		PatientICPHelperInterface helperICP = (PatientICPHelperInterface) getDomainImpl(PatientICPDomainHelper.class);
		PatientICP_CreationVo patientICP = helperICP.createPatientICP(icpConfig, patient, careContext, null, null, hcp);
		
		// Save Patient ICP record
		PatientICP domainPatientICP = PatientICP_CreationVoAssembler.extractPatientICP(getDomainFactory(), patientICP);
		
		getDomainFactory().save(domainPatientICP);
		
		long endTime = System.currentTimeMillis();
		
		@SuppressWarnings("unused")
		long miliseconds = endTime - startTime;

		// Return Patient ICP Ref VO
		return new PatientICPRefVo(domainPatientICP.getId(), domainPatientICP.getVersion());
	}

	public Boolean isAbdominalPainProtocol(TriageRefVo refTriage)
	{
		if (refTriage == null || refTriage.getID_Triage() == null)
			return false; 

		StringBuilder query = new StringBuilder();
		query.append("SELECT manTriage FROM Triage as t LEFT JOIN t.currentTriageAssessment as cta LEFT JOIN cta.triageProtocol as manTriage LEFT JOIN manTriage.taxonomyMap as tm LEFT JOIN tm.taxonomyName as tnm LEFT JOIN manTriage.activeStatus as activeS");
		query.append(" WHERE t.id =:trID AND activeS.id =:ACTIVE AND tnm.id =:taxNameID AND tm.taxonomyCode =:taxCode ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("trID");			paramValues.add(refTriage.getID_Triage());
		paramNames.add("ACTIVE");		paramValues.add(PreActiveActiveInactiveStatus.ACTIVE.getID());
		paramNames.add("taxNameID");	paramValues.add(TaxonomyType.MAXIMS_INTERNAL.getID());
		paramNames.add("taxCode");		paramValues.add("ABD_PAIN");
		
		List triageProtocol = getDomainFactory().find(query.toString(), paramNames, paramValues);
			
		if (triageProtocol != null && triageProtocol.size() > 0)
			return true;
		
		return false;
	}


	//WDEV-21082
	public VSMetrics getMetricsFromPatient(PatientRefVo patientRef) 
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getMetricsFromPatient(patientRef);
	}
}
