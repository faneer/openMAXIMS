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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.45 build 2287.24499)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseMedicationMultipleDosesImpl;
import ims.clinical.domain.objects.MedicationOverview;
import ims.clinical.vo.MedicationOverViewFilterVo;
import ims.clinical.vo.MedicationOverViewLiteVoCollection;
import ims.clinical.vo.MedicationOverViewVo;
import ims.clinical.vo.MedicationOverViewVoCollection;
import ims.clinical.vo.MedicationOverviewRefVo;
import ims.clinical.vo.domain.MedicationOverViewLiteVoAssembler;
import ims.clinical.vo.domain.MedicationOverViewVoAssembler;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientMedicationVoCollection;
import ims.core.vo.domain.PatientMedicationVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

public class MedicationDosesImpl extends BaseMedicationMultipleDosesImpl
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(filter);
	}

	public void markAsRIE(ims.core.vo.PatientMedicationVo medication, ims.core.vo.ClinicalContactShortVo clinicalContactShortVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException
	{
		// TODO Add your code here.
	}

	public MedicationOverViewVo saveMedicationOverviewVo(MedicationOverViewVo voMedicationOverviewVo, PatientRefVo patientRefVo) throws StaleObjectException 
	{
		if(voMedicationOverviewVo == null)
			throw new CodingRuntimeException("Cannot save null value for MedicationOverViewVo");
		
		if (!voMedicationOverviewVo.isValidated())
			throw new CodingRuntimeException("Medication Overview has not been validated");

		DomainFactory factory = getDomainFactory();
		if (voMedicationOverviewVo.getID_MedicationOverview() == null)//Inserting a record
		{
			String hql = " from MedicationOverview mv where mv.careContext.id = :contextid and mv.type = :typeId"; 
			List overs = factory.find(hql, new String[]{"contextid", "typeId"}, new Object[]{voMedicationOverviewVo.getCareContext().getID_CareContext(), getDomLookup(voMedicationOverviewVo.getType())});
			if(overs.size() != 0)
				throw new StaleObjectException(null, "A Medication OverView record already exists for this Care Context and Overview Type, the screen will be refreshed.");
		}
			
		MedicationOverview domMed = MedicationOverViewVoAssembler.extractMedicationOverview(factory, voMedicationOverviewVo);
		factory.save(domMed);		 
		return MedicationOverViewVoAssembler.create(domMed);
	}

	public MedicationOverViewVo getLatestMedicationOverViewVo(MedicationOverViewFilterVo overviewVo) 
	{
		if (overviewVo == null)
			throw new DomainRuntimeException("Invalid Overview");
		
		DomainFactory factory = getDomainFactory();
		

		String hql = " from MedicationOverview mv where mv.careContext.id = :contextid and mv.type = :typeId"; 
		List overs = factory.find(hql, new String[]{"contextid", "typeId"}, new Object[]{overviewVo.getCareContext().getID_CareContext(), getDomLookup(overviewVo.getType())});
		if(overs.size() == 0)
		{	//Get Latest for Patient
			hql = " from MedicationOverview mv where mv.careContext.episodeOfCare.careSpell.patient.id = :patid order by mv.authoringInformation.authoringDateTime desc"; 
			overs = factory.find(hql, new String[]{"patid"}, new Object[]{overviewVo.getPatientRef().getID_Patient()});
			if(overs.size() == 0)
				return null;
			
			MedicationOverViewVoCollection coll = MedicationOverViewVoAssembler.createMedicationOverViewVoCollectionFromMedicationOverview(overs);
			coll.sort(SortOrder.DESCENDING);
			return coll.get(0);
		}
		else
		{
			MedicationOverViewVoCollection coll = MedicationOverViewVoAssembler.createMedicationOverViewVoCollectionFromMedicationOverview(overs);
			coll.sort(SortOrder.DESCENDING);
			return coll.get(0);
		}

	}

	public MedicationOverViewLiteVoCollection listMedicationOverviews(MedicationOverViewFilterVo voMedicationViewFilter) 
	{
		if (voMedicationViewFilter == null)
			throw new DomainRuntimeException("Invalid Overview");
		
		DomainFactory factory = getDomainFactory();

		String hql = " from MedicationOverview mv where mv.careContext.episodeOfCare.careSpell.patient.id = :patid order by mv.authoringInformation.authoringDateTime desc"; 
		List overs = factory.find(hql, new String[]{"patid"}, new Object[]{voMedicationViewFilter.getPatientRef().getID_Patient()});
		if(overs.size() == 0)
			return null;
			
		return MedicationOverViewLiteVoAssembler.createMedicationOverViewLiteVoCollectionFromMedicationOverview(overs);

	}

	public MedicationOverViewVo getMedicationOverView(MedicationOverviewRefVo voRefMedication) 
	{
		if(voRefMedication == null)
			throw new DomainRuntimeException("Invalid Medication record to get");
		
		return MedicationOverViewVoAssembler.create((MedicationOverview)getDomainFactory().getDomainObject(MedicationOverview.class, voRefMedication.getID_MedicationOverview()));
	}

	
	public PatientMedicationVoCollection listMedications(MedicationOverviewRefVo medOverview) {
		if (medOverview==null)
		{
			throw new DomainRuntimeException("Invalid Medication Overview");
		}
		String hql = "from PatientMedication as p1_1 where (p1_1.id in (select p1_1.id  from MedicationOverview as m1_1 left join m1_1.medication as p1_1  where   (m1_1.id = :MedicationOverview_id)))";
		return PatientMedicationVoAssembler.createPatientMedicationVoCollectionFromPatientMedication(getDomainFactory().find(hql, new String[]{"MedicationOverview_id"}, new Object[]{medOverview.getID_MedicationOverview()}));
	}

}
