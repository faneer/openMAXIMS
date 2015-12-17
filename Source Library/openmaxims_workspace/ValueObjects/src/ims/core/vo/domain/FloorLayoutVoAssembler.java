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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Marius Mihalec
 */
public class FloorLayoutVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.FloorLayoutVo copy(ims.core.vo.FloorLayoutVo valueObjectDest, ims.core.vo.FloorLayoutVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_FloorLayout(valueObjectSrc.getID_FloorLayout());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Vml
		valueObjectDest.setVml(valueObjectSrc.getVml());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createFloorLayoutVoCollectionFromFloorLayout(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.layout.domain.objects.FloorLayout objects.
	 */
	public static ims.core.vo.FloorLayoutVoCollection createFloorLayoutVoCollectionFromFloorLayout(java.util.Set domainObjectSet)	
	{
		return createFloorLayoutVoCollectionFromFloorLayout(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.layout.domain.objects.FloorLayout objects.
	 */
	public static ims.core.vo.FloorLayoutVoCollection createFloorLayoutVoCollectionFromFloorLayout(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.FloorLayoutVoCollection voList = new ims.core.vo.FloorLayoutVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.layout.domain.objects.FloorLayout domainObject = (ims.core.layout.domain.objects.FloorLayout) iterator.next();
			ims.core.vo.FloorLayoutVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.layout.domain.objects.FloorLayout objects.
	 */
	public static ims.core.vo.FloorLayoutVoCollection createFloorLayoutVoCollectionFromFloorLayout(java.util.List domainObjectList) 
	{
		return createFloorLayoutVoCollectionFromFloorLayout(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.layout.domain.objects.FloorLayout objects.
	 */
	public static ims.core.vo.FloorLayoutVoCollection createFloorLayoutVoCollectionFromFloorLayout(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.FloorLayoutVoCollection voList = new ims.core.vo.FloorLayoutVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.layout.domain.objects.FloorLayout domainObject = (ims.core.layout.domain.objects.FloorLayout) domainObjectList.get(i);
			ims.core.vo.FloorLayoutVo vo = create(map, domainObject);

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
	 * Create the ims.core.layout.domain.objects.FloorLayout set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractFloorLayoutSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVoCollection voCollection) 
	 {
	 	return extractFloorLayoutSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractFloorLayoutSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.FloorLayoutVo vo = voCollection.get(i);
			ims.core.layout.domain.objects.FloorLayout domainObject = FloorLayoutVoAssembler.extractFloorLayout(domainFactory, vo, domMap);

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
	 * Create the ims.core.layout.domain.objects.FloorLayout list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractFloorLayoutList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVoCollection voCollection) 
	 {
	 	return extractFloorLayoutList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractFloorLayoutList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.FloorLayoutVo vo = voCollection.get(i);
			ims.core.layout.domain.objects.FloorLayout domainObject = FloorLayoutVoAssembler.extractFloorLayout(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.layout.domain.objects.FloorLayout object.
	 * @param domainObject ims.core.layout.domain.objects.FloorLayout
	 */
	 public static ims.core.vo.FloorLayoutVo create(ims.core.layout.domain.objects.FloorLayout domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.layout.domain.objects.FloorLayout object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.FloorLayoutVo create(DomainObjectMap map, ims.core.layout.domain.objects.FloorLayout domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.FloorLayoutVo valueObject = (ims.core.vo.FloorLayoutVo) map.getValueObject(domainObject, ims.core.vo.FloorLayoutVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.FloorLayoutVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.layout.domain.objects.FloorLayout
	 */
	 public static ims.core.vo.FloorLayoutVo insert(ims.core.vo.FloorLayoutVo valueObject, ims.core.layout.domain.objects.FloorLayout domainObject) 
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
	 * @param domainObject ims.core.layout.domain.objects.FloorLayout
	 */
	 public static ims.core.vo.FloorLayoutVo insert(DomainObjectMap map, ims.core.vo.FloorLayoutVo valueObject, ims.core.layout.domain.objects.FloorLayout domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_FloorLayout(domainObject.getId());
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
			
		// Vml
		valueObject.setVml(domainObject.getVml());
		// Name
		valueObject.setName(domainObject.getName());
		// Status
		ims.domain.lookups.LookupInstance instance3 = domainObject.getStatus();
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

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup3 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setStatus(voLookup3);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.layout.domain.objects.FloorLayout extractFloorLayout(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVo valueObject) 
	{
		return 	extractFloorLayout(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.layout.domain.objects.FloorLayout extractFloorLayout(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.FloorLayoutVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_FloorLayout();
		ims.core.layout.domain.objects.FloorLayout domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.layout.domain.objects.FloorLayout)domMap.get(valueObject);
			}
			// ims.core.vo.FloorLayoutVo ID_FloorLayout field is unknown
			domainObject = new ims.core.layout.domain.objects.FloorLayout();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_FloorLayout());
			if (domMap.get(key) != null)
			{
				return (ims.core.layout.domain.objects.FloorLayout)domMap.get(key);
			}
			domainObject = (ims.core.layout.domain.objects.FloorLayout) domainFactory.getDomainObject(ims.core.layout.domain.objects.FloorLayout.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_FloorLayout());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getVml() != null && valueObject.getVml().equals(""))
		{
			valueObject.setVml(null);
		}
		domainObject.setVml(valueObject.getVml());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value3);

		return domainObject;
	}

}
