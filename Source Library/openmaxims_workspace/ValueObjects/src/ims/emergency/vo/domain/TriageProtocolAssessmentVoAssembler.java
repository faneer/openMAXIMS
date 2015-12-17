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
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class TriageProtocolAssessmentVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.TriageProtocolAssessmentVo copy(ims.emergency.vo.TriageProtocolAssessmentVo valueObjectDest, ims.emergency.vo.TriageProtocolAssessmentVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TriageProtocolAssessment(valueObjectSrc.getID_TriageProtocolAssessment());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Patient
		valueObjectDest.setPatient(valueObjectSrc.getPatient());
		// Episode
		valueObjectDest.setEpisode(valueObjectSrc.getEpisode());
		// Attendance
		valueObjectDest.setAttendance(valueObjectSrc.getAttendance());
		// PatientProblem
		valueObjectDest.setPatientProblem(valueObjectSrc.getPatientProblem());
		// isMain
		valueObjectDest.setIsMain(valueObjectSrc.getIsMain());
		// TriageProtocol
		valueObjectDest.setTriageProtocol(valueObjectSrc.getTriageProtocol());
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
 	 * If more than one call to an Assembler is made then #createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentVoCollection createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(java.util.Set domainObjectSet)	
	{
		return createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentVoCollection createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.TriageProtocolAssessmentVoCollection voList = new ims.emergency.vo.TriageProtocolAssessmentVoCollection();
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
			ims.emergency.vo.TriageProtocolAssessmentVo vo = create(map, domainObject);
			
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
	public static ims.emergency.vo.TriageProtocolAssessmentVoCollection createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(java.util.List domainObjectList) 
	{
		return createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.domain.objects.TriageProtocolAssessment objects.
	 */
	public static ims.emergency.vo.TriageProtocolAssessmentVoCollection createTriageProtocolAssessmentVoCollectionFromTriageProtocolAssessment(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.TriageProtocolAssessmentVoCollection voList = new ims.emergency.vo.TriageProtocolAssessmentVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = (ims.emergency.domain.objects.TriageProtocolAssessment) domainObjectList.get(i);
			ims.emergency.vo.TriageProtocolAssessmentVo vo = create(map, domainObject);

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
	 public static java.util.Set extractTriageProtocolAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVoCollection voCollection) 
	 {
	 	return extractTriageProtocolAssessmentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTriageProtocolAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageProtocolAssessmentVo vo = voCollection.get(i);
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = TriageProtocolAssessmentVoAssembler.extractTriageProtocolAssessment(domainFactory, vo, domMap);

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
	 public static java.util.List extractTriageProtocolAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVoCollection voCollection) 
	 {
	 	return extractTriageProtocolAssessmentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTriageProtocolAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageProtocolAssessmentVo vo = voCollection.get(i);
			ims.emergency.domain.objects.TriageProtocolAssessment domainObject = TriageProtocolAssessmentVoAssembler.extractTriageProtocolAssessment(domainFactory, vo, domMap);

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
	 public static ims.emergency.vo.TriageProtocolAssessmentVo create(ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
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
	  public static ims.emergency.vo.TriageProtocolAssessmentVo create(DomainObjectMap map, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.TriageProtocolAssessmentVo valueObject = (ims.emergency.vo.TriageProtocolAssessmentVo) map.getValueObject(domainObject, ims.emergency.vo.TriageProtocolAssessmentVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.TriageProtocolAssessmentVo(domainObject.getId(), domainObject.getVersion());
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
	 public static ims.emergency.vo.TriageProtocolAssessmentVo insert(ims.emergency.vo.TriageProtocolAssessmentVo valueObject, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
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
	 public static ims.emergency.vo.TriageProtocolAssessmentVo insert(DomainObjectMap map, ims.emergency.vo.TriageProtocolAssessmentVo valueObject, ims.emergency.domain.objects.TriageProtocolAssessment domainObject) 
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
			
		// Patient
		if (domainObject.getPatient() != null)
		{
			if(domainObject.getPatient() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPatient();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(id, -1));				
			}
			else
			{
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(domainObject.getPatient().getId(), domainObject.getPatient().getVersion()));
			}
		}
		// Episode
		if (domainObject.getEpisode() != null)
		{
			if(domainObject.getEpisode() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getEpisode();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setEpisode(new ims.core.admin.vo.EpisodeOfCareRefVo(id, -1));				
			}
			else
			{
				valueObject.setEpisode(new ims.core.admin.vo.EpisodeOfCareRefVo(domainObject.getEpisode().getId(), domainObject.getEpisode().getVersion()));
			}
		}
		// Attendance
		if (domainObject.getAttendance() != null)
		{
			if(domainObject.getAttendance() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getAttendance();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setAttendance(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setAttendance(new ims.core.admin.vo.CareContextRefVo(domainObject.getAttendance().getId(), domainObject.getAttendance().getVersion()));
			}
		}
		// PatientProblem
		valueObject.setPatientProblem(ims.core.vo.domain.PatientProblemVoAssembler.create(map, domainObject.getPatientProblem()) );
		// isMain
		valueObject.setIsMain( domainObject.isIsMain() );
		// TriageProtocol
		if (domainObject.getTriageProtocol() != null)
		{
			if(domainObject.getTriageProtocol() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getTriageProtocol();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setTriageProtocol(new ims.emergency.configuration.vo.ManchesterTriageProtocolConfigurationRefVo(id, -1));				
			}
			else
			{
				valueObject.setTriageProtocol(new ims.emergency.configuration.vo.ManchesterTriageProtocolConfigurationRefVo(domainObject.getTriageProtocol().getId(), domainObject.getTriageProtocol().getVersion()));
			}
		}
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
		ims.domain.lookups.LookupInstance instance10 = domainObject.getTriagePriority();
		if ( null != instance10 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance10.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance10.getImage().getImageId(), instance10.getImage().getImagePath());
			}
			color = instance10.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.TriagePriority voLookup10 = new ims.emergency.vo.lookups.TriagePriority(instance10.getId(),instance10.getText(), instance10.isActive(), null, img, color);
			ims.emergency.vo.lookups.TriagePriority parentVoLookup10 = voLookup10;
			ims.domain.lookups.LookupInstance parent10 = instance10.getParent();
			while (parent10 != null)
			{
				if (parent10.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent10.getImage().getImageId(), parent10.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent10.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup10.setParent(new ims.emergency.vo.lookups.TriagePriority(parent10.getId(),parent10.getText(), parent10.isActive(), null, img, color));
				parentVoLookup10 = parentVoLookup10.getParent();
								parent10 = parent10.getParent();
			}			
			valueObject.setTriagePriority(voLookup10);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.domain.objects.TriageProtocolAssessment extractTriageProtocolAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVo valueObject) 
	{
		return 	extractTriageProtocolAssessment(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.domain.objects.TriageProtocolAssessment extractTriageProtocolAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageProtocolAssessmentVo valueObject, HashMap domMap) 
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
			// ims.emergency.vo.TriageProtocolAssessmentVo ID_TriageProtocolAssessment field is unknown
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

		ims.core.patient.domain.objects.Patient value1 = null;
		if ( null != valueObject.getPatient() ) 
		{
			if (valueObject.getPatient().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatient()) != null)
				{
					value1 = (ims.core.patient.domain.objects.Patient)domMap.get(valueObject.getPatient());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getPatient();	
			}
			else
			{
				value1 = (ims.core.patient.domain.objects.Patient)domainFactory.getDomainObject(ims.core.patient.domain.objects.Patient.class, valueObject.getPatient().getBoId());
			}
		}
		domainObject.setPatient(value1);
		ims.core.admin.domain.objects.EpisodeOfCare value2 = null;
		if ( null != valueObject.getEpisode() ) 
		{
			if (valueObject.getEpisode().getBoId() == null)
			{
				if (domMap.get(valueObject.getEpisode()) != null)
				{
					value2 = (ims.core.admin.domain.objects.EpisodeOfCare)domMap.get(valueObject.getEpisode());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getEpisode();	
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.EpisodeOfCare)domainFactory.getDomainObject(ims.core.admin.domain.objects.EpisodeOfCare.class, valueObject.getEpisode().getBoId());
			}
		}
		domainObject.setEpisode(value2);
		ims.core.admin.domain.objects.CareContext value3 = null;
		if ( null != valueObject.getAttendance() ) 
		{
			if (valueObject.getAttendance().getBoId() == null)
			{
				if (domMap.get(valueObject.getAttendance()) != null)
				{
					value3 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getAttendance());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getAttendance();	
			}
			else
			{
				value3 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getAttendance().getBoId());
			}
		}
		domainObject.setAttendance(value3);
		domainObject.setPatientProblem(ims.core.vo.domain.PatientProblemVoAssembler.extractPatientProblem(domainFactory, valueObject.getPatientProblem(), domMap));
		domainObject.setIsMain(valueObject.getIsMain());
		ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration value6 = null;
		if ( null != valueObject.getTriageProtocol() ) 
		{
			if (valueObject.getTriageProtocol().getBoId() == null)
			{
				if (domMap.get(valueObject.getTriageProtocol()) != null)
				{
					value6 = (ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration)domMap.get(valueObject.getTriageProtocol());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value6 = domainObject.getTriageProtocol();	
			}
			else
			{
				value6 = (ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration)domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.ManchesterTriageProtocolConfiguration.class, valueObject.getTriageProtocol().getBoId());
			}
		}
		domainObject.setTriageProtocol(value6);
		domainObject.setDiscriminator(ims.emergency.vo.domain.ProtocolDiscriminatorLiteVoAssembler.extractProtocolDiscriminator(domainFactory, valueObject.getDiscriminator(), domMap));
		ims.framework.utils.DateTime dateTime8 = valueObject.getAssessmentDateTime();
		java.util.Date value8 = null;
		if ( dateTime8 != null ) 
		{
			value8 = dateTime8.getJavaDate();
		}
		domainObject.setAssessmentDateTime(value8);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value9 = null;
		if ( null != valueObject.getAssessmentNurse() ) 
		{
			if (valueObject.getAssessmentNurse().getBoId() == null)
			{
				if (domMap.get(valueObject.getAssessmentNurse()) != null)
				{
					value9 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getAssessmentNurse());
				}
			}
			else
			{
				value9 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getAssessmentNurse().getBoId());
			}
		}
		domainObject.setAssessmentNurse(value9);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value10 = null;
		if ( null != valueObject.getTriagePriority() ) 
		{
			value10 =
				domainFactory.getLookupInstance(valueObject.getTriagePriority().getID());
		}
		domainObject.setTriagePriority(value10);

		return domainObject;
	}

}
