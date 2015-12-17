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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.42 build 2221.27776)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.clinical.domain.base.impl.BaseMDTListImpl;
import ims.clinical.domain.objects.MDTListandDates;
import ims.clinical.vo.MDTListAndDatesVo;
import ims.clinical.vo.MDTListAndDatesVoCollection;
import ims.clinical.vo.domain.MDTListAndDatesVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.domain.Demographics;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.ContextType;
import ims.domain.DomainFactory;

public class MDTListImpl extends BaseMDTListImpl
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2311212013216332219L;

	/**
	* A list of MDT appointments
	*/
	public ims.clinical.vo.MDTListAndDatesVoCollection listMDT(ims.clinical.vo.MDTListAndDatesVo voMDTList)
	{
		DomainFactory factory = getDomainFactory();
		List MDTList = factory.find(" from MDTListandDates mdtlist where mdtlist.careContext.endDateTime is null " +
				"and mdtlist.careContext.context = :context " + 
				"and mdtlist.listPatientisOn = :listPatient",
				new String[]{"context", "listPatient"},
				new Object[]{getDomLookup(voMDTList.getCareContext().getContext()), getDomLookup(voMDTList.getListPatientisOn())});

		MDTListAndDatesVoCollection voMDTNoContactColl = new MDTListAndDatesVoCollection();
		for (int x = 0; x < MDTList.size(); x++)
		{
			MDTListandDates domMDTListAndDates = (MDTListandDates) MDTList.get(x);

			MDTListAndDatesVo voMDTListAndDates = MDTListAndDatesVoAssembler.create(domMDTListAndDates);
			voMDTListAndDates.setPatient(PatientShortAssembler.create(domMDTListAndDates.getPatient()));

			Demographics impl = (Demographics) getDomainImpl(DemographicsImpl.class);
			voMDTListAndDates.getPatient().setHasAlerts(impl.hasAlerts(domMDTListAndDates.getPatient().getId()));
			voMDTListAndDates.getPatient().setHasAllergies(impl.hasAllergy(domMDTListAndDates.getPatient().getId()));

			voMDTNoContactColl.add(voMDTListAndDates);
		}

		return voMDTNoContactColl.sort();
	}

	/**
	* List of Clinical Contacts with no MDT list type
	*/
	public ims.clinical.vo.MDTListAndDatesVoCollection listCareContextsWithNoMDTList(ims.clinical.vo.MDTListAndDatesVo voMDTList)
	{
		DomainFactory factory = getDomainFactory();
		List contextList = factory.find(" from CareContext r where r.endDateTime is null and r.context = :context and r.id not in " + 
				"( select careContext.id from MDTListandDates)",
				new String[]{"context"},
				new Object[]{getDomLookup(ContextType.INPATIENT)});

		MDTListAndDatesVoCollection voMDTNoContactColl = new MDTListAndDatesVoCollection();
		for (int x = 0; x < contextList.size(); x++)
		{
			CareContext domCareContext = (CareContext) contextList.get(x);

			CareContextShortVo voCareContext = CareContextShortVoAssembler.create(domCareContext);
			
			Demographics impl = (Demographics) getDomainImpl(DemographicsImpl.class);
			
			MDTListAndDatesVo mdt = new MDTListAndDatesVo();
			mdt.setPatient(PatientShortAssembler.create(domCareContext.getEpisodeOfCare().getCareSpell().getPatient()));
			mdt.getPatient().setHasAlerts(impl.hasAlerts(mdt.getPatient().getID_Patient()));
			mdt.getPatient().setHasAllergies(impl.hasAllergy(mdt.getPatient().getID_Patient()));
			mdt.setCareContext(voCareContext);
			voMDTNoContactColl.add(mdt);
		}

		return voMDTNoContactColl.sort();
	}

}
