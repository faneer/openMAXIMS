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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2265.41281)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.vo.CareContextLiteVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.therapies.domain.base.impl.BaseGaitImpl;
import ims.therapies.treatment.domain.objects.Gait;
import ims.therapies.vo.GaitShortVoCollection;
import ims.therapies.vo.GaitVoCollection;
import ims.therapies.vo.domain.GaitShortVoAssembler;
import ims.therapies.vo.domain.GaitVoAssembler;

public class GaitImpl extends BaseGaitImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* listMedics
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

	/**
	* save Gait
	*/
	public ims.therapies.vo.GaitVo save(ims.therapies.vo.GaitVo voGait) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(!voGait.isValidated())
			throw new DomainRuntimeException("This Gait record has not been validated");
	
		DomainFactory factory = getDomainFactory();
		Gait doGait = GaitVoAssembler.extractGait(factory, voGait);
		factory.save(doGait);
				
		return GaitVoAssembler.create(doGait);
	}

	/**
	* get gait
	*/
	public ims.therapies.vo.GaitVo getGait(ims.core.vo.ClinicalContactShortVo voClinicalContact)
	{
		if (voClinicalContact == null)
			throw new RuntimeException("Cannot get GaitVo for null ClinicalContactShortVo");

		StringBuffer hql = new StringBuffer("from Gait as g1_1 where g1_1.clinicalContact.id = :CCID and g1_1.isRIE is null");

		List list = getDomainFactory().find(hql.toString(), "CCID", voClinicalContact.getID_ClinicalContact());

		if (list == null || list.size() == 0)
			return null;
		else if (list.size() > 1)
			throw new RuntimeException("More than one Gait Treatment found for the current Clinical Contact");

		GaitVoCollection voColl = GaitVoAssembler.createGaitVoCollectionFromGait(list);
		if (voColl.size() > 0)
			return voColl.get(0);

		return null;
	}

	/**
	* list By ClinicalContact
	*/
	public GaitShortVoCollection listByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from Gait ga ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " ga.clinicalContact.careContext.id = :cc");
			markers.add("cc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List gaitList = factory.find(query,markers,values);
		GaitShortVoCollection voGaitParColl = GaitShortVoAssembler.createGaitShortVoCollectionFromGait(gaitList);
		if(voGaitParColl.size()>0)
			return voGaitParColl;
		else
			return null;
	}
}
