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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.forms.eddepartmenttypeconfig;

import java.util.ArrayList;
import ims.admin.forms.eddepartmenttypeconfig.GenForm.grdDepartmentTypeRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.DefaultEDLocationDeptTypeVo;
import ims.emergency.vo.DefaultEDLocationDeptTypeVoCollection;
import ims.emergency.vo.lookups.EmergencyDeptType;
import ims.emergency.vo.lookups.EmergencyDeptTypeCollection;
import ims.emergency.vo.lookups.LookupHelper;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	private void clear()
	{
		form.grdDepartmentType().getRows().clear();
	}
	private void open()
	{
		clear();
		LocationLiteVoCollection locColl = domain.getLocations();
		DefaultEDLocationDeptTypeVoCollection defedlocColl = domain.getDefaultEDLocationDeptTypes();
		EmergencyDeptTypeCollection lkpEmergencyDeptTypeCollection  = getDefaultDeptType();
		if( locColl != null && locColl.size() > 0 )
		{
			for( LocationLiteVo locVo : locColl)
			{
				if( locVo != null )
				{
					addRow(locVo,defedlocColl,lkpEmergencyDeptTypeCollection);
				}
			}
		}
		form.setMode(FormMode.VIEW);
	}
	private EmergencyDeptTypeCollection getDefaultDeptType()
	{
		EmergencyDeptTypeCollection lkpEmergencyDeptTypeCollection = LookupHelper.getEmergencyDeptType(domain.getLookupService());
        return lkpEmergencyDeptTypeCollection;
	}
	private void addRow(LocationLiteVo locVo, DefaultEDLocationDeptTypeVoCollection defedlocColl, EmergencyDeptTypeCollection lkpEmergencyDeptTypeCollection)
	{
		if( locVo == null )
			return;
		
		DefaultEDLocationDeptTypeVo defaltEdVo = getSavedefaultEDLocationDeptTypeVoForLocation(locVo, defedlocColl);
		grdDepartmentTypeRow row = form.grdDepartmentType().getRows().newRow();
		row.setColumnEDLocation(locVo.getName());
		for( int i = 0; i < lkpEmergencyDeptTypeCollection.size();i++)
		{
			row.getColumnDepartmentType().newRow(lkpEmergencyDeptTypeCollection.get(i), lkpEmergencyDeptTypeCollection.get(i).getText());
		}
		
		if( defaltEdVo != null && defaltEdVo.getDefaultDeptTypeIsNotNull())
		{
			
			if( !lkpEmergencyDeptTypeCollection.contains(defaltEdVo.getDefaultDeptType()))
				row.getColumnDepartmentType().newRow(defaltEdVo.getDefaultDeptType(),defaltEdVo.getDefaultDeptType().getText());
			
			row.getColumnDepartmentType().setValue(defaltEdVo.getDefaultDeptType());
						
		}
		if( defaltEdVo == null )
		{
			defaltEdVo = new DefaultEDLocationDeptTypeVo();
			defaltEdVo.setLocation(locVo);
		}
		row.setValue(defaltEdVo);
		
		
	}
	
	private DefaultEDLocationDeptTypeVo getSavedefaultEDLocationDeptTypeVoForLocation(LocationLiteVo locVo, DefaultEDLocationDeptTypeVoCollection defedlocColl)
	{
		if( locVo == null) 
			return null;
		if( defedlocColl == null || defedlocColl.size() == 0 )
			return null;
			
		for( DefaultEDLocationDeptTypeVo defualtVo : defedlocColl )
		{
			 if( defualtVo != null )
			 {
				 if( locVo.getID_LocationIsNotNull() && defualtVo.getLocationIsNotNull() && defualtVo.getLocation().getID_LocationIsNotNull() && locVo.getID_Location().equals(defualtVo.getLocation().getID_Location()))
					 return defualtVo;
			 }
		}
		
		return null;
		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if( save())
			open();
	}
	
	private boolean save()
	{
		String[] uiErrors = getUiErrors();
		if (uiErrors != null && uiErrors.length > 0)
		{
			engine.showErrors(uiErrors);
			return false;
		}
		DefaultEDLocationDeptTypeVoCollection recordsColl = populateDataFromScreen();
		
		try
		{
			domain.saveDefaultEDLocationDeptType(recordsColl);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		
		return true;
	}
	private String[] getUiErrors()
	{
		String[] uiErrors = null;
		ArrayList uiErrorsList = new ArrayList();
		
		if( form.grdDepartmentType().getRows().size() == 0)
		{
			uiErrorsList.add("There are no ED Locations .");
		}
		
		for( int i = 0;i < form.grdDepartmentType().getRows().size();i++)
		{
			if( form.grdDepartmentType().getRows().get(i).getColumnDepartmentType().getValue() == null)
			{
				uiErrorsList.add("Department Type is mandatory for ED Location:" + form.grdDepartmentType().getRows().get(i).getColumnEDLocation());
			}
		}
		
		
		if(uiErrorsList.size() > 0)
		{
			uiErrors = new String[uiErrorsList.size()];
			uiErrorsList.toArray(uiErrors);
		}
		return uiErrors;
	}
	private DefaultEDLocationDeptTypeVoCollection populateDataFromScreen()
	{
		DefaultEDLocationDeptTypeVoCollection recordsColl = new DefaultEDLocationDeptTypeVoCollection();
		for( int i = 0;i < form.grdDepartmentType().getRows().size();i++)
		{
			DefaultEDLocationDeptTypeVo tempVo = form.grdDepartmentType().getRows().get(i).getValue();
			
			if( tempVo == null )
				tempVo = new DefaultEDLocationDeptTypeVo();
			
			tempVo.setDefaultDeptType((EmergencyDeptType)form.grdDepartmentType().getRows().get(i).getColumnDepartmentType().getValue());
			recordsColl.add(tempVo);
			
		}
		return recordsColl;
	}
	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	
	protected void onGrdDepartmentTypeGridComboBoxSelectionChanged(int column, grdDepartmentTypeRow row, Object value) throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
}
