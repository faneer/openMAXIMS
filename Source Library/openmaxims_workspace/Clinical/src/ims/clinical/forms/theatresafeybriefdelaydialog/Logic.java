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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 5540.19885)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.theatresafeybriefdelaydialog;

import ims.clinical.vo.SessionTheatreDelayAndDebriefTimesVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-22586
		SessionTheatreDelayAndDebriefTimesVo session = domain.getSessionDelay(form.getGlobalContext().Scheduling.getTheatreSession());
		
		int mins = 0;
		if (args != null && args.length == 1)
		{
			if (args[0] instanceof Integer)
			{
				mins = (Integer) args[0];
				session.setSafetyBriefDelayMins(mins);
				form.btnCancel().setVisible(false);
			}
			else
			{
				form.btnCancel().setVisible(true);
			}
		}
		else
			throw new CodingRuntimeException("Mandatory args missing");
		
		
		
				
		form.getLocalContext().setSessionDelay(session);

		populateScreenFromData();
	}

	private void populateScreenFromData()
	{
		clearScreen();

		SessionTheatreDelayAndDebriefTimesVo session = form.getLocalContext().getSessionDelay();
		if (session == null)
			return;

		if (session.getSafetyBriefDelayMinsIsNotNull())
			form.lblDelayMins().setValue(session.getSafetyBriefDelayMins().toString());

		form.cmbDelayReason().setValue(session.getSafetyBriefDelayReason());
		form.txtDetails().setValue(session.getSafetyBriefDelayReasonDetails());
	}

	private void clearScreen()
	{
		form.lblDelayMins().setValue("");
		form.cmbDelayReason().setValue(null);
		form.txtDetails().setValue(null);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		SessionTheatreDelayAndDebriefTimesVo session = form.getLocalContext().getSessionDelay();

		session = populateDataFromScreen(session);
		
		String[] arrErrors = session.validate(validateUI());
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		
		try
		{
			domain.saveSessionDelay(session);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setSessionDelay(domain.getSessionDelay(form.getGlobalContext().Scheduling.getTheatreSession()));
			populateScreenFromData();
			return;
		}
		engine.close(DialogResult.OK);
	}
	
	//WDEV-22451
	private String[] validateUI()
	{
		java.util.ArrayList<String> uiErrors = new java.util.ArrayList<String>();
		if(form.cmbDelayReason().getValue() == null)
		{
			uiErrors.add("Reason is mandatory");
		}
		
		return  uiErrors.size() > 0 ? uiErrors.toArray(new String[0]) : null;
	}

	private SessionTheatreDelayAndDebriefTimesVo populateDataFromScreen(SessionTheatreDelayAndDebriefTimesVo session)
	{
		if (session == null)
			session = new SessionTheatreDelayAndDebriefTimesVo();

		session.setSafetyBriefDelayReason(form.cmbDelayReason().getValue());
		session.setSafetyBriefDelayReasonDetails(form.txtDetails().getValue());

		return session;
	}

	//WDEV-22586
	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
