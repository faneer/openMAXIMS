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

package ims.therapies.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseSoapNoteDlgImpl extends DomainImpl implements ims.therapies.domain.SoapNoteDlg, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesaveClinicalNotes(ims.core.vo.ClinicalNotesVo clinicalNotesVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalNotes(ims.core.admin.vo.ClinicalContactRefVo contactVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSOAPsVo(ims.core.vo.SOAPVo voSOAP)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSOAPsVo(ims.core.clinical.vo.ClinicalNotesRefVo clinnoteRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalContact(Integer nId)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveClinicalContact(ims.core.vo.ClinicalContactShortVo clinicalContactVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMemberOfStaff(ims.core.vo.MemberOfStaffShortVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalNotesForContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalNote(ims.core.clinical.vo.ClinicalNotesRefVo clinicalNoteRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalNotesForCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
	}
}
