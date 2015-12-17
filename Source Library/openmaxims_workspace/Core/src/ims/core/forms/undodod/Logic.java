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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5214.17710)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.undodod;

import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.UndoDODFileds;
import ims.core.vo.lookups.UndoDODFiledsCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final Integer COL_FIELD_NAME = new Integer(0);
	private static final Integer COL_STATUS = new Integer(1);
    private static final Integer COL_BUTTON = new Integer(2);

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}
	
	private void initialise()
	{
		initialiseUndoGrid();
		bindUndoGridWithTypeFields();
	}

	private void bindUndoGridWithTypeFields()
	{
		UndoDODFiledsCollection types = LookupHelper.getUndoDODFileds(domain.getLookupService());
		
		for(int i=0; i<types.size(); i++)
		{
			addTypeRow(types.get(i));
		}
	}

	private void initialiseUndoGrid()
	{
		form.dyngrdUndo().clear();
		
		DynamicGridColumn column = form.dyngrdUndo().getColumns().newColumn("Field Name", COL_FIELD_NAME);
		column.setWidth(600);
		column.setCanGrow(true);
		
		column = form.dyngrdUndo().getColumns().newColumn(" ", COL_BUTTON);
		column.setWidth(35);
		column.setCanGrow(true);
		column.setAlignment(Alignment.CENTER);
		
		column = form.dyngrdUndo().getColumns().newColumn("Status", COL_STATUS);
		column.setWidth(-1);
		column.setCanGrow(true);
	}
	
	private void addTypeRow(UndoDODFileds undoDODFileds) 
	{
		if(undoDODFileds == null)
			return;
		
		DynamicGridRow row = form.dyngrdUndo().getRows().newRow();
		row.setSelectable(false);
		row.setExpanded(true);
		row.setValue(undoDODFileds);
		//row.setBackColor(Color.Azure);
		
		DynamicGridCell cell = row.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>" + undoDODFileds.getText() + "</b>");
		cell.setReadOnly(true);
		
		cell = row.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_32);
		cell.setTooltip("Undo All");
		cell.setReadOnly(false);
	}
	
	private DynamicGridColumn getColumn(Integer colFieldName) 
	{
		return form.dyngrdUndo().getColumns().getByIdentifier(colFieldName);
	}

	private void open()
	{
		populateUndoGrid();
		
		//form.setMode(FormMode.EDIT);
	}
	
	private void populateUndoGrid()
	{
		for(int i=0; i<form.dyngrdUndo().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdUndo().getRows().get(i);
			
			if(UndoDODFileds.APPOINTMENTS.equals(row.getValue()))
			{
				populateAppointments(row);
			}
			else if(UndoDODFileds.TCIS.equals(row.getValue()))
			{
				populateTCIs(row);
			}
			else if(UndoDODFileds.RTTSTATUS.equals(row.getValue()))
			{
				populateRTTStatus(row);
			}
		}
	}

	private void populateRTTStatus(DynamicGridRow parentRow)
	{
		DynamicGridRow childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		DynamicGridCell cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>28/05/2014 12:05</b> - Mr. Henry Adams");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("36 - Patient died before treatment");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
	}

	private void populateTCIs(DynamicGridRow parentRow)
	{
		DynamicGridRow childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		DynamicGridCell cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>05/05/2014 12:05</b> - OCS Ward - Central Hospital");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Inactive");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
		
		childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>03/04/2014 10:05</b> - OCS Ward - Central Hospital");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Inactive");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
	}

	private void populateAppointments(DynamicGridRow parentRow)
	{
		DynamicGridRow childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		DynamicGridCell cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>28/04/2014 12:05</b> - P1 - Emergency Deparment <div><b>Slot :</b> First Appointment - 28/04/2014 12.05 - 12.35 - Open</div>");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Cancelled");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
		
		childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>27/04/2014 10:00</b> - P1 - Emergency Deparment <div><b>Slot :</b> First Appointment - 27/04/2014 10.00 - 10.30 - Open</div>");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Cancelled");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
		
		childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>26/04/2014 11:05</b> - P1 - Emergency Deparment <div style=\"color:#FF0000\"><b>Slot :</b> First Appointment - 26/04/2014 11.05 - 12.35 - Booked </div>");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Cancelled");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.BLOCKED_SLOT_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
		
		childRow = parentRow.getRows().newRow();
		childRow.setSelectable(true);
		
		cell = childRow.getCells().newCell(getColumn(COL_FIELD_NAME), DynamicCellType.HTMLVIEW);
		cell.setValue("<b>25/04/2014 09:05</b> - P1 - Emergency Deparment <div><b>Slot :</b> First Appointment - 25/04/2014 09.00 - 11.00 - Open</div>");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_STATUS), DynamicCellType.HTMLVIEW);
		cell.setValue("Cancelled");
		cell.setReadOnly(true);
		cell = childRow.getCells().newCell(getColumn(COL_BUTTON), DynamicCellType.IMAGEBUTTON);
		cell.setValue(form.getImages().Core.Undo_24);
		cell.setTooltip("Undo");
		cell.setReadOnly(false);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}

	@Override
	protected void onDyngrdUndoCellButtonClicked(DynamicGridCell cell)
	{
		if(cell.getRow() != null && cell.getRow().getParent() == null)
		{
			for(int i=0; i<cell.getRow().getRows().size(); i++)
			{
    			if(cell.getRow().getRows().get(i).getParent().getValue().equals(UndoDODFileds.APPOINTMENTS))
    			{
    				if(i != 2)
    				{
    					DynamicGridCell statusCell = cell.getRow().getRows().get(i).getCells().get(getColumn(COL_STATUS));
    					statusCell.setValue("Booked");
    				}
    			}
    			else if(cell.getRow().getRows().get(i).getParent().getValue().equals(UndoDODFileds.TCIS))
    			{
    				DynamicGridCell statusCell = cell.getRow().getRows().get(i).getCells().get(getColumn(COL_STATUS));
    				statusCell.setValue("Active");
    			}
    			else if(cell.getRow().getRows().get(i).getParent().getValue().equals(UndoDODFileds.RTTSTATUS))
    			{
    				DynamicGridCell statusCell = cell.getRow().getRows().get(i).getCells().get(getColumn(COL_STATUS));
    				statusCell.setValue("12 - The first Activity at the start of a new Referral to Treatment Period  following a decision to refer directly to the CONSULTANT or NHS Allied Health Professional Service for a separate condition");
    			}
    			
    			if(i != 2)
    			{
    				DynamicGridCell imageCell = cell.getRow().getRows().get(i).getCells().get(getColumn(COL_BUTTON));
    				imageCell.clear();
    			}
			}
		}
		
		if(cell.getRow().getParent() != null && cell.getRow().getParent().getValue().equals(UndoDODFileds.APPOINTMENTS))
		{
			if(!cell.getValue().equals(form.getImages().Core.BLOCKED_SLOT_24))
			{
				DynamicGridCell statusCell = cell.getRow().getCells().get(getColumn(COL_STATUS));
				statusCell.setValue("Booked");
			}
		}
		
		if(cell.getRow().getParent() != null && cell.getRow().getParent().getValue().equals(UndoDODFileds.TCIS))
		{
			DynamicGridCell statusCell = cell.getRow().getCells().get(getColumn(COL_STATUS));
			statusCell.setValue("Active");
		}
		
		if(cell.getRow().getParent() != null && cell.getRow().getParent().getValue().equals(UndoDODFileds.RTTSTATUS))
		{
			DynamicGridCell statusCell = cell.getRow().getCells().get(getColumn(COL_STATUS));
			statusCell.setValue("12 - The first Activity at the start of a new Referral to Treatment Period  following a decision to refer directly to the CONSULTANT or NHS Allied Health Professional Service for a separate condition");
		}
		
		if(!cell.getValue().equals(form.getImages().Core.BLOCKED_SLOT_24))
		{
			cell.clear();
		}
	}
}
