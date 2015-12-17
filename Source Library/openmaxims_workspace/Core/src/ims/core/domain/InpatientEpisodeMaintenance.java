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
public interface InpatientEpisodeMaintenance extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Gets current and discharged episodes for patient
	*/
	public ims.core.vo.InpatientMaintenanceSummaryVo summary(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public void saveAdmissionDetails(ims.core.vo.InpatientEpisodeMaintenanceVo episode) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void cancelCurrentAdmission(ims.core.vo.PatientShort patient) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.DischargedEpisodeMaintenanceVo saveDischargedEpisode(ims.core.vo.DischargedEpisodeMaintenanceVo episode, ims.core.vo.InpatientEpisodeMaintenanceVo inPatDetails) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.DischargedEpisodeMaintenanceVo saveDischargedEpisode(ims.core.vo.DischargedEpisodeMaintenanceVo episode, ims.core.vo.InpatientEpisodeMaintenanceVo inPatDetails, Boolean initialTreatmentDeferredState, Boolean finalTreatmentDeferredState) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getServicesBySpeciality
	*/
	public ims.core.vo.ServiceLiteVoCollection getServicesBySpecialty(ims.core.vo.lookups.Specialty specialty);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listWards(ims.framework.interfaces.ILocation iLoc);

	// Generated from form domain interface definition
	public void rieDischargedEpisode(ims.core.vo.DischargedEpisodeMaintenanceVo episode) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Gets all active services 
	*/
	public ims.core.vo.ServiceLiteVoCollection getServices();

	// Generated from form domain interface definition
	/**
	* Marks a Consultant Stay as RIE
	*/
	public void rIEConsultantStay(ims.core.vo.ConsultantStayVo stay, ims.core.vo.DischargedEpisodeMaintenanceVo dischargedEpisode) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Marks a Ward Stay as RIE
	*/
	public void rIEWardStay(ims.core.vo.WardStayVo stay) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void cancelDischarge(ims.core.vo.DischargedEpisodeMaintenanceVo episode) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.MedicVo getMedicVoFromIMos(ims.vo.interfaces.IMos mos);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithMappingsLiteVo getMedicWithMappingsLiteVoFromIMos(ims.vo.interfaces.IMos mos);

	// Generated from form domain interface definition
	public ims.scheduling.vo.CancellationTypeReasonVoCollection listCancellationTypeReason();

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveHospitals();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getHospitalForLocation(ims.framework.interfaces.ILocation iLocation);

	// Generated from form domain interface definition
	public ims.scheduling.vo.CancellationTypeReasonVo getDeferredReason(ims.scheduling.vo.lookups.CancelAppointmentReason reason);

	// Generated from form domain interface definition
	public void undoRTTEvent(ims.RefMan.vo.RTTManagementGridValueVo event) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.emergency.vo.AppFormForTrackingVo getFormMenuAction(Integer formID);
}
