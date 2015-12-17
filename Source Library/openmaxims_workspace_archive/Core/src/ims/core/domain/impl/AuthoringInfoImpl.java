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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2379.15643)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.domain.base.impl.BaseAuthoringInfoImpl;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class AuthoringInfoImpl extends BaseAuthoringInfoImpl
{
	private static final long	serialVersionUID	= 1L;

	public HcpLiteVoCollection listHcpLiteByNameAndDisciplineType(String hcpName, HcpDisType hcpDisciplineType)
	{
		//WDEV-8356
		if (hcpName == null || hcpName.length() == 0)
			throw new DomainRuntimeException("Name not supplied");
	
		HcpAdmin hcpImpl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpImpl.listHcpLiteByNameAndDisciplineType(hcpName, hcpDisciplineType);
		/*
		HcpFilter filter = new HcpFilter();
		filter.setQueryName(new PersonName());
		filter.getQueryName().setSurname(hcpName);
		if(hcpDisciplineType != null)
			filter.setHcpType(hcpDisciplineType);

		List l = this.listHCPList(filter);
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(l);*/
	}
	
	private List listHCPList(HcpFilter filter)
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (filter == null)
			filter = new HcpFilter();

		hql = " from Hcp h ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		if (filter.getQueryName() != null)
		{
			if (filter.getQueryName().getSurname() != null && filter.getQueryName().getSurname().length() > 0)
			{
				condStr.append(" h.mos.name.upperSurname like :hcpSname");
				markers.add("hcpSname");
				values.add(filter.getQueryName().getSurname().toUpperCase() + "%");
				andStr = " and ";
			}
			if (filter.getQueryName().getForename() != null && filter.getQueryName().getForename().length() > 0)
			{
				condStr.append(andStr + " h.mos.name.upperForename like :hcpFname");
				markers.add("hcpFname");
				values.add(filter.getQueryName().getForename().toUpperCase() + "%");
				andStr = " and ";
			}
		}

		if (filter.getHcpType() != null)
		{
			//If the hcpType = HcpDisType.OTHER we must allow for that field being null or it's parent == OTHER
			if (filter.getHcpType().equals(HcpDisType.OTHER))
			{
				condStr.append(andStr + " ( h.hcpType is null or h.hcpType.parent.id =  :hcpType) ");
			}
			else
			{
				condStr.append(andStr + " h.hcpType = :hcpType");
			}
			markers.add("hcpType");
			values.add(getDomLookup(filter.getHcpType()));
			andStr = " and ";
		}
		
		condStr.append(andStr + "h.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);
		andStr = " and ";

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}

		hql += condStr.toString();
		return factory.find(hql, markers, values);
	}
	
}
