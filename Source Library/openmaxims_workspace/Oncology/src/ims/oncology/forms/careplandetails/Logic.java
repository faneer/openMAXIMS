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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.45 build 2418.19363)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.oncology.forms.careplandetails;

import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.lookups.YesNo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.oncology.forms.careplandetails.GenForm.grdActualModalityRow;
import ims.oncology.forms.careplandetails.GenForm.grdPlannedModRow;
import ims.oncology.vo.CancerCarePlanLiteVo;
import ims.oncology.vo.CancerCarePlanLiteVoCollection;
import ims.oncology.vo.CancerCarePlanVo;
import ims.oncology.vo.CancerMDTMeetingVoCollection;
import ims.oncology.vo.TreatmentModalitiesVo;
import ims.oncology.vo.TreatmentModalitiesVoCollection;
import ims.oncology.vo.lookups.CarePlanCurrentStatus;
import ims.oncology.vo.lookups.CarePlanTreatmentModality;
import ims.oncology.vo.lookups.CarePlanTreatmentModalityCollection;
import ims.oncology.vo.lookups.LookupHelper;
import ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		loadPlannedModalityGrid();
		loadAntiCancerReasonChecklist();
		loadAssociatedMdtCombo();
		form.getLocalContext().setUpdatedInstance(null);
		form.getLocalContext().setvoCancerCarePlan(null);
		open();
	}
	private void loadAntiCancerReasonChecklist() throws FormOpenException 
	{
		form.chklistAntiCancerReason().clear();
		
		NoAntiCancerTxReasonCollection collkup = LookupHelper.getNoAntiCancerTxReason(domain.getLookupService());
		if (collkup == null || collkup.size() <= 0)
		{
			throw new FormOpenException("The NoAntiCancerTxReason lookups MUST be populated before this form can be used.");
		}
		else
		{
			form.chklistAntiCancerReason().setValues(collkup);
			form.chklistAntiCancerReason().setValues(null);
		}
	}
	private void loadPlannedModalityGrid() throws PresentationLogicException 
	{
		form.grdPlannedMod().getRows().clear();
		CarePlanTreatmentModalityCollection collkup = LookupHelper.getCarePlanTreatmentModality(domain.getLookupService());
		if (collkup != null && collkup.size() > 0)
		{
			form.grdPlannedMod().getRows().clear();
			for(int i=0; i < collkup.size();i++)
			{
				GenForm.grdPlannedModRow row = form.grdPlannedMod().getRows().newRow();
				row.setValue(collkup.get(i));
				row.setcolModality(collkup.get(i).toString());
				row.setcolSequenceReadOnly(true);
			}
		}
		else
		{
			throw new FormOpenException("The CarePlanTreatmentModality lookups MUST be populated before this form can be used.");
		}			
	}
	private void loadActualModalityGrid() throws PresentationLogicException 
	{
		form.grdActualModality().getRows().clear();
		CarePlanTreatmentModalityCollection collkup = LookupHelper.getCarePlanTreatmentModality(domain.getLookupService());
		if (collkup != null && collkup.size() > 0)
		{
			form.grdActualModality().getRows().clear();
			for(int i=0; i < collkup.size();i++)
			{
				GenForm.grdActualModalityRow row = form.grdActualModality().getRows().newRow();
				row.setValue(collkup.get(i));
				row.setcolModality(collkup.get(i).toString());
				row.setcolSeqReadOnly(true);
			}
		}
		else
		{
			throw new FormOpenException("The CarePlanTreatmentModality lookups MUST be populated before this form can be used.");
		}			
	}

	private void open() throws PresentationLogicException 
	{
		form.setMode(FormMode.VIEW);
		clearScreen();
		clearGrids();
		loadPlannedModalityGrid();
		fillRecordBrowser();		
		
		if (isDialog())
			form.btnClose().setVisible(true);
		else
			form.btnClose().setVisible(false);
	}
	private boolean isDialog()
	{
		return engine.isDialog();
	}
	private void loadAssociatedMdtCombo() 
	{
		CancerMDTMeetingVoCollection voMdtMeetingColl = domain.listCancerMDTMeeting(form.getGlobalContext().Core.getEpisodeofCareShort());
		if(voMdtMeetingColl != null && voMdtMeetingColl.size() > 0)
		{
			for (int i =0; i < voMdtMeetingColl.size();i++)
			{
				StringBuffer associatedMDTText = new StringBuffer();
				associatedMDTText.append("MDT Meeting - MDT Meeting Date: ");
				if(voMdtMeetingColl.get(i).getDateIsNotNull())
					associatedMDTText.append(voMdtMeetingColl.get(i).getDate());
				associatedMDTText.append("    MDT Location: ");
				if(voMdtMeetingColl.get(i).getMDTLocationIsNotNull())
					associatedMDTText.append(voMdtMeetingColl.get(i).getMDTLocation());
				associatedMDTText.append("    Co-Morbidity Assessment: ");
				if(voMdtMeetingColl.get(i).getCoMorbidityAssessmentIsNotNull())
					associatedMDTText.append(voMdtMeetingColl.get(i).getCoMorbidityAssessment());
				form.cmbAssociatedMDT().newRow(voMdtMeetingColl.get(i), associatedMDTText.toString());
			}
		}		
	}
	private void clearGrids() 
	{
		form.grdPlannedMod().getRows().clear();
		form.grdActualModality().getRows().clear();
	}
	private void populateScreenFromData() throws PresentationLogicException 
	{
		CancerCarePlanVo voCancerCarePlan = form.getLocalContext().getvoCancerCarePlan();
		
		if(voCancerCarePlan == null)
		{
			form.btnNew().setVisible(true);	
			form.btnUpdate().setVisible(false);
			form.btnProgress().setVisible(false);
			form.btnRevise().setVisible(false);
			form.btnRevisionReason().setVisible(false);
			return;
		}
		else
		{
			form.btnNew().setVisible(true);
			form.btnNew().setEnabled(false);
			if(voCancerCarePlan.getCurrentStatus() == null)
			{
				form.btnUpdate().setVisible(true);
				form.btnUpdate().setEnabled(true);
				form.btnProgress().setVisible(false);
				form.btnProgress().setEnabled(false);
				form.btnRevise().setVisible(false);
				form.btnRevise().setEnabled(false);
			}
			else
			{
				form.btnUpdate().setVisible(true);
				form.btnUpdate().setEnabled(false);
				form.btnProgress().setVisible(true);
				form.btnProgress().setEnabled(true);
				form.btnRevise().setVisible(true);
				form.btnRevise().setEnabled(true);
			}
		}	
		
		populateMDTGrids();
		
		if(voCancerCarePlan.getNoAntiCancerTxReasonIsNotNull())
			form.chklistAntiCancerReason().setValues(voCancerCarePlan.getNoAntiCancerTxReason());
		
		if(voCancerCarePlan.getCarePlanDateIsNotNull())
			form.dteCarePlan().setValue(voCancerCarePlan.getCarePlanDate());
		if(voCancerCarePlan.getConsultantInChargeIsNotNull())
		{
			form.qmbConsultant().newRow(voCancerCarePlan.getConsultantInCharge(), voCancerCarePlan.getConsultantInCharge().getName().toString());
			form.qmbConsultant().setValue(voCancerCarePlan.getConsultantInCharge());
		}
		if(voCancerCarePlan.getCarePlanNotesIsNotNull())
			form.txtNotes().setValue(voCancerCarePlan.getCarePlanNotes());
		if(voCancerCarePlan.getCarePlanIntentIsNotNull())
			form.cmbTreatIntent().setValue(voCancerCarePlan.getCarePlanIntent());
		if(voCancerCarePlan.getRecurrenceIndicatorIsNotNull())
			form.cmbRecurrence().setValue(voCancerCarePlan.getRecurrenceIndicator());
		if(voCancerCarePlan.getCurrentStatusIsNotNull())
			form.cmbStatus().setValue(voCancerCarePlan.getCurrentStatus());
		if(voCancerCarePlan.getAgreedDateIsNotNull())
			form.dteAgreedDate().setValue(voCancerCarePlan.getAgreedDate());
		if(voCancerCarePlan.getReasonPatientPlanDiffMDTIsNotNull())
			form.txtReason().setValue(voCancerCarePlan.getReasonPatientPlanDiffMDT());
		if(voCancerCarePlan.getMdtMeetingIsNotNull())
			form.cmbAssociatedMDT().setValue(voCancerCarePlan.getMdtMeeting());
		if(voCancerCarePlan.getReasonForRevisionIsNotNull())
			form.btnRevisionReason().setVisible(true);
	}
	private void populateMDTGrids() throws PresentationLogicException 
	{
		CancerCarePlanVo voCancerCarePlan = form.getLocalContext().getvoCancerCarePlan();
		if(voCancerCarePlan == null)
			return;
		
		clearGrids();
		loadPlannedModalityGrid();
		TreatmentModalitiesVoCollection collCarePlanModalityVo = voCancerCarePlan.getTreatmentModalities();
		for (int i=0; i < collCarePlanModalityVo.size();i++)
		{						
			TreatmentModalitiesVo voTreatmentModalities = collCarePlanModalityVo.get(i);					
			if (voTreatmentModalities != null)
			{
				GenForm.grdPlannedModRow rowPlanned = form.grdPlannedMod().getRowByValue(voTreatmentModalities.getTreatmentModality());
				if(rowPlanned != null)
				{
					if (voTreatmentModalities.getTreatmentModalityIsNotNull())
						rowPlanned.setcolModality(voTreatmentModalities.getTreatmentModality().toString());
				
					if (voTreatmentModalities.getMDTSequenceIsNotNull())
						rowPlanned.setcolSequence(voTreatmentModalities.getMDTSequence());
					
					rowPlanned.setcolSelect(true);
					rowPlanned.setValue(voTreatmentModalities.getTreatmentModality());
				}
			}
		}
		if(voCancerCarePlan.getCurrentStatusIsNotNull() && (voCancerCarePlan.getCurrentStatus().equals(CarePlanCurrentStatus.AGREEDDIFFTOMDT) || voCancerCarePlan.getCurrentStatus().equals(CarePlanCurrentStatus.AGREEDSAMEASMDT) ))
		{
			loadActualModalityGrid();
			
			for (int i=0; i < collCarePlanModalityVo.size();i++)
			{						
				TreatmentModalitiesVo voTreatmentModalities = collCarePlanModalityVo.get(i);					
				if (voTreatmentModalities != null)
				{
					GenForm.grdActualModalityRow rowActualMod = form.grdActualModality().getRowByValue(voTreatmentModalities.getTreatmentModality());
					if(rowActualMod != null)
					{
						if (voTreatmentModalities.getTreatmentModalityIsNotNull())
							rowActualMod.setcolModality(voTreatmentModalities.getTreatmentModality().toString());
					
						if (voTreatmentModalities.getMDTSequenceIsNotNull())
							rowActualMod.setcolSeq(voTreatmentModalities.getMDTSequence());
						
						if (voTreatmentModalities.getCompletedDateIsNotNull())
							rowActualMod.setColDateComp(voTreatmentModalities.getCompletedDate());
		
						rowActualMod.setcolSelect(true);
						rowActualMod.setValue(voTreatmentModalities.getTreatmentModality());
					}
				}
			}
		}
	}
	private void fillRecordBrowser() throws PresentationLogicException 
	{
	
		form.recbrCarePlans().clear();
		CancerCarePlanLiteVoCollection voCancerCarePlanLiteColl = domain.listCancerCarePlans(form.getGlobalContext().Core.getEpisodeofCareShort());
		if(voCancerCarePlanLiteColl != null && voCancerCarePlanLiteColl.size() > 0)
		{
			populateBrowserFromData(voCancerCarePlanLiteColl);
			setRecordBrowser();
		}	
		else
		{
			form.btnProgress().setVisible(false);
			form.btnRevise().setVisible(false);
			form.btnUpdate().setEnabled(false);
			form.btnNew().setEnabled(true);
		}
	}

	/**
	 * @param voCancerCarePlanLiteColl
	 */
	private void populateBrowserFromData(CancerCarePlanLiteVoCollection voCancerCarePlanLiteColl) 
	{
		form.recbrCarePlans().clear();
		if(voCancerCarePlanLiteColl != null)
		{
			for(int i=0;i<voCancerCarePlanLiteColl.size();i++)
			{
				StringBuffer browserText = new StringBuffer();
				browserText.append("Cancer Care Plan Record: " + voCancerCarePlanLiteColl.get(i).getCarePlanDate());
				if(voCancerCarePlanLiteColl.get(i).getConsultantInChargeIsNotNull())
					browserText.append(" - " + voCancerCarePlanLiteColl.get(i).getConsultantInCharge());
				form.recbrCarePlans().newRow(voCancerCarePlanLiteColl.get(i), browserText.toString(), voCancerCarePlanLiteColl.get(i).getIsCurrentIsNotNull() && voCancerCarePlanLiteColl.get(i).getIsCurrent().equals(Boolean.TRUE) ?  Color.Green : Color.Black);
			}
		}
	}
	
	
	private void setRecordBrowser() throws PresentationLogicException 
	{
		//scroll through records to set the record marked as IsCurrent
		for(int i=0;i<form.recbrCarePlans().getValues().size();i++)
		{
			 CancerCarePlanLiteVo item = (CancerCarePlanLiteVo) form.recbrCarePlans().getValues().get(i);
			 if(item.getIsCurrentIsNotNull() && item.getIsCurrent())
			 {
				 form.recbrCarePlans().setValue(item);
				 break;
			 }
		}
		
		displayRecord();
	}
	
	private void displayRecord() throws PresentationLogicException 
	{
		clearScreen();
		updateBrowseInformation();
		if(form.recbrCarePlans().getValue() != null)
		{			
			if(form.recbrCarePlans().getValue() instanceof CancerCarePlanLiteVo)
				form.getLocalContext().setvoCancerCarePlan(domain.getCancerCarePlan((CancerCarePlanLiteVo) form.recbrCarePlans().getValue()));
			else
				return;
				
			populateScreenFromData();
		}
		checkRecordIsEditable();
	}
	
	private void checkRecordIsEditable() 
	{
		if(form.recbrCarePlans().getValue() != null)
		{			
			CancerCarePlanLiteVo voCCPLite = (CancerCarePlanLiteVo) form.recbrCarePlans().getValue();
	
			if(voCCPLite.getIsCurrentIsNotNull())
			{
				if(voCCPLite.getIsCurrent().equals(Boolean.TRUE))
				{
					if(form.cmbStatus().getValue() != null && !form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDSAMEASMDT) && !form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDDIFFTOMDT))
					{
						form.btnUpdate().setEnabled(true);
						form.btnProgress().setEnabled(false);
					}
					else if(form.cmbStatus().getValue() != null && (form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDSAMEASMDT) || form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDDIFFTOMDT)))
					{
						form.btnProgress().setEnabled(true);
						form.btnRevise().setEnabled(true);
						form.btnUpdate().setEnabled(false);
						form.btnNew().setEnabled(false);
					}
				}
				else
					activateButtons(false);
			}
			else
				activateButtons(false);
		}
	}
	
	private void activateButtons(boolean activate)
	{
		form.btnNew().setEnabled(activate);
		form.btnUpdate().setEnabled(activate);
		form.btnRevise().setEnabled(activate);
		form.btnProgress().setEnabled(activate);
	}
	
	private void updateBrowseInformation()
	{
		form.lblBrowseStatus().setValue(form.recbrCarePlans().getRecordState("Cancer Care Plan", "Cancer Care Plan"));
	}
	
	private void clearScreen() 
	{
		form.dteCarePlan().setValue(null);
		form.qmbConsultant().setValue(null);
		form.cmbTreatIntent().setValue(null);
		form.cmbRecurrence().setValue(null);
		form.txtNotes().setValue(null);
		form.cmbStatus().setValue(null);
		form.dteAgreedDate().setValue(null);
		form.txtReason().setValue(null);
		form.cmbAssociatedMDT().setValue(null);
		form.chklistAntiCancerReason().setValues(null);
		form.btnRevisionReason().setVisible(false);
	}
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Oncology.CarePlanProgress))
		{
			if(result.equals(DialogResult.OK))
			{
				open();
			}
		}
		else if (formName.equals(form.getForms().Oncology.CarePlanRevise))
		{
			if(result.equals(DialogResult.OK))
			{
				form.getLocalContext().setvoCancerCarePlan(form.getGlobalContext().Oncology.getvoCancerCarePlan());
				open();
			}
			else if(result.equals(DialogResult.CANCEL))
			{
				open();
			}
		}
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.cmbStatus().getValue() != null)
		{
			if(form.cmbStatus().getValue().getId() == CarePlanCurrentStatus.AGREEDSAMEASMDT.getId() || form.cmbStatus().getValue().getId() == CarePlanCurrentStatus.AGREEDDIFFTOMDT.getId())
			{
				if(form.dteAgreedDate().getValue() == null)
				{
					engine.showMessage("An Agreed Date must be provide before proceeding.");
					return;
				}
			}
		}
		populateDataFromScreen();
		
		CancerCarePlanVo voCarePlan = form.getLocalContext().getvoCancerCarePlan();
		voCarePlan.setIsCurrent(Boolean.TRUE);
		
		String[] errors = voCarePlan.validate();
		if(errors != null)
		{	
			engine.showErrors("Validation Errors", errors);
			return;
		}
		try 
		{
			form.getLocalContext().setvoCancerCarePlan(domain.saveCancerCarePlan(voCarePlan));   
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
		}
		open();
		form.setMode(FormMode.VIEW);
	}
	private void populateDataFromScreen() 
	{
		CancerCarePlanVo voCarePlan = form.getLocalContext().getvoCancerCarePlan();
		if(voCarePlan == null)
		{
			voCarePlan = new CancerCarePlanVo();
		}
		
		
		populateDataFromModalityGrids();
		
		voCarePlan = form.getLocalContext().getvoCancerCarePlan();
		
		
		if (!voCarePlan.getEpisodeOfCareIsNotNull())
		{
			voCarePlan.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		}
		if (!voCarePlan.getCareContextIsNotNull())
		{
			voCarePlan.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		}
		if (!voCarePlan.getClinicalContactIsNotNull())
		{
			voCarePlan.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		}
		
		voCarePlan.setCarePlanDate(form.dteCarePlan().getValue());
		voCarePlan.setConsultantInCharge(form.qmbConsultant().getValue());
		voCarePlan.setCarePlanNotes(form.txtNotes().getValue());
		voCarePlan.setCarePlanIntent(form.cmbTreatIntent().getValue());
		voCarePlan.setRecurrenceIndicator(form.cmbRecurrence().getValue());
		voCarePlan.setCurrentStatus(form.cmbStatus().getValue());
		voCarePlan.setAgreedDate(form.dteAgreedDate().getValue());
		if(form.cmbAssociatedMDT().getValue() != null)
		{
			voCarePlan.setMdtMeeting(form.cmbAssociatedMDT().getValue());
			voCarePlan.setHasAssociatedMDTMeeting(Boolean.TRUE);
		}
		else
		{
			voCarePlan.setMdtMeeting(null);
			voCarePlan.setHasAssociatedMDTMeeting(Boolean.FALSE);
		}
		
		voCarePlan.setNoAntiCancerTxReason(form.chklistAntiCancerReason().getValues());
		voCarePlan.setReasonPatientPlanDiffMDT(form.txtReason().getValue());
		

		form.getLocalContext().setvoCancerCarePlan(voCarePlan);
	}
	private void populateDataFromModalityGrids() 
	{
		CancerCarePlanVo voCarePlan = form.getLocalContext().getvoCancerCarePlan();
		if(voCarePlan == null)
			voCarePlan = new CancerCarePlanVo();

		TreatmentModalitiesVoCollection collCarePlanModalityVo = new TreatmentModalitiesVoCollection();

		if(form.cmbStatus().getValue() == null || (!form.cmbStatus().getValue().equals(CarePlanCurrentStatus.AGREEDSAMEASMDT) && !form.cmbStatus().getValue().equals(CarePlanCurrentStatus.AGREEDDIFFTOMDT)))
		{
			populateModalityFromScreen(collCarePlanModalityVo);
		}
		else if(form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDSAMEASMDT))
		{
			populateModalityFromScreen(collCarePlanModalityVo);
		}
		else if(form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDDIFFTOMDT))
		{
			GenForm.grdActualModalityRow rowActual;
			for(int i = 0 ; i < form.grdActualModality().getRows().size() ; i++)
			{
				rowActual = form.grdActualModality().getRows().get(i);
				GenForm.grdPlannedModRow rowPlanned;

				for(int x = 0 ; x < form.grdPlannedMod().getRows().size() ; x++)
				{
					rowPlanned = form.grdPlannedMod().getRows().get(x);
					
					if(rowActual.getValue().getId() == rowPlanned.getValue().getId())
					{
						TreatmentModalitiesVo voTreatmentModalities = new TreatmentModalitiesVo();					

						//If modalitity selected on the MDTAgreedGRid also selected on the patientagreedGRID
						if(rowPlanned.getcolSelect() && rowActual.getcolSelect())
						{
							voTreatmentModalities.setPatientAgreed(YesNo.YES);
							voTreatmentModalities.setPatientSequence(rowActual.getcolSeq());
							voTreatmentModalities.setCompletedDate(rowActual.getColDateComp());
							voTreatmentModalities.setIsMDTModality(Boolean.TRUE);
							voTreatmentModalities.setMDTSequence(rowPlanned.getcolSequence());
						}
						//If modalities selected on the MDTAgreedGrid but NOT ticked on the patientagreedGrid
						else if(rowPlanned.getcolSelect() && !rowActual.getcolSelect())
						{
							voTreatmentModalities.setPatientAgreed(YesNo.NO);
							voTreatmentModalities.setPatientSequence(null);
							voTreatmentModalities.setIsMDTModality(Boolean.TRUE);
							voTreatmentModalities.setMDTSequence(null);
						}
						//If modalities NOT selected on the MDTAgreedGrid but ticked on the patientagreedGrid
						else if(!rowPlanned.getcolSelect() && rowActual.getcolSelect())
						{
							voTreatmentModalities.setPatientAgreed(YesNo.YES);
							voTreatmentModalities.setPatientSequence(rowActual.getcolSeq());
							voTreatmentModalities.setCompletedDate(rowActual.getColDateComp());
							voTreatmentModalities.setIsMDTModality(Boolean.FALSE);
							voTreatmentModalities.setMDTSequence(null);
						}
						voTreatmentModalities.setTreatmentModality(rowActual.getValue());
						
						voTreatmentModalities.setIsCommenced(Boolean.TRUE);

						if(rowPlanned.getcolSelect() || rowActual.getcolSelect())
							collCarePlanModalityVo.add(voTreatmentModalities);				
					}
				}		
			}
		}
		voCarePlan.setTreatmentModalities(collCarePlanModalityVo);
		form.getLocalContext().setvoCancerCarePlan(voCarePlan);
	}
	private void populateModalityFromScreen(
			TreatmentModalitiesVoCollection collCarePlanModalityVo) {
		GenForm.grdPlannedModRow rowPlanned;
		for(int i=0;i<form.grdPlannedMod().getRows().size();i++)
		{
			rowPlanned = form.grdPlannedMod().getRows().get(i);
			if (rowPlanned.getcolSelect())
			{
				TreatmentModalitiesVo voTreatmentModalities = new TreatmentModalitiesVo();					

				voTreatmentModalities.setPatientAgreed(YesNo.YES);
				voTreatmentModalities.setPatientSequence(rowPlanned.getcolSequence());
				voTreatmentModalities.setIsMDTModality(Boolean.TRUE);
				voTreatmentModalities.setMDTSequence(rowPlanned.getcolSequence());
				voTreatmentModalities.setTreatmentModality(rowPlanned.getValue());
				voTreatmentModalities.setIsCommenced(Boolean.TRUE);
				
				collCarePlanModalityVo.add(voTreatmentModalities);				
			}
		}
	}
			
	protected void OnStatusChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.cmbStatus().getValue() == null || (!form.cmbStatus().getValue().equals(CarePlanCurrentStatus.AGREEDSAMEASMDT) && !form.cmbStatus().getValue().equals(CarePlanCurrentStatus.AGREEDDIFFTOMDT)))
		{
			form.grdActualModality().getRows().clear();
			form.grdActualModality().setEnabled(false);
			form.grdPlannedMod().setEnabled(true);
			form.grdPlannedMod().setReadOnly(false);
			form.txtReason().setValue(null);
			form.txtReason().setEnabled(false);
			form.dteAgreedDate().setValue(null);
			form.dteAgreedDate().setEnabled(false);
			
			//check No Anti-Cancer Value if it has a value in planned grid enable chklistAntiCancerReason
			if(isNoAntiCancerSelectedinPlannedGrid())
			{
				form.chklistAntiCancerReason().setEnabled(true);
			}	
			else
			{
				form.chklistAntiCancerReason().setValues(null);
				form.chklistAntiCancerReason().setEnabled(false);
			}
		}
		else if(form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDSAMEASMDT))
		{
			if(validatePlannedGridEntry())
			{
				form.grdPlannedMod().setEnabled(false);
				form.grdPlannedMod().setReadOnly(true);
				form.txtReason().setEnabled(false);

				form.grdActualModality().getRows().clear();
				
				GenForm.grdPlannedModRow rowPlanned;
				TreatmentModalitiesVoCollection collCarePlanModalityVo = new TreatmentModalitiesVoCollection();
				
				for(int i=0;i<form.grdPlannedMod().getRows().size();i++)
				{
					rowPlanned = form.grdPlannedMod().getRows().get(i);
					if (rowPlanned.getcolSelect())
					{
						TreatmentModalitiesVo voTreatmentModalities = new TreatmentModalitiesVo();					
						voTreatmentModalities.setTreatmentModality(rowPlanned.getValue());
						voTreatmentModalities.setMDTSequence(rowPlanned.getcolSequence());
						
						collCarePlanModalityVo.add(voTreatmentModalities);				
					}
				}
				for (int i=0; i < collCarePlanModalityVo.size();i++)
				{						
					TreatmentModalitiesVo voTreatmentModalities = collCarePlanModalityVo.get(i);					
					if (voTreatmentModalities != null)
					{
						GenForm.grdActualModalityRow rowActual = form.grdActualModality().getRows().newRow();

						if (voTreatmentModalities.getTreatmentModalityIsNotNull())
							rowActual.setcolModality(voTreatmentModalities.getTreatmentModality().toString());
					
						if (voTreatmentModalities.getMDTSequenceIsNotNull())
							rowActual.setcolSeq(voTreatmentModalities.getMDTSequence());
						
						if (voTreatmentModalities.getCompletedDateIsNotNull())
							rowActual.setColDateComp(voTreatmentModalities.getCompletedDate());
						
						rowActual.setValue(voTreatmentModalities.getTreatmentModality());
						rowActual.setcolSelect(true);
					}
				}
				form.dteAgreedDate().setEnabled(true);
				
				//check No Anti-Cancer Value if it has a value in planned grid enable chklistAntiCancerReason
				if(isNoAntiCancerSelectedinPlannedGrid())
					form.chklistAntiCancerReason().setEnabled(true);
				else
				{
					form.chklistAntiCancerReason().setValues(null);
					form.chklistAntiCancerReason().setEnabled(false);
				}
			}
			else
			{
				engine.showErrors(new String[]{"Invalid selection and sequence supplied for 'Modality - MDT Agreed' grid.\nEach selected item must have a sequence."});
				form.cmbStatus().setValue(null);
				form.grdActualModality().getRows().clear();
			}
		}
		else if(form.cmbStatus().getValue().equals(ims.oncology.vo.lookups.CarePlanCurrentStatus.AGREEDDIFFTOMDT))
		{
			form.grdPlannedMod().setEnabled(false);
			form.grdPlannedMod().setReadOnly(true);
			form.grdActualModality().setEnabled(true);
			form.grdActualModality().setReadOnly(false);
			
			loadModalityPatientAgreedGrid();
			form.dteAgreedDate().setEnabled(true);
			
			form.txtReason().setEnabled(true);
			
			form.chklistAntiCancerReason().setValues(null);
			form.chklistAntiCancerReason().setEnabled(false);
		}
	}

	private boolean validatePlannedGridEntry()	
	{
		int validCount = 0;
		int selectCount = 0;
		for(int i=0;i<form.grdPlannedMod().getRows().size(); i++)
		{
			grdPlannedModRow row = form.grdPlannedMod().getRows().get(i);
			if(row.getcolSelect() && row.getcolSequence() != null)
				validCount++;
			
			if(row.getcolSelect() || row.getcolSequence() != null)
				selectCount++;
		}
		
		return validCount > 0 && validCount == selectCount;
	}
	/**
	 * @return
	 */
	private boolean isNoAntiCancerSelectedinPlannedGrid() 
	{
		for(int i=0;i<form.grdPlannedMod().getRows().size();i++)
		{
			grdPlannedModRow row = form.grdPlannedMod().getRows().get(i);
			
			if(row.getValue().getId() == CarePlanTreatmentModality.NOANTICANCERTREATMENT.getId())
			{
				if(row.getcolSelect())
					return true;
				else
					return false;
			}
		}
		return false;
	}
	private void loadModalityPatientAgreedGrid() throws FormOpenException 
	{
		form.grdActualModality().getRows().clear();
		CarePlanTreatmentModalityCollection collkup = LookupHelper.getCarePlanTreatmentModality(domain.getLookupService());
		if (collkup != null && collkup.size() > 0)
		{
			form.grdActualModality().getRows().clear();
			for(int i=0; i < collkup.size();i++)
			{
				GenForm.grdActualModalityRow row = form.grdActualModality().getRows().newRow();
				row.setValue(collkup.get(i));
				row.setcolModality(collkup.get(i).toString());
			}
		}
		else
		{
			throw new FormOpenException("The CarePlanTreatmentModality lookups MUST be populated before this form can be used.");
		}			
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setUpdatedInstance(null);
		form.setMode(FormMode.VIEW);
		open();
	}
	protected void onBtnReviseClick() throws PresentationLogicException 
	{
		form.getGlobalContext().Oncology.setvoCancerCarePlan(form.getLocalContext().getvoCancerCarePlan());
		engine.open(form.getForms().Oncology.CarePlanRevise);		
	}
	protected void onBtnProgressClick() throws PresentationLogicException 
	{
		form.getGlobalContext().Oncology.setvoCancerCarePlan(form.getLocalContext().getvoCancerCarePlan());
		engine.open(form.getForms().Oncology.CarePlanProgress);		
	}
	private void setUpdatedRecord()
	{
		if(form.recbrCarePlans().getValue() != null)
		{
			form.getLocalContext().setUpdatedInstance(form.recbrCarePlans().getValue());
		}
	}
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		loadAssociatedMdtCombo();
		form.getLocalContext().setUpdatedInstance(null);
		form.getLocalContext().setvoCancerCarePlan(null);
		form.setMode(FormMode.EDIT);
		form.dteCarePlan().setValue(new Date());
		updateControlState(true);
		form.btnNew().setEnabled(false);
	}
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
		loadAssociatedMdtCombo();
		setUpdatedRecord();
		updateControlState(true);
		form.btnNew().setEnabled(false);
	}

	private void updateControlState(boolean bEnabled) 
	{
		form.dteCarePlan().setEnabled(bEnabled);
		form.qmbConsultant().setEnabled(bEnabled);
		form.cmbTreatIntent().setEnabled(bEnabled);
		form.cmbRecurrence().setEnabled(bEnabled);
		form.txtNotes().setEnabled(bEnabled);
		
		form.cmbStatus().setEnabled(bEnabled);
		
		form.grdActualModality().setEnabled(!bEnabled);		
		form.grdActualModality().setReadOnly(!bEnabled);	
		
		form.dteAgreedDate().setEnabled(!bEnabled);
		form.txtReason().setEnabled(!bEnabled);
		
		form.chklistAntiCancerReason().setEnabled(!bEnabled);

		form.grdPlannedMod().setEnabled(bEnabled);		
		form.grdPlannedMod().setReadOnly(!bEnabled);	
		form.grdPlannedMod().isEnabled();
		
		form.btnProgress().setVisible(!bEnabled);
		form.btnRevise().setVisible(!bEnabled);
	}
	
	protected void onQmbConsultantTextSubmited(String value) throws PresentationLogicException 
	{
		form.qmbConsultant().clear();
		HcpLiteVoCollection voHCPColl = domain.listHcps(value);
		
		if(voHCPColl != null)
		{
			for (int i = 0; i < voHCPColl.size(); i++)
			{
				form.qmbConsultant().newRow(voHCPColl.get(i), voHCPColl.get(i).toString());
			}
			if (voHCPColl.size() == 1)
			{
				form.qmbConsultant().setValue(voHCPColl.get(0));
			}
			else if (voHCPColl.size() > 1)
			{
				form.qmbConsultant().showOpened();		
			}
		}
	}
	protected void onRecbrCarePlansValueChanged() throws PresentationLogicException 
	{
		displayRecord();
	}
	protected void onGrdPlannedModGridCheckBoxClicked(int column, grdPlannedModRow row, boolean isChecked) throws PresentationLogicException 
	{
		if(row.getcolSelect())
			row.setcolSequenceReadOnly(false);
		else
		{
			row.setcolSequenceReadOnly(true);
			row.setcolSequence(null);
		}
		
		if(row.getValue().getId() == CarePlanTreatmentModality.NOANTICANCERTREATMENT.getId())
		{
			if(isChecked)
			{
				form.chklistAntiCancerReason().setEnabled(true);
			}
			else
			{
				form.chklistAntiCancerReason().setValues(null);
				form.chklistAntiCancerReason().setEnabled(false);
			}
		}
	}
	protected void onGrdActualModalityGridCheckBoxClicked(int column, grdActualModalityRow row, boolean isChecked) throws PresentationLogicException 
	{
		if(row.getcolSelect())
			row.setcolSeqReadOnly(false);
		else
		{
			row.setcolSeqReadOnly(true);
			row.setcolSeq(null);
		}
		
		if(row.getValue().getId() == CarePlanTreatmentModality.NOANTICANCERTREATMENT.getId())
		{
			if(isChecked)
			{
				form.chklistAntiCancerReason().setEnabled(true);
			}
			else
			{
				form.chklistAntiCancerReason().setValues(null);
				form.chklistAntiCancerReason().setEnabled(false);
			}
		}
	}

	protected void onBtnRevisionReasonClick() throws PresentationLogicException 
	{
		engine.showMessage(form.getLocalContext().getvoCancerCarePlan().getReasonForRevision(), "Reason for Revision" , MessageButtons.OK);
	}
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException {
		engine.close(DialogResult.OK);			
	}
}
