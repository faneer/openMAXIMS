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
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class TriageProtocolAssessmentShortVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.TriageProtocolAssessmentShortVo copy(ims.emergency.vo.TriageProtocolAssessmentShortVo valueObjectDest, ims.emergency.vo.TriageProtocolAssessmentShortVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TriageProtocolAssessment(valueObjectSrc.getID_TriageProtocolAssessment());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// TriageProtocol
		valueObjectDest.setTriageProtocol(valueObjectSrc.getTriageProtocol());
		// PatientProblem
		valueObjectDest.setPatientProblem(valueObjectSrc.getPatientProblem());
		// isMain
		valueObjectDest.setIsMain(valueObjectSrc.getIsMain());
		// Discriminator
		valueObjectDest.setDiscriminator(valueObjectSrc.getDiscriminator());
		// AssessmentDateTime
		valueObjectDest.setAssessmentDateTime(valueObjectSrc.getAssessmentDateTime());
		// AssessmentNurse
		valueObjectDest.setAssessmentNurse(valueObjectSrc.getAssessmentNurse());
		// TriagePriority
		valueObjectDest.setTriagePriority(valueObjectSrc.getTriagePriority());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentShortVoCollection createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(java.util.Set domainObjectSet)	
	{
		return createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentShortVoCollection createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voList = new ims.emergency.vo.TriageProtocolAssessmentShortVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = (ims.emergency.domain.objects.TriageProtocolAssessment) iterator.next();
			ims.emergency.vo.TriageProtocolAssessmentShortVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentShortVoCollection createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(java.util.List domainObjectList) 
	{
		return createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentShortVoCollection createTriageProtocolAssessmentShortVoCollectionFromTriageProtocolAssessment(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voList = new ims.emergency.vo.TriageProtocolAssessmentShortVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = (ims.emergency.domain.objects.TriageProtocolAssessment) domainObjectList.get(i);
			ims.emergency.vo.TriageProtocolAssessmentShortVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.domain.objects.TriageProtocolAssessment set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTriageProtocolAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voCollection) 
	 {
	 	return extractTriageProtocolAssessmentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTriageProtocolAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageProtocolAssessmentShortVo vo = voCollection.get(i);
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = TriageProtocolAssessmentShortVoAssembler.extractTriageProtocolAssessment(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.domain.objects.TriageProtocolAssessment list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTriageProtocolAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voCollection) 
	 {
	 	return extractTriageProtocolAssessmentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTriageProtocolAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageProtocolAssessmentShortVo vo = voCollection.get(i);
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = TriageProtocolAssessmentShortVoAssembler.extractTriageProtocolAssessment(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.domain.objects.TriageProtocolAssessment object.
	 * @param domainObject ims.emergency.domain.objects.TriageProtocolAssessment
	 */
	 public static ims.emergency.vo.TriageProtocolAssessmentShortVo create(ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.domain.objects.TriageProtocolAssessment object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.TriageProtocolAssessmentShortVo create(DomainObjectMap map, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.TriageProtocolAssessmentShortVo valueObject = (ims.emergency.vo.TriageProtocolAssessmentShortVo) map.getValueObject(domainObject, ims.emergency.vo.TriageProtocolAssessmentShortVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.TriageProtocolAssessmentShortVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.domain.objects.TriageProtocolAssessment
	 */
	 public static ims.emergency.vo.TriageProtocolAssessmentShortVo insert(ims.emergency.vo.TriageProtocolAssessmentShortVo valueObject, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
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
	 * @param domainObject ims.emergency.domain.objects.TriageProtocolAssessment
	 */
	 public static ims.emergency.vo.TriageProtocolAssessmentShortVo insert(DomainObjectMap map, ims.emergency.vo.TriageProtocolAssessmentShortVo valueObject, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TriageProtocolAssessment(domainObject.getId());
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
			
		// TriageProtocol
		valueObject.setTriageProtocol(ims.emergency.vo.domain.ManchesterTriageProtocolConfigLiteVoAssembler.create(map, domainObject.getTriageProtocol()) );
		// PatientProblem
		valueObject.setPatientProblem(ims.emergency.vo.domain.PatientProblemForTrackingVoAssembler.create(map, domainObject.getPatientProblem()) );
		// isMain
		valueObject.setIsMain( domainObject.isIsMain() );
		// Discriminator
		valueObject.setDiscriminator(ims.emergency.vo.domain.ProtocolDiscriminatorLiteVoAssembler.create(map, domainObject.getDiscriminator()) );
		// AssessmentDateTime
		java.util.Date AssessmentDateTime = domainObject.getAssessmentDateTime();
		if ( null != AssessmentDateTime ) 
		{
			valueObject.setAssessmentDateTime(new ims.framework.utils.DateTime(AssessmentDateTime) );
		}
		// AssessmentNurse
		valueObject.setAssessmentNurse(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getAssessmentNurse()) );
		// TriagePriority
		ims.domain.lookups.LookupInstance instance7 = domainObject.getTriagePriority();
		if ( null != instance7 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance7.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance7.getImage().getImageId(), instance7.getImage().getImagePath());
			}
			color = instance7.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.TriagePriority voLookup7 = new ims.emergency.vo.lookups.TriagePriority(instance7.getId(),instance7.getText(), instance7.isActive(), null, img, color);
			ims.emergency.vo.lookups.TriagePriority parentVoLookup7 = voLookup7;
			ims.domain.lookups.LookupInstance parent7 = instance7.getParent();
			while (parent7 != null)
			{
				if (parent7.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent7.getImage().getImageId(), parent7.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent7.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup7.setParent(new ims.emergency.vo.lookups.TriagePriority(parent7.getId(),parent7.getText(), parent7.isActive(), null, img, color));
				parentVoLookup7 = parentVoLookup7.getParent();
								parent7 = parent7.getParent();
			}			
			valueObject.setTriagePriority(voLookup7);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.domain.objects.TriageProtocolAssessment extractTriageProtocolAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVo valueObject) 
	{
		return 	extractTriageProtocolAssessment(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.domain.objects.TriageProtocolAssessment extractTriageProtocolAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentShortVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TriageProtocolAssessment();
		ims.emergency.domain.objects.TriageProtocolAssessment domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.domain.objects.TriageProtocolAssessment)domMap.get(valueObject);
			}
			// ims.emergency.vo.TriageProtocolAssessmentShortVo ID_TriageProtocolAssessment field is unknown
			domainObject = new ims.emergency.domain.objects.TriageProtocolAssessment();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TriageProtocolAssessment());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.domain.objects.TriageProtocolAssessment)domMap.get(key);
			}
			domainObject = (ims.emergency.domain.objects.TriageProtocolAssessment) domainFactory.getDomainObject(ims.emergency.domain.objects.TriageProtocolAssessment.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TriageProtocolAssessment());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration value1 = null;
		if ( null != valueObject.getTriageProtocol() ) 
		{
			if (valueObject.getTriageProtocol().getBoId() == null)
			{
				if (domMap.get(valueObject.getTriageProtocol()) != null)
				{
					value1 = (ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration)domMap.get(valueObject.getTriageProtocol());
				}
			}
			else
			{
				value1 = (ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration)domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration.class, valueObject.getTriageProtocol().getBoId());
			}
		}
		domainObject.setTriageProtocol(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.PatientProblem value2 = null;
		if ( null != valueObject.getPatientProblem() ) 
		{
			if (valueObject.getPatientProblem().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatientProblem()) != null)
				{
					value2 = (ims.core.clinical.domain.objects.PatientProblem)domMap.get(valueObject.getPatientProblem());
				}
			}
			else
			{
				value2 = (ims.core.clinical.domain.objects.PatientProblem)domainFactory.getDomainObject(ims.core.clinical.domain.objects.PatientProblem.class, valueObject.getPatientProblem().getBoId());
			}
		}
		domainObject.setPatientProblem(value2);
		domainObject.setIsMain(valueObject.getIsMain());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.emergency.configuration.domain.objects.ProtocolDiscriminator value4 = null;
		if ( null != valueObject.getDiscriminator() ) 
		{
			if (valueObject.getDiscriminator().getBoId() == null)
			{
				if (domMap.get(valueObject.getDiscriminator()) != null)
				{
					value4 = (ims.emergency.configuration.domain.objects.ProtocolDiscriminator)domMap.get(valueObject.getDiscriminator());
				}
			}
			else
			{
				value4 = (ims.emergency.configuration.domain.objects.ProtocolDiscriminator)domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.ProtocolDiscriminator.class, valueObject.getDiscriminator().getBoId());
			}
		}
		domainObject.setDiscriminator(value4);
		ims.framework.utils.DateTime dateTime5 = valueObject.getAssessmentDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setAssessmentDateTime(value5);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value6 = null;
		if ( null != valueObject.getAssessmentNurse() ) 
		{
			if (valueObject.getAssessmentNurse().getBoId() == null)
			{
				if (domMap.get(valueObject.getAssessmentNurse()) != null)
				{
					value6 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getAssessmentNurse());
				}
			}
			else
			{
				value6 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getAssessmentNurse().getBoId());
			}
		}
		domainObject.setAssessmentNurse(value6);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value7 = null;
		if ( null != valueObject.getTriagePriority() ) 
		{
			value7 =
				domainFactory.getLookupInstance(valueObject.getTriagePriority().getID());
		}
		domainObject.setTriagePriority(value7);

		return domainObject;
	}

}
