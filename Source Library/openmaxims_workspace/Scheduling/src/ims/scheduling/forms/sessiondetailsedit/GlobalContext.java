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

package ims.scheduling.forms.sessiondetailsedit;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Scheduling = new SchedulingContext(context);
		RefMan = new RefManContext(context);
		Admin = new AdminContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDirectoryofServicesCollectionIsNotNull()
		{
			return !cx_SchedulingDirectoryofServicesCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.DirectoryOfServiceVoCollection getDirectoryofServicesCollection()
		{
			return (ims.scheduling.vo.DirectoryOfServiceVoCollection)cx_SchedulingDirectoryofServicesCollection.getValue(context);
		}
		public void setDirectoryofServicesCollection(ims.scheduling.vo.DirectoryOfServiceVoCollection value)
		{
			cx_SchedulingDirectoryofServicesCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingDirectoryofServicesCollection = new ims.framework.ContextVariable("Scheduling.DirectoryofServicesCollection", "_cv_Scheduling.DirectoryofServicesCollection");
		public boolean getBookTheatreSlotDialogDataIsNotNull()
		{
			return !cx_SchedulingBookTheatreSlotDialogData.getValueIsNull(context);
		}
		public ims.scheduling.vo.BookTheatreSlotDialogVo getBookTheatreSlotDialogData()
		{
			return (ims.scheduling.vo.BookTheatreSlotDialogVo)cx_SchedulingBookTheatreSlotDialogData.getValue(context);
		}
		public void setBookTheatreSlotDialogData(ims.scheduling.vo.BookTheatreSlotDialogVo value)
		{
			cx_SchedulingBookTheatreSlotDialogData.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookTheatreSlotDialogData = new ims.framework.ContextVariable("Scheduling.BookTheatreSlotDialogData", "_cv_Scheduling.BookTheatreSlotDialogData");
		public boolean getSessionParentChildSlotIsNotNull()
		{
			return !cx_SchedulingSessionParentChildSlot.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionParentChildSlotVo getSessionParentChildSlot()
		{
			return (ims.scheduling.vo.SessionParentChildSlotVo)cx_SchedulingSessionParentChildSlot.getValue(context);
		}
		public void setSessionParentChildSlot(ims.scheduling.vo.SessionParentChildSlotVo value)
		{
			cx_SchedulingSessionParentChildSlot.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSessionParentChildSlot = new ims.framework.ContextVariable("Scheduling.SessionParentChildSlot", "_cv_Scheduling.SessionParentChildSlot");
		public boolean getFlexibleSessionSlotsIsNotNull()
		{
			return !cx_SchedulingFlexibleSessionSlots.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionParentChildSlotVoCollection getFlexibleSessionSlots()
		{
			return (ims.scheduling.vo.SessionParentChildSlotVoCollection)cx_SchedulingFlexibleSessionSlots.getValue(context);
		}
		public void setFlexibleSessionSlots(ims.scheduling.vo.SessionParentChildSlotVoCollection value)
		{
			cx_SchedulingFlexibleSessionSlots.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingFlexibleSessionSlots = new ims.framework.ContextVariable("Scheduling.FlexibleSessionSlots", "_cv_Scheduling.FlexibleSessionSlots");
		public boolean getSelectedSessionListOwnersIsNotNull()
		{
			return !cx_SchedulingSelectedSessionListOwners.getValueIsNull(context);
		}
		public ims.scheduling.vo.Session_ListOwnerVoCollection getSelectedSessionListOwners()
		{
			return (ims.scheduling.vo.Session_ListOwnerVoCollection)cx_SchedulingSelectedSessionListOwners.getValue(context);
		}
		public void setSelectedSessionListOwners(ims.scheduling.vo.Session_ListOwnerVoCollection value)
		{
			cx_SchedulingSelectedSessionListOwners.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSelectedSessionListOwners = new ims.framework.ContextVariable("Scheduling.SelectedSessionListOwners", "_cv_Scheduling.SelectedSessionListOwners");
		public boolean getSessionSlotsIsNotNull()
		{
			return !cx_SchedulingSessionSlots.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionSlotVoCollection getSessionSlots()
		{
			return (ims.scheduling.vo.SessionSlotVoCollection)cx_SchedulingSessionSlots.getValue(context);
		}
		public void setSessionSlots(ims.scheduling.vo.SessionSlotVoCollection value)
		{
			cx_SchedulingSessionSlots.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSessionSlots = new ims.framework.ContextVariable("Scheduling.SessionSlots", "_cv_Scheduling.SessionSlots");
		public boolean getCancelBlockReasonForSessionManagementIsNotNull()
		{
			return !cx_SchedulingCancelBlockReasonForSessionManagement.getValueIsNull(context);
		}
		public ims.scheduling.vo.CancelBlockReasonForSessionManagementVo getCancelBlockReasonForSessionManagement()
		{
			return (ims.scheduling.vo.CancelBlockReasonForSessionManagementVo)cx_SchedulingCancelBlockReasonForSessionManagement.getValue(context);
		}
		public void setCancelBlockReasonForSessionManagement(ims.scheduling.vo.CancelBlockReasonForSessionManagementVo value)
		{
			cx_SchedulingCancelBlockReasonForSessionManagement.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingCancelBlockReasonForSessionManagement = new ims.framework.ContextVariable("Scheduling.CancelBlockReasonForSessionManagement", "_cv_Scheduling.CancelBlockReasonForSessionManagement");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_RefManReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_RefManReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_RefManReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralContractTypeForPatient = new ims.framework.ContextVariable("RefMan.ReferralContractTypeForPatient", "_cvp_RefMan.ReferralContractTypeForPatient");

		private ims.framework.Context context;
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getProfileLocationIsNotNull()
		{
			return !cx_AdminProfileLocation.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getProfileLocation()
		{
			return (ims.core.vo.LocShortVo)cx_AdminProfileLocation.getValue(context);
		}
		public void setProfileLocation(ims.core.vo.LocShortVo value)
		{
			cx_AdminProfileLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminProfileLocation = new ims.framework.ContextVariable("Admin.ProfileLocation", "_cv_Admin.ProfileLocation");
		public boolean getProfileCaseNoteFoldersLocationIsNotNull()
		{
			return !cx_AdminProfileCaseNoteFoldersLocation.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getProfileCaseNoteFoldersLocation()
		{
			return (ims.core.vo.LocShortVo)cx_AdminProfileCaseNoteFoldersLocation.getValue(context);
		}
		public void setProfileCaseNoteFoldersLocation(ims.core.vo.LocShortVo value)
		{
			cx_AdminProfileCaseNoteFoldersLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminProfileCaseNoteFoldersLocation = new ims.framework.ContextVariable("Admin.ProfileCaseNoteFoldersLocation", "_cv_Admin.ProfileCaseNoteFoldersLocation");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedProceduresIsNotNull()
		{
			return !cx_ClinicalSelectedProcedures.getValueIsNull(context);
		}
		public ims.core.vo.ProcedureLiteVoCollection getSelectedProcedures()
		{
			return (ims.core.vo.ProcedureLiteVoCollection)cx_ClinicalSelectedProcedures.getValue(context);
		}
		public void setSelectedProcedures(ims.core.vo.ProcedureLiteVoCollection value)
		{
			cx_ClinicalSelectedProcedures.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedProcedures = new ims.framework.ContextVariable("Clinical.SelectedProcedures", "_cv_Clinical.SelectedProcedures");

		private ims.framework.Context context;
	}

	public SchedulingContext Scheduling;
	public RefManContext RefMan;
	public AdminContext Admin;
	public ClinicalContext Clinical;
}
