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

public abstract class BaseOrderSummaryDialogImpl extends DomainImpl implements ims.ocrr.domain.OrderSummaryDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetOrderSummary(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderDetails(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderFullDetails(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateauthoriseOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelOrderInvestigations(ims.core.vo.PatientShort patient, ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection collOrderInvestigation, ims.ocrr.vo.lookups.InvestigationStatusChangeReason cancelReason, String cancelReasonComment)
	{
		if(collOrderInvestigation == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'collOrderInvestigation' of type 'ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection' cannot be null.");
		if(cancelReason == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'cancelReason' of type 'ims.ocrr.vo.lookups.InvestigationStatusChangeReason' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role)
	{
		if(role == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'role' of type 'ims.framework.interfaces.IAppRole' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetCentricityPacsAccessionNumber(ims.ocrr.vo.OrderInvestigationListVo voOrderInvListVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrdInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigationRef)
	{
	}
}
