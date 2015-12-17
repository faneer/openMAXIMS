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

package ims.nursing.domain;

// Generated from form domain impl
public interface SkinBodyChart extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.nursing.vo.SkinAssessmentCollection listSkinAssessment(ims.core.admin.vo.CareContextRefVo voCurrentCareContext);

	// Generated from form domain interface definition
	public ims.nursing.vo.SkinAssessment getLastSkinAssessmentByCareContext(ims.core.admin.vo.CareContextRefVo voCurrentCareContext);

	// Generated from form domain interface definition
	/**
	* Saves the SkinAssessment, and if supplied, 
	* Save the component, add to the assessment, updates the list of components in the returned object
	*/
	public ims.nursing.vo.AssessmentHeaderInfo saveRecord(ims.nursing.vo.SkinAssessment skinAssessment, ims.nursing.vo.AssessmentHeaderInfo assessment, ims.nursing.vo.AssessmentComponent component) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.DrawingImageVo getDrawingImage(ims.core.vo.DrawingImageVo drawingImageVO);

	// Generated from form domain interface definition
	/**
	* get last skin assessment for patient
	*/
	public ims.nursing.vo.SkinAssessment getLastSkinAssessmentByPatient(Integer idPatient);
}
