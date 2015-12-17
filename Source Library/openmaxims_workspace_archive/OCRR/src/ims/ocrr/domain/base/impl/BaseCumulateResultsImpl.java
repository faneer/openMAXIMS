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

public abstract class BaseCumulateResultsImpl extends DomainImpl implements ims.ocrr.domain.CumulateResults, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistResults(ims.core.patient.vo.PatientRefVo patient, ims.ocrr.configuration.vo.AnalyteRefVoCollection analytes, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, Boolean isTabularView)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDataset(ims.ocrr.configuration.vo.AnalyteRefVo analyte)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrder(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderSpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo specimenRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDTFOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigationRef)
	{
	}
}
