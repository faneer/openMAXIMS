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
 * @author Catalin Tomozei
 */
public class CorrespondenceNoteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.CorrespondenceNoteVo copy(ims.RefMan.vo.CorrespondenceNoteVo valueObjectDest, ims.RefMan.vo.CorrespondenceNoteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReportNote(valueObjectSrc.getID_ReportNote());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// NoteType
		valueObjectDest.setNoteType(valueObjectSrc.getNoteType());
		// ReportNote
		valueObjectDest.setReportNote(valueObjectSrc.getReportNote());
		// NoteStatus
		valueObjectDest.setNoteStatus(valueObjectSrc.getNoteStatus());
		// copyToGP
		valueObjectDest.setCopyToGP(valueObjectSrc.getCopyToGP());
		// copyToPatient
		valueObjectDest.setCopyToPatient(valueObjectSrc.getCopyToPatient());
		// copyToSecondaryCare
		valueObjectDest.setCopyToSecondaryCare(valueObjectSrc.getCopyToSecondaryCare());
		// CatsReferral
		valueObjectDest.setCatsReferral(valueObjectSrc.getCatsReferral());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// RecordingInformation
		valueObjectDest.setRecordingInformation(valueObjectSrc.getRecordingInformation());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createCorrespondenceNoteVoCollectionFromReportNote(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ReportNote objects.
	 */
	public static ims.RefMan.vo.CorrespondenceNoteVoCollection createCorrespondenceNoteVoCollectionFromReportNote(java.util.Set domainObjectSet)	
	{
		return createCorrespondenceNoteVoCollectionFromReportNote(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ReportNote objects.
	 */
	public static ims.RefMan.vo.CorrespondenceNoteVoCollection createCorrespondenceNoteVoCollectionFromReportNote(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.CorrespondenceNoteVoCollection voList = new ims.RefMan.vo.CorrespondenceNoteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.ReportNote domainObject = (ims.RefMan.domain.objects.ReportNote) iterator.next();
			ims.RefMan.vo.CorrespondenceNoteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ReportNote objects.
	 */
	public static ims.RefMan.vo.CorrespondenceNoteVoCollection createCorrespondenceNoteVoCollectionFromReportNote(java.util.List domainObjectList) 
	{
		return createCorrespondenceNoteVoCollectionFromReportNote(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ReportNote objects.
	 */
	public static ims.RefMan.vo.CorrespondenceNoteVoCollection createCorrespondenceNoteVoCollectionFromReportNote(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.CorrespondenceNoteVoCollection voList = new ims.RefMan.vo.CorrespondenceNoteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.ReportNote domainObject = (ims.RefMan.domain.objects.ReportNote) domainObjectList.get(i);
			ims.RefMan.vo.CorrespondenceNoteVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.ReportNote set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReportNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVoCollection voCollection) 
	 {
	 	return extractReportNoteSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReportNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CorrespondenceNoteVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ReportNote domainObject = CorrespondenceNoteVoAssembler.extractReportNote(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.ReportNote list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReportNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVoCollection voCollection) 
	 {
	 	return extractReportNoteList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReportNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CorrespondenceNoteVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ReportNote domainObject = CorrespondenceNoteVoAssembler.extractReportNote(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.ReportNote object.
	 * @param domainObject ims.RefMan.domain.objects.ReportNote
	 */
	 public static ims.RefMan.vo.CorrespondenceNoteVo create(ims.RefMan.domain.objects.ReportNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.ReportNote object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.CorrespondenceNoteVo create(DomainObjectMap map, ims.RefMan.domain.objects.ReportNote domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.CorrespondenceNoteVo valueObject = (ims.RefMan.vo.CorrespondenceNoteVo) map.getValueObject(domainObject, ims.RefMan.vo.CorrespondenceNoteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.CorrespondenceNoteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ReportNote
	 */
	 public static ims.RefMan.vo.CorrespondenceNoteVo insert(ims.RefMan.vo.CorrespondenceNoteVo valueObject, ims.RefMan.domain.objects.ReportNote domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.ReportNote
	 */
	 public static ims.RefMan.vo.CorrespondenceNoteVo insert(DomainObjectMap map, ims.RefMan.vo.CorrespondenceNoteVo valueObject, ims.RefMan.domain.objects.ReportNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReportNote(domainObject.getId());
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
			
		// NoteType
		ims.domain.lookups.LookupInstance instance1 = domainObject.getNoteType();
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

			ims.RefMan.vo.lookups.ReportNoteType voLookup1 = new ims.RefMan.vo.lookups.ReportNoteType(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.RefMan.vo.lookups.ReportNoteType parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.RefMan.vo.lookups.ReportNoteType(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setNoteType(voLookup1);
		}
				// ReportNote
		valueObject.setReportNote(domainObject.getReportNote());
		// NoteStatus
		ims.domain.lookups.LookupInstance instance3 = domainObject.getNoteStatus();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.RefMan.vo.lookups.ReportNoteStatus voLookup3 = new ims.RefMan.vo.lookups.ReportNoteStatus(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.RefMan.vo.lookups.ReportNoteStatus parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.RefMan.vo.lookups.ReportNoteStatus(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setNoteStatus(voLookup3);
		}
				// copyToGP
		valueObject.setCopyToGP( domainObject.isCopyToGP() );
		// copyToPatient
		valueObject.setCopyToPatient( domainObject.isCopyToPatient() );
		// copyToSecondaryCare
		valueObject.setCopyToSecondaryCare( domainObject.isCopyToSecondaryCare() );
		// CatsReferral
		if (domainObject.getCatsReferral() != null)
		{
			if(domainObject.getCatsReferral() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCatsReferral();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCatsReferral(new ims.RefMan.vo.CatsReferralRefVo(id, -1));				
			}
			else
			{
				valueObject.setCatsReferral(new ims.RefMan.vo.CatsReferralRefVo(domainObject.getCatsReferral().getId(), domainObject.getCatsReferral().getVersion()));
			}
		}
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
		// RecordingInformation
		valueObject.setRecordingInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getRecordingInformation()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.ReportNote extractReportNote(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVo valueObject) 
	{
		return 	extractReportNote(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.ReportNote extractReportNote(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CorrespondenceNoteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReportNote();
		ims.RefMan.domain.objects.ReportNote domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.ReportNote)domMap.get(valueObject);
			}
			// ims.RefMan.vo.CorrespondenceNoteVo ID_ReportNote field is unknown
			domainObject = new ims.RefMan.domain.objects.ReportNote();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReportNote());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.ReportNote)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.ReportNote) domainFactory.getDomainObject(ims.RefMan.domain.objects.ReportNote.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReportNote());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getNoteType() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getNoteType().getID());
		}
		domainObject.setNoteType(value1);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getReportNote() != null && valueObject.getReportNote().equals(""))
		{
			valueObject.setReportNote(null);
		}
		domainObject.setReportNote(valueObject.getReportNote());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getNoteStatus() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getNoteStatus().getID());
		}
		domainObject.setNoteStatus(value3);
		domainObject.setCopyToGP(valueObject.getCopyToGP());
		domainObject.setCopyToPatient(valueObject.getCopyToPatient());
		domainObject.setCopyToSecondaryCare(valueObject.getCopyToSecondaryCare());
		ims.RefMan.domain.objects.CatsReferral value7 = null;
		if ( null != valueObject.getCatsReferral() ) 
		{
			if (valueObject.getCatsReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCatsReferral()) != null)
				{
					value7 = (ims.RefMan.domain.objects.CatsReferral)domMap.get(valueObject.getCatsReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value7 = domainObject.getCatsReferral();	
			}
			else
			{
				value7 = (ims.RefMan.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.RefMan.domain.objects.CatsReferral.class, valueObject.getCatsReferral().getBoId());
			}
		}
		domainObject.setCatsReferral(value7);
		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
		domainObject.setRecordingInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getRecordingInformation(), domMap));

		return domainObject;
	}

}
