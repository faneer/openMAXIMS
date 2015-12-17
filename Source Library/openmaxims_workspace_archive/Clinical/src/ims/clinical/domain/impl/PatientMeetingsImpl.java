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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.51 build 2469.26857)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BasePatientMeetingsImpl;
import ims.clinical.domain.objects.PatientMeeting;
import ims.clinical.vo.PatientMeetingLiteVoCollection;
import ims.clinical.vo.PatientMeetingVo;
import ims.clinical.vo.domain.PatientMeetingLiteVoAssembler;
import ims.clinical.vo.domain.PatientMeetingVoAssembler;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

public class PatientMeetingsImpl extends BasePatientMeetingsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* lists GoalPlanningMeetings 
	*/
	public PatientMeetingLiteVoCollection lisPatientMeetingsForCareContext(ims.core.admin.vo.CareContextRefVo voRefCareContext)
	{
		DomainFactory factory = getDomainFactory();				
		String hql = " from PatientMeeting m where m.careContext.id = " + voRefCareContext.getID_CareContext();
		List lstPatientMeetings = factory.find(hql);				
		return PatientMeetingLiteVoAssembler.createPatientMeetingLiteVoCollectionFromPatientMeeting(lstPatientMeetings).sort();
	}

	public ims.clinical.vo.PatientMeetingVo getPatientMeeting(ims.clinical.vo.PatientMeetingLiteVo voLitePatientMeeting)
	{
		DomainFactory factory = getDomainFactory();
		PatientMeeting doPatientMeeting = (PatientMeeting) factory.getDomainObject(PatientMeeting.class, voLitePatientMeeting.getID_PatientMeeting());
		return PatientMeetingVoAssembler.create(doPatientMeeting);
	}

	/**
	* savePatientMeetingVo
	*/
	public PatientMeetingVo savePatientMeetingVo(PatientMeetingVo voPatientMeeting) throws StaleObjectException 
	{
		if (!voPatientMeeting.isValidated())
			throw new DomainRuntimeException("This Patient Meeting has not been validated");

		DomainFactory factory = getDomainFactory();
		PatientMeeting domPatientMeeting = PatientMeetingVoAssembler.extractPatientMeeting(factory, voPatientMeeting);		
		factory.save(domPatientMeeting);		
		return PatientMeetingVoAssembler.create(domPatientMeeting);
	}

	public HcpLiteVoCollection listHcpLiteVoByName(String hcpName) 
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);
	}




}
