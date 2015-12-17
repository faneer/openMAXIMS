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
public interface PatientProcedures extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* will call procedure List Impl to list procedures
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedures(String filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.PatientProcedureVoCollection listClinicalContactProcedures(ims.core.vo.ClinicalContactShortVo voClinicalContactShort, ims.core.vo.CareContextShortVo careContext);

	// Generated from form domain interface definition
	/**
	* save a procedure and add to the collection for the episode
	*/
	public ims.core.vo.PatientProcedureVo savePatientProcedure(ims.core.vo.PatientProcedureVo patientProcedure, ims.core.patient.vo.PatientRefVo voPatRefVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* pass the clinical contact and the current procedure and patient - list all the charachteristics where the insertion procedure does not match the current procedure 
	*/
	public ims.core.vo.PatientCharacteristicVoCollection listCharchteristic(ims.core.clinical.vo.PatientProcedureRefVo currentProcedureRefVo, ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	public ims.core.vo.PatientProcedureVo getPatientProcedure(ims.core.clinical.vo.PatientProcedureRefVo procedureRef);
}
