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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.domain;

// Generated from form domain impl
public interface PresentingProblems extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.vo.LookupInstVo getMappings(ims.vo.LookupInstVo instance);

	// Generated from form domain interface definition
	/**
	* listPresentingProblems
	*/
	public ims.clinical.vo.ClinicalProblemShortVoCollection listPresentingProblems(ims.core.vo.lookups.Specialty specialty);

	// Generated from form domain interface definition
	/**
	* getHistoryProblems
	*/
	public ims.clinical.vo.PresentAbsentHistoryProblemsVo getHistoryProblems(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	/**
	* save
	*/
	public ims.clinical.vo.PresentAbsentHistoryProblemsVo save(ims.clinical.vo.PresentAbsentHistoryProblemsVo voHistoryProblems) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listHCPs
	*/
	public ims.core.vo.HcpLiteVoCollection listHCPs(ims.core.vo.Hcp filter);

	// Generated from form domain interface definition
	/**
	* getPMHCheckListConfig
	*/
	public ims.clinicaladmin.vo.PresProblemChecklistConfigVo getPresProblemCheckListConfig(ims.core.vo.lookups.Specialty specialtyLkup);

	// Generated from form domain interface definition
	/**
	* savePMHCheckListConfig
	*/
	public ims.clinicaladmin.vo.PresProblemChecklistConfigVo savePresProblemCheckListConfig(ims.clinicaladmin.vo.PresProblemChecklistConfigVo item) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* listProblemsByEpisodeOfCare
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* Save a ProblemConfig Vo
	*/
	public ims.clinical.vo.ProblemConfigVo saveProblemConfig(ims.clinical.vo.ProblemConfigVo voProblem) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* listPatientProblemsByPatient
	*/
	public ims.core.vo.PatientProblemVoCollection listPatientProblemsByPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* getPatientProblems
	*/
	public ims.clinical.vo.PatientPresentingProblemsVo getPatientProblems(ims.core.clinical.vo.PatientProblemRefVo refVo);
}
