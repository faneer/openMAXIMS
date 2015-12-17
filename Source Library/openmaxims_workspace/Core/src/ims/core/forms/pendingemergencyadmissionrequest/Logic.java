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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.pendingemergencyadmissionrequest;

import ims.RefMan.vo.CatsReferralStatusVo;
import ims.RefMan.vo.CatsReferralStatusVoCollection;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.configuration.AppRight;
import ims.core.admin.vo.CareSpellRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.MedicRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextRepatriationVo;
import ims.core.vo.CareContextRepatriationVoCollection;
import ims.core.vo.CareContextStatusHistoryVo;
import ims.core.vo.CareContextStatusHistoryVoCollection;
import ims.core.vo.CareSpellRepatriationVo;
import ims.core.vo.CareSpellStatusHistoryVo;
import ims.core.vo.CareSpellStatusHistoryVoCollection;
import ims.core.vo.CatsReferralDetailsRepatriationRequestVo;
import ims.core.vo.CatsReferralRepatriationRequestVo;
import ims.core.vo.EpisodeOfCareRepatriationVo;
import ims.core.vo.EpisodeOfCareRepatriationVoCollection;
import ims.core.vo.EpisodeOfCareStatusHistoryVo;
import ims.core.vo.EpisodeOfCareStatusHistoryVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.PasEventRepatriationVo;
import ims.core.vo.PendingEmergencyAdmissionRepatriationVo;
import ims.core.vo.PendingEmergencyAdmissionStatusVo;
import ims.core.vo.PendingEmergencyAdmissionStatusVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.CareContextStatus;
import ims.core.vo.lookups.CareSpelltoEpisodeRelationship;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.EpisodeOfCareStatus;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PasEventType;
import ims.core.vo.lookups.PatientStatus;
import ims.core.vo.lookups.PendingAdmissionStatus;
import ims.core.vo.lookups.PendingEmergencyAdmissionType;
import ims.core.vo.lookups.ProblemGroupStatus;
import ims.core.vo.lookups.SourceOfEmergencyReferral;
import ims.core.vo.lookups.SourceOfReferral;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.Time;

import java.util.ArrayList;
import java.util.Random;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//----------------------------------------------------------------------------------------------------------------------------
	//	Event handlers
	//----------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	
	@Override
	protected void onLnkReturnWorklistClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Core.PendingEmergencyWorklist);
	}
	
	
	@Override
	protected void onCmbTypeValueChanged() throws PresentationLogicException
	{
		if (!PendingEmergencyAdmissionType.CLINICAL_NEED.equals(form.cmbType().getValue()) && !PendingEmergencyAdmissionType.REQUEST_FOR_REPATRIATION.equals(form.cmbType().getValue()))
		{
			form.cmbTransferReason().setValue(null);
			form.dteProposedTransfer().setValue(null);
		}
		if (!PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue()))
		{
			form.cmbSourceOfReferral().setValue(null);
		}
		
		updateControlsState();
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		form.qmbWard().clear();
		updateControlsState();
	}


	@Override
	protected void onQmbWardTextSubmited(String value) throws PresentationLogicException
	{
		LocationLiteVoCollection wards = domain.listWards(form.cmbHospital().getValue(), value);
		
		populateWards(wards);
	}


	@Override
	protected void onQmbServiceTextSubmited(String value) throws PresentationLogicException
	{
		ServiceLiteVoCollection services = domain.listServices(value);
		
		populateServices(services);		
	}


	@Override
	protected void onQmbRecordingUserTextSubmited(String value) throws PresentationLogicException
	{
		MemberOfStaffLiteVoCollection mosUsers = domain.listMosUsers(value);
		
		populateMosUsers(mosUsers);
	}


	@Override
	protected void onQmbAcceptingConsultantTextSubmited(String value) throws PresentationLogicException
	{
		HcpLiteVoCollection consultants = domain.listConsultants(form.qmbService().getValue(), value); //WDEV-21305
		
		populateConsultants(consultants);
	}


	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// New instance record
		newInstance();
	}
	
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Update selected instance record
		updateInstance();
	}


	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh screen
		open();
	}
	

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// If the save was successful refresh screen
		if (save())
			open();
	}
	
	
	
	//----------------------------------------------------------------------------------------------------------------------------
	//	Form presentation function
	//----------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		if (!engine.hasRight(AppRight.PENDING_EMERGENCY_CAN_RECORD_REQUEST_FOR_REPATRIATION))
			form.cmbType().removeRow(PendingEmergencyAdmissionType.REQUEST_FOR_REPATRIATION);
		
		if (!engine.hasRight(AppRight.PENDING_EMERGENCY_CAN_RECORD_CLINICAL_NEED))
			form.cmbType().removeRow(PendingEmergencyAdmissionType.CLINICAL_NEED);
		
		populateHospitals(domain.listHospitals());
		
		form.cmbSourceOfReferral().removeRow(SourceOfEmergencyReferral.GENERAL_PRACTITIONER);				
	}

	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		populateDataToScreen(form.getGlobalContext().Core.getSelectedPendingNonEDEmergencyAdmission());
		
		// Set form in View mode
		form.setMode(FormMode.VIEW);
	}
	
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clearInstanceControls();		
		// Clear local context
		form.getGlobalContext().Core.setSelectedPendingNonEDEmergencyAdmission(null);
		
		//Default hospital WDEV-22230
		ILocation currentLocation = engine.getCurrentLocation();
		setDefaultLocation(currentLocation);
		
		// Set Referral Date
		form.dteReferralDate().setValue(new Date());
				
		// Set Recording user
		MemberOfStaffLiteVo mosUser = (MemberOfStaffLiteVo) domain.getMosUser();
		if (mosUser != null)
		{
			form.qmbRecordingUser().newRow(mosUser, mosUser.getIMosName());
			form.qmbRecordingUser().setValue(mosUser);
		}
		
		// Set Recording date time
		form.dtimRecordingDateTime().setValue(new DateTime());
		
		//Set Patient Category WDEV-21221 //WDEV-22272
		form.cmbPatientCategory().setValue(form.getGlobalContext().Core.getPatientShort().getPatientCategory() != null ? form.getGlobalContext().Core.getPatientShort().getPatientCategory() : PatientStatus.NHS);
		// TODO: Set defaults
		
		
		// Set form in Edit mode
		form.setMode(FormMode.EDIT);
	}


	private void setDefaultLocation(ILocation currentLocation)
	{
		if (currentLocation == null)
			return;
		ArrayList listOfHospitals = form.cmbHospital().getValues();

		for (int i=0;i<listOfHospitals.size();i++)
		{
			LocationLiteVo hospital = (LocationLiteVo) listOfHospitals.get(i);
			if (hospital != null && hospital.getID_Location().equals(currentLocation.getID()))
			{	
				form.cmbHospital().setValue(hospital);
				break;
			}
		}
		if (form.cmbHospital().getValue() == null)
		{	
			//Try and load the parent logged in location 			
			LocationLiteVo currentHospital = domain.getHospitalForLocation(currentLocation); 
			form.cmbHospital().setValue(currentHospital);			
		}
	}

	public void updateInstance()
	{
		// Set form in Edit mode
		form.setMode(FormMode.EDIT);
	}

	
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// Step 1 - 
		String[] errors = validateUIRules();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		ServiceLiteVo service = form.qmbService().getValue();
		LocationRefVo location = form.cmbHospital().getValue();
		DateTime startDateTime = new DateTime(form.dteReferralDate().getValue(), new Time());
		SourceOfReferral sourceOfReferral = SourceOfReferral.ED;
		SourceOfEmergencyReferral sourceOfEmergencyReferral = form.cmbSourceOfReferral().getValue();
		HcpLiteVo hcp = form.qmbAcceptingConsultant().getValue();
		MedicRefVo consultant = hcp != null && HcpDisType.MEDICAL.equals(hcp.getHcpType()) ? new MedicRefVo(hcp.getID_Hcp(), hcp.getVersion_Hcp()) : null;
		
		try
		{
			// Populate data from screen
			CatsReferralRepatriationRequestVo pendingEmergencyAdmission = form.getGlobalContext().Core.getSelectedPendingNonEDEmergencyAdmission();
			CatsReferralRepatriationRequestVo repatriationReferral = null;
			
			if (pendingEmergencyAdmission == null)
			{
				PasEventRepatriationVo pasEvent = createPasEvent(form.getGlobalContext().Core.getPatientShort(), startDateTime, consultant, location, service, sourceOfReferral);

				// Create CareSpell, Episode of Care, Care Context
				CareSpellRepatriationVo careSpell = createCareSpell(form.getGlobalContext().Core.getPatientShort(), pasEvent, startDateTime, hcp, location, service, sourceOfReferral);
				EpisodeOfCareRepatriationVo episodeOfCare = careSpell.getEpisodes().get(0);
				CareContextRepatriationVo careContext = episodeOfCare.getCareContexts().get(0);
			
				repatriationReferral = populateDataFromScreen(null, careContext, episodeOfCare);
				
				errors = repatriationReferral.validate(pasEvent.validate(careSpell.validate(validateUIRules())));
				if (errors != null && errors.length > 0)
				{
					engine.showErrors(errors);
					return false;
				}
				
				form.getGlobalContext().Core.setSelectedPendingNonEDEmergencyAdmission(domain.save(pasEvent, careSpell, repatriationReferral));
				return true;
			}
			
			repatriationReferral = populateDataFromScreen(pendingEmergencyAdmission);

			// Validate data
			errors = repatriationReferral.validate(validateUIRules());

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Attempt to save data
			form.getGlobalContext().Core.setSelectedPendingNonEDEmergencyAdmission(domain.save(repatriationReferral));
			return true;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
	}


	public void updateControlsState()
	{
		boolean pendingEmergencyAdmissionNotSaved = form.getGlobalContext().Core.getSelectedPendingNonEDEmergencyAdmission() == null || form.getGlobalContext().Core.getSelectedPendingNonEDEmergencyAdmission().getID_CatsReferral() == null;

		form.lnkReturnWorklist().setEnabled(FormMode.VIEW.equals(form.getMode()));
		form.lnkReturnWorklist().setVisible(form.getForms().Core.PendingEmergencyWorklist.equals(engine.getPreviousNonDialogFormName()));
		
		boolean canBeTransfer = PendingEmergencyAdmissionType.CLINICAL_NEED.equals(form.cmbType().getValue()) || PendingEmergencyAdmissionType.REQUEST_FOR_REPATRIATION.equals(form.cmbType().getValue());
		boolean isOtherTypePendingEmergencyAdmission = PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue());
		
		form.lblTransferReason().setVisible(canBeTransfer);
		form.cmbTransferReason().setVisible(canBeTransfer);
		form.cmbTransferReason().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.lblProposedTransferDate().setVisible(canBeTransfer);
		form.dteProposedTransfer().setVisible(canBeTransfer);
		form.dteProposedTransfer().setEnabled(FormMode.EDIT.equals(form.getMode()));
		
		form.lblSourceofEmergencyRef().setVisible(isOtherTypePendingEmergencyAdmission);
		form.cmbSourceOfReferral().setVisible(isOtherTypePendingEmergencyAdmission);
		form.cmbSourceOfReferral().setEnabled(FormMode.EDIT.equals(form.getMode()) && isOtherTypePendingEmergencyAdmission);
		
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnEdit().setEnabled(true);
			form.btnEdit().setVisible(form.getGlobalContext().Core.getSelectedPendingNonEDEmergencyAdmission() != null);
		}

		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.dtimAcceptedDateTime().setEnabled(pendingEmergencyAdmissionNotSaved);
		}
		
		boolean isDialog = engine.isDialog(); //WDEV-22318
		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()) && !isDialog);
		form.btnClose().setVisible(FormMode.VIEW.equals(form.getMode()) && isDialog);
	}

	
	
	//----------------------------------------------------------------------------------------------------------------------------
	//	Data exchange functions
	//----------------------------------------------------------------------------------------------------------------------------

	public void clearInstanceControls()
	{
		form.dteReferralDate().setValue(null);
		form.cmbType().setValue(null);
		form.cmbSourceOfReferral().setValue(null);
		form.txtReferrerLocation().setValue(null);
		form.cmbTransferReason().setValue(null);
		form.dteProposedTransfer().setValue(null);
		form.txtReferrerContactDetails().setValue(null);
		
		form.cmbHospital().setValue(null);
		form.qmbWard().clear();
		form.qmbService().setValue(null);
		form.cmbPatientCategory().setValue(null);
		
		form.qmbAcceptingConsultant().setValue(null);
		form.dtimAcceptedDateTime().setValue(null);
		
		form.txtComments().setValue(null);
		
		form.qmbRecordingUser().setValue(null);
		form.dtimRecordingDateTime().setValue(null);
	}
	
	
	private void populateDataToScreen(CatsReferralRepatriationRequestVo pendingEmergencyAdmission)
	{
		clearInstanceControls();
		
		if (pendingEmergencyAdmission == null || pendingEmergencyAdmission.getRepatriationRequest() == null)
			return;
		
		form.dteReferralDate().setValue(pendingEmergencyAdmission.getReferralDetails().getDateOfReferral());
		
		form.cmbType().newRow(pendingEmergencyAdmission.getRepatriationRequest().getType(), pendingEmergencyAdmission.getRepatriationRequest().getType().getText());		// This line will not add a new row if the value already exists in the collection
		form.cmbType().setValue(pendingEmergencyAdmission.getRepatriationRequest().getType());
		
		form.cmbSourceOfReferral().setValue(pendingEmergencyAdmission.getRepatriationRequest().getSourceOfEmergencyReferral());

		form.txtReferrerLocation().setValue(pendingEmergencyAdmission.getRepatriationRequest().getReferredLocation());
		
		form.cmbTransferReason().setValue(pendingEmergencyAdmission.getRepatriationRequest().getTransferReason());
		form.dteProposedTransfer().setValue(pendingEmergencyAdmission.getRepatriationRequest().getProposedTransferDate());

		form.txtReferrerContactDetails().setValue(pendingEmergencyAdmission.getRepatriationRequest().getContactDetails());
		
		form.txtComments().setValue(pendingEmergencyAdmission.getRepatriationRequest().getComments());

		
		form.qmbRecordingUser().newRow(pendingEmergencyAdmission.getRepatriationRequest().getRecordedBy(), pendingEmergencyAdmission.getRepatriationRequest().getRecordedBy().getIMosName());
		form.qmbRecordingUser().setValue(pendingEmergencyAdmission.getRepatriationRequest().getRecordedBy());
		form.dtimRecordingDateTime().setValue(pendingEmergencyAdmission.getRepatriationRequest().getRecordedDateTime());
		
		
		form.cmbHospital().setValue(pendingEmergencyAdmission.getRepatriationRequest().getHospital());
		if (pendingEmergencyAdmission.getRepatriationRequest().getWard() != null)
		{
			form.qmbWard().newRow(pendingEmergencyAdmission.getRepatriationRequest().getWard(), pendingEmergencyAdmission.getRepatriationRequest().getWard().getName());
			form.qmbWard().setValue(pendingEmergencyAdmission.getRepatriationRequest().getWard());
		}

		if (pendingEmergencyAdmission.getRepatriationRequest().getService() != null)
		{
			form.qmbService().newRow(pendingEmergencyAdmission.getRepatriationRequest().getService(), pendingEmergencyAdmission.getRepatriationRequest().getService().getServiceName());
			form.qmbService().setValue(pendingEmergencyAdmission.getRepatriationRequest().getService());
		}
		
		form.cmbPatientCategory().setValue(pendingEmergencyAdmission.getRepatriationRequest().getCategory());
		
		CatsReferralStatusVoCollection statuses = pendingEmergencyAdmission.getStatusHistory();
		if (statuses != null)
		{
			statuses.sort(SortOrder.ASCENDING);
			
			for (CatsReferralStatusVo status : statuses)
			{
				// Accepting Consultant and Accepting Date Time
				if (ReferralApptStatus.REFERRAL_ACCEPTED.equals(status.getReferralStatus()))
				{
					HcpLiteVo acceptingConsultant = domain.getHcpForMos(status.getAuthoringUser());
					if (acceptingConsultant != null)
					{
    					form.qmbAcceptingConsultant().newRow(acceptingConsultant, acceptingConsultant.getIMosName());
    					form.qmbAcceptingConsultant().setValue(acceptingConsultant);
					}
					form.dtimAcceptedDateTime().setValue(status.getStatusDateTime());
					break;
				}
			}
		}
	}
	
	


	private String[] validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();
	
		
		if (form.cmbType().getValue() == null)
			listOfErrors.add("Type is mandatory.");
		
		if (PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue()) && form.cmbSourceOfReferral().getValue() == null)
			listOfErrors.add("Source of Emergency Referral is mandatory.");
		
		if (form.dteProposedTransfer().getValue() != null && form.cmbTransferReason().getValue() == null)
			listOfErrors.add("Transfer Reason is mandatory if Proposed Transfer Date is completed.");
		
		if (form.cmbTransferReason().getValue() != null && form.dteProposedTransfer().getValue() == null)
			listOfErrors.add("Proposed Transfer Date is mandatory if Transfer Reason is completed.");
		
		if (form.qmbRecordingUser().getValue() == null)
			listOfErrors.add("Recording User is mandatory.");
		
		if (form.dtimRecordingDateTime().getValue() == null)
			listOfErrors.add("Recording Date Time is mandatory.");
		
		if (form.cmbHospital().getValue() == null)
			listOfErrors.add("Hospital is mandatory.");

		if (form.qmbService().getValue() == null)
			listOfErrors.add("Service is mandatory.");

		if (form.cmbPatientCategory().getValue() == null)
			listOfErrors.add("Patient Category is mandatory.");
		
		if (form.qmbAcceptingConsultant().getValue() == null)
			listOfErrors.add("Accepting Consultant is mandatory.");
		
		if (form.dtimAcceptedDateTime().getValue() == null)
			listOfErrors.add("Accepting Date/Time is mandatory.");
		
		//WDEV-21408
		if(form.dteReferralDate().getValue() != null)
			if(form.dteReferralDate().getValue().isGreaterThan(new Date()))
				listOfErrors.add("Referral Date cannot be in the future.");	
		
		if(form.dtimAcceptedDateTime().getValue() != null)
			if(form.dtimAcceptedDateTime().getValue().isGreaterThan(new DateTime()))
				listOfErrors.add(" Accepting Date/Time cannot be in the future."); 
		
		if(form.dtimRecordingDateTime().getValue() != null)
			if(form.dtimRecordingDateTime().getValue().isGreaterThan(new DateTime()))
				listOfErrors.add("Recording Date/Time cannot be in the future.");	

		// end WDEV-21408
		
		return listOfErrors.toArray(new String[listOfErrors.size()]);
	}



	private CatsReferralRepatriationRequestVo populateDataFromScreen(CatsReferralRepatriationRequestVo pendingEmergencyAdmission)
	{
		return populateDataFromScreen(pendingEmergencyAdmission, null, null);
	}


	private CatsReferralRepatriationRequestVo populateDataFromScreen(CatsReferralRepatriationRequestVo referral, CareContextRepatriationVo careContext, EpisodeOfCareRepatriationVo episodeOfCare)
	{
		Date referralDate = form.dteReferralDate().getValue();
		SourceOfReferral sourceOfReferral = SourceOfReferral.ED;
		SourceOfEmergencyReferral sourceOfEmergencyReferral = form.cmbSourceOfReferral().getValue();
		MemberOfStaffLiteVo recordingUser = form.qmbRecordingUser().getValue();
		DateTime recordingDateTime = form.dtimRecordingDateTime().getValue();
		ServiceLiteVo service = form.qmbService().getValue();
		DateTime referralAcceptedDateTime = form.dtimAcceptedDateTime().getValue();
		HcpLiteVo acceptingConsultant = form.qmbAcceptingConsultant().getValue();


		if (referral == null)
		{
			referral = new CatsReferralRepatriationRequestVo();
			
			// Set Referral
			referral.setPatient(form.getGlobalContext().Core.getPatientShort());
			referral.setEpisodeOfCare(episodeOfCare);
			referral.setCareContext(careContext);
			
			// Create Referral Details
			CatsReferralDetailsRepatriationRequestVo referralDetails = new CatsReferralDetailsRepatriationRequestVo();
			
			referral.setReferralDetails(referralDetails);
			
			// Set the first status of the referral
			referral.setStatusHistory(new CatsReferralStatusVoCollection());
			
			// See if the referral needs to be accepted
			if (form.qmbAcceptingConsultant().getValue() != null || form.dtimAcceptedDateTime().getValue() != null)
			{
				// Create the Accepted referral status
				CatsReferralStatusVo referralAcceptedStatus = new CatsReferralStatusVo();

				referralAcceptedStatus.setReferralStatus(ReferralApptStatus.REFERRAL_ACCEPTED);
				if (acceptingConsultant != null)
					referralAcceptedStatus.setAuthoringUser(acceptingConsultant.getMos());
				referralAcceptedStatus.setStatusDateTime(referralAcceptedDateTime);
				
				referral.setCurrentStatus(referralAcceptedStatus);
				referral.getStatusHistory().add(referralAcceptedStatus);
			}
			
			referral.setUrgency(ReferralUrgency.EMERGENCY);
			
			// Create Pending Emergency
			PendingEmergencyAdmissionRepatriationVo repatriationRequest = new PendingEmergencyAdmissionRepatriationVo();
			referral.setRepatriationRequest(repatriationRequest);
			referral.setIsEmergencyReferral(Boolean.TRUE);
			referral.setRTTClockImpact(Boolean.FALSE); //WDEV-20944	
		}
		else if (referral.getID_CatsReferralIsNotNull()) //WDEV-21305
		{
			CatsReferralStatusVoCollection statuses = referral.getStatusHistory();
			if (statuses != null)
			{
				statuses.sort(SortOrder.ASCENDING);
				
				for (CatsReferralStatusVo status : statuses)
				{
					// Accepting Consultant and Accepting Date Time
					if (ReferralApptStatus.REFERRAL_ACCEPTED.equals(status.getReferralStatus()))
					{
						if (acceptingConsultant != null)
						{	
							status.setAuthoringUser(acceptingConsultant.getMos());
						}	
						status.setStatusDateTime(referralAcceptedDateTime);						
						break;
					}
				}
			}
		}
		
		referral.setPatientCategory(form.cmbPatientCategory().getValue());
		
		CatsReferralDetailsRepatriationRequestVo referralDetails = referral.getReferralDetails();
		referralDetails.setService(service);
		referralDetails.setConsultant(acceptingConsultant);
		referralDetails.setReferrerType(sourceOfReferral);
		referralDetails.setAuthoringUser(recordingUser);
		referralDetails.setAuthoringDateTime(recordingDateTime);
		referralDetails.setDateOfReferral(referralDate);
		//referralDetails.setDateReferralReceived(referralDate);WDEV-22688
		
		PendingEmergencyAdmissionRepatriationVo repatriationRequest = referral.getRepatriationRequest();
		
		// This lines of code shouldn't be necessary
		if (repatriationRequest == null)
		{	repatriationRequest = new PendingEmergencyAdmissionRepatriationVo();	}
		
		repatriationRequest.setType(form.cmbType().getValue());
		repatriationRequest.setCategory(form.cmbPatientCategory().getValue());
		repatriationRequest.setSourceOfReferral(sourceOfReferral);
		repatriationRequest.setSourceOfEmergencyReferral(sourceOfEmergencyReferral);
		repatriationRequest.setProposedTransferDate(form.dteProposedTransfer().getValue());
		repatriationRequest.setTransferReason(form.cmbTransferReason().getValue());
		repatriationRequest.setService(form.qmbService().getValue());
		repatriationRequest.setHospital(form.cmbHospital().getValue());
		repatriationRequest.setWard(form.qmbWard().getValue());
		repatriationRequest.setReferredLocation(form.txtReferrerLocation().getValue());
		repatriationRequest.setContactDetails(form.txtReferrerContactDetails().getValue());
		repatriationRequest.setComments(form.txtComments().getValue());
		
		if (repatriationRequest != null && repatriationRequest.getID_PendingNoEDEmergencyAdmit() == null)
		{
			PendingEmergencyAdmissionStatusVo startStatus = new PendingEmergencyAdmissionStatusVo();
			startStatus.setStatus(PendingAdmissionStatus.CREATED);

    		// Create Pending Emergency Admission status
    		repatriationRequest.setCurrentStatus(startStatus);
    		repatriationRequest.setStatusHistory(new PendingEmergencyAdmissionStatusVoCollection());
    		repatriationRequest.getStatusHistory().add(startStatus);
		}
		
		repatriationRequest.setRecordedBy(recordingUser);
		repatriationRequest.setRecordedDateTime(recordingDateTime);

		return referral;
	}


	private CareSpellRepatriationVo createCareSpell(PatientRefVo patient, PasEventRepatriationVo pasEvent, DateTime startDateTime, HcpLiteVo hcp, LocationRefVo location, ServiceLiteVo service, SourceOfReferral sourceOfReferral)
	{
		CareSpellRepatriationVo careSpell = new CareSpellRepatriationVo();

		careSpell.setPatient(patient);
		careSpell.setStartDate(startDateTime.getDate());
		careSpell.setEndDate(null);

		CareSpellStatusHistoryVo firstStatus = new CareSpellStatusHistoryVo();
		firstStatus.setStatus(ProblemGroupStatus.OPEN);
		firstStatus.setStatusDateTime(startDateTime);
		
		careSpell.setCurrentStatus(firstStatus);
		careSpell.setStatusHistory(new CareSpellStatusHistoryVoCollection());
		careSpell.getStatusHistory().add(firstStatus);
		
		careSpell.setEpisodes(new EpisodeOfCareRepatriationVoCollection());
		careSpell.getEpisodes().add(createEpisodeOfCare(patient, careSpell, pasEvent, startDateTime, hcp, location, service, sourceOfReferral));

		return careSpell;
	}


	private EpisodeOfCareRepatriationVo createEpisodeOfCare(PatientRefVo patient, CareSpellRefVo careSpell, PasEventRepatriationVo pasEvent, DateTime startDateTime, HcpLiteVo hcp, LocationRefVo location, ServiceLiteVo service, SourceOfReferral sourceOfReferral)
	{
		EpisodeOfCareRepatriationVo episodeOfCare = new EpisodeOfCareRepatriationVo();
		
		episodeOfCare.setCareSpell(careSpell);
		episodeOfCare.setResponsibleHCP(hcp);		
		episodeOfCare.setSpecialty(service != null ? service.getSpecialty() : null);
		episodeOfCare.setRelationship(CareSpelltoEpisodeRelationship.PRIMARY);
		episodeOfCare.setStartDate(startDateTime.getDate());
		episodeOfCare.setEndDate(null);
		
		EpisodeOfCareStatusHistoryVo firstStatus = new EpisodeOfCareStatusHistoryVo();
		firstStatus.setStatus(EpisodeOfCareStatus.OPEN);
		firstStatus.setStatusDateTime(startDateTime);
		
		episodeOfCare.setCurrentStatus(firstStatus);
		episodeOfCare.setStatusHistory(new EpisodeOfCareStatusHistoryVoCollection());
		episodeOfCare.getStatusHistory().add(firstStatus);
		
		episodeOfCare.setCareContexts(new CareContextRepatriationVoCollection());
		episodeOfCare.getCareContexts().add(createCareContext(patient, episodeOfCare, pasEvent, startDateTime, hcp, location, service, sourceOfReferral));
		
		return episodeOfCare;
	}


	private CareContextRepatriationVo createCareContext(PatientRefVo patient, EpisodeOfCareRefVo episodeOfCare, PasEventRepatriationVo pasEvent, DateTime startDateTime, HcpLiteVo hcp, LocationRefVo location, ServiceLiteVo service, SourceOfReferral sourceOfReferral)
	{
		CareContextRepatriationVo careContext = new CareContextRepatriationVo();
		
		careContext.setPasEvent(pasEvent);
		careContext.setContext(ContextType.REFERRAL);
		careContext.setEpisodeOfCare(episodeOfCare);
		careContext.setStartDateTime(startDateTime);
		careContext.setEndDateTime(null);
		careContext.setResponsibleHCP(hcp);
		
		CareContextStatusHistoryVo firstStatus = new CareContextStatusHistoryVo();
		firstStatus.setStatus(CareContextStatus.OPEN);
		firstStatus.setStatusDateTime(startDateTime);
		
		careContext.setCurrentStatus(firstStatus);
		careContext.setStatusHistory(new CareContextStatusHistoryVoCollection());
		careContext.getStatusHistory().add(firstStatus);
		
		return careContext;
	}


	private PasEventRepatriationVo createPasEvent(PatientRefVo patient, DateTime eventDateTime, MedicRefVo consultant, LocationRefVo location, ServiceLiteVo service, SourceOfReferral sourceOfReferral)
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new IllegalArgumentException("'patient' - argument cannot be null or not saved into database.");
		
		if (eventDateTime == null)
			throw new IllegalArgumentException("'eventDateTime' - cannot be null or not saved into database.");
		
		PasEventRepatriationVo pasEvent = new PasEventRepatriationVo();
		
		// Prepare random seed
		Random rand = new Random(System.currentTimeMillis());
		
		pasEvent.setEventDateTime(eventDateTime);
		pasEvent.setPatient(patient);
		pasEvent.setPasEventId(patient.getID_Patient().toString() + eventDateTime.toString(DateTimeFormat.ISO) + "_" + (new DateTime()).toString(DateTimeFormat.ISO) + "_" + rand.nextInt(1000000000));
		pasEvent.setConsultant(consultant);
		pasEvent.setLocation(location);
		pasEvent.setSpecialty(service != null ? service.getSpecialty() : null);
		pasEvent.setSourceOfReferral(sourceOfReferral);
		pasEvent.setEventType(PasEventType.EMERGENCY);
		pasEvent.setService(service); //WDEV-20900

		return pasEvent;
	}

	
	private void populateHospitals(LocationLiteVoCollection hospitals)
	{
		form.cmbHospital().clear();
		
		if (hospitals == null)
			return;
		
		for (LocationLiteVo hospital : hospitals)
		{
			form.cmbHospital().newRow(hospital, hospital.getName());
		}
	}

	
	private void populateWards(LocationLiteVoCollection wards)
	{
		form.qmbWard().clear();
		
		if (wards == null)
			return;
		
		for (LocationLiteVo ward : wards)
		{
			form.qmbWard().newRow(ward, ward.getName());
		}
		
		if (wards.size() == 1)
			form.qmbWard().setValue(wards.get(0));
		else
			form.qmbWard().showOpened();
	}


	private void populateServices(ServiceLiteVoCollection services)
	{
		form.qmbService().clear();
		
		if (services == null)
			return;
		
		for (ServiceLiteVo service : services)
		{
			form.qmbService().newRow(service, service.getServiceName());
		}
		
		if (services.size() == 1)
			form.qmbService().setValue(services.get(0));
		else
			form.qmbService().showOpened();
	}



	private void populateMosUsers(MemberOfStaffLiteVoCollection mosUsers)
	{
		form.qmbRecordingUser().clear();
		
		if (mosUsers == null)
			return;
		
		for (MemberOfStaffLiteVo mos : mosUsers)
		{
			form.qmbRecordingUser().newRow(mos, mos.getIMosName());
		}
		
		if (mosUsers.size() == 1)
			form.qmbRecordingUser().setValue(mosUsers.get(0));
		else
			form.qmbRecordingUser().showOpened();
	}


	private void populateConsultants(HcpLiteVoCollection consultants)
	{
		form.qmbAcceptingConsultant().clear();
		
		if (consultants == null)
			return;
		
		for (HcpLiteVo hcp : consultants)
		{
			form.qmbAcceptingConsultant().newRow(hcp, hcp.getIMosName());
		}
		
		if (consultants.size() == 1)
			form.qmbAcceptingConsultant().setValue(consultants.get(0));
		else
			form.qmbAcceptingConsultant().showOpened();
	}


	@Override
	protected void onQmbServiceValueChanged() throws PresentationLogicException
	{
		ServiceLiteVo value = form.qmbService().getValue();
		if (value != null)
		{
			form.qmbAcceptingConsultant().clear();
		}		
	}

	//WDEV-22318
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);		
	}

}
