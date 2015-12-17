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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ccosched.domain.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ims.ccosched.domain.Booking;
import ims.domain.DomainFactory;
import ims.domain.lookups.LookupMapping;
import ims.dto.DTODomainImplementation;
import ims.dtomove.vo.SchedActivityVoCollection;
import ims.dtomove.vo.domain.ActivityActionVoAssembler;
import ims.dtomove.vo.domain.SchedActivityVoAssembler;
import ims.vo.LookupInstVo;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

public class BookingImpl extends DTODomainImplementation implements Booking
{
 
	private static final long serialVersionUID = 1L;

	public ims.dtomove.vo.ActivityActionVoCollection listActivityActions()
	{
		DomainFactory factory = getDomainFactory();

		List<?> ptList = factory.find("from ActivityAction activact where activact.active = 'Y' order by activact.group,activact.action",1000);
		
		if(ptList == null || ptList.size() == 0)
			return null;
		
		return ActivityActionVoAssembler.createActivityActionVoCollectionFromActivityAction(ptList);
	}

	public LookupInstVo getMappings(LookupInstVo lookupInstance) 
	{
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.LookupInstance doInst = factory.getLookupInstance(lookupInstance.getId());
		Set mappings = doInst.getMappings();
		LookupMappingVoCollection mapColl = new LookupMappingVoCollection();
		Iterator iter = mappings.iterator();
		LookupMapping doMapping;
		while (iter.hasNext())
		{
			doMapping = (LookupMapping) iter.next();
			mapColl.add(new LookupMappingVo(doMapping.getExtSystem(), doMapping.getExtCode()));
		}
		mapColl.sort();
		lookupInstance.setMappings(mapColl);
		return lookupInstance;

	}

	public SchedActivityVoCollection getSchedActivities() 
	{
		DomainFactory factory = getDomainFactory();

		List<?> schList = factory.find("from SchedActivity");
		
		if(schList == null || schList.size() == 0)
			return null;
		
		return SchedActivityVoAssembler.createSchedActivityVoCollectionFromSchedActivity(schList);
	}
}
