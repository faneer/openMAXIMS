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
 * @author John MacEnri
 */
public class PersonNameAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.PersonName copy(ims.core.vo.PersonName valueObjectDest, ims.core.vo.PersonName valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PersonName(valueObjectSrc.getID_PersonName());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// nameType
		valueObjectDest.setNameType(valueObjectSrc.getNameType());
		// surname
		valueObjectDest.setSurname(valueObjectSrc.getSurname());
		// forename
		valueObjectDest.setForename(valueObjectSrc.getForename());
		// middleName
		valueObjectDest.setMiddleName(valueObjectSrc.getMiddleName());
		// title
		valueObjectDest.setTitle(valueObjectSrc.getTitle());
		// upperSurname
		valueObjectDest.setUpperSurname(valueObjectSrc.getUpperSurname());
		// upperForename
		valueObjectDest.setUpperForename(valueObjectSrc.getUpperForename());
		// namesuffix
		valueObjectDest.setNamesuffix(valueObjectSrc.getNamesuffix());
		// objectidentifier
		valueObjectDest.setObjectidentifier(valueObjectSrc.getObjectidentifier());
		// beffdate
		valueObjectDest.setBeffdate(valueObjectSrc.getBeffdate());
		// beffdatecnf
		valueObjectDest.setBeffdatecnf(valueObjectSrc.getBeffdatecnf());
		// betdate
		valueObjectDest.setBetdate(valueObjectSrc.getBetdate());
		// betdatecnf
		valueObjectDest.setBetdatecnf(valueObjectSrc.getBetdatecnf());
		// pdsUpdateMode
		valueObjectDest.setPdsUpdateMode(valueObjectSrc.getPdsUpdateMode());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPersonNameCollectionFromPersonName(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.generic.domain.objects.PersonName objects.
	 */
	public static ims.core.vo.PersonNameCollection createPersonNameCollectionFromPersonName(java.util.Set domainObjectSet)	
	{
		return createPersonNameCollectionFromPersonName(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.generic.domain.objects.PersonName objects.
	 */
	public static ims.core.vo.PersonNameCollection createPersonNameCollectionFromPersonName(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.PersonNameCollection voList = new ims.core.vo.PersonNameCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.generic.domain.objects.PersonName domainObject = (ims.core.generic.domain.objects.PersonName) iterator.next();
			ims.core.vo.PersonName vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.generic.domain.objects.PersonName objects.
	 */
	public static ims.core.vo.PersonNameCollection createPersonNameCollectionFromPersonName(java.util.List domainObjectList) 
	{
		return createPersonNameCollectionFromPersonName(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.generic.domain.objects.PersonName objects.
	 */
	public static ims.core.vo.PersonNameCollection createPersonNameCollectionFromPersonName(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.PersonNameCollection voList = new ims.core.vo.PersonNameCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.generic.domain.objects.PersonName domainObject = (ims.core.generic.domain.objects.PersonName) domainObjectList.get(i);
			ims.core.vo.PersonName vo = create(map, domainObject);

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
	 * Create the ims.core.generic.domain.objects.PersonName set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPersonNameSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonNameCollection voCollection) 
	 {
	 	return extractPersonNameSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPersonNameSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonNameCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PersonName vo = voCollection.get(i);
			ims.core.generic.domain.objects.PersonName domainObject = PersonNameAssembler.extractPersonName(domainFactory, vo, domMap);

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
	 * Create the ims.core.generic.domain.objects.PersonName list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPersonNameList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonNameCollection voCollection) 
	 {
	 	return extractPersonNameList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPersonNameList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonNameCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PersonName vo = voCollection.get(i);
			ims.core.generic.domain.objects.PersonName domainObject = PersonNameAssembler.extractPersonName(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.generic.domain.objects.PersonName object.
	 * @param domainObject ims.core.generic.domain.objects.PersonName
	 */
	 public static ims.core.vo.PersonName create(ims.core.generic.domain.objects.PersonName domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.generic.domain.objects.PersonName object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.PersonName create(DomainObjectMap map, ims.core.generic.domain.objects.PersonName domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.PersonName valueObject = (ims.core.vo.PersonName) map.getValueObject(domainObject, ims.core.vo.PersonName.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.PersonName(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.generic.domain.objects.PersonName
	 */
	 public static ims.core.vo.PersonName insert(ims.core.vo.PersonName valueObject, ims.core.generic.domain.objects.PersonName domainObject) 
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
	 * @param domainObject ims.core.generic.domain.objects.PersonName
	 */
	 public static ims.core.vo.PersonName insert(DomainObjectMap map, ims.core.vo.PersonName valueObject, ims.core.generic.domain.objects.PersonName domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PersonName(domainObject.getId());
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
			
		// nameType
		ims.domain.lookups.LookupInstance instance1 = domainObject.getNameType();
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

			ims.core.vo.lookups.NameType voLookup1 = new ims.core.vo.lookups.NameType(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.NameType parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.core.vo.lookups.NameType(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setNameType(voLookup1);
		}
				// surname
		valueObject.setSurname(domainObject.getSurname());
		// forename
		valueObject.setForename(domainObject.getForename());
		// middleName
		valueObject.setMiddleName(domainObject.getMiddleName());
		// title
		ims.domain.lookups.LookupInstance instance5 = domainObject.getTitle();
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

			ims.core.vo.lookups.PersonTitle voLookup5 = new ims.core.vo.lookups.PersonTitle(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.core.vo.lookups.PersonTitle parentVoLookup5 = voLookup5;
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
								parentVoLookup5.setParent(new ims.core.vo.lookups.PersonTitle(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setTitle(voLookup5);
		}
				// upperSurname
		valueObject.setUpperSurname(domainObject.getUpperSurname());
		// upperForename
		valueObject.setUpperForename(domainObject.getUpperForename());
		// namesuffix
		valueObject.setNamesuffix(domainObject.getNamesuffix());
		// objectidentifier
		valueObject.setObjectidentifier(domainObject.getObjectidentifier());
		// beffdate
		java.util.Date beffdate = domainObject.getBeffdate();
		if ( null != beffdate ) 
		{
			valueObject.setBeffdate(new ims.framework.utils.Date(beffdate) );
		}
		// beffdatecnf
		valueObject.setBeffdatecnf( domainObject.isBeffdatecnf() );
		// betdate
		java.util.Date betdate = domainObject.getBetdate();
		if ( null != betdate ) 
		{
			valueObject.setBetdate(new ims.framework.utils.Date(betdate) );
		}
		// betdatecnf
		valueObject.setBetdatecnf( domainObject.isBetdatecnf() );
		// pdsUpdateMode
		ims.domain.lookups.LookupInstance instance14 = domainObject.getPdsUpdateMode();
		if ( null != instance14 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance14.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance14.getImage().getImageId(), instance14.getImage().getImagePath());
			}
			color = instance14.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PDSUpdateMode voLookup14 = new ims.core.vo.lookups.PDSUpdateMode(instance14.getId(),instance14.getText(), instance14.isActive(), null, img, color);
			ims.core.vo.lookups.PDSUpdateMode parentVoLookup14 = voLookup14;
			ims.domain.lookups.LookupInstance parent14 = instance14.getParent();
			while (parent14 != null)
			{
				if (parent14.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent14.getImage().getImageId(), parent14.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent14.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup14.setParent(new ims.core.vo.lookups.PDSUpdateMode(parent14.getId(),parent14.getText(), parent14.isActive(), null, img, color));
				parentVoLookup14 = parentVoLookup14.getParent();
								parent14 = parent14.getParent();
			}			
			valueObject.setPdsUpdateMode(voLookup14);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.generic.domain.objects.PersonName extractPersonName(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonName valueObject) 
	{
		return 	extractPersonName(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.generic.domain.objects.PersonName extractPersonName(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PersonName valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PersonName();
		ims.core.generic.domain.objects.PersonName domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.generic.domain.objects.PersonName)domMap.get(valueObject);
			}
			// ims.core.vo.PersonName ID_PersonName field is unknown
			domainObject = new ims.core.generic.domain.objects.PersonName();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PersonName());
			if (domMap.get(key) != null)
			{
				return (ims.core.generic.domain.objects.PersonName)domMap.get(key);
			}
			domainObject = (ims.core.generic.domain.objects.PersonName) domainFactory.getDomainObject(ims.core.generic.domain.objects.PersonName.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PersonName());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getNameType() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getNameType().getID());
		}
		domainObject.setNameType(value1);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSurname() != null && valueObject.getSurname().equals(""))
		{
			valueObject.setSurname(null);
		}
		domainObject.setSurname(valueObject.getSurname());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getForename() != null && valueObject.getForename().equals(""))
		{
			valueObject.setForename(null);
		}
		domainObject.setForename(valueObject.getForename());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getMiddleName() != null && valueObject.getMiddleName().equals(""))
		{
			valueObject.setMiddleName(null);
		}
		domainObject.setMiddleName(valueObject.getMiddleName());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getTitle() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getTitle().getID());
		}
		domainObject.setTitle(value5);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getUpperSurname() != null && valueObject.getUpperSurname().equals(""))
		{
			valueObject.setUpperSurname(null);
		}
		domainObject.setUpperSurname(valueObject.getUpperSurname());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getUpperForename() != null && valueObject.getUpperForename().equals(""))
		{
			valueObject.setUpperForename(null);
		}
		domainObject.setUpperForename(valueObject.getUpperForename());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getNamesuffix() != null && valueObject.getNamesuffix().equals(""))
		{
			valueObject.setNamesuffix(null);
		}
		domainObject.setNamesuffix(valueObject.getNamesuffix());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getObjectidentifier() != null && valueObject.getObjectidentifier().equals(""))
		{
			valueObject.setObjectidentifier(null);
		}
		domainObject.setObjectidentifier(valueObject.getObjectidentifier());
		java.util.Date value10 = null;
		ims.framework.utils.Date date10 = valueObject.getBeffdate();		
		if ( date10 != null ) 
		{
			value10 = date10.getDate();
		}
		domainObject.setBeffdate(value10);
		domainObject.setBeffdatecnf(valueObject.getBeffdatecnf());
		java.util.Date value12 = null;
		ims.framework.utils.Date date12 = valueObject.getBetdate();		
		if ( date12 != null ) 
		{
			value12 = date12.getDate();
		}
		domainObject.setBetdate(value12);
		domainObject.setBetdatecnf(valueObject.getBetdatecnf());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value14 = null;
		if ( null != valueObject.getPdsUpdateMode() ) 
		{
			value14 =
				domainFactory.getLookupInstance(valueObject.getPdsUpdateMode().getID());
		}
		domainObject.setPdsUpdateMode(value14);

		return domainObject;
	}

}
