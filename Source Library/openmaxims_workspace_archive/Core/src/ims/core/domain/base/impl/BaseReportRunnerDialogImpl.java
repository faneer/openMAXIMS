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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseReportRunnerDialogImpl extends DomainImpl implements ims.core.domain.ReportRunnerDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByNameAndDisciplineType(String hcpName, ims.core.vo.lookups.HcpDisType hcpDisciplineType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistGPsBySurname(String surname)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrganisationsShort(ims.core.vo.OrgShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocSite(String locationName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationByName(String locationName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistCustomSearchSeed(String name, String seedField, String[] displayFields, String[] searchFields, String text)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLokupType(String lookupType)
	{
	}
}
