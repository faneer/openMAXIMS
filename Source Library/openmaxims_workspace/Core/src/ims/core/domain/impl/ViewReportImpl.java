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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.25 build 1942.14331)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.List;

import ims.admin.domain.FormReports;
import ims.admin.domain.impl.FormReportsImpl;
import ims.admin.vo.ReportSeedVoCollection;
import ims.admin.vo.ReportVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.impl.DomainImpl;

public class ViewReportImpl extends DomainImpl implements ims.core.domain.ViewReport, ims.domain.impl.Transactional
{
	/**
	 *
	 * @return [0] = report Xml
	 * @return [1] = template Xml
	 * @return [2] = report name
	 * @return [3] = report description
	 * @return [4] = template name
	 * @return [5] = template edescription
	 *  
	 */
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws DomainInterfaceException
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description " +
				"from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.id = :rid  and t1_1.id = :tid)", new String[] {"rid", "tid"}, new Object[] {nReportId, nTemplateId});
				
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;	}

	public ReportSeedVoCollection getReportSeeds(ReportVo reportVo) 
	{
	    FormReports formReportsImpl = (FormReports)getDomainImpl(FormReportsImpl.class);
        return formReportsImpl.getReportSeeds(reportVo);
  
	}
}
