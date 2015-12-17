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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.20 build 40824.905)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.nursing.assessment.domain.objects.AdmissionAssessment;
import ims.nursing.assessment.domain.objects.EatingComponent;
import ims.nursing.vo.MiniNutritionalAssessment;
import ims.coe.vo.AssessmentEatingAndDrinking;
import ims.coe.vo.MnaEnhancedVo;
import ims.coe.vo.domain.AssessmentEatingAndDrinkingAssembler;
import ims.nursing.vo.domain.AssessmentHeaderInfoAssembler;
import ims.nursing.vo.domain.MiniNutritionalAssessmentAssembler;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.nursing.vo.lookups.AssessmentInformationStatus;
import ims.nursing.vo.lookups.AssessmentStatus;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.VitalSignsAll;
import ims.core.domain.VitalSignsMetrics;
import ims.core.domain.impl.VitalSignsImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.domain.HcpAssembler;
import ims.domain.exceptions.DomainException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.AssessmentInfo;
import ims.nursing.vo.AssessmentInfoCollection;

public class MNAInputImpl extends DomainImpl implements ims.nursing.domain.MNAInput, ims.domain.impl.Transactional
{
	/**
	* get MiniNutritionalAssessment Record
	*/
	public ims.nursing.vo.MiniNutritionalAssessment getRecord(Integer recordID)
	{
		DomainFactory factory = getDomainFactory();
		
		ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domAssess = (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment)factory.getDomainObject(ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment.class, recordID);
		return(MiniNutritionalAssessmentAssembler.create(domAssess));
	}
	
	/**
	* check if Part of Eating Assessment
	*/
	public Boolean isPartOfEatingAssessment(MiniNutritionalAssessment mnaRecord)
			throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		
		ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domMna = MiniNutritionalAssessmentAssembler.extractMiniNutritionalAssessment(factory, mnaRecord);
		java.util.List mnas = factory.find("from EatingComponent E where E.miniNutritionalAssessment = :mna", "mna", domMna);
		
		if(mnas == null || mnas.size() == 0)
			return Boolean.FALSE;
		
		return Boolean.TRUE;
	}

	/**
	* save MiniNutritionalAssessment Record
	*/
	public MiniNutritionalAssessment saveRecord(MiniNutritionalAssessment voMiniNutritionalAssessment) throws DomainInterfaceException, StaleObjectException 
	{
		// Ensure the Value Object was validated
		if (!voMiniNutritionalAssessment.isValidated())
			throw new DomainRuntimeException("This FallAssessment has not been validated");
			
		DomainFactory factory = getDomainFactory();			
		ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domAssessment = MiniNutritionalAssessmentAssembler.extractMiniNutritionalAssessment(factory, voMiniNutritionalAssessment);

		factory.save(domAssessment);
			
		return MiniNutritionalAssessmentAssembler.create(domAssessment);	
		
		
	}

	/**
	* gets last Metrics
	*/
	public VitalSignsVo getLastMetrics(CareContextRefVo careContext) throws DomainInterfaceException
	{
		VitalSignsMetrics vitalImpl = (VitalSignsMetrics)getDomainImpl(VitalSignsImpl.class);
		return vitalImpl.getLastMetrics(careContext);
	}
	
	/**
	* insert Metrics record
	*/
	public VitalSignsVo insertMetricsRecord(VitalSignsVo vitalSign) throws DomainInterfaceException, StaleObjectException 
	{
		VitalSignsAll vitalImpl = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vitalImpl.saveVitalSign(vitalSign);
	}




	/**
	* save Eating Assessment Component
	 * @throws UniqueKeyViolationException 
	*/
	public AssessmentHeaderInfo saveEatingAssessmentComponent(AssessmentHeaderInfo assessmentVo, AssessmentComponent componentVo, CareContextShortVo careContext) throws StaleObjectException, UniqueKeyViolationException 
	{
		return saveComponent(assessmentVo, componentVo);
	}

	
	private AssessmentHeaderInfo saveComponent(AssessmentHeaderInfo assessmentVo, AssessmentComponent componentVo) throws StaleObjectException, UniqueKeyViolationException 
	{
		// Ensure that the value object has been validated
		if (!componentVo.isValidated())
			throw new DomainRuntimeException("Assessment Component has not been validated");
		
		// Check if the assessment already exists, if not, create this then save the actual component
		DomainFactory factory = getDomainFactory();
		
		AdmissionAssessment domAssmnt = null;	

		//	Convert from VO to Domain Object
		domAssmnt = AssessmentHeaderInfoAssembler.extractAdmissionAssessment(factory, assessmentVo);			
		factory.save(domAssmnt);
			
		// The assessment is now persistant, we now want to save the component
		// We want to add another assessinfo record on this save too
		AssessmentInfoCollection voAssessInfoColl = componentVo.getAssessmentInfo();
		if (voAssessInfoColl == null)
			voAssessInfoColl = new AssessmentInfoCollection();	
		
		AssessmentInfo voAssessInfo = new AssessmentInfo();
		Object Object = getHcpLiteUser();
		HcpLiteVo hcpLiteVo = Object!=null?(HcpLiteVo)Object:null;
		
		voAssessInfo.setHCP(hcpLiteVo);
		
		AssessmentInformationStatus AssessInfoStatus;
		if (voAssessInfoColl.size() == 0)
			// New Component, set info status to new
			AssessInfoStatus = AssessmentInformationStatus.NEW;
		else
		{
			if (componentVo.getIsComplete().booleanValue() == true)
				// Complete component, set info status to complete
				AssessInfoStatus = AssessmentInformationStatus.COMPLETE;
			else
				// Incomplete component, set info status to incomplete
				AssessInfoStatus = AssessmentInformationStatus.INCOMPLETE;
		}
		voAssessInfo.setStatus(AssessInfoStatus);
		voAssessInfo.setDateTime(new ims.framework.utils.DateTime());	
		voAssessInfoColl.add(voAssessInfo);
		AssessmentEatingAndDrinking voAssessEat = (AssessmentEatingAndDrinking)componentVo;
		voAssessEat.setAssessmentInfo(voAssessInfoColl);
		EatingComponent doEatComp = AssessmentEatingAndDrinkingAssembler.extractEatingComponent(factory, voAssessEat);
		doEatComp.setComponentType(factory.getLookupInstance(AssessmentComponentType.TYPE_ID, AssessmentComponentType.EATING.getId()));
		doEatComp.setAssessment(domAssmnt);
		factory.save(doEatComp);
		componentVo.setID_AssessmentComponent(doEatComp.getId());
		// When saving the component, if the status is complete
		// we need to check for any other components with
		// a status incomplete.  If none found, we need to complete
		// the overall assessment
		if (domAssmnt.isAssessmentCompleted())
		{
			domAssmnt.setDateTimeComplete(new java.util.Date());				
			domAssmnt.setHCPComplete(HcpAssembler.extractHcp(factory,(ims.core.vo.Hcp)getHcpUser()));					
			domAssmnt.setAssessmentStatus(factory.getLookupInstance(AssessmentStatus.TYPE_ID, AssessmentStatus.COMPLETE.getId()));
		}
		factory.save(domAssmnt);
		ims.nursing.vo.AssessmentHeaderInfo header = AssessmentHeaderInfoAssembler.create(domAssmnt);
		componentVo.setAssessmentInfo(voAssessInfoColl);
		header.setCurrentComponent(componentVo);
		
		
		return header;
	}
	
	public MnaEnhancedVo saveAll(MnaEnhancedVo mnaEnhancedRecordVo,	CareContextShortVo careContext) throws DomainInterfaceException,StaleObjectException, UniqueKeyViolationException {
		// Ensure the Value Object was validated
		if (!mnaEnhancedRecordVo.isValidated())
			throw new DomainRuntimeException("This MnaEnhanced VO has not been validated");

		VitalSignsVo vs = null;
		if(mnaEnhancedRecordVo.getVsRecord() != null){
			vs = insertMetricsRecord(mnaEnhancedRecordVo.getVsRecord());
			if(vs!=null)
				mnaEnhancedRecordVo.getMnaRecord().setMetrics(vs.getMetrics());
		}
		
		mnaEnhancedRecordVo.getMnaRecord().validate();
		
		MiniNutritionalAssessment mna = saveRecord(mnaEnhancedRecordVo.getMnaRecord());
		AssessmentHeaderInfo headerInfo = null;
		
		if(mnaEnhancedRecordVo.getVsRecord() != null)
			insertMetricsRecord(mnaEnhancedRecordVo.getVsRecord());
		if(mnaEnhancedRecordVo.getAedRecord() != null)
		{
			mnaEnhancedRecordVo.getAedRecord().setMiniNutritionalAssessment(mna);
			mnaEnhancedRecordVo.getAedRecord().validate();
			headerInfo = saveEatingAssessmentComponent(mnaEnhancedRecordVo.getAshRecord(), mnaEnhancedRecordVo.getAedRecord(), careContext);
		}
		
		mnaEnhancedRecordVo.setMnaRecord(mna);
		mnaEnhancedRecordVo.setAshRecord(headerInfo);
		
		return mnaEnhancedRecordVo;
		
	}

	public AssessmentHeaderInfo saveEatingAssessmentComponent(AssessmentHeaderInfo assessmentVo, AssessmentComponent componentVo,ClinicalContactShortVo clinContactShortVo)	throws StaleObjectException, UniqueKeyViolationException, DomainInterfaceException {
		
		return saveComponent(assessmentVo, componentVo);
	}

	

	
}
