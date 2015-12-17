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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2348.20080)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.clinicadmin;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ClinicLiteVo;
import ims.core.vo.ClinicVo;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.ArrayList;

/**
 * Used to manage\maintain clinics
 * A clinic exists in the context of a location
 * Display the clinics in a tree (hierarchy - Hospital\Location as parent nodes
 * Child Nodes will be clinics) 
 *
 * @author bworwood, jmacenri, nmcanaspie
 *
 */

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	/**
	 * OnFormOpn: Initialise the form and load relevant details.
	 * @throws ims.framework.exceptions.PresentationLogicException
	 */	 
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	/**
	 * Initialize the form by loading in the defaults such as combos
	 */	 
	private void initialize()
	{
		loadLocationCombos();
		//wdev-13445
		String orderingClinicLoc = ConfigFlag.GEN.ORDERING_CLINIC_LOCATION_MANDATORY_FIELDS.getValue();
		if(orderingClinicLoc == "Outpatient Department" || orderingClinicLoc == "Clinic and Outpatient Department")
		{
			form.cmbOutpatient().setRequired(true);
		}
		else
		{
			form.cmbOutpatient().setRequired(false);
		}
			
		//----------
	}
	/**
	 * Populate the location combos (One used in Search Criteria and the other in teh details
	 * List only active location sites 
	 */	 
	private void loadLocationCombos()
	{
		LocationLiteVoCollection voLocationLiteColl = domain.listActiveHospitalsLite();
		for(int i=0; i<voLocationLiteColl.size(); i++)
		{
			form.cmbClinicLoc().newRow(voLocationLiteColl.get(i), voLocationLiteColl.get(i).getName().toString());
			form.cmbSearchLoc().newRow(voLocationLiteColl.get(i), voLocationLiteColl.get(i).getName().toString());
		}
	}
	
	/**
	 * Clear the form of all details, set the default state and retrieve record based on the last selected record (saved record) 
	 * Update the controls state 
	 */	 
	private void open()
	{
		clear();
		//updateControlsState(); WDEV-11914
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			populateSearchCriteriaAndSearch(form.getLocalContext().getSelectedRecord());
		}
		
		//WDEV-11914
		form.setMode(FormMode.VIEW);
	}
	/**
	 * Default in the search critera based on the details passed in the parameter
	 * If the parameter is not null retrieve any matching records and populate the tree 
	 * @param ClinicVo
	 */	 
	private void populateSearchCriteriaAndSearch(ClinicVo voClinic)
	{
		if (voClinic != null && voClinic.getID_ClinicIsNotNull())
		{
			form.cmbSearchLoc().setValue(voClinic.getClinicLocation());
			
			//WDEV-11914
			loadSearchOutpatientDepartment(form.cmbSearchLoc().getValue());
			
			form.txtSearchName().setValue(voClinic.getClinicName());
			form.chkSearchAciveOnly().setValue(voClinic.getIsActive());
			
			if (voClinic.getID_ClinicIsNotNull() && (voClinic.getClinicNameIsNotNull() || voClinic.getMapping(TaxonomyType.PAS) != null || voClinic.getClinicLocationIsNotNull()))
			{
				search();
			}
		}
		
	}
	/**
	 * Clear the search criteria fields and clinic details fields. 
	 */	 
	private void clear()
	{
		clearSearchCriteria();
		clearInstanceDetails();
	}

	/**
	 * Clear the the clinic details fields. 
	 */
	private void clearInstanceDetails()
	{
		
		form.TaxonomyMappings().clear();
		form.cmbClinicLoc().setValue(null);
		
		//WDEV-11914
		form.cmbOutpatient().clear();
		
		form.txtName().setValue(null);
		form.chkSearchAciveOnly().setValue(true);
	
	}

	/**
	 * Clear the the Search criteria. 
	 */
	private void clearSearchCriteria()
	{
		form.cmbSearchLoc().setValue(null);
		
		//WDEV-11914
		form.cmbSearchOutpatient().clear();
		
		form.txtSearchCode().setValue(null);
		form.txtSearchName().setValue(null);
		form.treClinics().clear();
		form.chkActive().setValue(false);
		
	}

	/**
	 * Cancel the update or creation of a clinic. Calls Open()
	 * * @throws ims.framework.exceptions.PresentationLogicException
	 */
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	/**
	 * Save the clinic details and then calls Open()
	 * @throws ims.framework.exceptions.PresentationLogicException
	 */
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			
			open();
	}
	
	/**
	 * Save the clinic details - populate the VO, validate the UI, validate the VO
	 */
	private boolean save() 
	{
		ClinicVo voClinic = populateInstanceData();
		
		String[] uiErrors = getUiErrors();
		String[] errors = voClinic.validate(uiErrors);
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(uiErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.saveClinic(voClinic));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/**
	 * Validate the UI for mandatory fields and 
	 * build up an array of errors for fields that fail validation
	 */
	private String[] getUiErrors() 
	{
		ArrayList errors = new ArrayList();
		if (form.txtName().getValue() == null) 
		{
			errors.add("Clinic Name is mandatory");
		}
		if (form.cmbClinicLoc().getValue() == null) 
		{
			errors.add("Clinic Location is mandatory");
		}
		//wdev-13445
		if(form.cmbOutpatient().isRequired() && form.cmbOutpatient().getValue() == null)
		{
			errors.add("Outpatient Department is mandatory.");
		}
		//------------
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid Clinic Record", searchErrors);
			return searchErrors;
		}
		return null;
	}

	/**
	 * Populate the clinic details fields from the local context record
	 */
	private ClinicVo populateInstanceData()
	{
		ClinicVo voClinic = form.getLocalContext().getSelectedRecord();
		
		if(voClinic == null)
			voClinic = new ClinicVo();
		
		if (form.cmbClinicLoc().getValue() != null)
		{
			voClinic.setClinicLocation(domain.getLocShortMappingsByRef(form.cmbClinicLoc().getValue()));
		}
		
		//WDEV-11914
		voClinic.setOutpatientDept(form.cmbOutpatient().getValue() != null ? domain.getLocShortMappingsByRef(form.cmbOutpatient().getValue()) : null);

		voClinic.setClinicName(form.txtName().getValue());
		voClinic.setIsActive(form.chkActive().getValue());
		voClinic.setCodeMappings(form.TaxonomyMappings().getValue());
		return voClinic;
	}

	/**
	 * Event that is fired on the selection of a menu item.  
	 * @param menuItemID
	 * @param sender
	 * @throws ims.framework.exceptions.PresentationLogicException
	 */	 
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if(sender.equals(form.treClinics()))
		{
			switch(menuItemID)
			{
				case GenForm.ContextMenus.Clinic.New:
					newInstance();
					break;
				
				case GenForm.ContextMenus.Clinic.Add:
					addInstance();
					break;
					
				case GenForm.ContextMenus.Clinic.Update:
					updateInstance();
					break;
			}
		}
	}
	
	/**
	 * Event that is fired on the selection of the new button. Calls newInstance()  
	 * @throws ims.framework.exceptions.PresentationLogicException
	 */
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	/**
	 * Event that is fired on the selection of the update button. Calls newInstance()  
	 * @throws ims.framework.exceptions.PresentationLogicException
	 */
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	/**
	 * New Instance - Set the defaults on a form for a new clinic instance  
	 */
	private void newInstance()
	{
		prepareScreen(true);
		form.chkActive().setValue(true);
		form.getLocalContext().setSelectedRecord(null);
		form.TaxonomyMappings().setComponentMode(FormMode.EDIT);
	}
	
	/**
	 * Update Instance - Set the defaults for the a form for an edit of a clinic  
	 */
	private void updateInstance()
	{
		form.setMode(FormMode.EDIT);
		form.cmbClinicLoc().setEnabled(true);
		form.TaxonomyMappings().setComponentMode(FormMode.EDIT);
	}
	/**
	 * Add Instance - Adding a new clinic to a selected hospital selected in the tree  
	 */
	private void addInstance()
	{
		if (form.treClinics().getSelectedNode() != null 
				&& form.treClinics().getSelectedNode().getValue() != null
				&& form.treClinics().getSelectedNode().getValue() instanceof LocationLiteVo)
		{
			prepareScreen(false);
			form.cmbClinicLoc().setValue((LocationLiteVo)form.treClinics().getSelectedNode().getValue());
			form.chkActive().setValue(true);
			form.getLocalContext().setSelectedRecord(null);
			
			//WDEV-11914 -  starts here
			loadOutpatientDepartment(form.cmbClinicLoc().getValue());
			form.setMode(FormMode.EDIT);
			//WDEV-11914 - ends here
		}
	}

	/**
	 * Prepare the screen for a new instance. The boolean parameter enable
	 * controls the enabling or disabling of the location combo
	 * @param  
	 */
	private void prepareScreen(boolean enable)
	{
		form.cmbClinicLoc().setEnabled(enable);
		clearInstanceDetails();
		
		//WDEV-11914
		form.setMode(FormMode.EDIT);
	}
	
	/**
	 * When the form mode changes set the control state dependant on the form state 
	 */
	protected void onFormModeChanged()
	{	
		updateControlsState();
	}
	
	/**
	 * Update the control state of the form dependant on the FormMode, Config Flag and if a location\Hospital is selected
	 */
	private void updateControlsState()
	{		
		boolean allowEdits = form.getMode().equals(FormMode.VIEW) && ConfigFlag.GEN.ALLOW_CLINIC_EDIT.getValue();
		boolean clinicSelected = (form.treClinics().getSelectedNode() != null && form.treClinics().getSelectedNode().getValue() instanceof ClinicLiteVo);
		boolean locationSelected = (form.treClinics().getSelectedNode() != null && form.treClinics().getSelectedNode().getValue() instanceof LocationLiteVo);
		
		form.btnUpdate().setVisible(allowEdits && clinicSelected);	
		form.btnNew().setVisible(allowEdits);	
		form.getContextMenus().getClinicNewItem().setVisible(allowEdits);
		form.getContextMenus().getClinicAddItem().setVisible(allowEdits && locationSelected);
		if (form.getContextMenus().getClinicAddItem().isVisible())
		{
			form.getContextMenus().getClinicAddItem().setText("Add New Clinic in " + ((LocationLiteVo)form.treClinics().getSelectedNode().getValue()).getName());
		}
		form.getContextMenus().getClinicUpdateItem().setVisible(allowEdits && clinicSelected);
		form.TaxonomyMappings().setComponentMode(form.getMode());	//WDEV-11914
		
		//WDEV-11914 - starts here
		if(FormMode.VIEW.equals(form.getMode()))
		{
			form.cmbSearchOutpatient().setEnabled(form.cmbSearchLoc().getValue() instanceof LocationLiteVo);
			form.cmbClinicLoc().setEnabled(false);
		}
		
		if(FormMode.EDIT.equals(form.getMode()))
		{
			form.cmbOutpatient().setEnabled(form.cmbClinicLoc().getValue() instanceof LocationLiteVo);
		}
		//WDEV-11914 - ends here
	}
	
	/**
	 * Populate the instance details fields based on the fields contained in the paramater ClinicVo
	 * @param ClinicVo
	 */
	private void populateInstanceControl(ClinicVo voClinic)
	{
		if(voClinic == null)
			clearInstanceDetails();
		else
		{
			form.cmbClinicLoc().setValue(voClinic.getClinicLocation());
			
			//WDEV-11914 - starts here
			loadOutpatientDepartment(form.cmbClinicLoc().getValue());
			form.cmbOutpatient().setValue(voClinic.getOutpatientDept());
			//WDEV-11914 - ends here
			
			form.txtName().setValue(voClinic.getClinicName());	
			form.chkActive().setValue(voClinic.getIsActive());
		}		
	}
	
	/**
	 * Event fired when a selection in the tree is cleared
	 * @throws PresentationLogicException
	 */
	protected void onTreClinicsTreeViewSelectionCleared() throws PresentationLogicException
	{
		clearInstanceDetails();
		form.getLocalContext().setSelectedRecord(null);
		form.TaxonomyMappings().setValue(null);
		updateControlsState();
	}
	
	/**
	 * Event fired when a selection is made on the tree
	 * @param TreeNode node
	 * @throws PresentationLogicException
	 */
	protected void onTreClinicsTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException
	{
		form.TaxonomyMappings().setComponentMode(FormMode.VIEW);
		clearInstanceDetails();
		form.getLocalContext().setSelectedRecord(null);
		
		if (node.getValue() != null && node.getValue() instanceof ClinicLiteVo)
		{
			ClinicVo clin = domain.getClinic((ClinicLiteVo)node.getValue());
			form.getLocalContext().setSelectedRecord(clin);
			populateInstanceControl(clin);
			form.TaxonomyMappings().setValue(clin.getCodeMappings());
		}
		updateControlsState();
	}

	/**
	 * Event fired when on selection of the Clear Button (Image Button)
	 * Clear the search criteria and instance fields
	 * @throws PresentationLogicException
	 */
	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		clear();
		
		//WDEV-11914
		updateControlsState();
	}

	/**
	 * Event fired when on selection of the Search Button (Image Button)
	 * @throws PresentationLogicException
	 */
	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		if (form.cmbSearchLoc().getValue() == null && form.txtSearchCode().getValue() == null && form.txtSearchName().getValue() == null)
		{
			form.txtSearchName().setValue(new String("%%%"));
			search();
			form.txtSearchName().setValue(null);
			
			return;
		}
	
		search();
		
		
	}
	private void clearrec()
	{
		form.treClinics().clear();
		form.TaxonomyMappings().clear();
		form.cmbClinicLoc().setValue(null);
		form.txtName().setValue(null);
		form.chkActive().setValue(false);
		//wdev-12851
		form.cmbOutpatient().setValue(null);
		//------
		
	}
	/**
	 * Retrieve the clinics from via the domain based on the search criteria and populate the tree with any results
	 */
	private void search()
	{
		ClinicVoCollection clinics = domain.listClinicsByNameCodeLocation(form.cmbSearchLoc().getValue(), form.cmbSearchOutpatient().getValue(), form.txtSearchName().getValue(), form.txtSearchCode().getValue(), form.chkSearchAciveOnly().getValue());
		//wdev-12851
		clearrec();
		updateControlsState();
		//---------
		if (clinics == null || clinics.size() == 0)
		{
			
			engine.showMessage("No records were found that match your search criteria.", "No results", MessageButtons.OK, MessageIcon.INFORMATION);
		}
		populateClinicTree(clinics);
		
	}

	/**
	 * Populate the tree based on the ClinicVoCollection passed in as a paraemter
	 * Clear the tree first of any details
	 * @param ClinicVoCollection voClinicColl
	 */
	private void populateClinicTree(ClinicVoCollection voClinicColl)
	{
		form.treClinics().clear();

		if (voClinicColl == null || voClinicColl.size() <= 0)
		{
			return;
		}

		createOrderedLocationNodes(voClinicColl); //WDEV-15426

		for (int i = 0; i < voClinicColl.size(); i++)
		{
			createClinicNode(voClinicColl.get(i));
		}

	}

	private void createOrderedLocationNodes(ClinicVoCollection voClinicColl)
	{
		if (voClinicColl == null)
			return;

		LocationLiteVoCollection locations = new LocationLiteVoCollection();

		for (int i = 0; i < voClinicColl.size(); i++)
		{
			LocationLiteVo loc = voClinicColl.get(i).getClinicLocation();

			if (loc != null)
			{
				locations.add(loc);
			}
		}

		locations.sort(); //sort the locations collection

		for (int i = 0; i < locations.size(); i++)
		{
			TreeNode nodeLoc = form.treClinics().getNodeByValue(locations.get(i));

			// If location does not exist add it
			if (nodeLoc == null)
			{
				nodeLoc = form.treClinics().getNodes().add(locations.get(i), locations.get(i).getName());
				nodeLoc.setCollapsedImage(form.getImages().Core.Home);
				nodeLoc.setExpandedImage(form.getImages().Core.Home);
				nodeLoc.setExpanded(true);
			}
		}
	}

	/**
	 * Creates a clinic node in the tree for the value passed in
	 * If the clinic is inactive set the colour of the text to red
	 * @see createClinicNode(TreeNode nodeLoc, ClinicVo voClinic)
	 * @param TreeNode nodeLoc
	 * @param ClinicVo voClinic
	 */
	private void createClinicNode(ClinicVo voClinic)
	{
		TreeNode nodeLoc = form.treClinics().getNodeByValue(voClinic.getClinicLocation());

		// Add clinic to location (as child node)

		// WDEV-11914 - starts here
		if (nodeLoc == null || voClinic == null)
			return;

		String clinicName = voClinic.getClinicName();

		if (voClinic.getOutpatientDeptIsNotNull())
			clinicName += " - " + voClinic.getOutpatientDept().getName();
		// WDEV-11914 - ends here

		TreeNode clinNode = nodeLoc.getNodes().add(voClinic, clinicName); // WDEV-11914
		clinNode.setExpandedImage(form.getImages().Admin.Activity);
		clinNode.setCollapsedImage(form.getImages().Admin.Activity);
		if (voClinic.getIsActiveIsNotNull() && !voClinic.getIsActive())
		{
			clinNode.setTextColor(Color.Red);
		}

	}
	
	//WDEV-11914
	@Override
	protected void onCmbSearchLocValueChanged()	throws PresentationLogicException 
	{
		loadSearchOutpatientDepartment(form.cmbSearchLoc().getValue());
		updateControlsState();
	}
	
	//WDEV-11914
	private void loadSearchOutpatientDepartment(LocationLiteVo hospital) 
	{
		form.cmbSearchOutpatient().clear();
		
		if(hospital == null || !hospital.getID_LocationIsNotNull())
			return;
		
		LocationLiteVoCollection departments = domain.listActiveOutpatientDepartment(hospital);
		
		for(int i =0; i<departments.size(); i++)
		{
			LocationLiteVo department = departments.get(i);
			
			if(department == null)
				continue;
			
			form.cmbSearchOutpatient().newRow(department, department.getIItemText());
		}
	}
	
	//WDEV-11914
	@Override
	protected void onCmbClinicLocValueChanged()	throws PresentationLogicException 
	{
		loadOutpatientDepartment(form.cmbClinicLoc().getValue());
		updateControlsState();
	}
	
	//WDEV-11914
	private void loadOutpatientDepartment(LocationLiteVo hospital) 
	{
		form.cmbOutpatient().clear();
		
		if(hospital == null || !hospital.getID_LocationIsNotNull())
			return;
		
		LocationLiteVoCollection departments = domain.listActiveOutpatientDepartment(hospital);
		
		for(int i =0; i<departments.size(); i++)
		{
			LocationLiteVo department = departments.get(i);
			
			if(department == null)
				continue;
			
			form.cmbOutpatient().newRow(department, department.getIItemText());
		}
	}	
}
