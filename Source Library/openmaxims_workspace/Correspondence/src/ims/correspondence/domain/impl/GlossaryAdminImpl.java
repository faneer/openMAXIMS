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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1927.15487)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.List;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.configuration.domain.objects.Glossary;
import ims.correspondence.configuration.domain.objects.GlossaryProfile;
import ims.correspondence.configuration.vo.GlossaryRefVo;
import ims.correspondence.helper.SpecifierAdapter;
import ims.correspondence.vo.GlossaryProfileVo;
import ims.correspondence.vo.GlossaryVo;
import ims.correspondence.vo.GlossaryVoCollection;
import ims.correspondence.vo.domain.GlossaryProfileVoAssembler;
import ims.correspondence.vo.domain.GlossaryVoAssembler;
import ims.correspondence.vo.lookups.ProfileType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;
import ims.domain.lookups.LookupService;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.ICspTypeSpecifier;

public class GlossaryAdminImpl extends DomainImpl implements ims.correspondence.domain.GlossaryAdmin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	
	
	public ICspTypeSpecifier[] listGlossaryProfiles(ProfileType profileType) 
	{
		if (profileType == null)
			throw new CodingRuntimeException("Invalid Profile Type passed in as argument");
		
		if (profileType.equals(ProfileType.SPECIALTY))			
		{
			return listGlossaryProfileSpecialties();

		}
		else if (profileType.equals(ProfileType.CONSULTANT))			
		{
			return listGlossaryProfileConsultants();
		}
		
		throw new CodingRuntimeException("Unsupported Profile Type");
	}

	private ICspTypeSpecifier[] listGlossaryProfileConsultants() 
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		MedicLiteVoCollection medicLite = mosAdmin.listMedicsLite();
		if (medicLite != null) 
			return medicLite.toICspTypeSpecifierArray();
		else
			return null;
		
		
	}

	private ICspTypeSpecifier[] listGlossaryProfileSpecialties() 
	{
		LookupService lookup = this.getLookupService();
		SpecialtyCollection collection = (SpecialtyCollection) lookup.getLookupCollection(Specialty.TYPE_ID,SpecialtyCollection.class, Specialty.class);
		ICspTypeSpecifier[] result = new ICspTypeSpecifier[collection.size()];
		for(int x = 0; x < collection.size(); x++)
		{
			result[x] = new SpecifierAdapter(collection.get(x));
		}		
		return result;
	}

	public GlossaryVoCollection listAllGlossaryItems()
	{
		DomainFactory factory = getDomainFactory();
		List glossaryList = factory.listDomainObjects(Glossary.class);
		return GlossaryVoAssembler.createGlossaryVoCollectionFromGlossary(glossaryList);
	}

	public GlossaryVo saveGlossary(GlossaryVo voGlossary) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		if (voGlossary == null)
			throw new CodingRuntimeException("Invalid argument: GlossaryVo is null");
		if (!voGlossary.isValidated())
			throw new DomainRuntimeException("Glossary VO not validated.");

		DomainFactory factory = getDomainFactory();
		Glossary domGlossary = GlossaryVoAssembler.extractGlossary(factory,voGlossary);
		try
		{
			factory.save(domGlossary);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("Text already exists within the system for this Glossary.", e);
		}

		return GlossaryVoAssembler.create(domGlossary);
	}

	public void deleteGlossary(GlossaryRefVo voGlossaryRef) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql1 = " from Glossary g " +
		" where g.id = " +  voGlossaryRef.getID_Glossary();
	
		try
		{
			factory.delete(hql1);
		}
		catch (ForeignKeyViolationException e)
		{
			throw new ForeignKeyViolationException("There are data items in the system referencing this item - delete access denied", e);
		}
	}

	public GlossaryProfileVo saveGlossaryProfile(GlossaryProfileVo voGlossaryProfile) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		if (voGlossaryProfile ==null)
			throw new CodingRuntimeException("Invalid argument: GlossaryProfileVo is null)");
			
		if (!voGlossaryProfile.isValidated())
			throw new DomainRuntimeException("GlossaryProfileVo has not been validated");
		DomainFactory factory = getDomainFactory();
		GlossaryProfile domGlossaryProfile = GlossaryProfileVoAssembler.extractGlossaryProfile(factory, voGlossaryProfile);
	
		try
		{
			factory.save(domGlossaryProfile);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("Profile already exists within the system for this user.", e);
		}

		return GlossaryProfileVoAssembler.create(domGlossaryProfile);

	}

	public GlossaryProfileVo getGlossaryProfile(ICspTypeSpecifier iCspTypeSpecifier) 
	{
		DomainFactory factory = getDomainFactory();		
		GlossaryProfile domGlossaryProfile = GlossaryProfile.getGlossaryProfileFromspecifier_unq_idx1(factory, iCspTypeSpecifier.getIGenericItemInfoID(), getDomLookup(iCspTypeSpecifier.getSpecifierType()));		
		return GlossaryProfileVoAssembler.create(domGlossaryProfile);
	}

	public GlossaryVo getGlossary(GlossaryRefVo refVoGlossary) 
	{
		if(refVoGlossary == null || refVoGlossary.getID_Glossary() == null)
		{
			throw new DomainRuntimeException("Invalid record");
		}

		DomainFactory factory = getDomainFactory();		
		Glossary domGlosssary = (Glossary)factory.getDomainObject(refVoGlossary);
		
		return GlossaryVoAssembler.create(domGlosssary);
	}



}
