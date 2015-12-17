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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.amentattendancetransfertimes;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.EDTransferVo;
import ims.emergency.vo.lookups.TransferToHospital;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setCurrentRecord(domain.get(form.getGlobalContext().Emergency.getAmendAttendanceTransferTimes()));
		
		if(form.getLocalContext().getCurrentRecord() == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		populateScreenFromData(form.getLocalContext().getCurrentRecord());
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.dtimReferred().setEnabled(form.dtimReferred().getValue() != null);
		form.dtimAccepted().setEnabled(form.dtimAccepted().getValue() != null);
	}

	private void populateScreenFromData(EDTransferVo edTransferVo)
	{
		clearScreen();
		
		if(edTransferVo == null)
			return;
		
		form.txtHospital().setValue(getTransfer(edTransferVo));
		form.txtReferredBy().setValue(edTransferVo.getReferredBy() != null ? edTransferVo.getReferredBy().getIMosName() : null);
		form.dtimReferred().setValue(edTransferVo.getReferredDateTime());
		form.dtimAccepted().setValue(edTransferVo.getAcceptedDateTime());
	}
	
	private String getTransfer(EDTransferVo edTransferVo)
	{
		if(edTransferVo == null)
			return null;
		
		if(edTransferVo.getToHospital() != null && !TransferToHospital.OTHER.equals(edTransferVo.getToHospital()))
			return edTransferVo.getToHospital().getText();
		
		if(edTransferVo.getOtherHospital() != null)
			return edTransferVo.getOtherHospital();
		
		return null;
	}

	private void clearScreen()
	{
		form.txtHospital().setValue(null);
		form.txtReferredBy().setValue(null);
		form.dtimReferred().setValue(null);
		form.dtimAccepted().setValue(null);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}
	
	private boolean save()
	{
		EDTransferVo record = populateDataFromScreen(form.getLocalContext().getCurrentRecord());
		
		String[] errors = validateUIRules();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		errors = record.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.save(record);
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		DateTime registrationDateTime = form.getGlobalContext().Emergency.getEmergencyAttendanceForTimeAmendments().getRegistrationDateTime();
		DateTime dischargeDatetime = form.getGlobalContext().Emergency.getEmergencyAttendanceForTimeAmendments().getDischargeDateTime();
		
		if(form.dtimReferred().isEnabled() && form.dtimReferred().getValue() == null)
		{
			uiErrors.add("Referred Time is mandatory.");
		}
		
		if(form.dtimAccepted().isEnabled() && form.dtimAccepted().getValue() == null)
		{
			uiErrors.add("Accepted Time is mandatory.");
		}
		
		if (form.dtimReferred().getValue() != null && form.dtimReferred().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Referred Time cannot be set in the future.");
		}
		
		if (form.dtimAccepted().getValue() != null && form.dtimAccepted().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Accepted Time cannot be set in the future.");
		}
		
		if (form.dtimReferred().getValue() != null && registrationDateTime != null && form.dtimReferred().getValue().isLessThan(registrationDateTime))
		{
			uiErrors.add("Referred Time cannot be less than Registration Start Time.");
		}
		
		if (form.dtimAccepted().getValue() != null && registrationDateTime != null && form.dtimAccepted().getValue().isLessThan(registrationDateTime))
		{
			uiErrors.add("Accepted Time cannot be less than Registration Start Time.");
		}
		if(form.dtimReferred().getValue() != null && dischargeDatetime != null && form.dtimReferred().getValue().isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Referred Time cannot be greater than Departed Date/Time.");
		}
		if(form.dtimAccepted().getValue() != null && dischargeDatetime != null && form.dtimAccepted().getValue().isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Accepted Time cannot be greater than Departed Date/Time.");
		}
		
		if (form.dtimAccepted().getValue() != null 
				&& form.dtimReferred().getValue() != null 
				&& (form.dtimAccepted().getValue().getDate().isLessThan(form.dtimReferred().getValue().getDate()) 
						|| (form.dtimAccepted().getValue().getDate().equals(form.dtimReferred().getValue().getDate()) 
								&& form.dtimAccepted().getValue().getTime().isLessThan(form.dtimReferred().getValue().getTime()))))
		{
			uiErrors.add("Accepted Time cannot be less than Referred Time.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private EDTransferVo populateDataFromScreen(EDTransferVo currentRecord)
	{
		if(currentRecord == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		currentRecord.setReferredDateTime(form.dtimReferred().getValue());
		currentRecord.setAcceptedDateTime(form.dtimAccepted().getValue());
		
		return currentRecord;
	}
}
