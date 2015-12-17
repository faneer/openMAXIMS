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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.nursing.forms.copycareplans;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.RecordingUserInformationVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.nursing.forms.copycareplans.GenForm.grdCarePlansRow;
import ims.nursing.vo.CarePlanForCopyCarePlansVo;
import ims.nursing.vo.CarePlanForCopyCarePlansVoCollection;
import ims.nursing.vo.CarePlanInterventions;
import ims.nursing.vo.CarePlanInterventionsCollection;
import ims.nursing.vo.CarePlanStatus;
import ims.nursing.vo.CarePlanStatusCollection;
import ims.nursing.vo.CopyCarePlanVo;
import ims.nursing.vo.CopyCarePlanVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCopyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		CarePlanForCopyCarePlansVoCollection collCarePlansToSave = new CarePlanForCopyCarePlansVoCollection();
		for (int i = 0; i < form.grdCarePlans().getRows().size(); i++)
		{
			if (form.grdCarePlans().getRows().get(i).getcolSelect())
			{
				collCarePlansToSave.add(populateCarePlanDataFromScreen(form.grdCarePlans().getRows().get(i).getValue()));
			}
		}

		if (collCarePlansToSave == null || collCarePlansToSave.size() == 0)
		{
			engine.showMessage("At least one Care Plan should be selected to be able to copy!");
			return false;
		}
		
		for (int i = 0; i < collCarePlansToSave.size(); i++)
		{
			String[] errors = collCarePlansToSave.get(i).validate();
			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
		}

		if (currentEpisodeHaveCarePlans())
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		try
		{
			domain.saveCarePlans(collCarePlansToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}

		return true;
	}

	private CarePlanForCopyCarePlansVo populateCarePlanDataFromScreen(CopyCarePlanVo carePlanToBeCopied)
	{
		CarePlanForCopyCarePlansVo carePlanToSave = new CarePlanForCopyCarePlansVo();

		CarePlanForCopyCarePlansVo carePlan = domain.getCarePlan(carePlanToBeCopied);

		carePlanToSave = (CarePlanForCopyCarePlansVo) carePlan.clone();
		carePlanToSave.setID_CarePlan(null);

		// Intervensions
		carePlanToSave.setInterventions(createNewCarePlanInterventionsCollection(carePlan.getInterventions()));

		// Next Evaluation date
		carePlanToSave.setNextEvaluationDate(carePlanToBeCopied.getNewNextEvaluationDate());

		CarePlanStatus currentCarePlanStatus = createNewCarePlanStatus();
		// CurrentCarePlanStatus
		carePlanToSave.setCurrentCarePlanStatus(currentCarePlanStatus);

		// CarePlanStatus
		CarePlanStatusCollection collCarePlanStatus = new CarePlanStatusCollection();
		collCarePlanStatus.add(currentCarePlanStatus);
		carePlanToSave.setCarePlanStatus(collCarePlanStatus);

		// ClinicaContact
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			carePlanToSave.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		}
		else
		{
			carePlanToSave.setClinicalContact(null);
		}

		// CareContext
		carePlanToSave.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		// RecordingInfo
		RecordingUserInformationVo recordingInfo = new RecordingUserInformationVo();

		Object mos = domain.getMosUser();
		if (mos != null)
		{
			recordingInfo.setRecordingUser((MemberOfStaffLiteVo) mos);
		}
		recordingInfo.setRecordingDateTime(new DateTime());

		return carePlanToSave;
	}

	private CarePlanStatus createNewCarePlanStatus()
	{
		CarePlanStatus carePlanStatus = new CarePlanStatus();

		carePlanStatus.setStatus(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE);
		carePlanStatus.setDateTime(new DateTime());
		Object hcpUser = domain.getHcpLiteUser();
		if (hcpUser != null)
		{
			carePlanStatus.setHCP((HcpLiteVo) hcpUser);
		}

		return carePlanStatus;

	}

	private CarePlanInterventionsCollection createNewCarePlanInterventionsCollection(CarePlanInterventionsCollection collInterventionsToBeCopied)
	{
		if (collInterventionsToBeCopied == null || collInterventionsToBeCopied.size() == 0)
			return null;

		CarePlanInterventionsCollection collInterventions = new CarePlanInterventionsCollection();

		collInterventionsToBeCopied.sort(SortOrder.ASCENDING);

		int counter = 0;

		for (int i = 0; i < collInterventionsToBeCopied.size(); i++)
		{
			CarePlanInterventions interventionToSave = collInterventionsToBeCopied.get(i);

			if (interventionToSave.getActive() && (interventionToSave.getIsRemoved() == null || (interventionToSave.getIsRemoved() != null && !interventionToSave.getIsRemoved())))
			{
				interventionToSave.setID_CarePlanIntervention(null);

				interventionToSave.setStartDate(new Date());

				Object hcpUser = domain.getHcpLiteUser();
				if (hcpUser != null)
				{
					interventionToSave.setStartBy((HcpLiteVo) hcpUser);
				}

				interventionToSave.setOrder(counter);
				counter++;

				// fields that shouldn't be copied
				interventionToSave.setStopDate(null);
				interventionToSave.setStopBy(null);
				interventionToSave.setIsRemoved(null); //WDEV-16795
				interventionToSave.setRemovalAuthoringInformation(null); //WDEV-16795

				collInterventions.add(interventionToSave);
			}
		}
		return collInterventions;
	}

	@Override
	protected void onChkCopyAllValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.chkCopyAll().getValue())
		{
			for (int i = 0; i < form.grdCarePlans().getRows().size(); i++)
			{
				form.grdCarePlans().getRows().get(i).setcolSelect(true);
			}
			form.getLocalContext().setactionSelected(ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKALL);
			engine.open(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog);

		}
		else
		{
			for (int i = 0; i < form.grdCarePlans().getRows().size(); i++)
			{
				form.grdCarePlans().getRows().get(i).setcolSelect(false);
			}
		}
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		listCarePlans();

	}

	private void listCarePlans()
	{
		form.grdCarePlans().getRows().clear();
		CopyCarePlanVoCollection collCarePlans = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, true);

		populateCarePlansGrid(collCarePlans);
		form.grdCarePlans().sort(4, SortOrder.ASCENDING);

	}

	private void populateCarePlansGrid(CopyCarePlanVoCollection collCarePlans)
	{
		if (collCarePlans == null)
			return;

		for (int i = 0; i < collCarePlans.size(); i++)
		{
			CopyCarePlanVo carePlan = collCarePlans.get(i);

			grdCarePlansRow row = form.grdCarePlans().getRows().newRow();

			row.setcolCarePlanTitle(carePlan.getTitle());

			if (carePlan != null && carePlan.getCarePlanStatusIsNotNull())
			{
				for (int x = 0; x < carePlan.getCarePlanStatus().size(); x++)
				{
					carePlan.getCarePlanStatus().sort(SortOrder.ASCENDING);
					if (carePlan.getCarePlanStatus().get(x).getStatus().equals(carePlan.getCurrentCarePlanStatus().getStatus()))
					{
						if (carePlan.getCarePlanStatus().get(x).getDateTime().getDate() != null)
							row.setcolInitiatedOn(carePlan.getCarePlanStatus().get(x).getDateTime().getDate());

						if (carePlan.getCarePlanStatus().get(x).getHCP() != null)
						{
							if (carePlan.getCarePlanStatus().get(x).getHCP().getName() != null)
								row.setcolInitiateBy(carePlan.getCarePlanStatus().get(x).getHCP().getName().toString());
						}
						break; // you could have a number of actives,
							   // i.e.active,then suspended,then active, you
							   // want
							   // the first active, so ASCENDING - get first
							   // active - need break.
					}
				}
			}
			if (carePlan.getCurrentCarePlanStatus() != null && carePlan.getCurrentCarePlanStatus().getStatus().equals(carePlan.getCurrentCarePlanStatus().getStatus()))
			{
				if (carePlan.getNextEvaluationDate() != null)
				{
					row.setcolNextEvaluation(carePlan.getNextEvaluationDate());
				}

			}

			if (carePlan.getCurrentCarePlanStatus() != null)
			{
				row.setcolStatus(carePlan.getCurrentCarePlanStatus().getStatus().getText());
			}
			row.setTooltipForcolCarePlanTitle(carePlan.getTitle());

			row.setValue(carePlan);
		}

	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);

	}

	@Override
	protected void onGrdCarePlansGridCheckBoxClicked(int column, grdCarePlansRow row, boolean isChecked) throws PresentationLogicException
	{
		if (row.getcolSelect())
		{
			form.getLocalContext().setselectedRow(row.getValue());
			form.getLocalContext().setactionSelected(ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKGRID);
			engine.open(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog);
		}

	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog) && result.equals(DialogResult.OK) && ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKGRID.equals(form.getLocalContext().getactionSelected()))
		{
			form.getLocalContext().getselectedRow().setNewNextEvaluationDate(form.getGlobalContext().Nursing.getNewNextEvaluationDateEntered().getNextEvaluationDate());
			form.grdCarePlans().setValue(form.getLocalContext().getselectedRow());

		}
		else if (formName.equals(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog) && result.equals(DialogResult.OK) && ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKALL.equals(form.getLocalContext().getactionSelected()))
		{
			for (int i = 0; i < form.grdCarePlans().getRows().size(); i++)
			{
				CopyCarePlanVo rowValue = form.grdCarePlans().getRows().get(i).getValue();
				rowValue.setNewNextEvaluationDate(form.getGlobalContext().Nursing.getNewNextEvaluationDateEntered().getNextEvaluationDate());
				form.grdCarePlans().getRows().get(i).setValue(rowValue);
			}
		}
		else if (formName.equals(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog) && result.equals(DialogResult.CANCEL) && ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKGRID.equals(form.getLocalContext().getactionSelected()))
		{
			form.grdCarePlans().setValue(form.getLocalContext().getselectedRow());
			form.grdCarePlans().getSelectedRow().setcolSelect(false);
		}
		else if (formName.equals(form.getForms().Nursing.EnterEvaluationDateForCarePlanDialog) && result.equals(DialogResult.CANCEL) && ims.nursing.vo.enums.CopyCarePlansActionSelected.CHECKALL.equals(form.getLocalContext().getactionSelected()))
		{
			form.chkCopyAll().setValue(null);
			for (int i = 0; i < form.grdCarePlans().getRows().size(); i++)
			{
				form.grdCarePlans().getRows().get(i).setcolSelect(false);
			}
		}

		form.getLocalContext().setactionSelected(null);

	}
	
	private boolean currentEpisodeHaveCarePlans()
	{
		CopyCarePlanVoCollection coll = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, false);
		if (coll==null || coll.size()==0)
			return false;
		return true;
		
	}
}
