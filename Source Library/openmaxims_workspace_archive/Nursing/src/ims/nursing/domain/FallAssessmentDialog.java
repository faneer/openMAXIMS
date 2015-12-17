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

package ims.nursing.domain;

// Generated from form domain impl
public interface FallAssessmentDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves header record
	*/
	public ims.coe.vo.FallAssessment getRecord(Integer recordID) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* Save the record
	*/
	public ims.coe.vo.AssessmentMobility saveRecord(ims.coe.vo.FallAssessment fallAssessmentVo, ims.coe.vo.AssessmentMobility componentVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* true if the fall record belongs to a mobility assessment
	*/
	public Boolean isPartOfMobilityAssessment(ims.coe.vo.FallAssessment fallRecordVo) throws ims.domain.exceptions.DomainInterfaceException;
}
