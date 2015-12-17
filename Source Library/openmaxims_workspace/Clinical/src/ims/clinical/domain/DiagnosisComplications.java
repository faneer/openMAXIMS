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
public interface DiagnosisComplications extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Get OPDEDVo
	*/
	public ims.core.vo.PatientDiagnosisVo getDiagnosisVo(ims.core.clinical.vo.PatientDiagnosisRefVo patdiagrefVo);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of Diagnosis / COmplication records for Clinical contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsContact(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* List all Diagnosis Complications for a Patient
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsPatient(ims.core.patient.vo.PatientRefVo patrefVo);

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	/**
	* list medics
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* List all Patient Complications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listPatientComplications(ims.core.patient.vo.PatientRefVo patrefvo);

	// Generated from form domain interface definition
	/**
	* List all Patient Diagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listPatientDiagnoses(ims.core.patient.vo.PatientRefVo patrefvo);

	// Generated from form domain interface definition
	/**
	* List all Complications for a Contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listContactComplications(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* List Diagnoses for a contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listContactDiagnoses(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* Diagnosis / Complications for a Care Context
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listCareContextComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareContextComplications(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listCareContextDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareContextDiagnoses(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationEpisodeOfCare
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listEpisodeOfCareComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listEpisodeOfCareComplications(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listEpisodeOfCareDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listEpisodeOfCareDiagnoses(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationCareSpell
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listCareSpellDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareSpellDiagnoses(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listCareSpellComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareSpellComplications(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listHotListDiagnosis
	*/
	public ims.core.vo.DiagLiteVoCollection listHotListDiagnosis(String name, ims.core.vo.lookups.Specialty specialty) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationEpisodeOfCarePlusUnresolved
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationEpisodeOfCarePlusUnresolved(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo, ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection saveClinicalDiAssociation(ims.clinical.vo.ClinicalDIAssociationVoCollection list) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getDiagnosisShortVo
	*/
	public ims.core.vo.PatientDiagnosisShortVo getDiagnosisShortVo(ims.core.clinical.vo.PatientDiagnosisRefVo patientDiagnosisRefVo);

	// Generated from form domain interface definition
	/**
	* saveDiagnosisVo
	*/
	public ims.core.vo.PatientDiagnosisVo saveDiagnosisVo(ims.core.vo.PatientDiagnosisVo voDiagnosis, ims.core.vo.PatientShort patientShortVo, Boolean savePMH, ims.core.vo.PatientNoDiagInfoForCCVo patientNoDiagInfo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationEpisodeOfCarePlusUnresolved
	*/
	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosisComplicationEpisodeOfCareAndUnresolved(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo, ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* Check if there are CDI Assocaitions
	*/
	public Boolean checkIfClinicalCDIAssociationsExist(ims.core.clinical.vo.PatientDiagnosisRefVo voPatientDiagnosis);

	// Generated from form domain interface definition
	/**
	* list Diagnosis and Complications and Excude Resolved for the Patient
	*/
	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosisComplicationsExcludeResolvedByPatient(ims.core.patient.vo.PatientRefVo voPatRef);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationsByPatient
	*/
	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosisComplicationsByPatient(ims.core.patient.vo.PatientRefVo voPatRef);

	// Generated from form domain interface definition
	/**
	*  listDiagnosisComplicationEpisodeOfCareForCancerDiagnosis
	*/
	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosisComplicationEpisodeOfCareForCancerDiagnosis(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	public ims.admin.vo.AppUserShortVo getAppUser(ims.admin.vo.AppUserVo user);

	// Generated from form domain interface definition
	public String getPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.PatientNoDiagInfoForCCVo getPatientNoDiagInfoForCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public void savePatientNoDiagInfo(ims.core.vo.PatientNoDiagInfoForCCVo patientNoDiagInfoToSave) throws ims.domain.exceptions.StaleObjectException;
}
