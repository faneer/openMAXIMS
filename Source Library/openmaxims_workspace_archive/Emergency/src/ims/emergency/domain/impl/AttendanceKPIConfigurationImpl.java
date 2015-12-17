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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import java.util.List;

import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.emergency.configuration.domain.objects.AttendanceKPIConfig;
import ims.emergency.configuration.domain.objects.ClinicianNoteDefaultTextConfig;
import ims.emergency.domain.AttendanceKPIConfiguration;
import ims.emergency.domain.base.impl.BaseAttendanceKPIConfigurationImpl;
import ims.emergency.vo.AttendanceKPIConfigVoCollection;
import ims.emergency.vo.domain.AttendanceKPIConfigVoAssembler;
import ims.emergency.vo.domain.ClinicianNoteDefaultTextConfigVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class AttendanceKPIConfigurationImpl extends BaseAttendanceKPIConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocationLiteVoCollection listLocations()
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		//List only Emergency Department
		hql.append(" from Location loc where loc.type = " + LocationType.ANE.getId()); 
		hql.append(" and loc.isActive =:active");
		hql.append(" and loc.isRIE is null");
		hql.append(" and loc.isVirtual =:virtual");
		hql.append(" order by loc.name asc"); 

		List locationList = factory.find(hql.toString(), new String[]{"active", "virtual"}, new Object[]{Boolean.TRUE, Boolean.FALSE});
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locationList); 
	}

	public ims.emergency.vo.AttendanceKPIConfigVo getAttendanceKPIConfigVo(ims.core.resource.place.vo.LocationRefVo locRef)
	{
		if( locRef == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select a1_1 from AttendanceKPIConfig as a1_1 left join a1_1.eDLocation as l1_1 where	(l1_1.id = :idLocation)";
		 
		
		List locs = factory.find(hsql, new String[] {"idLocation"}, new Object[] {locRef.getID_Location()});
		if(locs!= null && locs.size() > 0)
		{
			AttendanceKPIConfigVoCollection tempCol = AttendanceKPIConfigVoAssembler.createAttendanceKPIConfigVoCollectionFromAttendanceKPIConfig(locs);
			if( tempCol != null && tempCol.size() > 0)
				return tempCol.get(0);
		}
		return null;
	}

	public ims.emergency.vo.AttendanceKPIConfigVo saveAttendanceKPIConfig(ims.emergency.vo.AttendanceKPIConfigVo record) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (record == null)
			throw new CodingRuntimeException("Cannot save null AttendanceKPIConfigVo");

		DomainFactory factory = getDomainFactory();
				
		AttendanceKPIConfig doAttendanceKPIConfig = AttendanceKPIConfigVoAssembler.extractAttendanceKPIConfig(factory, record);

		try
		{
			factory.save(doAttendanceKPIConfig);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException();
		}

		return AttendanceKPIConfigVoAssembler.create(doAttendanceKPIConfig);
	}
	
}
