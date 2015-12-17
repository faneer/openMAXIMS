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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4758.16736)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import java.util.List;


import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.AdmissionDetail;
import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.vo.AdmissionDetailRefVo;
import ims.core.admin.pas.vo.DischargedEpisodeRefVo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.domain.ADT;
import ims.core.domain.base.impl.BaseADTDischargeDetailsComponentImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.AdmissionDetailVo;
import ims.core.vo.AdmissionDetailVoCollection;
import ims.core.vo.CareContextInterfaceVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.DischargedEpisodeVoCollection;
import ims.core.vo.PasEventVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.AdmissionDetailVoAssembler;
import ims.core.vo.domain.CareContextInterfaceVoAssembler;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.PasEventVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;


public class ADTDischargeDetailsComponentImpl extends BaseADTDischargeDetailsComponentImpl
{

	private static final long serialVersionUID = 1L;

	//wdev-16427
	public ims.core.vo.AdmissionDetailVo getAdmissionDetailById(ims.core.admin.pas.vo.AdmissionDetailRefVo admDetRef)
	{
		if( admDetRef == null)
			throw new CodingRuntimeException("This AdmissionDetailRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		AdmissionDetail doAdmissionDetail = (AdmissionDetail) factory.getDomainObject(AdmissionDetail.class, admDetRef.getID_AdmissionDetail());
			
		return AdmissionDetailVoAssembler.create(doAdmissionDetail);
	}

	public ims.core.vo.CareContextInterfaceVo getCareContextById(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if( careContextRef == null)
			throw new CodingRuntimeException("This CareContextRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		CareContext doCareContext = (CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());
			
		return CareContextInterfaceVoAssembler.create(doCareContext);
	}

	//wdev-16427
	public DischargedEpisodeVo getDischargeEpisodeByAdmissionDetail(AdmissionDetailRefVo admDetRef)
	{
		if( admDetRef == null )
			throw new CodingRuntimeException("AdmissionDetailRefVo is null");
		
		 
		
		DomainFactory factory = getDomainFactory();
		String hql = " select d1_1	from DischargedEpisode as d1_1 left join d1_1.admissionDetail as a1_1 where	(d1_1.admissionDetail.id = :idAdmissionDet ) order by d1_1.systemInformation.creationDateTime desc ";
		List<?> lst = factory.find(hql,new String[]{"idAdmissionDet"},new Object[]{admDetRef.getID_AdmissionDetail()});
		if (lst != null && lst.size() > 0)
		{
			DischargedEpisodeVoCollection tempColl = DischargedEpisodeVoAssembler.createDischargedEpisodeVoCollectionFromDischargedEpisode(lst) ;
			if(tempColl != null && tempColl.size() > 0)
			{
				return tempColl.get(0);
			}
	
		}
		return null;
	}

	//wdev-16427
	public DischargedEpisodeVo saveRecord(DischargedEpisodeVo record, PatientShort patient, CareContextInterfaceVo careContext) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		ADT Adt = (ADT)getDomainImpl(ADTImpl.class);
		if( patient != null)
		    patient.validate();
		
		return Adt.dischargePatient(patient, record, careContext);
	}

	//wdev-16428
	public AdmissionDetailVo getLastAdmissionForPatient(PatientRefVo parRef)
	{
		if( parRef == null )
			throw new CodingRuntimeException("PatientRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		 
		String hql = " select a1_1 from AdmissionDetail as a1_1 left join a1_1.pasEvent as p1_1 left join p1_1.patient as p2_1 where (p2_1.id = :patientId) order by a1_1.admissionDateTime desc";
		List<?> lst = factory.find(hql,new String[]{"patientId"},new Object[]{parRef.getID_Patient()});
		if (lst != null && lst.size() > 0)
		{
			AdmissionDetailVoCollection tempColl = AdmissionDetailVoAssembler.createAdmissionDetailVoCollectionFromAdmissionDetail(lst) ;
			if(tempColl != null && tempColl.size() > 0)
			{
				return tempColl.get(0);
			}
	
		}
		return null;
	}

	//wdev-16428
	public AdmissionDetailVo getAdmissionForSelectedCareContext(CareContextInterfaceVo careContext)
	{
		if( careContext == null || careContext.getPasEvent() == null )
			throw new CodingRuntimeException("CareContextInterfaceVo is null");
		
		DomainFactory factory = getDomainFactory();
		 	 
		String hql = " select a1_1	from AdmissionDetail as a1_1 left join a1_1.pasEvent as p1_1 where (p1_1.id = :pasEventId) order by a1_1.admissionDateTime desc";
		List<?> lst = factory.find(hql,new String[]{"pasEventId"},new Object[]{careContext.getPasEvent().getID_PASEvent()});
		if (lst != null && lst.size() > 0)
		{
			AdmissionDetailVoCollection tempColl = AdmissionDetailVoAssembler.createAdmissionDetailVoCollectionFromAdmissionDetail(lst) ;
			if(tempColl != null && tempColl.size() > 0)
			{
				return tempColl.get(0);
			}
	
		}
		return null;
	}

	//wdev-16428
	public void restoreCareContextAndDischarge(CareContextInterfaceVo careContext, PatientShort patientShort, DischargedEpisodeVo dischargeEpisode) throws DomainInterfaceException, StaleObjectException
	{
		

		ADT domADT = (ADT) getDomainImpl(ADTImpl.class);
		if( patientShort != null)
			patientShort.validate();
		
		if (dischargeEpisode != null && dischargeEpisode.getPasEvent() != null)
		{
		
			dischargeEpisode.validate();
			if (!dischargeEpisode.isValidated())
				throw new DomainRuntimeException("DischargeEpisodeVo has not been validated");

			
				
			try
			{
				domADT.cancelDischarge(patientShort, dischargeEpisode, careContext);
			}
			catch (StaleObjectException e)
			{
				throw new StaleObjectException(null);
				
			}
			catch (DomainException e)
			{
				throw new DomainRuntimeException("ADT Error Discharging Patient " + e.getMessage(), e);
			}
		}

		DomainFactory factory = getDomainFactory();
		CareContext domRootCareContext = (CareContext) factory.getDomainObject(CareContext.class, careContext.getID_CareContext());
		try
		{
			
			//Clear the EndDate
			domRootCareContext.setEndDateTime(null);
			if(domRootCareContext.getEpisodeOfCare() != null) 
			{
				domRootCareContext.getEpisodeOfCare().setEndDate(null);
			}
			factory.save(domRootCareContext);
			return;
		}
		catch (DomainException e)
		{
			throw new DomainRuntimeException("Domain Exception occurred saving Discharge.\r\n" + e.getMessage(), e);
		}
		
	}

	
	public DischargedEpisodeVo getDischargeEpisodeById(DischargedEpisodeRefVo dischargeEpisodeRef)
	{
		if( dischargeEpisodeRef == null)
			throw new CodingRuntimeException("This DischargedEpisodeRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		DischargedEpisode doDischargedEpisode = (DischargedEpisode) factory.getDomainObject(DischargedEpisode.class, dischargeEpisodeRef.getID_DischargedEpisode());
			
		return DischargedEpisodeVoAssembler.create(doDischargedEpisode);
	}

	
	public PatientShort getPatientShort(PatientRefVo patRef)
	{
		if( patRef == null)
			throw new CodingRuntimeException("This PatientRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		Patient doPatient = (Patient) factory.getDomainObject(Patient.class, patRef.getID_Patient());
			
		return PatientShortAssembler.create(doPatient);
	}

	//wdev-16770
	public PasEventVo getPasEventVo(PASEventRefVo pasEventRef)
	{
		if( pasEventRef == null)
			throw new CodingRuntimeException("This PASEventRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		PASEvent doPASEvent = (PASEvent) factory.getDomainObject(PASEvent.class, pasEventRef.getID_PASEvent());
		
		return PasEventVoAssembler.create(doPASEvent);
	}
}
