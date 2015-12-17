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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2418.19363)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;

import ims.core.domain.base.impl.BaseDataSetTypeImpl;
import ims.core.vo.domain.DataSetTypeVoAssembler;
import ims.domain.DomainFactory;

public class DataSetTypeImpl extends BaseDataSetTypeImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listDataSetType
	*/
	public ims.core.vo.DataSetTypeVoCollection listDataSetType(String name, ims.core.vo.lookups.DataSetCategory category, Boolean active)
	{
		//String hql = "from DatasetType as d1_1 where (d1_1.name like :NAME and d1_1.category.id = :CATEGORY)";
		
		DomainFactory factory = getDomainFactory();
		
		String hql = " from DatasetType as d1_1 "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(name != null)
		{	
			condStr.append(andStr + " upper(d1_1.name) like upper(:NAME)"); 
			markers.add("NAME");
			values.add(name);
			andStr = " and ";
		}

		if(category != null)
		{	
			condStr.append(andStr + " d1_1.category.id = :CATEGORY"); 
			markers.add("CATEGORY");
			values.add(new Integer(category.getId()));
			andStr = " and ";
		}

		if(active != null)
		{	
			condStr.append(andStr + " d1_1.isActive = :ACTIVE"); 
			markers.add("ACTIVE");
			values.add(active);
			andStr = " and ";
		}
		
		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();

		return DataSetTypeVoAssembler.createDataSetTypeVoCollectionFromDatasetType(
				factory.find(hql, markers, values)).sort();
	}
}
