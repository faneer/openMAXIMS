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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41119.1700)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.MedicationList;
import ims.core.domain.impl.MedicationListImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.MedicationLiteVoCollection;
import ims.core.vo.domain.HcpAssembler;
import ims.domain.exceptions.DomainException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.nursing.assessment.domain.objects.AccommodationandPropertyComponent;
import ims.nursing.assessment.domain.objects.AdmissionAssessment;
import ims.nursing.assessment.domain.objects.BreathingComponent;
import ims.nursing.assessment.domain.objects.CleansingandDressingComponent;
import ims.nursing.assessment.domain.objects.NurBladderComponent;
import ims.nursing.assessment.domain.objects.NurBowelComponent;
import ims.nursing.assessment.domain.objects.NurCommunicationComponent;
import ims.nursing.assessment.domain.objects.NurEatingComponent;
import ims.nursing.assessment.domain.objects.NurMobilityComponent;
import ims.nursing.assessment.domain.objects.PersonalDetailsComponent;
import ims.nursing.assessment.domain.objects.SafeEnvironmentComponent;
import ims.nursing.assessment.domain.objects.SkinComponent;
import ims.nursing.assessment.vo.AssessmentComponentRefVo;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentComponentCollection;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.AssessmentInfo;
import ims.nursing.vo.AssessmentInfoCollection;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.domain.AssessmentComponentAssembler;
import ims.nursing.vo.domain.AssessmentHeaderInfoAssembler;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.nursing.vo.lookups.AssessmentInformationStatus;
import ims.nursing.vo.lookups.AssessmentStatus;
import ims.spinalinjuries.vo.NurAssessmentAccommodationPropertyVo;
import ims.spinalinjuries.vo.NurAssessmentBladderVo;
import ims.spinalinjuries.vo.NurAssessmentBowelsVo;
import ims.spinalinjuries.vo.NurAssessmentBreathingVo;
import ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo;
import ims.spinalinjuries.vo.NurAssessmentCommunicationVo;
import ims.spinalinjuries.vo.NurAssessmentEatingVo;
import ims.spinalinjuries.vo.NurAssessmentMobilityVo;
import ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo;
import ims.spinalinjuries.vo.NurAssessmentSafeEnvironmentVo;
import ims.spinalinjuries.vo.NurAssessmentSkinVo;
import ims.spinalinjuries.vo.domain.NurAssessmentAccommodationPropertyVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentBladderVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentBowelsVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentBreathingVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentCleansingDressingVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentEatingVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentMobilityVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentCommunicationVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentPersonalDetailsVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentSafeEnvironmentVoAssembler;
import ims.spinalinjuries.vo.domain.NurAssessmentSkinVoAssembler;

public class NurAssessmentComponentImpl extends DomainImpl implements 	ims.spinalinjuries.domain.NurAssessmentAccommodationProperty, 
																		ims.spinalinjuries.domain.NurAssessmentBreathing, 
																		ims.spinalinjuries.domain.NurAssessmentMobility,
																		ims.spinalinjuries.domain.NurAssessmentCommunication,
																		ims.spinalinjuries.domain.NurAssessmentPersonalDetails,
																		ims.spinalinjuries.domain.NurAssessmentSafeEnvironement,
																		ims.spinalinjuries.domain.NurAssessmentBowels,
																		ims.spinalinjuries.domain.NurAssessmentSkin,
																		ims.spinalinjuries.domain.NurAssessmentBladder,
																		ims.spinalinjuries.domain.NurAssessmentCleansing,
																		ims.spinalinjuries.domain.NurAssessmentEating,
																		ims.domain.impl.Transactional
{
	
	public AssessmentHeaderInfo saveComponent(AssessmentHeaderInfo assessment, AssessmentComponent component) throws StaleObjectException
	{
		//Ensure that the value object has been validated
		if (!component.isValidated())
			throw new DomainRuntimeException("Assessment Component has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		AdmissionAssessment domAssmnt = null;	
		
		//Convert from VO to Domain Object
		domAssmnt = AssessmentHeaderInfoAssembler.extractAdmissionAssessment(factory, assessment);			
		factory.save(domAssmnt);
		
		// The assessment is now persistant, we now want to save the component
		// We want to add another assessinfo record on this save too
		
		AssessmentInfoCollection infColl = component.getAssessmentInfo();
		if (infColl == null)
		{
			infColl = new AssessmentInfoCollection();
			component.setAssessmentInfo(infColl);
		}
		AssessmentInfo info = new AssessmentInfo();
		info.setHCP((ims.core.vo.HcpLiteVo)getHcpLiteUser());
		AssessmentInformationStatus inf;
		if (infColl.size() == 0)
			// New Component, set info status to new
			inf = AssessmentInformationStatus.NEW;
		else
		{
			if (Boolean.TRUE.equals(component.getIsComplete()))
				// Complete component, set info status to complete
				inf = AssessmentInformationStatus.COMPLETE;
			else
				// Incomplete component, set info status to incomplete
				inf = AssessmentInformationStatus.INCOMPLETE;
		}
		info.setStatus(inf);
		info.setDateTime(new ims.framework.utils.DateTime());	
		infColl.add(info);		
		
		try
		{
			if (component instanceof NurAssessmentAccommodationPropertyVo)
			{
				// If this is a news component, we need to ensure that there isn't already a
				// component of this type for the current assessment
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_ACCOMODATION);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}
				NurAssessmentAccommodationPropertyVo voAccomProp = (NurAssessmentAccommodationPropertyVo)component;
			
				AccommodationandPropertyComponent doAccomProp = NurAssessmentAccommodationPropertyVoAssembler.extractAccommodationandPropertyComponent(factory, voAccomProp);
				doAccomProp.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_ACCOMODATION.getId()));
				doAccomProp.setAssessment(domAssmnt);
				factory.save(doAccomProp);
				component.setID_AssessmentComponent(doAccomProp.getId());
				
			}
			else if(component instanceof NurAssessmentBreathingVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_BREATHING);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}
				
				NurAssessmentBreathingVo voBreathing = (NurAssessmentBreathingVo)component;

				BreathingComponent doBreathing = NurAssessmentBreathingVoAssembler.extractBreathingComponent(factory, voBreathing);
				
				doBreathing.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_BREATHING.getId()));
				doBreathing.setAssessment(domAssmnt);
				factory.save(doBreathing);
				component.setID_AssessmentComponent(doBreathing.getId());	
			}
			else if(component instanceof NurAssessmentMobilityVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_MOBILITY);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}
	
				NurAssessmentMobilityVo voMobility = (NurAssessmentMobilityVo)component;

				NurMobilityComponent doMobility = NurAssessmentMobilityVoAssembler.extractNurMobilityComponent(factory, voMobility);
	
				doMobility.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_MOBILITY.getId()));
				doMobility.setAssessment(domAssmnt);
				factory.save(doMobility);
				component.setID_AssessmentComponent(doMobility.getId());	
			}
			else if(component instanceof NurAssessmentCommunicationVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_COMMUNICATION);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentCommunicationVo voCommunication = (NurAssessmentCommunicationVo)component;
				NurCommunicationComponent doCommunication = NurAssessmentCommunicationVoAssembler.extractNurCommunicationComponent(factory, voCommunication);
				
				doCommunication.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_COMMUNICATION.getId()));
				doCommunication.setAssessment(domAssmnt);
				factory.save(doCommunication);
				component.setID_AssessmentComponent(doCommunication.getId());	
			}
			else if(component instanceof NurAssessmentSafeEnvironmentVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_SAFE_ENVIRONMENT);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentSafeEnvironmentVo voEnvironment = (NurAssessmentSafeEnvironmentVo)component;

				SafeEnvironmentComponent doSafeEnvironment = NurAssessmentSafeEnvironmentVoAssembler.extractSafeEnvironmentComponent(factory, voEnvironment);

				doSafeEnvironment.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_SAFE_ENVIRONMENT.getId()));
				doSafeEnvironment.setAssessment(domAssmnt);
				factory.save(doSafeEnvironment);
				component.setID_AssessmentComponent(doSafeEnvironment.getId());	
			}
			else if(component instanceof NurAssessmentPersonalDetailsVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_PERSONAL_DETAILS);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentPersonalDetailsVo voPersonalDetails = (NurAssessmentPersonalDetailsVo)component;

				PersonalDetailsComponent doPersonalDetails = NurAssessmentPersonalDetailsVoAssembler.extractPersonalDetailsComponent(factory, voPersonalDetails);

				doPersonalDetails.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_PERSONAL_DETAILS.getId()));
				doPersonalDetails.setAssessment(domAssmnt);
				factory.save(doPersonalDetails);
				component.setID_AssessmentComponent(doPersonalDetails.getId());	
			}
			else if(component instanceof NurAssessmentBowelsVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_BOWELS);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentBowelsVo voBowels = (NurAssessmentBowelsVo)component;

				NurBowelComponent doBowels = NurAssessmentBowelsVoAssembler.extractNurBowelComponent(factory, voBowels);

				doBowels.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_BOWELS.getId()));
				doBowels.setAssessment(domAssmnt);
				factory.save(doBowels);
				component.setID_AssessmentComponent(doBowels.getId());	
			}
			else if(component instanceof NurAssessmentSkinVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_SKIN);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentSkinVo voSkin = (NurAssessmentSkinVo)component;

				SkinComponent doSkin = NurAssessmentSkinVoAssembler.extractSkinComponent(factory, voSkin);

				doSkin.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_SKIN.getId()));
				doSkin.setAssessment(domAssmnt);
				factory.save(doSkin);
				component.setID_AssessmentComponent(doSkin.getId());	
			}
			else if(component instanceof NurAssessmentBladderVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_BLADDER);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentBladderVo voBladder = (NurAssessmentBladderVo)component;

				NurBladderComponent doBladder = NurAssessmentBladderVoAssembler.extractNurBladderComponent(factory, voBladder);

				doBladder.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_BLADDER.getId()));
				doBladder.setAssessment(domAssmnt);
				factory.save(doBladder);
				component.setID_AssessmentComponent(doBladder.getId());	
			}
			else if(component instanceof NurAssessmentCleansingDressingVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_CLEANSING);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
				}

				NurAssessmentCleansingDressingVo voCleansing = (NurAssessmentCleansingDressingVo)component;

				CleansingandDressingComponent doCleansing = NurAssessmentCleansingDressingVoAssembler.extractCleansingandDressingComponent(factory, voCleansing);

				doCleansing.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_CLEANSING.getId()));
				doCleansing.setAssessment(domAssmnt);
				factory.save(doCleansing);
				component.setID_AssessmentComponent(doCleansing.getId());	
			}
			else if(component instanceof NurAssessmentEatingVo)
			{
				if (inf == AssessmentInformationStatus.NEW)
				{
					 java.util.List components = checkExisting(factory, domAssmnt, AssessmentComponentType.SPINAL_EATING);		
					 if (components != null && !components.isEmpty())
						 throw new DomainRuntimeException("A Component of this type already exists for the assessment");
						// throw new StaleObjectException((ims.domain.DomainObject)components.get(0), "A Component of this type already exists for the assessment");
				}

				NurAssessmentEatingVo voEat = (NurAssessmentEatingVo)component;

				NurEatingComponent doEat = NurAssessmentEatingVoAssembler.extractNurEatingComponent(factory, voEat);

				doEat.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.SPINAL_EATING.getId()));
				doEat.setAssessment(domAssmnt);
				factory.save(doEat);
				component.setID_AssessmentComponent(doEat.getId());	
			}
			else
				throw new DomainRuntimeException("Invalid Component Instance Specified");
		}
		catch(StaleObjectException e)
		{
			throw e;
		}
		catch(DomainException dex) 
		{
			if(component.getComponentType() != null)
				throw new DomainRuntimeException("Failed to Create Assessment Component Type " + component.getComponentType().getText() + "\r\n" + dex.getMessage(), dex);
			else
				throw new DomainRuntimeException("Failed to Create Assessment Component Type " + dex.getMessage(), dex);
		}
		
		// When saving the component, if the status is complete
		// we need to check for any other components with
		// a status incomplete.  If none found, we need to complete
		// the overall assessment
		factory.save(domAssmnt);
		factory.refresh(domAssmnt);
		if (checkCompleteAssessment(domAssmnt))
		{
			domAssmnt.setDateTimeComplete(new java.util.Date());				
			domAssmnt.setHCPComplete(HcpAssembler.extractHcp(factory,(ims.core.vo.Hcp)getHcpUser()));					
			domAssmnt.setAssessmentStatus(factory.getLookupInstance(AssessmentStatus.TYPE_ID, AssessmentStatus.COMPLETE.getId()));
		}
		factory.save(domAssmnt);

		ims.nursing.vo.AssessmentHeaderInfo header = AssessmentHeaderInfoAssembler.create(domAssmnt);
		header.setCurrentComponent(component);
		
		return header;
	}
	
	private boolean checkCompleteAssessment(AdmissionAssessment assmnt) 
	{
		Set comps = assmnt.getComponents();
		if (comps.size() < (ConfigFlag.DOM.ASSESSMENT_COMPONENT_NO.getValue())) 
			return false;
		
		int numberOfCompleteAssessment = 0;
		Iterator iter = comps.iterator();
		ims.nursing.assessment.domain.objects.AssessmentComponent comp;
		
		while (iter.hasNext())
		{
			comp = (ims.nursing.assessment.domain.objects.AssessmentComponent)iter.next();
			
			if(comp.isIsComplete() != null && comp.isIsComplete().booleanValue() == true)
			{
				numberOfCompleteAssessment++;
				
				if(numberOfCompleteAssessment >= ConfigFlag.DOM.ASSESSMENT_COMPONENT_NO.getValue())
					return true;
			}
		}
		
		return false;
	}

	/**
	 * Checks for incomplete assessment components for this assessment
	 * if only one found - the current one, we want to update the
	 * assessment status to complete
	 * @param assmnt
	 * @return true to update the assessment, false otherwise
	 */
	public boolean completeAssessment(AdmissionAssessment assmnt)
	{
		Set comps = assmnt.getComponents();
		if (comps.size() < (ConfigFlag.DOM.ASSESSMENT_COMPONENT_NO.getValue())) 
			return false;
		
		Iterator iter = comps.iterator();
		ims.nursing.assessment.domain.objects.AssessmentComponent comp;
		while (iter.hasNext())
		{
			comp = (ims.nursing.assessment.domain.objects.AssessmentComponent)iter.next();
			if (comp.isIsComplete() == null || comp.isIsComplete().booleanValue() == false) 
				return false;
		}
		return true;
	}

	/**
	 * Method to check whether a component of a particular type already exists for the assessment
	 * @param factory
	 * @param assmnt
	 * @param componentType
	 * @return
	 */
	private java.util.List checkExisting(DomainFactory factory, AdmissionAssessment assmnt, AssessmentComponentType componentType)
	{
		StringBuffer hql = new StringBuffer("from ims.nursing.assessment.domain.objects.AssessmentComponent this ");
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where this.assessment.id = :assessment");
		markers.add("assessment");
		values.add(assmnt.getId());
		hql.append(" and this.componentType = :compType");
		markers.add("compType");
		values.add(getDomLookup(componentType));
		hql.append(" and this.isRIE is null");
		return(factory.find(hql.toString(), markers, values));		
	}
	
	/* (non-Javadoc)
	 * @see ims.spinalinjuries.domain.NurAssessmentBreathing#listCarePlanTemplates(ims.nursing.vo.lookups.AssessmentComponentType)
	 */
	public CarePlanTemplateTitleCollection listCarePlanTemplates(AssessmentComponentType componentType) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = "from CarePlanTemplate t " +
				" where t.assessmentComponent = :compType" + 
				" and t.active = :isActive";
		java.util.List templates = factory.find(hql, new String[]{"compType", "isActive"}, new Object[]{getDomLookup(componentType), Boolean.TRUE});
		return (ims.nursing.vo.domain.CarePlanTemplateTitleAssembler.createCarePlanTemplateTitleCollectionFromCarePlanTemplate(templates));
	}
	
	public AssessmentComponent getComponent(AssessmentComponentRefVo voRefAssessComp)
	{
		DomainFactory factory = getDomainFactory();		
		ims.nursing.assessment.domain.objects.AssessmentComponent comp = (ims.nursing.assessment.domain.objects.AssessmentComponent) factory.getDomainObject(ims.nursing.assessment.domain.objects.AssessmentComponent.class, voRefAssessComp.getID_AssessmentComponent());
		
		if (comp instanceof AccommodationandPropertyComponent)
			return NurAssessmentAccommodationPropertyVoAssembler.create((AccommodationandPropertyComponent)comp);
		else if (comp instanceof BreathingComponent)
			return NurAssessmentBreathingVoAssembler.create((BreathingComponent)comp);
		else if (comp instanceof NurMobilityComponent)
			return NurAssessmentMobilityVoAssembler.create((NurMobilityComponent)comp);
		else if (comp instanceof NurCommunicationComponent)
			return NurAssessmentCommunicationVoAssembler.create((NurCommunicationComponent) comp);
		else if (comp instanceof SafeEnvironmentComponent)
			return NurAssessmentSafeEnvironmentVoAssembler.create((SafeEnvironmentComponent) comp);
		else if (comp instanceof PersonalDetailsComponent)
			return NurAssessmentPersonalDetailsVoAssembler.create((PersonalDetailsComponent) comp);
		else if (comp instanceof NurBowelComponent)
			return NurAssessmentBowelsVoAssembler.create((NurBowelComponent) comp);
		else if (comp instanceof SkinComponent)
			return NurAssessmentSkinVoAssembler.create((SkinComponent) comp);
		else if (comp instanceof NurBladderComponent)
			return NurAssessmentBladderVoAssembler.create((NurBladderComponent) comp);
		else if (comp instanceof CleansingandDressingComponent)
			return NurAssessmentCleansingDressingVoAssembler.create((CleansingandDressingComponent) comp);
		else if (comp instanceof NurEatingComponent)
			return NurAssessmentEatingVoAssembler.create((NurEatingComponent) comp);
		else
		{	
			throw new DomainRuntimeException("Invalid Assessment Component Type Specified (" + comp.getComponentType().toString()+ ")in AssessmentComponentImpl.getComponent");
		}
	}

	public AssessmentComponent getLastAssessmentComponentByCareContext(CareContextShortVo voCareContext, AssessmentComponentType assessmentComponentType)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = "select asmntComp " +
				" from ims.nursing.assessment.domain.objects.AssessmentComponent asmntComp " +
				" where asmntComp.assessment.careContext.episodeOfCare.id = :episodeID" +
				" and asmntComp.componentType = :compType"+ 
				" and asmntComp.isRIE is null"+
				" order by asmntComp.id desc";

		java.util.List components = factory.find(hql, new String[]{"episodeID", "compType"}, new Object[]{voCareContext.getEpisodeOfCare().getID_EpisodeOfCare(), getDomLookup(assessmentComponentType)});
		if ( components != null && ! components.isEmpty()) 
		{
			ims.nursing.assessment.domain.objects.AssessmentComponent comp = (ims.nursing.assessment.domain.objects.AssessmentComponent) components.get(0);
			AssessmentComponent copyComp = getComponent(AssessmentComponentAssembler.create(comp));
			copyComp.setAssessmentInfo(null);
			copyComp.setID_AssessmentComponent(null);
			return (copyComp);				
		}
		
		return null;	
	}

	public MedicationLiteVoCollection listMedication(String filterMedication)
	{
		MedicationList impl = (MedicationList) getDomainImpl(MedicationListImpl.class);
		try {
			return impl.listActiveMedication(filterMedication);
		} catch (DomainInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	public AssessmentComponent getAssessComponent(Integer admissionAssessId, AssessmentComponentType comptype) 
	{
		if(admissionAssessId == null || comptype == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "select a1_1 from AssessmentComponent as a1_1 left join a1_1.assessment as a2_1 where (a2_1.id = :admassesID and a1_1.componentType = :compType) and a1_1.isRIE is null";

		java.util.List components = factory.find(hql, new String[]{"admassesID", "compType"}, new Object[]{admissionAssessId,getDomLookup(comptype)});
	
		if ( components != null && ! components.isEmpty()) 
		{
			ims.nursing.assessment.domain.objects.AssessmentComponent comp = (ims.nursing.assessment.domain.objects.AssessmentComponent) components.get(0);
			AssessmentComponent copyComp = getComponent(AssessmentComponentAssembler.create(comp));
			return (copyComp);				
		}
				
		return null;	

	}

	
	public AssessmentHeaderInfo getAssessmentHeaderInfoByCareContext(CareContextRefVo voCareContextRef) 
	{
			
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from AdmissionAssessment t ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		String andStr = " ";

		if (voCareContextRef != null)
		{
			hql.append(andStr + " t.careContext.id = :care");
			markers.add("care");
			values.add(voCareContextRef.getID_CareContext());
			andStr = " and ";
			hql.append(andStr + " t.isRIE is null");
			
		}

		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		List headerInfoList = factory.find(query, markers, values);	
		if (headerInfoList != null && headerInfoList.size() > 0) 
		{
			AssessmentHeaderInfo voAssmnt = AssessmentHeaderInfoAssembler.create((AdmissionAssessment) headerInfoList.get(0));
			return voAssmnt;
		}
		else
			return null;
	}
}
