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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseSendToXRayImpl;
import ims.emergency.domain.objects.SentToXray;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.SentToXrayRefVo;
import ims.emergency.vo.SentToXrayVo;
import ims.emergency.vo.SentToXrayVoCollection;
import ims.emergency.vo.TrackingForSendToXRayVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.domain.EmergencyAttendanceForTrackingVoAssembler;
import ims.emergency.vo.domain.SentToXrayVoAssembler;
import ims.emergency.vo.domain.TrackingForSendToXRayVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.List;

public class SendToXRayImpl extends BaseSendToXRayImpl
{
	private static final long serialVersionUID = 1L;


	public SentToXrayVoCollection getAllSentToXRay(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SentToXrayVoCollection on null Id for CareContext ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select allSentToXRay from SentToXray as allSentToXRay where allSentToXRay.attendance.id = :attID order by allSentToXRay.sentDateTime desc ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"attID"}, new Object[] {careContextRef.getID_CareContext()});
			
		return SentToXrayVoAssembler.createSentToXrayVoCollectionFromSentToXray(list);	
	}

	public SentToXrayVo getSentToXRay(SentToXrayRefVo sentToXRay)
	{
		if (sentToXRay == null || sentToXRay.getID_SentToXray() == null)
		{
			throw new CodingRuntimeException("Cannot get SentToXrayVo on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
	
		SentToXray domainSentToXRay = (SentToXray) factory.getDomainObject(SentToXray.class, sentToXRay.getID_SentToXray());
		
		return SentToXrayVoAssembler.create(domainSentToXRay);
	}

	public SentToXrayVo save(SentToXrayVo sentToXRayToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if (sentToXRayToSave == null)
			throw new CodingRuntimeException("Cannot save null SentToXRay ");

		if (!sentToXRayToSave.isValidated())
			throw new DomainRuntimeException("SentToXrayVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		SentToXray domainSentToXRay = SentToXrayVoAssembler.extractSentToXray(factory, sentToXRayToSave);

		factory.save(domainSentToXRay);

		return SentToXrayVoAssembler.create(domainSentToXRay);
	}

	public SentToXrayVo save(SentToXrayVo sentToXRayToSave, TrackingForSendToXRayVo tracking) throws StaleObjectException
	{
		if (sentToXRayToSave == null)
			throw new CodingRuntimeException("Cannot save null SentToXRay ");

		if (!sentToXRayToSave.isValidated())
			throw new DomainRuntimeException("SentToXrayVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		SentToXray domainSentToXRay = SentToXrayVoAssembler.extractSentToXray(factory, sentToXRayToSave);

		factory.save(domainSentToXRay);
		
		if (tracking!=null)
		{
			if (!tracking.isValidated())
				throw new DomainRuntimeException("TrackingForAllocatedMedicVo Not Validated.");

			Tracking domainTracking = TrackingForSendToXRayVoAssembler.extractTracking(factory, tracking);

			factory.save(domainTracking);
		}

		return SentToXrayVoAssembler.create(domainSentToXRay);
	}
	
	public Boolean isStale(SentToXrayVo sentToXRayToSave)
	{
		if (sentToXRayToSave == null || sentToXRayToSave.getID_SentToXray() == null)
		{
			throw new CodingRuntimeException("Cannot get SentToXrayVo on null Id ");
		}
				
		DomainFactory factory = getDomainFactory();
		SentToXray domainSentToXRay = (SentToXray) factory.getDomainObject(SentToXray.class,sentToXRayToSave.getID_SentToXray());
		
		if(domainSentToXRay==null)
		{
			return true;
		}
		
		if (domainSentToXRay.getVersion() > sentToXRayToSave.getVersion_SentToXray())
		{
			return true;
		}
		
		return false;
	}

	public DateTime getAttendanceRegistrationDateTime(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SentToXRayVoCollection on null Id for CareContext ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select att from EmergencyAttendance as att where att.careContext.id = :careContextID ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"careContextID"}, new Object[] {careContextRef.getID_CareContext()});
			
		return EmergencyAttendanceForTrackingVoAssembler.createEmergencyAttendanceForTrackingVoCollectionFromEmergencyAttendance(list).get(0).getRegistrationDateTime();
	}

	public Boolean areUnReturnedSentToXRayForCareContext(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SentToXRayVoCollection on null Id for CareContext ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select count(sentToXRay.id) from SentToXray as sentToXRay where sentToXRay.attendance.id = :attID and sentToXRay.returnedDateTime is null ");
	
		Object[] count = factory.find(hql.toString(), new String[] {"attID"}, new Object[] {careContextRef.getID_CareContext()}).toArray();
			
		if(count != null && count.length > 0)
		 if (((Long) count[0]).intValue()>0)	
			return false;
		
		return true;
	}

	public TrackingForSendToXRayVo getTracking(TrackingRefVo trackingRef)
	{
		if (trackingRef == null || trackingRef.getID_Tracking() == null)
		{
			throw new CodingRuntimeException("Cannot get TrackingAreaRefVo on null Id for Tracking ");
		}

		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select tracking from Tracking as tracking where tracking.id = :trackingID ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"trackingID"}, new Object[] {trackingRef.getID_Tracking()});
	    return TrackingForSendToXRayVoAssembler.createTrackingForSendToXRayVoCollectionFromTracking(list).get(0);	
	}

	public Boolean isMostRecentRecordReturned(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get AllocatedMedicVoCollection on null Id for CareContext ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select allSentToXRay from SentToXray as allSentToXRay where allSentToXRay.attendance.id = :attID order by allSentToXRay.sentDateTime desc ");
		
		List<?> list = factory.find(hql.toString(), new String[] {"attID"}, new Object[] {careContextRef.getID_CareContext()});		
		
		if (list.size()>0)
		{
			SentToXrayVo lastRec = SentToXrayVoAssembler.createSentToXrayVoCollectionFromSentToXray(list).get(0);
			if (lastRec.getReturnedDateTimeIsNotNull())
				return true;
			else
				return false;
		}
		else
			return true;
	}

	public Boolean isLastEntry(CareContextRefVo careContext, SentToXrayVo sentToXRay)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Logical error - Care context is mandatory to check the record 'Send To X-Ray");
		
		String query = "SELECT COUNT (xRay) FROM SentToXray AS xRay LEFT JOIN xRay.attendance AS context WHERE xRay.systemInformation.creationDateTime >= :DATE_TIME AND xRay.id <> :XRAY_ID AND context.id = :CONTEXT_ID";
		
		long records = getDomainFactory().countWithHQL(query, new String[] {"DATE_TIME", "XRAY_ID", "CONTEXT_ID"}, new Object[] {sentToXRay.getSystemInformation().getCreationDateTime().getJavaDate(), sentToXRay.getID_SentToXray(), careContext.getID_CareContext()});
		
		if (records > 0)
			return false;
		
		return true;
	}

}
