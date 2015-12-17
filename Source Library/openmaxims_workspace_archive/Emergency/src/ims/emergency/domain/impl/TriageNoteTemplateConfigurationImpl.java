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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.admin.helper.Keywords;
import ims.clinical.vo.ClinicalProblemVo;
import ims.clinical.vo.ClinicalProblemVoCollection;
import ims.clinical.vo.domain.ClinicalProblemVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig;
import ims.emergency.configuration.vo.TriageNoteDefaultTextConfigRefVo;
import ims.emergency.domain.base.impl.BaseTriageNoteTemplateConfigurationImpl;
import ims.emergency.vo.TriageNoteDefaultTextConfigVo;
import ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection;
import ims.emergency.vo.domain.TriageNoteDefaultTextConfigVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.LookupInstVo;

import java.util.ArrayList;
import java.util.List;

public class TriageNoteTemplateConfigurationImpl extends BaseTriageNoteTemplateConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ClinicalProblemVoCollection listProblems(String problemName)
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		if (problemName == null || (problemName != null && problemName.length() == 0))
			throw new DomainRuntimeException("String for search is null.");

		String probNameLite = problemName != null ? problemName.toUpperCase() + "%" : "%%";

		StringBuffer hql = new StringBuffer();

		hql.append(" select probl from ClinicalProblem as probl left join probl.keywords as k where (probl.pCName like :ClinicalProblemSearchText or k.keyword like :ClinicalProblemSearchText) and probl.isActive = 1");
		hql.append(" order by UPPER(probl.pCName) asc");

		markers.add("ClinicalProblemSearchText");
		values.add(probNameLite);

		return ClinicalProblemVoAssembler.createClinicalProblemVoCollectionFromClinicalProblem(factory.find(hql.toString(), markers, values));
	}

	public TriageNoteDefaultTextConfigVo saveTriageNote(TriageNoteDefaultTextConfigVo triageNoteToSave) throws StaleObjectException
	{
		if (triageNoteToSave == null)
			throw new CodingRuntimeException("Cannot save null TriageNote");

		if (!triageNoteToSave.isValidated())
			throw new DomainRuntimeException("TriageNoteVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		TriageNoteDefaultTextConfig domainNote = TriageNoteDefaultTextConfigVoAssembler.extractTriageNoteDefaultTextConfig(factory, triageNoteToSave);

		factory.save(domainNote);

		return TriageNoteDefaultTextConfigVoAssembler.create(domainNote);
	}

	public TriageNoteDefaultTextConfigVoCollection listTriageNotes(ClinicalProblemVo presentingProblem, LookupInstVo status)
	{

		DomainFactory factory = getDomainFactory();

		String hql = " select tn from TriageNoteDefaultTextConfig as tn ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		if (presentingProblem != null)
		{
			condStr.append(andStr + " where tn.problem.id = :tName");
			markers.add("tName");
			values.add(presentingProblem.getID_ClinicalProblem());
			andStr = " and ";
		}
		else
			andStr = " where ";

		if (status != null)
		{
			condStr.append(andStr + " tn.status.id = :tStatus");
			markers.add("tStatus");
			values.add(status.getID());
		}
		
		condStr.append(" order by UPPER(tn.problem.pCName) asc");

		hql += condStr.toString();
		return TriageNoteDefaultTextConfigVoAssembler.createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(factory.find(hql, markers, values));
	}

	public TriageNoteDefaultTextConfigVo getTriageNote(TriageNoteDefaultTextConfigRefVo triageNote)
	{
		if (triageNote == null || triageNote.getID_TriageNoteDefaultTextConfig() == null)
		{
			throw new CodingRuntimeException("Cannot get TriageNoteDefaultTextConfigVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		TriageNoteDefaultTextConfig domainTriageNote = (TriageNoteDefaultTextConfig) factory.getDomainObject(TriageNoteDefaultTextConfig.class, triageNote.getID_TriageNoteDefaultTextConfig());

		return TriageNoteDefaultTextConfigVoAssembler.create(domainTriageNote);
	}

	public Boolean isStale(TriageNoteDefaultTextConfigVo triageNote)
	{
		if (triageNote == null || triageNote.getID_TriageNoteDefaultTextConfig() == null)
		{
			throw new CodingRuntimeException("Cannot get TriageNoteVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		TriageNoteDefaultTextConfig domainTriageNote = (TriageNoteDefaultTextConfig) factory.getDomainObject(TriageNoteDefaultTextConfig.class, triageNote.getID_TriageNoteDefaultTextConfig());

		if (domainTriageNote == null)
		{
			return true;
		}

		if (domainTriageNote.getVersion() > triageNote.getVersion_TriageNoteDefaultTextConfig())
		{
			return true;
		}

		return false;
	}
}
