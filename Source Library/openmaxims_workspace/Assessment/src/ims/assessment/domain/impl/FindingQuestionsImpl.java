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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2390.19774)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.admin.domain.ImageAdmin;
import ims.admin.domain.impl.ImageAdminImpl;
import ims.admin.vo.AppImageVo;
import ims.admin.vo.AppImageVoCollection;
import ims.assessment.configuration.domain.objects.DrawingGraphicFinding;
import ims.assessment.configuration.domain.objects.DrawingGraphicFindingQuestion;
import ims.assessment.domain.base.impl.BaseFindingQuestionsImpl;
import ims.core.vo.DrawingGraphicFindingQuestionVo;
import ims.core.vo.DrawingGraphicFindingQuestionVoCollection;
import ims.core.vo.domain.DrawingGraphicFindingQuestionVoAssembler;
import ims.core.vo.domain.DrawingGraphicFindingVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class FindingQuestionsImpl extends BaseFindingQuestionsImpl
{
	public ims.core.vo.DrawingGraphicFindingVo saveFinding(ims.core.vo.DrawingGraphicFindingVo voDrawingGraphicFinding) throws ims.domain.exceptions.StaleObjectException
	{
		if(voDrawingGraphicFinding == null)
			throw new RuntimeException("Cannot save null value for DrawingGraphicFindingVo");
		if(voDrawingGraphicFinding.isValidated() == false)
			throw new CodingRuntimeException("DrawingGraphicFinding Value Object has not been validated");
		
		DomainFactory factory = getDomainFactory();
		DrawingGraphicFinding doDrawingGraphicFinding = DrawingGraphicFindingVoAssembler.extractDrawingGraphicFinding(factory, voDrawingGraphicFinding);
		factory.save(doDrawingGraphicFinding);
		return DrawingGraphicFindingVoAssembler.create(doDrawingGraphicFinding);
	}
	
	public DrawingGraphicFindingQuestionVoCollection saveDrawingGraphicFindings(DrawingGraphicFindingQuestionVoCollection voColl) throws StaleObjectException
	{
		if(voColl == null)
			throw new RuntimeException("Cannot save null values for DrawingGraphicFindingQuestionVoCollection");
		if(voColl.isValidated() == false)
			throw new CodingRuntimeException("DrawingGraphicFindingQuestionVoCollection has not been validated");
		
		DomainFactory factory = getDomainFactory();
		ArrayList doList = new ArrayList();
		for(int i=0; i<voColl.size(); i++)
		{
			DrawingGraphicFindingQuestion doDrawingGraphicFindingQuestion = DrawingGraphicFindingQuestionVoAssembler.extractDrawingGraphicFindingQuestion(factory, voColl.get(i));
			factory.save(doDrawingGraphicFindingQuestion);
			doList.add(doDrawingGraphicFindingQuestion);
		}
		
		return DrawingGraphicFindingQuestionVoAssembler.createDrawingGraphicFindingQuestionVoCollectionFromDrawingGraphicFindingQuestion(doList);
	}

	public DrawingGraphicFindingQuestionVo saveDrawingGraphicFinding(DrawingGraphicFindingQuestionVo voDrawingGraphicFindingQuestion) throws StaleObjectException
	{
		if(voDrawingGraphicFindingQuestion == null)
			throw new RuntimeException("Cannot save null value for DrawingGraphicFindingQuestionVo");
		if(voDrawingGraphicFindingQuestion.isValidated() == false)
			throw new CodingRuntimeException("DrawingGraphicFindingQuestion Value Object has not been validated");
		
		DomainFactory factory = getDomainFactory();
		DrawingGraphicFindingQuestion doDrawingGraphicFindingQuestion = DrawingGraphicFindingQuestionVoAssembler.extractDrawingGraphicFindingQuestion(factory, voDrawingGraphicFindingQuestion);
		DrawingGraphicFinding doDrawingGraphicFinding = DrawingGraphicFindingVoAssembler.extractDrawingGraphicFinding(factory, voDrawingGraphicFindingQuestion.getDrawingGraphicFinding());
		factory.save(doDrawingGraphicFinding);
		
		doDrawingGraphicFindingQuestion.setDrawingGraphicFinding(doDrawingGraphicFinding);
		factory.save(doDrawingGraphicFinding);
		return DrawingGraphicFindingQuestionVoAssembler.create(doDrawingGraphicFindingQuestion);
	}

	/**
	* list Drawing Graphic Findings
	*/
	public ims.core.vo.DrawingGraphicFindingVoCollection listFindings(String findingName, PreActiveActiveInactiveStatus status)
	{
		/*
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from DrawingGraphicFinding dgf ");
		ArrayList names  = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(findingName != null && findingName.equals("") == false)
		{
			names.add("searchName");
			values.add(findingName.toUpperCase());
			names.add("STATUS");
			values.add(new Integer(PreActiveActiveInactiveStatus.ACTIVE.getId()));
			hql.append("where upper(dgf.displayText) like :searchName and dgf.activeStatus.id = :STATUS");
		}
		else
		{
			names.add("STATUS");
			values.add(new Integer(PreActiveActiveInactiveStatus.ACTIVE.getId()));
			hql.append("where dgf.activeStatus.id = :STATUS");
		}
	*/
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from DrawingGraphicFinding dgf ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(findingName != null && findingName.equals("") == false)
		{
			hql.append(andStr + " upper(dgf.displayText) like :searchName ");
			markers.add("searchName");
			values.add(findingName.toUpperCase());
			andStr = " and ";
		}
		if (status != null)
		{
			hql.append(andStr + " dgf.activeStatus.id = :STATUS ");
			markers.add("STATUS");
			values.add(new Integer(status.getId()));
			andStr = " and ";
		}

		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();
		
		List findingsList = factory.find(query, markers, values);
		return DrawingGraphicFindingVoAssembler.createDrawingGraphicFindingVoCollectionFromDrawingGraphicFinding(findingsList);
	}

	public AppImageVoCollection listImages(AppImageVo filter)
	{
		ImageAdmin imageAdmin = (ImageAdmin) getDomainImpl(ImageAdminImpl.class);
		return imageAdmin.listImages(filter);
	}

	/**
	 * List active finding questions 
	 */
	public DrawingGraphicFindingQuestionVoCollection listDrawingGraphicFindings(Integer findingId)
	{	
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select dgfq from DrawingGraphicFindingQuestion as dgfq left join dgfq.question as dgql where (dgfq.drawingGraphicFinding.id = :findID and dgql.status.id != :statusID) order by dgfq.order asc ");  //wdev-10987
		ArrayList names  = new ArrayList();
		ArrayList values = new ArrayList();
		
		names.add("findID");
		values.add(findingId);

		names.add("statusID");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.INACTIVE).getId());		
		
		List findingsList = factory.find(hql.toString(), names, values);
		return DrawingGraphicFindingQuestionVoAssembler.createDrawingGraphicFindingQuestionVoCollectionFromDrawingGraphicFindingQuestion(findingsList);
	}
}
