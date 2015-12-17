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

package ims.eas.forms.primarytumourconfiguration;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbPrimaryTumourNameLookup();
	abstract protected void defaultcmbPrimaryTumourNameLookupValue();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindcmbStatusSearchLookup();
	abstract protected void defaultcmbStatusSearchLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPrimaryTumourNameValueSet(Object value);
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrPrimaryTumourTabChanged(ims.framework.LayerBridge tab);
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onGrdAgentsGridCheckBoxClicked(int column, GenForm.ctnDetailsContainer.lyrPrimaryTumourLayer.tabTumourDetailsContainer.grdAgentsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdClinicalTrialsCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onGrdTumourConfigSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusSearchValueSet(Object value);
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
				onFormOpen(args);
			}
		});
		this.form.cmbPrimaryTumourName().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPrimaryTumourNameValueSet(value);
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
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.ctnDetails().lyrPrimaryTumour().tabTumourDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPrimaryTumourtabTumourDetailsActivated();
			}
		});
		this.form.ctnDetails().lyrPrimaryTumour().tabClinicalTrials().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPrimaryTumourtabClinicalTrialsActivated();
			}
		});
		this.form.ctnDetails().lyrPrimaryTumour().tabTumourDetails().cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.ctnDetails().lyrPrimaryTumour().tabTumourDetails().grdAgents().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAgentsGridCheckBoxClicked(column, new GenForm.ctnDetailsContainer.lyrPrimaryTumourLayer.tabTumourDetailsContainer.grdAgentsRow(row), isChecked);
			}
		});
		this.form.ctnDetails().lyrPrimaryTumour().tabClinicalTrials().dyngrdClinicalTrials().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdClinicalTrialsCellValueChanged(cell);
			}
		});
		this.form.grdTumourConfig().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTumourConfigSelectionChanged();
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
		this.form.cmbStatusSearch().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusSearchValueSet(value);
			}
		});
		this.form.getContextMenus().EAS.getPrimaryTumourConfigMenuNEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EASNamespace.PrimaryTumourConfigMenu.NEW, sender);
			}
		});
		this.form.getContextMenus().EAS.getPrimaryTumourConfigMenuEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EASNamespace.PrimaryTumourConfigMenu.EDIT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbPrimaryTumourNameLookup();
		bindcmbStatusLookup();
		bindcmbStatusSearchLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbPrimaryTumourNameLookup();
		bindcmbStatusLookup();
		bindcmbStatusSearchLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbPrimaryTumourNameLookupValue();
		defaultcmbStatusLookupValue();
		defaultcmbStatusSearchLookupValue();
	}
	private void onlyrPrimaryTumourtabTumourDetailsActivated()
	{
		this.form.ctnDetails().lyrPrimaryTumour().showtabTumourDetails();
		onlyrPrimaryTumourTabChanged(this.form.ctnDetails().lyrPrimaryTumour().tabTumourDetails());
	}
	private void onlyrPrimaryTumourtabClinicalTrialsActivated()
	{
		this.form.ctnDetails().lyrPrimaryTumour().showtabClinicalTrials();
		onlyrPrimaryTumourTabChanged(this.form.ctnDetails().lyrPrimaryTumour().tabClinicalTrials());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
