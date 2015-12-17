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

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseNewElectiveListTCIErodDialogImpl extends DomainImpl implements ims.RefMan.domain.NewElectiveListTCIErodDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetReferralDetails(ims.RefMan.vo.CatsReferralRefVo referralRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListConfigForHCP(Integer hcpId, Integer serviceId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListConfigForService(Integer serviceId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListsBySpecialty(Integer specialtyId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProcedureFromSuitableForSurgery(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProcedures(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo electiveListRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWards(String name, ims.core.resource.place.vo.LocationRefVo locationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.RefMan.vo.PatientElectiveListDetailsToSaveVo patientElectiveList, Boolean bCancelledTCIForNonMedicalReasons)
	{
	}

	@SuppressWarnings("unused")
	public void validateisFitForSurgery(ims.core.admin.vo.CareContextRefVo carecontextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateisStaleNote(ims.RefMan.vo.PatientElectiveListNotesVo patientElectiveListNote)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHospitals(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSuspensionsForPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveListRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasNonDiagnosticPatientElectiveList(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSuitableForSurgeryAssessmentByCareContext(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasNonDiagnosticPatientElectiveListforReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.RefMan.vo.CatsReferralRefVo voReferralRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelCaseNoteRequests(Integer tciId)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateCaseNoteRequests(Integer tciId, ims.core.vo.PatientShort patient, ims.core.vo.LocationLiteVo caseNoteFolderLocRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHospitalsByElectiveList(ims.core.configuration.vo.ElectiveListConfigurationRefVo electiveListConfig, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatetriggerElectiveListEvent(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveList)
	{
	}
}
