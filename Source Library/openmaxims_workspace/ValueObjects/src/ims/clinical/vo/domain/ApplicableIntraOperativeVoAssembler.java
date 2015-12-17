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
 * @author Daniel Laffan
 */
public class ApplicableIntraOperativeVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.ApplicableIntraOperativeVo copy(ims.clinical.vo.ApplicableIntraOperativeVo valueObjectDest, ims.clinical.vo.ApplicableIntraOperativeVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ApplicableIntraOperative(valueObjectSrc.getID_ApplicableIntraOperative());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// TheatreAppointment
		valueObjectDest.setTheatreAppointment(valueObjectSrc.getTheatreAppointment());
		// DisplayPlannedProcedures
		valueObjectDest.setDisplayPlannedProcedures(valueObjectSrc.getDisplayPlannedProcedures());
		// DisplayAnaestheticDetails
		valueObjectDest.setDisplayAnaestheticDetails(valueObjectSrc.getDisplayAnaestheticDetails());
		// DisplayPrepAndPositioning
		valueObjectDest.setDisplayPrepAndPositioning(valueObjectSrc.getDisplayPrepAndPositioning());
		// DisplayDiathermyAndLaser
		valueObjectDest.setDisplayDiathermyAndLaser(valueObjectSrc.getDisplayDiathermyAndLaser());
		// DisplayIrrigantCatheters
		valueObjectDest.setDisplayIrrigantCatheters(valueObjectSrc.getDisplayIrrigantCatheters());
		// DisplaySpecimenWounds
		valueObjectDest.setDisplaySpecimenWounds(valueObjectSrc.getDisplaySpecimenWounds());
		// DisplayImplantsArterial
		valueObjectDest.setDisplayImplantsArterial(valueObjectSrc.getDisplayImplantsArterial());
		// DisplayTourniquet
		valueObjectDest.setDisplayTourniquet(valueObjectSrc.getDisplayTourniquet());
		// DisplayCountsOccurances
		valueObjectDest.setDisplayCountsOccurances(valueObjectSrc.getDisplayCountsOccurances());
		// DisplayPerformedProcedures
		valueObjectDest.setDisplayPerformedProcedures(valueObjectSrc.getDisplayPerformedProcedures());
		// DisplayPACU
		valueObjectDest.setDisplayPACU(valueObjectSrc.getDisplayPACU());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.ApplicableIntraOperative objects.
	 */
	public static ims.clinical.vo.ApplicableIntraOperativeVoCollection createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(java.util.Set domainObjectSet)	
	{
		return createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.ApplicableIntraOperative objects.
	 */
	public static ims.clinical.vo.ApplicableIntraOperativeVoCollection createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.ApplicableIntraOperativeVoCollection voList = new ims.clinical.vo.ApplicableIntraOperativeVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.ApplicableIntraOperative domainObject = (ims.clinical.domain.objects.ApplicableIntraOperative) iterator.next();
			ims.clinical.vo.ApplicableIntraOperativeVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.ApplicableIntraOperative objects.
	 */
	public static ims.clinical.vo.ApplicableIntraOperativeVoCollection createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(java.util.List domainObjectList) 
	{
		return createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.ApplicableIntraOperative objects.
	 */
	public static ims.clinical.vo.ApplicableIntraOperativeVoCollection createApplicableIntraOperativeVoCollectionFromApplicableIntraOperative(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.ApplicableIntraOperativeVoCollection voList = new ims.clinical.vo.ApplicableIntraOperativeVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.ApplicableIntraOperative domainObject = (ims.clinical.domain.objects.ApplicableIntraOperative) domainObjectList.get(i);
			ims.clinical.vo.ApplicableIntraOperativeVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.ApplicableIntraOperative set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractApplicableIntraOperativeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVoCollection voCollection) 
	 {
	 	return extractApplicableIntraOperativeSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractApplicableIntraOperativeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.ApplicableIntraOperativeVo vo = voCollection.get(i);
			ims.clinical.domain.objects.ApplicableIntraOperative domainObject = ApplicableIntraOperativeVoAssembler.extractApplicableIntraOperative(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.ApplicableIntraOperative list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractApplicableIntraOperativeList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVoCollection voCollection) 
	 {
	 	return extractApplicableIntraOperativeList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractApplicableIntraOperativeList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.ApplicableIntraOperativeVo vo = voCollection.get(i);
			ims.clinical.domain.objects.ApplicableIntraOperative domainObject = ApplicableIntraOperativeVoAssembler.extractApplicableIntraOperative(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.ApplicableIntraOperative object.
	 * @param domainObject ims.clinical.domain.objects.ApplicableIntraOperative
	 */
	 public static ims.clinical.vo.ApplicableIntraOperativeVo create(ims.clinical.domain.objects.ApplicableIntraOperative domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.ApplicableIntraOperative object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.ApplicableIntraOperativeVo create(DomainObjectMap map, ims.clinical.domain.objects.ApplicableIntraOperative domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.ApplicableIntraOperativeVo valueObject = (ims.clinical.vo.ApplicableIntraOperativeVo) map.getValueObject(domainObject, ims.clinical.vo.ApplicableIntraOperativeVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.ApplicableIntraOperativeVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.ApplicableIntraOperative
	 */
	 public static ims.clinical.vo.ApplicableIntraOperativeVo insert(ims.clinical.vo.ApplicableIntraOperativeVo valueObject, ims.clinical.domain.objects.ApplicableIntraOperative domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.ApplicableIntraOperative
	 */
	 public static ims.clinical.vo.ApplicableIntraOperativeVo insert(DomainObjectMap map, ims.clinical.vo.ApplicableIntraOperativeVo valueObject, ims.clinical.domain.objects.ApplicableIntraOperative domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ApplicableIntraOperative(domainObject.getId());
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
			
		// TheatreAppointment
		if (domainObject.getTheatreAppointment() != null)
		{
			if(domainObject.getTheatreAppointment() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getTheatreAppointment();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setTheatreAppointment(new ims.scheduling.vo.Booking_AppointmentRefVo(id, -1));				
			}
			else
			{
				valueObject.setTheatreAppointment(new ims.scheduling.vo.Booking_AppointmentRefVo(domainObject.getTheatreAppointment().getId(), domainObject.getTheatreAppointment().getVersion()));
			}
		}
		// DisplayPlannedProcedures
		valueObject.setDisplayPlannedProcedures( domainObject.isDisplayPlannedProcedures() );
		// DisplayAnaestheticDetails
		valueObject.setDisplayAnaestheticDetails( domainObject.isDisplayAnaestheticDetails() );
		// DisplayPrepAndPositioning
		valueObject.setDisplayPrepAndPositioning( domainObject.isDisplayPrepAndPositioning() );
		// DisplayDiathermyAndLaser
		valueObject.setDisplayDiathermyAndLaser( domainObject.isDisplayDiathermyAndLaser() );
		// DisplayIrrigantCatheters
		valueObject.setDisplayIrrigantCatheters( domainObject.isDisplayIrrigantCatheters() );
		// DisplaySpecimenWounds
		valueObject.setDisplaySpecimenWounds( domainObject.isDisplaySpecimenWounds() );
		// DisplayImplantsArterial
		valueObject.setDisplayImplantsArterial( domainObject.isDisplayImplantsArterial() );
		// DisplayTourniquet
		valueObject.setDisplayTourniquet( domainObject.isDisplayTourniquet() );
		// DisplayCountsOccurances
		valueObject.setDisplayCountsOccurances( domainObject.isDisplayCountsOccurances() );
		// DisplayPerformedProcedures
		valueObject.setDisplayPerformedProcedures( domainObject.isDisplayPerformedProcedures() );
		// DisplayPACU
		valueObject.setDisplayPACU( domainObject.isDisplayPACU() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.ApplicableIntraOperative extractApplicableIntraOperative(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVo valueObject) 
	{
		return 	extractApplicableIntraOperative(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.ApplicableIntraOperative extractApplicableIntraOperative(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ApplicableIntraOperativeVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ApplicableIntraOperative();
		ims.clinical.domain.objects.ApplicableIntraOperative domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.ApplicableIntraOperative)domMap.get(valueObject);
			}
			// ims.clinical.vo.ApplicableIntraOperativeVo ID_ApplicableIntraOperative field is unknown
			domainObject = new ims.clinical.domain.objects.ApplicableIntraOperative();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ApplicableIntraOperative());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.ApplicableIntraOperative)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.ApplicableIntraOperative) domainFactory.getDomainObject(ims.clinical.domain.objects.ApplicableIntraOperative.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ApplicableIntraOperative());

		ims.scheduling.domain.objects.Booking_Appointment value1 = null;
		if ( null != valueObject.getTheatreAppointment() ) 
		{
			if (valueObject.getTheatreAppointment().getBoId() == null)
			{
				if (domMap.get(valueObject.getTheatreAppointment()) != null)
				{
					value1 = (ims.scheduling.domain.objects.Booking_Appointment)domMap.get(valueObject.getTheatreAppointment());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getTheatreAppointment();	
			}
			else
			{
				value1 = (ims.scheduling.domain.objects.Booking_Appointment)domainFactory.getDomainObject(ims.scheduling.domain.objects.Booking_Appointment.class, valueObject.getTheatreAppointment().getBoId());
			}
		}
		domainObject.setTheatreAppointment(value1);
		domainObject.setDisplayPlannedProcedures(valueObject.getDisplayPlannedProcedures());
		domainObject.setDisplayAnaestheticDetails(valueObject.getDisplayAnaestheticDetails());
		domainObject.setDisplayPrepAndPositioning(valueObject.getDisplayPrepAndPositioning());
		domainObject.setDisplayDiathermyAndLaser(valueObject.getDisplayDiathermyAndLaser());
		domainObject.setDisplayIrrigantCatheters(valueObject.getDisplayIrrigantCatheters());
		domainObject.setDisplaySpecimenWounds(valueObject.getDisplaySpecimenWounds());
		domainObject.setDisplayImplantsArterial(valueObject.getDisplayImplantsArterial());
		domainObject.setDisplayTourniquet(valueObject.getDisplayTourniquet());
		domainObject.setDisplayCountsOccurances(valueObject.getDisplayCountsOccurances());
		domainObject.setDisplayPerformedProcedures(valueObject.getDisplayPerformedProcedures());
		domainObject.setDisplayPACU(valueObject.getDisplayPACU());

		return domainObject;
	}

}
