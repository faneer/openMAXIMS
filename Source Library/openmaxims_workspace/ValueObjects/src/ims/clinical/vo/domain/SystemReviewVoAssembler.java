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
 * @author Dara Hickey
 */
public class SystemReviewVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.SystemReviewVo copy(ims.clinical.vo.SystemReviewVo valueObjectDest, ims.clinical.vo.SystemReviewVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SystemReview(valueObjectSrc.getID_SystemReview());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// Symptoms
		valueObjectDest.setSymptoms(valueObjectSrc.getSymptoms());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSystemReviewVoCollectionFromSystemReview(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.SystemReview objects.
	 */
	public static ims.clinical.vo.SystemReviewVoCollection createSystemReviewVoCollectionFromSystemReview(java.util.Set domainObjectSet)	
	{
		return createSystemReviewVoCollectionFromSystemReview(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.SystemReview objects.
	 */
	public static ims.clinical.vo.SystemReviewVoCollection createSystemReviewVoCollectionFromSystemReview(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.SystemReviewVoCollection voList = new ims.clinical.vo.SystemReviewVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.SystemReview domainObject = (ims.clinical.domain.objects.SystemReview) iterator.next();
			ims.clinical.vo.SystemReviewVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.SystemReview objects.
	 */
	public static ims.clinical.vo.SystemReviewVoCollection createSystemReviewVoCollectionFromSystemReview(java.util.List domainObjectList) 
	{
		return createSystemReviewVoCollectionFromSystemReview(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.SystemReview objects.
	 */
	public static ims.clinical.vo.SystemReviewVoCollection createSystemReviewVoCollectionFromSystemReview(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.SystemReviewVoCollection voList = new ims.clinical.vo.SystemReviewVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.SystemReview domainObject = (ims.clinical.domain.objects.SystemReview) domainObjectList.get(i);
			ims.clinical.vo.SystemReviewVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.SystemReview set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSystemReviewSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVoCollection voCollection) 
	 {
	 	return extractSystemReviewSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSystemReviewSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.SystemReviewVo vo = voCollection.get(i);
			ims.clinical.domain.objects.SystemReview domainObject = SystemReviewVoAssembler.extractSystemReview(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.SystemReview list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSystemReviewList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVoCollection voCollection) 
	 {
	 	return extractSystemReviewList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSystemReviewList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.SystemReviewVo vo = voCollection.get(i);
			ims.clinical.domain.objects.SystemReview domainObject = SystemReviewVoAssembler.extractSystemReview(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.SystemReview object.
	 * @param domainObject ims.clinical.domain.objects.SystemReview
	 */
	 public static ims.clinical.vo.SystemReviewVo create(ims.clinical.domain.objects.SystemReview domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.SystemReview object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.SystemReviewVo create(DomainObjectMap map, ims.clinical.domain.objects.SystemReview domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.SystemReviewVo valueObject = (ims.clinical.vo.SystemReviewVo) map.getValueObject(domainObject, ims.clinical.vo.SystemReviewVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.SystemReviewVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.SystemReview
	 */
	 public static ims.clinical.vo.SystemReviewVo insert(ims.clinical.vo.SystemReviewVo valueObject, ims.clinical.domain.objects.SystemReview domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.SystemReview
	 */
	 public static ims.clinical.vo.SystemReviewVo insert(DomainObjectMap map, ims.clinical.vo.SystemReviewVo valueObject, ims.clinical.domain.objects.SystemReview domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SystemReview(domainObject.getId());
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
		// Symptoms
		valueObject.setSymptoms(ims.clinical.vo.domain.SystemReviewSymptomVoAssembler.createSystemReviewSymptomVoCollectionFromSystemReviewSymptoms(map, domainObject.getSymptoms()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.SystemReview extractSystemReview(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVo valueObject) 
	{
		return 	extractSystemReview(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.SystemReview extractSystemReview(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.SystemReviewVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SystemReview();
		ims.clinical.domain.objects.SystemReview domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.SystemReview)domMap.get(valueObject);
			}
			// ims.clinical.vo.SystemReviewVo ID_SystemReview field is unknown
			domainObject = new ims.clinical.domain.objects.SystemReview();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SystemReview());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.SystemReview)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.SystemReview) domainFactory.getDomainObject(ims.clinical.domain.objects.SystemReview.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SystemReview());

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
		domainObject.setSymptoms(ims.clinical.vo.domain.SystemReviewSymptomVoAssembler.extractSystemReviewSymptomsSet(domainFactory, valueObject.getSymptoms(), domainObject.getSymptoms(), domMap));		

		return domainObject;
	}

}
