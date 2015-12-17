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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2046.20208)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import java.util.ArrayList;

import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.ocrr.vo.domain.OrderSetShortVoAssembler;

public class OrderSetListImpl extends DomainImpl implements ims.ocrr.domain.OrderSetList, ims.domain.impl.Transactional
{
	/**
	* listOrderSets
	*/
	public ims.ocrr.vo.OrderSetShortVoCollection listOrderSets(ims.ocrr.vo.OrderSetListSearchCriteriaVo searchCriteria)
	{
		DomainFactory factory = getDomainFactory();
		java.util.List ordeSets = null;
		
		String hql = " from OrderSet os "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(searchCriteria != null)
		{
			if(searchCriteria.getNameIsNotNull())
			{
				condStr.append(andStr + " upper(os.name) like :name");
	 			markers.add("name");
				values.add("%" + searchCriteria.getName().toUpperCase() + "%");
				andStr = " and ";
			}
			
			if(searchCriteria.getStatusIsNotNull())
			{
				condStr.append(andStr + " os.activeStatus = :status");
	 			markers.add("status");
				values.add(getDomLookup(searchCriteria.getStatus()));
				andStr = " and ";
			}			
		}
		
		if(condStr.length() > 0)
		{
			hql += " where ";
			hql += condStr.toString();
		}
		
		ordeSets = factory.find(hql.toString(), markers, values);		
		return OrderSetShortVoAssembler.createOrderSetShortVoCollectionFromOrderSet(ordeSets);
	}
}
