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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.22 build 41222.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.vo.Hcp;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.nursing.careplans.domain.objects.CarePlanEvaluationNote;
import ims.nursing.domain.CarePlanDetails;
import ims.nursing.domain.CarePlanStep2;
import ims.nursing.vo.CarePlan;
import ims.nursing.vo.domain.CarePlanEvaluationNoteAssembler;

public class CarePlanEvaluationImpl extends DomainImpl implements ims.nursing.domain.CarePlanEvaluation, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter filter)
	{
		CarePlanStep2 impl = (CarePlanStep2)getDomainImpl(CarePlanStep2Impl.class);
		return impl.listMedics(filter);
	}

	public Hcp getHcp(HcpFilter filter) 
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.getHcp(filter);
	}

	public ims.nursing.vo.CarePlanEvaluationNote saveEvaluationNote(ims.nursing.vo.CarePlanEvaluationNote evaluationNoteVo) throws StaleObjectException 
	{
		if(evaluationNoteVo == null)
			throw new CodingRuntimeException("Mandatory arguments not supplied to saveEvaluationNote method");

		if (!evaluationNoteVo.isValidated())
			throw new DomainRuntimeException("Evaluation Note has not been validated");
		
		DomainFactory factory = getDomainFactory();
		CarePlanEvaluationNote domCarePlanEval = CarePlanEvaluationNoteAssembler.extractCarePlanEvaluationNote(factory,evaluationNoteVo);
		factory.save(domCarePlanEval);
		return CarePlanEvaluationNoteAssembler.create(domCarePlanEval);					
	}

	public CarePlan saveCarePlan(CarePlan carePlan) throws StaleObjectException
	{
		CarePlanDetails impl = (CarePlanDetails) getDomainImpl(CarePlanDetailsImpl.class);
		return impl.saveCarePlan(carePlan);
	}
}
