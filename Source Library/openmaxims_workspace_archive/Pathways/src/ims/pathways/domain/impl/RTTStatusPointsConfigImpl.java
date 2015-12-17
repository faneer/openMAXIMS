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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.pathways.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.domain.base.impl.BaseRTTStatusPointsConfigImpl;
import ims.pathways.vo.RTTStatusPointVo;
import ims.pathways.vo.RTTStatusPointVoCollection;
import ims.pathways.vo.domain.RTTStatusPointVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class RTTStatusPointsConfigImpl extends BaseRTTStatusPointsConfigImpl
{

	private static final long serialVersionUID = 1L;

	public ims.pathways.vo.RTTStatusPointVoCollection listRTTStatusPoints()
	{
		DomainFactory factory = getDomainFactory();
		String hql = "select rttstat from RTTStatusPoint as rttstat order by rttstat.nationalCode asc";
		List<?> statuspoints = factory.find(hql);
		return RTTStatusPointVoAssembler.createRTTStatusPointVoCollectionFromRTTStatusPoint(statuspoints).sort();
	}

	private  String getDuplicateCodes(ims.pathways.vo.RTTStatusPointVo recVo)
	{
		DomainFactory factory = getDomainFactory();
		String dup ="";

		ArrayList<String> marques = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "select rt from RTTStatusPoint as rt where rt.localCode = :locCode ";

		if (recVo.getID_RTTStatusPoint() != null)
		{
			hql += " and rt.id <> :id ";
			marques.add("id");
			values.add(recVo.getID_RTTStatusPoint());
		}

		marques.add("locCode");
		values.add(recVo.getLocalCode());

		List<?> listDupRecords = factory.find(hql,marques, values);
		RTTStatusPointVoCollection rttStatusPointsColl = RTTStatusPointVoAssembler.createRTTStatusPointVoCollectionFromRTTStatusPoint(listDupRecords);

		if (rttStatusPointsColl != null && rttStatusPointsColl.size()> 0) 
		{		
			dup+= "An existing RTT Status Point record from the system already has a Local Code with value: " + recVo.getLocalCode();
		}

		return dup;
	}	

	public ims.pathways.vo.RTTStatusPointVo getRTTStatusPoint(ims.pathways.configuration.vo.RTTStatusPointRefVo rec)
	{
		if (rec == null || rec.getID_RTTStatusPoint() == null)
		{
			throw new CodingRuntimeException("Cannot get details for a null RTTStatusPointVo reference");
		}
		DomainFactory factory = getDomainFactory();

		RTTStatusPoint domRTTStatusPoint =(RTTStatusPoint) factory.getDomainObject(RTTStatusPoint.class, rec.getID_RTTStatusPoint());

		return RTTStatusPointVoAssembler.create(domRTTStatusPoint);

	}

	public RTTStatusPointVo saveRTTStatusPoint(RTTStatusPointVo record) throws StaleObjectException, UniqueKeyViolationException
	{
		if (record == null)

			throw new CodingRuntimeException("Cannot save a null RTTStatusPointVo Vo.");

		if (!record.isValidated())

			throw new CodingRuntimeException("Cannot save an invalid StatusPointVo Vo." );

		if (getDuplicateCodes(record).length() >0)
			throw new UniqueKeyViolationException(getDuplicateCodes(record));

		DomainFactory factory = getDomainFactory();

		RTTStatusPoint statusPointDO = RTTStatusPointVoAssembler.extractRTTStatusPoint(factory,record);

		factory.save(statusPointDO);

		return RTTStatusPointVoAssembler.create(statusPointDO);
	}
}
