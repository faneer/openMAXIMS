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
 * @author Cornel Ventuneac
 */
public class LocationSiteConfigVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.LocationSiteConfigVo copy(ims.RefMan.vo.LocationSiteConfigVo valueObjectDest, ims.RefMan.vo.LocationSiteConfigVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Location(valueObjectSrc.getID_Location());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// UpperName
		valueObjectDest.setUpperName(valueObjectSrc.getUpperName());
		// Locations
		valueObjectDest.setLocations(valueObjectSrc.getLocations());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Type
		valueObjectDest.setType(valueObjectSrc.getType());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
		// Address
		valueObjectDest.setAddress(valueObjectSrc.getAddress());
		// IsVirtual
		valueObjectDest.setIsVirtual(valueObjectSrc.getIsVirtual());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createLocationSiteConfigVoCollectionFromLocSite(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.LocSite objects.
	 */
	public static ims.RefMan.vo.LocationSiteConfigVoCollection createLocationSiteConfigVoCollectionFromLocSite(java.util.Set domainObjectSet)	
	{
		return createLocationSiteConfigVoCollectionFromLocSite(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.LocSite objects.
	 */
	public static ims.RefMan.vo.LocationSiteConfigVoCollection createLocationSiteConfigVoCollectionFromLocSite(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.LocationSiteConfigVoCollection voList = new ims.RefMan.vo.LocationSiteConfigVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.resource.place.domain.objects.LocSite domainObject = (ims.core.resource.place.domain.objects.LocSite) iterator.next();
			ims.RefMan.vo.LocationSiteConfigVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.LocSite objects.
	 */
	public static ims.RefMan.vo.LocationSiteConfigVoCollection createLocationSiteConfigVoCollectionFromLocSite(java.util.List domainObjectList) 
	{
		return createLocationSiteConfigVoCollectionFromLocSite(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.LocSite objects.
	 */
	public static ims.RefMan.vo.LocationSiteConfigVoCollection createLocationSiteConfigVoCollectionFromLocSite(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.LocationSiteConfigVoCollection voList = new ims.RefMan.vo.LocationSiteConfigVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.resource.place.domain.objects.LocSite domainObject = (ims.core.resource.place.domain.objects.LocSite) domainObjectList.get(i);
			ims.RefMan.vo.LocationSiteConfigVo vo = create(map, domainObject);

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
	 * Create the ims.core.resource.place.domain.objects.LocSite set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractLocSiteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVoCollection voCollection) 
	 {
	 	return extractLocSiteSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractLocSiteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.LocationSiteConfigVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.LocSite domainObject = LocationSiteConfigVoAssembler.extractLocSite(domainFactory, vo, domMap);

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
	 * Create the ims.core.resource.place.domain.objects.LocSite list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractLocSiteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVoCollection voCollection) 
	 {
	 	return extractLocSiteList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractLocSiteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.LocationSiteConfigVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.LocSite domainObject = LocationSiteConfigVoAssembler.extractLocSite(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.resource.place.domain.objects.LocSite object.
	 * @param domainObject ims.core.resource.place.domain.objects.LocSite
	 */
	 public static ims.RefMan.vo.LocationSiteConfigVo create(ims.core.resource.place.domain.objects.LocSite domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.resource.place.domain.objects.LocSite object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.LocationSiteConfigVo create(DomainObjectMap map, ims.core.resource.place.domain.objects.LocSite domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.LocationSiteConfigVo valueObject = (ims.RefMan.vo.LocationSiteConfigVo) map.getValueObject(domainObject, ims.RefMan.vo.LocationSiteConfigVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.LocationSiteConfigVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.resource.place.domain.objects.LocSite
	 */
	 public static ims.RefMan.vo.LocationSiteConfigVo insert(ims.RefMan.vo.LocationSiteConfigVo valueObject, ims.core.resource.place.domain.objects.LocSite domainObject) 
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
	 * @param domainObject ims.core.resource.place.domain.objects.LocSite
	 */
	 public static ims.RefMan.vo.LocationSiteConfigVo insert(DomainObjectMap map, ims.RefMan.vo.LocationSiteConfigVo valueObject, ims.core.resource.place.domain.objects.LocSite domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Location(domainObject.getId());
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
			
		// UpperName
		valueObject.setUpperName(domainObject.getUpperName());
		// Locations
		valueObject.setLocations(ims.RefMan.vo.domain.LocationConfigVoAssembler.createLocationConfigVoCollectionFromLocation(map, domainObject.getLocations()) );
		// Name
		valueObject.setName(domainObject.getName());
		// Type
		ims.domain.lookups.LookupInstance instance4 = domainObject.getType();
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

			ims.core.vo.lookups.LocationType voLookup4 = new ims.core.vo.lookups.LocationType(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.LocationType parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.LocationType(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setType(voLookup4);
		}
				// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
		// Address
		valueObject.setAddress(ims.core.vo.domain.PersonAddressAssembler.create(map, domainObject.getAddress()) );
		// IsVirtual
		valueObject.setIsVirtual( domainObject.isIsVirtual() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.resource.place.domain.objects.LocSite extractLocSite(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVo valueObject) 
	{
		return 	extractLocSite(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.resource.place.domain.objects.LocSite extractLocSite(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.LocationSiteConfigVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Location();
		ims.core.resource.place.domain.objects.LocSite domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.resource.place.domain.objects.LocSite)domMap.get(valueObject);
			}
			// ims.RefMan.vo.LocationSiteConfigVo ID_LocSite field is unknown
			domainObject = new ims.core.resource.place.domain.objects.LocSite();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Location());
			if (domMap.get(key) != null)
			{
				return (ims.core.resource.place.domain.objects.LocSite)domMap.get(key);
			}
			domainObject = (ims.core.resource.place.domain.objects.LocSite) domainFactory.getDomainObject(ims.core.resource.place.domain.objects.LocSite.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Location());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getUpperName() != null && valueObject.getUpperName().equals(""))
		{
			valueObject.setUpperName(null);
		}
		domainObject.setUpperName(valueObject.getUpperName());

		// SaveAsRefVO treated as RefValueObject
		ims.core.resource.place.vo.LocationRefVoCollection refCollection2 = new ims.core.resource.place.vo.LocationRefVoCollection();
		if (valueObject.getLocations() != null)
		{
			for (int i2=0; i2<valueObject.getLocations().size(); i2++)
			{
				ims.core.resource.place.vo.LocationRefVo ref2 = (ims.core.resource.place.vo.LocationRefVo)valueObject.getLocations().get(i2);
				refCollection2.add(ref2);
			}
		}
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.Set domainLocations2 = domainObject.getLocations();
		if (domainLocations2 == null)
		{
			domainLocations2 = new java.util.HashSet();
		}
		java.util.Set newSet2  = new java.util.HashSet();
		for(int i=0; i<size2; i++) 
		{
			ims.core.resource.place.vo.LocationRefVo vo = refCollection2.get(i);					
			ims.core.resource.place.domain.objects.Location dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.core.resource.place.domain.objects.Location)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.core.resource.place.domain.objects.Location)domainFactory.getDomainObject( ims.core.resource.place.domain.objects.Location.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainLocations2.contains(dom))
			{
				domainLocations2.add(dom);
			}
			newSet2.add(dom);			
		}
		java.util.Set removedSet2 = new java.util.HashSet();
		java.util.Iterator iter2 = domainLocations2.iterator();
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
			domainLocations2.remove(iter2.next());
		}		
		
		domainObject.setLocations(domainLocations2);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getType() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getType().getID());
		}
		domainObject.setType(value4);
		domainObject.setIsActive(valueObject.getIsActive());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.generic.domain.objects.Address value6 = null;
		if ( null != valueObject.getAddress() ) 
		{
			if (valueObject.getAddress().getBoId() == null)
			{
				if (domMap.get(valueObject.getAddress()) != null)
				{
					value6 = (ims.core.generic.domain.objects.Address)domMap.get(valueObject.getAddress());
				}
			}
			else
			{
				value6 = (ims.core.generic.domain.objects.Address)domainFactory.getDomainObject(ims.core.generic.domain.objects.Address.class, valueObject.getAddress().getBoId());
			}
		}
		domainObject.setAddress(value6);
		domainObject.setIsVirtual(valueObject.getIsVirtual());

		return domainObject;
	}

}
