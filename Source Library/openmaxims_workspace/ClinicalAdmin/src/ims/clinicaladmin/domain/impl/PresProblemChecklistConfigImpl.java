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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2287.24499)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.List;

import ims.admin.domain.impl.ServiceImpl;
import ims.clinical.configuration.domain.objects.PresProblemChecklistConfig;
import ims.clinicaladmin.domain.base.impl.BasePresProblemChecklistConfigImpl;
import ims.clinicaladmin.vo.PresProblemChecklistConfigShortVoCollection;
import ims.clinicaladmin.vo.PresProblemChecklistConfigVo;
import ims.clinicaladmin.vo.domain.PresProblemChecklistConfigShortVoAssembler;
import ims.clinicaladmin.vo.domain.PresProblemChecklistConfigVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class PresProblemChecklistConfigImpl extends BasePresProblemChecklistConfigImpl
{

	/**
	* getPMHCheckListConfig
	*/
	public PresProblemChecklistConfigVo getPresProblemCheckListConfig(ims.clinical.configuration.vo.PresProblemChecklistConfigRefVo voRef)
	{
		DomainFactory factory = getDomainFactory();
		PresProblemChecklistConfig domPresProblemChecklistConfig =  (PresProblemChecklistConfig) factory.getDomainObject(PresProblemChecklistConfig.class, voRef.getID_PresProblemChecklistConfig());
		return PresProblemChecklistConfigVoAssembler.create(domPresProblemChecklistConfig);
	}

	/**
	* savePMHCheckListConfig
	*/
	public PresProblemChecklistConfigVo savePresProblemCheckListConfig(PresProblemChecklistConfigVo item) throws ims.domain.exceptions.StaleObjectException
	{
		if(item == null)
			throw new DomainRuntimeException("Invalid presenting problem checklist config record to save");		
		if(!item.isValidated())
			throw new DomainRuntimeException("Presenting problem checklist config record not validated");

		DomainFactory factory = getDomainFactory();
		PresProblemChecklistConfig domPresProblemConfig = PresProblemChecklistConfigVoAssembler.extractPresProblemChecklistConfig(factory,item);
		factory.save(domPresProblemConfig);
		
		return PresProblemChecklistConfigVoAssembler.create(domPresProblemConfig);
	}


	/**
	* List all services
	*/
	public ims.core.vo.ServiceVoCollection listService(Boolean activeOnly)
	{
		ims.admin.domain.Service impl = (ims.admin.domain.Service) getDomainImpl(ServiceImpl.class);
		ims.core.vo.ServiceShortVo filter = new ims.core.vo.ServiceShortVo();
		filter.setIsActive(activeOnly);
		return impl.listService(filter);
	}



	public PresProblemChecklistConfigShortVoCollection listPresProblemCheckListShort() 
	{
		DomainFactory factory = getDomainFactory(); 
		List lstProbs = factory.find("from PresProblemChecklistConfig");
		return PresProblemChecklistConfigShortVoAssembler.createPresProblemChecklistConfigShortVoCollectionFromPresProblemChecklistConfig(lstProbs).sort();
	}



		
}
