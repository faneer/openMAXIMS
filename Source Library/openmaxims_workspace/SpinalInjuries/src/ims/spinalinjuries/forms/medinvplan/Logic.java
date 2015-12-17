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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.22 build 41222.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.medinvplan;

import java.util.ArrayList;

import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.lookups.ContactType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.generalmedical.vo.InvPlanVo;
import ims.spinalinjuries.vo.lookups.InvestigationsOnAdmission;
import ims.spinalinjuries.vo.lookups.InvestigationsOnAdmissionCollection;
import ims.spinalinjuries.vo.lookups.LookupHelper;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws FormOpenException 
	{
		form.ccAuthoring().setIsRequiredPropertyToControls(true); //WDEV-18846
		open();
	}

	private void loadLookupsIntoGrid()
	{
		GenForm.grdInvestOrderedRow row = null;
		InvestigationsOnAdmissionCollection sColl = LookupHelper.getInvestigationsOnAdmission(domain.getLookupService());
		for (int i = 0; i < sColl.size(); i++)
		{
			InvestigationsOnAdmission bInv = sColl.get(i);
			row = form.grdInvestOrdered().getRows().newRow();
			row.setValue(bInv);
			row.setcolInvestigation(bInv.getText());
		}
	}
	
	private void clearScreen()
	{
		form.ccAuthoring().setValue(null); //WDEV-18846
		form.grdInvestOrdered().getRows().clear();
		form.txtPlan().setValue(null);		
	}
	
	private void open() 
	{
	//	On selection of the link on the navigation bar, the page is displayed, 
	//	if no Investigations and Plan are recorded for the Medical Contact then the New button 
	//	is displayed and the update button is hidden, but if information exists then the update 
	//	button is displayed and the new button is hidden.
	
	//	The Investigation grid needs to be prepopulated with the all the lookups,This lookup will be 
	//	ordered and needs to be loaded into the gid in the relevent order.
	
	//	Populate the Recording HCP Date Time from the data already recorded in the MedicalContact if 
	//	this exists otherwise default in the logged in User for the recording HCP and DateTime as current 
	//	Date Time.

	//	On Click New or On Click Update:
	//		On clicking New or Update the screen should be put into Edit Mode, the comboboxes are 
	//		activated and the 'RIGHT' and 'LEFT' Columns in the grid need to be editable in order to 
	//		allow data entry.  The Save and Cancel buttons are activated at this point. (New and 
	//		Update buttons now hidden) 

	//		The User may select multiple Investigations and record comments in the Plan text box.

	//		On Click Save:
	//			Data is saved and the screen is returned to ReadOnly Mode. 

	//		On Click Cancel:
	//			Data is not saved, and the screen is refreshed to display the current Investigations and Plan  
	//			for the Admission Assessment if this is already recorded.
				
		clearScreen();
		loadLookupsIntoGrid();
		
		InvPlanVo voInvPlan = null;
		
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		boolean isMedicalAdmission = (voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION));
		
		if (isMedicalAdmission)		
			voInvPlan = domain.getInvPlanVoByClinicalContact(voClinicalContact);
		else
			voInvPlan = domain.getInvPlanByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		form.getLocalContext().setInvPlanVo(voInvPlan);
		
		if (voInvPlan != null)
		{
			InvestigationsOnAdmissionCollection collInv = voInvPlan.getInvestigationOrdered();
			if (collInv != null)
			{
				GenForm.grdInvestOrderedRow rowInv;
				for (int j = 0; j < collInv.size(); j++)
				{
					InvestigationsOnAdmission invPlan = collInv.get(j);
					int i=0;
					for (i = 0; i < form.grdInvestOrdered().getRows().size(); i++)
					{
						rowInv = form.grdInvestOrdered().getRows().get(i);
						if (rowInv.getValue().getId() == invPlan.getId())
						{
							rowInv.setcolSelect(true);
							break;
						}
					}
					if(i == form.grdInvestOrdered().getRows().size())
					{
						rowInv = form.grdInvestOrdered().getRows().newRow();
						rowInv.setValue(invPlan);
						rowInv.setcolInvestigation(invPlan.getText());
						rowInv.setcolSelect(true);
					}
				}
			}
			if(voInvPlan.getAuthoringInfo() != null)
			{				
				form.ccAuthoring().setValue(voInvPlan.getAuthoringInfo());
			}
			
			form.txtPlan().setValue(voInvPlan.getMedicalPlan());
			
		}
		form.setMode(FormMode.VIEW);
	}
	
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
		clearScreen();
		loadLookupsIntoGrid();
		setDefaultAuthoringInfo();
	}	
	//WDEV-18846 - start
	private void setDefaultAuthoringInfo()
	{		
		boolean isLoggedOnUserHCP = domain.getHcpLiteUser() != null;
		if (isLoggedOnUserHCP)
		{
			form.ccAuthoring().initializeComponent(true,null);
		}
		else
		{
			if (form.getGlobalContext().Core.getCurrentClinicalContact() != null)
			{
				form.ccAuthoring().initializeComponent(false,true); //WDEV-15172 
			}
		}
	}	
	//---------- end WDEV-18846

	protected void onGrdInvestOrderedSelectionChanged() throws PresentationLogicException 
	{
	}
	
	private void updateAuthoringControlsState()
	{
		form.ccAuthoring().setEnabledAuthoringHCP(form.getMode().equals(FormMode.EDIT));	//WDEV-18846 
		form.ccAuthoring().setEnabledDateTime(form.getMode().equals(FormMode.EDIT));		//WDEV-18846
	}
	
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
	}

	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		InvPlanVo voInvPlan = form.getLocalContext().getInvPlanVo();
		if (voInvPlan == null)
			voInvPlan = new InvPlanVo();
		
		voInvPlan.setAuthoringInfo(form.ccAuthoring().getValue());
		voInvPlan.setMedicalPlan(form.txtPlan().getValue());
		voInvPlan.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		InvestigationsOnAdmissionCollection collInv = new InvestigationsOnAdmissionCollection();
		GenForm.grdInvestOrderedRow row = null;	
		for (int i = 0; i < form.grdInvestOrdered().getRows().size(); i++)
		{
			row = form.grdInvestOrdered().getRows().get(i);
			if (row.getcolSelect())
				collInv.add(row.getValue());
		}
		voInvPlan.setInvestigationOrdered(collInv);	
		
		//WDEV-18846 - start
		ArrayList<String> uIErrors = new ArrayList<String>();
		if (form.ccAuthoring().getValue() == null)
		{
			uIErrors.add(form.ccAuthoring().getErrors());
		}

		if((voInvPlan.getInvestigationOrdered()== null || voInvPlan.getInvestigationOrdered().size() <= 0) && voInvPlan.getMedicalPlan() == null)
		{
			uIErrors.add("No data has been set for Investigations / Plan so the record cannot be saved. Please enter data in the above fields prior to saving the record.");			
		}
		String[] messages = voInvPlan.validate(uIErrors.toArray(new String[uIErrors.size()]));
		if (messages != null && messages.length > 0)
		{
			engine.showErrors("Validation Errors", messages);
			return;
		}
		//WDEV-18846 - end

		try
		{			
			voInvPlan = domain.saveInvPlanVo(voInvPlan, form.getGlobalContext().Core.getCurrentClinicalContact());
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;				
		}
		open();
	}

	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		open();
	}

	//WDEV-18846 
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState() //WDEV-18846
	{
		boolean isMedicalAdmission = form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && ContactType.SPINALMEDICALADMISSION.equals(form.getGlobalContext().Core.getCurrentClinicalContact().getContactType());
		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()) && isMedicalAdmission);
		form.btnNew().setEnabled(form.btnNew().isVisible() && form.getLocalContext().getInvPlanVo() == null);
		form.btnUpdate().setVisible(FormMode.VIEW.equals(form.getMode()) &&  isMedicalAdmission && form.getLocalContext().getInvPlanVo() != null);
		updateAuthoringControlsState();
	}
}
