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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.domain.CodedDiagnosisForAttendanceDialog;
import ims.clinical.domain.PatientSummary;
import ims.clinical.domain.impl.CodedDiagnosisForAttendanceDialogImpl;
import ims.clinical.domain.impl.PatientSummaryImpl;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EmergencyAttendanceRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.CodedDiagForAttendance;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.vo.CodedDiagForAttendanceRefVo;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CSPrimaryDiagnosisShortVo;
import ims.core.vo.CodedDiagnosesForAttendanceVo;
import ims.core.vo.CodedDiagnosesForAttendanceVoCollection;
import ims.core.vo.PatientDiagnosisAtConsultationVo;
import ims.core.vo.PatientDiagnosisAtConsultationVoCollection;
import ims.core.vo.domain.CodedDiagnosesForAttendanceVoAssembler;
import ims.core.vo.domain.PatientDiagnosisAtConsultationVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.domain.InterventionsTreatments;
import ims.emergency.domain.base.impl.BaseInterventionsDiagnosisInvestigationsCcImpl;
import ims.emergency.domain.objects.AttendDiagInvTreatStatus;
import ims.emergency.domain.objects.EmergencyAttendanceInvestigationCoding;
import ims.emergency.domain.objects.InterventionTreatmentDetail;
import ims.emergency.domain.objects.InterventionsTreatmentsForAttendence;
import ims.emergency.domain.objects.InvestigationAttendenceDetail;
import ims.emergency.domain.objects.InvestigationsForAttend;
import ims.emergency.vo.AttendDiagInvTreatStatusVo;
import ims.emergency.vo.EmergencyAttendanceInvestigationCodingVo;
import ims.emergency.vo.InterventionTreatmentDetailVo;
import ims.emergency.vo.InterventionsTreatmentsForAttendenceVo;
import ims.emergency.vo.InvestigationAttendenceDetailVo;
import ims.emergency.vo.InvestigationAttendenceDetailVoCollection;
import ims.emergency.vo.InvestigationsForAttendVo;
import ims.emergency.vo.OrderInvestigationForAttendenceNotesCcVoCollection;
import ims.emergency.vo.domain.AttendDiagInvTreatStatusVoAssembler;
import ims.emergency.vo.domain.EmergencyAttendanceInvestigationCodingVoAssembler;
import ims.emergency.vo.domain.InterventionTreatmentDetailVoAssembler;
import ims.emergency.vo.domain.InterventionsTreatmentsForAttendenceVoAssembler;
import ims.emergency.vo.domain.InvestigationAttendenceDetailVoAssembler;
import ims.emergency.vo.domain.InvestigationsForAttendVoAssembler;
import ims.emergency.vo.domain.OrderInvestigationForAttendenceNotesCcVoAssembler;
import ims.emergency.vo.lookups.AttendanceClinicalNoteType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.vo.ValueObject;

import java.util.ArrayList;
import java.util.List;

public class InterventionsDiagnosisInvestigationsCcImpl extends BaseInterventionsDiagnosisInvestigationsCcImpl
{
	private static final long serialVersionUID = 1L;

	public InterventionsTreatmentsForAttendenceVo getInterventionsTreatmentsForAttendence(CareContextRefVo attendence) 
	{
		if(attendence == null || attendence.getID_CareContext() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select it from InterventionsTreatmentsForAttendence as it where it.attendance.id = :AttendenceId ";
		
		List<?> list = factory.find(query, new String[] {"AttendenceId"}, new Object[] {attendence.getID_CareContext()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return InterventionsTreatmentsForAttendenceVoAssembler.create((InterventionsTreatmentsForAttendence) list.get(0));
	}

	public InterventionsTreatmentsForAttendenceVo save(InterventionsTreatmentsForAttendenceVo record, AttendDiagInvTreatStatusVo attendDiagInvTreatStatus, Boolean addedDuringCoding) throws StaleObjectException 
	{
		InterventionsTreatments impl = (InterventionsTreatments) getDomainImpl(InterventionsTreatmentsImpl.class);
		InterventionsTreatmentsForAttendenceVo newRecord = impl.save(record, addedDuringCoding);
		
		if(attendDiagInvTreatStatus != null && !Boolean.TRUE.equals(addedDuringCoding))
		{
			DomainFactory factory = getDomainFactory();
			
			AttendDiagInvTreatStatus doAttendDiagInvTreat = AttendDiagInvTreatStatusVoAssembler.extractAttendDiagInvTreatStatus(factory, attendDiagInvTreatStatus);
			factory.save(doAttendDiagInvTreat);
		}
		
		return newRecord;
	}

	public PatientDiagnosisAtConsultationVoCollection listPatientDiagnosis(CareContextRefVo attendance) 
	{
		if(attendance == null || attendance.getID_CareContext() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select pd from PatientDiagnosis as pd left join pd.careContext as cc where cc.id = :AttendenceId order by UPPER(pd.diagnosisDescription) asc";
		
		List<?> list = factory.find(query, new String[] {"AttendenceId"}, new Object[] {attendance.getID_CareContext()});
		
		return PatientDiagnosisAtConsultationVoAssembler.createPatientDiagnosisAtConsultationVoCollectionFromPatientDiagnosis(list);
	}

	public PatientDiagnosisAtConsultationVoCollection saveDiagnosis(PatientDiagnosisAtConsultationVoCollection diagnosis, CareContextRefVo careContext)	throws StaleObjectException 
	{
		if(diagnosis == null)
			throw new CodingRuntimeException("Cannot save a null PatientDiagnosisAtConsultationVoCollection.");
		
		if(!diagnosis.isValidated())
			throw new CodingRuntimeException("PatientDiagnosisAtConsultationVoCollection is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosisAtConsultationVoCollection coll = new PatientDiagnosisAtConsultationVoCollection();
		
		//WDEV-19239
		boolean isPatientDiagPrimary=false; 
		CareContextRefVo careContextRef = null;
		for(PatientDiagnosisAtConsultationVo diagnose : diagnosis)
		{
			if(diagnose == null)
				continue;
			
			careContextRef=diagnose.getCareContext();
			if (isPrimary(diagnose))
				isPatientDiagPrimary=true;
			
			PatientDiagnosis doDiagnose = PatientDiagnosisAtConsultationVoAssembler.extractPatientDiagnosis(factory, diagnose);
			
			factory.save(doDiagnose);
			coll.add(PatientDiagnosisAtConsultationVoAssembler.create(doDiagnose));
		}
		
		CodedDiagnosesForAttendanceVoCollection collCodedDiag = listCodedDiagnosesForAttendance(careContextRef, true);
		
		if (isPatientDiagPrimary && collCodedDiag!=null && collCodedDiag.size()>0)
		{
			for (CodedDiagnosesForAttendanceVo codedDiag : collCodedDiag)
			{
				codedDiag.setIsMain(false);
				
				CodedDiagForAttendance doCodedDiag = CodedDiagnosesForAttendanceVoAssembler.extractCodedDiagForAttendance(factory, codedDiag);
				factory.save(doCodedDiag);
			}
		}
		
		if(careContext != null)
		{
			AttendDiagInvTreatStatusVo attendDiagInvTreatStatus = getAttendDiagInvTreatStatus(careContext);
			
			if(attendDiagInvTreatStatus != null)
			{
				attendDiagInvTreatStatus.setNoDiagnoses(null);
				attendDiagInvTreatStatus.setDiagnosesNotRecorded(null);
			
				AttendDiagInvTreatStatus doAttendDiagInvTreatStatus = AttendDiagInvTreatStatusVoAssembler.extractAttendDiagInvTreatStatus(factory, attendDiagInvTreatStatus);
				factory.save(doAttendDiagInvTreatStatus);
			}
		}
		
		return coll;
	}

	//WDEV-19239
	private boolean isPrimary(PatientDiagnosisAtConsultationVo diagnose) 
	{
		if(diagnose == null || diagnose.getPrimaryForCareSpells() == null || diagnose.getPrimaryForCareSpells().size() == 0)
			return false;
		
		for(CSPrimaryDiagnosisShortVo primary : diagnose.getPrimaryForCareSpells())
		{
			if(primary == null || primary.getCareContext() == null)
				continue;
			
			if(primary.getCareContext().equals(diagnose.getCareContext()) && Boolean.TRUE.equals(primary.getIsActive()))
				return true;
		}
		
		return false;
	}
	
	public OrderInvestigationForAttendenceNotesCcVoCollection listOrderInvestigations(PatientRefVo patient, CareContextRefVo careContext, String investigationsAlreadyAdded) 
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Patient parameter can not be null when listing OrderInvestigations.");
		
		DomainFactory factory = getDomainFactory();
		java.util.Date fromDate = null;
		java.util.Date dateTo = null;
		
		if(careContext != null && careContext.getID_CareContext() != null)
		{
			CareContext doCareContext = (CareContext) factory.getDomainObject(CareContext.class, careContext.getID_CareContext());
			if(doCareContext != null)
			{
				if(doCareContext.getStartDateTime() != null)
				{
					fromDate = doCareContext.getStartDateTime();
				}
				
				if(doCareContext.getEndDateTime() != null)
				{
					return null;
				}
				
				dateTo = new java.util.Date();
			}		
		}
		
		StringBuilder query = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		
		query.append("SELECT orderInv FROM OrderInvestigation AS orderInv ");
		query.append(" LEFT JOIN FETCH orderInv.orderDetails AS details LEFT JOIN details.patient AS patient left join orderInv.investigation as inv left join inv.investigationIndex as invIndex left join orderInv.ordInvCurrentStatus.ordInvStatus as ordStatus ");
		
		query.append("WHERE patient.id = :PATIENT_ID and ordStatus.id <> :cancelledStatusId and ordStatus.id <> :cancelRequestStatusId");
		paramNames.add("PATIENT_ID");
		paramValues.add(patient.getID_Patient());
		
		//WDEV-17303
		paramNames.add("cancelledStatusId");
		paramValues.add(OrderInvStatus.CANCELLED.getID());
		paramNames.add("cancelRequestStatusId");
		paramValues.add(OrderInvStatus.CANCEL_REQUEST.getID());
		
		if (fromDate != null && dateTo != null)
		{
			query.append(" AND orderInv.systemInformation.creationDateTime BETWEEN :FROM_DATE AND :END_DATE ");
			
			paramNames.add("FROM_DATE");	paramValues.add(fromDate);
			paramNames.add("END_DATE");		paramValues.add(dateTo);
		}
		
		if(investigationsAlreadyAdded != null && investigationsAlreadyAdded.length() > 0)
		{
			query.append(" AND orderInv.id not in (");
			query.append(investigationsAlreadyAdded);
			query.append(") ");
		}
		
		query.append(" order by UPPER(invIndex.name) asc");
		
		return OrderInvestigationForAttendenceNotesCcVoAssembler.createOrderInvestigationForAttendenceNotesCcVoCollectionFromOrderInvestigation(factory.find(query.toString(), paramNames, paramValues));
	}

	public InvestigationAttendenceDetailVoCollection listInvestigationAttendence(CareContextRefVo careContext) 
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select ia from InvestigationAttendenceDetail as ia left join ia.attendance as at left join ia.attendenceInvestigation as ai where at.id = :AttendenceId and ia.active = 1 order by UPPER(ai.text) asc";
		
		List<?> list = factory.find(query, new String[] {"AttendenceId"}, new Object[] {careContext.getID_CareContext()});
		
		return InvestigationAttendenceDetailVoAssembler.createInvestigationAttendenceDetailVoCollectionFromInvestigationAttendenceDetail(list);
	}

	public Boolean isStaleOnDiagnosis(ValueObject diagnosis)  //WDEV-19239
	{
		if(diagnosis == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> appts=null;
		
		if(diagnosis instanceof PatientDiagnosisAtConsultationVo)
		{
			PatientDiagnosisAtConsultationVo patDiag = (PatientDiagnosisAtConsultationVo) diagnosis;
			appts = factory.find("select a.id from PatientDiagnosis as a where a.id = :DiagnosisId and a.version > :DiagnosisVersion", new String[] {"DiagnosisId", "DiagnosisVersion"}, new Object[] {patDiag.getID_PatientDiagnosis(), patDiag.getVersion_PatientDiagnosis()});
		}
		else if(diagnosis instanceof CodedDiagnosesForAttendanceVo)
		{
			CodedDiagnosesForAttendanceVo codedDiag = (CodedDiagnosesForAttendanceVo) diagnosis;
			appts = factory.find("select a.id from CodedDiagForAttendance as a where a.id = :DiagnosisId and a.version > :DiagnosisVersion", new String[] {"DiagnosisId", "DiagnosisVersion"}, new Object[] {codedDiag.getID_CodedDiagForAttendance(), codedDiag.getVersion_CodedDiagForAttendance()});
		}
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}

	public PatientDiagnosisAtConsultationVo getPatientDiagnosis(PatientDiagnosisRefVo patDiagnosis) 
	{
		if(patDiagnosis == null || patDiagnosis.getID_PatientDiagnosis() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatDiagnosis = (PatientDiagnosis) factory.getDomainObject(PatientDiagnosis.class, patDiagnosis.getID_PatientDiagnosis());
		
		return PatientDiagnosisAtConsultationVoAssembler.create(doPatDiagnosis);
	}

	//WDEV-17320
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		PatientSummary ps = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return ps.getPIDDiagnosisInfo(careContextRefVo, episodeRefVo, null);
	}

	public EmergencyAttendanceInvestigationCodingVo getInvestigationSequence(EmergencyAttendanceRefVo emergencyAttendance) 
	{
		return null;
	}

	public EmergencyAttendanceInvestigationCodingVo saveInvestigationSequence(EmergencyAttendanceInvestigationCodingVo investigationSequence) throws StaleObjectException 
	{
		if(investigationSequence == null)
			throw new CodingRuntimeException("Cannot save a null EmergencyAttendanceInvestigationCodingVo.");
		
		if(!investigationSequence.isValidated())
			throw new CodingRuntimeException("EmergencyAttendanceInvestigationCodingVo is not validated.");
		
		DomainFactory factory = getDomainFactory();

		EmergencyAttendanceInvestigationCoding doInv = EmergencyAttendanceInvestigationCodingVoAssembler.extractEmergencyAttendanceInvestigationCoding(factory, investigationSequence);
		factory.save(doInv);
		return EmergencyAttendanceInvestigationCodingVoAssembler.create(doInv);
	}

	public EmergencyAttendanceInvestigationCodingVo getInvestigationSequence(CareContextRefVo emergencyAttendance) 
	{
		if(emergencyAttendance == null || emergencyAttendance.getID_CareContext() == null)
			return null;

		DomainFactory factory = getDomainFactory();
		String query = "select eaic from EmergencyAttendanceInvestigationCoding as eaic left join eaic.careContext as cc where cc.id = :ccID";
		
		List<?> list = factory.find(query, new String[] {"ccID"}, new Object[] {emergencyAttendance.getID_CareContext()});
		if(list != null && list.size() > 0)
			return EmergencyAttendanceInvestigationCodingVoAssembler.create((EmergencyAttendanceInvestigationCoding)list.get(0));

		return null;
	}

	//WDEV-19058
	public InterventionTreatmentDetailVo saveInterventionTreatmentDetailVo(InterventionTreatmentDetailVo interventionTreatToSave) throws StaleObjectException
	{
		if(interventionTreatToSave == null)
			throw new CodingRuntimeException("Cannot save a null InterventionTreatmentDetailVo.");
		
		DomainFactory factory = getDomainFactory();

		InterventionTreatmentDetail doIntervTreat = InterventionTreatmentDetailVoAssembler.extractInterventionTreatmentDetail(factory, interventionTreatToSave);
		factory.save(doIntervTreat);
		return InterventionTreatmentDetailVoAssembler.create(doIntervTreat);
	}

	public AttendDiagInvTreatStatusVo getAttendDiagInvTreatStatus(CareContextRefVo careContextRef)
	{
		if(careContextRef == null || careContextRef.getID_CareContext() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String queryNoKnownInvestigationSaved = "SELECT attendDiagInvTreatStatus  from AttendDiagInvTreatStatus as attendDiagInvTreatStatus left join attendDiagInvTreatStatus.attendance as at where (at.id = :AttendenceId and (attendDiagInvTreatStatus.isRIE is null OR attendDiagInvTreatStatus.isRIE = 0) ) ";
		AttendDiagInvTreatStatus doAttendDiagInvTreatStatus = (AttendDiagInvTreatStatus) factory.findFirst(queryNoKnownInvestigationSaved, new String[] {"AttendenceId"}, new Object[] {careContextRef.getID_CareContext()});
		
		return AttendDiagInvTreatStatusVoAssembler.create(doAttendDiagInvTreatStatus);
	}

	public AttendDiagInvTreatStatusVo saveAttendDiagInvTreatStatus(AttendDiagInvTreatStatusVo attendDiagInvTreatStatus) throws StaleObjectException, UniqueKeyViolationException
	{
		if(attendDiagInvTreatStatus == null)
			throw new CodingRuntimeException("Cannot save a null AttendDiagInvTreatStatusVo.");
		
		if(!attendDiagInvTreatStatus.isValidated())
			throw new CodingRuntimeException("AttendDiagInvTreatStatusVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		AttendDiagInvTreatStatus doAttendDiagInvTreatStatus = AttendDiagInvTreatStatusVoAssembler.extractAttendDiagInvTreatStatus(factory, attendDiagInvTreatStatus);
		
		factory.save(doAttendDiagInvTreatStatus);
		
		return AttendDiagInvTreatStatusVoAssembler.create(doAttendDiagInvTreatStatus);
	}

	public InvestigationsForAttendVo getInvestigationsForAttend(CareContextRefVo careContext)
	{
		DomainFactory factory = getDomainFactory();
		String query = "select ifa from InvestigationsForAttend as ifa left join ifa.attendance as cc where cc.id = :AttendenceId ";
		
		List<?> list = factory.find(query, new String[] {"AttendenceId"}, new Object[] {careContext.getID_CareContext()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return InvestigationsForAttendVoAssembler.create((InvestigationsForAttend) list.get(0));
	}

	public InvestigationsForAttendVo save(InvestigationsForAttendVo record) throws StaleObjectException
	{
		if(record == null)
			throw new CodingRuntimeException("Cannot save a null InvestigationsForAttendVo");
		
		if(!record.isValidated())
			throw new CodingRuntimeException("InvestigationsForAttendVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		InvestigationsForAttend doInvestigationsForAttend = InvestigationsForAttendVoAssembler.extractInvestigationsForAttend(factory, record);
		factory.save(doInvestigationsForAttend);
		
		return InvestigationsForAttendVoAssembler.create(doInvestigationsForAttend);
	}

	public InvestigationAttendenceDetailVo inactivateInvestigationAttendenceDetail(InvestigationAttendenceDetailVo record, AttendDiagInvTreatStatusVo attendDiagInvTreatStatus) throws StaleObjectException
	{
		if(record == null)
			throw new CodingRuntimeException("Cannot save a null InvestigationAttendenceDetailVo.");
		
		if(!record.isValidated())
			throw new CodingRuntimeException("InvestigationAttendenceDetailVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		InvestigationAttendenceDetail doRecord = InvestigationAttendenceDetailVoAssembler.extractInvestigationAttendenceDetail(factory, record);
		factory.save(doRecord);
		
		if(attendDiagInvTreatStatus != null)
		{
			AttendDiagInvTreatStatus doAttendDiagInvTreat = AttendDiagInvTreatStatusVoAssembler.extractAttendDiagInvTreatStatus(factory, attendDiagInvTreatStatus);
			factory.save(doAttendDiagInvTreat);
		}
		
		return record;
	}
	
	//WDEV-19918 - MAXIMS 10.1.2
	public Boolean existAttendanceNotes(PatientRefVo patientRef, CareContextRefVo careContextRef, AttendanceClinicalNoteType noteType)
	{
		if(patientRef == null)
			throw new CodingRuntimeException("Cannot list AttendanceClinicalNotes for a null Patient Id.");
		
		String hql = "select count(attClinicalNotes.id) from AttendanceClinicalNotes as attClinicalNotes ";
		StringBuffer hqlConditions = new StringBuffer();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String andStr = "";
		
		if (patientRef !=null)
		{	
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.patient.id = :PatientId ");
			markers.add("PatientId");
			values.add(patientRef.getID_Patient());
			andStr = " and ";
		}
		
		if(careContextRef != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" attClinicalNotes.attendance.id = :CareContextId ");
			markers.add("CareContextId");
			values.add(careContextRef.getID_CareContext());
			andStr = " and ";
		}

		if (noteType!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.noteType.id = :noteTypeId ");
			markers.add("noteTypeId");
			values.add(noteType.getID());
			andStr = " and ";
		}
		
		if (hqlConditions.length() > 0)
		{
			hqlConditions.insert(0, " where (");
			hqlConditions.append(" ) ");
		}

		hqlConditions.append(andStr + " (attClinicalNotes.isRIE is null OR attClinicalNotes.isRIE = 0) ");
		
		hql=hql + hqlConditions.toString();
		
		DomainFactory factory = getDomainFactory();
		
		List<?> list = factory.find(hql, markers, values);
	
		if (list != null && list.size() > 0 && ((Long) list.get(0)).intValue() > 0)
			return true;
				
		return false;
	}

	//WDEV-19239
	public CodedDiagnosesForAttendanceVoCollection listCodedDiagnosesForAttendance(CareContextRefVo attendance, Boolean isMain)
	{
		CodedDiagnosisForAttendanceDialog impl=(CodedDiagnosisForAttendanceDialog)getDomainImpl(CodedDiagnosisForAttendanceDialogImpl.class);
		return impl.listCodedDiagnosis(attendance, isMain);
	}

	//WDEV-19239
	public CodedDiagnosesForAttendanceVoCollection saveCodedDiagnosis(CodedDiagnosesForAttendanceVoCollection codedDiagList) throws StaleObjectException
	{
		if(codedDiagList == null)
			throw new CodingRuntimeException("Cannot save a null CodedDiagnosesForAttendanceVoCollection.");
		
		if(!codedDiagList.isValidated())
			throw new CodingRuntimeException("CodedDiagnosesForAttendanceVoCollection is not validated.");
		
		DomainFactory factory = getDomainFactory();
		CodedDiagnosesForAttendanceVoCollection coll = new CodedDiagnosesForAttendanceVoCollection();
		
		for(CodedDiagnosesForAttendanceVo diagnose : codedDiagList)
		{
			if(diagnose == null)
				continue;
			
			CodedDiagForAttendance doCodedDiag = CodedDiagnosesForAttendanceVoAssembler.extractCodedDiagForAttendance(factory, diagnose);
			
			factory.save(doCodedDiag);
			coll.add(CodedDiagnosesForAttendanceVoAssembler.create(doCodedDiag));
		}
		
		return coll;
	}

	//WDEV-19239
	public CodedDiagnosesForAttendanceVo getCodedDiagForAttendance(CodedDiagForAttendanceRefVo codedDiagRef)
	{
		if(codedDiagRef == null || codedDiagRef.getID_CodedDiagForAttendance() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		CodedDiagForAttendance doCodedDiag = (CodedDiagForAttendance) factory.getDomainObject(CodedDiagForAttendance.class, codedDiagRef.getID_CodedDiagForAttendance());
		
		return CodedDiagnosesForAttendanceVoAssembler.create(doCodedDiag);
	}

	//WDEV-19239
	public PatientDiagnosisAtConsultationVoCollection saveDiagnosisSequence(PatientDiagnosisAtConsultationVoCollection patDiagnosis, CodedDiagnosesForAttendanceVoCollection codedDiagnosis, CareContextRefVo careContextRef) throws StaleObjectException
	{
		if (codedDiagnosis!=null && codedDiagnosis.size()>0)
		{
			saveCodedDiagnosis(codedDiagnosis);
		}
		
		PatientDiagnosisAtConsultationVoCollection collpatDiag = null; 
		
		if (patDiagnosis!=null && patDiagnosis.size()>0)
		{
			collpatDiag= saveDiagnosis(patDiagnosis, careContextRef);
		}
	
		return collpatDiag;
	}
}
