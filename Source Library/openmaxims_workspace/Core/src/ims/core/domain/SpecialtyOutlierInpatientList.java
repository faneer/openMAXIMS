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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.domain;

// Generated from form domain impl
public interface SpecialtyOutlierInpatientList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.SpecialtyOutlierInpatientEpisodeListVoCollection listInpatientEpisodes(ims.core.resource.place.vo.LocationRefVo wardRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.InpatientEpisodeLiteVo getInpatientEpisodeLite(ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatRef);

	// Generated from form domain interface definition
	public ims.core.vo.PendingTransfersLiteVo getPendingTranfer(ims.core.admin.pas.vo.PendingTransfersRefVo pendingTransferRefVo);

	// Generated from form domain interface definition
	public void cancelTransfer(ims.core.vo.PendingTransfersLiteVo voPending, ims.core.resource.place.vo.LocationRefVo wardRef) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.BedSpaceStateLiteVo getSelectedBedSpaceState(ims.core.layout.vo.BedSpaceRefVo bedSpaceRef);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextByPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEventRef);
}
