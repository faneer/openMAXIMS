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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.adhocdateselection;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{

		if (!validateRules())
			return;

		if (domain.isExcludedDate(form.dteSelection().getValue()))
		{
			engine.showMessage("Selected Date is in the Exclusion Dates list. Do you want to continue?", "Warning", MessageButtons.YESNO, MessageIcon.WARNING);
			return;
		}

		generateSession();
	}

	private void generateSession() throws PresentationLogicException
	{
		Boolean wasGenerated = false;

		try
		{
			wasGenerated = domain.generateSession(form.getGlobalContext().Scheduling.getProfileShort(), form.dteSelection().getValue());
		}
		catch (DomainInterfaceException e)
		{
			throw new PresentationLogicException("DomainInterfaceException occurred generating sessions - " + e.getMessage(), e);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
		}

		if (wasGenerated)
		{
			engine.showMessage("Session generated.");
			engine.close(DialogResult.OK);
		}
		else
		{
			form.btnOK().setEnabled(false);
			form.htmWarning().setHTML("<font color=red><b>A session was already generated for the selected date.</b>");
		}
	}

	private boolean validateRules()
	{
		if (form.dteSelection().getValue() == null)
		{
			engine.showMessage("Date is mandatory.");
			return false;
		}

		return true;
	}

	@Override
	protected void onDteSelectionValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.btnOK().setEnabled(true);
		form.htmWarning().setHTML("");
	}

	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (DialogResult.YES.equals(result))
		{
			generateSession();
		}
		else
			engine.close(DialogResult.CANCEL);

	}
}
