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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.WhiteBoardConfig;
import ims.emergency.configuration.vo.TrackingAreaRefVo;
import ims.emergency.configuration.vo.WhiteBoardOtherActionsRefVo;
import ims.emergency.domain.base.impl.BaseEDWhiteboardConfigurationImpl;
import ims.emergency.vo.TrackingAreaLiteVoCollection;
import ims.emergency.vo.WhiteBoardConfigVo;
import ims.emergency.vo.WhiteBoardConfigVoCollection;
import ims.emergency.vo.domain.TrackingAreaLiteVoAssembler;
import ims.emergency.vo.domain.WhiteBoardConfigVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class EDWhiteboardConfigurationImpl extends BaseEDWhiteboardConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocationLiteVoCollection listEDLocations()
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		//List only Emergency Department
		hql.append(" from Location loc where loc.type = " + LocationType.ANE.getId()); 
		hql.append(" and loc.isActive =:active");
		hql.append(" and loc.isRIE is null");
		hql.append(" and loc.isVirtual =:virtual");
		hql.append(" order by loc.name asc ");

		List<?> locationList = factory.find(hql.toString(), new String[]{"active", "virtual"}, new Object[]{Boolean.TRUE, Boolean.FALSE});
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locationList); 
	}

	public WhiteBoardConfigVo getEDWhiteBoardConfigByLocation(LocationRefVo locationRef, TrackingAreaRefVo trackingAreaRef)
	{
		if(locationRef == null || trackingAreaRef==null)
			throw new CodingRuntimeException("Can not get EDWhiteBoardConfig value on null locationID or nullAreaID.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select whiteBoardCfg from WhiteBoardConfig as whiteBoardCfg ");
		hql.append("where whiteBoardCfg.eDLocation.id = :locationID and whiteBoardCfg.currentArea.id = :areaID  ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"locationID","areaID"}, new Object[] {locationRef.getID_Location(),trackingAreaRef.getID_TrackingArea()});
		
		if (list!=null && list.size()>0)
		{
			return WhiteBoardConfigVoAssembler.createWhiteBoardConfigVoCollectionFromWhiteBoardConfig(list).get(0);
		}
		return null;
	}

	public WhiteBoardConfigVo save(WhiteBoardConfigVo edWhiteBoardToSave) throws StaleObjectException
	{
		if (edWhiteBoardToSave == null)
			throw new CodingRuntimeException("Cannot save null WhiteBoardConfigVo ");

		if (!edWhiteBoardToSave.isValidated())
			throw new CodingRuntimeException("WhiteBoardConfigVo not Validated");
		
		DomainFactory factory = getDomainFactory();

		WhiteBoardConfig domainWhiateBoardConfig = WhiteBoardConfigVoAssembler.extractWhiteBoardConfig(factory, edWhiteBoardToSave);
		factory.save(domainWhiateBoardConfig);
		
		return WhiteBoardConfigVoAssembler.create(domainWhiateBoardConfig);
	}

	public TrackingAreaLiteVoCollection getAreasByLocation(LocationRefVo locationRef)
	{
		if( locationRef == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		List <?> trackingAreas = null;
		
		String hsql = "select t1_1 from TrackingArea as t1_1 left join t1_1.eDLocation as l1_1 where l1_1.id = :idLocation ";
		trackingAreas = factory.find(hsql, new String[] {"idLocation"}, new Object[] {locationRef.getID_Location()});
		
		return TrackingAreaLiteVoAssembler.createTrackingAreaLiteVoCollectionFromTrackingArea(trackingAreas);
	}

	public WhiteBoardConfigVoCollection getAllWhiteboardConfigurations()
	{
		StringBuffer hql = new StringBuffer();
		hql.append("select whiteBoardCfg from WhiteBoardConfig as whiteBoardCfg where whiteBoardCfg.currentArea is not null ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString());
		
		return WhiteBoardConfigVoAssembler.createWhiteBoardConfigVoCollectionFromWhiteBoardConfig(list);
	}

	public Boolean isActionUsed(WhiteBoardOtherActionsRefVo whiteBoardActionRef)
	{
		if(whiteBoardActionRef == null )
			throw new CodingRuntimeException("Can not get PatientWhiteBoardOtherActions value on null whiteBoardActionRef.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select patWhiteBoardAction from PatientWhiteboardActions as patWhiteBoardAction left join patWhiteBoardAction.actionType as actionType where actionType.id = :actionID  ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"actionID"}, new Object[] {whiteBoardActionRef.getID_WhiteBoardOtherActions()});
		
		if (list!=null && list.size()>0)
		{
			return true;
		}
		
		return false;
	}

}
