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

package ims.clinical.domain;

// Generated from form domain impl
public interface ExtendedCarePlanClinicalNotes extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Gets the Clinical Notes Details for the given Clinical Note ID
	*/
	public ims.nursing.vo.NursingClinicalNotesVo getClinicalNotes(ims.core.vo.ClinicalNotesVo clinicalNoteVo);

	// Generated from form domain interface definition
	/**
	* Saves Clinical Note Details
	*/
	public ims.nursing.vo.NursingClinicalNotesVo saveClinicalNotes(ims.nursing.vo.NursingClinicalNotesVo notesVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Lists careplans for an episode 
	*/
	public ims.nursing.vo.CarePlanTitleCollection listCarePlans(ims.core.vo.CareContextShortVo careContextShortVo);

	// Generated from form domain interface definition
	/**
	* Return mappings for a Lookup Instance
	*/
	public ims.vo.LookupInstVo getMappings(ims.vo.LookupInstVo instance);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVo getHCPLite(ims.core.vo.MemberOfStaffShortVo mos);

	// Generated from form domain interface definition
	public ims.core.vo.MemberOfStaffVo getMemberOfStaff(ims.core.vo.MemberOfStaffShortVo mos);
}
