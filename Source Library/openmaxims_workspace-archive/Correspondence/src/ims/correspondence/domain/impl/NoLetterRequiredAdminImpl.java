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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.List;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.domain.objects.Clinic;
import ims.core.resource.place.vo.ClinicRefVo;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.domain.ClinicVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.correspondence.configuration.domain.objects.NoLetterIsRequired;
import ims.correspondence.vo.NoLetterIsRequiredVo;
import ims.correspondence.vo.NoLetterIsRequiredVoCollection;
import ims.correspondence.vo.domain.NoLetterIsRequiredVoAssembler;
import ims.correspondence.vo.lookups.NoLetterIsRequiredSpecifier;
import ims.domain.DomainFactory;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.domain.impl.DomainImpl;

public class NoLetterRequiredAdminImpl extends DomainImpl implements ims.correspondence.domain.NoLetterRequiredAdmin, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClinicVoCollection listClinics()
	{
		DomainFactory factory = getDomainFactory();
		return ClinicVoAssembler.createClinicVoCollectionFromClinic(factory.listDomainObjects(Clinic.class));
	}

	public MedicLiteVoCollection listConsultants()
	{
		MosAdmin impl = (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return impl.listMedicsLite();
	}
	

	public NoLetterIsRequiredVoCollection listNoLetterIsRequiredConsultants()
	{
		DomainFactory factory = getDomainFactory();		
		List lstNLRConsultants = factory.find("from NoLetterIsRequired nlr where nlr.classIdentifier = :NLRSpecifier",new String[]{"NLRSpecifier"}, new Object[]{getDomLookup(NoLetterIsRequiredSpecifier.CONSULTANT)});				
		return NoLetterIsRequiredVoAssembler.createNoLetterIsRequiredVoCollectionFromNoLetterIsRequired(lstNLRConsultants);
	}

	public NoLetterIsRequiredVoCollection listNoLetterIsRequiredSpecialties()
	{				
		DomainFactory factory = getDomainFactory();		
		List lstNLRSpecialties = factory.find("from NoLetterIsRequired nlr where nlr.classIdentifier = :NLRSpecifier",new String[]{"NLRSpecifier"}, new Object[]{getDomLookup(NoLetterIsRequiredSpecifier.SERVICE)});				
		return NoLetterIsRequiredVoAssembler.createNoLetterIsRequiredVoCollectionFromNoLetterIsRequired(lstNLRSpecialties);		
	}



	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.NoLetterRequiredAdmin#listNoLetterIsRequiredClinics(java.lang.Boolean)
	 */
	public NoLetterIsRequiredVoCollection listNoLetterIsRequiredClinics(Boolean bNew) 
	{
		DomainFactory factory = getDomainFactory();
		List lstNLRSClinics = null;
	
		if (bNew.equals(Boolean.TRUE))			
			lstNLRSClinics = factory.find("from NoLetterIsRequired nlr where nlr.classIdentifier = :NLRSpecifier",new String[]{"NLRSpecifier"}, new Object[]{getDomLookup(NoLetterIsRequiredSpecifier.CLINICNEW)});  
		else
			lstNLRSClinics = factory.find("from NoLetterIsRequired nlr where nlr.classIdentifier = :NLRSpecifier",new String[]{"NLRSpecifier"}, new Object[]{getDomLookup(NoLetterIsRequiredSpecifier.CLINICREVIEW)});			
				
		return NoLetterIsRequiredVoAssembler.createNoLetterIsRequiredVoCollectionFromNoLetterIsRequired(lstNLRSClinics);
	}

	public ims.correspondence.vo.NoLetterIsRequiredVo saveNoLetterIsRequired(ims.correspondence.vo.NoLetterIsRequiredVo voNoLetterIsRequired) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException 
	{
		if (!voNoLetterIsRequired.isValidated())
		{
			throw new CodingRuntimeException("NoLetter is required record has not been validated");
		}
				
		DomainFactory factory = getDomainFactory();				
		NoLetterIsRequired domNLR =  NoLetterIsRequiredVoAssembler.extractNoLetterIsRequired(factory, voNoLetterIsRequired);
		try
		{
			factory.save(domNLR);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("No Letter required already exists within the system. Please try again to update.", e);
		}
		
		return NoLetterIsRequiredVoAssembler.create(domNLR);
	}

	public NoLetterIsRequiredVo getNLRItems() 
	{
		DomainFactory factory = getDomainFactory();		
		java.util.List l = factory.find("from NoLetterIsRequired");
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. NoLetterIsRequired = returned " + l.size() + " records. " );
		return NoLetterIsRequiredVoAssembler.create((NoLetterIsRequired) l.get(0));
	}	
	
	public Boolean isLetterRequired(HcpRefVo voRefMedic, Specialty lkpSpecialty, ClinicRefVo voRefClinicNew, ClinicRefVo voRefClinicReview) 
	{
		DomainFactory factory = getDomainFactory();
			
		String hql = " from NoLetterIsRequired n ";
		String sWhere = "";
		
		if (voRefMedic != null)
		{
			sWhere = " join fetch n.consultants cons where cons.id = " + voRefMedic.getID_Hcp();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (lkpSpecialty != null)
		{
			sWhere = " join fetch n.specialties spec join spec.instance instance where instance = " + getDomLookup(lkpSpecialty).getId();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (voRefClinicNew != null)
		{
			sWhere = " join fetch n.newClinics nc where nc.id = " + voRefClinicNew.getID_Clinic();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		if (voRefClinicReview != null)
		{
			sWhere = " join fetch n.reviewClinics rc where rc.id = " + voRefClinicReview.getID_Clinic();
			List lstNLR  = factory.find(hql + sWhere);			
			if (lstNLR != null && lstNLR.size() > 0)
				return Boolean.FALSE;								
		}
		
		return Boolean.TRUE;

	}



}