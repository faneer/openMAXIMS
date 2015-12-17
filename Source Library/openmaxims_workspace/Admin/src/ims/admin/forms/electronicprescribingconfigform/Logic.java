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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.electronicprescribingconfigform;

import ims.admin.forms.electronicprescribingconfigform.GenForm.grdDetailsRow;
import ims.admin.vo.AppRoleShortVoCollection;
import ims.admin.vo.ElectronicPrescribingConfigVo;
import ims.admin.vo.ElectronicPrescribingConfigVoCollection;
import ims.core.vo.lookups.ElectronicPrescribingButton;
import ims.core.vo.lookups.ElectronicPrescribingButtonCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		form.grdDetails().getRows().clear();
		loadEPrescribingLookup();
		populateGrid(domain.listElectronicPrescribing());
		updateContextMenu();
	}
	
	private void populateGrid(ElectronicPrescribingConfigVoCollection listElectronicPrescribing)
	{
		if (listElectronicPrescribing == null)
			return;
			
		for (int i = 0 ; i < listElectronicPrescribing.size() ; i++)
		{
			for ( int j = 0 ; j < form.grdDetails().getRows().size() ; j++)
			{
				if (form.grdDetails().getRows().get(j).getValue() instanceof ElectronicPrescribingButton
					&& form.grdDetails().getRows().get(j).getValue().equals(listElectronicPrescribing.get(i).getButton()) )
				{
					grdDetailsRow row = form.grdDetails().getRows().get(j);
					row.setColButtonText(listElectronicPrescribing.get(i).getButtonText());
					row.setTooltipForColButtonText(listElectronicPrescribing.get(i).getButtonText());
					
					row.setColLabelText(listElectronicPrescribing.get(i).getLabelText());
					row.setTooltipForColLabelText(listElectronicPrescribing.get(i).getLabelText());
					
					row.setColExePath(listElectronicPrescribing.get(i).getButtonExecutablePath());
					row.setTooltipForColExePath(listElectronicPrescribing.get(i).getButtonExecutablePath());
					
					row.setColParameter(listElectronicPrescribing.get(i).getButtonParameter());
					row.setTooltipForColParameter(listElectronicPrescribing.get(i).getButtonParameter());
					
					row.setColRoles(createRolesText(listElectronicPrescribing.get(i).getButtonDeniedRoleAccess()));
					row.setTooltipForColRoles(createRolesText(listElectronicPrescribing.get(i).getButtonDeniedRoleAccess()));
					
					row.setValue(listElectronicPrescribing.get(i));
				}
			}
		}
	}

	private String createRolesText(AppRoleShortVoCollection buttonDeniedRoleAccess)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; i < buttonDeniedRoleAccess.size() ; i++)
		{
			sb.append(buttonDeniedRoleAccess.get(i).getName());
			if (i+1 < buttonDeniedRoleAccess.size())
				sb.append(", ");
		}
		return sb.toString();
	}

	private void loadEPrescribingLookup()
	{
		form.grdDetails().getRows().clear();
		ElectronicPrescribingButtonCollection lkpColl = LookupHelper.getElectronicPrescribingButton(domain.getLookupService());
		if (lkpColl != null)
		{
			for (int x=0; x < lkpColl.size(); x++)
			{
				grdDetailsRow row = form.grdDetails().getRows().newRow();
				row.setColButton(lkpColl.get(x).getText());
				row.setTooltipForColButton(lkpColl.get(x).getText());

				row.setValue(lkpColl.get(x));
			}
		}		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.AdminNamespace.ElectronicPrescribingMenu.EditButtonConfiguration:
				editConfig();
				break;
			case GenForm.ContextMenus.AdminNamespace.ElectronicPrescribingMenu.RemoveButtonConfiguration:
				removeConfig();
				break;
			case GenForm.ContextMenus.AdminNamespace.ElectronicPrescribingMenu.DenyRoleAccess:
				denyConfig();
				break;
		}
	}

	private void denyConfig()
	{
		if (form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo)
			form.getGlobalContext().Admin.setSelectedRoles(((ElectronicPrescribingConfigVo)form.grdDetails().getValue()).getButtonDeniedRoleAccess());
		
		engine.open(form.getForms().Admin.RoleSelect);
	}

	private void removeConfig()
	{
		engine.showMessage("Are you sure you want to remove this record?","Are You Sure", MessageButtons.YESNO, MessageIcon.QUESTION);
	}
	
	private void editConfig()
	{
		if (form.grdDetails().getValue() instanceof ElectronicPrescribingButton)
		{
			ElectronicPrescribingConfigVo voElect = new ElectronicPrescribingConfigVo();
			voElect.setButton((ElectronicPrescribingButton)form.grdDetails().getValue());
			form.getGlobalContext().Admin.setElectronicPrescribingConfigVo(voElect);
		}
		else if (form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo)
				form.getGlobalContext().Admin.setElectronicPrescribingConfigVo((ElectronicPrescribingConfigVo)form.grdDetails().getValue());
			
		engine.open(form.getForms().Admin.ElectronicPrescribingConfigDialog);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK)
			&& formName.equals(form.getForms().Admin.ElectronicPrescribingConfigDialog))
		{
			save();
		}
		else if(formName.equals(form.getForms().Admin.RoleSelect)
			&& result.equals(DialogResult.OK))
		{
			AppRoleShortVoCollection voRoles = form.getGlobalContext().Admin.getSelectedRoles();
			((ElectronicPrescribingConfigVo)form.grdDetails().getValue()).setButtonDeniedRoleAccess(new AppRoleShortVoCollection());
			for (int i = 0; voRoles != null  && i < voRoles.size(); i++)
			{
				if(form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo)
					((ElectronicPrescribingConfigVo)form.grdDetails().getValue()).getButtonDeniedRoleAccess().add(voRoles.get(i));
			}
			form.getGlobalContext().Admin.setElectronicPrescribingConfigVo(((ElectronicPrescribingConfigVo)form.grdDetails().getValue()));
			save();
		}

		open();
	}
	
	private void save()
	{
		String[] errors = form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}

		try
		{
			domain.saveElectronicPrescribingConfig(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
		}
	}

	@Override
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		updateContextMenu();
	}

	private void updateContextMenu()
	{
		form.getContextMenus().Admin.hideAllElectronicPrescribingMenuMenuItems();
		
		form.getContextMenus().Admin.getElectronicPrescribingMenuEditButtonConfigurationItem().setVisible(form.grdDetails().getValue() != null);
		form.getContextMenus().Admin.getElectronicPrescribingMenuRemoveButtonConfigurationItem().setVisible(form.grdDetails().getValue() != null && form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo);
		form.getContextMenus().Admin.getElectronicPrescribingMenuDenyRoleAccessItem().setVisible(form.grdDetails().getValue() != null && form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo);
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.YES)
			&& form.grdDetails().getValue() instanceof ElectronicPrescribingConfigVo)
		{
			ElectronicPrescribingConfigVo voEP = (ElectronicPrescribingConfigVo)form.grdDetails().getValue();
			String[] errors = voEP.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}

			try
			{
				domain.deleteElectronicPrescribingRecord(voEP);
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
			}
			open();
		}
	}
}
