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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import java.util.ArrayList;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.domain.base.impl.BaseBringStagePhaseIntoScopeImpl;
import ims.icp.helper.PatientICPDomainHelper;
import ims.icp.helper.PatientICPHelperInterface;
import ims.icp.vo.ICPPhase_StatusChangeVo;
import ims.icp.vo.ICPStage_StatusChangeVo;
import ims.icp.vo.PatientICPPhase_StatusChangeVo;
import ims.icp.vo.PatientICPStage_StatusChangeVo;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.vo.PatientICPRefVo;

public class BringStagePhaseIntoScopeImpl extends BaseBringStagePhaseIntoScopeImpl
{

	private static final long serialVersionUID = 1L;

	public ims.icp.vo.PatientICP_StatusChangeVo getPatientICP(ims.icps.instantiation.vo.PatientICPRefVo patientICP)
	{
		if (patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("Parameter patientICP must not be null.");
		
		PatientICPHelperInterface helper = (PatientICPHelperInterface) getDomainImpl(PatientICPDomainHelper.class);
		
		return helper.getPatientICPBringStagePhaseIntoScope(patientICP);
	}

	public void bringStagesIntoScope(PatientICPRefVo patientICP, ArrayList<Object> stages) throws StaleObjectException
	{
		// Check ICP parameter
		if (patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("ERROR");
		
		// Check collection for stages
		if (stages == null)
			throw new CodingRuntimeException("ERROR");
		
		
		DomainFactory factory = getDomainFactory();
		
		
		// Get Patient ICP domain object
		PatientICP domainPatientICP = (PatientICP) factory.getDomainObject(PatientICP.class, patientICP.getID_PatientICP());
		
		// Check version for stale
		if (patientICP.getVersion_PatientICP() != domainPatientICP.getVersion())
			throw new StaleObjectException(domainPatientICP);
		
		
		// Execute bring into scope for collection elements
		for (int i = 0; i < stages.size(); i++)
		{
			Object value = stages.get(i);
			
			if (value instanceof PatientICPStage_StatusChangeVo)
			{
				domainPatientICP.bringStageIntoScope(factory, null, ((PatientICPStage_StatusChangeVo)value).getStage().getID_ICPStage().toString());
			}
			else if (value instanceof ICPStage_StatusChangeVo)
			{
				domainPatientICP.bringStageIntoScope(factory, null, ((ICPStage_StatusChangeVo)value).getID_ICPStage().toString());
			}
		}

		// Commit to database
		factory.save(domainPatientICP);
	}

	public void bringPhasesIntoScope(PatientICPRefVo patientICP, ArrayList<Object> phases) throws StaleObjectException
	{
		// Check ICP parameter
		if (patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("ERROR");
		
		// Check collection for stages
		if (phases == null)
			throw new CodingRuntimeException("ERROR");
		
		
		DomainFactory factory = getDomainFactory();
		
		
		// Get Patient ICP domain object
		PatientICP domainPatientICP = (PatientICP) factory.getDomainObject(PatientICP.class, patientICP.getID_PatientICP());
		
		// Check version for stale
		if (patientICP.getVersion_PatientICP() != domainPatientICP.getVersion())
			throw new StaleObjectException(domainPatientICP);
		
		// Execute bring into scope for collection elements
		for (int i = 0; i < phases.size(); i++)
		{
			Object value = phases.get(i);

			if (value instanceof PatientICPPhase_StatusChangeVo)
			{
				domainPatientICP.bringPhaseIntoScope(factory, null, ((PatientICPPhase_StatusChangeVo)value).getPhase().getID_ICPPhase().toString());
			}
			else if (value instanceof ICPPhase_StatusChangeVo)
			{
				domainPatientICP.bringPhaseIntoScope(factory, null, ((ICPPhase_StatusChangeVo)value).getID_ICPPhase().toString());
			}
		}

		// Commit to database
		factory.save(domainPatientICP);
	}
}
