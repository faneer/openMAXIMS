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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.60 build 2874.29117)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.domain.impl;

import java.util.List;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.configuration.vo.PathwayRefVo;
import ims.pathways.configuration.vo.TargetRefVo;
import ims.pathways.configuration.vo.TargetRefVoCollection;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.base.impl.BaseCreateNewEventImpl;
import ims.pathways.domain.objects.PatientJourneyTarget;
import ims.pathways.vo.EventTargetLiteVoCollection;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.PatientJourneyTargetVo;
import ims.pathways.vo.PatientJourneyTargetVoCollection;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.domain.EventTargetLiteVoAssembler;
import ims.pathways.vo.domain.PatientJourneyTargetVoAssembler;
import ims.pathways.vo.lookups.EventCreationTypeCollection;

public class CreateNewEventImpl extends BaseCreateNewEventImpl
{
	private static final long serialVersionUID = 1L;

	public EventTargetLiteVoCollection listEventTargetsByTypesAndTargets(EventCreationTypeCollection eventTypes, TargetRefVoCollection targets)
	{
		if(eventTypes.size() == 0 || targets.size() == 0)
			throw new CodingRuntimeException("eventTypes or targets not populated in method listEventTargetsByTypesAndTargets");
		
		String hql = " from EventTarget et " + 
				"where (et.target.id in " + "(" +  getIdString(targets) + ")" +  " and et.event.eventType.id in " + "(" +  getIdString(eventTypes) + ")" +  " and et.status = :status and et.event.status = :status )";
			
		return EventTargetLiteVoAssembler.createEventTargetLiteVoCollectionFromEventTarget(getDomainFactory().find(hql, new String[] {"status"}, new Object[] {getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)}));
	}

	private String getIdString(TargetRefVoCollection targets)
	{
		String idString = "";
		
		for(int i=0;i<targets.size();i++)
		{
			idString += targets.get(i).getID_Target();
			idString += ((targets.size() - (i+1)) > 0 ? "," : "");
		}
		
		return idString;
	}

	private String getIdString(EventCreationTypeCollection eventTypes)
	{
		String idString = "";
		
		for(int i=0;i<eventTypes.size();i++)
		{
			idString += eventTypes.getIndex(i).getID();
			idString += ((eventTypes.size() - (i+1)) > 0 ? "," : "");
		}
		
		return idString;
	}

	public PatientEventVo savePatientEvent(PatientEventVo event) throws DomainInterfaceException,StaleObjectException
	{
		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
		return impl.instantiatePatientEvent(event);
	}

	public PatientJourneyTargetVo getPatientJourneyTarget(PatientPathwayJourneyRefVo journey, TargetRefVo target)
	{
		DomainFactory factory = getDomainFactory();
		
		// wdev-4066 - remove achievedDate check
		String hql = "select pjt from PatientJourneyTarget as pjt left join pjt.pathwayTarget as pt left join pt.target as target left join pjt.currentStatus as cs " + 
				"where (pjt.pathwayJourney.id = :idJourney and target.id = :idTarget)";
			
		List pjts = factory.find(hql, new String[] {"idJourney","idTarget"}, new Object[] {journey.getID_PatientPathwayJourney(), target.getID_Target()});
		if(pjts != null && pjts.size() > 0)
			return PatientJourneyTargetVoAssembler.create((PatientJourneyTarget) pjts.get(0));
			
		return null;
	}

	public PatientJourneyTargetVoCollection listCurrentPathwayJourneyTargets(PatientPathwayJourneyRefVo journey, PathwayRefVo pathway)
	{
		return PatientJourneyTargetVoAssembler.createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(listCurrentPathwayJourneyTargets( getDomainFactory(), journey, pathway));
	}
	
	private List listCurrentPathwayJourneyTargets(DomainFactory factory, PatientPathwayJourneyRefVo profile, PathwayRefVo pathway)
	{
		return factory.find(" from PatientJourneyTarget pt where pt.pathwayJourney.id = " + profile.getID_PatientPathwayJourney());
	}
}
