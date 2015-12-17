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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BasePrognosticLocationConfigImpl;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.oncology.configuration.domain.objects.PrognosticLocationConfig;
import ims.oncology.vo.domain.PrognosticLocationConfigVoAssembler;

public class PrognosticLocationConfigImpl extends BasePrognosticLocationConfigImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.PrognosticLocationConfigVoCollection list()
	{
		return PrognosticLocationConfigVoAssembler.createPrognosticLocationConfigVoCollectionFromPrognosticLocationConfig(getDomainFactory().find("from PrognosticLocationConfig as plc order by plc.locationName asc"));
	}

	public ims.oncology.vo.PrognosticLocationConfigVo get(ims.oncology.configuration.vo.PrognosticLocationConfigRefVo record)
	{
		if(record == null || record.getID_PrognosticLocationConfig() == null)
			return null;
		
		return PrognosticLocationConfigVoAssembler.create((PrognosticLocationConfig) getDomainFactory().getDomainObject(PrognosticLocationConfig.class, record.getID_PrognosticLocationConfig()));
	}

	public ims.oncology.vo.PrognosticLocationConfigVo save(ims.oncology.vo.PrognosticLocationConfigVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(record == null)
			throw new CodingRuntimeException("Can not save a null PrognosticLocationConfigVo");
		
		if(!record.isValidated())
			throw new CodingRuntimeException("PrognosticLocationConfigVo must be validated before save.");
		
		DomainFactory factory = getDomainFactory();
		PrognosticLocationConfig doRecord = PrognosticLocationConfigVoAssembler.extractPrognosticLocationConfig(factory, record);
		
		factory.save(doRecord);
		
		return PrognosticLocationConfigVoAssembler.create(doRecord);
	}
}
