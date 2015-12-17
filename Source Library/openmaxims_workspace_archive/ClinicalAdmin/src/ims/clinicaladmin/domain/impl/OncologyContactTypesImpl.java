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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3847.19721)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.ArrayList;

import ims.clinicaladmin.domain.base.impl.BaseOncologyContactTypesImpl;
import ims.core.vo.domain.CustomListVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.oncology.domain.objects.ContactTypesByDiscipline;
import ims.oncology.vo.domain.ContactTypesByDisciplineVoAssembler;

public class OncologyContactTypesImpl extends BaseOncologyContactTypesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.ContactTypesByDisciplineVo getContactTypeByDiscipline(ims.oncology.vo.ContactTypesByDisciplineRefVo voTypeRef)
	{
		DomainFactory factory = getDomainFactory();
		return ContactTypesByDisciplineVoAssembler.create((ContactTypesByDiscipline)factory.getDomainObject((ContactTypesByDiscipline.class), voTypeRef.getID_ContactTypesByDiscipline()));
	}

	public ims.oncology.vo.ContactTypesByDisciplineVo saveContactTypeByDiscipline(ims.oncology.vo.ContactTypesByDisciplineVo voContact) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if (!voContact.isValidated())
			throw new CodingRuntimeException("ContactTypesByDiscipline has not been validated");
		if(voContact == null)
			throw new CodingRuntimeException("Cannot save null ContactTypesByDiscipline");
		
		DomainFactory factory = getDomainFactory();
		
		ContactTypesByDiscipline doCC = ContactTypesByDisciplineVoAssembler.extractContactTypesByDiscipline(factory, voContact);
		factory.save(doCC);
		return (ContactTypesByDisciplineVoAssembler.create(doCC));		
	}

	public ims.oncology.vo.ContactTypesByDisciplineVoCollection listContactTypesByDiscipline()
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = " from ContactTypesByDiscipline "; 
		return ContactTypesByDisciplineVoAssembler.createContactTypesByDisciplineVoCollectionFromContactTypesByDiscipline(factory.find(hql,3000));
	}
}
