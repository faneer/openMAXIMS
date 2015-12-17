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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41206.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import ims.domain.exceptions.StaleObjectException;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.domain.impl.SkinBodyChartImpl;
import ims.spinalinjuries.domain.NurAssessmentSkin;

public class SkinBodyChartSpinalImpl extends SkinBodyChartImpl implements ims.nursing.domain.SkinBodyChart, ims.domain.impl.Transactional
{
	protected AssessmentHeaderInfo saveAssessmentComponent(AssessmentHeaderInfo assessment,AssessmentComponent component) throws StaleObjectException 
	{
		NurAssessmentSkin componentImpl = (NurAssessmentSkin)getDomainImpl(NurAssessmentComponentImpl.class);
		return (componentImpl.saveComponent(assessment, component));
	}
}
