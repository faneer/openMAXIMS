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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface MedMskSpineExam extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Get the Admission Spinal Examinations and findings for the selected Episode
	*/
	public ims.generalmedical.vo.AdmisSpineExamVo getAdmisSpineExamination(ims.core.vo.ClinicalContactShortVo contact, ims.generalmedical.vo.MskSpineExamFindingShortVo voSpineExamShort);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.AdmisSpineExamVo saveAdmisSpineExamination(ims.generalmedical.vo.AdmisSpineExamVo admisSpinExam) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get image of Back
	*/
	public ims.core.vo.DrawingImageVo getDrawingImage(ims.core.vo.DrawingImageVo drawingImageVO);

	// Generated from form domain interface definition
	/**
	* list by Care Context returns all Spine Exam short to load into Record Browser
	*/
	public ims.generalmedical.vo.MskSpineExamFindingShortVoCollection listByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.AdmisSpineExamVo getAdmisSpineExamByCareContext(ims.core.vo.CareContextLiteVo voCareContext, ims.generalmedical.vo.MskSpineExamFindingShortVo voSpineExamFindingShort);

	// Generated from form domain interface definition
	/**
	* checks if there is a Clinical Contact of type SpinalMedicalAdission that has a Spine Exam within the CareContext, if so it will be displayed
	*/
	public ims.generalmedical.vo.AdmisSpineExamVo getMedicalAdmissionSpineExamByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);
}
