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

package ims.correspondence.forms.glossaryadmin;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdGlossarycolCategoryLookup();
	abstract protected void bindgrdGlossaryProfilecolCategoryLookup();
	abstract protected void bindcmbProfileTypeLookup();
	abstract protected void defaultcmbProfileTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrGlossaryTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdGlossarySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdGlossaryProfileSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSpecConsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbProfileTypeValueSet(Object value);
	abstract protected void onCmbProfileTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.lyrGlossary().tabGlossaryDef().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrGlossarytabGlossaryDefActivated();
			}
		});
		this.form.lyrGlossary().tabGlossaryProfile().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrGlossarytabGlossaryProfileActivated();
			}
		});
		this.form.lyrGlossary().tabGlossaryDef().grdGlossary().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdGlossarySelectionChanged();
			}
		});
		this.form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdGlossaryProfileSelectionChanged();
			}
		});
		this.form.lyrGlossary().tabGlossaryProfile().grdSpecCons().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSpecConsSelectionChanged();
			}
		});
		this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbProfileTypeValueSet(value);
			}
		});
		this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbProfileTypeValueChanged();
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Add, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Update, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridDeleteItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Delete, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getGlossaryConsultantGridAddUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.GlossaryConsultantGrid.AddUpdate, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdGlossarycolCategoryLookup();
		bindgrdGlossaryProfilecolCategoryLookup();
		bindcmbProfileTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdGlossarycolCategoryLookup();
		bindgrdGlossaryProfilecolCategoryLookup();
		bindcmbProfileTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbProfileTypeLookupValue();
	}
	private void onlyrGlossarytabGlossaryDefActivated()
	{
		this.form.lyrGlossary().showtabGlossaryDef();
		onlyrGlossaryTabChanged(this.form.lyrGlossary().tabGlossaryDef());
	}
	private void onlyrGlossarytabGlossaryProfileActivated()
	{
		this.form.lyrGlossary().showtabGlossaryProfile();
		onlyrGlossaryTabChanged(this.form.lyrGlossary().tabGlossaryProfile());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
