// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.booktheatreslot;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbAnaesTypeLookup();
	abstract protected void defaultcmbAnaesTypeLookupValue();
	abstract protected void bindcmbTheatreTypeLookup();
	abstract protected void defaultcmbTheatreTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAnaesTypeValueSet(Object value);
	abstract protected void onQmbProcedureValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbProcedureTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTheatreTypeValueSet(Object value);
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnERODClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreInvApptsTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewTheatreListOrderClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSelectedSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTheatreSessionSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.lyr1().tabSearch().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabSearchActivated();
			}
		});
		this.form.lyr1().tabReferral().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabReferralActivated();
			}
		});
		this.form.lyr1().tabSearch().cmbAnaesType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAnaesTypeValueSet(value);
			}
		});
		this.form.lyr1().tabSearch().qmbProcedure().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbProcedureValueChanged();
			}
		});
		this.form.lyr1().tabSearch().qmbProcedure().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbProcedureTextSubmited(value);
			}
		});
		this.form.lyr1().tabSearch().cmbTheatreType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTheatreTypeValueSet(value);
			}
		});
		this.form.lyr1().tabSearch().imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.lyr1().tabSearch().imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.lyr1().tabReferral().btnEROD().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnERODClick();
			}
		});
		this.form.lyr1().tabReferral().treInvAppts().setTreeViewSelectionChangedEvent(new TreeViewSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreInvApptsTreeViewSelectionChanged(node);
			}
		});
		this.form.btnViewTheatreListOrder().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewTheatreListOrderClick();
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
		this.form.grdSelected().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSelectedSelectionChanged();
			}
		});
		this.form.grdTheatreSession().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTheatreSessionSelectionChanged();
			}
		});
		this.form.getContextMenus().Scheduling.getBookTheatreSlotBOOKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.BookTheatreSlot.BOOK, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getBookTheatreSlotADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.BookTheatreSlot.ADD, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getBookTheatreSlotSUSPENDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.BookTheatreSlot.SUSPEND, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getBookTheatreSlotRELEASEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.BookTheatreSlot.RELEASE, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getBookTheatreSlotMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.BookTheatreSlot.MOVE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbAnaesTypeLookup();
		bindcmbTheatreTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbAnaesTypeLookup();
		bindcmbTheatreTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbAnaesTypeLookupValue();
		defaultcmbTheatreTypeLookupValue();
	}
	private void onlyr1tabSearchActivated()
	{
		this.form.lyr1().showtabSearch();
	}
	private void onlyr1tabReferralActivated()
	{
		this.form.lyr1().showtabReferral();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
