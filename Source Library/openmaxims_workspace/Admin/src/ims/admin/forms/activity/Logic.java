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
//This code was generated by Dara Hickey using IMS Development Environment (version 1.22 build 50228.901)
//Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.activity;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ActivitySchedVo;
import ims.core.vo.ActivitySchedVoCollection;
import ims.core.vo.ActivityVo;
import ims.core.vo.ActivityVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.ActivitySpecRequirements;
import ims.core.vo.lookups.ActivitySpecRequirementsCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.ntpf.vo.CodingAlertConfigurationVo;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;
import ims.vo.lookups.ClassHelper;
import ims.core.vo.lookups.ActivityType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		engine.setCaption(ConfigFlag.UI.DISPLAY_NAME_ACTIVITY.getValue(true));
		form.lyrActivity().tabNtpf().pnlActivityDetails().setValue(ConfigFlag.UI.DISPLAY_NAME_ACTIVITY.getValue() + " Details:");
		form.lyrActivity().tabNtpf().chkItem().setEnabled(false);
		if(ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("SCHED"))
		{
			loadSpecialRequirements();
			form.chkActiveOnly().setValue(true);
		}
		else
			form.chkActiveOnly().setVisible(false);
		
		populateActivityTree();
	}

	/**
	 * @param node2
	 * @param activityType2
	 * 
	 */
	private void populateActivityTree()
	{
		form.treActivity().clear();

		if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("NTPF"))
		{
			LookupInstanceCollection actTypesToExclude = new LookupInstanceCollection();
			actTypesToExclude.add(ActivityType.PROCEDURE);
			actTypesToExclude.add(ActivityType.INVESTIGATION);

			form.getLocalContext().setActivityVoCollection(domain.listNTPFActivities(Boolean.TRUE, actTypesToExclude));

			LookupInstanceCollection instColl = (LookupInstanceCollection) domain.getLookupService().getLookupCollection(ActivityType.TYPE_ID, ClassHelper.getLookupCollectionClass(ActivityType.TYPE_ID), ClassHelper.getLookupClass(ActivityType.TYPE_ID), true, false);
			LookupInstVo[] roots = instColl.getRoots();
			for (int j = 0; j < roots.length; j++)
			{
				LookupInstVo inst = roots[j];
				if(!inst.equals(ActivityType.PROCEDURE) && !inst.equals(ActivityType.INVESTIGATION))
				{
					TreeNode newNode = form.treActivity().getNodes().add(inst, inst.getText());
					//Image img = getCorrectImage(inst);
					newNode.setExpandedImage(form.getImages().Core.YellowSquare);
					newNode.setCollapsedImage(form.getImages().Core.YellowSquare);
					newNode.setSelectedImage(form.getImages().Core.YellowSquare);
	
					if (form.getLocalContext().getActivityVoCollectionIsNotNull())
						fillTypeActivites(newNode, inst);
					fillLookupHierarchy(newNode, inst);
				}
			}

			form.treActivity().expandAll(); //collapseAll();
		}
		else if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("SCHED"))
		{
			form.lyrActivity().showtabSchedulling();
			//load the screen with activitiies of type appt
			form.getLocalContext().setActivityVoCollection(new ActivityVoCollection());
			
			ActivitySchedVoCollection voCollActSched;
			if(form.chkActiveOnly().getValue() == true)
				voCollActSched = domain.listSchedActivities(Boolean.TRUE);
			else
				voCollActSched = domain.listSchedActivities(null);
				
			for (int i = 0; i < voCollActSched.size(); i++)
				form.getLocalContext().getActivityVoCollection().add(voCollActSched.get(i));

			TreeNode newNode = form.treActivity().getNodes().add(ActivityType.APPOINTMENTTYPES, ActivityType.APPOINTMENTTYPES.getText());
			newNode.setExpandedImage(form.getImages().Core.YellowSquare);
			newNode.setCollapsedImage(form.getImages().Core.YellowSquare);
			newNode.setSelectedImage(form.getImages().Core.YellowSquare);

			if (form.getLocalContext().getActivityVoCollectionIsNotNull())
				fillTypeActivites(newNode, ActivityType.APPOINTMENTTYPES);
			fillLookupHierarchy(newNode, ActivityType.APPOINTMENTTYPES);
			
			form.treActivity().expandAll();
		}
		
		form.getContextMenus().getGenericGridAddItem().setVisible(false);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
	}

	/**
	 * @param newNode
	 * @param inst
	 */
	private void fillTypeActivites(TreeNode parentNode, LookupInstVo inst)
	{
		ActivityVoCollection collActivityVo = form.getLocalContext().getActivityVoCollection();
		for (int i = 0; i < collActivityVo.size(); i++)
		{
			ActivityVo voActivity = collActivityVo.get(i);

			if (voActivity.getActivityType().equals(inst))
			{
				if( voActivity.getIsActiveIsNotNull() && voActivity.getIsActive().equals(Boolean.TRUE))	//wdev-19994
				{
    				TreeNode newNode = parentNode.getNodes().add(voActivity, voActivity.getName());
    				newNode.setExpandedImage(form.getImages().Core.BlueSquare);
    				newNode.setCollapsedImage(form.getImages().Core.BlueSquare);
    				newNode.setSelectedImage(form.getImages().Core.BlueSquare);
				}
				else
				{
					TreeNode newNode = parentNode.getNodes().add(voActivity, voActivity.getName());
    				newNode.setExpandedImage(form.getImages().Core.RedSqaure);
    				newNode.setCollapsedImage(form.getImages().Core.RedSqaure);
    				newNode.setSelectedImage(form.getImages().Core.RedSqaure);
				}
			}
		}
	}

	private void fillLookupHierarchy(TreeNode node, LookupInstVo inst)
	{
		ArrayList children = inst.getChildInstances();
		for (int i = 0; i < children.size(); i++)
		{
			LookupInstVo child = (LookupInstVo) children.get(i);
			TreeNode newNode = node.getNodes().add(child, child.getText());
			newNode.setExpandedImage(form.getImages().Core.YellowSquare);
			newNode.setCollapsedImage(form.getImages().Core.YellowSquare);
			newNode.setSelectedImage(form.getImages().Core.YellowSquare);

			fillLookupHierarchy(newNode, child);
			if (form.getLocalContext().getActivityVoCollectionIsNotNull())
				fillTypeActivites(newNode, child);
		}
	}

	private void clearNTPFActivityDetails()
	{
		form.lyrActivity().tabNtpf().txtActivity().setValue(null);
		form.lyrActivity().tabNtpf().txtName().setValue(null);
		form.lyrActivity().tabNtpf().chkActive().setValue(false);
		form.lyrActivity().tabNtpf().chkItem().setValue(false);
		form.lyrActivity().tabNtpf().txtEmailAlert().setValue(null);
		form.lyrActivity().tabNtpf().qmbMemberOfStaff().setValue(null);
		form.lyrActivity().tabNtpf().txtAlertDescription().setValue(null);
		form.lyrActivity().tabNtpf().ccTaxonomyTab1().setValue(null);
	}

	private void clearSchedActivityDetails()
	{
		form.lyrActivity().tabSchedulling().txtActName().setValue(null);
		form.lyrActivity().tabSchedulling().intTimeRequired().setValue(null);
		form.lyrActivity().tabSchedulling().intIntervalRequired().setValue(null);
		form.lyrActivity().tabSchedulling().txtActType().setValue(null);
		form.lyrActivity().tabSchedulling().chkPatientRequired().setValue(false);
		form.lyrActivity().tabSchedulling().chkScheduled().setValue(false);
		form.lyrActivity().tabSchedulling().chkActActive().setValue(false);
		form.lyrActivity().tabSchedulling().txtActImage().setValue(null);
		form.lyrActivity().tabSchedulling().chkDiagnosticActivity().setValue(null);
		form.lyrActivity().tabSchedulling().chkFirstAppointment().setValue(null);
		form.getGlobalContext().Admin.setSelectedImage(null);
		
		for(int i=0;i<form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().size();i++)
			form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().get(i).setcolSelected(false);
		
		form.lyrActivity().tabSchedulling().ccTaxonomyTab2().setValue(null);
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ActivityVo activityVo = form.getLocalContext().getActivityVo();

		CodingAlertConfigurationVo alertVo = form.getLocalContext().getAlertVo();
		populateActivityVoFromScreen(activityVo);
		String[] arrErrors;

		if (!(activityVo instanceof ActivitySchedVo))
		{
			if (alertVo == null)
				alertVo = new CodingAlertConfigurationVo();

			populateAlertVoFromScreen(alertVo);
			alertVo.setActivity(activityVo);

			arrErrors = alertVo.validate();
			if (arrErrors != null)
			{
				engine.showErrors("Validation Errors", arrErrors);
				return;
			}

		}
		String[] uiErrors = getUiErrors();			//wdev-12702
		arrErrors = activityVo.validate(uiErrors);
		if (arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}

		try
		{
			if (!(activityVo instanceof ActivitySchedVo))
			{
				domain.saveAlert(alertVo);
			}
			else
			{
				domain.saveSchedActivity((ActivitySchedVo) activityVo);
			}

		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}

		populateActivityTree();
		clearActivityDetails();

		form.setMode(FormMode.VIEW);

	}
	//wdev-12702
	private String[] getUiErrors() 
	{
		ArrayList errors = new ArrayList();
		if (form.lyrActivity().tabSchedulling().intTimeRequired().getValue() == null) 
		{
			errors.add("Time Required is mandatory.");
		}
		
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			return searchErrors;
		}
		return null;
	}
	/**
	 * @param alertVo
	 */
	private void populateAlertVoFromScreen(CodingAlertConfigurationVo alertVo)
	{
		alertVo.setEmail(form.lyrActivity().tabNtpf().txtEmailAlert().getValue());
		alertVo.setUser(form.lyrActivity().tabNtpf().qmbMemberOfStaff().getValue());
		alertVo.setDescription(form.lyrActivity().tabNtpf().txtAlertDescription().getValue());
	}

	private void populateActivityVoFromScreen(ActivityVo voActivity)
	{
		if (voActivity == null)
			return;

		if (voActivity instanceof ActivitySchedVo)
		{
			//scheduling
			if (voActivity.getActivityType() == null)
				voActivity.setActivityType((ActivityType) form.treActivity().getSelectedNode().getValue());

			//if (form.lyrActivity().tabSchedulling().txtActName().getValue() != null)		WDEV-15167
			voActivity.setName(form.lyrActivity().tabSchedulling().txtActName().getValue());

			if (form.lyrActivity().tabSchedulling().intTimeRequired().getValue() != null)
				((ActivitySchedVo) voActivity).setTmReq(form.lyrActivity().tabSchedulling().intTimeRequired().getValue());

			if (form.lyrActivity().tabSchedulling().intIntervalRequired().getValue() != null)
				((ActivitySchedVo) voActivity).setIntReq(form.lyrActivity().tabSchedulling().intIntervalRequired().getValue());

			if (form.getGlobalContext().Admin.getSelectedImageIsNotNull())
				((ActivitySchedVo) voActivity).setActivityImage(form.getGlobalContext().Admin.getSelectedImage());

			((ActivitySchedVo) voActivity).setIsPatReq(new Boolean(form.lyrActivity().tabSchedulling().chkPatientRequired().getValue()));
			((ActivitySchedVo) voActivity).setIsScheduled(new Boolean(form.lyrActivity().tabSchedulling().chkScheduled().getValue()));
			voActivity.setIsActive(new Boolean(form.lyrActivity().tabSchedulling().chkActActive().getValue()));

			// Save Activity special requirements.
			ActivitySpecRequirementsCollection asrColl = new ActivitySpecRequirementsCollection();

			GenForm.lyrActivityLayer.tabSchedullingContainer.grdActSpecialRequirementsRow row;
			for (int i = 0; i < form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().size(); i++)
			{
				row = form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().get(i);
				if (row.getcolSelected())
					asrColl.add(row.getValue());
			}
			((ActivitySchedVo) voActivity).setSpecialRequirements(asrColl);
			
			// Save Activity taxonomy mappings (WDEV-6108)
			voActivity.setCodeMappings(form.lyrActivity().tabSchedulling().ccTaxonomyTab2().getValue());
			voActivity.setFirstAppointment(form.lyrActivity().tabSchedulling().chkFirstAppointment().getValue());
			voActivity.setDiagnostic(form.lyrActivity().tabSchedulling().chkDiagnosticActivity().getValue());
		}
		else
		{
			if (voActivity.getActivityType() == null)
				voActivity.setActivityType((ActivityType) form.treActivity().getSelectedNode().getValue());

			if (form.lyrActivity().tabNtpf().txtName().getValue() != null)
				voActivity.setName(form.lyrActivity().tabNtpf().txtName().getValue());

			voActivity.setIsWorkQueue(new Boolean(form.lyrActivity().tabNtpf().chkItem().getValue()));
			voActivity.setIsActive(new Boolean(form.lyrActivity().tabNtpf().chkActive().getValue()));
			
			// Save Activity taxonomy mappings (WDEV-6108)
			voActivity.setCodeMappings(form.lyrActivity().tabNtpf().ccTaxonomyTab1().getValue());
		}
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearActivityDetails();
		form.setMode(FormMode.VIEW);
		populateActivityTree();
	}

	private void populateScreenFromActivityVo(ActivityVo localActivity)
	{
		if (localActivity == null)
			return;

		if (localActivity instanceof ActivitySchedVo)
		{
			if (localActivity.getActivityTypeIsNotNull())
				form.lyrActivity().tabSchedulling().txtActType().setValue(localActivity.getActivityType().getText());

			if (localActivity.getName() != null)
				form.lyrActivity().tabSchedulling().txtActName().setValue(localActivity.getName());

			if (((ActivitySchedVo) localActivity).getTmReq() != null)
				form.lyrActivity().tabSchedulling().intTimeRequired().setValue(((ActivitySchedVo) localActivity).getTmReq());

			if (((ActivitySchedVo) localActivity).getIntReq() != null)
				form.lyrActivity().tabSchedulling().intIntervalRequired().setValue(((ActivitySchedVo) localActivity).getIntReq());

			if (((ActivitySchedVo) localActivity).getActivityImage() != null)
				form.lyrActivity().tabSchedulling().txtActImage().setValue(((ActivitySchedVo) localActivity).getActivityImage().getImagePath());

			form.getGlobalContext().Admin.setSelectedImage(((ActivitySchedVo) localActivity).getActivityImage());
			
			if (((ActivitySchedVo) localActivity).getIsPatReq() != null)
				form.lyrActivity().tabSchedulling().chkPatientRequired().setValue(((ActivitySchedVo) localActivity).getIsPatReq().booleanValue());

			if (((ActivitySchedVo) localActivity).getIsScheduled() != null)
				form.lyrActivity().tabSchedulling().chkScheduled().setValue(((ActivitySchedVo) localActivity).getIsScheduled().booleanValue());

			if (((ActivitySchedVo) localActivity).getIsActive() != null)
				form.lyrActivity().tabSchedulling().chkActActive().setValue(localActivity.getIsActive().booleanValue());
			
			form.lyrActivity().tabSchedulling().chkFirstAppointment().setValue(((ActivitySchedVo) localActivity).getFirstAppointment());
			form.lyrActivity().tabSchedulling().chkDiagnosticActivity().setValue(((ActivitySchedVo) localActivity).getDiagnostic());

			if(((ActivitySchedVo) localActivity).getSpecialRequirementsIsNotNull())
			{
				GenForm.lyrActivityLayer.tabSchedullingContainer.grdActSpecialRequirementsRow row;
				ActivitySpecRequirementsCollection requirements = ((ActivitySchedVo) localActivity).getSpecialRequirements();
				for (int i=0; i<requirements.size(); i++)
				{
					ActivitySpecRequirements requirement = requirements.get(i);
					row = form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRowByValue(requirement);
					if (row != null)
						row.setcolSelected(true);
					else
					{
						row = form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().newRow();
						row.setValue(requirement);
						row.setcolRequirement(requirement.getText());	
						row.setcolSelected(true);	
					}
				}
			}
			
			// Populate the taxonomy mappings (WDEV-6108)
			form.lyrActivity().tabSchedulling().ccTaxonomyTab2().setValue(localActivity.getCodeMappings());
		}
		else
		{
			if (localActivity.getActivityTypeIsNotNull())
				form.lyrActivity().tabNtpf().txtActivity().setValue(localActivity.getActivityType().getText());

			if (localActivity.getName() != null)
				form.lyrActivity().tabNtpf().txtName().setValue(localActivity.getName());

			form.lyrActivity().tabNtpf().chkActive().setValue(localActivity.getIsActive().booleanValue());
			form.lyrActivity().tabNtpf().chkItem().setValue(localActivity.getIsWorkQueue().booleanValue());
			
			// Populate the taxonomy mappings (WDEV-6108)
			form.lyrActivity().tabNtpf().ccTaxonomyTab1().setValue(localActivity.getCodeMappings());
		}
	}

	private void populateScreenFromAlertVo(CodingAlertConfigurationVo alertVo)
	{
		if (alertVo.getEmailIsNotNull())
			form.lyrActivity().tabNtpf().txtEmailAlert().setValue(alertVo.getEmail());
		if (alertVo.getActivityIsNotNull())
		{
			if (alertVo.getUserIsNotNull())
			{
				form.lyrActivity().tabNtpf().qmbMemberOfStaff().newRow(alertVo.getUser(), alertVo.getUser().getName().getForename() + " " + alertVo.getUser().getName().getSurname());
				form.lyrActivity().tabNtpf().qmbMemberOfStaff().setValue(alertVo.getUser());
			}
		}
		if (alertVo.getDescriptionIsNotNull())
			form.lyrActivity().tabNtpf().txtAlertDescription().setValue(alertVo.getDescription());
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (form.treActivity().getSelectedNode() != null)
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add :
					addRecord();
				break;
				case GenForm.ContextMenus.GenericGrid.Update :
					updateRecord();
				break;
			}
		}
	}

	private void updateRecord()
	{
		form.setMode(FormMode.EDIT);
		if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("NTPF"))
		{
			showAlertDetails(enableAlertControls(form.treActivity().getSelectedNode().getParent()), (ActivityType) form.treActivity().getSelectedNode().getParent().getValue());
		}
	}

	private void addRecord()
	{
		form.setMode(FormMode.EDIT);

		if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("NTPF"))
		{
			if (form.treActivity().getSelectedNode() != null)
				form.lyrActivity().tabNtpf().txtActivity().setValue(form.treActivity().getSelectedNode().getText());
			form.lyrActivity().tabNtpf().chkItem().setValue(true);
			form.lyrActivity().tabNtpf().chkActive().setValue(true);
			form.getLocalContext().setActivityVo(new ActivityVo());
			form.getLocalContext().setAlertVo(new CodingAlertConfigurationVo());
			showAlertDetails(enableAlertControls(form.treActivity().getSelectedNode()), (ActivityType) form.treActivity().getSelectedNode().getValue());
		}
		else if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("SCHED"))
		{
			if (form.treActivity().getSelectedNode() != null)
				form.lyrActivity().tabSchedulling().txtActType().setValue(form.treActivity().getSelectedNode().getText());
			form.lyrActivity().tabSchedulling().chkActActive().setValue(true);
			form.getLocalContext().setActivityVo(new ActivitySchedVo());
		}
	}

	private void loadSpecialRequirements()
	{
		ActivitySpecRequirementsCollection coll = LookupHelper.getActivitySpecRequirements(domain.getLookupService());

		GenForm.lyrActivityLayer.tabSchedullingContainer.grdActSpecialRequirementsRow row = null;
		for (int i = 0; i < coll.size(); i++)
		{
			row = form.lyrActivity().tabSchedulling().grdActSpecialRequirements().getRows().newRow();
			row.setcolRequirement(coll.get(i).getText());
			row.setValue(coll.get(i));
		}
	}

	protected void onImbActivityImageClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Admin.ImageSelectDialog);
	}

	protected void onTreActivityTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException
	{
		if (node.getValue() instanceof ActivityVo)
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
			form.getLocalContext().setActivityVo((ActivityVo) form.treActivity().getSelectedNode().getValue());
			clearActivityDetails();

			ActivityVo voActivity = (ActivityVo) form.treActivity().getSelectedNode().getValue();
			populateScreenFromActivityVo(voActivity);

			if (!(node.getValue() instanceof ActivitySchedVo))
			{
				CodingAlertConfigurationVo alertVo = domain.getAlert(voActivity);
				form.getLocalContext().setAlertVo(alertVo);
				populateScreenFromAlertVo(alertVo);
				showAlertDetails(enableAlertControls(node.getParent()), voActivity.getActivityType());
			}
		}
		else if (node.getValue() instanceof ActivityType)
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			clearActivityDetails();

			ActivityType activityType = (ActivityType) node.getValue();
			if (activityType.equals(ActivityType.ADMINFUNCTIONS))
			{
				if (adminInstanceExists())
					form.getContextMenus().getGenericGridAddItem().setVisible(false);
			}

			showAlertDetails(enableAlertControls(node), activityType);

			if (oneChildOnlyAllowed(node))
				form.getContextMenus().getGenericGridAddItem().setVisible(false);
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		}
	}

	private void clearActivityDetails()
	{
		if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("NTPF"))
		{
			clearNTPFActivityDetails();
		}
		else if (ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("SCHED"))
		{
			clearSchedActivityDetails();
		}
	}

	/**
	 * @param activityType
	 * @return
	 */
	private boolean enableAlertControls(TreeNode node)
	{

		ActivityType activityType = (ActivityType) node.getValue();

		if (activityType.equals(ActivityType.WORKQUEUEFOLLOWUPTYPES))
			return false;

		if (activityType.equals(ActivityType.APPOINTMENTTYPES))
			return false;

		if (node.getParent() != null)
		{
			activityType = (ActivityType) node.getParent().getValue();
			if (activityType.equals(ActivityType.WORKQUEUEFOLLOWUPTYPES))
				return false;
		}

		return true;

	}

	/**
	 * @return
	 */
	private boolean adminInstanceExists()
	{
		ActivityVoCollection collActivityVo = form.getLocalContext().getActivityVoCollection();
		if (collActivityVo == null)
			return false;

		for (int i = 0; i < collActivityVo.size(); i++)
		{
			ActivityVo voActivity = collActivityVo.get(i);

			if (voActivity.getActivityType().equals(ActivityType.ADMINFUNCTIONS))
				return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see ims.admin.forms.activity.Handlers#onQmbMemberOfStaffTextSubmited(java.lang.String)
	 */
	protected void onQmbMemberOfStaffTextSubmited(String value) throws PresentationLogicException
	{
		if (value != null)
		{
			MemberOfStaffShortVo voMemberOfStaffFilter = new MemberOfStaffShortVo();
			PersonName name = new PersonName();
			name.setSurname(value);
			voMemberOfStaffFilter.setName(name);
			voMemberOfStaffFilter.setIsAppUser(new Boolean(true));

			MemberOfStaffShortVoCollection voCollMemberOfStaff = domain.listStaff(voMemberOfStaffFilter);

			voCollMemberOfStaff.sort();
			form.lyrActivity().tabNtpf().qmbMemberOfStaff().clear();
			for (int i = 0; i < voCollMemberOfStaff.size(); i++)
			{
				form.lyrActivity().tabNtpf().qmbMemberOfStaff().newRow(voCollMemberOfStaff.get(i), voCollMemberOfStaff.get(i).getName().getForename() + " " + voCollMemberOfStaff.get(i).getName().getSurname());
			}
			if (voCollMemberOfStaff.size() == 1)
				form.lyrActivity().tabNtpf().qmbMemberOfStaff().setValue(voCollMemberOfStaff.get(0));
			else if (voCollMemberOfStaff.size() > 1)
				form.lyrActivity().tabNtpf().qmbMemberOfStaff().showOpened();
		}

	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Admin.ImageSelectDialog) && result.equals(DialogResult.OK))
		{
			if (form.getGlobalContext().Admin.getSelectedImageIsNotNull())
				form.lyrActivity().tabSchedulling().txtActImage().setValue(form.getGlobalContext().Admin.getSelectedImage().getImagePath());

		}
	}

	private void showAlertDetails(boolean b, ActivityType type)
	{
		form.lyrActivity().tabNtpf().pnlAlert().setVisible(b);
		form.lyrActivity().tabNtpf().lblEmailAlertTo().setVisible(b);
		form.lyrActivity().tabNtpf().lblAlertDescription().setVisible(b);
		form.lyrActivity().tabNtpf().lblStaffMember().setVisible(b);
		form.lyrActivity().tabNtpf().txtEmailAlert().setVisible(b);
		form.lyrActivity().tabNtpf().qmbMemberOfStaff().setVisible(b);
		form.lyrActivity().tabNtpf().txtAlertDescription().setVisible(b);

		form.lyrActivity().tabNtpf().pnlAlert().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().lblEmailAlertTo().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().lblAlertDescription().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().lblStaffMember().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().txtEmailAlert().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().qmbMemberOfStaff().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.lyrActivity().tabNtpf().txtAlertDescription().setEnabled(form.getMode().equals(FormMode.EDIT));

		// If type is Appointments, we always want to disable the work queue checkbox
		if (type.equals(ActivityType.APPOINTMENTTYPES))
		{
			form.lyrActivity().tabNtpf().chkItem().setVisible(false);
			form.lyrActivity().tabNtpf().lblWorkQueue().setVisible(false);
		}
		else
		{
			form.lyrActivity().tabNtpf().chkItem().setVisible(true);
			form.lyrActivity().tabNtpf().lblWorkQueue().setVisible(true);
			form.lyrActivity().tabNtpf().chkItem().setEnabled(form.getMode().equals(FormMode.EDIT));
		}

	}

	private boolean oneChildOnlyAllowed(TreeNode node)
	{
		if (node.getNodes() != null && node.getNodes().size() > 0)
			if (node.getParent() != null)
				if (node.getParent().getParent() != null)
					return true;

		return false;
	}

	protected void onChkActiveOnlyValueChanged() throws PresentationLogicException
	{
		clearActivityDetails();
		populateActivityTree();
	}

	protected void onFormModeChanged()
	{
		if(ConfigFlag.UI.ACTIVITY_VIEW.getValue().equals("SCHED"))
		{
			form.chkActiveOnly().setEnabled(form.getMode().equals(FormMode.VIEW));
		}
		
		form.lyrActivity().tabNtpf().ccTaxonomyTab1().setComponentMode(form.getMode());
		form.lyrActivity().tabSchedulling().ccTaxonomyTab2().setComponentMode(form.getMode());
	}

	@Override
	protected void onChkDiagnosticActivityValueChanged() throws PresentationLogicException
	{
		if(form.lyrActivity().tabSchedulling().chkDiagnosticActivity().getValue())
		{
			form.lyrActivity().tabSchedulling().chkFirstAppointment().setValue(false);
		}
	}

	@Override
	protected void onChkFirstAppointmentValueChanged() throws PresentationLogicException
	{
		if(form.lyrActivity().tabSchedulling().chkFirstAppointment().getValue())
		{
			form.lyrActivity().tabSchedulling().chkDiagnosticActivity().setValue(false);
		}
	}
}
