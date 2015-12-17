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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.54 build 2699.23990)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.contextviewer;

import java.util.List;

import ims.admin.forms.contextviewer.GenForm.grdContextDataRow;
import ims.framework.ContextDescriptor;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.Color;
import ims.framework.utils.DecimalFormat;
import ims.framework.utils.beans.ColorBean;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		populateGrid();
	}
	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	private void populateGrid()
	{
		grdContextDataRow row = null;

		List<ContextDescriptor> persistentGlobalContext = engine.getPersistentGlobalContextVariablesInfo();
		if(persistentGlobalContext.size() > 0)
		{
			row = form.grdContextData().getRows().newRow();
			row.setColKey("Persistent Global Context");
			row.setBold(true);
			row.setBackColor(Color.LightCoral);
		}		
		
		ColorBean bean = new ColorBean(Color.LightCoral);
		bean.setValue("#FDE5E5");
		Color lighterColor = new Color(bean);
		String persistentGlobalContextTotalSize = displayContext(persistentGlobalContext, row, lighterColor);
		
		List<ContextDescriptor> globalContext = engine.getGlobalContextVariablesInfo();
		if(globalContext.size() > 0)
		{
			row = form.grdContextData().getRows().newRow();
			row.setColKey("Global Context");
			row.setBold(true);
			row.setBackColor(Color.LightPink);
		}		
		bean.setValue("#FFF1F3");
		lighterColor = new Color(bean);
		String globalContextTotalSize = displayContext(globalContext, row, lighterColor);
		
		List<ContextDescriptor> localContext = engine.getLocalContextVariablesInfo();
		if(localContext.size() > 0)
		{
			row = form.grdContextData().getRows().newRow();
			row.setBackColor(Color.LightBlue);
			row.setBold(true);
			row.setColKey("Local Context");
		}
		bean.setValue("#E8F6FA");
		lighterColor = new Color(bean);
		String localContextTotalSize = displayContext(localContext, row, lighterColor);
		
		displayFooter(localContextTotalSize, globalContextTotalSize, persistentGlobalContextTotalSize);		
	}
	
	private String displayContext(List<ContextDescriptor> context, grdContextDataRow parentRow, Color color)
	{
		if(parentRow == null || context == null || context.size() == 0)
			return null;
		
		parentRow.setExpanded(true);
		
		double total = 0;
		
		for (int i = 0; i < context.size(); i++)
		{
			grdContextDataRow row = parentRow.getRows().newRow();
			ContextDescriptor contextDescriptor = context.get(i);
			String key = contextDescriptor.getKey();
			key = key.substring(key.indexOf('.') + 1, key.length());
			//Remove __internal_x_context__
			if(key.indexOf("__internal_x_context__") >= 0)
			{
				key = key.replace("__internal_x_context__", "");
			}
			row.setColKey(key);
			row.setTooltipForColKey(key);
			row.setBackColor(color);
			
			String type = contextDescriptor.getType();
			type = type.replace("class", "");
			row.setColType(type);
			row.setTooltipForColType(type);
			
			double size = contextDescriptor.getSize();
			total += size;
			
			String sizeText = "";
			if(size < 1024)
			{
				sizeText = String.valueOf(size < 0 ? 0 : (int)size) + " bytes";
			}
			else if(size > 1024 && size < 1024*1024)
			{
				sizeText = String.valueOf(DecimalFormat.format(size/1024, 4, 2)) + " KB";
			}
			else if(size > 1024*1024)
			{
				sizeText = String.valueOf(DecimalFormat.format(size/(1024*1024), 6, 2)) + " MB";
			}
				
			row.setColSize(sizeText);
			row.setTooltipForColSize(sizeText);
			
			row.setColValue(contextDescriptor.getValue());
			row.setTooltipForColValue(contextDescriptor.getValue());
		}
		
		return String.valueOf(DecimalFormat.format(total/(1024), 6, 2)) + " KB";
	}
	
	private void displayFooter(String localContextTotalSize, String globalContextTotalSize, String persistentGlobalContextTotalSize)
	{
		String footer = "";
		
		if(persistentGlobalContextTotalSize != null)
		{
			if(footer.length() > 0)
				footer += "<br>";
			
			footer += "Persistent Global Context Size: " +  persistentGlobalContextTotalSize;
		}
		
		if(globalContextTotalSize != null)
		{
			if(footer.length() > 0)
				footer += "<br>";
			
			footer += "Global Context Size: " +  globalContextTotalSize;
		}
		
		if(localContextTotalSize != null)
		{			
			if(footer.length() > 0)
				footer += "<br>";
			
			footer += "Local Context Size: " +  localContextTotalSize;
		}		
		
		form.grdContextData().setFooterValue(footer);
	}
}
