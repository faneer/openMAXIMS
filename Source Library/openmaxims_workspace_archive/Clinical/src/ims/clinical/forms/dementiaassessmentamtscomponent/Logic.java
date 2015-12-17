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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.dementiaassessmentamtscomponent;

import ims.clinical.forms.dementiaassessmentamtscomponent.GenForm.GroupMedicationEnumeration;
import ims.clinical.forms.dementiaassessmentamtscomponent.GenForm.GroupPRotocolEnumeration;
import ims.clinical.vo.DementiaAssessAndInvestigateVo;
import ims.clinical.vo.DementiaAssessInvestigateNoteVo;
import ims.clinical.vo.DementiaVo;
import ims.clinical.vo.DementiaWorklistStatusVo;
import ims.clinical.vo.enums.DementiaEventEnumeration;
import ims.clinicaladmin.vo.DementiaTermConfigVo;
import ims.clinicaladmin.vo.lookups.DementiaTermConfig;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.lookups.DementiaWorklistStatus;
import ims.core.vo.lookups.YesNo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		edit();
	}
	
	private void edit()
	{
		form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.EDIT);
		form.fireCustomControlValueChanged();

		form.setMode(FormMode.EDIT);
		
		open();
		updateControlState();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			open();

			if (form.getLocalContext().getinFollowUpModeIsNotNull()
				&& form.getLocalContext().getinFollowUpMode())
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.RELOAD_AMTS_BROWSER);
			else
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.SAVE);
					
			form.fireCustomControlValueChanged();
		}
	}
	private void open()
	{
		populateScreenFromData();
		
	}

	private boolean save()
	{
		if ( ! validateData(true))
			return false;
		
		int nThreshold = 8;//Default as per specification
		if (form.getGlobalContext().Admin.getDementiaConfigurationIsNotNull()
			&& form.getGlobalContext().Admin.getDementiaConfiguration().getAMTSThresholdScoreIsNotNull())
			nThreshold = form.getGlobalContext().Admin.getDementiaConfiguration().getAMTSThresholdScore();

		form.getGlobalContext().Clinical.setAMTSRecordToView(null);
		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
		{
			DementiaAssessAndInvestigateVo voAMTSFollowUp = populateDataFromScreen();
			if (voAMTSFollowUp.getID_DementiaAssessAndInvestigateIsNotNull())
			{
				form.getLocalContext().getSelectedRecord().getFollowUpAssessments().set(form.getLocalContext().getSelectedRecord().getFollowUpAssessments().indexOf(voAMTSFollowUp), voAMTSFollowUp);
				form.getGlobalContext().Clinical.setAMTSRecordToView(voAMTSFollowUp);
			}
			else
			{
				form.getLocalContext().getSelectedRecord().getFollowUpAssessments().add(voAMTSFollowUp);
				form.getGlobalContext().Clinical.setAMTSRecordToView(null);
			}
			
		}
		else
		{
			form.getLocalContext().getSelectedRecord().setStepTwoAssess(populateDataFromScreen());
			form.getLocalContext().getSelectedRecord().setAMTSScore(form.txtTotalScore().getValue() != null ? new Integer(form.txtTotalScore().getValue()) : null);
		}
		
		//Create worklist status entry
		if ((form.getLocalContext().getinFollowUpMode() == null
				|| (form.getLocalContext().getinFollowUpModeIsNotNull()
				&&  !form.getLocalContext().getinFollowUpMode()) )
			&& (form.getLocalContext().getSelectedRecord().getCurrentWorklistStatus().getStatus().equals(DementiaWorklistStatus.STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING)
			|| form.getLocalContext().getSelectedRecord().getCurrentWorklistStatus().getStatus().equals(DementiaWorklistStatus.COMPLETED)
			|| form.getLocalContext().getSelectedRecord().getCurrentWorklistStatus().getStatus().equals(DementiaWorklistStatus.FOR_REFERRAL)) )
		{
			DementiaWorklistStatusVo voStat = new DementiaWorklistStatusVo();
			AuthoringInformationVo voAuthor = new AuthoringInformationVo();
			voAuthor.setAuthoringDateTime(new DateTime());
			if(domain.getHcpUser() != null)
				voAuthor.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
			voStat.setAuthoringInformation(voAuthor);

			if ((new Integer(form.txtTotalScore().getValue()) > nThreshold))
				voStat.setStatus(DementiaWorklistStatus.COMPLETED);
			else if ((new Integer(form.txtTotalScore().getValue()) == nThreshold))
				voStat.setStatus(DementiaWorklistStatus.FOR_REFERRAL);
			else if ((new Integer(form.txtTotalScore().getValue()) < nThreshold))
				voStat.setStatus(DementiaWorklistStatus.FOR_REFERRAL);
			
			form.getLocalContext().getSelectedRecord().setCurrentWorklistStatus(voStat);
			form.getLocalContext().getSelectedRecord().getHistoricalWorklistStatus().add(voStat);
		}
		String[] str = form.getLocalContext().getSelectedRecord().validate();
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);
			return false;
		}

		try 
		{
			form.getLocalContext().setSelectedRecord(domain.saveDementia(form.getLocalContext().getSelectedRecord()));
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			
			form.getLocalContext().setSelectedRecord(domain.getDementia(form.getLocalContext().getSelectedRecord()));
			open();
			if (form.getLocalContext().getinFollowUpModeIsNotNull()
				&& form.getLocalContext().getinFollowUpMode())
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.RELOAD_AMTS_BROWSER);
			else
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.SAVE);
			form.fireCustomControlValueChanged();

			form.setMode(FormMode.VIEW);			
			return false;
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			form.getLocalContext().setSelectedRecord(domain.getDementia(form.getLocalContext().getSelectedRecord()));
			open();
			if (form.getLocalContext().getinFollowUpModeIsNotNull()
				&& form.getLocalContext().getinFollowUpMode())
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.SOE); //wdev-16368
			else
				form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.SOE);
			
			form.fireCustomControlValueChanged();
			form.setMode(FormMode.VIEW);
			return false;
		} 
		
		form.setMode(FormMode.VIEW);			
		
		return true;
	}

	private boolean validateData(boolean bShowMessage)
	{

		StringBuffer sb = new StringBuffer();
		if (form.lblConfirmMedication().isVisible()
			&& form.GroupMedication().getValue().equals(GroupMedicationEnumeration.None))
			sb.append(form.lblConfirmMedication().getValue() + " is mandatory.");
		
		if (form.lblConfirmTrust().isVisible()
			&& form.GroupPRotocol().getValue().equals(GroupPRotocolEnumeration.None))
		{
			
			if (sb.toString().length() >0)
				sb.append("\n\n");
			sb.append(form.lblConfirmTrust().getValue() + " is mandatory.");
		}

		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
			sb = new StringBuffer();
		
		if (form.txtTotalScore().getValue() == null
			|| form.txtTotalScore().getValue().equals(""))
			sb.append("Score has not yet been calculated. Finish the assessment and Save again.");

		if (sb.toString().length() >0)
		{
			if (bShowMessage)
				engine.showMessage(sb.toString());
			
			return false;
		}
		
		return true;
	}

	private void updateControlState()
	{
		form.btnEdit().setVisible(false);
		form.btnNewFollowUp().setVisible(false);
		form.btnEditFollowUp().setVisible(false);

		if (form.getMode().equals(FormMode.VIEW))
		{
			if( form.getLocalContext().getSelectedRecordIsNotNull() 
				&& form.getLocalContext().getSelectedRecord().getStepTwoAssessIsNotNull()
				&& form.getLocalContext().getSelectedRecord().getStepTwoAssess().getID_DementiaAssessAndInvestigateIsNotNull()
				&& form.getLocalContext().getSelectedRecord().getStepTwoAssess().getAuthoringInformationIsNotNull()
				&& form.getLocalContext().getSelectedRecord().getStepTwoAssess().getAuthoringInformation().getAuthoringHcpIsNotNull()
				&& domain.getHcpLiteUser() != null)
			{
				if ( ((HcpLiteVo) domain.getHcpLiteUser()).equals(form.getLocalContext().getSelectedRecord().getStepTwoAssess().getAuthoringInformation().getAuthoringHcp())
					|| (engine.hasRight(AppRight.CAN_EDIT_AND_RIE_DEMENTIA)) )
					form.btnEdit().setVisible(true);
			}
			else if (domain.getHcpLiteUser() != null)
				form.btnEdit().setVisible(true);
		}
		if (form.getMode().equals(FormMode.VIEW)
			&& form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
		{
			if( form.getLocalContext().getSelectedAMTSRecordIsNotNull() 
				&& form.getLocalContext().getSelectedAMTSRecord().getID_DementiaAssessAndInvestigateIsNotNull()
				&& domain.getHcpLiteUser() != null)
			{
				if( ((HcpLiteVo) domain.getHcpLiteUser()).equals(form.getLocalContext().getSelectedAMTSRecord().getAuthoringInformation().getAuthoringHcp())
					|| ( domain.getHcpLiteUser() != null && engine.hasRight(AppRight.CAN_EDIT_AND_RIE_DEMENTIA)) )
					form.btnEditFollowUp().setVisible(true);

				if (domain.getHcpLiteUser() != null)
					form.btnNewFollowUp().setVisible(true);
			} 
			else if (domain.getHcpLiteUser() != null)
				form.btnNewFollowUp().setVisible(true);
		}

		form.btnRIE().setVisible(form.getMode().equals(FormMode.VIEW) 
			&& form.getLocalContext().getSelectedRecord() != null 
			&& form.getLocalContext().getSelectedRecord().getStepTwoAssess() !=null
			&& ! form.getLocalContext().getinFollowUpMode()
			&& engine.hasRight(AppRight.CAN_EDIT_AND_RIE_DEMENTIA)	);
		
		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
		{
			form.txtComment().setVisible(false);
		
			form.btnEdit().setVisible(false);
		}
		else
			form.txtComment().setEnabled(form.getMode().equals(FormMode.EDIT));

		form.btnSave().setEnabled(false);
		if ( validateData(false))
			form.btnSave().setEnabled(form.getMode().equals(FormMode.EDIT));
		
		form.btnSave().setVisible(form.getMode().equals(FormMode.EDIT));
		form.btnCancel().setVisible(form.getMode().equals(FormMode.EDIT));
		
		hideShowBottomQuestionsBasedOnThreshold(false);
	}
	private void populateQuestions()
	{
		DementiaTermConfig lkpHint = new DementiaTermConfig();
		
		lkpHint.setId(DementiaTermConfig.AMTS_AGE.getID());
		DementiaTermConfigVo voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null  )
			form.lblAge().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_DOB.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblDOB().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_QUESTION.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblRepeat42().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_CURRENT_YEAR.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblCurrentYear().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_CURRENT_TIME.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null  )
			form.lblCurrentTime().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_HOSP_NAME.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblNameOfHospital().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_TWO_PEOPLE.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null  )
			form.lblRecognizetwopeople().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_WW_TWO.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null  )
			form.lblYearOfWW2().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_MONARCH.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblWhoIsMonarch().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_COUNT.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null  )
			form.lblCountbackwards().setValue(voHint.getHelpText());
		
		lkpHint.setId(DementiaTermConfig.AMTS_RECALL_QUESTION.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null )
			form.lblRecall42().setValue(voHint.getHelpText());
		
		
		lkpHint.setId(DementiaTermConfig.AMTS_TRUST_PROTOCOL.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if ( voHint != null )
		{
			 form.imbConfirmTrustProtocol().setTooltip(voHint.getHelpText());
		}
		
		lkpHint.setId(DementiaTermConfig.AMTS_TRUST_PROTOCOL_TEXT.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if ( voHint != null )
		{
			 form.lblConfirmTrust().setValue(voHint.getHelpText());
			
		}
		
		lkpHint.setId(DementiaTermConfig.AMTS_MED_REVIEW.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if ( voHint != null )
		{
			 form.imbConfirmMedication().setTooltip(voHint.getHelpText());
		}
		
		lkpHint.setId(DementiaTermConfig.AMTS_MED_REVIEW_LABEL_TEXT.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if ( voHint != null )
		{
			 form.lblConfirmMedication().setValue(voHint.getHelpText());
			
		}
	
		lkpHint.setId(DementiaTermConfig.AMTS_FORM_HELP.getID());
		voHint = domain.getHintByLookupID(lkpHint);
		if ( voHint != null )
		{
			 form.imbAMTSForm().setTooltip(voHint.getHelpText());
		}

	}
	

	public void setModeForm(FormMode modeform) 
	{
		form.setMode(modeform);
		
	}

	public void initialize() 
	{
	}
	private void clearTenQuestions()
	{
		form.chkAgeYes().setValue(null);
		form.chkAgeNo().setValue(null);
		form.chkDBYes().setValue(null);
		form.chkDBNo().setValue(null);
		form.chkCurrentYearYes().setValue(null);
		form.chkCurrentYearNo().setValue(null);
		form.chkCurrentTimeYes().setValue(null);
		form.chkCurrentTimeNo().setValue(null);
		form.chkNameHospitalYes().setValue(null);
		form.chkNameHospitalNo().setValue(null);
		form.chkRecogniseYes().setValue(null);
		form.chkRecogniseNo().setValue(null);
		form.chkYearWW2Yes().setValue(null);
		form.chkYearWW2No().setValue(null);
		form.chkMonarchNo().setValue(null);
		form.chkMonarchYes().setValue(null);
		form.chkCountYes().setValue(null);
		form.chkCountNo().setValue(null);
		form.chkRecallYes().setValue(null);
		form.chkRecallNo().setValue(null);
	}
	private void clearLastTwoQuestions()
	{
		form.GroupMedication().setValue(GroupMedicationEnumeration.None);
		form.GroupPRotocol().setValue(GroupPRotocolEnumeration.None);
	}

	private void clearAllControls()
	{
		clearTenQuestions();
		form.txtTotalScore().setValue(null);
		form.txtComment().setValue(null);
		clearLastTwoQuestions();
	}

	protected void onFormModeChanged() 
	{
		updateControlState();
	}

	public DementiaEventEnumeration getSelectedEvent() 
	{
		return form.getLocalContext().getSelectedEvent();
	}

	
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		hideShowBottomQuestionsBasedOnThreshold(false);

		open();
		form.setMode(FormMode.VIEW);			

		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
			form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.RELOAD_AMTS_BROWSER);
		else
			form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.CANCEL);
		form.fireCustomControlValueChanged();
	}

	@Override
	protected void onChkRecallYesValueChanged() throws PresentationLogicException
	{
		form.chkRecallNo().setValue(false);
		calculateAndDisplayScore();
	}

	private void hideShowBottomQuestionsBasedOnThreshold(Boolean hideshow)
	{
		int nThreshold = 8;//Default as per specification
		boolean bThresholdExceeded = false;
		boolean bDelerium = false;
		boolean bAllCompleted = false;
		if (form.getGlobalContext().Admin.getDementiaConfigurationIsNotNull()
			&& form.getGlobalContext().Admin.getDementiaConfiguration().getAMTSThresholdScoreIsNotNull())
			nThreshold = form.getGlobalContext().Admin.getDementiaConfiguration().getAMTSThresholdScore();

		if (form.txtTotalScore().getValue() != "" 
			&& form.txtTotalScore().getValue() != null)
			bAllCompleted = true;
		
		if (form.txtTotalScore().getValue() != "" 
			&& form.txtTotalScore().getValue() != null ? new Integer(form.txtTotalScore().getValue()) <= nThreshold : false)
		{
			hideshow = true;
			bThresholdExceeded = true;
		}
		else
			hideshow = false;

		if (form.getLocalContext().getSelectedRecordIsNotNull()
			&& form.getLocalContext().getSelectedRecord().getDeliriumConfirmedIsNotNull()
			&& form.getLocalContext().getSelectedRecord().getDeliriumConfirmed())
		{
			hideshow = true;
		    bDelerium = true;
		}
		
		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
		{
			form.txtComment().setVisible(false);
			form.lblComment().setVisible(false);
			form.lblComment1().setVisible(false);			//wdev-16421
			hideshow = false;
		}
			
		form.imbConfirmTrustProtocol().setVisible(hideshow);
		if (hideshow)
			form.imbConfirmTrustProtocol().setEnabled(false);
		form.lblConfirmTrust().setVisible(hideshow);
		form.GroupPRotocol().setVisible(hideshow);
		form.GroupPRotocol().setEnabled(form.getMode().equals(FormMode.EDIT) && (bThresholdExceeded || (bAllCompleted && bDelerium)) );
		
		form.imbConfirmMedication().setVisible(hideshow);
		if (hideshow)
			form.imbConfirmMedication().setEnabled(false);
		form.lblConfirmMedication().setVisible(hideshow);
		form.GroupMedication().setVisible(hideshow);
		form.GroupMedication().setEnabled(form.getMode().equals(FormMode.EDIT) && (bThresholdExceeded || (bAllCompleted && bDelerium)) );		
		form.hzl34().setVisible(hideshow);
		form.hzl35().setVisible(hideshow);
		
	}

	private void calculateAndDisplayScore()
	{
		int nScore =0;
		form.txtTotalScore().setValue("");
		
		if (form.chkAgeYes().getValue())
			nScore++;

		if (form.chkDBYes().getValue())
			nScore++;

		if (form.chkCurrentYearYes().getValue())
			nScore++;

		if (form.chkCurrentTimeYes().getValue())
			nScore++;

		if (form.chkNameHospitalYes().getValue())
			nScore++;

		if (form.chkRecogniseYes().getValue())
			nScore++;

		if (form.chkYearWW2Yes().getValue())
			nScore++;

		if (form.chkMonarchYes().getValue())
			nScore++;

		if (form.chkCountYes().getValue())
			nScore++;

		if (form.chkRecallYes().getValue())
			nScore++;

		form.btnSave().setEnabled(false);
		
		if (	(form.chkAgeYes().getValue() || form.chkAgeNo().getValue())
			&&	(form.chkDBYes().getValue() || form.chkDBNo().getValue())
			&&	(form.chkCurrentYearYes().getValue() || form.chkCurrentYearNo().getValue())
			&&	(form.chkCurrentTimeYes().getValue() || form.chkCurrentTimeNo().getValue())
			&&	(form.chkNameHospitalYes().getValue() || form.chkNameHospitalNo().getValue())
			&&	(form.chkRecogniseYes().getValue() || form.chkRecogniseNo().getValue())
			&&	(form.chkYearWW2Yes().getValue() || form.chkYearWW2No().getValue())
			&&	(form.chkMonarchYes().getValue() || form.chkMonarchNo().getValue())
			&&	(form.chkCountYes().getValue() || form.chkCountNo().getValue())
			&&	(form.chkRecallYes().getValue() || form.chkRecallNo().getValue())
			)
		{	
			form.txtTotalScore().setValue( new Integer(nScore).toString());
			hideShowBottomQuestionsBasedOnThreshold(true);
			if ( validateData(false))
				form.btnSave().setEnabled(form.getMode().equals(FormMode.EDIT));
		}
	}

	@Override
	protected void onChkCountYesValueChanged() throws PresentationLogicException
	{
		form.chkCountNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkMonarchYesValueChanged() throws PresentationLogicException
	{
		form.chkMonarchNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkYearWW2YesValueChanged() throws PresentationLogicException
	{
		form.chkYearWW2No().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkRecogniseYesValueChanged() throws PresentationLogicException
	{
		form.chkRecogniseNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkNameHospitalYesValueChanged() throws PresentationLogicException
	{
		form.chkNameHospitalNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkCurrentTimeYesValueChanged() throws PresentationLogicException
	{
		form.chkCurrentTimeNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkCurrentYearYesValueChanged() throws PresentationLogicException
	{
		form.chkCurrentYearNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkDBYesValueChanged() throws PresentationLogicException
	{
		form.chkDBNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkAgeYesValueChanged() throws PresentationLogicException
	{
		form.chkAgeNo().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkRecallNoValueChanged() throws PresentationLogicException
	{
		form.chkRecallYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkCountNoValueChanged() throws PresentationLogicException
	{
		form.chkCountYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkMonarchNoValueChanged() throws PresentationLogicException
	{
		form.chkMonarchYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkYearWW2NoValueChanged() throws PresentationLogicException
	{
		form.chkYearWW2Yes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkRecogniseNoValueChanged() throws PresentationLogicException
	{
		form.chkRecogniseYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkNameHospitalNoValueChanged() throws PresentationLogicException
	{
		form.chkNameHospitalYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkCurrentTimeNoValueChanged() throws PresentationLogicException
	{
		form.chkCurrentTimeYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkCurrentYearNoValueChanged() throws PresentationLogicException
	{
		form.chkCurrentYearYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkDBNoValueChanged() throws PresentationLogicException
	{
		form.chkDBYes().setValue(false);
		calculateAndDisplayScore();
	}

	@Override
	protected void onChkAgeNoValueChanged() throws PresentationLogicException
	{
		form.chkAgeYes().setValue(false);
		calculateAndDisplayScore();
	}

	public void initialize(DementiaVo voDementia, FormMode formMode, DementiaAssessAndInvestigateVo voAMTS)
	{
		form.getLocalContext().setSelectedRecord(voDementia);
		form.getLocalContext().setinFollowUpMode(false);
		form.getLocalContext().setSelectedAMTSRecord(null);
		if (voAMTS != null)
		{
			form.getLocalContext().setSelectedAMTSRecord(voAMTS);
			form.getLocalContext().setinFollowUpMode(true);
		}

		populateQuestions();
		hideShowBottomQuestionsBasedOnThreshold(false);
		initializeAuthoringControls(null);

		form.setMode(formMode);
		
		open();
	}

	private void initializeAuthoringControls(AuthoringInformationVo voAuthoring)
	{
		if (voAuthoring == null)
		{
			voAuthoring = new AuthoringInformationVo();
			voAuthoring.setAuthoringDateTime(new DateTime());
			voAuthoring.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		}
		
		form.lblAuthoringDateTime().setValue(voAuthoring.getAuthoringDateTime().toString());
		if (voAuthoring.getAuthoringHcpIsNotNull())
		{
			if (voAuthoring.getAuthoringHcp().getIHcpName().length() > 65)
			{
				form.lblAuthoringHCP().setTooltip(voAuthoring.getAuthoringHcp().getIHcpName());
				form.lblAuthoringHCP().setValue(voAuthoring.getAuthoringHcp().getIHcpName().substring(0, 65));
			}
			else
				form.lblAuthoringHCP().setValue(voAuthoring.getAuthoringHcp().getIHcpName());
		}
		
	}

	private void populateScreenFromData()
	{
		clearAllControls();
		
		DementiaAssessAndInvestigateVo voAMTS = null;
		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode()
			&& form.getLocalContext().getSelectedAMTSRecordIsNotNull())
			voAMTS = form.getLocalContext().getSelectedAMTSRecord();
		else if (form.getLocalContext().getSelectedRecordIsNotNull())
			voAMTS = form.getLocalContext().getSelectedRecord().getStepTwoAssess();

		if (voAMTS == null || voAMTS.getID_DementiaAssessAndInvestigate() == null)
			return;

		if (voAMTS != null)
		{
			initializeAuthoringControls(voAMTS.getAuthoringInformation());
			
			//Age
			if (voAMTS.getQ1Age().equals(YesNo.YES))
				form.chkAgeYes().setValue(true);
			else
				form.chkAgeNo().setValue(true);
			
			//DOB
			if (voAMTS.getQ2DOB().equals(YesNo.YES))
				form.chkDBYes().setValue(true);
			else
				form.chkDBNo().setValue(true);

			//Current Year
			if(voAMTS.getQ3CurrentYear().equals(YesNo.YES))
				form.chkCurrentYearYes().setValue(true);
			else
				form.chkCurrentYearNo().setValue(true);

			//Current Time
			if (voAMTS.getQ4CurrentTime().equals(YesNo.YES))
				form.chkCurrentTimeYes().setValue(true);
			else
				form.chkCurrentTimeNo().setValue(true);

			//name of hospital
			if (voAMTS.getQ5NameOfHospital().equals(YesNo.YES))
				form.chkNameHospitalYes().setValue(true);
			else
				form.chkNameHospitalNo().setValue(true);

			//recognise
			if (voAMTS.getQ6RecognisePeople().equals(YesNo.YES))
				form.chkRecogniseYes().setValue(true);
			else
				form.chkRecogniseNo().setValue(true);

			//ww2
			if (voAMTS.getQ7YearWW2Ended().equals(YesNo.YES))
				form.chkYearWW2Yes().setValue(true);
			else
				form.chkYearWW2No().setValue(true);

			//Monach
			if (voAMTS.getQ8Monarch().equals(YesNo.YES))
				form.chkMonarchYes().setValue(true);
			else
				form.chkMonarchNo().setValue(true);

			//Backwards from 20
			if (voAMTS.getQ9CountBackwards().equals(YesNo.YES))
				form.chkCountYes().setValue(true);
			else
				form.chkCountNo().setValue(true);

			//Recall
			if (voAMTS.getQ10Recall().equals(YesNo.YES))
				form.chkRecallYes().setValue(true);
			else
				form.chkRecallNo().setValue(true);

			calculateAndDisplayScore();
			
			if(voAMTS.getConfirmMedicationReviewIsNotNull())
				form.GroupMedication().setValue(voAMTS.getConfirmMedicationReview().equals(YesNo.YES) ? GroupMedicationEnumeration.rdoMedicationYES : GroupMedicationEnumeration.rdoMedicationNO);

			if(voAMTS.getConfirmTrustsProtocolIsNotNull())
				form.GroupPRotocol().setValue(voAMTS.getConfirmTrustsProtocol().equals(YesNo.YES) ? GroupPRotocolEnumeration.rdoTrustProtocolYES : GroupPRotocolEnumeration.rdoTrustProtocolNO);

			form.txtComment().setValue(voAMTS.getStepTwoAssessNoteIsNotNull() ? voAMTS.getStepTwoAssessNote().getNote() : "");
			
			if ( validateData(false))
				form.btnSave().setEnabled(form.getMode().equals(FormMode.EDIT));
		}
		
	}
	
	private DementiaAssessAndInvestigateVo populateDataFromScreen()
	{
		DementiaAssessAndInvestigateVo voAMTS = form.getLocalContext().getSelectedRecord().getStepTwoAssess();
		
		if (form.getLocalContext().getinFollowUpModeIsNotNull()
			&& form.getLocalContext().getinFollowUpMode())
			 voAMTS = form.getLocalContext().getSelectedAMTSRecord();
		
		if (voAMTS == null)
			voAMTS = new DementiaAssessAndInvestigateVo();
		
		AuthoringInformationVo voAuthor = new AuthoringInformationVo();
		if (voAMTS.getAuthoringInformation() == null)
		{
			voAuthor.setAuthoringDateTime(new DateTime());
			if(domain.getHcpUser() != null)
				voAuthor.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());

			voAMTS.setAuthoringInformation(voAuthor);
		}
		voAMTS.setAMTSScore(form.txtTotalScore().getValue() != null ? new Integer(form.txtTotalScore().getValue()) : null);

		//Age
		if(form.chkAgeYes().getValue())
			voAMTS.setQ1Age(YesNo.YES);
		else
			voAMTS.setQ1Age(YesNo.NO);
			
		//DOB
		if(form.chkDBYes().getValue())
			voAMTS.setQ2DOB(YesNo.YES);
		else
			voAMTS.setQ2DOB(YesNo.NO);

		//Current Year
		if(form.chkCurrentYearYes().getValue())
			voAMTS.setQ3CurrentYear(YesNo.YES);
		else
			voAMTS.setQ3CurrentYear(YesNo.NO);

		//Current Time
		if(form.chkCurrentTimeYes().getValue())
			voAMTS.setQ4CurrentTime(YesNo.YES);
		else
			voAMTS.setQ4CurrentTime(YesNo.NO);

		//name of hospital
		if(form.chkNameHospitalYes().getValue())
			voAMTS.setQ5NameOfHospital(YesNo.YES);
		else
			voAMTS.setQ5NameOfHospital(YesNo.NO);

		//recognise
		if(form.chkRecogniseYes().getValue())
			voAMTS.setQ6RecognisePeople(YesNo.YES);
		else
			voAMTS.setQ6RecognisePeople(YesNo.NO);

		//ww2
		if(form.chkYearWW2Yes().getValue())
			voAMTS.setQ7YearWW2Ended(YesNo.YES);
		else
			voAMTS.setQ7YearWW2Ended(YesNo.NO);

		//Monach
		if(form.chkMonarchYes().getValue())
			voAMTS.setQ8Monarch(YesNo.YES);
		else
			voAMTS.setQ8Monarch(YesNo.NO);

		//Backwards from 20
		if(form.chkCountYes().getValue())
			voAMTS.setQ9CountBackwards(YesNo.YES);
		else
			voAMTS.setQ9CountBackwards(YesNo.NO);

		//Recall
		if(form.chkRecallYes().getValue())
			voAMTS.setQ10Recall(YesNo.YES);
		else
			voAMTS.setQ10Recall(YesNo.NO);

		voAMTS.setConfirmMedicationReview(null);
		if(form.lblConfirmMedication().isVisible())
			voAMTS.setConfirmMedicationReview(form.GroupMedication().getValue().equals(GroupMedicationEnumeration.rdoMedicationYES) ? YesNo.YES : YesNo.NO);
		else
			voAMTS.setConfirmMedicationReview(null);
			
		voAMTS.setConfirmTrustsProtocol(null);
		if(form.lblConfirmTrust().isVisible())
			voAMTS.setConfirmTrustsProtocol(form.GroupPRotocol().getValue().equals(GroupPRotocolEnumeration.rdoTrustProtocolYES) ? YesNo.YES : YesNo.NO);
		else
			voAMTS.setConfirmTrustsProtocol(null);

		if (form.txtComment().isVisible()
			&& form.txtComment().getValue() != null
			&& form.txtComment().getValue().length() >0)
		{
			if (voAMTS.getStepTwoAssessNote() == null)
				voAMTS.setStepTwoAssessNote(new DementiaAssessInvestigateNoteVo());

			if (voAuthor.getAuthoringDateTime() == null) // i.e. was this initialised above, if not then do the domain calls to populate
			{
				voAuthor.setAuthoringDateTime(new DateTime());
				if(domain.getHcpUser() != null)
					voAuthor.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
			}
				
			voAMTS.getStepTwoAssessNote().setAuthoringInformation(voAuthor);
			voAMTS.getStepTwoAssessNote().setNote(form.txtComment().getValue());
		}
		else
		{
			voAMTS.setStepTwoAssessNote(null); // WDEV-16373
		}
		return voAMTS; 
	}

	public DementiaVo getValue()
	{
		return form.getLocalContext().getSelectedRecord();
	}

	public void resetSelectedEvent()
	{
		form.getLocalContext().setSelectedEvent(null);
	}

	@Override
	protected void onBtnRIEClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Core.RieConfirmationDialog);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.RieConfirmationDialog) && DialogResult.OK.equals(result))
		{
			form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.MARK_RIE);
			form.fireCustomControlValueChanged();
			open();
		}
		 
	}
	

	@Override
	protected void onBtnEditFollowUpClick() throws PresentationLogicException
	{
		edit();
	}

	@Override
	protected void onBtnNewFollowUpClick() throws PresentationLogicException
	{
		form.getLocalContext().setSelectedEvent(DementiaEventEnumeration.EDIT);
		form.fireCustomControlValueChanged();

		form.setMode(FormMode.EDIT);
		form.getLocalContext().setSelectedAMTSRecord(null);
		clearAllControls();
		hideShowBottomQuestionsBasedOnThreshold(false);
		initializeAuthoringControls(null);
		updateControlState();
	}

	@Override
	protected void onRadioButtonGroupMedicationValueChanged() throws PresentationLogicException
	{
		if ( validateData(false))
			form.btnSave().setEnabled(form.getMode().equals(FormMode.EDIT));
	}

	@Override
	protected void onRadioButtonGroupPRotocolValueChanged() throws PresentationLogicException
	{
		if ( validateData(false))
			form.btnSave().setEnabled(form.getMode().equals(FormMode.EDIT));
	}

}
