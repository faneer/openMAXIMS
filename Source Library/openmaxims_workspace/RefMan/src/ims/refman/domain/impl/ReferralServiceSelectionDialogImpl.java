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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseReferralServiceSelectionDialogImpl;
import ims.core.vo.ServiceShortVoCollection;
import ims.core.vo.domain.ServiceShortVoAssembler;
import ims.core.vo.lookups.ServiceCategory;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;

import java.util.ArrayList;
import java.util.List;

public class ReferralServiceSelectionDialogImpl extends BaseReferralServiceSelectionDialogImpl
{
	private static final long serialVersionUID = 1L;

	public ServiceShortVoCollection getReferralServices(String serviceName, Specialty specialty)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hqlJoins = new StringBuffer("select s from ReferralService rs left join rs.referralServices as s left join s.specialty as ss ");
		StringBuffer hql = new StringBuffer(" ");
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if(serviceName != null)
		{
			hql.append(" s.upperName like :ServiceName ");
			markers.add("ServiceName");
			values.add(serviceName.toUpperCase() + "%");
			andStr = " and ";
		}
		
		if (specialty != null)
		{
			hql.append(andStr + " ss.id = :SpecId");
			markers.add("SpecId");
			values.add(specialty.getID());
			andStr = " and ";
		}
		
		if (markers.size() > 0)
			hql.insert(0, " where ");
		
		hql.append( " order by s.upperName asc" );
		
		List<?> list = factory.find(hqlJoins.append(hql.toString()).toString(), markers, values);
		
		return ServiceShortVoAssembler.createServiceShortVoCollectionFromService(list);
	}

	public ServiceShortVoCollection getServicesForCategory(String serviceName, Specialty specialty, ServiceCategory category)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer("select serv from Service as serv left join serv.serviceCategory as servCateg left join serv.specialty as spec where serv.isActive = 1 ");
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(serviceName != null)
		{
			hql.append(" and serv.upperName like :serviceName ");
			markers.add("serviceName");
			values.add(serviceName.toUpperCase() + "%");
		}
		
		if (specialty != null)
		{
			hql.append( " and spec.id = :specId ");
			markers.add("specId");
			values.add(specialty.getID());
		}
		
		if (category != null)
		{
			hql.append( " and servCateg.id = :serviceCategoryID ");
			markers.add("serviceCategoryID");
			values.add(category.getID());
		}
		
		hql.append( " order by serv.upperName asc" );
		
		return ServiceShortVoAssembler.createServiceShortVoCollectionFromService(factory.find(hql.toString(), markers, values));
	}
}
