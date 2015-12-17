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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.forms.complexactivityconfig;

import ims.admin.forms.complexactivityconfig.GenForm.grdComplexActivityRow;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final String COLUMN_LINKED_ACTIVITY = "0";
	private static final String COLUMN_SEQUENCE = "1";

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}

	private void initialise()
	{
		form.cmbService().newRow("1", "Biochemistry");
		form.cmbService().newRow("2", "Cardiology");
		form.cmbService().newRow("3", "MSK");

		form.cmbService2().newRow("1", "Biochemistry");
		form.cmbService2().newRow("2", "Cardiology");
		form.cmbService2().newRow("3", "MSK");
	}

	private void open()
	{
		populateGrid();
		createDynamicGridColumns();
		form.setMode(FormMode.VIEW);
	}

	private void populateGrid()
	{
		grdComplexActivityRow newRow = form.grdComplexActivity().getRows().newRow();

		newRow.setColComplexActivity("Diabetes Nurse Specialist");
		newRow.setColActive("Active");
		newRow.setValue("Diabetes Nurse Specialist");

		newRow = form.grdComplexActivity().getRows().newRow();

		newRow.setColComplexActivity("Dietician Appointment");
		newRow.setColActive("Active");
		newRow.setValue("Dietician Appointment");
	}

	private void createDynamicGridColumns()
	{
		form.dyngrdLinkedActivity().getRows().clear();

		DynamicGridColumn columnName = form.dyngrdLinkedActivity().getColumns().newColumn("Linked Activity", COLUMN_LINKED_ACTIVITY);

		columnName.setWidth(300);

		columnName.setAlignment(Alignment.LEFT);
		columnName.setReadOnly(true);
		columnName.setCanGrow(Boolean.TRUE);

		columnName = form.dyngrdLinkedActivity().getColumns().newColumn("Sequence", COLUMN_SEQUENCE);

		columnName.setWidth(80);

		columnName.setAlignment(Alignment.LEFT);
		columnName.setReadOnly(true);
		columnName.setCanGrow(Boolean.TRUE);
	}

	private void populateDynamicGrid()
	{
		form.dyngrdLinkedActivity().getRows().clear();

		DynamicGridRow row = form.dyngrdLinkedActivity().getRows().newRow();

		row.setSelectable(true);

		DynamicGridCell cellActivity = row.getCells().newCell(getColumnById(COLUMN_LINKED_ACTIVITY), DynamicCellType.QUERYCOMBOBOX);

		cellActivity.setTypedText("Diagnostic Appointment");

		DynamicGridCell cellSequence = row.getCells().newCell(getColumnById(COLUMN_SEQUENCE), DynamicCellType.STRING);

		cellSequence.setValue("1");
		cellSequence.setReadOnly(true);

		row.setValue("Diagnostic Appointment");

		row = form.dyngrdLinkedActivity().getRows().newRow();

		row.setSelectable(true);

		DynamicGridCell cellActivity1 = row.getCells().newCell(getColumnById(COLUMN_LINKED_ACTIVITY), DynamicCellType.QUERYCOMBOBOX);

		cellActivity1.setTypedText("First Appointment");

		DynamicGridCell cellSequence1 = row.getCells().newCell(getColumnById(COLUMN_SEQUENCE), DynamicCellType.STRING);

		cellSequence1.setValue("2");
		cellSequence.setReadOnly(true);

		row.setValue("First Appointment");

	}

	private DynamicGridColumn getColumnById(String identifier)
	{
		return form.dyngrdLinkedActivity().getColumns().getByIdentifier(identifier);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.btnEdit().setEnabled(form.grdComplexActivity().getValue() != null);

		form.getContextMenus().Admin.hideAllComplexActivityConfigCMMenuItems();

		form.getContextMenus().Admin.getComplexActivityConfigCMADDItem().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.getContextMenus().Admin.getComplexActivityConfigCMMOVE_UPItem().setVisible(form.dyngrdLinkedActivity().getValue() != null && form.dyngrdLinkedActivity().getSelectedRow().canMoveUp());
		form.getContextMenus().Admin.getComplexActivityConfigCMMOVE_DOWNItem().setVisible(form.dyngrdLinkedActivity().getValue() != null && form.dyngrdLinkedActivity().getSelectedRow().canMoveDown());
		form.getContextMenus().Admin.getComplexActivityConfigCMREMOVEItem().setVisible(form.dyngrdLinkedActivity().getValue() != null);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		populateDynamicGrid();
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onGrdComplexActivitySelectionChanged()
	{
		populateDynamicGrid();
		updateControlsState();
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
	}

	private void clearScreen()
	{
		form.txtComplexActivity().setValue(null);
		form.cmbService().setValue(null);
		form.chkActive().setValue(null);
		form.grdComplexActivity().getRows().clear();

		form.txtComplexAct2().setValue(null);
		form.GroupYesNo().setValue(null);
		form.cmbService2().setValue(null);
		form.dyngrdLinkedActivity().getRows().clear();

	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{}

	@Override
	protected void onDyngrdLinkedActivityRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException
	{
		updateControlsState();

	}
}
