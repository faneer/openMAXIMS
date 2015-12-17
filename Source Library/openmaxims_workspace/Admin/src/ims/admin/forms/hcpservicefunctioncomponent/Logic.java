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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.forms.hcpservicefunctioncomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HCPServiceFunctionVo;
import ims.core.vo.HCPServiceFunctionVoCollection;
import ims.core.vo.HCPWithServiceAndFunctionVo;
import ims.core.vo.ServiceFunctionForServiceConfigurationVo;
import ims.core.vo.ServiceFunctionForServiceConfigurationVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.ServiceFunction;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final Integer COLUMN_SERVICE = new Integer(0);
	private static final Integer COLUMN_CHECKBOX = new Integer(1);
	private static final Integer COLUMN_SELECT_ALL_CHILDREN = new Integer(2);
	
	public void initialise(ims.core.resource.people.vo.HcpRefVo hcp)
	{
		initialiseGrid();
		clear();
		
		if(hcp == null || hcp.getID_Hcp() == null)
			return;
		
		form.getLocalContext().setSelectedHcp(domain.get(hcp));
		populateScreenFromData(form.getLocalContext().getSelectedHcp());
		
		updateControlsState();
	}

	private void initialiseGrid()
	{
		form.dyngrdServiceFunction().clear();
		form.dyngrdServiceFunction().getColumns().clear();
		
		DynamicGridColumn columnName = form.dyngrdServiceFunction().getColumns().newColumn("Service/Function", COLUMN_SERVICE);
		columnName.setCanGrow(true);
		columnName.setWidth(230);
		
		columnName = form.dyngrdServiceFunction().getColumns().newColumn("Select", COLUMN_CHECKBOX);
		columnName.setWidth(50);
		columnName.setHeaderAlignment(Alignment.CENTER);
		columnName.setAlignment(Alignment.CENTER);
		
//		columnName = form.dyngrdServiceFunction().getColumns().newColumn("Check/Uncheck \n all Functions", COLUMN_SELECT_ALL_CHILDREN);
		columnName = form.dyngrdServiceFunction().getColumns().newColumn("All", COLUMN_SELECT_ALL_CHILDREN); //WDEV-20735
		columnName.setWidth(-1);
		columnName.setAlignment(Alignment.CENTER);
		columnName.setHeaderAlignment(Alignment.CENTER);
	}

	private void populateScreenFromData(HCPWithServiceAndFunctionVo hcp)
	{
		clear();
		
		if(hcp == null)
			return;
		
		form.txtHCP().setValue(hcp.getMos() != null ? hcp.getMos().getIMosName() : null);
		
		if(hcp.getServiceFunction() == null)
			return;
		
		for(HCPServiceFunctionVo inst : hcp.getServiceFunction())
		{
			addRow(inst, null);
		}
	}

	private void addRow(HCPServiceFunctionVo inst, ServiceLiteVo service)
	{
		if(inst == null && service == null)
			return;
		
		DynamicGridRow serviceRow = getServiceRow(inst != null ? inst.getService() : service);
		if(inst != null && inst.getFunction() == null)
		{
			serviceRow.setValue(inst);
			
			DynamicGridCell cell = serviceRow.getCells().get(getColumn(COLUMN_CHECKBOX));
			cell.setValue(Boolean.TRUE.equals(inst.getIsActive()));
		}
		
		if(service != null)
		{
			DynamicGridCell cell = serviceRow.getCells().get(getColumn(COLUMN_CHECKBOX));
			cell.setValue(true);
		}
		
		if(inst != null && inst.getFunction() != null)
		{
			addChildRow(serviceRow, inst, null, null);
		}
		
		DynamicGridCell cellCheckAllFunctions = serviceRow.getCells().get(getColumn(COLUMN_SELECT_ALL_CHILDREN));
		
		if(cellCheckAllFunctions != null)
		{
			cellCheckAllFunctions.setReadOnly(!Boolean.TRUE.equals(serviceRow.getCells().get(getColumn(COLUMN_CHECKBOX)).getValue()));
			cellCheckAllFunctions.setValue(areAllChildrenChecked(serviceRow));
		}
	}
	
	private boolean areAllChildrenChecked(DynamicGridRow serviceRow)
	{
		if(serviceRow == null || serviceRow.getRows().size() == 0)
			return false;
		
		for(int i=0; i<serviceRow.getRows().size(); i++)
		{
			DynamicGridCell cell = serviceRow.getRows().get(i).getCells().get(getColumn(COLUMN_CHECKBOX));
			
			if(cell != null && !Boolean.TRUE.equals(cell.getValue()))
				return false;
		}
		
		return true;
	}

	private void addChildRow(DynamicGridRow serviceRow, HCPServiceFunctionVo inst, ServiceFunction function, ServiceFunctionForServiceConfigurationVo conf)
	{
		if(serviceRow == null || (inst == null && function == null))
			return;
		
		DynamicGridRow childRow = null;
			
		childRow = getFunctionRow(serviceRow, inst != null ? inst.getFunction() : function);
		
		if(childRow == null && inst != null && !Boolean.TRUE.equals(inst.getIsActive()))
			return;
		
		DynamicGridCell rowCell = null;
		if(childRow == null)
		{
			childRow = serviceRow.getRows().newRow();
		
			rowCell = childRow.getCells().newCell(getColumn(COLUMN_SERVICE), DynamicCellType.STRING);
			rowCell.setValue(getChildText(inst, function));
			rowCell.setReadOnly(true);
		}
		
		childRow.setValue(inst != null ? inst : function);
		
		DynamicGridCell rowCellC = childRow.getCells().get(getColumn(COLUMN_CHECKBOX));
		
		if(rowCellC == null)
		{
			rowCellC = childRow.getCells().newCell(getColumn(COLUMN_CHECKBOX), DynamicCellType.BOOL);
			rowCellC.setAutoPostBack(true);
		}
		
		DynamicGridCell cellParent = rowCellC.getRow().getParent().getCells().get(getColumn(COLUMN_SELECT_ALL_CHILDREN));
		
		if(cellParent != null)
		{
			rowCellC.setReadOnly(rowCellC.getRow().getParent().getCells().get(getColumn(COLUMN_SELECT_ALL_CHILDREN)).isReadOnly());
		}
		
		rowCellC.setValue(inst != null ? Boolean.TRUE.equals(inst.getIsActive()) : null);
	}

	private DynamicGridRow getFunctionRow(DynamicGridRow serviceRow, ServiceFunction function)
	{
		if(function == null)
			return null;
		
		for(int i=0; i<serviceRow.getRows().size(); i++)
		{
			DynamicGridRow functionRow = serviceRow.getRows().get(i);
			
			if(functionRow.getValue() instanceof HCPServiceFunctionVo)
			{
				if(function.equals(((HCPServiceFunctionVo) functionRow.getValue()).getFunction()))
					return functionRow;
			}
			else if(functionRow.getValue() instanceof ServiceFunction)
			{
				if(function.equals((ServiceFunction) functionRow.getValue()))
					return functionRow;
			}
		}
		
		return null;
	}

	private Object getChildText(HCPServiceFunctionVo inst, ServiceFunction function)
	{
		if(inst != null)
		{
			return inst.getFunction() != null ? inst.getFunction().getText() : null;
		}
		
		return function != null ? function.getText() : null;
	}

	private DynamicGridRow getServiceRow(ServiceLiteVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		for(int i=0; i<form.dyngrdServiceFunction().getRows().size(); i++)
		{
			if(form.dyngrdServiceFunction().getRows().get(i).getValue() instanceof ServiceLiteVo)
			{
				if(service.equals(form.dyngrdServiceFunction().getRows().get(i).getValue()))
					return form.dyngrdServiceFunction().getRows().get(i);
			}
			else if(form.dyngrdServiceFunction().getRows().get(i).getValue() instanceof HCPServiceFunctionVo)
			{
				if(service.equals(((HCPServiceFunctionVo)form.dyngrdServiceFunction().getRows().get(i).getValue()).getService()))
					return form.dyngrdServiceFunction().getRows().get(i);
			}
		}
		
		DynamicGridRow newRow = form.dyngrdServiceFunction().getRows().newRow();
		newRow.setExpanded(true);
		newRow.setValue(service);
		
		DynamicGridCell rowCell = newRow.getCells().newCell(getColumn(COLUMN_SERVICE), DynamicCellType.STRING);
		rowCell.setValue(service.getServiceName());
		rowCell.setReadOnly(true);
		
		rowCell = newRow.getCells().newCell(getColumn(COLUMN_CHECKBOX), DynamicCellType.BOOL);
		rowCell.setAutoPostBack(true);
		
		ServiceFunctionForServiceConfigurationVoCollection confList = domain.listServiceFunctionByService(service);
		
		for(ServiceFunctionForServiceConfigurationVo conf : confList)
		{
			addChildRow(newRow, null, conf.getFunction(), conf);
		}
		
		if(confList != null && confList.size() > 0)
		{
			rowCell = newRow.getCells().newCell(getColumn(COLUMN_SELECT_ALL_CHILDREN), DynamicCellType.BOOL);
			rowCell.setAutoPostBack(true);
		}
		
		return newRow;
	}

	private DynamicGridColumn getColumn(Integer identifier)
	{
		return form.dyngrdServiceFunction().getColumns().getByIdentifier(identifier);
	}

	private void clear()
	{
		form.txtHCP().setValue(null);
		form.qmbService().clear();
		form.dyngrdServiceFunction().getRows().clear();
	}

	public Boolean save()
	{
		form.getLocalContext().setIsStale(false);
		
		HCPWithServiceAndFunctionVo hcp = populateDataFromScreen(form.getLocalContext().getSelectedHcp());
		
		if(hcp == null)
			return false;
		
		String[] errors = hcp.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.save(hcp);
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			form.getLocalContext().setIsStale(true);
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		return true;
	}

	private HCPWithServiceAndFunctionVo populateDataFromScreen(HCPWithServiceAndFunctionVo hcp)
	{
		if(hcp == null)
			return null;
		
		HCPServiceFunctionVoCollection coll = new HCPServiceFunctionVoCollection();
		
		for(int i=0; i<form.dyngrdServiceFunction().getRows().size(); i++)
		{
			DynamicGridRow serviceRow = form.dyngrdServiceFunction().getRows().get(i);
			
    		if(serviceRow.getValue() instanceof HCPServiceFunctionVo)
    		{
    			HCPServiceFunctionVo inst = (HCPServiceFunctionVo) serviceRow.getValue();
    			inst.setIsActive(Boolean.TRUE.equals(Boolean.TRUE.equals(serviceRow.getCells().get(getColumn(COLUMN_CHECKBOX)).getValue())));
    			coll.add(inst);
    		}
    		else if(serviceRow.getValue() instanceof ServiceLiteVo && Boolean.TRUE.equals(Boolean.TRUE.equals(serviceRow.getCells().get(getColumn(COLUMN_CHECKBOX)).getValue())))
    		{
    			coll.add(createHcpServiceFunctionRecord((ServiceLiteVo) serviceRow.getValue(), null));
    		}
			
			for(int j=0; j<serviceRow.getRows().size(); j++)
			{
				DynamicGridRow childRow = serviceRow.getRows().get(j);
				
				if(Boolean.TRUE.equals(childRow.getCells().get(getColumn(COLUMN_CHECKBOX)).getValue()))
				{
					if(childRow.getValue() instanceof HCPServiceFunctionVo)
					{
						HCPServiceFunctionVo inst = (HCPServiceFunctionVo) childRow.getValue();
						inst.setIsActive(true);
						
						coll.add(inst);
					}
					else if(childRow.getValue() instanceof ServiceFunction)
					{
						ServiceLiteVo serv = null;
						if(serviceRow.getValue() instanceof ServiceLiteVo)
						{
							serv = (ServiceLiteVo) serviceRow.getValue();
						}
						else if(serviceRow.getValue() instanceof HCPServiceFunctionVo)
						{
							serv = ((HCPServiceFunctionVo) serviceRow.getValue()).getService();
						}
						coll.add(createHcpServiceFunctionRecord(serv, (ServiceFunction) childRow.getValue()));
					}
				}
				else
				{
					if(childRow.getValue() instanceof HCPServiceFunctionVo)
					{
						HCPServiceFunctionVo inst = (HCPServiceFunctionVo) childRow.getValue();
						inst.setIsActive(false);
						
						coll.add(inst);
					}
				}
			}
		}
		
		hcp.setServiceFunction(coll.size() > 0 ? coll : null);
		
		return hcp;
	}

	private HCPServiceFunctionVo createHcpServiceFunctionRecord(ServiceLiteVo service, ServiceFunction function)
	{
		HCPServiceFunctionVo record = new HCPServiceFunctionVo();
		
		record.setService(service);
		record.setFunction(function);
		record.setIsActive(true);
		
		return record;
	}

	@Override
	protected void onQmbServiceValueChanged() throws PresentationLogicException
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		if(FormMode.EDIT.equals(form.getMode()))
		{
			form.btnAddService().setEnabled(form.qmbService().getValue() != null);
		}
	}

	@Override
	protected void onQmbServiceTextSubmited(String value) throws PresentationLogicException
	{
		searchService(value);
		updateControlsState();
	}
	
	private void searchService(String value)
	{
		form.qmbService().clear();
		
		if(value == null)
			return;
		
		ServiceLiteVoCollection services = domain.listServices(value);
		
		if(services == null)
			return;
		
		for(ServiceLiteVo service : services)
		{
			if(service == null)
				continue;
			
			form.qmbService().newRow(service, service.getServiceName());
		}
		
		if(services.size() == 1)
		{
			form.qmbService().setValue(services.get(0));
		}
		else
		{
			form.qmbService().showOpened();
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	public Boolean isStale()
	{
		return Boolean.TRUE.equals(form.getLocalContext().getIsStale());
	}

	@Override
	protected void onBtnAddServiceClick() throws PresentationLogicException
	{
		addRow(null, form.qmbService().getValue());
		form.qmbService().clear();
		
		updateControlsState();
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.dyngrdServiceFunction().setHeaderHeight(50);
	}

	@Override
	protected void onDyngrdServiceFunctionCellValueChanged(DynamicGridCell cell)
	{
		if(cell.getColumn().equals(getColumn(COLUMN_SELECT_ALL_CHILDREN)))
		{
			if((cell.getRow().getValue() instanceof ServiceLiteVo) || (cell.getRow().getValue() instanceof HCPServiceFunctionVo))
			{
				checkChildren(cell.getRow(), Boolean.TRUE.equals(cell.getValue()), null);
			}
		}
		
		else if(cell.getColumn().equals(getColumn(COLUMN_CHECKBOX)))
		{
			if((cell.getRow().getValue() instanceof ServiceLiteVo) || (cell.getRow().getValue() instanceof HCPServiceFunctionVo))
			{
				DynamicGridCell cellSelectAll = cell.getRow().getCells().get(getColumn(COLUMN_SELECT_ALL_CHILDREN));
				
				if(cellSelectAll != null)
				{
					cellSelectAll.setReadOnly(!Boolean.TRUE.equals(cell.getValue()));
					cellSelectAll.setValue(null);
				}
				
				checkChildren(cell.getRow(), false, Boolean.TRUE.equals(cell.getValue()));
				
				if(cell.getRow().getParent() != null)
				{
					DynamicGridCell cellParentSelectAll = cell.getRow().getParent().getCells().get(getColumn(COLUMN_SELECT_ALL_CHILDREN));
					
					if(cellParentSelectAll != null)
					{
						cellParentSelectAll.setValue(areAllChildrenChecked(cell.getRow().getParent()));
					}
				}
			}
		}
	}

	private void checkChildren(DynamicGridRow row, boolean value, Boolean enableCell)
	{
		if(row == null || row.getRows().size() == 0)
			return;
		
		for(int i=0; i<row.getRows().size(); i++)
		{
			if(enableCell != null)
			{
				row.getRows().get(i).getCells().get(getColumn(COLUMN_CHECKBOX)).setReadOnly(!enableCell);
			}
			
			row.getRows().get(i).getCells().get(getColumn(COLUMN_CHECKBOX)).setValue(value);
		}
	}
}
