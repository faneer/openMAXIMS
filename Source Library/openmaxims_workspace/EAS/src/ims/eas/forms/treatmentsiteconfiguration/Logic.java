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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.treatmentsiteconfiguration;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.forms.treatmentsiteconfiguration.GenForm.ctnDetailsContainer.GroupYesNoEnumeration;
import ims.eas.forms.treatmentsiteconfiguration.GenForm.ctnDetailsContainer.grdScanLimitsRow;
import ims.eas.forms.treatmentsiteconfiguration.GenForm.grdTreatmentSiteRow;
import ims.eas.vo.TreatmentSitesVo;
import ims.eas.vo.TreatmentSitesVoCollection;
import ims.eas.vo.lookups.LookupHelper;
import ims.eas.vo.lookups.ScanLimits;
import ims.eas.vo.lookups.ScanLimitsCollection;
import ims.eas.vo.lookups.TreatmentSitesCollection;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//initalise();
		open();
	}

//	private void initalise()
//	{		
//
//		LookupService lookupService = domain.getLookupService();
//		
//		TreatmentSitesCollection lkpTreatmentSitesCollection =
//				(TreatmentSitesCollection) lookupService.getLookupCollection(TreatmentSites.TYPE_ID, 
//					TreatmentSitesCollection.class, TreatmentSites.class,true,false);
//		
//		form.cmbTreatmentSiteName().clear();
//		for (int i = 0; lkpTreatmentSitesCollection != null && i < lkpTreatmentSitesCollection.size(); i++)
//		{
//			if (lkpTreatmentSitesCollection.get(i).isActive())
//				form.cmbTreatmentSiteName().newRow(lkpTreatmentSitesCollection.get(i), lkpTreatmentSitesCollection.get(i).getText());
//			else
//				form.cmbTreatmentSiteName().newRow(lkpTreatmentSitesCollection.get(i), lkpTreatmentSitesCollection.get(i).getText(),Color.Red);
//		}
//		
//	}
	
	private void open()
	{
		form.setMode(FormMode.VIEW);
	}

	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		doSearch();
		
		if (form.getLocalContext().getSelectedTreatmentSite() != null)
		{
			form.grdTreatmentSite().setValue(form.getLocalContext().getSelectedTreatmentSite());
			
			if (form.grdTreatmentSite().getSelectedRow() == null)
			{
				form.getLocalContext().setSelectedTreatmentSite(null);
			}
			
			populateContainerDetails();
		}
		else
			clearContainer();

		form.setMode(FormMode.VIEW);
	}

	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		prepareForEdit();
	}

	private void prepareForEdit()
	{
		populateScanLimitsGridWithLookups();
		checkScanLimitsUsed();
		removePreactiveOrActiveLookup();
		form.setMode(FormMode.EDIT);
		form.ctnDetails().cmbStatus().setFocus();
	}

	private void checkScanLimitsUsed()
	{
		ScanLimitsCollection treatmentSiteScanLimits = form.getLocalContext().getSelectedTreatmentSite().getScanLimits();

		if (treatmentSiteScanLimits == null || treatmentSiteScanLimits.size() == 0)
		{
			return;
		}

		for (int i = 0; i < form.ctnDetails().grdScanLimits().getRows().size(); i++)
		{
			grdScanLimitsRow currentRow = form.ctnDetails().grdScanLimits().getRows().get(i);

			for (int j = 0; j < treatmentSiteScanLimits.size(); j++)
			{
				if (currentRow.getValue().getID() == treatmentSiteScanLimits.get(j).getID())
				{
					currentRow.setcolSelect(Boolean.TRUE);
				}

				if (form.getLocalContext().getSelectedTreatmentSite().getDefaultScanLimit() != null && currentRow.getValue().getID() == form.getLocalContext().getSelectedTreatmentSite().getDefaultScanLimit().getID())
				{
					currentRow.setcolDefault(Boolean.TRUE);
				}
			}
		}
	}

	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		clearContainer();
		form.getLocalContext().setSelectedTreatmentSite(null);
		form.grdTreatmentSite().setValue(null);
		form.ctnDetails().cmbStatus().setValue(PreActiveActiveInactiveStatus.PREACTIVE);

		populateTreatmentSiteComboWithoutActiveConfigs();
		populateScanLimitsGridWithLookups();
		removePreactiveOrActiveLookup();
		form.setMode(FormMode.EDIT);
	}

	private void populateTreatmentSiteComboWithoutActiveConfigs()
	{
		form.ctnDetails().cmbTreatmentSite().clear();
		TreatmentSitesCollection lkpTreatmentSitesCollection = LookupHelper.getTreatmentSites(domain.getLookupService());

		if (lkpTreatmentSitesCollection == null)
			return;

		TreatmentSitesVoCollection savedTreatmentSites = domain.getTreatmentSites(null, null);

		if (savedTreatmentSites != null && savedTreatmentSites.size() > 0)
		{
			for (int j = 0; savedTreatmentSites != null && j < savedTreatmentSites.size(); j++)
			{
				if (lkpTreatmentSitesCollection.contains(savedTreatmentSites.get(j).getTreatmentSite()))
				{
					lkpTreatmentSitesCollection.remove(savedTreatmentSites.get(j).getTreatmentSite());
				}
			}
		}

		for (int i = 0; lkpTreatmentSitesCollection != null && i < lkpTreatmentSitesCollection.size(); i++)
		{
			form.ctnDetails().cmbTreatmentSite().newRow(lkpTreatmentSitesCollection.get(i), lkpTreatmentSitesCollection.get(i).getText());
		}
		
	}

	private void populateScanLimitsGridWithLookups()
	{
		form.ctnDetails().grdScanLimits().getRows().clear();
		ScanLimitsCollection lkpScanLimitsCollection = LookupHelper.getScanLimits(domain.getLookupService());

		if (lkpScanLimitsCollection == null)
			return;

		for (int i = 0; i < lkpScanLimitsCollection.size(); i++)
		{
			grdScanLimitsRow newScanLimit = form.ctnDetails().grdScanLimits().getRows().newRow();
			newScanLimit.setcolName(lkpScanLimitsCollection.get(i).getText());
			newScanLimit.setcolDefault(Boolean.FALSE);
			newScanLimit.setcolSelect(Boolean.FALSE);
			newScanLimit.setValue(lkpScanLimitsCollection.get(i));
		}
	}

	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			searchAndSelect();
		}
	}

	private void searchAndSelect()
	{
		doSearch();
		form.grdTreatmentSite().setValue(form.getLocalContext().getSelectedTreatmentSite());

		if (form.grdTreatmentSite().getSelectedRow() == null)
		{
			form.getLocalContext().setSelectedTreatmentSite(null);
		}

		populateContainerDetails();
		form.setMode(FormMode.VIEW);
	}

	private boolean save()
	{
		TreatmentSitesVo treatmentSite = populateDataFromScreen(form.getLocalContext().getSelectedTreatmentSite());

		String[] errors = treatmentSite.validate(validateUiRules());

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		
		if (domain.checkAlreadyActive(treatmentSite))
		{
			engine.showMessage("A configuration for this Treatment Site already exists.");
			return false;
		}

		try
		{
			form.getLocalContext().setSelectedTreatmentSite(domain.saveTreatmentSite(treatmentSite));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			searchAndSelect();
			return false;
		}

		return true;
	}

	private String[] validateUiRules()
	{
		
		ArrayList<String> listOfErrors = new ArrayList<String>();
		
//		if (form.ctnDetails().cmbTreatmentSite().getValue() != null
//				&& !form.ctnDetails().cmbTreatmentSite().getValue().isActive())
//		{
//			listOfErrors.add("reatment Site is inactive, no edits allowed.");
//		}

		if (!(GroupYesNoEnumeration.rdoNo.equals(form.ctnDetails().GroupYesNo().getValue()) || GroupYesNoEnumeration.rdoYes.equals(form.ctnDetails().GroupYesNo().getValue())))
		{
			listOfErrors.add("Is Laterality relevant for this Treatment Site is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		return result;
	}

	private TreatmentSitesVo populateDataFromScreen(TreatmentSitesVo selectedTreatmentSite)
	{
		if (selectedTreatmentSite == null)
		{
			selectedTreatmentSite = new TreatmentSitesVo();
		}

		selectedTreatmentSite.setTreatmentSite(form.ctnDetails().cmbTreatmentSite().getValue());
		selectedTreatmentSite.setStatus(form.ctnDetails().cmbStatus().getValue());

		if (GroupYesNoEnumeration.rdoYes.equals(form.ctnDetails().GroupYesNo().getValue()))
		{
			selectedTreatmentSite.setLaterality(Boolean.TRUE);
		}
		else if (GroupYesNoEnumeration.rdoNo.equals(form.ctnDetails().GroupYesNo().getValue()))
		{
			selectedTreatmentSite.setLaterality(Boolean.FALSE);
		}

		//WDEV-17492
		if (form.ctnDetails().txtGraphic().getValue() == null)
			form.getGlobalContext().EAS.setTreatmentSiteConfig(null);
		
		selectedTreatmentSite.setAssessment(form.getGlobalContext().EAS.getTreatmentSiteConfig());
		selectedTreatmentSite.setScanLimits(getScanLimits());
		selectedTreatmentSite.setDefaultScanLimit(getDefaultScanLimit());

		return selectedTreatmentSite;
	}

	private ScanLimits getDefaultScanLimit()
	{
		ScanLimits scanLimits = new ScanLimits();

		for (int i = 0; i < form.ctnDetails().grdScanLimits().getRows().size(); i++)
		{
			grdScanLimitsRow row = form.ctnDetails().grdScanLimits().getRows().get(i);

			if (Boolean.TRUE.equals(row.getcolDefault()))
			{
				scanLimits = row.getValue();
				break;
			}
		}

		return scanLimits;
	}

	private ScanLimitsCollection getScanLimits()
	{
		ScanLimitsCollection scanLimitSelected = new ScanLimitsCollection();

		for (int i = 0; i < form.ctnDetails().grdScanLimits().getRows().size(); i++)
		{
			grdScanLimitsRow row = form.ctnDetails().grdScanLimits().getRows().get(i);

			if (Boolean.TRUE.equals(row.getcolSelect()))
			{
				scanLimitSelected.add(row.getValue());
			}
		}

		return scanLimitSelected;
	}

	
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Core.SelectGraphicalAssessment);
	}

	
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.ctnDetails().setCollapsed(form.grdTreatmentSite().getSelectedRow() == null && form.getMode().equals(FormMode.VIEW));
		form.ctnDetails().cmbTreatmentSite().setEnabled(form.getMode().equals(FormMode.EDIT) && PreActiveActiveInactiveStatus.PREACTIVE.equals(form.ctnDetails().cmbStatus().getValue()));

		form.btnEdit().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdTreatmentSite().getSelectedRow() != null);
		form.btnEdit().setEnabled(form.getMode().equals(FormMode.VIEW) && form.grdTreatmentSite().getSelectedRow() != null);
		
		//WDEV-16949
		form.ctnDetails().btnClear().setEnabled(form.getMode().equals(FormMode.EDIT) && form.ctnDetails().txtGraphic().getValue() != null); 

		form.getContextMenus().EAS.getTreatmentSiteConfigMenuNEWItem().setVisible(form.getMode().equals(FormMode.VIEW));
		form.getContextMenus().EAS.getTreatmentSiteConfigMenuNEWItem().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.getContextMenus().EAS.getTreatmentSiteConfigMenuEDITItem().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdTreatmentSite().getSelectedRow() != null);
		form.getContextMenus().EAS.getTreatmentSiteConfigMenuEDITItem().setEnabled(form.getMode().equals(FormMode.VIEW) && form.grdTreatmentSite().getSelectedRow() != null);
	}

	private void clearScreen()
	{
		form.cmbTreatmentSiteName().setValue(null);
		form.cmbStatusSearch().setValue(null);
		form.grdTreatmentSite().getRows().clear();
		clearContainer();
	}

	private void clearContainer()
	{
		form.ctnDetails().cmbTreatmentSite().setValue(null);
		form.ctnDetails().cmbStatus().setValue(null);
		form.ctnDetails().txtGraphic().setValue(null);
		form.ctnDetails().GroupYesNo().setValue(null);
		form.ctnDetails().grdScanLimits().getRows().clear();
	}

	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		doSearch();
	}

	private void doSearch()
	{
		populateTreatmentSiteGrid();
		clearContainer();
	}

	private void populateTreatmentSiteGrid()
	{
		form.grdTreatmentSite().getRows().clear();
		TreatmentSitesVoCollection treatmentSites = domain.getTreatmentSites(form.cmbTreatmentSiteName().getValue(), form.cmbStatusSearch().getValue());

		if (treatmentSites == null || treatmentSites.size() == 0)
		{
			form.getLocalContext().setSelectedTreatmentSite(null);
			engine.showMessage("No results found.");
		}

		for (int i = 0; i < treatmentSites.size(); i++)
		{
			grdTreatmentSiteRow newRow = form.grdTreatmentSite().getRows().newRow();
			newRow.setcolTreatmentSite(treatmentSites.get(i).getTreatmentSite().getText());
			newRow.setcolStatus(treatmentSites.get(i).getStatus().getText());
			newRow.setcolDate(treatmentSites.get(i).getSystemInformation().getLastupdateDateTime() != null ? treatmentSites.get(i).getSystemInformation().getLastupdateDateTime().toString() : treatmentSites.get(i).getSystemInformation().getCreationDateTime().toString());
			newRow.setValue(treatmentSites.get(i));
		}

		updateControlsState();
	}

	
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.SelectGraphicalAssessment) && DialogResult.OK.equals(result))
		{
			form.ctnDetails().txtGraphic().setValue(form.getGlobalContext().EAS.getTreatmentSiteConfig().getName());
			updateControlsState();//WDEV-16949
		}
	}

	
	protected void onGrdTreatmentSiteSelectionChanged() throws PresentationLogicException
	{
		form.getLocalContext().setSelectedTreatmentSite(form.grdTreatmentSite().getValue());
		populateTreatmentSiteCombo();
		populateContainerDetails();
		updateControlsState();
	}

	private void populateTreatmentSiteCombo()
	{
		form.ctnDetails().cmbTreatmentSite().clear();
		TreatmentSitesCollection lkpTreatmentSitesCollection = LookupHelper.getTreatmentSites(domain.getLookupService());

		if (lkpTreatmentSitesCollection == null)
			return;

		for (int i = 0; lkpTreatmentSitesCollection != null && i < lkpTreatmentSitesCollection.size(); i++)
		{
			form.ctnDetails().cmbTreatmentSite().newRow(lkpTreatmentSitesCollection.get(i), lkpTreatmentSitesCollection.get(i).getText());
		}
	}

	private void populateContainerDetails()
	{
		clearContainer();

		if (form.getLocalContext().getSelectedTreatmentSite() == null)
			return;

		TreatmentSitesVo updatedTreatmentSite = domain.getTreatmentSite(form.getLocalContext().getSelectedTreatmentSite().getID_TreatmentSites());
		form.getLocalContext().setSelectedTreatmentSite(updatedTreatmentSite);

		form.ctnDetails().cmbTreatmentSite().setValue(form.getLocalContext().getSelectedTreatmentSite().getTreatmentSite());
		form.ctnDetails().cmbStatus().setValue(form.getLocalContext().getSelectedTreatmentSite().getStatus());

		if (form.getLocalContext().getSelectedTreatmentSite().getAssessment() != null)
		{
			form.ctnDetails().txtGraphic().setValue(form.getLocalContext().getSelectedTreatmentSite().getAssessment().getName());
		}

		if (Boolean.TRUE.equals(form.getLocalContext().getSelectedTreatmentSite().getLaterality()))
		{
			form.ctnDetails().GroupYesNo().setValue(GroupYesNoEnumeration.rdoYes);
		}
		else
		{
			form.ctnDetails().GroupYesNo().setValue(GroupYesNoEnumeration.rdoNo);
		}

		populateScanLimitsGrid();
	}

	private void populateScanLimitsGrid()
	{
		ScanLimitsCollection scanLimitsCollection = form.getLocalContext().getSelectedTreatmentSite().getScanLimits();

		for (int i = 0; i < scanLimitsCollection.size(); i++)
		{
			grdScanLimitsRow newScanLimit = form.ctnDetails().grdScanLimits().getRows().newRow();
			newScanLimit.setcolName(scanLimitsCollection.get(i).getText());

			if (form.getLocalContext().getSelectedTreatmentSite().getDefaultScanLimit() != null && form.getLocalContext().getSelectedTreatmentSite().getDefaultScanLimit().equals(scanLimitsCollection.get(i)))
			{
				newScanLimit.setcolDefault(Boolean.TRUE);
			}

			newScanLimit.setcolSelect(Boolean.TRUE);
			newScanLimit.setValue(scanLimitsCollection.get(i));
		}

	}

	
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.EASNamespace.TreatmentSiteConfigMenu.NEW:
				newInstance();
				break;
			case GenForm.ContextMenus.EASNamespace.TreatmentSiteConfigMenu.EDIT:
				prepareForEdit();
				break;
		}
	}

	
	protected void onGrdScanLimitsGridCheckBoxClicked(int column, grdScanLimitsRow row, boolean isChecked) throws PresentationLogicException
	{
		if (column == 1 && isChecked)
		{
			resetDefaultRows(row);
			row.setcolSelect(Boolean.TRUE);
		}
		else if (column == 2 && (!isChecked) && Boolean.TRUE.equals(row.getcolDefault()))
		{
			row.setcolDefault(Boolean.FALSE);
		}
	}

	private void resetDefaultRows(grdScanLimitsRow selectedRow)
	{
		for (int i = 0; i < form.ctnDetails().grdScanLimits().getRows().size(); i++)
		{
			grdScanLimitsRow row = form.ctnDetails().grdScanLimits().getRows().get(i);

			if (row.getValue() != selectedRow.getValue())
			{
				row.setcolDefault(Boolean.FALSE);
			}
		}
	}

	private void removePreactiveOrActiveLookup()
	{
		PreActiveActiveInactiveStatus status = form.ctnDetails().cmbStatus().getValue();
		form.ctnDetails().cmbStatus().clear();

		PreActiveActiveInactiveStatusCollection lookupColl = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(domain.getLookupService());

		for (int i = 0; lookupColl != null && i < lookupColl.size(); i++)
		{
			if (isStatusActive() && lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE))
				continue;
			
			if (isStatusInactive() && lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE))
				continue;

			form.ctnDetails().cmbStatus().newRow(lookupColl.get(i), lookupColl.get(i).toString(), lookupColl.get(i).getImage(), lookupColl.get(i).getColor());
		}

		form.ctnDetails().cmbStatus().setValue(status);
	}

	private boolean isStatusActive()
	{
		TreatmentSitesVo treatmentSiteVo = form.getLocalContext().getSelectedTreatmentSite();
		return treatmentSiteVo != null && treatmentSiteVo.getStatusIsNotNull() && treatmentSiteVo.getStatus().equals(PreActiveActiveInactiveStatus.ACTIVE);
	}

	private boolean isStatusInactive()
	{
		TreatmentSitesVo treatmentSiteVo = form.getLocalContext().getSelectedTreatmentSite();
		return treatmentSiteVo != null && treatmentSiteVo.getStatusIsNotNull() && treatmentSiteVo.getStatus().equals(PreActiveActiveInactiveStatus.INACTIVE);
	}

	
	protected void onBtnClearClick() throws PresentationLogicException
	{
		form.ctnDetails().txtGraphic().setValue(null);
		form.getGlobalContext().EAS.setTreatmentSiteConfig(null);
		updateControlsState();
	}
}
