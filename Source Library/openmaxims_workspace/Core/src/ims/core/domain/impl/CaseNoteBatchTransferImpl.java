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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5332.26009)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.domain.CaseNoteTransfer;
import ims.core.domain.base.impl.BaseCaseNoteBatchTransferImpl;
import ims.core.vo.PatientCaseNoteTransferVo;
import ims.domain.exceptions.StaleObjectException;

public class CaseNoteBatchTransferImpl extends BaseCaseNoteBatchTransferImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocationLiteVoCollection listCaseNoteLocations(String name)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listCaseNoteFolderLocations(name);
	}

	public void saveTransfer(PatientCaseNoteTransferVo transfer, Boolean sameLocation) throws StaleObjectException
	{
		CaseNoteTransfer impl = (CaseNoteTransfer) getDomainImpl(CaseNoteTransferImpl.class);
		impl.saveTransfer(transfer, null, sameLocation);
		
	}
}
