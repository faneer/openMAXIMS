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

package ims.ocrr.forms.myorder;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindcmbOrderCategoryLookup();
	abstract protected void defaultcmbOrderCategoryLookupValue();
	abstract protected void bindcmbPriorityLookup();
	abstract protected void defaultcmbPriorityLookupValue();
	abstract protected void bindcmbPatMobilityLookup();
	abstract protected void defaultcmbPatMobilityLookupValue();
	abstract protected void bindcmbDurationLookup();
	abstract protected void defaultcmbDurationLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOrderClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreeComponentsTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbResponsibleHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbOrderingHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnContinueClinicalClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSummaryClinicalInfoNextClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSummaryClinicalInfoPreviousClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtongrpPatientLocationValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviousGeneralClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnContinueGeneralClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdReportToCellTextSubmited(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdReportToCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdReportToRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbOrderPriorityClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbOrderCategoryValueSet(Object value);
	abstract protected void oncmbPriorityValueSet(Object value);
	abstract protected void onCmbPriorityValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbOrderedByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbClinicianTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbLocationValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbLocationTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkPrintLocalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviousRadClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnContinueRadClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPatMobilityValueSet(Object value);
	abstract protected void onBtnSitesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbRequestedTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTestGridButtonClicked(int column, GenForm.lyrDetailsLayer.tabPathDetailsContainer.lyrPathologyLayer.tabRequestedTestsContainer.grdTestRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTestSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTestMutableComboBoxSelected(int column, GenForm.lyrDetailsLayer.tabPathDetailsContainer.lyrPathologyLayer.tabRequestedTestsContainer.grdTestRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnApplyPhlenbOutPatClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnApplyPhlebInpatClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDteCollectValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDurationValueSet(Object value);
	abstract protected void onDyngrdPhlebCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onBtnApplyOtherClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnApplySpecAlreadyCollectedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnGenerateSpecimensClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviousPathologyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				// Checking lookups usage
				if(getLookupUsageErrors() != null && getLookupUsageErrors().length > 0)
					throw new ims.framework.exceptions.FormMandatoryLookupMissingException(ims.framework.exceptions.FormMandatoryLookupMissingException.getError(getLookupUsageErrors()));
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
		this.form.btnOrder().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOrderClick();
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
		this.form.treeComponents().setTreeViewSelectionChangedEvent(new TreeViewSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreeComponentsTreeViewSelectionChanged(node);
			}
		});
		this.form.lyrDetails().tabClinicalNotes().qmbResponsibleHCP().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbResponsibleHCPTextSubmited(value);
			}
		});
		this.form.lyrDetails().tabClinicalNotes().qmbOrderingHCP().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbOrderingHCPTextSubmited(value);
			}
		});
		this.form.lyrDetails().tabClinicalNotes().btnContinueClinical().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnContinueClinicalClick();
			}
		});
		this.form.lyrDetails().tabSummaryClinicalInfo().btnSummaryClinicalInfoNext().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSummaryClinicalInfoNextClick();
			}
		});
		this.form.lyrDetails().tabSummaryClinicalInfo().btnSummaryClinicalInfoPrevious().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSummaryClinicalInfoPreviousClick();
			}
		});
		this.form.lyrDetails().tabGenDetails().grpPatientLocation().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtongrpPatientLocationValueChanged();
			}
		});
		this.form.lyrDetails().tabGenDetails().btnPreviousGeneral().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviousGeneralClick();
			}
		});
		this.form.lyrDetails().tabGenDetails().btnContinueGeneral().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnContinueGeneralClick();
			}
		});
		this.form.lyrDetails().tabGenDetails().cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.lyrDetails().tabGenDetails().dyngrdReportTo().setDynamicGridCellTextSubmitedEvent(new DynamicGridCellTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdReportToCellTextSubmited(cell);
			}
		});
		this.form.lyrDetails().tabGenDetails().dyngrdReportTo().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdReportToCellValueChanged(cell);
			}
		});
		this.form.lyrDetails().tabGenDetails().dyngrdReportTo().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdReportToRowSelectionChanged(row);
			}
		});
		this.form.lyrDetails().tabGenDetails().imbOrderPriority().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbOrderPriorityClick();
			}
		});
		this.form.lyrDetails().tabGenDetails().cmbOrderCategory().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOrderCategoryValueSet(value);
			}
		});
		this.form.lyrDetails().tabGenDetails().cmbPriority().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPriorityValueSet(value);
			}
		});
		this.form.lyrDetails().tabGenDetails().cmbPriority().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbPriorityValueChanged();
			}
		});
		this.form.lyrDetails().tabGenDetails().qmbOrderedBy().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbOrderedByTextSubmited(value);
			}
		});
		this.form.lyrDetails().tabGenDetails().qmbClinician().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbClinicianTextSubmited(value);
			}
		});
		this.form.lyrDetails().tabGenDetails().qmbLocation().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbLocationValueChanged();
			}
		});
		this.form.lyrDetails().tabGenDetails().qmbLocation().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbLocationTextSubmited(value);
			}
		});
		this.form.lyrDetails().tabRadDetails().chkPrintLocal().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkPrintLocalValueChanged();
			}
		});
		this.form.lyrDetails().tabRadDetails().btnPreviousRad().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviousRadClick();
			}
		});
		this.form.lyrDetails().tabRadDetails().btnContinueRad().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnContinueRadClick();
			}
		});
		this.form.lyrDetails().tabRadDetails().cmbPatMobility().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPatMobilityValueSet(value);
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabRequestedTests().btnSites().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSitesClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabRequestedTests().cmbRequestedType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbRequestedTypeValueChanged();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabRequestedTests().grdTest().setGridButtonClickedEvent(new GridButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestGridButtonClicked(column, new GenForm.lyrDetailsLayer.tabPathDetailsContainer.lyrPathologyLayer.tabRequestedTestsContainer.grdTestRow(row));
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabRequestedTests().grdTest().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestSelectionChanged();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabRequestedTests().grdTest().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestMutableComboBoxSelected(column, new GenForm.lyrDetailsLayer.tabPathDetailsContainer.lyrPathologyLayer.tabRequestedTestsContainer.grdTestRow(row), value);
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().btnApplyPhlenbOutPat().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnApplyPhlenbOutPatClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().btnApplyPhlebInpat().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnApplyPhlebInpatClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().dteCollect().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteCollectValueChanged();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDurationValueSet(value);
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().dyngrdInpat().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPhlebCellValueChanged(cell);
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabOther().btnApplyOther().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnApplyOtherClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabSpecAlreadyCollected().btnApplySpecAlreadyCollected().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnApplySpecAlreadyCollectedClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().btnGenerateSpecimens().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnGenerateSpecimensClick();
			}
		});
		this.form.lyrDetails().tabPathDetails().btnPreviousPathology().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviousPathologyClick();
			}
		});
		this.form.getContextMenus().getOCRRMyOrderAddInvestigationADDINVESTIGATIONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderAddInvestigation.ADDINVESTIGATION, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderAddInvestigationREMOVEINVESTIGATIONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderAddInvestigation.REMOVEINVESTIGATION, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToADDMOSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.ADDMOS, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToADDGPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.ADDGP, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.Add, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.Remove, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToADDWARDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.ADDWARD, sender);
			}
		});
		this.form.getContextMenus().getOCRRMyOrderReportToADDOUTPATItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRMyOrderReportTo.ADDOUTPAT, sender);
			}
		});
		this.form.getContextMenus().getSelectItemsSELECTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SelectItems.SELECT, sender);
			}
		});
		this.form.getContextMenus().getSelectItemsLINKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SelectItems.LINK, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbOrderCategoryLookup();
		bindcmbPatMobilityLookup();
		bindcmbDurationLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbOrderCategoryLookup();
		bindcmbPriorityLookup();
		bindcmbPatMobilityLookup();
		bindcmbDurationLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbOrderCategoryLookupValue();
		defaultcmbPriorityLookupValue();
		defaultcmbPatMobilityLookupValue();
		defaultcmbDurationLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
