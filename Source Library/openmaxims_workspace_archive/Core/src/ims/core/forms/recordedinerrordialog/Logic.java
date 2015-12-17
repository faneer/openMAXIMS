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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.42 build 2196.26417)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.recordedinerrordialog;

import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.vo.ValueObject;



public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		ValueObject vo = engine.getRecordedInErrorVo(engine.getPreviousNonDialogFormName());
		if (vo == null)
			throw new FormOpenException("No Record Exists to Mark as Recorded In Error");
	}
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			btnOkClicked();
		}
		catch (DomainRuntimeException e)
		{
			String a []={e.getMessage()};
			engine.showErrors(a);
		}
	}
	private void btnOkClicked()throws DomainRuntimeException {
		FormName parentForm = engine.getPreviousNonDialogFormName();
		Integer patientId=null, contactId=null, careContextId=null;
		if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			patientId = form.getGlobalContext().Core.getPatientShort().getID_Patient();
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			contactId = form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact();
		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			careContextId = form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext();
		if (form.txtComment().getValue()==null)
		{
			throw new DomainRuntimeException("The reason for marking this record as Recorded In Error is mandatory");
		}
		try 
		{
			domain.markAsRie(engine.getRecordedInErrorVo(parentForm), parentForm, patientId, contactId, careContextId, form.txtComment().getValue());
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage("Data has been modified and cannot be marked as Recorded In Error");
		}
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
