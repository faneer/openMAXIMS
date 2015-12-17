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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5332.26009)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.wardselection;

import ims.RefMan.forms.wardselection.GenForm.grdSelectedRow;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.lookups.LocationType;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise(args);
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		form.btnAddToList().setEnabled(areLocationsSelected());
	}

	private boolean areLocationsSelected()
	{
		for(int i=0; i<form.grdWards().getRows().size(); i++)
		{
			if(form.grdWards().getRows().get(i).getColSelect())
				return true;
		}
		
		return false;
	}

	private void initialise(Object[] args)
	{
		// WDEV-23039
//		form.txtHospital().setValue(form.getGlobalContext().RefMan.getSelectedHospital() != null ? form.getGlobalContext().RefMan.getSelectedHospital().getName() : null);
		populateHospital(); //WDEV-23039
		
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof LocationType)
			{
				form.getLocalContext().setLocationType((LocationType) args[0]);
			}
		}
		
		//WDEV-20395
//		LocationLiteVoCollection collBuildings = domain.listBuildings(form.getGlobalContext().RefMan.getSelectedHospital(), LocationType.BUILDING, null);
		LocationLiteVoCollection collBuildings = domain.listBuildings(form.cmbHospital().getValue(), LocationType.BUILDING, null); //WDEV-23039
		populateBuildingCombo(collBuildings);
		
		populateSelectedGrid();
	}
	
	//WDEV-23039
	private void populateHospital() 
	{
		form.cmbHospital().clear();
		
		LocationLiteVoCollection hospColl = domain.listHospitals();
		
		if(hospColl == null)
			return;
		
		for (int i = 0; i < hospColl.size(); i++)
		{
			LocationLiteVo hosp = hospColl.get(i);
			form.cmbHospital().newRow(hosp, hosp.getName());
		}
		
		LocationLiteVo currentHospital = form.getGlobalContext().RefMan.getSelectedHospital();
		form.cmbHospital().setValue(currentHospital);
	}
	
	//WDEV-20395
	private void populateBuildingCombo(LocationLiteVoCollection collBuildings)
	{
		form.cmbBuilding().clear();
		if (collBuildings==null || collBuildings.size()==0)
			return;
		
		for (LocationLiteVo building : collBuildings)
		{
			if (building==null)
				continue;
			form.cmbBuilding().newRow(building, building.getName());
		}
	}

	private void populateSelectedGrid()
	{
		if(form.getLocalContext().getLocationType() == null || LocationType.WARD.equals(form.getLocalContext().getLocationType()))
		{
			populateSelectedLocations(form.getGlobalContext().RefMan.getSelectedWards());
		}
		else if(LocationType.CASE_NOTE_FOLDER_LOCATION.equals(form.getLocalContext().getLocationType()))
		{
			populateSelectedLocations(form.getGlobalContext().RefMan.getSelectedCaseNoteFolderLocations());
		}
	}

	private void populateSelectedLocations(LocationLiteVoCollection selectedWards)
	{
		form.grdSelected().getRows().clear();
		
		if(selectedWards == null)
			return;
		
		for(int i=0; i<selectedWards.size(); i++)
		{
			addSelectedRowLocation(selectedWards.get(i));
		}
	}

	private void listLocations(LocationRefVo locationRefVo)
	{
		form.grdWards().getRows().clear();
		form.grdWards().getRows().clear(); //WDEV-23039

		if (locationRefVo == null || locationRefVo.getID_Location() == null)
			return;

		LocationLiteVoCollection wards = domain.listLocations(locationRefVo, form.getLocalContext().getLocationType(), form.txtLocation().getValue());

		if (wards == null || wards.size() == 0)
			return;

		for (LocationLiteVo ward : wards)
		{
			if (ward == null ||  ward.equals(locationRefVo))//WDEV-22088
				continue;

			addLocationRow(ward);
		}
	}
	
	private void addLocationRow(LocationLiteVo loc)
	{
		if (loc == null)
			return;

		ims.RefMan.forms.wardselection.GenForm.grdWardsRow row = form.grdWards().getRows().newRow();
		row.setColWard(loc.getName());

		row.setValue(loc);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.getLocalContext().getLocationType() == null || LocationType.WARD.equals(form.getLocalContext().getLocationType()))
		{
			form.getGlobalContext().RefMan.setSelectedWards(getSelectedLocations());
		}
		else if(LocationType.CASE_NOTE_FOLDER_LOCATION.equals(form.getLocalContext().getLocationType()))
		{
			form.getGlobalContext().RefMan.setSelectedCaseNoteFolderLocations(getSelectedLocations());
		}
		
		engine.close(DialogResult.OK);
	}
	
	private LocationLiteVoCollection getSelectedLocations()
	{
		LocationLiteVoCollection coll = new LocationLiteVoCollection();
		
		for(int i=0; i<form.grdSelected().getRows().size(); i++)
		{
			if(form.grdSelected().getRows().get(i).getColSelect())
			{
				coll.add(form.grdSelected().getRows().get(i).getValue());
			}
		}
		
		return coll.size() > 0 ? coll : null;
	}

	@Override
	protected void onGrdWardsGridCheckBoxClicked(int column, GenForm.grdWardsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		//WDEV-20395
		if (form.cmbBuilding().getValue()!=null)
		{
			listLocations(form.cmbBuilding().getValue());
		}
		else
		{
			//WDEV-23039
//			listLocations(form.getGlobalContext().RefMan.getSelectedHospital());
			listLocations(form.cmbHospital().getValue()); //WDEV-23039
			
		}
		updateControlsState();
	}

	@Override
	protected void onBtnAddToListClick() throws PresentationLogicException
	{
		addToSelectedGrid();
		setColSelectFromLocationsGrid(false);
		updateControlsState();
	}

	private void setColSelectFromLocationsGrid(boolean value)
	{
		for(int i=0; i<form.grdWards().getRows().size(); i++)
		{
			form.grdWards().getRows().get(i).setColSelect(value);
		}
	}

	private void addToSelectedGrid()
	{
		for(int i=0; i<form.grdWards().getRows().size(); i++)
		{
			if(form.grdWards().getRows().get(i).getColSelect())
			{
				addSelectedRowLocation(form.grdWards().getRows().get(i).getValue());
			}
		}
	}

	private void addSelectedRowLocation(LocationLiteVo loc)
	{
		if (loc == null)
			return;

		if(isAlreadyAdded(loc))
			return;
		
		grdSelectedRow row = form.grdSelected().getRows().newRow();

		row.setColWard(loc.getName());
		row.setColSelect(true);

		row.setValue(loc);
	}

	private boolean isAlreadyAdded(LocationLiteVo loc)
	{
		for(int i=0; i<form.grdSelected().getRows().size(); i++)
		{
			if(form.grdSelected().getRows().get(i).getValue().equals(loc))
				return true;
		}
		
		return false;
	}

	@Override
	protected void onBtnDeselecAllClick() throws PresentationLogicException
	{
		setColSelectFromLocationsGrid(false);
		updateControlsState();
	}

	@Override
	protected void onBtnSelectAllClick() throws PresentationLogicException
	{
		setColSelectFromLocationsGrid(true);
		updateControlsState();
	}

	//WDEV-20395
	@Override
	protected void onCmbBuildingValueChanged() throws PresentationLogicException
	{
		if (form.cmbBuilding().getValue()!=null)
		{
			listLocations(form.cmbBuilding().getValue());
		}
	}
	
	//WDEV-23039
	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		form.cmbBuilding().clear();
		form.grdWards().getRows().clear();
		
		LocationLiteVoCollection collBuildings = domain.listBuildings(form.cmbHospital().getValue(), LocationType.BUILDING, null);
		populateBuildingCombo(collBuildings);

		updateControlsState();
	}
}
