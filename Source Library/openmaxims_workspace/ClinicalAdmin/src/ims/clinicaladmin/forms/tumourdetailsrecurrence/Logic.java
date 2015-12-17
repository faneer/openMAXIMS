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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.60 build 2791.17293)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.forms.tumourdetailsrecurrence;

import java.util.ArrayList;
import java.util.List;

import ims.clinicaladmin.forms.tumourdetailsrecurrence.GenForm; // WDEV - 12358 - This form never worked until this check in :))
import ims.clinicaladmin.forms.tumourdetailsrecurrence.GenForm.grdDisplayRow;
import ims.clinicaladmin.vo.PatientTumourRecurrenceVo;
import ims.clinicaladmin.vo.PatientTumourRecurrenceVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())//	WDEV-15240
			engine.close(DialogResult.OK);
	}

	//	WDEV-15240
	private boolean save() 
	{
		String[] errors = validateUIRules();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		form.getGlobalContext().ClinicalAdmin.setTumourDetailsRecurrence(populateDataFromScreen(form.grdDisplay().getValues()));
		return true;
	}

	//	WDEV-15240
	private String[] validateUIRules() 
	{
		List<String> uiErrors = new ArrayList<String>();
		
		for (int x = 0; x < form.grdDisplay().getRows().size(); x++)
		{
			grdDisplayRow row = form.grdDisplay().getRows().get(x);
			
			if(row == null)
				continue;
			
			if (row.getcolDate() == null)
			{
				uiErrors.add("Date is mandatory.");
			}
			
			if (row.getcolSite() == null)
			{
				uiErrors.add("Site is mandatory.");
			}
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open();
		
		if (form.getGlobalContext().Core.getParentFormModeIsNotNull() && form.getGlobalContext().Core.getParentFormMode().equals(FormMode.VIEW))
		{
			form.setMode(FormMode.VIEW);
			form.getContextMenus().hideAllGenericGridMenuItems();
			form.btnOk().setVisible(false);
		}
	}

	private void initialize()
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		updateContextMenu();
	}

	private void updateContextMenu()
	{
		form.getContextMenus().getGenericGridRemoveItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdDisplay().getSelectedRowIndex() >= 0);
	}

	private void open()
	{
		PatientTumourRecurrenceVoCollection voColl = form.getGlobalContext().ClinicalAdmin.getTumourDetailsRecurrence();
		populateScreenFromData(voColl);
	}

	private void populateScreenFromData(PatientTumourRecurrenceVoCollection voColl)
	{
		form.grdDisplay().getRows().clear();

		if (voColl != null)
		{
			for (int x = 0; x < voColl.size(); x++)
			{
				PatientTumourRecurrenceVo selectedRecord = voColl.get(x);
				grdDisplayRow row = form.grdDisplay().getRows().newRow();
				row.setcolDate(selectedRecord.getRecurrenceDate());
				row.setcolSite(selectedRecord.getRecurrenceSite());
				row.setValue(selectedRecord);
				row.setReadOnly(true);
			}
		}
	}

	private PatientTumourRecurrenceVoCollection populateDataFromScreen(PatientTumourRecurrenceVoCollection voColl)
	{
		if (voColl == null)
			voColl = new PatientTumourRecurrenceVoCollection();

		PatientTumourRecurrenceVo record = null;;
		for (int x = 0; x < form.grdDisplay().getRows().size(); x++)
		{
			record = form.grdDisplay().getRows().get(x).getValue();
			grdDisplayRow rowValue = form.grdDisplay().getRows().get(x);
			record.setRecurrenceDate(rowValue.getcolDate());
			record.setRecurrenceSite(rowValue.getcolSite());

			if (record.getID_PatientTumourRecurrenceIsNotNull())
				voColl.add(x, record);
			else
				voColl.add(record);
		}

		return voColl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ims.clinicaladmin.forms.tumourdetailsrecurrence.Handlers#onContextMenuItemClick(int, ims.framework.Control)
	 */
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				add();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				remove();
				break;
		}
		
		updateContextMenu();
	}

	/**
	 * 
	 */
	private void remove()
	{
		form.grdDisplay().getRows().remove(form.grdDisplay().getSelectedRowIndex());
		updateContextMenu();
	}

	private void add()
	{
		grdDisplayRow row = form.grdDisplay().getRows().newRow();
		row.setValue(new PatientTumourRecurrenceVo());
		row.setcolDate(new Date());
		row.setReadOnly(false);

		updateContextMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ims.clinicaladmin.forms.tumourdetailsrecurrence.Handlers#onGrdDisplaySelectionChanged()
	 */
	@Override
	protected void onGrdDisplaySelectionChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		updateContextMenu();
	}
}
