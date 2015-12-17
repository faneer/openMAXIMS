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

package ims.emergency.domain;

// Generated from form domain impl
public interface EmergencyAttendanceDetailsCc extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listCareSpellsByPatient
	*/
	public ims.emergency.vo.EpisodeDetailsVoCollection listEmergencyEpisodeByPatient(ims.core.patient.vo.PatientRefVo patientRefVo, Integer maxRecords, ims.emergency.vo.enums.AttendanceHistoryDialog type, ims.framework.utils.DateTime scheduledDate, ims.framework.utils.DateTime unscheduledDate);

	// Generated from form domain interface definition
	/**
	* get Patient
	*/
	public ims.core.vo.Patient getPatient(ims.core.patient.vo.PatientRefVo patientRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* save
	*/
	public ims.emergency.vo.EpisodeDetailsVo save(ims.emergency.vo.EpisodeDetailsVo record, ims.core.vo.CareSpellVo voCareSpell, ims.core.vo.EpisodeofCareVo voEpisodeOfCare, ims.core.vo.CareContextVo voCareContext, ims.emergency.vo.TrackingSendToAreaVo trackingVo, ims.emergency.vo.TIIGVo tiigrecord, ims.emergency.vo.RTAVo rtaRecord, ims.emergency.vo.AttendanceDetailsVo emergattendance, ims.scheduling.vo.BookingAppointmentForEDAttendanceDetailsVo bookApptToSave, ims.emergency.vo.EmergencyAttendanceBillingVo invoiceBilling, ims.emergency.vo.ChartRequestedVo chartRequested, ims.emergency.vo.EmergencyAttendanceNonInsuranceHealthCoverVo insuranceDetails) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.GpLiteWithNameVo getGP(Integer id);

	// Generated from form domain interface definition
	/**
	* getEpisodeOfCare
	*/
	public ims.core.vo.EpisodeofCareVo getEpisodeOfCare(Integer id);

	// Generated from form domain interface definition
	/**
	* getCareSpellByEpisodeOfCare
	*/
	public ims.core.vo.CareSpellVo getCareSpellByEpisodeOfCare(Integer id);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingSendToAreaVo isPatientCurrentlyinED(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.core.vo.GpShortVo getGpPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.emergency.vo.AttendanceDetailsVo getLastAttendance(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.EpisodeDetailsVo getEmergencyEpisode(ims.core.admin.vo.EmergencyEpisodeRefVo episodeId);

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteShortVo getTypeOfLocSite(ims.core.resource.place.vo.LocationRefVo locRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.LocationDepartmentTypesVo getLocationDepartmentTypes(ims.core.resource.place.vo.LocationRefVo edLocation);

	// Generated from form domain interface definition
	public ims.emergency.vo.EpisodeOfcareLiteVo getEpisodeOfCareLite(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef);

	// Generated from form domain interface definition
	public ims.admin.vo.EDAttendanceControlsConfigVoCollection getEDAttendanceControlsConfig(ims.admin.vo.lookups.EDAttendenceControlType controlType);

	// Generated from form domain interface definition
	public ims.emergency.vo.AttendanceDetailsVo getAttendanceDetails(ims.core.admin.vo.EmergencyAttendanceRefVo attendanceDetailsRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.lookups.EmergencyDeptType getEDDeptType(ims.core.resource.place.vo.LocationRefVo locationRef);

	// Generated from form domain interface definition
	/**
	* Triggers an ED attendance registration event
	*/
	public void triggerAttendanceRegistrationEvent(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void triggerAttendanceUpdateEvent(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void triggerAttendanceDischargeEvent(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void triggerAttendanceCancelDischargeEvent(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void triggerAttendanceCancelRegistrationEvent(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean isModeOfArrivalAmbulance( ims.emergency.vo.lookups.ModeOfArrival lookup);

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentForEDAttendanceDetailsVo getBookApptForLastAttendance(ims.core.admin.vo.EmergencyAttendanceRefVo emergAttendanceRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.AttendanceDetailsVo getLastDischargedAttendance(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.lookups.SchoolCollection getSchool(String text);
}
