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
package ims.nursing.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class HandlingMovementDetailVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.nursing.vo.HandlingMovementDetailVo copy(ims.nursing.vo.HandlingMovementDetailVo valueObjectDest, ims.nursing.vo.HandlingMovementDetailVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_HandlingMovementDetail(valueObjectSrc.getID_HandlingMovementDetail());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Movement
		valueObjectDest.setMovement(valueObjectSrc.getMovement());
		// MechanicalEquipment
		valueObjectDest.setMechanicalEquipment(valueObjectSrc.getMechanicalEquipment());
		// OtherEquipment
		valueObjectDest.setOtherEquipment(valueObjectSrc.getOtherEquipment());
		// NoOfStaff
		valueObjectDest.setNoOfStaff(valueObjectSrc.getNoOfStaff());
		// Details
		valueObjectDest.setDetails(valueObjectSrc.getDetails());
		// SysInfo
		valueObjectDest.setSysInfo(valueObjectSrc.getSysInfo());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.nursing.domain.objects.HandlingMovementDetail objects.
	 */
	public static ims.nursing.vo.HandlingMovementDetailVoCollection createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(java.util.Set domainObjectSet)	
	{
		return createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.nursing.domain.objects.HandlingMovementDetail objects.
	 */
	public static ims.nursing.vo.HandlingMovementDetailVoCollection createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.nursing.vo.HandlingMovementDetailVoCollection voList = new ims.nursing.vo.HandlingMovementDetailVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.nursing.domain.objects.HandlingMovementDetail domainObject = (ims.nursing.domain.objects.HandlingMovementDetail) iterator.next();
			ims.nursing.vo.HandlingMovementDetailVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.nursing.domain.objects.HandlingMovementDetail objects.
	 */
	public static ims.nursing.vo.HandlingMovementDetailVoCollection createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(java.util.List domainObjectList) 
	{
		return createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.nursing.domain.objects.HandlingMovementDetail objects.
	 */
	public static ims.nursing.vo.HandlingMovementDetailVoCollection createHandlingMovementDetailVoCollectionFromHandlingMovementDetail(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.nursing.vo.HandlingMovementDetailVoCollection voList = new ims.nursing.vo.HandlingMovementDetailVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.nursing.domain.objects.HandlingMovementDetail domainObject = (ims.nursing.domain.objects.HandlingMovementDetail) domainObjectList.get(i);
			ims.nursing.vo.HandlingMovementDetailVo vo = create(map, domainObject);

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
	 * Create the ims.nursing.domain.objects.HandlingMovementDetail set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractHandlingMovementDetailSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVoCollection voCollection) 
	 {
	 	return extractHandlingMovementDetailSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractHandlingMovementDetailSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.HandlingMovementDetailVo vo = voCollection.get(i);
			ims.nursing.domain.objects.HandlingMovementDetail domainObject = HandlingMovementDetailVoAssembler.extractHandlingMovementDetail(domainFactory, vo, domMap);

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
	 * Create the ims.nursing.domain.objects.HandlingMovementDetail list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractHandlingMovementDetailList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVoCollection voCollection) 
	 {
	 	return extractHandlingMovementDetailList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractHandlingMovementDetailList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.HandlingMovementDetailVo vo = voCollection.get(i);
			ims.nursing.domain.objects.HandlingMovementDetail domainObject = HandlingMovementDetailVoAssembler.extractHandlingMovementDetail(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.nursing.domain.objects.HandlingMovementDetail object.
	 * @param domainObject ims.nursing.domain.objects.HandlingMovementDetail
	 */
	 public static ims.nursing.vo.HandlingMovementDetailVo create(ims.nursing.domain.objects.HandlingMovementDetail domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.nursing.domain.objects.HandlingMovementDetail object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.nursing.vo.HandlingMovementDetailVo create(DomainObjectMap map, ims.nursing.domain.objects.HandlingMovementDetail domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.nursing.vo.HandlingMovementDetailVo valueObject = (ims.nursing.vo.HandlingMovementDetailVo) map.getValueObject(domainObject, ims.nursing.vo.HandlingMovementDetailVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.nursing.vo.HandlingMovementDetailVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.nursing.domain.objects.HandlingMovementDetail
	 */
	 public static ims.nursing.vo.HandlingMovementDetailVo insert(ims.nursing.vo.HandlingMovementDetailVo valueObject, ims.nursing.domain.objects.HandlingMovementDetail domainObject) 
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
	 * @param domainObject ims.nursing.domain.objects.HandlingMovementDetail
	 */
	 public static ims.nursing.vo.HandlingMovementDetailVo insert(DomainObjectMap map, ims.nursing.vo.HandlingMovementDetailVo valueObject, ims.nursing.domain.objects.HandlingMovementDetail domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_HandlingMovementDetail(domainObject.getId());
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
			
		// Movement
		ims.domain.lookups.LookupInstance instance1 = domainObject.getMovement();
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

			ims.nursing.vo.lookups.PatientHandlingMovement voLookup1 = new ims.nursing.vo.lookups.PatientHandlingMovement(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.nursing.vo.lookups.PatientHandlingMovement parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.nursing.vo.lookups.PatientHandlingMovement(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setMovement(voLookup1);
		}
				// MechanicalEquipment
		java.util.List listMechanicalEquipment = domainObject.getMechanicalEquipment();
		ims.nursing.vo.lookups.MechanicalEquipCollection MechanicalEquipment = new ims.nursing.vo.lookups.MechanicalEquipCollection();
		for(java.util.Iterator iterator = listMechanicalEquipment.iterator(); iterator.hasNext(); ) 
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
			ims.nursing.vo.lookups.MechanicalEquip voInstance = new ims.nursing.vo.lookups.MechanicalEquip(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.nursing.vo.lookups.MechanicalEquip parentVoInstance = voInstance;
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
								parentVoInstance.setParent(new ims.nursing.vo.lookups.MechanicalEquip(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			MechanicalEquipment.add(voInstance);
		}
		valueObject.setMechanicalEquipment( MechanicalEquipment );
		// OtherEquipment
		valueObject.setOtherEquipment(domainObject.getOtherEquipment());
		// NoOfStaff
		valueObject.setNoOfStaff(domainObject.getNoOfStaff());
		// Details
		valueObject.setDetails(domainObject.getDetails());
		// SysInfo
		// set system information
		valueObject.setSysInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.nursing.domain.objects.HandlingMovementDetail extractHandlingMovementDetail(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVo valueObject) 
	{
		return 	extractHandlingMovementDetail(domainFactory, valueObject, new HashMap());
	}

	public static ims.nursing.domain.objects.HandlingMovementDetail extractHandlingMovementDetail(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.HandlingMovementDetailVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_HandlingMovementDetail();
		ims.nursing.domain.objects.HandlingMovementDetail domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.nursing.domain.objects.HandlingMovementDetail)domMap.get(valueObject);
			}
			// ims.nursing.vo.HandlingMovementDetailVo ID_HandlingMovementDetail field is unknown
			domainObject = new ims.nursing.domain.objects.HandlingMovementDetail();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_HandlingMovementDetail());
			if (domMap.get(key) != null)
			{
				return (ims.nursing.domain.objects.HandlingMovementDetail)domMap.get(key);
			}
			domainObject = (ims.nursing.domain.objects.HandlingMovementDetail) domainFactory.getDomainObject(ims.nursing.domain.objects.HandlingMovementDetail.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_HandlingMovementDetail());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getMovement() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getMovement().getID());
		}
		domainObject.setMovement(value1);
		ims.nursing.vo.lookups.MechanicalEquipCollection collection2 =
	valueObject.getMechanicalEquipment();
	    java.util.List domainMechanicalEquipment = domainObject.getMechanicalEquipment();;			
	    int collection2Size=0;
		if (collection2 == null)
		{
			domainMechanicalEquipment = new java.util.ArrayList(0);
		}
		else
		{
			collection2Size = collection2.size();
		}
		
		for(int i=0; i<collection2Size; i++) 
		{
			int instanceId = collection2.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainMechanicalEquipment.indexOf(dom);
			if (domIdx == -1)
			{
				domainMechanicalEquipment.add(i, dom);
			}
			else if (i != domIdx && i < domainMechanicalEquipment.size())
			{
				Object tmp = domainMechanicalEquipment.get(i);
				domainMechanicalEquipment.set(i, domainMechanicalEquipment.get(domIdx));
				domainMechanicalEquipment.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j2 = domainMechanicalEquipment.size();
		while (j2 > collection2Size)
		{
			domainMechanicalEquipment.remove(j2-1);
			j2 = domainMechanicalEquipment.size();
		}

		domainObject.setMechanicalEquipment(domainMechanicalEquipment);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getOtherEquipment() != null && valueObject.getOtherEquipment().equals(""))
		{
			valueObject.setOtherEquipment(null);
		}
		domainObject.setOtherEquipment(valueObject.getOtherEquipment());
		domainObject.setNoOfStaff(valueObject.getNoOfStaff());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDetails() != null && valueObject.getDetails().equals(""))
		{
			valueObject.setDetails(null);
		}
		domainObject.setDetails(valueObject.getDetails());

		return domainObject;
	}

}
