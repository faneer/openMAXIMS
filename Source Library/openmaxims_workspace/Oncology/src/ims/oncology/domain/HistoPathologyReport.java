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

package ims.oncology.domain;

// Generated from form domain impl
public interface HistoPathologyReport extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* savePathologyDetails
	*/
	public ims.clinicaladmin.vo.PathologyDetailsVo savePathologyDetails(ims.clinicaladmin.vo.PathologyDetailsVo pathVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* geStagingClassification
	*/
	public ims.clinicaladmin.vo.PathologyDetailsVo getPathologyDetail(ims.oncology.vo.PathologyDetailsRefVo pathRefVo);

	// Generated from form domain interface definition
	/**
	* listPathologyDetails
	*/
	public ims.clinicaladmin.vo.PathologyDetailsListVoCollection listPathologyDetails(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* List Organisations for given search criteria
	*/
	public ims.core.vo.OrgLiteVoCollection listOrganisationsLite(ims.core.vo.OrgShortVo filter);

	// Generated from form domain interface definition
	/**
	* getGroup
	*/
	public ims.clinicaladmin.vo.TumourGroupVo getGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getSite
	*/
	public ims.clinicaladmin.vo.TumourSiteVo getSite(ims.oncology.configuration.vo.TumourSiteRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getTumourOverAllStaging
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVo getTumourOverAllStaging(ims.oncology.configuration.vo.TumourGroupRefVo groupRefVo, ims.oncology.configuration.vo.TumourSiteRefVo siteRefVo, ims.oncology.configuration.vo.TumourGroupSiteTNMValueRefVo tRefVo, ims.oncology.configuration.vo.TumourGroupSiteTNMValueRefVo nRefVo, ims.oncology.configuration.vo.TumourGroupSiteTNMValueRefVo mRefVo);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.PathologyDetailsVo savePathologyDetailsTwoArg(ims.clinicaladmin.vo.PathologyDetailsVo pathVo1, ims.clinicaladmin.vo.PathologyDetailsVo pathVo2) throws ims.domain.exceptions.StaleObjectException;
}
