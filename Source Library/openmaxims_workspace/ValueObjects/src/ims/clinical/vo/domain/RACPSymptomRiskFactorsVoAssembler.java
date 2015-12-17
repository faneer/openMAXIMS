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
public class RACPSymptomRiskFactorsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.RACPSymptomRiskFactorsVo copy(ims.clinical.vo.RACPSymptomRiskFactorsVo valueObjectDest, ims.clinical.vo.RACPSymptomRiskFactorsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_RACPSymptomRiskFactors(valueObjectSrc.getID_RACPSymptomRiskFactors());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// SymptomIndicator
		valueObjectDest.setSymptomIndicator(valueObjectSrc.getSymptomIndicator());
		// Symptoms
		valueObjectDest.setSymptoms(valueObjectSrc.getSymptoms());
		// SymptomDuration
		valueObjectDest.setSymptomDuration(valueObjectSrc.getSymptomDuration());
		// SymptomNotes
		valueObjectDest.setSymptomNotes(valueObjectSrc.getSymptomNotes());
		// RiskFactorIndicator
		valueObjectDest.setRiskFactorIndicator(valueObjectSrc.getRiskFactorIndicator());
		// RiskFactors
		valueObjectDest.setRiskFactors(valueObjectSrc.getRiskFactors());
		// SmokingStatus
		valueObjectDest.setSmokingStatus(valueObjectSrc.getSmokingStatus());
		// AlcoholUnitsPerWeek
		valueObjectDest.setAlcoholUnitsPerWeek(valueObjectSrc.getAlcoholUnitsPerWeek());
		// DiabetesStatus
		valueObjectDest.setDiabetesStatus(valueObjectSrc.getDiabetesStatus());
		// OtherNotes
		valueObjectDest.setOtherNotes(valueObjectSrc.getOtherNotes());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// SymptomDurationUnit
		valueObjectDest.setSymptomDurationUnit(valueObjectSrc.getSymptomDurationUnit());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.RACPSymptomRiskFactors objects.
	 */
	public static ims.clinical.vo.RACPSymptomRiskFactorsVoCollection createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(java.util.Set domainObjectSet)	
	{
		return createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.RACPSymptomRiskFactors objects.
	 */
	public static ims.clinical.vo.RACPSymptomRiskFactorsVoCollection createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voList = new ims.clinical.vo.RACPSymptomRiskFactorsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject = (ims.clinical.domain.objects.RACPSymptomRiskFactors) iterator.next();
			ims.clinical.vo.RACPSymptomRiskFactorsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.RACPSymptomRiskFactors objects.
	 */
	public static ims.clinical.vo.RACPSymptomRiskFactorsVoCollection createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(java.util.List domainObjectList) 
	{
		return createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.RACPSymptomRiskFactors objects.
	 */
	public static ims.clinical.vo.RACPSymptomRiskFactorsVoCollection createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voList = new ims.clinical.vo.RACPSymptomRiskFactorsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject = (ims.clinical.domain.objects.RACPSymptomRiskFactors) domainObjectList.get(i);
			ims.clinical.vo.RACPSymptomRiskFactorsVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.RACPSymptomRiskFactors set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractRACPSymptomRiskFactorsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voCollection) 
	 {
	 	return extractRACPSymptomRiskFactorsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractRACPSymptomRiskFactorsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.RACPSymptomRiskFactorsVo vo = voCollection.get(i);
			ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject = RACPSymptomRiskFactorsVoAssembler.extractRACPSymptomRiskFactors(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.RACPSymptomRiskFactors list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractRACPSymptomRiskFactorsList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voCollection) 
	 {
	 	return extractRACPSymptomRiskFactorsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractRACPSymptomRiskFactorsList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.RACPSymptomRiskFactorsVo vo = voCollection.get(i);
			ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject = RACPSymptomRiskFactorsVoAssembler.extractRACPSymptomRiskFactors(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.RACPSymptomRiskFactors object.
	 * @param domainObject ims.clinical.domain.objects.RACPSymptomRiskFactors
	 */
	 public static ims.clinical.vo.RACPSymptomRiskFactorsVo create(ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.RACPSymptomRiskFactors object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.RACPSymptomRiskFactorsVo create(DomainObjectMap map, ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.RACPSymptomRiskFactorsVo valueObject = (ims.clinical.vo.RACPSymptomRiskFactorsVo) map.getValueObject(domainObject, ims.clinical.vo.RACPSymptomRiskFactorsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.RACPSymptomRiskFactorsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.RACPSymptomRiskFactors
	 */
	 public static ims.clinical.vo.RACPSymptomRiskFactorsVo insert(ims.clinical.vo.RACPSymptomRiskFactorsVo valueObject, ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.RACPSymptomRiskFactors
	 */
	 public static ims.clinical.vo.RACPSymptomRiskFactorsVo insert(DomainObjectMap map, ims.clinical.vo.RACPSymptomRiskFactorsVo valueObject, ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_RACPSymptomRiskFactors(domainObject.getId());
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
			
		// SymptomIndicator
		valueObject.setSymptomIndicator( domainObject.isSymptomIndicator() );
		// Symptoms
		valueObject.setSymptoms(ims.clinical.vo.domain.RACPSymptomsVoAssembler.createRACPSymptomsVoCollectionFromRACPSymptoms(map, domainObject.getSymptoms()) );
		// SymptomDuration
		ims.domain.lookups.LookupInstance instance3 = domainObject.getSymptomDuration();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.SymptomDuration voLookup3 = new ims.clinical.vo.lookups.SymptomDuration(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.clinical.vo.lookups.SymptomDuration parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.clinical.vo.lookups.SymptomDuration(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setSymptomDuration(voLookup3);
		}
				// SymptomNotes
		valueObject.setSymptomNotes(domainObject.getSymptomNotes());
		// RiskFactorIndicator
		valueObject.setRiskFactorIndicator( domainObject.isRiskFactorIndicator() );
		// RiskFactors
		java.util.List listRiskFactors = domainObject.getRiskFactors();
		ims.core.vo.lookups.RACPRiskFactorCollection RiskFactors = new ims.core.vo.lookups.RACPRiskFactorCollection();
		for(java.util.Iterator iterator = listRiskFactors.iterator(); iterator.hasNext(); ) 
		{
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;
		
			ims.domain.lookups.LookupInstance instance = 
				(ims.domain.lookups.LookupInstance) iterator.next();
			if (instance.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
			}
			else 
			{
				img = null;
			}
			color = instance.getColor();
			if (color != null) 
				color.getValue();
			ims.core.vo.lookups.RACPRiskFactor voInstance = new ims.core.vo.lookups.RACPRiskFactor(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.core.vo.lookups.RACPRiskFactor parentVoInstance = voInstance;
			ims.domain.lookups.LookupInstance parent = instance.getParent();
			while (parent != null)
			{
				if (parent.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent.getImage().getImageId(), parent.getImage().getImagePath());
				}
				else 
				{
					img = null;
				}
				color = parent.getColor();
				if (color != null) 
					color.getValue();
								parentVoInstance.setParent(new ims.core.vo.lookups.RACPRiskFactor(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			RiskFactors.add(voInstance);
		}
		valueObject.setRiskFactors( RiskFactors );
		// SmokingStatus
		valueObject.setSmokingStatus(ims.core.vo.domain.SmokingAssembler.create(map, domainObject.getSmokingStatus()) );
		// AlcoholUnitsPerWeek
		valueObject.setAlcoholUnitsPerWeek(ims.core.vo.domain.AlcoholVoAssembler.create(map, domainObject.getAlcoholUnitsPerWeek()) );
		// DiabetesStatus
		ims.domain.lookups.LookupInstance instance9 = domainObject.getDiabetesStatus();
		if ( null != instance9 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance9.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance9.getImage().getImageId(), instance9.getImage().getImagePath());
			}
			color = instance9.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.DiabetesStatus voLookup9 = new ims.clinical.vo.lookups.DiabetesStatus(instance9.getId(),instance9.getText(), instance9.isActive(), null, img, color);
			ims.clinical.vo.lookups.DiabetesStatus parentVoLookup9 = voLookup9;
			ims.domain.lookups.LookupInstance parent9 = instance9.getParent();
			while (parent9 != null)
			{
				if (parent9.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent9.getImage().getImageId(), parent9.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent9.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup9.setParent(new ims.clinical.vo.lookups.DiabetesStatus(parent9.getId(),parent9.getText(), parent9.isActive(), null, img, color));
				parentVoLookup9 = parentVoLookup9.getParent();
								parent9 = parent9.getParent();
			}			
			valueObject.setDiabetesStatus(voLookup9);
		}
				// OtherNotes
		valueObject.setOtherNotes(domainObject.getOtherNotes());
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
		// SymptomDurationUnit
		valueObject.setSymptomDurationUnit(domainObject.getSymptomDurationUnit());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.RACPSymptomRiskFactors extractRACPSymptomRiskFactors(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVo valueObject) 
	{
		return 	extractRACPSymptomRiskFactors(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.RACPSymptomRiskFactors extractRACPSymptomRiskFactors(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.RACPSymptomRiskFactorsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_RACPSymptomRiskFactors();
		ims.clinical.domain.objects.RACPSymptomRiskFactors domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.RACPSymptomRiskFactors)domMap.get(valueObject);
			}
			// ims.clinical.vo.RACPSymptomRiskFactorsVo ID_RACPSymptomRiskFactors field is unknown
			domainObject = new ims.clinical.domain.objects.RACPSymptomRiskFactors();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_RACPSymptomRiskFactors());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.RACPSymptomRiskFactors)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.RACPSymptomRiskFactors) domainFactory.getDomainObject(ims.clinical.domain.objects.RACPSymptomRiskFactors.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_RACPSymptomRiskFactors());

		domainObject.setSymptomIndicator(valueObject.getSymptomIndicator());

		// SaveAsRefVO treated as RefValueObject
		ims.clinical.vo.RACPSymptomsRefVoCollection refCollection2 = new ims.clinical.vo.RACPSymptomsRefVoCollection();
		if (valueObject.getSymptoms() != null)
		{
			for (int i2=0; i2<valueObject.getSymptoms().size(); i2++)
			{
				ims.clinical.vo.RACPSymptomsRefVo ref2 = (ims.clinical.vo.RACPSymptomsRefVo)valueObject.getSymptoms().get(i2);
				refCollection2.add(ref2);
			}
		}
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.Set domainSymptoms2 = domainObject.getSymptoms();
		if (domainSymptoms2 == null)
		{
			domainSymptoms2 = new java.util.HashSet();
		}
		java.util.Set newSet2  = new java.util.HashSet();
		for(int i=0; i<size2; i++) 
		{
			ims.clinical.vo.RACPSymptomsRefVo vo = refCollection2.get(i);					
			ims.clinical.domain.objects.RACPSymptoms dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.clinical.domain.objects.RACPSymptoms)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.clinical.domain.objects.RACPSymptoms)domainFactory.getDomainObject( ims.clinical.domain.objects.RACPSymptoms.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainSymptoms2.contains(dom))
			{
				domainSymptoms2.add(dom);
			}
			newSet2.add(dom);			
		}
		java.util.Set removedSet2 = new java.util.HashSet();
		java.util.Iterator iter2 = domainSymptoms2.iterator();
		//Find out which objects need to be removed
		while (iter2.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter2.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet2.contains(o))
			{
				removedSet2.add(o);
			}
		}
		iter2 = removedSet2.iterator();
		//Remove the unwanted objects
		while (iter2.hasNext())
		{
			domainSymptoms2.remove(iter2.next());
		}		
		
		domainObject.setSymptoms(domainSymptoms2);		
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getSymptomDuration() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getSymptomDuration().getID());
		}
		domainObject.setSymptomDuration(value3);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSymptomNotes() != null && valueObject.getSymptomNotes().equals(""))
		{
			valueObject.setSymptomNotes(null);
		}
		domainObject.setSymptomNotes(valueObject.getSymptomNotes());
		domainObject.setRiskFactorIndicator(valueObject.getRiskFactorIndicator());
		ims.core.vo.lookups.RACPRiskFactorCollection collection6 =
	valueObject.getRiskFactors();
	    java.util.List domainRiskFactors = domainObject.getRiskFactors();;			
	    int collection6Size=0;
		if (collection6 == null)
		{
			domainRiskFactors = new java.util.ArrayList(0);
		}
		else
		{
			collection6Size = collection6.size();
		}
		
		for(int i=0; i<collection6Size; i++) 
		{
			int instanceId = collection6.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainRiskFactors.indexOf(dom);
			if (domIdx == -1)
			{
				domainRiskFactors.add(i, dom);
			}
			else if (i != domIdx && i < domainRiskFactors.size())
			{
				Object tmp = domainRiskFactors.get(i);
				domainRiskFactors.set(i, domainRiskFactors.get(domIdx));
				domainRiskFactors.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j6 = domainRiskFactors.size();
		while (j6 > collection6Size)
		{
			domainRiskFactors.remove(j6-1);
			j6 = domainRiskFactors.size();
		}

		domainObject.setRiskFactors(domainRiskFactors);		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Smoking value7 = null;
		if ( null != valueObject.getSmokingStatus() ) 
		{
			if (valueObject.getSmokingStatus().getBoId() == null)
			{
				if (domMap.get(valueObject.getSmokingStatus()) != null)
				{
					value7 = (ims.core.clinical.domain.objects.Smoking)domMap.get(valueObject.getSmokingStatus());
				}
			}
			else
			{
				value7 = (ims.core.clinical.domain.objects.Smoking)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Smoking.class, valueObject.getSmokingStatus().getBoId());
			}
		}
		domainObject.setSmokingStatus(value7);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Alcohol value8 = null;
		if ( null != valueObject.getAlcoholUnitsPerWeek() ) 
		{
			if (valueObject.getAlcoholUnitsPerWeek().getBoId() == null)
			{
				if (domMap.get(valueObject.getAlcoholUnitsPerWeek()) != null)
				{
					value8 = (ims.core.clinical.domain.objects.Alcohol)domMap.get(valueObject.getAlcoholUnitsPerWeek());
				}
			}
			else
			{
				value8 = (ims.core.clinical.domain.objects.Alcohol)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Alcohol.class, valueObject.getAlcoholUnitsPerWeek().getBoId());
			}
		}
		domainObject.setAlcoholUnitsPerWeek(value8);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value9 = null;
		if ( null != valueObject.getDiabetesStatus() ) 
		{
			value9 =
				domainFactory.getLookupInstance(valueObject.getDiabetesStatus().getID());
		}
		domainObject.setDiabetesStatus(value9);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getOtherNotes() != null && valueObject.getOtherNotes().equals(""))
		{
			valueObject.setOtherNotes(null);
		}
		domainObject.setOtherNotes(valueObject.getOtherNotes());
		ims.core.admin.domain.objects.CareContext value11 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value11 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value11 = domainObject.getCareContext();	
			}
			else
			{
				value11 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value11);
		domainObject.setSymptomDurationUnit(valueObject.getSymptomDurationUnit());

		return domainObject;
	}

}
