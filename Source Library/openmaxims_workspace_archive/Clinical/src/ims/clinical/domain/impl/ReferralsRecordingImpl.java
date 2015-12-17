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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.52 build 2497.19681)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.MosAdminImpl;
import ims.clinical.domain.base.impl.BaseReferralsRecordingImpl;
import ims.clinical.domain.objects.ReferralsRecording;
import ims.clinical.vo.ReferralsRecordingRefVo;
import ims.clinical.vo.ReferralsRecordingShortVoCollection;
import ims.clinical.vo.ReferralsRecordingVo;
import ims.clinical.vo.domain.ReferralsRecordingShortVoAssembler;
import ims.clinical.vo.domain.ReferralsRecordingVoAssembler;
import ims.clinical.vo.lookups.ReferralCategory;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class ReferralsRecordingImpl extends BaseReferralsRecordingImpl
{

	private static final long serialVersionUID = 1L;
	
	public HcpCollection listHcps(String value) {
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		HcpFilter hcpFilter = new HcpFilter();
		PersonName personName = new PersonName();
		personName.setSurname(value);
		hcpFilter.setQueryName(personName);
		return hcpAdmin.listHCPs(hcpFilter);
	}

	public ReferralsRecordingVo save(ReferralsRecordingVo record) throws StaleObjectException 
	{	
		if(record == null)
		{
			throw new DomainRuntimeException("Invalid record");
		}
		if(!record.isValidated())
		{
			throw new CodingRuntimeException("Record not validated");
		}
			
		DomainFactory factory = getDomainFactory();
		ReferralsRecording domainRecord = ReferralsRecordingVoAssembler.extractReferralsRecording(factory, record);		
		
		factory.save(domainRecord);
			
		return ReferralsRecordingVoAssembler.create(domainRecord);
	}
	
	public ReferralsRecordingShortVoCollection list(CareContextRefVo careContext)
	{
		return ReferralsRecordingShortVoAssembler.createReferralsRecordingShortVoCollectionFromReferralsRecording(
				getDomainFactory().find("from ReferralsRecording as ref where ref.careContext.id = :CARE_CONTEXT and ref.referralCategory = :REF_CAT", 
						new String[] {"CARE_CONTEXT", "REF_CAT"}, new Object[] {careContext.getID_CareContext(), getDomLookup(ReferralCategory.FURTHERREFERRAL)}));
	}
	
	public ReferralsRecordingVo get(ReferralsRecordingRefVo record) 
	{
		if(record == null || record.getID_ReferralsRecording() == null)
		{
			throw new DomainRuntimeException("Invalid record");
		}
		
		DomainFactory factory = getDomainFactory();
		ReferralsRecording domainRecord = (ReferralsRecording)factory.getDomainObject
					(ReferralsRecording.class, record.getID_ReferralsRecording().intValue());
		
		return ReferralsRecordingVoAssembler.create(domainRecord);
		
	}

	public LocShortVoCollection listLocationsForMemberOfStaff(MemberOfStaffRefVo mos) {
		MosAdmin impl =  (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return impl.listLocationsForMemberOfStaff(mos);
	}

}
