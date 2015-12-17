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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BasePatientInternalReferralsListImpl;
import ims.clinical.vo.ClinicalReferralsForIncomingReferralListVo;
import ims.clinical.vo.ClinicalReferralsForIncomingReferralListVoCollection;
import ims.clinical.vo.PatientClinicalReferralsListFilterVo;
import ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection;
import ims.clinical.vo.domain.ClinicalReferralsForIncomingReferralListVoAssembler;
import ims.clinical.vo.domain.ServiceConfigIntReferralForIncomingListVoAssembler;
import ims.clinical.vo.lookups.ClinicalReferralType;
import ims.clinicaladmin.helper.IInternalReferralActionsHelper;
import ims.clinicaladmin.helper.InternalReferralActionsHelper;
import ims.core.vo.lookups.InternalReferralStatus;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class PatientInternalReferralsListImpl extends BasePatientInternalReferralsListImpl
{
	private static final long serialVersionUID = 1L;

	private static final String INPATIENT_REFERRAL = "Inpatient";
	private static final String OUTPATIENT_REFERRAL = "Outpatient";

	//WDEV-18966
	public ServiceConfigIntReferralForIncomingListVoCollection listServices(String serviceName)
	{
		if (serviceName == null || serviceName.length() == 0)
			throw new CodingRuntimeException("Invalid service name search parameter.");
		
		DomainFactory factory = getDomainFactory();
		String hql = "select refservice from ServiceConfigIntReferral as refservice left join refservice.service as serv where refservice.active = 1 and serv.isActive = 1 and serv.upperName like :SERV_NAME order by serv.upperName asc"; //WDEV-20219 UPPER(serv.serviceName)
		
		List<?> serviceList = factory.find(hql,"SERV_NAME",serviceName.trim().toUpperCase() + "%");

		return ServiceConfigIntReferralForIncomingListVoAssembler.createServiceConfigIntReferralForIncomingListVoCollectionFromServiceConfigIntReferral(serviceList);
	}

	private String getReferralType(ClinicalReferralType clinicalReferralType) 
	{
		if(clinicalReferralType == null)
			return null;

		if(ClinicalReferralType.IP_TO_BE_SEEN_AS_INPATIENT.equals(clinicalReferralType))
			return INPATIENT_REFERRAL;

		return OUTPATIENT_REFERRAL;
	}
	
	public ClinicalReferralsForIncomingReferralListVoCollection listPatientReferrals(PatientClinicalReferralsListFilterVo patientReferralFilter)
	{
		if (patientReferralFilter == null)
			throw new CodingRuntimeException("The PatientClinicalReferralsListFilter argument passed to search method cannot be null.");
		if (patientReferralFilter.getPatient() == null)
			throw new CodingRuntimeException("The reference to Patient cannot be null in PatientClinicalReferralsListFilter argument passed to search method.");

		DomainFactory factory = getDomainFactory();

		StringBuilder mainhql = new StringBuilder();
		StringBuilder conditions = new StringBuilder();

		mainhql.append("select clref from ClinicalReferrals as clref left join clref.patient as pat left join clref.referToService as service left join clref.currentReferralStatus as currentstat left join currentstat.referralStatus as stat ");

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = "";

		if (patientReferralFilter.getPatient() != null)
		{
			conditions.append("pat.id = :patientID");
			markers.add("patientID");
			values.add(patientReferralFilter.getPatient().getID_Patient());
			andStr = " and ";
		}

		if (patientReferralFilter.getService() != null)
		{
			conditions.append(andStr + "service.service.id = :serviceID");
			markers.add("serviceID");
			values.add(patientReferralFilter.getService().getService().getID_Service());
			andStr = " and ";
		}

		if (patientReferralFilter.getReferralStatus() != null)
		{
			conditions.append(andStr + "stat = :refStatus");
			markers.add("refStatus");
			values.add(getDomLookup(patientReferralFilter.getReferralStatus()));
			andStr = " and ";
		}

		if (patientReferralFilter.getReferralDateFrom() != null)
		{
			conditions.append(andStr + "clref.dateDecisionToRefer >= :dateFrom");
			markers.add("dateFrom");
			values.add(patientReferralFilter.getReferralDateFrom().getDate());
			andStr = " and ";
		}

		if (patientReferralFilter.getReferralDateTo() != null)
		{
			conditions.append(andStr + "clref.dateDecisionToRefer <= :dateTo");
			markers.add("dateTo");
			values.add(patientReferralFilter.getReferralDateTo().getDate());
			andStr = " and ";
		}
		
		conditions.append(andStr + " stat <> :exludedRefStatus"); //WDEV-18969
		markers.add("exludedRefStatus");
		values.add(getDomLookup(InternalReferralStatus.ABANDONED));

		if (markers.size() > 0)
		{
			mainhql.append(" where " + conditions.toString());
		}
		mainhql.append (" order by clref.dateDecisionToRefer desc");

		List<?> patientReferralsList = factory.find(mainhql.toString(), markers.toArray(new String[markers.size()]), values.toArray(new Object[values.size()]));

		if  (patientReferralsList != null && patientReferralsList.size() > 0)
		{	
			ClinicalReferralsForIncomingReferralListVoCollection patientReferralsListColl =  ClinicalReferralsForIncomingReferralListVoAssembler.createClinicalReferralsForIncomingReferralListVoCollectionFromClinicalReferrals(patientReferralsList);

			for(ClinicalReferralsForIncomingReferralListVo referral : patientReferralsListColl)
			{
				if(referral == null)
					continue;

				referral.setReferralTypeText(getReferralType(referral.getReferralType()));
			}
			return patientReferralsListColl;
		}
		return null;
	}

	public InternalReferralActionsHelper getInternalReferralsHelper(Integer appForm)
	{
		ims.clinicaladmin.helper.IInternalReferralActionsHelper iInterface = (IInternalReferralActionsHelper) getDomainImpl(InternalReferralActionsHelper.class);
		return iInterface.initializeInternalReferralActionsHelper(appForm);
	}
}
