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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5214.17710)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.clinical.vo.PatientCaseNoteRefVo;
import ims.core.domain.base.impl.BaseCaseNoteOpentRequestsGridCCImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.PatientCaseNoteRequestShortVoCollection;
import ims.core.vo.domain.PatientCaseNoteRequestShortVoAssembler;
import ims.core.vo.lookups.CaseNoteRequestStatus;
import ims.core.vo.lookups.LocationType;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class CaseNoteOpentRequestsGridCCImpl extends BaseCaseNoteOpentRequestsGridCCImpl
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteRequestShortVoCollection listOpenRequests(PatientRefVo patient, PatientCaseNoteRefVo caseNote, LocationRefVo location, DateTime dateFrom, DateTime dateTo, Boolean caseNotesInMedicalRecordsOnly)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT request FROM PatientCaseNoteRequest AS request LEFT JOIN request.patient AS patient left join request.requestedForLocation as loc ");
		query.append(" LEFT JOIN request.caseNote AS caseNote LEFT JOIN caseNote.currentLocation AS currentLocation LEFT JOIN currentLocation.type AS locType ");
		
		query.append("WHERE patient.id = :PAT_ID AND request.requestStatus.id = :REQ_STATUS");

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("PAT_ID");		paramValues.add(patient.getID_Patient());
		paramNames.add("REQ_STATUS");	paramValues.add(CaseNoteRequestStatus.OPEN.getId());

		
		// Show request only for given Case Note 
		if (caseNote != null && caseNote.getID_PatientCaseNote() != null)
		{
			query.append(" AND caseNote.id = :CASE_NOTE_ID");
			
			paramNames.add("CASE_NOTE_ID");
			paramValues.add(caseNote.getID_PatientCaseNote());
		}
		
		if(location != null && location.getID_Location() != null)
		{
			query.append(" AND loc.id = :LOC_ID");
			
			paramNames.add("LOC_ID");
			paramValues.add(location.getID_Location());
		}
		
		if(dateFrom != null && dateTo != null)
		{
			query.append(" AND request.requiredByDate between :DATE_FROM and :DATE_TO ");
			
			paramNames.add("DATE_FROM");
			paramNames.add("DATE_TO");
			paramValues.add(dateFrom.getJavaDate());
			paramValues.add(dateTo.getJavaDate());
		}
		
		if (Boolean.TRUE.equals(caseNotesInMedicalRecordsOnly))
		{
			query.append(" AND locType.id = :MEDICAL_RECORDS ");
			paramNames.add("MEDICAL_RECORDS");
			paramValues.add(LocationType.MEDICAL_RECORDS.getID());
		}
		
		query.append(" ORDER BY request.requiredByDate ASC");
		
		return PatientCaseNoteRequestShortVoAssembler.createPatientCaseNoteRequestShortVoCollectionFromPatientCaseNoteRequest(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}
}
