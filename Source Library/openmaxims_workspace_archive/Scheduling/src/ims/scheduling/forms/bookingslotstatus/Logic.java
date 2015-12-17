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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.forms.bookingslotstatus;

import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.scheduling.forms.bookingslotstatus.BaseLogic;
import ims.scheduling.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.Status_Reason;


public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialiseScreen(form.getGlobalContext().ChooseAndBook.getisCancelSlotAndApptAvailable());
	}

	/**
	 * this methosd loads whichever specific combo needs to be loaded
	 * and shows the relevant conc 
	 * @param isCancelSlotOnly
	 */
	private void initialiseScreen(Boolean isCancelSlotAndApptAvailable) 
	{
		//cancel
		if(form.getGlobalContext().ChooseAndBook.getSessionSlotStatusIsNotNull() && form.getGlobalContext().ChooseAndBook.getApptStatusIsNotNull())
		{
			if(isCancelSlotAndApptAvailable.booleanValue())
			{
				form.chkCancSlot().setVisible(true);
				form.lblCancelSlotOption().setVisible(true);
			}
		}
		else if(form.getGlobalContext().ChooseAndBook.getApptStatusReasonIsNotNull())
		{
			form.chkCancSlot().setVisible(false);
			form.lblCancelSlotOption().setVisible(false);
		}
		else
		{
			form.chkCancSlot().setVisible(false);
			form.lblCancelSlotOption().setVisible(false);
		}
		loadReasons();
	}
	
	private void loadReasons() 
	{
		TreeNode[] collReason = LookupHelper.getStatus_Reason(domain.getLookupService()).getRootNodes();
		Status_Reason instance = null;
		for(int i=0;i<collReason.length;i++)
		{
			instance = (Status_Reason) collReason[i];
			
			Status_Reason parentInstance = getCorrespondingParentInstance(); 

			if(parentInstance != null)
			{
				if(instance.equals(parentInstance))
					break;
			}
		}
		
		if(instance == null)
			return;
		
		if(instance.getChildInstances().size() == 0)
		{
			form.cmbStatusReason().newRow(instance, instance.getText());
			form.cmbStatusReason().setValue(instance);
		}
		else
		{
			for(int i=0;i<instance.getChildInstances().size();i++)
			{
				if(((Status_Reason)instance.getChildInstances().get(i)).equals(Status_Reason.REJECT_CAB))
					continue;
				
				form.cmbStatusReason().newRow((Status_Reason)instance.getChildInstances().get(i), ((Status_Reason)instance.getChildInstances().get(i)).getText());
			}		
		}	
	}

	/**
	 * This method will return which type of parent instance has been populated
	 * if it is apptstatus we return otherwise we get slotstatus - used to determine
	 * which set of child instances to load
	 * @return
	 */
	private Status_Reason getCorrespondingParentInstance() 
	{
		Status_Reason reason = form.getGlobalContext().ChooseAndBook.getApptStatus();
		if(reason == null)
			reason = form.getGlobalContext().ChooseAndBook.getSessionSlotStatus();
		
		return reason;
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		if(form.getGlobalContext().ChooseAndBook.getisCancelSlotAndApptAvailable().booleanValue())
		{
			if(form.cmbStatusReason().getValue() != null)
			{
				if(form.chkCancSlot().getValue() == true)
					form.getGlobalContext().ChooseAndBook.setSessionSlotStatusReason(form.cmbStatusReason().getValue());
				
				form.getGlobalContext().ChooseAndBook.setApptStatusReason(form.cmbStatusReason().getValue());
				if(form.cmbStatusReason().getValue().getParent() != null)
				{
					if(form.cmbStatusReason().getValue().getParent().equals(Status_Reason.CANCELLED) && form.chkCancSlot().getValue() == true)
						form.getGlobalContext().ChooseAndBook.setSessionSlotStatus(Status_Reason.CANCELLED_PENDING_APPT);
				}
			}
		}
		else
		{
			if(form.getGlobalContext().ChooseAndBook.getApptStatusIsNotNull())
				form.getGlobalContext().ChooseAndBook.setApptStatusReason(form.cmbStatusReason().getValue());
			else if(form.getGlobalContext().ChooseAndBook.getSessionSlotStatusIsNotNull())
				form.getGlobalContext().ChooseAndBook.setSessionSlotStatusReason(form.cmbStatusReason().getValue());
		}
		
		form.getGlobalContext().ChooseAndBook.setisCancelSlot(new Boolean(form.chkCancSlot().getValue()));
		engine.close(DialogResult.OK);
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().ChooseAndBook.setApptStatusReason(null);
		form.getGlobalContext().ChooseAndBook.setSessionSlotStatusReason(null);		
		engine.close(DialogResult.CANCEL);
	}
}
