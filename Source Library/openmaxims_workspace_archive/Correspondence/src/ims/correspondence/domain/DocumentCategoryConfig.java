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

package ims.correspondence.domain;

// Generated from form domain impl
public interface DocumentCategoryConfig extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all the Reports that are active
	*/
	public ims.core.vo.TemplateForPatientDocumentVoCollection listReports(String templateName, ims.core.admin.vo.TemplateBoRefVoCollection notThisOnes, ims.core.vo.lookups.DocumentCategory cat);

	// Generated from form domain interface definition
	public ims.core.vo.DocumentCategoryConfigShortVo getDocCatConfig(ims.core.admin.vo.TemplateBoRefVo template);

	// Generated from form domain interface definition
	public ims.core.vo.DocumentCategoryConfigShortVo save(ims.core.vo.DocumentCategoryConfigShortVo record) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.DocumentCategoryConfigShortVoCollection listDocCateConfig(ims.core.vo.lookups.DocumentCategory docCat);

	// Generated from form domain interface definition
	public ims.core.vo.DocumentCategoryConfigShortVoCollection saveAll(ims.core.vo.DocumentCategoryConfigShortVoCollection oldCats, ims.core.vo.DocumentCategoryConfigShortVoCollection newCats) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;
}
