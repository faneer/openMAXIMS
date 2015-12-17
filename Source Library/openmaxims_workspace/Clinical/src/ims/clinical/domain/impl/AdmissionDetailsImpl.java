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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.clinical.domain.base.impl.BaseAdmissionDetailsImpl;
import ims.core.admin.pas.domain.objects.AdmissionDetail;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.vo.AdmissionDetailRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.AdmissionDetailLiteVoCollection;
import ims.core.vo.AdmissionDetailLiteWithInpatientEpisodeVo;
import ims.core.vo.InpatientEpisodeBedNumberUpdateVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.AdmissionDetailLiteVoAssembler;
import ims.core.vo.domain.AdmissionDetailLiteWithInpatientEpisodeVoAssembler;
import ims.core.vo.domain.InpatientEpisodeBedNumberUpdateVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;

import java.util.ArrayList;

public class AdmissionDetailsImpl extends BaseAdmissionDetailsImpl
{
	private static final long serialVersionUID = 1L;

	
	/**
	* Methods used to retrieve all Admission Episodes for given patient.
	*/
	public AdmissionDetailLiteVoCollection listAdmissionEpisodes(PatientRefVo patient)
	{
		// Test patient parameter
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Logical error - can't not list admision details");

		// Build query
		String query = "SELECT admissionDetails FROM AdmissionDetail AS admissionDetails LEFT JOIN admissionDetails.pasEvent AS pas LEFT JOIN pas.patient AS patient WHERE patient.id = :ID ORDER BY admissionDetails.admissionDateTime DESC";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID");
		paramValues.add(patient.getID_Patient());
		
		// Query database & return results
		return AdmissionDetailLiteVoAssembler.createAdmissionDetailLiteVoCollectionFromAdmissionDetail(getDomainFactory().find(query, paramNames, paramValues));
	}

	
	/**
	* Method used to retrieve Admission Details.
	*/
	public AdmissionDetailLiteWithInpatientEpisodeVo getAdmission(AdmissionDetailRefVo admission)
	{
		// Check admission record parameter
		if (admission == null || !admission.getID_AdmissionDetailIsNotNull())
			return null;
		
		AdmissionDetailLiteWithInpatientEpisodeVo admissionDetails = AdmissionDetailLiteWithInpatientEpisodeVoAssembler.create((AdmissionDetail) getDomainFactory().getDomainObject(AdmissionDetail.class, admission.getID_AdmissionDetail()));

		// Get Inpatient episode if exists
		String query = "SELECT inpEp FROM InpatientEpisode AS inpEp LEFT JOIN inpEp.pasEvent AS pas1, AdmissionDetail AS admtDetail LEFT JOIN admtDetail.pasEvent AS pas2 WHERE pas1.id = pas2.id AND admtDetail.id = :ADM_ID AND inpEp.isRIE is null";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ADM_ID");
		paramValues.add(admissionDetails.getID_AdmissionDetail());
		
		InpatientEpisodeBedNumberUpdateVo inpatientEpisode = InpatientEpisodeBedNumberUpdateVoAssembler.create((InpatientEpisode) getDomainFactory().findFirst(query, paramNames, paramValues));
		
		admissionDetails.setInpatientEpisode(inpatientEpisode);
		
		return admissionDetails;
	}

	
	/**
	* Method used to save Admission Details.
	*/
	public AdmissionDetailLiteWithInpatientEpisodeVo saveAdmission(AdmissionDetailLiteWithInpatientEpisodeVo admission) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		// Check for validated parameter
		if (admission == null || admission.isValidated() == false)
			throw new DomainRuntimeException("Logical error - can't save null or not-validated object");

		boolean hasInpatient = admission.getInpatientEpisodeIsNotNull();

		// Extract domain objects (admission details & inpatient episode for bed number)
		AdmissionDetail domainAdmissionDetail = AdmissionDetailLiteVoAssembler.extractAdmissionDetail(getDomainFactory(), admission);
		InpatientEpisode domainInpatientEpisode = null;

		if (hasInpatient)
		{
			domainInpatientEpisode = InpatientEpisodeBedNumberUpdateVoAssembler.extractInpatientEpisode(getDomainFactory(), admission.getInpatientEpisode());
		}

		// Commit to database both domain objects
		getDomainFactory().save(domainAdmissionDetail);

		if (hasInpatient)
		{
			getDomainFactory().save(domainInpatientEpisode);
		}

		AdmissionDetailLiteWithInpatientEpisodeVo admissionDetails = AdmissionDetailLiteWithInpatientEpisodeVoAssembler.create(domainAdmissionDetail);

		if (hasInpatient)
		{
			InpatientEpisodeBedNumberUpdateVo inpatientEpisode = InpatientEpisodeBedNumberUpdateVoAssembler.create(domainInpatientEpisode);

			admissionDetails.setInpatientEpisode(inpatientEpisode);
		}

		// Return saved record
		return admissionDetails;
	}

	
	/**
	* Method used to retrieve active wards for in the same hospital as given ward.
	*/
	public LocationLiteVoCollection listWards(LocationRefVo ward)
	{
		LocationRefVo hospital = null;

		// If the hospital is null or not found in the database then return no wards
		if (ward == null || !ward.getID_LocationIsNotNull())
			return null;
		
		// Search for the first parent of type hospital
		hospital = getHospitalForWard(ward);
		
		if (hospital == null)
			return null;
		
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocShortMappingsVoCollection locationShortVoMap = implLoc.listActiveWardsForHospital(hospital);
		
		if (locationShortVoMap == null || locationShortVoMap.size() == 0)
			return null;
		
		LocationLiteVoCollection results = new LocationLiteVoCollection();
		
		for (LocShortMappingsVo location : locationShortVoMap)
			results.add(location);
		
		return results;
	}


	/**
	 * Method used to recursively retrieve the first parent hospital for a ward
	 */
	private LocationRefVo getHospitalForWard(LocationRefVo ward)
	{
		Location domainWard = (Location) getDomainFactory().getDomainObject(Location.class, ward.getID_Location());
		Location parentLocation = domainWard.getParentLocation();
		
		
		if (parentLocation == null)
			return null;
		

		LocationRefVo hospital = new LocationRefVo(parentLocation.getId(), parentLocation.getVersion());
		
		if (parentLocation.getType() != null && LocationType.HOSP.getID() == parentLocation.getType().getId())
		{
			return hospital;
		}
		
		return getHospitalForWard(hospital);
	}
}
