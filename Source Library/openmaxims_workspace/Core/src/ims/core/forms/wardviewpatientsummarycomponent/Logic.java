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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.wardviewpatientsummarycomponent;

import ims.core.resource.place.vo.LocationRefVo;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int COL_LABEL = 0;
	private static final int COL_VALUE = 1;
	private static final int COL_BUTTON = 2;
	
	private static final int COL_LABEL_WIDTH = 180;
	private static final int COL_VALUE_WIDTH = 25;
	private static final int COL_BUTTON_WIDTH = 25;
	
	
	public static final int ROW_OCCUPYING_A_BED = 0;
	public static final int ROW_AWAITING_BED = 1;
	public static final int ROW_HOME_LEAVE = 2;
	public static final int ROW_HOME_LEAVE_WITH_BED = 3;
	public static final int ROW_SPECIALTY_OUTLIERS = 4;
	public static final int ROW_DISCHARGE_WITHIN_24_HOURS = 5;
	public static final int ROW_DISCHARGE_CONFIRMED_24_HOURS = 6;
	public static final int ROW_READY_TO_LEAVE = 7;
	public static final int ROW_STILL_TO_ARRIVE = 8;
	public static final int ROW_ARRIVED = 9;
	public static final int ROW_SEEN = 10;
	public static final int ROW_TRANSFER_OUT = 11;
	public static final int ROW_TRANSFER_IN = 12;
	public static final int ROW_ED_ADMISSIONS = 13;
	public static final int ROW_EMERGENCY_ADMISSIONS = 14;
	public static final int ROW_ELECTIVE_TCI_ADMISSIONS = 15;
	public static final int ROW_PENDING_EMERGENCY_THEATRE = 16;

	private static final String OCCUPYING_BED_CAPTION = "Patients Occupying a Bed/Chair List";
	private static final String AWAITING_BED_CAPTION = "Patients Awaiting Bed/Chair List";
	private static final String HOMELEAVE_CAPTION = "Patients on Home Leave List";
	private static final String HOMELEAVE_BED_CAPTION = "Patients on Home Leave with Retained Bed/Chair List";
	private static final String PATIENTS_FROM_ED_CAPTION = "Incoming ED Patients List";
	private static final String PENDING_EMERGENCY_CAPTION = "Pending Emergency Admissions List";
	private static final String ELECTIVE_TCI_CAPTION = "Elective TCIs List";
	private static final String PENDING_EMERGENCY_THEATRE_CAPTION  = "Pending Emergency Theatre List";
	private static final String TRANSFER_OUT_CAPTION = "Transfer Out Patients List";
	private static final String TRANSFER_IN_CAPTION = "Transfer In Patients List";
	private static final String DISCHARGE_WITHIN_24HRS_CAPTION = "Patients for Discharge Within 24 Hours List";
	private static final String DISCHARGE_CONFIRMED_24HRS_CAPTION = "Patients with Discharge Confirmed Within 24 Hours List";
	private static final String DISCHARGE_READY_TO_LEAVE_CAPTION = "Patients for Discharge Ready to Leave List";
	private static final String WARD_ATTENDERS_TO_ARRIVE_CAPTION = "Ward Attenders Still to Arrive List";
	private static final String WARD_ATTENDERS_ARRIVED_CAPTION = "Arrived Ward Attenders List";
	private static final String WARD_ATTENDERS_SEEN_CAPTION = "Seen Ward Attenders List";
	
	private static final String DEFAULT_VIEW_CAPTION = "Ward View Patient List";
	//-------------------------------------------------------------------------------------------------------------------------------------
	//	Component Interface
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	public void setVisible(Boolean visibleState)
	{
		form.dyngrdPatients().setVisible(Boolean.TRUE.equals(visibleState));
	}
	
	public void initialize()
	{
		form.dyngrdPatients().clear();
		form.dyngrdPatients().setSelectable(false);
		form.dyngrdPatients().setReadOnly(true);
		
		DynamicGridColumn colLabel = form.dyngrdPatients().getColumns().newColumn("", COL_LABEL);
		colLabel.setWidth(COL_LABEL_WIDTH);
		colLabel.setDynamicWidthSupported(true);
	
		DynamicGridColumn colValue = form.dyngrdPatients().getColumns().newColumn("", COL_VALUE);
		colValue.setWidth(COL_VALUE_WIDTH);
		colValue.setAlignment(Alignment.CENTER);
		
		DynamicGridColumn colButton = form.dyngrdPatients().getColumns().newColumn("", COL_BUTTON);
		colButton.setWidth(COL_BUTTON_WIDTH);
		colButton.setAlignment(Alignment.CENTER);
		
		form.getLocalContext().setAwaitingBedCount(0);
		
		populateDynamicGrid();
	}

	public void setValue(LocationRefVo ward, LocationRefVo bay)
	{
		form.getGlobalContext().Core.setWardViewPatientListWard(ward);
		form.getGlobalContext().Core.setWardViewPatientListBay(bay);
		
		
		// ON THE WARD
		int patientsOnWard = domain.countPatientsOnTheWard(ward, bay);
		form.getGlobalContext().Core.setMaleBedAdmissionWardCount(domain.countMalePatientsOnTheWard(ward, bay));
		form.getGlobalContext().Core.setFemaleBedAdmissionWardCount(domain.countFemalePatientsOnTheWard(ward, bay));
		DynamicGridCell cellValueOnTheWard = getCell(ROW_OCCUPYING_A_BED, COL_VALUE);
		if (cellValueOnTheWard != null)
			cellValueOnTheWard.setValue(patientsOnWard);
		if (patientsOnWard > 0)
		{
			getCell(ROW_OCCUPYING_A_BED, COL_BUTTON);
		}
		
		// AWAITING BED
		int patientsAwaitingBed = domain.countPatientsAwaitingBedOnWard(ward, bay);
		form.getLocalContext().setAwaitingBedCount(patientsAwaitingBed);
		DynamicGridCell cellValueAwaitingBed = getCell(ROW_AWAITING_BED, COL_VALUE);
		if (cellValueAwaitingBed != null)
			cellValueAwaitingBed.setValue(patientsAwaitingBed);
				
		// HOME LEAVE
		int patientsOnHomeLeave = domain.countPatientsOnHomeLeave(ward, bay);
		DynamicGridCell cellValueHomeLeave = getCell(ROW_HOME_LEAVE, COL_VALUE);
		if (cellValueHomeLeave != null)
			cellValueHomeLeave.setValue(patientsOnHomeLeave);
				
		// HOME LEAVE WITH BED RETAINED
		int patientsOnHomeLeaveWithBeds = domain.countPatientsOnHomeLeaveWithBedRetained(ward, bay);
		DynamicGridCell cellValueHomeLeaveWithBed = getCell(ROW_HOME_LEAVE_WITH_BED, COL_VALUE);
		if (cellValueHomeLeaveWithBed != null)
			cellValueHomeLeaveWithBed.setValue(patientsOnHomeLeaveWithBeds);
		
		// SPECIALTY OUTLIER
		int patientsOutlierSpecialty = domain.countPatientsOutlinerSpecialty(ward, bay);
		DynamicGridCell cellSpecialtyOutlier = getCell(ROW_SPECIALTY_OUTLIERS, COL_VALUE);
		if (cellSpecialtyOutlier != null)
			cellSpecialtyOutlier.setValue(patientsOutlierSpecialty);
		
		
		// DISCHARGE WHITIN 24 HOURS
		int patientsToBeDischargedWithin24Hours = domain.countPatientsToBeDischargedWithin24Hours(ward, bay);
		DynamicGridCell cellValueToBeDischargedWithin24Hours = getCell(ROW_DISCHARGE_WITHIN_24_HOURS, COL_VALUE);
		if (cellValueToBeDischargedWithin24Hours != null)
			cellValueToBeDischargedWithin24Hours.setValue(patientsToBeDischargedWithin24Hours);
		
		// DISCHARGE CONFIRMED 24 HOURS
		int patientsDischargedConfirmedIn24Hours = domain.countPatientsWithDischargedConfirmedIn24hours(ward, bay);
		DynamicGridCell cellValueDischargedConfirmedIn24Hours = getCell(ROW_DISCHARGE_CONFIRMED_24_HOURS, COL_VALUE);
		if (cellValueDischargedConfirmedIn24Hours != null)
			cellValueDischargedConfirmedIn24Hours.setValue(patientsDischargedConfirmedIn24Hours);
		
		// READY TO LEAVE
		int patientsReadyToLeave = domain.countPatientsReadyToLeave(ward, bay);
		DynamicGridCell cellValueReadyToLeave = getCell(ROW_READY_TO_LEAVE, COL_VALUE);
		if (cellValueReadyToLeave != null)
			cellValueReadyToLeave.setValue(patientsReadyToLeave);
		
		
		// STILL TO ARRIVE
		int patientsStillToArrive = domain.countPatientsStillToArrive(ward, bay);
		DynamicGridCell cellValueStillToArrive = getCell(ROW_STILL_TO_ARRIVE, COL_VALUE);
		if (cellValueStillToArrive != null)
			cellValueStillToArrive.setValue(patientsStillToArrive);
		
		// ARRIVED
		int patientsArrived = domain.countPatientsArrived(ward, bay);
		DynamicGridCell cellValueArrived = getCell(ROW_ARRIVED, COL_VALUE);
		if (cellValueArrived != null)
			cellValueArrived.setValue(patientsArrived);
		
		// SEEN
		int patientsSeen = domain.countPatientsSeen(ward, bay);
		DynamicGridCell cellValueSeen = getCell(ROW_SEEN, COL_VALUE);
		if (cellValueSeen != null)
			cellValueSeen.setValue(patientsSeen);
		
		// TRANSFER OUT
		int patientsForTransferOut = domain.countPatientsForTransferOut(ward, bay);
		DynamicGridCell cellValueTransferOut = getCell(ROW_TRANSFER_OUT, COL_VALUE);
		if (cellValueTransferOut != null)
			cellValueTransferOut.setValue(patientsForTransferOut);
		
		// TRANSFER IN
		int patientsForTransferIn = domain.countPatientsForTransferIn(ward, bay);
		DynamicGridCell cellValueTransferIn = getCell(ROW_TRANSFER_IN, COL_VALUE);
		if (cellValueTransferIn != null)
			cellValueTransferIn.setValue(patientsForTransferIn);
		
		// ED_ADMISSIONS
		int patientsForEDAdmission = domain.countPatientsForEDAdmissions(ward, bay);
		DynamicGridCell cellValueEDAdmissions = getCell(ROW_ED_ADMISSIONS, COL_VALUE);
		if (cellValueEDAdmissions != null)
			cellValueEDAdmissions.setValue(patientsForEDAdmission);
		
		// EMERGENCY ADMISSIONS
		int patientsForEmergencyAdmission = domain.countPatientsForEmergencyAdmissions(ward, bay);
		DynamicGridCell cellValueEmergencyAdmission = getCell(ROW_EMERGENCY_ADMISSIONS, COL_VALUE);
		if (cellValueEmergencyAdmission != null)
			cellValueEmergencyAdmission.setValue(patientsForEmergencyAdmission);
		
		// TCI ADMISSIONS
		int patientsForTCIAdmissions = domain.countPatientsForTCIAdmissions(ward, bay);
		DynamicGridCell cellValueTCIAdmissions = getCell(ROW_ELECTIVE_TCI_ADMISSIONS, COL_VALUE);
		if (cellValueTCIAdmissions != null)
			cellValueTCIAdmissions.setValue(patientsForTCIAdmissions);
		
		// PENDING EMERGENCY THEATRES
		int pendingEmergencyTheatres = domain.countPatientsForPET(ward);
		DynamicGridCell cellValuePendingEmergencyTheatres = getCell(ROW_PENDING_EMERGENCY_THEATRE, COL_VALUE);
		if (cellValuePendingEmergencyTheatres != null)
			cellValuePendingEmergencyTheatres.setValue(pendingEmergencyTheatres);
		
	}

	public void refresh(LocationRefVo ward, LocationRefVo bay)
	{
		setValue(ward, bay);
	}
	
	public void setWardClosedBlocked(Boolean closedBlocked)
	{
		form.getLocalContext().setClosedBlockedWard(closedBlocked);
	}
	
	public Integer getAwaitingBedCount()
	{
		return form.getLocalContext().getAwaitingBedCount();		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	//	Form event handlers
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}


	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		refresh(form.getGlobalContext().Core.getWardViewPatientListWard(), form.getGlobalContext().Core.getWardViewPatientListBay());
		
		form.fireCustomControlValueChanged();
	}

	
	@Override
	protected void onDyngrdPatientsCellButtonClicked(DynamicGridCell cell)
	{
		// The Ward and Bay are already set in the GC
		Object identifier = cell.getRow().getIdentifier();
		engine.setPatientInfo(null); //WDEV-22472
		
		if (identifier != null)
		{
			if (identifier.equals(ROW_STILL_TO_ARRIVE) || identifier.equals(ROW_ARRIVED) || identifier.equals(ROW_SEEN))
			{
				engine.open(form.getForms().Core.WardAttenderDialog, new Object[]{identifier}, getCaption(form.getForms().Core.WardAttenderDialog,identifier));
				return;
			}
			
			if (identifier.equals(ROW_SPECIALTY_OUTLIERS))
			{
				engine.open(form.getForms().Core.SpecialtyOutlierInpatientList);
				return;
			}
			
			if (identifier.equals(ROW_PENDING_EMERGENCY_THEATRE))
			{
				engine.open(form.getForms().RefMan.PendingEmergencyTheatreForWard, new Object[] {form.getGlobalContext().Core.getWardViewPatientListWard()}, getCaption(form.getForms().RefMan.PendingEmergencyTheatreForWard, identifier));
				return;
			}
				
		}
		
		engine.open(form.getForms().Core.WardViewPatientList, new Object[] {identifier}, getCaption(form.getForms().Core.WardViewPatientList, identifier));
	}


	//-------------------------------------------------------------------------------------------------------------------------------------
	//
	//-------------------------------------------------------------------------------------------------------------------------------------
	

	private String getCaption(FormName formName, Object identifier)
	{
		if (identifier == null)
			return DEFAULT_VIEW_CAPTION;
		
		if (form.getForms().Core.WardAttenderDialog.equals(formName))
		{
			if (identifier.equals(ROW_STILL_TO_ARRIVE))
				return WARD_ATTENDERS_TO_ARRIVE_CAPTION;
			else if (identifier.equals(ROW_ARRIVED))
				return WARD_ATTENDERS_ARRIVED_CAPTION;
			else if (identifier.equals(ROW_SEEN))
				return WARD_ATTENDERS_SEEN_CAPTION;
		}
		else if (form.getForms().RefMan.PendingEmergencyTheatreForWard.equals(formName))
		{
			if (identifier.equals(ROW_PENDING_EMERGENCY_THEATRE))
				return PENDING_EMERGENCY_THEATRE_CAPTION;					
		}
		else if (form.getForms().Core.WardViewPatientList.equals(formName))
		{			
			if (identifier.equals(ROW_OCCUPYING_A_BED))
				return OCCUPYING_BED_CAPTION;
			else if (identifier.equals(ROW_AWAITING_BED))
				return AWAITING_BED_CAPTION;
			else if (identifier.equals(ROW_HOME_LEAVE))
				return HOMELEAVE_CAPTION;
			if (identifier.equals(ROW_HOME_LEAVE_WITH_BED))
				return HOMELEAVE_BED_CAPTION;
			else if (identifier.equals(ROW_ED_ADMISSIONS))
				return PATIENTS_FROM_ED_CAPTION;
			else if (identifier.equals(ROW_EMERGENCY_ADMISSIONS))
				return PENDING_EMERGENCY_CAPTION;
			if (identifier.equals(ROW_ELECTIVE_TCI_ADMISSIONS))
				return ELECTIVE_TCI_CAPTION;
			else if (identifier.equals(ROW_TRANSFER_OUT))
				return TRANSFER_OUT_CAPTION;
			else if (identifier.equals(ROW_TRANSFER_IN))
				return TRANSFER_IN_CAPTION;
			else if (identifier.equals(ROW_DISCHARGE_WITHIN_24_HOURS))
				return DISCHARGE_WITHIN_24HRS_CAPTION;
			else if (identifier.equals(ROW_DISCHARGE_CONFIRMED_24_HOURS))
				return DISCHARGE_CONFIRMED_24HRS_CAPTION;
			else if (identifier.equals(ROW_READY_TO_LEAVE))
				return DISCHARGE_READY_TO_LEAVE_CAPTION;
		}
		
		return DEFAULT_VIEW_CAPTION;
	}
	
	private void populateDynamicGrid()
	{
		form.dyngrdPatients().getRows().clear();
		
		// ADMITTED TO WARD (Header row)
		DynamicGridRow rowHeaderAdmittedToWard = form.dyngrdPatients().getRows().newRow();
		rowHeaderAdmittedToWard.setSelectable(false);
		rowHeaderAdmittedToWard.setBackColor(Color.LightBlue);
		DynamicGridCell cellLabelAdmittedToWard = rowHeaderAdmittedToWard.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
		cellLabelAdmittedToWard.setValue("<b>ADMITTED TO WARD</b>");
		cellLabelAdmittedToWard.setWidth(COL_LABEL_WIDTH + COL_VALUE_WIDTH);
		
			// OCCUPYING A BED
    		DynamicGridRow rowOccupyingABed = form.dyngrdPatients().getRows().newRow();
    		rowOccupyingABed.setSelectable(false);
    		rowOccupyingABed.setIdentifier(ROW_OCCUPYING_A_BED);
    		DynamicGridCell cellLabelOccupyingABed = rowOccupyingABed.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
    		cellLabelOccupyingABed.setValue("Occupying a bed/chair");
    		cellLabelOccupyingABed.setWidth(COL_LABEL_WIDTH);
    		DynamicGridCell cellValueOccupyingABed = rowOccupyingABed.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
    		cellValueOccupyingABed.setValue(0);
    		cellValueOccupyingABed.setWidth(COL_VALUE_WIDTH);
    		DynamicGridCell cellButtonOccupyingABed = rowOccupyingABed.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
    		cellButtonOccupyingABed.setWidth(COL_BUTTON_WIDTH);
		
    		// AWAITING BED ROW
    		DynamicGridRow rowAwaitingBeds = form.dyngrdPatients().getRows().newRow();
    		rowAwaitingBeds.setSelectable(false);
    		rowAwaitingBeds.setIdentifier(ROW_AWAITING_BED);
    		DynamicGridCell cellLabelAwaitingBed = rowAwaitingBeds.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
    		cellLabelAwaitingBed.setValue("Awaiting bed/chair");
    		cellLabelAwaitingBed.setWidth(COL_LABEL_WIDTH);
    		DynamicGridCell cellValueAwaitingBed = rowAwaitingBeds.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
    		cellValueAwaitingBed.setValue(0);
    		cellValueAwaitingBed.setWidth(COL_VALUE_WIDTH);
    		DynamicGridCell cellButtonAwaitingBed = rowAwaitingBeds.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
    		cellButtonAwaitingBed.setWidth(COL_BUTTON_WIDTH);

    		// HOME LEAVE ROW
    		DynamicGridRow rowHomeLeave = form.dyngrdPatients().getRows().newRow();
    		rowHomeLeave.setSelectable(false);
    		rowHomeLeave.setIdentifier(ROW_HOME_LEAVE);
    		DynamicGridCell cellLabelHomeLeave = rowHomeLeave.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
    		cellLabelHomeLeave.setValue("Home Leave");
    		cellLabelHomeLeave.setWidth(COL_LABEL_WIDTH);
    		DynamicGridCell cellValueHomeLeave = rowHomeLeave.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
    		cellValueHomeLeave.setValue(0);
    		cellValueHomeLeave.setWidth(COL_VALUE_WIDTH);
    		DynamicGridCell cellButtonHomeLeave = rowHomeLeave.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
    		cellButtonHomeLeave.setWidth(COL_BUTTON_WIDTH);
    		
    		// HOME LEAVE ROW WITH BED RETAINED
    		DynamicGridRow rowHomeLeaveWithBed = form.dyngrdPatients().getRows().newRow();
    		rowHomeLeaveWithBed.setSelectable(false);
    		rowHomeLeaveWithBed.setIdentifier(ROW_HOME_LEAVE_WITH_BED);
    		DynamicGridCell cellLabelHomeLeaveBed = rowHomeLeaveWithBed.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
    		cellLabelHomeLeaveBed.setValue("Home Leave with Bed Retained");
    		cellLabelHomeLeaveBed.setWidth(COL_LABEL_WIDTH);
    		DynamicGridCell cellValueHomeLeaveBed = rowHomeLeaveWithBed.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
    		cellValueHomeLeaveBed.setValue(0);
    		cellValueHomeLeaveBed.setWidth(COL_VALUE_WIDTH);
    		DynamicGridCell cellButtonHomeLeaveWithBed = rowHomeLeaveWithBed.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
    		cellButtonHomeLeaveWithBed.setWidth(COL_BUTTON_WIDTH);
    		
    		// SPECIALTY OUTLIERS ROW
    		DynamicGridRow rowSpecialtyOutlier = form.dyngrdPatients().getRows().newRow();
    		rowSpecialtyOutlier.setSelectable(false);
    		rowSpecialtyOutlier.setIdentifier(ROW_SPECIALTY_OUTLIERS);
    		DynamicGridCell cellLabelSpecialtyOutliner = rowSpecialtyOutlier.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
    		cellLabelSpecialtyOutliner.setValue("Specialty Outliers in Ward");
    		cellLabelSpecialtyOutliner.setWidth(COL_LABEL_WIDTH);
    		DynamicGridCell cellValueSpecialtyOutliner = rowSpecialtyOutlier.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
    		cellValueSpecialtyOutliner.setValue(0);
    		cellValueSpecialtyOutliner.setWidth(COL_VALUE_WIDTH);
    		DynamicGridCell cellButtonSpecialtyOutliner = rowSpecialtyOutlier.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
    		cellButtonSpecialtyOutliner.setWidth(COL_BUTTON_WIDTH);
    		
		
		// INCOMING PATIENTS (Header row)
		DynamicGridRow rowIncomingPatients = form.dyngrdPatients().getRows().newRow();
		rowIncomingPatients.setSelectable(false);
		rowIncomingPatients.setBackColor(Color.LightBlue);
		DynamicGridCell cellLabelIncomingPatients = rowIncomingPatients.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
		cellLabelIncomingPatients.setValue("<b>INCOMING</b>");
		cellLabelIncomingPatients.setWidth(COL_LABEL_WIDTH + COL_VALUE_WIDTH);
			
			// ED ADMISSIONS ROW
			DynamicGridRow rowEDAdmissions = form.dyngrdPatients().getRows().newRow();
			rowEDAdmissions.setSelectable(false);
			rowEDAdmissions.setIdentifier(ROW_ED_ADMISSIONS);
			DynamicGridCell cellLabelEDAdmissions = rowEDAdmissions.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelEDAdmissions.setValue("ED");
			cellLabelEDAdmissions.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueEDAdmissions = rowEDAdmissions.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueEDAdmissions.setValue(0);
			cellValueEDAdmissions.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonEDAdmission = rowEDAdmissions.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonEDAdmission.setWidth(COL_BUTTON_WIDTH);
			
			// EMERGENCY ADMISSIONS ROW
			DynamicGridRow rowEmergencyAdmissions = form.dyngrdPatients().getRows().newRow();
			rowEmergencyAdmissions.setSelectable(false);
			rowEmergencyAdmissions.setIdentifier(ROW_EMERGENCY_ADMISSIONS);
			DynamicGridCell cellLabelEmergencyAdmissions = rowEmergencyAdmissions.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelEmergencyAdmissions.setValue("Emergency");
			cellLabelEmergencyAdmissions.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueEmergencyAdmissions = rowEmergencyAdmissions.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueEmergencyAdmissions.setValue(0);
			cellValueEmergencyAdmissions.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonEmergencyAdmissions = rowEmergencyAdmissions.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonEmergencyAdmissions.setWidth(COL_BUTTON_WIDTH);
			
			
			// TCI ADMISSIONS ROW
			DynamicGridRow rowTCIAdmission = form.dyngrdPatients().getRows().newRow();
			rowTCIAdmission.setSelectable(false);
			rowTCIAdmission.setIdentifier(ROW_ELECTIVE_TCI_ADMISSIONS);
			DynamicGridCell cellLabelTCIAdmission = rowTCIAdmission.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelTCIAdmission.setValue("Elective TCI");
			cellLabelTCIAdmission.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueTCIAdmissions = rowTCIAdmission.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueTCIAdmissions.setValue(0);
			cellValueTCIAdmissions.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonTCIAdmissions = rowTCIAdmission.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonTCIAdmissions.setWidth(COL_BUTTON_WIDTH);
			
			// PENDING EMERGENCY THEATRES ROW
			DynamicGridRow rowPET = form.dyngrdPatients().getRows().newRow();
			rowPET.setSelectable(false);
			rowPET.setIdentifier(ROW_PENDING_EMERGENCY_THEATRE);
			DynamicGridCell cellLabelPET = rowPET.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelPET.setValue("Pending Emergency Theatre");
			cellLabelPET.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValuePET = rowPET.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValuePET.setValue(0);
			cellValuePET.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonPET = rowPET.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonPET.setWidth(COL_BUTTON_WIDTH);
    		

		// TRANSFERS (Header row)
		DynamicGridRow rowTransfer = form.dyngrdPatients().getRows().newRow();
		rowTransfer.setSelectable(false);
		rowTransfer.setBackColor(Color.LightBlue);
		DynamicGridCell cellLabelTransfer = rowTransfer.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
		cellLabelTransfer.setValue("<b>INTERNAL TRANSFERS</b>");
		cellLabelTransfer.setWidth(COL_LABEL_WIDTH + COL_VALUE_WIDTH);
			
			// TRANSFER OUT ROW
			DynamicGridRow rowForTransferOut = form.dyngrdPatients().getRows().newRow();
			rowForTransferOut.setSelectable(false);
			rowForTransferOut.setIdentifier(ROW_TRANSFER_OUT);
			DynamicGridCell cellLabelTransferOut = rowForTransferOut.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelTransferOut.setValue("Transfer Out");
			cellLabelTransferOut.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueTransferOut = rowForTransferOut.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueTransferOut.setValue(0);
			cellValueTransferOut.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonTransferOut = rowForTransferOut.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonTransferOut.setWidth(COL_BUTTON_WIDTH);
			
			// TRANSFER IN ROW
			DynamicGridRow rowForTransferIn = form.dyngrdPatients().getRows().newRow();
			rowForTransferIn.setSelectable(false);
			rowForTransferIn.setIdentifier(ROW_TRANSFER_IN);
			DynamicGridCell cellLabelTransferIn = rowForTransferIn.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelTransferIn.setValue("Transfer In");
			cellLabelTransferIn.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueTransferIn = rowForTransferIn.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueTransferIn.setValue(0);
			cellValueTransferIn.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonTransferIn = rowForTransferIn.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonTransferIn.setWidth(COL_BUTTON_WIDTH);

				
		// FOR DISCHARGE ROW (Header row)
		DynamicGridRow rowHeaderForDischarge = form.dyngrdPatients().getRows().newRow();
		rowHeaderForDischarge.setSelectable(false);
		rowHeaderForDischarge.setBackColor(Color.LightBlue);
		DynamicGridCell cellLabelForDischarge = rowHeaderForDischarge.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
		cellLabelForDischarge.setValue("<b>DISCHARGE</b>");
		cellLabelForDischarge.setWidth(COL_LABEL_WIDTH + COL_VALUE_WIDTH); 
		
			// WITHIN 24 HOURS ROW
			DynamicGridRow rowDischargeWithin24Hours = form.dyngrdPatients().getRows().newRow();
			rowDischargeWithin24Hours.setSelectable(false);
			rowDischargeWithin24Hours.setIdentifier(ROW_DISCHARGE_WITHIN_24_HOURS);
			DynamicGridCell cellLabelDischargeWithin24Hours = rowDischargeWithin24Hours.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelDischargeWithin24Hours.setValue("Potential within 24 hours");
			cellLabelDischargeWithin24Hours.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueDischargeWithin24Hours = rowDischargeWithin24Hours.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueDischargeWithin24Hours.setValue(0);
			cellValueDischargeWithin24Hours.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonDischargeWithin24Hours = rowDischargeWithin24Hours.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonDischargeWithin24Hours.setWidth(COL_BUTTON_WIDTH);
			
			// CONFIRMED WITHIN 24 HOURS ROW
			DynamicGridRow rowDischargeConfirmedIn24Hours = form.dyngrdPatients().getRows().newRow();
			rowDischargeConfirmedIn24Hours.setSelectable(false);
			rowDischargeConfirmedIn24Hours.setIdentifier(ROW_DISCHARGE_CONFIRMED_24_HOURS);
			DynamicGridCell cellLabelDischargeConfirmedIn24Hours = rowDischargeConfirmedIn24Hours.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelDischargeConfirmedIn24Hours.setValue("Confirmed within 24 hours");
			cellLabelDischargeConfirmedIn24Hours.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueDischargeConfirmedIn24Hours = rowDischargeConfirmedIn24Hours.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueDischargeConfirmedIn24Hours.setValue(0);
			cellValueDischargeConfirmedIn24Hours.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonDischargeConfirmedIn24Hours = rowDischargeConfirmedIn24Hours.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonDischargeConfirmedIn24Hours.setWidth(COL_BUTTON_WIDTH);
			
			// READY TO LEAVE ROW
			DynamicGridRow rowReadyToLeave = form.dyngrdPatients().getRows().newRow();
			rowReadyToLeave.setSelectable(false);
			rowReadyToLeave.setIdentifier(ROW_READY_TO_LEAVE);
			DynamicGridCell cellLabelReadyToLeave = rowReadyToLeave.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelReadyToLeave.setValue("Ready to leave");
			cellLabelReadyToLeave.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueReadyToLeave = rowReadyToLeave.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueReadyToLeave.setValue(0);
			cellValueReadyToLeave.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonReadyToLeave = rowReadyToLeave.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonReadyToLeave.setWidth(COL_BUTTON_WIDTH);
		
			
		// WARD ATTENDERS ROW (Header row)
		DynamicGridRow rowWardAttenders = form.dyngrdPatients().getRows().newRow();
		rowWardAttenders.setSelectable(false);
		rowWardAttenders.setBackColor(Color.LightBlue);
		DynamicGridCell cellLabelWardAttenders = rowWardAttenders.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
		cellLabelWardAttenders.setValue("<b>WARD ATTENDERS</b>");
		cellLabelWardAttenders.setWidth(COL_LABEL_WIDTH + COL_VALUE_WIDTH);
		
			// DUE IN - STILL TO ARRIVE ROW
			DynamicGridRow rowStillToArrive = form.dyngrdPatients().getRows().newRow();
			rowStillToArrive.setSelectable(false);
			rowStillToArrive.setIdentifier(ROW_STILL_TO_ARRIVE);
			DynamicGridCell cellLabelStillToArrive = rowStillToArrive.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelStillToArrive.setValue("Still to Arrive");
			cellLabelStillToArrive.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueStillToArrive = rowStillToArrive.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueStillToArrive.setValue(0);
			cellValueStillToArrive.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonStillToArrive = rowStillToArrive.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonStillToArrive.setWidth(COL_BUTTON_WIDTH);
			
			// ARRIVED, BUT NOT SEEN ROW
			DynamicGridRow rowArrivedButNotSeen = form.dyngrdPatients().getRows().newRow();
			rowArrivedButNotSeen.setSelectable(false);
			rowArrivedButNotSeen.setIdentifier(ROW_ARRIVED);
			DynamicGridCell cellLabelArrivedButNotSeen = rowArrivedButNotSeen.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelArrivedButNotSeen.setValue("Arrived");
			cellLabelArrivedButNotSeen.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueArrivedButNotSeen = rowArrivedButNotSeen.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueArrivedButNotSeen.setValue(0);
			cellValueArrivedButNotSeen.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonArrivedButNotSeen = rowArrivedButNotSeen.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonArrivedButNotSeen.setWidth(COL_BUTTON_WIDTH);
			
			// SEEN ROW
			DynamicGridRow rowSeen = form.dyngrdPatients().getRows().newRow();
			rowSeen.setSelectable(false);
			rowSeen.setIdentifier(ROW_SEEN);
			DynamicGridCell cellLabelSeen = rowSeen.getCells().newCell(getColumn(COL_LABEL), DynamicCellType.LABEL);
			cellLabelSeen.setValue("Seen");
			cellLabelSeen.setWidth(COL_LABEL_WIDTH);
			DynamicGridCell cellValueSeen = rowSeen.getCells().newCell(getColumn(COL_VALUE), DynamicCellType.INT);
			cellValueSeen.setValue(0);
			cellValueSeen.setWidth(COL_VALUE_WIDTH);
			DynamicGridCell cellButtonSeen = rowSeen.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.BUTTON);
			cellButtonSeen.setWidth(COL_BUTTON_WIDTH);
	}

	
	private DynamicGridColumn getColumn(Object columnIdentifier)
	{
		return form.dyngrdPatients().getColumns().getByIdentifier(columnIdentifier);
	}
	

	private DynamicGridRow getRowByIdentifier(Object identifier)
	{
		if (identifier == null)
			return null;
		
		for (int i = 0; i < form.dyngrdPatients().getRows().size(); i++)
		{
			if (identifier.equals(form.dyngrdPatients().getRows().get(i).getIdentifier()))
				return form.dyngrdPatients().getRows().get(i);
		}
		
		return null;
	}


	private DynamicGridCell getCell(Object rowIdentifier, Object columnIdentifier)
	{
		if (rowIdentifier == null || columnIdentifier == null)
			throw new CodingRuntimeException("Row Identifier and Column Identifier cannot be null.");
		
		DynamicGridRow rowOnTheWard = getRowByIdentifier(rowIdentifier);
		DynamicGridCell cellValueOnTheWard = rowOnTheWard.getCells().get(getColumn(columnIdentifier));
		return cellValueOnTheWard;
	}	
}
