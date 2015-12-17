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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.62 build 3126.20282)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.assessment.forms.pathwayoverview;

import ims.assessment.configuration.vo.GraphicAssessmentRefVo;
import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.forms.pathwayoverview.GenForm.grdPathwayRow;
import ims.assessment.forms.screeningoverview.GenForm;
import ims.assessment.vo.PathwayOverviewSearchCriteriaVo;
import ims.assessment.vo.PathwayOverviewVo;
import ims.assessment.vo.PathwayOverviewVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onBtnCreatePathwayClick() throws PresentationLogicException 
	{
		open();
		form.getGlobalContext().Assessment.setPathwayOverviewSearchCriteria(getSearchCriteria()); //WDEV-19389 
	}
	
	private PathwayOverviewSearchCriteriaVo getSearchCriteria()
	{
		PathwayOverviewSearchCriteriaVo searchCriteria = new PathwayOverviewSearchCriteriaVo();
		
		searchCriteria.setPathway(form.cmbPathway().getValue());
		searchCriteria.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		return searchCriteria;
	}
	
	private void setSearchCriteria(PathwayOverviewSearchCriteriaVo pathwayOverviewSearchCriteriaVo) 
	{
		form.cmbPathway().setValue(pathwayOverviewSearchCriteriaVo.getPathway());
	}

	protected void onCmbPathwayValueChanged() throws PresentationLogicException 
	{				
		if (form.cmbPathway().getValue() != null)
		{
			form.btnCreatePathway().setEnabled(true);
		}
		else
		{
			form.btnCreatePathway().setEnabled(false);
			form.grdPathway().getRows().clear();
			form.getGlobalContext().Assessment.setPathwayOverviewSearchCriteria(null);
		}
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{	
		form.btnCreatePathway().setEnabled(false);
		form.grdPathway().getRows().clear();
		
		form.getContextMenus().Assessment.getScreenProfileConfigurationVIEW_CONFIGURATIONItem().setText("View Assessment");
		form.getContextMenus().Assessment.getScreenProfileConfigurationEDIT_CONFIGURATIONItem().setText("Edit Assessment");
		
		//WDEV-19389 
		if (!(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Assessment.getPathwayOverviewSearchCriteriaIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().equals(form.getGlobalContext().Assessment.getPathwayOverviewSearchCriteria().getCareContext())))
			form.getGlobalContext().Assessment.setPathwayOverviewSearchCriteria(null);
		
		if(form.getGlobalContext().Assessment.getPathwayOverviewSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().Assessment.getPathwayOverviewSearchCriteria());
			form.btnCreatePathway().setEnabled(true);
			open();
		}
		//WDEV-19389 - end
	}
	
	private void open()
	{
		form.grdPathway().getRows().clear();
		int typeID = form.cmbPathway().getValue().getID();
		String type = form.cmbPathway().getValue().getText();		
		PathwayOverviewVoCollection coll = domain.listProfilesByContextType(form.getGlobalContext().Core.getCurrentCareContext(), new Integer(typeID));		
		displayData(coll, type);
	}
	
	private void displayData(PathwayOverviewVoCollection coll, String profileName)
	{
		for (int i = 0; i < coll.size(); i++)
		{
			PathwayOverviewVo item = coll.get(i);
			
			grdPathwayRow row = form.grdPathway().getRows().newRow();
			
			row.setcolAssessment(item.getUserAssessmentNameIsNotNull() ? item.getUserAssessmentName() : item.getGraphicAssessmentName());
			row.setcolStatus(item.getStatusIsNotNull() ? item.getStatus() : "Outstanding");
			
			row.setValue(item);
		}				
	}

	protected void onGrdPathwaySelectionChanged() throws PresentationLogicException 
	{
		enableContextMenu();
	}

	private void enableContextMenu()
	{
		boolean objSelected = form.grdPathway().getSelectedRowIndex() >= 0;
		form.getContextMenus().Assessment.getScreenProfileConfigurationADD_CONFIGURATIONItem().setVisible(false);
		form.getContextMenus().Assessment.getScreenProfileConfigurationEDIT_CONFIGURATIONItem().setVisible(objSelected);
		form.getContextMenus().Assessment.getScreenProfileConfigurationVIEW_CONFIGURATIONItem().setVisible(objSelected);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.AssessmentNamespace.ScreenProfileConfiguration.VIEW_CONFIGURATION:
				viewAssessment();
				break;
			case GenForm.ContextMenus.AssessmentNamespace.ScreenProfileConfiguration.EDIT_CONFIGURATION:
				editAssessment();
				break;
			default:
					break;
		}
		
	}

	private void viewAssessment()
	{
		UserAssessmentRefVo refUA = null;
		GraphicAssessmentRefVo refGA = null;
		
		form.getGlobalContext().Clinical.setReturnToFormName(form.getForms().Assessment.PathwayOverview);
		form.getGlobalContext().Core.setUserDefinedFormMode(FormMode.VIEW);
		
		if(form.grdPathway().getValue().getUserAssessmentIDIsNotNull())
		{
			refUA = new UserAssessmentRefVo();
			refUA.setID_UserAssessment(form.grdPathway().getValue().getUserAssessmentID());
			engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {refUA});
		}
		else if(form.grdPathway().getValue().getGraphicAssessmentIDIsNotNull())
		{
			refGA = new GraphicAssessmentRefVo();
			refGA.setID_GraphicAssessment(form.grdPathway().getValue().getGraphicAssessmentID());
			engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {refGA});
		}
		
	}
	
	private void editAssessment()
	{
		UserAssessmentRefVo refUA = null;
		GraphicAssessmentRefVo refGA = null;
		
		form.getGlobalContext().Clinical.setReturnToFormName(form.getForms().Assessment.PathwayOverview);
		form.getGlobalContext().Core.setUserDefinedFormMode(FormMode.EDIT);
		
		if(form.grdPathway().getValue().getUserAssessmentIDIsNotNull())
		{
			refUA = new UserAssessmentRefVo();
			refUA.setID_UserAssessment(form.grdPathway().getValue().getUserAssessmentID());
			engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {refUA});
		}
		else if(form.grdPathway().getValue().getGraphicAssessmentIDIsNotNull())
		{
			refGA = new GraphicAssessmentRefVo();
			refGA.setID_GraphicAssessment(form.grdPathway().getValue().getGraphicAssessmentID());
			engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {refGA});
		}		
	}	
}
