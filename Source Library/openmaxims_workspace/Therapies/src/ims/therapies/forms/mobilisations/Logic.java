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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.39 build 2173.22508)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.mobilisations;

import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.MobilisationsTreatment;
import ims.therapies.forms.mobilisations.GenForm.grdTreatmentsRow;
import ims.therapies.vo.MobilisationsShortVo;
import ims.therapies.vo.MobilisationsShortVoCollection;
import ims.therapies.vo.MobilisationsTreatmentVo;
import ims.therapies.vo.MobilisationsTreatmentVoCollection;
import ims.therapies.vo.MobilisationsVo;


public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	
	private void initialize()
	{
		form.ctnMob().setCollapsed(true);
		form.ctnMob().lyrMob().tabEmpty().setHeaderVisible(false);
	}
	private void open()
	{
		clear();
		resetContextVariables();		
							
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			populateParentNodes(domain.listByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));			
		}
									
		form.setMode(FormMode.VIEW);
		reselectUpdatedNode();
	}
	private void populateParentNodes(MobilisationsShortVoCollection voMobilisationsShortColl)
	{
		if (voMobilisationsShortColl == null || voMobilisationsShortColl.size() <= 0 ) return;
		
		for(int i=0; i<voMobilisationsShortColl.size(); i++)
		{
			populateParentNode(voMobilisationsShortColl.get(i));			
		}		
	}
	
	private void reselectUpdatedNode()
	{
		//Pattern demands that the last updated node is displayed
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdTreatments().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
	}

	private void populateParentNode(MobilisationsShortVo voMobilisationsShort)
	{
		GenForm.grdTreatmentsRow parRow = form.grdTreatments().getRows().newRow();
		parRow.setColTreatment(voMobilisationsShort.getAuthoringDateTime().toString()+ " - " + voMobilisationsShort.getAuthoringCP().toString());
		parRow.setValue(voMobilisationsShort);		
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && voMobilisationsShort.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			form.grdTreatments().setValue(voMobilisationsShort);			
			expandParentNode(parRow);
		}
	}

	
	private void expandParentNode(grdTreatmentsRow parRow)
	{
		if (parRow.getValue() instanceof MobilisationsShortVo == false ) return;
		
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((MobilisationsShortVo)parRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		MobilisationsVo voParentInstance = form.getLocalContext().getSelectedParentInstance();	
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() 
				&& voParentInstance.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(new Boolean(true));
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
			form.getLocalContext().setUpdatingParentInstance(voParentInstance);
			parRow.setBackColor(Color.Beige);			
		}
		
		if (voParentInstance.getMobilisationsTreatment() != null)  
		{
			parRow.setValue(voParentInstance);
			parRow.setExpanded(true);
			populateChildNodes(parRow, voParentInstance.getMobilisationsTreatment());
		}
		
		populateParentInstanceControls(voParentInstance);		
		
	}

	private MobilisationsVo getParentFromDomain(MobilisationsShortVo voMobilisationsShort)
	{
		if(Boolean.TRUE.equals(engine.isRIEMode()))						//wdev-13564
			return domain.getMobilisationById(voMobilisationsShort);	//wdev-13564
		else
			return domain.getMobilisation(voMobilisationsShort.getClinicalContact());
	}

	private void populateParentInstanceControls(MobilisationsVo voMobilisationParent)
	{
		if(voMobilisationParent != null)
		{
			form.ctnMob().lyrMob().tabHeader().dtimAuthoring().setValue(voMobilisationParent.getAuthoringDateTime());
			if(voMobilisationParent.getAuthoringCP() != null)
				form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().newRow(voMobilisationParent.getAuthoringCP(), voMobilisationParent.getAuthoringCP().toString());
			form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().setValue(voMobilisationParent.getAuthoringCP());
		}
	}

	private void populateChildNodes(grdTreatmentsRow parRow, MobilisationsTreatmentVoCollection voMobTreatmentColl)
	{
		if (voMobTreatmentColl == null || voMobTreatmentColl.size()<=0) return;		
		
		voMobTreatmentColl.sort();
		for(int i=0; i<voMobTreatmentColl.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdTreatmentsRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voMobTreatmentColl.get(i));				
			}
		}
	}

	private void populateChildNode(grdTreatmentsRow childRow, MobilisationsTreatmentVo voMobTreatment)
	{
		if (voMobTreatment == null) return;		
		
		childRow.setValue(voMobTreatment);
		if(voMobTreatment.getTreatmentType() != null)
			childRow.setColTreatment(voMobTreatment.getTreatmentType().toString());
		if(voMobTreatment.getReason() != null)
			childRow.setColReason(voMobTreatment.getReason().toString());
		if(voMobTreatment.getAreaTreated() != null)
			childRow.setColAreaTreated(voMobTreatment.getAreaTreated().toString());
	
		//if not saved then set the colour
		if(voMobTreatment.getID_MobilisationsTreatment() == null)
			childRow.setTextColor(Color.Red);
		
	}

	private void getSelectedInstance()
	{
		// In update mode we can select nodes without displaying anything but the context
		// menus can change based on what's selected so we need to update them
		if (form.getMode().equals(FormMode.EDIT)) 
		{
			updateContextMenusState();
			return;
		}		
		
		GenForm.grdTreatmentsRow parentRow = null;
		
		if(form.grdTreatments().getValue() instanceof MobilisationsVo)
		{	
			populateParentInstanceControls((MobilisationsVo) form.grdTreatments().getValue());
		}
		else if(form.grdTreatments().getValue() instanceof MobilisationsShortVo)
		{	
			parentRow = form.grdTreatments().getSelectedRow();
			expandParentNode(form.grdTreatments().getSelectedRow());
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
		{
			parentRow = form.grdTreatments().getSelectedRow().getParentRow();
			populateParentInstanceControls((MobilisationsVo) parentRow.getValue());
			form.getLocalContext().setSelectedParentInstance((MobilisationsVo) parentRow.getValue());
			MobilisationsTreatmentVo voMobilisationTreat = (MobilisationsTreatmentVo) form.grdTreatments().getValue();
			populateChildInstanceControls(voMobilisationTreat);
			
			if(parentRow.getValue() instanceof MobilisationsVo && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			{
				MobilisationsVo voMobilisation = (MobilisationsVo) parentRow.getValue();
				if(voMobilisation.getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
					form.getLocalContext().setSelectedChildInstance(voMobilisationTreat);
			}	
		}
		else
		{
			parentRow = form.grdTreatments().getSelectedRow();
			form.getLocalContext().setSelectedParentInstance((MobilisationsVo) form.grdTreatments().getValue());
			populateParentInstanceControls((MobilisationsVo) form.grdTreatments().getValue());
		}
		
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(form.getLocalContext().getSelectedParentInstanceIsNotNull() && form.getLocalContext().getSelectedParentInstance().getClinicalContactIsNotNull() && form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContactIsNotNull() && form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))); //wdev-13513

		updateControlsState();
		
	}

	private void populateChildInstanceControls(MobilisationsTreatmentVo voMobilisationsTreatment)
	{
		if (voMobilisationsTreatment == null ) return;
		
		form.ctnMob().lyrMob().tabDetails().txtOther().setValue(voMobilisationsTreatment.getOther());
		form.ctnMob().lyrMob().tabDetails().txtAreaTreated().setValue(voMobilisationsTreatment.getAreaTreated());
		form.ctnMob().lyrMob().tabDetails().txtReason().setValue(voMobilisationsTreatment.getReason());
		form.ctnMob().lyrMob().tabDetails().cmbTreatment().setValue(voMobilisationsTreatment.getTreatmentType());
		form.getLocalContext().setSelectedChildInstance(voMobilisationsTreatment);
	}

	private void updateContextMenusState()
	{
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			if(form.getLocalContext().getGoldenInstanceSelected().booleanValue())
			{
				// If the golden instance is currently selected we change the text of the update context menu
				// based on whether a parent or child node is selected in the grid.
				if (form.grdTreatments().getValue() instanceof MobilisationsVo)
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);						
				else if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
					form.getContextMenus().getGenericGridUpdateItem().setText("Edit Mobilisation Treatment");
				
				// If the golden node is selected we can now only add child nodes so set the menu text accordingly.
				form.getContextMenus().getGenericGridAddItem().setText("Add Mobilisation Treatment");			
	
				form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																			 form.grdTreatments().getSelectedRowIndex()>=0) &&
																			 form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo ||
																			 (form.getMode().equals(FormMode.EDIT) &&
																			 form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo &&
																			 ((MobilisationsTreatmentVo)form.grdTreatments().getValue()).getID_MobilisationsTreatment() == null));																								

			
			
			
			
			
			}
			else
			{
				// If the golden instance has been found but NOT selected hide the context menu's 
				if (form.getLocalContext().getGoldenInstanceFound().booleanValue() == true)
				{
					form.getContextMenus().hideAllGenericGridMenuItems();
					return;
				}
				else
				{
					form.getContextMenus().getGenericGridAddItem().setText("New Mobilisation");
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
				}
			}
		
			form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW)); 
			form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
					 form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo &&
					 ((MobilisationsTreatmentVo)form.grdTreatments().getValue()).getID_MobilisationsTreatment() == null);
		}
		else
		{
			form.getContextMenus().hideAllGenericGridMenuItems();
		}
		
	}

	private void resetContextVariables()
	{
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		form.getLocalContext().setGoldenInstanceFound(new Boolean(false));
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);	
		form.getLocalContext().setUpdatingParentInstance(null);
	}

	protected void onGrdTreatmentsSelectionChanged() throws PresentationLogicException
	{
		getSelectedInstance();
	}

	
	protected void onFormModeChanged()
	{
		updateControlsState();		 
	}
	
	public void clear()
	{
		form.grdTreatments().getRows().clear();
		clearChildInstanceControls();
	}

	private void clearChildInstanceControls()
	{
		form.ctnMob().lyrMob().tabDetails().cmbTreatment().setValue(null);
		form.ctnMob().lyrMob().tabDetails().txtOther().setValue(null);
		form.ctnMob().lyrMob().tabDetails().txtReason().setValue(null);
		form.ctnMob().lyrMob().tabDetails().txtAreaTreated().setValue(null);
	}
	
	protected void onBtnOkDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addOrUpdateChild();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();	
	}

	private boolean save()
	{
		if(checkForUnsavedChild())
			return false;
		
		MobilisationsVo voMobilisations  = populateInstanceData(form.getLocalContext().getUpdatingParentInstance());
		
		if (voMobilisations.getClinicalContact() == null)
			voMobilisations.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		String[] arrErrors =  voMobilisations.validate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.save(voMobilisations));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Mobilisation record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		catch (DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			open();			
			return false;			
		}
		
		setUpdatedChild();
		return true;		
	}

	private void setUpdatedChild()
	{
		//Straight child update - Select the currently being updated child as the one so show - post save
		if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)		
		{
			form.getLocalContext().setUpdatedChild((MobilisationsTreatmentVo) form.grdTreatments().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				form.getLocalContext().getSelectedParentInstance().getMobilisationsTreatment().sort();
				form.getLocalContext().setUpdatedChild(
						form.getLocalContext().getSelectedParentInstance().getMobilisationsTreatment().get(
								form.getLocalContext().getSelectedParentInstance().getMobilisationsTreatment().size() - 1));
			}
		}
	}

	private String[] validateUIRules()
	{
		return null;
	}

	private MobilisationsVo populateInstanceData(MobilisationsVo voMobilisation)
	{

		if (voMobilisation == null)
			voMobilisation = new MobilisationsVo();
				
		populateParentInstanceData(voMobilisation);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voMobilisation);			
		}
		else 		// Update child instance.
		{
			MobilisationsTreatmentVo voMobTreat = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voMobTreat);
			form.getLocalContext().setSelectedChildInstance(voMobTreat);
			
			for (int i=0; i < voMobilisation.getMobilisationsTreatment().size(); i++)
			{
				if (voMobilisation.getMobilisationsTreatment().get(i).getID_MobilisationsTreatment() == 
					form.getLocalContext().getSelectedChildInstance().getID_MobilisationsTreatment())
				{						
					voMobilisation.getMobilisationsTreatment().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voMobilisation;	
	}

	private void populateChildInstanceData(MobilisationsTreatmentVo voMobTreatment)
	{
		voMobTreatment.setTreatmentType(form.ctnMob().lyrMob().tabDetails().cmbTreatment().getValue());
		voMobTreatment.setAreaTreated(form.ctnMob().lyrMob().tabDetails().txtAreaTreated().getValue());
		voMobTreatment.setOther(form.ctnMob().lyrMob().tabDetails().txtOther().getValue());
		voMobTreatment.setReason(form.ctnMob().lyrMob().tabDetails().txtReason().getValue());
	}

	private void populateChildCollectionFromGrid(MobilisationsVo voMobilisation)
	{
		if (form.grdTreatments().getValue() == null) return;

		if (voMobilisation.getMobilisationsTreatment() == null)
			voMobilisation.setMobilisationsTreatment(new MobilisationsTreatmentVoCollection());
		
		GenForm.grdTreatmentsRow parentRow = form.grdTreatments().getValue() instanceof MobilisationsShortVo || form.grdTreatments().getValue() instanceof MobilisationsVo ? 
										    form.grdTreatments().getSelectedRow() : form.grdTreatments().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voMobilisation.getMobilisationsTreatment().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
			voMobilisation.getMobilisationsTreatment().add((MobilisationsTreatmentVo) parentRow.getRows().get(i).getValue());
        }
	}

	private void populateParentInstanceData(MobilisationsVo voMobilisation)
	{
		voMobilisation.setAuthoringCP(form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().getValue());
		voMobilisation.setAuthoringDateTime(form.ctnMob().lyrMob().tabHeader().dtimAuthoring().getValue());		
	}

	private boolean checkForUnsavedChild()
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{				
			if(addOrUpdateChild())
				return true;
		}
		return false;
	}

	private boolean addOrUpdateChild()
	{
		if (form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))			
			newParentNode(form.getLocalContext().getSelectedParentInstance());			
				
		MobilisationsTreatmentVo voMobilisationsTreat = form.getLocalContext().getSelectedChildInstance();
		
		if (voMobilisationsTreat == null)
			voMobilisationsTreat = new MobilisationsTreatmentVo(); 

		populateChildInstanceData(voMobilisationsTreat);

		if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo && form.getLocalContext().getSelectedChildInstanceIsNotNull())
		{
			promoteUpdatedChild(voMobilisationsTreat);
			newChildInstance();
			updateControlsState();
		}
		else
		{
			if(newChildNode(voMobilisationsTreat))
				return true;
		}
		return false;
	}

	private void updateControlsState()
	{
		//The new button
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW) && 
				form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == false);

		// The collapsible container
		form.ctnMob().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab
		if (form.grdTreatments().getValue() == null)
			form.ctnMob().lyrMob().showtabEmpty();

		// The Parent tab
		setParentTabVisability();						

		// The details tab
		setDetailsTabVisibility();		

		// Pick a tab to show
		showHeaderOrDetailsTab();																				

		// The context menus
		updateContextMenusState();		
		
	}

	private void showHeaderOrDetailsTab()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			// In view mode just show the selected node
			if (form.grdTreatments().getValue() instanceof MobilisationsVo)		
				form.ctnMob().lyrMob().showtabHeader();
			else if (form.grdTreatments().getValue() instanceof MobilisationsShortVo)		
				form.ctnMob().lyrMob().showtabHeader();
			else if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
				form.ctnMob().lyrMob().showtabDetails();
			else
				form.ctnMob().lyrMob().showtabEmpty();
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnMob().lyrMob().showtabHeader();
			else
				form.ctnMob().lyrMob().showtabDetails();
		}
		
	}

	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	
			// In view mode, make the details tab visible if a detail instance is selected in the hierarchy grid.  
			form.ctnMob().lyrMob().tabDetails().setHeaderVisible(form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo);									
			form.ctnMob().lyrMob().tabDetails().txtOther().setEnabled(false);
		}
		else
		{			
			// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
			// editing a parent.
			form.ctnMob().lyrMob().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));
			
			fixCombo();
			setAddApplyCaption();			
		}			

		enableDetailsButtons();		
	}

	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
				  form.ctnMob().lyrMob().tabDetails().isHeaderVisible() &&
				  form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnMob().lyrMob().tabDetails().btnOkDetails().setVisible(boolVisible);
		form.ctnMob().lyrMob().tabDetails().btnCancelDetails().setVisible(boolVisible);
		
	}

	private void setAddApplyCaption()
	{
		form.ctnMob().lyrMob().tabDetails().btnOkDetails().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo))
				form.ctnMob().lyrMob().tabDetails().btnOkDetails().setText("Apply");
		
	}

	private void setParentTabVisability()
	{
		form.ctnMob().lyrMob().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());					
		enableParentControls();		
		
	}

	private void enableParentControls()
	{
		/*boolean boolEnabled = (form.getMode().equals(FormMode.EDIT) && (form.grdTreatments().getValue() instanceof MobilisationsVo ||
				  form.grdTreatments().getValue() instanceof MobilisationsShortVo));*/

		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT));
		
		form.ctnMob().lyrMob().tabHeader().dtimAuthoring().setEnabled(boolEnabled);
		form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().setEnabled(boolEnabled);
		
	}

	private void newParentNode(MobilisationsVo voNewParent)
	{
		if (voNewParent == null) return;
		
		MobilisationsShortVo voParentShort = new MobilisationsShortVo();
		voParentShort.setAuthoringCP(form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().getValue());
		voParentShort.setAuthoringDateTime(form.ctnMob().lyrMob().tabHeader().dtimAuthoring().getValue());
		voParentShort.setClinicalContact(voNewParent.getClinicalContact());
		
		GenForm.grdTreatmentsRow parentRow = form.grdTreatments().getRows().newRow();
		if(voParentShort.getAuthoringCP() != null)
			parentRow.setColTreatment(voParentShort.getAuthoringDateTime().toString()+ " - " + 
							   	voParentShort.getAuthoringCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
		parentRow.setExpanded(true);
		form.grdTreatments().setValue(voParentShort);
		
	}

	private void promoteUpdatedChild(MobilisationsTreatmentVo voMobilisationsTreat)
	{
		if (voMobilisationsTreat == null) return;
		form.grdTreatments().setValue(form.getLocalContext().getSelectedChildInstance());
		populateChildNode(form.grdTreatments().getSelectedRow(),voMobilisationsTreat);	
	}

	private boolean newChildNode(MobilisationsTreatmentVo voMobilisationsTreat)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) return false;
		
		if (voMobilisationsTreat.countFieldsWithValue() >= 1)
		{
			String strErrors[] = voMobilisationsTreat.validate();
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}
	 				
			promoteChild(voMobilisationsTreat);			
			clearChildInstanceControls();
		}
		return false;
	}

	private void promoteChild(MobilisationsTreatmentVo voMobilisationsTreat)
	{
		if (voMobilisationsTreat == null) return;
		GenForm.grdTreatmentsRow childRow = null;
		form.grdTreatments().setValue(form.getLocalContext().getUpdatingParentInstance());
		if(form.grdTreatments().getValue() != null)
		{
			if(form.grdTreatments().getSelectedRow().getValue() instanceof MobilisationsTreatmentVo)
				childRow = form.grdTreatments().getSelectedRow().getParentRow().getRows().newRow();
			else
				childRow = form.grdTreatments().getSelectedRow().getRows().newRow();
		}
		populateChildNode(childRow, voMobilisationsTreat);	
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnCancelDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearChildInstanceControls();
	}
	
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException
	{
		setAuthoringCP(value);		
	}
	private void setAuthoringCP(String value)
	{
		form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		if(coll != null)
		{
			for (int i = 0; i < coll.size(); i++)
			{
				Hcp med = coll.get(i);
				form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().newRow(med, med.toString());			
			}
			
			if (coll.size() == 1)
				form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().setValue(coll.get(0));
			else if (coll.size() > 1)
				form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().showOpened();
		}
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeChild();
		}
	}
	private void removeChild()
	{
		MobilisationsShortVo voParentShort = null;
		MobilisationsVo voParent = null;
		if(form.grdTreatments().getSelectedRow().getParentRow().getValue() instanceof MobilisationsShortVo)
		{
			voParentShort = (MobilisationsShortVo) form.grdTreatments().getSelectedRow().getParentRow().getValue();
			form.grdTreatments().removeSelectedRow();
			form.grdTreatments().setValue(voParentShort);
		}
		else
		{
			voParent = (MobilisationsVo) form.grdTreatments().getSelectedRow().getParentRow().getValue();
			form.grdTreatments().removeSelectedRow();
			form.grdTreatments().setValue(voParent);
		}

		updateContextMenusState();
	}

	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.grdTreatments().getValue() instanceof MobilisationsShortVo || form.grdTreatments().getValue() instanceof MobilisationsVo));
		form.setMode(FormMode.EDIT);
		if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)			
		{
			MobilisationsTreatmentVo voCachedChild = (MobilisationsTreatmentVo) form.grdTreatments().getValue(); 
			if (voCachedChild.getID_MobilisationsTreatment() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}			
		}	
		disableHeaderInfo();
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{
		newInstance();
	}
	
	private void newInstance()
	{
		//New instance has been invoked for a parent instance with no current selection made OR
		// with a parent that is not the Golden node..
		if (form.grdTreatments().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
				&& form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))))
		{
			newParentInstance();			
			form.setMode(FormMode.EDIT);		
		}
		else
		{
			newChildInstance();
			form.setMode(FormMode.EDIT);		
			disableHeaderInfo();
		}
		// New instance has been invoked with a child node selected.
		//if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
		//form.setMode(FormMode.EDIT);		
		//if (form.grdTreatments().getValue() instanceof MobilisationsShortVo)
		//{
			//new instance for golden parent node meaning add a new child
		//	newChildInstance();
		//	form.setMode(FormMode.EDIT);		
		//	disableHeaderInfo();
		//}
		//else if (form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
		//{
			// New instance has been invoked with a child node selected.
		//}
	}
	private void disableHeaderInfo() 
	{
		form.ctnMob().lyrMob().tabHeader().dtimAuthoring().setEnabled(false);
		form.ctnMob().lyrMob().tabHeader().qmbAuthoringCP().setEnabled(false);
	}

	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		if(form.grdTreatments().getValue() instanceof MobilisationsTreatmentVo)
			form.grdTreatments().setValue(form.grdTreatments().getSelectedRow().getParentRow().getValue());
	}

	private void newParentInstance()
	{
		MobilisationsVo voNewParent = new MobilisationsVo(); 	
		
		Hcp voHcp = (Hcp) domain.getHcpUser();
		voNewParent.setAuthoringCP(voHcp);
		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setMobilisationsTreatment(new MobilisationsTreatmentVoCollection());
		populateParentInstanceControls(voNewParent);		
		form.getLocalContext().setSelectedParentInstance(voNewParent);
		form.getLocalContext().setUpdatingParentInstance(voNewParent);
		enableParentControls();
	}

	public boolean allowNew()
	{
		if (form.ctnMob().lyrMob().tabDetails().cmbTreatment().size() == 0)
		{
			engine.showMessage("The MobilisationTreatment lookup must first be populated before this form can be used. ");;
			return false;
		}
		return true;
	}
	
	public boolean allowUpdate()
	{
		return (form.grdTreatments().getValue()!= null); 
	}

	protected void onCmbTreatmentValueChanged() throws PresentationLogicException
	{
		fixCombo();
	}
	private void fixCombo()
	{
		if(form.ctnMob().lyrMob().tabDetails().cmbTreatment().getValue() != null)
		{
			if(form.ctnMob().lyrMob().tabDetails().cmbTreatment().getValue().equals(MobilisationsTreatment.OTHER))
				form.ctnMob().lyrMob().tabDetails().txtOther().setEnabled(true);
			else
			{
				form.ctnMob().lyrMob().tabDetails().txtOther().setEnabled(false);
				form.ctnMob().lyrMob().tabDetails().txtOther().setValue(null);
			}
		}
	}

	//wdev-13564
	protected void onRIEDialogClosed(DialogResult result) throws PresentationLogicException 
	{
		if(result == DialogResult.OK)
		{
			
		}
		
	}
}
