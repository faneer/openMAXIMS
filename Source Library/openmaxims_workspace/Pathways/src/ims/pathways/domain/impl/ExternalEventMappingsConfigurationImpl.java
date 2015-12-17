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
	// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.60 build 2833.15418)
	// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.
	
	package ims.pathways.domain.impl;
	
	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;
	import ims.core.admin.domain.objects.ProviderSystem;
	import ims.core.resource.people.domain.objects.Medic;
	import ims.core.vo.MedicLiteVoCollection;
	import ims.core.vo.PersonName;
	import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
	import ims.domain.DomainFactory;
	import ims.domain.exceptions.DomainRuntimeException;
	import ims.domain.exceptions.ForeignKeyViolationException;
	import ims.domain.exceptions.StaleObjectException;
	import ims.domain.lookups.impl.LookupServiceImpl;
	import ims.framework.exceptions.CodingRuntimeException;
	import ims.ocrr.vo.ProviderSystemVoCollection;
	import ims.ocrr.vo.domain.ProviderSystemVoAssembler;
	import ims.pathways.configuration.domain.objects.ExternalEventMapping;
	import ims.pathways.configuration.vo.ExternalEventMappingRefVo;
	import ims.pathways.domain.base.impl.BaseExternalEventMappingsConfigurationImpl;
	import ims.pathways.vo.ExternalEventMappingVo;
	import ims.pathways.vo.ExternalEventMappingVoCollection;
import ims.pathways.vo.domain.ExternalEventMappingVoAssembler;
	
	public class ExternalEventMappingsConfigurationImpl extends BaseExternalEventMappingsConfigurationImpl
	{
		private static final long serialVersionUID = 1L;
	
		public ProviderSystemVoCollection listProviderSystems() 
		{
			DomainFactory factory = getDomainFactory();
			return ProviderSystemVoAssembler.createProviderSystemVoCollectionFromProviderSystem(factory.listDomainObjects(ProviderSystem.class)).sort();		
		}
		
		public Class<LookupServiceImpl> getLookupServiceClass()
		{
			return ims.domain.lookups.impl.LookupServiceImpl.class;
		}
		
		public String getPASName(Integer id, String extSystem)
		{
			if (id == null || extSystem == null)
				return null;
			
			return getLookupService().getRemoteLookup(id, extSystem);
		}
		
		public MedicLiteVoCollection listMedics() 
		{
			DomainFactory factory = getDomainFactory();
			return  MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(factory.listDomainObjects(Medic.class)).sort();		
		}
		
		public MedicLiteVoCollection listMedics(String name) 
		{
			if (name == null || name.length() == 0)
				throw new DomainRuntimeException("Name not supplied");
			
			DomainFactory factory = getDomainFactory();
			String hql;
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
			PersonName medicName = new PersonName();
			medicName.setSurname(name);
	
			hql = " from Medic med ";
			StringBuffer condStr = new StringBuffer();
			String andStr = " ";
			
			condStr.append(" med.mos.name.upperSurname like :name or  med.mos.name.upperForename like :name");
			markers.add("name");
			values.add(medicName.getSurname().toUpperCase() + "%");
			andStr = " and ";
			condStr.append(andStr + "med.isActive = :isActive");
			markers.add("isActive");
			values.add(Boolean.TRUE);
			andStr = " and ";
	
			if (andStr.equals(" and "))
			{
				hql += " where ";
			}
	
			hql += condStr.toString();
			
			return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(factory.find(hql, markers, values));
		}
		
		public ExternalEventMappingVoCollection save(ExternalEventMappingVoCollection records, ExternalEventMappingVoCollection initialColl) throws StaleObjectException, ForeignKeyViolationException 
		{	
			ExternalEventMappingVo vo = new ExternalEventMappingVo();
			ExternalEventMappingVoCollection coll = new ExternalEventMappingVoCollection();
			int collSize = records.size();
			for (int j = 0; j < collSize; j++) 
			{
				if(records.get(j) == null)
				{
					throw new DomainRuntimeException("Invalid record");
				}
				if(!records.get(j).isValidated())
				{
					throw new CodingRuntimeException("Record not validated");
				}
			}
			DomainFactory factory = getDomainFactory();
			for (int i = 0; i < collSize; i++) 
			{
				
				ExternalEventMapping domainRecord = ExternalEventMappingVoAssembler.extractExternalEventMapping(factory, records.get(i));		
				
				factory.save(domainRecord);
				vo = ExternalEventMappingVoAssembler.create(domainRecord);
				coll.add(vo);
			}
			if (initialColl != null)
			{
				for (int i = 0; i < initialColl.size(); i++) 
				{
					ExternalEventMapping domainRecord = ExternalEventMappingVoAssembler.extractExternalEventMapping(factory, initialColl.get(i));
					factory.delete(domainRecord);
				}
			}
			
				
			return coll;
		}
		
		public ExternalEventMappingVo get(ExternalEventMappingRefVo record) 
		{
			if(record == null || record.getID_ExternalEventMapping() == null)
			{
				throw new DomainRuntimeException("Invalid record");
			}
			
			DomainFactory factory = getDomainFactory();
			ExternalEventMapping domainRecord = (ExternalEventMapping)factory.getDomainObject
						(ExternalEventMapping.class, record.getID_ExternalEventMapping().intValue());
			
			return ExternalEventMappingVoAssembler.create(domainRecord);
		}
	
		@SuppressWarnings("unchecked")
		public ExternalEventMappingVoCollection listByCriteria(ExternalEventMappingVo filter) 
		{
			DomainFactory factory = getDomainFactory();
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
			String andStr = " where ";
			StringBuffer hql = new StringBuffer();
			StringBuffer mainQuery = new StringBuffer();
			
			if (filter == null)
			{
					mainQuery.append(" from ExternalEventMapping as event order by event.providerSystem.id asc, event.group asc, event.detail asc, event.specialty asc");	
			}
			else
			{	
				mainQuery.append(" select event from ExternalEventMapping as event ");
				
				if (filter.getGroupIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.group.id = :id_group");
					names.add("id_group");
					values.add(filter.getGroup().getID());
					andStr = " and ";
				}
				if (filter.getProviderSystemIsNotNull())
				{
					mainQuery.append(" left join event.providerSystem as provider ");
					hql.append(andStr);
					hql.append(" provider.id = :id_provider ");
					names.add("id_provider");
					values.add(filter.getProviderSystem().getID_ProviderSystem());
					andStr = " and ";
				}
				if (filter.getDetailIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.detail.id = :id_detail");
					names.add("id_detail");
					values.add(filter.getDetail().getID());
					andStr = " and ";
				}
				if (filter.getSpecialtyIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.specialty.id = :id_specialty");
					names.add("id_specialty");
					values.add(filter.getSpecialty().getID());
					andStr = " and ";
				}
				if (filter.getClinicCodeIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.clinicCode = :clinicCode");
					names.add("clinicCode");
					values.add(filter.getClinicCode().toUpperCase());
					andStr = " and ";
				}
				if (filter.getConsultantIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.consultant.id = :id_consultant");
					names.add("id_consultant");
					values.add(filter.getConsultant().getID_Hcp());
					andStr = " and ";
				}
							
				hql.append(" order by event.providerSystem  asc,  event.group asc, event.detail asc ");
				
				if (filter.getSpecialtyIsNotNull())
				{
					hql.append(" , event.specialty asc ");
				}
				if (filter.getConsultantIsNotNull())
				{
					hql.append(" , event.consultant asc "); 	
				}
				if (filter.getClinicCodeIsNotNull())
				{
					hql.append(" , event.clinicCode  asc "); 	
				}
			}

			List collection = factory.find(mainQuery.toString()+hql.toString(), names, values, 1000);
			return ExternalEventMappingVoAssembler.createExternalEventMappingVoCollectionFromExternalEventMapping(collection);
		}
	
		@SuppressWarnings("unchecked")
		public ExternalEventMappingVoCollection checkForUniq(ExternalEventMappingVo filter, StringBuffer  ids) 
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer();
			StringBuffer mainQuery = new StringBuffer();
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
			String andStr = " where ";
			List collection = null;
				
			if (filter.getConsultantIsNotNull())	
			{
				
				mainQuery.append(" select event from ExternalEventMapping as event ");
				hql.append(" where event.consultant.id = :id_consultant");
				names.add("id_consultant");
				values.add(filter.getConsultant().getID_Hcp());
				
				hql.append(" and event.id = :id_event");
				names.add("id_event");
				values.add(filter.getID_ExternalEventMapping());
			}
			if (ids != null &&
					ids.length() > 0)
			{
				hql.append(" and event.id not in ( " + ids + " )");
			}
			if (filter.getConsultantIsNotNull())
						collection = factory.find(mainQuery.toString()+hql.toString(), names, values);
			if (collection != null &&
					collection.size() > 0)
 				return ExternalEventMappingVoAssembler.createExternalEventMappingVoCollectionFromExternalEventMapping(collection);
			
			if (filter.getClinicCodeIsNotNull())
			{
				hql = new StringBuffer();
				mainQuery = new StringBuffer();
				names = new ArrayList<String>();
				values = new ArrayList<Serializable>();
				
				mainQuery.append(" select event from ExternalEventMapping as event ");
				hql.append(" where event.clinicCode = :clinicCode");
				names.add("clinicCode");
				values.add(filter.getClinicCode().toUpperCase());
			
				hql.append(" and event.id = :id_event");
				names.add("id_event");
				values.add(filter.getID_ExternalEventMapping());
			}
			if (ids != null &&
					ids.length() > 0)
			{
				hql.append(" and event.id not in ( " + ids + " )");
			}
			
			if (filter.getClinicCodeIsNotNull())
						collection = factory.find(mainQuery.toString()+hql.toString(), names, values);
			
			if (collection != null &&
					collection.size() > 0)
				return ExternalEventMappingVoAssembler.createExternalEventMappingVoCollectionFromExternalEventMapping(collection);
			
				
			hql = new StringBuffer();
			mainQuery = new StringBuffer();
			names = new ArrayList<String>();
			values = new ArrayList<Serializable>();
				
				
			mainQuery.append(" select event from ExternalEventMapping as event ");
				
			if (filter.getGroupIsNotNull() &&
						filter.getProviderSystemIsNotNull() &&
							filter.getDetailIsNotNull())
				{
					mainQuery.append(" left join event.providerSystem as provider ");
					hql.append(andStr);
					hql.append(" event.group.id = :id_group and provider.id = :id_provider and event.detail.id = :id_detail ");
					names.add("id_group");
					names.add("id_provider");
					names.add("id_detail");
					values.add(filter.getGroup().getID());
					values.add(filter.getProviderSystem().getID_ProviderSystem());
					values.add(filter.getDetail().getID());
					andStr = " and ";
				}
				if (filter.getSpecialtyIsNotNull())
				{
					hql.append(andStr);
					hql.append(" event.specialty.id = :id_specialty");
					names.add("id_specialty");
					values.add(filter.getSpecialty().getID());
					andStr = " and ";
				}
				
				if (ids != null &&
						ids.length() > 0)
				{
					hql.append(" and event.id not in ( " + ids + " )");
				}
				
				collection = factory.find(mainQuery.toString()+hql.toString(), names, values);
			
 			return ExternalEventMappingVoAssembler.createExternalEventMappingVoCollectionFromExternalEventMapping(collection);
		}
	
	}
