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

package ims.ocrr.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicalOrdersResultsOCRRFormImpl extends DomainImpl implements ims.ocrr.domain.ClinicalOrdersResultsOCRRForm, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistClinicians(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistResults(ims.framework.utils.DateTime dateFrom, ims.framework.utils.DateTime dateTo, ims.core.clinical.vo.ServiceRefVo department, ims.ocrr.configuration.vo.InvestigationIndexRefVo exam, ims.core.resource.people.vo.HcpRefVo clinician, Boolean resultsOnly, ims.core.patient.vo.PatientRefVo patientId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServices(String name, ims.core.vo.lookups.ServiceCategory type)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role)
	{
		if(role == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'role' of type 'ims.framework.interfaces.IAppRole' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistInvestigations(String name, Boolean beginWith)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRefAppDetOcsOrder(String listId, ims.core.patient.vo.PatientRefVo patientRef, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferralAppointmentDetailsOrderInv(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvRef)
	{
	}
}
