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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2420.16410)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.helper.Keywords;
import ims.core.charting.domain.objects.ChartType;
import ims.core.domain.base.impl.BaseChartTypeDetailsImpl;
import ims.core.vo.domain.ChartTypeVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;

public class ChartTypeDetailsImpl extends BaseChartTypeDetailsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* getChartType
	*/
	public ims.core.vo.ChartTypeVo getChartType(ims.core.charting.vo.ChartTypeRefVo refObj)
	{
		return ChartTypeVoAssembler.create((ChartType) getDomainFactory().getDomainObject(ChartType.class, refObj.getID_ChartType()));
	}

	/**
	* saveChartType
	*/
	public ims.core.vo.ChartTypeVo saveChartType(ims.core.vo.ChartTypeVo recordVo) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException 
	{
		if (!recordVo.isValidated())
			throw new DomainRuntimeException("ChartTypeVo record has not been validated");
		
		DomainFactory factory = getDomainFactory();
		ChartType bo = ChartTypeVoAssembler.extractChartType(factory, recordVo);
		
		try
		{
			factory.save(bo);
		}
		catch (UnqViolationUncheckedException e)
		{			
			throw new UniqueKeyViolationException(e);
		}

		return ChartTypeVoAssembler.create(bo);
	}
}
