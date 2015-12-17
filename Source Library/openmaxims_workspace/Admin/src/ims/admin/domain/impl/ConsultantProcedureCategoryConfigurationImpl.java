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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.base.impl.BaseConsultantProcedureCategoryConfigurationImpl;
import ims.admin.vo.ConsultantProcedureCategoryVo;
import ims.admin.vo.ConsultantProcedureCategoryVoCollection;
import ims.admin.vo.domain.ConsultantProcedureCategoryVoAssembler;
import ims.core.clinical.domain.objects.ConsultantProcedureCategory;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;

import java.util.ArrayList;
import java.util.List;

public class ConsultantProcedureCategoryConfigurationImpl extends BaseConsultantProcedureCategoryConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.HcpLiteVoCollection listHcps(String nameFilter) throws ims.domain.exceptions.DomainInterfaceException
	{
		if (nameFilter == null)
			throw new DomainInterfaceException("Name Filter must be not null");
		HcpAdmin hcpAdminImpl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdminImpl.listHcpLiteByName(nameFilter);
		
	}

	public ims.admin.vo.ConsultantProcedureCategoryVo save(ims.admin.vo.ConsultantProcedureCategoryVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (record == null)
			throw new DomainInterfaceException("The record you want to save is null");
		if (!record.isValidated())
			throw new DomainInterfaceException("The record you want to save is not validated");
		ConsultantProcedureCategory domObj = ConsultantProcedureCategoryVoAssembler.extractConsultantProcedureCategory(getDomainFactory(), record);
		getDomainFactory().save(domObj);
		return ConsultantProcedureCategoryVoAssembler.create(domObj);
	}

	
	@SuppressWarnings("unchecked")
	public HcpLiteVoCollection listHcpLiteNotConfigured(String nameFilter) throws ims.domain.exceptions.DomainInterfaceException
	{
		if (nameFilter==null)
			throw new DomainInterfaceException("NameFilter must be not null");
		String query = "select h1_1 from Hcp as h1_1 left join h1_1.mos as m1_1 " +
				"where (h1_1.id not in (select c1_1.performingHCP.id from ConsultantProcedureCategory as c1_1) " +
				"and h1_1.isActive = 1 and m1_1.name.upperSurname like :nameFilter) " +
				"order by m1_1.name.upperSurname asc, m1_1.name.upperForename asc ";
		List results = getDomainFactory().find(query, "nameFilter", nameFilter.toUpperCase() + "%"); //WDEV-11739
		if (results == null | results.size() == 0)
			return null;
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(results);
			
	}

	@SuppressWarnings("unchecked")
	public ConsultantProcedureCategoryVoCollection listConsultantsProcedureCategory(HcpLiteVo hcp) throws DomainInterfaceException
	{
		
		StringBuilder query = new StringBuilder("select c1_1 from ConsultantProcedureCategory as c1_1 " +
				"left join c1_1.performingHCP as h1_1 left join h1_1.mos as m1_1");
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		if (hcp != null)
		{
			query.append(" where (c1_1.performingHCP.id = :Hcp_id)");
			paramNames.add("Hcp_id");
			paramValues.add(hcp.getID_Hcp());
		}
		
		query.append(" order by m1_1.name.surname asc ");
		List domObjs = getDomainFactory().find(query.toString(),paramNames,paramValues);
		if (domObjs == null || domObjs.size()==0)
			return null;
			
		return ConsultantProcedureCategoryVoAssembler.createConsultantProcedureCategoryVoCollectionFromConsultantProcedureCategory(domObjs);
	}

	public void deleteConfiguredConsultant(ConsultantProcedureCategoryVo confdConsultant) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		if (!confdConsultant.getID_ConsultantProcedureCategoryIsNotNull())
		{
			throw new DomainInterfaceException("New record recived for deletion ");
			
		}
		ConsultantProcedureCategory obj = ConsultantProcedureCategoryVoAssembler.extractConsultantProcedureCategory(getDomainFactory(),confdConsultant);
		getDomainFactory().delete(obj);
	}
}
