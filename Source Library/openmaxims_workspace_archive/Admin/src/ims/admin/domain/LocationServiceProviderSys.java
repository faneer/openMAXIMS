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

package ims.admin.domain;

// Generated from form domain impl
public interface LocationServiceProviderSys extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.OrganisationVoCollection listOrganisation(ims.core.vo.OrganisationVo organisation);

	// Generated from form domain interface definition
	/**
	* list services associated with a location
	*/
	public ims.core.vo.LocationServiceVoCollection listLocationService(ims.core.resource.place.vo.LocationRefVo voLocation);

	// Generated from form domain interface definition
	/**
	* save LocationServiceProvider
	*/
	public ims.ocrr.vo.LocSvcProviderSysVo saveLocationServiceProvider(ims.ocrr.vo.LocSvcProviderSysVo voLoSvcProviderSysVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Gets a LocationService Provider From Location Id
	*/
	public ims.ocrr.vo.LocSvcProviderSysVoCollection listLocationServiceProvider(Integer locationServiceId);

	// Generated from form domain interface definition
	public ims.ocrr.vo.ProviderSystemVoCollection listProviderSystems();

	// Generated from form domain interface definition
	/**
	* listProviderSystemById
	*/
	public ims.ocrr.vo.LocSvcProviderSysVoCollection listProviderSystemById(ims.core.admin.vo.ProviderSystemRefVo refVo);
}
