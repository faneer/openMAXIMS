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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5527.24259)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.inactivateprofileslots;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ServiceFunctionLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.forms.inactivateprofileslots.GenForm.grdSlotsRow;
import ims.scheduling.vo.CancellationTypeReasonVoCollection;
import ims.scheduling.vo.ProfileForProfileRippleVo;
import ims.scheduling.vo.ProfileRippleVo;
import ims.scheduling.vo.Profile_SlotGenericVo;
import ims.scheduling.vo.Profile_SlotGenericVoCollection;
import ims.scheduling.vo.lookups.CancelAppointmentReason;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}
	
	private boolean save()
	{
		ProfileRippleVo profileRippleToSave=populateDataFromScreen();
		
		String[] errors = profileRippleToSave.validate(getUIErrors());
		
		if (errors!=null && errors.length>0)
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
	
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.dteEffectiveFromDate().getValue()!=null && form.dteEffectiveFromDate().getValue().isLessThan(new Date()))
		{
			errors.add("'Effective From Date' should be greater than today's date.");
		}
		
		if (form.dteEffectiveFromDate().getValue()!=null && form.getLocalContext().getSelectedProfile()!=null && form.getLocalContext().getSelectedProfile().getLastGenDate()!=null && form.dteEffectiveFromDate().getValue().isGreaterThan(form.getLocalContext().getSelectedProfile().getLastGenDate())) //WDEV-21450
		{
			errors.add("'Effective From Date' is greater than the last generation date for sessions on the profile. In this case no ripple out is required and the profile should be cloned on the Profile Configuration screen and the relevant changes made there.");
		}

		if (form.cmbCancellationReason().getValue()==null && form.cmbCancellationReason().isRequired())
		{
			errors.add("'Cancellation Reason' is mandatory.");
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	private ProfileRippleVo populateDataFromScreen()
	{
		ProfileRippleVo profileRipple = new ProfileRippleVo();
		ProfileForProfileRippleVo profile = (ProfileForProfileRippleVo)form.getLocalContext().getSelectedProfile().clone();
		
		//updateProfileSlots
		for (int i=0;profile.getProfileSlotsIsNotNull() && i<profile.getProfileSlots().size();i++)
		{
			grdSlotsRow correspondentRowInGrid = form.grdSlots().getRowByValue(profile.getProfileSlots().get(i));
			
			if (correspondentRowInGrid!=null)
			{
				profile.getProfileSlots().get(i).setIsActive(correspondentRowInGrid.getcolSlotsActive());
			}
		}
		
		profileRipple.setDateTimeRequested(new DateTime());
		profileRipple.setEffectiveFromDate(form.dteEffectiveFromDate().getValue());
		profileRipple.setCancellationReason(form.cmbCancellationReason().getValue());
		profileRipple.setProfile(profile);
		profileRipple.setInactiveSlots(form.getLocalContext().getCollInactivateSlots());
		profileRipple.setActive(true);
		
		return profileRipple;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onDteEffectiveFromDateValueChanged() throws PresentationLogicException
	{
		if (form.dteEffectiveFromDate().getValue()!=null && form.getLocalContext().getSelectedProfile()!=null && form.getLocalContext().getSelectedProfile().getLastGenDate()!=null && form.dteEffectiveFromDate().getValue().isGreaterThan(form.getLocalContext().getSelectedProfile().getLastGenDate())) //WDEV-21450
		{
			engine.showMessage("'Effective From Date' is greater than the last generation date for sessions on the profile. In this case no ripple out is required and the profile should be cloned on the Profile Configuration screen and the relevant changes made there.");
		}
	}
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		form.getLocalContext().setSelectedProfile(form.getGlobalContext().Scheduling.getProfileForProfileRippleVo());
		populateCancelationreasonCombo();
		populateSlotsGrid(form.getLocalContext().getSelectedProfile().getProfileSlots());
		updateControlState();
	}
	
	private void populateCancelationreasonCombo()
	{
		CancellationTypeReasonVoCollection coll = domain.listCancellationReasonByType(Status_Reason.HOSPITALCANCELLED);
	
		for(int i=0; i<coll.size(); i++)
		{
			CancelAppointmentReason cancellReason = coll.get(i)!=null ? coll.get(i).getCancellationReason() : null;
			
			if(cancellReason!=null)
			{
				form.cmbCancellationReason().newRow(cancellReason, cancellReason.getText());
			}
		}
	}

	private void updateControlState()
	{
		form.getContextMenus().Scheduling.getInactivateProfileSlotMenuINACTIVATEItem().setVisible(form.grdSlots().getSelectedRow()!=null && Boolean.TRUE.equals(form.grdSlots().getSelectedRow().getcolSlotsActive()));
		form.btnSave().setEnabled(form.getLocalContext().getCollInactivateSlots()!=null && form.getLocalContext().getCollInactivateSlots().size()>0);
	}
	private void populateSlotsGrid(Profile_SlotGenericVoCollection collProfileSlots)
	{
		form.grdSlots().getRows().clear();
		
		if (collProfileSlots==null || collProfileSlots.size()==0)
			return;
		
		for (Profile_SlotGenericVo slot:collProfileSlots)
		{
			if (Boolean.TRUE.equals(slot.getIsActive()))
			{
				addRow(slot);
			}
		}
	}
	
	private void addRow(Profile_SlotGenericVo profileSlot)
	{
		if (profileSlot==null)
			return;
		
		grdSlotsRow row = form.grdSlots().getRows().newRow();
		row.setValue(profileSlot);
		row.setcolSlotsActive(profileSlot.getIsActive());
		row.setcolSlotsActivity(profileSlot.getActivityIsNotNull() ? profileSlot.getActivity().getName() : null);
		row.setcolSlotsDuration(profileSlot.getDurationIsNotNull() ? profileSlot.getDuration().toString() : null);
		row.setcolSlotsPriority(profileSlot.getPriorityIsNotNull() ? profileSlot.getPriority().getText() : null);
		row.setcolSlotsStartTime(profileSlot.getStartTmIsNotNull() ? profileSlot.getStartTm().toString() : null);
		row.setcolSlotsEndTime(profileSlot.getEndTimeIsNotNull() ? profileSlot.getEndTime().toString() : null); //WDEV-19702
		
		if( profileSlot.getFunctionsIsNotNull())
		{
			if( profileSlot.getFunctions().size() > 0)
			{
				ServiceFunctionLiteVo tempServVo = domain.getServiceFunction(profileSlot.getFunctions().get(0));
				row.setcolSlotsFunction(tempServVo != null && tempServVo.getFunctionIsNotNull() ? tempServVo.getFunction().getIItemText():null);
			}
			else
				row.setcolSlotsFunction(null);
		}
		else
			row.setcolSlotsFunction(null);
		profileSlot.getStartTmIsNotNull();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.InactivateProfileSlotMenu.INACTIVATE:
				inactivateSlot();
			break;
		}
		
		updateControlState();
	}
	
	private void inactivateSlot()
	{
		Profile_SlotGenericVoCollection collInactivated = form.getLocalContext().getCollInactivateSlots();
		if (collInactivated==null)
			collInactivated=new Profile_SlotGenericVoCollection();
		
		if (form.grdSlots().getSelectedRow()!=null && Boolean.TRUE.equals(form.grdSlots().getSelectedRow().getcolSlotsActive()))
		{
			Profile_SlotGenericVo inactivatedSlot = form.grdSlots().getSelectedRow().getValue();
			inactivatedSlot.setIsActive(false);
			collInactivated.add(inactivatedSlot);
			form.getLocalContext().setCollInactivateSlots(collInactivated);
			form.grdSlots().getSelectedRow().setcolSlotsActive(false);
		}
	}

	@Override
	protected void onGrdSlotsSelectionChanged() throws PresentationLogicException
	{
		updateControlState();
	}
	
}
