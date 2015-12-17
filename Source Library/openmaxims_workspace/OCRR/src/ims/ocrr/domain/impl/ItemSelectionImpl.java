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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2042.23312)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.core.resource.place.vo.LocationRefVo;
import ims.core.resource.place.vo.LocationRefVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.ocrr.vo.InvestShortVoCollection;
import ims.ocrr.vo.domain.InvestShortVoAssembler;
import ims.ocrr.vo.domain.OrderSetShortVoAssembler;
import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.InvestigationOrderability;

import java.util.ArrayList;
import java.util.List;

public class ItemSelectionImpl extends DomainImpl implements ims.ocrr.domain.ItemSelection, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	/**
	* lists all investigation using the name filter
	*/
	public ims.ocrr.vo.InvestShortVoCollection listInvestigationsOrProfiles(Category category, String name, LocationLiteVo location, ServiceShortVo service, Boolean isProfile, Boolean noAddOns, Boolean noRequiresSite, Boolean noSeperateOrder, Boolean excludeForProfile, Boolean beginsWith, LocationRefVoCollection locationList)
	{	
		DomainFactory factory = getDomainFactory();
		
		String hql = "select distinct inv from Investigation inv "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " where ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(name != null)
		{
			name.replaceAll("%", "");
			
			//synonymn
			condStr.append(" left join inv.investigationIndex.synonyms as syn where ( syn.upperName like :name and syn.activeStatus = :synActiveStatus");
			andStr = " or ";
			condStr.append(andStr + " inv.investigationIndex.upperName like :name");
			markers.add("name");
			markers.add("synActiveStatus");
			if(beginsWith != null)
				values.add(!beginsWith ? "%" + name.toUpperCase() + "%" : name.toUpperCase() + "%");
			else
				values.add(name.toUpperCase() + "%");
			
			values.add(Boolean.TRUE);
			condStr.append(" ) ");
			andStr = " and ";		
		}
		
		if(category != null)
		{
			condStr.append(andStr + " inv.investigationIndex.category = :category");
 			markers.add("category");
			values.add(getDomLookup(category));
			andStr = " and ";	
		}
		
		if(location != null)
		{
 			markers.add("locationId");
			values.add(location.getID_Location());
			condStr.append(andStr +  " inv.providerService.locationService.location.id = :locationId ");
			andStr = " and ";	
		}
		else if (locationList != null)
		{
			//WDEV-10065 - if there are no locations for the selected referral contract return no investigations
			if(locationList.size() == 0)
				return new InvestShortVoCollection();
			
			List<String> locationIds = new ArrayList<String>();
			for(LocationRefVo voRef : locationList)
				locationIds.add(voRef.getID_Location().toString());
		
			condStr.append(andStr +  " inv.providerService.locationService.location.id in (" + getIdString(locationIds) + ")");	
			andStr = " and ";	
		}
		if(service != null)
		{
			condStr.append(andStr + " inv.providerService.locationService.service.id = :serviceId");
 			markers.add("serviceId");
			values.add(service.getID_Service());
			andStr = " and ";		
		}
		if(isProfile != null)
		{
			condStr.append(andStr + " inv.investigationIndex.isProfile = :isProfile");
 			markers.add("isProfile");
			values.add(isProfile);
			andStr = " and ";		
		}
		if(noRequiresSite != null && noRequiresSite.booleanValue())
		{
			condStr.append(andStr + " inv.investigationIndex.requiresSiteSpecifier = :isRequire");
 			markers.add("isRequire");
			values.add(Boolean.FALSE);
			andStr = " and ";	
		}
		
		
		if(excludeForProfile != null && excludeForProfile.booleanValue() == true)
		{
			if(noAddOns != null && noAddOns.booleanValue())
			{
				condStr.append(andStr + " inv.isAddon = :isAddon");
	 			markers.add("isAddon");
				values.add(Boolean.FALSE);
				andStr = " and ";	
			}
			if(noSeperateOrder != null && noSeperateOrder.booleanValue())
			{
				condStr.append(andStr + " inv.separateOrder = :isSep");
	 			markers.add("isSep");
				values.add(Boolean.FALSE);
				andStr = " and ";	
			}
		}
				
		condStr.append(andStr + " inv.investigationIndex.activeStatus = :activeStatusIndex");
		markers.add("activeStatusIndex");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		andStr = " and ";		

		condStr.append(andStr + " inv.activeStatus = :activeStatus");
		markers.add("activeStatus");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		
		condStr.append(andStr + " (inv.investigationIndex.orderability != :orderAbility or inv.investigationIndex.orderability = null)");
		markers.add("orderAbility");
		values.add(getDomLookup(InvestigationOrderability.RESULTONLY));

		hql += condStr.toString();
		return InvestShortVoAssembler.createInvestShortVoCollectionFromInvestigation(factory.find(hql,markers,values)).sort();
	}

	private String getIdString(List<String> invIds)
	{
		String idString = "";

		for (int i = 0; i < invIds.size(); i++)
		{
			idString += invIds.get(i).toUpperCase();
			idString += ((invIds.size() - (i + 1)) > 0 ? "," : "");
		}

		return idString;
	}

	/**
	* lists order sets by name
	*/
	public ims.ocrr.vo.OrderSetShortVoCollection listOrderSets(String name)
	{		
		if(name == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		java.util.List ordersets = null;
		
		ordersets = factory.find("from OrderSet os where upper(os.name) like :name and os.activeStatus = :idActive"  , new String[] {"name","idActive"}, new Object[] {"%" + name.toUpperCase() + "%",getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)});
		
		return OrderSetShortVoAssembler.createOrderSetShortVoCollectionFromOrderSet(ordersets);
	}
}
