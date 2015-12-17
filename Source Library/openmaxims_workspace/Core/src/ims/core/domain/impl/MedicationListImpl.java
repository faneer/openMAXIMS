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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.20 build 40903.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;
import ims.admin.helper.Keywords;
import ims.core.clinical.domain.objects.Medication;
import ims.core.clinical.vo.MedicationRefVo;
import ims.core.vo.MedicationLiteVoCollection;
import ims.core.vo.domain.MedicationLiteVoAssembler;
import ims.core.vo.domain.MedicationVoAssembler;
import ims.core.vo.domain.TaxonomyMapAssembler;

import java.util.List;
import java.util.ArrayList;

public class MedicationListImpl extends DomainImpl implements ims.core.domain.MedicationList, ims.domain.impl.Transactional
{
	/**
	 * Save a Medication Vo
	 */
	public ims.core.vo.MedicationVo saveMedicationVo(ims.core.vo.MedicationVo voMedication) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException
	{
		if (!voMedication.isValidated())
		{
			throw new DomainRuntimeException("This MedicationVo has not been validated");
		}

		DomainFactory factory = getDomainFactory();

		voMedication.setMedicationName(voMedication.getMedicationName().trim());//wdev-1336

		// Bug Fix WDEV-1896 
		if (!voMedication.getID_MedicationIsNotNull())
		{
			List l = factory.find("from Medication m where upper(m.medicationName) = :medName", new String[]{"medName"}, new Object[]{voMedication.getMedicationName().toUpperCase()});
			if (l.size() > 0)
				throw new UniqueKeyViolationException("Medication record called \"" + voMedication.getMedicationName() + "\" already exists. Duplicates not allowed.");
		}

		Medication domMedication = MedicationVoAssembler.extractMedication(factory, voMedication);	
		
		domMedication.setKeywords(Keywords.setupKeyWords(domMedication.getKeywords(), domMedication.getMedicationName()));
	
		try
		{
			//WDEV-4212
			domMedication.getTaxonomyMap().clear();
			domMedication.setTaxonomyMap(TaxonomyMapAssembler.extractTaxonomyMapList(factory, voMedication.getTaxonomyMap()));

			factory.save(domMedication);
		}
		catch (UnqViolationUncheckedException e)
		{		
//			check which constraint was violated (name/taxononmy map)

			//name
			Medication med = Medication.getMedicationFromMedicationName(factory, voMedication.getMedicationName());
			if (med != null && med.getId() != null && !(med.getId().equals(voMedication.getID_Medication())))
			{
				throw new UniqueKeyViolationException("Medication record called \"" + voMedication.getMedicationName() + "\" already exists. Duplicates not allowed.", e);	
			}
			
			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domMedication, voMedication.getTaxonomyMap(), "getMedicationName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			throw (e);
		}

		return MedicationVoAssembler.create(domMedication);
	}

	public ims.core.vo.MedicationVo getMedicationVo(MedicationRefVo voMediactionRef)
	{
		DomainFactory factory = getDomainFactory();
		Medication med = (Medication) factory.getDomainObject(Medication.class, voMediactionRef.getID_Medication());
		return (MedicationVoAssembler.create(med));
	}
	
	public MedicationLiteVoCollection listMedicationIncludeInactive(String filter) throws DomainInterfaceException
	{
		return listMedications(filter, false);
	}

	public MedicationLiteVoCollection listActiveMedication(String filter) throws DomainInterfaceException
	{
		return listMedications(filter, true);
	}
	
	/**
	 * The filter is assumed to be one or more keywords seperated by some white space.
	 * Each keyword is used in a seperate query to get back Medications which have a keyword like it.
	 * Each subsequent keyword query narrows the original returned list so the eventual returned list
	 * only contains Medication which contain a match on all the keywords.
	 * It would be nice if this could be implemented as a single HQL query but I don't know how.
	 * @param filter
	 * @param activeOnly
	 * @return
	 * @throws DomainInterfaceException 
	 */
	private List listDomMedications(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Medication m join m.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (activeOnly)
		{
			hql.append(" where m.isActive = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}		
		return Keywords.searchByKeywords(factory, filter, hql.toString(), names, values);			
	}

	private MedicationLiteVoCollection listMedications(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		return MedicationLiteVoAssembler.createMedicationLiteVoCollectionFromMedication(listDomMedications(filter, activeOnly)).sort();		
	}

}
