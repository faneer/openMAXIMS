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

package ims.scheduling.domain;

// Generated from form domain impl
public interface Profiles extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Lists all profiles
	*/
	public ims.scheduling.vo.ProfileShortVoCollection listProfiles(ims.core.vo.ServiceShortVo service, ims.scheduling.vo.DirectoryOfServiceVo directoryOfService, ims.core.resource.place.vo.LocationRefVo hosp, Boolean activeOnly, Boolean isOutpatient, Boolean isTheatre, String name, ims.vo.interfaces.IMos listOwner);

	// Generated from form domain interface definition
	/**
	* List Directory of Services to pre-populate the grid
	*/
	public ims.scheduling.vo.DirectoryOfServiceVoCollection listDOS(ims.scheduling.vo.DirectoryOfServiceVo directoryOfService);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceVoCollection listLocationServices(ims.core.vo.LocShortVo locShort);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVoCollection listServices();

	// Generated from form domain interface definition
	/**
	* Lists all roles
	*/
	public ims.admin.vo.AppRoleShortVoCollection listRoles();

	// Generated from form domain interface definition
	/**
	* listHcpLite
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLite(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Sch_ProfileGenericVo saveGenericProfile(ims.scheduling.vo.Sch_ProfileGenericVo profile, ims.scheduling.vo.ProfileTemplateVoCollection templates) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Sch_ProfileGenericVo getGenericProfileDetails(ims.scheduling.vo.ProfileShortVo profileShort);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Sch_ProfileVo getProfileDetails(ims.scheduling.vo.ProfileShortVo profileShort);

	// Generated from form domain interface definition
	/**
	* getLocationService
	*/
	public ims.core.vo.LocationServiceVo getLocationService(ims.core.resource.place.vo.LocationRefVo location, ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	/**
	* listProfileTemplatesByProfile
	*/
	public ims.scheduling.vo.ProfileTemplateVoCollection listProfileTemplatesByProfile(ims.scheduling.vo.Sch_ProfileRefVo profile);

	// Generated from form domain interface definition
	/**
	* Procedures Performed by Hcp(s)
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedureByHcpAndName(ims.core.resource.people.vo.HcpRefVoCollection hcp, String name);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveHospitalsLite();

	// Generated from form domain interface definition
	/**
	* listActivity
	*/
	public ims.core.vo.ActivityLiteVoCollection listActivity();
}
