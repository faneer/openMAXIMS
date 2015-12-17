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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.clinicaltask;

import ims.clinical.forms.clinicaltask.GenForm.grdTasksRow;
import ims.clinical.vo.lookups.HospitalAtNightClinicalTask;
import ims.clinical.vo.lookups.HospitalAtNightClinicalTaskCollection;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void open() 
	{
		populateClinicalTaskGridWithValues();
	}

	private void populateClinicalTaskGridWithValues() 
	{
		if(form.getGlobalContext().Clinical.getClinicalTasks() == null)
			return;
		
		for(int i=0; i<form.getGlobalContext().Clinical.getClinicalTasks().size(); i++)
		{
			HospitalAtNightClinicalTask task = form.getGlobalContext().Clinical.getClinicalTasks().get(i);
			
			grdTasksRow row = form.grdTasks().getRowByValue(task);
			
			if(row != null)
				row.setColSelect(true);
		}
	}

	private void initialize() 
	{
		populateClinicalTaskGrid();
	}

	private void populateClinicalTaskGrid() 
	{
		HospitalAtNightClinicalTaskCollection coll = ims.clinical.vo.lookups.LookupHelper.getHospitalAtNightClinicalTask(domain.getLookupService());
		
		form.grdTasks().getRows().clear();
		
		if(coll == null || coll.size() ==0)
			return;
		
		for(int i=0; i<coll.size(); i++)
		{
			grdTasksRow row = form.grdTasks().getRows().newRow();
			
			row.setColTaskName(coll.get(i).getText());
			row.setValue(coll.get(i));
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		HospitalAtNightClinicalTaskCollection selectedInstances = populateFromClinicalTasksGrid();
		
		if(selectedInstances == null || selectedInstances.size() == 0)
		{
			engine.showErrors(new String[] {"Please select at least one Clinical Task."});
			return;
		}
		
		form.getGlobalContext().Clinical.setClinicalTasks(selectedInstances);
		
		engine.close(DialogResult.OK);
	}

	private HospitalAtNightClinicalTaskCollection populateFromClinicalTasksGrid() 
	{
		HospitalAtNightClinicalTaskCollection coll = new HospitalAtNightClinicalTaskCollection();
		
		for(int i=0; i<form.grdTasks().getRows().size(); i++)
		{
			if(form.grdTasks().getRows().get(i).getColSelect())
			{
				coll.add(form.grdTasks().getRows().get(i).getValue());
			}
		}
		
		if(coll.size() == 0)
			return null;
		
		return coll;
	}
}
