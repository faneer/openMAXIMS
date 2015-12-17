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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.skinclosureintraopdialog;

import ims.clinical.vo.IntraOpPlannedProcedureVo;
import ims.clinical.vo.IntraOpPlannedProcedureVoCollection;
import ims.clinical.vo.SkinClosureIntraOpVo;
import ims.core.vo.PatientProcedureMinVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		loadProcedures();

		initialise();
		open();
	}

	private void initialise()
	{
		form.lblDetails().setVisible(false);
		form.txtDetails().setVisible(false);
	}

	private void loadProcedures()
	{
		IntraOpPlannedProcedureVoCollection items = domain.listIntraOpPlannedProcedureByAppointment(form.getGlobalContext().Clinical.getTheatreAppointmentRef());
		if (items != null && items.size() >= 1)
		{
			for (IntraOpPlannedProcedureVo plannedProc : items)
			{
				if (plannedProc.getPlannedProcedureIsNotNull() && plannedProc.getPlannedProcedure().getProcedureIsNotNull())
					form.cmbProcedure().newRow(plannedProc.getPlannedProcedure(), plannedProc.getPlannedProcedure().getProcedure().getProcedureName());
			}
		}
		else
		{
			engine.showMessage("A Planned Procedure must be recorded");
			engine.close(DialogResult.CANCEL);
		}
	}

	private void open()
	{
		SkinClosureIntraOpVo skinClosure = form.getGlobalContext().Clinical.getSkinClosureIntraOpVo();
		populateScreenFromData(skinClosure);
		chkOtherValueChanged();
		if (skinClosure == null)
		{
			defaultSelectedProcedure();
		}
	}

	private void defaultSelectedProcedure()
	{
		if (form.cmbProcedure().getValues().size() == 1)
		{
			form.cmbProcedure().setValue((PatientProcedureMinVo) form.cmbProcedure().getValues().get(0));
		}
	}

	@Override
	protected void onChkOtherValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		chkOtherValueChanged();
	}

	private void chkOtherValueChanged()
	{
		form.lblDetails().setVisible(form.chkOther().getValue());
		form.txtDetails().setVisible(form.chkOther().getValue());

		if (!form.chkOther().getValue())
			form.txtDetails().setValue(null);
	}

	protected void clearScreen()
	{
		form.chklistSkinClosureTypes().setValues(null);
		form.txtDetails().setValue(null);
		form.chkOther().setValue(false);
		form.cmbProcedureWoundClass().setValue(null);
		form.cmbProcedure().setValue(null);
	}

	protected void populateScreenFromData(ims.clinical.vo.SkinClosureIntraOpVo skinClosure)
	{
		clearScreen();
		if (skinClosure == null)
			return;

		form.chklistSkinClosureTypes().setValues(skinClosure.getSkinClosureType());
		form.txtDetails().setValue(skinClosure.getDetailsIsNotNull() ? skinClosure.getDetails() : null);
		if (skinClosure.getOtherIsNotNull())
			form.chkOther().setValue(skinClosure.getOther().booleanValue());
		form.cmbProcedureWoundClass().setValue(skinClosure.getProcedureWoundClassIsNotNull() ? skinClosure.getProcedureWoundClass() : null);
		form.cmbProcedure().setValue(skinClosure.getPatientProcedureIsNotNull() ? skinClosure.getPatientProcedure() : null);
	}

	protected ims.clinical.vo.SkinClosureIntraOpVo populateDataFromScreen(ims.clinical.vo.SkinClosureIntraOpVo skinClosure)
	{
		if (skinClosure == null)
			skinClosure = new ims.clinical.vo.SkinClosureIntraOpVo();

		skinClosure.setSkinClosureType(form.chklistSkinClosureTypes().getValues());
		skinClosure.setDetails(form.txtDetails().getValue());
		skinClosure.setOther(new Boolean(form.chkOther().getValue()));
		skinClosure.setProcedureWoundClass(form.cmbProcedureWoundClass().getValue());
		skinClosure.setPatientProcedure(form.cmbProcedure().getValue());
		skinClosure.setTheatreAppointment(form.getGlobalContext().Clinical.getTheatreAppointmentRef());

		return skinClosure;
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		SkinClosureIntraOpVo skinClosure = populateDataFromScreen(form.getGlobalContext().Clinical.getSkinClosureIntraOpVo());

		String[] errors = skinClosure.validate(validateUI(skinClosure));

		if (errors != null)
		{
			engine.showErrors("Validation Errors", errors);
			return;
		}

		//WDEV-21829
		if (skinClosure.getID_SkinClosureIntraOpIsNotNull() && domain.getSkinClosureIntraOp(skinClosure)==null)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);
			return;
		}
		
		try
		{
			domain.saveSkinClosureIntraOp(skinClosure);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getGlobalContext().Clinical.setSkinClosureIntraOpVo(domain.getSkinClosureIntraOp(skinClosure));
			open();
			return;
		}
		engine.close(DialogResult.OK);
	}

	private String[] validateUI(SkinClosureIntraOpVo skinClosure)
	{
		//WDEV-21829
		java.util.ArrayList<String> uiErrors = new java.util.ArrayList<String>();

		if (skinClosure.getOtherIsNotNull() && skinClosure.getOther())
		{
			if (skinClosure.getDetails() == null)
			{
				uiErrors.add("Details is mandatory");
			}
		}
		
		if (skinClosure.getSkinClosureType() == null || skinClosure.getSkinClosureType().size() == 0)
		{
			uiErrors.add("Skin Closure Type is mandatory");
		}

		return uiErrors.toArray(new String[0]);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onChklistSkinClosureTypesValueChanged() throws PresentationLogicException
	{

	}
}
