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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.42 build 2202.25904)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.ultrasound;

import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.UltrasoundTargetAndArea;
import ims.therapies.vo.ElectrotherapyUltrasoundShortVo;
import ims.therapies.vo.ElectrotherapyUltrasoundShortVoCollection;
import ims.therapies.vo.ElectrotherapyUltrasoundTreatmentVo;
import ims.therapies.vo.ElectrotherapyUltrasoundTreatmentVoCollection;
import ims.therapies.vo.ElectrotherapyUltrasoundVo;
import ims.therapies.vo.TreatmentEquipmentConfigVo;
import ims.therapies.vo.TreatmentEquipmentConfigVoCollection;
import ims.therapies.vo.lookups.TreatmentEquipmentTypeConfig;
import ims.vo.LookupInstVo;

import java.util.ArrayList;


public class Logic extends BaseLogic
{
	protected void onFormOpen() throws PresentationLogicException
	{
		initialize();
		open();
	}

	protected void onGrdSummarySelectionChanged() throws PresentationLogicException
	{
		getSelectedInstance();
	}

	protected void onFormModeChanged() 
	{
		updateControlsState();		
	}

	protected void onBtnNewClick() throws PresentationLogicException
	{
		newInstance();
	}

		
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();					
	}

	protected void onBtnCancelDetailsClick() throws PresentationLogicException
	{
		clearChildInstanceControls();
	}
	
	protected void onBtnOkClick() throws PresentationLogicException
	{		
		addOrUpdateChild();
	}

	private boolean addOrUpdateChild() 
	{
		if (form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))			
			newParentNode(form.getLocalContext().getSelectedParentInstance());			
				
		ElectrotherapyUltrasoundTreatmentVo voEUltrasoundTreatment = form.getLocalContext().getSelectedChildInstance();
		
		if (voEUltrasoundTreatment == null)
			voEUltrasoundTreatment = new ElectrotherapyUltrasoundTreatmentVo(); 

		populateChildInstanceData(voEUltrasoundTreatment);

		if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)
		{
			promoteUpdatedChild(voEUltrasoundTreatment);
			newChildInstance();
			updateControlsState();
		}
		else
		{
			if(newChildNode(voEUltrasoundTreatment))
				return true;
		}
		return false;
	}
	
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException
	{
		setAuthoringCP(value);		
	}

	protected void onCmbMachineValueChanged() throws PresentationLogicException
	{
		setMachineValues();		
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
		ElectrotherapyUltrasoundShortVo voParent = (ElectrotherapyUltrasoundShortVo) form.grdHierarchy().getSelectedRow().getParentRow().getValue();
		form.grdHierarchy().removeSelectedRow();
		form.grdHierarchy().setValue(voParent);
		updateContextMenusState();
	}


	protected void onCmbTargetValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		targetChanged();
	}
	
	public void initialize() 
	{		
		form.ctnUltra().setCollapsed(true);
		form.ctnUltra().lyrUltra().tabEmpty().setHeaderVisible(false);
		loadTargetCombo();
		loadMachineUsedCombo();		
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

	private void reselectUpdatedNode() 
	{
		// Pattern demands that the last updated node is displayed
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdHierarchy().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
	}
		

	private void newInstance()
	{
		// New instance has been invoked for a parent instance with no current selection made OR
		// with a parent that is not the Golden node..
		if (form.grdHierarchy().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
				&& form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))))
		{
			newParentInstance();			
		}

		// New instance has been invoked with a child node selected.
		if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)
		{
			newChildInstance();
		}
		
		
		form.setMode(FormMode.EDIT);		
	}


	private void newChildInstance() 
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		form.grdHierarchy().setValue(form.grdHierarchy().getSelectedRow().getParentRow().getValue());
	}

	/**
	 * Invoked when the user clicks OK to add a new element to the child array
	 * Basically we update the hierarchy grid with the newly added details clearing the control
	 * to facilitate new input. We then update the local context variable with the new child 
	 *
	 */
	private boolean newChildNode(ElectrotherapyUltrasoundTreatmentVo voEUltrasoundTreatment) 
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) return false;
		
		if (voEUltrasoundTreatment.countFieldsWithValue() > 1)
		{
			String strErrors[] = voEUltrasoundTreatment.validate(validateUIRules());
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}
	 				
			promoteChild(voEUltrasoundTreatment);			
			clearChildInstanceControls();
		}
		return false;
	}



	private void updateInstance()
	{								
		form.getLocalContext().setUpdatingParent(Boolean.valueOf(form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo));
		
		if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)			
		{
			ElectrotherapyUltrasoundTreatmentVo voCachedChild = (ElectrotherapyUltrasoundTreatmentVo) form.grdHierarchy().getValue(); 
			if ( voCachedChild.getID_ElectrotherapyUltrasoundTreatment() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}			
		}
		
		form.setMode(FormMode.EDIT);		
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
		if(form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo)
		{									 
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ElectrotherapyUltrasoundShortVo) form.grdHierarchy().getValue()));
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)
		{
//			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ElectrotherapyUltrasoundShortVo) form.grdHierarchy().getSelectedRow().getParentRow().getValue()));
			form.getLocalContext().setSelectedChildInstance((ElectrotherapyUltrasoundTreatmentVo) form.grdHierarchy().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
		}
 
		form.getLocalContext().setGoldenInstanceSelected(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? Boolean.valueOf(form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())) : Boolean.FALSE);
		
		updateControlsState();
	}
	
	
	private boolean save() 
	{										
		if(checkForUnsavedChild())
			return false;
		
		ElectrotherapyUltrasoundVo voElectrotherapyUltrasound  = populateInstanceData(form.getLocalContext().getSelectedParentInstance());
		
		if (voElectrotherapyUltrasound.getClinicalContact() == null)
			voElectrotherapyUltrasound.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		String[] arrErrors; 
		//WDEV-15389
		if (form.getLocalContext().getSelectedChildInstanceIsNotNull() && form.getLocalContext().getSelectedChildInstance().countFieldsWithValue() >= 1)
			arrErrors =  voElectrotherapyUltrasound.validate(validateUIRules());
		else
			arrErrors =  voElectrotherapyUltrasound.validate();
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.save(voElectrotherapyUltrasound));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Ultrasound record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		
		setUpdatedChild();
		return true;		
	}


	// We need to store the node which was last updated
	private void setUpdatedChild() 
	{
		// Straight child update - Select the currently being updated child as the one so show - post save
		if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)		
		{
			form.getLocalContext().setUpdatedChild((ElectrotherapyUltrasoundTreatmentVo) form.grdHierarchy().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				form.getLocalContext().getSelectedParentInstance().getUltrasoundTreatments().sort();
				form.getLocalContext().setUpdatedChild(
						form.getLocalContext().getSelectedParentInstance().getUltrasoundTreatments().get(
								form.getLocalContext().getSelectedParentInstance().getUltrasoundTreatments().size() - 1));
			}
			
		}
	}
			

	/**
	 * Invoked as part of the save routine. The user may have entered data in the details tab and not 
	 * bothered clicking ok. This method counts thae vo fields to decide if it should promote the unsaved
     * data entry to the hierarchy grid before saving.	 	
	 **/ 
	private boolean checkForUnsavedChild() 
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{				
			if(addOrUpdateChild())
				return true;
		}
		return false;
	}


	private void promoteUpdatedChild(ElectrotherapyUltrasoundTreatmentVo voEUltrasoundTreatment) 
	{
		if (voEUltrasoundTreatment == null) return;
		populateChildNode(form.grdHierarchy().getSelectedRow(),voEUltrasoundTreatment);		
	}


	private void newParentInstance() 
	{
		ElectrotherapyUltrasoundVo voNewParent = new ElectrotherapyUltrasoundVo(); 		
		voNewParent.setAuthoringCP(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getResponsibleHCP());
		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setUltrasoundTreatments(new ElectrotherapyUltrasoundTreatmentVoCollection());
		populateParentInstanceControls(voNewParent);		
		form.getLocalContext().setSelectedParentInstance(voNewParent);					
	}

	private void newParentNode(ElectrotherapyUltrasoundVo voNewParent) 
	{
		if (voNewParent == null) return;
	
		ElectrotherapyUltrasoundShortVo voParentShort = new ElectrotherapyUltrasoundShortVo();
		voParentShort.setAuthoringCP(voNewParent.getAuthoringCP());
		voParentShort.setAuthoringDateTime(voNewParent.getAuthoringDateTime());
		voParentShort.setClinicalContact(voNewParent.getClinicalContact());
		
		GenForm.grdHierarchyRow parentRow = form.grdHierarchy().getRows().newRow();			
		parentRow.setColTarget(voParentShort.getAuthoringDateTime().toString()+ " - " + 
							   voParentShort.getAuthoringCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(Boolean.TRUE);
		parentRow.setExpanded(true);
		form.grdHierarchy().setValue(voParentShort);		
	}
	
/**
 * @calls the Domain Get for the selected node..
 * 
 */	
	private void expandParentNode(GenForm.grdHierarchyRow selectedRow)
	{
		if (selectedRow.getValue() instanceof ElectrotherapyUltrasoundShortVo == false ) return;
				
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ElectrotherapyUltrasoundShortVo) selectedRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		ElectrotherapyUltrasoundVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		if(voParentInstance.getClinicalContact().getID_ClinicalContact().equals
									(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(Boolean.TRUE);
			form.getLocalContext().setGoldenInstanceSelected(Boolean.TRUE);
			selectedRow.setBackColor(Color.Beige);			
		}
		
		if (voParentInstance.getUltrasoundTreatments() != null)  
		{
			selectedRow.setExpanded(true);
			populateChildNodes(selectedRow, voParentInstance.getUltrasoundTreatments());
		}
		
		populateParentInstanceControls(voParentInstance);		
										
	}
			
	
	private ElectrotherapyUltrasoundVo getParentFromDomain(ElectrotherapyUltrasoundShortVo voEUltraShort)
	{ 				
		return domain.getUltrasound(voEUltraShort);						
	}	
			
	
	public String[] validateUIRules() //WDEV-15389
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue() == null)
		{
			listOfErrors.add("Target is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			
			return result;
		}
		
		return null;
		
	}
		
	/**
	 * Populates the Hierarchy tree with the contents of the ElectrotherapyUltrasoundShortVoCollection
	 * Selects the item that matches the current SOAP clinical contact 
	 * Sets that items background colour to LightYellow and expands that node.
	 * @param voCollUltrasoundParents
	 */
	private void populateParentNodes(ElectrotherapyUltrasoundShortVoCollection voCollUltrasoundParents)
	{
		if (voCollUltrasoundParents == null || voCollUltrasoundParents.size() <= 0 ) return;
		
		for(int i=0; i<voCollUltrasoundParents.size(); i++)
		{
			populateParentNode(voCollUltrasoundParents.get(i));			
		}		
	}

	private void populateParentNode(ElectrotherapyUltrasoundShortVo voUltrasoundParent) 
	{
		GenForm.grdHierarchyRow parRow = form.grdHierarchy().getRows().newRow();
		parRow.setColTarget(voUltrasoundParent.getAuthoringDateTime().toString()+ " - " + 
				            voUltrasoundParent.getAuthoringCP().toString());
		
		parRow.setValue(voUltrasoundParent);			
		if(voUltrasoundParent != null 
			&& voUltrasoundParent.getClinicalContactIsNotNull()
			&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
			&& voUltrasoundParent.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			form.grdHierarchy().setValue(voUltrasoundParent);			
			expandParentNode(parRow);
		}
	}
		
	
	/**
	 * Given a row in the hierarchy row get the collection of treatments associated
	 * with that ultrasound and and create a child treenode for each. Use a Red 
	 * text colour to denote any as yes unsaved treatments.
	 * @param voCollTreatments
	 * @param parRow
	 */			
	private void populateChildNodes(GenForm.grdHierarchyRow parRow, ElectrotherapyUltrasoundTreatmentVoCollection voCollTreatments)
	{
		if (voCollTreatments == null || voCollTreatments.size()<=0) return;		
		
		voCollTreatments.sort();
		for(int i=0; i<voCollTreatments.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdHierarchyRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voCollTreatments.get(i));				
			}
		}
	}

	private void populateChildNode(GenForm.grdHierarchyRow childRow, ElectrotherapyUltrasoundTreatmentVo voUltraTreat) 
	{		
		if (voUltraTreat == null) return;		
					
		childRow.setValue(voUltraTreat);
		if(voUltraTreat.getTarget() != null)
			childRow.setColTarget(voUltraTreat.getTarget().toString());
		if(voUltraTreat.getAreaTreated() != null)
			childRow.setColAreaTreated(voUltraTreat.getAreaTreated().toString());
		if(voUltraTreat.getMuscleAspect() != null)
			childRow.setColMuscleAspect(voUltraTreat.getMuscleAspect().toString());
		if(voUltraTreat.getLaterality() != null)
			childRow.setColLaterality(voUltraTreat.getLaterality().toString());			
		childRow.setValue(voUltraTreat);
	
		//if not saved then set the colour
		if(voUltraTreat.getID_ElectrotherapyUltrasoundTreatment() == null)
			childRow.setTextColor(Color.Red);
	}
	
	private void populateParentInstanceControls(ElectrotherapyUltrasoundVo voUltraParent)
	{
		if(voUltraParent != null)
		{
			form.ctnUltra().lyrUltra().tabHeader().dtimAuthoringDateTime().setValue(voUltraParent.getAuthoringDateTime());
			form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().newRow(voUltraParent.getAuthoringCP(), voUltraParent.getAuthoringCP().toString());
			form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().setValue(voUltraParent.getAuthoringCP());
			form.ansWarning().setValue(voUltraParent.getWarningGiven());
		}
	}

	private void populateChildInstanceControls(ElectrotherapyUltrasoundTreatmentVo voUltraTreat)
	{	
		if (voUltraTreat == null ) return;
				
		form.ctnUltra().lyrUltra().tabDetails().cmbTarget().setValue(voUltraTreat.getTarget());
		if(voUltraTreat.getAreaTreated() != null)
			form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().newRow(voUltraTreat.getAreaTreated(), voUltraTreat.getAreaTreated().toString());

		form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().setValue(voUltraTreat.getAreaTreated());
		form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setValue(voUltraTreat.getMuscleAspect());
		form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().setValue(voUltraTreat.getLaterality());
		form.ctnUltra().lyrUltra().tabDetails().txtComment().setValue(voUltraTreat.getComment());
		form.ctnUltra().lyrUltra().tabDetails().cmbWave().setValue(voUltraTreat.getWave());
		form.ctnUltra().lyrUltra().tabDetails().cmbPulse().setValue(voUltraTreat.getPulse());
		form.ctnUltra().lyrUltra().tabDetails().cmbFreq().setValue(voUltraTreat.getFrequency());
		form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().setValue(voUltraTreat.getIntensity());
		form.ctnUltra().lyrUltra().tabDetails().intDuration().setValue(voUltraTreat.getDuration());
  
		TreatmentEquipmentConfigVo 	voTreatmentEquipment = voUltraTreat.getMachineUsed();
		form.ctnUltra().lyrUltra().tabDetails().cmbMachine().setValue(voTreatmentEquipment);
		form.ctnUltra().lyrUltra().tabDetails().txtModel().setValue(voTreatmentEquipment != null ? voTreatmentEquipment.getModel() : null);
		form.ctnUltra().lyrUltra().tabDetails().txtSerial().setValue(voTreatmentEquipment != null ? voTreatmentEquipment.getSerialNumber(): null);		
	}	
		
	private ElectrotherapyUltrasoundVo populateInstanceData(ElectrotherapyUltrasoundVo voElectrotherapyUltrasound)
	{

		if (voElectrotherapyUltrasound == null)
			voElectrotherapyUltrasound = new ElectrotherapyUltrasoundVo();
				
		populateParentInstanceData(voElectrotherapyUltrasound);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voElectrotherapyUltrasound);			
		}
		else 		// Update child instance.
		{
			ElectrotherapyUltrasoundTreatmentVo voUltraTreat = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voUltraTreat);
			form.getLocalContext().setSelectedChildInstance(voUltraTreat);
			
			for (int i=0; i < voElectrotherapyUltrasound.getUltrasoundTreatments().size(); i++)
			{
				if (voElectrotherapyUltrasound.getUltrasoundTreatments().get(i).getID_ElectrotherapyUltrasoundTreatment().equals(form.getLocalContext().getSelectedChildInstance().getID_ElectrotherapyUltrasoundTreatment()))
				{						
					voElectrotherapyUltrasound.getUltrasoundTreatments().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voElectrotherapyUltrasound;		
	}

	private void populateParentInstanceData(ElectrotherapyUltrasoundVo voEUltrasound) 
	{
		voEUltrasound.setAuthoringCP(form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().getValue());
		voEUltrasound.setAuthoringDateTime(form.ctnUltra().lyrUltra().tabHeader().dtimAuthoringDateTime().getValue());		
		voEUltrasound.setWarningGiven(form.ansWarning().getValue());
	}

	private void populateChildInstanceData(ElectrotherapyUltrasoundTreatmentVo voUltraTreat) 
	{
		voUltraTreat.setTarget(form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue());
		voUltraTreat.setAreaTreated(form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().getValue());
		voUltraTreat.setMuscleAspect(form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().getValue());
		voUltraTreat.setLaterality(form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().getValue());
		voUltraTreat.setComment(form.ctnUltra().lyrUltra().tabDetails().txtComment().getValue());			
		voUltraTreat.setWave(form.ctnUltra().lyrUltra().tabDetails().cmbWave().getValue());
		voUltraTreat.setPulse(form.ctnUltra().lyrUltra().tabDetails().cmbPulse().getValue());
		voUltraTreat.setFrequency(form.ctnUltra().lyrUltra().tabDetails().cmbFreq().getValue());
		voUltraTreat.setIntensity(form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().getValue());
		voUltraTreat.setDuration(form.ctnUltra().lyrUltra().tabDetails().intDuration().getValue());
				
		TreatmentEquipmentConfigVo 	voTreatmentEquipment = form.ctnUltra().lyrUltra().tabDetails().cmbMachine().getValue(); 		
		if (voTreatmentEquipment == null)
			voTreatmentEquipment = new TreatmentEquipmentConfigVo();
		
		voTreatmentEquipment.setModel(form.ctnUltra().lyrUltra().tabDetails().txtModel().getValue());
		voTreatmentEquipment.setSerialNumber(form.ctnUltra().lyrUltra().tabDetails().txtSerial().getValue());
		voUltraTreat.setMachineUsed(voTreatmentEquipment);
	}
	
	private void populateChildCollectionFromGrid(ElectrotherapyUltrasoundVo voElectrotherapyUltrasound) 
	{
		if (form.grdHierarchy().getValue() == null) return;

		if (voElectrotherapyUltrasound.getUltrasoundTreatments() == null)
			voElectrotherapyUltrasound.setUltrasoundTreatments(new ElectrotherapyUltrasoundTreatmentVoCollection());
		
		GenForm.grdHierarchyRow parentRow = form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo ? 
										    form.grdHierarchy().getSelectedRow() : form.grdHierarchy().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voElectrotherapyUltrasound.getUltrasoundTreatments().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
        	voElectrotherapyUltrasound.getUltrasoundTreatments().add((ElectrotherapyUltrasoundTreatmentVo) parentRow.getRows().get(i).getValue());
        }
	}

	private void promoteChild(ElectrotherapyUltrasoundTreatmentVo voEUltrasoundTreatment) 
	{
		if (voEUltrasoundTreatment == null) return;
		GenForm.grdHierarchyRow childRow = form.grdHierarchy().getSelectedRow().getRows().newRow();		
		populateChildNode(childRow, voEUltrasoundTreatment);			
	}
	
	
	public void updateControlsState()
	{				
		// The new button
		form.btnNew().setVisible( form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getMode().equals(FormMode.VIEW) 
				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == false);

		// The collapsible container
		form.ctnUltra().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab
		if (form.grdHierarchy().getValue() == null)
			form.ctnUltra().lyrUltra().showtabEmpty();

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
			if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo)		
				form.ctnUltra().lyrUltra().showtabHeader();
			else if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)
				form.ctnUltra().lyrUltra().showtabDetails();
			else
				form.ctnUltra().lyrUltra().showtabEmpty();
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnUltra().lyrUltra().showtabHeader();
			else
				form.ctnUltra().lyrUltra().showtabDetails();
		}
	}

	private void setParentTabVisability() 
	{
		form.ctnUltra().lyrUltra().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());					
		enableParentControls();		
	}

	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	
			// In view mode, make the details tab visible if a detail instance is selected in the hierarchy grid.  
			form.ctnUltra().lyrUltra().tabDetails().setHeaderVisible(form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo);									
		}
		else
		{			
			// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
			// editing a parent.
			form.ctnUltra().lyrUltra().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));
			
			setAddApplyCaption();			
		}			

		enableDetailsButtons();		
	}
	
	
	private void setAddApplyCaption() 
	{
		form.ctnUltra().lyrUltra().tabDetails().btnOk().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo))
				form.ctnUltra().lyrUltra().tabDetails().btnOk().setText("Apply");
		
				
	}

	private void updateContextMenusState()
	{									
		if(form.getLocalContext().getGoldenInstanceSelected().booleanValue())
		{
			// If the golden instance is currently selected we change the text of the update context menu
			// based on whether a parent or child node is selected in the grid.
			if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo)
				form.getContextMenus().getGenericGridUpdateItem().setText("Update Electrotherapy Ultrasound");						
			else if (form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo)
				form.getContextMenus().getGenericGridUpdateItem().setText("Update Ultrasound Treatment");
			
			// If the golden node is selected we can now only add child nodes so set the menu text accordingly.
			form.getContextMenus().getGenericGridAddItem().setText("Add Ultrasound Treatment");			

			// Only show the update menu if the user has selected an item to update.
			form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																		 form.grdHierarchy().getSelectedRowIndex()>=0) ||
																		 (form.getMode().equals(FormMode.EDIT) &&
																		 form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo &&
																		 ((ElectrotherapyUltrasoundTreatmentVo)form.grdHierarchy().getValue()).getID_ElectrotherapyUltrasoundTreatment() == null));																								
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
				form.getContextMenus().getGenericGridAddItem().setText("New Electrotherapy Ultrasound");
				form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
			}
		}
		
		form.getContextMenus().getGenericGridAddItem().setVisible(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getMode().equals(FormMode.VIEW));
		form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
				 form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundTreatmentVo &&
				 ((ElectrotherapyUltrasoundTreatmentVo)form.grdHierarchy().getValue()).getID_ElectrotherapyUltrasoundTreatment() == null);
		
	}
	
	/**
	 * Set's the visibility of the OK and Cancel buttons.
	 * Essentially if we are adding a new child then we want to see both buttons
	 * Otherwise we don't
	 */
	private void enableDetailsButtons()
	{					
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
							  form.ctnUltra().lyrUltra().tabDetails().isHeaderVisible() &&
							  form.getLocalContext().getSelectedChildInstance() == null);
		
		form.ctnUltra().lyrUltra().tabDetails().btnOk().setVisible(boolVisible);
		form.ctnUltra().lyrUltra().tabDetails().btnCancelDetails().setVisible(boolVisible);
	}
	

	private void enableParentControls()
	{
		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT) && 
							  form.grdHierarchy().getValue() instanceof ElectrotherapyUltrasoundShortVo);
		
		form.ctnUltra().lyrUltra().tabHeader().dtimAuthoringDateTime().setEnabled(boolEnabled);
		form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().setEnabled(boolEnabled);
	}
	
	public void clear()
	{		
		form.grdHierarchy().getRows().clear();		
		clearChildInstanceControls();
	}
	
	private void clearChildInstanceControls()
	{
		// Details tab
		form.ctnUltra().lyrUltra().tabDetails().cmbTarget().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().txtComment().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbMachine().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().txtModel().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().txtSerial().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbWave().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbPulse().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbFreq().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().setValue(null);
		form.ctnUltra().lyrUltra().tabDetails().intDuration().setValue(null);
	}


	private void loadMachineUsedCombo()
	{				
		TreatmentEquipmentConfigVoCollection voCollTreatmentEquipment = domain.listTreatmentEquipmentConfigs(TreatmentEquipmentTypeConfig.ULTRASOUND);
		if (voCollTreatmentEquipment != null)
		{
			for (int i = 0; i < voCollTreatmentEquipment.size(); i++) 
				form.ctnUltra().lyrUltra().tabDetails().cmbMachine().newRow(voCollTreatmentEquipment.get(i), 
															voCollTreatmentEquipment.get(i).getDescription());
		}
	}

	private void setMachineValues() 
	{
		if(form.ctnUltra().lyrUltra().tabDetails().cmbMachine().getValue() != null)
		{
			TreatmentEquipmentConfigVo 	voTreatmentEquipment = form.ctnUltra().lyrUltra().tabDetails().cmbMachine().getValue();
			form.ctnUltra().lyrUltra().tabDetails().txtModel().setValue(voTreatmentEquipment.getModel());
			form.ctnUltra().lyrUltra().tabDetails().txtSerial().setValue(voTreatmentEquipment.getSerialNumber());
		}
		else //WDEV-15389
		{
			form.ctnUltra().lyrUltra().tabDetails().txtModel().setValue(null);
			form.ctnUltra().lyrUltra().tabDetails().txtSerial().setValue(null);
		}
	}
	
	private void checkMuscleCombo()
	{
/*		if(form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue() != null)
		{
			if(form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue().equals(UltrasoundTargetAndArea.MUSCLE))
				form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setEnabled(true);
			else
				form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setEnabled(false);
		}
		*/
	}

	private void loadTargetCombo()
	{
		TreeNode[] coll = LookupHelper.getUltrasoundTargetAndArea(domain.getLookupService()).getRootNodes();
				
		if(coll != null)
		{
			for(int i=0;i<coll.length;i++)
			{
				UltrasoundTargetAndArea item = (UltrasoundTargetAndArea)coll[i];
				if(item.isActive())
					form.ctnUltra().lyrUltra().tabDetails().cmbTarget().newRow(item, item.getText());
			}
		}	
	}	

	private void setAuthoringCP(String value) 
	{
		form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().clear();
				
		HcpLiteVoCollection coll = domain.listHcpLiteByName(value);
		for (int i = 0; i < coll.size(); i++)
		{
			HcpLiteVo med = coll.get(i);
			form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().newRow(med, med.toString());			
		}
		
		if (coll.size() == 1)
			form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().setValue(coll.get(0));
		else if (coll.size() > 1)
			form.ctnUltra().lyrUltra().tabHeader().qmbAuthoringCP().showOpened();
	}
	
	private void targetChanged() 
	{
		form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().clear();
		if(form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue() == null) 
			return;

		ArrayList<LookupInstVo> coll = form.ctnUltra().lyrUltra().tabDetails().cmbTarget().getValue().getChildInstances();
		form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setValue(null);
		UltrasoundTargetAndArea type = null;
		for(int i=0;i<coll.size();i++)
		{
			type = (UltrasoundTargetAndArea)coll.get(i);
			if(type.isActive())
				form.ctnUltra().lyrUltra().tabDetails().cmbAreaTreated().newRow((UltrasoundTargetAndArea) coll.get(i), coll.get(i).toString());
		}
		
		checkMuscleCombo();
	}
		
	private void resetContextVariables() 
	{
		form.getLocalContext().setGoldenInstanceSelected(Boolean.FALSE);
		form.getLocalContext().setGoldenInstanceFound(Boolean.FALSE);
		form.getLocalContext().setUpdatingParent(Boolean.FALSE);
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);		
	}
	
	
}
