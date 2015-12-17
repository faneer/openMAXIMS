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

package ims.emergency.forms.triage;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStartTriageClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkReturnToListClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditMainProblemClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcAlertValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcAllergyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAttendanceHistorySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdProblemSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrPatientTriageTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcVitalSignsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrObs2TabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcVitalSignsObsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcUrinalysisValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcUrineToxValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcHCGValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcPatientAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcPatientMedsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcRelevantPMHValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcSuppValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcDischargeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbPresentingProblemValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbPresentingProblemTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnReferToSpecialtyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnMovePatientClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewHistoryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPatientSummaryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnTrackingSummaryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnTrackingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdPatientsCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdPatientsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupClinicianReviewValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormClosing(args);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnStartTriage().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStartTriageClick();
			}
		});
		this.form.lnkReturnToList().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkReturnToListClick();
			}
		});
		this.form.btnEditMainProblem().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditMainProblemClick();
			}
		});
		this.form.setccAlertValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcAlertValueChanged();
			}
		});
		this.form.setccAllergyValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcAllergyValueChanged();
			}
		});
		this.form.grdAttendanceHistory().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAttendanceHistorySelectionChanged();
			}
		});
		this.form.grdProblem().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdProblemSelectionChanged();
			}
		});
		this.form.lyrPatientTriage().tabNotes().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabNotesActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabObsActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabObs2Activated();
			}
		});
		this.form.lyrPatientTriage().tabTriagePathway().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabTriagePathwayActivated();
			}
		});
		this.form.lyrPatientTriage().tabPatientMeds().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabPatientMedsActivated();
			}
		});
		this.form.lyrPatientTriage().tabRelevantPMH().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabRelevantPMHActivated();
			}
		});
		this.form.lyrPatientTriage().tabSupport().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabSupportActivated();
			}
		});
		this.form.lyrPatientTriage().tabDischarge().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientTriagetabDischargeActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs().setccVitalSignsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcVitalSignsValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabVitalSigns().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrObs2tabVitalSignsActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrinalysis().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrObs2tabUrinalysisActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrineTox().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrObs2tabUrineToxActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabHCG().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrObs2tabHCGActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabOther().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrObs2tabOtherActivated();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabVitalSigns().setccVitalSignsObsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcVitalSignsObsValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrinalysis().setccUrinalysisValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcUrinalysisValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrineTox().setccUrineToxValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcUrineToxValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabHCG().setccHCGValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcHCGValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabObs2().lyrObs2().tabOther().setccPatientAssessmentValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcPatientAssessmentValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabPatientMeds().setccPatientMedsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcPatientMedsValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabRelevantPMH().setccRelevantPMHValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcRelevantPMHValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabSupport().setccSuppValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcSuppValueChanged();
			}
		});
		this.form.lyrPatientTriage().tabDischarge().setccDischargeValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcDischargeValueChanged();
			}
		});
		this.form.qmbPresentingProblem().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbPresentingProblemValueChanged();
			}
		});
		this.form.qmbPresentingProblem().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbPresentingProblemTextSubmited(value);
			}
		});
		this.form.btnReferToSpecialty().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnReferToSpecialtyClick();
			}
		});
		this.form.btnMovePatient().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMovePatientClick();
			}
		});
		this.form.btnViewHistory().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewHistoryClick();
			}
		});
		this.form.btnPatientSummary().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPatientSummaryClick();
			}
		});
		this.form.btnTrackingSummary().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnTrackingSummaryClick();
			}
		});
		this.form.btnTracking().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnTrackingClick();
			}
		});
		this.form.dyngrdPatients().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPatientsCellButtonClicked(cell);
			}
		});
		this.form.dyngrdPatients().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPatientsRowSelectionChanged(row);
			}
		});
		this.form.GroupClinicianReview().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupClinicianReviewValueChanged();
			}
		});
		this.form.setTimerElapsedEvent(new ims.framework.delegates.TimerElapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
			{
				onTimer(timer);
			}
		});
		this.form.getContextMenus().Emergency.getOtherProblemsTriageMenuADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.OtherProblemsTriageMenu.ADD, sender);
			}
		});
		this.form.getContextMenus().Emergency.getOtherProblemsTriageMenuEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.OtherProblemsTriageMenu.EDIT, sender);
			}
		});
	}
	private void onlyrPatientTriagetabNotesActivated()
	{
		this.form.lyrPatientTriage().showtabNotes();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabNotes());
	}
	private void onlyrPatientTriagetabObsActivated()
	{
		this.form.lyrPatientTriage().showtabObs();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabObs());
	}
	private void onlyrPatientTriagetabObs2Activated()
	{
		this.form.lyrPatientTriage().showtabObs2();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabObs2());
	}
	private void onlyrPatientTriagetabTriagePathwayActivated()
	{
		this.form.lyrPatientTriage().showtabTriagePathway();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabTriagePathway());
	}
	private void onlyrPatientTriagetabPatientMedsActivated()
	{
		this.form.lyrPatientTriage().showtabPatientMeds();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabPatientMeds());
	}
	private void onlyrPatientTriagetabRelevantPMHActivated()
	{
		this.form.lyrPatientTriage().showtabRelevantPMH();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabRelevantPMH());
	}
	private void onlyrPatientTriagetabSupportActivated()
	{
		this.form.lyrPatientTriage().showtabSupport();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabSupport());
	}
	private void onlyrPatientTriagetabDischargeActivated()
	{
		this.form.lyrPatientTriage().showtabDischarge();
		onlyrPatientTriageTabChanged(this.form.lyrPatientTriage().tabDischarge());
	}
	private void onlyrObs2tabVitalSignsActivated()
	{
		this.form.lyrPatientTriage().tabObs2().lyrObs2().showtabVitalSigns();
		onlyrObs2TabChanged(this.form.lyrPatientTriage().tabObs2().lyrObs2().tabVitalSigns());
	}
	private void onlyrObs2tabUrinalysisActivated()
	{
		this.form.lyrPatientTriage().tabObs2().lyrObs2().showtabUrinalysis();
		onlyrObs2TabChanged(this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrinalysis());
	}
	private void onlyrObs2tabUrineToxActivated()
	{
		this.form.lyrPatientTriage().tabObs2().lyrObs2().showtabUrineTox();
		onlyrObs2TabChanged(this.form.lyrPatientTriage().tabObs2().lyrObs2().tabUrineTox());
	}
	private void onlyrObs2tabHCGActivated()
	{
		this.form.lyrPatientTriage().tabObs2().lyrObs2().showtabHCG();
		onlyrObs2TabChanged(this.form.lyrPatientTriage().tabObs2().lyrObs2().tabHCG());
	}
	private void onlyrObs2tabOtherActivated()
	{
		this.form.lyrPatientTriage().tabObs2().lyrObs2().showtabOther();
		onlyrObs2TabChanged(this.form.lyrPatientTriage().tabObs2().lyrObs2().tabOther());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
