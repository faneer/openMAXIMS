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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.domain.base.impl.BaseUserDefinedFormSearchImpl;
import ims.assessment.domain.GraphicAssessments;
import ims.assessment.domain.UserAssessmentNew;
import ims.assessment.domain.UserAssessments;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.assessment.vo.GraphicAssessmentVo;
import ims.assessment.vo.UserAssessmentShortVoCollection;
import ims.assessment.vo.UserAssessmentVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentTypeCollection;
public class UserDefinedFormSearchImpl extends BaseUserDefinedFormSearchImpl
{
	/**
	* listAssessments
	*/
	public UserAssessmentShortVoCollection listAssessments(String name, ims.core.vo.lookups.PreActiveActiveInactiveStatus status, UserDefinedAssessmentTypeCollection types)
	{
		UserAssessments domainImpl = (UserAssessments) getDomainImpl(UserAssessmentsImpl.class);
		return domainImpl.listAssessments(name, null, types, status);
	}

	public UserAssessmentVo getUserAssessment(Integer id)
	{
		UserAssessmentNew domainImpl = (UserAssessmentNew) getDomainImpl(UserAssessmentNewImpl.class);
		return domainImpl.getAssessment(id);
	}

	public GraphicAssessmentShortVoCollection listGraphicAssessments(String name, ims.core.vo.lookups.PreActiveActiveInactiveStatus status,  ims.core.vo.lookups.UserDefinedAssessmentType type)
	{
		GraphicAssessments domainImpl = (GraphicAssessments) getDomainImpl(GraphicAssessmentsImpl.class);
		return domainImpl.listAssessments(name, status, type);
	}

	public GraphicAssessmentVo getGraphicAssessment(Integer id)
	{
		GraphicAssessments domainImpl = (GraphicAssessments) getDomainImpl(GraphicAssessmentsImpl.class);
		return domainImpl.getGraphicAssessment(id);
	}

	public GraphicAssessmentShortVoCollection listGraphicAssessments(String name, PreActiveActiveInactiveStatus status, UserDefinedAssessmentTypeCollection types)
	{
		GraphicAssessments domainImpl = (GraphicAssessments) getDomainImpl(GraphicAssessmentsImpl.class);
		return domainImpl.listAssessments(name, status, types);
	}
}
