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
 * @author Sinead McDermott
 */
public class SupportNetworkProfessionalVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.SupportNetworkProfessionalVo copy(ims.core.vo.SupportNetworkProfessionalVo valueObjectDest, ims.core.vo.SupportNetworkProfessionalVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SupportNetworkProfessional(valueObjectSrc.getID_SupportNetworkProfessional());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// isCurrActiveProfSupp
		valueObjectDest.setIsCurrActiveProfSupp(valueObjectSrc.getIsCurrActiveProfSupp());
		// isAdmissionHCP
		valueObjectDest.setIsAdmissionHCP(valueObjectSrc.getIsAdmissionHCP());
		// HcpSubType
		valueObjectDest.setHcpSubType(valueObjectSrc.getHcpSubType());
		// currentLocation
		valueObjectDest.setCurrentLocation(valueObjectSrc.getCurrentLocation());
		// MOS
		valueObjectDest.setMOS(valueObjectSrc.getMOS());
		// SysInfo
		valueObjectDest.setSysInfo(valueObjectSrc.getSysInfo());
		// SuppliedProfessional
		valueObjectDest.setSuppliedProfessional(valueObjectSrc.getSuppliedProfessional());
		// Profession
		valueObjectDest.setProfession(valueObjectSrc.getProfession());
		// AuthorngInfo
		valueObjectDest.setAuthorngInfo(valueObjectSrc.getAuthorngInfo());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.SupportNetworkProfessional objects.
	 */
	public static ims.core.vo.SupportNetworkProfessionalVoCollection createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(java.util.Set domainObjectSet)	
	{
		return createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.SupportNetworkProfessional objects.
	 */
	public static ims.core.vo.SupportNetworkProfessionalVoCollection createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.SupportNetworkProfessionalVoCollection voList = new ims.core.vo.SupportNetworkProfessionalVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject = (ims.core.clinical.domain.objects.SupportNetworkProfessional) iterator.next();
			ims.core.vo.SupportNetworkProfessionalVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.SupportNetworkProfessional objects.
	 */
	public static ims.core.vo.SupportNetworkProfessionalVoCollection createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(java.util.List domainObjectList) 
	{
		return createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.SupportNetworkProfessional objects.
	 */
	public static ims.core.vo.SupportNetworkProfessionalVoCollection createSupportNetworkProfessionalVoCollectionFromSupportNetworkProfessional(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.SupportNetworkProfessionalVoCollection voList = new ims.core.vo.SupportNetworkProfessionalVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject = (ims.core.clinical.domain.objects.SupportNetworkProfessional) domainObjectList.get(i);
			ims.core.vo.SupportNetworkProfessionalVo vo = create(map, domainObject);

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
	 * Create the ims.core.clinical.domain.objects.SupportNetworkProfessional set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSupportNetworkProfessionalSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVoCollection voCollection) 
	 {
	 	return extractSupportNetworkProfessionalSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSupportNetworkProfessionalSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SupportNetworkProfessionalVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject = SupportNetworkProfessionalVoAssembler.extractSupportNetworkProfessional(domainFactory, vo, domMap);

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
	 * Create the ims.core.clinical.domain.objects.SupportNetworkProfessional list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSupportNetworkProfessionalList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVoCollection voCollection) 
	 {
	 	return extractSupportNetworkProfessionalList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSupportNetworkProfessionalList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SupportNetworkProfessionalVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject = SupportNetworkProfessionalVoAssembler.extractSupportNetworkProfessional(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.clinical.domain.objects.SupportNetworkProfessional object.
	 * @param domainObject ims.core.clinical.domain.objects.SupportNetworkProfessional
	 */
	 public static ims.core.vo.SupportNetworkProfessionalVo create(ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.clinical.domain.objects.SupportNetworkProfessional object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.SupportNetworkProfessionalVo create(DomainObjectMap map, ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.SupportNetworkProfessionalVo valueObject = (ims.core.vo.SupportNetworkProfessionalVo) map.getValueObject(domainObject, ims.core.vo.SupportNetworkProfessionalVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.SupportNetworkProfessionalVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.clinical.domain.objects.SupportNetworkProfessional
	 */
	 public static ims.core.vo.SupportNetworkProfessionalVo insert(ims.core.vo.SupportNetworkProfessionalVo valueObject, ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject) 
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
	 * @param domainObject ims.core.clinical.domain.objects.SupportNetworkProfessional
	 */
	 public static ims.core.vo.SupportNetworkProfessionalVo insert(DomainObjectMap map, ims.core.vo.SupportNetworkProfessionalVo valueObject, ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SupportNetworkProfessional(domainObject.getId());
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
			
		// isCurrActiveProfSupp
		valueObject.setIsCurrActiveProfSupp( domainObject.isIsCurrActiveProfSupp() );
		// isAdmissionHCP
		valueObject.setIsAdmissionHCP( domainObject.isIsAdmissionHCP() );
		// HcpSubType
		ims.domain.lookups.LookupInstance instance3 = domainObject.getHcpSubType();
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

			ims.core.vo.lookups.HcpDisType voLookup3 = new ims.core.vo.lookups.HcpDisType(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.HcpDisType parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.HcpDisType(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setHcpSubType(voLookup3);
		}
				// currentLocation
		valueObject.setCurrentLocation(ims.core.vo.domain.LocShortVoAssembler.create(map, domainObject.getCurrentLocation()) );
		// MOS
		valueObject.setMOS(ims.core.vo.domain.MemberOfStaffShortVoAssembler.create(map, domainObject.getMOS()) );
		// SysInfo
		// set system information
		valueObject.setSysInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
		// SuppliedProfessional
		valueObject.setSuppliedProfessional(ims.core.vo.domain.SuppNetworkServiceProfessionDetailVoAssembler.create(map, domainObject.getSuppliedProfessional()) );
		// Profession
		ims.domain.lookups.LookupInstance instance8 = domainObject.getProfession();
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

			ims.core.vo.lookups.HcpDisType voLookup8 = new ims.core.vo.lookups.HcpDisType(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.HcpDisType parentVoLookup8 = voLookup8;
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
								parentVoLookup8.setParent(new ims.core.vo.lookups.HcpDisType(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setProfession(voLookup8);
		}
				// AuthorngInfo
		valueObject.setAuthorngInfo(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthorngInfo()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.clinical.domain.objects.SupportNetworkProfessional extractSupportNetworkProfessional(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVo valueObject) 
	{
		return 	extractSupportNetworkProfessional(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.clinical.domain.objects.SupportNetworkProfessional extractSupportNetworkProfessional(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SupportNetworkProfessionalVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SupportNetworkProfessional();
		ims.core.clinical.domain.objects.SupportNetworkProfessional domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.clinical.domain.objects.SupportNetworkProfessional)domMap.get(valueObject);
			}
			// ims.core.vo.SupportNetworkProfessionalVo ID_SupportNetworkProfessional field is unknown
			domainObject = new ims.core.clinical.domain.objects.SupportNetworkProfessional();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SupportNetworkProfessional());
			if (domMap.get(key) != null)
			{
				return (ims.core.clinical.domain.objects.SupportNetworkProfessional)domMap.get(key);
			}
			domainObject = (ims.core.clinical.domain.objects.SupportNetworkProfessional) domainFactory.getDomainObject(ims.core.clinical.domain.objects.SupportNetworkProfessional.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SupportNetworkProfessional());

		domainObject.setIsCurrActiveProfSupp(valueObject.getIsCurrActiveProfSupp());
		domainObject.setIsAdmissionHCP(valueObject.getIsAdmissionHCP());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getHcpSubType() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getHcpSubType().getID());
		}
		domainObject.setHcpSubType(value3);
		domainObject.setCurrentLocation(ims.core.vo.domain.LocShortVoAssembler.extractLocation(domainFactory, valueObject.getCurrentLocation(), domMap));
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.MemberOfStaff value5 = null;
		if ( null != valueObject.getMOS() ) 
		{
			if (valueObject.getMOS().getBoId() == null)
			{
				if (domMap.get(valueObject.getMOS()) != null)
				{
					value5 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getMOS());
				}
			}
			else
			{
				value5 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getMOS().getBoId());
			}
		}
		domainObject.setMOS(value5);
		domainObject.setSuppliedProfessional(ims.core.vo.domain.SuppNetworkServiceProfessionDetailVoAssembler.extractSuppNetworkServiceProfessionDetail(domainFactory, valueObject.getSuppliedProfessional(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getProfession() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getProfession().getID());
		}
		domainObject.setProfession(value8);
		domainObject.setAuthorngInfo(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthorngInfo(), domMap));

		return domainObject;
	}

}
