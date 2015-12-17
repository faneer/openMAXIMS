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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.62 build 2929.28798)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;
import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.clinical.domain.base.impl.BaseDemoReferralListImpl;
import ims.clinical.domain.objects.ReferralsRecording;
import ims.clinical.vo.ReferralsRecordingListVo;
import ims.clinical.vo.ReferralsRecordingListVoCollection;
import ims.clinical.vo.ReferralsRecordingRefVo;
import ims.clinical.vo.ReferralsRecordingShortVo;
import ims.clinical.vo.domain.ReferralsRecordingListVoAssembler;
import ims.clinical.vo.domain.ReferralsRecordingShortVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.utils.Date;

public class DemoReferralListImpl extends BaseDemoReferralListImpl
{

	private static final long serialVersionUID = 1L;

	public MemberOfStaffLiteVoCollection listActiveMosByName(String name)
	{
		MosAdmin mosAdminIml = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdminIml.listActiveMosByName(name);
	}
	
	public ReferralsRecordingListVoCollection listByCriteria(ReferralsRecordingListVo filter, Date dateFrom, Date dateTo)
	{
		DomainFactory factory = getDomainFactory();
		
		IMSCriteria criteria = new IMSCriteria(ReferralsRecording.class, factory);
		
		/*if (filter.getSpecialtyFunctionCodeIsNotNull())
		{
			criteria.equal("specialtyFunctionCode.id", filter.getSpecialtyFunctionCode().getID());
		}*/
		if (filter.getDisciplineIsNotNull())
		{
			criteria.equal("discipline.id", filter.getDiscipline().getID());
		}
		if (filter.getReferralStatusIsNotNull())
		{
			criteria.equal("referralStatus.id", filter.getReferralStatus().getID());
		}
		if (filter.getReferralSourceIsNotNull())
		{
			criteria.equal("referralSource.id", filter.getReferralSource().getID());
		}
		if (filter.getReferralHCPIsNotNull())
		{
			criteria.equal("referralHCP.id", filter.getReferralHCP().getID_MemberOfStaff());
		}
		/*if (dateFrom != null && dateTo != null)
		{
			criteria.between("dateSent", dateFrom.getDate(), dateTo.getDate());
		}*/
		List lst = criteria.find();
		return (ReferralsRecordingListVoAssembler.createReferralsRecordingListVoCollectionFromReferralsRecording(lst)).sort();
	}

	public CareContextShortVo getCareContext(CareContextRefVo voRef)
	{
		if(voRef == null || voRef.getID_CareContext() == null)
		{
			throw new DomainRuntimeException("Invalid record");
		}
		
		DomainFactory factory = getDomainFactory();
		CareContext domainRecord = (CareContext)factory.
			getDomainObject(CareContext.class, voRef.getID_CareContext().intValue());
		
		return CareContextShortVoAssembler.create(domainRecord);	
	}

	public ReferralsRecordingShortVo getReferralsRecording(ReferralsRecordingRefVo voRef)
	{
		if(voRef == null || voRef.getID_ReferralsRecording() == null)
		{
			throw new DomainRuntimeException("Invalid record");
		}
		
		DomainFactory factory = getDomainFactory();
		ReferralsRecording domainRecord = (ReferralsRecording)factory.
			getDomainObject(ReferralsRecording.class, voRef.getID_ReferralsRecording().intValue());
		
		return ReferralsRecordingShortVoAssembler.create(domainRecord);	
	}	
}
