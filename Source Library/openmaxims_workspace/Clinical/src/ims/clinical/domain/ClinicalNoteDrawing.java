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

package ims.clinical.domain;

// Generated from form domain impl
public interface ClinicalNoteDrawing extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* getClinicalNotes
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotes(Integer nId);

	// Generated from form domain interface definition
	/**
	* saveClinicalNotes
	*/
	public ims.core.vo.ClinicalNotesVo saveClinicalNotes(ims.core.vo.ClinicalNotesVo voClinicalNotes, ims.core.vo.ClinicalContactShortVo voClinicalContactShort, ims.core.vo.ClinicalNotesAdditionalVo voClinicalNotesAdditional) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getClinicalContact
	*/
	public ims.core.vo.ClinicalContactVo getClinicalContact(Integer nId);

	// Generated from form domain interface definition
	/**
	* getClinicalNotesAdditional
	*/
	public ims.core.vo.ClinicalNotesAdditionalVo getClinicalNotesAdditional(Integer clinicalNotesId);

	// Generated from form domain interface definition
	/**
	* Save the SOAPVo
	*/
	public void saveSOAPsVo(ims.core.vo.SOAPVo voSOAP) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Get OPDEDVo
	*/
	public ims.core.vo.SOAPVo getSOAPsVo(ims.core.clinical.vo.ClinicalNotesRefVo clinnoteRefVo);

	// Generated from form domain interface definition
	/**
	* Get Clinical Notes for a Clinical contact ref id
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotesForContact(ims.core.admin.vo.ClinicalContactRefVo clincontactRefId);

	// Generated from form domain interface definition
	/**
	* Save clinical notes
	*/
	public ims.core.vo.ClinicalNotesVo saveClinicalNotesOnly(ims.core.vo.ClinicalNotesVo voClinicaNotes) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.MemberOfStaffVo getMemberOfStaff(ims.core.vo.MemberOfStaffShortVo mos);

	// Generated from form domain interface definition
	/**
	* Get a Clinical Note for a Care Context
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotesForCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listMedics(String hcpName);

	// Generated from form domain interface definition
	/**
	* Get a NotingDetail for the ClinicalContact
	*/
	public ims.clinical.vo.NotingDetailsVo getNotingDetails(ims.core.vo.ClinicalContactShortVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* Save a NotingDetails
	*/
	public ims.clinical.vo.NotingDetailsVo saveNotingDetails(ims.clinical.vo.NotingDetailsVo notingDetailVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Save Patient Assessment List
	*/
	public ims.assessment.vo.PatientAssessmentListVo savePatientAssessmentList(ims.assessment.vo.PatientAssessmentListVo voPatientAssessmentList) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list Patient User Defined Objects
	*/
	public ims.assessment.vo.PatientUserDefinedObjectListVoCollection listPatientUserDefinedObjects(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* savePatientUserDefinedObject
	*/
	public ims.assessment.vo.PatientUserDefinedObjectVo savePatientUserDefinedObject(ims.assessment.vo.PatientUserDefinedObjectVo voPatientUserDefinedObject) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getPatientUserDefinedObjectList
	*/
	public ims.assessment.vo.PatientUserDefinedObjectListVo getPatientUserDefinedObjectList(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo);

	// Generated from form domain interface definition
	/**
	* getPatientUserDefinedObject
	*/
	public ims.assessment.vo.PatientUserDefinedObjectVo getPatientUserDefinedObject(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo);

	// Generated from form domain interface definition
	/**
	* savePatientAssessment
	*/
	public ims.assessment.vo.PatientAssessmentVo savePatientAssessment(ims.assessment.vo.PatientAssessmentVo patientAssessment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getPatientAssessment
	*/
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessment(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* getActiveGraphicAssessment
	*/
	public ims.assessment.vo.GraphicAssessmentVo getActiveGraphicAssessment(ims.core.vo.lookups.UserDefinedAssessmentType type);

	// Generated from form domain interface definition
	/**
	* getOutpatientNotesForClinicalContact
	*/
	public ims.clinical.vo.OutpatientNotesOutcomeVo getOutpatientNotesForClinicalContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContact);

	// Generated from form domain interface definition
	/**
	* saveOutpatientNotesOutcome
	*/
	public ims.clinical.vo.OutpatientNotesOutcomeVo saveOutpatientNotesOutcome(ims.clinical.vo.OutpatientNotesOutcomeVo record) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Save a clinical Contact
	*/
	public ims.core.vo.ClinicalContactShortVo saveClinicalContact(ims.core.vo.ClinicalContactShortVo clinicalContactVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get OP note for a clinical note
	*/
	public ims.clinical.vo.OutpatientNotesOutcomeVo getOutpatientNotesOutcomeForClinicalNote(ims.core.clinical.vo.ClinicalNotesRefVo clinnoteRefVo);

	// Generated from form domain interface definition
	/**
	* getCareContextShort
	*/
	public ims.core.vo.CareContextListVo getCareContextShort(Integer id);

	// Generated from form domain interface definition
	/**
	*  getClinicalNotesShort
	*/
	public ims.core.vo.ClinicalNotesShortVo getClinicalNotesShort(Integer id);

	// Generated from form domain interface definition
	/**
	* getClinicalNoting
	*/
	public ims.clinical.vo.NotingDetailsVo getClinicalNoting(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.NotingDetailsVo getNotingDetailsForCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientUserDefinedObjectListVoCollection listPatientUserDefinedObjectsForCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentForCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.OutpatientNotesOutcomeVo getOutpatientNotesForCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalNotesVo saveClinicalNotesForCareContext(ims.core.vo.ClinicalNotesVo voClinicalNotes, ims.core.admin.vo.CareContextRefVo voCareContext, ims.core.vo.ClinicalNotesAdditionalVo voClinicalNotesAdditional) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalNotesVo saveClinicalNotesOnlyForCareContext(ims.core.vo.ClinicalNotesVo voClinicaNotes) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinical.vo.OutpatientNotesOutcomeVo saveOutpatientNotesOutcomePerCareContext(ims.clinical.vo.OutpatientNotesOutcomeVo record) throws ims.domain.exceptions.StaleObjectException;
}
