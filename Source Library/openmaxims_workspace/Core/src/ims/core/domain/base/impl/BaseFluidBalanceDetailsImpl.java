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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseFluidBalanceDetailsImpl extends DomainImpl implements ims.core.domain.FluidBalanceDetails, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetDailyFluidBalanceDetailsByContextDateAndTimePeriod(ims.core.admin.vo.CareContextRefVo contextRefVo, ims.framework.utils.DateTime datetimeStartShift, ims.framework.utils.DateTime datetimeEndShift)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDailyFluidBalance(ims.core.vo.DailyFluidBalanceVo dfbVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetFluidBalanceInstancesForContextAndDate(ims.core.admin.vo.CareContextRefVo contextVo, ims.framework.utils.DateTime datetimeStartShift, ims.framework.utils.DateTime datetimeEndShift)
	{
	}
}
