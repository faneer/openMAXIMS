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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.oncology.forms.patientstreatmentplanactionsdialog;

import ims.ccosched.vo.PatTrPlanGroupSiteTechVo;
import ims.ccosched.vo.PatTrPlanGroupSiteTechVoCollection;
import ims.ccosched.vo.PatTreatPlanActionLiteVo;
import ims.ccosched.vo.PatTreatPlanActionLiteVoCollection;
import ims.dtomove.vo.ActivityActionVo;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.oncology.forms.patientstreatmentplanactionsdialog.GenForm.grdActionsRow;
import ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection;
import ims.oncology.vo.RadiotherapyDetailsLiteDialogVoCollection;

import java.text.ParseException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		 
		PatTreatmentPlanRadiotherapyDialogVoCollection voColl;
		RadiotherapyDetailsLiteDialogVoCollection voExistingActionColl;
		try 
		{
			voColl = domain.listActivePatTreatMentPlans(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getEpisodeofCareShort());
			voExistingActionColl = domain.listActionsAlreadyLinkedToRadiotherapy(form.getGlobalContext().Core.getPatientShort());
		} 
		catch (NumberFormatException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		} 
		if (voColl == null || voColl.size() == 0 )
			engine.showMessage("No Records found.");
		
		form.grdActions().getRows().clear();
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			PatTreatPlanActionLiteVoCollection voActionsColl = voColl.get(i).getActions();
			
			grdActionsRow row = null;
			for (int j = 0 ; voActionsColl != null && j < voActionsColl.size() ; j++)
			{
				ActivityActionVo voAction = voActionsColl.get(j).getAction();
				
				//WDEV-15378
				if ( ! checkIfNoLinkedRecordYet(voActionsColl.get(j), voExistingActionColl) 
						&& voActionsColl.get(j).getActiveIsNotNull()
						&& voActionsColl.get(j).getActive()
						&& voActionsColl.get(j).getActivityIsNotNull()
						&& (voActionsColl.get(j).getActivity().getActivityId().equals(-204) //-204, -206, -202, -205, -207
							|| 	voActionsColl.get(j).getActivity().getActivityId().equals(-206)
							|| 	voActionsColl.get(j).getActivity().getActivityId().equals(-202)
							|| 	voActionsColl.get(j).getActivity().getActivityId().equals(-205)
							|| 	voActionsColl.get(j).getActivity().getActivityId().equals(-207)) ) 
				{
					row = form.grdActions().getRows().newRow();
					row.setcolAction(voAction!= null && voAction.getActionIsNotNull() ? voAction.getAction().getName() : "");
					
					row.setcolTreatDate(voColl.get(i).getDecisionToTreatIsNotNull() ? voColl.get(i).getDecisionToTreat().toString() : "");
					row.setcolSites(creatSiteString(voActionsColl.get(j).getGroupSiteTech()));
					row.setTooltipForcolSites(creatSiteString(voActionsColl.get(j).getGroupSiteTech()));//WDEV-14593
					
					row.setcolCons(voActionsColl.get(j).getTreatingConsultantIsNotNull() ? voActionsColl.get(j).getTreatingConsultant().getIMosName().toString() : "");
					row.setValue(voActionsColl.get(j));
				}
			}
		}
		
		
		if (form.grdActions().getRows().size() == 0)
		{
			engine.showMessage("No active and unused actions for the treatment plan(s) found.","No actions found", MessageButtons.OK, MessageIcon.INFORMATION);
			engine.close(DialogResult.CANCEL);
			return;
		}

		form.btnSave().setEnabled(false);
		form.getGlobalContext().Oncology.setRadiotherapyPatTreatmentPlanAction(null);
		form.getGlobalContext().Oncology.setDecisionTreatFromDialog(null);
	}

	private boolean checkIfNoLinkedRecordYet(PatTreatPlanActionLiteVo voAction, RadiotherapyDetailsLiteDialogVoCollection voExistingActionColl) 
	{
		for (int i = 0 ; voExistingActionColl != null && i < voExistingActionColl.size() ; i++)
		{
			if (voExistingActionColl.get(i).getAssociatedTreatmentPlanActionIsNotNull()
				&& voAction.getID_PatAction().equals(voExistingActionColl.get(i).getAssociatedTreatmentPlanAction().getID_PatAction()))
				return true;
		}
		return false;
	}

	private String creatSiteString(PatTrPlanGroupSiteTechVoCollection patTrPlanGroupSiteTechVoCollection) 
	{
		if (patTrPlanGroupSiteTechVoCollection == null)
			return "";
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < patTrPlanGroupSiteTechVoCollection.size() ; i++)
		{
			PatTrPlanGroupSiteTechVo voGST = patTrPlanGroupSiteTechVoCollection.get(i);
			sb.append(voGST.getTreatmentGroupSiteIsNotNull() && voGST.getTreatmentGroupSite().getParentInstance() != null ? voGST.getTreatmentGroupSite().getParentInstance().getText() : voGST.getTreatmentGroupSite().getText());
			if (voGST.getTreatmentGroupSite().getParentInstance() != null)
			{
				sb.append(" - ");
				sb.append(voGST.getTreatmentGroupSite().getText());
				sb.append(" "); 
			}
			else
			{
				if (patTrPlanGroupSiteTechVoCollection.size() > i+1)
					sb.append(", "); 
			}
		
			
//			sb.append(collSites.get(i).getTreatmentGroupIsNotNull() ? collSites.get(i).getTreatmentGroup().getName() : "");
//			if (collSites.get(i).getTreatmentGroupIsNotNull() && collSites.get(i).getTreatmentSite() == null && collSites.size() > i+1)
//				sb.append(","); 

//			if (collSites.get(i).getTreatmentGroupIsNotNull() && collSites.get(i).getTreatmentSiteIsNotNull())
//				sb.append(" - "); 
				
//			sb.append(collSites.get(i).getTreatmentSiteIsNotNull() ? collSites.get(i).getTreatmentSite().getDescription() : "");
//			if (collSites.get(i).getTreatmentSiteIsNotNull() && collSites.size() > i+1)
//				sb.append(","); 
		}
		
		return sb.toString();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Oncology.setRadiotherapyPatTreatmentPlanAction(form.grdActions().getSelectedRow().getValue());
		try 
		{
			form.getGlobalContext().Oncology.setDecisionTreatFromDialog(form.grdActions().getSelectedRow().getcolTreatDate() != null ? new Date(form.grdActions().getSelectedRow().getcolTreatDate()) : null);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Oncology.setRadiotherapyPatTreatmentPlanAction(null);
		form.getGlobalContext().Oncology.setDecisionTreatFromDialog(null);
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onGrdActionsSelectionChanged() throws PresentationLogicException 
	{
		form.btnSave().setEnabled(true);
		
	}
}
