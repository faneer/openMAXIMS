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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.domain.objects.PendingEmergencyAdmission;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.EpisodeofCareShortVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PasEventShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.domain.base.impl.BaseEDDecisionToAdmitDialogImpl;
import ims.emergency.domain.objects.ReferralToSpecTeam;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.helper.EmergencyHelper;
import ims.emergency.helper.IEmergencyHelper;
import ims.emergency.vo.BedAvailabilityForTrackVo;
import ims.emergency.vo.PendingEmergencyAdmissionShortVo;
import ims.emergency.vo.ReferralToSpecialtyTeamVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.domain.PendingEmergencyAdmissionShortVoAssembler;
import ims.emergency.vo.domain.ReferralToSpecialtyTeamVoAssembler;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;

public class EDDecisionToAdmitDialogImpl extends BaseEDDecisionToAdmitDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistAndTriageVo(ims.emergency.vo.TrackingRefVo trackingRef)
	{
		
		if(trackingRef == null || trackingRef.getID_Tracking() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Tracking Id.");
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingRef.getID_Tracking()));
	
	}
	
	public PendingEmergencyAdmissionShortVo save(PendingEmergencyAdmissionShortVo record, BedAvailabilityForTrackVo bedAvailability, TrackingForClinicianWorklistAndTriageVo tracking, ReferralToSpecialtyTeamVo referralToSpecialtyToBeSaved) throws StaleObjectException, UniqueKeyViolationException //WDEV-16777 
	{
		if( record == null)
			throw new CodingRuntimeException("Cannot save a null PendingEmergencyAdmission record.");
		
		if( tracking == null)
			throw new CodingRuntimeException("Cannot save a null Tracking record.");
		
		if(!tracking.isValidated())
			throw new CodingRuntimeException("Tracking record is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		//WDEV-16777
		if (referralToSpecialtyToBeSaved!=null)
		{
			ReferralToSpecTeam domainReferralToSpecialtyToBeSaved = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(factory, referralToSpecialtyToBeSaved);
			factory.save(domainReferralToSpecialtyToBeSaved);	
			tracking.setCurrentReferral(null);			
		
			Tracking doTracking = TrackingForClinicianWorklistAndTriageVoAssembler.extractTracking(factory, tracking);
			factory.save(doTracking);
			tracking=TrackingForClinicianWorklistAndTriageVoAssembler.create(doTracking);
			tracking.validate();
	
		}
		
		PendingEmergencyAdmission doPendingEmergencyAdmission = null;
		if( record.getPasEventIsNotNull() && !record.getPasEvent().getID_PASEventIsNotNull() )				
		{
			
			PASEvent doPASEvent = PasEventShortVoAssembler.extractPASEvent(factory, record.getPasEvent());
			factory.save(doPASEvent);
			
			doPendingEmergencyAdmission = PendingEmergencyAdmissionShortVoAssembler.extractPendingEmergencyAdmission(factory, record);
			doPendingEmergencyAdmission.setPasEvent(doPASEvent);
			factory.save(doPendingEmergencyAdmission);
			
					
			
		}
		else 
		{
			doPendingEmergencyAdmission = PendingEmergencyAdmissionShortVoAssembler.extractPendingEmergencyAdmission(factory, record);
			factory.save(doPendingEmergencyAdmission);
		}
		
		tracking.setBedAvailability(bedAvailability);
		Tracking doTracking = TrackingForClinicianWorklistAndTriageVoAssembler.extractTracking(factory, tracking);
		doTracking.setAssociatedPendingEmergencyAdmission(doPendingEmergencyAdmission);
		factory.save(doTracking);

		return PendingEmergencyAdmissionShortVoAssembler.create(doPendingEmergencyAdmission);
	}

	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patRef)
	{
		if( patRef == null || patRef.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot get Patient record for a null Patient Id.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patRef.getID_Patient()));
	
	}

	
	
	//wdev-17254
	public TrackingForClinicianWorklistAndTriageVo saveRemoveBed(TrackingForClinicianWorklistAndTriageVo tracking, PendingEmergencyAdmissionShortVo pending) throws StaleObjectException, UniqueKeyViolationException
	{
		if( tracking == null )
			throw new CodingRuntimeException("Cannot save a null TrackingForClinicianWorklistAndTriageVo  record");
		
			
		
		DomainFactory factory = getDomainFactory();
		
		PendingEmergencyAdmission doPendingEmergencyAdmission = null;
		if( pending != null )
		{
			doPendingEmergencyAdmission = PendingEmergencyAdmissionShortVoAssembler.extractPendingEmergencyAdmission(factory, pending);
			factory.save(doPendingEmergencyAdmission);
		}
		
		Tracking doTracking = TrackingForClinicianWorklistAndTriageVoAssembler.extractTracking(factory, tracking);
		
		if( doTracking != null && doPendingEmergencyAdmission != null)
			doTracking.setAssociatedPendingEmergencyAdmission(doPendingEmergencyAdmission);
		
		factory.save(doTracking);
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create(doTracking);
		
	}

	//wdev-17380
	public EpisodeofCareShortVo getEpisodeOfCare(EpisodeOfCareRefVo episodeRef) 
	{
		if( episodeRef == null || episodeRef.getID_EpisodeOfCare() == null)
			throw new CodingRuntimeException("Cannot get Episode Of Care record for a null EpisodeOfCareRefVo");
		
		return EpisodeofCareShortVoAssembler.create((EpisodeOfCare) getDomainFactory().getDomainObject(EpisodeOfCare.class, episodeRef.getID_EpisodeOfCare()));
	
	}

	//wdev-17380
	public CareContextShortVo getCareContextShort(CareContextRefVo careContextRef) 
	{
		if( careContextRef == null || careContextRef.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot get Care Context record for a null CareContextRefVo");
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContextRef.getID_CareContext()));
			
	}

	//wdev-17488
	public LocationLiteVo getLocationLiteVo(LocationRefVo locRef) 
	{
		if( locRef == null || locRef.getID_Location() == null)
			throw new CodingRuntimeException("Cannot get Location record for a null LocationRefVo");
		return LocationLiteVoAssembler.create((Location) getDomainFactory().getDomainObject(Location.class, locRef.getID_Location()));
			
	}

	//WDEV-17615
	public LocationLiteVo getCurrentHospital(ILocation currentLocation)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getCurrentHospital(currentLocation);
	}
}
