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

package ims.core.domain;

// Generated from form domain impl
public interface WardViewPatientList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.PatientLite_IdentifiersVoCollection listPatients(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay, Object searchType);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsOnTheWard(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsAwaitingBed(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsOnHomeLeave(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsToBeDischargedWithin24Hours(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsWithDischargedConfirmedWithin24Hours(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsReadyToLeave(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForTransferOutPatients(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForTransferInPatients(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.TrackingForPendingEmergencyAdmitVoCollection listPendingEDEmergencyAdmission(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListBedInfoVoCollection listPatientsForElectiveAdmission(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.InpatientEpisodeLiteVo getInpatientEpisodeLite(ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatientEpisode);

	// Generated from form domain interface definition
	public ims.core.vo.PendingTransfersLiteVo getPendingTransferLite(ims.core.admin.pas.vo.PendingTransfersRefVo transfer);

	// Generated from form domain interface definition
	public void cancelTransfer(ims.core.vo.PendingTransfersLiteVo transfer, ims.core.resource.place.vo.LocationRefVo ward) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingRefVo getTrackingForPendingEmergency(ims.core.admin.pas.vo.PendingEmergencyAdmissionRefVo pendingEmergency);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.WardViewPatientListVoCollection listForPatientsOnHomeLeaveWithBedsRetained(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.core.vo.BedSpaceStateLiteVo getSelectedBedSpaceState(ims.core.admin.pas.vo.BedSpaceStateRefVo bedSpaceStateRef);

	// Generated from form domain interface definition
	public ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVoCollection listPendingEmergencyAdmissions(ims.core.resource.place.vo.LocationRefVo ward, ims.core.resource.place.vo.LocationRefVo bay);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListBedAdmissionVo getPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveList);

	// Generated from form domain interface definition
	public ims.core.vo.PendingTransfersLiteVo getPendingTransferForInpatientEpisode(ims.core.admin.pas.vo.InpatientEpisodeRefVo voInpatRef);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextForPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEventRef);

	// Generated from form domain interface definition
	public ims.core.vo.WardConfigLiteVo getWardConfig(ims.core.resource.place.vo.LocationRefVo wardRef);

	// Generated from form domain interface definition
	public void updatePendingTransfer(ims.core.vo.PendingTransfersLiteVo pendingTransf) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextForTrackingAttendance(ims.emergency.vo.EmergencyAttendanceLiteVo emergencyAttendanceRef);

	// Generated from form domain interface definition
	public void undoReadyToLeave(ims.core.vo.InpatientEpisodeLiteVo voInpatToUpdate) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void returnFromHomeLeaveToWard(ims.core.vo.InpatientEpisodeLiteVo voInpat, ims.core.vo.HomeLeaveVo voHomeLeave) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;
}
