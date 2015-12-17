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

package ims.scheduling.forms.sessiondetailsedit;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbConsMediaLookup();
	abstract protected void defaultcmbConsMediaLookupValue();
	abstract protected void bindgrdSlotscolPriorityLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbDoServiceTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbProfileTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrSessEditTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onBtnLocationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbConsMediaValueSet(Object value);
	abstract protected void onGrdListOwnerSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdListOwnerMutableComboBoxSelected(int column, GenForm.lyrSessEditLayer.tabListOwnersContainer.grdListOwnerRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdListOwnerGridQueryComboBoxTextSubmited(int column, GenForm.lyrSessEditLayer.tabListOwnersContainer.grdListOwnerRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDosGridCheckBoxClicked(int column, GenForm.lyrSessEditLayer.tabDosContainer.grdDosRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSlotsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdActivitiesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPCSlotsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTheatreSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTheatreGridCheckBoxClicked(int column, GenForm.lyrSessEditLayer.tabTheatreProceduresContainer.grdTheatreRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTheatreGridQueryComboBoxTextSubmited(int column, GenForm.lyrSessEditLayer.tabTheatreProceduresContainer.grdTheatreRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdBookRightsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdExclTimeSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSessionsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.qmbDoService().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbDoServiceTextSubmited(value);
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
		this.form.lyrSessEdit().tabGeneral().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabGeneralActivated();
			}
		});
		this.form.lyrSessEdit().tabListOwners().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabListOwnersActivated();
			}
		});
		this.form.lyrSessEdit().tabDos().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabDosActivated();
			}
		});
		this.form.lyrSessEdit().tabSlotDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabSlotDetailsActivated();
			}
		});
		this.form.lyrSessEdit().tabActivity().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabActivityActivated();
			}
		});
		this.form.lyrSessEdit().tabTheatreProcedures().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabTheatreProceduresActivated();
			}
		});
		this.form.lyrSessEdit().tabBookingRights().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabBookingRightsActivated();
			}
		});
		this.form.lyrSessEdit().tabExclusion().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSessEdittabExclusionActivated();
			}
		});
		this.form.lyrSessEdit().tabGeneral().btnLocation().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnLocationClick();
			}
		});
		this.form.lyrSessEdit().tabGeneral().cmbConsMedia().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbConsMediaValueSet(value);
			}
		});
		this.form.lyrSessEdit().tabListOwners().grdListOwner().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdListOwnerSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabListOwners().grdListOwner().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdListOwnerMutableComboBoxSelected(column, new GenForm.lyrSessEditLayer.tabListOwnersContainer.grdListOwnerRow(row), value);
			}
		});
		this.form.lyrSessEdit().tabListOwners().grdListOwner().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdListOwnerGridQueryComboBoxTextSubmited(column, new GenForm.lyrSessEditLayer.tabListOwnersContainer.grdListOwnerRow(row), text);
			}
		});
		this.form.lyrSessEdit().tabDos().grdDos().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDosGridCheckBoxClicked(column, new GenForm.lyrSessEditLayer.tabDosContainer.grdDosRow(row), isChecked);
			}
		});
		this.form.lyrSessEdit().tabSlotDetails().grdSlots().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSlotsSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabActivity().grdActivities().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdActivitiesSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabTheatreProcedures().lyrTheatre().tabPCSlots().grdPCSlots().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPCSlotsSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabTheatreProcedures().grdTheatre().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTheatreSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabTheatreProcedures().grdTheatre().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTheatreGridCheckBoxClicked(column, new GenForm.lyrSessEditLayer.tabTheatreProceduresContainer.grdTheatreRow(row), isChecked);
			}
		});
		this.form.lyrSessEdit().tabTheatreProcedures().grdTheatre().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTheatreGridQueryComboBoxTextSubmited(column, new GenForm.lyrSessEditLayer.tabTheatreProceduresContainer.grdTheatreRow(row), text);
			}
		});
		this.form.lyrSessEdit().tabBookingRights().grdBookRights().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdBookRightsSelectionChanged();
			}
		});
		this.form.lyrSessEdit().tabExclusion().grdExclTime().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdExclTimeSelectionChanged();
			}
		});
		this.form.grdSessions().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSessionsSelectionChanged();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
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
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsListOwnersADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsListOwners.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsListOwnersEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsListOwners.EDIT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsListOwnersREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsListOwners.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditSlotsADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditSlots.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditSlotsBLOCKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditSlots.BLOCK, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditSlotsCANCELItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditSlots.CANCEL, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditActivityADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditActivity.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditActivityREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditActivity.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditParentChildSlotsADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditParentChildSlots.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditParentChildSlotsSUSPENDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditParentChildSlots.SUSPEND, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditParentChildSlotsRELEASEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditParentChildSlots.RELEASE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditTheatreProceduresADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditTheatreProcedures.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditTheatreProceduresEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditTheatreProcedures.EDIT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditTheatreProceduresREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditTheatreProcedures.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsBookingRightsADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsBookingRights.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsBookingRightsEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsBookingRights.EDIT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsBookingRightsREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsBookingRights.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditExclusionTimesADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditExclusionTimes.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditExclusionTimesEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditExclusionTimes.EDIT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditExclusionTimesREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEditExclusionTimes.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getSessionDetailsEditEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.SessionDetailsEdit.EDIT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbConsMediaLookup();
		bindgrdSlotscolPriorityLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbConsMediaLookup();
		bindgrdSlotscolPriorityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbConsMediaLookupValue();
	}
	private void onlyrSessEdittabGeneralActivated()
	{
		this.form.lyrSessEdit().showtabGeneral();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabGeneral());
	}
	private void onlyrSessEdittabListOwnersActivated()
	{
		this.form.lyrSessEdit().showtabListOwners();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabListOwners());
	}
	private void onlyrSessEdittabDosActivated()
	{
		this.form.lyrSessEdit().showtabDos();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabDos());
	}
	private void onlyrSessEdittabSlotDetailsActivated()
	{
		this.form.lyrSessEdit().showtabSlotDetails();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabSlotDetails());
	}
	private void onlyrSessEdittabActivityActivated()
	{
		this.form.lyrSessEdit().showtabActivity();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabActivity());
	}
	private void onlyrSessEdittabTheatreProceduresActivated()
	{
		this.form.lyrSessEdit().showtabTheatreProcedures();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabTheatreProcedures());
	}
	private void onlyrSessEdittabBookingRightsActivated()
	{
		this.form.lyrSessEdit().showtabBookingRights();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabBookingRights());
	}
	private void onlyrSessEdittabExclusionActivated()
	{
		this.form.lyrSessEdit().showtabExclusion();
		onlyrSessEditTabChanged(this.form.lyrSessEdit().tabExclusion());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
