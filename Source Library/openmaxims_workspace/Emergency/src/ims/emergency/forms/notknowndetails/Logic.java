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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.notknowndetails;

import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.AttendDiagInvTreatStatusVo;
import ims.emergency.vo.enums.NoKnownSelectedEvent;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);	
		open();
	}
	
	private void open()
	{
		populateScreenFromData();	
		form.setMode(form.getLocalContext().getFormMode());
	}

	private void populateScreenFromData()
	{
		clearScreen();
		
		if (NoKnownSelectedEvent.INVESTIGATION.equals(form.getLocalContext().getNoKnownSelectedType()))
		{
			populateInvestigationDetailsScreenFromData();
		}
		else if (NoKnownSelectedEvent.INTERVENTION.equals(form.getLocalContext().getNoKnownSelectedType()))
		{
			populateTreatmentDetailsScreenFromData();
		}
	}

	private void clearScreen()
	{
		form.cmbIntervTreatReason().setValue(null);
		form.cmbInvestigationsReason().setValue(null);
		form.txtReason().setValue(null);
	}

	private void populateInvestigationDetailsScreenFromData()
	{
		if (form.getLocalContext().getAttendDiagInvTreatStatus() == null)
			return;
		
		form.cmbInvestigationsReason().setValue(form.getLocalContext().getAttendDiagInvTreatStatus().getInvestigationReason());
		form.txtReason().setValue(form.getLocalContext().getAttendDiagInvTreatStatus().getInvestigationReasonText());
	}
	
	private void populateTreatmentDetailsScreenFromData()
	{
		if (form.getLocalContext().getAttendDiagInvTreatStatus() == null)
			return;
		
		form.cmbIntervTreatReason().setValue(form.getLocalContext().getAttendDiagInvTreatStatus().getTreatmentReason());
		form.txtReason().setValue(form.getLocalContext().getAttendDiagInvTreatStatus().getTreatmentReasonText());
	}
	
	private void initialize(Object[] args)
	{
		if (args!=null && args.length>4) 
		{
			form.getLocalContext().setPatient(args[0]!=null && args[0] instanceof PatientRefVo ? (PatientRefVo)args[0] : null);
			form.getLocalContext().setEpisodeOfCare(args[1]!=null && args[1] instanceof EpisodeOfCareRefVo ? (EpisodeOfCareRefVo)args[1] : null);
			form.getLocalContext().setCareContext(args[2]!=null && args[2] instanceof CareContextRefVo ? (CareContextRefVo)args[2] : null);
			form.getLocalContext().setNoKnownSelectedType((NoKnownSelectedEvent) args[3]);
			form.getLocalContext().setFormMode( (FormMode) args[4]);
		}
		
		form.getLocalContext().setAttendDiagInvTreatStatus(domain.getAttendDiagInvTreatStatus(form.getLocalContext().getCareContext()));;
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save(form.getLocalContext().getNoKnownSelectedType()))
		{
				engine.close(DialogResult.OK);
		}
	}
	
	//WDEV-19058
	private boolean save(NoKnownSelectedEvent noKnownSelectedEvent)
	{
		AttendDiagInvTreatStatusVo attendDiagInvTreatStatus = populateDataFromScreen(form.getLocalContext().getAttendDiagInvTreatStatus(), noKnownSelectedEvent);
		
		String[] errros = attendDiagInvTreatStatus.validate();
		
		if(errros != null && errros.length > 0)
		{
			engine.showErrors(errros);
			return false;
		}
		
		try 
		{
			domain.saveAttendDiagInvTreatStatus(attendDiagInvTreatStatus);
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}
	
	//WDEV-19058
	private AttendDiagInvTreatStatusVo populateDataFromScreen(AttendDiagInvTreatStatusVo attendDiagInvTreatStatusVo, NoKnownSelectedEvent noKnownSelectedEvent)
	{
		if (attendDiagInvTreatStatusVo==null)
			attendDiagInvTreatStatusVo= new AttendDiagInvTreatStatusVo();
		else
			attendDiagInvTreatStatusVo=(AttendDiagInvTreatStatusVo) attendDiagInvTreatStatusVo.clone();
		
		attendDiagInvTreatStatusVo.setPatient(form.getLocalContext().getPatient());
		attendDiagInvTreatStatusVo.setEpisode(form.getLocalContext().getEpisodeOfCare());
		attendDiagInvTreatStatusVo.setAttendance(form.getLocalContext().getCareContext());
		
		if (NoKnownSelectedEvent.INVESTIGATION.equals(noKnownSelectedEvent))
		{
			attendDiagInvTreatStatusVo.setInvestigationReason(form.cmbInvestigationsReason().getValue());
			attendDiagInvTreatStatusVo.setInvestigationReasonText(form.txtReason().getValue());
			attendDiagInvTreatStatusVo.setInvestigationNotRecorded(true);
			attendDiagInvTreatStatusVo.setNoInvestigations(null);
		}
		else if (NoKnownSelectedEvent.INTERVENTION.equals(noKnownSelectedEvent))
		{
			attendDiagInvTreatStatusVo.setTreatmentReason(form.cmbIntervTreatReason().getValue());
			attendDiagInvTreatStatusVo.setTreatmentReasonText(form.txtReason().getValue());
			attendDiagInvTreatStatusVo.setTreatmentsNotRecorded(true);
			attendDiagInvTreatStatusVo.setNoTreatments(null);
		}
		
		return attendDiagInvTreatStatusVo;
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.ABORT);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.cmbInvestigationsReason().setVisible(NoKnownSelectedEvent.INVESTIGATION.equals(form.getLocalContext().getNoKnownSelectedType()));
		form.cmbInvestigationsReason().setEnabled(FormMode.EDIT.equals(form.getMode()));
		
		form.cmbIntervTreatReason().setVisible(NoKnownSelectedEvent.INTERVENTION.equals(form.getLocalContext().getNoKnownSelectedType()));
		form.cmbIntervTreatReason().setEnabled(FormMode.EDIT.equals(form.getMode()));
	}
}
