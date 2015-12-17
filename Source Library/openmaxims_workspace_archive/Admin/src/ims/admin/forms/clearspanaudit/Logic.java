//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Ancuta Ciubotaru using IMS Development Environment (version 1.80 build 3979.27222)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.forms.clearspanaudit;

import ims.admin.forms.clearspanaudit.GenForm;
import ims.admin.vo.ClearSpanAuditVo;
import ims.admin.vo.ClearSpanAuditVoCollection;
import ims.admin.vo.lookups.ClearSpanEventLevel;
import ims.admin.vo.lookups.ClearSpanEventLevelCollection;
import ims.admin.vo.lookups.ClearSpanEvents;
import ims.admin.vo.lookups.ClearSpanEventsCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.delegates.CancelArgs;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	
	@Override
	protected void onGrdDetailsSelectionChanged()
	{
		displayDetails();
	}
		
	private void displayDetails()
	{
		displayDetails(form.grdDetails().getValue());		
	}
	private void displayDetails(ClearSpanAuditVo entry) 
	{
		clearDetails();
		
		if(entry == null)
			return;
		
		form.getLocalContext().setSelectedEntry(entry);
				
		form.ctnDetails().txtDetailsDateTime().setValue(entry.getTimeGenerated().toString());	
		form.ctnDetails().txtDetailsEventType().setValue(entry.getEventType().toString());
		form.ctnDetails().txtDetailsLevel().setValue(entry.getEvenLevel().toString());
		form.ctnDetails().txtDetailsSource().setValue(entry.getSourceName());				
		form.ctnDetails().txtDetailsMessage().setValue(entry.getMessage());
		form.ctnDetails().txtDetailsData().setValue(entry.getData());
		
		form.ctnDetails().setCollapsed(false);
	}
	
	private void initialize() 
	{				
		form.setMode(FormMode.VIEW);
		initializeDate();
		initializeEventType();
		initializeLevel();
		form.ctnDetails().setCollapsed(true);		
	}
	private void clearSearch()
	{
		form.dtimStart().setValue(null); // WDEV-16571 
		form.txtSource().setValue(null);		
		form.cmbLevel().setValue(null);
		form.cmbType().setValue(null);		
		form.grdDetails().getRows().clear();
		form.ctnDetails().setCollapsed(true);
		clearDetails();
		
	}
	private void initializeDate()
	{
		form.dtimStart().setValue(new DateTime(new Date(), new Time()).addHours(-1));		
	}
	private void initializeEventType() 
	{		
		form.cmbType().clear();		
		ClearSpanEventsCollection coll = null;
		
		try
		{
			coll = domain.getEventTypes();
		} catch (DomainInterfaceException e)
		{
			//throw new DomainRuntimeException(e);
			engine.showMessage("Cannot get the Event Types");
			return;
		}
				
		for(int i=0;i<coll.size();i++)
		{
			ClearSpanEvents ev=coll.get(i);
			form.cmbType().newRow(ev, ev.getText());
		} 
	}
	
	private void initializeLevel()
	{	
		form.cmbLevel().clear();				
		ClearSpanEventLevelCollection levels=(ClearSpanEventLevelCollection) ClearSpanEventLevel.getNegativeInstancesAsIItemCollection();
		
		for(int x = 0; x < levels.size(); x++)
		{
			form.cmbLevel().newRow(levels.get(x), levels.get(x).getText(), levels.get(x).getImage());
		}
	}
		
	
	private void search()
	{		
		if(!validateSeach())
			return;
		try
		{
			populate(domain.getEntriesTotal(form.dtimStart().getValue(),
					form.txtSource().getValue(), 
					form.cmbType().getValue(),
					form.cmbLevel().getValue()));
			if(domain.getTotalCount().intValue()>200)
			{
				engine.showMessage("Search returned more than the configured max size of 200. Please refine the search criteria.");
			}
		} catch (DomainInterfaceException e)
		{
			engine.showMessage("Cannot get the returned entries based on the search criteria");
			return;
		}
	}
	
	private boolean validateSeach() 
	{
		if(form.dtimStart().getValue() == null)
		{
			engine.showMessage("Time Generated is mandatory.");//WDEV-15166
			return false;
		}
				
		return true;
	}
	private void populate(ClearSpanAuditVoCollection entries) 
	{				
		form.grdDetails().getRows().clear();
		form.grdDetails().resetScrollPosition();
		form.ctnDetails().setCollapsed(true);
		clearDetails();
		
		if(entries == null)
			return;
		
		for(int x = 0; x < entries.size(); x++)
		{
			populate(entries.get(x));
		}			
	}
	private void populate(ClearSpanAuditVo entry) 
	{
		if(entry == null)
			return;
		
		GenForm.grdDetailsRow row = form.grdDetails().getRows().newRow();
		row.setValue(entry);
		
		ClearSpanEventLevelCollection levs=(ClearSpanEventLevelCollection) ClearSpanEventLevel.getNegativeInstancesAsIItemCollection();
		
		try
		{
			if(domain.getEventLevelCode(entry.getEvenLevel(), levs).equals(domain.getEventLevelCode(ClearSpanEventLevel.INFORMATION, levs)))
				row.setcolImage(form.getImages().Admin.LogInformation);
			
			if(domain.getEventLevelCode(entry.getEvenLevel(), levs).equals(domain.getEventLevelCode(ClearSpanEventLevel.WARNING, levs)))
				row.setcolImage(form.getImages().Admin.LogWarning);	
			
		} catch (DomainInterfaceException e)
		{
			engine.showMessage("Cannot get the Event Levels");
			return;
		}
				
		
		row.setcolDateTime(entry.getTimeGenerated().toString());
		row.setcolLevel(entry.getEvenLevel().getText());
		row.setcolType(entry.getEventType().getText());
		
		String message = entry.getMessage();
		if(message.length() > 120)
			message = message.substring(0, 120) + "...";				
		row.setcolMessage(message);			
		
		String data = entry.getData()==null?" ": entry.getData();
		if(data.length() > 120)
			data = data.substring(0, 120) + "...";						
		row.setcolData(data);
		
	}
	private void clearDetails()
	{				
		form.ctnDetails().txtDetailsDateTime().setValue(null);		
		form.ctnDetails().txtDetailsLevel().setValue(null);
		form.ctnDetails().txtDetailsSource().setValue(null);
		form.ctnDetails().txtDetailsEventType().setValue(null);		
		form.ctnDetails().txtDetailsMessage().setValue(null);		
		form.getLocalContext().setSelectedEntry(null);
	}
	
	protected void onFormClosing(CancelArgs args)throws PresentationLogicException 
	{		
						
	}
	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearSearch();
		
	}
	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		search();
		
	}
	
    
	
	
}
