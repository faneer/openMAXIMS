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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.34 build 2083.15190)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.LookupTree;
import ims.admin.domain.impl.LookupTreeImpl;
import ims.core.clinical.domain.objects.QuestionInformation;
import ims.vo.LookupInstVo;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupTypeVo;
import ims.core.vo.domain.QuestionInformationVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;

public class QuestionAnswerImpl extends DomainImpl implements ims.core.domain.QuestionAnswer, ims.domain.impl.Transactional
{
	public ims.core.vo.QuestionInformationVo saveQuestion(ims.core.vo.QuestionInformationVo questionInfo) throws StaleObjectException
	{
		if(!questionInfo.isValidated())
			throw new DomainRuntimeException("QuestionInformationVo not validated");
					
		DomainFactory factory = getDomainFactory();
		QuestionInformation doQuestionInfo = QuestionInformationVoAssembler.extractQuestionInformation(factory, questionInfo);
		factory.save(doQuestionInfo);
		
		return QuestionInformationVoAssembler.create(doQuestionInfo);
	}

	public LookupInstanceCollection saveLookupInstance(LookupTypeVo type, LookupInstVo instance) throws DomainInterfaceException, StaleObjectException 
	{
		LookupTree domainLookupTree = (LookupTree) getDomainImpl(LookupTreeImpl.class);
		return domainLookupTree.saveLookupInstance(type, instance);
	}

	public LookupInstVo deactivateInstance(LookupTypeVo type, LookupInstVo voInstance) throws StaleObjectException 
	{
		LookupTree domainLookupTree = (LookupTree) getDomainImpl(LookupTreeImpl.class);
		return domainLookupTree.deactivateInstance(type, voInstance);
	}


	public LookupInstanceCollection getLookupInstances(LookupTypeVo type) 
	{
		LookupTree domainLookupTree = (LookupTree) getDomainImpl(LookupTreeImpl.class);
		return domainLookupTree.getLookupInstances(type);
	}
}
