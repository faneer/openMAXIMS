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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41222.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.forms.vertebrallevels;

import ims.clinicaladmin.forms.vertebrallevels.GenForm.grdLevelRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.VertebrallevelVoCollection;
import ims.core.vo.VertebrallevelVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.chkActiveOnly().setValue(false);
		open();
	}
	
	private void open() 
	{
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setVisible(false);
		form.getContextMenus().getAddUpDownMOVEUPItem().setVisible(false);
		listVertebral();
	}
	
	private void listVertebral() 
	{
		form.grdLevel().setValue(null);
		
		form.grdLevel().getRows().clear();
		VertebrallevelVoCollection voCollVertebral  = domain.listVertebralLevel(new Boolean(form.chkActiveOnly().getValue()));
		VertebrallevelVo voVertebralItem;
		GenForm.grdLevelRow row = null;
		for(int i=0;i<voCollVertebral.size();i++)
		{
			voVertebralItem = voCollVertebral.get(i);
			row = form.grdLevel().getRows().newRow();
			
			row.setcolActive(voVertebralItem.getIsActive().booleanValue());
			row.setcolDescription(voVertebralItem.getDescription());
			row.setcolLevel(voVertebralItem.getName());
			//WDEV-3158 
			row.setcolLevelReadOnly(true);
			// WDEV - 7007
//			row.setcolLowerLimb(voVertebralItem.getIsLLAsiaScore().booleanValue());
//			row.setcolUpperLimb(voVertebralItem.getIsULAsiaScore().booleanValue());
			row.setValue(voVertebralItem);
		}		
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdLevel().setValue(null);
		form.setMode(FormMode.EDIT);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		VertebrallevelVoCollection voCollVertebral = new VertebrallevelVoCollection();
		VertebrallevelVo voVertebralItem;
		GenForm.grdLevelRow row;
		for(int i=0;i<form.grdLevel().getRows().size();i++)
		{
			row = form.grdLevel().getRows().get(i);
			voVertebralItem = row.getValue();
			
			//Validation had to be set in code, as VO is used in other forms where it is not mandatory.
			if(row.getcolLevel() == null || row.getcolLevel() == "")
			{
				engine.showMessage("'Level' is a mandatory field");
				return;
			}
			voVertebralItem.setDescription(row.getcolDescription());
			voVertebralItem.setIsActive(new Boolean(row.getcolActive()));
			voVertebralItem.setName(row.getcolLevel());
			// WDEV - 7007
//			voVertebralItem.setIsLLAsiaScore(new Boolean(row.getcolLowerLimb()));
//			voVertebralItem.setIsULAsiaScore(new Boolean(row.getcolUpperLimb()));
			voVertebralItem.setOrderNo(new Integer(i));
			voCollVertebral.add(voVertebralItem);
		}
		
		String[] arrErrors = voCollVertebral.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		
		try {
			domain.saveVetrebralLevel(voCollVertebral);
		} catch (StaleObjectException e) {
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		
		form.setMode(FormMode.VIEW);
		open();
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();
	}
	
	protected void onImbAddClick()
	{
		newVertebralLevel();
	}

	private void newVertebralLevel() {
		GenForm.grdLevelRow row = form.grdLevel().getRows().newRow();
		row.setValue(new VertebrallevelVo());
		
		row.setcolActive(true);
		// WDEV - 7007
//		row.setcolLowerLimb(false);
//		row.setcolUpperLimb(false);
		
		form.grdLevel().setValue(null);
		setUpDownBtns();
	}

	protected void onChkActiveOnlyValueChanged() throws PresentationLogicException 
	{
		listVertebral();
	}
	
	protected void onImbUpClick() 
	{
		moveUP();
	}

	private void moveUP() 
	{
		form.grdLevel().moveUp();
		setUpDownBtns();
	}

	protected void onImbDownClick() 
	{
		moveDOWN();
	}

	private void moveDOWN()
	{
		form.grdLevel().moveDown();
		setUpDownBtns();
	}
	
	private void setUpDownBtns() 
	{
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setVisible(form.grdLevel().canMoveCurrentDown());
		form.getContextMenus().getAddUpDownMOVEUPItem().setVisible(form.grdLevel().canMoveCurrentUp());
	}

	protected void onGrdLevelSelectionChanged() throws PresentationLogicException 
	{
		if(form.getMode().equals(FormMode.EDIT))
			setUpDownBtns();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdLevel()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.AddUpDown.ADD:
					newVertebralLevel();
					break;
				case GenForm.ContextMenus.AddUpDown.MOVEUP:
					moveUP();
					break;
				case GenForm.ContextMenus.AddUpDown.MOVEDOWN:
					moveDOWN();
					break;
			}
		}
		
	}

	protected void onFormModeChanged() 
	{
		form.getContextMenus().getAddUpDownADDItem().setVisible(form.getMode().equals(FormMode.EDIT));		
	}


	protected void onGrdLevelGridCheckBoxClicked(int column, grdLevelRow row, boolean isChecked) throws PresentationLogicException
	{
		// WDEV - 7007
//		if(column == 2 || column == 3)
//		{
//			if(isChecked)
//			{
//				if(column == 2)
//				{
//					row.setcolLowerLimb(false);
//				}
//				else if(column == 3)
//				{
//					row.setcolUpperLimb(false);
//				}
//			}
//		}
	}
}
