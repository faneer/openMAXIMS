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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.emergency.domain.base.impl.BaseTrackingStatusDialogImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.TrackingForTrackingStatusVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.domain.TrackingForTrackingStatusVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;

public class TrackingStatusDialogImpl extends BaseTrackingStatusDialogImpl
{

	private static final long serialVersionUID = 1L;

	public TrackingForTrackingStatusVo getTracking(TrackingRefVo tracking)
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		if (tracking == null || !tracking.getID_TrackingIsNotNull())
		{
			throw new CodingRuntimeException("Cannot get Tracking on null TrackingId ");
		}

		StringBuffer hql = new StringBuffer();

		hql.append(" select Tracking from Tracking as Tracking where Tracking.id = :trackingID");
		markers.add("trackingID");
		values.add(tracking.getID_Tracking());

		return TrackingForTrackingStatusVoAssembler.createTrackingForTrackingStatusVoCollectionFromTracking(factory.find(hql.toString(), markers, values)).get(0);
	}

	public void saveTracking(ims.emergency.vo.TrackingForTrackingStatusVo trackingToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if (trackingToSave == null)
			throw new CodingRuntimeException("Cannot save null TrackingForTrackingStatusVo ");

		if (!trackingToSave.isValidated())
			throw new DomainRuntimeException("TrackingForTrackingStatusVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		Tracking domainTrackingStatus = TrackingForTrackingStatusVoAssembler.extractTracking(factory, trackingToSave);

		factory.save(domainTrackingStatus);
	}

}
