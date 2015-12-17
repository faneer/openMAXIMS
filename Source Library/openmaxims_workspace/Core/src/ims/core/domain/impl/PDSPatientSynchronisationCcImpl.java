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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5207.10654)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.PDSDemographics;
import ims.core.domain.PatientMergeDemographics;
import ims.core.domain.base.impl.BasePDSPatientSynchronisationCcImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.vo.domain.PatientPDSMergeVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

public class PDSPatientSynchronisationCcImpl extends BasePDSPatientSynchronisationCcImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.PatientPDSMergeVo getPDSPatient(ims.core.patient.vo.PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("The argument cannot be null");
		Patient patientDO = (Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient());
		return PatientPDSMergeVoAssembler.create(patientDO);
	}

	public ims.core.vo.PatientPDSMergeVo getLPIPatient(ims.core.patient.vo.PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("The argument cannot be null");
		Patient patientDO = (Patient) getDomainFactory().getDomainObject(Patient.class, patientRef.getID_Patient());
		return PatientPDSMergeVoAssembler.create(patientDO);
	}

	public ims.core.vo.Patient getResultPatient(ims.core.patient.vo.PatientRefVo patientRef)
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		return impl.getPatient(patientRef);
	}

	public Boolean isGPLinkedToSurgery(ims.core.resource.people.vo.GpRefVo gpRef, ims.core.resource.place.vo.LocationRefVo surgeryRef)
	{
		PatientMergeDemographics impl = (PatientMergeDemographics) getDomainImpl(PatientMergeDemographicsImpl.class);
		
		return impl.checkIfGPIsLinkedToSurgery(gpRef, surgeryRef);
	}

	@Override
	public ims.core.vo.Patient savePatient(ims.core.vo.Patient patient, Boolean fromInterface) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		
		return impl.savePatient(patient, fromInterface, true);
	}
}
