//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseMyOrderImpl extends DomainImpl implements ims.ocrr.domain.MyOrder, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetQuestions(ims.ocrr.vo.MyOrderComponentVo component)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcp(String text)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMos(String text)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOcsOrder(ims.ocrr.vo.OcsOrderVo ocsOrder, ims.ocrr.vo.SpecimenWorkListItemVoCollection workListItems, ims.ocrr.vo.enums.ORDERSTATE orderState, ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(catsReferral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsReferral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetInvestigationUnderSpecimen(Integer idInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSpecimenCollectionDetails(ims.ocrr.vo.lookups.SpecimenCollectionMethod type, ims.framework.utils.Date date)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicalNotesByCareContextAndNoteType(ims.core.admin.vo.CareContextRefVo careContext, ims.core.vo.lookups.ClinicalNoteType noteType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocationsByName(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdultOrPaediatricContainerforProfileInvestigation(ims.ocrr.configuration.vo.InvestigationIndexRefVo invIndex, Boolean isUsePaediatricContainer)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPathInvDetailsForInvestigation(Integer idInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWardsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo location, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo location, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutpatDeptsForHospitalByName(ims.core.resource.place.vo.LocationRefVo hospital, String nameFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInpatientEpisode(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOutPatientAttendance(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistGPsBySurname(String surname)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClosedRounds(ims.framework.utils.Date date, ims.ocrr.vo.lookups.SpecimenCollectionTime round, ims.core.resource.place.vo.LocationRefVo ward)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByName(String hcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWardsForHospitalByNameShort(ims.core.resource.place.vo.LocationRefVo hospital, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutpatDeptsForHospitalByNameShort(ims.core.resource.place.vo.LocationRefVo hospital, String nameFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveServiceQuestions(Integer serviceId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveCategoryQuestions(ims.ocrr.vo.lookups.Category category)
	{
	}

	@SuppressWarnings("unused")
	public void validategetParentHospital(ims.vo.ValueObject wardOrClinic)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOcsOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo ocsOrder)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveMosByName(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProfileLevelPhlebMayCollect(Integer parentInvestigationId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocationForService(ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAandEForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo hosp, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistUserEnteredLocationsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo hosp, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferrerGP(ims.RefMan.vo.CatsReferralRefVo catsRef)
	{
		if(catsRef == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsRef' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetInitiallySeenByHcpFromConsultationClinicalNotesByReferral(ims.RefMan.vo.CatsReferralRefVo referral)
	{
		if(referral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'referral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistActiveOutpatientDepartment(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOutpatientDepartmentByClinic(ims.core.resource.place.vo.ClinicRefVo clinic)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInvestigationHelpText(Integer investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistResponsibleMedicsByName(String hcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferralListVo(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInpatientEpisodeForPatient(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDefaultEmergencyDepartment(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasArrived(ims.RefMan.vo.CatsReferralRefVo referral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLeadConsultantForReferral(ims.RefMan.vo.CatsReferralRefVo referral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHCPbyMoS(ims.core.resource.people.vo.MemberOfStaffRefVo memberOfStaff)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInvestigationQuestionsAnswers(ims.ocrr.configuration.vo.InvestigationRefVo investigation, ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderDetails)
	{
	}

	@SuppressWarnings("unused")
	public void validategetServiceQuestionsAnswers(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderDetails, ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCategoryQuestionsAnswers(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderDetails, ims.ocrr.vo.lookups.Category category)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigationAppointment(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigationBooking(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateOrderInvestigationAppointment(ims.RefMan.vo.OrderInvWithStatusApptVo orderInvestigationAppointment, ims.ocrr.vo.OrderInvestigationLiteVo investigationToAmend)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppointment(ims.scheduling.vo.Booking_AppointmentVo appointment, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo referral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateInvestigationStatus(ims.ocrr.vo.OrderInvestigationForStatusChangeVo investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLatestSummaryClinicalInformation(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTypeOfLocSite(ims.core.resource.place.vo.LocationRefVo locRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistResponsibleEdClinicians(String hcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContextByPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrderPriority(Boolean requiresPathologyMappings, Boolean requiresRadiologyMappings, Boolean requiresClinicalMappings)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLatestPasEvent(ims.core.patient.vo.PatientRefVo patient)
	{
	}
}