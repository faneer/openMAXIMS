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
package ims.oncology.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class PatTreatmentPlanRadiotherapyDialogVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo copy(ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObjectDest, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatTreatmentPlan(valueObjectSrc.getID_PatTreatmentPlan());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// DecisionToTreat
		valueObjectDest.setDecisionToTreat(valueObjectSrc.getDecisionToTreat());
		// Actions
		valueObjectDest.setActions(valueObjectSrc.getActions());
		// TreatmentSites
		valueObjectDest.setTreatmentSites(valueObjectSrc.getTreatmentSites());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.oncology.domain.objects.PatTreatmentPlan objects.
	 */
	public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(java.util.Set domainObjectSet)	
	{
		return createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.oncology.domain.objects.PatTreatmentPlan objects.
	 */
	public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voList = new ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.oncology.domain.objects.PatTreatmentPlan domainObject = (ims.oncology.domain.objects.PatTreatmentPlan) iterator.next();
			ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.oncology.domain.objects.PatTreatmentPlan objects.
	 */
	public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(java.util.List domainObjectList) 
	{
		return createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.oncology.domain.objects.PatTreatmentPlan objects.
	 */
	public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection createPatTreatmentPlanRadiotherapyDialogVoCollectionFromPatTreatmentPlan(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voList = new ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.oncology.domain.objects.PatTreatmentPlan domainObject = (ims.oncology.domain.objects.PatTreatmentPlan) domainObjectList.get(i);
			ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo vo = create(map, domainObject);

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
	 * Create the ims.oncology.domain.objects.PatTreatmentPlan set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatTreatmentPlanSet(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voCollection) 
	 {
	 	return extractPatTreatmentPlanSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatTreatmentPlanSet(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo vo = voCollection.get(i);
			ims.oncology.domain.objects.PatTreatmentPlan domainObject = PatTreatmentPlanRadiotherapyDialogVoAssembler.extractPatTreatmentPlan(domainFactory, vo, domMap);

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
	 * Create the ims.oncology.domain.objects.PatTreatmentPlan list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatTreatmentPlanList(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voCollection) 
	 {
	 	return extractPatTreatmentPlanList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatTreatmentPlanList(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo vo = voCollection.get(i);
			ims.oncology.domain.objects.PatTreatmentPlan domainObject = PatTreatmentPlanRadiotherapyDialogVoAssembler.extractPatTreatmentPlan(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.oncology.domain.objects.PatTreatmentPlan object.
	 * @param domainObject ims.oncology.domain.objects.PatTreatmentPlan
	 */
	 public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo create(ims.oncology.domain.objects.PatTreatmentPlan domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.oncology.domain.objects.PatTreatmentPlan object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo create(DomainObjectMap map, ims.oncology.domain.objects.PatTreatmentPlan domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObject = (ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo) map.getValueObject(domainObject, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.oncology.domain.objects.PatTreatmentPlan
	 */
	 public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo insert(ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObject, ims.oncology.domain.objects.PatTreatmentPlan domainObject) 
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
	 * @param domainObject ims.oncology.domain.objects.PatTreatmentPlan
	 */
	 public static ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo insert(DomainObjectMap map, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObject, ims.oncology.domain.objects.PatTreatmentPlan domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatTreatmentPlan(domainObject.getId());
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
			
		// DecisionToTreat
		java.util.Date DecisionToTreat = domainObject.getDecisionToTreat();
		if ( null != DecisionToTreat ) 
		{
			valueObject.setDecisionToTreat(new ims.framework.utils.Date(DecisionToTreat) );
		}
		// Actions
		valueObject.setActions(ims.ccosched.vo.domain.PatTreatPlanActionLiteVoAssembler.createPatTreatPlanActionLiteVoCollectionFromPatAction(map, domainObject.getActions()) );
		// TreatmentSites
		java.util.List listTreatmentSites = domainObject.getTreatmentSites();
		ims.oncology.vo.lookups.TreatmentGroupSiteCollection TreatmentSites = new ims.oncology.vo.lookups.TreatmentGroupSiteCollection();
		for(java.util.Iterator iterator = listTreatmentSites.iterator(); iterator.hasNext(); ) 
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
			ims.oncology.vo.lookups.TreatmentGroupSite voInstance = new ims.oncology.vo.lookups.TreatmentGroupSite(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.oncology.vo.lookups.TreatmentGroupSite parentVoInstance = voInstance;
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
								parentVoInstance.setParent(new ims.oncology.vo.lookups.TreatmentGroupSite(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			TreatmentSites.add(voInstance);
		}
		valueObject.setTreatmentSites( TreatmentSites );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.oncology.domain.objects.PatTreatmentPlan extractPatTreatmentPlan(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObject) 
	{
		return 	extractPatTreatmentPlan(domainFactory, valueObject, new HashMap());
	}

	public static ims.oncology.domain.objects.PatTreatmentPlan extractPatTreatmentPlan(ims.domain.ILightweightDomainFactory domainFactory, ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatTreatmentPlan();
		ims.oncology.domain.objects.PatTreatmentPlan domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.oncology.domain.objects.PatTreatmentPlan)domMap.get(valueObject);
			}
			// ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVo ID_PatTreatmentPlan field is unknown
			domainObject = new ims.oncology.domain.objects.PatTreatmentPlan();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatTreatmentPlan());
			if (domMap.get(key) != null)
			{
				return (ims.oncology.domain.objects.PatTreatmentPlan)domMap.get(key);
			}
			domainObject = (ims.oncology.domain.objects.PatTreatmentPlan) domainFactory.getDomainObject(ims.oncology.domain.objects.PatTreatmentPlan.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatTreatmentPlan());

		java.util.Date value1 = null;
		ims.framework.utils.Date date1 = valueObject.getDecisionToTreat();		
		if ( date1 != null ) 
		{
			value1 = date1.getDate();
		}
		domainObject.setDecisionToTreat(value1);

		// SaveAsRefVO treated as RefValueObject
		ims.oncology.vo.PatActionRefVoCollection refCollection2 = new ims.oncology.vo.PatActionRefVoCollection();
		if (valueObject.getActions() != null)
		{
			for (int i2=0; i2<valueObject.getActions().size(); i2++)
			{
				ims.oncology.vo.PatActionRefVo ref2 = (ims.oncology.vo.PatActionRefVo)valueObject.getActions().get(i2);
				refCollection2.add(ref2);
			}
		}
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.Set domainActions2 = domainObject.getActions();
		if (domainActions2 == null)
		{
			domainActions2 = new java.util.HashSet();
		}
		java.util.Set newSet2  = new java.util.HashSet();
		for(int i=0; i<size2; i++) 
		{
			ims.oncology.vo.PatActionRefVo vo = refCollection2.get(i);					
			ims.oncology.domain.objects.PatAction dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.oncology.domain.objects.PatAction)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.oncology.domain.objects.PatAction)domainFactory.getDomainObject( ims.oncology.domain.objects.PatAction.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainActions2.contains(dom))
			{
				domainActions2.add(dom);
			}
			newSet2.add(dom);			
		}
		java.util.Set removedSet2 = new java.util.HashSet();
		java.util.Iterator iter2 = domainActions2.iterator();
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
			domainActions2.remove(iter2.next());
		}		
		
		domainObject.setActions(domainActions2);		
		ims.oncology.vo.lookups.TreatmentGroupSiteCollection collection3 =
	valueObject.getTreatmentSites();
	    java.util.List domainTreatmentSites = domainObject.getTreatmentSites();;			
	    int collection3Size=0;
		if (collection3 == null)
		{
			domainTreatmentSites = new java.util.ArrayList(0);
		}
		else
		{
			collection3Size = collection3.size();
		}
		
		for(int i=0; i<collection3Size; i++) 
		{
			int instanceId = collection3.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainTreatmentSites.indexOf(dom);
			if (domIdx == -1)
			{
				domainTreatmentSites.add(i, dom);
			}
			else if (i != domIdx && i < domainTreatmentSites.size())
			{
				Object tmp = domainTreatmentSites.get(i);
				domainTreatmentSites.set(i, domainTreatmentSites.get(domIdx));
				domainTreatmentSites.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j3 = domainTreatmentSites.size();
		while (j3 > collection3Size)
		{
			domainTreatmentSites.remove(j3-1);
			j3 = domainTreatmentSites.size();
		}

		domainObject.setTreatmentSites(domainTreatmentSites);		

		return domainObject;
	}

}
