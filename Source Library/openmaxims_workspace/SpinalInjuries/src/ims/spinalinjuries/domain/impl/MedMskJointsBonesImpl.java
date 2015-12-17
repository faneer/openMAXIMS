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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.23 build 50316.1400)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.
// 22/03/2005 - Add a problem (MedicalProbOnAdmisVo)
// 31/03/2005 - Listing & Saving depending on Medical Contact
package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.medical.domain.objects.MskExamJointBones;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.PatientProblem;
import ims.core.domain.BoneJointConfiguration;
import ims.core.domain.impl.MuscleJointConfigurationImpl;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MskGroupVoCollection;
import ims.core.vo.lookups.ContactType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.generalmedical.vo.MskBoneJointShortVo;
import ims.generalmedical.vo.MskBoneJointShortVoCollection;
import ims.generalmedical.vo.MskBoneJointVo;
import ims.generalmedical.vo.MskBoneJointVoCollection;
import ims.generalmedical.vo.domain.MedicalProbOnAdmisVoAssembler;
import ims.generalmedical.vo.domain.MskBoneJointShortVoAssembler;
import ims.generalmedical.vo.domain.MskBoneJointVoAssembler;

public class MedMskJointsBonesImpl extends DomainImpl implements ims.spinalinjuries.domain.MedMskJointsBones, ims.domain.impl.Transactional
{
	/**
	 * list the Bones & Joints
	 */
	public MskBoneJointVo getBoneJointsRecords(ClinicalContactShortVo contact, MskBoneJointShortVo voMskBoneJoint) 
	{
		DomainFactory factory = getDomainFactory();
		
		if(voMskBoneJoint != null)
		{
			return MskBoneJointVoAssembler.create((MskExamJointBones) getDomainFactory().getDomainObject(MskExamJointBones.class,voMskBoneJoint.getID_MskExamJointBones()));
		}
		else
		{
			String hql = " from MskExamJointBones mejb "; 
			StringBuffer condStr = new StringBuffer();
			String andStr = " ";
		
			ArrayList markers = new ArrayList();
			ArrayList values = new ArrayList();
		
			if(contact.getID_ClinicalContactIsNotNull())
			{
				condStr.append(andStr + " mejb.clinicalContact.id = :id_ClinicalContact"); 
				markers.add("id_ClinicalContact");
				values.add(contact.getID_ClinicalContact());
				andStr = " and ";
			}	
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			MskBoneJointVoCollection voMskBoneJointVoColl = MskBoneJointVoAssembler.createMskBoneJointVoCollectionFromMskExamJointBones(factory.find(hql, markers, values));
			if(voMskBoneJointVoColl.size()>0)
			{
				voMskBoneJointVoColl.sort(SortOrder.DESCENDING);
				return voMskBoneJointVoColl.get(0);
			}
			else
				return null;
		}
		
	}
	
	/**
	* saves the Bone and Joints
	*/
	public MskBoneJointVo saveBoneJointsRecord(MskBoneJointVo boneJointVo) throws StaleObjectException
	{
		if (boneJointVo.isValidated() == false)
			throw new DomainRuntimeException("Bones and Joints have not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		if(boneJointVo.getJointBoneDetailIsNotNull())
		{
			for(int z=0; z< boneJointVo.getJointBoneDetail().size(); z++)
			{
				if(boneJointVo.getJointBoneDetail().get(z).getProblemIsNotNull())
				{
					PatientProblem doMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.extractPatientProblem(factory, boneJointVo.getJointBoneDetail().get(z).getProblem());
					
					factory.save(doMedicalProbOnAdmis);
				}
			}
		}
		MskExamJointBones boExamJointBones = MskBoneJointVoAssembler.extractMskExamJointBones(factory, boneJointVo);
		
		factory.save(boExamJointBones);

		boneJointVo = MskBoneJointVoAssembler.create(boExamJointBones);
		
		return boneJointVo;
	}

	/** 
	 * list the configured groups 
	 */
	public MskGroupVoCollection listMskGroup(Boolean activeOnly) 
	{
		BoneJointConfiguration impl = (BoneJointConfiguration) getDomainImpl(MuscleJointConfigurationImpl.class);
		return impl.listMskGroup(activeOnly);
	}

	/** 
	 * returns all Joint/Bone records from the rootClinicalContact (for recordBrowser)
	 */
	public MskBoneJointShortVoCollection listByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = " from MskExamJointBones mejb "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voCareContext != null)
		{
			condStr.append(andStr + " mejb.careContext.id = :cc"); 
			markers.add("cc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		List mskJointBone = factory.find(hql,markers,values);
		MskBoneJointShortVoCollection voBoneJointShortColl = MskBoneJointShortVoAssembler.createMskBoneJointShortVoCollectionFromMskExamJointBones(mskJointBone);
		if(voBoneJointShortColl != null)
			return voBoneJointShortColl.sort(SortOrder.DESCENDING);
		else	
			return null;
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}

	public MskBoneJointVo getBoneJointByCareContext(CareContextLiteVo voCareContext, MskBoneJointShortVo voBoneJointShort)
	{
		DomainFactory factory = getDomainFactory();
		
		if(voBoneJointShort != null)
		{
			return MskBoneJointVoAssembler.create((MskExamJointBones) getDomainFactory().getDomainObject(MskExamJointBones.class,voBoneJointShort.getID_MskExamJointBones()));
		}
		else
		{
			String hql = " from MskExamJointBones mejb "; 
			StringBuffer condStr = new StringBuffer();
			String andStr = " ";
		
			ArrayList markers = new ArrayList();
			ArrayList values = new ArrayList();
		
			if(voCareContext.getID_CareContextIsNotNull())
			{
				condStr.append(andStr + " mejb.careContext.id = :id"); 
				markers.add("id");
				values.add(voCareContext.getID_CareContext());
				andStr = " and ";
			}	
			
			condStr.append(andStr + " mejb.clinicalContact.id is null");
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			MskBoneJointVoCollection voMskBoneJointVoColl = MskBoneJointVoAssembler.createMskBoneJointVoCollectionFromMskExamJointBones(factory.find(hql, markers, values));
			if(voMskBoneJointVoColl.size()>0)
			{
				voMskBoneJointVoColl.sort(SortOrder.DESCENDING);
				return voMskBoneJointVoColl.get(0);
			}
			else
				return null;
		}
	}

	public MskBoneJointVo getMedicalAdmissionJointByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
		
		List jointBone =   factory.find(" from MskExamJointBones jb where jb.clinicalContact.id = " + 
				"( select cons.id from CareContext con join con.clinicalContacts cons where cons.contactType = :type and con.id = :idcare)",
				new String[]{"type", "idcare" },
				new Object[]{ getDomLookup(ContactType.SPINALMEDICALADMISSION),voCareContextRef.getID_CareContext()});
		
		MskBoneJointVoCollection voMskBoneJointVoColl = MskBoneJointVoAssembler.createMskBoneJointVoCollectionFromMskExamJointBones(jointBone);
		if(voMskBoneJointVoColl.size()>0)
		{
			voMskBoneJointVoColl.sort(SortOrder.DESCENDING);
			return voMskBoneJointVoColl.get(0);
		}
		else
			return null;
	}

	public MskBoneJointShortVoCollection listByEpisodeOfCare(EpisodeOfCareRefVo voEpisodeOfCareRef)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = " from MskExamJointBones mejb "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voEpisodeOfCareRef != null)
		{
			condStr.append(andStr + " mejb.careContext.episodeOfCare.id = :eoc"); 
			markers.add("eoc");
			values.add(voEpisodeOfCareRef.getID_EpisodeOfCare());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		List mskJointBone = factory.find(hql,markers,values);
		MskBoneJointShortVoCollection voBoneJointShortColl = MskBoneJointShortVoAssembler.createMskBoneJointShortVoCollectionFromMskExamJointBones(mskJointBone);
		if(voBoneJointShortColl != null)
			return voBoneJointShortColl.sort(SortOrder.DESCENDING);
		else	
			return null;
	}
}
