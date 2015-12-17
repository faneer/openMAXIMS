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
 * Generated on 12/10/2015, 13:25
 *
 */
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cristian Belciug
 */
public class ElectiveListStatusForBookTheatreVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVo copy(ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObjectDest, ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ElectiveListStatus(valueObjectSrc.getID_ElectiveListStatus());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ElectiveListStatus
		valueObjectDest.setElectiveListStatus(valueObjectSrc.getElectiveListStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ElectiveListStatus objects.
	 */
	public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(java.util.Set domainObjectSet)	
	{
		return createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ElectiveListStatus objects.
	 */
	public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voList = new ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.ElectiveListStatus domainObject = (ims.RefMan.domain.objects.ElectiveListStatus) iterator.next();
			ims.RefMan.vo.ElectiveListStatusForBookTheatreVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ElectiveListStatus objects.
	 */
	public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(java.util.List domainObjectList) 
	{
		return createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ElectiveListStatus objects.
	 */
	public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection createElectiveListStatusForBookTheatreVoCollectionFromElectiveListStatus(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voList = new ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.ElectiveListStatus domainObject = (ims.RefMan.domain.objects.ElectiveListStatus) domainObjectList.get(i);
			ims.RefMan.vo.ElectiveListStatusForBookTheatreVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.ElectiveListStatus set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractElectiveListStatusSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voCollection) 
	 {
	 	return extractElectiveListStatusSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractElectiveListStatusSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ElectiveListStatusForBookTheatreVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ElectiveListStatus domainObject = ElectiveListStatusForBookTheatreVoAssembler.extractElectiveListStatus(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.ElectiveListStatus list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractElectiveListStatusList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voCollection) 
	 {
	 	return extractElectiveListStatusList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractElectiveListStatusList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ElectiveListStatusForBookTheatreVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ElectiveListStatus domainObject = ElectiveListStatusForBookTheatreVoAssembler.extractElectiveListStatus(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.ElectiveListStatus object.
	 * @param domainObject ims.RefMan.domain.objects.ElectiveListStatus
	 */
	 public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVo create(ims.RefMan.domain.objects.ElectiveListStatus domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.ElectiveListStatus object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVo create(DomainObjectMap map, ims.RefMan.domain.objects.ElectiveListStatus domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObject = (ims.RefMan.vo.ElectiveListStatusForBookTheatreVo) map.getValueObject(domainObject, ims.RefMan.vo.ElectiveListStatusForBookTheatreVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.ElectiveListStatusForBookTheatreVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ElectiveListStatus
	 */
	 public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVo insert(ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObject, ims.RefMan.domain.objects.ElectiveListStatus domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.ElectiveListStatus
	 */
	 public static ims.RefMan.vo.ElectiveListStatusForBookTheatreVo insert(DomainObjectMap map, ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObject, ims.RefMan.domain.objects.ElectiveListStatus domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ElectiveListStatus(domainObject.getId());
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
			
		// ElectiveListStatus
		ims.domain.lookups.LookupInstance instance1 = domainObject.getElectiveListStatus();
		if ( null != instance1 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance1.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance1.getImage().getImageId(), instance1.getImage().getImagePath());
			}
			color = instance1.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.WaitingListStatus voLookup1 = new ims.core.vo.lookups.WaitingListStatus(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.WaitingListStatus parentVoLookup1 = voLookup1;
			ims.domain.lookups.LookupInstance parent1 = instance1.getParent();
			while (parent1 != null)
			{
				if (parent1.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent1.getImage().getImageId(), parent1.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent1.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup1.setParent(new ims.core.vo.lookups.WaitingListStatus(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setElectiveListStatus(voLookup1);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.ElectiveListStatus extractElectiveListStatus(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObject) 
	{
		return 	extractElectiveListStatus(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.ElectiveListStatus extractElectiveListStatus(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ElectiveListStatusForBookTheatreVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ElectiveListStatus();
		ims.RefMan.domain.objects.ElectiveListStatus domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.ElectiveListStatus)domMap.get(valueObject);
			}
			// ims.RefMan.vo.ElectiveListStatusForBookTheatreVo ID_ElectiveListStatus field is unknown
			domainObject = new ims.RefMan.domain.objects.ElectiveListStatus();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ElectiveListStatus());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.ElectiveListStatus)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.ElectiveListStatus) domainFactory.getDomainObject(ims.RefMan.domain.objects.ElectiveListStatus.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ElectiveListStatus());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getElectiveListStatus() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getElectiveListStatus().getID());
		}
		domainObject.setElectiveListStatus(value1);

		return domainObject;
	}

}
