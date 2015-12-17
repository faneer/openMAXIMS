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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.util.ArrayList;
import java.util.List;


import ims.clinical.configuration.domain.objects.ProcedureHotlistItem;
import ims.clinical.domain.base.impl.BasePlannedPerformedProcedureDialogImpl;
import ims.clinical.vo.domain.PatientProcedureForSurgicalAuditPreOpChecksVoAssembler;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.MedicVoCollection;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.lookups.Specialty;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class PlannedPerformedProcedureDialogImpl extends BasePlannedPerformedProcedureDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVoCollection getPatientProcedures(ims.core.vo.lookups.Specialty specialtyId)
	{
		if( specialtyId == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		List patprocs = factory.find("select p1_1	from PatientProcedure as p1_1 left join p1_1.specialty as l1_1	where (l1_1.id = :specialtyId)", new String[] {"specialtyId"}, new Object[] {getDomLookup(specialtyId).getId()});
		 
		 
		if( patprocs != null && patprocs.size() > 0)
			return PatientProcedureForSurgicalAuditPreOpChecksVoAssembler.createPatientProcedureForSurgicalAuditPreOpChecksVoCollectionFromPatientProcedure(patprocs);
		
	
		return null;
		
		//--------------------
		
		
		//--------------------
		
	}

	public ims.core.vo.EpisodeofCareLiteVo getEpisodeOfcare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public ims.core.vo.HcpLiteVoCollection getHcps()
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	
	public ProcedureLiteVoCollection getProcedures(Specialty specialtyId) 
	{
		
		
		if(specialtyId == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("select distinct procHotListItem from ProcedureHotlist as procHotList left join procHotList.hotlistItem as procHotListItem left join procHotListItem.procedure as proc left join proc.keywords as kw "); 
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where proc.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		if (specialtyId !=null)
		{
			hql.append(" and procHotList.specialty = :spec");
			names.add("spec");
			values.add(getDomLookup(specialtyId));			
		}
	
		List hits = factory.find(hql.toString(), names, values);		
		
		List ret = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			ret.add(((ProcedureHotlistItem)hits.get(i)).getProcedure());
		}
		
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(ret);
	}

	
	public MedicVo getMedicVo(HcpRefVo hcp) 
	{
		if( hcp == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		List medics = factory.find("select m1_1 from Medic as m1_1 left join m1_1.mos as m2_1 left join m2_1.hcp as h1_1 where 	(h1_1.id = :hcpId)", new String[] {"hcpId"}, new Object[] {hcp.getID_Hcp()});
		 
		 
		if( medics != null && medics.size() > 0)
		{
			MedicVoCollection tempColl = MedicVoAssembler.createMedicVoCollectionFromMedic(medics);
			if( tempColl != null && tempColl.size() > 0)
				return tempColl.get(0);
		}
			
		return null;
		
				
		
	}


	public HcpLiteVo getHcpLiteVo(HcpRefVo hcpRef) 
	{
		if( hcpRef == null )
			return null;
		
		return HcpLiteVoAssembler.create((Hcp)getDomainFactory().getDomainObject(Hcp.class,hcpRef.getID_Hcp()));
	}

	public HcpLiteVo getHcpLiteVo(MemberOfStaffRefVo mosRef)
	{
		if( mosRef == null || mosRef.getID_MemberOfStaff()==null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		List <?>hcp = factory.find("select mos.hcp from MemberOfStaff as mos where (mos.id = :mosId)", new String[] {"mosId"}, new Object[] {mosRef.getID_MemberOfStaff()});
		 
		 
		if( hcp != null && hcp.size() > 0)
		{
			return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(hcp).get(0);
		}
		
		return null;
	}

	//WDEV-15687
	public MedicLiteVo getMedicLiteVo(HcpRefVo hcp)
	{
		if( hcp == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		List medics = factory.find("select m1_1 from Medic as m1_1 left join m1_1.mos as m2_1 left join m2_1.hcp as h1_1 where 	(h1_1.id = :hcpId)", new String[] {"hcpId"}, new Object[] {hcp.getID_Hcp()});
		 
		 
		if( medics != null && medics.size() > 0)
		{
			MedicLiteVoCollection tempColl = MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(medics);
			if( tempColl != null && tempColl.size() > 0)
				return tempColl.get(0);
		}
			
		return null;
	}
}
