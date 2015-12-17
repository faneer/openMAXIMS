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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseAppointmentOutcomeDiagnosisSelectionDialogImpl;
import ims.RefMan.vo.PatientDiagnosisForAppointmentOutcomeVoCollection;
import ims.RefMan.vo.domain.PatientDiagnosisForAppointmentOutcomeVoAssembler;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.DomainFactory;

import java.util.ArrayList;
import java.util.List;

public class AppointmentOutcomeDiagnosisSelectionDialogImpl extends BaseAppointmentOutcomeDiagnosisSelectionDialogImpl
{

	private static final long serialVersionUID = 1L;

	public PatientDiagnosisForAppointmentOutcomeVoCollection listPatientDiagnosis(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
		return PatientDiagnosisForAppointmentOutcomeVoAssembler.createPatientDiagnosisForAppointmentOutcomeVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(patientRefVo, true, false, false)).sort();
	}
	
	private List listDiagnosesForPatient(PatientRefVo patrefvo, boolean boolDiagnosis, boolean boolComplication, boolean boolExcludeResolved)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";
 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		condStr.append(andStr + " patdiag.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patrefvo.getID_Patient());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " (patdiag.isComplication = :complication OR patdiag.isComplication is null) ");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}
		
		if (boolExcludeResolved)
		{
			condStr.append(andStr + " patdiag.isResolved = :excresolved");
			markers.add("excresolved");
			values.add(Boolean.FALSE);
		}

		hql += " where ";

		hql += condStr.toString();
		List list = factory.find(hql,markers,values);
		return list;		
	}
	
}
