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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.utils.Date;
import ims.scheduling.domain.ExclusionDates;
import ims.scheduling.domain.GenerateSessions;
import ims.scheduling.domain.base.impl.BaseAdHocDateSelectionImpl;
import ims.scheduling.vo.ExclusionDatesVo;
import ims.scheduling.vo.ProfileShortVo;

public class AdHocDateSelectionImpl extends BaseAdHocDateSelectionImpl
{

	private static final long serialVersionUID = 1L;

	public Boolean generateSession(ProfileShortVo profile, Date date) throws DomainInterfaceException, StaleObjectException
	{
		GenerateSessions impl = (GenerateSessions) getDomainImpl(GenerateSessionsImpl.class);

		return impl.createAdHocSession(profile, date);
	}

	public Boolean isExcludedDate(Date date)
	{
		ExclusionDates impl = (ExclusionDates) getDomainImpl(ExclusionDatesImpl.class);
		ExclusionDatesVo exDate = impl.listExclusionDates();

		if (exDate == null)
			return false;

		for (int i = 0; i < exDate.getDates().length; i++)
		{
			if (date.equals(exDate.getDates()[i]))
			{
				return true;
			}
		}

		return false;
	}

}
