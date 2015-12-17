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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.core.forms.baysopeningtimesdlg;

import ims.core.vo.BayConfigListVo;
import ims.core.vo.BayConfigListVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int COL_BAY_NAME = 0;
	private static final int COL_BAY_WEEKDAY_OPENING_TIME = 1;
	private static final int COL_BAY_WEEKDAY_CLOSING_TIME = 2;
	private static final int COL_BAY_WEEKEND_OPENING_TIME = 3;
	private static final int COL_BAY_WEEKEND_CLOSING_TIME = 4;
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initializeDynamicGrid();
		open();
	}
	private void open()
	{
		populateScrenFromData(form.getGlobalContext().Core.getADTWard());

	}
	private void populateScrenFromData(LocationLiteVo adtWard)
	{
		form.dyngrdBays().getRows().clear();

		if (adtWard == null)
			return;
		if (adtWard.getName() != null)
		{	
			form.htmWard().setHTML("<div " + (adtWard.getName().length() >= 65 ? "title = \"" + adtWard.getName() + "\" " : "") + "style=\"color:#000000; font-size: 16px;" + "\"><b>" + (adtWard.getName().length() >= 65 ? adtWard.getName().substring(0, 65) + "..." : adtWard.getName()) + "</b></div> ") ;
		}
		BayConfigListVoCollection bays = domain.getConfig(adtWard);
		if (bays == null || bays.size() == 0)
			return;

		for (BayConfigListVo bay: bays)
		{
			addBayRow(bay);
		}
		
	}
	private void addBayRow(BayConfigListVo bay)
	{
		if (bay == null || !bay.isBayOutOfOpeningHours())
			return;
		
		DynamicGridRow row = form.dyngrdBays().getRows().newRow();
		DynamicGridCell cell = row.getCells().newCell(getColumn(COL_BAY_NAME), DynamicCellType.LABEL);
		row.setSelectable(false);
		
		cell.setValue(bay.getBayIsNotNull() ? bay.getBay().getName() : null);
		cell.setTooltip(bay.getBayIsNotNull() ? bay.getBay().getName() : null);
		
		if (Boolean.TRUE.equals(bay.getWeekdaysOnly()))
		{
			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKDAY_OPENING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getOpeningTimeIsNotNull() ? bay.getOpeningTime().toString() : new Time(0, 0).toString());

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKDAY_CLOSING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getClosingTimeIsNotNull() ? bay.getClosingTime().toString() : new Time(23, 59).toString());

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKEND_OPENING_TIME), DynamicCellType.LABEL);
			cell.setValue("Bay Closed");

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKEND_CLOSING_TIME), DynamicCellType.LABEL);
			cell.setValue("Bay Closed");
		}
		else
		{
			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKDAY_OPENING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getOpeningTimeIsNotNull() ? bay.getOpeningTime().toString() : new Time(0, 0).toString());

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKDAY_CLOSING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getClosingTimeIsNotNull() ? bay.getClosingTime().toString() : new Time(23, 59).toString());

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKEND_OPENING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getOpeningTimeIsNotNull() ? bay.getOpeningTime().toString() : new Time(0, 0).toString());

			cell = row.getCells().newCell(getColumn(COL_BAY_WEEKEND_CLOSING_TIME), DynamicCellType.LABEL);
			cell.setValue(bay.getClosingTimeIsNotNull() ? bay.getClosingTime().toString() : new Time(23, 59).toString());

		}
		row.setValue(bay);		
	}
	
	private DynamicGridColumn getColumn(Integer identifier)
	{
		return form.dyngrdBays().getColumns().getByIdentifier(identifier);
	}
	private void initializeDynamicGrid()
	{
		form.dyngrdBays().clear();
		form.dyngrdBays().setSelectable(false);
		form.dyngrdBays().setHeaderHeight(58);
		
		DynamicGridColumn colBay = null;
		
		colBay = form.dyngrdBays().getColumns().newColumn("Bay", COL_BAY_NAME);
		colBay.setWidth(380);		
		
		DynamicGridColumn colBayTime = form.dyngrdBays().getColumns().newColumn("Weekdays\nOpening Time", COL_BAY_WEEKDAY_OPENING_TIME);
		colBayTime.setWidth(80);		
		colBayTime.setHeaderAlignment(Alignment.CENTER);
		colBayTime.setAlignment(Alignment.CENTER);
		
		colBayTime = form.dyngrdBays().getColumns().newColumn("Weekdays\nClosing Time", COL_BAY_WEEKDAY_CLOSING_TIME);
		colBayTime.setWidth(80);
		colBayTime.setHeaderAlignment(Alignment.CENTER);
		colBayTime.setAlignment(Alignment.CENTER);
		
		colBayTime = form.dyngrdBays().getColumns().newColumn("Weekend\nOpening Time", COL_BAY_WEEKEND_OPENING_TIME);
		colBayTime.setWidth(80);
		colBayTime.setHeaderAlignment(Alignment.CENTER);
		colBayTime.setAlignment(Alignment.CENTER);	
		
		colBayTime = form.dyngrdBays().getColumns().newColumn("Weekend\nClosing Time", COL_BAY_WEEKEND_CLOSING_TIME);
		colBayTime.setWidth(80);
		colBayTime.setHeaderAlignment(Alignment.CENTER);
		colBayTime.setAlignment(Alignment.CENTER);	
		
	}
	@Override
	protected void onImbRefreshClick() throws ims.framework.exceptions.PresentationLogicException
	{
		populateScrenFromData(form.getGlobalContext().Core.getADTWard());
	}
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
