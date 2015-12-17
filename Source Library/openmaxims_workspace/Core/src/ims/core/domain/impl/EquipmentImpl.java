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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.22 build 50216.1545)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.domain.objects.ClinicalContact;
import ims.core.resource.equipment.domain.objects.Equipment;
import ims.core.resource.equipment.vo.EquipmentRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalContactVo;
import ims.core.vo.EquipmentVo;
import ims.core.vo.EquipmentVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.ClinicalContactVoAssembler;
import ims.core.vo.domain.EquipmentVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;

public class EquipmentImpl extends DomainImpl implements ims.core.domain.Equipment, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* List of Hcps
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(filter);
	}

	public EquipmentVo saveEquipmentDetails(EquipmentVo equipment) throws DomainInterfaceException, StaleObjectException 
	{
		if (!equipment.isValidated())
		{
			throw new DomainRuntimeException("Equipment has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		
		Equipment doEquipment = EquipmentVoAssembler.extractEquipment(factory, equipment);
		
		factory.save(doEquipment);
		return EquipmentVoAssembler.create(doEquipment);
	}


	public EquipmentVoCollection listEquipment(PatientShort voPrisoner, Boolean activeOnly) 
	{
		if (voPrisoner == null)
			throw new RuntimeException("Cannot get EquipmentVoCollection for null patient");

		DomainFactory factory = getDomainFactory();
		
		ArrayList<String> params = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "from Equipment eq where eq.careContext.episodeOfCare.careSpell.patient.id = :patientId";
		
		params.add("patientId");
		values.add(voPrisoner.getID_Patient());
		
		if (Boolean.TRUE.equals(activeOnly))
		{
			hql += " and (eq.inactive = :inactive or eq.inactive is null) ";
			params.add("inactive");
			values.add(Boolean.FALSE);
		}

		List equipList = factory.find(hql, params, values);

		return EquipmentVoAssembler.createEquipmentVoCollectionFromEquipment(equipList);
	}

	public ClinicalContactVo getClinicalContact(ClinicalContactShortVo voClinicalContactShort) 
	{
		if (voClinicalContactShort == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		ClinicalContact domClinicalContact = (ClinicalContact)factory.getDomainObject(ClinicalContact.class,voClinicalContactShort.getID_ClinicalContact());
		ims.core.vo.ClinicalContactVo contactVo = ClinicalContactVoAssembler.create(domClinicalContact); 
		
		return contactVo;
	}

	public EquipmentVoCollection listEquipmentByCareContext(CareContextLiteVo voCareContextLite, Boolean activeOnly) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from Equipment eq ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContextLite.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " eq.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContextLite.getID_CareContext());
			andStr = " and ";
		}
		
		if (Boolean.TRUE.equals(activeOnly))
		{
			hql.append(andStr + " eq.inactive is null ");
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List edList = factory.find(query,markers,values);
		EquipmentVoCollection voEquipmentColl = EquipmentVoAssembler.createEquipmentVoCollectionFromEquipment(edList);
		
		if(voEquipmentColl.size()>0)
			return voEquipmentColl;
		else
			return null;	
		}

	public EquipmentVo getEquipment(EquipmentRefVo equipmentId) 
	{
		if(equipmentId == null || !equipmentId.getID_EquipmentIsNotNull())
			throw new CodingRuntimeException("Can not get Equipment on null Id.");
		
		return EquipmentVoAssembler.create((Equipment) getDomainFactory().getDomainObject(Equipment.class, equipmentId.getID_Equipment()));
	}
}
