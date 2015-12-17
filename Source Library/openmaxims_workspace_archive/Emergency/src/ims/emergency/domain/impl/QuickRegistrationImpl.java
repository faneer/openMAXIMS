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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.domain.objects.EmergencyEpisode;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.PatientLiteVo;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.domain.LocSiteShortVoAssembler;
import ims.core.vo.domain.PatientLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseQuickRegistrationImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo;
import ims.emergency.vo.EmergencyEpisodeForQuickRegistrationVo;
import ims.emergency.vo.TrackingForQuickRegistrationVo;
import ims.emergency.vo.domain.EmergencyEpisodeForQuickRegistrationVoAssembler;
import ims.emergency.vo.domain.TrackingForQuickRegistrationVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.Iterator;

public class QuickRegistrationImpl extends BaseQuickRegistrationImpl
{

	private static final long serialVersionUID = 1L;

	public void save(PatientLiteVo patient, CareSpellVo careSpell, EmergencyEpisodeForQuickRegistrationVo emergencyEpisode, TrackingForQuickRegistrationVo tracking, CareContextVo careContext, EmergencyAttendanceForQuickRegistrationVo emergencyAttendanceToSave) throws StaleObjectException
	{

		if (patient == null || !patient.isValidated())
			throw new CodingRuntimeException("PatientVo is null or has not been validated");

		if (careSpell == null || !careSpell.isValidated())
			throw new CodingRuntimeException("careSpellVo is null or has not been validated");

		if (emergencyEpisode == null || !emergencyEpisode.isValidated())
			throw new CodingRuntimeException("EmergencyEpisodeVo is null or has not been validated");

		DomainFactory factory = getDomainFactory();

		EpisodeOfCare doEpisode = null;
		CareContext doCare = null;

		Patient domainPatient = PatientLiteVoAssembler.extractPatient(factory, patient);
		factory.save(domainPatient);

		PatientLiteVo savedPatient = PatientLiteVoAssembler.create(domainPatient);
		emergencyAttendanceToSave.setPatient(savedPatient);

		CareSpell domainCareSpell = CareSpellVoAssembler.extractCareSpell(factory, careSpell);

		if (domainCareSpell.getPatient() == null || domainCareSpell.getPatient().getId() == null)
			domainCareSpell.setPatient(domainPatient);

		factory.save(domainCareSpell);

		doEpisode = getEpisodeOfCareDO(domainCareSpell);
		doCare = getCareContextDO(doEpisode);

		EmergencyEpisode domainEmergencyEpisode = EmergencyEpisodeForQuickRegistrationVoAssembler.extractEmergencyEpisode(factory, emergencyEpisode);

		if (domainEmergencyEpisode.getPatient() == null || domainEmergencyEpisode.getPatient().getId() == null)
			domainEmergencyEpisode.setPatient(domainPatient);

		if (domainEmergencyEpisode.getEpisodeOfCare() == null || domainEmergencyEpisode.getEpisodeOfCare().getId() == null)
			domainEmergencyEpisode.setEpisodeOfCare(doEpisode);

		if (domainCareSpell != null)
		{
			domainEmergencyEpisode.setEpisodeOfCare(doEpisode);
		}

		Iterator<?> it = domainEmergencyEpisode.getEmergencyAttendances().iterator();
		EmergencyAttendance doEmergencyAttendances = null;

		while (it.hasNext())
		{
			doEmergencyAttendances = (EmergencyAttendance) it.next();
			if (doEmergencyAttendances.getCareContext() == null || doEmergencyAttendances.getCareContext().getId() == null)
				doEmergencyAttendances.setCareContext(doCare);
		}
		factory.save(domainEmergencyEpisode);

		if (tracking != null)
		{
			if (!tracking.isValidated())
				throw new CodingRuntimeException("TrackingVo has not been validated");

			Tracking domainTracking = TrackingForQuickRegistrationVoAssembler.extractTracking(factory, tracking);

			if (domainTracking.getPatient() == null || domainTracking.getPatient().getId() == null)
				domainTracking.setPatient(domainPatient);

			if (domainTracking.getEpisode() == null || domainTracking.getEpisode().getId() == null)
				domainTracking.setEpisode(domainEmergencyEpisode);

			if (domainTracking.getAttendance() == null || domainTracking.getAttendance().getId() == null)
				domainTracking.setAttendance(doEmergencyAttendances);

			if (domainTracking.getCurrentStatus().getPatient() == null || domainTracking.getCurrentStatus().getPatient().getId() == null)
				domainTracking.getCurrentStatus().setPatient(domainPatient);

			if (domainTracking.getCurrentStatus().getAttendance() == null || domainTracking.getCurrentStatus().getAttendance().getId() == null)
				domainTracking.getCurrentStatus().setAttendance(doCare);

			if (domainTracking.getCurrentStatus().getEpisode() == null || domainTracking.getCurrentStatus().getEpisode().getId() == null)
				domainTracking.getCurrentStatus().setEpisode(doEpisode);

			factory.save(domainTracking);
		}
	}

	private CareContext getCareContextDO(EpisodeOfCare doEpisode)
	{
		for (Iterator<?> iter = doEpisode.getCareContexts().iterator(); iter.hasNext();)
		{
			CareContext element = (CareContext) iter.next();
			return element;
		}

		return null;
	}

	private EpisodeOfCare getEpisodeOfCareDO(CareSpell domainCareSpell)
	{
		for (Iterator<?> iter = domainCareSpell.getEpisodes().iterator(); iter.hasNext();)
		{
			EpisodeOfCare element = (EpisodeOfCare) iter.next();
			return element;
		}

		return null;
	}

	public LocSiteShortVo getTypeOfLocSite(LocationRefVo locRef)
	{
		if (locRef == null)
			throw new CodingRuntimeException("Location not provided");

		DomainFactory factory = getDomainFactory();
		LocSite doLocation = (LocSite) factory.getDomainObject(LocSite.class, locRef.getID_Location());
		return LocSiteShortVoAssembler.create(doLocation);
	}

	//WDEV-15958
	public PatientLiteVo getPatient(PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient()==null)
			throw new CodingRuntimeException("Patient not provided");

		DomainFactory factory = getDomainFactory();
		Patient doPatient = (Patient) factory.getDomainObject(Patient.class, patientRef.getID_Patient());
		return PatientLiteVoAssembler.create(doPatient);
	}

	//WDEV-16556
	public Boolean checkIsAlreadyAdmitted(Integer patientId)
	{
		if (patientId == null)
		{
			throw new CodingRuntimeException("Cannot check if Patient is admitted on null PatientID ");
		}

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		hql.append(" select count (c1_1.id) from EmergencyAttendance as e1_1 right join e1_1.careContext as c1_1 left join c1_1.episodeOfCare as e2_1 left join e2_1.careSpell as c2_1 left join c2_1.patient as p1_1 where (p1_1.id = :patId and e1_1.isRIE is null  and c1_1.endDateTime is null ) "); //wdev-17569
				
		Object[] count = factory.find(hql.toString(), new String[] { "patId" }, new Object[] {patientId}).toArray();
		
		if(count != null && count.length > 0)
			 if (((Long) count[0]).intValue() > 0) 
			 return true;
		
		return false;
	}
}
