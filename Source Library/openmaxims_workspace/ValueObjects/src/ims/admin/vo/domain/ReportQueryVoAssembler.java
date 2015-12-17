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
package ims.admin.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Vasile Purdila
 */
public class ReportQueryVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.admin.vo.ReportQueryVo copy(ims.admin.vo.ReportQueryVo valueObjectDest, ims.admin.vo.ReportQueryVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReportQuery(valueObjectSrc.getID_ReportQuery());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
		// QueryXML
		valueObjectDest.setQueryXML(valueObjectSrc.getQueryXML());
		// seeds
		valueObjectDest.setSeeds(valueObjectSrc.getSeeds());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReportQueryVoCollectionFromReportQuery(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.ReportQuery objects.
	 */
	public static ims.admin.vo.ReportQueryVoCollection createReportQueryVoCollectionFromReportQuery(java.util.Set domainObjectSet)	
	{
		return createReportQueryVoCollectionFromReportQuery(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.ReportQuery objects.
	 */
	public static ims.admin.vo.ReportQueryVoCollection createReportQueryVoCollectionFromReportQuery(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.admin.vo.ReportQueryVoCollection voList = new ims.admin.vo.ReportQueryVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.domain.objects.ReportQuery domainObject = (ims.core.admin.domain.objects.ReportQuery) iterator.next();
			ims.admin.vo.ReportQueryVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.admin.domain.objects.ReportQuery objects.
	 */
	public static ims.admin.vo.ReportQueryVoCollection createReportQueryVoCollectionFromReportQuery(java.util.List domainObjectList) 
	{
		return createReportQueryVoCollectionFromReportQuery(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.domain.objects.ReportQuery objects.
	 */
	public static ims.admin.vo.ReportQueryVoCollection createReportQueryVoCollectionFromReportQuery(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.admin.vo.ReportQueryVoCollection voList = new ims.admin.vo.ReportQueryVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.domain.objects.ReportQuery domainObject = (ims.core.admin.domain.objects.ReportQuery) domainObjectList.get(i);
			ims.admin.vo.ReportQueryVo vo = create(map, domainObject);

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
	 * Create the ims.core.admin.domain.objects.ReportQuery set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReportQuerySet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVoCollection voCollection) 
	 {
	 	return extractReportQuerySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReportQuerySet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.ReportQueryVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.ReportQuery domainObject = ReportQueryVoAssembler.extractReportQuery(domainFactory, vo, domMap);

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
	 * Create the ims.core.admin.domain.objects.ReportQuery list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReportQueryList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVoCollection voCollection) 
	 {
	 	return extractReportQueryList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReportQueryList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.ReportQueryVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.ReportQuery domainObject = ReportQueryVoAssembler.extractReportQuery(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.admin.domain.objects.ReportQuery object.
	 * @param domainObject ims.core.admin.domain.objects.ReportQuery
	 */
	 public static ims.admin.vo.ReportQueryVo create(ims.core.admin.domain.objects.ReportQuery domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.domain.objects.ReportQuery object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.admin.vo.ReportQueryVo create(DomainObjectMap map, ims.core.admin.domain.objects.ReportQuery domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.admin.vo.ReportQueryVo valueObject = (ims.admin.vo.ReportQueryVo) map.getValueObject(domainObject, ims.admin.vo.ReportQueryVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.admin.vo.ReportQueryVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.domain.objects.ReportQuery
	 */
	 public static ims.admin.vo.ReportQueryVo insert(ims.admin.vo.ReportQueryVo valueObject, ims.core.admin.domain.objects.ReportQuery domainObject) 
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
	 * @param domainObject ims.core.admin.domain.objects.ReportQuery
	 */
	 public static ims.admin.vo.ReportQueryVo insert(DomainObjectMap map, ims.admin.vo.ReportQueryVo valueObject, ims.core.admin.domain.objects.ReportQuery domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReportQuery(domainObject.getId());
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
			
		// Name
		valueObject.setName(domainObject.getName());
		// Description
		valueObject.setDescription(domainObject.getDescription());
		// QueryXML
		valueObject.setQueryXML(domainObject.getQueryXML());
		// seeds
		ims.core.admin.vo.ReportSeedBoRefVoCollection seeds = new ims.core.admin.vo.ReportSeedBoRefVoCollection();
		for(java.util.Iterator iterator = domainObject.getSeeds().iterator(); iterator.hasNext(); ) 
		{
			ims.core.admin.domain.objects.ReportSeedBo tmp = (ims.core.admin.domain.objects.ReportSeedBo)iterator.next();
			if (tmp != null)
				seeds.add(new ims.core.admin.vo.ReportSeedBoRefVo(tmp.getId(),tmp.getVersion()));
		}
		valueObject.setSeeds(seeds);
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.domain.objects.ReportQuery extractReportQuery(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVo valueObject) 
	{
		return 	extractReportQuery(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.domain.objects.ReportQuery extractReportQuery(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportQueryVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReportQuery();
		ims.core.admin.domain.objects.ReportQuery domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.domain.objects.ReportQuery)domMap.get(valueObject);
			}
			// ims.admin.vo.ReportQueryVo ID_ReportQuery field is unknown
			domainObject = new ims.core.admin.domain.objects.ReportQuery();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReportQuery());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.domain.objects.ReportQuery)domMap.get(key);
			}
			domainObject = (ims.core.admin.domain.objects.ReportQuery) domainFactory.getDomainObject(ims.core.admin.domain.objects.ReportQuery.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReportQuery());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getQueryXML() != null && valueObject.getQueryXML().equals(""))
		{
			valueObject.setQueryXML(null);
		}
		domainObject.setQueryXML(valueObject.getQueryXML());

		ims.core.admin.vo.ReportSeedBoRefVoCollection refCollection4 = valueObject.getSeeds();
		int size4 = (null == refCollection4) ? 0 : refCollection4.size();		
		java.util.Set domainSeeds4 = domainObject.getSeeds();
		if (domainSeeds4 == null)
		{
			domainSeeds4 = new java.util.HashSet();
		}
		java.util.Set newSet4  = new java.util.HashSet();
		for(int i=0; i<size4; i++) 
		{
			ims.core.admin.vo.ReportSeedBoRefVo vo = refCollection4.get(i);					
			ims.core.admin.domain.objects.ReportSeedBo dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.core.admin.domain.objects.ReportSeedBo)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.core.admin.domain.objects.ReportSeedBo)domainFactory.getDomainObject( ims.core.admin.domain.objects.ReportSeedBo.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainSeeds4.contains(dom))
			{
				domainSeeds4.add(dom);
			}
			newSet4.add(dom);			
		}
		java.util.Set removedSet4 = new java.util.HashSet();
		java.util.Iterator iter4 = domainSeeds4.iterator();
		//Find out which objects need to be removed
		while (iter4.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter4.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet4.contains(o))
			{
				removedSet4.add(o);
			}
		}
		iter4 = removedSet4.iterator();
		//Remove the unwanted objects
		while (iter4.hasNext())
		{
			domainSeeds4.remove(iter4.next());
		}		
		
		domainObject.setSeeds(domainSeeds4);		

		return domainObject;
	}

}
