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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientmergemanager;

import java.util.ArrayList;

import ims.core.forms.patientmergemanager.GenForm.lyrPatMergeLayer.tabRequestsContainer.grpInterfaceEnumeration;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MergeRequestVo;
import ims.core.vo.MergeRequestVoCollection;
import ims.core.vo.MergedTablesVo;
import ims.core.vo.MergedTablesVoCollection;
import ims.core.vo.PatientId;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientMergeHistoryVo;
import ims.core.vo.PatientMergeHistoryVoCollection;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.factory.PatientMergeServletControllerFactory;
import ims.framework.interfaces.IPatMergeInterfaceComponent;
import ims.framework.interfaces.IPatMergeServletController;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int OUTSTANDING=1;
	private static final int COMPLETED=2;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		init();
	}
	
	private void init() throws PresentationLogicException
	{
		form.lyrPatMerge().tabRequests().grpInterface().setValue(grpInterfaceEnumeration.rdoCompleted);
		//form.lyrPatMerge().tabRequests().grpInterface().setEnabled(GenForm.lyrPatMergeLayer.tabRequestsContainer.grpInterfaceEnumeration.rdoCompleted, true);
		refreshServletTab();
	}

	@Override
	protected void onGrdMergeSelectionChanged()
	{
		if (form.lyrPatMerge().tabRequests().grdMerge().getValue() instanceof PatientMergeHistoryVo)
		{
			form.lyrPatMerge().tabRequests().grdType().getRows().clear();
			form.lyrPatMerge().tabRequests().grdAffectedItems().getRows().clear();
			
			PatientMergeHistoryVo history = (PatientMergeHistoryVo) form.lyrPatMerge().tabRequests().grdMerge().getValue();
			PatientIdCollection ids = history.getPatientIds();
			if (ids != null && ids.size() > 0)
			{
				GenForm.lyrPatMergeLayer.tabRequestsContainer.grdTypeRow row;
				for (int i=0; i<ids.size(); i++)
				{
					PatientId id = ids.get(i);
					row = form.lyrPatMerge().tabRequests().grdType().getRows().newRow();
					row.setcolIdType(id.getType().getText());
					row.setcolIdVal(id.getValue());
					row.setTooltip("Patient Identifiers previously associated with source patient");
				}
			}
			MergedTablesVoCollection items = history.getItems();
			if (items != null && items.size() > 0)
			{
				GenForm.lyrPatMergeLayer.tabRequestsContainer.grdAffectedItemsRow row;
				for (int i=0; i<items.size(); i++)
				{
					MergedTablesVo item = items.get(i);
					row = form.lyrPatMerge().tabRequests().grdAffectedItems().getRows().newRow();
					row.setcolEntity(toShortName(item.getEntityName()));
					row.setTooltipForcolEntity(item.getEntityName());
					row.setcolID(item.getObjectId());
					row.setcolTable(item.getTableName());
					row.setTooltipForcolTable(item.getTableName());
					row.setcolAttribute(item.getAttributeName());
					row.setTooltipForcolAttribute(item.getAttributeName());
				}
			}
		}
	}
	
	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearTabRequests();
		
	}
	
	private void clearTabRequests() 
	{
		form.lyrPatMerge().tabRequests().dteFrom().setValue(null);
		form.lyrPatMerge().tabRequests().dteTo().setValue(null);
		form.lyrPatMerge().tabRequests().cmbDestIdType().setValue(null);
		form.lyrPatMerge().tabRequests().cmbSourceIdType().setValue(null);
		form.lyrPatMerge().tabRequests().txtDestValue().setValue(null);
		form.lyrPatMerge().tabRequests().txtSourceValue().setValue(null);
		
		form.lyrPatMerge().tabRequests().grdAffectedItems().getRows().clear();
		form.lyrPatMerge().tabRequests().grdMerge().getRows().clear();
		form.lyrPatMerge().tabRequests().grdType().getRows().clear();
	}

	@Override
	protected void onImbFindClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isSearchCriteriaValid()) //WDEV-18871 
		{
			int type = getSearchType();
			if (type == OUTSTANDING)
				searchMergeRequest();
			else if (type == COMPLETED)
				searchMergeHistory();
			else
				engine.showMessage("Please Select search type - Outstanding or Completed Merges");
		}
	}
	
	//WDEV-18871 
	private boolean isSearchCriteriaValid()
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (form.lyrPatMerge().tabRequests().dteFrom().getValue() != null && form.lyrPatMerge().tabRequests().dteTo().getValue()!= null && form.lyrPatMerge().tabRequests().dteFrom().getValue().isGreaterThan(form.lyrPatMerge().tabRequests().dteTo().getValue()))
		{
			errorList.add("Find Requests Date From cannot be greater than Find Requests Date To");
		}
		
		if (errorList != null && errorList.size() > 0)
		{
			engine.showErrors(errorList.toArray(new String[errorList.size()]));
			return false;
		}
		
		return true;
	}

	private void searchMergeHistory()
	{
		form.lyrPatMerge().tabRequests().grdType().getRows().clear();
		form.lyrPatMerge().tabRequests().grdAffectedItems().getRows().clear();
		
		PatientId sourcePatient = new PatientId();
		sourcePatient.setType(form.lyrPatMerge().tabRequests().cmbSourceIdType().getValue());
		sourcePatient.setValue(form.lyrPatMerge().tabRequests().txtSourceValue().getValue());
		
		PatientId destinationPatient = new PatientId();
		destinationPatient.setType(form.lyrPatMerge().tabRequests().cmbDestIdType().getValue());
		destinationPatient.setValue(form.lyrPatMerge().tabRequests().txtDestValue().getValue());
		
		PatientMergeHistoryVoCollection historyColl = domain.listHistoryRequests(form.lyrPatMerge().tabRequests().dteFrom().getValue(),
				form.lyrPatMerge().tabRequests().dteTo().getValue(),
				form.lyrPatMerge().tabRequests().ccRequesteBy().getValue() instanceof MemberOfStaffLiteVo ? 
					(MemberOfStaffLiteVo)form.lyrPatMerge().tabRequests().ccRequesteBy().getValue() : null, sourcePatient, destinationPatient);

		form.lyrPatMerge().tabRequests().grdMerge().getRows().clear();
		
		// WDEV-18871 - starts here
		if (historyColl == null || historyColl.size() == 0)
		{
			engine.showMessage("No records matching your search criteria were found!", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
		}
		// WDEV-18871 - ends 
		
		if (historyColl != null && historyColl.size() > 0)
		{
			GenForm.lyrPatMergeLayer.tabRequestsContainer.grdMergeRow row;
			for (int i=0; i<historyColl.size(); i++)
			{
				PatientMergeHistoryVo history = historyColl.get(i);
				
				row = form.lyrPatMerge().tabRequests().grdMerge().getRows().newRow();
				row.setValue(history);
				row.setcolComment(history.getComment());
				row.setTooltipForcolComment(history.getComment());
				row.setcolDestinationPatient(history.getDestinationPatId().toString());
				row.setcolSourcePatient(history.getSourcePatId().toString());
				row.setcolOccurred(history.getCreationDateTime().getDate());
				row.setcolRequestedBy(history.getRequestedByIsNotNull()? history.getRequestedBy().getIMosName() : "");
				row.setcolDB(history.getDatabaseName());
			}
		}
		form.lyrPatMerge().tabRequests().grdAffectedItems().setVisible(true);
		form.lyrPatMerge().tabRequests().grdType().setVisible(true);
	}

	private void searchMergeRequest() 
	{
		PatientId sourcePatient = new PatientId();
		sourcePatient.setType(form.lyrPatMerge().tabRequests().cmbSourceIdType().getValue());
		sourcePatient.setValue(form.lyrPatMerge().tabRequests().txtSourceValue().getValue());
		
		PatientId destinationPatient = new PatientId();
		destinationPatient.setType(form.lyrPatMerge().tabRequests().cmbDestIdType().getValue());
		destinationPatient.setValue(form.lyrPatMerge().tabRequests().txtDestValue().getValue());
		
		MergeRequestVoCollection mergeColl = domain.listOutstandingRequests(form.lyrPatMerge().tabRequests().dteFrom().getValue(), 
				form.lyrPatMerge().tabRequests().dteTo().getValue(), form.lyrPatMerge().tabRequests().ccRequesteBy().getValue() instanceof MemberOfStaffLiteVo ? 
						(MemberOfStaffLiteVo)form.lyrPatMerge().tabRequests().ccRequesteBy().getValue() : null
						, sourcePatient, destinationPatient);
		
		form.lyrPatMerge().tabRequests().grdMerge().getRows().clear();
		
		// WDEV-18871 - start
		if (mergeColl == null || mergeColl.size() == 0)
		{
			engine.showMessage("No records matching your search criteria were found!", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
		}
		// WDEV-18871 - end
		
		if (mergeColl != null && mergeColl.size() > 0)
		{
			GenForm.lyrPatMergeLayer.tabRequestsContainer.grdMergeRow row;
			for (int i=0; i<mergeColl.size(); i++)
			{
				MergeRequestVo request = mergeColl.get(i);
				
				row = form.lyrPatMerge().tabRequests().grdMerge().getRows().newRow();
				row.setValue(request);
				row.setcolComment(request.getComment());
				row.setcolDestinationPatient(request.getDestinationPatId().toString());
				row.setcolRequestedBy(request.getRequestedByIsNotNull()?request.getRequestedBy().getIMosName():"");
				row.setcolSourcePatient(request.getSourcePatId().toString());
				row.setcolOccurred(request.getSysinfo().getCreationDateTime().getDate());
				row.setTooltip(request.getComment());
			}
		}
		form.lyrPatMerge().tabRequests().grdAffectedItems().setVisible(false);
		form.lyrPatMerge().tabRequests().grdType().setVisible(false);
	}

	private int getSearchType()
	{
		if (form.lyrPatMerge().tabRequests().grpInterface().getValue().equals(GenForm.lyrPatMergeLayer.tabRequestsContainer.grpInterfaceEnumeration.rdoOutstanding))
			return OUTSTANDING;
		else
			return COMPLETED;
	}

	
	@Override
	protected void onBtnRestartClick() throws ims.framework.exceptions.PresentationLogicException
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			controller.shutdown();
			Thread.sleep(1000); // Sleep for 1 second before starting
			controller.startup();
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.INFORMATION, "Patient Merge Servlet Restarted as requested");
			Thread.sleep(200);  // Before refresh
		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to restart PatientMerge Servlet - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to restart PatientMerge Servlet - " + e.getMessage());
		}
		refreshServletTab();
	}
	
	@Override
	protected void onBtnStopClick() throws ims.framework.exceptions.PresentationLogicException
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			controller.shutdown();
			Thread.sleep(200);  // Before refresh

		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to stop PatientMerge Servlet - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to stop PatientMerge Servlet - " + e.getMessage());
		}
		refreshServletTab();
	}
	
	@Override
	protected void onBtnStartClick() throws ims.framework.exceptions.PresentationLogicException
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			controller.startup();
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.INFORMATION, "Patient Merge Servlet Started as requested");
			Thread.sleep(200);  // Before refresh
		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to start PatientMerge Servlet - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to start PatientMerge Servlet - " + e.getMessage());
		}
		refreshServletTab();
		
	}
	
	private String getNoSuccess()
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			if (controller != null)
			{
				IPatMergeInterfaceComponent comp = controller.getPatMerge();
				return String.valueOf(comp.getSuccessfulCount());
			}
		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to retrieve Num Successful Merges - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to retrieve Num Successful Merges - " + e.getMessage());
			return "Not Available";
		}	
		return "Not Available";
	}

	private String getNoFailed()
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			if (controller != null)
			{
				IPatMergeInterfaceComponent comp = controller.getPatMerge();
			
				return String.valueOf(comp.getErrorCount());
			}
		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to retrieve Num Failed Merges - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to retrieve Num Failed Merges - " + e.getMessage());
			return "Not Available";
		}
		return "Not Available";
	}
	
	protected Boolean isServletRunning()
	{
		IPatMergeServletController controller = PatientMergeServletControllerFactory.getController();
		try 
		{
			if (controller != null)
				return(controller.isRunning());
		}
		catch (Exception e) 
		{
			engine.showMessage("Exception occurred attempting to retrieve PatientMerge Servlet Status - " + e.getMessage());
			engine.createSystemLogEntry(SystemLogType.PATIENT_MERGE, SystemLogLevel.ERROR, "Exception occurred attempting to retrieve PatientMerge Servlet Status - " + e.getMessage());
			return null;
		}
		return null;
	}

	protected void refreshServletTab() throws PresentationLogicException 
	{
		Boolean stat = isServletRunning();
		if (stat == null)
		{
			form.lyrPatMerge().tabServlet().lblStat().setValue("Servlet Status Unknown");
			form.lyrPatMerge().tabServlet().lblNoFail().setValue("0");
			form.lyrPatMerge().tabServlet().lblNoSuccess().setValue("0");
			form.lyrPatMerge().tabServlet().btnStart().setEnabled(false);
			form.lyrPatMerge().tabServlet().btnRestart().setEnabled(false);
			form.lyrPatMerge().tabServlet().btnStop().setEnabled(false);
		}
		else if (stat.booleanValue() == true)
		{
			form.lyrPatMerge().tabServlet().lblStat().setValue("Running");
			form.lyrPatMerge().tabServlet().lblNoFail().setValue(getNoFailed());
			form.lyrPatMerge().tabServlet().lblNoSuccess().setValue(getNoSuccess());

			form.lyrPatMerge().tabServlet().btnStart().setEnabled(false);
			form.lyrPatMerge().tabServlet().btnStop().setEnabled(true);
			form.lyrPatMerge().tabServlet().btnRestart().setEnabled(true);
		}
		else if (stat.booleanValue() == false)
		{
			form.lyrPatMerge().tabServlet().lblStat().setValue("Stopped");
			form.lyrPatMerge().tabServlet().lblNoFail().setValue("N/A");
			form.lyrPatMerge().tabServlet().lblNoSuccess().setValue("N/A");

			form.lyrPatMerge().tabServlet().btnStart().setEnabled(true);
			form.lyrPatMerge().tabServlet().btnRestart().setEnabled(false);
			form.lyrPatMerge().tabServlet().btnStop().setEnabled(false);
		}
		
	}

	@Override
	protected void onBtnRefreshClick() throws PresentationLogicException
	{
		refreshServletTab();
	}

	private String toShortName(String entity)
	{
		return entity.substring(entity.lastIndexOf('.')+1);
	}

}
