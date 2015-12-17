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

package ims.nursing.domain;

// Generated from form domain impl
public interface PlanOfCare extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listPlansofCareByStatus
	*/
	public ims.nursing.vo.PlanOfCareListVoCollection listPlansofCareByStatus(ims.core.admin.vo.CareContextRefVo voCareContextRef, ims.nursing.vo.lookups.PlanOfCareStatus status);

	// Generated from form domain interface definition
	/**
	* listDailyPatientProgressHitory
	*/
	public ims.nursing.vo.PlanOfCareHistoryVoCollection listDailyPatientProgressHistory(ims.core.admin.vo.CareContextRefVo voCareContextRef, ims.nursing.vo.PlanOfCareRefVo record);

	// Generated from form domain interface definition
	/**
	* getPlanOfCare
	*/
	public ims.nursing.vo.PlanOfCareVo getPlanOfCare(ims.nursing.vo.PlanOfCareRefVo voPlanOfCareRef);

	// Generated from form domain interface definition
	/**
	* savePlanOfCare
	*/
	public ims.nursing.vo.PlanOfCareVo savePlanOfCare(ims.nursing.vo.PlanOfCareVo record) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.nursing.vo.PlanOfCareActionsVoCollection listPocActions(ims.core.admin.vo.CareContextRefVo voCareContext, ims.nursing.vo.PlanOfCareRefVo record);
}
