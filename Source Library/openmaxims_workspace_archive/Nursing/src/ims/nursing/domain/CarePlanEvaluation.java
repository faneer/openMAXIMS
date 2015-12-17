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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.nursing.domain;

// Generated from form domain impl
public interface CarePlanEvaluation extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Returns a list of all Medics
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	public ims.core.vo.Hcp getHcp(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* save the Evaluation Note
	*/
	public ims.nursing.vo.CarePlanEvaluationNote saveEvaluationNote(ims.nursing.vo.CarePlanEvaluationNote evaluationNoteVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* saves the interventions and the evaluation note
	*/
	public ims.nursing.vo.CarePlan saveCarePlan(ims.nursing.vo.CarePlan carePlan) throws ims.domain.exceptions.StaleObjectException;
}
