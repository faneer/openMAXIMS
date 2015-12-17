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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3537.24515)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.medications;

import ims.clinical.vo.lookups.CodingItemType;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.MedicationDose;
import ims.core.vo.MedicationDoseCollection;
import ims.core.vo.MedicationLiteVo;
import ims.core.vo.PatientMedicationVo;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.MedicationRoute;
import ims.core.vo.lookups.MedicationRouteCollection;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	// Dynamic grid columns
	private static final int COL_DOSE_DOSENAME = 1;
	private static final int COL_DOSE_ROUTE = 2;
	private static final int COL_DOSE_COMMENCED_BY = 5;
	private static final int COL_DOSE_COMMENCED_DATE = 6;
	
	private static final Integer ROW_STATE_EDITABLE = 1;
	private static final Integer ROW_STATE_NOT_EDITABLE = 2;

	//-----------------------------------------------------------------------------------------------------------------------------------------
	// Events region
	//-----------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initilize();
		open();
	}
	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Read data from screen
		PatientMedicationVo tempVo;
		
		if (form.getGlobalContext().RefMan.getPatientMedicationIsNotNull())
		{
			tempVo = populateInstanceFromScreen((PatientMedicationVo) form.getGlobalContext().RefMan.getPatientMedication().clone());
		}
		else
		{
			tempVo = populateInstanceFromScreen();
		}
		
		String[] errors = tempVo.validate(validateUIRules());
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		form.getGlobalContext().RefMan.setPatientMedication(populateInstanceFromScreen(form.getGlobalContext().RefMan.getPatientMedication()));
		
		engine.close(DialogResult.OK);
	}
	
	private String[] validateUIRules()
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (form.ccMedication().getValue()== null)
			errorList.add("Clinical Term is mandatory.");

		if (form.dteCommencedDate().getValue() != null && form.dteCommencedDate().getValue().isGreaterThan(new Date()))
			errorList.add("Commenced Date cannot be in the future."); //WDEV-18762
		
		for (int i = 0; i < form.dyngrdDoses().getRows().size(); i++)
		{
			DynamicGridRow doseRow = form.dyngrdDoses().getRows().get(i);
			
			DynamicGridCell doseCell = doseRow.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_DOSENAME));
			if (doseCell.getValue() == null)
				errorList.add("Dose and Route are mandatory for all prescribed doses.");
			
			DynamicGridCell routeCell = doseRow.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_ROUTE));
			if (routeCell.getValue() == null)
				errorList.add("Dose and Route are mandatory for all prescribed doses.");
		}

		return errorList.toArray(new String[errorList.size()]);
	}

	@Override
	protected void onQmbCommencedByHcpTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			populateHcpValues(domain.getHcp(value));
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
		}
	}

	@Override
	protected void onDyngrdDosesRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		updateControlsState();
	}
	
	@Override
	protected void onDyngrdDosesRowSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.MedicationMultipleDoses.NEW_DOSE:
				newDose(); 
				break;
				
			case GenForm.ContextMenus.MedicationMultipleDoses.UPDATE_DOSE:
				updateDose();
				break;
				
			case GenForm.ContextMenus.MedicationMultipleDoses.DISCONTINUE_DOSE:
				removeDose();
				break;
		}
		
		updateControlsState();
	}

	
	//-----------------------------------------------------------------------------------------------------------------------------------------
	// Window control region
	//-----------------------------------------------------------------------------------------------------------------------------------------
	
	private void initilize()
	{
		// Initialize dynamic grid
		initializeDynamicGrid();
		
		// Initialize context menu
		form.getContextMenus().getMedicationMultipleDosesNEW_DOSEItem().setEnabled(true);
		form.getContextMenus().getMedicationMultipleDosesDISCONTINUE_DOSEItem().setEnabled(true);
		form.getContextMenus().getMedicationMultipleDosesDISCONTINUE_DOSEItem().setText("Remove");
		
		form.ccMedication().setCodingItemType(CodingItemType.MEDICATION);
		form.ccMedication().setHotlist(Boolean.FALSE);
		form.ccMedication().setParentEditing(Boolean.TRUE);
		form.ccMedication().setSpecialty(Specialty.PRESCRIPTION);
		
		form.ccMedication().setClinicalTermMandatory(Boolean.TRUE);
		form.ccMedication().setDescriptionMandatory(Boolean.TRUE);
		
		//WDEV-20283
		if (form.getGlobalContext().RefMan.getPatientMedication()!=null)
			form.btnAdd().setText("Save");
		form.ccMedication().setDrugsAlreadyAddedToPrescriptionStringID(form.getGlobalContext().RefMan.getDrugsAlreadyAddedToPrescription());
	}

	private void initializeDynamicGrid()
	{
		form.dyngrdDoses().clear();
		
		form.dyngrdDoses().setSelectable(true);
		
		DynamicGridColumn column = form.dyngrdDoses().getColumns().newColumn("Dose");
		column.setIdentifier(COL_DOSE_DOSENAME);
		column.setWidth(120);
		column.setDynamicWidthSupported(true);
		
		column = form.dyngrdDoses().getColumns().newColumn("Route");
		column.setIdentifier(COL_DOSE_ROUTE);
		column.setWidth(120);
		column.setDynamicWidthSupported(true);
		
//		column = form.dyngrdDoses().getColumns().newColumn("Times");
//		column.setIdentifier(COL_DOSE_TIMES);
//		column.setWidth(120);
//		column.setDynamicWidthSupported(true);
		
//		column = form.dyngrdDoses().getColumns().newColumn("Commenced By Type");
//		column.setIdentifier(COL_DOSE_COMMENCED_BY_TYPE);
//		column.setWidth(120);
//		
		column = form.dyngrdDoses().getColumns().newColumn("Commenced By (HCP)");
		column.setIdentifier(COL_DOSE_COMMENCED_BY);
		column.setWidth(200);
		column.setDynamicWidthSupported(true);
		
		column = form.dyngrdDoses().getColumns().newColumn("Date");
		column.setIdentifier(COL_DOSE_COMMENCED_DATE);
		column.setWidth(-1);
		column.setDynamicWidthSupported(true);
	}

	private void open()
	{
		populateScreenFromInstance(form.getGlobalContext().RefMan.getPatientMedication());
		
		form.setMode(FormMode.EDIT);
	}


	private void clearInstanceControls()
	{
		form.ccMedication().clear();
		form.cmbCommencedBy().setValue(null);
		form.qmbCommencedByHcp().clear();
		form.dteCommencedDate().setValue(null);
		form.cmbFrequency().setValue(null);
		form.cmbSource().setValue(null);
		form.dyngrdDoses().getRows().clear();
		form.chkIncludeInDrugOrder().setValue(null);
		form.intNumberOfDaysSupply().setValue(null);
	}

	private void updateControlsState()
	{
		updateContextMenuState();
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().getMedicationMultipleDosesNEW_DOSEItem().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.getContextMenus().getMedicationMultipleDosesDISCONTINUE_DOSEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.dyngrdDoses().getValue() instanceof MedicationDose);
		
		form.getContextMenus().getMedicationMultipleDosesUPDATE_DOSEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.dyngrdDoses().getValue() instanceof MedicationDose
																						&& form.dyngrdDoses().getSelectedRow() != null
																						&& ROW_STATE_NOT_EDITABLE.equals(form.dyngrdDoses().getSelectedRow().getIdentifier()));
	}

	@SuppressWarnings("unchecked")
	private void populateHcpValues(HcpCollection hcpCollection)
	{
		form.qmbCommencedByHcp().clear();
		
		if (hcpCollection == null || hcpCollection.size() == 0)
			return;
		
		if (hcpCollection.size() == 1 && hcpCollection.get(0) != null)
		{
			form.qmbCommencedByHcp().newRow(hcpCollection.get(0), hcpCollection.get(0).getMosIsNotNull() ? hcpCollection.get(0).toString() : "");
			form.qmbCommencedByHcp().setValue(hcpCollection.get(0));
			
			return;
		}

		
		for (int i = 0; i < hcpCollection.size(); i++)
		{
			Hcp hcp = hcpCollection.get(i);
			
			if (hcp == null)
				continue;
			
			form.qmbCommencedByHcp().getValues().add(hcp);
			
			form.qmbCommencedByHcp().newRow(hcp, hcp.getMosIsNotNull() ? hcp.getMos().toString() : "");
		}

		form.qmbCommencedByHcp().showOpened();
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange region
	//-----------------------------------------------------------------------------------------------------------------------------------------
	
	private void populateScreenFromInstance(PatientMedicationVo patientMedication)
	{
		clearInstanceControls();
		
		if (patientMedication == null)
			return;
		
		form.ccMedication().setValue(patientMedication);
		
		form.cmbCommencedBy().setValue(patientMedication.getCommencedByType());

		if (patientMedication.getHcpCommenced() != null)
		{
			form.qmbCommencedByHcp().newRow(patientMedication.getHcpCommenced(), patientMedication.getHcpCommenced().getMosIsNotNull() ? patientMedication.getHcpCommenced().getMos().toString() : "HCP name not available");
			form.qmbCommencedByHcp().setValue(patientMedication.getHcpCommenced());
		}
		
		form.dteCommencedDate().setValue(patientMedication.getCommencedDate());
		form.cmbFrequency().setValue(patientMedication.getFrequency());
		form.cmbSource().setValue(patientMedication.getSourceofInformation());
		
		setDoses(patientMedication.getPrescribedDoses());
		
		form.chkIncludeInDrugOrder().setValue(patientMedication.getIsCopied());
		form.intNumberOfDaysSupply().setValue(patientMedication.getNoDaysSupply());
	}

	private PatientMedicationVo populateInstanceFromScreen(PatientMedicationVo patientMedication)
	{
		if (patientMedication == null)
		{
			patientMedication = new PatientMedicationVo();
			patientMedication.setPatient(domain.getPatient(form.getGlobalContext().RefMan.getCatsReferral()));
		}
		
		patientMedication.setMedication((MedicationLiteVo) form.ccMedication().getSelectedItem());
		patientMedication.setOtherMedicationText(form.ccMedication().getDescription());
		
		patientMedication.setCommencedByType(form.cmbCommencedBy().getValue());
		patientMedication.setHcpCommenced(form.qmbCommencedByHcp().getValue());
		patientMedication.setCommencedDate(form.dteCommencedDate().getValue());
		patientMedication.setFrequency(form.cmbFrequency().getValue());
		patientMedication.setSourceofInformation(form.cmbSource().getValue());
		
		patientMedication.setPrescribedDoses(getDoses(patientMedication.getPrescribedDoses()));
		
		patientMedication.setIsCopied(form.chkIncludeInDrugOrder().getValue());
		patientMedication.setNoDaysSupply(form.intNumberOfDaysSupply().getValue());
		
		return patientMedication;
	}

	private PatientMedicationVo populateInstanceFromScreen()
	{
		return populateInstanceFromScreen(null);
	}
	

	//-----------------------------------------------------------------------------------------------------------------------------------------
	// Doses
	//-----------------------------------------------------------------------------------------------------------------------------------------

	private MedicationDoseCollection getDoses(MedicationDoseCollection prescribedDoses)
	{
		if (prescribedDoses == null)
		{
			prescribedDoses = new MedicationDoseCollection();
		}
		
		prescribedDoses.clear();
		
		for (int i = 0; i < form.dyngrdDoses().getRows().size(); i++)
		{
			prescribedDoses.add(getDoseRowValue(form.dyngrdDoses().getRows().get(i)));
		}
		
		return prescribedDoses;
	}
	
	private void setDoses(MedicationDoseCollection prescribedDoses)
	{
		form.dyngrdDoses().getRows().clear();
		
		if (prescribedDoses == null)
			return;
		
		for (int i = 0; i < prescribedDoses.size(); i++)
		{
			setDoseRowValue(form.dyngrdDoses().getRows().newRow(), prescribedDoses.get(i));
		}
	}

	private void setDoseRowValue(DynamicGridRow row, MedicationDose dose)
	{
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not set a dose to null row");
		
		row.setValue(dose);
		
		if (dose == null)
			return;
		
		DynamicGridCell cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_DOSENAME), DynamicCellType.STRING);
		cell.setValidationMessage("Dose length is restricted to 255 characters.");
		cell.setValue(dose.getDose());
		cell.setWidth(120);
		cell.setReadOnly(true);
		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_ROUTE), DynamicCellType.ENUMERATION);
		// bind to lookup
		cell.getItems().clear();
		MedicationRouteCollection medicationRouteCollection = LookupHelper.getMedicationRoute(domain.getLookupService());
		for (int i = 0; i < medicationRouteCollection.size(); i++)
		{
			MedicationRoute route = medicationRouteCollection.get(i);
			cell.getItems().newItem(route, route.getText());
		}
		cell.setValue(dose.getAdminRoute());
		cell.setWidth(120);
		cell.setReadOnly(true);
		
		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_BY), DynamicCellType.STRING);
		cell.setIdentifier(dose.getDoseStartHcp());
		cell.setValue(dose.getDoseStartHcp() != null ? dose.getDoseStartHcp().toString() : "");
		cell.setWidth(200);
		cell.setReadOnly(true);
		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_DATE), DynamicCellType.DATE);
		cell.setValue(dose.getDoseStartDate());
		cell.setWidth(-1);
		cell.setReadOnly(true);
		
		row.setIdentifier(ROW_STATE_NOT_EDITABLE);
	}

	private MedicationDose getDoseRowValue(DynamicGridRow row)
	{
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not read a value from null row");
		
		if (row.getValue() == null || !(row.getValue() instanceof MedicationDose))
		{
			row.setValue(new MedicationDose());
		}
		
		MedicationDose dose = (MedicationDose) row.getValue();
		
		DynamicGridCell cell = row.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_DOSENAME));
		dose.setDose(cell.getValue() != null ? cell.getValue().toString() : null);
		
		cell = row.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_ROUTE));
		dose.setAdminRoute(cell.getValue() != null ? (MedicationRoute) (cell.getValue()) : null);
		
		cell = row.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_BY));
		dose.setDoseStartHcp(cell.getIdentifier()!= null ? (Hcp) (cell.getIdentifier()) : null);
		
		cell = row.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_DATE));
		dose.setDoseStartDate(cell.getValue() != null ? (Date) (cell.getValue()) : null);
		
		return dose;
	}

	private void newDose()
	{
		DynamicGridRow row = form.dyngrdDoses().getRows().newRow();
		
		DynamicGridCell cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_DOSENAME), DynamicCellType.STRING);
		cell.setReadOnly(false);
		cell.setStringMaxLength(255);
		cell.setValidationMessage("Dose length is restricted to 255 characters.");
		cell.setWidth(120);
		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_ROUTE), DynamicCellType.ENUMERATION);
		cell.setReadOnly(false);
		// bind to lookup
		cell.getItems().clear();
		MedicationRouteCollection medicationRouteCollection = LookupHelper.getMedicationRoute(domain.getLookupService());
		for (int i = 0; i < medicationRouteCollection.size(); i++)
		{
			MedicationRoute route = medicationRouteCollection.get(i);
			cell.getItems().newItem(route, route.getText());
		}
		cell.setWidth(120);

		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_BY), DynamicCellType.STRING);
		cell.setReadOnly(true);
		cell.setIdentifier(domain.getHcpUser());
		cell.setValue(domain.getHcpUser() != null ? domain.getHcpUser().toString() : "");
		cell.setWidth(200);
		
		cell = row.getCells().newCell(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_COMMENCED_DATE), DynamicCellType.DATE);
		cell.setReadOnly(true);
		cell.setValue(new Date());
		cell.setWidth(-1);
		
		row.setValue(new MedicationDose());
		
		row.setIdentifier(ROW_STATE_EDITABLE);
	
		// Update grid selection
		form.dyngrdDoses().setSelectedRow(row);
	}

	private void updateDose()
	{
		DynamicGridRow doseRow = form.dyngrdDoses().getSelectedRow();
		
		if (doseRow == null)
			return;
		
		DynamicGridCell cellDose = doseRow.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_DOSENAME));
		cellDose.setReadOnly(false);
		
		DynamicGridCell cellRoute = doseRow.getCells().get(form.dyngrdDoses().getColumns().getByIdentifier(COL_DOSE_ROUTE));
		cellRoute.setReadOnly(false);
		
		doseRow.setIdentifier(ROW_STATE_EDITABLE);
	}

	private void removeDose()
	{
		if (form.dyngrdDoses().getSelectedRow() == null)
			return;
		
		form.dyngrdDoses().getRows().remove(form.dyngrdDoses().getSelectedRow());
	}
}
