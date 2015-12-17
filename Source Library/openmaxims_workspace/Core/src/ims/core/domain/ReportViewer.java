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
public interface ReportViewer extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* getReport
	*/
	public ims.admin.vo.ReportVo getReport(ims.core.admin.vo.TemplateBoRefVo templateRef);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByNameAndDisciplineType(String hcpName, ims.core.vo.lookups.HcpDisType hcpDisciplineType);

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	/**
	* Lists GPs by Surname
	*/
	public ims.core.vo.GpShortVoCollection listGPsBySurname(String surname);

	// Generated from form domain interface definition
	public ims.core.vo.OrgShortVoCollection listOrganisationsShort(ims.core.vo.OrgShortVo filter);

	// Generated from form domain interface definition
	/**
	* list Location Site
	*/
	public ims.core.vo.LocSiteLiteVoCollection listLocSite(String locationName);

	// Generated from form domain interface definition
	/**
	* list Locations By Name
	*/
	public ims.core.vo.LocationLiteVoCollection listLocationByName(String locationName);

	// Generated from form domain interface definition
	public Integer getLokupType(String lookupType);

	// Generated from form domain interface definition
	public java.util.ArrayList<Object[]> listCustomSearchSeed(String name, String seedField, String[] displayFields, String[] searchFields, String searchText) throws ims.domain.exceptions.DomainInterfaceException;
}
