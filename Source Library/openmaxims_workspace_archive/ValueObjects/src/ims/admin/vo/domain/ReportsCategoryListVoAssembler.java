//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.admin.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Alexie Ursache
 */
public class ReportsCategoryListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.admin.vo.ReportsCategoryListVo copy(ims.admin.vo.ReportsCategoryListVo valueObjectDest, ims.admin.vo.ReportsCategoryListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReportsCategory(valueObjectSrc.getID_ReportsCategory());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Reports
		valueObjectDest.setReports(valueObjectSrc.getReports());
		// ParentCategory
		valueObjectDest.setParentCategory(valueObjectSrc.getParentCategory());
		// SubCategories
		valueObjectDest.setSubCategories(valueObjectSrc.getSubCategories());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReportsCategoryListVoCollectionFromReportsCategory(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.ReportsCategory objects.
	 */
	public static ims.admin.vo.ReportsCategoryListVoCollection createReportsCategoryListVoCollectionFromReportsCategory(java.util.Set domainObjectSet)	
	{
		return createReportsCategoryListVoCollectionFromReportsCategory(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.ReportsCategory objects.
	 */
	public static ims.admin.vo.ReportsCategoryListVoCollection createReportsCategoryListVoCollectionFromReportsCategory(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.admin.vo.ReportsCategoryListVoCollection voList = new ims.admin.vo.ReportsCategoryListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.domain.objects.ReportsCategory domainObject = (ims.core.admin.domain.objects.ReportsCategory) iterator.next();
			ims.admin.vo.ReportsCategoryListVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.admin.domain.objects.ReportsCategory objects.
	 */
	public static ims.admin.vo.ReportsCategoryListVoCollection createReportsCategoryListVoCollectionFromReportsCategory(java.util.List domainObjectList) 
	{
		return createReportsCategoryListVoCollectionFromReportsCategory(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.domain.objects.ReportsCategory objects.
	 */
	public static ims.admin.vo.ReportsCategoryListVoCollection createReportsCategoryListVoCollectionFromReportsCategory(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.admin.vo.ReportsCategoryListVoCollection voList = new ims.admin.vo.ReportsCategoryListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.domain.objects.ReportsCategory domainObject = (ims.core.admin.domain.objects.ReportsCategory) domainObjectList.get(i);
			ims.admin.vo.ReportsCategoryListVo vo = create(map, domainObject);

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
	 * Create the ims.core.admin.domain.objects.ReportsCategory set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReportsCategorySet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVoCollection voCollection) 
	 {
	 	return extractReportsCategorySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReportsCategorySet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.ReportsCategoryListVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.ReportsCategory domainObject = ReportsCategoryListVoAssembler.extractReportsCategory(domainFactory, vo, domMap);

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
	 * Create the ims.core.admin.domain.objects.ReportsCategory list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReportsCategoryList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVoCollection voCollection) 
	 {
	 	return extractReportsCategoryList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReportsCategoryList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.ReportsCategoryListVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.ReportsCategory domainObject = ReportsCategoryListVoAssembler.extractReportsCategory(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.admin.domain.objects.ReportsCategory object.
	 * @param domainObject ims.core.admin.domain.objects.ReportsCategory
	 */
	 public static ims.admin.vo.ReportsCategoryListVo create(ims.core.admin.domain.objects.ReportsCategory domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.domain.objects.ReportsCategory object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.admin.vo.ReportsCategoryListVo create(DomainObjectMap map, ims.core.admin.domain.objects.ReportsCategory domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.admin.vo.ReportsCategoryListVo valueObject = (ims.admin.vo.ReportsCategoryListVo) map.getValueObject(domainObject, ims.admin.vo.ReportsCategoryListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.admin.vo.ReportsCategoryListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.domain.objects.ReportsCategory
	 */
	 public static ims.admin.vo.ReportsCategoryListVo insert(ims.admin.vo.ReportsCategoryListVo valueObject, ims.core.admin.domain.objects.ReportsCategory domainObject) 
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
	 * @param domainObject ims.core.admin.domain.objects.ReportsCategory
	 */
	 public static ims.admin.vo.ReportsCategoryListVo insert(DomainObjectMap map, ims.admin.vo.ReportsCategoryListVo valueObject, ims.core.admin.domain.objects.ReportsCategory domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReportsCategory(domainObject.getId());
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
		// Reports
		ims.core.admin.vo.ReportBoRefVoCollection Reports = new ims.core.admin.vo.ReportBoRefVoCollection();
		for(java.util.Iterator iterator = domainObject.getReports().iterator(); iterator.hasNext(); ) 
		{
			ims.core.admin.domain.objects.ReportBo tmp = (ims.core.admin.domain.objects.ReportBo)iterator.next();
			if (tmp != null)
				Reports.add(new ims.core.admin.vo.ReportBoRefVo(tmp.getId(),tmp.getVersion()));
		}
		valueObject.setReports(Reports);
		// ParentCategory
		if (domainObject.getParentCategory() != null)
		{
			if(domainObject.getParentCategory() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getParentCategory();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setParentCategory(new ims.core.admin.vo.ReportsCategoryRefVo(id, -1));				
			}
			else
			{
				valueObject.setParentCategory(new ims.core.admin.vo.ReportsCategoryRefVo(domainObject.getParentCategory().getId(), domainObject.getParentCategory().getVersion()));
			}
		}
		// SubCategories
		valueObject.setSubCategories(ims.admin.vo.domain.ReportsCategoryListVoAssembler.createReportsCategoryListVoCollectionFromReportsCategory(map, domainObject.getSubCategories()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.domain.objects.ReportsCategory extractReportsCategory(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVo valueObject) 
	{
		return 	extractReportsCategory(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.domain.objects.ReportsCategory extractReportsCategory(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.ReportsCategoryListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReportsCategory();
		ims.core.admin.domain.objects.ReportsCategory domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.domain.objects.ReportsCategory)domMap.get(valueObject);
			}
			// ims.admin.vo.ReportsCategoryListVo ID_ReportsCategory field is unknown
			domainObject = new ims.core.admin.domain.objects.ReportsCategory();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReportsCategory());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.domain.objects.ReportsCategory)domMap.get(key);
			}
			domainObject = (ims.core.admin.domain.objects.ReportsCategory) domainFactory.getDomainObject(ims.core.admin.domain.objects.ReportsCategory.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReportsCategory());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());

		ims.core.admin.vo.ReportBoRefVoCollection refCollection2 = valueObject.getReports();
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.Set domainReports2 = domainObject.getReports();
		if (domainReports2 == null)
		{
			domainReports2 = new java.util.HashSet();
		}
		java.util.Set newSet2  = new java.util.HashSet();
		for(int i=0; i<size2; i++) 
		{
			ims.core.admin.vo.ReportBoRefVo vo = refCollection2.get(i);					
			ims.core.admin.domain.objects.ReportBo dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.core.admin.domain.objects.ReportBo)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.core.admin.domain.objects.ReportBo)domainFactory.getDomainObject( ims.core.admin.domain.objects.ReportBo.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainReports2.contains(dom))
			{
				domainReports2.add(dom);
			}
			newSet2.add(dom);			
		}
		java.util.Set removedSet2 = new java.util.HashSet();
		java.util.Iterator iter2 = domainReports2.iterator();
		//Find out which objects need to be removed
		while (iter2.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter2.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet2.contains(o))
			{
				removedSet2.add(o);
			}
		}
		iter2 = removedSet2.iterator();
		//Remove the unwanted objects
		while (iter2.hasNext())
		{
			domainReports2.remove(iter2.next());
		}		
		
		domainObject.setReports(domainReports2);		
		ims.core.admin.domain.objects.ReportsCategory value3 = null;
		if ( null != valueObject.getParentCategory() ) 
		{
			if (valueObject.getParentCategory().getBoId() == null)
			{
				if (domMap.get(valueObject.getParentCategory()) != null)
				{
					value3 = (ims.core.admin.domain.objects.ReportsCategory)domMap.get(valueObject.getParentCategory());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getParentCategory();	
			}
			else
			{
				value3 = (ims.core.admin.domain.objects.ReportsCategory)domainFactory.getDomainObject(ims.core.admin.domain.objects.ReportsCategory.class, valueObject.getParentCategory().getBoId());
			}
		}
		domainObject.setParentCategory(value3);
		domainObject.setSubCategories(ims.admin.vo.domain.ReportsCategoryListVoAssembler.extractReportsCategorySet(domainFactory, valueObject.getSubCategories(), domainObject.getSubCategories(), domMap));		

		return domainObject;
	}

}
