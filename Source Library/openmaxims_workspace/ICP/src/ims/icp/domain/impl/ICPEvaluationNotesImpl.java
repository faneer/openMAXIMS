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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3520.27738)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.domain.base.impl.BaseICPEvaluationNotesImpl;
import ims.icp.vo.PatientICPEvaluationNoteVo;
import ims.icp.vo.PatientICPEvaluationNoteVoCollection;
import ims.icp.vo.PatientICP_EvaluationNotesVo;
import ims.icp.vo.domain.PatientICPEvaluationNoteVoAssembler;
import ims.icp.vo.domain.PatientICP_EvaluationNotesVoAssembler;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.domain.objects.PatientICPEvaluationNote;
import ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo;
import ims.icps.instantiation.vo.PatientICPRefVo;

public class ICPEvaluationNotesImpl extends BaseICPEvaluationNotesImpl
{

	private static final long serialVersionUID = 1L;


	/**
	 * Function used to retrieve Patient ICP record
	 */
	public PatientICP_EvaluationNotesVo getPatientICP(PatientICPRefVo patientICP)
	{
		if (patientICP == null || patientICP.getID_PatientICP() == null)
			return null;
		
		return PatientICP_EvaluationNotesVoAssembler.create((PatientICP) getDomainFactory().getDomainObject(PatientICP.class, patientICP.getID_PatientICP()));
	}


	public PatientICPEvaluationNoteVo getEvaluationNote(PatientICPEvaluationNoteRefVo evaluationNote)
	{
		if (evaluationNote == null || !evaluationNote.getID_PatientICPEvaluationNoteIsNotNull())
			return null;
		
		return PatientICPEvaluationNoteVoAssembler.create((PatientICPEvaluationNote) getDomainFactory().getDomainObject(PatientICPEvaluationNote.class, evaluationNote.getID_PatientICPEvaluationNote()));
	}

	/**
	* addEvaluationNote
	*/
	public void addEvaluationNote(PatientICP_EvaluationNotesVo patientICP, PatientICPEvaluationNoteVo evaluationNote) throws StaleObjectException
	{
		if(patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("PatientICPRefVo is null or has a null ID !");

		DomainFactory factory = getDomainFactory();
		
		if (patientICP.getEvaluationNotes() == null)
			patientICP.setEvaluationNotes(new PatientICPEvaluationNoteVoCollection());
		
		patientICP.getEvaluationNotes().add(evaluationNote);
		
		PatientICP bo = PatientICP_EvaluationNotesVoAssembler.extractPatientICP(factory, patientICP);
		
		factory.save(bo);
	}

	/**
	* updateEvaluationNote
	*/
	public void updateEvaluationNote(PatientICPEvaluationNoteVo evaluationNote) throws StaleObjectException
	{
		if(evaluationNote == null)
			throw new CodingRuntimeException("Can't update a null Critical event !");
		
		if(!evaluationNote.isValidated())
			throw new CodingRuntimeException("The Critical event is not validated !");
		
		DomainFactory factory = getDomainFactory();
		
		PatientICPEvaluationNote bo = PatientICPEvaluationNoteVoAssembler.extractPatientICPEvaluationNote(factory, evaluationNote);
		factory.save(bo);
	}
}
