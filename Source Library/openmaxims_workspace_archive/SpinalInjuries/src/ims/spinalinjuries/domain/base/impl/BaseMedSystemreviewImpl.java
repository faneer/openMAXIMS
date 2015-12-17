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

package ims.spinalinjuries.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseMedSystemreviewImpl extends DomainImpl implements ims.spinalinjuries.domain.MedSystemreview, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetAdmisSystemReviewByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContactShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAdmisSystemReview(ims.generalmedical.vo.AdmisSysRevewVo admisSysReview, ims.core.vo.ClinicalContactShortVo contact)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmisSystemReviewByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientProblemByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContactShort)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientProblemByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmisSystemReviewCollByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmisSystemReviewCollByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContactShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveProblemsAdmis(ims.generalmedical.vo.MedicalProbOnAdmisVoCollection problemColl)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRiePatientProblemBYCareConntext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRiePatientProblemByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalCOntactShort)
	{
	}
}
