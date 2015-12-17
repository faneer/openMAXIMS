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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.bedinfodialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		RefMan = new RefManContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBedInfoActionIsNotNull()
		{
			return !cx_CoreBedInfoAction.getValueIsNull(context);
		}
		public ims.core.vo.enums.BedInfoAction getBedInfoAction()
		{
			return (ims.core.vo.enums.BedInfoAction)cx_CoreBedInfoAction.getValue(context);
		}
		public void setBedInfoAction(ims.core.vo.enums.BedInfoAction value)
		{
			cx_CoreBedInfoAction.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreBedInfoAction = new ims.framework.ContextVariable("Core.BedInfoAction", "_cv_Core.BedInfoAction");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getItemsIsNotNull()
		{
			return !cx_CoreItems.getValueIsNull(context);
		}
		public ims.admin.vo.SelectItemVoCollection getItems()
		{
			return (ims.admin.vo.SelectItemVoCollection)cx_CoreItems.getValue(context);
		}
		public void setItems(ims.admin.vo.SelectItemVoCollection value)
		{
			cx_CoreItems.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreItems = new ims.framework.ContextVariable("Core.Items", "_cv_Core.Items");
		public boolean getADTWardIsNotNull()
		{
			return !cx_CoreADTWard.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getADTWard()
		{
			return (ims.core.vo.LocationLiteVo)cx_CoreADTWard.getValue(context);
		}
		public void setADTWard(ims.core.vo.LocationLiteVo value)
		{
			cx_CoreADTWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTWard = new ims.framework.ContextVariable("Core.ADTWard", "_cv_Core.ADTWard");
		public boolean getHasWaitingAreaIsNotNull()
		{
			return !cx_CoreHasWaitingArea.getValueIsNull(context);
		}
		public Boolean getHasWaitingArea()
		{
			return (Boolean)cx_CoreHasWaitingArea.getValue(context);
		}
		public void setHasWaitingArea(Boolean value)
		{
			cx_CoreHasWaitingArea.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHasWaitingArea = new ims.framework.ContextVariable("Core.HasWaitingArea", "_cv_Core.HasWaitingArea");
		public boolean getSelectedWaitingAreaPatientIsNotNull()
		{
			return !cx_CoreSelectedWaitingAreaPatient.getValueIsNull(context);
		}
		public ims.core.vo.InpatientEpisodeLiteVo getSelectedWaitingAreaPatient()
		{
			return (ims.core.vo.InpatientEpisodeLiteVo)cx_CoreSelectedWaitingAreaPatient.getValue(context);
		}
		public void setSelectedWaitingAreaPatient(ims.core.vo.InpatientEpisodeLiteVo value)
		{
			cx_CoreSelectedWaitingAreaPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedWaitingAreaPatient = new ims.framework.ContextVariable("Core.SelectedWaitingAreaPatient", "_cv_Core.SelectedWaitingAreaPatient");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCreateVTERiskAssessmentOnDischargeIsNotNull()
		{
			return !cx_CoreCreateVTERiskAssessmentOnDischarge.getValueIsNull(context);
		}
		public Boolean getCreateVTERiskAssessmentOnDischarge()
		{
			return (Boolean)cx_CoreCreateVTERiskAssessmentOnDischarge.getValue(context);
		}
		public void setCreateVTERiskAssessmentOnDischarge(Boolean value)
		{
			cx_CoreCreateVTERiskAssessmentOnDischarge.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCreateVTERiskAssessmentOnDischarge = new ims.framework.ContextVariable("Core.CreateVTERiskAssessmentOnDischarge", "_cv_Core.CreateVTERiskAssessmentOnDischarge");
		public boolean getInpatientEpisodeForVTERiskAssessmentWorklistVoIsNotNull()
		{
			return !cx_CoreInpatientEpisodeForVTERiskAssessmentWorklistVo.getValueIsNull(context);
		}
		public ims.vo.interfaces.IVTERiskAssessment getInpatientEpisodeForVTERiskAssessmentWorklistVo()
		{
			return (ims.vo.interfaces.IVTERiskAssessment)cx_CoreInpatientEpisodeForVTERiskAssessmentWorklistVo.getValue(context);
		}
		public void setInpatientEpisodeForVTERiskAssessmentWorklistVo(ims.vo.interfaces.IVTERiskAssessment value)
		{
			cx_CoreInpatientEpisodeForVTERiskAssessmentWorklistVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreInpatientEpisodeForVTERiskAssessmentWorklistVo = new ims.framework.ContextVariable("Core.InpatientEpisodeForVTERiskAssessmentWorklistVo", "_cv_Core.InpatientEpisodeForVTERiskAssessmentWorklistVo");
		public boolean getVTERiskAssessmentShortVoIsNotNull()
		{
			return !cx_CoreVTERiskAssessmentShortVo.getValueIsNull(context);
		}
		public ims.clinical.vo.VTERiskAssessmentShortVo getVTERiskAssessmentShortVo()
		{
			return (ims.clinical.vo.VTERiskAssessmentShortVo)cx_CoreVTERiskAssessmentShortVo.getValue(context);
		}
		public void setVTERiskAssessmentShortVo(ims.clinical.vo.VTERiskAssessmentShortVo value)
		{
			cx_CoreVTERiskAssessmentShortVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVTERiskAssessmentShortVo = new ims.framework.ContextVariable("Core.VTERiskAssessmentShortVo", "_cv_Core.VTERiskAssessmentShortVo");
		public boolean getDischargeEpisodeBedInfoIsNotNull()
		{
			return !cx_CoreDischargeEpisodeBedInfo.getValueIsNull(context);
		}
		public ims.core.vo.DischargedEpisodeADTVo getDischargeEpisodeBedInfo()
		{
			return (ims.core.vo.DischargedEpisodeADTVo)cx_CoreDischargeEpisodeBedInfo.getValue(context);
		}
		public void setDischargeEpisodeBedInfo(ims.core.vo.DischargedEpisodeADTVo value)
		{
			cx_CoreDischargeEpisodeBedInfo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreDischargeEpisodeBedInfo = new ims.framework.ContextVariable("Core.DischargeEpisodeBedInfo", "_cv_Core.DischargeEpisodeBedInfo");
		public boolean getSelectedBedSpaceStateIsNotNull()
		{
			return !cx_CoreSelectedBedSpaceState.getValueIsNull(context);
		}
		public ims.core.vo.BedSpaceStateLiteVo getSelectedBedSpaceState()
		{
			return (ims.core.vo.BedSpaceStateLiteVo)cx_CoreSelectedBedSpaceState.getValue(context);
		}
		public void setSelectedBedSpaceState(ims.core.vo.BedSpaceStateLiteVo value)
		{
			cx_CoreSelectedBedSpaceState.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedBedSpaceState = new ims.framework.ContextVariable("Core.SelectedBedSpaceState", "_cv_Core.SelectedBedSpaceState");
		public boolean getEditVTERiskAssessmentFromInpatientEpisodeIsNotNull()
		{
			return !cx_CoreEditVTERiskAssessmentFromInpatientEpisode.getValueIsNull(context);
		}
		public Boolean getEditVTERiskAssessmentFromInpatientEpisode()
		{
			return (Boolean)cx_CoreEditVTERiskAssessmentFromInpatientEpisode.getValue(context);
		}
		public void setEditVTERiskAssessmentFromInpatientEpisode(Boolean value)
		{
			cx_CoreEditVTERiskAssessmentFromInpatientEpisode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEditVTERiskAssessmentFromInpatientEpisode = new ims.framework.ContextVariable("Core.EditVTERiskAssessmentFromInpatientEpisode", "_cv_Core.EditVTERiskAssessmentFromInpatientEpisode");
		public boolean getADTTransfersOutIsNotNull()
		{
			return !cx_CoreADTTransfersOut.getValueIsNull(context);
		}
		public ims.core.vo.PendingTransfersLiteVoCollection getADTTransfersOut()
		{
			return (ims.core.vo.PendingTransfersLiteVoCollection)cx_CoreADTTransfersOut.getValue(context);
		}
		public void setADTTransfersOut(ims.core.vo.PendingTransfersLiteVoCollection value)
		{
			cx_CoreADTTransfersOut.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTTransfersOut = new ims.framework.ContextVariable("Core.ADTTransfersOut", "_cv_Core.ADTTransfersOut");
		public boolean getBedInfoDialogIsNotNull()
		{
			return !cx_CoreBedInfoDialog.getValueIsNull(context);
		}
		public ims.core.vo.BedSpaceInfoDialogVo getBedInfoDialog()
		{
			return (ims.core.vo.BedSpaceInfoDialogVo)cx_CoreBedInfoDialog.getValue(context);
		}
		public void setBedInfoDialog(ims.core.vo.BedSpaceInfoDialogVo value)
		{
			cx_CoreBedInfoDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreBedInfoDialog = new ims.framework.ContextVariable("Core.BedInfoDialog", "_cv_Core.BedInfoDialog");
		public boolean getADTTransfersInIsNotNull()
		{
			return !cx_CoreADTTransfersIn.getValueIsNull(context);
		}
		public ims.core.vo.PendingTransfersLiteVoCollection getADTTransfersIn()
		{
			return (ims.core.vo.PendingTransfersLiteVoCollection)cx_CoreADTTransfersIn.getValue(context);
		}
		public void setADTTransfersIn(ims.core.vo.PendingTransfersLiteVoCollection value)
		{
			cx_CoreADTTransfersIn.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTTransfersIn = new ims.framework.ContextVariable("Core.ADTTransfersIn", "_cv_Core.ADTTransfersIn");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientElectiveListsForCancellationDialogIsNotNull()
		{
			return !cx_RefManPatientElectiveListsForCancellationDialog.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection getPatientElectiveListsForCancellationDialog()
		{
			return (ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection)cx_RefManPatientElectiveListsForCancellationDialog.getValue(context);
		}
		public void setPatientElectiveListsForCancellationDialog(ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection value)
		{
			cx_RefManPatientElectiveListsForCancellationDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManPatientElectiveListsForCancellationDialog = new ims.framework.ContextVariable("RefMan.PatientElectiveListsForCancellationDialog", "_cv_RefMan.PatientElectiveListsForCancellationDialog");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public RefManContext RefMan;
}
