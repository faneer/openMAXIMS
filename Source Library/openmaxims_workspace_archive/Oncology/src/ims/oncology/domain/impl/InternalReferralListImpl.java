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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3915.24993)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.oncology.domain.impl;

import ims.core.domain.Demographics;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.oncology.domain.base.impl.BaseInternalReferralListImpl;
import ims.oncology.vo.domain.InternalReferralListVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class InternalReferralListImpl extends BaseInternalReferralListImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.InternalReferralListVoCollection listReferrals(ims.oncology.vo.InternalReferralListFilterVo filterVo)
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql = " from InternalReferral IR "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = "";
		
		if (filterVo.getActiveOnlyIsNotNull()
			&& filterVo.getActiveOnly())
		{
			condStr.append(" (IR.referralSeen = null or IR.referralSeen = :isSeen)");
			markers.add("isSeen");
			values.add(Boolean.FALSE);
			andStr = " and ";
		}
	
		if (filterVo.getReferralTypeIsNotNull())
		{
			condStr.append(andStr + " IR.referralType = :reftype");
			markers.add("reftype");
			values.add(getDomLookup(filterVo.getReferralType()));
			andStr = " and ";
		}
		if (filterVo.getReferredByIsNotNull())
		{
			condStr.append(andStr + " IR.referredBy.id = :cons");
			markers.add("cons");
			values.add(filterVo.getReferredBy().getID_Hcp());
			andStr = " and ";
		}
		if (filterVo.getDateFromIsNotNull() && filterVo.getDateToIsNotNull())
		{
			condStr.append(andStr + " ( IR.referralDate between :fromdate and :todate )");
			markers.add("fromdate");
			values.add(filterVo.getDateFrom().getDate());
			markers.add("todate");
			values.add(filterVo.getDateTo().getDate());
			andStr = " and ";
		}
		else if (filterVo.getDateFromIsNotNull() && filterVo.getDateTo() == null)
		{
			condStr.append(andStr + " ( IR.referralDate >= :fromdate ) ");
			markers.add("fromdate");
			values.add(filterVo.getDateFrom().getDate());
			andStr = " and ";
			
		}
		else if (filterVo.getDateFrom() == null && filterVo.getDateToIsNotNull())
		{
			condStr.append(andStr + " ( IR.referralDate  <= :todate) ");
			markers.add("todate");
			values.add(filterVo.getDateTo().getDate());
			andStr = " and ";
		}

		condStr.append(andStr + " IR.status  = :statAct) ");
		markers.add("statAct");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		andStr = " and ";

		hql += " where ";
		
		hql += condStr.toString();
		List IRs = factory.find(hql, markers, values);
		
		return InternalReferralListVoAssembler.createInternalReferralListVoCollectionFromInternalReferral(IRs).sort();
	}

	public PatientShort getPatientShort(PatientRefVo patientRefVo) 
	{
		Demographics impl = (Demographics)getDomainImpl(DemographicsImpl.class);
		return impl.getPatient(patientRefVo);
	}
}
