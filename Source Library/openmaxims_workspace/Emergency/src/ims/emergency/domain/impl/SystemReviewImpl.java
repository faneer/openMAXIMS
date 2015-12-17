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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import java.util.List;

import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseSystemReviewImpl;

import ims.emergency.domain.objects.SystemsReview;
import ims.emergency.vo.SystemReviewForPresentingProblemConfigVo;
import ims.emergency.vo.SystemReviewForPresentingProblemConfigVoCollection;
import ims.emergency.vo.SystemReviewVo;
import ims.emergency.vo.SystemReviewVoCollection;
import ims.emergency.vo.SystemsReviewRefVo;
import ims.emergency.vo.domain.SystemReviewForPresentingProblemConfigVoAssembler;
import ims.emergency.vo.domain.SystemReviewVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;


public class SystemReviewImpl extends BaseSystemReviewImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.SystemReviewVoCollection listSystemReview(ims.core.admin.vo.CareContextRefVo attendance)
	{
		
		if( attendance == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select s1_1	from SystemsReview as s1_1 left join s1_1.attendance as c1_1 where	(c1_1.id = :idcareContext) order by s1_1.systemInformation.creationDateTime desc ";
	
		List systemrev = factory.find(hsql, new String[] {"idcareContext"}, new Object[] {attendance.getID_CareContext()});
		if( systemrev != null && systemrev.size() > 0)
			return SystemReviewVoAssembler.createSystemReviewVoCollectionFromSystemsReview(systemrev);
		
		return null;
	}

	
	public SystemReviewVo getSystemReview(SystemsReviewRefVo record) 
	{
		if(	record == null )
			throw new CodingRuntimeException("SystemsReviewVo not provided");
		
		DomainFactory factory = getDomainFactory();
		SystemsReview doSystemsReview  =(SystemsReview) factory.getDomainObject(SystemsReview.class, record.getID_SystemsReview());
		return SystemReviewVoAssembler.create(doSystemsReview);
	}

    //WDEV-17118
	public SystemReviewVoCollection getAllActiveSystemNotes(CareContextRefVo attendance)
	{
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select sys from SystemsReview as sys left join sys.attendance as att where (att.id = :idcareContext) and (sys.isRIE is null or sys.isRIE = 0) and (sys.isCorrected is null or sys.isCorrected = 0)";
	
		List systemrev = factory.find(hsql, new String[] {"idcareContext"}, new Object[] {attendance.getID_CareContext()});
		
		if(systemrev != null && systemrev.size() > 0)
			return SystemReviewVoAssembler.createSystemReviewVoCollectionFromSystemsReview(systemrev);
		
		return null;
	}


	public SystemReviewForPresentingProblemConfigVo getSystemReviewForPresentingProblem(ClinicalProblemRefVo problemRef)
	{
		if( problemRef == null )
			throw new CodingRuntimeException("Cannot get clinicalprobelmRef");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select s1_1	from SystemReviewForPresentingProblemConfig as s1_1 left join s1_1.problem as c1_1	where  (c1_1.id = :idproblem)";
	
		List systemrev = factory.find(hsql, new String[] {"idproblem"}, new Object[] {problemRef.getID_ClinicalProblem()});
		
		if(	systemrev != null && systemrev.size() > 0)
		{
			SystemReviewForPresentingProblemConfigVoCollection tempColl = SystemReviewForPresentingProblemConfigVoAssembler.createSystemReviewForPresentingProblemConfigVoCollectionFromSystemReviewForPresentingProblemConfig(systemrev);
			
			if(	tempColl != null && tempColl.size() > 0)
			{
				return tempColl.get(0);
			}
		}
		
		return null;
	}
}
