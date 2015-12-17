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

package ims.admin.domain;

// Generated from form domain impl
public interface LocationService extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceVo saveLocationService(ims.core.vo.LocationServiceVo locationService) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.OrganisationVoCollection listOrganisation(ims.core.vo.OrganisationVo organisation);

	// Generated from form domain interface definition
	/**
	* list services associated with a location
	*/
	public ims.core.vo.LocationServiceVoCollection listLocationService(ims.core.resource.place.vo.LocationRefVo voLocation);

	// Generated from form domain interface definition
	/**
	* list services by name
	*/
	public ims.core.vo.ServiceShortVoCollection listServices(String serviceName);

	// Generated from form domain interface definition
	/**
	* get functions that are linked to a service
	*/
	public ims.core.vo.ServiceFunctionVoCollection listServiceFunction(Integer voServiceId);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVo getService(Integer serviceId);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceActivityVoCollection listServiceActivity(Integer voServiceId);

	// Generated from form domain interface definition
	public ims.core.vo.ActivityVoCollection listActivity(ims.core.vo.ActivityVo filter);

	// Generated from form domain interface definition
	public ims.core.vo.ActivityVoCollection listActivity(ims.core.vo.LocationServiceActivityVo locationServiceActivity) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list activities
	*/
	public ims.core.vo.ActivityVoCollection listActivity(ims.core.vo.ActivityVo filterActivity, Boolean checkDuplicate);

	// Generated from form domain interface definition
	/**
	* by Location, Active
	*/
	public ims.core.vo.LocationServiceVoCollection listLocationService(ims.core.vo.LocationServiceVo locationServiceFilter);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceActivityVoCollection listLocationServiceActivity(ims.core.vo.LocationServiceVo locationService, ims.core.vo.ActivityVo activity) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVoCollection listService(Boolean activeOnly);

	// Generated from form domain interface definition
	public ims.core.vo.OrgShortVoCollection listOrganisation();

	// Generated from form domain interface definition
	/**
	* remove a service from a location
	*/
	public void removeLocationService(ims.core.vo.LocationServiceVo voLocationService) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceActivityVoCollection listLocationServiceActivity(ims.core.vo.LocationServiceVo filterLocationService);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceFunctionsVoCollection listLocationServiceFunction(ims.core.vo.LocationServiceVo voLocationService, ims.core.vo.ServiceFunctionVo voFunction);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceShortVoCollection listServiceExcludeCategory(String serviceName, ims.core.vo.lookups.ServiceCategory serviceCategory);

	// Generated from form domain interface definition
	/**
	* List LocationServiceActivity on KeyWords Join
	*/
	public ims.core.vo.LocationServiceActivityVoCollection listLocationServiceActivityKeyWords(ims.core.vo.LocationServiceVo locationService, ims.core.vo.ActivityVo activity) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	*  getProcedureForActivity
	*/
	public ims.core.vo.ProcedureVo getProcedureForActivity(ims.core.resource.place.vo.ActivityRefVo activityRefVo);

	// Generated from form domain interface definition
	/**
	* COunt
	* 
	*/
	public Integer countBatches(ims.core.resource.place.vo.LocationRefVo location);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceMidVoCollection listLocationServiceLite(ims.core.resource.place.vo.LocationRefVo voLocation);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceVoCollection listServicesForLocation(ims.core.resource.place.vo.LocationRefVo location, ims.core.vo.ServiceVo service);
}
