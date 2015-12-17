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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4664.22850)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.quickregistrationpatientsearchdialog;

import ims.core.vo.enums.PatientSearchEvent;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccPatientSearch().initialize(false);
		form.ccPatientSearch().setFilterCriteria(form.getGlobalContext().Core.getPatientFilter());
		form.btnSelect().setEnabled(false);
	}
	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
		form.getGlobalContext().Emergency.setSelectedPatient(form.ccPatientSearch().getSelectedPatient());
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onCcPatientSearchValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (PatientSearchEvent.PATIENT_SELECTED.equals(form.ccPatientSearch().getEvent()))
		{
			form.btnSelect().setEnabled(true);
			
		}
		else if (PatientSearchEvent.NONE.equals(form.ccPatientSearch().getEvent()))
		{
			form.btnSelect().setEnabled(false);
		}
	}
}
