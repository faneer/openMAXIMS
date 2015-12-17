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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.updaterttstatusdatetime;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}
	
	private void initialise()
	{
		form.dtimRTTStatusDateTime().setValue(new DateTime());
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		String[] errors = validateUIRules();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		try
		{
			domain.updateRTTStatusAndClockWithNewDate(form.dtimRTTStatusDateTime().getValue(), form.getGlobalContext().RefMan.getRTTManagementValue());
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		catch (DomainInterfaceException e)
		{
			//e.printStackTrace();
			engine.showErrors(new String[] {e.getMessage()});
			
			return;
		}
		
		engine.close(DialogResult.OK);
	}
	
	private String[] validateUIRules()
	{
		ArrayList<String> errorList = new ArrayList<String>();
			
		if (form.dtimRTTStatusDateTime().getValue() == null)
		{
			errorList.add("RTT Status Date Time cannot be empty.");
		}
		else
		{
			if((new DateTime()).isLessThan(form.dtimRTTStatusDateTime().getValue()))
			{
				errorList.add("RTT Status Date Time cannot be set in the future.");
			}
			
			if(form.getGlobalContext().RefMan.getPreviousRTTStatusDate() != null)
			{
				if(form.dtimRTTStatusDateTime().getValue().isLessThan(form.getGlobalContext().RefMan.getPreviousRTTStatusDate()))
				{
					errorList.add("RTT Status Date Time cannot be set earlier than previous RTT Status Date/Time " + form.getGlobalContext().RefMan.getPreviousRTTStatusDate());
				}
			}
				
			if(form.getGlobalContext().RefMan.getNextRTTStatusDate() != null)
			{
				if(form.dtimRTTStatusDateTime().getValue().isGreaterThan(form.getGlobalContext().RefMan.getNextRTTStatusDate()))
				{
					errorList.add("RTT Status Date Time cannot be set later than next RTT Status Date/Time " + form.getGlobalContext().RefMan.getNextRTTStatusDate());
				}
			}
		}
		
		return errorList.toArray(new String[errorList.size()]);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
