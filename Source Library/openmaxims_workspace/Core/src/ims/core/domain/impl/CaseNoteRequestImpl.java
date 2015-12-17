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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5214.17710)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.admin.vo.CaseNoteTrackingConfigVo;
import ims.core.clinical.vo.PatientCaseNoteRefVo;
import ims.core.clinical.vo.PatientCaseNoteRequestRefVo;
import ims.core.domain.PatientCaseNotes;
import ims.core.domain.base.impl.BaseCaseNoteRequestImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientCaseNoteRequestForCheckingVoCollection;
import ims.core.vo.PatientCaseNoteRequestVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.utils.DateTime;

public class CaseNoteRequestImpl extends BaseCaseNoteRequestImpl
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteRequestVo getCaseNoteRequests(PatientCaseNoteRequestRefVo caseNoteRequests) 
	{
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		return impl.getCaseNoteRequests(caseNoteRequests);
	}

	public PatientCaseNoteRequestVo saveCaseNoteRequest(PatientCaseNoteRequestVo caseNoteRequest) throws StaleObjectException 
	{
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		return impl.saveCaseNoteRequest(caseNoteRequest);
	}

	public LocationLiteVoCollection listCaseNoteLocations(String value) 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listCaseNoteFolderLocations(value);
	}

	public PatientCaseNoteRequestForCheckingVoCollection checkIfThereAreRequests(PatientCaseNoteRefVo caseNote, PatientCaseNoteRequestRefVo currentRequest, LocationRefVo location,	DateTime reqDate) 
	{
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		return impl.checkIfThereAreRequests(caseNote, currentRequest, location, reqDate);
	}

	public PatientCaseNoteRequestVo saveCaseNoteRequest(PatientCaseNoteRequestVo request, PatientCaseNoteRequestForCheckingVoCollection requestedThatNeedsToBeCancelled) throws StaleObjectException 
	{
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		return impl.saveCaseNoteRequest(request, requestedThatNeedsToBeCancelled);
	}

	public CaseNoteTrackingConfigVo getTrackingConfig() 
	{
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		return impl.getTrackingConfig();
	}
}
