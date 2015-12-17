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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.inpatientdashboardconfiguration;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.scheduling.forms.inpatientdashboardconfiguration.GenForm.grdWardGroupsRow;
import ims.scheduling.forms.inpatientdashboardconfiguration.GenForm.grdWardsRow;
import ims.scheduling.vo.InpatientDashboardConfigVo;
import ims.scheduling.vo.InpatientDashboardConfigVoCollection;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}
	
	private void initialise()
	{
		form.chkActiveOnly().setValue(true);
		
	}

	private void open()
	{
		populateScreenFromData();
		form.setMode(FormMode.VIEW);
		
	}

	private void populateScreenFromData()
	{
		populateWardDeptGrid();
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		
	}

	private void populateWardDeptGrid()
	{
		form.grdWardGroups().getRows().clear();
		
		InpatientDashboardConfigVoCollection wardDeptsColl = domain.listWardDepts(form.chkActiveOnly().getValue());
		
		if (wardDeptsColl==null || wardDeptsColl.size()==0)
			return;
		
		for (InpatientDashboardConfigVo wardDept : wardDeptsColl)
		{
			if (wardDept == null)
				continue;
			
			grdWardGroupsRow rowParent = form.grdWardGroups().getRows().newRow();
			
			rowParent.setValue(wardDept);
			rowParent.setColWardDept(wardDept.getWardDeptName());
			rowParent.setTooltipForColWardDept(wardDept.getWardDeptName());
			rowParent.setColCategory(wardDept.getCategory() != null ? wardDept.getCategory().getText() : "");
			rowParent.setTooltipForColCategory(wardDept.getCategory() != null ? wardDept.getCategory().getText() : "");
			rowParent.setColActive(wardDept.getIsActive() ? "Y" : "N");
			
			rowParent.setExpanded(true);
			
			if (wardDept.getWardLocations() != null && wardDept.getWardLocations().size() > 0)
			{
				wardDept.getWardLocations().sort(SortOrder.ASCENDING);

				for (int i = 0; i < wardDept.getWardLocations().size(); i++)
				{
					LocationLiteVo ward = wardDept.getWardLocations().get(i);

					if (ward == null)
						continue;

					grdWardGroupsRow rowChild = rowParent.getRows().newRow();
					rowChild.setColWardDept(ward.getName());
					rowChild.setTooltipForColWardDept(ward.getName());
				}
			}
		}
		
		form.grdWardGroups().setValue(form.getLocalContext().getSelectedRecord());
		
		if (form.grdWardGroups().getValue() == null) // this is for the case where the record was inactivated
			form.getLocalContext().setSelectedRecord(null);
		
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		boolean isEditMode = FormMode.EDIT.equals(form.getMode());
		boolean recordSelected = form.grdWardGroups().getValue() != null;
		boolean notFirstRecord = form.grdWardGroups().getSelectedRowIndex() != 0;
		
		grdWardGroupsRow lastRecordRow = form.grdWardGroups().getRows().size() > 0 ? form.grdWardGroups().getRows().get(form.grdWardGroups().getRows().size() - 1) : null;
		grdWardGroupsRow selectedRow = form.grdWardGroups().getSelectedRow();
		
		boolean isLastRecord = lastRecordRow != null && selectedRow != null && selectedRow.getValue() != null && selectedRow.getValue().equals(lastRecordRow.getValue());
		
		boolean canMoveUp = !isEditMode && recordSelected && notFirstRecord;
		boolean canMoveDown = !isEditMode && recordSelected && !isLastRecord;
		
		form.btnNew().setVisible(!isEditMode);
		form.btnEdit().setVisible(!isEditMode && recordSelected);
		
		form.getContextMenus().Scheduling.getInpatientDashboardConfigNEW_WARD_DEPTItem().setVisible(!isEditMode);
		form.getContextMenus().Scheduling.getInpatientDashboardConfigEDIT_WARD_DEPTItem().setVisible(!isEditMode && recordSelected);
		form.getContextMenus().Scheduling.getInpatientDashboardConfigMOVE_UPItem().setVisible(canMoveUp);
		form.getContextMenus().Scheduling.getInpatientDashboardConfigMOVE_DOWNItem().setVisible(canMoveDown);
		
		form.txtWardDept().setEnabled(isEditMode);
		form.intRed().setEnabled(isEditMode);
		form.intGreen().setEnabled(isEditMode);
		form.intBlue().setEnabled(isEditMode);
		form.cmbCategory().setEnabled(isEditMode);
		form.chkActive().setEnabled(isEditMode);
		
		form.grdWards().setReadOnly(!isEditMode);
		form.grdWards().setEnabled(isEditMode);
		
		form.btnAdd().setEnabled(isEditMode && form.cmbCategory().getValue() != null);
		form.btnRemove().setEnabled(isEditMode && form.grdWards().getSelectedRow() != null);
		
		form.grdWardGroups().setEnabled(!isEditMode);
		form.grdWardGroups().setReadOnly(!isEditMode);
		
		form.chkActiveOnly().setEnabled(!isEditMode);
		form.chkAll().setEnabled(!isEditMode);
		
	}

	@Override
	protected void onBtnRemoveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdWards().removeSelectedRow();
		updateControlsState();
	}

	@Override
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		grdWardsRow row = form.grdWards().getRows().newRow(true);
		row.setReadOnly(false);
		
		updateControlsState();
	}

	@Override
	protected void onGrdWardsSelectionChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onGrdWardsGridQueryComboBoxTextSubmited(int column, GenForm.grdWardsRow row, String text) throws ims.framework.exceptions.PresentationLogicException
	{
		row.setValue(null);
		row.getColWard().setValue(null);
		row.getColWard().clear();
		
		LocationLiteVoCollection wards = domain.listWards(text);
		
		if( wards == null)
			return;
		
		for (LocationLiteVo ward : wards)
		{
			row.getColWard().newRow(ward, ward.getName());
		}
		
		if (wards.size() == 1)
		{
			row.getColWard().setValue(wards.get(0));
			row.setValue(wards.get(0));
		}
		else
		{
			row.getColWard().showOpened();
		}
	}

	@Override
	protected void onGrdWardGroupsSelectionChanged()
	{
		form.getLocalContext().setSelectedRecord(form.grdWardGroups().getValue());
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		
		updateControlsState();
	}

	private void populateInstanceControls(InpatientDashboardConfigVo wardDept)
	{
		clearInstanceControls();
		
		if (wardDept==null)
			return;
		
		form.txtWardDept().setValue(wardDept.getWardDeptName());
		form.intRed().setValue(wardDept.getRed());
		form.intGreen().setValue(wardDept.getGreen());
		form.intBlue().setValue(wardDept.getBlue());
		form.cmbCategory().setValue(wardDept.getCategory());
		form.chkActive().setValue(wardDept.getIsActive());
		
		if (wardDept.getWardLocations() != null && wardDept.getWardLocations().size() > 0)
		{
			wardDept.getWardLocations().sort(SortOrder.ASCENDING);
			
			for (int i = 0; i < wardDept.getWardLocations().size(); i++)
			{
				LocationLiteVo ward = wardDept.getWardLocations().get(i);

				grdWardsRow row = form.grdWards().getRows().newRow();
				row.getColWard().newRow(ward, ward.getName());
				row.getColWard().setValue(ward);
				row.setValue(ward);
			}
		}
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		clearInstanceControls();
		
		form.chkActive().setValue(true);
		form.getLocalContext().setSelectedRecord(null);
		form.grdWardGroups().setValue(null);
		
		form.setMode(FormMode.EDIT);
		
	}

	private void clearInstanceControls()
	{
		form.txtWardDept().setValue(null);
		form.intRed().setValue(null);
		form.intGreen().setValue(null);
		form.intBlue().setValue(null);
		form.cmbCategory().setValue(null);
		form.chkActive().setValue(null);
		form.grdWards().getRows().clear();
		
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			open();
		}
	}

	private boolean save()
	{
		InpatientDashboardConfigVo wardDeptToSave = populateDataFromScreen(form.getLocalContext().getSelectedRecord());
		
		String[] errors = wardDeptToSave.validate(validateUiRules());
		
		if (errors!=null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.save(wardDeptToSave));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}

	private String[] validateUiRules()
	{
		ArrayList<String> uiErrors = new ArrayList<String>();
		
		if ( form.intRed().getValue() != null &&  form.intRed().getValue() > 255)
		{
			uiErrors.add("Red must not exceed 255 ");
		}
		
		if ( form.intGreen().getValue() != null &&  form.intGreen().getValue() > 255)
		{
			uiErrors.add("Green must not exceed 255 ");
		}
		
		if ( form.intBlue().getValue() != null &&  form.intBlue().getValue() > 255)
		{
			uiErrors.add("Blue must not exceed 255 ");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private InpatientDashboardConfigVo populateDataFromScreen(InpatientDashboardConfigVo wardDeptToSave)
	{
		if (wardDeptToSave == null)
		{
			wardDeptToSave = new InpatientDashboardConfigVo();
			
			Integer savedRecords = domain.countSavedRecords();
			wardDeptToSave.setSequenceNo(savedRecords + 1);
		}
		else
			wardDeptToSave = (InpatientDashboardConfigVo) wardDeptToSave.clone();
		
		
		wardDeptToSave.setWardDeptName(form.txtWardDept().getValue());
		wardDeptToSave.setCategory(form.cmbCategory().getValue());
		wardDeptToSave.setIsActive(form.chkActive().getValue());
		wardDeptToSave.setWardLocations(form.grdWards().getValues());
		
		wardDeptToSave.setRed(form.intRed().getValue());
		wardDeptToSave.setGreen(form.intGreen().getValue());
		wardDeptToSave.setBlue(form.intBlue().getValue());
		
		return wardDeptToSave;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onChkAllValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.chkActiveOnly().setValue(!Boolean.TRUE.equals(form.chkAll().getValue()));
		form.getLocalContext().setSelectedRecord(null);
		
		open();
	}

	@Override
	protected void onChkActiveOnlyValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.chkAll().setValue(!Boolean.TRUE.equals(form.chkActiveOnly().getValue()));
		form.getLocalContext().setSelectedRecord(null);
		
		open();
	}

	@Override
	protected void onCmbCategoryValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbCategory().getValue() == null)
		{
			form.grdWards().getRows().clear();
		}
		
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.InpatientDashboardConfig.NEW_WARD_DEPT:
				 newInstance();
			break;
			
			case GenForm.ContextMenus.SchedulingNamespace.InpatientDashboardConfig.EDIT_WARD_DEPT:
				form.setMode(FormMode.EDIT);
			break;
			
			case GenForm.ContextMenus.SchedulingNamespace.InpatientDashboardConfig.MOVE_UP:
				moveRecord(true);
			break;
			
			case GenForm.ContextMenus.SchedulingNamespace.InpatientDashboardConfig.MOVE_DOWN:
				moveRecord(false);
			break;
		}
	}

	private void moveRecord (boolean moveUp)
	{
		InpatientDashboardConfigVo selectedRecord = form.grdWardGroups().getSelectedRow().getValue();
		
		int rowNumber = 0;
		
		for (int i = 0; i < form.grdWardGroups().getRows().size(); i++)
		{
			grdWardGroupsRow row = form.grdWardGroups().getRows().get(i);
			
			if (selectedRecord.equals(row.getValue()))
			{
				rowNumber = i;
				break;
			}
		}
		
		int previousOrNextRecordRowNumber =  moveUp ? rowNumber - 1 : rowNumber + 1;
		
		InpatientDashboardConfigVo previousOrNextRecord = form.grdWardGroups().getRows().get(previousOrNextRecordRowNumber).getValue();
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.switchSequenceNumber(selectedRecord, previousOrNextRecord));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		
		open();
		
	}

	@Override
	protected void onGrdWardsMutableComboBoxSelected(int column, grdWardsRow row, Object value) throws PresentationLogicException
	{
		row.setValue((LocationLiteVo) value);	
		
	}
}
