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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.65 build 3225.30788)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.naes.forms.actionplandialog;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.ActionPlanTemplateVo;
import ims.core.vo.ActionPlanTemplateVoCollection;
import ims.core.vo.ActionPlanVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.controls.DynamicGridRowCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.naes.vo.ActionDetailStatusVo;
import ims.naes.vo.ActionDetailStatusVoCollection;
import ims.naes.vo.ActionDetailVo;
import ims.naes.vo.ActionDetailVoCollection;
import ims.naes.vo.lookups.Action;
import ims.naes.vo.lookups.ActionCollection;
import ims.naes.vo.lookups.NaesActionStatus;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(args != null && args.length == 2)
		{
			if(args[0] instanceof Boolean ){
				Boolean completedSceleraExists = (Boolean) args[0];
				form.getLocalContext().setCompletedSceleraExists(completedSceleraExists);
			}
			if(args[1] instanceof Boolean ){
				Boolean completedLabExists = (Boolean) args[1];
				form.getLocalContext().setCompletedLabExists(completedLabExists);
			}
		}
		
		createGrid();
		form.dyngrdActionPlans().getRows().clear();
		populateGrid();
		
		ActionPlanVo  voActionPlan  = form.getGlobalContext().Naes.getActionPlanTemplates();
		form.txtFinalCureCode().setValue(voActionPlan.getFinalCure());
		form.txtScleraCode().setValue(voActionPlan.getSclera());
		
		//WDEV-11573
		MemberOfStaffLiteVo voMember = (MemberOfStaffLiteVo) domain.getMosUser();
		if(voMember != null)
		{
			form.qmbTechnician().newRow(voMember, voMember.getIMosName());
			form.qmbTechnician().setValue(voMember);
		}
	}

	private void createGrid()
	{
		form.dyngrdActionPlans().setHeaderHeight(20);
		DynamicGridColumn actionCol = form.dyngrdActionPlans().getColumns().newColumn("Action Plans");
		DynamicGridColumn descriptionCol = form.dyngrdActionPlans().getColumns().newColumn("Description");
		DynamicGridColumn selectCol = form.dyngrdActionPlans().getColumns().newColumn("");
		actionCol.setWidth(150);
		descriptionCol.setWidth(150);
		selectCol.setWidth(50);

	}

	private void populateGrid()
	{
		ActionPlanTemplateVoCollection activeTemplates = domain.getActiveActionPlanTemplates();

		for (int i = 0; i < activeTemplates.size(); i++)
		{
			DynamicGridRow row = form.dyngrdActionPlans().getRows().newRow();
			row.setValue(activeTemplates.get(i));
			row.setSelectable(false);

			DynamicGridCell actionCell = row.getCells().newCell(form.dyngrdActionPlans().getColumns().get(0), DynamicCellType.STRING);
			actionCell.setReadOnly(true);
			actionCell.setValue(activeTemplates.get(i).getActionPlanName());

			DynamicGridCell selectcell = row.getCells().newCell(form.dyngrdActionPlans().getColumns().get(2), DynamicCellType.BOOL);
			selectcell.setAutoPostBack(true);
			selectcell.setValue(false);

			DynamicGridCell DescriptionCell = row.getCells().newCell(form.dyngrdActionPlans().getColumns().get(1), DynamicCellType.STRING);
			DescriptionCell.setValue(activeTemplates.get(i).getDescription());
			DescriptionCell.setReadOnly(true);
			
			
			createActions(row, activeTemplates.get(i));

		}

	}

			
	private void createActions(DynamicGridRow row, ActionPlanTemplateVo actionPlanTemplateVo)
	{
		for (int i = 0; i < actionPlanTemplateVo.getActions().size(); i++)
		{
			DynamicGridRow childRow = row.getRows().newRow();
			childRow.setValue(actionPlanTemplateVo.getActions().get(i).getActions());
			childRow.setSelectable(false);
			DynamicGridCell statusCell = childRow.getCells().newCell(form.dyngrdActionPlans().getColumns().get(0), DynamicCellType.STRING);
			statusCell.setValue(actionPlanTemplateVo.getActions().get(i).getActions().getIItemText());

			DynamicGridCell selectcell = childRow.getCells().newCell(form.dyngrdActionPlans().getColumns().get(1), DynamicCellType.BOOL);
			selectcell.setAutoPostBack(true);
			selectcell.setValue(false);

		}
	}

	@Override
	protected void onBtnOkClicked() throws ims.framework.exceptions.PresentationLogicException
	{
		ActionPlanVo selectedTemplates = populateDataFromScreen();
		
		//WDEV-9655 - starts hre
		List<String> uiErrors = new ArrayList<String>();
		if(Boolean.TRUE.equals(form.getLocalContext().getCompletedSceleraExists()) && form.txtScleraCode().getValue()==null)
		{
			uiErrors.add("Sclera Code is mandatory when completed Sclera action exists");
		}
		if(Boolean.TRUE.equals(form.getLocalContext().getCompletedLabExists()) && form.txtFinalCureCode().getValue()==null)
		{
			uiErrors.add("Final Cure Code is mandatory when completed Final Cure action exists");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		if(uiResults.length > 0)
		{
			engine.showErrors(uiResults);
			form.getLocalContext().setCompletedSceleraExists(null);	//WDEV-9655
			form.getLocalContext().setCompletedLabExists(null);	//WDEV-9655
			return;
		}
		//WDEV-9655 - ends here
		
		if(form.getGlobalContext().Naes.getActionPlanTemplates()== null)
		{
			String []errors = selectedTemplates.validate();
			
			if(errors != null)
			{
				engine.showErrors(errors);
				return;	
			}
			
			form.getGlobalContext().Naes.setActionPlanTemplates(selectedTemplates);
		}
		else
		{
			form.getGlobalContext().Naes.getActionPlanTemplates().setFinalCure(form.txtFinalCureCode().getValue());
			form.getGlobalContext().Naes.getActionPlanTemplates().setSclera(form.txtScleraCode().getValue());
			
			if(selectedTemplates.getActions().size()>0)
				for (int i = 0; i < selectedTemplates.getActions().size(); i++)
				{
					String[] actionError = selectedTemplates.getActions().get(i).validate();
					
					if(actionError != null)
					{
						engine.showErrors(actionError);
						return;
					}
					
					form.getGlobalContext().Naes.getActionPlanTemplates().getActions().add(selectedTemplates.getActions().get(i));
				}
			else{
				engine.showMessage("No templates selected");
				return;
			}
		}
		
		
		
		engine.close(DialogResult.OK);
	}

	private ActionPlanVo populateDataFromScreen()
	{
		ActionPlanVo actionPlanvo = new ActionPlanVo();

		actionPlanvo.setComment("");
		actionPlanvo.setDateCommenced(new Date());
		actionPlanvo.setOrderNumber("");
		actionPlanvo.setActions(createActionsDetails());
		
		return actionPlanvo;
	}

	private ActionDetailVoCollection createActionsDetails()
	{
		ActionDetailVoCollection actionDetailvoColl = new ActionDetailVoCollection();
		for (int i = 0; i < form.dyngrdActionPlans().getRows().size(); i++)
		{
			ActionCollection actions = new ActionCollection();
			if (form.dyngrdActionPlans().getRows().get(i).getParent() == null)
			{
				DynamicGridRow row = form.dyngrdActionPlans().getRows().get(i);
				ActionPlanTemplateVo selectedTemplate = (ActionPlanTemplateVo) row.getValue();

				Boolean x = (Boolean) row.getCells().get(form.dyngrdActionPlans().getColumns().get(2)).getValue();
				if (x == true)
				{
					DynamicGridRowCollection childrows = row.getRows();

					for (int j = 0; j < childrows.size(); j++)
					{
						Boolean y = (Boolean) childrows.get(j).getCells().get(form.dyngrdActionPlans().getColumns().get(1)).getValue();

						if (y == true)
						{
							actions.add((Action) childrows.get(j).getValue());
						}
					}

					boolean nStartDateAdded = false;
					boolean nResponsibleTechnicianAdded = false;
					for (int j = 0; j < actions.size(); j++)
					{
						ActionDetailVo actionDetails = new ActionDetailVo();
						ActionDetailStatusVo actionStatus = new ActionDetailStatusVo();

						actionStatus.setStatusDateTime(new DateTime());
						actionStatus.setTechnician(form.qmbTechnician().getValue());
						actionStatus.setStatus(form.cmbStatus().getValue());

						if(!nResponsibleTechnicianAdded){
							actionDetails.setResponsibleTechnician(form.qmbTechnician().getValue());
							nResponsibleTechnicianAdded = true;
						}
						actionDetails.setAction(actions.get(j));
						actionDetails.setCurrentStatus(actionStatus);

						actionDetails.setStatusHistory(new ActionDetailStatusVoCollection());
						actionDetails.setActionTemplate(selectedTemplate);
						
						if (form.dteActionDate().getValue() != null && !nStartDateAdded)
						{
							actionDetails.setStartDate(form.dteActionDate().getValue());
							
							nStartDateAdded = true;
						}
						actionDetailvoColl.add(actionDetails);
						
						//WDEV-9655 - starts here
						Boolean completedLabExists = actionDetails.getActionIsNotNull() && actionDetails.getActionIsNotNull()
														&& actionDetails.getAction().equals(Action.LABCOMP)
														&& actionDetails.getCurrentStatusIsNotNull() 
														&& actionDetails.getCurrentStatus().getStatusIsNotNull()
														&& actionDetails.getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED);

						if(!form.getLocalContext().getCompletedLabExistsIsNotNull() || (form.getLocalContext().getCompletedLabExistsIsNotNull() && Boolean.FALSE.equals(form.getLocalContext().getCompletedLabExists())))
							form.getLocalContext().setCompletedLabExists(completedLabExists);
						
						Boolean completedSceleraExists = actionDetails.getActionIsNotNull() && actionDetails.getActionIsNotNull()
															&&	actionDetails.getAction().equals(Action.SCLERACODEVERIFIED)
															&& actionDetails.getCurrentStatusIsNotNull() 
															&& actionDetails.getCurrentStatus().getStatusIsNotNull()
															&& actionDetails.getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED );
						
						if(!form.getLocalContext().getCompletedSceleraExistsIsNotNull() || (form.getLocalContext().getCompletedSceleraExistsIsNotNull() && Boolean.FALSE.equals(form.getLocalContext().getCompletedSceleraExists())))
							form.getLocalContext().setCompletedSceleraExists(completedSceleraExists);
						//WDEV-9655 - ends here
					}
					
				}
			}

		}
		return actionDetailvoColl;
	}

	@Override
	protected void onBtnCancelClicked() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);

	}

	@Override
	protected void onqmbTechnicianTextSubmitted(String value) throws PresentationLogicException
	{
		//wdev-11680
		form.qmbTechnician().clear();
		//-----------
		MemberOfStaffLiteVoCollection activeMos = domain.getMembersOfStaff(value);

		for (int i = 0; i < activeMos.size(); i++)
		{
			form.qmbTechnician().newRow(activeMos.get(i), activeMos.get(i).getName().toShortForm());
			form.qmbTechnician().showOpened();

		}

	}

	@Override
	protected void onDynGridActionPlansCellValueChanged(DynamicGridCell cell)
	{
		if (cell.getType().equals(DynamicCellType.BOOL) && cell.getRow().getParent() == null)
		{
			DynamicGridRow row = cell.getRow();
			DynamicGridRowCollection childRows = row.getRows();

			for (int i = 0; i < childRows.size(); i++)
			{
				childRows.get(i).getCells().get(form.dyngrdActionPlans().getColumns().get(1)).setValue(cell.getValue());
			}
		}
		if (cell.getType().equals(DynamicCellType.BOOL) && cell.getRow().getParent() != null)
		{

			DynamicGridRow parentRow = cell.getRow().getParent();
			parentRow.getCells().get(form.dyngrdActionPlans().getColumns().get(2)).setValue(true);

		}

	}
}
