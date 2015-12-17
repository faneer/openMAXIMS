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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseWardDataViewImpl extends DomainImpl implements ims.core.domain.WardDataView, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistWardsForCurrentLocation(ims.framework.interfaces.ILocation parentLocation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBedSpaceState(ims.core.layout.vo.BedSpaceRefVo bed)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPendingElectiveAdmission(ims.core.resource.place.vo.LocationRefVo voLocation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistEmergencyAdmission(ims.core.resource.place.vo.LocationRefVo location)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPendingTransfersInByWard(ims.core.resource.place.vo.LocationRefVo destWard)
	{
		if(destWard == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'destWard' of type 'ims.core.resource.place.vo.LocationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistPendingTransfersOutByWard(ims.core.resource.place.vo.LocationRefVo currentLocation)
	{
		if(currentLocation == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'currentLocation' of type 'ims.core.resource.place.vo.LocationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetWardBayConfigByWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWaitingAreaPatientsByWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
		if(ward == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'ward' of type 'ims.core.resource.place.vo.LocationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetLocation(ims.core.resource.place.vo.LocationRefVo voLocRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountInfants(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInpatientsInBedsByWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
		if(ward == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'ward' of type 'ims.core.resource.place.vo.LocationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistInpatientEpisodeByWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContextForPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSystemReportAndTemplate(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCCODTOPatient(String pkey)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHomeLeaveByWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCurrentHospital(ims.framework.interfaces.ILocation location)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInpatientEpisodeForVTE(ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatientEpisodeRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAllBedsForWard(ims.core.resource.place.vo.LocationRefVo ward)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBedSpaceState(ims.core.admin.pas.vo.BedSpaceStateRefVo bedSpaceState)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountFemalePatientsOnTheBayForSelectedBedSpace(ims.core.resource.place.vo.LocationRefVo wardRef, ims.core.resource.place.vo.LocationRefVo bayRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountMalePatientsOnTheBayForSelectedBedSpace(ims.core.resource.place.vo.LocationRefVo wardRef, ims.core.resource.place.vo.LocationRefVo bayRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPendingTransfer(ims.core.admin.pas.vo.PendingTransfersRefVo pendingTransferRef)
	{
	}
}
