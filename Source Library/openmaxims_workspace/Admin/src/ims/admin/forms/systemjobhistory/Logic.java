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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.80 build 3999.26423)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.forms.systemjobhistory;

import java.util.List;

import javax.naming.NamingException;

import ims.admin.forms.systemjobhistory.GenForm.grdHistoryRow;
import ims.admin.forms.systemjobhistory.GenForm.lyrDetailsLayer.tabTraceContainer.grdTraceRow;
import ims.admin.vo.ConfiguredJobVo;
import ims.core.vo.ConfiguredJobExecutionSummaryVo;
import ims.core.vo.ConfiguredJobExecutionSummaryVoCollection;
import ims.core.vo.ConfiguredJobExecutionTraceVo;
import ims.core.vo.ConfiguredJobExecutionTraceVoCollection;
import ims.framework.LayerBridge;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ISchedulerJob;
import ims.framework.interfaces.ISchedulerServlet;
import ims.framework.interfaces.ITraceRecord;
import ims.scheduler.SchedulerJobExecutionStatus;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException 
	{
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{		
		
		loadData();
		form.lyrDetails().showtabEmpty();
		form.lyrDetails().tabEmpty().setHeaderVisible(false);
		form.lyrDetails().tabDetails().setHeaderVisible(false);
		form.lyrDetails().tabTrace().setHeaderVisible(false);
		
		if (form.grdHistory().getRows().size() > 0)
		{
			form.grdHistory().setValue(form.grdHistory().getRows().get(0).getValue());
			onGrdHistorySelectionChanged();
		}		
	}

	private void loadData() 
	{
		form.btnRefresh().setVisible(false);
		form.grdHistory().getRows().clear();
		
		ISchedulerServlet servletInstance = getTaskSchedulerServlet();
		ConfiguredJobVo currentJobConfiguration = form.getGlobalContext().Admin.getCurrentJobConfiguration();
		
		ISchedulerJob instance = servletInstance.getJob(currentJobConfiguration.getID_ConfiguredJob());
		if (instance != null)
		{	
			form.btnRefresh().setVisible(true);
			
			ConfiguredJobExecutionSummaryVo executionSummary = new ConfiguredJobExecutionSummaryVo();
			executionSummary.setMessage("Scheduled job is running.");
			executionSummary.setStartDateTime(instance.getJobStartDateTime());
			if (instance.getExecutionTrace() != null)
			{
				List<ITraceRecord> traces = instance.getExecutionTrace().getTrace();
				ConfiguredJobExecutionTraceVoCollection coll = new ConfiguredJobExecutionTraceVoCollection();
				for (int i = 0; i < traces.size(); i++) 
				{
					ConfiguredJobExecutionTraceVo vo = new ConfiguredJobExecutionTraceVo();
					vo.setMessage(traces.get(i).getMessage());
					vo.setDateTime(traces.get(i).getDateTime());
					coll.add(vo);
				}				
				
				executionSummary.setTraces(coll);
			}
			
			grdHistoryRow row = form.grdHistory().getRows().newRow();
			row.setValue(executionSummary);
			
			row.setColImage(form.getImages().Core.Time);
			row.setColStartDateTime(executionSummary.getStartDateTime() == null ? "Unknown" : executionSummary.getStartDateTime().toString());
			row.setColEndDateTime(null);
			row.setColStatus("In Progress");
			row.setColMessage(executionSummary.getMessage() == null ? "No details." : executionSummary.getMessage());			
		}		
		
		ConfiguredJobExecutionSummaryVoCollection list = domain.getHistory(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		for(int x = 0; x < list.size(); x++)
		{
			addItem(list.get(x));
		}
	}

	private void addItem(ConfiguredJobExecutionSummaryVo item) 
	{
		grdHistoryRow row = form.grdHistory().getRows().newRow();
		row.setValue(item);
		
		if (SchedulerJobExecutionStatus.parse(item.getStatus()) != null)
		{
			if (SchedulerJobExecutionStatus.parse(item.getStatus()).toString().equals("Succeeded"))
			{
				row.setColImage(form.getImages().Admin.LogInformation);
			}
			else if (SchedulerJobExecutionStatus.parse(item.getStatus()).toString().equals("Failed"))
			{
				row.setColImage(form.getImages().Admin.LogFatalError);
			}
		}
		
		row.setColStartDateTime(item.getStartDateTime() == null ? "Unknown" : item.getStartDateTime().toString());
		row.setColEndDateTime(item.getEndDateTime() == null ? "Unknown" : item.getEndDateTime().toString());
		row.setColStatus(item.getStatus() == null ? "Unknown" : SchedulerJobExecutionStatus.parse(item.getStatus()) == null ? "Unknown" : SchedulerJobExecutionStatus.parse(item.getStatus()).toString());
		row.setColMessage(item.getMessage() == null ? "No details." : item.getMessage());		
	}

	@Override
	protected void onGrdHistorySelectionChanged() throws PresentationLogicException 
	{
		showDetailsAndTraceTabs();
		
		form.lyrDetails().showtabDetails();
		form.lyrDetails().tabDetails().txtDetails().setValue(form.grdHistory().getSelectedRow() != null ? (form.grdHistory().getSelectedRow().getValue() != null ? form.grdHistory().getSelectedRow().getValue().getMessage() : null) : null);
		
		form.lyrDetails().tabTrace().grdTrace().getRows().clear();
		
		ConfiguredJobExecutionSummaryVo item = form.grdHistory().getValue();
		if(item != null && item.getTraces() != null)
		{
			ConfiguredJobExecutionTraceVoCollection list = item.getTraces();
			for(int x = 0; x < list.size(); x++)
			{
				addTraceItem(list.get(x));
			}
		}
		
		if (form.btnRefresh().isVisible())
		{
			form.lyrDetails().showtabTrace();
			if (form.lyrDetails().tabTrace().grdTrace().getRows().size() > 0) //WDEV-17838
			{	
				form.lyrDetails().tabTrace().grdTrace().setValue(form.lyrDetails().tabTrace().grdTrace().getRows().get(form.lyrDetails().tabTrace().grdTrace().getRows().size()-1).getValue());
			}
		}
	}

	private void addTraceItem(ConfiguredJobExecutionTraceVo item) 
	{
		grdTraceRow row = form.lyrDetails().tabTrace().grdTrace().getRows().newRow();
		row.setColImage(form.getImages().Core.Time);
		row.setColDateTime(item.getDateTime() == null ? "Unknown" : item.getDateTime().toString());
		row.setColMessage(item.getMessage() == null ? "No message" : item.getMessage());
	}

	private void showDetailsAndTraceTabs()
	{
		form.lyrDetails().tabEmpty().setHeaderVisible(false);		
		
		form.lyrDetails().tabDetails().setHeaderVisible(true);
		form.lyrDetails().tabDetails().setHeaderEnabled(true);
		
		form.lyrDetails().tabTrace().setHeaderVisible(true);
		form.lyrDetails().tabTrace().setHeaderEnabled(true);
	}
	
	@Override
	protected void onlyrDetailsTabChanged(LayerBridge tab) 
	{	
		
		
	} 
	
	private ISchedulerServlet getTaskSchedulerServlet()
	{
		try 
		{
			return ims.configuration.JNDI.getTaskSchedulerServlet();
		} 
		catch (NamingException err) 
		{		
			engine.showMessage(err.getMessage());
			return null;
		}
	}

	@Override
	protected void onBtnRefreshClick() throws PresentationLogicException 
	{
		loadData();
		form.lyrDetails().showtabEmpty();
		form.lyrDetails().tabEmpty().setHeaderVisible(false);
		form.lyrDetails().tabDetails().setHeaderVisible(false);
		form.lyrDetails().tabTrace().setHeaderVisible(false);
		
		if (form.grdHistory().getRows().size() > 0)
		{
			form.grdHistory().setValue(form.grdHistory().getRows().get(0).getValue());			
			onGrdHistorySelectionChanged();
		}			
		
		form.lyrDetails().showtabTrace();
	}	
}
