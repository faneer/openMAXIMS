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

package ims.clinical.forms.edischargediagnosiscomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbCoMorbLookup();
	abstract protected void defaultcmbCoMorbLookupValue();
	abstract protected void bindcmbLateralityLookup();
	abstract protected void defaultcmbLateralityLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStartEDischargeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbCoMorbValueSet(Object value);
	abstract protected void oncmbLateralityValueSet(Object value);
	abstract protected void onCcClinicalTermValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupSelectionValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPrevoiusDiagnosesCoMorbiditesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPrevoiusDiagnosesCoMorbiditesGridCheckBoxClicked(int column, GenForm.grdPrevoiusDiagnosesCoMorbiditesRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDiagnosisComplicationsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDiagnosisComplicationsGridCheckBoxClicked(int column, GenForm.grdDiagnosisComplicationsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnStartEDischarge().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStartEDischargeClick();
			}
		});
		this.form.ctnDetails().cmbCoMorb().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCoMorbValueSet(value);
			}
		});
		this.form.ctnDetails().cmbLaterality().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLateralityValueSet(value);
			}
		});
		this.form.ctnDetails().setccClinicalTermValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcClinicalTermValueChanged();
			}
		});
		this.form.ctnDetails().GroupSelection().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupSelectionValueChanged();
			}
		});
		this.form.grdPrevoiusDiagnosesCoMorbidites().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPrevoiusDiagnosesCoMorbiditesSelectionChanged();
			}
		});
		this.form.grdPrevoiusDiagnosesCoMorbidites().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPrevoiusDiagnosesCoMorbiditesGridCheckBoxClicked(column, new GenForm.grdPrevoiusDiagnosesCoMorbiditesRow(row), isChecked);
			}
		});
		this.form.grdDiagnosisComplications().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDiagnosisComplicationsSelectionChanged();
			}
		});
		this.form.grdDiagnosisComplications().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDiagnosisComplicationsGridCheckBoxClicked(column, new GenForm.grdDiagnosisComplicationsRow(row), isChecked);
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
		this.form.getContextMenus().Clinical.getEDischargeDiagnosisMenuCOPYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EDischargeDiagnosisMenu.COPY, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.New, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.Edit, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.View, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryLinkingItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.Linking, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistorySupersedeItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.Supersede, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryRIEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.RIE, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryViewAllCDIItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.ViewAllCDI, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryViewAllUnlinkedCDIItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.ViewAllUnlinkedCDI, sender);
			}
		});
		this.form.getContextMenus().getPastMedicalHistoryViewAssociationsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PastMedicalHistory.ViewAssociations, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbCoMorbLookup();
		bindcmbLateralityLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbCoMorbLookup();
		bindcmbLateralityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbCoMorbLookupValue();
		defaultcmbLateralityLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
