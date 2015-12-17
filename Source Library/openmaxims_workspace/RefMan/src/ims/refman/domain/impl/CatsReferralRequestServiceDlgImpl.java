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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseCatsReferralRequestServiceDlgImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.LinkedCatsReferral;
import ims.RefMan.vo.CareSpellForRequestServiceShortVo;
import ims.RefMan.vo.CatsReferralForRequestServiceVo;
import ims.RefMan.vo.CatsReferralMasterVo;
import ims.RefMan.vo.CatsReferralMasterVoCollection;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ContractServiceLocationsConfigVo;
import ims.RefMan.vo.EpisodeOfCareForRequestServiceShortVoCollection;
import ims.RefMan.vo.LinkedCatsReferralForOutcomeVo;
import ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection;
import ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo;
import ims.RefMan.vo.domain.CareSpellForRequestServiceShortVoAssembler;
import ims.RefMan.vo.domain.CatsReferralMasterVoAssembler;
import ims.RefMan.vo.domain.ContractServiceLocationsConfigVoAssembler;
import ims.RefMan.vo.domain.LinkedCatsReferralForOutcomeVoAssembler;
import ims.RefMan.vo.domain.LinkedCatsReferral_RIE_OutcomeVoAssembler;
import ims.RefMan.vo.lookups.ReferralRelationType;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.domain.objects.Referral;
import ims.core.admin.vo.ReferralRefVo;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.configuration.domain.objects.ContractConfig;
import ims.core.configuration.domain.objects.ContractServiceLocationsConfig;
import ims.core.configuration.vo.ContractConfigRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.Patient;
import ims.core.vo.ReferralSourceUrgencyVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientAssembler;
import ims.core.vo.domain.ReferralSourceUrgencyVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.lookups.ReferralType;
import ims.core.vo.lookups.SourceOfReferral;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.PatientJourneyVo;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.scheduling.domain.objects.SessionExclusionDate;
import ims.scheduling.helper.IRequestForService;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.ExclusionDatesVo;
import ims.scheduling.vo.domain.ExclusionDatesVoAssembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatsReferralRequestServiceDlgImpl extends BaseCatsReferralRequestServiceDlgImpl implements IRequestForService
{
	private static final long serialVersionUID = 1L;
	private static final int TWO_WEEK_WAIT_TO_1ST_APP = 14;			//wdev-20946

	
	/**
	 *	List Linked Referral records for parent referral and the creating appointment if available and the indicated relationship
	 *	If the appointment parameter is missing, then list all linked refer
	 */
	public LinkedCatsReferralForOutcomeVoCollection listLinkedReferral(CatsReferralRefVo referral, Booking_AppointmentRefVo appointment, ReferralRelationType relationship)
	{
		// If the parent referral is null or doesn't have an ID
		// terminate function execution
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT linkedReferral FROM CatsReferral AS parentReferral ");
		query.append(" LEFT JOIN parentReferral.linkedReferrals AS linkedReferral ");
		query.append(" LEFT JOIN linkedReferral.referral AS referral ");
		query.append(" LEFT JOIN referral.creatingAppointment AS creatingAppointment ");
		query.append(" LEFT JOIN linkedReferral.referralRelationType AS relationType ");
		
		query.append(" WHERE ");
		
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		
		query.append(" parentReferral.id = :PARENT_REFERRAL_ID AND relationType.id = :RELATIONSHIP ");
		
		paramNames.add("PARENT_REFERRAL_ID");		paramValues.add(referral.getID_CatsReferral());
		paramNames.add("RELATIONSHIP");				paramValues.add(relationship.getID());
		
		if (appointment != null && appointment.getID_Booking_Appointment() != null)
		{
			query.append(" AND creatingAppointment.id = :CREATING_APPOINTMENT");
			
			paramNames.add("CREATING_APPOINTMENT");		paramValues.add(appointment.getID_Booking_Appointment());
		}
		
		return LinkedCatsReferralForOutcomeVoAssembler.createLinkedCatsReferralForOutcomeVoCollectionFromLinkedCatsReferral(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	

	/**
	 *	Function used to save Linked Referral and associate it with parent Cats Referral 
	 */
	public LinkedCatsReferralForOutcomeVo saveLinkedReferralForServiceRequest(LinkedCatsReferralForOutcomeVo linkedReferral, CatsReferralRefVo parentReferral, CareSpellForRequestServiceShortVo careSpell) throws DomainInterfaceException, StaleObjectException
	{
		// Check parameter to save to have value and be validated
		if (linkedReferral == null)
			throw new CodingRuntimeException("Linked Referral to be saved cannot be null");
		
		if (!linkedReferral.isValidated())
			throw new CodingRuntimeException("Linked Referral to be saved has not been validated.");
		
		
		// Create Journey for Request for Service Journey if required (this should only be necessary for new objects)
		if (linkedReferral.getReferral().getJourney() == null)
		{
			linkedReferral.getReferral().setJourney(createPatientJourney(linkedReferral.getReferral()));
		}
		
		
		// Extract & save Linked Referral record
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap();
		CareSpell domCareSpell = CareSpellForRequestServiceShortVoAssembler.extractCareSpell(getDomainFactory(), careSpell, map);
		getDomainFactory().save(domCareSpell);

		LinkedCatsReferral domLinkedReferral = LinkedCatsReferralForOutcomeVoAssembler.extractLinkedCatsReferral(getDomainFactory(), linkedReferral, map);
		getDomainFactory().save(domLinkedReferral);
		linkedReferral = LinkedCatsReferralForOutcomeVoAssembler.create(domLinkedReferral);


		// Get parent referral
		if (parentReferral != null && parentReferral.getID_CatsReferral() != null)
		{
			// Add the linked referral parent referral
			// TODO: We don't need this big VO for parent referral, we can use a smaller one
			//WDEV-22786 VO used caused a Stale Object 
			CatsReferral masterReferralDO = (CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, parentReferral.getID_CatsReferral());
			
			if (masterReferralDO.getLinkedReferrals() == null)
				masterReferralDO.setLinkedReferrals(new java.util.ArrayList());
			
			masterReferralDO.getLinkedReferrals().add(domLinkedReferral);						
			
			// Save parent referral
			getDomainFactory().save(masterReferralDO);
		}
		
		// Return saved referral
		return linkedReferral;
	}
	
	
	public void saveLinkedReferralsForServiceRequest(LinkedCatsReferralForOutcomeVoCollection linkedReferrals, CatsReferralRefVo parentReferral, CareSpellForRequestServiceShortVo careSpell) throws DomainInterfaceException, StaleObjectException
	{
		// Check parameter to save to have value and be validated
		if (linkedReferrals == null)
			throw new CodingRuntimeException("Linked Referral to be saved cannot be null");

		if (!linkedReferrals.isValidated())
			throw new CodingRuntimeException("Linked Referral to be saved has not been validated.");

		
		// Add all Episode of Care and Care Context to existing Care Spell
		
		
		for (LinkedCatsReferralForOutcomeVo linkedReferral : linkedReferrals)
		{
			// Update careSpell only for not saved referrals
			if (linkedReferral.getID_LinkedCatsReferral() == null)
			{
				if (careSpell.getEpisodes() == null)
					careSpell.setEpisodes(new EpisodeOfCareForRequestServiceShortVoCollection());
				careSpell.getEpisodes().add(linkedReferral.getReferral().getEpisodeOfCare());

				// These lines are needed to ensure the same VO (the exact instantiation) are being sent to save function
				// have been recreated as the Hash Code for the VOs is changed at this point (not sure where it was changed previously)
				linkedReferral.getReferral().getEpisodeOfCare().setCareSpell(careSpell);
				linkedReferral.getReferral().getEpisodeOfCare().getCareContexts().get(0).setEpisodeOfCare(linkedReferral.getReferral().getEpisodeOfCare());
				linkedReferral.getReferral().setCareContext(linkedReferral.getReferral().getEpisodeOfCare().getCareContexts().get(0));
			}
		}
		
		
		// Extract & save Linked Referral record
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap();
		CareSpell domCareSpell = CareSpellForRequestServiceShortVoAssembler.extractCareSpell(getDomainFactory(), careSpell, map);
		getDomainFactory().save(domCareSpell);

		
		for (LinkedCatsReferralForOutcomeVo linkedReferral : linkedReferrals)
		{

			// Create Journey for Request for Service Journey if required (this should only be necessary for new objects)
			if (linkedReferral.getReferral().getJourney() == null)
			{
				linkedReferral.getReferral().setJourney(createPatientJourney(linkedReferral.getReferral()));
			}

			LinkedCatsReferral domLinkedReferral = LinkedCatsReferralForOutcomeVoAssembler.extractLinkedCatsReferral(getDomainFactory(), linkedReferral, map);
			getDomainFactory().save(domLinkedReferral);
			linkedReferral = LinkedCatsReferralForOutcomeVoAssembler.create(domLinkedReferral);


			// Get parent referral
			if (parentReferral != null && parentReferral.getID_CatsReferral() != null)
			{
				// Add the linked referral parent referral
				// TODO: We don't need this big VO for parent referral, we can use a smaller one
				CatsReferralMasterVo masterReferral = CatsReferralMasterVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, parentReferral.getID_CatsReferral()));

				if (masterReferral.getLinkedReferrals() == null)
					masterReferral.setLinkedReferrals(new LinkedCatsReferralForOutcomeVoCollection());

				masterReferral.getLinkedReferrals().add(linkedReferral);

				CatsReferral domParentReferral = CatsReferralMasterVoAssembler.extractCatsReferral(getDomainFactory(), masterReferral);

				// Save parent referral
				getDomainFactory().save(domParentReferral);
			}
		}
	}

	
	public ServiceLiteVoCollection getReferralService(ContractConfigRefVo contractRef)
	{
		if(contractRef == null || contractRef.getID_ContractConfig() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select s from ContractConfig as cc left join cc.serviceLocations as sl left join sl.service as s where cc.id = :ContractConfig and s.isActive=1 order by s.serviceName asc  "; //WDEV-21195 //WDEV-22950
		
		List doServices = factory.find(query, new String[] {"ContractConfig"}, new Object[] {contractRef.getID_ContractConfig()});

		return ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(doServices);
		
	}
	//wdev-19933

	public ReferralSourceUrgencyVoCollection getSourceOfReferralConfigVoColl()
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from ReferralSourceUrgency");
		List<?> list = factory.find(hql.toString());
		if( list != null && list.size() > 0 )
			return ReferralSourceUrgencyVoAssembler.createReferralSourceUrgencyVoCollectionFromReferralSourceUrgency(list);
		
		
		return null;
	}

	public CatsReferralMasterVo getParentCatsReferrall(CatsReferralRefVo catsReferralRef)
	{
		if( catsReferralRef == null )
			return null;
			
		/*CatsReferral doCatsReferral = (CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, catsReferralRef.getID_CatsReferral());*/
		StringBuilder query = new StringBuilder("SELECT p1_1 FROM ");
		query.append(" CatsReferral as p1_1 ");
		query.append(" WHERE( p1_1.id = :parentCatsReferralID) ");
				
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("parentCatsReferralID");		paramValues.add(catsReferralRef.getID_CatsReferral());
		
		
		List catsReferral = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		if( catsReferral != null && catsReferral.size() > 0)
		{
			
			CatsReferralMasterVoCollection coll = CatsReferralMasterVoAssembler.createCatsReferralMasterVoCollectionFromCatsReferral(catsReferral);
			if( coll != null && coll.size() > 0)
				return coll.get(0);
		}
		return null;
	
	}

	//wdev-20946
	public ExclusionDatesVo listExclusionDates()
	{
		DomainFactory factory = getDomainFactory();
		List exDate = factory.find("from SessionExclusionDate exDate");
		if(exDate.size() > 0)
		{
			SessionExclusionDate doExDate = (SessionExclusionDate)exDate.get(0);
			//idf record has been instantiated but dates array is empty return null
			if(doExDate.getDates() == null || doExDate.getDates().size() == 0)
				return null;
			
			return ExclusionDatesVoAssembler.create(doExDate);
		}
			
		return null;
	}

	//wdev-20946
	public ContractServiceLocationsConfigVo getContractServiceLocConfByContractService(ContractConfigRefVo contractRef, ServiceRefVo serviceRef)
	{
		if (contractRef==null || serviceRef==null)
		{
			return null;
		}
		
		String sql="select serviceLoc from ContractConfig as contractConf left join contractConf.serviceLocations as serviceLoc where contractConf.id = :ContractID and serviceLoc.service.id = :ServiceID" ;
		
		List <?>  listServiceLoc=getDomainFactory().find(sql,new String[]{"ContractID", "ServiceID"}, new Object[]{contractRef.getID_ContractConfig(), serviceRef.getID_Service()}) ;
		
		if (listServiceLoc!=null && listServiceLoc.size()>0)
			return ContractServiceLocationsConfigVoAssembler.create((ContractServiceLocationsConfig)listServiceLoc.get(0));
		
		return null;
	}

	
	public Date getEndDateKPI(CatsReferralForRequestServiceVo record)
	{
		if(record == null )
			throw new CodingRuntimeException("catsReferall is null or id not provided for method getReferralDetail");
		
		if(record.getReferralDetails() != null && SourceOfReferral.NATIONAL_SCREENING.equals(record.getReferralDetails().getReferrerType()))
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		ContractConfig doContractConfig = (ContractConfig) factory.getDomainObject(record.getContract());
		
		ExclusionDatesVo voExDate = listExclusionDates();
		Integer daysToFirstAppointment = null;
		Date firstOPKPI = null;
		if( ReferralUrgency.TWO_WEEK_WAIT.equals(record.getUrgency()))
		{
			if(record.getReferralDetails() != null && Boolean.TRUE.equals(record.getReferralDetails().getService().getIsSubjectToRTTClock()))
			{
				daysToFirstAppointment = TWO_WEEK_WAIT_TO_1ST_APP;
			}
		}
		else
		{
			ContractServiceLocationsConfigVo contrServiceLocationConf = getContractServiceLocConfByContractService(record.getContract(), record.getReferralDetails().getService());
			
			if (contrServiceLocationConf != null && contrServiceLocationConf.getDaysTo1stApptIsNotNull())
			{
				daysToFirstAppointment = contrServiceLocationConf.getDaysTo1stAppt();
			}
			else if (doContractConfig != null && record.getReferralDetails() != null && Boolean.TRUE.equals(record.getReferralDetails().getService().getIsSubjectToRTTClock()))
			{
				daysToFirstAppointment = doContractConfig.getDaysTo1stAppt();
			}
		}
		
		if (daysToFirstAppointment != null)
		{
			if(record.getReferralDetails() != null && record.getReferralDetails().getDateOfReferral() != null)
			{
				firstOPKPI = ExclusionDatesVo.addBusinessDays(record.getReferralDetails().getDateOfReferral(), daysToFirstAppointment, voExDate != null ? voExDate.getDates() : null, true);
				
			}
		}
		return firstOPKPI;
	}
	
	/**
	 * Function used to retrieve the Slot Owner HCP for an appointment
	 */
	public HcpLiteVo getAppointmentSlotResponsable(Booking_AppointmentRefVo bookingAppointment)
	{
		if (bookingAppointment == null || bookingAppointment.getID_Booking_Appointment() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT hcp FROM Booking_Appointment AS appointment ");
		query.append(" LEFT JOIN appointment.sessionSlot AS slot LEFT JOIN slot.slotResp AS listOwner ");
		query.append(" LEFT JOIN listOwner.hcp AS hcp ");
		query.append(" WHERE ");
		query.append(" appointment.id = :APPOINTMENT ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("APPOINTMENT");
		paramValues.add(bookingAppointment.getID_Booking_Appointment());
		
		return HcpLiteVoAssembler.create((Hcp) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}

	public ServiceLiteVo getServiceForReferral(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT service FROM CatsReferral AS referral ");
		query.append(" LEFT JOIN referral.referralDetails AS referralDetails ");
		query.append(" LEFT JOIN referralDetails.service AS service ");
		
		query.append(" WHERE ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append(" referral.id = :REFERRAL_ID ");
		
		paramNames.add("REFERRAL_ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return ServiceLiteVoAssembler.create((Service) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	private PatientPathwayJourneyRefVo createPatientJourney(CatsReferralForRequestServiceVo referral) 
	{
		try 
		{
			DomainFactory factory = getDomainFactory();
		
    		// Get Referral Patient - unfortunately for Journey we need the FULL Patient VO.
    		ims.core.patient.domain.objects.Patient domPatient = (ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, referral.getPatient().getID_Patient());
    		Patient voPatient = PatientAssembler.create(domPatient);
		

    		// Step 1 - Create the holding core.admin.Referral object
			Referral domReferral = new Referral();
			domReferral.setAuthoringDateTime(new java.util.Date());			
			domReferral.setReferralType(factory.getLookupInstance(ReferralType.INTERNAL.getId()));
			 // WDEV-23419  Include user Id as part of external referral key
			int userId=0;
			ims.framework.interfaces.IAppUser user = super.getLoggedInUser();
			if (user != null)
				userId = user.getUserId();
			domReferral.setExtReferralKey("IMS_" + userId + "_" + new java.util.Date().getTime()); // WDEV-23419 Include UserId

			domReferral.setPatient((ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, referral.getPatient().getID_Patient()));
			factory.save(domReferral);
			
			
			// Step 2 - Create the Patient Journey
			PatientJourneyVo journey = new PatientJourneyVo();
			journey.setPatient(voPatient);
			journey.setReferral(new ReferralRefVo(domReferral.getId(), domReferral.getVersion()));
			journey.setStartDate(referral.getReferralDetails().getDateOfReferral());
			journey.setExtReferralKey(domReferral.getExtReferralKey());
						


			HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl (HL7PathwayIfImpl.class);
			
			// Services specialty - if not set then use Emergency
			if (referral.getReferralDetailsIsNotNull() && referral.getReferralDetails().getServiceIsNotNull() && referral.getReferralDetails().getService().getSpecialtyIsNotNull())
				journey = impl.createPatientJourney(journey, null, referral.getReferralDetails().getService().getSpecialty(), null,null);			
			else	
				journey = impl.createPatientJourney(journey, null, Specialty.EMERGENCY, null,null);
			
			return new PatientPathwayJourneyRefVo(journey.getID_PatientPathwayJourney(), journey.getVersion_PatientPathwayJourney());
		} 
		catch (DomainInterfaceException e) 
		{
			super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.ERROR, "Domain Interface Exception occurred creating patient journey - " + e.getMessage());
			return null;
		} 
		catch (StaleObjectException e) 
		{
			super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.ERROR, "Stale Object Exception occurred creating patient journey - " + e.getMessage());
			return null;
		}
	}



	public CareSpellForRequestServiceShortVo getCareSpellForReferral(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT carespell ");
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.careContext AS carecontext ");
		query.append(" LEFT JOIN carecontext.episodeOfCare AS episodeofcare LEFT JOIN episodeofcare.careSpell AS carespell ");
		
		query.append(" WHERE ");
		
		query.append(" referral.id = :REFERRAL_ID ");
		
		paramNames.add("REFERRAL_ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return CareSpellForRequestServiceShortVoAssembler.create((CareSpell) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	public Boolean performRIE(LinkedCatsReferralForOutcomeVo linkedRequestForService, String rieMessage) throws DomainInterfaceException, StaleObjectException
	{
		if (linkedRequestForService == null || linkedRequestForService.getID_LinkedCatsReferral() == null)
			return false;
		
		
		DomainFactory factory = getDomainFactory();
		
		// Get the Linked Referral record data needed for RIE process
		LinkedCatsReferral_RIE_OutcomeVo linkedReferral = LinkedCatsReferral_RIE_OutcomeVoAssembler.create((LinkedCatsReferral) factory.getDomainObject(LinkedCatsReferral.class, linkedRequestForService.getID_LinkedCatsReferral()));
		
		Integer patientID = linkedReferral.getReferral().getPatient().getID_Patient();
		
		// If the Linked Referral has a CatsReferral - also mark it as RIE
		if (linkedReferral.getReferral() != null)
		{
			// If the CatsReferral has a Journey - also mark it as RIE
			if (linkedReferral.getReferral().getJourney() != null)
			{
				// Mark as RIE the Core.Referral for the Patient Journey
				if (linkedReferral.getReferral().getJourney().getReferral() != null)
				{
					factory.markAsRie(Referral.class, linkedReferral.getReferral().getJourney().getReferral().getID_Referral() , null, patientID, null, null, rieMessage);
				}
				
				factory.markAsRie(PatientPathwayJourney.class, linkedReferral.getReferral().getJourney().getID_PatientPathwayJourney(), null, patientID, null, null, rieMessage);
			}

			// Mark as RIE the Care Context for the Referral
			factory.markAsRie(CareContext.class, linkedReferral.getReferral().getCareContext().getID_CareContext(), null, patientID, null, null, rieMessage);

			// Mark as RIE the CatsReferal
			factory.markAsRie(CatsReferral.class, linkedReferral.getReferral().getID_CatsReferral(), null, patientID, null, null, rieMessage);
		}
		
		// Mark as RIE the Linked Cats Referral record
		factory.markAsRie(LinkedCatsReferral.class, linkedReferral.getID_LinkedCatsReferral(), null, patientID, null, null, rieMessage);

		return true;
	}
}
