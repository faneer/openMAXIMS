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

public abstract class BasePathologyResultsImpl extends DomainImpl implements ims.ocrr.domain.PathologyResults, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistClinicians(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInvestigationTypes(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistResults(ims.core.patient.vo.PatientRefVo patient, ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate, ims.ocrr.configuration.vo.InvestigationIndexRefVo investigationType, ims.core.vo.ServiceLiteVo discipline, ims.core.resource.people.vo.HcpRefVo clinician, Boolean resultsOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistChartResults(ims.core.patient.vo.PatientRefVo patient, ims.core.charting.vo.ChartTypeRefVo chartType, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, Boolean isTabularView)
	{
	}

	@SuppressWarnings("unused")
	public void validategetChartType(ims.core.charting.vo.ChartTypeRefVo id)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistInvestigationTypesSynonyms(String name, Boolean beginWith)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSystemReportAndTemplate(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecimenWorkListItemDateToCollectBySpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo specimen)
	{
		if(specimen == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'specimen' of type 'ims.ocrr.orderingresults.vo.OrderSpecimenRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetMappingForResultStatusLookup(ims.ocrr.vo.lookups.ResultStatus resultStatusInstance, ims.core.vo.lookups.TaxonomyType extSystem)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecimenWorkListItemDateToCollectByInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecimensWithDateToCollect(String specimensIds)
	{
	}
}
