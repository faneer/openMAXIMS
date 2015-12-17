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

package ims.eas.forms.eastreatmentoptionscomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdPhaseColumnPhaseLookup();
	abstract protected void bindgrdPhaseColumnModalityLookup();
	abstract protected void bindgrdPhaseColumnUnitsLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbPrimaryTumourValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbPrimaryTumourTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupReqValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkOffProtocolValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupPosValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTreatmentSiteSelChange() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbClinicalTrialValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OncmbProtocolSelChange() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OngrdPhaseSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OngrdPhaseSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPhaseMutableComboBoxSelected(int column, GenForm.grdPhaseRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPhaseGridCheckBoxClicked(int column, GenForm.grdPhaseRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.qmbPrimaryTumour().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbPrimaryTumourValueChanged();
			}
		});
		this.form.qmbPrimaryTumour().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbPrimaryTumourTextSubmited(value);
			}
		});
		this.form.GroupReq().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupReqValueChanged();
			}
		});
		this.form.chkOffProtocol().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkOffProtocolValueChanged();
			}
		});
		this.form.GroupPos().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupPosValueChanged();
			}
		});
		this.form.cmbTreatmentSite().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				oncmbTreatmentSiteSelChange();
			}
		});
		this.form.cmbClinicalTrial().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbClinicalTrialValueChanged();
			}
		});
		this.form.cmbProtocol().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OncmbProtocolSelChange();
			}
		});
		this.form.grdPhase().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				OngrdPhaseSelectionChanged();
			}
		});
		this.form.grdPhase().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OngrdPhaseSelectionCleared();
			}
		});
		this.form.grdPhase().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPhaseMutableComboBoxSelected(column, new GenForm.grdPhaseRow(row), value);
			}
		});
		this.form.grdPhase().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPhaseGridCheckBoxClicked(column, new GenForm.grdPhaseRow(row), isChecked);
			}
		});
		this.form.getContextMenus().EAS.getTreatmentOptionsPhaseMenuADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EASNamespace.TreatmentOptionsPhaseMenu.ADD, sender);
			}
		});
		this.form.getContextMenus().EAS.getTreatmentOptionsPhaseMenuREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EASNamespace.TreatmentOptionsPhaseMenu.REMOVE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdPhaseColumnPhaseLookup();
		bindgrdPhaseColumnModalityLookup();
		bindgrdPhaseColumnUnitsLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdPhaseColumnPhaseLookup();
		bindgrdPhaseColumnModalityLookup();
		bindgrdPhaseColumnUnitsLookup();
	}
	protected void defaultAllLookupValues()
	{
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
