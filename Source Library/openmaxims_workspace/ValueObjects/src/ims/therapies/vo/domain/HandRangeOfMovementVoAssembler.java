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
package ims.therapies.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Dara Hickey
 */
public class HandRangeOfMovementVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.therapies.vo.HandRangeOfMovementVo copy(ims.therapies.vo.HandRangeOfMovementVo valueObjectDest, ims.therapies.vo.HandRangeOfMovementVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_HandRangeOfMovement(valueObjectSrc.getID_HandRangeOfMovement());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Details
		valueObjectDest.setDetails(valueObjectSrc.getDetails());
		// AuthoringDateTime
		valueObjectDest.setAuthoringDateTime(valueObjectSrc.getAuthoringDateTime());
		// AuthoringCP
		valueObjectDest.setAuthoringCP(valueObjectSrc.getAuthoringCP());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// DominantHand
		valueObjectDest.setDominantHand(valueObjectSrc.getDominantHand());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.therapies.hand.domain.objects.HandRangeOfMovement objects.
	 */
	public static ims.therapies.vo.HandRangeOfMovementVoCollection createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(java.util.Set domainObjectSet)	
	{
		return createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.therapies.hand.domain.objects.HandRangeOfMovement objects.
	 */
	public static ims.therapies.vo.HandRangeOfMovementVoCollection createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.therapies.vo.HandRangeOfMovementVoCollection voList = new ims.therapies.vo.HandRangeOfMovementVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject = (ims.therapies.hand.domain.objects.HandRangeOfMovement) iterator.next();
			ims.therapies.vo.HandRangeOfMovementVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.therapies.hand.domain.objects.HandRangeOfMovement objects.
	 */
	public static ims.therapies.vo.HandRangeOfMovementVoCollection createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(java.util.List domainObjectList) 
	{
		return createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.therapies.hand.domain.objects.HandRangeOfMovement objects.
	 */
	public static ims.therapies.vo.HandRangeOfMovementVoCollection createHandRangeOfMovementVoCollectionFromHandRangeOfMovement(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.therapies.vo.HandRangeOfMovementVoCollection voList = new ims.therapies.vo.HandRangeOfMovementVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject = (ims.therapies.hand.domain.objects.HandRangeOfMovement) domainObjectList.get(i);
			ims.therapies.vo.HandRangeOfMovementVo vo = create(map, domainObject);

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
	 * Create the ims.therapies.hand.domain.objects.HandRangeOfMovement set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractHandRangeOfMovementSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVoCollection voCollection) 
	 {
	 	return extractHandRangeOfMovementSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractHandRangeOfMovementSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.HandRangeOfMovementVo vo = voCollection.get(i);
			ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject = HandRangeOfMovementVoAssembler.extractHandRangeOfMovement(domainFactory, vo, domMap);

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
	 * Create the ims.therapies.hand.domain.objects.HandRangeOfMovement list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractHandRangeOfMovementList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVoCollection voCollection) 
	 {
	 	return extractHandRangeOfMovementList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractHandRangeOfMovementList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.HandRangeOfMovementVo vo = voCollection.get(i);
			ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject = HandRangeOfMovementVoAssembler.extractHandRangeOfMovement(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.therapies.hand.domain.objects.HandRangeOfMovement object.
	 * @param domainObject ims.therapies.hand.domain.objects.HandRangeOfMovement
	 */
	 public static ims.therapies.vo.HandRangeOfMovementVo create(ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.therapies.hand.domain.objects.HandRangeOfMovement object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.therapies.vo.HandRangeOfMovementVo create(DomainObjectMap map, ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.therapies.vo.HandRangeOfMovementVo valueObject = (ims.therapies.vo.HandRangeOfMovementVo) map.getValueObject(domainObject, ims.therapies.vo.HandRangeOfMovementVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.therapies.vo.HandRangeOfMovementVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.therapies.hand.domain.objects.HandRangeOfMovement
	 */
	 public static ims.therapies.vo.HandRangeOfMovementVo insert(ims.therapies.vo.HandRangeOfMovementVo valueObject, ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject) 
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
	 * @param domainObject ims.therapies.hand.domain.objects.HandRangeOfMovement
	 */
	 public static ims.therapies.vo.HandRangeOfMovementVo insert(DomainObjectMap map, ims.therapies.vo.HandRangeOfMovementVo valueObject, ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_HandRangeOfMovement(domainObject.getId());
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
			
		// Details
		valueObject.setDetails(ims.generalmedical.vo.domain.RangeOfMovementDetailVoAssembler.createRangeOfMovementDetailVoCollectionFromMSkExamJointBonesDetail(map, domainObject.getDetails()) );
		// AuthoringDateTime
		java.util.Date AuthoringDateTime = domainObject.getAuthoringDateTime();
		if ( null != AuthoringDateTime ) 
		{
			valueObject.setAuthoringDateTime(new ims.framework.utils.DateTime(AuthoringDateTime) );
		}
		// AuthoringCP
		valueObject.setAuthoringCP(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getAuthoringCP()) );
		// ClinicalContact
		if (domainObject.getClinicalContact() != null)
		{
			if(domainObject.getClinicalContact() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getClinicalContact();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(id, -1));				
			}
			else
			{
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(domainObject.getClinicalContact().getId(), domainObject.getClinicalContact().getVersion()));
			}
		}
		// DominantHand
		ims.domain.lookups.LookupInstance instance5 = domainObject.getDominantHand();
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

			ims.therapies.vo.lookups.DominantHand voLookup5 = new ims.therapies.vo.lookups.DominantHand(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.therapies.vo.lookups.DominantHand parentVoLookup5 = voLookup5;
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
								parentVoLookup5.setParent(new ims.therapies.vo.lookups.DominantHand(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setDominantHand(voLookup5);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.therapies.hand.domain.objects.HandRangeOfMovement extractHandRangeOfMovement(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVo valueObject) 
	{
		return 	extractHandRangeOfMovement(domainFactory, valueObject, new HashMap());
	}

	public static ims.therapies.hand.domain.objects.HandRangeOfMovement extractHandRangeOfMovement(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.HandRangeOfMovementVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_HandRangeOfMovement();
		ims.therapies.hand.domain.objects.HandRangeOfMovement domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.therapies.hand.domain.objects.HandRangeOfMovement)domMap.get(valueObject);
			}
			// ims.therapies.vo.HandRangeOfMovementVo ID_HandRangeOfMovement field is unknown
			domainObject = new ims.therapies.hand.domain.objects.HandRangeOfMovement();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_HandRangeOfMovement());
			if (domMap.get(key) != null)
			{
				return (ims.therapies.hand.domain.objects.HandRangeOfMovement)domMap.get(key);
			}
			domainObject = (ims.therapies.hand.domain.objects.HandRangeOfMovement) domainFactory.getDomainObject(ims.therapies.hand.domain.objects.HandRangeOfMovement.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_HandRangeOfMovement());

		domainObject.setDetails(ims.generalmedical.vo.domain.RangeOfMovementDetailVoAssembler.extractMSkExamJointBonesDetailSet(domainFactory, valueObject.getDetails(), domainObject.getDetails(), domMap));		
		ims.framework.utils.DateTime dateTime2 = valueObject.getAuthoringDateTime();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setAuthoringDateTime(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value3 = null;
		if ( null != valueObject.getAuthoringCP() ) 
		{
			if (valueObject.getAuthoringCP().getBoId() == null)
			{
				if (domMap.get(valueObject.getAuthoringCP()) != null)
				{
					value3 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getAuthoringCP());
				}
			}
			else
			{
				value3 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getAuthoringCP().getBoId());
			}
		}
		domainObject.setAuthoringCP(value3);
		ims.core.admin.domain.objects.ClinicalContact value4 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value4 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value4 = domainObject.getClinicalContact();	
			}
			else
			{
				value4 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getDominantHand() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getDominantHand().getID());
		}
		domainObject.setDominantHand(value5);

		return domainObject;
	}

}
