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

package ims.correspondence.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePatientListsImpl extends DomainImpl implements ims.correspondence.domain.PatientLists, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort voPatientShort)
	{
	}

	@SuppressWarnings("unused")
	public void validateisLetterRequired(ims.core.resource.people.vo.HcpRefVo voRefMedic, ims.core.vo.lookups.Specialty lkpSpecialty, ims.core.resource.place.vo.ClinicRefVo voClinicNew, ims.core.resource.place.vo.ClinicRefVo voRefClinicReview)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWards(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInPatients(ims.core.vo.PatientListsFilterVo voSearchCriteria)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPasEvent(ims.framework.utils.DateTime eventDateTime, ims.core.patient.vo.PatientRefVo voPatienRef, String pasEventId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCorrespondenceDetailsByPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveCorrespondenceDetails(ims.correspondence.vo.CorrespondenceDetailsVo voDocumentDetails, ims.vo.LookupInstVo pasEventType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutPatients(ims.framework.utils.Date dteDischargeDateFrom, ims.framework.utils.Date dteDischargeDateTo, ims.correspondence.vo.ClinicAccessFullVoCollection voCollClinicAccess, ims.correspondence.vo.ConsultantAccessFullVoCollection voCollConsultantAccess, ims.correspondence.vo.SpecialtyAccessVoCollection voCollSpecialtyAccess, ims.core.vo.lookups.DocumentStatus lkpDocumentStatus)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePasEvent(ims.core.vo.PasEventVo voPasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetFullUserAccessForUser(Integer appUserID)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCorrespondenceDetails(ims.correspondence.vo.CorrespondenceDetailsRefVo voCorrespRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreatePasEvent(ims.framework.utils.DateTime eventDateTime, ims.core.patient.vo.PatientRefVo voRefPatient, ims.correspondence.vo.PasContactVo voPasContact)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPasEventwithReferringGP(ims.core.admin.pas.vo.PASEventRefVo pasEventRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPasEventWithGpPractices(ims.framework.utils.DateTime eventDateTime, ims.core.patient.vo.PatientRefVo voRefPatient, String str)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCurrentDocument(ims.correspondence.vo.CorrespondenceDetailsRefVo voRefCorrespondenceDetail)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPasEvent(ims.core.admin.pas.vo.PASEventRefVo voPasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInPatients(ims.core.resource.place.vo.LocationRefVo refVoWard, ims.core.resource.people.vo.MedicRefVo refVoMedic)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveMedics(String strMedicName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistConsultantAccessForUser(Integer userId, String filterText)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSpecialtyAccessForUser(Integer userId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicAccessForUser(Integer idUser)
	{
	}
}
