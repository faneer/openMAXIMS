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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40623.1200)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.core.clinical.domain.objects.ClinicalNotes;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.domain.ClinicalNotesVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.nursing.vo.NursingClinicalNotesListVoCollection;
import ims.nursing.vo.domain.NursingClinicalNotesListVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class ClinicalNotesViewImpl extends DomainImpl implements ims.nursing.domain.ClinicalNotesView, ims.domain.impl.Transactional
{
	/**
	 * call getReportAndTemplate form Core.Reports domainImpl
	 */
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws DomainInterfaceException
	{
		Reports impl = (Reports) getDomainImpl(ReportsImpl.class);
		return impl.getReportAndTemplate(nReportId, nTemplateId);
	}
	/**
	 * Lists Clinic Notes for the given EpisodeId and Date Range - also receives
	 * a filter for all or active only true = all false = active only
	 */    
	public NursingClinicalNotesListVoCollection listClinicNotes(Date fromDate,Date toDate, Boolean activeOnly, CareContextShortVo careContextVo) 
	{
		DomainFactory factory = getDomainFactory();
		String filter = "from NursingClinicalNotes t ";
		String andStr = " ";
		ArrayList markerNames = new ArrayList();
		ArrayList markerValues = new ArrayList();

		StringBuffer filterString = new StringBuffer();
		boolean conditionFound = false;

		if (fromDate != null && toDate != null)
		{
			filterString.append(" t.recordingDateTime >= :fromDate and t.recordingDateTime < :toDate ");
			conditionFound = true;

			markerNames.add("fromDate");
			markerValues.add(fromDate.getDate());

			// Adding a day to the toDate will ensure everything up to 23:59:59
			// recorded on toDate will be returned
			markerNames.add("toDate");
			markerValues.add(toDate.copy().addDay(1).getDate());

			andStr = " and ";
		}
		else if (fromDate != null)
		{
			filterString.append(" t.recordingDateTime >= :fromDate ");
			filterString.append(" and t.recordingDateTime < :toDate ");
			conditionFound = true;
			markerNames.add("fromDate");
			markerNames.add("toDate");

			markerValues.add(fromDate.getDate());
			markerValues.add(fromDate.copy().addDay(1).getDate());

			andStr = " and ";
		}

		if (careContextVo != null)
		{
			if (conditionFound)
				filterString.append(" and ");

			filterString.append(" t.careContext.id = :CareContext ");
			markerNames.add("CareContext");
			markerValues.add(careContextVo.getID_CareContext());
			andStr = " and ";

			// commented out as attribute no longer part of BO
			if (activeOnly != null && activeOnly.booleanValue())
			{
				//filterString.append(andStr + " t.currentStatus.correctionConfirmed != :isActive");
				filterString.append(andStr + " t.isCorrected <> :isActive"); //WDEV-15049
				markerNames.add("isActive");
				markerValues.add(Boolean.TRUE);
				
			}	
		}
		// We only want to list Nursing Clinical notes here.
		// filterString.append(andStr + " t.class = NursingClinicalNotes");

		String[] names = new String[markerNames.size()];
		markerNames.toArray(names);
		filter += " where ";

		filter += filterString.toString();

		List notes = factory.find(filter, markerNames, markerValues,1000);
		return NursingClinicalNotesListVoAssembler.createNursingClinicalNotesListVoCollectionFromNursingClinicalNotes(notes).sort(SortOrder.DESCENDING);
		
	}
	public ClinicalNotesVo getClinicalNoteById(Integer idClinicalNote)
	{
		if(idClinicalNote == null)
			throw new CodingRuntimeException("idClinicalNote cannot be null in method getClinicalNoteById");
		
		return ClinicalNotesVoAssembler.create((ClinicalNotes) getDomainFactory().getDomainObject(ClinicalNotes.class, idClinicalNote));
	}
}
