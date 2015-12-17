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

package ims.therapies.forms.remedial;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbLocationLookup();
	abstract protected void defaultcmbLocationLookupValue();
	abstract protected void bindgrdMaterialColMaterialLookup();
	abstract protected void bindcmbActPositionLookup();
	abstract protected void defaultcmbActPositionLookupValue();
	abstract protected void bindcmbSeqLookup();
	abstract protected void defaultcmbSeqLookupValue();
	abstract protected void bindcmbActivityLookup();
	abstract protected void defaultcmbActivityLookupValue();
	abstract protected void bindcmbPatPositionLookup();
	abstract protected void defaultcmbPatPositionLookupValue();
	abstract protected void bindcmbIndependenceLookup();
	abstract protected void defaultcmbIndependenceLookupValue();
	abstract protected void bindcmbSubObLookup();
	abstract protected void defaultcmbSubObLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbAuthoringCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLocationValueSet(Object value);
	abstract protected void onGrdMaterialSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbActPositionValueSet(Object value);
	abstract protected void oncmbSeqValueSet(Object value);
	abstract protected void oncmbActivityValueSet(Object value);
	abstract protected void oncmbPatPositionValueSet(Object value);
	abstract protected void onBtnOkActivityClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelActivityClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIndependenceValueSet(Object value);
	abstract protected void oncmbSubObValueSet(Object value);
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdActivitySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabHeader().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrRemedialtabHeaderActivated();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrRemedialtabDetailsActivated();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabEmpty().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrRemedialtabEmptyActivated();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabHeader().qmbAuthoringHCP().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbAuthoringCPTextSubmited(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabHeader().cmbLocation().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLocationValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().grdMaterial().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMaterialSelectionChanged();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbActPosition().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbActPositionValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbSeq().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSeqValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbActivity().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbActivityValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbPatPosition().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPatPositionValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().btnOk().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOkActivityClick();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().btnClearActivity().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelActivityClick();
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbIndependence().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIndependenceValueSet(value);
			}
		});
		this.form.ctnRemedial().lyrRemedial().tabDetails().cmbSubOb().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSubObValueSet(value);
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
		this.form.grdActivity().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdActivitySelectionChanged();
			}
		});
		this.form.getContextMenus().getHcpGridADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HcpGrid.ADD, sender);
			}
		});
		this.form.getContextMenus().getHcpGridREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.HcpGrid.REMOVE, sender);
			}
		});
		this.form.getContextMenus().getGenericGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Add, sender);
			}
		});
		this.form.getContextMenus().getGenericGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getGenericGridRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Remove, sender);
			}
		});
		this.form.getContextMenus().getGenericGridViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.View, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getGenericGridReplaceItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Replace, sender);
			}
		});
		this.form.getContextMenus().getGenericGridConfirmItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Confirm, sender);
			}
		});
		this.form.getContextMenus().getGenericGridEDIT_VIEW_ICP_ACTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.EDIT_VIEW_ICP_ACTIONS, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbLocationLookup();
		bindgrdMaterialColMaterialLookup();
		bindcmbActPositionLookup();
		bindcmbSeqLookup();
		bindcmbActivityLookup();
		bindcmbPatPositionLookup();
		bindcmbIndependenceLookup();
		bindcmbSubObLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbLocationLookup();
		bindgrdMaterialColMaterialLookup();
		bindcmbActPositionLookup();
		bindcmbSeqLookup();
		bindcmbActivityLookup();
		bindcmbPatPositionLookup();
		bindcmbIndependenceLookup();
		bindcmbSubObLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbLocationLookupValue();
		defaultcmbActPositionLookupValue();
		defaultcmbSeqLookupValue();
		defaultcmbActivityLookupValue();
		defaultcmbPatPositionLookupValue();
		defaultcmbIndependenceLookupValue();
		defaultcmbSubObLookupValue();
	}
	private void onlyrRemedialtabHeaderActivated()
	{
		this.form.ctnRemedial().lyrRemedial().showtabHeader();
	}
	private void onlyrRemedialtabDetailsActivated()
	{
		this.form.ctnRemedial().lyrRemedial().showtabDetails();
	}
	private void onlyrRemedialtabEmptyActivated()
	{
		this.form.ctnRemedial().lyrRemedial().showtabEmpty();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
