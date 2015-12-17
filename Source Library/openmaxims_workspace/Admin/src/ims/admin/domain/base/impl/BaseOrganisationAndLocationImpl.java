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

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseOrganisationAndLocationImpl extends DomainImpl implements ims.admin.domain.OrganisationAndLocation, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistOrganisation(ims.core.vo.OrganisationVo organisation, Boolean excludeGPs, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrganisation(ims.core.vo.OrganisationVo organisation)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveLocationSite(ims.core.vo.LocSiteVo locationSite)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveLocation(ims.core.vo.LocMostVo location)
	{
	}

	@SuppressWarnings("unused")
	public void validatemoveOrganisation(ims.core.vo.OrganisationVo orgToMove, ims.core.vo.OrganisationVo currentParent, ims.core.vo.OrganisationVo destParent)
	{
	}

	@SuppressWarnings("unused")
	public void validatemoveLocSite(ims.core.vo.LocSiteVo locSiteToMove, ims.core.vo.OrgShortVo currentParent, ims.core.vo.OrgShortVo destParent)
	{
	}

	@SuppressWarnings("unused")
	public void validatemoveLocation(ims.core.vo.LocMostVo locToMove, ims.core.vo.LocSiteVo locSiteCurrentParent, ims.core.vo.LocMostVo locCurrentParent, ims.core.vo.LocSiteVo locSiteDestParent, ims.core.vo.LocMostVo locDestParent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrganisation(Integer id)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocSite(Integer id)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeleteOrganisation(ims.core.vo.OrganisationVo orgToDelete)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeleteLocation(ims.core.vo.LocMostVo locToDelete)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationByLocalCode(String localCode, ims.core.vo.lookups.LocationType codeSpecifier)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocation(ims.core.vo.LocMostVo locationFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocSite(ims.core.vo.OrgShortVo organisation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrganisationsShort(ims.core.vo.OrgShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeleteLocSite(ims.core.vo.LocSiteVo locSiteToDelete)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationsMin(ims.core.vo.lookups.LocationType locType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrganisationByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocSiteByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationByPostCode(String postCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatesetOrgActiveState(ims.core.resource.place.vo.OrganisationRefVo org, Boolean state)
	{
	}

	@SuppressWarnings("unused")
	public void validatesetLocationActiveState(ims.core.resource.place.vo.LocationRefVo loc, Boolean state)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveClinic(ims.core.vo.ClinicVo clinic)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocSiteByPostCode(String postCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocationsByName(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocSiteLiteByName(String nameFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinic(Integer clinicCode)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocation(Integer location)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital, String wardName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospitalByName(ims.core.resource.place.vo.LocationRefVo hospital, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveClinicsForHospitalByName(ims.core.resource.place.vo.LocationRefVo hospital, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo location, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveOutpatDeptsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo parentLoc, String nameFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveOutpatDeptsForHospitalByName(ims.core.resource.place.vo.LocationRefVo hospital, String nameFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocSiteShortByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationLiteByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocSite(String locationName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationByName(String locationName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveAandEForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo hosp, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrganisationsLite(ims.core.vo.OrgShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatecheckExchequerCodeIsUnique(String taxonomyCode, ims.vo.ValueObjectRef refVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrgLiteByTaxonomyType(String extId, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validatecheckOrganisationNameisUnique(String orgName, ims.core.resource.place.vo.OrganisationRefVo orgRefVo)
	{
		if(orgName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'orgName' of type 'String' cannot be null.");
		if(orgRefVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'orgRefVo' of type 'ims.core.resource.place.vo.OrganisationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatecheckLocationNameIsUnique(String locationName, Integer locationId)
	{
		if(locationName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'locationName' of type 'String' cannot be null.");
		if(locationId == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'locationId' of type 'Integer' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatecheckLocationSiteNameIsUnique(String locSiteName, Integer locSiteId)
	{
		if(locSiteName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'locSiteName' of type 'String' cannot be null.");
		if(locSiteId == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'locSiteId' of type 'Integer' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospitalLite(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicByTaxonomyCode(ims.core.vo.lookups.TaxonomyType type, String taxCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPCTs(String value, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validategetActiveHospitalCodeForClinic(ims.core.resource.place.vo.ClinicRefVo clinicRefVo, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationByOrganisation(ims.core.resource.place.vo.OrganisationRefVo organisation, String name)
	{
		if(organisation == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'organisation' of type 'ims.core.resource.place.vo.OrganisationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistLocationByOrganisationIncludingPathAndRadTypes(ims.core.resource.place.vo.OrganisationRefVo org)
	{
		if(org == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'org' of type 'ims.core.resource.place.vo.OrganisationRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPrinter(ims.framework.interfaces.IPrinter printer)
	{
		if(printer == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'printer' of type 'ims.framework.interfaces.IPrinter' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetActiveHospitalCodeForLoc(ims.core.vo.LocShortMappingsVo loc, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPracticeNationalCodeForSurgery(ims.core.resource.place.vo.LocationRefVo surgery)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocMost(Integer id)
	{
	}

	@SuppressWarnings("unused")
	public void validategetActiveHospitalCodeForLoc(ims.core.resource.place.domain.objects.Location location, ims.core.vo.lookups.TaxonomyType taxonomyType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistCaseNoteFolderLocations(String strVal)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveClinicsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo hospital, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHospitalLiteForLocation(ims.framework.interfaces.ILocation location)
	{
	}

	@SuppressWarnings("unused")
	public void validatetriggerWardMasterFileEvent(ims.core.resource.place.vo.LocationRefVo locRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveLocationSite(ims.core.vo.LocSiteVo voLocSite, ims.core.vo.LocMostVo childLoc)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationsByTheParentLocation( ims.core.vo.lookups.LocationType locationtype, ims.core.resource.place.vo.LocationRefVo parentLocation, Boolean isActive, Boolean referringHospital, Boolean treatingHosp, Boolean caseNoteFolderLocation, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutpatientlocationsByHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validategetChildLocationsIdsForLocation(Integer locationID, int[] locationTypes, Boolean isActive)
	{
	}

	@SuppressWarnings("unused")
	public void validategetChildLocationsIdsForLocation(Integer locationID, int[] locationTypes, Boolean isActive, Boolean isVirtual)
	{
	}

	@SuppressWarnings("unused")
	public void validategetChildLocationsIdsForLocation(Integer locationID, int[] locationTypes, Boolean isActive, Boolean isVirtual, Boolean caseNoteFolder)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTheatreAndProcedureRoomsIDsForLocation(ims.core.resource.place.vo.LocationRefVo locationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistCaseNoteLocationByParentLocation(ims.core.resource.place.vo.LocSiteRefVo parentLocSite, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationsByParentLocation(ims.core.vo.lookups.LocationType type, ims.core.resource.place.vo.LocationRefVo parentLocation, Boolean isActive, Boolean isVirtual, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCaseNoteFolderLocationByParent(ims.core.resource.place.vo.LocationRefVo locRef, String value, ims.core.vo.lookups.LocationType type)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationByParent(ims.core.resource.place.vo.LocationRefVo locRef, String value, ims.core.vo.lookups.LocationType type1)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocationsForHospital(ims.core.resource.place.vo.LocationRefVo location, int[] types)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistRequestorLocation(ims.core.resource.place.vo.LocationRefVo hospital, String locationName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetChildLocationsIdsForLocation(Integer locationID, int[] locationTypes, Boolean isActive, Boolean isVirtual, Boolean caseNoteFolder, Boolean includeCurrent)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveLocationsForHospitalByName(ims.core.resource.place.vo.LocationRefVo location, int[] types, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistRequestorLocationWithOrWithoutVirtualLoc(ims.core.resource.place.vo.LocationRefVo hospital, String locationName, Boolean virtual)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistRequestorLocationWithOrWithoutVirtualLocIncludeWards(ims.core.resource.place.vo.LocationRefVo hospital, String locationName, Boolean virtual, Boolean includeWards)
	{
	}
}
