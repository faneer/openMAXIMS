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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.appointmentoutcomediagnosisselectiondialog;

import ims.RefMan.forms.appointmentoutcomediagnosisselectiondialog.GenForm.grdCareContextRow;
import ims.RefMan.forms.appointmentoutcomediagnosisselectiondialog.GenForm.grdOtherDiagnosisRow;
import ims.RefMan.vo.PatientDiagnosisForAppointmentOutcomeVo;
import ims.RefMan.vo.PatientDiagnosisForAppointmentOutcomeVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PatientDiagnosisForAppointmentOutcomeVoCollection vocoll = new PatientDiagnosisForAppointmentOutcomeVoCollection();
		
		for (int i = 0; i < form.grdCareContext().getRows().size(); i++)
		{			
			if (form.grdCareContext().getRows().get(i).getcolSelect())
			{
				vocoll.add(form.grdCareContext().getRows().get(i).getValue());
			}
		}	
		
		for (int i = 0; i < form.grdOtherDiagnosis().getRows().size(); i++)
		{			
			if (form.grdOtherDiagnosis().getRows().get(i).getcolSelect())
			{
				vocoll.add(form.grdOtherDiagnosis().getRows().get(i).getValue());
			}
		}			
		
		form.getGlobalContext().RefMan.setSelectedDiagnosisApptOutcomeList(vocoll);
		engine.close(DialogResult.OK);
	}

	protected void onFormModeChanged() 
	{
		updateControlState();
	}

	private void updateControlState() 
	{		
		form.btnClose().setText(FormMode.EDIT.equals(form.getMode()) ? "Cancel" : "Close");	
	}

	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		initialise();
		open();		
	}

	private void initialise() 
	{
		form.grdCareContext().getRows().clear();
		form.grdOtherDiagnosis().getRows().clear();				
	}

	private void open() 
	{
		populateScreenFromData(form.getGlobalContext().RefMan.getSelectedDiagnosisApptOutcomeList(),domain.listPatientDiagnosis(form.getGlobalContext().Core.getPatientShort()));
		form.setMode(FormMode.EDIT);
	}

	private void populateScreenFromData(PatientDiagnosisForAppointmentOutcomeVoCollection patientDiagnosisForAppointmentOutcomeVoCollection, PatientDiagnosisForAppointmentOutcomeVoCollection patientDiagnosisForAppointmentOutcomeVoCollection2) 
	{
		form.grdCareContext().getRows().clear();
		form.grdOtherDiagnosis().getRows().clear();
		
		if (patientDiagnosisForAppointmentOutcomeVoCollection2 != null)
		{
			for (PatientDiagnosisForAppointmentOutcomeVo diag : patientDiagnosisForAppointmentOutcomeVoCollection2)
			{
				if (form.getGlobalContext().Core.getCurrentCareContext() != null && diag.getCareContext() != null && diag.getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()))
				{
					grdCareContextRow row = form.grdCareContext().getRows().newRow();
					
					row.setcolDescription(diag.getDiagnosisDescription());
					row.setcolDiagnosisDate(diag.getDiagnosedDate() != null ? diag.getDiagnosedDate().toString(): "");
					
					if (diag.getAuthoringInfo() != null)
					{		
						row.setcolAuthoringHCPDateTime(diag.getAuthoringInfo().getIItemText());
					}
					
					row.setcolStatus((diag.getCurrentStatus() != null && diag.getCurrentStatus().getStatus() != null) ? diag.getCurrentStatus().getStatus().getText() : "");
					row.setValue(diag);
				}
				else
				{
					grdOtherDiagnosisRow otherDiagRow = form.grdOtherDiagnosis().getRows().newRow();
					otherDiagRow.setcolDescription(diag.getDiagnosisDescription());
					otherDiagRow.setcolDiagnosisDate(diag.getDiagnosedDate() != null ? diag.getDiagnosedDate().toString() : "");
					
					if (diag.getAuthoringInfo() != null)
					{		
						otherDiagRow.setcolAuthoringHCPDateTime(diag.getAuthoringInfo().getIItemText());
					}
					
					otherDiagRow.setcolStatus((diag.getCurrentStatus() != null && diag.getCurrentStatus().getStatus() != null) ? diag.getCurrentStatus().getStatus().getText() : "");
					otherDiagRow.setValue(diag);
				}
			}
		}
		
		markApptOutcomeDiagnosis(form.getGlobalContext().RefMan.getSelectedDiagnosisApptOutcomeList());
	}
	
	private void markApptOutcomeDiagnosis(PatientDiagnosisForAppointmentOutcomeVoCollection patientDiagnosisOpNotesVoCollection)
	{
		if (patientDiagnosisOpNotesVoCollection == null)
			return;

		//check Referral Diagnosis Grid
		for (PatientDiagnosisForAppointmentOutcomeVo diagnosis : patientDiagnosisOpNotesVoCollection)
		{
			for (int i = 0; i < form.grdCareContext().getRows().size(); i++)
			{
				grdCareContextRow diagnosisRow = form.grdCareContext().getRows().get(i);
				
				if (diagnosis.equals(diagnosisRow.getValue()))
					diagnosisRow.setcolSelect(true);				
			}
		}
		
		//add any  records not persisted
		for (PatientDiagnosisForAppointmentOutcomeVo diag : patientDiagnosisOpNotesVoCollection)
		{
			if (!diag.getID_PatientDiagnosisIsNotNull())
			{
				grdCareContextRow row = form.grdCareContext().getRows().newRow();
				
				row.setcolDescription(diag.getDiagnosisDescription());
				row.setcolDiagnosisDate(diag.getDiagnosedDate() != null ? diag.getDiagnosedDate().toString(): "");
				
				if (diag.getAuthoringInfo() != null)
				{		
					row.setcolAuthoringHCPDateTime(diag.getAuthoringInfo().getIItemText());
				}
				
				row.setcolStatus((diag.getCurrentStatus() != null && diag.getCurrentStatus().getStatus() != null) ? diag.getCurrentStatus().getStatus().getText() : "");
				row.setValue(diag);
			}
		}		
		
		//check Other Diagnosis Grid
		for (PatientDiagnosisForAppointmentOutcomeVo diagnosis : patientDiagnosisOpNotesVoCollection)
		{
			for (int i = 0; i < form.grdOtherDiagnosis().getRows().size(); i++)
			{
				 grdOtherDiagnosisRow otherDiagnosisRow = form.grdOtherDiagnosis().getRows().get(i);
				
				if (diagnosis.equals(otherDiagnosisRow.getValue()))
					otherDiagnosisRow.setcolSelect(true);
			}
		}
	}
	
}
