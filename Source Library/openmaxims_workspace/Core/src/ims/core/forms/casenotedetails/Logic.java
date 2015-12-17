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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.casenotedetails;

import ims.core.clinical.vo.PatientCaseNoteRefVo;
import ims.core.vo.PatientCaseNoteDetailsVo;
import ims.core.vo.PatientLiteVo;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	
	private static final int COL_LABEL = 1;
	private static final int COL_VALUE = 2;

	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form Event handlers
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (args == null || args.length == 0)
			return;
		
		initialize();
		
		if (args[0] instanceof PatientCaseNoteRefVo)
			populateCaseNoteDetails(domain.getPatientCaseNote((PatientCaseNoteRefVo) args[0]));
	}


	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}



	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	private void initialize()
	{
		// Initialize dynamic grid 
		form.dyngrdDetails().clear();
		
		// Label column
		DynamicGridColumn colLabel = form.dyngrdDetails().getColumns().newColumn("", COL_LABEL);
		colLabel.setWidth(200);
		
		// Value column
		DynamicGridColumn colValue = form.dyngrdDetails().getColumns().newColumn("", COL_VALUE);
		colValue.setWidth(400);
		
		form.dyngrdDetails().setSelectable(false);
	}


	private void populateCaseNoteDetails(PatientCaseNoteDetailsVo patientCaseNote)
	{
		form.dyngrdDetails().getRows().clear();
		
		if (patientCaseNote == null)
			return;
		
		// Patient Details
		DynamicGridRow patientRow = form.dyngrdDetails().getRows().newRow();
		DynamicGridCell patientCell = patientRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		patientCell.setValue("<b>Patient:</b>");
		patientRow.setBackColor(Color.LightGray);

		PatientLiteVo patient = patientCaseNote.getPatient();
		
		// Patient Name
		DynamicGridRow row = patientRow.getRows().newRow();
		DynamicGridCell patientNameLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		patientNameLabelCell.setValue("<b>Name:</b>");
		DynamicGridCell patientNameValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		patientNameValueCell.setValue(patient != null ? patient.getName().toString() : "-");
		
		// Patient DOB
		row = patientRow.getRows().newRow();
		DynamicGridCell patientDOBLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		patientDOBLabelCell.setValue("<b>Date of Birth:</b>");
		DynamicGridCell patientDOBValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		patientDOBValueCell.setValue(patient != null && patient.getDob() != null ? patient.getDob().toString() : "-");
		
		// Patient Sex
		row = patientRow.getRows().newRow();
		DynamicGridCell patientSexLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		patientSexLabelCell.setValue("<b>Sex:</b>");
		DynamicGridCell patientSexValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		patientSexValueCell.setValue(patient != null && patient.getSex() != null ? patient.getSex().getText() : "-");
		
		
		// Case Note Details
		DynamicGridRow caseNoteRow = form.dyngrdDetails().getRows().newRow();
		DynamicGridCell caseNoteCell = caseNoteRow.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteCell.setValue("<b>Case Note Details</b>");
		caseNoteRow.setBackColor(Color.LightGray);
		
		
		// Case Note Type
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteTypeLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteTypeLabelCell.setValue("<b>Case Note Type:</b>");
		DynamicGridCell caseNoteTypeValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteTypeValueCell.setValue(patientCaseNote.getType().getText());
		
		// Case Note Folder
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteFolderLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteFolderLabelCell.setValue("<b>Folder:</b>");
		DynamicGridCell caseNoteFolderValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteFolderValueCell.setValue(patientCaseNote.getFolder().getText());
		
		// Case Note Tracking ID
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteTrackingLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteTrackingLabelCell.setValue("<b>Tracking ID</b>");
		DynamicGridCell caseNoteTrackingValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteTrackingValueCell.setValue(patientCaseNote.getTrackingID());
		
		// Case Note Status
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteStatusLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteStatusLabelCell.setValue("<b>Status:</b>");
		DynamicGridCell caseNoteStatusValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteStatusValueCell.setValue(patientCaseNote.getStatus().getText());
		
		// Case Note Created By
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteCreateByLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteCreateByLabelCell.setValue("<b>Created By:</b>");
		DynamicGridCell caseNoteCreatedByValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteCreatedByValueCell.setValue(patientCaseNote.getCreatedBy().getName().toString());
		
		
		// Case Note Creation Date
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteCreationDateLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteCreationDateLabelCell.setValue("<b>Created On:</b>");
		DynamicGridCell caseNoteCreationDateValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteCreationDateValueCell.setValue(patientCaseNote.getCreationDate().getDate().toString());
		
		// Case Note Current Location
		row = caseNoteRow.getRows().newRow();
		DynamicGridCell caseNoteCurrentLocationLabelCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_LABEL), DynamicCellType.STRING);
		caseNoteCurrentLocationLabelCell.setValue("<b>Current Location:</b>");
		DynamicGridCell caseNoteCurrentLocationValueCell = row.getCells().newCell(form.dyngrdDetails().getColumns().getByIdentifier(COL_VALUE), DynamicCellType.STRING);
		caseNoteCurrentLocationValueCell.setValue(patientCaseNote.getCurrentLocation().getName());
		
		
		patientRow.setExpanded(true);
		caseNoteRow.setExpanded(true);
	}
}
