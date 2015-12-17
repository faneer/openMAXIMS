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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2424.20430)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.clinicalteamadministration;

import ims.core.forms.clinicalteamadministration.GenForm.grdHierarchyRow;
import ims.core.vo.ClinicalTeamMemberVo;
import ims.core.vo.ClinicalTeamMemberVoCollection;
import ims.core.vo.ClinicalTeamSearchCriteriaVo;
import ims.core.vo.ClinicalTeamVo;
import ims.core.vo.ClinicalTeamVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.ClinicalTeamType;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.vo.ValueObject;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();		
	}
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	protected void onGrdHierarchySelectionChanged() throws PresentationLogicException
	{
		selectionChanged();		
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.ClinicalTeam.NEW_TEAM:
				newParentInstance();
				break;
			case GenForm.ContextMenus.ClinicalTeam.NEW_MEMBERS:
				newChildInstance();
				break;
			case GenForm.ContextMenus.ClinicalTeam.UPDATE_TEAM:
				updateParentInstance();
				break;
			case GenForm.ContextMenus.ClinicalTeam.UPDATE_MEMBER:
				updateChildInstance();
				break;
			case GenForm.ContextMenus.ClinicalTeam.REMOVE_MEMBER:
				removeChild();
		}
	}		
	
			
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbSearchTeamType().setValue(null);
		form.txtSearchTeamName().setValue("");
		form.chkSearchActiveTeams().setValue(false);
		clearSearchCriteria();		
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		getSearchCriteria();
		search();
	}
	
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newParentInstance();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())			
			open();					
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		removeUnsavedNodes();
		setUpdatedItem();
		open();
	}

	
	private void removeUnsavedNodes() 
	{
		for (int i=0; i < form.grdHierarchy().getRows().size(); i++)
		{
			ValueObject vo = form.grdHierarchy().getRows().get(i).getValue(); 
			if ( vo instanceof ClinicalTeamVo)
			{
				ClinicalTeamVo voClinicalTeam = (ClinicalTeamVo) vo;
				if (voClinicalTeam.getID_ClinicalTeam() == null)
					form.grdHierarchy().getRows().remove(i);
			}
					
		}

		
	}
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addOrUpdateChild();
	}
	
	protected void onCustomControlSearchHCPsValueChanged() throws PresentationLogicException
	{
		HcpLiteVoCollection voCollHCPLites = form.ctnDetails().lyrDetails().tabDetailsMembers().customControlSearchHCPs().listHCPLites();
		form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().getRows().clear();
		if (voCollHCPLites != null)
		{
			for (int i = 0; i < voCollHCPLites.size(); i++)
			{
				// Remove the Lead Hcp and any other current team members..
				if (!inTeam(voCollHCPLites.get(i)))
				{				
					GenForm.ctnDetailsContainer.lyrDetailsLayer.tabDetailsMembersContainer.grdTeamMembersRow row = form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().getRows().newRow();
					row.setcolHcp(voCollHCPLites.get(i).getMos().getName().toString());
					row.setValue(voCollHCPLites.get(i));
				}
			} 			
		}		
	}
	
	private boolean inTeam(HcpLiteVo voHcp)
	{		
		if (form.getLocalContext().getSelectedParentInstance() == null)
			return false;
		
		ClinicalTeamVo voClinicalTeam = form.getLocalContext().getSelectedParentInstance();		
		
		boolean boolReturn = false;
		
		if (voHcp.equals(getTeamLead(voClinicalTeam)))
			boolReturn = true;
		else
		{
			for (int i=0; i < voClinicalTeam.getTeamMembers().size(); i++)
			{
				if (voClinicalTeam.getTeamMembers().get(i).getHCP().equals(voHcp))
				{
					boolReturn = true;
					break;
				}
			}
		}
				
		return boolReturn;
	}
	
	
	HcpLiteVo getTeamLead(ClinicalTeamVo voClinicalTeam)
	{
		HcpLiteVo voHcpLite = null;
		if (voClinicalTeam != null && voClinicalTeam.getLeadHCP() != null)
			voHcpLite = voClinicalTeam.getLeadHCP();					
		
		return voHcpLite;
	}
	
	protected void onQmbTeamLeadTextSubmited(String value) throws PresentationLogicException
	{
		listHCPs(value);		
	}	
			
	
	protected void onBtnCancelDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsMembers().chkActive().setValue(true);
	}	

	private void selectionChanged()
	{
		// In update mode we can select nodes without displaying anything but the context
		// menus can change based on what's selected so we need to update them
		if (form.getMode().equals(FormMode.EDIT)) 
		{
			updateContextMenusState();
			return;
		}		
				
		//expand the selected parent
		if(form.grdHierarchy().getValue() instanceof ClinicalTeamVo)
		{									 
			form.getLocalContext().setSelectedParentInstance((ClinicalTeamVo) form.grdHierarchy().getValue());
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());			
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls(true);
		}		
		else if(form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo)
		{
			form.getLocalContext().setSelectedChildInstance((ClinicalTeamMemberVo) form.grdHierarchy().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
			form.getLocalContext().setSelectedParentInstance((ClinicalTeamVo) form.grdHierarchy().getSelectedRow().getParentRow().getValue());
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());			
		}
 
		updateControlsState();
		
	}
	
	private void open()
	{									
		form.setMode(FormMode.VIEW);
		if (form.getLocalContext().getTeamSearchCriteriaIsNotNull())
		{
			search();
			reselectUpdatedNode();
		}
	}
		
	private void search()
	{
		clear();
		resetContextVariables();
		populateClinicalTeamTree(domain.listClinicalTeams(form.getLocalContext().getTeamSearchCriteria()));					
	}
	
	
	private void newParentInstance()
	{
		//form.getLocalContext().setUpdatingParent(new Boolean(true));		
		ClinicalTeamVo voNewParent = new ClinicalTeamVo(); 		
		voNewParent.setTeamMembers(new ClinicalTeamMemberVoCollection());		
		form.getLocalContext().setSelectedParentInstance(voNewParent);
		newParentNode(voNewParent);
		clearParentInstanceControls();
		// Box the selected node offside
		if (form.grdHierarchy().getValue() instanceof ClinicalTeamVo )
			form.getLocalContext().setUpdatedParent((ClinicalTeamVo) form.grdHierarchy().getValue());
		else if (form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo )
			form.getLocalContext().setUpdatedChild((ClinicalTeamMemberVo) form.grdHierarchy().getValue());
		
		form.getLocalContext().setSelectedChildInstance(new ClinicalTeamMemberVo());
		form.ctnDetails().setCollapsed(false);		
		form.setMode(FormMode.EDIT);		
	}
	

	private void newChildInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		clearChildInstanceControls(true); 				
		form.getLocalContext().setSelectedChildInstance(new ClinicalTeamMemberVo());
		form.ctnDetails().lyrDetails().tabDetailsMembers().customControlSearchHCPs().initializeComponent(Boolean.TRUE);
		form.setMode(FormMode.EDIT);		
	}
	
	/**
	 * Invoked when the user clicks OK to add a new element to the child array
	 * Basically we update the hierarchy grid with the newly added details clearing the control
	 * to facilitate new input. We then update the local context variable with the new child 
	 *
	 */
	private void  newChildNode(ClinicalTeamMemberVo voClinicalTeamMember) throws PresentationLogicException
	{		
		if (voClinicalTeamMember.countFieldsWithValue() > 1)
		{			
			String strErrors[] = voClinicalTeamMember.validate(validateUIRules());
		
			if(strErrors != null && strErrors.length > 0)
			{				
				StringBuffer sErr = new StringBuffer("Clinical team promote failed for the following reason(s) : ");
				for (int i=0; i < strErrors.length; i++)
					sErr.append(strErrors[i] + " ");
				throw new PresentationLogicException(sErr.toString());
			}
	 				
			promoteChild(voClinicalTeamMember);			
			clearChildInstanceControls(false);
		}
	}
		
	private void updateParentInstance()
	{								
		form.getLocalContext().setUpdatingParent(new Boolean(true));		
		form.setMode(FormMode.EDIT);		
	}
	
	private void updateChildInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(false)); 				
		populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());		
		form.setMode(FormMode.EDIT);
	}
		
	
	private boolean save()
	{
		try
		{
			checkForUnsavedChild();
		}
		catch (PresentationLogicException e) 
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		ClinicalTeamVo voClinicalTeam  = populateInstanceData(form.getLocalContext().getSelectedParentInstance());
		
		String[] arrErrors =  voClinicalTeam.validate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.saveClinicalTeam(voClinicalTeam));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		
		setUpdatedItem();		
		return true;		
	}
	

				
	private void getSearchCriteria()
	{
		ClinicalTeamSearchCriteriaVo voClinicalTeamSearchCriteria = new ClinicalTeamSearchCriteriaVo();		
		voClinicalTeamSearchCriteria.setTeamName(form.txtSearchTeamName().getValue());
		voClinicalTeamSearchCriteria.setTeamType(form.cmbSearchTeamType().getValue());
		
		Boolean boolActive = form.chkSearchActiveTeams() == null || form.chkSearchActiveTeams().getValue() == false ? null : new Boolean(form.chkSearchActiveTeams().getValue()); 		
		voClinicalTeamSearchCriteria.setActive(boolActive);

		form.getLocalContext().setTeamSearchCriteria(voClinicalTeamSearchCriteria);
	}
	
	private void removeChild()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		ClinicalTeamVo voParent = (ClinicalTeamVo) form.grdHierarchy().getSelectedRow().getParentRow().getValue();
		form.grdHierarchy().removeSelectedRow();
		form.getLocalContext().setSelectedChildInstance(null);		
		form.grdHierarchy().setValue(voParent);
		form.setMode(FormMode.EDIT);
		updateContextMenusState();
	}
	
	
	private void reselectUpdatedNode()
	{
		// Pattern demands that the last updated node is displayed				
		if (form.getLocalContext().getUpdatedChildIsNotNull())
			form.grdHierarchy().setValue(form.getLocalContext().getUpdatedChild());							
		else if (form.getLocalContext().getUpdatedParent() != null)
			form.grdHierarchy().setValue(form.getLocalContext().getUpdatedParent());

		selectionChanged();		
		resetSearchContextVariables();		
	}
	
	
	
	private void populateClinicalTeamTree(ClinicalTeamVoCollection voCollClinicalTeams)
	{
		if (voCollClinicalTeams == null || voCollClinicalTeams.size() <= 0 ) return;
		
		for(int i=0; i<voCollClinicalTeams.size(); i++)
			newParentNode(voCollClinicalTeams.get(i));			
	}


	private void newParentNode(ClinicalTeamVo voClinicalTeam)
	{
		GenForm.grdHierarchyRow parRow = form.grdHierarchy().getRows().newRow();
		parRow.setcolTeam(voClinicalTeam.getTeamName());		
		parRow.setValue(voClinicalTeam);
		parRow.setExpandedImage(form.getImages().Admin.ClinicalTeam);
		parRow.setCollapsedImage(form.getImages().Admin.ClinicalTeam);
		
		form.grdHierarchy().setValue(voClinicalTeam);
							
		form.getLocalContext().setSelectedParentInstance(voClinicalTeam);
		populateChildNodes(voClinicalTeam, parRow);		
	}
	
	
	private void populateChildNodes(ClinicalTeamVo voClinicalTeam, grdHierarchyRow parRow)
	{
		if (voClinicalTeam == null  || parRow == null || voClinicalTeam.getTeamMembers() == null)
			return;
		
		if (voClinicalTeam.getTeamMembers().size() > 0)
			parRow.setExpanded(true);
		
		voClinicalTeam.getTeamMembers().sort();
		for (int i=0; i < voClinicalTeam.getTeamMembers().size(); i++)
		{
			GenForm.grdHierarchyRow childRow = parRow.getRows().newRow();
			populateChildNode(childRow, voClinicalTeam.getTeamMembers().get(i));
		}
	}
	
	private void populateChildNode(grdHierarchyRow childRow, ClinicalTeamMemberVo voClinicalTeamMember)
	{
		if (childRow == null || voClinicalTeamMember == null)
			return;
		
		childRow.setcolHcp(voClinicalTeamMember.getHCP() != null ? voClinicalTeamMember.getHCP().getMos().getName().toString() : null);
		if(voClinicalTeamMember.getStartDateIsNotNull())
			childRow.setcolStartDate(voClinicalTeamMember.getStartDate().toString());
		if(voClinicalTeamMember.getEndDateIsNotNull())
			childRow.setcolEndDate(voClinicalTeamMember.getEndDate().toString());
		childRow.setValue(voClinicalTeamMember);
		childRow.setCollapsedImage(form.getImages().Admin.NCHAD);
		childRow.setExpandedImage(form.getImages().Admin.NCHAD);
		
		if (voClinicalTeamMember.getID_ClinicalTeamMember() == null)
			childRow.setTextColor(Color.Red);
	}

	private void resetContextVariables()
	{
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.ctnDetails().lyrDetails().tabDetailsMembers().customControlSearchHCPs().setHCPType(new Boolean(true));
	}
	
	private void resetSearchContextVariables()
	{
		form.getLocalContext().setUpdatedChild(null);		
		form.getLocalContext().setUpdatingParent(new Boolean(false));		
	}
	
	private void clear()
	{
		form.grdHierarchy().getRows().clear();
		form.grdHierarchy().setValue(null);
		clearChildInstanceControls(true);
	}

	private void updateControlsState()
	{
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW));

		// The collapsible container
		form.ctnDetails().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab - need to hide it also 
		if (form.getMode().equals(FormMode.VIEW))
			form.ctnDetails().lyrDetails().tabNoDetailSelected().setVisible(form.grdHierarchy().getValue() == null);

		setParentTabVisability();						
		setDetailsTabVisibility();		
		setMembersDisplayTabVisibility();
		setNoDetailsTabVisibility();
		chooseTab();																				
		
		// The context menus
		updateContextMenusState();		

		
	}
	
	private void setNoDetailsTabVisibility() 
	{
		form.ctnDetails().lyrDetails().tabNoDetailSelected().setHeaderVisible(form.getLocalContext().getSelectedParentInstance() == null);		
	}
	
	private void setMembersDisplayTabVisibility() 
	{		
		boolean bShow = form.getMode().equals(FormMode.VIEW) &&
						form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo; 
		form.ctnDetails().lyrDetails().tabMemberDisplay().setHeaderVisible(bShow);
	}
	
	
	private void setDetailsTabVisibility()
	{ 						
		// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
		// editing a parent.
		boolean bShowDetails = form.getMode().equals(FormMode.EDIT) &&
								form.getLocalContext().getSelectedParentInstanceIsNotNull() &&  		
								form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE) ;		
		form.ctnDetails().lyrDetails().tabDetailsMembers().setHeaderVisible(bShowDetails);
		if (bShowDetails)
			setAddApplyCaption();						

		enableDetailsControls();		
		
	}
	
	private void setParentTabVisability()
	{
		boolean bShow = form.getLocalContext().getSelectedParentInstanceIsNotNull();
		form.ctnDetails().lyrDetails().tabDetailsTeam().setHeaderVisible(bShow);					
		setParentControlVisibility(bShow);
	}

	private void populateParentInstanceControls(ClinicalTeamVo voClinicalTeam)
	{
		form.ctnDetails().lyrDetails().tabDetailsTeam().txtTeamName().setValue(voClinicalTeam.getTeamName());
		form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().setValue(voClinicalTeam.getTeamType());
		
		if (voClinicalTeam.getLeadHCP() != null)
		{
			form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().newRow(voClinicalTeam.getLeadHCP(), voClinicalTeam.getLeadHCP().getMos().getName().toShortForm());
			form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().setValue(voClinicalTeam.getLeadHCP());			
		}
		
		form.ctnDetails().lyrDetails().tabDetailsTeam().chkTeamIsActive().setValue(voClinicalTeam.getIsActive().booleanValue());
	}

	private void populateChildInstanceControls(ClinicalTeamMemberVo voClinicalTeamMember)
	{
		if (voClinicalTeamMember == null)
			return;

		form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayStart().setValue(voClinicalTeamMember.getStartDate() != null ? voClinicalTeamMember.getStartDate() : null);
		form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayEnd().setValue(voClinicalTeamMember.getEndDate() != null ? voClinicalTeamMember.getEndDate() : null);		
		form.ctnDetails().lyrDetails().tabMemberDisplay().chkDisplayIsActive().setValue(voClinicalTeamMember.getIsActive() == null ? false: voClinicalTeamMember.getIsActive().booleanValue() );
				
		if (voClinicalTeamMember.getHCP() != null)
			form.ctnDetails().lyrDetails().tabMemberDisplay().txtDisplayMemberName().setValue(voClinicalTeamMember.getHCP().getMos().getName().toShortForm());
	}
		
	
	private void updateContextMenusState()
	{
		boolean bViewMode = form.getMode().equals(FormMode.VIEW);
		form.getContextMenus().getClinicalTeamNEW_TEAMItem().setVisible(bViewMode && form.getLocalContext().getSelectedParentInstance() == null);
		
		boolean bCanUpdateParent = 	bViewMode && 
									form.getLocalContext().getSelectedParentInstance() != null && 
									form.getLocalContext().getSelectedParentInstance().getID_ClinicalTeam() != null;
									
		form.getContextMenus().getClinicalTeamUPDATE_TEAMItem().setVisible(bCanUpdateParent);
		form.getContextMenus().getClinicalTeamNEW_MEMBERSItem().setVisible(bCanUpdateParent);
		
		form.getContextMenus().getClinicalTeamREMOVE_MEMBERItem().setVisible(form.getLocalContext().getSelectedChildInstance() != null 
				&& form.grdHierarchy().getSelectedRow() != null 
				&& form.grdHierarchy().getSelectedRow().getValue() instanceof ClinicalTeamMemberVo);
		
		form.getContextMenus().getClinicalTeamUPDATE_MEMBERItem().setVisible(form.getLocalContext().getSelectedChildInstance() != null &&
							bViewMode && form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() != null);

	}
	

	
	private ClinicalTeamVo populateInstanceData(ClinicalTeamVo voClinicalTeam)
	{
		if (voClinicalTeam == null)
			voClinicalTeam = new ClinicalTeamVo();
				
		populateParentInstanceData(voClinicalTeam);						

//		if (voClinicalTeam.getID_ClinicalTeam() == null || form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
//			return voClinicalTeam;		
								 
		if (form.getLocalContext().getSelectedChildInstance() == null || 
				(form.getLocalContext().getSelectedChildInstance() != null && form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() == null))			
		{
			// Adding/Removing Child/Children
			populateChildCollectionFromGrid(voClinicalTeam);			
		}
		else 		
		{
			// Update child instance.
			ClinicalTeamMemberVo voClinicalTeamMember = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voClinicalTeamMember);
			form.getLocalContext().setSelectedChildInstance(voClinicalTeamMember);
			
			for (int i=0; i < voClinicalTeam.getTeamMembers().size(); i++)
			{
				if (voClinicalTeam.getTeamMembers().get(i).getID_ClinicalTeamMember() == 
					form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember())
				{						
					voClinicalTeam.getTeamMembers().set(i, form.getLocalContext().getSelectedChildInstance());
					// For reselection post save set the value to the updated child.
					form.grdHierarchy().setValue(form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		
		return voClinicalTeam;				
	}

	
	private void populateChildCollectionFromGrid(ClinicalTeamVo voClinicalTeam)
	{
		if (form.grdHierarchy().getValue() == null) return;

		if (voClinicalTeam.getTeamMembers() == null)
			voClinicalTeam.setTeamMembers(new ClinicalTeamMemberVoCollection());
		
		GenForm.grdHierarchyRow parentRow = form.grdHierarchy().getValue() instanceof ClinicalTeamVo ? 
										    form.grdHierarchy().getSelectedRow() : form.grdHierarchy().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() >= 0 )
        	voClinicalTeam.getTeamMembers().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        	voClinicalTeam.getTeamMembers().add((ClinicalTeamMemberVo) parentRow.getRows().get(i).getValue());
				
	}
	private void populateParentInstanceData(ClinicalTeamVo voClinicalTeam)
	{
		voClinicalTeam.setTeamName(form.ctnDetails().lyrDetails().tabDetailsTeam().txtTeamName().getValue());
		voClinicalTeam.setTeamType(form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().getValue());
		voClinicalTeam.setLeadHCP(form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().getValue());
		voClinicalTeam.setIsActive(new Boolean(form.ctnDetails().lyrDetails().tabDetailsTeam().chkTeamIsActive().getValue()));		
	}
	
	public String[] validateUIRules()
	{
		java.util.ArrayList listOfErrors = new java.util.ArrayList();
		
		if (form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().getValue() == null)
			listOfErrors.add("Lead HCP is mandatory");
				
		if (form.ctnDetails().lyrDetails().tabDetailsMembers().isVisible())
		{
			if (form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().getValue() != null && form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().getValue() != null )
				if (form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().getValue().isGreaterThan(form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().getValue()))
					listOfErrors.add("Start date must be before End Date");													
		}
		
		else if (form.ctnDetails().lyrDetails().tabMemberDisplay().isVisible())
		{
			if (form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayStart().getValue() != null && form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayEnd().getValue() != null)
				if (form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayStart().getValue().isGreaterThan(form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayEnd().getValue()))
					listOfErrors.add("Start date must be before End Date");				
		}
						
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			return null;
		}
		
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);

		return result;			
	}

	private void checkForUnsavedChild() throws PresentationLogicException
	{
		if (form.getLocalContext().getUpdatingParent().booleanValue() == false)
		{
			if (form.getLocalContext().getSelectedChildInstance() == null || 
					(form.getLocalContext().getSelectedChildInstance() != null && form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() == null))
			{
				ClinicalTeamMemberVo voClinicalTeamMember = new ClinicalTeamMemberVo();
				populateChildInstanceData(voClinicalTeamMember);
				newChildNode(voClinicalTeamMember);
			}
		}
	}
	
	
	private void addOrUpdateChild()
	{																
		ClinicalTeamMemberVo voClinicalTeamMember = form.getLocalContext().getSelectedChildInstance();
		
		if (voClinicalTeamMember == null)
			voClinicalTeamMember = new ClinicalTeamMemberVo(); 

		populateChildInstanceData(voClinicalTeamMember);

		if (form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo)
		{
			if (form.grdHierarchy().getSelectedRow() != null) 
				populateChildNode(form.grdHierarchy().getSelectedRow(),voClinicalTeamMember);		

			newChildInstance();
			updateControlsState();
		}
		else
		{
			try
			{
				newChildNode(voClinicalTeamMember);
			}
			catch (PresentationLogicException e)
			{
				engine.showMessage(e.getMessage());
			}
		}
	}
	
	
	
	private void populateChildInstanceData(ClinicalTeamMemberVo voClinicalTeamMember)
	{
		if (voClinicalTeamMember.getID_ClinicalTeamMember() != null)
		{
			if(form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayStart()!=null)
				voClinicalTeamMember.setStartDate(form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayStart().getValue());
			if(form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayEnd()!=null)
				voClinicalTeamMember.setEndDate(form.ctnDetails().lyrDetails().tabMemberDisplay().dteDisplayEnd().getValue());
			voClinicalTeamMember.setIsActive(new Boolean(form.ctnDetails().lyrDetails().tabMemberDisplay().chkDisplayIsActive().getValue()));
		}
		else
		{			
			if(form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().getSelectedRow()!=null)
				voClinicalTeamMember.setHCP(form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().getSelectedRow().getValue());
			if(form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart()!=null)
				voClinicalTeamMember.setStartDate(form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().getValue());
			if(form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd()!=null)
				voClinicalTeamMember.setEndDate(form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().getValue());
			voClinicalTeamMember.setIsActive(new Boolean(form.ctnDetails().lyrDetails().tabDetailsMembers().chkActive().getValue()));						
		}
	}
	
	
	// We need to store the node which was last updated
	private void setUpdatedItem() 
	{ 
		if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
		{
			if (form.getLocalContext().getSelectedParentInstance() != null && form.getLocalContext().getSelectedParentInstance().getID_ClinicalTeam() != null)
			{
				form.getLocalContext().setUpdatedParent(form.getLocalContext().getSelectedParentInstance());					
				return;
			}
		}			
		
		if (form.grdHierarchy().getValue() instanceof ClinicalTeamVo)
		{
			form.getLocalContext().setUpdatedParent((ClinicalTeamVo) form.grdHierarchy().getValue());
		}
		else if (form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo)		
		{
			form.getLocalContext().setUpdatedChild((ClinicalTeamMemberVo) form.grdHierarchy().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				if (form.getLocalContext().getSelectedParentInstance() != null && form.getLocalContext().getSelectedParentInstance().getTeamMembers() != null &&
						form.getLocalContext().getSelectedParentInstance().getTeamMembers().size() > 0)				
				{
					form.getLocalContext().getSelectedParentInstance().getTeamMembers().sort();
					form.getLocalContext().setUpdatedChild(form.getLocalContext().getSelectedParentInstance().getTeamMembers().get(
							form.getLocalContext().getSelectedParentInstance().getTeamMembers().size() - 1));
				}
			}			
		}
	}
	
	
	
	private void promoteChild(ClinicalTeamMemberVo voClinicalTeamMember) 
	{
		if (voClinicalTeamMember == null) 
			return;		
		
		if (form.grdHierarchy().getSelectedRow() != null)
			form.grdHierarchy().getSelectedRow().setExpanded(true);
		
		GenForm.grdHierarchyRow childRow = 
			form.grdHierarchy().getSelectedRow().getRows().newRow();

		populateChildNode(childRow, voClinicalTeamMember);
		form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().removeSelectedRow();
	}
	
	private void setAddApplyCaption() 
	{
		form.ctnDetails().lyrDetails().tabDetailsMembers().btnOK().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo))
				form.ctnDetails().lyrDetails().tabDetailsMembers().btnOK().setText("Apply");
	}
	
	
	private void enableDetailsControls()
	{					
		boolean boolAddnew = form.getMode().equals(FormMode.EDIT) &&
							  form.ctnDetails().lyrDetails().tabDetailsMembers().isHeaderVisible() &&
							  form.getLocalContext().getSelectedChildInstance() != null &&
							  form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() == null;
		
		form.ctnDetails().lyrDetails().tabDetailsMembers().btnOK().setVisible(boolAddnew);
		form.ctnDetails().lyrDetails().tabDetailsMembers().btnCancelDetails().setVisible(boolAddnew);
		form.ctnDetails().lyrDetails().tabDetailsMembers().setcustomControlSearchHCPsEnabled(boolAddnew);		

		boolean boolEdit = 	form.getMode().equals(FormMode.EDIT) &&
		  						form.ctnDetails().lyrDetails().tabDetailsMembers().isHeaderVisible() &&		  								
								form.getLocalContext().getSelectedChildInstance() != null &&
								form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() != null;
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().setEnabled(boolEdit || boolAddnew);
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().setEnabled(boolEdit || boolAddnew);
		form.ctnDetails().lyrDetails().tabDetailsMembers().chkActive().setEnabled(boolEdit || boolAddnew);
		
		form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().setReadOnly(true);		
	}
	

	private void setParentControlVisibility(boolean boolShow)
	{		
		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT)); 		
		form.ctnDetails().lyrDetails().tabDetailsTeam().txtTeamName().setEnabled(boolEnabled);
		form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().setEnabled(boolEnabled);
		form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().setEnabled(boolEnabled);
		form.ctnDetails().lyrDetails().tabDetailsTeam().chkTeamIsActive().setEnabled(boolEnabled);		
	}
	
	
	private void chooseTab() 
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			if (form.getLocalContext().getSelectedParentInstance() == null)
				form.ctnDetails().lyrDetails().showtabNoDetailSelected();			

			// In view mode just show the selected node 
			if (form.grdHierarchy().getValue() instanceof ClinicalTeamVo)		
				form.ctnDetails().lyrDetails().showtabDetailsTeam();
			else if (form.grdHierarchy().getValue() instanceof ClinicalTeamMemberVo)
				form.ctnDetails().lyrDetails().showtabMemberDisplay();
			
		}	
		else
		{
			boolean bNewParent = form.getLocalContext().getSelectedParentInstanceIsNotNull() && form.getLocalContext().getSelectedParentInstance().getID_ClinicalTeam() == null;			
			
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE) || bNewParent) 
				form.ctnDetails().lyrDetails().showtabDetailsTeam();
			else
			{
				if (form.getLocalContext().getSelectedChildInstance() == null || form.getLocalContext().getSelectedChildInstance().getID_ClinicalTeamMember() == null) 
					form.ctnDetails().lyrDetails().showtabDetailsMembers();
				else
					form.ctnDetails().lyrDetails().showtabMemberDisplay();
			}
		}
		
		
		
		
	}
	
	private void clearChildInstanceControls(boolean boolIncludeTeamMembers)
	{
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteStart().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsMembers().dteEnd().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsMembers().chkActive().setValue(true);
		
		if (boolIncludeTeamMembers)		
		{
			form.ctnDetails().lyrDetails().tabDetailsMembers().customControlSearchHCPs().clear();
			form.ctnDetails().lyrDetails().tabDetailsMembers().grdTeamMembers().getRows().clear();			
		}
	}
	
	
	private void clearParentInstanceControls()
	{
		form.ctnDetails().lyrDetails().tabDetailsTeam().txtTeamName().setValue("");
		form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().setValue(null);
		form.ctnDetails().lyrDetails().tabDetailsTeam().chkTeamIsActive().setValue(true);		
	}
	
	
	
	
	private void initialize()
	{
		form.chkSearchActiveTeams().setValue(true);
		form.ctnDetails().lyrDetails().tabDetailsMembers().chkActive().setValue(true);
		resetContextVariables();
	}

	
	private void listHCPs(String value) 
	{
		form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().clear();

		MemberOfStaffShortVo voFilter = new MemberOfStaffShortVo();
		if (value != null)
		{
			PersonName voName = new PersonName();
			voName.setSurname(value);
			voFilter.setName(voName);
		}

		HcpLiteVoCollection voCollHCPLites = new HcpLiteVoCollection();		
		if (form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().getValue() != null && form.ctnDetails().lyrDetails().tabDetailsTeam().cmbTeamType().getValue().equals(ClinicalTeamType.CONSULTANTTEAM))		    
		{
			Hcp voHcp = new Hcp();		
			voHcp.setHcpType(HcpDisType.MEDICAL);
			voFilter.setHcp(voHcp);
		}

		voCollHCPLites = domain.listHcpLites(voFilter);
		for (int i = 0; i < voCollHCPLites.size(); i++)
			form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().newRow(voCollHCPLites.get(i), voCollHCPLites.get(i).getMos().getName().toString());			
				
		if (voCollHCPLites.size() == 1)
		{
			form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().setValue(voCollHCPLites.get(0));
		}
		else if (voCollHCPLites.size() > 1)
			form.ctnDetails().lyrDetails().tabDetailsTeam().qmbTeamLead().showOpened();
	}

	
	private void clearSearchCriteria()
	{
		ClinicalTeamSearchCriteriaVo voSearchCriteria =  new ClinicalTeamSearchCriteriaVo();
		voSearchCriteria.setActive(new Boolean(true));
		form.getLocalContext().setTeamSearchCriteria(voSearchCriteria);		
	}	
	
	
}
