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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2249.27365)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.DiagnosisComplications;
import ims.clinical.domain.PatientProblems;
import ims.clinical.domain.PatientSummary;
import ims.clinical.domain.Procedures;
import ims.clinical.domain.base.impl.BaseClinicalDiAssociationsImpl;
import ims.clinical.vo.ClinicalDIAssociationVoCollection;
import ims.clinical.vo.domain.ClinicalDIAssociationVoAssembler;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.clinical.vo.PatientProblemRefVo;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientDiagnosisShortVo;
import ims.core.vo.PatientDiagnosisShortVoCollection;
import ims.core.vo.PatientProblemVoCollection;
import ims.core.vo.domain.PatientDiagnosisShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class ClinicalDiAssociationsImpl extends BaseClinicalDiAssociationsImpl
{
	private static final long serialVersionUID = 1L;
	
	public PatientDiagnosisShortVoCollection listComplications(PatientRefVo patient) 
	{
		DiagnosisComplications impl = (DiagnosisComplications) getDomainImpl(DiagnosisComplicationsImpl.class);
		return impl.listPatientComplications(patient);		
	}
	public PatientDiagnosisShortVoCollection listDiagnosis(PatientRefVo patient) 
	{
		DiagnosisComplications impl = (DiagnosisComplications) getDomainImpl(DiagnosisComplicationsImpl.class);
		return impl.listPatientDiagnoses(patient);		
	}
	public PatientProblemVoCollection listProblems(PatientRefVo patient)
	{
		PatientProblems impl = (PatientProblems) getDomainImpl(PatientProblemsImpl.class);
		return impl.listByPatient(patient);		
	}
	public ims.core.vo.PatientProcedureShortVoCollection listProcedures(PatientRefVo patient, ims.core.vo.lookups.PatientProcedureStatus status)
	{
		Procedures impl = (Procedures) getDomainImpl(PlannedProcedureImpl.class);
		return impl.listProcedureByPatientAndStatus(patient, status);		
	}
	public ClinicalDIAssociationVoCollection listClinicalDiAssociation(PatientDiagnosisRefVo filter)  
	{
		PatientSummary impl = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return impl.listClinicalDiAssociationByPatientDiagnosis(filter);
	}
	public ClinicalDIAssociationVoCollection listClinicalDiAssociation(PatientProcedureRefVo filter) 
	{
		PatientSummary impl = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return impl.listClinicalDiAssociationByPatientProcedure(filter);
	}
	public ClinicalDIAssociationVoCollection listClinicalDiAssociation(PatientProblemRefVo filter) 
	{
		PatientSummary impl = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return impl.listClinicalDiAssociationByPatientProblem(filter);
	}
	public ClinicalDIAssociationVoCollection saveClinicalDiAssociation(ClinicalDIAssociationVoCollection list) throws StaleObjectException 
	{
		if(list == null)
			throw new RuntimeException("Cannot save null ClinicalDIAssociationVoCollection");
		if(!list.isValidated())
			throw new CodingRuntimeException("ClinicalDIAssociationVoCollection has not been validated.");
		
		DomainFactory factory = getDomainFactory();
		ClinicalDIAssociationVoCollection result = new ClinicalDIAssociationVoCollection();
		
		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x) != null)
			{
				factory.save(ClinicalDIAssociationVoAssembler.extractClinicalcdiassociations(factory, list.get(x)));
			}
		}		
		
		return result;
	}
	public PatientDiagnosisShortVo saveDiagnosis(PatientDiagnosisShortVo patientDiagnosisShortVO) throws StaleObjectException
	{
		if(patientDiagnosisShortVO == null)
			throw new RuntimeException("Cannot save null PatientDiagnosisShortVo");
		if(patientDiagnosisShortVO.isValidated() == false)
			throw new CodingRuntimeException("PatientDiagnosisShortVo has not been validated");
	
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatientDiagnosis = PatientDiagnosisShortVoAssembler.extractPatientDiagnosis(factory, patientDiagnosisShortVO);
		factory.save(doPatientDiagnosis);
		
		return PatientDiagnosisShortVoAssembler.create(doPatientDiagnosis);
	}
}
