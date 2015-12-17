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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.44 build 2243.21916)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.List;

import ims.spinalinjuries.vo.lookups.MskJointsMovementsCollection;
import ims.therapies.domain.base.impl.BaseRangeOfMovementImpl;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.clinical.vo.MskJointsRefVo;
import ims.core.domain.BoneJointConfiguration;
import ims.core.domain.impl.MuscleJointConfigurationImpl;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.generalmedical.vo.RangeOfMovementJointVoCollection;
import ims.generalmedical.vo.RangeOfMovementVo;
import ims.generalmedical.vo.RangeOfMovementVoCollection;
import ims.generalmedical.vo.domain.RangeOfMovementVoAssembler;
import ims.medical.domain.objects.MskExamJointBones;

public class RangeOfMovementImpl extends BaseRangeOfMovementImpl
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RangeOfMovementVo getRangeOfMovementByClinicalContact(ClinicalContactRefVo clinicalcontact) 
	{
		DomainFactory factory = getDomainFactory();				
		String hql;
		hql = " from MskExamJointBones m where m.clinicalContact.id = " + clinicalcontact.getID_ClinicalContact();
		List lstGroups = factory.find(hql);				

		RangeOfMovementVoCollection voCollRangeOfMovements =  RangeOfMovementVoAssembler.createRangeOfMovementVoCollectionFromMskExamJointBones(lstGroups);
		if (voCollRangeOfMovements.size() == 1)
			return voCollRangeOfMovements.get(0);
		else 
			return null;
		
	}
	
	/**
	* list Medics
	*/
	public HcpCollection listHCPs(HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

	public RangeOfMovementJointVoCollection listJoints() 
	{
		BoneJointConfiguration impl =  (BoneJointConfiguration)getDomainImpl(MuscleJointConfigurationImpl.class);
		return impl.listJoints();
	}
	
	public RangeOfMovementVo save(RangeOfMovementVo voRangeOfMovement) throws StaleObjectException, UniqueKeyViolationException 
	{
		if(!voRangeOfMovement.isValidated())
			throw new DomainRuntimeException("This Range Of Movement has not been validated");
	
		DomainFactory factory = getDomainFactory();
		MskExamJointBones domMskExamJointBones = RangeOfMovementVoAssembler.extractMskExamJointBones(factory, voRangeOfMovement);
		factory.save(domMskExamJointBones);
				
		return RangeOfMovementVoAssembler.create(domMskExamJointBones);						
	}	
	
	public MskJointsMovementsCollection listMovementsForJoint(MskJointsRefVo refJoint) 
	{
		BoneJointConfiguration impl =  (BoneJointConfiguration)getDomainImpl(MuscleJointConfigurationImpl.class);
		return impl.listMovementsForJoint(refJoint);
	}

	public RangeOfMovementVoCollection listRangeOfMovementsForCareContext(CareContextRefVo voRefCareContext) 
	{
		DomainFactory factory = getDomainFactory();				
		String hql = " from MskExamJointBones m where m.careContext.id = " + voRefCareContext.getID_CareContext();
		List lstROMs = factory.find(hql);				
		return RangeOfMovementVoAssembler.createRangeOfMovementVoCollectionFromMskExamJointBones(lstROMs);
	}




}
