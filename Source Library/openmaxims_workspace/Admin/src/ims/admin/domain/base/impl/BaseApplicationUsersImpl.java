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

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseApplicationUsersImpl extends DomainImpl implements ims.admin.domain.ApplicationUsers, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistMos(String mosSurname, String mosForename)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAppUser(ims.admin.vo.AppUserVo appUserItem, Boolean replicateToDTO, ims.core.vo.MemberOfStaffShortVo memberOfStaffOld)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAppUsers(ims.admin.vo.AppUserShortVo appUserFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAppUser(ims.admin.vo.AppUserShortVo appUserVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetEmailData(ims.core.configuration.vo.AppUserRefVo appUser)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDtoAppUserByName(String name)
	{
		if(name == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'name' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateupdateAppUser(ims.admin.vo.AppUserVo appUser)
	{
		if(appUser == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appUser' of type 'ims.admin.vo.AppUserVo' cannot be null.");
	}
}
