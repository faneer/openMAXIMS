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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4198.17562)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.casenotetransferdialog;

import ims.core.vo.CaseNoteFolderVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.dtimTransfer().setValue(new ims.framework.utils.DateTime());
		
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.dtimTransfer().getValue() == null
			|| form.qmbCaseNoteLocations().getValue() == null)
		{
			engine.showMessage("Please enter both Transfer Date/Time and Location.");
			return;
		}
		
		CaseNoteFolderVo voCaseNote = new CaseNoteFolderVo();
		
		voCaseNote.setVolume("TODO");
		voCaseNote.setLocation("TODO");
		voCaseNote.setMoveTo(form.qmbCaseNoteLocations().getValue());
		
		voCaseNote.setLocDate(form.dtimTransfer().getValue().getDate());
		voCaseNote.setLocTime(form.dtimTransfer().getValue().getTime());
		voCaseNote.setComments(form.txtComment().getValue());
		voCaseNote.setUNAM("TODO");
		voCaseNote.setRDAT(new Date());
		voCaseNote.setRTIM(new Time());
		voCaseNote.setHOSPNUM(form.getGlobalContext().Core.getPatientShort().getHospnum().getValue().toString());
		
		form.getGlobalContext().Core.setCaseFolderChange(voCaseNote);

		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setCaseFolderChange(null);
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onQmbCaseNoteLocationsTextSubmited(String value) throws PresentationLogicException 
	{
		String[] collLocations = domain.listLocation(value);
		if (collLocations != null)
		{
			for (String item : collLocations)
			{
				if (form.getGlobalContext().Core.getCurrentCaseFolderLocationIsNotNull()
					&& ! form.getGlobalContext().Core.getCurrentCaseFolderLocation().equals(item))
					form.qmbCaseNoteLocations().newRow(item, item);
			}
		}
		if (collLocations.length == 1)
			form.qmbCaseNoteLocations().setValue(collLocations[0]);
		else if (collLocations.length > 1)
			form.qmbCaseNoteLocations().showOpened();

	}
}
