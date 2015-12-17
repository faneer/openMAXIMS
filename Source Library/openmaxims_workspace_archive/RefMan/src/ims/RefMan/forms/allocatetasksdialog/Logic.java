// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3551.27961)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.allocatetasksdialog;

import java.util.Comparator;

import ims.RefMan.vo.CATSReferralFilterVo;
import ims.RefMan.vo.CatsReferralListManualAssemblyVo;
import ims.RefMan.vo.CatsReferralListManualAssemblyVoCollection;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.WorkAllocationVo;
import ims.RefMan.vo.WorkAllocationVoCollection;
import ims.RefMan.vo.lookups.AdditionalInvestigationAppointmentsStatus;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.vo.lookups.Status_Reason;

public class Logic extends BaseLogic
{
	/**
	 *	WDEV-13184
	 *	@author George Josan
	 *	Comparator for manual sort after 'Days left until appointment' column
	 */
	private static class DaysLeftComparator implements Comparator<CatsReferralListManualAssemblyVo>
	{
		private int direction;

		public DaysLeftComparator(SortOrder sortOrder)
		{
			if (SortOrder.ASCENDING.equals(sortOrder))
				direction = 1;
			else
				direction = -1;
		}

		public int compare(CatsReferralListManualAssemblyVo o1, CatsReferralListManualAssemblyVo o2)
		{
			if (o1.getDaysLeftIsNotNull() && o2.getDaysLeftIsNotNull())
				return o1.getDaysLeft().compareTo(o2.getDaysLeft()) * direction;
			
			if (o1.getDaysLeftIsNotNull() && !o2.getDaysLeftIsNotNull())
				return direction;
			
			if (!o1.getDaysLeftIsNotNull() && o2.getDaysLeftIsNotNull())
				return -1 * direction;
			
			return 0;
		}

	}

	public static final Integer		COLHIDDEN			= new Integer(-15);
	public static final Integer		COLTREE				= new Integer(-14);
	public static final Integer		COLICP				= new Integer(-12);
	public static final Integer		COLCAB				= new Integer(0);
	public static final Integer		COLLOC				= new Integer(1);
	public static final Integer		COLSERVICE			= new Integer(-1);
	public static final Integer		COLREVIEW			= new Integer(-2);
	public static final Integer		COL20KPI			= new Integer(-3);
	public static final Integer		COLIMAGE			= new Integer(-4);
	public static final Integer		COLNHSNO			= new Integer(-5);
	public static final Integer		COLNAME				= new Integer(-6);
	public static final Integer		COLALLOCATED		= new Integer(-7);
	public static final Integer		COLSTATUS			= new Integer(-8);
	public static final Integer		COLINV				= new Integer(-9);
	public static final Integer		COLINVNEEDAPPT		= new Integer(-10);
	public static final Integer		COLBOOKING			= new Integer(-11);
	public static final Integer		COLDAYSLEFT			= new Integer(-13);

	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
		initializeDynamicGrid();
		String strIDs = search();
		loadAllocatedTasks(strIDs);

		form.getLocalContext().setSelectedAll(false);
		form.ccAllocatedTo().setEnabled(false);
		
		form.btnSave().setVisible(false);
		
		form.ccAllocatedTo().isRequired(true);//WDEV-13759
		
		//WDEV-11024
		updateControlsState();
	}
	
	
	@Override
	/**
	 *	WDEV-13184
	 *	Event handler for DynamicGridColumnHeaderClicked - used for manual sort on column
	 *	'Days until appointment'
	 */
	protected void onDyngrdReferralsColumnHeaderClicked(DynamicGridColumn column)
	{
		// Sort grid records after value from column clicked
		sortReferralRecords(column.getIdentifier());
		// Update controls state
		updateControlsState();
	}

	/**
	 *	WDEV-13184
	 *	Function used to sort Referral records after values of column header clicked
	 */
	private void sortReferralRecords(Object identifier)
	{
		// Get all records from screen into a collection
		CatsReferralListManualAssemblyVoCollection records = populateReferralsFromGrid();
		// Toggle sort order
		sortOrderToggle(identifier);
		
		// Determine column, sort records
		if (COLDAYSLEFT.equals(identifier))
		{
			records.sort(new DaysLeftComparator(form.getLocalContext().getSortOrderDayUntilAppointment()));
		}
		
		// Get selected value
		Object selectedValue = form.dyngrdReferrals().getValue();
		
		// Populate records to grid
		populateReferralsToGrid(records);
		
		// Reselect records
		form.dyngrdReferrals().setValue(selectedValue);
	}

	/**
	 * WDEV-13184
	 * Function used to populate Referral records to screen
	 */
	private void populateReferralsToGrid(CatsReferralListManualAssemblyVoCollection records)
	{
		// Clear the grid
		form.dyngrdReferrals().getRows().clear();
		
		// If the collection is null terminate function
		if (records == null)
			return;
		
		// Build a string with the records ID's
		StringBuilder recordsID = new StringBuilder();
		// Add each Referral record to grid
		for (int i = 0; i < records.size(); i++)
		{
			addNewDynamicGridRow(records.get(i));
			
			// Append records ID
			recordsID.append(records.get(i).getCatsReferralId());
			if (i < records.size() -1)
				recordsID.append(", ");
		}
		
		// Load allocated tasks
		loadAllocatedTasks(recordsID.toString());
	}

	/**
	 *	WDEV-13184
	 *	Function used to retrieve Referral records from grid
	 */
	private CatsReferralListManualAssemblyVoCollection populateReferralsFromGrid()
	{
		// Records collection
		CatsReferralListManualAssemblyVoCollection records = new CatsReferralListManualAssemblyVoCollection();
		
		// Iterate grid rows and add their values to collection
		for (int i = 0; i < form.dyngrdReferrals().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdReferrals().getRows().get(i);
			
			if (row.getValue() instanceof CatsReferralListManualAssemblyVo)
				records.add((CatsReferralListManualAssemblyVo) row.getValue());
		}
		
		// Return records collection
		return records;
	}


	/**
	 *	WDEV-13184
	 *	Function used to toggle sort order for manual sort columns
	 */
	private void sortOrderToggle(Object identifier)
	{
		// Days left until appointment column
		if (COLDAYSLEFT.equals(identifier))
		{
			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderDayUntilAppointment()))
				form.getLocalContext().setSortOrderDayUntilAppointment(SortOrder.DESCENDING);
			else
				form.getLocalContext().setSortOrderDayUntilAppointment(SortOrder.ASCENDING);
		}
		else
		{
			form.getLocalContext().setSortOrderDayUntilAppointment(null);
		}
	}


	//WDEV-11024
	private void updateControlsState()
	{
		if(FormMode.EDIT.equals(form.getMode()))
		{
			form.btnSelectAll().setVisible(form.dyngrdReferrals().getRows().size() > 0);
		}
	}

	private void loadAllocatedTasks(String strIDs)
	{
		//WDEV-11024
		if(strIDs == null || strIDs.length() == 0)
			return;
		
		WorkAllocationVoCollection voColl = domain.listAllocatedTasks(strIDs);

		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			for (int j = 0 ; j < form.dyngrdReferrals().getRows().size() ; j++)
			{
				if (((CatsReferralListManualAssemblyVo)form.dyngrdReferrals().getRows().get(j).getValue()).getCatsReferralId().equals(voColl.get(i).getCatsReferral().getID_CatsReferral()))
				{
					form.dyngrdReferrals().getRows().get(j).getCells().get(getColumn(COLTREE)).setValue(Boolean.TRUE);
					form.dyngrdReferrals().getRows().get(j).getCells().get(getColumn(COLTREE)).setIdentifier(voColl.get(i));
					form.dyngrdReferrals().getRows().get(j).getCells().get(getColumn(COLTREE)).setTooltip("Allocated to " + (voColl.get(i).getAllocatedToIsNotNull() ? voColl.get(i).getAllocatedTo().getName().toString() : ""));
					
					// WDEV-13184
					// Update the row value - to reflect that it is checked
					((CatsReferralListManualAssemblyVo) form.dyngrdReferrals().getRows().get(j).getValue()).setIsChecked(Boolean.TRUE);

					form.dyngrdReferrals().getRows().get(j).getCells().get(getColumn(COLHIDDEN)).setValue(Boolean.TRUE);
				}
			}
		}
	}

	private String search() 
	{
		form.dyngrdReferrals().getRows().clear();
		CATSReferralFilterVo voFilter = form.getGlobalContext().RefMan.getReferralStatusListFilter();
		
		CatsReferralListManualAssemblyVoCollection voColl = null;
		if (voFilter.countFieldsWithValue() > 3)
		{
			voColl = domain.listCATSReferrals(voFilter, ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue(), false);
		}
		else
		{
			return "";
		}
		
		if (voColl == null || voColl.size() == 0)
		{
			engine.showMessage("No records match your search criteria.", "No data found", MessageButtons.OK, MessageIcon.WARNING);
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			addNewDynamicGridRow(voColl.get(i));
			sb.append(voColl.get(i).getCatsReferralId());
			if (i < voColl.size() -1)
				sb.append(", ");
		}
		return sb.toString();
	}

	private DynamicGridColumn getColumn(Integer identifier)
	{
		return form.dyngrdReferrals().getColumns().getByIdentifier(identifier);
	}

	private void addNewDynamicGridRow(CatsReferralListManualAssemblyVo voCatsRef)
	{
		DynamicGridRow newRow = form.dyngrdReferrals().getRows().newRow();
		DynamicGridCell checkCell = newRow.getCells().newCell(getColumn(COLTREE), DynamicCellType.BOOL);
		checkCell.setAutoPostBack(true);
		checkCell.setTooltip("Allocate / De-Allocate");
		// WDEV-13184 - Check the cell 
		checkCell.setValue(voCatsRef.getIsChecked());
		
		DynamicGridCell hiddenCell = newRow.getCells().newCell(getColumn(COLHIDDEN), DynamicCellType.BOOL);
		hiddenCell.setValue(Boolean.FALSE);
		
		if (ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue())
		{
			DynamicGridCell icpCell = newRow.getCells().newCell(getColumn(COLICP), DynamicCellType.IMAGE);
			icpCell.setValue(voCatsRef.getLinkedICPIDIsNotNull() && voCatsRef.getLinkedICPID() ? form.getImages().ICP.ICP : null);
			icpCell.setTooltip(voCatsRef.getLinkedICPIDIsNotNull() && voCatsRef.getLinkedICPID() ? "ICP" : "");
			icpCell.setReadOnly(true);
		}	
		
		if (voCatsRef.getIsCABIsNotNull() && voCatsRef.getIsCAB())
		{
			DynamicGridCell cabCell = newRow.getCells().newCell(getColumn(COLCAB), DynamicCellType.IMAGE);
			cabCell.setValue(form.getImages().OCRR.LetterC);
			cabCell.setTooltip("Choose and Book Referral");
			cabCell.setReadOnly(true);
		}	
		
//		wdev-12682
		if(form.getGlobalContext().RefMan.getDiagnosticReferralForApplicationIsNotNull()
			&& form.getGlobalContext().RefMan.getDiagnosticReferralForApplication())
		{
			DynamicGridCell locCell = newRow.getCells().newCell(getColumn(COLLOC), DynamicCellType.LABEL);
			locCell.setValue(voCatsRef.getReferralLocationNameIsNotNull() ? voCatsRef.getReferralLocationName() : "");
		}
		
		DynamicGridCell serviceCell = newRow.getCells().newCell(getColumn(COLSERVICE), DynamicCellType.LABEL);
		serviceCell.setValue(voCatsRef.getServiceNameIsNotNull() ? voCatsRef.getServiceName().toString() : "");
		
		DynamicGridCell rdCell = newRow.getCells().newCell(getColumn(COLREVIEW), DynamicCellType.IMAGE);
		if (voCatsRef.getIsFlaggedForReviewIsNotNull() && voCatsRef.getIsFlaggedForReview()) {
			rdCell.setValue(form.getImages().Core.RedFlag);
		}

		DynamicGridCell twentykpiCell = newRow.getCells().newCell(getColumn(COL20KPI), DynamicCellType.LABEL);
		twentykpiCell.setValue("");
		//WDEV-11713
		if (voCatsRef.getEnd18WWIsNotNull())
			twentykpiCell.setValue(voCatsRef.getEnd18WW().toString());
		
		DynamicGridCell nhsCell = newRow.getCells().newCell(getColumn(COLNHSNO), DynamicCellType.LABEL);
		nhsCell.setValue(voCatsRef.getNHSValue());

		DynamicGridCell typeNameCell = newRow.getCells().newCell(getColumn(COLNAME), DynamicCellType.STRING);
		typeNameCell.setValue(voCatsRef.getPatientNameIsNotNull()? voCatsRef.getPatientName().toString() : "");
		typeNameCell.setReadOnly(true);//WDEV-14171

		DynamicGridCell allocCell = null;
		if (voCatsRef.getIsCurrentlyAllocatedIsNotNull() && voCatsRef.getIsCurrentlyAllocated())
		{
			allocCell = newRow.getCells().newCell(getColumn(COLALLOCATED), DynamicCellType.IMAGE);
			allocCell.setReadOnly(true);
			allocCell.setValue(form.getImages().Core.Users);
			allocCell.setTooltip("Allocated");
		}	

		if (voCatsRef.getHasInvestigationsIsNotNull() && voCatsRef.getHasInvestigations())
		{
			DynamicGridCell typeInvCell = newRow.getCells().newCell(getColumn(COLINV), DynamicCellType.IMAGE);
			typeInvCell.setValue(form.getImages().OCRR.Accepted);
			typeInvCell.setTooltip("Investigations Ordered");
		}
		
		if (voCatsRef.getAdditionalInvStatusIsNotNull() 
			&& voCatsRef.getAdditionalInvStatus().equals(AdditionalInvestigationAppointmentsStatus.TOBEBOOKED))
		{
			DynamicGridCell typeInvCell = newRow.getCells().newCell(getColumn(COLINVNEEDAPPT), DynamicCellType.IMAGE);
			typeInvCell.setValue(form.getImages().OCRR.SpecimenDetails16);
			typeInvCell.setTooltip("Investigation Requires an Appointment");
		}
		
		DynamicGridCell statCell = newRow.getCells().newCell(getColumn(COLSTATUS), DynamicCellType.LABEL);
		statCell.setValue(voCatsRef.getCatsCurrentStatusIsNotNull() ? voCatsRef.getCatsCurrentStatus().getText().toString() : "");
		statCell.setTooltip(voCatsRef.getCatsCurrentStatusIsNotNull() ? voCatsRef.getCatsCurrentStatus().getText().toString() : "");
		statCell.setIdentifier(voCatsRef.getCatsCurrentStatusIsNotNull() ? voCatsRef.getCatsCurrentStatus() : null);
		
		if (voCatsRef.getHasApointmentsIsNotNull() && voCatsRef.getHasApointments())
		{
			DynamicGridCell bookCell = newRow.getCells().newCell(getColumn(COLBOOKING), DynamicCellType.IMAGE);
			bookCell.setValue(form.getImages().Core.CalendarMonth16);
			bookCell.setTooltip("Appointment Booked");
		}

		DynamicGridCell daysLeftCell = newRow.getCells().newCell(getColumn(COLDAYSLEFT), DynamicCellType.INT);
		daysLeftCell.setReadOnly(true);
		if(voCatsRef.getConsultationApptStatusIsNotNull()
			&& voCatsRef.getConsultationApptStatus().equals(Status_Reason.BOOKED))
		{
			if (voCatsRef.getConsAppointmentDateIsNotNull())
			{
				Date today = new Date();
				
				// WDEV-13184
				// Days until Consultant Appointment is now displayed as in Referral Status List
				long lval = Date.daysBetween(new Date(), new Date(voCatsRef.getConsAppointmentDate()));

				if (today.isGreaterThan(voCatsRef.getConsAppointmentDate()))
				{
					daysLeftCell.setTooltip("Consultation Appointment date is in the Past: " + voCatsRef.getConsAppointmentDate().toString());
					daysLeftCell.setValue((int)lval);
				}
				else
				{
					daysLeftCell.setTooltip("Days until Appointment.<br>Date is : " + voCatsRef.getConsAppointmentDate().toString() + " " + (voCatsRef.getConsultationApptStartTimeIsNotNull() ? voCatsRef.getConsultationApptStartTime().toString() : ""));
					daysLeftCell.setValue((int)lval);
				}
			}
		}


		newRow.setValue(voCatsRef);
		
		if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.FURTHER_MANAGEMENT_REQUIRED)) 
				newRow.setBackColor(ConfigFlag.UI.FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR.getValue());
				
		if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.DISCHARGED)) 
				newRow.setBackColor(ConfigFlag.UI.DISCHARGED_ROW_COLOUR.getValue());
				
		//WDEV-6195
		if (voCatsRef.getPatientNameIsNotNull())
		{
			if(voCatsRef.getAssociatedPatientIdIsNotNull())
			{
				newRow.setBackColor(ConfigFlag.UI.MERGED_COLOUR.getValue());

				if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.FURTHER_MANAGEMENT_REQUIRED)) 
					newRow.setTextColor(ConfigFlag.UI.FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR.getValue());

				if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.DISCHARGED)) 
					newRow.setTextColor(ConfigFlag.UI.DISCHARGED_ROW_COLOUR.getValue());
			}
			
			if (voCatsRef.getPatientDODIsNotNull())
			{
				newRow.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());			
				
				if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.FURTHER_MANAGEMENT_REQUIRED)) 
					newRow.setTextColor(ConfigFlag.UI.FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR.getValue());

				if (voCatsRef.getCatsCurrentStatusIsNotNull() && voCatsRef.getCatsCurrentStatus().equals(ReferralApptStatus.DISCHARGED)) 
					newRow.setTextColor(ConfigFlag.UI.DISCHARGED_ROW_COLOUR.getValue());
			}
		}
		newRow.setSelectable(true);
	}

	private void initializeDynamicGrid()
	{
		form.dyngrdReferrals().clear();
		form.dyngrdReferrals().setSelectable(true);
		
		DynamicGridColumn cabTree = form.dyngrdReferrals().getColumns().newColumn("", COLTREE);
		cabTree.setWidth(30);	

		DynamicGridColumn hiddenTree = form.dyngrdReferrals().getColumns().newColumn("", COLHIDDEN);
		hiddenTree.setWidth(0);	

		if (ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue())
		{
			DynamicGridColumn cabColumn = form.dyngrdReferrals().getColumns().newColumn("", COLICP);
			cabColumn.setWidth(32);	
		}	

		DynamicGridColumn cabColumn = form.dyngrdReferrals().getColumns().newColumn("", COLCAB);
		cabColumn.setWidth(32);	

		DynamicGridColumn serviceColumn = null;
//		wdev-12682
		if(form.getGlobalContext().RefMan.getDiagnosticReferralForApplicationIsNotNull()
			&& form.getGlobalContext().RefMan.getDiagnosticReferralForApplication())
		{
			DynamicGridColumn locColumn = form.dyngrdReferrals().getColumns().newColumn("Location", COLLOC);
			locColumn.setWidth(75);	
			
			serviceColumn = form.dyngrdReferrals().getColumns().newColumn("Service", COLSERVICE);
			serviceColumn.setWidth(80);	
		}
		else
		{
			serviceColumn = form.dyngrdReferrals().getColumns().newColumn("Service", COLSERVICE);
			serviceColumn.setWidth(125);	
		}	

		DynamicGridColumn recColumn = form.dyngrdReferrals().getColumns().newColumn("", COLREVIEW);
		recColumn.setWidth(40);	
		recColumn.setAlignment(Alignment.CENTER);

		DynamicGridColumn remainingColumn = form.dyngrdReferrals().getColumns().newColumn("RTT Breach", COL20KPI);//WDEV-11713
		remainingColumn.setWidth(75);
		
		DynamicGridColumn ubrnColumn = form.dyngrdReferrals().getColumns().newColumn("", COLIMAGE);
		ubrnColumn.setWidth(32);	
		
		DynamicGridColumn nhsnoColumn = form.dyngrdReferrals().getColumns().newColumn("NHS No.", COLNHSNO);
		nhsnoColumn.setWidth(70);		
		nhsnoColumn.setSortMode(SortMode.AUTOMATIC);
			
		DynamicGridColumn nameColumn = form.dyngrdReferrals().getColumns().newColumn("Name", COLNAME);
//		wdev-12682
		if (ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue() 
			&& (form.getGlobalContext().RefMan.getDiagnosticReferralForApplicationIsNotNull()
				&& form.getGlobalContext().RefMan.getDiagnosticReferralForApplication()) )
			nameColumn.setWidth(98);		
		else if (ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue() 
				|| (form.getGlobalContext().RefMan.getDiagnosticReferralForApplicationIsNotNull()
					&& form.getGlobalContext().RefMan.getDiagnosticReferralForApplication()))
			nameColumn.setWidth(113);	
		else
			nameColumn.setWidth(143);		
				
		nameColumn.setSortMode(SortMode.AUTOMATIC);

		DynamicGridColumn pdfColumn = form.dyngrdReferrals().getColumns().newColumn("", COLALLOCATED);
		pdfColumn.setWidth(32);		
		pdfColumn.setSortMode(SortMode.AUTOMATIC);

		DynamicGridColumn statusColumn = form.dyngrdReferrals().getColumns().newColumn("Status", COLSTATUS);
		statusColumn.setWidth(98);		
		statusColumn.setSortMode(SortMode.AUTOMATIC);

		DynamicGridColumn invColumn = form.dyngrdReferrals().getColumns().newColumn("", COLINV);
		invColumn.setWidth(32);		
		invColumn.setSortMode(SortMode.AUTOMATIC);

		DynamicGridColumn invNeedApptColumn = form.dyngrdReferrals().getColumns().newColumn("", COLINVNEEDAPPT);
		invNeedApptColumn.setWidth(32);		
		invNeedApptColumn.setSortMode(SortMode.AUTOMATIC);
		
		DynamicGridColumn bookColumn = form.dyngrdReferrals().getColumns().newColumn("", COLBOOKING);
		bookColumn.setWidth(32);	
		
		DynamicGridColumn daysleftColumn = form.dyngrdReferrals().getColumns().newColumn("", COLDAYSLEFT);
		daysleftColumn.setWidth(-1);	
		daysleftColumn.setSortMode(SortMode.MANUAL);
	
		form.dyngrdReferrals().setCheckBoxesAutoPostBack(true);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		WorkAllocationVoCollection voColl = populateCollectionFromScreen();
		
		if ( ! validateData())
			return;

		voColl.validate();
		try 
		{
			domain.saveAllocations(voColl);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.toString());			
		}
		
		engine.close(DialogResult.OK);
	}
	
	private boolean validateData() 
	{
		if (form.ccAllocatedTo().getValue() == null
			&& form.getLocalContext().getonlyDeallocate().equals(Boolean.FALSE))
		{
			engine.showMessage("No Allocate To value is selected.");
			return false;
		}
		
		return true;
	}

	private WorkAllocationVoCollection populateCollectionFromScreen()
	{
		WorkAllocationVoCollection voColl = new WorkAllocationVoCollection();
		boolean onlyDeallocates = true;
		
		for(int i = 0 ; i < form.dyngrdReferrals().getRows().size() ; i++)
		{			
			Object objBool = form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getValue();
			if (objBool instanceof Boolean) 
			{
				if((Boolean) objBool
					&& form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getIdentifier() == null)
				{
					WorkAllocationVo newWorkAllocation = new WorkAllocationVo();
					newWorkAllocation.setCatsReferral(new CatsReferralRefVo( ((CatsReferralListManualAssemblyVo)form.dyngrdReferrals().getRows().get(i).getValue()).getCatsReferralId(),0));
					newWorkAllocation.setDateAllocated(new DateTime());
					newWorkAllocation.setAllocatedBy((MemberOfStaffLiteVo) domain.getMosUser());
					newWorkAllocation.setAllocatedTo((MemberOfStaffLiteVo)form.ccAllocatedTo().getValue());
					newWorkAllocation.setReferralStatus(new ReferralApptStatus(((CatsReferralListManualAssemblyVo)form.dyngrdReferrals().getRows().get(i).getValue()).getCatsCurrentStatus().getID(), "", Boolean.TRUE));
					voColl.add(newWorkAllocation);
					onlyDeallocates = false;
				}
				else if ( !((Boolean) objBool)
					&& form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getIdentifier() != null)
				{
					WorkAllocationVo voExistingWorkallocation = (WorkAllocationVo) form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getIdentifier();
					voExistingWorkallocation.setUnallocatedBy((MemberOfStaffRefVo)domain.getMosUser());
					voExistingWorkallocation.setUnallocatedDate(new DateTime());
					
					voColl.add(voExistingWorkallocation);
				}
			}
		}
		
		form.getLocalContext().setonlyDeallocate(onlyDeallocates);
		return voColl;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onDyngrdReferralsCellValueChanged(DynamicGridCell cell) 
	{
		if (cell.getType().equals(DynamicCellType.BOOL))
		{
			Object objBool = cell.getValue();
			if (objBool instanceof Boolean) 
			{
				form.ccAllocatedTo().setEnabled(true);
				
				((CatsReferralListManualAssemblyVo) cell.getRow().getValue()).setIsChecked((Boolean) objBool);
				
				if( ! ((Boolean) objBool))
					engine.showMessage("This will De-Allocate this Task.");
			}
		}
			
		if ( ! isAnythingTicked())
			form.ccAllocatedTo().setEnabled(false);
			
		if ( anythingToSave())
		{
			form.btnSave().setEnabled(true);
			form.btnSave().setVisible(true);
		}
		else
		{
			form.btnSave().setEnabled(false);
			form.btnSave().setVisible(false);
		}
	}

	private boolean anythingToSave() 
	{
		for (int i = 0 ; i < form.dyngrdReferrals().getRows().size() ; i++)
		{
			Object objBool = form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getValue();
			Object objHiddenBool = form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLHIDDEN)).getValue();
			//If ticked and was previously not saved
			if (objBool instanceof Boolean
				&& ((Boolean)objBool)) 
			{
				if (objHiddenBool instanceof Boolean
					&&  !((Boolean)objHiddenBool)) 
				return true;
			}
			//If un-ticked and was previously saved
			if (objBool instanceof Boolean
				&&  !((Boolean)objBool)) 
			{
				if (objHiddenBool instanceof Boolean
					&&  ((Boolean)objHiddenBool)) 
				return true;
			}
		}
		return false;
	}

	private boolean isAnythingTicked() 
	{
		for (int i = 0 ; i < form.dyngrdReferrals().getRows().size() ; i++)
		{
			Object objBool = form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).getValue();
			Object objHiddenBool = form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLHIDDEN)).getValue();
			if (objBool instanceof Boolean
				&& ((Boolean)objBool)) 
			{
				if (objHiddenBool instanceof Boolean
					&&  !((Boolean)objHiddenBool)) 
				return true;
			}
		}
		return false;
	}

	@Override
	protected void onBtnSelectAllClick() throws PresentationLogicException 
	{	
		int size = form.dyngrdReferrals().getRows().size();
		if (form.getLocalContext().getSelectedAll())
		{
			form.btnSelectAll().setText("Select All");
			form.getLocalContext().setSelectedAll(false);
			for (int i = 0; i < size; i++) 
			{
				form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).setValue(Boolean.FALSE);
			}
			engine.showMessage("This will De-Allocate all Tasks.");
		}
		else
		{
			form.btnSelectAll().setText("Unselect All");
			form.getLocalContext().setSelectedAll(true);
			
			for (int i = 0; i < size; i++) 
			{
				form.dyngrdReferrals().getRows().get(i).getCells().get(getColumn(COLTREE)).setValue(Boolean.TRUE);
			}
			form.ccAllocatedTo().setEnabled(true);
		}
		if (!isAnythingTicked()) {
			form.ccAllocatedTo().setEnabled(false);
		}
			
		if (anythingToSave()) {
			form.btnSave().setEnabled(true);
			form.btnSave().setVisible(true);
		}
		else {
			form.btnSave().setEnabled(false);
			form.btnSave().setVisible(false);
		}
	}
}
