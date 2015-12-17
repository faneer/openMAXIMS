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
 * @author Cristian Belciug
 */
public class OutpatientPreAssessmentVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.OutpatientPreAssessmentVo copy(ims.RefMan.vo.OutpatientPreAssessmentVo valueObjectDest, ims.RefMan.vo.OutpatientPreAssessmentVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_OutpatientPreAssessment(valueObjectSrc.getID_OutpatientPreAssessment());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// SuitableForSurgeryAssessment
		valueObjectDest.setSuitableForSurgeryAssessment(valueObjectSrc.getSuitableForSurgeryAssessment());
		// FitForSurgeryAssesment
		valueObjectDest.setFitForSurgeryAssesment(valueObjectSrc.getFitForSurgeryAssesment());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.OutpatientPreAssessment objects.
	 */
	public static ims.RefMan.vo.OutpatientPreAssessmentVoCollection createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(java.util.Set domainObjectSet)	
	{
		return createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.OutpatientPreAssessment objects.
	 */
	public static ims.RefMan.vo.OutpatientPreAssessmentVoCollection createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.OutpatientPreAssessmentVoCollection voList = new ims.RefMan.vo.OutpatientPreAssessmentVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.OutpatientPreAssessment domainObject = (ims.RefMan.domain.objects.OutpatientPreAssessment) iterator.next();
			ims.RefMan.vo.OutpatientPreAssessmentVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.OutpatientPreAssessment objects.
	 */
	public static ims.RefMan.vo.OutpatientPreAssessmentVoCollection createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(java.util.List domainObjectList) 
	{
		return createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.OutpatientPreAssessment objects.
	 */
	public static ims.RefMan.vo.OutpatientPreAssessmentVoCollection createOutpatientPreAssessmentVoCollectionFromOutpatientPreAssessment(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.OutpatientPreAssessmentVoCollection voList = new ims.RefMan.vo.OutpatientPreAssessmentVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.OutpatientPreAssessment domainObject = (ims.RefMan.domain.objects.OutpatientPreAssessment) domainObjectList.get(i);
			ims.RefMan.vo.OutpatientPreAssessmentVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.OutpatientPreAssessment set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOutpatientPreAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVoCollection voCollection) 
	 {
	 	return extractOutpatientPreAssessmentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOutpatientPreAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.OutpatientPreAssessmentVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.OutpatientPreAssessment domainObject = OutpatientPreAssessmentVoAssembler.extractOutpatientPreAssessment(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.OutpatientPreAssessment list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOutpatientPreAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVoCollection voCollection) 
	 {
	 	return extractOutpatientPreAssessmentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOutpatientPreAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.OutpatientPreAssessmentVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.OutpatientPreAssessment domainObject = OutpatientPreAssessmentVoAssembler.extractOutpatientPreAssessment(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.OutpatientPreAssessment object.
	 * @param domainObject ims.RefMan.domain.objects.OutpatientPreAssessment
	 */
	 public static ims.RefMan.vo.OutpatientPreAssessmentVo create(ims.RefMan.domain.objects.OutpatientPreAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.OutpatientPreAssessment object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.OutpatientPreAssessmentVo create(DomainObjectMap map, ims.RefMan.domain.objects.OutpatientPreAssessment domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.OutpatientPreAssessmentVo valueObject = (ims.RefMan.vo.OutpatientPreAssessmentVo) map.getValueObject(domainObject, ims.RefMan.vo.OutpatientPreAssessmentVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.OutpatientPreAssessmentVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.OutpatientPreAssessment
	 */
	 public static ims.RefMan.vo.OutpatientPreAssessmentVo insert(ims.RefMan.vo.OutpatientPreAssessmentVo valueObject, ims.RefMan.domain.objects.OutpatientPreAssessment domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.OutpatientPreAssessment
	 */
	 public static ims.RefMan.vo.OutpatientPreAssessmentVo insert(DomainObjectMap map, ims.RefMan.vo.OutpatientPreAssessmentVo valueObject, ims.RefMan.domain.objects.OutpatientPreAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_OutpatientPreAssessment(domainObject.getId());
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
			
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
		// SuitableForSurgeryAssessment
		if (domainObject.getSuitableForSurgeryAssessment() != null)
		{
			if(domainObject.getSuitableForSurgeryAssessment() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getSuitableForSurgeryAssessment();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setSuitableForSurgeryAssessment(new ims.RefMan.vo.SuitableForSurgeryAssessmentRefVo(id, -1));				
			}
			else
			{
				valueObject.setSuitableForSurgeryAssessment(new ims.RefMan.vo.SuitableForSurgeryAssessmentRefVo(domainObject.getSuitableForSurgeryAssessment().getId(), domainObject.getSuitableForSurgeryAssessment().getVersion()));
			}
		}
		// FitForSurgeryAssesment
		if (domainObject.getFitForSurgeryAssesment() != null)
		{
			if(domainObject.getFitForSurgeryAssesment() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getFitForSurgeryAssesment();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setFitForSurgeryAssesment(new ims.RefMan.vo.FitForSurgeryAssesmentRefVo(id, -1));				
			}
			else
			{
				valueObject.setFitForSurgeryAssesment(new ims.RefMan.vo.FitForSurgeryAssesmentRefVo(domainObject.getFitForSurgeryAssesment().getId(), domainObject.getFitForSurgeryAssesment().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.OutpatientPreAssessment extractOutpatientPreAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVo valueObject) 
	{
		return 	extractOutpatientPreAssessment(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.OutpatientPreAssessment extractOutpatientPreAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.OutpatientPreAssessmentVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_OutpatientPreAssessment();
		ims.RefMan.domain.objects.OutpatientPreAssessment domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.OutpatientPreAssessment)domMap.get(valueObject);
			}
			// ims.RefMan.vo.OutpatientPreAssessmentVo ID_OutpatientPreAssessment field is unknown
			domainObject = new ims.RefMan.domain.objects.OutpatientPreAssessment();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_OutpatientPreAssessment());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.OutpatientPreAssessment)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.OutpatientPreAssessment) domainFactory.getDomainObject(ims.RefMan.domain.objects.OutpatientPreAssessment.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_OutpatientPreAssessment());

		ims.core.admin.domain.objects.CareContext value1 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value1 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getCareContext();	
			}
			else
			{
				value1 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value1);
		ims.RefMan.domain.objects.SuitableForSurgeryAssessment value2 = null;
		if ( null != valueObject.getSuitableForSurgeryAssessment() ) 
		{
			if (valueObject.getSuitableForSurgeryAssessment().getBoId() == null)
			{
				if (domMap.get(valueObject.getSuitableForSurgeryAssessment()) != null)
				{
					value2 = (ims.RefMan.domain.objects.SuitableForSurgeryAssessment)domMap.get(valueObject.getSuitableForSurgeryAssessment());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getSuitableForSurgeryAssessment();	
			}
			else
			{
				value2 = (ims.RefMan.domain.objects.SuitableForSurgeryAssessment)domainFactory.getDomainObject(ims.RefMan.domain.objects.SuitableForSurgeryAssessment.class, valueObject.getSuitableForSurgeryAssessment().getBoId());
			}
		}
		domainObject.setSuitableForSurgeryAssessment(value2);
		ims.RefMan.domain.objects.FitForSurgeryAssesment value3 = null;
		if ( null != valueObject.getFitForSurgeryAssesment() ) 
		{
			if (valueObject.getFitForSurgeryAssesment().getBoId() == null)
			{
				if (domMap.get(valueObject.getFitForSurgeryAssesment()) != null)
				{
					value3 = (ims.RefMan.domain.objects.FitForSurgeryAssesment)domMap.get(valueObject.getFitForSurgeryAssesment());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getFitForSurgeryAssesment();	
			}
			else
			{
				value3 = (ims.RefMan.domain.objects.FitForSurgeryAssesment)domainFactory.getDomainObject(ims.RefMan.domain.objects.FitForSurgeryAssesment.class, valueObject.getFitForSurgeryAssesment().getBoId());
			}
		}
		domainObject.setFitForSurgeryAssesment(value3);

		return domainObject;
	}

}
