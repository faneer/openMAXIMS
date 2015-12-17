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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.17 build 40519.1300)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.core.admin.vo.CareContextRefVo;

import ims.domain.impl.DomainImpl;
import ims.domain.DomainFactory;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.AssessmentOverview;
import ims.nursing.vo.domain.AssessmentComponentAssembler;
import ims.nursing.vo.domain.AssessmentHeaderInfoAssembler;
import ims.nursing.vo.domain.AssessmentOverviewAssembler;
import ims.nursing.assessment.domain.objects.AdmissionAssessment;
import ims.nursing.assessment.vo.AssessmentComponentRefVo;


public class AdmissionAssessOverviewImpl extends DomainImpl implements ims.nursing.domain.AdmissionAssessOverview, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssessmentOverview getAssessmentDetailsByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from AdmissionAssessment t ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		String andStr = " ";

		if (voCareContextRef != null)
		{
			hql.append(andStr + " t.careContext.id = :rcc");
			markers.add("rcc");
			values.add(voCareContextRef.getID_CareContext());
			andStr = " and ";
			hql.append(andStr + " t.isRIE is null");
		}

		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		
		List assessmentList = factory.find(query, markers, values);		
		
		if (assessmentList != null && assessmentList.size() > 0) 
		{
			AssessmentOverview voAssmnt = AssessmentOverviewAssembler.create((AdmissionAssessment) assessmentList.get(0));
			return voAssmnt;
		}
		else
		{
			return null;
		}
	}

	public AssessmentHeaderInfo getAssessmentHeaderInfoByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from AdmissionAssessment t ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		String andStr = " ";

		if (voCareContextRef != null)
		{
			hql.append(andStr + " t.careContext.id = :care");
			markers.add("care");
			values.add(voCareContextRef.getID_CareContext());
			andStr = " and ";
			hql.append(andStr + " t.isRIE is null");
		}

		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		List headerInfoList = factory.find(query, markers, values);	
		if (headerInfoList != null && headerInfoList.size() > 0) 
		{
			AssessmentHeaderInfo voAssmnt = AssessmentHeaderInfoAssembler.create((AdmissionAssessment) headerInfoList.get(0));
			return voAssmnt;
		}
		else
			return null;
	}

	public AssessmentComponent getComponent(AssessmentComponentRefVo assessCompRefVo)
	{
		DomainFactory factory = getDomainFactory();		
		ims.nursing.assessment.domain.objects.AssessmentComponent comp = (ims.nursing.assessment.domain.objects.AssessmentComponent)factory.getDomainObject(ims.nursing.assessment.domain.objects.AssessmentComponent.class, assessCompRefVo.getID_AssessmentComponent());
		return AssessmentComponentAssembler.create(comp);
	}


}
