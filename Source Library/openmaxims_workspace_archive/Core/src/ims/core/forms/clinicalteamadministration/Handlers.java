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

package ims.core.forms.clinicalteamadministration;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTeamTypeLookup();
	abstract protected void defaultcmbTeamTypeLookupValue();
	abstract protected void bindcmbSearchTeamTypeLookup();
	abstract protected void defaultcmbSearchTeamTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbTeamLeadTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTeamTypeValueSet(Object value);
	abstract protected void onBtnCancelDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCustomControlSearchHCPsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSearchTeamTypeValueSet(Object value);
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdHierarchySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.ctnDetails().lyrDetails().tabDetailsTeam().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabDetailsTeamActivated();
			}
		});
		this.form.ctnDetails().lyrDetails().tabMemberDisplay().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabMemberDisplayActivated();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsMembers().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabDetailsMembersActivated();
			}
		});
		this.form.ctnDetails().lyrDetails().tabNoDetailSelected().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabNoDetailSelectedActivated();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbTeamLeadTextSubmited(value);
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTeamTypeValueSet(value);
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsMembers().btnCancelDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelDetailsClick();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsMembers().btnOK().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOkClick();
			}
		});
		this.form.ctnDetails().lyrDetails().tabDetailsMembers().setcustomControlSearchHCPsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCustomControlSearchHCPsValueChanged();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.cmbSearchTeamType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSearchTeamTypeValueSet(value);
			}
		});
		this.form.imbSearchTeam().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.imbClearTeam().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.grdHierarchy().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdHierarchySelectionChanged();
			}
		});
		this.form.getContextMenus().getClinicalTeamNEW_TEAMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalTeam.NEW_TEAM, sender);
			}
		});
		this.form.getContextMenus().getClinicalTeamUPDATE_TEAMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalTeam.UPDATE_TEAM, sender);
			}
		});
		this.form.getContextMenus().getClinicalTeamNEW_MEMBERSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalTeam.NEW_MEMBERS, sender);
			}
		});
		this.form.getContextMenus().getClinicalTeamREMOVE_MEMBERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalTeam.REMOVE_MEMBER, sender);
			}
		});
		this.form.getContextMenus().getClinicalTeamUPDATE_MEMBERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalTeam.UPDATE_MEMBER, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTeamTypeLookup();
		bindcmbSearchTeamTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTeamTypeLookup();
		bindcmbSearchTeamTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTeamTypeLookupValue();
		defaultcmbSearchTeamTypeLookupValue();
	}
	private void onlyrDetailstabDetailsTeamActivated()
	{
		this.form.ctnDetails().lyrDetails().showtabDetailsTeam();
	}
	private void onlyrDetailstabMemberDisplayActivated()
	{
		this.form.ctnDetails().lyrDetails().showtabMemberDisplay();
	}
	private void onlyrDetailstabDetailsMembersActivated()
	{
		this.form.ctnDetails().lyrDetails().showtabDetailsMembers();
	}
	private void onlyrDetailstabNoDetailSelectedActivated()
	{
		this.form.ctnDetails().lyrDetails().showtabNoDetailSelected();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
