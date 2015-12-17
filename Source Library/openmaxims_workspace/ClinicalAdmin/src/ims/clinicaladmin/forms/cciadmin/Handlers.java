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

package ims.clinicaladmin.forms.cciadmin;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbEndoscopyTypeLookup();
	abstract protected void defaultcmbEndoscopyTypeLookupValue();
	abstract protected void bindcmbProcGenderSpecificLookup();
	abstract protected void defaultcmbProcGenderSpecificLookupValue();
	abstract protected void bindcmbProcDefaultAnaesthTypeLookup();
	abstract protected void defaultcmbProcDefaultAnaesthTypeLookupValue();
	abstract protected void bindcmbHospitalCatLookup();
	abstract protected void defaultcmbHospitalCatLookupValue();
	abstract protected void bindcmbSurgeonCatLookup();
	abstract protected void defaultcmbSurgeonCatLookupValue();
	abstract protected void bindcmbTreatInterventionTypeLookup();
	abstract protected void defaultcmbTreatInterventionTypeLookupValue();
	abstract protected void bindgrdMappingscolExtCodeTypeLookup();
	abstract protected void bindgrdNUmappingscolExtCodeTypeLookup();
	abstract protected void bindcmbFrequencyLookup();
	abstract protected void defaultcmbFrequencyLookupValue();
	abstract protected void bindcmbAlgTypeLookup();
	abstract protected void defaultcmbAlgTypeLookupValue();
	abstract protected void bindcmbAnaesthetistCatLookup();
	abstract protected void defaultcmbAnaesthetistCatLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonrdoGrpValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbEndoscopyTypeValueSet(Object value);
	abstract protected void onChkEndoscopyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkProcBilateralListingValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkProcLateralityValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbProcGenderSpecificValueSet(Object value);
	abstract protected void oncmbProcDefaultAnaesthTypeValueSet(Object value);
	abstract protected void oncmbHospitalCatValueSet(Object value);
	abstract protected void oncmbSurgeonCatValueSet(Object value);
	abstract protected void oncmbTreatInterventionTypeValueSet(Object value);
	abstract protected void onGrdExtCodesGridButtonClicked(int column, GenForm.lyrDetailsLayer.tabMappingsContainer.grdMappingsRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdExtCodesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onNUGrdExtCodesGridButtonClicked(int column, GenForm.lyrDetailsLayer.tabNUMappingsContainer.grdNUmappingsRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onNUGrdExtCodesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdFRUCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdFRURowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbFrequencyValueSet(Object value);
	abstract protected void oncmbAlgTypeValueSet(Object value);
	abstract protected void oncmbAnaesthetistCatValueSet(Object value);
	abstract protected void onGrdItemsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.rdoGrp().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonrdoGrpValueChanged();
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
		this.form.cmbEndoscopyType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbEndoscopyTypeValueSet(value);
			}
		});
		this.form.chkEndoscopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkEndoscopyValueChanged();
			}
		});
		this.form.chkProcBilateralListing().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkProcBilateralListingValueChanged();
			}
		});
		this.form.chkProcLaterality().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkProcLateralityValueChanged();
			}
		});
		this.form.cmbProcGenderSpecific().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbProcGenderSpecificValueSet(value);
			}
		});
		this.form.cmbProcDefaultAnaesthType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbProcDefaultAnaesthTypeValueSet(value);
			}
		});
		this.form.cmbHospitalCat().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbHospitalCatValueSet(value);
			}
		});
		this.form.cmbSurgeonCat().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSurgeonCatValueSet(value);
			}
		});
		this.form.cmbTreatInterventionType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTreatInterventionTypeValueSet(value);
			}
		});
		this.form.lyrDetails().tabMappings().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabMappingsActivated();
			}
		});
		this.form.lyrDetails().tabNUMappings().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabNUMappingsActivated();
			}
		});
		this.form.lyrDetails().tabKeywords().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabKeywordsActivated();
			}
		});
		this.form.lyrDetails().tabHotlists().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabHotlistsActivated();
			}
		});
		this.form.lyrDetails().tabFRU().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabFRUActivated();
			}
		});
		this.form.lyrDetails().tabDefaultValues().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabDefaultValuesActivated();
			}
		});
		this.form.lyrDetails().tabMappings().grdMappings().setGridButtonClickedEvent(new GridButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdExtCodesGridButtonClicked(column, new GenForm.lyrDetailsLayer.tabMappingsContainer.grdMappingsRow(row));
			}
		});
		this.form.lyrDetails().tabMappings().grdMappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdExtCodesSelectionChanged();
			}
		});
		this.form.lyrDetails().tabNUMappings().grdNUmappings().setGridButtonClickedEvent(new GridButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onNUGrdExtCodesGridButtonClicked(column, new GenForm.lyrDetailsLayer.tabNUMappingsContainer.grdNUmappingsRow(row));
			}
		});
		this.form.lyrDetails().tabNUMappings().grdNUmappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onNUGrdExtCodesSelectionChanged();
			}
		});
		this.form.lyrDetails().tabFRU().dyngrdFRU().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdFRUCellValueChanged(cell);
			}
		});
		this.form.lyrDetails().tabFRU().dyngrdFRU().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdFRURowSelectionChanged(row);
			}
		});
		this.form.lyrDetails().tabDefaultValues().cmbFrequency().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbFrequencyValueSet(value);
			}
		});
		this.form.cmbAlgType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAlgTypeValueSet(value);
			}
		});
		this.form.cmbAnaesthetistCat().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAnaesthetistCatValueSet(value);
			}
		});
		this.form.grdItems().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdItemsSelectionChanged();
			}
		});
		this.form.btnSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSearchClick();
			}
		});
		this.form.getContextMenus().Admin.getTaxonomyGridAddTaxonomyItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdminNamespace.TaxonomyGrid.AddTaxonomy, sender);
			}
		});
		this.form.getContextMenus().Admin.getTaxonomyGridUpdateTaxonomyItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdminNamespace.TaxonomyGrid.UpdateTaxonomy, sender);
			}
		});
		this.form.getContextMenus().Admin.getTaxonomyGridRemoveTaxonomyItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AdminNamespace.TaxonomyGrid.RemoveTaxonomy, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.Add, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.Remove, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminRemoveAllItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.RemoveAll, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminRestoreItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.Restore, sender);
			}
		});
		this.form.getContextMenus().getKeywordAdminSnomedKeywordsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.KeywordAdmin.SnomedKeywords, sender);
			}
		});
		this.form.getContextMenus().getCciHotlistUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CciHotlist.Update, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuADDFORMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.ADDFORM, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuREMOVEFORMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.REMOVEFORM, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuADDROUTEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.ADDROUTE, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuREMOVEROUTEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.REMOVEROUTE, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuADDUNITSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.ADDUNITS, sender);
			}
		});
		this.form.getContextMenus().ClinicalAdmin.getMedicationFRUMenuREMOVEUNITSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalAdminNamespace.MedicationFRUMenu.REMOVEUNITS, sender);
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
	}
	protected void bindLookups()
	{
		bindcmbEndoscopyTypeLookup();
		bindcmbProcGenderSpecificLookup();
		bindcmbProcDefaultAnaesthTypeLookup();
		bindcmbHospitalCatLookup();
		bindcmbSurgeonCatLookup();
		bindcmbTreatInterventionTypeLookup();
		bindgrdMappingscolExtCodeTypeLookup();
		bindgrdNUmappingscolExtCodeTypeLookup();
		bindcmbFrequencyLookup();
		bindcmbAlgTypeLookup();
		bindcmbAnaesthetistCatLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbEndoscopyTypeLookup();
		bindcmbProcGenderSpecificLookup();
		bindcmbProcDefaultAnaesthTypeLookup();
		bindcmbHospitalCatLookup();
		bindcmbSurgeonCatLookup();
		bindcmbTreatInterventionTypeLookup();
		bindgrdMappingscolExtCodeTypeLookup();
		bindgrdNUmappingscolExtCodeTypeLookup();
		bindcmbFrequencyLookup();
		bindcmbAlgTypeLookup();
		bindcmbAnaesthetistCatLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbEndoscopyTypeLookupValue();
		defaultcmbProcGenderSpecificLookupValue();
		defaultcmbProcDefaultAnaesthTypeLookupValue();
		defaultcmbHospitalCatLookupValue();
		defaultcmbSurgeonCatLookupValue();
		defaultcmbTreatInterventionTypeLookupValue();
		defaultcmbFrequencyLookupValue();
		defaultcmbAlgTypeLookupValue();
		defaultcmbAnaesthetistCatLookupValue();
	}
	private void onlyrDetailstabMappingsActivated()
	{
		this.form.lyrDetails().showtabMappings();
	}
	private void onlyrDetailstabNUMappingsActivated()
	{
		this.form.lyrDetails().showtabNUMappings();
	}
	private void onlyrDetailstabKeywordsActivated()
	{
		this.form.lyrDetails().showtabKeywords();
	}
	private void onlyrDetailstabHotlistsActivated()
	{
		this.form.lyrDetails().showtabHotlists();
	}
	private void onlyrDetailstabFRUActivated()
	{
		this.form.lyrDetails().showtabFRU();
	}
	private void onlyrDetailstabDefaultValuesActivated()
	{
		this.form.lyrDetails().showtabDefaultValues();
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
