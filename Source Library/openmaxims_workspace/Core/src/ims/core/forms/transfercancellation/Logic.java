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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.transfercancellation;

import ims.core.vo.PendingTransfersLiteVo;
import ims.core.vo.TransferCancellationReasonDetailsVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;

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
		form.setMode(FormMode.EDIT);
		
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (populateDataFromScreen((PendingTransfersLiteVo) form.getGlobalContext().Core.getADTPendingTransfer().clone()))
			engine.close(DialogResult.OK);
	}
	private boolean populateDataFromScreen(PendingTransfersLiteVo adtPendingTransfer)
	{
		if (adtPendingTransfer == null)
			return false;
		
		if (validateUI())
		{	
			if (adtPendingTransfer.getCancellationReasonDetails() == null)
				adtPendingTransfer.setCancellationReasonDetails(new TransferCancellationReasonDetailsVo());
			adtPendingTransfer.getCancellationReasonDetails().setCancellationComments(form.txtComment().getValue());
			adtPendingTransfer.getCancellationReasonDetails().setCancellationReason(form.cmbCancellationReason().getValue());

			String[] validationErrors = adtPendingTransfer.validate();
			if (validationErrors != null)
			{
				engine.showErrors(validationErrors);
				return false;
			}
			form.getGlobalContext().Core.setADTPendingTransfer(adtPendingTransfer);
			return true;
		}
		return  false;
	}
	private boolean validateUI()
	{		
		if (form.cmbCancellationReason().getValue() == null)
		{	
			engine.showErrors(new String[] {"Cancellation Reason is mandatory."});
			return false;
		}
		
		return true;
	}	
}
