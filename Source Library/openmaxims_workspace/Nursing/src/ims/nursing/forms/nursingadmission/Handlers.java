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

package ims.nursing.forms.nursingadmission;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbPreferredLangLookup();
	abstract protected void defaultcmbPreferredLangLookupValue();
	abstract protected void bindansDiagDiscussedLookup();
	abstract protected void defaultansDiagDiscussedLookupValue();
	abstract protected void bindgrdFamilyColRelationshipLookup();
	abstract protected void bindgrdFamilyColProgressLookup();
	abstract protected void bindansDNRCompleteLookup();
	abstract protected void defaultansDNRCompleteLookupValue();
	abstract protected void bindcmbResusStatus2Lookup();
	abstract protected void defaultcmbResusStatus2LookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPreferredLangValueSet(Object value);
	abstract protected void onansDiagDiscussedValueSet(Object value);
	abstract protected void onGrdFamilySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdFamilyGridComboBoxSelectionChanged(int column, GenForm.grdFamilyRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdFamilyGridCheckBoxClicked(int column, GenForm.grdFamilyRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDiagnosisSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansDNRCompleteValueSet(Object value);
	abstract protected void oncmbResusStatus2ValueSet(Object value);
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.cmbPreferredLang().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPreferredLangValueSet(value);
			}
		});
		this.form.ansDiagDiscussed().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansDiagDiscussedValueSet(value);
			}
		});
		this.form.grdFamily().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFamilySelectionChanged();
			}
		});
		this.form.grdFamily().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFamilyGridComboBoxSelectionChanged(column, new GenForm.grdFamilyRow(row), value);
			}
		});
		this.form.grdFamily().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFamilyGridCheckBoxClicked(column, new GenForm.grdFamilyRow(row), isChecked);
			}
		});
		this.form.grdDiagnosis().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDiagnosisSelectionChanged();
			}
		});
		this.form.ansDNRComplete().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansDNRCompleteValueSet(value);
			}
		});
		this.form.cmbResusStatus2().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbResusStatus2ValueSet(value);
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
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
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
		this.form.getContextMenus().getGenericGridCOPYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.COPY, sender);
			}
		});
		this.form.getContextMenus().getGenericGridREMOVE_UNVERIFIED_NHS_NUMBERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.REMOVE_UNVERIFIED_NHS_NUMBER, sender);
			}
		});
		this.form.getContextMenus().getAdmissionSummaryMenuVIEWDIAGNOSISItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdmissionSummaryMenu.VIEWDIAGNOSIS, sender);
			}
		});
		this.form.getContextMenus().getAdmissionSummaryMenuVIEWPROCEDUREItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdmissionSummaryMenu.VIEWPROCEDURE, sender);
			}
		});
		this.form.getContextMenus().getAdmissionSummaryMenuNEWDIAGNOSISItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdmissionSummaryMenu.NEWDIAGNOSIS, sender);
			}
		});
		this.form.getContextMenus().getAdmissionSummaryMenuNEWPROCEDUREItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdmissionSummaryMenu.NEWPROCEDURE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbPreferredLangLookup();
		bindansDiagDiscussedLookup();
		bindgrdFamilyColRelationshipLookup();
		bindgrdFamilyColProgressLookup();
		bindansDNRCompleteLookup();
		bindcmbResusStatus2Lookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbPreferredLangLookup();
		bindansDiagDiscussedLookup();
		bindgrdFamilyColRelationshipLookup();
		bindgrdFamilyColProgressLookup();
		bindansDNRCompleteLookup();
		bindcmbResusStatus2Lookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbPreferredLangLookupValue();
		defaultansDiagDiscussedLookupValue();
		defaultansDNRCompleteLookupValue();
		defaultcmbResusStatus2LookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
