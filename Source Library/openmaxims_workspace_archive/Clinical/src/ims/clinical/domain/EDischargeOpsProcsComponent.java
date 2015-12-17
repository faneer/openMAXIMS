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
public interface EDischargeOpsProcsComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* will call procedure List Impl to list procedures
	*/
	public ims.core.vo.PatientProcedureProcsComponentLiteVoCollection listProcedures(ims.core.admin.vo.CareContextRefVo careContext) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* save a procedure and add to the collection for the episode
	*/
	public ims.core.vo.PatientProcedureProcsComponentVo savePatientProcedure(ims.core.vo.PatientProcedureProcsComponentVo patientProcedure, ims.core.patient.vo.PatientRefVo voPatRefVo, ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo summary) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.PatientProcedureProcsComponentVo getProcedure(ims.core.clinical.vo.PatientProcedureRefVo procedure);

	// Generated from form domain interface definition
	public void saveProcedures(ims.core.vo.PatientProcedureProcsComponentLiteVoCollection procedures, ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo summary) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.CareContextVo getCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVo getHcp(ims.vo.interfaces.IMos iMos);

	// Generated from form domain interface definition
	public void rieProcedure(ims.core.vo.PatientProcedureProcsComponentLiteVo proc, ims.framework.FormName formName, Integer patientId, Integer contactId, Integer careContextId, String rieMessage, ims.edischarge.vo.SummaryRefVo summary) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo getEDischargeSummary(ims.edischarge.vo.SummaryRefVo summary);

	// Generated from form domain interface definition
	public ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo saveEDischargeSummary(ims.clinical.vo.EDischargeSTHKSummaryForProcComponentVo summary) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.SurgicalOperationNotesShortVo getSurgicalOperationNotesShort(ims.core.admin.vo.CareContextRefVo careContextRef);
}
