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
// This code was generated by Ancuta Ciubotaru using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.vo.ReportTemplateLiteVoCollection;
import ims.admin.vo.domain.ReportTemplateLiteVoAssembler;
import ims.core.admin.domain.objects.ModalityReports;
import ims.core.admin.vo.ModalityReportsRefVo;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.domain.base.impl.BaseReportsToModalityConfigFormImpl;
import ims.core.vo.ModalityReportsVoCollection;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.domain.ModalityReportsVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderSpecimen;

import java.util.ArrayList;
import java.util.List;

public class ReportsToModalityConfigFormImpl extends BaseReportsToModalityConfigFormImpl
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public ServiceLiteVoCollection listModality()
	{
		String hql = "from Service as s1_1 order by s1_1.serviceName asc";
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find(hql.toString());
		
		return ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(list);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModalityReportsVoCollection listModalityReports(TemplateBoRefVo template, ServiceRefVo modality, Boolean dft) throws DomainInterfaceException
	{
		StringBuffer hql = new StringBuffer();
		StringBuffer cond = new StringBuffer();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		
		DomainFactory factory = getDomainFactory();
		hql.append("select m from ModalityReports as m left join m.modality as s");
		
		if(template != null)
		{
			cond.append(andStr + "m.template.id = (:TID)");
			markers.add("TID");
			values.add(template.getID_TemplateBo());
			andStr = " and ";
		}

		if(modality != null)
		{
			cond.append(andStr + "m.modality.id = (:MID)");
			markers.add("MID");
			values.add(modality.getID_Service());
			andStr = " and ";
		}
		
		cond.append(andStr + "m.dFTReport = (:DFT)");
		markers.add("DFT");
		values.add(dft);
		andStr = " and ";
		
		if (andStr.equals(" and "))
		{
			hql.append(" where ");
		}
		
		hql.append(cond.toString());
		hql.append(" order by s.upperName"); //WDEV-20219 UPPER(s.serviceName)
		
		List list = factory.find(hql.toString(), markers, values);

		return ModalityReportsVoAssembler.createModalityReportsVoCollectionFromModalityReports(list);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })	
	public ReportTemplateLiteVoCollection listTemplates(String name, Boolean isDft)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		StringBuffer cond = new StringBuffer();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		hql.append("select t from TemplateBo as t join t.report as rep join rep.seeds as sd");
		
		cond.append(andStr + "t.isActive = :A");
		markers.add("A");
		values.add(Boolean.TRUE);
		andStr = " and ";

		cond.append(andStr + "t.report.isActive = :A");
		
		if(name.length() > 0)
		{
			cond.append(andStr + "UPPER(t.name) LIKE UPPER(:NAME)");
			markers.add("NAME");
			values.add(name);
			andStr = " and ";
		}
		
		if(isDft)
			cond.append(andStr + "sd.bOName in (" + getSeedsString(new String[] {OrderInvestigation.class.getName()}) + ")");
		else
			cond.append(andStr + "sd.bOName in (" + getSeedsString(new String[] {OrderSpecimen.class.getName(),OrderInvestigation.class.getName()}) + ")");
		andStr = " and ";
		
		if (andStr.equals(" and "))
		{
			hql.append(" where ");
		}
		
		hql.append(cond.toString());
		hql.append(" order by UPPER(t.name)");
		
		List list = factory.find(hql.toString(), markers, values);
		
		return ReportTemplateLiteVoAssembler.createReportTemplateLiteVoCollectionFromTemplateBo(list);
	}

	private String getSeedsString(String[] seedTypes)
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < seedTypes.length; i++)
		{
			if(i > 0)
				sb.append(',');
			
			sb.append('\'');
			sb.append(seedTypes[i]);
			sb.append('\'');
		}
		
		return sb.toString();
	}
	
	public void deleteRecord(ModalityReportsRefVo recordId) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		if(recordId == null || recordId.getID_ModalityReports() == null)
			throw new CodingRuntimeException("The modality report recordId parameter is null !");
		
		DomainFactory factory = getDomainFactory();
		
		factory.delete(factory.loadDomainObject(ModalityReports.class, recordId.getID_ModalityReports()));
	}
	
}
