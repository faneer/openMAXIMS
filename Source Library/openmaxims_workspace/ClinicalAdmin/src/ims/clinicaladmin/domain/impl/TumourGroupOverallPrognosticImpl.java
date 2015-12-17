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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4076.22135)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseTumourGroupOverallPrognosticImpl;
import ims.clinicaladmin.vo.OverallPrognosticGroupingVo;
import ims.clinicaladmin.vo.OverallPrognosticGroupingVoCollection;
import ims.clinicaladmin.vo.domain.OverallPrognosticGroupingVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.oncology.configuration.domain.objects.PrognosticGrouping;
import ims.oncology.configuration.vo.TumourGroupRefVo;

import java.util.ArrayList;

public class TumourGroupOverallPrognosticImpl extends BaseTumourGroupOverallPrognosticImpl
{

	private static final long serialVersionUID = 1L;

	public OverallPrognosticGroupingVoCollection listOverallPrognostic(TumourGroupRefVo tumourGroup)
	{
		if (tumourGroup == null || !tumourGroup.getID_TumourGroupIsNotNull())
			return null;
		
		String query = "select overall from PrognosticGrouping as overall left join overall.tGroup as group where group.id = :GROUP_ID";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("GROUP_ID");
		paramValues.add(tumourGroup.getID_TumourGroup());
		
		return OverallPrognosticGroupingVoAssembler.createOverallPrognosticGroupingVoCollectionFromPrognosticGrouping(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	public OverallPrognosticGroupingVoCollection saveOverall(OverallPrognosticGroupingVoCollection overallPrognostic) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (overallPrognostic == null)
			throw new DomainInterfaceException("Can not save empty records");
		
		OverallPrognosticGroupingVoCollection returnCollection = new OverallPrognosticGroupingVoCollection();
		
		
		for (OverallPrognosticGroupingVo overall : overallPrognostic)
		{
			if (!overall.isValidated())
				throw new DomainRuntimeException("Record in collection is not validated");
			
			PrognosticGrouping domOverall = OverallPrognosticGroupingVoAssembler.extractPrognosticGrouping(getDomainFactory(), overall);
			
			getDomainFactory().save(domOverall);
			
			returnCollection.add(OverallPrognosticGroupingVoAssembler.create(domOverall));
		}
		
		return returnCollection;
	}
}
