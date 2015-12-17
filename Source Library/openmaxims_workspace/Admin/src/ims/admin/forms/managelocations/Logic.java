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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.45 build 2363.27458)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.managelocations;

import ims.admin.forms.managelocations.GenForm.grdLocationsRow;
import ims.configuration.gen.ConfigFlag;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.interfaces.ILocationProvider;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		// will be removed
		form.setMode(FormMode.EDIT);
		
		initialize();
		open();
	}
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Admin.SelectLocations) && result == DialogResult.OK)
		{
			addSelectedLocations();
		}
	}	
	protected void onGrdLocationsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();		
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		engine.close(DialogResult.CANCEL);
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.ManageLocations.ADD:
				addLocations();
				break;
			case GenForm.ContextMenus.ManageLocations.CLEAR:
				clearLocations();
				break;
			case GenForm.ContextMenus.ManageLocations.MOVEDOWN:
				moveSelectedLocationDown();
				break;
			case GenForm.ContextMenus.ManageLocations.MOVEUP:
				moveSelectedLocationUp();
				break;
			case GenForm.ContextMenus.ManageLocations.MOVETOP:
				moveSelectedLocationToTop();
				break;
			case GenForm.ContextMenus.ManageLocations.DELETE:
				deleteSelectedLocation();
				break;
			case GenForm.ContextMenus.ManageLocations.VALIDATE:
				validateLocation();
				break;
		}
		
		updateControlsState();
	}			
	private void initialize()
	{
		setNoteMessage();			
	}
	private void open()
	{
		form.grdLocations().getRows().clear();
		
		ILocation[] locations = engine.getStoredLocations();
		if(locations != null)
		{
			for(int x = 0; x < locations.length; x++)
			{
				addLocation(locations[x]);
			}
		}
		
		updateControlsState();
	}
	private void addLocation(ILocation location)
	{
		addLocation(location, false);
	}
	private void addLocation(ILocation location, boolean select) 
	{
		GenForm.grdLocationsRow row = form.grdLocations().getRows().newRow(select);		
		row.setcolLocation(location.getName());
		row.setValue(location);
	}
	private void updateControlsState()
	{
		updateContextMenuState();	
		setNoteMessage();
		markDefaultLocation();
	}
	private void updateContextMenuState()
	{
		boolean locationSelected = form.grdLocations().getValue() != null;
		
		//form.getContextMenus().getManageLocationsADDItem().setVisible(getMaximumSelectionAllowed() > 0);
		form.getContextMenus().getManageLocationsMOVEUPItem().setVisible(form.grdLocations().canMoveCurrentUp());
		form.getContextMenus().getManageLocationsMOVEDOWNItem().setVisible(form.grdLocations().canMoveCurrentDown());
		form.getContextMenus().getManageLocationsDELETEItem().setVisible(locationSelected);
		form.getContextMenus().getManageLocationsCLEARItem().setVisible(form.grdLocations().getRows().size() > 0);
		form.getContextMenus().getManageLocationsMOVETOPItem().setVisible(form.grdLocations().canMoveCurrentUp());
		form.getContextMenus().getManageLocationsVALIDATEItem().setVisible(form.grdLocations().getRows().size() > 0);
	}
	private void deleteSelectedLocation() 
	{
		form.grdLocations().removeSelectedRow();
	}
	private void moveSelectedLocationToTop() 
	{
		ILocation location = form.grdLocations().getValue();
		form.grdLocations().removeSelectedRow();
		
		ILocation[] existingLocations = new ILocation[form.grdLocations().getRows().size()];
		for(int x = 0; x < form.grdLocations().getRows().size(); x++)
		{
			existingLocations[x] = form.grdLocations().getRows().get(x).getValue();
		}
		
		form.grdLocations().getRows().clear();
		addLocation(location, true);
		for(int x = 0; x < existingLocations.length; x++)
		{
			addLocation(existingLocations[x]);
		}		
	}
	private void moveSelectedLocationUp() 
	{
		form.grdLocations().moveUp();
	}
	private void moveSelectedLocationDown() 
	{
		form.grdLocations().moveDown();
	}
	private void addLocations() 
	{
		form.getGlobalContext().Admin.setManagedLocations(getLocations());
		engine.open(form.getForms().Admin.SelectLocations);
	}
	private void clearLocations() 
	{
		form.grdLocations().getRows().clear();
	}
	private boolean save()
	{
		engine.setStoredLocations(getLocations());
		return true;
	}
	private ILocation[] getLocations() 
	{
		ILocation[] locations = new ILocation[form.grdLocations().getRows().size()];
		for(int x = 0; x < form.grdLocations().getRows().size(); x++)
		{
			locations[x] = form.grdLocations().getRows().get(x).getValue();
		}
		return locations;
	}
	private void validateLocation()
	{
		validateLocation(true);
	}
	private void validateLocation(boolean showMessage) 
	{
		ILocationProvider locationProvider = engine.getLocationProvider();
		if(locationProvider == null)
		{
			engine.showMessage("Unable to validate locations: Location Provider not found.");
			return;
		}

		int removed = 0;
		int changed = 0;
		for(int x = form.grdLocations().getRows().size() - 1; x >= 0; x--)
		{
			ILocation location = locationProvider.validateLocation(form.grdLocations().getRows().get(x).getValue());
			if(location != null)
			{
				updateLocation(form.grdLocations().getRows().get(x), location);
				changed++;
			}
			else
			{
				form.grdLocations().getRows().remove(x);
				removed++;
			}
		}		
		
		if(showMessage)
			engine.showMessage("Validation completed.");
	}
	private void updateLocation(grdLocationsRow row, ILocation location) 
	{
		row.setcolLocation(location.getName());
		row.setValue(location);
	}	
	private void addSelectedLocations() 
	{
		form.getGlobalContext().Admin.setManagedLocations(null);		
		ILocation[] locationsToBeAdded = form.getGlobalContext().Admin.getSelectedLocations();
		if(locationsToBeAdded == null)
			return;
		
		for(int x = 0; x < locationsToBeAdded.length; x++)
		{
			addLocation(locationsToBeAdded[x]);
		}
		
		updateControlsState();
	}
	/*private int getMaximumSelectionAllowed()
	{
		int maximum = ConfigFlag.UI.MAX_NO_SELECTED_LOCATIONS_STORED.getValue();
		
		ILocation[] locations = getLocations();
		maximum -= locations.length;
		if(maximum < 0)
			maximum = 0;
		
		return maximum;
	}*/
	private void setNoteMessage() 
	{
		form.lblNote().setValue("Note: The maximum number of stored locations is " + ConfigFlag.UI.MAX_NO_SELECTED_LOCATIONS_STORED.getValue() + ".");			
	}
	private void markDefaultLocation()
	{
		if(form.grdLocations().getRows().size() == 0)
			return;
		
		form.grdLocations().getRows().get(0).setBackColor(Color.Beige);
		
		for(int x = 1; x < form.grdLocations().getRows().size(); x++)
		{
			form.grdLocations().getRows().get(x).setBackColor(Color.Default);
		}
	}
}
