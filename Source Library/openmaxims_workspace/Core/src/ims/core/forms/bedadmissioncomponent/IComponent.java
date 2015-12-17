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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.bedadmissioncomponent;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public void initialise();

	/**
	* saveAdmission
	*/
	public Boolean saveAdmission();

	/**
	* getInWaitingIsVisible - used to change text on admit button on bedinfodialog
	*/
	public Boolean getInWaitingIsVisible();

	/**
	* allocateBed
	*/
	public Boolean allocateBed();

	/**
	* getIsRecordSelected
	*/
	public Boolean getIsRecordSelected();

	public Boolean checkForPatientAlreadyAdmited();

	/**
	* returnFromLeave
	*/
	public Boolean returnFromLeave();

	/**
	* getIsReturnFromLeaveVisible
	*/
	public Boolean getIsReturnFromLeaveVisible();

	public Boolean saveElectiveListAdmission(ims.core.vo.PatientCaseNoteTransferVoCollection collPatientCaseNoteTransfer);

	public Boolean hasPatientElectiveListToCancel();

	public Boolean isOnTCITab();

	public Boolean isOnEmergency();

	public Boolean saveElectiveListEmergencyAdmission();

	public ims.core.vo.lookups.Sex getSexForSelectedPatient();

	public Boolean hasPatientAppointmentsWithinNextMonth();

	public Boolean hasTCIForSameService();

	public Boolean isPrivateBedAdmission();

	public Boolean isOutsideOpeningHoursAdmission();

	public Boolean isBayGenderMismatch();

	public Boolean hasConflictWithTemporaryBayGender();

	public void setWardBayConfigRef(ims.core.admin.pas.vo.WardBayConfigRefVo wardBayConfigRef);

	public Boolean canCloseBedDialog();

	public Boolean canClearElectiveListContexts();

	public void clearElectiveListContexts();

	public Boolean isTCIRecordSelectedForView();

	public ims.core.vo.PatientShort getPatientForElectiveListEntry();

	public void clearSelectionAndInstanceControls();

	public Boolean isGenderAlreadyMixedForBay();

	/**
	* getSelectedPatient
	*/
	public ims.core.patient.vo.PatientRefVo getSelectedPatient();

	public void refreshHomeLeaves();

	public Boolean cancelHomeLeave();

	public Boolean hasTCIWithinNextMonth();

	public ims.core.vo.PatientShort getSelectedPatientReturnFromLeave();

	public String[] getErrors();

	/**
	* refreshSelectedPatient
	*/
	public Boolean refreshSelectedPatient();
}
