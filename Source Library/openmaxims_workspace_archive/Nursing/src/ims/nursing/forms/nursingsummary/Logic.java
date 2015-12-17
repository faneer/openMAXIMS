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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.51 build 2469.26857)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.nursingsummary;

import ims.assessment.helper.DailyPatientProgressHelper;
import ims.assessment.vo.PatientAssessmentListVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridRow;
import ims.framework.utils.DateTime;
import ims.nursing.forms.nursingsummary.GenForm.grdAssessmentRow;
import ims.nursing.forms.nursingsummary.GenForm.grdInvasiveRow;
import ims.nursing.helper.NursingSummaryHelper;
import ims.nursing.vo.BradenScale;
import ims.nursing.vo.MUSTVo;
import ims.nursing.vo.PatientInvasiveDeviceShortVo;
import ims.nursing.vo.PatientInvasiveDeviceShortVoCollection;
import ims.nursing.vo.PlanOfCareListVoCollection;
import ims.nursing.vo.PlanOfCareLiteVo;
import ims.nursing.vo.RepositioningPlanVo;
import ims.nursing.vo.lookups.PlanOfCareInterval;
import ims.vo.ValueObject;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final Integer	COL_PLAN			= new Integer(0);
	private static final Integer	COL_STARTDATE		= new Integer(1);
	private static final Integer	COL_RESOLVEDDATE	= new Integer(2);
	private static final Integer	COL_URL				= new Integer(3);
	
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbInterval().setValue((PlanOfCareInterval) form.cmbInterval().getValues().get(0));
		populateActions();
		populateAssessmentGrid();
		populateInvasiveDeviceGrid();
		displayLastDPPScores();
		updateContextMenu();
	}
	
	private void displayLastDPPScores()
	{
		PatientAssessmentVo voPatientAssessment = domain.getLastDPPAssessment(UserDefinedAssessmentType.DPP, form.getGlobalContext().Core.getCurrentCareContext());
		displayScoreTotalInTree(voPatientAssessment);
	}
	
	private void displayScoreTotalInTree(PatientAssessmentVo voPatAssessment)
	{
		form.treDPP().clear();
		if(voPatAssessment == null)
			return;
		
		DailyPatientProgressHelper helper = new DailyPatientProgressHelper(form.getImages().Core.RedSqaure, form.getImages().Core.YellowSquare, form.getImages().Core.GreenSquare);
		helper.populateTreeScores(form.treDPP(), voPatAssessment.getAssessmentData().getAnswerGroups());
	}
	
	private void populateActions()
	{
		DateTime date1 = null;
		DateTime date2 = null;
		
		if(form.cmbInterval().getValue() != null)
		{
			date1 = new DateTime();
			date2 = new DateTime();
			
			int hours = 0;
			if(PlanOfCareInterval.HOURS12.equals(form.cmbInterval().getValue()))
				hours = -12;
			else if(PlanOfCareInterval.HOURS24.equals(form.cmbInterval().getValue()))
				hours = -24;
			else if(PlanOfCareInterval.HOURS36.equals(form.cmbInterval().getValue()))
				hours = -36;
			else if(PlanOfCareInterval.HOURS48.equals(form.cmbInterval().getValue()))
				hours = -48;
			else if(PlanOfCareInterval.HOURS72.equals(form.cmbInterval().getValue()))
				hours = -72;
			
			date1.addHours(hours);
		}
		
		PlanOfCareListVoCollection coll = domain.listPlansofCare(form.getGlobalContext().Core.getCurrentCareContext(), null, date1, date2);
		NursingSummaryHelper helper = new NursingSummaryHelper(form.dyngrdActions(), form.getImages().Core.RedSqaure, form.getImages().Core.GreenSquare, form.getImages().Core.YellowSquare, form.getImages().Core.Information, coll);
		helper.displayActionsGroupByPlan(coll, false);
	}
	
	protected void onCmbIntervalValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		populateActions();
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.NursingSummary.NEW_PLAN :
				newPlan();
			break;
			case GenForm.ContextMenus.NursingSummary.VIEW_PLAN :
				viewPlan();
				break;
			default :
			break;
		}
	}
	private void viewPlan()
	{
		form.getGlobalContext().Nursing.setFormAction("VIEW");
		form.getGlobalContext().Nursing.setPlanOfCareId(((PlanOfCareLiteVo)form.dyngrdActions().getValue()).getID_PlanOfCare());
		engine.open(form.getForms().Nursing.PlanOfCare);
	}
	private void newPlan()
	{
		form.getGlobalContext().Nursing.setFormAction("NEW");
		form.getGlobalContext().Nursing.setPlanOfCareId(null);
		engine.open(form.getForms().Nursing.PlanOfCare);
	}
	protected void onDyngrdActionsRowSelectionChanged(DynamicGridRow row)
	{
		updateContextMenu();
	}
	
	private void updateContextMenu()
	{
		form.getContextMenus().getNursingSummaryNEW_PLANItem().setVisible(true);
		
		if(form.dyngrdActions().getValue() instanceof PlanOfCareLiteVo)
			form.getContextMenus().getNursingSummaryVIEW_PLANItem().setVisible(true);
		else
			form.getContextMenus().getNursingSummaryVIEW_PLANItem().setVisible(false);
	}

	protected void onDyngrdActionsCellButtonClicked(DynamicGridCell cell)
	{
		engine.openUrl(cell.getTooltip());
	}
	
	private void populateAssessmentGrid()
	{
		populateBradenScaleRecord();
		populateMustRecord();
		populateSkinAssessmentRecord();
		populatePainAssessmentRecord();
		populateFallsAssessment();
		addResositioningPlanningRecord();
	}

	private void populateBradenScaleRecord()
	{
		CareContextRefVo careContextRefVo = form.getGlobalContext().Core.getCurrentCareContext();
		BradenScale bradenScaleVo = domain.getLastCompletedBradenScale(careContextRefVo);
		if (bradenScaleVo != null)
		{
			addNewAssessmentRow(bradenScaleVo, "Braden Scale", bradenScaleVo.getDateTimeInitiated());
		}
	}
	
	private void populateMustRecord()
	{
		CareContextRefVo careContextRefVo = form.getGlobalContext().Core.getCurrentCareContext();
		MUSTVo mustVo = domain.getLastComplementedMustRecord(careContextRefVo);
		if(mustVo != null)
		{
			addNewAssessmentRow(mustVo, "MUST", mustVo.getAuthoringInformationIsNotNull()?mustVo.getAuthoringInformation().getAuthoringDateTime():null);
		}
	}
	
	private void populatePainAssessmentRecord()
	{
		PatientAssessmentListVo painAssessment = domain.getLastCompletedAssessment(UserDefinedAssessmentType.PAINASSESSMENT, form.getGlobalContext().Core.getCurrentCareContext(), Boolean.TRUE);
		if (painAssessment != null)
		{
			addNewAssessmentRow(painAssessment, "Pain Assessment", painAssessment.getAuthoringInformationIsNotNull() ? painAssessment.getAuthoringInformation().getAuthoringDateTime() : null);
		}
	}
	
	private void populateFallsAssessment()
	{
		PatientAssessmentListVo fallAssessment = domain.getLastStructuredAssessment(UserDefinedAssessmentType.FALLSRISK, form.getGlobalContext().Core.getCurrentCareContext());
		if (fallAssessment != null)
		{
			addNewAssessmentRow(fallAssessment, UserDefinedAssessmentType.FALLSRISK.toString(), fallAssessment.getAuthoringInformationIsNotNull() ? fallAssessment.getAuthoringInformation().getAuthoringDateTime() : null);
		}	
	}

	private void populateSkinAssessmentRecord()
	{
		PatientAssessmentListVo skinAssessment = domain.getLastCompletedAssessment(UserDefinedAssessmentType.SKINASSESSMENT, form.getGlobalContext().Core.getCurrentCareContext(), Boolean.TRUE);
		if (skinAssessment != null)
		{
			addNewAssessmentRow(skinAssessment, UserDefinedAssessmentType.SKINASSESSMENT.toString(), skinAssessment.getAuthoringInformationIsNotNull() ? skinAssessment.getAuthoringInformation().getAuthoringDateTime() : null);
		}
	}
	
	private void addResositioningPlanningRecord()
	{
		RepositioningPlanVo voRepositioningPlan = domain.getLastCompletedRepositioningPlan(form.getGlobalContext().Core.getCurrentCareContext());
		if(voRepositioningPlan != null)
		{
			addNewAssessmentRow(voRepositioningPlan, "Repositioning Plan", voRepositioningPlan.getAuthoringInformationIsNotNull()?voRepositioningPlan.getAuthoringInformation().getAuthoringDateTime():null);
		}
	}
	
	private void addNewAssessmentRow(ValueObject bradenScaleVo, String assessment, DateTime dateTimeInitiated)
	{
		grdAssessmentRow row = form.grdAssessment().getRows().newRow();
		row.setColAssessment(assessment);
		row.setColLastCompleted(dateTimeInitiated != null ? dateTimeInitiated.toString() : "");
		row.setValue(bradenScaleVo);		
	}
	
	private void populateInvasiveDeviceGrid()
	{
		PatientInvasiveDeviceShortVoCollection voColl = domain.listCurrentPatientInvasiveDevice(form.getGlobalContext().Core.getCurrentCareContext());
		for (int i = 0; voColl != null && i < voColl.size(); i++)
		{
			PatientInvasiveDeviceShortVo voInvasiveDev = voColl.get(i);
			grdInvasiveRow row = form.grdInvasive().getRows().newRow();
			row.setColInvasive(voInvasiveDev.getInvasiveDeviceIsNotNull()?voInvasiveDev.getInvasiveDevice().getInvasiveDevice():"");
			row.setColInserted(voInvasiveDev.getInsertedDateTimeIsNotNull()?voInvasiveDev.getInsertedDateTime().toString():"");
			if (voInvasiveDev.getTargetRemovalDateTime().getDate().isLessOrEqualThan(new DateTime().getDate()))
			{
				row.setBackColor(ims.configuration.gen.ConfigFlag.UI.INVASIVE_DEVICE_REMOVAL_ROW_COLOR.getValue());
			}
		}
	}
}
