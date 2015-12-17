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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4772.16308)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.LocShortMappingsVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.domain.base.impl.BaseMoveToWardSpecimenCollectionImpl;
import ims.ocrr.orderingresults.domain.objects.SpecimenWorkListItem;
import ims.ocrr.vo.SpecimenWorkListItemListVo;
import ims.ocrr.vo.domain.SpecimenWorkListItemListVoAssembler;

public class MoveToWardSpecimenCollectionImpl extends BaseMoveToWardSpecimenCollectionImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocShortMappingsVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);

		return impl.listActiveHospitals();
	}

	public LocationLiteVo getHospitalForCurrentLocation(Integer locId)
	{
		if (locId == null)
			throw new CodingRuntimeException("Cannot get the Hospital for a null Location.");

		DomainFactory factory = getDomainFactory();
		Location doLocation = (Location) factory.getDomainObject(Location.class, locId);

		return getHospital(doLocation);
	}

	private LocShortMappingsVo getHospital(Location doLocation)
	{
		if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
		{
			return LocShortMappingsVoAssembler.create((LocSite) doLocation);
		}

		while (doLocation.getParentLocation() != null)
		{
			doLocation = doLocation.getParentLocation();

			if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			{
				return LocShortMappingsVoAssembler.create((LocSite) doLocation);
			}
		}

		return null;
	}

	public LocShortVoCollection listActiveWardsForHospital(LocationRefVo hospital, String name)
	{
		OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return locImpl.listActiveWardsForHospital(hospital, name);
	}

	public SpecimenWorkListItemListVo getSpecimenWorklistItem(Integer id)
	{
		if (id == null)
			throw new CodingRuntimeException("Cannot get SpecimenWorklistItem on null Id.");

		return SpecimenWorkListItemListVoAssembler.create((SpecimenWorkListItem) getDomainFactory().getDomainObject(SpecimenWorkListItem.class, id));
	}

	public LocationLiteVo getPatientWard(Integer locId)
	{
		if (locId == null)
			throw new CodingRuntimeException("Cannot get Ward on null Id.");

		return LocationLiteVoAssembler.create((Location) getDomainFactory().getDomainObject(Location.class, locId));
	}

	public void saveWorkListItem(SpecimenWorkListItemListVo specimenWorkListItem) throws StaleObjectException
	{
		if (specimenWorkListItem == null)
			throw new CodingRuntimeException("Cannot save null specimenWorkListItem");

		if (!specimenWorkListItem.isValidated())
			throw new DomainRuntimeException("SpecimenWorkListItemVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		SpecimenWorkListItem domainSpecimenWorkListItem = SpecimenWorkListItemListVoAssembler.extractSpecimenWorkListItem(factory, specimenWorkListItem);

		factory.save(domainSpecimenWorkListItem);
	}

	public PatientShort getPatient(Integer patientId)
	{
		if (patientId == null)
			throw new CodingRuntimeException("Cannot get Patient on null Id.");

		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientId));
	}
}
