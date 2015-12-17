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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.psaconfig;

import ims.clinicaladmin.forms.psaconfig.GenForm.grdPSAConfigRow;
import ims.clinicaladmin.forms.selecttumourhistology.GenForm;
import ims.clinicaladmin.forms.tumourhistologyconfig.GenForm.grdHistologiesRow;
import ims.clinicaladmin.vo.PSAConfigVo;
import ims.clinicaladmin.vo.PSAConfigVoCollection;
import ims.clinicaladmin.vo.TumourHistologyLiteVo;
import ims.clinicaladmin.vo.TumourHistologyLiteVoCollection;
import ims.clinicaladmin.vo.TumourHistologyVo;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	public void initialize()
	{
		form.getLocalContext().setSelectedPASConfig(null);
		// Initialize context menu
		form.getContextMenus().hideAllGenericGridMenuItems();

		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
		form.ctnDetails().setCollapsed(true);
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
		//form.getLocalContext().setSelectedPASConfig(domain.getPASConfig(form.grdPSAConfig().getValue()));
		populatePASConfigGrid(domain.listPASConfiguration());
		form.grdPSAConfig().setValue(form.getLocalContext().getSelectedPASConfig());
		//form.getLocalContext().setSelectedPASConfig(domain.getPASConfig(form.grdPSAConfig().getValue()));
		populateInstanceControlsFromData(form.getLocalContext().getSelectedPASConfig());
		form.grdPSAConfig().setValue(form.getLocalContext().getSelectedPASConfig());
		form.setMode(FormMode.VIEW);
		updateControlsState();
		
	}
	private void populateInstanceControlsFromData(PSAConfigVo pasconfig)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Terminate function on null value parameter
		if (pasconfig == null)
			return;
		
		// Set value to instance controls
		form.ctnDetails().txtName().setValue(pasconfig.getPSAName());
		form.ctnDetails().txtDescription().setValue(pasconfig.getPSADescription());
		form.ctnDetails().chkActive().setValue(Boolean.TRUE.equals(pasconfig.getIsActive()));
		
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
		form.ctnDetails().setCollapsed(false);
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
				
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
		}
	}
	public void clear()
	{
		form.grdPSAConfig().getRows().clear();
		clearInstanceControls();
	}
	public void clearInstanceControls()
	{
		form.ctnDetails().txtName().setValue(null);
		form.ctnDetails().txtDescription().setValue(null);
		form.ctnDetails().chkActive().setValue(null);
	}
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context selection
		form.getLocalContext().setSelectedPASConfig(null);
		
		// Clear instance controls
		clearInstanceControls();
		// Set form to EDIT mode
		form.ctnDetails().chkActive().setValue(true);
		form.ctnDetails().setCollapsed(false);
		form.setMode(FormMode.EDIT);
	}
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			// Populate instance data from screen
			
			PSAConfigVo psavo = populateDataFromInstanceControls(form.getLocalContext().getSelectedPASConfig());

			// Validate instance data
			String[] errors = psavo.validate();

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			form.getLocalContext().setSelectedPASConfig(psavo);	
			// Attempt to save
			form.getLocalContext().setSelectedPASConfig(domain.savePASConfig(form.getLocalContext().getSelectedPASConfig()));
			
			// Save was successful
			return true;
		}
		// Treat exceptions
		catch (StaleObjectException e)
		{
			
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UnqViolationUncheckedException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}

		
	}
	private PSAConfigVo populateDataFromInstanceControls(PSAConfigVo psaconfigparam)
	{
		
		PSAConfigVo psaconfig = psaconfigparam != null ?(PSAConfigVo)psaconfigparam.clone() : null;
		if (psaconfig == null)
		{
			psaconfig = new PSAConfigVo();
		}
		
		// Get instance data from screen
		psaconfig.setPSAName(form.ctnDetails().txtName().getValue());
		psaconfig.setPSADescription(form.ctnDetails().txtDescription().getValue());
		psaconfig.setIsActive(Boolean.TRUE.equals(form.ctnDetails().chkActive().getValue()));
		

		return psaconfig;
	}
	public void updateControlsState()
	{
		// Update controls for VIEW mode
		if (FormMode.VIEW.equals(form.getMode()))
		{
			// EDIT button
			form.btnEdit().setEnabled(true);
			form.btnEdit().setVisible(form.getLocalContext().getSelectedPASConfigIsNotNull() && form.grdPSAConfig().getValue() != null);
		}
		

		// Update context menu options
		updateContextMenuState();
	}
	private void updateContextMenuState()
	{
		// NEW option should be visible in VIEW mode always, EDIT options should have the same rules as EDIT button
		form.getContextMenus().getGenericGridAddItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getLocalContext().getSelectedPASConfigIsNotNull() && form.grdPSAConfig().getValue() != null);
	}
	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}
	private void populatePASConfigGrid(PSAConfigVoCollection pasconfigcoll)
	{
		// Clear grid
		form.grdPSAConfig().getRows().clear();
		
		// Terminate function on null value parameter
		if (pasconfigcoll == null)
			return;
				
		// Iterate through pasconfig collection
		for (PSAConfigVo pasconfigvo : pasconfigcoll)
		{
			if (pasconfigvo == null)
				continue;
			
			// Add each pasconfig to a grid row
			grdPSAConfigRow pasconfigrow = form.grdPSAConfig().getRows().newRow(true);
			
			// Set pasconfigvo row columns
			pasconfigrow.setColumnName(pasconfigvo.getPSAName());
			pasconfigrow.setColumnDescription(pasconfigvo.getPSADescription());
			pasconfigrow.setColumnActive(Boolean.TRUE.equals(pasconfigvo.getIsActive()));
			if(pasconfigvo.getIsActive() == null || pasconfigvo.getIsActive().equals(Boolean.FALSE))
				pasconfigrow.setTextColor(Color.Gray);
			pasconfigrow.setValue(pasconfigvo);
		}
	}
	
	protected void onGrdPSAConfigSelectionChanged()	throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedPASConfig(domain.getPASConfig(form.grdPSAConfig().getValue()));
		// Populate instance controls with selected record
		populateInstanceControlsFromData(form.getLocalContext().getSelectedPASConfig());

		// Update controls state (buttons, context menu options, etc.)
		updateControlsState();
		form.ctnDetails().setCollapsed(false);
		
		
	}

}
