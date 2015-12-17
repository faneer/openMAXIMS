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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.domain.PatientSummary;
import ims.clinical.domain.impl.PatientSummaryImpl;
import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.domain.DomainFactory;
import ims.domain.lookups.LookupInstance;
import ims.emergency.domain.Triage;
import ims.emergency.domain.base.impl.BaseTrackingAndAttendanceWorklistsImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.TrackingAttendanceWorklist_SearchCriteriaVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.Tracking_TrackingAttendanceWorklistVo;
import ims.emergency.vo.Tracking_TrackingAttendanceWorklistVoCollection;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.emergency.vo.domain.Tracking_TrackingAttendanceWorklistVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.util.ArrayList;
import java.util.List;


public class TrackingAndAttendanceWorklistsImpl extends BaseTrackingAndAttendanceWorklistsImpl
{
	private static final long serialVersionUID = 1L;

	// Defined values for ED, discharge status
	private static final Integer STATUS_CURRENTLY_IN_ED		= 1;
	private static final Integer STATUS_DISCHARGED			= 2;
//	private static final Integer STATUS_CURRENT_DISCHARGE	= 3;
	
	// Defined values for allocated bed
	private static final Integer BED_AWAITING	= 1;
	private static final Integer BED_ALLOCATED	= 2;



	//---------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Domain Interface function
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public Tracking_TrackingAttendanceWorklistVoCollection listEmergencyAttendances(TrackingAttendanceWorklist_SearchCriteriaVo searchCriteria)
	{
		if (searchCriteria == null)
			return null;

		StringBuilder querySelectPart = new StringBuilder();
		StringBuilder queryFromJoinPart = new StringBuilder();
		StringBuilder queryConditionPart = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		PatIdType patIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); //WDEV-19652
		
		// SELECT part of the query
		//querySelectPart.append("SELECT tracking, (SELECT hospNr.value FROM Patient AS hospNrPat LEFT JOIN hospNrPat.identifiers AS hospNr LEFT JOIN hospNr.type AS type WHERE type.id = :HOSP_NUMBER AND hospNrPat.id = patient.id and (hospNr.merged is null  or hospNr.merged = 0) ) "); //WDEV-16816
		querySelectPart.append("SELECT tracking, (SELECT MAX(hospNr.value) FROM Patient AS hospNrPat LEFT JOIN hospNrPat.identifiers AS hospNr LEFT JOIN hospNr.type AS type WHERE type.id = :patIDType AND hospNrPat.id = patient.id ) "); //WDEV-16816  //WDEV-19652
		queryFromJoinPart.append("FROM Tracking AS tracking LEFT JOIN tracking.patient AS patient LEFT JOIN tracking.attendance AS attendance ");
		queryFromJoinPart.append("LEFT JOIN tracking.triageDetails AS triage ");
		queryFromJoinPart.append("LEFT JOIN tracking.episode AS episode ");
		//WDEV-16816
		queryFromJoinPart.append(" left join tracking.seenBy as seenByHcp ");
		
		// Parameters needed for Hospital Number 
		//WDEV-19652
		paramNames.add("patIDType");
		paramValues.add(patIdType.getID());
		
		queryConditionPart.append("WHERE attendance is not null AND (attendance.isRIE is null OR attendance.isRIE = 0) AND (tracking.isRIE is null OR tracking.isRIE = 0)");
		
		String logicalCondition = "AND ";
		
		
		// Medic search criteria
		if (searchCriteria.getMedic() != null)
		{
			//queryFromJoinPart.append("LEFT JOIN tracking.currentAllocatedMedic AS currentMedicAllocated LEFT JOIN currentMedicAllocated.allocatedMedic AS medic ");
			queryFromJoinPart.append(" left join seenByHcp.allocatedMedic  as medic ");
			queryConditionPart.append(logicalCondition).append(" medic.id = :MEDIC_ID ");
			logicalCondition = " AND ";

			paramNames.add("MEDIC_ID");		paramValues.add(searchCriteria.getMedic().getID_Hcp());
		}
		
		// Nurse search criteria
		if (searchCriteria.getNurse() != null)
		{
			//queryFromJoinPart.append("LEFT JOIN tracking.currentAllocatedNurse AS currentNurseAllocated LEFT JOIN currentNurseAllocated.allocatedNurse AS nurse ");
			queryFromJoinPart.append(" left join seenByHcp.allocatedNurse as nurse ");
			queryConditionPart.append(logicalCondition).append(" nurse.id = :NURSE_ID ");
			logicalCondition = " AND ";

			paramNames.add("NURSE_ID");		paramValues.add(searchCriteria.getNurse().getID_Hcp());
		}
		
		// Referral Speciality & Referral Consultant Team Speciality
		if (searchCriteria.getSpecialty() != null || searchCriteria.getTeamSpecialty() != null)
		{
			queryFromJoinPart.append("LEFT JOIN tracking.currentReferral AS currentReferral ");

			if (searchCriteria.getSpecialty() != null)
			{
				queryConditionPart.append(logicalCondition).append(" currentReferral.specialty.id = :REF_SPECIALTY ");
				logicalCondition = " AND ";

				paramNames.add("REF_SPECIALTY");	paramValues.add(searchCriteria.getSpecialty().getID());
			}

			if (searchCriteria.getTeamSpecialty() != null)
			{
				queryConditionPart.append(logicalCondition).append(" currentReferral.teamConsultant.id = :TEAM_SPECIALTY ");
				logicalCondition = " AND ";

				paramNames.add("TEAM_SPECIALTY");	paramValues.add(searchCriteria.getTeamSpecialty().getID());
			}
		}
		
		// Triage priority
		if (searchCriteria.getPriority() != null)
		{
			queryConditionPart.append(logicalCondition).append(" triage.currentTriagePriority.id = :PRIORITY ");
			logicalCondition = " AND ";

			paramNames.add("PRIORITY");		paramValues.add(searchCriteria.getPriority().getID());
		}
		
		// Breached KPI date
		if (Boolean.TRUE.equals(searchCriteria.getBreachedPriorityKPI()) && getCurrentLocation() != null)
		{
			queryFromJoinPart.append(", AttendanceKPIConfig AS attendanceKPI LEFT JOIN attendanceKPI.triagePriorityKPIs AS triageKPI ");
			queryConditionPart.append(logicalCondition);
			queryConditionPart.append(" triage is not null AND triage.currentTriagePriority is not null AND triage.currentTriagePriority.id = triageKPI.triagePriority.id AND attendanceKPI.eDLocation.id = :LOCATION AND ");
			queryConditionPart.append(" ( (triage.medicInterventionStartDateTime is not null AND DATEDIFF(MINUTE, triage.medicInterventionStartDateTime, triage.triageStartDateTime) > triageKPI.priorityBreachedKPI) OR ");
			queryConditionPart.append(" (triage.medicInterventionStartDateTime is null AND DATEDIFF(MINUTE, triage.triageStartDateTime, :CURRENT_DATE) > triageKPI.priorityBreachedKPI))");
			
			paramNames.add("LOCATION");
			paramValues.add(getCurrentLocation().getID());
			
			paramNames.add("CURRENT_DATE");
			paramValues.add(new DateTime().getJavaDate());
		}
		
		// Patient Surname
		if (searchCriteria.getPatientSurname() != null && searchCriteria.getPatientSurname().length() > 0)
		{
			//WDEV-19285
			String patientSurnameSearchCriteria = searchCriteria.getPatientSurname().replaceAll("[^a-zA-Z]", "");
			
			queryConditionPart.append(logicalCondition).append(" patient.name.upperSurname LIKE :PATIENT_NAME ");
			logicalCondition = " AND ";
			
			paramNames.add("PATIENT_NAME");		paramValues.add("%" + patientSurnameSearchCriteria.toUpperCase() + "%");
		}
		
		// Address
		if (searchCriteria.getAddressContains() != null && searchCriteria.getAddressContains().length() > 0)
		{
			queryConditionPart.append(logicalCondition).append(" (");
			queryConditionPart.append("UPPER(patient.address.line1) LIKE :ADDRESS OR ");
			queryConditionPart.append("UPPER(patient.address.line2) LIKE :ADDRESS OR ");
			queryConditionPart.append("UPPER(patient.address.line3) LIKE :ADDRESS OR ");
			queryConditionPart.append("UPPER(patient.address.line4) LIKE :ADDRESS OR ");
			queryConditionPart.append("UPPER(patient.address.line5) LIKE :ADDRESS");
			queryConditionPart.append(") ");
			
			logicalCondition = " AND ";
			
			paramNames.add("ADDRESS");			paramValues.add("%" + searchCriteria.getAddressContains().toUpperCase() + "%");
		}

		// Attendance Period
		if (searchCriteria.getAttendanceFrom() != null && searchCriteria.getAttendanceTo() != null)
		{
			queryConditionPart.append(logicalCondition).append(" attendance.registrationDateTime BETWEEN :ATTENDANCE_DATE_FROM AND :ATTENDANCE_DATE_TO ");
			
			logicalCondition = " AND ";
			
			paramNames.add("ATTENDANCE_DATE_FROM");		paramValues.add(searchCriteria.getAttendanceFrom().getDate());
			paramNames.add("ATTENDANCE_DATE_TO");		paramValues.add(new DateTime(searchCriteria.getAttendanceTo(), new Time(23, 59)).getJavaDate());
		}
		
		// Triage Period
		if (searchCriteria.getTriageFrom() != null && searchCriteria.getTriageTo() != null)
		{
			queryConditionPart.append(logicalCondition).append(" triage.triageStartDateTime BETWEEN :TRIAGE_DATE_FROM AND :TRIAGE_DATE_TO ");
			
			logicalCondition = " AND ";
			
			paramNames.add("TRIAGE_DATE_FROM");			paramValues.add(searchCriteria.getTriageFrom().getDate());
			paramNames.add("TRIAGE_DATE_TO");			paramValues.add(new DateTime(searchCriteria.getTriageTo(), new Time(23, 59)).getJavaDate());
		}
		
		// Discharge Period
		if (searchCriteria.getDischargeFrom() != null && searchCriteria.getDischargeTo() != null)
		{
			queryConditionPart.append(logicalCondition).append(" attendance.dischargeDateTime BETWEEN :DISCHARGE_DATE_FROM AND :DISCHARGE_DATE_TO ");
			
			logicalCondition = " AND ";
			
			paramNames.add("DISCHARGE_DATE_FROM");		paramValues.add(searchCriteria.getDischargeFrom().getDate());
			paramNames.add("DISCHARGE_DATE_TO");		paramValues.add(new DateTime(searchCriteria.getDischargeTo(), new Time(23, 59)).getJavaDate());
		}
		
		
		// ED Status type
		if (searchCriteria.getEDStatus() != null)
		{
			if (STATUS_CURRENTLY_IN_ED.equals(searchCriteria.getEDStatus()))
			{
				if( getCurrentLocation() != null )		//wdev-18310
				{
					queryConditionPart.append(logicalCondition).append(" (tracking.eDLocation.id = :CURRENT_LOCATION AND (tracking.isDischarged is null OR tracking.isDischarged = 0)) ");
					
					paramNames.add("CURRENT_LOCATION");		paramValues.add(getCurrentLocation().getID());
					
					logicalCondition = " AND ";
				}
			}
			else if (STATUS_DISCHARGED.equals(searchCriteria.getEDStatus()))
			{
				queryConditionPart.append(logicalCondition).append(" tracking.isDischarged = 1 ");
				
				logicalCondition = " AND ";
			}
		}
		
		
		// Awaiting Bed / Bed Allocated
		if (searchCriteria.getBedAllocation() != null)
		{
			if (BED_AWAITING.equals(searchCriteria.getBedAllocation()))
			{
				queryConditionPart.append(logicalCondition).append(" tracking.bedAvailability is not null ");
				queryConditionPart.append(" AND tracking.bedAvailability.awaitingDateTime is not null ");
				queryConditionPart.append(" AND tracking.bedAvailability.availableDateTime is null ");
				
				logicalCondition = " AND ";
			}
			else if (BED_ALLOCATED.equals(searchCriteria.getBedAllocation()))
			{
				queryConditionPart.append(logicalCondition).append(" tracking.bedAvailability is not null ");
				queryConditionPart.append(" AND tracking.bedAvailability.availableDateTime is not null ");
				
				logicalCondition = " AND ";
			}
		}
		
		
		// Outcome
		if (searchCriteria.getOutcome() != null)
		{
			queryConditionPart.append(logicalCondition).append(" attendance.outcome.id = :OUTCOME ");
			logicalCondition = " AND ";

			paramNames.add("OUTCOME");		paramValues.add(searchCriteria.getOutcome().getID());
		}
		
		
		// Source Of Referral
		if (searchCriteria.getSourceOfReferral() != null)
		{
			queryConditionPart.append(logicalCondition).append(" episode.sourceOfReferral.id = :SOURCE ");
			logicalCondition = " AND ";

			paramNames.add("SOURCE");		paramValues.add(searchCriteria.getSourceOfReferral().getID());
		}
		
		// Attendance ID
		if (searchCriteria.getAttendanceID() != null)
		{
			queryConditionPart.append(logicalCondition).append(" attendance.id = :ATTENDANCE ");
			logicalCondition = " AND ";

			paramNames.add("ATTENDANCE");		paramValues.add(searchCriteria.getAttendanceID().intValue());
		}
		
		// Presenting Complaint
		if (searchCriteria.getPresentingProblem() != null)
		{
			queryConditionPart.append(logicalCondition).append(" episode.presentingComplaint.id = :COMPLAINT ");
			logicalCondition = " AND ";

			paramNames.add("COMPLAINT");		paramValues.add(searchCriteria.getPresentingProblem().getID());
		}
		
		// Results Awaiting to be Seen
		if (Boolean.TRUE.equals(searchCriteria.getAwaitingReview())) //WDEV-15941
		{
			/*queryFromJoinPart.append(", OrderInvestigation AS ordInv LEFT JOIN ordInv.orderDetails AS ordDetails LEFT JOIN ordDetails.patient AS invPatient ");
			
			queryConditionPart.append(logicalCondition).append(" ordInv.ordInvCurrentStatus.ordInvStatus.id = :REVIEW and patient.id = invPatient.id AND ordInv.id is not null AND ((attendance.dischargeDateTime is not null AND ordInv.displayDateTime BETWEEN attendance.registrationDateTime AND attendance.dischargeDateTime) OR (attendance.dischargeDateTime is null AND ordInv.displayDateTime BETWEEN attendance.registrationDateTime AND :CURRENT_DATE_TIME ))");
			logicalCondition = " AND ";

			paramNames.add("CURRENT_DATE_TIME");		paramValues.add(new DateTime().getJavaDate());
			paramNames.add("REVIEW");					paramValues.add(OrderInvStatus.REVIEW.getID());*/
			
			queryFromJoinPart.append(" left join patient.oCSNotification as patNotification left join patNotification.newResults as newRes left join patNotification.seenResults as seenRes ");
			queryConditionPart.append(logicalCondition).append(" (newRes is not null and (seenRes is null or (seenRes is not null and newRes.newCount > seenRes.seenCount))) ");
		}
		
		if(Boolean.TRUE.equals(searchCriteria.getAttendanceNotCoded()))//WDEV-19304
		{
			/*queryConditionPart.append(logicalCondition).append("((attendance.careContext.id not in (select pDiag.careContext.id from PatientDiagnosis as pDiag where pDiag.careContext.id = attendance.careContext.id and (pDiag.isRIE is null or pDiag.isRIE = 0) AND attendance.careContext.id not in (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv where noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.diagnosesNotRecorded = true OR noKnownInv.noDiagnoses = true))))  "); //WDEV-19304
			queryConditionPart.append(" OR (attendance.careContext.id not in (select att.id from InvestigationsForAttend as ifa left join ifa.attendance as att left join ifa.investigations as invAttend where att.id = attendance.careContext.id and invAttend.active = 1) AND attendance.careContext.id not in (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv where noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.noInvestigations = true OR noKnownInv.investigationNotRecorded = true)) AND patient.id not in (select ordDetAttend.patient.id from OrderInvestigation as ordInvAttend left join ordInvAttend.orderDetails as ordDetAttend where ((attendance.dischargeDateTime is not null AND ordInvAttend.displayDateTime BETWEEN attendance.registrationDateTime AND attendance.dischargeDateTime) OR (attendance.dischargeDateTime is null AND ordInvAttend.displayDateTime BETWEEN attendance.registrationDateTime AND :ATTEND_CURRENT_DATE_TIME ))))" ); //WDEV-19304
			queryConditionPart.append(" OR (attendance.careContext.id not in (select interventionTreatAttend.attendance.id from InterventionsTreatmentsForAttendence as interventionTreatAttend left join interventionTreatAttend.interventionTreatments as interventionTreat where interventionTreatAttend.attendance.id = attendance.careContext.id and interventionTreat.id is not null) OR  attendance.careContext.id not in (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv where noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.noTreatments = true OR noKnownInv.treatmentsNotRecorded = true)))"); //WDEV-19304
			queryConditionPart.append(")");*/
			queryConditionPart.append(logicalCondition).append("((NOT EXISTS (select pDiag.careContext.id from PatientDiagnosis as pDiag where pDiag.careContext.id = attendance.careContext.id and (pDiag.isRIE is null or pDiag.isRIE = 0)) AND NOT EXISTS (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv WHERE noKnownInv is not null AND noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.diagnosesNotRecorded = true OR noKnownInv.noDiagnoses = true))  "); //WDEV-19304
			queryConditionPart.append(" OR (NOT EXISTS (select att.id from InvestigationsForAttend as ifa left join ifa.attendance as att left join ifa.investigations as invAttend where att.id = attendance.careContext.id and invAttend.active = 1) AND NOT EXISTS (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv WHERE noKnownInv is not null AND noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.noInvestigations = true OR noKnownInv.investigationNotRecorded = true))  AND NOT EXISTS (select ordDetAttend.patient.id from OrderInvestigation as ordInvAttend left join ordInvAttend.orderDetails as ordDetAttend where (ordDetAttend.patient.id = attendance.patient.id AND (attendance.dischargeDateTime is not null AND ordInvAttend.displayDateTime BETWEEN attendance.registrationDateTime AND attendance.dischargeDateTime) OR (attendance.dischargeDateTime is null AND ordInvAttend.displayDateTime BETWEEN attendance.registrationDateTime AND :ATTEND_CURRENT_DATE_TIME))))" ); //WDEV-19304
			queryConditionPart.append(" OR (NOT EXISTS (select interventionTreatAttend.attendance.id from InterventionsTreatmentsForAttendence as interventionTreatAttend left join interventionTreatAttend.interventionTreatments as interventionTreat where interventionTreatAttend.attendance.id = attendance.careContext.id and interventionTreat.id is not null)AND NOT EXISTS (SELECT noKnownInv.attendance.id from AttendDiagInvTreatStatus AS noKnownInv WHERE noKnownInv is not null AND noKnownInv.attendance.id = attendance.careContext.id AND (noKnownInv.isRIE is null or noKnownInv.isRIE = 0) AND (noKnownInv.noTreatments = true OR noKnownInv.treatmentsNotRecorded = true)))"); //WDEV-19304
			queryConditionPart.append(" )) ");
			
			logicalCondition = " AND ";

			paramNames.add("ATTEND_CURRENT_DATE_TIME");		paramValues.add(new DateTime().getJavaDate());
		}
		
		//WDEV-19282 Main Presenting Problem
		if (searchCriteria.getClinicalProblem() != null)
		{
			queryFromJoinPart.append(" left join triage.mainPresentingProblem as presProblem left join presProblem.problem as clinicalProblem ");
			queryConditionPart.append(logicalCondition).append(" clinicalProblem.id = :clinicalProblemID ");
			logicalCondition = " AND ";

			paramNames.add("clinicalProblemID");		paramValues.add(searchCriteria.getClinicalProblem().getID_ClinicalProblem());
		}
		
		//WDEV-19298
		if (Boolean.TRUE.equals(searchCriteria.getShowTemporaryRegistrations()))
		{
			queryConditionPart.append(logicalCondition).append(" patient.isQuickRegistrationPatient = 1 ");
			logicalCondition = " AND ";
		}
		
		//WDEV-20703
		if (Boolean.TRUE.equals(searchCriteria.getIncludeRequiresDischargeDocumentationReview()))
		{
			queryConditionPart.append(logicalCondition).append(" (tracking.requiringDischargeDocumentationReview = 1) ");
			logicalCondition = " AND ";
		}
		
		//WDEV-19652
		if (searchCriteria.getIDValueIsNotNull())
		{
			boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();
		
			queryFromJoinPart.append(" left join patient.identifiers as patId left join patId.type as type ");
			
			queryConditionPart.append(logicalCondition).append(" type.id = :patTypeId ");
			paramNames.add("patTypeId");
			paramValues.add(patIdType.getID());
			
			logicalCondition = " AND ";
			
			queryConditionPart.append(logicalCondition).append((!isCaseSensitivePatIdSearch ? " UPPER(patId.value)" : "patId.value" ) + " = :patId"); //WDEV-18817
			paramNames.add("patId");
			
			if (!isCaseSensitivePatIdSearch)
			{
				searchCriteria.setIDValue(searchCriteria.getIDValue().toUpperCase());
			}
			if (patIdType.equals(PatIdType.NHSN))
			{
				
				paramValues.add(searchCriteria.getIDValue().replace(" ", ""));
			}
			else
			{
				paramValues.add(searchCriteria.getIDValue().trim());
			}
			
			logicalCondition = " AND ";
		}
		
		// Query data base for records
		StringBuilder query = new StringBuilder();
		query.append(querySelectPart).append(queryFromJoinPart).append(queryConditionPart);
		
		query.append(" ORDER BY attendance.registrationDateTime ");
		
		List<?> list = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		
		// If no records were found return null collection
		if (list == null)
			return null;

		
		// Create result collection
		Tracking_TrackingAttendanceWorklistVoCollection resultsCollection = new Tracking_TrackingAttendanceWorklistVoCollection();
		// Build result collection
		for (int i = 0; i < list.size(); i++)
		{
			Object[] result = (Object[]) list.get(i);
			
			Tracking_TrackingAttendanceWorklistVo tracking = Tracking_TrackingAttendanceWorklistVoAssembler.create((Tracking) result[0]);
			
			if (tracking != null)
			{
				tracking.setHospitalNo((String) result[1]);
				tracking.calculateLOS();
			}
			
			resultsCollection.add(tracking);
		}

		return resultsCollection;
	}

	// 	WDEV-16012
	public CareContextShortVo getCareContext(CareContextRefVo careContextRef) 
	{
		if(careContextRef == null || careContextRef.getID_CareContext() == null)
			return null;
		
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContextRef.getID_CareContext()));
	}

	//WDEV-17151
	public TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistAndTriageVo(TrackingRefVo trackingRef)
	{
		if(trackingRef == null )
			throw new CodingRuntimeException("TrackingRefVo cannot be null");
	
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingRef.getID_Tracking()));
	}

	//WDEV-17332
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		PatientSummary ps = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return ps.getPIDDiagnosisInfo(careContextRefVo, episodeRefVo, null);
	}

	//WDEV-17332
	public PatientShort getPatient(PatientRefVo patientRef)
	{
		if(patientRef == null || patientRef.getID_Patient() == null)
			return null;
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient()));
	}

	//WDEV-17653
	public SpecialtyCollection listSpecialties()
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select lookInst from Lookup as look left join look.instances as lookInst left join lookInst.mappings as mappings where (look.id = 621 and mappings.extSystem = 'MAXIMS' and mappings.extCode like 'EDREFER%' and lookInst.active = 1)");

		List<?> list = factory.find(hql.toString());

		if (list!=null && list.size()>0)
		{
			SpecialtyCollection coll = new SpecialtyCollection();
			
			for (int i=0;i<list.size();i++)
			{
				LookupInstance doLookInst=(LookupInstance)list.get(i);
				ims.core.vo.lookups.Specialty voLookup = new ims.core.vo.lookups.Specialty(doLookInst.getId(),doLookInst.getText(),doLookInst.isActive(),null,doLookInst.getImage(),doLookInst.getColor());	
				coll.add(voLookup);
			}
			
			return coll;
		}
		
		return null;
	}

	public ClinicalProblemShortVoCollection listProblems(String problemName)
	{
		Triage triage = (Triage)getDomainImpl(TriageImpl.class);
		return triage.listClinicalProblems(problemName);
	}
}
