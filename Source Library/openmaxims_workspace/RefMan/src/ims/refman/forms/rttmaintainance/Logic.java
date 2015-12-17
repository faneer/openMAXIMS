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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.rttmaintainance;

import ims.RefMan.vo.CATSReferralForRTTMaintainanceVo;
import ims.RefMan.vo.CATSReferralForRTTMaintainanceVoCollection;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.pathways.vo.PathwayRTTClockImpactUndoVo;
import ims.pathways.vo.PathwayRTTClockImpactUndoVoCollection;
import ims.pathways.vo.lookups.RTTClockState;

import java.util.ArrayList;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	
	private static final int COL_CLOCK_IMPACT_SOURCE_TYPE = 0;
	private static final int COL_CLOCK_IMPACT_INITIAL_STATUS = 1;
	private static final int COL_CLOCK_IMPACT_FINAL_STATUS = 2;
	private static final int COL_CLOCK_IMPACT_INITIAL_CLOCK_START = 3;
	private static final int COL_CLOCK_IMPACT_INITIAL_CLOCK_END = 4;
	private static final int COL_CLOCK_IMPACT_FINAL_CLOCK_START = 5;
	private static final int COL_CLOCK_IMPACT_FINAL_CLCOK_END = 6;
	private static final int COL_CLOCK_IMPACT_IMPACT_TYPE = 7;

	
	//--------------------------------------------------------------------------------------------------------------------
	//	Form event handlers
	//--------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open(null);
	}
	

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		open(form.cmbReferral().getValue());
	}

	
	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		if (validateSearch())
		{
			CATSReferralForRTTMaintainanceVoCollection referrals = search(form.getGlobalContext().Core.getPatientShort(), form.dteFrom().getValue(), form.dteTo().getValue(), true);
			populatePatientReferrals(referrals, null, true);
		}
		
		updateControlsState();
	}


	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearScreen();
		updateControlsState();
	}

	
	@Override
	protected void onCmbReferralValueChanged() throws PresentationLogicException
	{
		form.cmbReferral().setTooltip(getDisplayStringForReferral(form.cmbReferral().getValue()));
		
		updateReferralSelection(form.cmbReferral().getValue());
		
		updateControlsState();
	}


	@Override
	protected void onDyngrdRTTClockImpactRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException
	{
		updateControlsState();
	}

	@Override
	protected void onDyngrdRTTClockImpactRowSelectionCleared() throws PresentationLogicException
	{
		updateControlsState();
	}

	@Override
	protected void onBtnUndoClockImpactClick() throws PresentationLogicException
	{
		CATSReferralForRTTMaintainanceVo referral = form.cmbReferral().getValue();
		PathwayRTTClockImpactUndoVo clockImpact = (PathwayRTTClockImpactUndoVo) form.dyngrdRTTClockImpact().getSelectedRow().getValue();
		
		if (undoClockImpact(referral, clockImpact))
		{
			open(referral);
		}
	}


	@Override
	protected void onBtnManualClockStatusClick() throws PresentationLogicException
	{
		form.getGlobalContext().RefMan.setCatsReferralSetRTTClockStatus(form.cmbReferral().getValue());
		engine.open(form.getForms().RefMan.ManuallySetRTTClockStatus);
	}

	
	//--------------------------------------------------------------------------------------------------------------------
	//	Form presentation function
	//--------------------------------------------------------------------------------------------------------------------
	
	private void initialize()
	{
		// Initialize the Dynamic Grid
		form.dyngrdRTTClockImpact().clear();
		
		form.dyngrdRTTClockImpact().setHeaderHeight(45);
		
		DynamicGridColumn columnSource = form.dyngrdRTTClockImpact().getColumns().newColumn("Source", COL_CLOCK_IMPACT_SOURCE_TYPE);
		columnSource.setHeaderAlignment(Alignment.CENTER);
		columnSource.setWidth(120);
		columnSource.setCanGrow(true);
		
		DynamicGridColumn columnInitialStatus = form.dyngrdRTTClockImpact().getColumns().newColumn("Initial\nStatus", COL_CLOCK_IMPACT_INITIAL_STATUS);
		columnInitialStatus.setHeaderAlignment(Alignment.CENTER);
		columnInitialStatus.setWidth(150);
		columnInitialStatus.setCanGrow(true);
		
		DynamicGridColumn columnFinalStatus = form.dyngrdRTTClockImpact().getColumns().newColumn("Final\nStatus", COL_CLOCK_IMPACT_FINAL_STATUS);
		columnFinalStatus.setHeaderAlignment(Alignment.CENTER);
		columnFinalStatus.setWidth(150);
		columnFinalStatus.setCanGrow(true);
		
		DynamicGridColumn columnInitialClockStart = form.dyngrdRTTClockImpact().getColumns().newColumn("Initial Clock\nStart", COL_CLOCK_IMPACT_INITIAL_CLOCK_START);
		columnInitialClockStart.setHeaderAlignment(Alignment.CENTER);
		columnInitialClockStart.setAlignment(Alignment.CENTER);
		columnInitialClockStart.setWidth(70);
		columnInitialClockStart.setCanGrow(false);
		
		DynamicGridColumn columnInitialClockEnd = form.dyngrdRTTClockImpact().getColumns().newColumn("Initial Clock\nEnd", COL_CLOCK_IMPACT_INITIAL_CLOCK_END);
		columnInitialClockEnd.setHeaderAlignment(Alignment.CENTER);
		columnInitialClockEnd.setAlignment(Alignment.CENTER);
		columnInitialClockEnd.setWidth(70);
		columnInitialClockEnd.setCanGrow(false);
		
		DynamicGridColumn columnFinalClockStart = form.dyngrdRTTClockImpact().getColumns().newColumn("Final Clock\nStart", COL_CLOCK_IMPACT_FINAL_CLOCK_START);
		columnFinalClockStart.setHeaderAlignment(Alignment.CENTER);
		columnFinalClockStart.setAlignment(Alignment.CENTER);
		columnFinalClockStart.setWidth(70);
		columnFinalClockStart.setCanGrow(false);
		
		DynamicGridColumn columnFinalClockEnd = form.dyngrdRTTClockImpact().getColumns().newColumn("Final Clock\nEnd", COL_CLOCK_IMPACT_FINAL_CLCOK_END);
		columnFinalClockEnd.setHeaderAlignment(Alignment.CENTER);
		columnFinalClockEnd.setAlignment(Alignment.CENTER);
		columnFinalClockEnd.setWidth(70);
		columnFinalClockEnd.setCanGrow(false);

		DynamicGridColumn columnImpactType = form.dyngrdRTTClockImpact().getColumns().newColumn("Impact Type", COL_CLOCK_IMPACT_IMPACT_TYPE);
		columnImpactType.setHeaderAlignment(Alignment.CENTER);
		columnImpactType.setWidth(-1);
		columnImpactType.setCanGrow(true);		
	}
	

	private void clearScreen()
	{
		form.cmbReferral().clear();
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);

		clearReferralDetails();
	}


	private void clearReferralDetails()
	{
		form.cmbPathway().clear();
		form.txtRTTStatus().setValue("-");
		form.txtRTTStatus().setTooltip("-");
		
		form.dyngrdRTTClockImpact().getRows().clear();
	}

	
	private void open(CATSReferralForRTTMaintainanceVo referral)
	{
		CATSReferralForRTTMaintainanceVoCollection referrals = search(form.getGlobalContext().Core.getPatientShort(), form.dteFrom().getValue(), form.dteTo().getValue(), false);
		populatePatientReferrals(referrals, referral, false);
		
		form.setMode(FormMode.VIEW);
	}

	
	private boolean undoClockImpact(CATSReferralForRTTMaintainanceVo referral, PathwayRTTClockImpactUndoVo clockImpact)
	{
		try
		{
			domain.undoClockImpact(referral, clockImpact);
			
			return true;
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (StaleObjectException e)
		{
			open(referral);
			return false;
		}
	}


	private boolean validateSearch()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.dteFrom().getValue() != null && form.dteTo().getValue() != null
			&& form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
		{
			errors.add("Date From cannot be set after the Date To.");
		}
		
		if (errors.size() > 0)
		{
			engine.showErrors(errors.toArray(new String[errors.size()]));
			return false;
		}
		
		return true;
	}


	private void updateControlsState()
	{
		CATSReferralForRTTMaintainanceVo referral = form.cmbReferral().getValue();
		DynamicGridRow selectedRow = form.dyngrdRTTClockImpact().getSelectedRow();
		
		boolean lastRowSelected = selectedRow != null && isLastClockImpact(form.cmbReferral().getValue(), (PathwayRTTClockImpactUndoVo) selectedRow.getValue());
		form.btnUndoClockImpact().setEnabled(lastRowSelected);
		form.btnManualClockStatus().setVisible(referral != null && referral.getJourney() != null && Boolean.TRUE.equals(referral.getRTTClockImpact())); //WDEV-20169 
	}

	
	private CATSReferralForRTTMaintainanceVoCollection search(PatientRefVo patient, Date dateFrom, Date dateTo, boolean displayMessage)
	{
		CATSReferralForRTTMaintainanceVoCollection referrals = domain.listReferralsForPatient(patient, dateFrom, dateTo);
		
		if (referrals == null || referrals.size() == 0)
		{
			engine.showMessage("No results found.");
		}
		
		return referrals;
	}

	
	private void updateReferralSelection(CATSReferralForRTTMaintainanceVo referral)
	{
		clearReferralDetails();
		
		if (referral == null)
			return;
		
		
		// Set the current status for the referral label
		if (referral.getCurrentRTTStatus() != null)
		{
			form.txtRTTStatus().setValue(referral.getCurrentRTTStatus().getRTTStatus().getDescription());
			form.txtRTTStatus().setTooltip(referral.getCurrentRTTStatus().getRTTStatus().getDescription());
		}
		
		// Search for clock impacts & populate them to grid
		PathwayRTTClockImpactUndoVoCollection clockImpacts = domain.listClockImpacts(referral);
		
		populateClockImpacts(clockImpacts);
	}

	
	//--------------------------------------------------------------------------------------------------------------------
	//	Functions used to populate data to & from screen
	//--------------------------------------------------------------------------------------------------------------------

	private void populatePatientReferrals(CATSReferralForRTTMaintainanceVoCollection referrals, CATSReferralForRTTMaintainanceVo processedReferral, boolean showOpened)
	{
		form.cmbReferral().clear();
		
		clearReferralDetails();
		
		if (referrals == null)
			return;
		
		for (CATSReferralForRTTMaintainanceVo referral : referrals)
		{
			form.cmbReferral().newRow(referral, getDisplayStringForReferral(referral));
		}
		
		CATSReferralForRTTMaintainanceVo selectedReferral = null;
		
		if (processedReferral != null)
		{
			form.cmbReferral().setValue(processedReferral);
			selectedReferral = form.cmbReferral().getValue();
		}
		else if (referrals.size() == 1)
		{
			form.cmbReferral().setValue(referrals.get(0));
			selectedReferral = form.cmbReferral().getValue();
		}
		
		if (selectedReferral != null)
		{
			form.cmbReferral().setTooltip(getDisplayStringForReferral(selectedReferral));
			updateReferralSelection(selectedReferral);
		}
		else if (showOpened)
		{
			form.cmbReferral().showOpened();
		}
	}

	
	private void populateClockImpacts(PathwayRTTClockImpactUndoVoCollection clockImpacts)
	{
		form.dyngrdRTTClockImpact().getRows().clear();
		
		if (clockImpacts == null)
			return;
		
		for (PathwayRTTClockImpactUndoVo clockImpact : clockImpacts)
		{
			DynamicGridRow row = form.dyngrdRTTClockImpact().getRows().newRow();

			// Populate row
			DynamicGridCell impactSource = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_SOURCE_TYPE), DynamicCellType.WRAPTEXT);
			impactSource.setValue(clockImpact.getSource().getText());
			
			DynamicGridCell initialStatus = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_INITIAL_STATUS), DynamicCellType.WRAPTEXT);
			initialStatus.setValue(clockImpact.getInitialRTTStatus() != null ? clockImpact.getInitialRTTStatus().getRTTStatus().getDescription() : "");
			
			DynamicGridCell finalStatus = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_FINAL_STATUS), DynamicCellType.WRAPTEXT);
			finalStatus.setValue(clockImpact.getFinalRTTStatus() != null ? clockImpact.getFinalRTTStatus().getRTTStatus().getDescription() : "");
			
			
			DynamicGridCell cellInitialClockStartDate = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_INITIAL_CLOCK_START), DynamicCellType.STRING);
			cellInitialClockStartDate.setValue(clockImpact.getInitialClock() != null && clockImpact.getInitialClock().getStartDate() != null ? clockImpact.getInitialClock().getStartDate().toString() : "-");
			
			DynamicGridCell cellInitialClockEndDate = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_INITIAL_CLOCK_END), DynamicCellType.STRING);
			Date initialClockEndDate = getStopDateFromInitialClockImpact(clockImpact);
			cellInitialClockEndDate.setValue(initialClockEndDate != null ? initialClockEndDate.toString() : "-");	
			
			DynamicGridCell cellFinalClockStartDate = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_FINAL_CLOCK_START), DynamicCellType.STRING);
			cellFinalClockStartDate.setValue(clockImpact.getFinalClock() != null && clockImpact.getFinalClock().getStartDate() != null ?  clockImpact.getFinalClock().getStartDate().toString() : "-");
			
			DynamicGridCell cellFinalClockEndDate = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_FINAL_CLCOK_END), DynamicCellType.STRING);
			Date finalClockEndDate = getStopDateFromFinalClockImpact(clockImpact);
			cellFinalClockEndDate.setValue(finalClockEndDate != null ? finalClockEndDate.toString() : "-");

			
			DynamicGridCell type = row.getCells().newCell(form.dyngrdRTTClockImpact().getColumns().getByIdentifier(COL_CLOCK_IMPACT_IMPACT_TYPE), DynamicCellType.WRAPTEXT);
			if (Boolean.TRUE.equals(clockImpact.getClockStarted()) && Boolean.TRUE.equals(clockImpact.getClockStopped()))
				type.setValue("Clock Started & Stopped");
			else if (Boolean.TRUE.equals(clockImpact.getClockStopped()))
				type.setValue("Clock Stopped");
			else if (Boolean.TRUE.equals(clockImpact.getClockStarted()))
				type.setValue("Clock Started");
			
			row.setValue(clockImpact);
		}
	}


	private Date getStopDateFromFinalClockImpact(PathwayRTTClockImpactUndoVo clockImpact)
	{
		if (clockImpact == null)
			return null;
		
		// Final Clock - End Date
		// We must determine if the clock was stopped in this step or was stopped at a later time
		if (clockImpact.getFinalClock() == null || RTTClockState.NOT_PRESENT.equals(clockImpact.getFinalClockState()))
			return null;
		
		if (RTTClockState.STARTED.equals(clockImpact.getFinalClockState()))
			return null;
		
		if (RTTClockState.STOPPED.equals(clockImpact.getFinalClockState()))
			return clockImpact.getFinalClock().getStopDate();
		
		return clockImpact.getFinalClock().getStopDate();
	}


	private Date getStopDateFromInitialClockImpact(PathwayRTTClockImpactUndoVo clockImpact)
	{
		if (clockImpact == null)
			return null;
		

		// Initial Clock - End Date
		// In this case - the possibility exists that final clock and initial clock is the same clock
		// and the clock was stopped as a result of the impact
		if (clockImpact.getInitialClock() == null || RTTClockState.NOT_PRESENT.equals(clockImpact.getInitialClockState()))
			return null;
		
		if (RTTClockState.STARTED.equals(clockImpact.getInitialClockState()))
			return null;
		
		if (RTTClockState.STOPPED.equals(clockImpact.getInitialClockState()))
			return clockImpact.getInitialClock().getStopDate();
		
		return clockImpact.getInitialClock().getStopDate();
	}


	private String getDisplayStringForReferral(CATSReferralForRTTMaintainanceVo referral)
	{
		if (referral == null)
			return "";
		
		StringBuilder displayString = new StringBuilder();
		String separator = "";
		
		displayString.append(separator);
		displayString.append(referral.getReferralDetails() != null && referral.getReferralDetails().getDateOfReferral() != null ? referral.getReferralDetails().getDateOfReferral() : "<Unknown Referral Date>");
		separator = " - ";

		if (referral.getUrgency() != null)
		{
			displayString.append(separator);
			displayString.append(referral.getUrgency().getText());
			
			separator = " - ";
			
		}

		if (referral.getReferralDetails() != null && referral.getReferralDetails().getService() != null)
		{
			displayString.append(separator);
			displayString.append(referral.getReferralDetails().getService().getServiceName());
			
			separator = " - ";
		}

		if (referral.getReferralDetails() != null && referral.getReferralDetails().getReferringConsultant() != null)
		{
			displayString.append(separator);
			displayString.append(referral.getReferralDetails().getReferringConsultant().toString());
			
			separator = " - ";
		}
		
		return displayString.toString();
	}
	

	private boolean isLastClockImpact(CATSReferralForRTTMaintainanceVo referral, PathwayRTTClockImpactUndoVo clockImpact)
	{
		if (clockImpact == null || referral == null || referral.getJourney() == null)
			return false;
		
		if (clockImpact.getFinalClock() == null && referral.getJourney().getCurrentClock() != null)
			return false;
		
		if (clockImpact.getFinalClock() != null && referral.getJourney().getCurrentClock() == null)
			return false;
		
		if (clockImpact.getFinalClock() != null && referral.getJourney().getCurrentClock() != null
				&& !clockImpact.getFinalClock().equals(referral.getJourney().getCurrentClock()))
			return false;
		
		
		//WDEV-20093
		if (clockImpact.getFinalRTTStatus() == null && referral.getJourney().getCurrentClock() != null && referral.getJourney().getCurrentClock().getCurrentRTTStatus() != null)
			return false;
		
		if (clockImpact.getFinalRTTStatus() != null)
		{
			if (referral.getJourney().getCurrentClock() != null && !clockImpact.getFinalRTTStatus().equals(referral.getJourney().getCurrentClock().getCurrentRTTStatus()))
				return false;
			
			if (referral.getJourney().getCurrentClock() == null && !clockImpact.getFinalRTTStatus().equals(referral.getCurrentRTTStatus()))
				return false;
		}

		return true;
	}
}