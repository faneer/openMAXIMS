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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.20 build 40903.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.domain.impl.DomainImpl;
import ims.admin.helper.Keywords;
import ims.core.clinical.domain.objects.Diagnosis;
import ims.core.clinical.vo.DiagnosisRefVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.domain.DiagLiteVoAssembler;
import ims.core.vo.domain.DiagnosisVoAssembler;
import java.util.List;
import java.util.ArrayList;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;

public class DiagnosisListImpl extends DomainImpl implements ims.core.domain.DiagnosisList, ims.domain.impl.Transactional
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ims.core.vo.DiagnosisVo saveDiagnosisVo(ims.core.vo.DiagnosisVo voDiagnosisVo) throws StaleObjectException, UniqueKeyViolationException																							
	{
		if (!voDiagnosisVo.isValidated())
		{
			throw new DomainRuntimeException("This DiagnosisVo has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();			
		Diagnosis domDiagnosis = DiagnosisVoAssembler.extractDiagnosis(factory, voDiagnosisVo);

		domDiagnosis.setKeywords(Keywords.setupKeyWords(domDiagnosis.getKeywords(), domDiagnosis.getDiagnosisName()));
		try
		{
			factory.save(domDiagnosis);
		}
		catch(UnqViolationUncheckedException e)
		{		
			//check which constraint was violated (name/taxononmy map)

			//name
			Diagnosis diag = Diagnosis.getDiagnosisFromDiagnosisName(factory, voDiagnosisVo.getDiagnosisName());
			if (diag != null && diag.getId() != null && !(diag.getId().equals(voDiagnosisVo.getID_Diagnosis())))
			{
				throw new UniqueKeyViolationException("Diagnosis record called \"" + voDiagnosisVo.getDiagnosisName() + "\" already exists. Duplicates not allowed.", e);	
			}

			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domDiagnosis, voDiagnosisVo.getTaxonomyMap(), "getDiagnosisName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
						
			throw (e);
		}
		return DiagnosisVoAssembler.create(domDiagnosis);
	}
	
	/**
	 * The filter is assumed to be one or more keywords seperated by some white space.
	 * Each keyword is used in a seperate query to get back Diagnosis which have a keyword like it.
	 * Each subsequent keyword query narrows the original returned list so the eventual returned list
	 * only contains Diagnosis which contain a match on all the keywords.
	 * It would be nice if this could be implemented as a single HQL query but I don't know how.
	 * @param filter
	 * @param activeOnly
	 * @return
	 * @throws DomainInterfaceException 
	 */
	private List listDomDiagnosis(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Diagnosis d join d.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (activeOnly)
		{
			hql.append(" where d.isActive = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		
		return Keywords.searchByKeywords(factory, filter, hql.toString(), names, values);			
	}
	
	private DiagLiteVoCollection listDiagnosis(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		return DiagLiteVoAssembler.createDiagLiteVoCollectionFromDiagnosis(listDomDiagnosis(filter, activeOnly)).sort();		
	}
	
	public ims.core.vo.DiagnosisVo getDiagnosisVo(DiagnosisRefVo voDiagnosisRef)
	{
		DomainFactory factory = getDomainFactory();
		Diagnosis med = (Diagnosis) factory.getDomainObject(Diagnosis.class, voDiagnosisRef.getID_Diagnosis());
		return (DiagnosisVoAssembler.create(med));
	}
	
	public DiagLiteVoCollection listDiagnosisIncludeInactive(String filter) throws DomainInterfaceException
	{
		return listDiagnosis(filter, false);
	}

	public DiagLiteVoCollection listActiveDiagnosis(String filter) throws DomainInterfaceException
	{
		return listDiagnosis(filter, true);
	}

	
}
