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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.icp.forms.activatestagephases;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.controls.TreeNode;
import ims.framework.controls.TreeNodeCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.vo.PatientICPPhase_DisplayVo;
import ims.icp.vo.PatientICPPhase_DisplayVoCollection;
import ims.icp.vo.PatientICPStage_DisplayVo;
import ims.icp.vo.PatientICPStage_DisplayVoCollection;
import ims.icp.vo.PatientICP_DisplayVo;
import ims.icp.vo.lookups.ICPStageStatus;
import ims.vo.ValueObject;

import java.util.ArrayList;
import java.util.Comparator;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Utility classes region - comparators
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Stage comparator - will sort after configured sequence
	 */
	private static class StageComparator implements Comparator<PatientICPStage_DisplayVo>
	{
		public int compare(PatientICPStage_DisplayVo stage1, PatientICPStage_DisplayVo stage2)
		{
			return stage1.getStage().getSequence().compareTo(stage2.getStage().getSequence());
		}

	}

	/**
	 *	Phase comparator - will sort after configured sequence
	 */
	private static class PhaseComparator implements Comparator<PatientICPPhase_DisplayVo>
	{
		public int compare(PatientICPPhase_DisplayVo phase1, PatientICPPhase_DisplayVo phase2)
		{
			return phase1.getPhase().getSequence().compareTo(phase2.getPhase().getSequence());
		}
	}



	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers - region
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Event handler for OnFormOpen event
	 *	<br />
	 *	<i>Note:</i> Do not put complex logic code in here - instead just call functions to easy replicate
	 *	this functionality where needed
	 */
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh screen
		open();
	}
	
	/**
	 *	Event handler for OnClick event for 'Activate' event
	 *	<br />
	 *	<i>Note:</i> Do not put complex logic code in here - instead just call functions to easy replicate
	 *	this functionality where needed
	 */
	@Override
	protected void onBtnActivateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// If the save was successful then close the form with 'OK' result
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}

	/**
	 * Event handler for OnClick event for 'Cancel' button
	 *	<br />
	 *	<i>Note:</i> Do not put complex logic code in here - instead just call functions to easy replicate
	 *	this functionality where needed
	 */
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Close dialog with 'Cancel' result
		engine.close(DialogResult.CANCEL);
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form logic functions - region
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to refresh screen
	 */
	private void open()
	{
		// Get PatientICP from data base
		// (we need - PatientICP (name), Stages (name + status), Phases (name + status) - we don't need actions) based on global context
		PatientICP_DisplayVo patientICP = domain.getPatientICP(form.getGlobalContext().ICP.getPatientICPRecord());
		
		// Display PatientICP in the tree
		populateTree(patientICP);
		
		// Set form (dialog) mode to Edit
		form.setMode(FormMode.EDIT);
	}

	/**
	 * Function used to commit data to database
	 */
	private boolean save()
	{
		try
		{
			// Get selected nodes values from screen
			java.util.ArrayList<ims.vo.ValueObject> selectedStagesPhases = getSelectedStagesPhases();

			// Check for at least one record to be activated
			if (selectedStagesPhases.size() == 0)
			{
				engine.showMessage("At least one stage or one phase must be selected for activation.", "Patient ICP Activation Error");
				return false;
			}

			// Commit data to database
			form.getGlobalContext().ICP.setPatientICPRecord(domain.activateStagesPhases(form.getGlobalContext().ICP.getPatientICPRecord(), selectedStagesPhases));

			// Assume save succeeded
			return true;
		}
		// Treat exceptions
		catch (DomainInterfaceException exception)
		{
			engine.showMessage(exception.getMessage());
			exception.printStackTrace();
			return false;
		}
		catch (StaleObjectException exception)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			exception.printStackTrace();
			open();
			return false;
		}
	}


	//------------------------------------------------------------------------------------------------------------------------------------------------
	//	Data exchange functions - region
	//------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to retrieve selected stages or phases from tree
	 */
	private ArrayList<ValueObject> getSelectedStagesPhases()
	{
		// Create container for selected Stages and Phases
		ArrayList<ValueObject> selectedStagesPhases = new ArrayList<ValueObject>();
		
		// Iterate tree nodes
		addCheckedNodes(selectedStagesPhases, form.treItems().getNodes());

		// Return container
		return selectedStagesPhases;
	}

	/**
	 * Function used to recursively iterate nodes in tree (depth first) and add checked nodes to ICP
	 * It will not check node for value, as only stages and phases can be checked - if this changes be sure to update this code too
	 */
	private void addCheckedNodes(ArrayList<ValueObject> selectedStagesPhases, TreeNodeCollection nodes)
	{
		// Safeguard the array list containing checked stages / phases
		if (selectedStagesPhases == null)
			throw new CodingRuntimeException("Array list passed to keep the selected Stages / Phases can not be null.");
		
		// If the nodes are null - terminate function execution
		if (nodes == null || nodes.size() == 0)
			return;
		
		// Iterate nodes collection
		for (int i = 0; i < nodes.size(); i++)
		{
			// Set a reference to node
			TreeNode node = nodes.get(i);
			
			// Check if node has child nodes
			if (node.getNodes().size() > 0)
			{
				// Analyse current node child nodes
				addCheckedNodes(selectedStagesPhases, node.getNodes());
			}
			
			// If the node is checked 
			if (node.isChecked())
			{
				// Add it's value to Stages / Phases to be brought into scope collection
				selectedStagesPhases.add((ValueObject) node.getValue());
			}
		}
	}

	/**
	 * Function used to populate a Patient ICP record to tree (with stages & phases)
	 * This will only populate stages and phases that are out of scope - as these are the only stages and phases retrieved from domain
	 * Currently only stages and phases that are out of scope have check-boxes - if this changes be sure to update logic around this
	 */
	private void populateTree(PatientICP_DisplayVo patientICP)
	{
		// Clear tree
		form.treItems().clear();
		
		// Check for values to populate
		if (patientICP == null)
			return;
		
		// Add ICP Node
		TreeNode nodeICP = form.treItems().getNodes().add(patientICP, patientICP.getICP().getName());
		// Do not show a check-box for ICP node
		nodeICP.setCheckBoxVisible(false);
		// Add stages to patient ICP Node
		populateStagesToPatientICPNode(nodeICP, patientICP.getStages().sort(new StageComparator()));
		
		// Expand root node
		nodeICP.setExpanded(true);
	}

	/**
	 *	Function used to populate a Patient ICP stages to Patient ICP Node
	 *	Currently only stages and phases that are out of scope have check-boxes - if this changes be sure to update logic around this
	 */
	private void populateStagesToPatientICPNode(TreeNode nodeICP, PatientICPStage_DisplayVoCollection stages)
	{
		// If the stages collection is null then stop & exit the function
		if (stages == null)
			return;
		
		// Iterate stage collection for patient ICP
		for (PatientICPStage_DisplayVo stage : stages)
		{
			// Add stage node to a tree
			TreeNode stageNode = nodeICP.getNodes().add(stage, stage.getStage().getName());

			// Add phases to stage Node
			boolean stageHasLinkedActions = populatePhasesToStageNode(stageNode, stage.getPhases().sort(new PhaseComparator()));
			
			// Set the check box visible if it needs to be brought into scope
			stageNode.setCheckBoxVisible(stage.getCurrentStatusIsNotNull() && ICPStageStatus.NOTINSCOPE.equals(stage.getCurrentStatus().getStatus()) && stageHasLinkedActions);
			
			// Expand stage node
			stageNode.setExpanded(true);
		}
	}

	/**
	 *	Function used to populate a stage phases to a Stage Node
	 *	Currently only stages and phases that are out of scope have check-boxes - if this changes be sure to update logic around this
	 */
	private boolean populatePhasesToStageNode(TreeNode stageNode, PatientICPPhase_DisplayVoCollection phases)
	{
		// If the phases collection is null then move on to next phase
		if (phases == null)
			return false;
		
		boolean stageHasLinkedActions = false;
		
		// Iterate phases
		for (PatientICPPhase_DisplayVo phase : phases)
		{
			// Add each phase to tree
			TreeNode phaseNode = stageNode.getNodes().add(phase, phase.getPhase().getName());
			
			// On current logic a displayed phase will always have NOT IN SCOPE status
			// Set it as selectable only if it has actions
			phaseNode.setCheckBoxVisible(Boolean.TRUE.equals(phase.getHasActions()));
			
			// If any phase has linked actions -> stage has linked actions
			stageHasLinkedActions = Boolean.TRUE.equals(phase.getHasActions()) || stageHasLinkedActions; 
		}
		
		return stageHasLinkedActions;
	}
}
