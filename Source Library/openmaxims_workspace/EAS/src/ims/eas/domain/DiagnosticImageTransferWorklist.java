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

package ims.eas.domain;

// Generated from form domain impl
public interface DiagnosticImageTransferWorklist extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHCP(String name, Boolean responsibleHcp);

	// Generated from form domain interface definition
	public ims.eas.vo.DiagnosticImageTransferVoCollection listDiagnosticImages(ims.framework.utils.Date seenFrom, ims.framework.utils.Date seenTo, ims.framework.utils.Date dtaFrom, ims.framework.utils.Date dtaTo, ims.core.resource.people.vo.HcpRefVo seenBy, ims.core.resource.people.vo.HcpRefVo responsibleHcp, ims.eas.vo.lookups.EASStatus status, Boolean removed);

	// Generated from form domain interface definition
	public ims.eas.vo.ElectronicActionSheetVo getEAS(ims.eas.vo.ElectronicActionSheetRefVo eas);

	// Generated from form domain interface definition
	public void recordRemovalReason(ims.eas.vo.ElectronicActionSheetRefVo eas, ims.eas.vo.lookups.RemovalReason removalReason) throws ims.domain.exceptions.StaleObjectException;
}
