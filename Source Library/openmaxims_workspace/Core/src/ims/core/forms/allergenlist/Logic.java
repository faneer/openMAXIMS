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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.20 build 40803.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.allergenlist;

import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.admin.helper.Keywords;
import ims.core.forms.allergenlist.GenForm.grdAllergenRow;
import ims.core.forms.allergenlist.GenForm.grdExtCodesRow;
import ims.core.forms.allergenlist.GenForm.grdKeywordsRow;
import ims.core.vo.AllergenDetails;
import ims.core.vo.AllergenVo;
import ims.core.vo.AllergenVoCollection;
import ims.core.vo.KeywordVo;
import ims.core.vo.KeywordVoCollection;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}

	public void initialize()
	{
		form.setMode(FormMode.VIEW);
		form.txtSpecifySearch().setFocus();
		setContextMenuTexts();
	}	

	public void open()
	{
	}

	private void setContextMenuTexts()
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Taxonomy");		
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit Taxonomy");
		form.getContextMenus().getGenericGridRemoveItem().setText("Remove Taxonomy");
	}
	
	protected void onBtnCancelClick() 
	{
		clearInstanceControls();
		if (form.grdAllergen().getSelectedRow() != null)
		{
			setInstanceDetails(form.grdAllergen().getSelectedRow().getValue());
		}
		form.setMode(FormMode.VIEW);
	}
		
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		save();
	}
	
	private void setInstanceRowDetails(grdAllergenRow row, AllergenVo vo)
	{
		row.setcolAllergenName(vo.getAllergenName());
		
		if (vo.getAllergenType() != null)
			row.setcolAllergenType(vo.getAllergenType().getText());
		
		row.setValue(vo);			
		if (vo.getIsActiveIsNotNull() && !vo.getIsActive().booleanValue())
		{
			row.setBold(false);
			row.setTextColor(Color.Gray);
		}
		else
		{
			row.setBold(true);
			row.setTextColor(Color.Default);
		}	
	}

	private grdAllergenRow newInstanceRow(AllergenVo vo)
	{
		return newInstanceRow(vo, false);
	}
	
	private grdAllergenRow newInstanceRow(AllergenVo vo, boolean autoSelect)
	{
		grdAllergenRow row = form.grdAllergen().getRows().newRow(autoSelect);
		setInstanceRowDetails(row, vo);		
		return row;
	}
	
	protected void onBtnUpdateClick() 
	{
		updateInstance();
	}
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		newInstance();
	}
	
	protected void onGrdAllergenSelectionChanged() 
	{
		setInstanceDetails(form.grdAllergen().getValue());
	}

	private void setInstanceDetails(AllergenVo allergenDetail) 
	{
		clearInstanceControls();		
		if (allergenDetail == null)
			return;
		
		AllergenDetails allergenDetails = domain.getAllergenDetails(allergenDetail);		

		form.getLocalContext().setallergenDetails(allergenDetails);			
		form.txtAllergen().setValue(allergenDetails.getAllergenName());			
		form.cmbAllergenType().setValue(allergenDetails.getAllergenType());
			
		if (allergenDetails.getIsActive() != null)
			form.chkActive().setValue(allergenDetails.getIsActive().booleanValue());			
		
		TaxonomyMapCollection coll = allergenDetails.getTaxonomyMap();
		if (coll != null)
		{
			form.grdExtCodes().getRows().clear();
				
			GenForm.grdExtCodesRow row = null;
			for (int i=0; i < coll.size(); i++)
			{
				row = form.grdExtCodes().getRows().newRow();					
				row.setcolExtCodeType(coll.get(i).getTaxonomyName());					
				row.setcolCode(coll.get(i).getTaxonomyCode());					
				row.setValue(coll.get(i));
			}
		}
		KeywordVoCollection keys = allergenDetails.getKeywords();
		if (keys != null)
		{
			form.grdKeywords().getRows().clear();
				
			grdKeywordsRow row = null;
			for (int i=0; i < keys.size(); i++)
			{
				row = form.grdKeywords().getRows().newRow();					
				row.setKeyword(keys.get(i).getKeyword());					
				row.setValue(keys.get(i));
			}
		}		
		updateContextMenu();
	}

	private void updateContextMenu() 
	{
		updateControlsState();
	}

	protected void onBtnSearchClick() 
	{
		if (form.txtSpecifySearch().getValue() == null || form.txtSpecifySearch().getValue().length() < 3)
		{
			engine.showMessage("Please specify a search name of at least 3 characters");
			return;				
		}		
		listAllergies(form.txtSpecifySearch().getValue());
		updateContextMenu();
	}
	
	/**
	 * @param szSearchCriteria
	 */
	private void listAllergies(String szSearchCriteria) 
	{
		form.grdAllergen().getRows().clear();
		clearInstanceControls();
		
		AllergenVoCollection rcColl;
		try 
		{
			rcColl = domain.listAllAllergen(szSearchCriteria);
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}		
		if (rcColl.size() == 0) 
		{
			engine.showMessage("No matching Allergies found");
			return;
		}

		for (int i = 0; i< rcColl.size(); i++)
		{
			newInstanceRow(rcColl.get(i));
		}
		if (rcColl.size() == 1)
		{
			form.grdAllergen().setValue(rcColl.get(0));
			onGrdAllergenSelectionChanged();			
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if ( (formName.equals(form.getForms().Core.TaxonomySearch)) && (result.equals(DialogResult.OK)) )
		{
			if(form.getGlobalContext().Core.getTaxonomyMapIsNotNull())
			{
				TaxonomyMap voTaxonomyMap = form.getGlobalContext().Core.getTaxonomyMap();
				GenForm.grdExtCodesRow row = form.grdExtCodes().getRowByValue(voTaxonomyMap);
				if ((row == null) && (form.grdExtCodes().getSelectedRowIndex() >= 0))
					row = form.grdExtCodes().getRows().get(form.grdExtCodes().getSelectedRowIndex());
				else
				{
					engine.showMessage("Please select an External Code row and try again.");
					return;
				}
				
				populateTaxonomy(row, voTaxonomyMap);
					
				//Check if the user wants to change the name of the Procedure
				if(!voTaxonomyMap.getDescription().equals(form.txtAllergen().getValue()))
				{
					form.getGlobalContext().Core.setYesNoDialogMessage("Do you want to call the allergen - " + voTaxonomyMap.getDescription() + " ?");
					engine.open(form.getForms().Core.YesNoDialog);
				}
				updateContextMenu();
			}
		}
		
		else if ( (formName.equals(form.getForms().Core.YesNoDialog)) && (result.equals(DialogResult.YES)) )
		{
			//Change the name of the Procedure as the one from the Taxonomy Search
			form.txtAllergen().setValue(form.getGlobalContext().Core.getTaxonomyMap().getDescription());
			updateContextMenu();
		}		
	}
		
	protected void onGrdExtCodesSelectionChanged() throws PresentationLogicException
	{
		updateContextMenu();
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				addTaxonomy();					
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateTaxonomy();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeTaxonomy();			
				break;
			case GenForm.ContextMenus.KeywordAdmin.Add:
				addKeyword();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Remove:
				form.grdKeywords().removeSelectedRow();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveUp:
				form.grdKeywords().moveUp();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveDown:
				form.grdKeywords().moveDown();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.RemoveAll:
				form.grdKeywords().getRows().clear();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Restore:
				setDefaultKeywords();
				updateControlsState();
				break;				
			case GenForm.ContextMenus.KeywordAdmin.SnomedKeywords:
				addSnomedKeywords();
				updateControlsState();
				break;				
		}
		
	}
	
	private void setDefaultKeywords()
	{
		form.grdKeywords().getRows().clear();
		String[] keys = Keywords.generateKeywords(form.txtAllergen().getValue());
		for (int i = 0; i < keys.length; i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().newRow();
			row.setValue(new KeywordVo());
			row.setKeyword(keys[i]);
		}
	}

	private void addKeyword()
	{
		form.grdKeywords().getRows().newRow(true).setValue(new KeywordVo());
	}

	protected void onFormModeChanged() 
	{
		updateContextMenu();
		
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.txtAllergen().setEnabled(form.getLocalContext().getallergenDetailsIsNotNull() &&		
				form.getLocalContext().getallergenDetails().getID_Allergen() == null);
		}
	}
	
	private void addTaxonomy() 
	{
		form.grdExtCodes().getRows().newRow(true).setValue(new TaxonomyMap());
		updateContextMenu();
	}
	
	private void populateTaxonomy(GenForm.grdExtCodesRow row, TaxonomyMap voTaxonomyMap) 
	{
		if(row != null && voTaxonomyMap != null)
		{
			row.setcolExtCodeType(voTaxonomyMap.getTaxonomyName());
			row.setcolCode(voTaxonomyMap.getTaxonomyCode());
			row.setValue(voTaxonomyMap);
		}
	}
	
	private void updateTaxonomy() 
	{
		if (form.grdExtCodes().getSelectedRow() != null)
			taxonomySearch(form.grdExtCodes().getSelectedRow());
	}
	
	private void removeTaxonomy()
	{
		form.grdExtCodes().removeSelectedRow();
		updateContextMenu();
	}
	
	protected void onGrdExtCodesGridButtonClicked(int column, grdExtCodesRow row)
	{
		if(form.getMode().equals(FormMode.EDIT))
			taxonomySearch(row);
		
	}

	private void taxonomySearch(grdExtCodesRow row)
	{
		if(row.getcolExtCodeType() == null)
		{
			engine.showMessage("Please select External Code Type");
			return;
		}
				
		form.getGlobalContext().Core.setTaxonomySearchForName(form.txtAllergen().getValue());
		TaxonomyMap voTaxonomyMap = row.getValue();
		if(voTaxonomyMap == null)
			voTaxonomyMap = new TaxonomyMap();
		
		voTaxonomyMap.setTaxonomyName(row.getcolExtCodeType());
		voTaxonomyMap.setTaxonomyCode(row.getcolCode());
		
		form.getGlobalContext().Core.setTaxonomyMap(voTaxonomyMap);		
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	protected void onGrdKeywordsSelectionChanged() throws PresentationLogicException
	{
		updateContextMenu();
	}

	public void clearInstanceControls()
	{
		form.txtAllergen().setValue(null);
		form.cmbAllergenType().setValue(null);
		form.chkActive().setValue(false);
		form.grdExtCodes().getRows().clear();
		form.grdKeywords().getRows().clear();
	}

	public void newInstance() throws PresentationLogicException
	{
		String searchString = form.txtSpecifySearch().getValue();
		form.getLocalContext().setallergenDetails(new AllergenDetails());
		form.grdAllergen().setValue(null);
		clearInstanceControls();
		form.chkActive().setValue(true);	
		form.txtAllergen().setValue(searchString);
		if (form.grdAllergen().getRows().size() > 0)
			form.txtAllergen().setValue(null);
		form.txtAllergen().setFocus();
		form.setMode(FormMode.EDIT);
	}

	public boolean save() throws PresentationLogicException
	{
		AllergenDetails allergenDetails = form.getLocalContext().getallergenDetails();
		if (allergenDetails == null) allergenDetails = new AllergenDetails();

		allergenDetails.setAllergenName(form.txtAllergen().getValue());		
		allergenDetails.setIsActive(new Boolean(form.chkActive().getValue()));		
		allergenDetails.setAllergenType(form.cmbAllergenType().getValue());	
		
		TaxonomyMapCollection voCollTaxonomyMapCollection =  new TaxonomyMapCollection();
		for (int i = 0; i < form.grdExtCodes().getRows().size(); i++)
		{
			grdExtCodesRow row = form.grdExtCodes().getRows().get(i);
			TaxonomyMap voTaxonomyMap = row.getValue() != null?row.getValue():new TaxonomyMap();
			voTaxonomyMap.setTaxonomyCode(row.getcolCode());			
			voTaxonomyMap.setTaxonomyName(row.getcolExtCodeType());
			voCollTaxonomyMapCollection.add(voTaxonomyMap);
		}
		allergenDetails.setTaxonomyMap(voCollTaxonomyMapCollection);
		
		KeywordVoCollection coll =  new KeywordVoCollection();
		for (int i = 0; i < form.grdKeywords().getRows().size(); i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().get(i);
			KeywordVo vo = row.getValue();
			if (vo == null)
				vo = new KeywordVo();
			if (row.getKeyword() == null || row.getKeyword().equals(""))
				continue;
			
			vo.setKeyword(row.getKeyword());
			coll.add(vo);
		}
		allergenDetails.setKeywords(coll);
		
		String[] arrErrors = allergenDetails.validate();
		if(arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return false;
		}
		
		try
		{
			allergenDetails = domain.saveAllergenDetails(allergenDetails);
		} 
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			onBtnCancelClick();
			return false;
		} 
		catch(UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}

		grdAllergenRow row = form.grdAllergen().getRowByValue(allergenDetails);		
		if (row == null)
		{
			form.txtSpecifySearch().setValue(null);
			form.grdAllergen().getRows().clear();
			newInstanceRow(allergenDetails, true);
		}
		else
		{
			setInstanceRowDetails(row, allergenDetails);
		}
		form.setMode(FormMode.VIEW);
		setInstanceDetails(allergenDetails);		
		return true;
	}

	public void updateControlsState()
	{
		boolean editMode  = form.getMode().equals(FormMode.EDIT);
		boolean editable  = form.grdExtCodes().getValue() != null && editMode;
		boolean removable = form.grdExtCodes().getSelectedRowIndex()>=0 && editMode;
		
		form.getContextMenus().getGenericGridAddItem().setVisible(editMode);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(editable);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(removable);
		
		boolean keywordSelected = (form.grdKeywords().getSelectedRow() != null);
		form.getContextMenus().getKeywordAdminAddItem().setVisible(editMode);
		form.getContextMenus().getKeywordAdminMoveDownItem().setVisible(editMode && form.grdKeywords().canMoveCurrentDown());
		form.getContextMenus().getKeywordAdminMoveUpItem().setVisible(editMode && form.grdKeywords().canMoveCurrentUp());
		form.getContextMenus().getKeywordAdminRemoveAllItem().setVisible(editMode && form.grdKeywords().getRows().size() > 0);

		form.getContextMenus().getKeywordAdminSnomedKeywordsItem().setVisible(editMode && containsSnomedMapping());
		
		form.getContextMenus().getKeywordAdminRestoreItem().setVisible(editMode && form.txtAllergen().getValue() != null);
		if (form.getLocalContext().getallergenDetails() != null && form.getLocalContext().getallergenDetails().getID_Allergen() != null)
			form.getContextMenus().getKeywordAdminRestoreItem().setText("Restore defaults");
		else
			form.getContextMenus().getKeywordAdminRestoreItem().setText("Set to default");
		
		form.getContextMenus().getKeywordAdminRemoveItem().setVisible(editMode && keywordSelected);
		
		if(form.getMode().equals(FormMode.VIEW))
		{
			// sets the update button to be enabled if there is a record selected
			form.btnUpdate().setVisible(true);			
			form.btnUpdate().setEnabled(form.grdAllergen().getSelectedRow() != null);
		}		
	}

	private boolean containsSnomedMapping()
	{
		if (form.grdExtCodes().getRows().size() == 0)
			return false;
		
		for (int i = 0; i < form.grdExtCodes().getRows().size(); i++)
		{
			grdExtCodesRow row = form.grdExtCodes().getRows().get(i);
			
			if (row.getcolExtCodeType() != null && row.getcolExtCodeType().equals(TaxonomyType.SNOMED))
				return true;
		}
		return false;
	}

	private void addSnomedKeywords()
	{
		TaxonomyMap map = getSnomedMapping();
		if (map == null)
			return;
		
		KeywordVoCollection coll = domain.listSnomedKeywords(map.getTaxonomyCode());
		for (int i = 0; i < coll.size(); i++)
		{
			KeywordVo keyword = coll.get(i);
			if (!containsKeyword(keyword))
			{
				grdKeywordsRow row = form.grdKeywords().getRows().newRow();					
				row.setKeyword(coll.get(i).getKeyword());					
				row.setValue(coll.get(i));							
			}
		}		
	}

	private boolean containsKeyword(KeywordVo keyword)
	{
		if (form.grdKeywords().getRows().size() == 0)
			return false;
		
		for (int i = 0; i < form.grdKeywords().getRows().size(); i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().get(i);
			if (row.getKeyword().equals(keyword.getKeyword()))
				return true;
		}
		return false;
	}

	private TaxonomyMap getSnomedMapping()
	{
		if (form.grdExtCodes().getRows().size() == 0)
			return null;
		
		for (int i = 0; i < form.grdExtCodes().getRows().size(); i++)
		{
			grdExtCodesRow row = form.grdExtCodes().getRows().get(i);
			if (row.getcolExtCodeType().equals(TaxonomyType.SNOMED))
				return row.getValue();
		}
		return null;
	}

	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}
}
