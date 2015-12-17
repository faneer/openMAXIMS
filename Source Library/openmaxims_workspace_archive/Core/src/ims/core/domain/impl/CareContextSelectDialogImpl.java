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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.62 build 3040.26452)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.List;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.base.impl.BaseCareContextSelectDialogImpl;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocSiteRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.LocSiteLiteMappingsVo;
import ims.core.vo.LocSiteLiteMappingsVoCollection;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PasEventVo;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.domain.LocSiteLiteVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PasEventVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;

public class CareContextSelectDialogImpl extends BaseCareContextSelectDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.CareSpellVoCollection listCareSpellsByPatient(ims.core.patient.vo.PatientRefVo patientRefVo, Date careContextDate)
	{
		if(patientRefVo == null || patientRefVo.getID_Patient() == null)
			throw new CodingRuntimeException("Patient not provided");
	
		DomainFactory factory = getDomainFactory();
		List<?> careSpells = null;
		
		if(careContextDate != null)
			careSpells = factory.find("select careSpell from CareSpell as careSpell left join careSpell.episodes as epis left join epis.careContexts as cc where (cc.startDateTime >= :ccStartDate and careSpell.patient.id = :idPatient)", new String[] {"ccStartDate","idPatient"}, new Object[] { careContextDate.getDate(), patientRefVo.getID_Patient()});
		else
			careSpells = factory.find("from CareSpell as careSpell where careSpell.patient.id = :idPatient", new String[] {"idPatient"}, new Object[] { patientRefVo.getID_Patient()});
		
		if (careSpells != null && careSpells.size() > 0)
			return CareSpellVoAssembler.createCareSpellVoCollectionFromCareSpell(careSpells).sort(SortOrder.DESCENDING);
		
		return null;
	}

	public LocSiteLiteMappingsVoCollection listLocSites()
	{
		String locationName="%";
		String location = locationName != null ? locationName.toUpperCase() + "%" : "%%";
		StringBuffer hql = new StringBuffer();
		hql.append("select ls, t.taxonomyCode");
		hql.append(" from LocSite as ls");
		hql.append(" left join ls.codeMappings as t left join t.taxonomyName as tn where tn =:taxonomyType");
		hql.append(" and");
		hql.append(" ls.upperName like :locationName");
		hql.append(" and ls.isActive =:active");
		hql.append(" and ls.type !=:SurgeryType");
		hql.append(" and ls.isRIE is null");
		hql.append(" and ls.isVirtual =:virtual");//wdev-2730
		

		LocSiteLiteMappingsVoCollection locSitesWithMappings = new LocSiteLiteMappingsVoCollection();
		List list = getDomainFactory().find(hql.toString(), new String[]{"locationName", "active", "SurgeryType","virtual","taxonomyType"}, new Object[]{location, Boolean.TRUE, getDomLookup(LocationType.SURGERY),Boolean.FALSE,getDomLookup(TaxonomyType.PATH)});
		for (Object obj : list)
		{
			Object[]array = (Object[]) obj;
			LocSiteLiteVo lslVo = LocSiteLiteVoAssembler.create((LocSite)array[0]);
			LocSiteLiteMappingsVo llm= new LocSiteLiteMappingsVo();
			llm.setProviderHospital(lslVo);
			llm.setPathMapping((String)array[1]);
			locSitesWithMappings.add(llm);
		}
		return locSitesWithMappings.sort();
	}

	public CareContextVo updateCareContextwithOrderingHospital(CareContextRefVo careContext, LocSiteRefVo locSite) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		CareContext domCareContext = (CareContext) factory.getDomainObject(careContext);
		LocSite domOrderingHosp = (LocSite)factory.getDomainObject(locSite);
		domCareContext.setOrderingHospital(domOrderingHosp);
		factory.save(domCareContext);
		return CareContextVoAssembler.create(domCareContext);
	}

	//WDEV-11840
	public LocationLiteVoCollection listWardsForCurrentHospital(LocationRefVo currentWard) 
	{
		if(currentWard == null || !currentWard.getID_LocationIsNotNull())
			throw new CodingRuntimeException("Can not list Wards for a null Location Id");
		
		Location hospital = getHospitalByWard(currentWard);
		
		if(hospital == null)
			return null;
		
		LocationRefVo hospitalRef = LocationLiteVoAssembler.create(hospital);
		
		OrganisationAndLocation organisatonImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		
		return organisatonImpl.listActiveWardsForHospitalLite(hospitalRef);
	}

	//WDEV-11840
	private Location getHospitalByWard(LocationRefVo currentWard) 
	{
		DomainFactory factory = getDomainFactory();
		Location location = (Location)factory.getDomainObject(currentWard);
		
		if (location == null)
			return null;

		while (location!=null && (location.isIsActive() && location.getType()!=null && !location.getType().equals(getDomLookup(LocationType.HOSP))))
		{
			location = location.getParentLocation();
		}
		
		if(location != null)
			return location;
		
		return null;
	}

	//WDEV-11840
	public PasEventVo updatePasEventWithNewWard(PasEventVo pasEvent) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		if(pasEvent == null)
			throw new CodingRuntimeException("Can not save a null PasEventVo.");
		
		if(!pasEvent.isValidated())
			throw new CodingRuntimeException("PasEventVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PASEvent doPasEvent = PasEventVoAssembler.extractPASEvent(factory, pasEvent);
		
		factory.save(doPasEvent);
		
		return PasEventVoAssembler.create(doPasEvent);
	}
}
