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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40616.1545)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.assessleisure;

import ims.coe.vo.AssessmentLeisure;
import ims.coe.vo.LeisureClub;
import ims.coe.vo.LeisureClubCollection;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.textBoxHobbies().setFocus();
		form.setMode(FormMode.EDIT);
		form.bSave().setEnabled(true);
		form.gridCarePlan().setReadOnly(false);
		form.getLocalContext().setYesNoColl(ims.core.vo.lookups.LookupHelper.getYesNoUnknown(domain.getLookupService()));
		form.checkBoxCopy().setEnabled(false);
		
		// Populate the Grid CarePlan Templates
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.LEISURE);
		if (tempColl != null)
		{
			form.gridCarePlan().getRows().clear();
			GenForm.gridCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.gridCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setcolCarePlans(template.getTitle());
			}
		}
		
		// If there is an assessment in the global context, we want to call the get component
		// domain method
		// Otherwise, it is a new assessment component
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setAssmnt(assmnt);
		if (assmnt != null && assmnt.getID_AssessmentIsNotNull())
		{		
			//AssessmentLeisure assessLeisure = (AssessmentLeisure)domain.getComponent(assmnt.getCurrentComponent(), AssessmentComponentType.LEISURE);
			AssessmentLeisure assessLeisure = (AssessmentLeisure)domain.getComponent(assmnt,AssessmentComponentType.LEISURE);
			form.getLocalContext().setAssessLeisure(assessLeisure);
			populateFormInfo(assessLeisure);			
		}
		else
		{
			// check if there is a relevant component
			getLastAssessmentComponent();
		}
		
		try
		{
			onAnswerBoxDrinkSociallyValueChanged();
		} catch (PresentationLogicException e)
		{
			throw new FormOpenException(e.getMessage(),e);		}
	}
	
	protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getPrevAssessLeisure() == null)
			return;

		form.getLocalContext().getPrevAssessLeisure().setIsComplete(Boolean.FALSE);
		form.getLocalContext().getPrevAssessLeisure().setCarePlanTemplate(null);
	
		populateFormInfo(form.getLocalContext().getPrevAssessLeisure());
		form.checkBoxCopy().setValue(true);
		form.checkBoxCopy().setEnabled(false);
	}
	
	protected void getLastAssessmentComponent()
	{
		AssessmentLeisure assessLeisure = (AssessmentLeisure)domain.getLastAssessmentComponent(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getCurrentCareContext(),AssessmentComponentType.LEISURE);
		if (assessLeisure == null)
		{
			this.form.checkBoxCopy().setValue(false);
			return;
		}
		
		form.getLocalContext().setPrevAssessLeisure(assessLeisure);
		form.checkBoxCopy().setEnabled(true);
	}
	
	private void populateFormInfo(AssessmentLeisure assessLeisure)
	{
		if (assessLeisure == null)
			return;
		
		form.checkBoxComplete().setValue(assessLeisure.getIsComplete().booleanValue());
		if (assessLeisure.getIsComplete().booleanValue() == true) // Complete
		{
			form.bSave().setEnabled(false);
			form.setMode(FormMode.VIEW);
			form.checkBoxComplete().setEnabled(false);
			form.checkBoxCopy().setEnabled(false);
			form.gridCarePlan().setReadOnly(true);
			form.intBoxUnits().setEnabled(false);
		}
		form.checkBoxCopy().setValue(assessLeisure.getCopy().booleanValue());
	
		if (assessLeisure.getCopy().booleanValue() == true)
			form.checkBoxCopy().setEnabled(false);

		form.intBoxUnits().setValue(assessLeisure.getAlcoholUnits());
		form.textBoxDetails().setValue(assessLeisure.getAlcoholDetails());
		form.textBoxEnjoyMost().setValue(assessLeisure.getEnjoyDoingMost());
		form.textBoxHobbies().setValue(assessLeisure.getHobbies());
		form.textBoxSpendingTime().setValue(assessLeisure.getPreferencesOfTime());
		form.answerBoxDrinkSocially().setValue(assessLeisure.getAlcoholSocially());
		
		// Populate the Club Grid
		if (assessLeisure.getLeisureClubs() != null)
		{
			GenForm.gridClubRow row;
			LeisureClubCollection clubColl = assessLeisure.getLeisureClubs();
			form.gridClub().getRows().clear();
			LeisureClub club;
			for (int i=0; i<clubColl.size(); i++)
			{
				club = clubColl.get(i);
				row = form.gridClub().getRows().newRow();
				row.setValue(club);
				row.setColClub(club.getClubName());
				row.setColDays(club.getDaysOfWeek());
				row.setColFrequency(club.getFrequency());
				row.setColReq(club.getRequirements());
			}
		}
		
		// Populate the correct selected careplan template if one saved with the component
		if (assessLeisure.getCarePlanTemplate() != null && assessLeisure.getCarePlanTemplate().size() > 0)
		{
			GenForm.gridCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = assessLeisure.getCarePlanTemplate();
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.gridCarePlan().getRows().size(); j++)
			{
				cpRow = form.gridCarePlan().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setcolSelected(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
	}
	
	protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getAssessLeisure() != null && form.getLocalContext().getAssessLeisure().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getAssessLeisure().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}
	}
	
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		AssessmentLeisure assessLeisure = form.getLocalContext().getAssessLeisure();
		if (assessLeisure == null)
		{
			assessLeisure = new AssessmentLeisure();
			assessLeisure.setComponentType(AssessmentComponentType.LEISURE);
		}
		
		assessLeisure.setIsComplete(new Boolean(this.form.checkBoxComplete().getValue()));
		assessLeisure.setCopy(new Boolean(this.form.checkBoxCopy().getValue()));
		assessLeisure.setAlcoholDetails(form.textBoxDetails().getValue());
		assessLeisure.setAlcoholUnits(form.intBoxUnits().getValue());
		assessLeisure.setEnjoyDoingMost(form.textBoxEnjoyMost().getValue());
		assessLeisure.setHobbies(form.textBoxHobbies().getValue());
		assessLeisure.setPreferencesOfTime(form.textBoxSpendingTime().getValue());
		assessLeisure.setAlcoholSocially(form.answerBoxDrinkSocially().getValue());

		// Save the Grid Club Information
		GenForm.gridClubRow row;
		LeisureClubCollection clubColl = new LeisureClubCollection();
		for (int i=0; i<form.gridClub().getRows().size(); i++)
		{
			row = form.gridClub().getRows().get(i);
			if (row.getColClub() == null &&
					row.getColDays() == null &&
						row.getColFrequency() == null &&
							row.getColReq() == null)
				continue;
			
			LeisureClub club = row.getValue();
			if (club == null)
				club = new LeisureClub();
			club.setClubName(row.getColClub());
			club.setDaysOfWeek(row.getColDays());
			club.setFrequency(row.getColFrequency());
			club.setRequirements(row.getColReq());
			clubColl.add(club);
		}
		assessLeisure.setLeisureClubs(clubColl);

		String[] messages = assessLeisure.validate();
		if (messages != null)
		{
			engine.showErrors("Error occurred Creating Assessment Leisure Component. ", messages);			
		 	return;
		}
		
		try
		{		
			AssessmentHeaderInfo newAssmnt = form.getLocalContext().getAssmnt();
			
			if (newAssmnt.getCareContext() == null) 
				newAssmnt.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
			if (newAssmnt.getClinicalContact() == null)
				newAssmnt.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
	
		  newAssmnt = domain.saveComponent(newAssmnt, assessLeisure);
		  form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			//	We may need to reset the current component value in GC for onFormOpen - if there was none previously

			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));
			onFormOpen();
			return;				
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Leisure Assessment record already exists. " + e.getMessage());
			onFormOpen();
			return;
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));
			onFormOpen();
			return;	
		}
					
//		If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.gridCarePlan().getReadOnly() == false)
		{
			CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
		 	GenForm.gridCarePlanRow cpRow;
		 	for (int i=0; i<form.gridCarePlan().getRows().size(); i++)
		 	{
				cpRow = form.gridCarePlan().getRows().get(i);
			 	if (cpRow.getcolSelected() && !cpRow.isReadOnly())
				 	templList.add(cpRow.getValue());
			}
		 	if (templList.size() > 0)
		 	{
				 form.getGlobalContext().COE.CarePlan.setTemplateList(templList);
				 engine.open(form.getForms().Nursing.CarePlanStep2);
		 	}
		 	else
				 engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		}
		 else
			 engine.open(form.getForms().Nursing.AdmissionAssessOverview);	
	}

	protected void onBRemoveClick() throws PresentationLogicException
	{
		if (form.gridClub().getSelectedRowIndex() >= 0)
				form.gridClub().getRows().remove(form.gridClub().getSelectedRowIndex());
		
	}

	protected void onBAddClick() throws PresentationLogicException
	{
		form.gridClub().getRows().newRow();
		
	}

	protected void onAnswerBoxDrinkSociallyValueChanged() throws PresentationLogicException
	{
		if(form.answerBoxDrinkSocially().getValue() == null || !form.answerBoxDrinkSocially().getValue().equals(YesNoUnknown.YES))
		{
			form.intBoxUnits().setValue(null);
			form.intBoxUnits().setEnabled(false);
		}
		else
			form.intBoxUnits().setEnabled(true);
		
		if(form.getLocalContext().getAssessLeisure() != null)
		{
			if(form.getLocalContext().getAssessLeisure().getIsComplete().booleanValue() == true)
				form.intBoxUnits().setEnabled(false);
		}	
		
	}
	
	
}
