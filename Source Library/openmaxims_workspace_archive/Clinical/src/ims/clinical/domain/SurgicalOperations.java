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
public interface SurgicalOperations extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* will call procedure List Impl to list procedures
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedures(String filterProcedure) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.PatientSurgicalOperationVoCollection listClinicalContactSurgicalOperations(ims.core.vo.ClinicalContactShortVo voClinicalContactShort);

	// Generated from form domain interface definition
	/**
	* save an operation and add to the collection for the clinical contact
	*/
	public ims.core.vo.PatientSurgicalOperationVo savePatientSurgicalOperation(ims.core.vo.PatientSurgicalOperationVo patientOperation, ims.core.patient.vo.PatientRefVo patient, ims.core.vo.CareContextShortVo careContext) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* pass the clinical contact and the current procedure - get the patient and his coreclinical and list all the charachteristics where the insertion procedure does not match the current procedure 
	*/
	public ims.core.vo.PatientCharacteristicVoCollection listCharchteristic(ims.core.patient.vo.PatientRefVo refVoPatient, ims.core.vo.PatientProcedureVo currentProcedure);

	// Generated from form domain interface definition
	public ims.core.vo.PatientSurgicalOperationVoCollection listCareContextSurgicalOperations(ims.core.admin.vo.CareContextRefVo refCareContext, Boolean bRIE);

	// Generated from form domain interface definition
	public ims.core.vo.PatientPastMedicalHistoryVo savePatientPMHRecord(ims.core.vo.PatientPastMedicalHistoryVo voPMH, ims.core.patient.vo.PatientRefVo patient) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	public ims.core.vo.PatientProcedureVoCollection listCareContextPatientProcedures(ims.core.admin.vo.CareContextRefVo refVoCareContext);
}
