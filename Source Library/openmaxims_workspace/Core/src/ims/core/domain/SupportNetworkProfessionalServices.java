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
public interface SupportNetworkProfessionalServices extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkProfessionalVoCollection listSupportNetworkProfessionalByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef, Boolean activeOnly);

	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkProfessionalVo saveSupportNetworkProfessional(ims.core.vo.SupportNetworkProfessionalVo supportNetworkProfessional, ims.core.admin.vo.CareContextRefVo voCareContextRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter, ims.core.vo.lookups.HcpDisType subType);

	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkServicesVo saveSupportNetworkService(ims.core.vo.SupportNetworkServicesVo supportNetworkService, ims.core.admin.vo.CareContextRefVo voCareContextRef) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkServicesVoCollection listSupportNetworkServiceByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef, Boolean activeOnly);

	// Generated from form domain interface definition
	public ims.core.vo.LocShortVoCollection listLocations(ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	/**
	* copys the previous support network professional info into this episode
	*/
	public void copyPreviousProfessionalData(ims.core.vo.SupportNetworkProfessionalVoCollection professionalVoCollection, ims.core.vo.CareContextShortVo careContextShort) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* copys the previous support network service info into this episode
	*/
	public void copyPreviousServiceData(ims.core.vo.SupportNetworkServicesVoCollection serviceVoCollection, ims.core.vo.CareContextShortVo careContextShort) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVoCollection listService(ims.core.vo.lookups.ServiceCategory serviceType);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceVo getLocationService(ims.core.vo.LocShortVo locShort, ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	/**
	* Return a list of Mmember of staff
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaffWithPrimaryLocations(ims.core.vo.MemberOfStaffShortVo voMemberOfStaffShortVo, ims.core.vo.lookups.HcpDisType hcpSUbtype);

	// Generated from form domain interface definition
	/**
	* get the Hcp but of type Medic, Nurse, Therapist
	*/
	public ims.core.vo.Hcp getHcp(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* Lists CareContexts for a patient
	*/
	public ims.core.vo.CareContextShortVoCollection listCareContexts(ims.core.patient.vo.PatientRefVo voPatientRef);

	// Generated from form domain interface definition
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkProfessionalVoCollection listSupportNetworkProfessionalByPatient(Boolean activeOnly, ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* saves a Family Support Network
	*/
	public ims.core.vo.SupportNetworkProfessionalVo saveSupportNetworkProfessionaForPatient(ims.core.vo.SupportNetworkProfessionalVo voSupportNetworkProfessional, ims.core.patient.vo.PatientRefVo patient) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.SupportNetworkServicesVoCollection listSupportNetworkServicesByPatient(Boolean activeOnly, ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* saves a Family Support Network
	*/
	public ims.core.vo.SupportNetworkServicesVo saveSupportNetworkServicesForPatient(ims.core.vo.SupportNetworkServicesVo voSupportNetworkServices, ims.core.patient.vo.PatientRefVo patient) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.LocShortVoCollection listLocationsForMemberOfStaff(ims.core.resource.people.vo.MemberOfStaffRefVo mos);

	// Generated from form domain interface definition
	public ims.core.vo.GpShortVo getGPDetails(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVoCollection listService(ims.core.vo.lookups.ServiceCategoryCollection excludedServices);

	// Generated from form domain interface definition
	/**
	* getGpSurgeryByPatient
	*/
	public ims.core.vo.LocSiteShortVo getGpSurgeryByPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.core.vo.PatientNoSupportNetworkServicesInfoVo savePatientNoSupportNetworkServicesInfo(ims.core.vo.PatientNoSupportNetworkServicesInfoVo patientCoreClinicalDataVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* savePatientNoSupportNetworkStatusInfo
	*/
	public ims.core.vo.PatientNoSupportNetworkStatusInfoVo savePatientNoSupportNetworkStatusInfo(ims.core.vo.PatientNoSupportNetworkStatusInfoVo voPatientNoSupportNetworkStatusInfo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* getPatientNoSupportNetworkServicesInfo
	*/
	public ims.core.vo.PatientNoSupportNetworkServicesInfoVo getPatientNoSupportNetworkServicesInfo(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	/**
	* getPatientNoSupportNetworkStatusInfo
	*/
	public ims.core.vo.PatientNoSupportNetworkStatusInfoVo getPatientNoSupportNetworkStatusInfo(ims.core.patient.vo.PatientRefVo patientRefVo);
}
