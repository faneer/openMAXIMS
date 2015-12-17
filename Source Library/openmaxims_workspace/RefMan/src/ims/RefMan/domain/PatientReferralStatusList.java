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
public interface PatientReferralStatusList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Get PatientShort
	*/
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo voPatientRef);

	// Generated from form domain interface definition
	/**
	* Get Care Context Short
	*/
	public ims.core.vo.CareContextShortVo getCareContextShort(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* Get
	*/
	public ims.RefMan.vo.ConsultationDetailsVo getConsultation(ims.RefMan.vo.CatsReferralRefVo voCATSRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralListVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voReferralRef);

	// Generated from form domain interface definition
	public Boolean isPatientAlreadyAdmitted(ims.core.patient.vo.PatientRefVo voPatientRef);

	// Generated from form domain interface definition
	public Boolean hadPreviousAdmissionForThisReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public void undoProviderCancellation(ims.RefMan.vo.CatsReferralListVo referral, ims.core.vo.ReferralNoteVo referralNote) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public void undoReferralRejection(ims.RefMan.vo.CatsReferralListVo catsRef) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public String getPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListRefVo getActivePatientElectiveListsForCurrentCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsRef);

	// Generated from form domain interface definition
	/**
	* list CATS referrals
	*/
	public ims.RefMan.vo.CatsReferralListManualAssemblyVoCollection listCATSReferrals(ims.RefMan.vo.CATSReferralFilterVo voCATSFilter, Boolean bIncludeICPColumn, Boolean bIncludeELEColumn);

	// Generated from form domain interface definition
	public Boolean isALinkedReferral(Integer catsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForLinkRefVo getReferralLinkedToThis(Integer referralId);

	// Generated from form domain interface definition
	public void undoEndOfCare(ims.RefMan.vo.CatsReferralListVo catsRef) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public Boolean hasCatsReferralTransferOfCareChild(Integer refId);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForLinkRefVo getParentReferralLinkedToThis(Integer refId);

	// Generated from form domain interface definition
	public Boolean hasStatusToRevert(ims.RefMan.vo.CatsReferralRefVo ref);
}
