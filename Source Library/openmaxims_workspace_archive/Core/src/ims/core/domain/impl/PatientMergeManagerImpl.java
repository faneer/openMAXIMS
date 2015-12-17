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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.base.impl.BasePatientMergeManagerImpl;
import ims.core.patient.domain.objects.PatientMergeHistory;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.PatientId;
import ims.core.vo.domain.MergeRequestVoAssembler;
import ims.core.vo.domain.PatientMergeHistoryVoAssembler;
import ims.domain.DomainFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientMergeManagerImpl extends BasePatientMergeManagerImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Lists all items in the merge request table
	*/
	public ims.core.vo.MergeRequestVoCollection listOutstandingRequests(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, MemberOfStaffRefVo requestedBy, ims.core.vo.PatientId sourcePat, ims.core.vo.PatientId destPat)
	{
		DomainFactory factory = getDomainFactory();
		
		String andStr=" where ";
		StringBuffer hql = new StringBuffer();
		hql.append(" from MergeRequest mrg ");
		
		ArrayList<String> paramLabels = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
	
		if (dateFrom != null && dateTo != null)
		{
			hql.append(andStr).append(" mrg.systemInformation.creationDateTime between :dateFrom and :dateTo");
			andStr=" and ";
			paramLabels.add("dateFrom");
			paramLabels.add("dateTo");
			paramValues.add(dateFrom.getDate());
			Date newDate = ((ims.framework.utils.Date)dateTo.clone()).addDay(1).getDate();
			paramValues.add(newDate);
		}
		else if (dateFrom != null && dateTo == null)
		{
			hql.append(andStr).append(" mrg.systemInformation.creationDateTime >= :dateFrom");
			andStr=" and ";
			paramLabels.add("dateFrom");
			paramValues.add(dateFrom.getDate());
		}
		else if (dateFrom == null && dateTo != null)
		{
			hql.append(andStr).append(" mrg.systemInformation.creationDateTime < :dateTo");
			andStr=" and ";
			paramLabels.add("dateTo");
			Date newDate = ((ims.framework.utils.Date)dateTo.clone()).addDay(1).getDate();
			paramValues.add(newDate);
		}
		
		if (requestedBy != null)
		{
			hql.append(andStr).append(" mrg.requestedBy.id = :requestedBy");
			andStr=" and ";
			paramLabels.add("requestedBy");
			paramValues.add(requestedBy.getID_MemberOfStaff());
		}
		
		if (sourcePat != null  && sourcePat.getTypeIsNotNull() && sourcePat.getValueIsNotNull())
		{
			hql.append(andStr).append(" mrg.sourcePatId = :sourcePat ");
			andStr = " and ";
			paramLabels.add("sourcePat");
			paramValues.add(getPatientIdFromMerge(factory, sourcePat));
		}
		
		if (destPat != null && destPat.getTypeIsNotNull() && destPat.getValueIsNotNull())
		{
			hql.append(andStr).append(" mrg.destinationPatId = :destPat ");
			andStr = " and ";
			paramLabels.add("destPat");
			paramValues.add(getPatientIdFromPatient(factory, destPat));
		}

		List<?> lst = factory.find(hql.toString(), paramLabels, paramValues);
		return MergeRequestVoAssembler.createMergeRequestVoCollectionFromMergeRequest(lst);
		
	}

	private Integer getPatientIdFromPatient(DomainFactory factory, PatientId pat)
	{
		if (pat == null)
			return null;
		
		String hql = " from Patient p join p.identifiers as ids" +
				" where ids.type = :type and ids.value = :value";
			
		ArrayList<String> paramLabels = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramLabels.add("type");
		paramLabels.add("value");
		paramValues.add(getDomLookup(pat.getType()));
		paramValues.add(pat.getValue());
		List<?> lst = factory.find(hql, paramLabels, paramValues);
		if (lst == null || lst.size() == 0)
			return null;
		ims.core.patient.domain.objects.Patient domPat = (ims.core.patient.domain.objects.Patient) lst.get(0);
		return domPat.getId();
	}

	private Integer getPatientIdFromMerge(DomainFactory factory, PatientId pat)
	{
		if (pat == null)
			return null;
		
		String hql = " from PatientMergeHistory p join p.patientIds as ids" +
				" where ids.type = :type and ids.value = :value";
			
		ArrayList<String> paramLabels = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramLabels.add("type");
		paramLabels.add("value");
		paramValues.add(getDomLookup(pat.getType()));
		paramValues.add(pat.getValue());
		List<?> lst = factory.find(hql, paramLabels, paramValues);
		if (lst == null || lst.size() == 0)
			return null;
		PatientMergeHistory domPat = (PatientMergeHistory) lst.get(0);
		return domPat.getSourcePatId();
	}

	
	/**
	* Returns a list of patient merge history records
	*/
	public ims.core.vo.PatientMergeHistoryVoCollection listHistoryRequests(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, MemberOfStaffRefVo requestedBy, ims.core.vo.PatientId sourcePat, ims.core.vo.PatientId destinationPat)
	{
		DomainFactory factory = getDomainFactory();
		
		String andStr=" where ";
		StringBuffer hql = new StringBuffer();
		hql.append(" from PatientMergeHistory mrg ");
		
		ArrayList<String> paramLabels = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
	
		if (dateFrom != null && dateTo != null)
		{
			hql.append(andStr).append(" mrg.creationDateTime between :dateFrom and :dateTo");
			andStr=" and ";
			paramLabels.add("dateFrom");
			paramLabels.add("dateTo");
			paramValues.add(dateFrom.getDate());
			Date newDate = ((ims.framework.utils.Date)dateTo.clone()).addDay(1).getDate();
			paramValues.add(newDate);
		}
		else if (dateFrom != null && dateTo == null)
		{
			hql.append(andStr).append(" mrg.creationDateTime >= :dateFrom");
			andStr=" and ";
			paramLabels.add("dateFrom");
			paramValues.add(dateFrom.getDate());
		}
		else if (dateFrom == null && dateTo != null)
		{
			hql.append(andStr).append(" mrg.creationDateTime < :dateTo");
			andStr=" and ";
			paramLabels.add("dateTo");
			Date newDate = ((ims.framework.utils.Date)dateTo.clone()).addDay(1).getDate();
			paramValues.add(newDate);
		}
		
		if (requestedBy != null)
		{
			hql.append(andStr).append(" mrg.requestedBy.id = :requestedBy");
			andStr=" and ";
			paramLabels.add("requestedBy");
			paramValues.add(requestedBy.getID_MemberOfStaff());
		}
		
		if (sourcePat != null && sourcePat.getTypeIsNotNull() && sourcePat.getValueIsNotNull())
		{
			hql.append(andStr).append(" mrg.sourcePatId = :sourcePat ");
			andStr = " and ";
			paramLabels.add("sourcePat");
			paramValues.add(getPatientIdFromMerge(factory, sourcePat));
		}
		
		if (destinationPat != null && destinationPat.getTypeIsNotNull() && destinationPat.getValueIsNotNull())
		{
			hql.append(andStr).append(" mrg.destinationPatId = :destPat ");
			andStr = " and ";
			paramLabels.add("destPat");
			paramValues.add(getPatientIdFromPatient(factory, destinationPat));
		}

		List<?> lst = factory.find(hql.toString(), paramLabels, paramValues);
		return PatientMergeHistoryVoAssembler.createPatientMergeHistoryVoCollectionFromPatientMergeHistory(lst);
		
	}
}
