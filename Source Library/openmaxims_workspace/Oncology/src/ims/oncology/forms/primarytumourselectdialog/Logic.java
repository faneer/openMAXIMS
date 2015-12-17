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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.55 build 2757.28809)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.forms.primarytumourselectdialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.oncology.vo.PrimaryTumourDetailsShortVo;
import ims.oncology.vo.PrimaryTumourDetailsShortVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		PrimaryTumourDetailsShortVoCollection coll = domain.listPrimaryTumourForCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		for (int i = 0 ; coll != null && i < coll.size() ; i++)
		{
			StringBuffer sb = new StringBuffer();
			sb.append(coll.get(i).getTumourGroupIsNotNull() ? coll.get(i).getTumourGroup().getGroupName() : " --- ");
			sb.append(" / ");
			sb.append(coll.get(i).getTumourSiteIsNotNull() ? coll.get(i).getTumourSite().getName() : " --- ");
			sb.append(" / ");
			sb.append(coll.get(i).getPatientDiagnosisIsNotNull() && coll.get(i).getPatientDiagnosis().getDiagnosedDateIsNotNull() 
					? coll.get(i).getPatientDiagnosis().getDiagnosedDate().toString() : " --- ");
			sb.append(" / ");
			sb.append(coll.get(i).getPreTreatmentOverallIsNotNull() ? coll.get(i).getPreTreatmentOverall().getOverallStageDescription() : " --- ");
			
			form.treTumours().getNodes().add(coll.get(i), sb.toString());
		}
		
		form.setMode(FormMode.EDIT);
		form.btnSave().setEnabled(false);
	}
	
	@Override
	protected void onTreTumoursTreeViewCheck(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i = 0 ; i < form.treTumours().getNodes().size() ; i++)
		{
			if (form.treTumours().getNodes().get(i).isChecked() && form.treTumours().getNodes().get(i) != node)
				form.treTumours().getNodes().get(i).setChecked(false);
		}
		form.btnSave().setEnabled(true);
	}
	
	@Override
	protected void onTreTumoursTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i = 0 ; i < form.treTumours().getNodes().size() ; i++)
		{
			if (form.treTumours().getNodes().get(i).isChecked())
				form.getGlobalContext().Oncology.setSelectedPrimaryTumourDetail((PrimaryTumourDetailsShortVo)form.treTumours().getNodes().get(i).getValue());
		}
		
		engine.close(DialogResult.OK);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-18105
		form.getGlobalContext().Oncology.setSelectedPrimaryTumourDetail(null);
		engine.close(DialogResult.CANCEL);
	}
}
