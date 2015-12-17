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

package ims.RefMan.domain;

// Generated from form domain impl
public interface OnExaminationComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHCP(String name) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* saveBaselineObs
	*/
	public ims.RefMan.vo.onExaminationVo saveOnExamination(ims.RefMan.vo.onExaminationVo voOnExamination) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get OnExamination
	*/
	public ims.RefMan.vo.onExaminationVo getOnExamination(ims.RefMan.vo.CatsReferralRefVo voCATSReferralRef);

	// Generated from form domain interface definition
	/**
	* getSystemReportAndTemplate
	*/
	public String[] getSystemReportAndTemplate(Integer imsId);

	// Generated from form domain interface definition
	/**
	* getConsultationClinicalNotes
	*/
	public ims.RefMan.vo.ConsultationClinicalNotesLiteVoCollection getConsultationClinicalNotes(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getDiagnosisManagement
	*/
	public ims.RefMan.vo.DiagnosisManagementLiteVoCollection getDiagnosisManagement(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getPrescription
	*/
	public ims.RefMan.vo.PrescriptionsLiteVoCollection getPrescription(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getReferralOutcome
	*/
	public ims.RefMan.vo.ReferralOutcomeLiteVoCollection getReferralOutcome(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getFollowUpNotes
	*/
	public ims.RefMan.vo.FollowUpNoteLiteVoCollection getFollowUpNotes(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getTLTSummaryNotes
	*/
	public ims.RefMan.vo.TltSummaryNoteLiteVoCollection getTLTSummaryNotes(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* listPatientDocuments
	*/
	public ims.core.vo.PatientDocumentLiteVoCollection listPatientDocuments(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.CareContextRefVo careContext, ims.core.vo.lookups.DocumentCategory documentCategory, ims.RefMan.vo.CatsReferralRefVo refVo, ims.core.vo.enums.UploadDocumentStoreLevel level);

	// Generated from form domain interface definition
	/**
	* getReferralDischarge
	*/
	public ims.RefMan.vo.ReferralDischargeVoCollection getReferralDischarge(ims.RefMan.vo.ReferralOutcomeRefVo refVo);

	// Generated from form domain interface definition
	/**
	* getReferralOutcomeFullVo
	*/
	public ims.RefMan.vo.ReferralOutcomeVo getReferralOutcomeFullVo(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* saveReferralOutcome
	*/
	public ims.RefMan.vo.ReferralOutcomeVo saveReferralOutcome(ims.RefMan.vo.ReferralOutcomeVo voReferralOutcome) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.OrgLiteVoCollection listAllSuppliers();

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo saveCatsReferral(ims.RefMan.vo.CatsReferralWizardVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* isThereFurtherManagementOfTypeTLT
	*/
	public Boolean isThereFurtherManagementOfTypeTLT(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReportNoteVoCollection getCatsReportNote(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CorrespondenceNoteLiteVoCollection getReportNote(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	public ims.RefMan.vo.FurtherManagementDetailsVoCollection getFurtherManagement(ims.RefMan.vo.ReferralOutcomeRefVo refVo);

	// Generated from form domain interface definition
	public ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection listInvestigations(ims.RefMan.vo.CatsReferralRefVo referral);
}
