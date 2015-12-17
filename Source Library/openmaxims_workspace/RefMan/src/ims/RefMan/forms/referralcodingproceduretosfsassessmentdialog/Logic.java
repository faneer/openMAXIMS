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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.referralcodingproceduretosfsassessmentdialog;

import ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientProcedureLiteVo;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccAuthoring().initializeComponent();
		form.ccAuthoring().setIsRequiredPropertyToControls(true);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private SuitableForSurgeryAssessmentLiteVo populateDataFromScreen()
	{
		SuitableForSurgeryAssessmentLiteVo assessment = new SuitableForSurgeryAssessmentLiteVo();
			
		PatientProcedureLiteVo voPatientProcedure = domain.getProcedureLiteVo(form.getGlobalContext().Clinical.getPatientProcedureForIntraOperativeDialog());

		assessment.setCareContext(voPatientProcedure.getCareContext());
		assessment.setAuthoringInformation(form.ccAuthoring().getValue());
		assessment.setProcedure(voPatientProcedure);
		assessment.setSuitableForSurgeryDate(form.dteSuitable().getValue());
		assessment.setSuitableForSurgery(YesNoUnknown.YES);
		assessment.setProcedurePerformed(Boolean.TRUE);
		
		return assessment;
	}

	private boolean save() throws PresentationLogicException
	{
		StringBuffer sb = new StringBuffer();
		
		if(form.ccAuthoring().getValue().getAuthoringHcp() == null)
			sb.append("Authoring HCP is mandatory.\n\n");
		if(form.ccAuthoring().getValue().getAuthoringDateTime() == null)
			sb.append("Authoring DateTime is mandatory.\n\n");
		if(form.dteSuitable().getValue() == null)
			sb.append("Suitable Date is mandatory.");
		
		if (sb.length() > 0)
		{
			engine.showMessage(sb.toString());
			return false;
		}

		SuitableForSurgeryAssessmentLiteVo assessment = populateDataFromScreen();
		
		String[] errors = assessment.validate();
		if (errors != null && errors.length != 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			assessment = domain.saveAssessment(assessment); 
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		return true;
	}

}
