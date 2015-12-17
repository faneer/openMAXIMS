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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3070.24992)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.forms.townlandquerydialog;

import ims.core.vo.TownlandShortVo;
import ims.core.vo.TownlandShortVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	
	private void initialize() 
	{
		form.setMode(FormMode.VIEW);
		form.getLocalContext().setcanSearch(false);
		if(form.getGlobalContext().PCI.getCountyIsNotNull())
		{
			form.cmbCounty().setValue(form.getGlobalContext().PCI.getCounty());
		}
		updateControlsState();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdTownland().getValue() instanceof TownlandShortVo)
		{
			TownlandShortVo townlanSelected = (TownlandShortVo) form.grdTownland().getValue();
			if(townlanSelected.getDEDIsNotNull())
			{
				form.getGlobalContext().PCI.setDED(townlanSelected.getDED());
				engine.close(DialogResult.OK);
			}
		}
	}
	
	private void search() 
	{
		form.grdTownland().getRows().clear();
		if(form.getLocalContext().getcanSearchIsNotNull() && form.getLocalContext().getcanSearch())
		{
			if(canSearch())
			{
				TownlandShortVoCollection listTownlands = domain.list(form.cmbCounty().getValue(), form.txtTownland().getValue());
				
				if (listTownlands == null || listTownlands.size() == 0)
				{
					engine.showMessage("No results found");
				}
				
				populateGrid(listTownlands);
			}
		}
	}
	
	private void populateGrid(TownlandShortVoCollection listTownlands) 
	{
		for(int i=0; i<listTownlands.size(); i++)
		{
			if(listTownlands.get(i) != null)
			{
				GenForm.grdTownlandRow row = form.grdTownland().getRows().newRow();
				row.setColTownland(listTownlands.get(i).getName());
				row.setColDED(listTownlands.get(i).getDED() != null ? listTownlands.get(i).getDED().getName() : null);
				row.setColCounty(listTownlands.get(i).getCountyIsNotNull() ? listTownlands.get(i).getCounty().getText() : null);
				row.setValue(listTownlands.get(i));
			}
		}
	}

	private boolean canSearch() 
	{
		if(form.txtTownland().getValue() == null && form.cmbCounty().getValue() == null)
		{
			engine.showMessage("Please enter at least one search criteria.");
			form.getLocalContext().setcanSearch(false);
			return false;
		}
		return true;
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearch();
		updateControlsState();
	}

	private void clearSearch() 
	{
		form.cmbCounty().setValue(null);
		form.txtTownland().setValue(null);
		form.grdTownland().getRows().clear();
		form.getLocalContext().setcanSearch(false);
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException 
	{
		form.getLocalContext().setcanSearch(true);
		search();
		updateControlsState();
	}

	@Override
	protected void onGrdTownlandSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.btnOk().setEnabled(form.grdTownland().getValue() instanceof TownlandShortVo);
	}
}
