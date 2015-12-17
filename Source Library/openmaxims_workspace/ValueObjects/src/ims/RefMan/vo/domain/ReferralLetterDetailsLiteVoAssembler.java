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
 * @author Daniel Laffan
 */
public class ReferralLetterDetailsLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.ReferralLetterDetailsLiteVo copy(ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObjectDest, ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralLetterDetails(valueObjectSrc.getID_ReferralLetterDetails());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Service
		valueObjectDest.setService(valueObjectSrc.getService());
		// ReferrerType
		valueObjectDest.setReferrerType(valueObjectSrc.getReferrerType());
		// AlliedHealthProfName
		valueObjectDest.setAlliedHealthProfName(valueObjectSrc.getAlliedHealthProfName());
		// DateOfReferral
		valueObjectDest.setDateOfReferral(valueObjectSrc.getDateOfReferral());
		// DateReferralReceived
		valueObjectDest.setDateReferralReceived(valueObjectSrc.getDateReferralReceived());
		// Transport
		valueObjectDest.setTransport(valueObjectSrc.getTransport());
		// SpecialRequirements
		valueObjectDest.setSpecialRequirements(valueObjectSrc.getSpecialRequirements());
		// IsDADReferral
		valueObjectDest.setIsDADReferral(valueObjectSrc.getIsDADReferral());
		// Location
		valueObjectDest.setLocation(valueObjectSrc.getLocation());
		// EndDateKPI
		valueObjectDest.setEndDateKPI(valueObjectSrc.getEndDateKPI());
		// EndDateEmailKPI
		valueObjectDest.setEndDateEmailKPI(valueObjectSrc.getEndDateEmailKPI());
		// EndDatePaperKPI
		valueObjectDest.setEndDatePaperKPI(valueObjectSrc.getEndDatePaperKPI());
		// End18WW
		valueObjectDest.setEnd18WW(valueObjectSrc.getEnd18WW());
		// Consultant
		valueObjectDest.setConsultant(valueObjectSrc.getConsultant());
		// Function
		valueObjectDest.setFunction(valueObjectSrc.getFunction());
		// OriginalDateOfReferral
		valueObjectDest.setOriginalDateOfReferral(valueObjectSrc.getOriginalDateOfReferral());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.ReferralLetterDetails objects.
	 */
	public static ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(java.util.Set domainObjectSet)	
	{
		return createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.clinical.domain.objects.ReferralLetterDetails objects.
	 */
	public static ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voList = new ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.clinical.domain.objects.ReferralLetterDetails domainObject = (ims.core.clinical.domain.objects.ReferralLetterDetails) iterator.next();
			ims.RefMan.vo.ReferralLetterDetailsLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.ReferralLetterDetails objects.
	 */
	public static ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(java.util.List domainObjectList) 
	{
		return createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.clinical.domain.objects.ReferralLetterDetails objects.
	 */
	public static ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection createReferralLetterDetailsLiteVoCollectionFromReferralLetterDetails(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voList = new ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.clinical.domain.objects.ReferralLetterDetails domainObject = (ims.core.clinical.domain.objects.ReferralLetterDetails) domainObjectList.get(i);
			ims.RefMan.vo.ReferralLetterDetailsLiteVo vo = create(map, domainObject);

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
	 * Create the ims.core.clinical.domain.objects.ReferralLetterDetails set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralLetterDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voCollection) 
	 {
	 	return extractReferralLetterDetailsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralLetterDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ReferralLetterDetailsLiteVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.ReferralLetterDetails domainObject = ReferralLetterDetailsLiteVoAssembler.extractReferralLetterDetails(domainFactory, vo, domMap);

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
	 * Create the ims.core.clinical.domain.objects.ReferralLetterDetails list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralLetterDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voCollection) 
	 {
	 	return extractReferralLetterDetailsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralLetterDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ReferralLetterDetailsLiteVo vo = voCollection.get(i);
			ims.core.clinical.domain.objects.ReferralLetterDetails domainObject = ReferralLetterDetailsLiteVoAssembler.extractReferralLetterDetails(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.clinical.domain.objects.ReferralLetterDetails object.
	 * @param domainObject ims.core.clinical.domain.objects.ReferralLetterDetails
	 */
	 public static ims.RefMan.vo.ReferralLetterDetailsLiteVo create(ims.core.clinical.domain.objects.ReferralLetterDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.clinical.domain.objects.ReferralLetterDetails object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.ReferralLetterDetailsLiteVo create(DomainObjectMap map, ims.core.clinical.domain.objects.ReferralLetterDetails domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObject = (ims.RefMan.vo.ReferralLetterDetailsLiteVo) map.getValueObject(domainObject, ims.RefMan.vo.ReferralLetterDetailsLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.ReferralLetterDetailsLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.clinical.domain.objects.ReferralLetterDetails
	 */
	 public static ims.RefMan.vo.ReferralLetterDetailsLiteVo insert(ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObject, ims.core.clinical.domain.objects.ReferralLetterDetails domainObject) 
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
	 * @param domainObject ims.core.clinical.domain.objects.ReferralLetterDetails
	 */
	 public static ims.RefMan.vo.ReferralLetterDetailsLiteVo insert(DomainObjectMap map, ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObject, ims.core.clinical.domain.objects.ReferralLetterDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralLetterDetails(domainObject.getId());
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
			
		// Service
		valueObject.setService(ims.core.vo.domain.ServiceLiteVoAssembler.create(map, domainObject.getService()) );
		// ReferrerType
		ims.domain.lookups.LookupInstance instance2 = domainObject.getReferrerType();
		if ( null != instance2 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance2.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance2.getImage().getImageId(), instance2.getImage().getImagePath());
			}
			color = instance2.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.SourceOfReferral voLookup2 = new ims.core.vo.lookups.SourceOfReferral(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.core.vo.lookups.SourceOfReferral parentVoLookup2 = voLookup2;
			ims.domain.lookups.LookupInstance parent2 = instance2.getParent();
			while (parent2 != null)
			{
				if (parent2.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent2.getImage().getImageId(), parent2.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent2.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup2.setParent(new ims.core.vo.lookups.SourceOfReferral(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setReferrerType(voLookup2);
		}
				// AlliedHealthProfName
		valueObject.setAlliedHealthProfName(domainObject.getAlliedHealthProfName());
		// DateOfReferral
		java.util.Date DateOfReferral = domainObject.getDateOfReferral();
		if ( null != DateOfReferral ) 
		{
			valueObject.setDateOfReferral(new ims.framework.utils.Date(DateOfReferral) );
		}
		// DateReferralReceived
		java.util.Date DateReferralReceived = domainObject.getDateReferralReceived();
		if ( null != DateReferralReceived ) 
		{
			valueObject.setDateReferralReceived(new ims.framework.utils.Date(DateReferralReceived) );
		}
		// Transport
		ims.domain.lookups.LookupInstance instance6 = domainObject.getTransport();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.scheduling.vo.lookups.ApptTransportType voLookup6 = new ims.scheduling.vo.lookups.ApptTransportType(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.scheduling.vo.lookups.ApptTransportType parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.scheduling.vo.lookups.ApptTransportType(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setTransport(voLookup6);
		}
				// SpecialRequirements
		valueObject.setSpecialRequirements(domainObject.getSpecialRequirements());
		// IsDADReferral
		valueObject.setIsDADReferral( domainObject.isIsDADReferral() );
		// Location
		valueObject.setLocation(ims.core.vo.domain.LocationLiteVoAssembler.create(map, domainObject.getLocation()) );
		// EndDateKPI
		java.util.Date EndDateKPI = domainObject.getEndDateKPI();
		if ( null != EndDateKPI ) 
		{
			valueObject.setEndDateKPI(new ims.framework.utils.Date(EndDateKPI) );
		}
		// EndDateEmailKPI
		java.util.Date EndDateEmailKPI = domainObject.getEndDateEmailKPI();
		if ( null != EndDateEmailKPI ) 
		{
			valueObject.setEndDateEmailKPI(new ims.framework.utils.Date(EndDateEmailKPI) );
		}
		// EndDatePaperKPI
		java.util.Date EndDatePaperKPI = domainObject.getEndDatePaperKPI();
		if ( null != EndDatePaperKPI ) 
		{
			valueObject.setEndDatePaperKPI(new ims.framework.utils.Date(EndDatePaperKPI) );
		}
		// End18WW
		java.util.Date End18WW = domainObject.getEnd18WW();
		if ( null != End18WW ) 
		{
			valueObject.setEnd18WW(new ims.framework.utils.Date(End18WW) );
		}
		// Consultant
		valueObject.setConsultant(ims.core.vo.domain.HcpMinVoAssembler.create(map, domainObject.getConsultant()) );
		// Function
		valueObject.setFunction(ims.core.vo.domain.ServiceFunctionLiteVoAssembler.create(map, domainObject.getFunction()) );
		// OriginalDateOfReferral
		java.util.Date OriginalDateOfReferral = domainObject.getOriginalDateOfReferral();
		if ( null != OriginalDateOfReferral ) 
		{
			valueObject.setOriginalDateOfReferral(new ims.framework.utils.Date(OriginalDateOfReferral) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.clinical.domain.objects.ReferralLetterDetails extractReferralLetterDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObject) 
	{
		return 	extractReferralLetterDetails(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.clinical.domain.objects.ReferralLetterDetails extractReferralLetterDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralLetterDetailsLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralLetterDetails();
		ims.core.clinical.domain.objects.ReferralLetterDetails domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.clinical.domain.objects.ReferralLetterDetails)domMap.get(valueObject);
			}
			// ims.RefMan.vo.ReferralLetterDetailsLiteVo ID_ReferralLetterDetails field is unknown
			domainObject = new ims.core.clinical.domain.objects.ReferralLetterDetails();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralLetterDetails());
			if (domMap.get(key) != null)
			{
				return (ims.core.clinical.domain.objects.ReferralLetterDetails)domMap.get(key);
			}
			domainObject = (ims.core.clinical.domain.objects.ReferralLetterDetails) domainFactory.getDomainObject(ims.core.clinical.domain.objects.ReferralLetterDetails.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralLetterDetails());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Service value1 = null;
		if ( null != valueObject.getService() ) 
		{
			if (valueObject.getService().getBoId() == null)
			{
				if (domMap.get(valueObject.getService()) != null)
				{
					value1 = (ims.core.clinical.domain.objects.Service)domMap.get(valueObject.getService());
				}
			}
			else
			{
				value1 = (ims.core.clinical.domain.objects.Service)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Service.class, valueObject.getService().getBoId());
			}
		}
		domainObject.setService(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getReferrerType() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getReferrerType().getID());
		}
		domainObject.setReferrerType(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAlliedHealthProfName() != null && valueObject.getAlliedHealthProfName().equals(""))
		{
			valueObject.setAlliedHealthProfName(null);
		}
		domainObject.setAlliedHealthProfName(valueObject.getAlliedHealthProfName());
		java.util.Date value4 = null;
		ims.framework.utils.Date date4 = valueObject.getDateOfReferral();		
		if ( date4 != null ) 
		{
			value4 = date4.getDate();
		}
		domainObject.setDateOfReferral(value4);
		java.util.Date value5 = null;
		ims.framework.utils.Date date5 = valueObject.getDateReferralReceived();		
		if ( date5 != null ) 
		{
			value5 = date5.getDate();
		}
		domainObject.setDateReferralReceived(value5);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getTransport() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getTransport().getID());
		}
		domainObject.setTransport(value6);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSpecialRequirements() != null && valueObject.getSpecialRequirements().equals(""))
		{
			valueObject.setSpecialRequirements(null);
		}
		domainObject.setSpecialRequirements(valueObject.getSpecialRequirements());
		domainObject.setIsDADReferral(valueObject.getIsDADReferral());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.place.domain.objects.Location value9 = null;
		if ( null != valueObject.getLocation() ) 
		{
			if (valueObject.getLocation().getBoId() == null)
			{
				if (domMap.get(valueObject.getLocation()) != null)
				{
					value9 = (ims.core.resource.place.domain.objects.Location)domMap.get(valueObject.getLocation());
				}
			}
			else
			{
				value9 = (ims.core.resource.place.domain.objects.Location)domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Location.class, valueObject.getLocation().getBoId());
			}
		}
		domainObject.setLocation(value9);
		java.util.Date value10 = null;
		ims.framework.utils.Date date10 = valueObject.getEndDateKPI();		
		if ( date10 != null ) 
		{
			value10 = date10.getDate();
		}
		domainObject.setEndDateKPI(value10);
		java.util.Date value11 = null;
		ims.framework.utils.Date date11 = valueObject.getEndDateEmailKPI();		
		if ( date11 != null ) 
		{
			value11 = date11.getDate();
		}
		domainObject.setEndDateEmailKPI(value11);
		java.util.Date value12 = null;
		ims.framework.utils.Date date12 = valueObject.getEndDatePaperKPI();		
		if ( date12 != null ) 
		{
			value12 = date12.getDate();
		}
		domainObject.setEndDatePaperKPI(value12);
		java.util.Date value13 = null;
		ims.framework.utils.Date date13 = valueObject.getEnd18WW();		
		if ( date13 != null ) 
		{
			value13 = date13.getDate();
		}
		domainObject.setEnd18WW(value13);
		domainObject.setConsultant(ims.core.vo.domain.HcpMinVoAssembler.extractHcp(domainFactory, valueObject.getConsultant(), domMap));
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.ServiceFunction value15 = null;
		if ( null != valueObject.getFunction() ) 
		{
			if (valueObject.getFunction().getBoId() == null)
			{
				if (domMap.get(valueObject.getFunction()) != null)
				{
					value15 = (ims.core.clinical.domain.objects.ServiceFunction)domMap.get(valueObject.getFunction());
				}
			}
			else
			{
				value15 = (ims.core.clinical.domain.objects.ServiceFunction)domainFactory.getDomainObject(ims.core.clinical.domain.objects.ServiceFunction.class, valueObject.getFunction().getBoId());
			}
		}
		domainObject.setFunction(value15);
		java.util.Date value16 = null;
		ims.framework.utils.Date date16 = valueObject.getOriginalDateOfReferral();		
		if ( date16 != null ) 
		{
			value16 = date16.getDate();
		}
		domainObject.setOriginalDateOfReferral(value16);

		return domainObject;
	}

}
