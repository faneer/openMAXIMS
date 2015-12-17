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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.forms.theatresessionmanagement;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbListTypeLookup();
	abstract protected void defaultcmbListTypeLookupValue();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnTheatreUtilisationDashboardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbListTypeValueSet(Object value);
	abstract protected void onLnkreturnToListClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbAddListOwnersClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcListOwnerValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrTabsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdSessionsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdSessionsCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onBtnMoveLocationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdSlotsCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdSlotsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkSelectAllValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnReOpenClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddSlotClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSessionCommentsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnMoveSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBlockSessionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDynCancelledApptsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
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
				bindLookups();
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
		this.form.btnTheatreUtilisationDashboard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnTheatreUtilisationDashboardClick();
			}
		});
		this.form.cmbListType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbListTypeValueSet(value);
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
		this.form.lyrTabs().tabCancelledAppointments().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabCancelledAppointmentsActivated();
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
		this.form.lyrTabs().tabExtendedView().btnMoveLocation().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMoveLocationClick();
			}
		});
		this.form.lyrTabs().tabExtendedView().dyngrdSlots().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdSlotsCellValueChanged(cell);
			}
		});
		this.form.lyrTabs().tabExtendedView().dyngrdSlots().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdSlotsRowSelectionChanged(row);
			}
		});
		this.form.lyrTabs().tabExtendedView().chkSelectAll().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkSelectAllValueChanged();
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
		this.form.lyrTabs().tabExtendedView().btnSessionComments().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSessionCommentsClick();
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
		this.form.lyrTabs().tabCancelledAppointments().dynCancelledAppts().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDynCancelledApptsRowSelectionChanged(row);
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
		this.form.getContextMenus().Scheduling.getSessionManagementUNBLOCKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.UNBLOCK, sender);
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
		this.form.getContextMenus().Scheduling.getSessionManagementBLOCK_SELECTED_SLOTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.BLOCK_SELECTED_SLOTS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementCANCEL_SELECTED_SLOTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.CANCEL_SELECTED_SLOTS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionManagementADD_SLOT_COMMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionManagement.ADD_SLOT_COMMENT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getCancelledApptsSessionManREBOOK_APPOINTMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.CancelledApptsSessionMan.REBOOK_APPOINTMENT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbListTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbListTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbListTypeLookupValue();
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
	private void onlyrTabstabCancelledAppointmentsActivated()
	{
		this.form.lyrTabs().showtabCancelledAppointments();
		onlyrTabsTabChanged(this.form.lyrTabs().tabCancelledAppointments());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
