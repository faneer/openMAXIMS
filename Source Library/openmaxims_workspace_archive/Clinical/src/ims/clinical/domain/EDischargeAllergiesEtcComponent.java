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

package ims.clinical.domain;

// Generated from form domain impl
public interface EDischargeAllergiesEtcComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* lists patient allergies, filtering by patient and active status
	*/
	public ims.core.vo.PatientAllergyEDischargeVoCollection listPatientAllergies(ims.core.vo.PatientShort patient, Boolean active);

	// Generated from form domain interface definition
	/**
	* saves a patient allergy
	*/
	public ims.core.vo.PatientAllergyEDischargeVo savePatientAllergy(ims.core.vo.PatientAllergyEDischargeVo voPatientAllergy) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Lists Allergen Type Reactions
	*/
	public ims.core.vo.AllergenTypeReactionsCollection listAllergenTypeReactions(ims.core.vo.lookups.AllergenType voAllergenType);

	// Generated from form domain interface definition
	/**
	* Gets a single PatientAllerge based on a PatientAllergy ID value. 
	*/
	public ims.core.vo.PatientAllergyEDischargeVo getpatientAllergy(Integer patientAllergyID);

	// Generated from form domain interface definition
	/**
	* Retrieves a Patient Specific List of Alerts
	*/
	public ims.core.vo.PatientAlertEDischargeVoCollection listPatientAlerts(ims.core.vo.PatientShort patient, Boolean active);

	// Generated from form domain interface definition
	/**
	* Saves a Patient Alert
	*/
	public ims.core.vo.PatientAlertEDischargeVo savePatientAlert(ims.core.vo.PatientAlertEDischargeVo patientAlertItem) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* getPatientAlert
	*/
	public ims.core.vo.PatientAlertEDischargeVo getPatientAlert(ims.core.clinical.vo.PatientAlertRefVo patientalertRefVo);
}
