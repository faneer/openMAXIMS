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
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class TCIOutcomeForAppointmentDNAVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo copy(ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObjectDest, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TCIOutcomeForPatientElectiveList(valueObjectSrc.getID_TCIOutcomeForPatientElectiveList());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Outcome
		valueObjectDest.setOutcome(valueObjectSrc.getOutcome());
		// ChangeBy
		valueObjectDest.setChangeBy(valueObjectSrc.getChangeBy());
		// StatusDateTime
		valueObjectDest.setStatusDateTime(valueObjectSrc.getStatusDateTime());
		// OutcomeReason
		valueObjectDest.setOutcomeReason(valueObjectSrc.getOutcomeReason());
		// CancelledForNonMedicalReason
		valueObjectDest.setCancelledForNonMedicalReason(valueObjectSrc.getCancelledForNonMedicalReason());
		// CancellationReason
		valueObjectDest.setCancellationReason(valueObjectSrc.getCancellationReason());
		// ReasonComments
		valueObjectDest.setReasonComments(valueObjectSrc.getReasonComments());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList objects.
	 */
	public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(java.util.Set domainObjectSet)	
	{
		return createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList objects.
	 */
	public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voList = new ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject = (ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList) iterator.next();
			ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList objects.
	 */
	public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(java.util.List domainObjectList) 
	{
		return createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList objects.
	 */
	public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection createTCIOutcomeForAppointmentDNAVoCollectionFromTCIOutcomeForPatientElectiveList(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voList = new ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject = (ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList) domainObjectList.get(i);
			ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTCIOutcomeForPatientElectiveListSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voCollection) 
	 {
	 	return extractTCIOutcomeForPatientElectiveListSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTCIOutcomeForPatientElectiveListSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject = TCIOutcomeForAppointmentDNAVoAssembler.extractTCIOutcomeForPatientElectiveList(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTCIOutcomeForPatientElectiveListList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voCollection) 
	 {
	 	return extractTCIOutcomeForPatientElectiveListList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTCIOutcomeForPatientElectiveListList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject = TCIOutcomeForAppointmentDNAVoAssembler.extractTCIOutcomeForPatientElectiveList(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList object.
	 * @param domainObject ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList
	 */
	 public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo create(ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo create(DomainObjectMap map, ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObject = (ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo) map.getValueObject(domainObject, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList
	 */
	 public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo insert(ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObject, ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList
	 */
	 public static ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo insert(DomainObjectMap map, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObject, ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TCIOutcomeForPatientElectiveList(domainObject.getId());
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
			
		// Outcome
		ims.domain.lookups.LookupInstance instance1 = domainObject.getOutcome();
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

			ims.RefMan.vo.lookups.AdmissionOfferOutcome voLookup1 = new ims.RefMan.vo.lookups.AdmissionOfferOutcome(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.RefMan.vo.lookups.AdmissionOfferOutcome parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.RefMan.vo.lookups.AdmissionOfferOutcome(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setOutcome(voLookup1);
		}
				// ChangeBy
		if (domainObject.getChangeBy() != null)
		{
			if(domainObject.getChangeBy() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getChangeBy();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setChangeBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(id, -1));				
			}
			else
			{
				valueObject.setChangeBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(domainObject.getChangeBy().getId(), domainObject.getChangeBy().getVersion()));
			}
		}
		// StatusDateTime
		java.util.Date StatusDateTime = domainObject.getStatusDateTime();
		if ( null != StatusDateTime ) 
		{
			valueObject.setStatusDateTime(new ims.framework.utils.DateTime(StatusDateTime) );
		}
		// OutcomeReason
		ims.domain.lookups.LookupInstance instance4 = domainObject.getOutcomeReason();
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

			ims.RefMan.vo.lookups.TCIStatusChangeReason voLookup4 = new ims.RefMan.vo.lookups.TCIStatusChangeReason(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.RefMan.vo.lookups.TCIStatusChangeReason parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.RefMan.vo.lookups.TCIStatusChangeReason(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setOutcomeReason(voLookup4);
		}
				// CancelledForNonMedicalReason
		valueObject.setCancelledForNonMedicalReason( domainObject.isCancelledForNonMedicalReason() );
		// CancellationReason
		ims.domain.lookups.LookupInstance instance6 = domainObject.getCancellationReason();
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

			ims.scheduling.vo.lookups.CancelAppointmentReason voLookup6 = new ims.scheduling.vo.lookups.CancelAppointmentReason(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.scheduling.vo.lookups.CancelAppointmentReason parentVoLookup6 = voLookup6;
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
								parentVoLookup6.setParent(new ims.scheduling.vo.lookups.CancelAppointmentReason(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setCancellationReason(voLookup6);
		}
				// ReasonComments
		valueObject.setReasonComments(domainObject.getReasonComments());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList extractTCIOutcomeForPatientElectiveList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObject) 
	{
		return 	extractTCIOutcomeForPatientElectiveList(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList extractTCIOutcomeForPatientElectiveList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TCIOutcomeForPatientElectiveList();
		ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList)domMap.get(valueObject);
			}
			// ims.RefMan.vo.TCIOutcomeForAppointmentDNAVo ID_TCIOutcomeForPatientElectiveList field is unknown
			domainObject = new ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TCIOutcomeForPatientElectiveList());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList) domainFactory.getDomainObject(ims.RefMan.domain.objects.TCIOutcomeForPatientElectiveList.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TCIOutcomeForPatientElectiveList());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getOutcome() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getOutcome().getID());
		}
		domainObject.setOutcome(value1);
		ims.core.resource.people.domain.objects.MemberOfStaff value2 = null;
		if ( null != valueObject.getChangeBy() ) 
		{
			if (valueObject.getChangeBy().getBoId() == null)
			{
				if (domMap.get(valueObject.getChangeBy()) != null)
				{
					value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getChangeBy());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getChangeBy();	
			}
			else
			{
				value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getChangeBy().getBoId());
			}
		}
		domainObject.setChangeBy(value2);
		ims.framework.utils.DateTime dateTime3 = valueObject.getStatusDateTime();
		java.util.Date value3 = null;
		if ( dateTime3 != null ) 
		{
			value3 = dateTime3.getJavaDate();
		}
		domainObject.setStatusDateTime(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getOutcomeReason() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getOutcomeReason().getID());
		}
		domainObject.setOutcomeReason(value4);
		domainObject.setCancelledForNonMedicalReason(valueObject.getCancelledForNonMedicalReason());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getCancellationReason() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getCancellationReason().getID());
		}
		domainObject.setCancellationReason(value6);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getReasonComments() != null && valueObject.getReasonComments().equals(""))
		{
			valueObject.setReasonComments(null);
		}
		domainObject.setReasonComments(valueObject.getReasonComments());

		return domainObject;
	}

}
