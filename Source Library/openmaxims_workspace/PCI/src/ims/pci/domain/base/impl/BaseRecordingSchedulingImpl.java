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

package ims.pci.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseRecordingSchedulingImpl extends DomainImpl implements ims.pci.domain.RecordingScheduling, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetClientImmunisationSchedule(ims.core.patient.vo.PatientRefVo client)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveClientImmunisationSchedule(ims.pci.vo.ClientImmunisationScheduleVo clientImmunisationSchdule)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDefaultScheduleConfiguration(ims.framework.utils.Date atDate)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDefaultScheduleToClient(ims.core.patient.vo.PatientRefVo clientRef, ims.core.vo.MemberOfStaffLiteVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRegisteredGp(ims.core.patient.vo.PatientRefVo client)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistGp(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMembersOfStaff(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistBatchVaccine(String batchNumber, ims.core.vo.VaccineLiteVo vaccine)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBatchVaccine(String batchName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGpContract(ims.core.resource.people.vo.GpRefVo gpRef, ims.framework.utils.Date date)
	{
	}
}
