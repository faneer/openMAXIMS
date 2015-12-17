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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.EpisodeofCareVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.TrackingArea;
import ims.emergency.configuration.domain.objects.TrackingWorkflowConfig;
import ims.emergency.configuration.vo.TrackingAreaRefVo;
import ims.emergency.configuration.vo.TrackingWorkflowConfigRefVo;
import ims.emergency.domain.EDPartialAdmissionDialog;
import ims.emergency.domain.base.impl.BaseSendToAreaDialogImpl;
import ims.emergency.domain.objects.EDPartialAdmission;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.domain.objects.TrackingMovementTimes;
import ims.emergency.vo.CurrentPartialAdmissionForSendToAreaVo;
import ims.emergency.vo.TrackingAreaCubiclesVo;
import ims.emergency.vo.TrackingAreaLiteVo;
import ims.emergency.vo.TrackingLiteVo;
import ims.emergency.vo.TrackingLiteVoCollection;
import ims.emergency.vo.TrackingMovementTimesVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.TrackingStatusWorkflowVo;
import ims.emergency.vo.domain.CurrentPartialAdmissionForSendToAreaVoAssembler;
import ims.emergency.vo.domain.EDPartialAdmissionVoAssembler;
import ims.emergency.vo.domain.TrackingAreaCubiclesVoAssembler;
import ims.emergency.vo.domain.TrackingAreaLiteVoAssembler;
import ims.emergency.vo.domain.TrackingAreaVoAssembler;
import ims.emergency.vo.domain.TrackingLiteVoAssembler;
import ims.emergency.vo.domain.TrackingMovementTimesVoAssembler;
import ims.emergency.vo.domain.TrackingStatusWorkflowVoAssembler;
import ims.emergency.vo.lookups.ModeOfArrival;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class SendToAreaImpl extends BaseSendToAreaDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TrackingAreaVoCollection listTrackingAreas(ims.core.resource.place.vo.LocationRefVo locRef, TrackingAreaRefVo trackingAreaRef)
	{
		if( locRef == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		List trackingAreas = null;
		
		if(	trackingAreaRef == null )		//AttendanceDetails 
		{
			String hsql = "select t1_1 from TrackingArea as t1_1 left join t1_1.eDLocation as l1_1 where(l1_1.id = :idLocation and t1_1.isRegistrationArea = 1)";
			trackingAreas = factory.find(hsql, new String[] {"idLocation"}, new Object[] {locRef.getID_Location()});
		}
		else								//Tracking form, Move button
		{
			String hsql = "select t2_1 from TrackingArea as t1_1 left join t1_1.eDLocation as l1_1 left join t1_1.sendToAreas as t2_1 left join t2_1.status as l2_1 where	(t1_1.id = :idtrackingArea and l1_1.id = :idLocation and l2_1.id = :idStatus)";
			trackingAreas = factory.find(hsql, new String[] {"idtrackingArea","idLocation","idStatus"}, new Object[] {trackingAreaRef.getID_TrackingArea(),locRef.getID_Location(),PreActiveActiveInactiveStatus.ACTIVE.getID()});
		}
		 
		return TrackingAreaVoAssembler.createTrackingAreaVoCollectionFromTrackingArea(trackingAreas);
	}

	
	public TrackingLiteVo getTrackingLiteVo(TrackingRefVo trackingRef) 
	{
		if(	trackingRef == null)
			throw new CodingRuntimeException("Tracking cannot be null");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "from Tracking as t1_1 where	(t1_1.id = :idTracking) ";
	
		List trackings = factory.find(hsql, new String[] {"idTracking"}, new Object[] { trackingRef.getID_Tracking()});
		
		if( trackings != null && trackings.size() > 0)
		{
			TrackingLiteVoCollection tempColl = TrackingLiteVoAssembler.createTrackingLiteVoCollectionFromTracking(trackings);
			if(	tempColl != null && tempColl.size() > 0)
			{
				return tempColl.get(0);
			}
		}
		
		return null;
	}


	public TrackingLiteVo saveTrackingAndTrackingMovementTimes(	TrackingLiteVo record, TrackingMovementTimesVo trackingMovementTimes, CurrentPartialAdmissionForSendToAreaVo partialAdmission, Boolean trigersPreAdmissiontoPAS, EpisodeofCareVo epOfCare, CareContextVo careContext) throws StaleObjectException // WDEV-18278
	{
		if(	record == null || trackingMovementTimes == null)
			throw new DomainRuntimeException(" Tracking or TrackingMovementTimes are not validated.");
		
		DomainFactory factory = getDomainFactory();
						
		Tracking doTracking = TrackingLiteVoAssembler.extractTracking(factory, record);
		
		factory.save(doTracking);
		
		TrackingMovementTimes doTrackingMovementTimes = TrackingMovementTimesVoAssembler.extractTrackingMovementTimes(factory, trackingMovementTimes);
		factory.save(doTrackingMovementTimes);
		
		if (Boolean.TRUE.equals(trigersPreAdmissiontoPAS))
		{
			if (partialAdmission != null)
			{
				EDPartialAdmission doPartialAdmission = CurrentPartialAdmissionForSendToAreaVoAssembler.extractEDPartialAdmission(factory, partialAdmission);
				factory.save(doPartialAdmission);
			}
			
			if (record != null)
			{
				EDPartialAdmissionDialog dom = (EDPartialAdmissionDialog) getDomainImpl(EDPartialAdmissionDialogImpl.class);
				try
				{
					dom.triggerCancelPartialAdmission(record.getAttendance(), record.getCurrentPartialAdmission());
				}
				catch (DomainInterfaceException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if (careContext != null && epOfCare != null)
		{
			CareContext doCare = CareContextVoAssembler.extractCareContext(factory,careContext);
			factory.save(doCare);
			
			EpisodeofCareVo lastEpofcare = getEpisodeOfCare(epOfCare.getID_EpisodeOfCare());
			EpisodeOfCare doEpisode = EpisodeofCareVoAssembler.extractEpisodeOfCare(factory, lastEpofcare);
			doEpisode.getCareContexts().add(doCare);
			factory.save(doEpisode);		
		}
		
		return TrackingLiteVoAssembler.create(doTracking);
	}

	//WDEV-17140
	public TrackingAreaLiteVo getRegistrationAreaByLocation(LocationRefVo locationRef)
	{
		if(locationRef == null)
			throw new CodingRuntimeException("Can not get TrackingArea value on null locationID.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select trackArea from TrackingArea as trackArea ");
		hql.append("where trackArea.eDLocation.id = :locationID and trackArea.isRegistrationArea = 1");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"locationID"}, new Object[] {locationRef.getID_Location()});
		
		if (list!=null && list.size()>0)
		{
			return TrackingAreaLiteVoAssembler.create((TrackingArea)list.get(0));
		}
		return null;
	}

	public TrackingStatusWorkflowVo getTrackingWorkflowConfig(TrackingWorkflowConfigRefVo trackingStatusRef)
	{
		if (trackingStatusRef == null)
			return null;
				
		StringBuffer hql = new StringBuffer();
		hql.append("select twc from TrackingWorkflowConfig as twc ");
		hql.append("where twc.id = :twcID and (twc.isRIE is null  or twc.isRIE = 0) ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"twcID"}, new Object[] {trackingStatusRef.getID_TrackingWorkflowConfig()});
		
		if (list!=null && list.size()>0)
		{
			return TrackingStatusWorkflowVoAssembler.create((TrackingWorkflowConfig) list.get(0));
		}
		
		return null;
	}


	public EpisodeofCareVo getEpisodeOfCare(Integer id)
	{
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, id);
		return EpisodeofCareVoAssembler.create(doEpisodeOfCare);
	}


	public Boolean isAmbulanceArrival(ModeOfArrival arrivalMode)
	{
		if (arrivalMode == null)
			return false;
		
		if (ModeOfArrival.AMBULANCE.equals(arrivalMode))
			return true;
		
		String hql = "SELECT COUNT(amb.id) FROM AmbulanceArrivalsConfig AS amb LEFT JOIN amb.ambulanceArrivals AS ambArr LEFT JOIN ambArr.instance AS ambArrInst WHERE ambArrInst.id = :MODE_OF_ARRIVAL";

		long count = getDomainFactory().countWithHQL(hql, new String[] {"MODE_OF_ARRIVAL"}, new Object[] {arrivalMode.getID()});

		if (count > 0)
			return true;
		
		return false;
	}


	public TrackingAreaCubiclesVo getTrackingAreaCubicle(TrackingAreaRefVo trackingAreaRef)
	{
		if(trackingAreaRef == null || trackingAreaRef.getID_TrackingArea() == null)
			return null;
		 

		StringBuffer hql = new StringBuffer();
		hql.append("select t1_1 from TrackingAreaCubicles as t1_1 left join t1_1.trackingArea as t2_1 ");
		hql.append("where (t2_1.id = :trackinAreaId) ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"trackinAreaId"}, new Object[] {trackingAreaRef.getID_TrackingArea()});
		
		if (list!=null && list.size()>0)
		{
			return TrackingAreaCubiclesVoAssembler.createTrackingAreaCubiclesVoCollectionFromTrackingAreaCubicles(list).get(0);
		}
		return null;
	}


	public TrackingAreaLiteVo getTrackingAreaLite(TrackingAreaRefVo trackingAreaRef)
	{
		if(trackingAreaRef == null)
			throw new CodingRuntimeException("Cannot get TrackingArea on null Id.");
		
		return TrackingAreaLiteVoAssembler.create((TrackingArea) getDomainFactory().getDomainObject(TrackingArea.class, trackingAreaRef.getID_TrackingArea()));
	}
}
