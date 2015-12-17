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

package ims.ocrr.forms.testedit;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindcmbGenderSpecificLookup();
	abstract protected void defaultcmbGenderSpecificLookupValue();
	abstract protected void bindcmbTurnAroundMeasureLookup();
	abstract protected void defaultcmbTurnAroundMeasureLookupValue();
	abstract protected void bindcmbMinReOrderFemaleLookup();
	abstract protected void defaultcmbMinReOrderFemaleLookupValue();
	abstract protected void bindcmbMinReOrderPeriodLookup();
	abstract protected void defaultcmbMinReOrderPeriodLookupValue();
	abstract protected void bindcmbTestStatusLookup();
	abstract protected void defaultcmbTestStatusLookupValue();
	abstract protected void bindcmbDurationLookup();
	abstract protected void defaultcmbDurationLookupValue();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupEventTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkNoInterfaceValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkRequiresSiteValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkNotResultedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkNotOrderableValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbColorValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onCmbCategoryValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbGenderSpecificValueSet(Object value);
	abstract protected void onGrdHeadersSelectionChanged(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTurnAroundMeasureValueSet(Object value);
	abstract protected void oncmbMinReOrderFemaleValueSet(Object value);
	abstract protected void onIntMinReOrderFemaleValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIntMinReOrderPeriodValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbMinReOrderPeriodValueSet(Object value);
	abstract protected void onChkAddOnValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkTestSeperateOrderValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTestStatusValueSet(Object value);
	abstract protected void onCmbProviderServiceValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbProviderValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIntNoOfSpecTypesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDurationValueSet(Object value);
	abstract protected void onGrdTestsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdQuestionsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTestHelpSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTestHelpGridComboBoxSelectionChanged(int column, GenForm.lyrInvestigationsLayer.tabHelpTextsContainer.grdTestHelpRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkReturnClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTaxonomySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSynonymsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSitesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

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
		this.form.GroupEventType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupEventTypeValueChanged();
			}
		});
		this.form.GroupType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupTypeValueChanged();
			}
		});
		this.form.chkNoInterface().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkNoInterfaceValueChanged();
			}
		});
		this.form.chkRequiresSite().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkRequiresSiteValueChanged();
			}
		});
		this.form.chkNotResulted().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkNotResultedValueChanged();
			}
		});
		this.form.chkNotOrderable().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkNotOrderableValueChanged();
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
		this.form.cmbColor().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbColorValueChanged();
			}
		});
		this.form.cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.cmbCategory().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbCategoryValueChanged();
			}
		});
		this.form.cmbGenderSpecific().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbGenderSpecificValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabProvider().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabProviderActivated();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabGeneralDetActivated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabPathologyDetailsActivated();
			}
		});
		this.form.lyrInvestigations().tabClinicalImagingDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabClinicalImagingDetailsActivated();
			}
		});
		this.form.lyrInvestigations().tabLinkedInvestigations().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabLinkedInvestigationsActivated();
			}
		});
		this.form.lyrInvestigations().tabQuestions().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabQuestionsActivated();
			}
		});
		this.form.lyrInvestigations().tabHelpTexts().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrInvestigationstabHelpTextsActivated();
			}
		});
		this.form.lyrInvestigations().tabProvider().grdHeaders().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdHeadersSelectionChanged(mouseButton);
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbTurnAroundMeasure().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTurnAroundMeasureValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbMinReOrderFemale().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMinReOrderFemaleValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().intMinReOrderFemale().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onIntMinReOrderFemaleValueChanged();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().intMinReOrderPeriod().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onIntMinReOrderPeriodValueChanged();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbMinReOrderPeriod().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMinReOrderPeriodValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().chkAddOn().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkAddOnValueChanged();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().chkTestSeperateOrder().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkTestSeperateOrderValueChanged();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbTestStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTestStatusValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbProviderService().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbProviderServiceValueChanged();
			}
		});
		this.form.lyrInvestigations().tabGeneralDet().cmbProvider().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbProviderValueChanged();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().intNoOfSpecTypes().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onIntNoOfSpecTypesValueChanged();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen1().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen1Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen2().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen2Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen3().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen3Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen4().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen4Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen5().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen5Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen6().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen6Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen7().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen7Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen8().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen8Activated();
			}
		});
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().tabSpecimen9().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSpecimenstabSpecimen9Activated();
			}
		});
		this.form.lyrInvestigations().tabClinicalImagingDetails().cmbDuration().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDurationValueSet(value);
			}
		});
		this.form.lyrInvestigations().tabLinkedInvestigations().grdTests().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestsSelectionChanged();
			}
		});
		this.form.lyrInvestigations().tabQuestions().grdQuestions().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdQuestionsSelectionChanged();
			}
		});
		this.form.lyrInvestigations().tabHelpTexts().grdTestHelp().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestHelpSelectionChanged();
			}
		});
		this.form.lyrInvestigations().tabHelpTexts().grdTestHelp().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTestHelpGridComboBoxSelectionChanged(column, new GenForm.lyrInvestigationsLayer.tabHelpTextsContainer.grdTestHelpRow(row), value);
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
		this.form.lnkReturn().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkReturnClick();
			}
		});
		this.form.lyrSelection().tabTax().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSelectiontabTaxActivated();
			}
		});
		this.form.lyrSelection().tabSyn().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSelectiontabSynActivated();
			}
		});
		this.form.lyrSelection().tabSites().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSelectiontabSitesActivated();
			}
		});
		this.form.lyrSelection().tabTax().grdTaxonomy().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTaxonomySelectionChanged();
			}
		});
		this.form.lyrSelection().tabSyn().grdSynonyms().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSynonymsSelectionChanged();
			}
		});
		this.form.lyrSelection().tabSites().grdSites().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSitesSelectionChanged();
			}
		});
		this.form.getContextMenus().getOCRRProviderADDNEWPROVIDERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRProvider.ADDNEWPROVIDER, sender);
			}
		});
		this.form.getContextMenus().getOCRRProviderUPDATEPROVIDERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRProvider.UPDATEPROVIDER, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedTestsASSOCIATEWITHItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedTests.ASSOCIATEWITH, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedTestsREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedTests.REMOVE, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedQuestionsADDQUESTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedQuestions.ADDQUESTIONS, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedQuestionsREMOVEQUESTIONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedQuestions.REMOVEQUESTION, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedQuestionsMOVEUPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedQuestions.MOVEUP, sender);
			}
		});
		this.form.getContextMenus().getOCRRAssociatedQuestionsMOVEDOWNItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRAssociatedQuestions.MOVEDOWN, sender);
			}
		});
		this.form.getContextMenus().getOCRRHelpTextADD_HELPTEXTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRHelpText.ADD_HELPTEXT, sender);
			}
		});
		this.form.getContextMenus().getOCRRHelpTextREMOVE_HELPTEXTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRHelpText.REMOVE_HELPTEXT, sender);
			}
		});
		this.form.getContextMenus().getOCRRTaxonomyADD_TAXONOMYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRTaxonomy.ADD_TAXONOMY, sender);
			}
		});
		this.form.getContextMenus().getOCRRTaxonomyREMOVE_TAXONOMYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRTaxonomy.REMOVE_TAXONOMY, sender);
			}
		});
		this.form.getContextMenus().getOCRRSynonymsADD_SYNONYMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSynonyms.ADD_SYNONYM, sender);
			}
		});
		this.form.getContextMenus().getOCRRSynonymsREMOVE_SYNONYMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSynonyms.REMOVE_SYNONYM, sender);
			}
		});
		this.form.getContextMenus().getOCRRSpecimenSiteMOVE_UPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSpecimenSite.MOVE_UP, sender);
			}
		});
		this.form.getContextMenus().getOCRRSpecimenSiteMOVE_DOWNItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSpecimenSite.MOVE_DOWN, sender);
			}
		});
		this.form.getContextMenus().getOCRRSpecimenSiteSELECT_SITESItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSpecimenSite.SELECT_SITES, sender);
			}
		});
		this.form.getContextMenus().getOCRRSpecimenSiteSORTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OCRRSpecimenSite.SORT, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbStatusLookup();
		bindcmbGenderSpecificLookup();
		bindcmbTurnAroundMeasureLookup();
		bindcmbMinReOrderFemaleLookup();
		bindcmbMinReOrderPeriodLookup();
		bindcmbTestStatusLookup();
		bindcmbDurationLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbStatusLookup();
		bindcmbGenderSpecificLookup();
		bindcmbTurnAroundMeasureLookup();
		bindcmbMinReOrderFemaleLookup();
		bindcmbMinReOrderPeriodLookup();
		bindcmbTestStatusLookup();
		bindcmbDurationLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbStatusLookupValue();
		defaultcmbGenderSpecificLookupValue();
		defaultcmbTurnAroundMeasureLookupValue();
		defaultcmbMinReOrderFemaleLookupValue();
		defaultcmbMinReOrderPeriodLookupValue();
		defaultcmbTestStatusLookupValue();
		defaultcmbDurationLookupValue();
	}
	private void onlyrInvestigationstabProviderActivated()
	{
		this.form.lyrInvestigations().showtabProvider();
	}
	private void onlyrInvestigationstabGeneralDetActivated()
	{
		this.form.lyrInvestigations().showtabGeneralDet();
	}
	private void onlyrInvestigationstabPathologyDetailsActivated()
	{
		this.form.lyrInvestigations().showtabPathologyDetails();
	}
	private void onlyrInvestigationstabClinicalImagingDetailsActivated()
	{
		this.form.lyrInvestigations().showtabClinicalImagingDetails();
	}
	private void onlyrInvestigationstabLinkedInvestigationsActivated()
	{
		this.form.lyrInvestigations().showtabLinkedInvestigations();
	}
	private void onlyrInvestigationstabQuestionsActivated()
	{
		this.form.lyrInvestigations().showtabQuestions();
	}
	private void onlyrInvestigationstabHelpTextsActivated()
	{
		this.form.lyrInvestigations().showtabHelpTexts();
	}
	private void onlyrSpecimenstabSpecimen1Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen1();
	}
	private void onlyrSpecimenstabSpecimen2Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen2();
	}
	private void onlyrSpecimenstabSpecimen3Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen3();
	}
	private void onlyrSpecimenstabSpecimen4Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen4();
	}
	private void onlyrSpecimenstabSpecimen5Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen5();
	}
	private void onlyrSpecimenstabSpecimen6Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen6();
	}
	private void onlyrSpecimenstabSpecimen7Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen7();
	}
	private void onlyrSpecimenstabSpecimen8Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen8();
	}
	private void onlyrSpecimenstabSpecimen9Activated()
	{
		this.form.lyrInvestigations().tabPathologyDetails().lyrSpecimens().showtabSpecimen9();
	}
	private void onlyrSelectiontabTaxActivated()
	{
		this.form.lyrSelection().showtabTax();
	}
	private void onlyrSelectiontabSynActivated()
	{
		this.form.lyrSelection().showtabSyn();
	}
	private void onlyrSelectiontabSitesActivated()
	{
		this.form.lyrSelection().showtabSites();
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
