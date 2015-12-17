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

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseAtConsultationComponentImpl extends DomainImpl implements ims.RefMan.domain.AtConsultationComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPresentationReferralSummary(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveMedication(String filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveDiagnosis(String filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAtConsultation(ims.RefMan.vo.AtConsultationVo voAtConsultation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetConsultation(ims.RefMan.vo.CatsReferralRefVo voCATSRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotlistProcedureShort(String procedureName, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferralService(ims.RefMan.vo.CatsReferralRefVo voCatsReferralRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateOrUpdateMedication(ims.core.vo.MedicationVo value)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPresentationReferralSummaryMedication(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
	}
}
