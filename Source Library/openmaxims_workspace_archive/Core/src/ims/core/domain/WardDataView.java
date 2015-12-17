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

package ims.core.domain;

// Generated from form domain impl
public interface WardDataView extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listWardsForCurrentLocation
	*/
	public ims.core.vo.LocationLiteVoCollection listWardsForCurrentLocation(ims.framework.interfaces.ILocation parentLocation);

	// Generated from form domain interface definition
	/**
	* getBedSpaceState
	*/
	public ims.core.vo.BedSpaceStateLiteVo getBedSpaceState(ims.core.layout.vo.BedSpaceRefVo bed);

	// Generated from form domain interface definition
	/**
	* listPendingElectiveAdmission
	*/
	public ims.core.vo.PendingElectiveAdmissionAdmitVoCollection listPendingElectiveAdmission(ims.core.resource.place.vo.LocationRefVo voLocation);

	// Generated from form domain interface definition
	/**
	* listEmergencyAdmission
	*/
	public ims.core.vo.PendingEmergencyAdmissionAdmitVoCollection listEmergencyAdmission(ims.core.resource.place.vo.LocationRefVo location);

	// Generated from form domain interface definition
	/**
	* listPendingTransfersInByWard
	*/
	public ims.core.vo.PendingTransfersLiteVoCollection listPendingTransfersInByWard(ims.core.resource.place.vo.LocationRefVo destWard);

	// Generated from form domain interface definition
	/**
	* listPendingTransfersOutByWard
	*/
	public ims.core.vo.PendingTransfersLiteVoCollection listPendingTransfersOutByWard(ims.core.resource.place.vo.LocationRefVo currentLocation);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveHospitalsLite();

	// Generated from form domain interface definition
	/**
	* getWardBayConfig
	*/
	public ims.core.vo.WardBayConfigVo getWardBayConfigByWard(ims.core.resource.place.vo.LocationRefVo ward);

	// Generated from form domain interface definition
	/**
	* listWaitingAreaPatientsByWard
	*/
	public ims.core.vo.InpatientEpisodeLiteVoCollection listWaitingAreaPatientsByWard(ims.core.resource.place.vo.LocationRefVo ward);

	// Generated from form domain interface definition
	public ims.core.vo.LocMostVo getLocation(ims.core.resource.place.vo.LocationRefVo voLocRef);

	// Generated from form domain interface definition
	/**
	* countInfants (WDEV-7722)
	*/
	public int countInfants(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* listInpatientsInBedsByWard
	*/
	public ims.core.vo.WardDataViewVoCollection listInpatientsInBedsByWard(ims.core.resource.place.vo.LocationRefVo ward);

	// Generated from form domain interface definition
	/**
	* listInpatientEpisodeByWard
	*/
	public ims.core.vo.InpatientEpisodeLiteVoCollection listInpatientEpisodeByWard(ims.core.resource.place.vo.LocationRefVo ward);

	// Generated from form domain interface definition
	/**
	* getCareContextForPasEvent
	*/
	public ims.core.vo.CareContextShortVo getCareContextForPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent);

	// Generated from form domain interface definition
	/**
	* getSystemReportAndTemplate
	*/
	public String[] getSystemReportAndTemplate(Integer imsId);

	// Generated from form domain interface definition
	/**
	* getPatient
	*/
	public ims.dto.client.Patient getCCODTOPatient(String pkey) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listHomeLeaveByWard
	*/
	public ims.core.vo.InpatientEpisodeLiteVoCollection listHomeLeaveByWard(ims.core.resource.place.vo.LocationRefVo ward);

	// Generated from form domain interface definition
	public String getPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getCurrentHospital(ims.framework.interfaces.ILocation location);
}
