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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.RefMan.domain.base.impl.BasePreAssessmentOutcomeDlgImpl;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.vo.PatientElectiveListForPreassessmentOutcVo;
import ims.RefMan.vo.domain.PatientElectiveListForPreassessmentOutcVoAssembler;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientAlertLiteVoCollection;
import ims.core.vo.domain.PatientAlertLiteVoAssembler;
import ims.core.vo.lookups.AlertAccessRights;
import ims.core.vo.lookups.AlertType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.IAlertsAccess;
import ims.framework.interfaces.IAppRole;

public class PreAssessmentOutcomeDlgImpl extends BasePreAssessmentOutcomeDlgImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.PatientElectiveListForPreassessmentOutcVo getPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo patElectListRef)
	{
		if( patElectListRef == null )
			return null;
			
		PatientElectiveList doPatientElectiveList = (PatientElectiveList) getDomainFactory().getDomainObject(PatientElectiveList.class, patElectListRef.getID_PatientElectiveList());
		
		return PatientElectiveListForPreassessmentOutcVoAssembler.create(doPatientElectiveList);
	}

	public PatientAlertLiteVoCollection listAlerts(PatientRefVo patient, IAppRole role)
	{
		if(patient == null)
			throw new CodingRuntimeException("Cannot list Patient Alerts on null Patient Id.");
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select patAlrt from PatientAlert patAlrt left join patAlrt.alertType as alertType ");
		hql.append(" where patAlrt.patient.id = :patient");
		names.add("patient");
		values.add(patient.getID_Patient());
		
		hql.append (" and patAlrt.isCurrentlyActiveAlert = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);
		
		String alertCategoryIds = getAlertCategoryIds(role);
		if(alertCategoryIds == null || alertCategoryIds.length() == 0)
			return null;
		
		hql.append (" and alertType.parent is not null and alertType.parent.id in (");
		hql.append(alertCategoryIds);
		hql.append(")");
		
		hql.append (" and alertType.parent.id = :alertTypeH");
		names.add("alertTypeH");
		values.add(AlertType.ANAESTHETIC_HAZARDS.getID());
		
		hql.append(" order by patAlrt.systemInformation.creationDateTime desc");
	
		List<?> list = factory.find(hql.toString(), names,values);
		return(PatientAlertLiteVoAssembler.createPatientAlertLiteVoCollectionFromPatientAlert(list));
	}
	
	private String getAlertCategoryIds(IAppRole role)
	{
		IAlertsAccess[] alertsAccessList = role.getAlertsAccessList();
		
		String ids = "";
		
		for(int i=0; i<alertsAccessList.length; i++)
		{
			IAlertsAccess alertAccess = alertsAccessList[i];
			
			if(alertAccess == null)
				continue;
			
			if(!(alertAccess.getIAlertType() instanceof AlertType) || !(alertAccess.getIAccess() instanceof AlertAccessRights))
				continue;
			
			AlertType alertType = (AlertType) alertAccess.getIAlertType();
			AlertAccessRights access = (AlertAccessRights) alertAccess.getIAccess();
			
			if(AlertAccessRights.READ_ONLY.equals(access) || AlertAccessRights.READ_WRITE.equals(access))
			{
				ids += (ids.length() > 0 ? "," : "") + alertType.getID();
			}
		}
		
		return ids.length() > 0 ? ids : null;
	}

	public void save(PatientElectiveListForPreassessmentOutcVo record) throws StaleObjectException, UniqueKeyViolationException
	{
		if( record == null)
			throw new CodingRuntimeException("Cannot save a null PatientElectiveList.");
		
		
		
		DomainFactory factory = getDomainFactory();
		
		//if( record.getPreAssessmentOutcome().getID_PreAssessmentOutcomeIsNotNull())
		//{
		//	PreAssessmentOutcome doPreAssessmentOutcome = PreAssessmentOutcomeVoAssembler.extractPreAssessmentOutcome(factory, record.getPreAssessmentOutcome());
		//	factory.save(doPreAssessmentOutcome);
			
		//}
		//else
		//{
		PatientElectiveList doPatientElectiveList =  PatientElectiveListForPreassessmentOutcVoAssembler.extractPatientElectiveList(factory, record);
		factory.save(doPatientElectiveList);
		//}
		
	}
}
