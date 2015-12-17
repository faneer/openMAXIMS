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
package ims.nursing.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Sinead McDermott
 */
public class SkinAssessmentReviewAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.nursing.vo.SkinAssessmentReview copy(ims.nursing.vo.SkinAssessmentReview valueObjectDest, ims.nursing.vo.SkinAssessmentReview valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SkinAssessmentReview(valueObjectSrc.getID_SkinAssessmentReview());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// DateTimeReview
		valueObjectDest.setDateTimeReview(valueObjectSrc.getDateTimeReview());
		// HCPReview
		valueObjectDest.setHCPReview(valueObjectSrc.getHCPReview());
		// SiteDetails
		valueObjectDest.setSiteDetails(valueObjectSrc.getSiteDetails());
		// HowLongIsItPresent
		valueObjectDest.setHowLongIsItPresent(valueObjectSrc.getHowLongIsItPresent());
		// PressureSoreGrade
		valueObjectDest.setPressureSoreGrade(valueObjectSrc.getPressureSoreGrade());
		// Length
		valueObjectDest.setLength(valueObjectSrc.getLength());
		// Width
		valueObjectDest.setWidth(valueObjectSrc.getWidth());
		// Depth
		valueObjectDest.setDepth(valueObjectSrc.getDepth());
		// WoundBed
		valueObjectDest.setWoundBed(valueObjectSrc.getWoundBed());
		// SurroundingSkin
		valueObjectDest.setSurroundingSkin(valueObjectSrc.getSurroundingSkin());
		// ExudateAmount
		valueObjectDest.setExudateAmount(valueObjectSrc.getExudateAmount());
		// ExudateType
		valueObjectDest.setExudateType(valueObjectSrc.getExudateType());
		// Odour
		valueObjectDest.setOdour(valueObjectSrc.getOdour());
		// Pain
		valueObjectDest.setPain(valueObjectSrc.getPain());
		// InfectionSuspected
		valueObjectDest.setInfectionSuspected(valueObjectSrc.getInfectionSuspected());
		// SwabTaken
		valueObjectDest.setSwabTaken(valueObjectSrc.getSwabTaken());
		// WoundTraced
		valueObjectDest.setWoundTraced(valueObjectSrc.getWoundTraced());
		// CleansedWith
		valueObjectDest.setCleansedWith(valueObjectSrc.getCleansedWith());
		// PrimaryDressing
		valueObjectDest.setPrimaryDressing(valueObjectSrc.getPrimaryDressing());
		// SecondaryDressing
		valueObjectDest.setSecondaryDressing(valueObjectSrc.getSecondaryDressing());
		// FrequencyOfChange
		valueObjectDest.setFrequencyOfChange(valueObjectSrc.getFrequencyOfChange());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSkinAssessmentReviewCollectionFromSkinAssessmentReview(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview objects.
	 */
	public static ims.nursing.vo.SkinAssessmentReviewCollection createSkinAssessmentReviewCollectionFromSkinAssessmentReview(java.util.Set domainObjectSet)	
	{
		return createSkinAssessmentReviewCollectionFromSkinAssessmentReview(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview objects.
	 */
	public static ims.nursing.vo.SkinAssessmentReviewCollection createSkinAssessmentReviewCollectionFromSkinAssessmentReview(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.nursing.vo.SkinAssessmentReviewCollection voList = new ims.nursing.vo.SkinAssessmentReviewCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject = (ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview) iterator.next();
			ims.nursing.vo.SkinAssessmentReview vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview objects.
	 */
	public static ims.nursing.vo.SkinAssessmentReviewCollection createSkinAssessmentReviewCollectionFromSkinAssessmentReview(java.util.List domainObjectList) 
	{
		return createSkinAssessmentReviewCollectionFromSkinAssessmentReview(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview objects.
	 */
	public static ims.nursing.vo.SkinAssessmentReviewCollection createSkinAssessmentReviewCollectionFromSkinAssessmentReview(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.nursing.vo.SkinAssessmentReviewCollection voList = new ims.nursing.vo.SkinAssessmentReviewCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject = (ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview) domainObjectList.get(i);
			ims.nursing.vo.SkinAssessmentReview vo = create(map, domainObject);

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
	 * Create the ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSkinAssessmentReviewSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReviewCollection voCollection) 
	 {
	 	return extractSkinAssessmentReviewSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSkinAssessmentReviewSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReviewCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.SkinAssessmentReview vo = voCollection.get(i);
			ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject = SkinAssessmentReviewAssembler.extractSkinAssessmentReview(domainFactory, vo, domMap);

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
	 * Create the ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSkinAssessmentReviewList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReviewCollection voCollection) 
	 {
	 	return extractSkinAssessmentReviewList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSkinAssessmentReviewList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReviewCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.SkinAssessmentReview vo = voCollection.get(i);
			ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject = SkinAssessmentReviewAssembler.extractSkinAssessmentReview(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview object.
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview
	 */
	 public static ims.nursing.vo.SkinAssessmentReview create(ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.nursing.vo.SkinAssessmentReview create(DomainObjectMap map, ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.nursing.vo.SkinAssessmentReview valueObject = (ims.nursing.vo.SkinAssessmentReview) map.getValueObject(domainObject, ims.nursing.vo.SkinAssessmentReview.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.nursing.vo.SkinAssessmentReview(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview
	 */
	 public static ims.nursing.vo.SkinAssessmentReview insert(ims.nursing.vo.SkinAssessmentReview valueObject, ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject) 
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
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview
	 */
	 public static ims.nursing.vo.SkinAssessmentReview insert(DomainObjectMap map, ims.nursing.vo.SkinAssessmentReview valueObject, ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SkinAssessmentReview(domainObject.getId());
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
			
		// DateTimeReview
		java.util.Date DateTimeReview = domainObject.getDateTimeReview();
		if ( null != DateTimeReview ) 
		{
			valueObject.setDateTimeReview(new ims.framework.utils.DateTime(DateTimeReview) );
		}
		// HCPReview
		valueObject.setHCPReview(ims.core.vo.domain.HcpAssembler.create(map, domainObject.getHCPReview()) );
		// SiteDetails
		valueObject.setSiteDetails(domainObject.getSiteDetails());
		// HowLongIsItPresent
		valueObject.setHowLongIsItPresent(domainObject.getHowLongIsItPresent());
		// PressureSoreGrade
		ims.domain.lookups.LookupInstance instance5 = domainObject.getPressureSoreGrade();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinPressureSoreGrade voLookup5 = new ims.nursing.vo.lookups.SkinPressureSoreGrade(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinPressureSoreGrade parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.nursing.vo.lookups.SkinPressureSoreGrade(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setPressureSoreGrade(voLookup5);
		}
				// Length
		valueObject.setLength(domainObject.getLength());
		// Width
		valueObject.setWidth(domainObject.getWidth());
		// Depth
		valueObject.setDepth(domainObject.getDepth());
		// WoundBed
		ims.domain.lookups.LookupInstance instance9 = domainObject.getWoundBed();
		if ( null != instance9 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance9.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance9.getImage().getImageId(), instance9.getImage().getImagePath());
			}
			color = instance9.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinWoundBed voLookup9 = new ims.nursing.vo.lookups.SkinWoundBed(instance9.getId(),instance9.getText(), instance9.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinWoundBed parentVoLookup9 = voLookup9;
			ims.domain.lookups.LookupInstance parent9 = instance9.getParent();
			while (parent9 != null)
			{
				if (parent9.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent9.getImage().getImageId(), parent9.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent9.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup9.setParent(new ims.nursing.vo.lookups.SkinWoundBed(parent9.getId(),parent9.getText(), parent9.isActive(), null, img, color));
				parentVoLookup9 = parentVoLookup9.getParent();
								parent9 = parent9.getParent();
			}			
			valueObject.setWoundBed(voLookup9);
		}
				// SurroundingSkin
		ims.domain.lookups.LookupInstance instance10 = domainObject.getSurroundingSkin();
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

			ims.nursing.vo.lookups.SkinSurroundingSkin voLookup10 = new ims.nursing.vo.lookups.SkinSurroundingSkin(instance10.getId(),instance10.getText(), instance10.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinSurroundingSkin parentVoLookup10 = voLookup10;
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
								parentVoLookup10.setParent(new ims.nursing.vo.lookups.SkinSurroundingSkin(parent10.getId(),parent10.getText(), parent10.isActive(), null, img, color));
				parentVoLookup10 = parentVoLookup10.getParent();
								parent10 = parent10.getParent();
			}			
			valueObject.setSurroundingSkin(voLookup10);
		}
				// ExudateAmount
		ims.domain.lookups.LookupInstance instance11 = domainObject.getExudateAmount();
		if ( null != instance11 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance11.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance11.getImage().getImageId(), instance11.getImage().getImagePath());
			}
			color = instance11.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinExudateAmount voLookup11 = new ims.nursing.vo.lookups.SkinExudateAmount(instance11.getId(),instance11.getText(), instance11.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinExudateAmount parentVoLookup11 = voLookup11;
			ims.domain.lookups.LookupInstance parent11 = instance11.getParent();
			while (parent11 != null)
			{
				if (parent11.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent11.getImage().getImageId(), parent11.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent11.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup11.setParent(new ims.nursing.vo.lookups.SkinExudateAmount(parent11.getId(),parent11.getText(), parent11.isActive(), null, img, color));
				parentVoLookup11 = parentVoLookup11.getParent();
								parent11 = parent11.getParent();
			}			
			valueObject.setExudateAmount(voLookup11);
		}
				// ExudateType
		ims.domain.lookups.LookupInstance instance12 = domainObject.getExudateType();
		if ( null != instance12 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance12.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance12.getImage().getImageId(), instance12.getImage().getImagePath());
			}
			color = instance12.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinExudateType voLookup12 = new ims.nursing.vo.lookups.SkinExudateType(instance12.getId(),instance12.getText(), instance12.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinExudateType parentVoLookup12 = voLookup12;
			ims.domain.lookups.LookupInstance parent12 = instance12.getParent();
			while (parent12 != null)
			{
				if (parent12.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent12.getImage().getImageId(), parent12.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent12.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup12.setParent(new ims.nursing.vo.lookups.SkinExudateType(parent12.getId(),parent12.getText(), parent12.isActive(), null, img, color));
				parentVoLookup12 = parentVoLookup12.getParent();
								parent12 = parent12.getParent();
			}			
			valueObject.setExudateType(voLookup12);
		}
				// Odour
		ims.domain.lookups.LookupInstance instance13 = domainObject.getOdour();
		if ( null != instance13 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance13.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance13.getImage().getImageId(), instance13.getImage().getImagePath());
			}
			color = instance13.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinOdour voLookup13 = new ims.nursing.vo.lookups.SkinOdour(instance13.getId(),instance13.getText(), instance13.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinOdour parentVoLookup13 = voLookup13;
			ims.domain.lookups.LookupInstance parent13 = instance13.getParent();
			while (parent13 != null)
			{
				if (parent13.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent13.getImage().getImageId(), parent13.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent13.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup13.setParent(new ims.nursing.vo.lookups.SkinOdour(parent13.getId(),parent13.getText(), parent13.isActive(), null, img, color));
				parentVoLookup13 = parentVoLookup13.getParent();
								parent13 = parent13.getParent();
			}			
			valueObject.setOdour(voLookup13);
		}
				// Pain
		ims.domain.lookups.LookupInstance instance14 = domainObject.getPain();
		if ( null != instance14 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance14.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance14.getImage().getImageId(), instance14.getImage().getImagePath());
			}
			color = instance14.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinPain voLookup14 = new ims.nursing.vo.lookups.SkinPain(instance14.getId(),instance14.getText(), instance14.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinPain parentVoLookup14 = voLookup14;
			ims.domain.lookups.LookupInstance parent14 = instance14.getParent();
			while (parent14 != null)
			{
				if (parent14.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent14.getImage().getImageId(), parent14.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent14.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup14.setParent(new ims.nursing.vo.lookups.SkinPain(parent14.getId(),parent14.getText(), parent14.isActive(), null, img, color));
				parentVoLookup14 = parentVoLookup14.getParent();
								parent14 = parent14.getParent();
			}			
			valueObject.setPain(voLookup14);
		}
				// InfectionSuspected
		valueObject.setInfectionSuspected( domainObject.isInfectionSuspected() );
		// SwabTaken
		valueObject.setSwabTaken( domainObject.isSwabTaken() );
		// WoundTraced
		valueObject.setWoundTraced( domainObject.isWoundTraced() );
		// CleansedWith
		ims.domain.lookups.LookupInstance instance18 = domainObject.getCleansedWith();
		if ( null != instance18 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance18.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance18.getImage().getImageId(), instance18.getImage().getImagePath());
			}
			color = instance18.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinCleansedWith voLookup18 = new ims.nursing.vo.lookups.SkinCleansedWith(instance18.getId(),instance18.getText(), instance18.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinCleansedWith parentVoLookup18 = voLookup18;
			ims.domain.lookups.LookupInstance parent18 = instance18.getParent();
			while (parent18 != null)
			{
				if (parent18.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent18.getImage().getImageId(), parent18.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent18.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup18.setParent(new ims.nursing.vo.lookups.SkinCleansedWith(parent18.getId(),parent18.getText(), parent18.isActive(), null, img, color));
				parentVoLookup18 = parentVoLookup18.getParent();
								parent18 = parent18.getParent();
			}			
			valueObject.setCleansedWith(voLookup18);
		}
				// PrimaryDressing
		ims.domain.lookups.LookupInstance instance19 = domainObject.getPrimaryDressing();
		if ( null != instance19 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance19.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance19.getImage().getImageId(), instance19.getImage().getImagePath());
			}
			color = instance19.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinPrimaryDressing voLookup19 = new ims.nursing.vo.lookups.SkinPrimaryDressing(instance19.getId(),instance19.getText(), instance19.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinPrimaryDressing parentVoLookup19 = voLookup19;
			ims.domain.lookups.LookupInstance parent19 = instance19.getParent();
			while (parent19 != null)
			{
				if (parent19.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent19.getImage().getImageId(), parent19.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent19.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup19.setParent(new ims.nursing.vo.lookups.SkinPrimaryDressing(parent19.getId(),parent19.getText(), parent19.isActive(), null, img, color));
				parentVoLookup19 = parentVoLookup19.getParent();
								parent19 = parent19.getParent();
			}			
			valueObject.setPrimaryDressing(voLookup19);
		}
				// SecondaryDressing
		ims.domain.lookups.LookupInstance instance20 = domainObject.getSecondaryDressing();
		if ( null != instance20 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance20.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance20.getImage().getImageId(), instance20.getImage().getImagePath());
			}
			color = instance20.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinSecondaryDressing voLookup20 = new ims.nursing.vo.lookups.SkinSecondaryDressing(instance20.getId(),instance20.getText(), instance20.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinSecondaryDressing parentVoLookup20 = voLookup20;
			ims.domain.lookups.LookupInstance parent20 = instance20.getParent();
			while (parent20 != null)
			{
				if (parent20.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent20.getImage().getImageId(), parent20.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent20.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup20.setParent(new ims.nursing.vo.lookups.SkinSecondaryDressing(parent20.getId(),parent20.getText(), parent20.isActive(), null, img, color));
				parentVoLookup20 = parentVoLookup20.getParent();
								parent20 = parent20.getParent();
			}			
			valueObject.setSecondaryDressing(voLookup20);
		}
				// FrequencyOfChange
		ims.domain.lookups.LookupInstance instance21 = domainObject.getFrequencyOfChange();
		if ( null != instance21 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance21.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance21.getImage().getImageId(), instance21.getImage().getImagePath());
			}
			color = instance21.getColor();
			if (color != null) 
				color.getValue();

			ims.nursing.vo.lookups.SkinFrequencyOfChange voLookup21 = new ims.nursing.vo.lookups.SkinFrequencyOfChange(instance21.getId(),instance21.getText(), instance21.isActive(), null, img, color);
			ims.nursing.vo.lookups.SkinFrequencyOfChange parentVoLookup21 = voLookup21;
			ims.domain.lookups.LookupInstance parent21 = instance21.getParent();
			while (parent21 != null)
			{
				if (parent21.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent21.getImage().getImageId(), parent21.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent21.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup21.setParent(new ims.nursing.vo.lookups.SkinFrequencyOfChange(parent21.getId(),parent21.getText(), parent21.isActive(), null, img, color));
				parentVoLookup21 = parentVoLookup21.getParent();
								parent21 = parent21.getParent();
			}			
			valueObject.setFrequencyOfChange(voLookup21);
		}
				// Comment
		valueObject.setComment(domainObject.getComment());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview extractSkinAssessmentReview(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReview valueObject) 
	{
		return 	extractSkinAssessmentReview(domainFactory, valueObject, new HashMap());
	}

	public static ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview extractSkinAssessmentReview(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.SkinAssessmentReview valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SkinAssessmentReview();
		ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview)domMap.get(valueObject);
			}
			// ims.nursing.vo.SkinAssessmentReview ID_SkinAssessmentReview field is unknown
			domainObject = new ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SkinAssessmentReview());
			if (domMap.get(key) != null)
			{
				return (ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview)domMap.get(key);
			}
			domainObject = (ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview) domainFactory.getDomainObject(ims.nursing.assessmenttools.domain.objects.SkinAssessmentReview.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SkinAssessmentReview());

		ims.framework.utils.DateTime dateTime1 = valueObject.getDateTimeReview();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setDateTimeReview(value1);
		domainObject.setHCPReview(ims.core.vo.domain.HcpAssembler.extractHcp(domainFactory, valueObject.getHCPReview(), domMap));
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSiteDetails() != null && valueObject.getSiteDetails().equals(""))
		{
			valueObject.setSiteDetails(null);
		}
		domainObject.setSiteDetails(valueObject.getSiteDetails());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHowLongIsItPresent() != null && valueObject.getHowLongIsItPresent().equals(""))
		{
			valueObject.setHowLongIsItPresent(null);
		}
		domainObject.setHowLongIsItPresent(valueObject.getHowLongIsItPresent());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getPressureSoreGrade() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getPressureSoreGrade().getID());
		}
		domainObject.setPressureSoreGrade(value5);
		domainObject.setLength(valueObject.getLength());
		domainObject.setWidth(valueObject.getWidth());
		domainObject.setDepth(valueObject.getDepth());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value9 = null;
		if ( null != valueObject.getWoundBed() ) 
		{
			value9 =
				domainFactory.getLookupInstance(valueObject.getWoundBed().getID());
		}
		domainObject.setWoundBed(value9);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value10 = null;
		if ( null != valueObject.getSurroundingSkin() ) 
		{
			value10 =
				domainFactory.getLookupInstance(valueObject.getSurroundingSkin().getID());
		}
		domainObject.setSurroundingSkin(value10);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value11 = null;
		if ( null != valueObject.getExudateAmount() ) 
		{
			value11 =
				domainFactory.getLookupInstance(valueObject.getExudateAmount().getID());
		}
		domainObject.setExudateAmount(value11);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value12 = null;
		if ( null != valueObject.getExudateType() ) 
		{
			value12 =
				domainFactory.getLookupInstance(valueObject.getExudateType().getID());
		}
		domainObject.setExudateType(value12);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value13 = null;
		if ( null != valueObject.getOdour() ) 
		{
			value13 =
				domainFactory.getLookupInstance(valueObject.getOdour().getID());
		}
		domainObject.setOdour(value13);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value14 = null;
		if ( null != valueObject.getPain() ) 
		{
			value14 =
				domainFactory.getLookupInstance(valueObject.getPain().getID());
		}
		domainObject.setPain(value14);
		domainObject.setInfectionSuspected(valueObject.getInfectionSuspected());
		domainObject.setSwabTaken(valueObject.getSwabTaken());
		domainObject.setWoundTraced(valueObject.getWoundTraced());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value18 = null;
		if ( null != valueObject.getCleansedWith() ) 
		{
			value18 =
				domainFactory.getLookupInstance(valueObject.getCleansedWith().getID());
		}
		domainObject.setCleansedWith(value18);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value19 = null;
		if ( null != valueObject.getPrimaryDressing() ) 
		{
			value19 =
				domainFactory.getLookupInstance(valueObject.getPrimaryDressing().getID());
		}
		domainObject.setPrimaryDressing(value19);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value20 = null;
		if ( null != valueObject.getSecondaryDressing() ) 
		{
			value20 =
				domainFactory.getLookupInstance(valueObject.getSecondaryDressing().getID());
		}
		domainObject.setSecondaryDressing(value20);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value21 = null;
		if ( null != valueObject.getFrequencyOfChange() ) 
		{
			value21 =
				domainFactory.getLookupInstance(valueObject.getFrequencyOfChange().getID());
		}
		domainObject.setFrequencyOfChange(value21);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());

		return domainObject;
	}

}
