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

package ims.RefMan.forms.bookappointment;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbUrgencyLookup();
	abstract protected void defaultcmbUrgencyLookupValue();
	abstract protected void bindcmbListTypeLookup();
	abstract protected void defaultcmbListTypeLookupValue();
	abstract protected void bindgrdApptcolConsMediaLookup();
	abstract protected void bindgrdApptcolPatCategoryLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewTriageOutcomeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAllConsultationActivityBookedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdSessionSlotsCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdSessionSlotsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbUrgencyValueSet(Object value);
	abstract protected void onQmbListOwnerTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnLinkAppointmentsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbListTypeValueSet(Object value);
	abstract protected void onBtnERODClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOutpatientDashboardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreInvApptsTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDashboardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdApptSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbServiceValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbActivityValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBookingCalendarApptsDateSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBookingCalendarApptsMonthSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.btnViewTriageOutcome().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewTriageOutcomeClick();
			}
		});
		this.form.btnAllConsultationActivityBooked().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAllConsultationActivityBookedClick();
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
		this.form.dyngrdSessionSlots().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdSessionSlotsCellValueChanged(cell);
			}
		});
		this.form.dyngrdSessionSlots().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdSessionSlotsRowSelectionChanged(row);
			}
		});
		this.form.cmbUrgency().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUrgencyValueSet(value);
			}
		});
		this.form.qmbListOwner().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbListOwnerTextSubmited(value);
			}
		});
		this.form.btnLinkAppointments().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnLinkAppointmentsClick();
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
		this.form.btnEROD().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnERODClick();
			}
		});
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.btnOutpatientDashboard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOutpatientDashboardClick();
			}
		});
		this.form.treInvAppts().setTreeViewSelectionChangedEvent(new TreeViewSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreInvApptsTreeViewSelectionChanged(node);
			}
		});
		this.form.btnDashboard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDashboardClick();
			}
		});
		this.form.grdAppt().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdApptSelectionChanged();
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
		this.form.cmbService().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbServiceValueChanged();
			}
		});
		this.form.cmbActivity().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbActivityValueChanged();
			}
		});
		this.form.btnBook().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookClick();
			}
		});
		this.form.bookingCalendarAppts().setBookingCalendarDateSelectedEvent(new BookingCalendarDateSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				onBookingCalendarApptsDateSelected(date);
			}
		});
		this.form.bookingCalendarAppts().setBookingCalendarMonthSelectedEvent(new BookingCalendarMonthSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				onBookingCalendarApptsMonthSelected(date);
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
		this.form.getContextMenus().RefMan.getBookAppointmentAddSlotADD_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.BookAppointmentAddSlot.ADD_SLOT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getBookAppointmentAddSlotADD_FLEXIBLE_SLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.BookAppointmentAddSlot.ADD_FLEXIBLE_SLOT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getBookAppointmentREBOOK_APPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.BookAppointment.REBOOK_APPT, sender);
			}
		});
		this.form.getContextMenus().RefMan.getBookAppointmentCMREMOVE_APPOINTMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.RefManNamespace.BookAppointmentCM.REMOVE_APPOINTMENT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbUrgencyLookup();
		bindcmbListTypeLookup();
		bindgrdApptcolConsMediaLookup();
		bindgrdApptcolPatCategoryLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbUrgencyLookup();
		bindcmbListTypeLookup();
		bindgrdApptcolConsMediaLookup();
		bindgrdApptcolPatCategoryLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbUrgencyLookupValue();
		defaultcmbListTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
