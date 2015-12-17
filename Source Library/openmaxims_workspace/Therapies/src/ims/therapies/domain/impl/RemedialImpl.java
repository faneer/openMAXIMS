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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.42 build 2207.27783)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.therapies.domain.base.impl.BaseRemedialImpl;
import ims.therapies.treatment.domain.objects.Remedial;
import ims.therapies.treatment.vo.RemedialRefVo;
import ims.therapies.vo.RemedialShortVoCollection;
import ims.therapies.vo.RemedialVo;
import ims.therapies.vo.domain.RemedialShortVoAssembler;
import ims.therapies.vo.domain.RemedialVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class RemedialImpl extends BaseRemedialImpl
{
	/**
	* Get the current Remedial record for the Clinical Contact 
	*/
	public ims.therapies.vo.RemedialVo getRemedialVoByClinicalContact(ClinicalContactRefVo voClinicalContactRef)
	{
		//return RemedialVoAssembler.create(Remedial.getRemedialFromClinicalContact(getDomainFactory(), voClinicalContactRef.getID_ClinicalContact()));
		//WDEV-15078
		if(voClinicalContactRef == null || voClinicalContactRef.getID_ClinicalContact()==null )
			throw new CodingRuntimeException("Can not get RemedialVo value on null ClinicalContact.");
		
		
		StringBuffer hql = new StringBuffer();
		hql.append("select remedial from Remedial as remedial ");
		hql.append("where remedial.clinicalContact.id = :clinicalId ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"clinicalId"}, new Object[] {voClinicalContactRef.getID_ClinicalContact()});
		
		if (list!=null && list.size()>0)
		{
			return RemedialVoAssembler.createRemedialVoCollectionFromRemedial(list).get(0);
		}
		return null;
		
	}

	/**
	* list HCPs
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(filter);
	}

	public RemedialVo saveRemedialVo(RemedialVo voRemedial) throws StaleObjectException 
	{
		// Ensure the value object has been validated
		if (!voRemedial.isValidated())
			throw new DomainRuntimeException("Remedial has not been validated");
		
		DomainFactory factory = getDomainFactory();
		Remedial doRemedial = RemedialVoAssembler.extractRemedial(factory, voRemedial);
	
		factory.save(doRemedial);

		return RemedialVoAssembler.create(doRemedial);
	}

	public RemedialShortVoCollection listRemedialByCareContext(CareContextRefVo voCareContextRef)
	{
		if (voCareContextRef == null)
			throw new DomainRuntimeException("CareContextRefVo is null");
			
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from Remedial r ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" r.clinicalContact.careContext.id = :cc");
		markers.add("cc");
		values.add(voCareContextRef.getID_CareContext());
		
		if (markers.size() > 0) 
			query += " where ";
		
		query += hql.toString();	
		
		List remedial = factory.find(query,markers,values);
		RemedialShortVoCollection voRemedialColl = RemedialShortVoAssembler.createRemedialShortVoCollectionFromRemedial(remedial);
		//WDEV-15078
		//if(voRemedialColl.size() > 0)
			return voRemedialColl;
		//else
			//return null;	
	}

	//WDEV-15078
	public Boolean existRemedialForClinicalContact(ClinicalContactRefVo clinicalContactRef)
	{
		if (clinicalContactRef == null || clinicalContactRef.getID_ClinicalContact() == null)
		{
			throw new CodingRuntimeException("Cannot get Remedial on null Id for ClinicalContact ");
		}

		StringBuffer hql = new StringBuffer();
		hql.append("select count(remedial.id) from Remedial as remedial ");
		hql.append("where (remedial.clinicalContact.id = :clinicalId and (remedial.isRIE is null or remedial.isRIE = 0)) ");
		
		DomainFactory factory = getDomainFactory();
		Object[] count = factory.find(hql.toString(), new String[] {"clinicalId"}, new Object[] {clinicalContactRef.getID_ClinicalContact()}).toArray();
		
		if (count != null && count.length > 0)
			if (((Long) count[0]).intValue() > 0)
				return true;

		return false;
	}

	public RemedialVo getRemedial(RemedialRefVo remedialRef)
	{
		if (remedialRef==null || remedialRef.getID_Remedial()==null)
		{
			throw new CodingRuntimeException("Cannot get Remedial on null Id for Remedial ");
		}
		DomainFactory factory = getDomainFactory();
		Remedial domainRemedial = (Remedial)factory.getDomainObject(Remedial.class, remedialRef.getID_Remedial());
		
		return RemedialVoAssembler.create(domainRemedial);
		
	}

}
