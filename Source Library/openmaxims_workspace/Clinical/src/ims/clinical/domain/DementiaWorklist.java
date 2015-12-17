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
public interface DementiaWorklist extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.LocSiteLiteVoCollection listHospitals();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listWards(ims.core.resource.place.vo.LocationRefVo hospital, String wardName);

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteLiteVo getCurrentHospital(ims.framework.interfaces.ILocation location);

	// Generated from form domain interface definition
	public ims.clinical.vo.DementiaForWorklistVoCollection listPatients(ims.clinical.vo.DementiaWorklistSearchCriteriaVo searchCriteria);

	// Generated from form domain interface definition
	public ims.admin.vo.DementiaConfigurationVo getDementiaConfiguration();

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatient(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.DementiaVo rieDementiaRecord(ims.clinical.vo.DementiaVo voDementia, ims.framework.FormName formName, Integer patientId, Integer contactId, Integer careContextId, String rieMessage) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.DementiaVo getDementiaForRIEUse(ims.core.clinical.vo.DementiaRefVo dementiaRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.DementiaVo getDementia(ims.core.clinical.vo.DementiaRefVo dementiaRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.DementiaForWorklistVo getDementiaForWorklist(ims.core.clinical.vo.DementiaRefVo dementiaRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.DementialManualClassAssemblyVoCollection listPatientsManualAssembley(ims.clinical.vo.DementiaWorklistSearchCriteriaVo searchCriteria);

	// Generated from form domain interface definition
	public String[] getSystemReportAndTemplate(Integer imsId);
}
