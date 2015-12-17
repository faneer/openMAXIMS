//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.45 build 2363.27458)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.selectlocations;

import ims.configuration.gen.ConfigFlag;
import ims.framework.enumerations.DialogResult;
import ims.framework.interfaces.ILocation;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		ILocation[] selection = getLocations();
		
		int maximum = getMaximumSelectionAllowed();
		if(selection.length > maximum)
		{
			if(maximum == 0)
			{
				engine.showMessage("No locations can be selected.");
			}
			else if(maximum == 1)
			{
				engine.showMessage("Only one location can be selected.");
			}
			else
			{
				engine.showMessage("Up to " + maximum + " locations can be selected.");
			}
			
			return;
		}
		
		form.getGlobalContext().Admin.setSelectedLocations(selection);
		engine.close(DialogResult.OK);
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	private void open()
	{
		form.grdLocations().getRows().clear();
		
		/*ILocation[] locations = engine.getLocationProvider().listLocations();
		if(locations != null)
		{
			for(int x = 0; x < locations.length; x++)
			{
				if(shouldAddLocation(locations[x]))
					addLocation(locations[x]);
			}
		}*/
		
		setNoteMessage();
	}
	private int getMaximumSelectionAllowed()
	{
		int maximum = ConfigFlag.UI.MAX_NO_SELECTED_LOCATIONS_STORED.getValue();
		
		ILocation[] locations = form.getGlobalContext().Admin.getManagedLocations();
		if(locations != null)
			maximum -= locations.length;
		if(maximum < 0)
			maximum = 0;
		
		return maximum;
	}
	private void setNoteMessage() 
	{
		int maximum = getMaximumSelectionAllowed();
		
		if(maximum == 0)
			form.lblNote().setValue("Note: No locations can be selected.");
		else if(maximum == 1)
			form.lblNote().setValue("Note: Only one location can be selected.");
		else
			form.lblNote().setValue("Note: Up to " + maximum + " locations can be selected.");		
	}
	/*private boolean shouldAddLocation(ILocation location)
	{
		ILocation[] locations = form.getGlobalContext().Admin.getManagedLocations();
		if(locations == null)
			return true;
		
		for(int x = 0; x < locations.length; x++)
		{
			if(locations[x] != null && locations[x].getID() == location.getID())
				return false;
		}	
		
		return true;
	}
	private void addLocation(ILocation location) 
	{
		GenForm.grdLocationsRow row = form.grdLocations().getRows().newRow();
		row.setcolLocation(location.getName());
		row.setValue(location);
	}*/
	private ILocation[] getLocations() 
	{
		int count = 0;
		for(int x = 0; x < form.grdLocations().getRows().size(); x++)
		{
			if(form.grdLocations().getRows().get(x).getcolSelected())
				count++;
		}
		
		int index = 0;
		ILocation[] locations = new ILocation[count];
		for(int x = 0; x < form.grdLocations().getRows().size(); x++)
		{
			if(form.grdLocations().getRows().get(x).getcolSelected())
			{
				locations[index++] = form.grdLocations().getRows().get(x).getValue();
			}
		}
		return locations;
	}
}
