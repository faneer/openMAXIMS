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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.systemreview;

import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.clinical.vo.lookups.BodySystemCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.emergency.forms.systemreview.GenForm.grdSystemReviewRow;
import ims.emergency.vo.SystemReviewForPresentingProblemConfigVo;
import ims.emergency.vo.SystemReviewVo;
import ims.emergency.vo.SystemReviewVoCollection;
import ims.emergency.vo.enums.EdAssessment_CustomControlsEvents;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	public void initialize(CareContextRefVo careContextRef,	EpisodeOfCareRefVo episodeRef, PatientRefVo patientRef, ClinicalProblemRefVo problemRef) 
	{
		form.getLocalContext().setCareContextRef(careContextRef);
		form.getLocalContext().setEpisodeOfCareRef(episodeRef);
		form.getLocalContext().setPatientRef(patientRef);
		form.getLocalContext().setClinicalProblemRef(problemRef);
		form.getLocalContext().setSelectedSystemReview(null);
		open();
		updateControlsState();
		
	}
	private void open()
	{
		clear();
		SystemReviewVoCollection tempColl = domain.listSystemReview(form.getLocalContext().getCareContextRef());
		if( tempColl != null && tempColl.size() > 0)
		{
			populateGrid(tempColl);
		}
		if(	form.getLocalContext().getSelectedSystemReviewIsNotNull())
		{
			form.getLocalContext().setSelectedSystemReview(domain.getSystemReview(form.getLocalContext().getSelectedSystemReview()));
			form.grdSystemReview().setValue(form.getLocalContext().getSelectedSystemReview());
		}
	}
	
	private void populateGrid(SystemReviewVoCollection tempColl)
	{
		form.grdSystemReview().getRows().clear();
		StringBuffer tooltip = new StringBuffer();
		
		if( tempColl != null && tempColl.size() > 0)
		{
			for(int i = 0; i < tempColl.size();i++)
			{
				if(	tempColl.get(i) != null)
				{
					grdSystemReviewRow row = form.grdSystemReview().getRows().newRow();
					
					//WDEV-17118
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()))
						row.setBackColor(ConfigFlag.UI.CORRECTION_ROW_COLOUR.getValue());
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()))
					{
						row.setColumnSystemReview(tempColl.get(i).getSystemsIsNotNull() ? "<s>" + tempColl.get(i).getSystems().getText() + "</s>":"");
					}
					else
						row.setColumnSystemReview(tempColl.get(i).getSystemsIsNotNull() ? tempColl.get(i).getSystems().getText():"");
					
					tooltip.delete(0, tooltip.length());
					tooltip.append(tempColl.get(i).getSystemsIsNotNull() ? tempColl.get(i).getSystems().getText():"");
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()) && tempColl.get(i).getCorrectedAuthoringInformation() != null)
					{
						tooltip.append("<br><b>Correction HCP: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringHcp());
						tooltip.append("<br><b>Corrected Date/Time: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringDateTime());
						tooltip.append(tempColl.get(i).getCorrectionCommentsIsNotNull() ? "<br><b>Correction comments: </b>" + tempColl.get(i).getCorrectionComments(): "<br><b>No Comments</b>");
					}
					
					row.setTooltipForColumnSystemReview(tooltip.toString());
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()))
					{
						row.setColumnAuthoringHCP(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringHcp() != null ?  "<s>" + tempColl.get(i).getAuthoringInformation().getAuthoringHcp().toString() + "</s>":"");
					}
					else
						row.setColumnAuthoringHCP(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringHcp() != null ?  tempColl.get(i).getAuthoringInformation().getAuthoringHcp().toString():"");
					
					tooltip.delete(0, tooltip.length());
					tooltip.append(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringHcp() != null ?  tempColl.get(i).getAuthoringInformation().getAuthoringHcp().toString():"");
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()) && tempColl.get(i).getCorrectedAuthoringInformation() != null)
					{
						tooltip.append("<br><b>Correction HCP: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringHcp());
						tooltip.append("<br><b>Corrected Date/Time: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringDateTime());
						tooltip.append(tempColl.get(i).getCorrectionCommentsIsNotNull() ? "<br><b>Correction comments: </b>" + tempColl.get(i).getCorrectionComments(): "<br><b>No Comments</b>");
					}
					
					row.setTooltipForColumnAuthoringHCP(tooltip.toString());
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()))
					{
						row.setColumnAuthoringDateTime(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringDateTimeIsNotNull() ? "<s>" + tempColl.get(i).getAuthoringInformation().getAuthoringDateTime().toString() + "</s>":"");
					}
					else
						row.setColumnAuthoringDateTime(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringDateTimeIsNotNull() ? tempColl.get(i).getAuthoringInformation().getAuthoringDateTime().toString():"");
					
					tooltip.delete(0, tooltip.length());
					tooltip.append(tempColl.get(i).getAuthoringInformationIsNotNull() && tempColl.get(i).getAuthoringInformation().getAuthoringDateTimeIsNotNull() ? tempColl.get(i).getAuthoringInformation().getAuthoringDateTime().toString():"");
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()) && tempColl.get(i).getCorrectedAuthoringInformation() != null)
					{
						tooltip.append("<br><b>Correction HCP: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringHcp());
						tooltip.append("<br><b>Corrected Date/Time: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringDateTime());
						tooltip.append(tempColl.get(i).getCorrectionCommentsIsNotNull() ? "<br><b>Correction comments: </b>" + tempColl.get(i).getCorrectionComments(): "<br><b>No Comments</b>");
					}
					
					row.setTooltipForColumnAuthoringDateTime(tooltip.toString());
					
					
					row.setColumnNote(Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()) ? "<s>" + tempColl.get(i).getSystemReviewNote() + "</s>" : tempColl.get(i).getSystemReviewNote());
					tooltip.delete(0, tooltip.length());
					tooltip.append(tempColl.get(i).getSystemReviewNote());
					
					if (Boolean.TRUE.equals(tempColl.get(i).getIsCorrected()) && tempColl.get(i).getCorrectedAuthoringInformation() != null)
					{
						tooltip.append("<br><b>Correction HCP: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringHcp());
						tooltip.append("<br><b>Corrected Date/Time: </b>" + tempColl.get(i).getCorrectedAuthoringInformation().getAuthoringDateTime());
						tooltip.append(tempColl.get(i).getCorrectionCommentsIsNotNull() ? "<br><b>Correction comments: </b>" + tempColl.get(i).getCorrectionComments(): "<br><b>No Comments</b>");
					}
					
					row.setTooltipForColumnNote(tooltip.toString());
					
					row.setValue(tempColl.get(i));
				}
			}
		}
	}
	private void clear()
	{
		form.grdSystemReview().getRows().clear();
	}

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Emergency.SystemsReviewDialog) && result.equals(DialogResult.OK))
		{
			if (form.getGlobalContext().Emergency.getAddEditForSystemsReviewDlg() == null || Boolean.FALSE.equals(form.getGlobalContext().Emergency.getAddEditForSystemsReviewDlg()))   //add mode
			{
				form.getLocalContext().setSelectedSystemReview(null);
			}
			
			open();
		}
		
		//WDEV-17118
		if (formName.equals(form.getForms().Emergency.SystemReviewNotesDialog) || formName.equals(form.getForms().Emergency.NoteCorrectionDialog))
		{
			open();
		}
		
		if (formName.equals(form.getForms().Core.RieConfirmationDialog) && DialogResult.OK.equals(result))
		{
			doRIE();
		}
		
		//WDEV-17337
		form.getLocalContext().setSelectedEvent(EdAssessment_CustomControlsEvents.SAVE);
		form.fireCustomControlValueChanged();
		
		updateControlsState();
	}
	
	private void doRIE()
	{
		if(	form.getLocalContext().getSelectedSystemReviewIsNotNull() )
		{
			try
			{
				
					domain.markAsRie(form.getLocalContext().getSelectedSystemReview(), form.getForms().Emergency.SystemReview,  
							form.getGlobalContext().Core.getPatientShort().getID_Patient(), null,
							form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext():null,
							form.getGlobalContext().Core.getRieMessage());
				
			}
			catch (StaleObjectException e)
			{
				engine.showErrors(new String[]{ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue()});
				
				
			}
			catch (UnqViolationUncheckedException e)
			{
				engine.showErrors(new String[]{ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue()});
				
				
			}
			
			form.getLocalContext().setSelectedSystemReview(null);
		}
			
		open(); 
	}
	
	protected void onBtnRieClick() throws ims.framework.exceptions.PresentationLogicException
	{

		if(form.getLocalContext().getSelectedSystemReview() == null)
			return;
				
		engine.open(form.getForms().Core.RieConfirmationDialog);
	}
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//form.getGlobalContext().Emergency.setAddEditForSystemsReviewDlg(Boolean.FALSE);
		
		//WDEV-17118
		SystemReviewVoCollection currentActiveNotes = domain.getAllActiveSystemNotes(form.getLocalContext().getCareContextRef());
		SystemReviewForPresentingProblemConfigVo systemsReviewForproblem = domain.getSystemReviewForPresentingProblem(form.getLocalContext().getClinicalProblemRef());
		BodySystemCollection newSystems = getSystemsForCreation(currentActiveNotes, systemsReviewForproblem);
		
		SystemReviewVoCollection newSystemReviewColl = new SystemReviewVoCollection();
		
		for (int i = 0; i < newSystems.size(); i++)
		{
			SystemReviewVo tempVo = new SystemReviewVo();
			tempVo.setPatient(form.getLocalContext().getPatientRef());
			tempVo.setAttendance(form.getLocalContext().getCareContextRef());
			tempVo.setEpisode(form.getLocalContext().getEpisodeOfCareRef());
			tempVo.setSystems(newSystems.get(i));
			newSystemReviewColl.add(tempVo);
		}
		
		//engine.open(form.getForms().Emergency.SystemsReviewDialog, new Object[]{tempVo, form.getLocalContext().getClinicalProblemRef()});
		
		if (newSystemReviewColl.size() == 0)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			updateControlsState();
			return;
		}
		
		form.getGlobalContext().Emergency.setSystemReviewCollection(newSystemReviewColl);
		engine.open(form.getForms().Emergency.SystemReviewNotesDialog);
	}
	
	private BodySystemCollection getSystemsForCreation(SystemReviewVoCollection currentActiveNotes, SystemReviewForPresentingProblemConfigVo systemsReviewForproblem)
	{
		if (systemsReviewForproblem == null)
			return null;
		
		BodySystemCollection systemCollection = systemsReviewForproblem.getSystem();
		
		if (currentActiveNotes == null)
		{
			return systemsReviewForproblem.getSystem();
		}
		
		
		if (systemsReviewForproblem.getSystem() != null && systemsReviewForproblem.getSystem().size() > 0 && currentActiveNotes.size() > 0)
		{
			for (int i = 0; i < currentActiveNotes.size(); i++)
			{
				if (systemsReviewForproblem.getSystem().contains(currentActiveNotes.get(i).getSystems()))
				{
					systemCollection.remove(currentActiveNotes.get(i).getSystems());
				}
			}
		}
		
		return systemCollection;
	}
		
	protected void onGrdSystemReviewSelectionChanged()
	{
		if(form.grdSystemReview().getSelectedRow() != null)
		{
			form.getLocalContext().setSelectedSystemReview(domain.getSystemReview(form.grdSystemReview().getSelectedRow().getValue()));
			form.getGlobalContext().Emergency.setSystemReview(form.getLocalContext().getSelectedSystemReview());
		}
		else
			form.getLocalContext().setSelectedSystemReview(null);
		
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		//WDEV-17337
		SystemReviewVoCollection currentActiveNotes =null;
		if (form.getLocalContext().getCareContextRef()!=null)
			currentActiveNotes= domain.getAllActiveSystemNotes(form.getLocalContext().getCareContextRef());
		
		Boolean isEnable = Boolean.TRUE.equals(form.getLocalContext().getisEnabled());
		
		//WDEV-17118
		form.btnNew().setEnabled(form.getMode().equals(FormMode.VIEW) && isEnable && checkIsEnabled(currentActiveNotes));
		form.btnNew().setText(currentActiveNotes != null ? "Edit review" :"New review");
		
		form.btnCorrect().setEnabled(form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getSelectedSystemReviewIsNotNull() && (! Boolean.TRUE.equals(form.getLocalContext().getSelectedSystemReview().getIsCorrected())) && isEnable);
		form.btnRie().setEnabled(form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getSelectedSystemReviewIsNotNull() && isEnable);
	}
	
	//WDEV-17118
	private Boolean checkIsEnabled(SystemReviewVoCollection currentActiveNotes)
	{
		SystemReviewForPresentingProblemConfigVo systemsReviewForProblem = null;
		Boolean isOk = Boolean.FALSE;
		
		if (form.getLocalContext().getClinicalProblemRef() != null)
		{
			systemsReviewForProblem = domain.getSystemReviewForPresentingProblem(form.getLocalContext().getClinicalProblemRef());
		}
		
		if (currentActiveNotes == null && systemsReviewForProblem != null && systemsReviewForProblem.getSystem() != null && systemsReviewForProblem.getSystem().size() > 0)
		{
			isOk = Boolean.TRUE;
		}
		else if (currentActiveNotes != null && systemsReviewForProblem != null && systemsReviewForProblem.getSystem() != null)
		{
			if (currentActiveNotes.size() != systemsReviewForProblem.getSystem().size() && systemsReviewForProblem.getSystem().size() > currentActiveNotes.size())
			{
				isOk = Boolean.TRUE;
			}
			else
			{
				BodySystemCollection clone = (BodySystemCollection) systemsReviewForProblem.getSystem().clone();

				for (int x = 0; x < currentActiveNotes.size(); x++)
				{
					for (int y = 0; y < systemsReviewForProblem.getSystem().size(); y++)
					{
						if (currentActiveNotes.get(x).getSystems().equals(systemsReviewForProblem.getSystem().get(y)))
						{
							clone.remove(systemsReviewForProblem.getSystem().get(y));
						}
					}
				}

				isOk = (clone.size() > 0);
			}
		}
		
		return isOk;
	}
	
	public void setEnabled(Boolean value) 
	{
		form.getLocalContext().setisEnabled(value);
		updateControlsState();
	}
	
	//WDEV-17118
	protected void onBtnCorrectClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.NoteCorrectionDialog);
	}
	
	//WDEV-17337
	public EdAssessment_CustomControlsEvents getSelectedEvent()
	{
		return form.getLocalContext().getSelectedEvent();
	}
	
	//WDEV-17337
	public void resetSelectedEvent()
	{
		form.getLocalContext().setSelectedEvent(null);
	}
}
