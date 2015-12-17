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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface OPDEDClinicNotes extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Save the OPDEDVo
	*/
	public void saveOPDEDVo(ims.generalmedical.vo.OPDErectDysfxnVo voOPDED) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Get OPDEDVo
	*/
	public ims.generalmedical.vo.OPDErectDysfxnVo getOPDEDVo(ims.core.vo.ClinicalContactShortVo voClinicalContact);

	// Generated from form domain interface definition
	/**
	* Retrieves the social history for the currect episode.
	*/
	public ims.core.vo.SocialHistoryVo getMedSocialHistory(ims.core.vo.ClinicalContactShortVo voClinicalContactShort);

	// Generated from form domain interface definition
	/**
	* Save the social history for the current episode.
	*/
	public void saveMedSocialHistory(ims.core.vo.SocialHistoryVo voSocialHistory) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get record by care context
	*/
	public ims.generalmedical.vo.OPDErectDysfxnVoCollection getOPDErectDysfxnByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	/**
	* return a collection of OPDErectDysfxnVo
	*/
	public ims.generalmedical.vo.OPDErectDysfxnVoCollection listByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	/**
	* Retrieve a Med Social History Record by care context
	*/
	public ims.core.vo.SocialHistoryVo getMedSocialHistoryByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVoCollection listOPEDCareContextsByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo refEpisodeOfCare);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	public ims.core.vo.SocialHistoryVo getSocialHistoryByPatient(ims.core.patient.vo.PatientRefVo patient);
}
