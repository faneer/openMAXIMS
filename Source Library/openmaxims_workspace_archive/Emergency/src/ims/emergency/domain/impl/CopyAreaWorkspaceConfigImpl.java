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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.TrackingArea;
import ims.emergency.configuration.domain.objects.TrackingConfiguration;
import ims.emergency.domain.base.impl.BaseCopyAreaWorkspaceConfigImpl;
import ims.emergency.vo.TrackingAreaVo;
import ims.emergency.vo.TrackingAreaVoCollection;
import ims.emergency.vo.TrackingConfigurationVo;
import ims.emergency.vo.domain.TrackingAreaVoAssembler;
import ims.emergency.vo.domain.TrackingConfigurationVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class CopyAreaWorkspaceConfigImpl extends BaseCopyAreaWorkspaceConfigImpl
{

	private static final long serialVersionUID = 1L;

	public LocationLiteVoCollection listEmergencyDepartments()
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		//List only Emergency Department
		hql.append(" select track.eDLocation from TrackingConfiguration as track left join track.eDLocation as loc where loc.type = " + LocationType.ANE.getId()); 
		hql.append(" and loc.isActive =:active");
		hql.append(" and loc.isRIE is null");
		hql.append(" and loc.isVirtual =:virtual");
		hql.append(" order by loc.name asc ");

		List<?> locationList = factory.find(hql.toString(), new String[]{"active", "virtual"}, new Object[]{Boolean.TRUE, Boolean.FALSE});
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locationList); 
	}

	public TrackingAreaVoCollection getTrackingAreasByLocation(LocationRefVo locationRef)
	{
		if(locationRef == null)
			throw new CodingRuntimeException("Can not get Areas value on null Location.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select trackConfig.areas from TrackingConfiguration as trackConfig ");
		hql.append("where trackConfig.eDLocation.id = :locationID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"locationID"}, new Object[] {locationRef.getID_Location()});
	
		return TrackingAreaVoAssembler.createTrackingAreaVoCollectionFromTrackingArea(list);
		
	}

	public TrackingConfigurationVo getTrackingConfig(LocationRefVo locationRef)
	{
		if(locationRef == null)
			throw new CodingRuntimeException("Can not get TrackingConfiguration value on null locationID.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select trackConfig from TrackingConfiguration as trackConfig ");
		hql.append("where trackConfig.eDLocation.id = :locationID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"locationID"}, new Object[] {locationRef.getID_Location()});
		
		if (list!=null && list.size()>0)
		{
			return TrackingConfigurationVoAssembler.createTrackingConfigurationVoCollectionFromTrackingConfiguration(list).get(0);
		}
		return null;
	}

	public TrackingConfigurationVo saveTrackinConfig(TrackingConfigurationVo trackingConfigToSave, TrackingAreaVo trackingAreaToSave) throws StaleObjectException
	{
		if (trackingConfigToSave == null && trackingAreaToSave==null)

			throw new CodingRuntimeException("Cannot save TrackingConfiguration/TrackingArea if null or get TrackingConfiguration/TrackingArea on null ID . ");
		
		DomainFactory factory = getDomainFactory();
		if (trackingConfigToSave!=null)
		{
    		if (!trackingConfigToSave.isValidated())
    			throw new CodingRuntimeException("TrackingConfigurationVo not Validated");
    		
    		
    		TrackingConfiguration trackingConfig = TrackingConfigurationVoAssembler.extractTrackingConfiguration(factory,trackingConfigToSave);
    
    		factory.save(trackingConfig);
    		return TrackingConfigurationVoAssembler.create(trackingConfig);
		}	
		else if (trackingAreaToSave!=null)
		{	
			if (!trackingAreaToSave.isValidated())
				throw new CodingRuntimeException("TrackingAreaVo not Validated");
				
			TrackingArea trackingArea = TrackingAreaVoAssembler.extractTrackingArea(factory,trackingAreaToSave);

			factory.save(trackingArea);
				
			return null;		
		}
		
		return null;
	}

}
