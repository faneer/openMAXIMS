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

package ims.clinicaladmin.domain;

// Generated from form domain impl
public interface TumourCategoryGroupSites extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourCategoryListVoCollection listCategory(Boolean isActive);

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
	* getCategory
	*/
	public ims.clinicaladmin.vo.TumourCategoryVo getCategory(ims.oncology.configuration.vo.TumourCategoryRefVo voRef);

	// Generated from form domain interface definition
	/**
	*  getOtherClassification
	*/
	public ims.oncology.vo.TumourGroupClassificationVoCollection getOtherClassification(ims.oncology.configuration.vo.TumourGroupClassificationRefVoCollection voRef);

	// Generated from form domain interface definition
	/**
	* saveCategory
	*/
	public ims.clinicaladmin.vo.TumourCategoryVo saveCategory(ims.clinicaladmin.vo.TumourCategoryVo record) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* saveGroup
	*/
	public ims.clinicaladmin.vo.TumourGroupVo saveGroup(ims.clinicaladmin.vo.TumourGroupVo voGroup, ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVo version) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Domain function used to save a TNM classification version.
	*/
	public ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVo saveVersion(ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVo version, ims.clinicaladmin.vo.TumourCategoryListVo category) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourSiteVo saveSite(ims.clinicaladmin.vo.TumourSiteVo record, ims.clinicaladmin.vo.TumourGroupListVo voGroup) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourCategoryListVo getCategoryList(ims.oncology.configuration.vo.TumourCategoryRefVo voRef);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourGroupListVo getGroupList(ims.oncology.configuration.vo.TumourGroupRefVo voRef);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourSiteListVo getSiteList(ims.oncology.configuration.vo.TumourSiteRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getTNMValueForGroup
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection getTNMValueForGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getTNMValueForSite
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection getTNMValueForSite(ims.oncology.configuration.vo.TumourSiteRefVo refVo, ims.oncology.vo.lookups.TNMType type);

	// Generated from form domain interface definition
	/**
	* getSiteWhoHasTNM
	*/
	public ims.clinicaladmin.vo.TumourSiteListVoCollection getSiteWhoHasTNM(ims.oncology.configuration.vo.TumourGroupRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getTaxonomyMapForTNM
	*/
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMapForTNM(ims.oncology.configuration.vo.TumourGroupSiteTNMValueRefVo refVo);

	// Generated from form domain interface definition
	/**
	* listTumourDiffs
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVoCollection listAllTumourDiffs();

	// Generated from form domain interface definition
	/**
	* listTumourDiffsForGroup
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVoCollection listTumourDiffsForGroup(ims.oncology.configuration.vo.TumourGroupRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getTaxonomyMapForHistology
	*/
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMapForHistology(ims.oncology.configuration.vo.TumourHistologyRefVo refVo);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourHistologyVo getHistology(ims.oncology.configuration.vo.TumourHistologyRefVo voRef);

	// Generated from form domain interface definition
	/**
	* getOverallStaging
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection getOverallStaging(ims.vo.ValueObject refVo);

	// Generated from form domain interface definition
	/**
	* countForOverallStaging
	*/
	public Integer countForOverallStaging(ims.vo.ValueObjectRef voRef);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection saveOverall(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection voCollOverall) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	*  countForActiveGroupOrSite
	*/
	public Integer countForActiveGroupOrSite(ims.vo.ValueObject voRef);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.TNMStagingClassificationVersionLiteVoCollection listVersions(ims.clinicaladmin.vo.TumourCategoryListVo category);

	// Generated from form domain interface definition
	public ims.assessment.vo.UserAssessmentLiteVoCollection listUserAssessments(String assessmentName);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.HistopathologicGradeVoCollection listDefaultDifferentiations();

	// Generated from form domain interface definition
	public Boolean countForOverallPrognostic(ims.oncology.configuration.vo.TumourGroupRefVo group);
}
