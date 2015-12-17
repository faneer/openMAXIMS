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

package ims.clinicaladmin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseTumourCategoryGroupSitesImpl extends DomainImpl implements ims.clinicaladmin.domain.TumourCategoryGroupSites, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistCategory(Boolean isActive)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSite(ims.oncology.configuration.vo.TumourSiteRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCategory(ims.oncology.configuration.vo.TumourCategoryRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOtherClassification(ims.oncology.configuration.vo.TumourGroupClassificationRefVoCollection voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveCategory(ims.clinicaladmin.vo.TumourCategoryVo record)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveGroup(ims.clinicaladmin.vo.TumourGroupVo voGroup, ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVo version)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveVersion(ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVo version, ims.clinicaladmin.vo.TumourCategoryListVo category)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSite(ims.clinicaladmin.vo.TumourSiteVo record, ims.clinicaladmin.vo.TumourGroupListVo voGroup)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCategoryList(ims.oncology.configuration.vo.TumourCategoryRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGroupList(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSiteList(ims.oncology.configuration.vo.TumourSiteRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTNMValueForGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTNMValueForSite(ims.oncology.configuration.vo.TumourSiteRefVo refVo, ims.oncology.vo.lookups.TNMType type)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSiteWhoHasTNM(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTaxonomyMapForTNM(ims.oncology.configuration.vo.TumourGroupSiteTNMValueRefVo refVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistTumourDiffsForGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTaxonomyMapForHistology(ims.oncology.configuration.vo.TumourHistologyRefVo refVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHistology(ims.oncology.configuration.vo.TumourHistologyRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOverallStaging(ims.vo.ValueObject refVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountForOverallStaging(ims.vo.ValueObjectRef voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOverall(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection voCollOverall)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountForActiveGroupOrSite(ims.vo.ValueObject voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistVersions(ims.clinicaladmin.vo.TumourCategoryListVo category)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistUserAssessments(String assessmentName)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountForOverallPrognostic(ims.oncology.configuration.vo.TumourGroupRefVo group)
	{
	}
}
