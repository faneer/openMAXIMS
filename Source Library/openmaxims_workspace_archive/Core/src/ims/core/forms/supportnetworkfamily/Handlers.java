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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.supportnetworkfamily;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbEmergencyLookup();
	abstract protected void defaultcmbEmergencyLookupValue();
	abstract protected void bindcmbRelationshipLookup();
	abstract protected void defaultcmbRelationshipLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCopyPAClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbEmergencyValueSet(Object value);
	abstract protected void oncmbRelationshipValueSet(Object value);
	abstract protected void onBtnReactivateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtongroupFilterValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridFamilySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBNewFamilyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateFamilyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnInactiveRecordFamClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveFamilyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelFamilyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnCopyPA().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCopyPAClick();
			}
		});
		this.form.ctnFamilySupport().cmbEmergency().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbEmergencyValueSet(value);
			}
		});
		this.form.ctnFamilySupport().cmbRelationship().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbRelationshipValueSet(value);
			}
		});
		this.form.btnReactivate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnReactivateClick();
			}
		});
		this.form.groupFilter().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtongroupFilterValueChanged();
			}
		});
		this.form.grdFamily().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridFamilySelectionChanged();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBNewFamilyClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateFamilyClick();
			}
		});
		this.form.btnInactive().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnInactiveRecordFamClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveFamilyClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelFamilyClick();
			}
		});
		this.form.getContextMenus().getSupportNetworkFamilyGridNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SupportNetworkFamilyGrid.New, sender);
			}
		});
		this.form.getContextMenus().getSupportNetworkFamilyGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SupportNetworkFamilyGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getSupportNetworkFamilyGridNewFromNextofkinItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SupportNetworkFamilyGrid.NewFromNextofkin, sender);
			}
		});
		this.form.getContextMenus().getSupportNetworkFamilyGridCOPY_ALL_PREVIOUS_FAMILYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SupportNetworkFamilyGrid.COPY_ALL_PREVIOUS_FAMILY, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbEmergencyLookup();
		bindcmbRelationshipLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbEmergencyLookup();
		bindcmbRelationshipLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbEmergencyLookupValue();
		defaultcmbRelationshipLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
