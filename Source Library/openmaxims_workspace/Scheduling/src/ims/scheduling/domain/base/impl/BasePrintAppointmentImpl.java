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

package ims.scheduling.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePrintAppointmentImpl extends DomainImpl implements ims.scheduling.domain.PrintAppointment, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetReportAndTemplate(Integer nReportId, Integer nTemplateId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTemplates(java.util.ArrayList ids)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReport(ims.core.admin.vo.ReportBoRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientDocument(ims.core.vo.PatientDocumentVo patientDocumentToSave,  java.util.ArrayList idsArrayList)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReportTemplateVo(ims.core.admin.vo.TemplateBoRefVo reportTemplateRef)
	{
	}
}
