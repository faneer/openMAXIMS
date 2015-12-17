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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseTriageHistoryImpl;
import ims.emergency.domain.objects.Triage;
import ims.emergency.domain.objects.TriageProtocolAssessment;
import ims.emergency.forms.edassessmentcomponent.Logic.TriagePriorityEnum;
import ims.emergency.vo.TriageForRIETriageAssessmentVo;
import ims.emergency.vo.TriageProtocolAssessmentRefVo;
import ims.emergency.vo.TriageProtocolAssessmentShortVo;
import ims.emergency.vo.TriageProtocolAssessmentShortVoCollection;
import ims.emergency.vo.domain.TriageForRIETriageAssessmentVoAssembler;
import ims.emergency.vo.domain.TriageProtocolAssessmentShortVoAssembler;
import ims.emergency.vo.lookups.TriagePriority;
import ims.emergency.vo.lookups.TriagePriorityChange;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class TriageHistoryImpl extends BaseTriageHistoryImpl
{
	private static final long serialVersionUID = 1L;


	public TriageProtocolAssessmentShortVoCollection listTriageProtocols(PatientRefVo patient, CareContextRefVo careContext)
	{
		if (patient == null || careContext == null)
			throw new CodingRuntimeException("Parameters patient and careContext are mandatory");
		
		String query = "SELECT tp FROM TriageProtocolAssessment AS tp LEFT JOIN tp.patient AS pat LEFT JOIN tp.attendance AS attend WHERE tp.isMain = 1 AND pat.id = :PAT_ID AND attend.id = :CONTEXT_ID ORDER BY tp.assessmentDateTime DESC";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("PAT_ID");
		paramValues.add(patient.getID_Patient());
		
		paramNames.add("CONTEXT_ID");
		paramValues.add(careContext.getID_CareContext());
		
		
		return TriageProtocolAssessmentShortVoAssembler.createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(getDomainFactory().find(query, paramNames, paramValues));
	}


	public Boolean isStale(TriageProtocolAssessmentShortVo triageAssessment)
	{
		if (triageAssessment == null || triageAssessment.getID_TriageProtocolAssessment() == null)
			throw new CodingRuntimeException("Cannot get Triage Assessment on null id.");
		
		TriageProtocolAssessment protocol = (TriageProtocolAssessment) getDomainFactory().getDomainObject(TriageProtocolAssessment.class, triageAssessment.getID_TriageProtocolAssessment());

		if (protocol == null || Boolean.TRUE.equals(protocol.getIsRIE()))
		{
			return true;
		}

		return false;
	}


	public void markTriageAsRIE(TriageProtocolAssessmentShortVo triageAssessment, FormName formName, PatientRefVo patient, CareContextRefVo careContext, String messageRIE) throws StaleObjectException, DomainInterfaceException
	{
		if (triageAssessment == null || triageAssessment.getID_TriageProtocolAssessment() == null)
			throw new CodingRuntimeException("Cannot RIE the records not saved.");
		
		// Get the Triage to check if it is the current Triage Assessment
		TriageForRIETriageAssessmentVo triage = getTriage(careContext);
		
		if (triage != null)
		{
			if (triage.getInitialTriageAssessment() == null || triageAssessment.equals(triage.getInitialTriageAssessment()))
				throw new DomainInterfaceException("Cannot record in error initial triage.");
			
			if (triageAssessment.equals(triage.getCurrentTriageAssessment()))
			{
				// Get the previous triage Assessment
				TriageProtocolAssessmentShortVo previousAssessment = getPreviousProtocolAssessment(careContext, triageAssessment.getAssessmentDateTime(), triage.getCurrentTriageAssessment());
				
				if (previousAssessment == null)
					return;		// TODO - cannot RIE past the initial triage
								
				// Update current triage Assessment
				triage.setCurrentTriageAssessment(previousAssessment);
				if (triage.getInitialTriageAssessment().equals(previousAssessment))
					triage.setTriagePriorityChange(null);
				else
					triage.setTriagePriorityChange(getPriorityChange(triage.getInitialTriageAssessment().getTriagePriority(), previousAssessment.getTriagePriority()));
				triage.setCurrentTriagePriority(previousAssessment.getTriagePriority());
				
				
				getDomainFactory().save(TriageForRIETriageAssessmentVoAssembler.extractTriage(getDomainFactory(), triage));
			}
		}
		
		markAsRie(triageAssessment, formName, patient.getID_Patient(), null, careContext.getID_CareContext(), messageRIE);
	}


	private TriageProtocolAssessmentShortVo getPreviousProtocolAssessment(CareContextRefVo careContext, DateTime assessmentDateTime, TriageProtocolAssessmentRefVo currentTriageProtocol)
	{
		String query = "SELECT tp FROM TriageProtocolAssessment AS tp LEFT JOIN tp.attendance AS attend WHERE (tp.isRIE is null OR tp.isRIE = 0) AND tp.isMain = 1 AND tp.id <> :PROTOCOL_ID AND attend.id = :CONTEXT_ID AND tp.assessmentDateTime <= :PROT_DATETIME ORDER BY tp.assessmentDateTime DESC";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramNames.add("PROTOCOL_ID");			paramValues.add(currentTriageProtocol.getID_TriageProtocolAssessment());
		paramNames.add("CONTEXT_ID");			paramValues.add(careContext.getID_CareContext());
		paramNames.add("PROT_DATETIME");		paramValues.add(assessmentDateTime.getJavaDate());
		
		return TriageProtocolAssessmentShortVoAssembler.create((TriageProtocolAssessment) getDomainFactory().findFirst(query, paramNames, paramValues));
	}


	private TriagePriorityChange getPriorityChange(TriagePriority initialPriority, TriagePriority currentPriority)
	{
		if (initialPriority == null)
			return null;
		
		Integer initialPriorityOrder = getOrderByPriority(initialPriority);
		Integer currentPriorityOrder = getOrderByPriority(currentPriority);
		
		if (initialPriorityOrder == null || currentPriorityOrder == null)
			return null;
		
		int compare = initialPriorityOrder.compareTo(currentPriorityOrder);

		if (compare < 0)
			return TriagePriorityChange.PRIORITY_DECREASED;
		else if (compare > 0)
			return TriagePriorityChange.PRIORITY_ELEVATED;
		
		return TriagePriorityChange.SAME_PRIORITY;
	}


	private Integer getOrderByPriority(TriagePriority priority)
	{
		for(TriagePriorityEnum item : TriagePriorityEnum.values())
		{
			if(item.getIndex().equals(priority))
				return item.getOrder();
		}
		
		return null;
	}
	

	private TriageForRIETriageAssessmentVo getTriage(CareContextRefVo careContext)
	{
		String query = "SELECT trg FROM Triage AS trg LEFT JOIN trg.attendance AS attd WHERE attd.id = :CONTEXT_ID and (trg.isRIE is null OR trg.isRIE = 0)";
		
		return TriageForRIETriageAssessmentVoAssembler.create((Triage) getDomainFactory().findFirst(query, "CONTEXT_ID", careContext.getID_CareContext()));
	}
}
