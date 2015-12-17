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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseReportAccessImpl;
import ims.admin.vo.SystemReportVo;
import ims.admin.vo.domain.SystemReportVoAssembler;
import ims.core.admin.domain.objects.ReportBo;
import ims.core.admin.vo.ReportBoRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

public class ReportAccessImpl extends BaseReportAccessImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.SystemReportVo saveReport(SystemReportVo report) throws ims.domain.exceptions.StaleObjectException
	{
		if (report == null)
			throw new CodingRuntimeException("Cannot save null Report");

		if (!report.isValidated())
			throw new DomainRuntimeException("SystemReportVo Not Validated.");

		DomainFactory factory = getDomainFactory();

		ReportBo doReport = SystemReportVoAssembler.extractReportBo(factory, report);
		factory.save(doReport);

		return SystemReportVoAssembler.create(doReport);
	}

	public SystemReportVo getReport(ReportBoRefVo reportRef)
	{
		if (reportRef == null)
			throw new CodingRuntimeException("Cannot get Report on null Id.");

		return SystemReportVoAssembler.create((ReportBo) getDomainFactory().getDomainObject(ReportBo.class, reportRef.getID_ReportBo()));
	}
}
