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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3853.21665)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.extendedclinicalnotes;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.authoringinfo.IComponent;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.ClinicalNoteStatusVoCollection;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.lookups.ClinicalNoteType;
import ims.core.vo.lookups.ClinicalNotesStatus;
import ims.core.vo.lookups.ClinicalNotingMode;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.SourceOfNote;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private void initialiseScreenControls() 
	{
		form.lblDiscipline().setVisible(true);
		form.customControlAuthoring().setIsRequiredPropertyToControls(true);
		form.lblCorrect().setVisible(false);
		form.txtCorrectionReason().setVisible(false);
		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		form.btnClose().setEnabled(true);

		if (isDialog())
			onBtnCloseClick();
		else
			openNotingDetails();
	}
	
	private boolean isDialog()
	{
		return engine.isDialog();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			openNotingDetails();

		form.btnClose().setEnabled(true);
	}
	
	private String[] getUiErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.customControlAuthoring().getValue() != null
			&& (form.customControlAuthoring().getValue().getAuthoringHcp() == null
				|| (form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull()
				&& form.customControlAuthoring().getValue().getAuthoringHcp().getID_Hcp() == null)))
				errors.add("Authoring HCP is mandatory.");

		if (form.ccRecordingUser().getValue() == null)
			errors.add("Recording HCP is mandatory.");

		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.CORRECTION)
			&& form.txtCorrectionReason().getValue() == null)
				errors.add("Correction Reason is a required field.");
		
		if(form.cmbNoteType().getValue() == null)
		{
			errors.add("Note Type is mandatory");
		}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid Clinical Notes record", searchErrors);
			return searchErrors;
		}
		return null;
	}
	
	private boolean save() throws PresentationLogicException
	{
		String[] uiErrors = getUiErrors();
		if(uiErrors != null && uiErrors.length > 0)
		{
			engine.showErrors(uiErrors);
			return false;
		}

		ClinicalNotesVo record = populateDataFromScreen(form.getLocalContext().getclinicalNotesVo());
		if (record == null)
			return false;
		
		String[] errors = record.validate(uiErrors);
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			record = domain.saveClinicalNotesAndClinicalContact(record,form.getGlobalContext().Core.getCurrentClinicalContact());
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setclinicalNotesVo(record);
			//form.getGlobalContext().Clinical.setCurrentClinicalNote(null);
			form.getGlobalContext().Clinical.setCurrentClinicalNote(record); //wdev-14614
			openNotingDetails();
			if(	isDialog())													//wdev-14614
			{
				
				if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull() &&  form.getGlobalContext().Clinical.getCurrentClinicalNote().getCurrentStatusIsNotNull() && form.getGlobalContext().Clinical.getCurrentClinicalNote().getCurrentStatus().getStatusIsNotNull() && ClinicalNotesStatus.CORRECTED.equals(form.getGlobalContext().Clinical.getCurrentClinicalNote().getCurrentStatus().getStatus()))
				{
					form.setMode(FormMode.VIEW);
					form.btnClose().setVisible(true);
				}
				else
					enableOrDisableControls();
					
			}
			return false;
		}
		catch(CodingRuntimeException e)
		{
			if ("ANOTHER_NOTE_FOR_CLINICAL_CONTACT".equals(e.getMessage()))
				throw new FormOpenException("A clinical note of a different type has been created for this clincal contact by another user");
			form.getGlobalContext().Clinical.setCurrentClinicalNote(null);
			engine.showMessage(e.getMessage());
			openNotingDetails();
			return false;
		}
		catch(DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			openNotingDetails();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		form.getLocalContext().setclinicalNotesVo(record);
		form.getGlobalContext().Clinical.setCurrentClinicalNote(record);
	
		if (isDialog())
		{		
			onBtnCancelClick();
			onBtnCloseClick();	
			return false;

		}
		
		return true;
		
	}
	
	private ClinicalNotesVo populateDataFromScreen(ClinicalNotesVo clinicalNotesVo) 
	{
		if (clinicalNotesVo == null)
			clinicalNotesVo = new ClinicalNotesVo();
		
		if ( ! clinicalNotesVo.getCareContextIsNotNull()
			&& clinicalNotesVo.getID_ClinicalNotes() == null)
			clinicalNotesVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if ( ! clinicalNotesVo.getClinicalContactIsNotNull()
			&& clinicalNotesVo.getID_ClinicalNotes() == null)
			clinicalNotesVo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		MemberOfStaffShortVo mos = null;
		if (getDisciplineForLoggedInUser(clinicalNotesVo) != null)
			mos = getDisciplineForLoggedInUser(clinicalNotesVo);
		else
			return null;
		
		//Save old Status to check for active
		ClinicalNoteStatusVo voPreviousStat = clinicalNotesVo.getCurrentStatus();
		ClinicalNoteStatusVo voStat = new ClinicalNoteStatusVo();
		
		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.CORRECTION))
			voStat.setStatus(ClinicalNotesStatus.CORRECTED);

		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.NEW))
				voStat.setStatus(ClinicalNotesStatus.DRAFT);

		voStat.setDateTime(new DateTime());
		voStat.setMOS(mos != null ? mos : null);
	
		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.CORRECTION))
		{
			voStat.setClinicalNote(clinicalNotesVo.getClinicalNote());
			voStat.setCorrectionReason(form.txtCorrectionReason().getValue());
			voStat.setCorrectedBy(mos);
			voStat.setStatus(ClinicalNotesStatus.CORRECTED);
			
			clinicalNotesVo.setIsCorrected(new Boolean(true));
		}

		clinicalNotesVo.setNoteType(ClinicalNoteType.CLINICALNOTE);
		clinicalNotesVo.setNoteClassification(form.cmbNoteType().getValue());

		if (voStat.getStatusIsNotNull())
			clinicalNotesVo.setCurrentStatus(voStat);
		else
			clinicalNotesVo.setCurrentStatus(voPreviousStat);
		
		clinicalNotesVo.setStatusHistory(addStatusToCollection(clinicalNotesVo.getStatusHistory(),voStat));
		
		clinicalNotesVo.setInHospitalReport(Boolean.FALSE);
		
		if(form.customControlAuthoring().getValue()!=null)
		{
			HcpDisType hcpDisType = 
				form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull()	&& 
					form.customControlAuthoring().getValue().getAuthoringHcp().getHcpTypeIsNotNull() ?
							form.customControlAuthoring().getValue().getAuthoringHcp().getHcpType() : null;
			clinicalNotesVo.setDiscipline(hcpDisType);
		}
		
		if(form.customControlAuthoring().getValue()!=null)
		{
			AuthoringInformationVo voAuthor = new AuthoringInformationVo();
			voAuthor.setAuthoringDateTime(
					form.customControlAuthoring().getValue() != null && 
						form.customControlAuthoring().getValue().getAuthoringDateTimeIsNotNull() ? 
								form.customControlAuthoring().getValue().getAuthoringDateTime() : null);
			voAuthor.setAuthoringHcp(
					form.customControlAuthoring().getValue() != null &&
						form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull() ? 
								form.customControlAuthoring().getValue().getAuthoringHcp() : null);
					
			if(voAuthor.getAuthoringDateTime()==null || voAuthor.getAuthoringHcp()==null)
				clinicalNotesVo.setAuthoringInfo(null);
			else
				clinicalNotesVo.setAuthoringInfo(voAuthor);
		}
		
		if (ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO")//wdev-14623
			&& clinicalNotesVo.getID_ClinicalNotesIsNotNull()
			&& clinicalNotesVo.getAuthoringInfo() == null)//added to get around the fact that authoring info is mandatory in BO.put in here and get around the non-null.
			clinicalNotesVo.setAuthoringInfo(new AuthoringInformationVo());//if fields are blank a AuthoringInfo object will be put in here and get around the non-null.

		clinicalNotesVo.setForReview(null);
		clinicalNotesVo.setForReviewDiscipline(null);
		
		clinicalNotesVo.setRecordingDateTime(form.dtimRecordingDateTime().getValue()); 
		clinicalNotesVo.setRecordingUser((MemberOfStaffLiteVo) form.ccRecordingUser().getValue());

		clinicalNotesVo.setClinicalNote(form.richNotes().getValue());
		
		clinicalNotesVo.setIsDerivedNote(Boolean.FALSE);
		clinicalNotesVo.setSourceOfNote(SourceOfNote.CLINICALCLINICALNOTE);
		
		return clinicalNotesVo;
	}

	protected void showHideCustomComponent(IComponent customControl, Boolean isEnabled, boolean initialize)
	{	
		if (customControl != null)
		{
			customControl.setEnabledAuthoringHCP(isEnabled);
			customControl.setEnabledDateTime(isEnabled);
		}
		
		if (customControl != null &&
				initialize != false)
		{	
			customControl.initializeComponent();
		}
	}
	
	private MemberOfStaffShortVo getDisciplineForLoggedInUser(ClinicalNotesVo clinicalNotesVo)
	{
		MemberOfStaffVo fullVo = null;
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();

		if (form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.CORRECTION))
			return mos;
			
		if (mos != null)
			fullVo = domain.getMemberOfStaff(mos);

		if (fullVo != null)
		{
			if (fullVo.getHcpIsNotNull() && fullVo.getHcp() instanceof MedicVo)
			{
				MedicVo voMedic = (MedicVo)fullVo.getHcp();
				if (voMedic.getHcpTypeIsNotNull())
					clinicalNotesVo.setDiscipline(voMedic.getHcpType());
				else
				{
					engine.showMessage("Please select a Discipline type for the logged in user.");
					return null;
				}
			}
			else
			{
				if (form.customControlAuthoring().getValue()!=null && form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull()
					&& form.customControlAuthoring().getValue().getAuthoringHcp().getHcpTypeIsNotNull())
					clinicalNotesVo.setDiscipline(form.customControlAuthoring().getValue().getAuthoringHcp().getHcpType());
				else
				{
					engine.showMessage("No Discipline is available. Please choose an authoring user.");
					return null;
				}
			}
		}
		else
		{
			engine.showMessage("Member of Staff is Null.");
			return null;
		}
		return mos;
	}
	
	private ClinicalNoteStatusVoCollection addStatusToCollection(ClinicalNoteStatusVoCollection statusHistory, ClinicalNoteStatusVo voStat) 
	{
		ClinicalNoteStatusVoCollection voColl = statusHistory;
		if (voColl == null)
			voColl = new ClinicalNoteStatusVoCollection();
		voColl.add(voStat);
		
		return voColl;
	}
	
	private boolean testDiscipline()
	{
		MemberOfStaffVo fullVo = null;
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();
		if (mos != null)
			fullVo = domain.getMemberOfStaff(mos);
		
		if (fullVo != null)
		{
			if (fullVo.getHcpIsNotNull())
			{
				if (fullVo.getHcp().getHcpTypeIsNotNull())
				{
					if (form.customControlAuthoring().getValue() != null 
						&& form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull() 
						&& form.customControlAuthoring().getValue().getAuthoringHcp().getHcpTypeIsNotNull())
					{
						if (form.customControlAuthoring().getValue().getAuthoringHcp().getHcpType().equals(fullVo.getHcp().getHcpType()))
							return true;
					}					
				}				
			}
		}
		return false;
	}
	
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
		showHideCustomComponent(form.customControlAuthoring(), Boolean.FALSE, false);

		form.richNotes().setEnabled(true);
		form.btnClose().setVisible(false);
		
		if (isDialog())
			form.getGlobalContext().Clinical.setReturnToFormMode(FormMode.EDIT);
		
		form.getGlobalContext().Core.setClinicalNotingMode(ClinicalNotingMode.UPDATE);
		if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull() &&
				validationIPMode(form.getGlobalContext().Clinical.getCurrentClinicalNote().getCurrentStatus()))
		{
			form.getGlobalContext().Core.setClinicalNotingMode(ClinicalNotingMode.VALIDATE);
		}
	}
	
	private boolean validationIPMode(ClinicalNoteStatusVo currentStatus) 
	{
		if (currentStatus != null
			&&	currentStatus.getStatusIsNotNull() 
			&& (currentStatus.getStatus().equals(ClinicalNotesStatus.PREVALIDATION))
			&& domain.getHcpLiteUser() != null 
			&& testDiscipline())
			return true;
		else
			return false;
	}
	
	private void newInstance() 
	{
		form.setMode(FormMode.EDIT);
		
		form.richNotes().setEnabled(true);
		form.customControlAuthoring().initializeComponent();

		form.customControlAuthoring().setEnabledAuthoringHCP(Boolean.FALSE);
		form.customControlAuthoring().setEnabledDateTime(Boolean.TRUE);

		AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo ();
		voAuthoringInformation.setAuthoringDateTime(new DateTime());
		if (domain.getHcpUser() != null)
		{
			HcpLiteVo authoringHcp = (HcpLiteVo) domain.getHcpLiteUser();
			if (authoringHcp != null)
				voAuthoringInformation.setAuthoringHcp(authoringHcp);
			form.customControlAuthoring().setValue(voAuthoringInformation);
			
			form.ccRecordingUser().setValue(authoringHcp.getMos());
		}
		else // No a HCP
		{
			if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContact().getSeenByIsNotNull())
				voAuthoringInformation.setAuthoringHcp(form.getGlobalContext().Core.getCurrentClinicalContact().getSeenBy());
			form.customControlAuthoring().setValue(voAuthoringInformation);
			
			if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContact().getSeenByIsNotNull())
				form.ccRecordingUser().setValue(form.getGlobalContext().Core.getCurrentClinicalContact().getSeenBy().getMos());
		}
		form.dtimRecordingDateTime().setValue(new DateTime());

		
		if (form.customControlAuthoring().getValue() != null 
			&& form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull() 
			&& form.customControlAuthoring().getValue().getAuthoringHcp().getHcpTypeIsNotNull())
			form.txtDiscipline().setValue(form.customControlAuthoring().getValue().getAuthoringHcp().getHcpType().getText());
		
		form.btnClose().setEnabled(false);
	}

	private void setCurrentClinicalNote()
	{
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			ClinicalContactShortVo currentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			ClinicalNotesVo clinicalNotesForContact = domain.getClinicalNotesForContact(currentClinicalContact);
			if (clinicalNotesForContact != null)
				form.getGlobalContext().Clinical.setCurrentClinicalNote(domain.getClinicalNote(clinicalNotesForContact));
			else
				form.getGlobalContext().Clinical.setCurrentClinicalNote(null);
		}
	}
	
	private void openNotingDetails() throws PresentationLogicException
	{
		clearDetails();
		form.setMode(FormMode.VIEW);
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()&& form.getGlobalContext().Clinical.getCurrentClinicalNote()==null)
			setCurrentClinicalNote();

		if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull())
			form.getGlobalContext().Clinical.setCurrentClinicalNote(domain.getClinicalNote(form.getGlobalContext().Clinical.getCurrentClinicalNote()));
		
		form.getLocalContext().setclinicalNotesVo(form.getGlobalContext().Clinical.getCurrentClinicalNote());
		if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull())
		{
			if (form.getGlobalContext().Clinical.getCurrentClinicalNote().getSourceOfNoteIsNotNull())
			{
				if (!form.getGlobalContext().Clinical.getCurrentClinicalNote().getSourceOfNote().equals(SourceOfNote.CLINICALCLINICALNOTE) )
					throw new FormOpenException("There is a clinical note of a different type already recorded on the system for this clincal contact");
			}
			
			populateScreenControls(form.getGlobalContext().Clinical.getCurrentClinicalNote());
		}	
	}

	private void enableOrDisableControls()
	{
		form.customControlAuthoring().setEnabledAuthoringHCP(Boolean.FALSE);
		form.customControlAuthoring().setEnabledDateTime(Boolean.TRUE);
			
		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.CORRECTION))
		{
			form.customControlAuthoring().setEnabledDateTime(Boolean.FALSE);

			form.setMode(FormMode.EDIT);

			form.cmbNoteType().setEnabled(false);
			form.richNotes().setEnabled(false);
			form.chkCharted().setVisible(false);

			form.lblCorrect().setVisible(true);
			form.txtCorrectionReason().setVisible(true);
			
			form.btnClose().setVisible(false);
		}
			
		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull() 
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.UPDATE))
		{
			form.setMode(FormMode.EDIT);

			form.chkCharted().setVisible(true);

			form.lblDiscipline().setVisible(false);
			form.cmbNoteType().setEnabled(true);
							
			form.richNotes().setEnabled(true);

			form.btnClose().setVisible(false);
		}
			
		if(form.getGlobalContext().Core.getClinicalNotingModeIsNotNull() 
			&& form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.NEW))
		{
			newInstance();
	
			form.chkCharted().setVisible(true);
			form.cmbNoteType().setEnabled(true);

			form.getGlobalContext().Clinical.setReturnToFormMode(null);
			form.getGlobalContext().Clinical.setCurrentClinicalNote(null);

			form.btnClose().setVisible(false);
		}
	}

	private void populateScreenControls(ClinicalNotesVo voNote) throws FormOpenException 
	{
		if (voNote.getIsDerivedNoteIsNotNull() 
			&& voNote.getIsDerivedNote().booleanValue())
			throw new FormOpenException("There is a clinical note of a different type already recorded on the system for this clincal contact");
		
		form.getLocalContext().setclinicalNotesVo(voNote);
		
		settingCustomAuthoring(voNote);

		form.cmbNoteType().setValue(voNote.getNoteClassification());
		form.richNotes().setValue(voNote.getClinicalNote());
		
		form.txtDiscipline().setValue(voNote.getDisciplineIsNotNull() ? voNote.getDiscipline().getText() : "");//wdev-8976

		if (voNote.getIsCorrectedIsNotNull()
			&& voNote.getIsCorrected())
		{
			form.lblCorrect().setVisible(true);
			form.txtCorrectionReason().setVisible(true);
			form.txtCorrectionReason().setEnabled(form.getMode().equals(FormMode.EDIT));
			
			form.txtCorrectionReason().setValue(voNote.getCurrentStatusIsNotNull() ? voNote.getCurrentStatus().getCorrectionReason() : "");
		}
	}

	private void settingCustomAuthoring(ClinicalNotesVo voNote)
	{
		AuthoringInformationVo voAuthor = new AuthoringInformationVo();
		voAuthor.setAuthoringDateTime(voNote.getAuthoringInfoIsNotNull() ? voNote.getAuthoringInfo().getAuthoringDateTime() : null);
		voAuthor.setAuthoringHcp(voNote.getAuthoringInfoIsNotNull() ? voNote.getAuthoringInfo().getAuthoringHcp() : null);
		form.customControlAuthoring().setValue(voAuthor);
		
		form.dtimRecordingDateTime().setValue(voNote.getRecordingDateTimeIsNotNull() ? voNote.getRecordingDateTime() : null);
		form.ccRecordingUser().setValue(voNote.getRecordingUserIsNotNull() ? voNote.getRecordingUser() : null);
	}

	private void clearDetails() 
	{
		form.customControlAuthoring().setValue(null);
		form.ccRecordingUser().setValue(null);
		form.dtimRecordingDateTime().setValue(null);

		form.txtDiscipline().setValue(null);
		form.richNotes().setValue(null);
	}
	
	protected void onBtnCloseClick() throws PresentationLogicException 
	{
		form.getGlobalContext().Core.setClinicalNotingMode(null);
		engine.close(DialogResult.OK);
	}

	protected void onCustomControlAuthoringValueChanged() throws PresentationLogicException
	{
		if(form.customControlAuthoring().getValue()!=null)
			form.txtDiscipline().setValue(form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull()
					&& form.customControlAuthoring().getValue().getAuthoringHcp().getHcpTypeIsNotNull() ? form.customControlAuthoring().getValue().getAuthoringHcp().getHcpType().getText() : "");
		else
			form.txtDiscipline().setValue("");
	}

	protected void onFormModeChanged()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.customControlAuthoring().setEnabledAuthoringHCP(false);
			form.customControlAuthoring().setEnabledDateTime(false);
		}
	}
	
	private void checkForDiscipline()
	{
		if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull())
		{	
			MemberOfStaffShortVo mos = null;
			if (getDisciplineForLoggedInUser(form.getGlobalContext().Clinical.getCurrentClinicalNote()) != null)
				mos = getDisciplineForLoggedInUser(form.getGlobalContext().Clinical.getCurrentClinicalNote());
			else
			{
				engine.showMessage("No Discipline is available. Please choose an authoring user.");
				return;
			}
					
		}
	}
	
	
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		//WDEV-2511 
		if (domain.getMosUser() == null)
			throw new FormOpenException("The User Account is not linked to a HCP or Member of Staff, this form will not be active. Please contact the System Administrator.");
		
		form.btnClose().setVisible(engine.isDialog());
		initialiseScreenControls();
		openNotingDetails();
		enableOrDisableControls();
		checkForDiscipline();
	}

	@Override
	protected void onChkChartedValueChanged() throws PresentationLogicException
	{
		if (form.chkCharted().getValue()
			&& form.getMode().equals(FormMode.EDIT))
		{
			AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo ();
			voAuthoringInformation.setAuthoringDateTime(new DateTime());

			form.customControlAuthoring().setValue(voAuthoringInformation);
			
			
			HcpLiteVo voHcp = domain.getHcpLiteVoFOrMosID(form.ccRecordingUser().getValue().getIMosHcpId());
					
					
			form.customControlAuthoring().setHcpType(voHcp != null ? voHcp.getHcpType() : null);
			form.customControlAuthoring().setEnabledAuthoringHCP(true);
			form.customControlAuthoring().setEnabledDateTime(true);
		}
		else
		{
			form.customControlAuthoring().setEnabledAuthoringHCP(false);
			form.customControlAuthoring().setEnabledDateTime(true);
			AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo ();
			voAuthoringInformation.setAuthoringDateTime(new DateTime());
			if (domain.getHcpUser() != null)
			{
				HcpLiteVo authoringHcp = (HcpLiteVo) domain.getHcpLiteUser();
				if (authoringHcp != null)
					voAuthoringInformation.setAuthoringHcp(authoringHcp);
				form.customControlAuthoring().setValue(voAuthoringInformation);
			}
		}
		
	}

	
}
