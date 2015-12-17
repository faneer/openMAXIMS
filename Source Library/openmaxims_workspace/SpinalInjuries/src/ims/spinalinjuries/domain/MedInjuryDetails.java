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
public interface MedInjuryDetails extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Get the current Injury Details Record for the Clinical Contact 
	*/
	public ims.generalmedical.vo.InjuryDetailsVoCollection getInjuryDetailsByMedicalAdmissionClinicalContact(ims.core.admin.vo.ClinicalContactRefVo voClinicalContactRef);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.InjuryDetailsVo saveInjuryDetails(ims.generalmedical.vo.InjuryDetailsVo injuryDetails) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list medics
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* get the current List of Problems Identified in the Root Contact
	*/
	public ims.generalmedical.vo.MedicalProbOnAdmisVoCollection getProblems(ims.core.vo.CareContextShortVo careContext);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MedicalProbOnAdmisVoCollection saveProblemsOnAdmis(ims.generalmedical.vo.MedicalProbOnAdmisVoCollection collProblemsOnAdmis) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get Injury Details By Care Context
	*/
	public ims.generalmedical.vo.InjuryDetailsVoCollection getInjuryDetailsByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MedicalProbOnAdmisVoCollection saveProblemOnAdmisAsRie(ims.generalmedical.vo.MedicalProbOnAdmisVoCollection problemColl) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MedicalProbOnAdmisVoCollection getRIEProblems(ims.core.vo.CareContextShortVo careContext);
}
