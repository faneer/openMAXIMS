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

package ims.ocrr.domain;

// Generated from form domain impl
public interface PhlebotomyWorkList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listActiveTreatingHospitals
	*/
	public ims.core.vo.LocShortMappingsVoCollection listActiveTreatingHospitals();

	// Generated from form domain interface definition
	/**
	* listActiveWardsForHospital
	*/
	public ims.core.vo.LocShortMappingsVoCollection listActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital, ims.framework.utils.Date dateToCollect, ims.ocrr.vo.lookups.SpecimenCollectionTime roundToCollect);

	// Generated from form domain interface definition
	/**
	* List the details for a collection method and a dayofWeek (passing date and then calculatiing day of week lookup instance)
	*/
	public ims.ocrr.vo.SpecimenCollectionListConfigDetailsVoCollection listSpecimenCollectionDetails(ims.ocrr.vo.lookups.SpecimenCollectionMethod type, ims.framework.utils.Date date);

	// Generated from form domain interface definition
	/**
	* listWorkListItems
	*/
	public ims.ocrr.vo.SpecimenWorkListitemCustomVoCollection listWorkListItems(Integer[] wards, ims.framework.utils.Date dateToCollect, ims.ocrr.vo.lookups.SpecimenCollectionTime roundToCollect);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getHospitalForCurrentLocation(ims.framework.interfaces.ILocation currentLocation);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientById(Integer patientId);
}
