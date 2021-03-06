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

package ims.scheduling.forms.sessionmanagement;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkreturnToListClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbAddListOwnersClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcListOwnerValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrTabsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdSessionsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdSessionsCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onBtnReOpenClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddSlotClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddCommentsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnMoveSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBlockSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSlotsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbProfileTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
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
		this.form.lnkreturnToList().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkreturnToListClick();
			}
		});
		this.form.imbAddListOwners().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbAddListOwnersClick();
			}
		});
		this.form.setccListOwnerValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcListOwnerValueChanged();
			}
		});
		this.form.lyrTabs().tabClinicView().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabClinicViewActivated();
			}
		});
		this.form.lyrTabs().tabAvailabilityView().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabAvailabilityViewActivated();
			}
		});
		this.form.lyrTabs().tabExtendedView().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabExtendedViewActivated();
			}
		});
		this.form.lyrTabs().tabClinicView().grdSessions().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSessionsSelectionChanged();
			}
		});
		this.form.lyrTabs().tabAvailabilityView().dyngrdSessions().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdSessionsCellButtonClicked(cell);
			}
		});
		this.form.lyrTabs().tabExtendedView().btnReOpen().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnReOpenClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().btnAddSlot().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddSlotClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().btnAddComments().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddCommentsClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().btnMoveSession().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMoveSessionClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().btnCancelSession().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelSessionClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().btnBlockSession().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBlockSessionClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().grdSlots().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSlotsSelectionChanged();
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.qmbProfile().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbProfileTextSubmited(value);
			}
		});
		this.form.cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementADD_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.ADD_SLOT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementREMOVE_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.REMOVE_SLOT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementCANCEL_APPOINTMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.CANCEL_APPOINTMENT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementREBOOK_APPOINTMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.REBOOK_APPOINTMENT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementADD_COMMENTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.ADD_COMMENTS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementDO_NOT_MOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.DO_NOT_MOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementBLOCK_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.BLOCK_SLOT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementCANCEL_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.CANCEL_SLOT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementREOPENItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.REOPEN, sender);
			}
		});
	}
	private void onlyrTabstabClinicViewActivated()
	{
		this.form.lyrTabs().showtabClinicView();
		onlyrTabsTabChanged(this.form.lyrTabs().tabClinicView());
	}
	private void onlyrTabstabAvailabilityViewActivated()
	{
		this.form.lyrTabs().showtabAvailabilityView();
		onlyrTabsTabChanged(this.form.lyrTabs().tabAvailabilityView());
	}
	private void onlyrTabstabExtendedViewActivated()
	{
		this.form.lyrTabs().showtabExtendedView();
		onlyrTabsTabChanged(this.form.lyrTabs().tabExtendedView());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
