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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4876.20447)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.attendancerequiringcontractingtasksettings;

import ims.emergency.vo.AttendanceReqContractSettingsVo;
import ims.framework.interfaces.IDynamicFormDataOperations;

import java.util.ArrayList;

public class Logic extends BaseLogic implements IDynamicFormDataOperations
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		loadData();
	}
	
	public void loadData() 
	{
		AttendanceReqContractSettingsVo record = domain.getConfiguration(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		form.getLocalContext().setRecord(record);
		populateScreenFromData(record);
	}

	private void populateScreenFromData(AttendanceReqContractSettingsVo record)
	{
		clear();
		
		if(record == null)
			return;
		
		form.dtimFrom().setValue(record.getFromDate());
		form.dtimTo().setValue(record.getToDate());
		
	}

	private void clear()
	{
		form.dtimFrom().setValue(null);
		form.dtimTo().setValue(null);
	}

	public void saveData() throws Exception 
	{
		AttendanceReqContractSettingsVo record  = getData();
		
		String[] errors = record.validate(getUIErrors());
		if(errors != null && errors.length > 0)
			throw new Exception("Validation Errors");
		
		domain.saveConfiguration(record);
	}
	
	public AttendanceReqContractSettingsVo getData() 
	{
		AttendanceReqContractSettingsVo record = populateDataFromScreen(form.getLocalContext().getRecord());
		record.setConfiguredJob(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		return record;
	}
	
	public String[] validateData() 
	{
		return getData().validate(getUIErrors());
	}

	private String[] getUIErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		// WDEV-17603
			
		if (form.dtimFrom().getValue() != null && form.dtimTo().getValue() != null && form.dtimFrom().getValue().isGreaterThan(form.dtimTo().getValue()))
		{
			errors.add ("From Date/Time cannot be greater than To Date/Time.");
		}
	
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid Attendance Requiring Contract Settings record", searchErrors);
			return searchErrors;
		}
		return null;
	}

	private AttendanceReqContractSettingsVo populateDataFromScreen(AttendanceReqContractSettingsVo record) 
	{
		if(record == null)
			record = new AttendanceReqContractSettingsVo();
		
		record.setFromDate(form.dtimFrom().getValue());
		record.setToDate(form.dtimTo().getValue());
		
		return record;
	}
	
}
