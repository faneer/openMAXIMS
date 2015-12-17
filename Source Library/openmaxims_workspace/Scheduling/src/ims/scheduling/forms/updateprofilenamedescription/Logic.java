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
// This code was generated by Richard Reynolds using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.updateprofilenamedescription;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.scheduling.vo.ProfileForProfileRippleVo;
import ims.scheduling.vo.ProfileRippleVo;
import ims.scheduling.vo.Profile_SlotGenericVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedProfile(form.getGlobalContext().Scheduling.getProfileForProfileRippleVo());
		
		form.txtProfileName().setValue(form.getLocalContext().getSelectedProfile().getName());
		form.txtProfileName().setTooltip(form.getLocalContext().getSelectedProfile().getName());
//		form.txtProfileDescription().setValue(form.getLocalContext().getSelectedProfile().getDescription());
//		form.txtProfileDescription().setTooltip(form.getLocalContext().getSelectedProfile().getDescription());
	}

	@Override
	protected void onDteEffectiveFromDateValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private boolean save()
	{
		ProfileRippleVo profileRippleToSave = populateDataFromScreen();
		
		String[] errors = profileRippleToSave.validate(getUIErrors(true));
		
		if (errors != null 
				&& errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.save(profileRippleToSave); 
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		return true;
	}
	
	private ProfileRippleVo populateDataFromScreen()
	{
		ProfileRippleVo profileRipple = new ProfileRippleVo();
		ProfileForProfileRippleVo profile = (ProfileForProfileRippleVo)form.getLocalContext().getSelectedProfile().clone();
		
		profileRipple.setDateTimeRequested(new DateTime());
		profileRipple.setEffectiveFromDate(form.dteEffectiveFromDate().getValue());
		profileRipple.setName(form.txtProfileName().getValue());
		profileRipple.setDescription(form.txtProfileName().getValue());
		
		profile.setName(form.txtProfileName().getValue());
		profile.setDescription(form.txtProfileName().getValue());

		profileRipple.setProfile(profile);
		profileRipple.setActive(true);
		
		return profileRipple;
	}
	
	private String[] getUIErrors(boolean bLaunchedOnSave)
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		Profile_SlotGenericVoCollection collActiveClots = getActiveSlotsFromProfile(form.getLocalContext().getSelectedProfile());
		
		Time firstSlotStartTime = null;
		Time lastSlotEndTime = null;
		
		if (collActiveClots != null 
				&& collActiveClots.size() > 0)
		{
			collActiveClots.sort(SortOrder.ASCENDING);
			firstSlotStartTime = collActiveClots.get(0).getStartTm();
			lastSlotEndTime=collActiveClots.get(collActiveClots.size()-1).getEndTime();
		}
		
		if (bLaunchedOnSave 
				&& form.dteEffectiveFromDate().getValue() != null 
				&& form.dteEffectiveFromDate().getValue().isLessThan(new Date()))
		{
			errors.add("'Effective From Date' should be greater than today's date.");
		}
		
		if (form.dteEffectiveFromDate().getValue() != null 
				&& form.dteEffectiveFromDate().getValue().isLessThan(new Date()))
		{
			errors.add("'Effective From Date' should be greater than today's date.");
		}
		
		if (form.dteEffectiveFromDate().getValue() != null 
				&& form.getLocalContext().getSelectedProfile() != null 
				&& form.getLocalContext().getSelectedProfile().getLastGenDate() != null 
				&& form.dteEffectiveFromDate().getValue().isGreaterThan(form.getLocalContext().getSelectedProfile().getLastGenDate()))
		{
			errors.add("'Effective From Date' is greater than the last generation date for sessions on the profile. In this case no ripple out is required and the profile should be cloned on the Profile Configuration screen and the relevant changes made there.");
		}
		
//		if (bLaunchedOnSave && form.timStartTime().getValue()!=null && form.timEndTime().getValue()!=null && form.timStartTime().getValue().isGreaterOrEqualThan(form.timEndTime().getValue()))
//		{
//			errors.add("'Profile End Time' should be greater than 'Profile Start Time'");
//		}
//		
//		if (bLaunchedOnSave && form.timStartTime().getValue()!=null && firstSlotStartTime!=null && form.timStartTime().getValue().isGreaterThan(firstSlotStartTime))
//		{		
//			errors.add("'Profile Start Time' should not be greater than the start time of the first active slot.");
//		}
//		
//		if (bLaunchedOnSave && form.timEndTime().getValue()!=null && lastSlotEndTime!=null && form.timEndTime().getValue().isLessThan(lastSlotEndTime))
//		{		
//			errors.add("'Profile End Time' should not be less than the end time of the last active slot.");
//		}

		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	private Profile_SlotGenericVoCollection getActiveSlotsFromProfile(ProfileForProfileRippleVo profile)
	{
		if (profile == null 
				|| profile.getProfileSlots() == null 
				|| profile.getProfileSlots().size() == 0)
			return null;
		
		Profile_SlotGenericVoCollection collActiveSlots = new Profile_SlotGenericVoCollection();
		
		for (int i=0; i < profile.getProfileSlots().size(); i++)
		{
			if (Boolean.TRUE.equals(profile.getProfileSlots().get(i).getIsActive()))
			{
				collActiveSlots.add(profile.getProfileSlots().get(i));
			}
		}
		
		return collActiveSlots;
	}
//	@Override
//	protected void onTxtProfileDescriptionChanged() throws PresentationLogicException
//	{
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	protected void onTxtProfileNameChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}


}
