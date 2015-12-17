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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.clinical.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Peter Martin
 */
public class PatientCaseConferenceVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.PatientCaseConferenceVo copy(ims.clinical.vo.PatientCaseConferenceVo valueObjectDest, ims.clinical.vo.PatientCaseConferenceVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatientCaseConference(valueObjectSrc.getID_PatientCaseConference());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// CaseConfDate
		valueObjectDest.setCaseConfDate(valueObjectSrc.getCaseConfDate());
		// isDischargeCaseConf
		valueObjectDest.setIsDischargeCaseConf(valueObjectSrc.getIsDischargeCaseConf());
		// CaseConfOutCome
		valueObjectDest.setCaseConfOutCome(valueObjectSrc.getCaseConfOutCome());
		// CancellationReason
		valueObjectDest.setCancellationReason(valueObjectSrc.getCancellationReason());
		// Comments
		valueObjectDest.setComments(valueObjectSrc.getComments());
		// DischargeDelayValue
		valueObjectDest.setDischargeDelayValue(valueObjectSrc.getDischargeDelayValue());
		// DischargeDelayUnit
		valueObjectDest.setDischargeDelayUnit(valueObjectSrc.getDischargeDelayUnit());
		// PredictedNextCaseConf
		valueObjectDest.setPredictedNextCaseConf(valueObjectSrc.getPredictedNextCaseConf());
		// PredicatedDischargeDate
		valueObjectDest.setPredicatedDischargeDate(valueObjectSrc.getPredicatedDischargeDate());
		// Minutes
		valueObjectDest.setMinutes(valueObjectSrc.getMinutes());
		// MOSStatus
		valueObjectDest.setMOSStatus(valueObjectSrc.getMOSStatus());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatientCaseConferenceVoCollectionFromPatientCaseConference(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.PatientCaseConference objects.
	 */
	public static ims.clinical.vo.PatientCaseConferenceVoCollection createPatientCaseConferenceVoCollectionFromPatientCaseConference(java.util.Set domainObjectSet)	
	{
		return createPatientCaseConferenceVoCollectionFromPatientCaseConference(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.PatientCaseConference objects.
	 */
	public static ims.clinical.vo.PatientCaseConferenceVoCollection createPatientCaseConferenceVoCollectionFromPatientCaseConference(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.PatientCaseConferenceVoCollection voList = new ims.clinical.vo.PatientCaseConferenceVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.PatientCaseConference domainObject = (ims.clinical.domain.objects.PatientCaseConference) iterator.next();
			ims.clinical.vo.PatientCaseConferenceVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.clinical.domain.objects.PatientCaseConference objects.
	 */
	public static ims.clinical.vo.PatientCaseConferenceVoCollection createPatientCaseConferenceVoCollectionFromPatientCaseConference(java.util.List domainObjectList) 
	{
		return createPatientCaseConferenceVoCollectionFromPatientCaseConference(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.PatientCaseConference objects.
	 */
	public static ims.clinical.vo.PatientCaseConferenceVoCollection createPatientCaseConferenceVoCollectionFromPatientCaseConference(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.PatientCaseConferenceVoCollection voList = new ims.clinical.vo.PatientCaseConferenceVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.PatientCaseConference domainObject = (ims.clinical.domain.objects.PatientCaseConference) domainObjectList.get(i);
			ims.clinical.vo.PatientCaseConferenceVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.clinical.domain.objects.PatientCaseConference set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatientCaseConferenceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVoCollection voCollection) 
	 {
	 	return extractPatientCaseConferenceSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatientCaseConferenceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.PatientCaseConferenceVo vo = voCollection.get(i);
			ims.clinical.domain.objects.PatientCaseConference domainObject = PatientCaseConferenceVoAssembler.extractPatientCaseConference(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.clinical.domain.objects.PatientCaseConference list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatientCaseConferenceList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVoCollection voCollection) 
	 {
	 	return extractPatientCaseConferenceList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatientCaseConferenceList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.PatientCaseConferenceVo vo = voCollection.get(i);
			ims.clinical.domain.objects.PatientCaseConference domainObject = PatientCaseConferenceVoAssembler.extractPatientCaseConference(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.clinical.domain.objects.PatientCaseConference object.
	 * @param domainObject ims.clinical.domain.objects.PatientCaseConference
	 */
	 public static ims.clinical.vo.PatientCaseConferenceVo create(ims.clinical.domain.objects.PatientCaseConference domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.PatientCaseConference object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.PatientCaseConferenceVo create(DomainObjectMap map, ims.clinical.domain.objects.PatientCaseConference domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.PatientCaseConferenceVo valueObject = (ims.clinical.vo.PatientCaseConferenceVo) map.getValueObject(domainObject, ims.clinical.vo.PatientCaseConferenceVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.PatientCaseConferenceVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.PatientCaseConference
	 */
	 public static ims.clinical.vo.PatientCaseConferenceVo insert(ims.clinical.vo.PatientCaseConferenceVo valueObject, ims.clinical.domain.objects.PatientCaseConference domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.PatientCaseConference
	 */
	 public static ims.clinical.vo.PatientCaseConferenceVo insert(DomainObjectMap map, ims.clinical.vo.PatientCaseConferenceVo valueObject, ims.clinical.domain.objects.PatientCaseConference domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatientCaseConference(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// ClinicalContact
		valueObject.setClinicalContact(ims.core.vo.domain.ClinicalContactShortVoAssembler.create(map, domainObject.getClinicalContact()) );
		// CaseConfDate
		java.util.Date CaseConfDate = domainObject.getCaseConfDate();
		if ( null != CaseConfDate ) 
		{
			valueObject.setCaseConfDate(new ims.framework.utils.Date(CaseConfDate) );
		}
		// isDischargeCaseConf
		valueObject.setIsDischargeCaseConf( domainObject.isIsDischargeCaseConf() );
		// CaseConfOutCome
		ims.domain.lookups.LookupInstance instance4 = domainObject.getCaseConfOutCome();
		if ( null != instance4 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance4.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance4.getImage().getImageId(), instance4.getImage().getImagePath());
			}
			color = instance4.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.CaseConferenceOutcome voLookup4 = new ims.clinical.vo.lookups.CaseConferenceOutcome(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.clinical.vo.lookups.CaseConferenceOutcome parentVoLookup4 = voLookup4;
			ims.domain.lookups.LookupInstance parent4 = instance4.getParent();
			while (parent4 != null)
			{
				if (parent4.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent4.getImage().getImageId(), parent4.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent4.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup4.setParent(new ims.clinical.vo.lookups.CaseConferenceOutcome(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setCaseConfOutCome(voLookup4);
		}
				// CancellationReason
		ims.domain.lookups.LookupInstance instance5 = domainObject.getCancellationReason();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.CaseConferenceOutcome voLookup5 = new ims.clinical.vo.lookups.CaseConferenceOutcome(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.clinical.vo.lookups.CaseConferenceOutcome parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.clinical.vo.lookups.CaseConferenceOutcome(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setCancellationReason(voLookup5);
		}
				// Comments
		valueObject.setComments(domainObject.getComments());
		// DischargeDelayValue
		valueObject.setDischargeDelayValue(domainObject.getDischargeDelayValue());
		// DischargeDelayUnit
		ims.domain.lookups.LookupInstance instance8 = domainObject.getDischargeDelayUnit();
		if ( null != instance8 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance8.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance8.getImage().getImageId(), instance8.getImage().getImagePath());
			}
			color = instance8.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.TimeDaystoYears voLookup8 = new ims.core.vo.lookups.TimeDaystoYears(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.TimeDaystoYears parentVoLookup8 = voLookup8;
			ims.domain.lookups.LookupInstance parent8 = instance8.getParent();
			while (parent8 != null)
			{
				if (parent8.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent8.getImage().getImageId(), parent8.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent8.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup8.setParent(new ims.core.vo.lookups.TimeDaystoYears(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setDischargeDelayUnit(voLookup8);
		}
				// PredictedNextCaseConf
		Integer PredictedNextCaseConf = domainObject.getPredictedNextCaseConf();
		if ( null != PredictedNextCaseConf ) 
		{
			valueObject.setPredictedNextCaseConf(new ims.framework.utils.PartialDate(PredictedNextCaseConf) );
		}
		// PredicatedDischargeDate
		Integer PredicatedDischargeDate = domainObject.getPredicatedDischargeDate();
		if ( null != PredicatedDischargeDate ) 
		{
			valueObject.setPredicatedDischargeDate(new ims.framework.utils.PartialDate(PredicatedDischargeDate) );
		}
		// Minutes
		valueObject.setMinutes(domainObject.getMinutes());
		// MOSStatus
		valueObject.setMOSStatus(ims.clinical.vo.domain.CaseConfMOSStatusVoAssembler.createCaseConfMOSStatusVoCollectionFromCaseConfMOSStatus(map, domainObject.getMOSStatus()) );
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.PatientCaseConference extractPatientCaseConference(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVo valueObject) 
	{
		return 	extractPatientCaseConference(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.PatientCaseConference extractPatientCaseConference(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientCaseConferenceVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatientCaseConference();
		ims.clinical.domain.objects.PatientCaseConference domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.PatientCaseConference)domMap.get(valueObject);
			}
			// ims.clinical.vo.PatientCaseConferenceVo ID_PatientCaseConference field is unknown
			domainObject = new ims.clinical.domain.objects.PatientCaseConference();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatientCaseConference());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.PatientCaseConference)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.PatientCaseConference) domainFactory.getDomainObject(ims.clinical.domain.objects.PatientCaseConference.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatientCaseConference());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.ClinicalContact value1 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value1 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else
			{
				value1 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value1);
		java.util.Date value2 = null;
		ims.framework.utils.Date date2 = valueObject.getCaseConfDate();		
		if ( date2 != null ) 
		{
			value2 = date2.getDate();
		}
		domainObject.setCaseConfDate(value2);
		domainObject.setIsDischargeCaseConf(valueObject.getIsDischargeCaseConf());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getCaseConfOutCome() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getCaseConfOutCome().getID());
		}
		domainObject.setCaseConfOutCome(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getCancellationReason() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getCancellationReason().getID());
		}
		domainObject.setCancellationReason(value5);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComments() != null && valueObject.getComments().equals(""))
		{
			valueObject.setComments(null);
		}
		domainObject.setComments(valueObject.getComments());
		domainObject.setDischargeDelayValue(valueObject.getDischargeDelayValue());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getDischargeDelayUnit() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getDischargeDelayUnit().getID());
		}
		domainObject.setDischargeDelayUnit(value8);
		ims.framework.utils.PartialDate PredictedNextCaseConf = valueObject.getPredictedNextCaseConf();
		Integer value9 = null;
		if ( null != PredictedNextCaseConf ) 
		{
			value9 = PredictedNextCaseConf.toInteger();
		}
		domainObject.setPredictedNextCaseConf(value9);
		ims.framework.utils.PartialDate PredicatedDischargeDate = valueObject.getPredicatedDischargeDate();
		Integer value10 = null;
		if ( null != PredicatedDischargeDate ) 
		{
			value10 = PredicatedDischargeDate.toInteger();
		}
		domainObject.setPredicatedDischargeDate(value10);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getMinutes() != null && valueObject.getMinutes().equals(""))
		{
			valueObject.setMinutes(null);
		}
		domainObject.setMinutes(valueObject.getMinutes());
		domainObject.setMOSStatus(ims.clinical.vo.domain.CaseConfMOSStatusVoAssembler.extractCaseConfMOSStatusSet(domainFactory, valueObject.getMOSStatus(), domainObject.getMOSStatus(), domMap));		
		ims.core.admin.domain.objects.CareContext value13 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value13 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value13 = domainObject.getCareContext();	
			}
			else
			{
				value13 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value13);

		return domainObject;
	}

}
