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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.39 build 2174.21371)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.stretching;

import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.therapies.forms.stretching.GenForm;
import ims.therapies.forms.stretching.GenForm.grdAreaRow;
import ims.therapies.forms.stretching.GenForm.ctnStretchingContainer.lyrStretchingLayer.tabDetailsContainer;
import ims.therapies.vo.StretchingDetailsVo;
import ims.therapies.vo.StretchingDetailsVoCollection;
import ims.therapies.vo.StretchingShortVo;
import ims.therapies.vo.StretchingShortVoCollection;
import ims.therapies.vo.StretchingVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}

	private void open() 
	{
		clear();
		resetContextVariables();		
							
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			populateParentNodes(domain.listStretchingByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));			
		}
									
		form.setMode(FormMode.VIEW);
		reselectUpdatedNode();
	}

	private void reselectUpdatedNode()
	{
		// Pattern demands that the last updated node is displayed
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdArea().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
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
		
		//expand the selected parent
		if(form.grdArea().getValue() instanceof StretchingShortVo)
		{		
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((StretchingShortVo) form.grdArea().getValue()));
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
			//add activities if not added already
			populateChildNodes(form.grdArea().getSelectedRow(),form.getLocalContext().getSelectedParentInstance().getStretchingDetails());			
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdArea().getValue() instanceof StretchingDetailsVo)
		{
			form.getLocalContext().setSelectedChildInstance((StretchingDetailsVo) form.grdArea().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
		}
 
		if (form.getGlobalContext().Core.getCurrentClinicalContact() == null)
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		else
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())));
		
		updateControlsState();
		
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			form.btnNew().setVisible(false);
			form.btnUpdate().setVisible(false);
		}
	}
	
	private void updateControlsState()
	{
		// The new button
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW) 
				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == false
				&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull());

 		form.btnUpdate().setVisible(form.getMode().equals(FormMode.VIEW) 
 				&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
 				&& form.grdArea().getValue() instanceof StretchingDetailsVo
 				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == true);
		
		// The collapsible container
		form.ctnStretching().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab
		if (form.grdArea().getValue() == null)
			form.ctnStretching().lyrStretching().showtabEmpty();

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
			if (form.grdArea().getValue() instanceof StretchingShortVo)		
				form.ctnStretching().lyrStretching().showtabHeader();
			else if (form.grdArea().getValue() instanceof StretchingDetailsVo)
				form.ctnStretching().lyrStretching().showtabDetails();
			else
				form.ctnStretching().lyrStretching().showtabEmpty();
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnStretching().lyrStretching().showtabHeader();
			else
				form.ctnStretching().lyrStretching().showtabDetails();
		}
	}

	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	
			// In view mode, make the details tab visible if a detail instance is selected in the hierarchy grid.  
			form.ctnStretching().lyrStretching().tabDetails().setHeaderVisible(form.grdArea().getValue() instanceof StretchingDetailsVo);									
		}
		else
		{			
			// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
			// editing a parent.
			form.ctnStretching().lyrStretching().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));
			
			setAddApplyCaption();			
		}			
		enableDetailsButtons();	
	}
	
	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
				  form.ctnStretching().lyrStretching().tabDetails().isHeaderVisible() &&
				  form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnStretching().lyrStretching().tabDetails().btnOk().setVisible(boolVisible);
		form.ctnStretching().lyrStretching().tabDetails().btnCancelDetails().setVisible(boolVisible);
	}
	
	private void setAddApplyCaption()
	{
		form.ctnStretching().lyrStretching().tabDetails().btnOk().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdArea().getValue() instanceof StretchingDetailsVo))
				form.ctnStretching().lyrStretching().tabDetails().btnOk().setText("Apply");
	}

	private void setParentTabVisability()
	{
		form.ctnStretching().lyrStretching().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());					
		enableParentControls();
	}

	private void enableParentControls()
	{
		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT));
		form.ctnStretching().lyrStretching().tabHeader().dtimAuthoring().setEnabled(boolEnabled);
		form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().setEnabled(boolEnabled);
	}

	private void populateChildInstanceControls(StretchingDetailsVo voStretchingDetails)
	{
		if (voStretchingDetails == null ) 
			return;
			
		//Display the details data
		form.ctnStretching().lyrStretching().tabDetails().chkActive().setValue(voStretchingDetails.getActiveIsNotNull() ? voStretchingDetails.getActive().booleanValue(): false);
		form.ctnStretching().lyrStretching().tabDetails().chkPassive().setValue(voStretchingDetails.getPassiveIsNotNull() ? voStretchingDetails.getPassive().booleanValue(): false);
		form.ctnStretching().lyrStretching().tabDetails().cmbArea().setValue(voStretchingDetails.getStretchingAreaIsNotNull() ? voStretchingDetails.getStretchingArea(): null);
		form.ctnStretching().lyrStretching().tabDetails().txtComment().setValue(voStretchingDetails.getCommentIsNotNull() ? voStretchingDetails.getComment(): null);
	}

	private void populateParentInstanceControls(StretchingVo voStretchingParent)
	{
		if(voStretchingParent != null)
		{
			form.ctnStretching().lyrStretching().tabHeader().dtimAuthoring().setValue(voStretchingParent.getAuthoringDateTime());
			if(voStretchingParent.getAuthoringCP() != null)
				form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().newRow(voStretchingParent.getAuthoringCP(), voStretchingParent.getAuthoringCP().toString());
			form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().setValue(voStretchingParent.getAuthoringCP());
		}
	}

	private StretchingVo getParentFromDomain(StretchingShortVo voStretchingShort)
	{
		return domain.getStretchingVo(voStretchingShort);
	}

	private void updateContextMenusState()
	{
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			if(form.getLocalContext().getGoldenInstanceSelected().booleanValue())
			{
				// If the golden instance is currently selected we change the text of the update context menu
				// based on whether a parent or child node is selected in the grid.
				if (form.grdArea().getValue() instanceof StretchingShortVo)
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);						
				else if (form.grdArea().getValue() instanceof StretchingDetailsVo)
					form.getContextMenus().getGenericGridUpdateItem().setText("Edit Stretching Details");
				
				// If the golden node is selected we can now only add child nodes so set the menu text accordingly.
				form.getContextMenus().getGenericGridAddItem().setText("Add Stretching Details");			
	
				// Only show the update menu if the user has selected an item to update.
				form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																			 form.grdArea().getSelectedRowIndex()>=0) &&
																			 form.grdArea().getValue() instanceof StretchingDetailsVo ||
																			 (form.getMode().equals(FormMode.EDIT) &&
																			 form.grdArea().getValue() instanceof StretchingDetailsVo &&
																			 ((StretchingDetailsVo)form.grdArea().getValue()).getID_StretchingDetails() == null));																								
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
					form.getContextMenus().getGenericGridAddItem().setText("New Stretching Record");
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
				}
			}
			form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW));
			form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
					 form.grdArea().getValue() instanceof StretchingDetailsVo &&
					 ((StretchingDetailsVo)form.grdArea().getValue()).getID_StretchingDetails() == null);
		}
		else
		{
			form.getContextMenus().hideAllGenericGridMenuItems();
		}
	}

	private void populateParentNodes(StretchingShortVoCollection voStretchingColl)
	{
		if (voStretchingColl == null)
			return;

		for(StretchingShortVo stretchingShortVo : voStretchingColl)
		{
			populateParentNode(stretchingShortVo);			
		}
	}

	private void populateParentNode(StretchingShortVo voStretching)
	{
		if (voStretching == null)
			return;
		
		GenForm.grdAreaRow parRow = form.grdArea().getRows().newRow();
		parRow.setColArea((voStretching.getAuthoringDateTimeIsNotNull()?voStretching.getAuthoringDateTime().toString():"") + " - " + 
				(voStretching.getAuthoringCPIsNotNull()? voStretching.getAuthoringCP().toString():""));
		//parRow.setTooltip(voRehabParent.getCareContext().toString());
		
		parRow.setValue(voStretching);
		form.grdArea().setValue(voStretching);
		expandParentNode(parRow);
	}

	private void expandParentNode(grdAreaRow selectedRow)
	{
		if (selectedRow.getValue() instanceof StretchingShortVo == false ) return;
		
		StretchingVo voStretching = getParentFromDomain((StretchingShortVo) form.grdArea().getValue());
		if(voStretching.getStretchingDetails()==null || voStretching.getStretchingDetails().size()==0){
			try {
				domain.deleteStretchingVo((StretchingShortVo) selectedRow.getValue());
			} catch (ForeignKeyViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			open();
			return;
		}
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((StretchingShortVo) selectedRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		StretchingVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
				&& (voParentInstance.getClinicalContact().getID_ClinicalContact().equals
									(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(new Boolean(true));
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
			selectedRow.setBackColor(Color.Beige);			
		}
		if (voParentInstance.getStretchingDetailsIsNotNull())  
		{
			selectedRow.setExpanded(true);
			populateChildNodes(selectedRow, voParentInstance.getStretchingDetails());
		}
		populateParentInstanceControls(voParentInstance);		
	}

	private void populateChildNodes(grdAreaRow parRow, StretchingDetailsVoCollection voStretchingDetailsColl)
	{
		parRow.getRows().clear();
		
		if (voStretchingDetailsColl == null || voStretchingDetailsColl.size()<=0) return;		
		
		//RehabilitationVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		//if(voParentInstance.getClinicalContact().getID_ClinicalContact().equals
		//						(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		
		voStretchingDetailsColl.sort();
		for(int i=0; i<voStretchingDetailsColl.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdAreaRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voStretchingDetailsColl.get(i));				
			}
		}
		//reselect parent
		form.grdArea().setValue(parRow.getValue());
		parRow.setExpanded(true);
	}

	private void populateChildNode(grdAreaRow childRow, StretchingDetailsVo voStretchingDetails)
	{
		if (voStretchingDetails == null) return;		
		
		childRow.setValue(voStretchingDetails);
		if(voStretchingDetails.getStretchingArea() != null)
			childRow.setColArea(voStretchingDetails.getStretchingArea().toString());
		if(voStretchingDetails.getActive() != null)
			childRow.setColActive(voStretchingDetails.getActive().booleanValue());
		if(voStretchingDetails.getPassive() != null)
			childRow.setcolPassive(voStretchingDetails.getPassive().booleanValue());
		if(voStretchingDetails.getComment() != null)
			childRow.setColComment(voStretchingDetails.getComment().toString());			
		
		//if not saved then set the colour
		if(voStretchingDetails.getID_StretchingDetails() == null)
			childRow.setTextColor(Color.Red);
	}

	private void resetContextVariables()
	{
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		form.getLocalContext().setGoldenInstanceFound(new Boolean(false));
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);
	}

	private void clear()
	{
		form.grdArea().getRows().clear();		
		clearChildInstanceControls();
	}

	private void clearChildInstanceControls()
	{
		form.ctnStretching().lyrStretching().tabDetails().cmbArea().setValue(null);
		form.ctnStretching().lyrStretching().tabDetails().chkActive().setValue(false);
		form.ctnStretching().lyrStretching().tabDetails().chkPassive().setValue(false);
		form.ctnStretching().lyrStretching().tabDetails().txtComment().setValue(null);
	}

	private void initialize()
	{
		form.ctnStretching().setCollapsed(true);
		form.ctnStretching().lyrStretching().tabEmpty().setHeaderVisible(false);
	}

	protected void onFormModeChanged() 
	{
		updateControlsState();
	}

	protected void onQmbAuthoringCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().showOpened();		
		}		
	}

	private boolean addOrUpdateChild(boolean saveorAd)
	{
		if (form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))			
			newParentNode(form.getLocalContext().getSelectedParentInstance());			
				
		StretchingDetailsVo voStretchingDetails = form.getLocalContext().getSelectedChildInstance();
		
		if (voStretchingDetails == null)
			voStretchingDetails = new StretchingDetailsVo(); 

		populateChildInstanceData(voStretchingDetails);

		if (form.grdArea().getValue() instanceof StretchingDetailsVo && form.getLocalContext().getSelectedChildInstanceIsNotNull())
		{
			StretchingDetailsVo voStretchingDetailsSelected = (StretchingDetailsVo)form.grdArea().getValue();
			
			if (voStretchingDetailsSelected.getID_StretchingDetails() == null) 
			{
				//allow update of selected child that is not saved yet.
				promoteUpdatedChild(voStretchingDetails);
				newChildInstance();
				updateControlsState();
			}
		}
		else
		{
			if(newChildNode(voStretchingDetails,saveorAd))
				return true;			
		}
		return false;		
	}

	private boolean newChildNode(StretchingDetailsVo voStretchingDetails,boolean saveorAd)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) return false;
		
		if(voStretchingDetails.getActive().equals(Boolean.FALSE))
			voStretchingDetails.setActive(null);
		if(voStretchingDetails.getPassive().equals(Boolean.FALSE))
			voStretchingDetails.setPassive(null);
		//-------------
		int cont;
		if(saveorAd == true)
			cont = 1;
		else
			cont = 0;
		//-------------
		
		if (voStretchingDetails.countFieldsWithValue() >= cont)// in if condition was >= 1
		{
			String strErrors[] = voStretchingDetails.validate();
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}
			promoteChild(voStretchingDetails);			
			clearChildInstanceControls();
		}
		return false;
	}

	private void promoteChild(StretchingDetailsVo voStretchingDetails)
	{
		if (voStretchingDetails == null) return;
		GenForm.grdAreaRow childRow = null;
		form.grdArea().setValue(form.getLocalContext().getSelectedParentInstance());
		if(form.grdArea().getSelectedRow().getValue() instanceof StretchingDetailsVo)
			childRow = form.grdArea().getSelectedRow().getParentRow().getRows().newRow();
		else
			childRow = form.grdArea().getSelectedRow().getRows().newRow();		
		populateChildNode(childRow, voStretchingDetails);	
	}

	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		if (form.grdArea().getValue() instanceof StretchingShortVo)
			form.grdArea().setValue(form.grdArea().getSelectedRow().getValue());
		else if (form.grdArea().getValue() instanceof StretchingDetailsVo)
			form.grdArea().setValue(form.grdArea().getSelectedRow().getParentRow().getValue());
	}

	private void promoteUpdatedChild(StretchingDetailsVo voStretchingDetails)
	{
		if (voStretchingDetails == null) return;
		populateChildNode(form.grdArea().getSelectedRow(),voStretchingDetails);	
	}

	private void populateChildInstanceData(StretchingDetailsVo voStretchingDetails)
	{
		voStretchingDetails.setStretchingArea(form.ctnStretching().lyrStretching().tabDetails().cmbArea().getValue());
		voStretchingDetails.setActive(new Boolean(form.ctnStretching().lyrStretching().tabDetails().chkActive().getValue()));
		voStretchingDetails.setPassive(new Boolean(form.ctnStretching().lyrStretching().tabDetails().chkPassive().getValue()));
		voStretchingDetails.setComment(form.ctnStretching().lyrStretching().tabDetails().txtComment().getValue());
	}

	private void newParentNode(StretchingVo voNewParent)
	{
		if (voNewParent == null) return;
		
		StretchingShortVo voParentShort = new StretchingShortVo();
		voParentShort.setAuthoringCP(voNewParent.getAuthoringCP());
		voParentShort.setAuthoringDateTime(voNewParent.getAuthoringDateTime());
		voParentShort.setClinicalContact(voNewParent.getClinicalContact());

		GenForm.grdAreaRow parentRow = form.grdArea().getRows().newRow();
		if(voParentShort.getAuthoringCP() != null)
			parentRow.setColArea(voParentShort.getAuthoringDateTime().toString()+ " - " + 
							   	voParentShort.getAuthoringCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
		parentRow.setExpanded(true);
		form.grdArea().setValue(voParentShort);
	}

	private boolean save()
	{
		if(form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().getValue() == null)
		{
			engine.showMessage("No Authoring HCP has been provided! Please select an Authoring HCP from the Stretching tab before proceeding.");
			return false;
		}
		
		if(checkForUnsavedChild())
			return false;
		
		StretchingVo voStretching  = populateInstanceData(form.getLocalContext().getSelectedParentInstance());
		
		if (voStretching.getClinicalContact() == null)
			voStretching.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		String[] arrErrors =  voStretching.validate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.saveStretchingVo(voStretching));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			setUpdatedChild();
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Stretching record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage("A Stretching record already exists for this clinical contact.");
			e.printStackTrace();
			open();
			return false;
		}
		setUpdatedChild();
		return true;		
	}

	private void setUpdatedChild()
	{
		// Straight child update - Select the currently being updated child as the one so show - post save
		if (form.grdArea().getValue() instanceof StretchingDetailsVo)		
		{
			form.getLocalContext().setUpdatedChild((StretchingDetailsVo) form.grdArea().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				form.getLocalContext().getSelectedParentInstance().getStretchingDetails().sort();
				form.getLocalContext().setUpdatedChild(
						form.getLocalContext().getSelectedParentInstance().getStretchingDetails().get(
								form.getLocalContext().getSelectedParentInstance().getStretchingDetails().size() - 1));
			}
		}
	}

	private String[] validateUIRules()
	{
		return null;
	}

	private StretchingVo populateInstanceData(StretchingVo voStretching)
	{
		if (voStretching == null)
			voStretching = new StretchingVo();
				
		populateParentInstanceData(voStretching);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voStretching);			
		}
		else 		// Update child instance.
		{
			StretchingDetailsVo voStretchingDetails = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voStretchingDetails);
			form.getLocalContext().setSelectedChildInstance(voStretchingDetails);
			
			for (int i=0; i < voStretching.getStretchingDetails().size(); i++)
			{
				if ( voStretching.getStretchingDetails().get(i) != null && voStretching.getStretchingDetails().get(i).getID_StretchingDetails().equals(form.getLocalContext().getSelectedChildInstance().getID_StretchingDetails()))
				{						
					voStretching.getStretchingDetails().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voStretching;	
	}

	private void populateChildCollectionFromGrid(StretchingVo voStretching)
	{
		if (form.grdArea().getValue() == null) return;

		if (voStretching.getStretchingDetails() == null)
			voStretching.setStretchingDetails(new StretchingDetailsVoCollection());
		
		GenForm.grdAreaRow parentRow = form.grdArea().getValue() instanceof StretchingShortVo ? 
										    form.grdArea().getSelectedRow() : form.grdArea().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voStretching.getStretchingDetails().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
			voStretching.getStretchingDetails().add((StretchingDetailsVo) parentRow.getRows().get(i).getValue());
        }
	}

	private void populateParentInstanceData(StretchingVo voStretching)
	{
		voStretching.setAuthoringCP(form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().getValue());
		voStretching.setAuthoringDateTime(form.ctnStretching().lyrStretching().tabHeader().dtimAuthoring().getValue());
	}

	private boolean checkForUnsavedChild()
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{				
			if(addOrUpdateChild(true))//------------------add parameter boolean
				return true;
		}
		return false;
	}

	private void newInstance()
	{
		// New instance has been invoked for a parent instance with no current selection made OR
		// with a parent that is not the Golden node..
		if (form.grdArea().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
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
	}

	private void newParentInstance()
	{
		StretchingVo voNewParent = new StretchingVo(); 		
		voNewParent.setAuthoringCP((Hcp) domain.getHcpUser());
		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setStretchingDetails(new StretchingDetailsVoCollection());
		populateParentInstanceControls(voNewParent);
		form.getLocalContext().setSelectedParentInstance(voNewParent);					
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
		StretchingShortVo voParent = (StretchingShortVo) form.grdArea().getSelectedRow().getParentRow().getValue();
		form.grdArea().removeSelectedRow();
		form.grdArea().setValue(voParent);
		updateContextMenusState();
	}

	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.grdArea().getValue() instanceof StretchingShortVo));
		form.setMode(FormMode.EDIT);
		if (form.grdArea().getValue() instanceof StretchingDetailsVo)			
		{
			StretchingDetailsVo voChild = (StretchingDetailsVo) form.grdArea().getValue(); 
			if ( voChild.getID_StretchingDetails() == null)
			{
				populateChildInstanceControls(voChild);
			}			
		}
		disableHeaderInfo();
	}

	private void disableHeaderInfo()
	{
		form.ctnStretching().lyrStretching().tabHeader().dtimAuthoring().setEnabled(false);
		form.ctnStretching().lyrStretching().tabHeader().qmbAuthoringHcp().setEnabled(false);
	}

	protected void onBtnOkClick() throws PresentationLogicException
	{
		addOrUpdateChild(false);//-----------------
	}

	protected void onBtnCancelDetailsClick() throws PresentationLogicException
	{
		clearChildInstanceControls();
		newChildInstance();
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{
		newInstance();
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if (save())
			open();	
	}

	protected void onGrdAreaSelectionChanged() throws PresentationLogicException
	{
		getSelectedInstance();
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		updateInstance();
	}

	
	
	///////////////////////////////////////
	
	protected void updateContextMenus()
	{
		if (form.grdArea().getSelectedRowIndex()>=0)
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		}
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(false);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(false);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
		form.getContextMenus().getGenericGridViewItem().setVisible(false);
	}

	@Override
	protected void onChkActiveValueChanged() throws PresentationLogicException 
	{
		tabDetailsContainer detailTab = form.ctnStretching().lyrStretching().tabDetails();
		if (detailTab.chkActive().getValue() == true)
		{
		detailTab.chkPassive().setValue(false);
		}
		
	}

	@Override
	protected void onChkPassiveValueChanged() throws PresentationLogicException 
	{
		tabDetailsContainer detailTab = form.ctnStretching().lyrStretching().tabDetails();
		if (detailTab.chkPassive().getValue() == true)
		{
		detailTab.chkActive().setValue(false);
		}
		
	}	

}
