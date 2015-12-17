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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseDementiaAssessmentFINDComponentImpl;
import ims.clinical.vo.domain.DementiaVoAssembler;
import ims.clinicaladmin.vo.DementiaTermConfigVo;
import ims.clinicaladmin.vo.domain.DementiaTermConfigVoAssembler;
import ims.core.admin.domain.objects.DementiaTermConfig;
import ims.core.clinical.domain.objects.Dementia;
import ims.core.vo.lookups.YesNo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class DementiaAssessmentFINDComponentImpl extends BaseDementiaAssessmentFINDComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.DementiaVo saveDementia(ims.clinical.vo.DementiaVo dementiaToSave,FormName formName) throws ims.domain.exceptions.StaleObjectException
	{
		if (dementiaToSave == null )
		{
			throw new CodingRuntimeException("Cannot get DementiaVo on null Id ");
		}
		
		//WDEV-16247
		if (dementiaToSave.getID_DementiaIsNotNull() && dementiaToSave.getStepOneFindIsNotNull() && dementiaToSave.getStepOneFind().getID_DementiaFindIsNotNull()
				&& (YesNo.YES.equals(dementiaToSave.getStepOneFind().getHasFormalDiagnosisOfDementia()) || (YesNo.NO.equals(dementiaToSave.getStepOneFind().getHasFormalDiagnosisOfDementia())&& YesNo.NO.equals(dementiaToSave.getStepOneFind().getDeliriumConfirmed()) && YesNo.NO.equals(dementiaToSave.getStepOneFind().getAwarenessQuestion())))
				&& (dementiaToSave.getStepTwoAssessIsNotNull() && dementiaToSave.getStepTwoAssess().getID_DementiaAssessAndInvestigateIsNotNull()))
		{
			String rieMessage = "THIS RECORD HAS BEEN MARKED AS RECORDED IN ERROR BY MAXIMS DEMENTIA - REASON : record is not relevant because of Edit to FIND record";
			Integer patientId = dementiaToSave.getPatient().getID_Patient();
			
			if (dementiaToSave.getStepTwoAssess().getStepTwoAssessNoteIsNotNull()) 
			{
				markAsRie(dementiaToSave.getStepTwoAssess().getStepTwoAssessNote(), formName, patientId, null, null, rieMessage);
			}
			markAsRie(dementiaToSave.getStepTwoAssess(), formName, patientId, null, null, rieMessage);
			
			dementiaToSave.setStepTwoAssess(null);
			dementiaToSave.setAMTSScore(null);
		//	dementiaToSave.setDeliriumConfirmed(null);
		//	dementiaToSave.setDementiaConfirmed(null);
			dementiaToSave.setConfirmedPatientPutOnDementiaPathway(null);
	
		}
		
		String[] arrErrors = dementiaToSave.validate();
		
		if( arrErrors != null)
			throw new DomainRuntimeException("Error saving voDementia - not validated correctly");
		
		DomainFactory factory = getDomainFactory();
		Dementia domainDementia = DementiaVoAssembler.extractDementia(factory, dementiaToSave);
		factory.save(domainDementia);
		return DementiaVoAssembler.create(domainDementia);
	}

	public ims.clinical.vo.DementiaVo getDementia(ims.core.clinical.vo.DementiaRefVo dementiaRef)
	{
		if (dementiaRef == null || dementiaRef.getID_Dementia()== null)
		{
			throw new CodingRuntimeException("Cannot get DementiaVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		Dementia domainDementia = (Dementia) factory.getDomainObject(Dementia.class, dementiaRef.getID_Dementia());

		return DementiaVoAssembler.create(domainDementia);
	}

	public DementiaTermConfigVo getHintByLookupID(ims.clinicaladmin.vo.lookups.DementiaTermConfig volookup)
	{
		if( volookup == null)
			throw new CodingRuntimeException("DementiaTermConfig is null");

		DomainFactory factory = getDomainFactory();

		String hql = " from DementiaTermConfig as dtg 	where ( dtg.field.id =:fld )"; 

		List <?> list = factory.find(hql,new String[]{"fld"}, new Object[]{volookup.getID()});

		if (list != null && list.size() > 0)
		{
			DementiaTermConfig doDementiaTermConfig = (DementiaTermConfig)list.get(0);
			return DementiaTermConfigVoAssembler.create(doDementiaTermConfig);
		}
		return null;
	}

}
