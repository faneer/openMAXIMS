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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.ntpfbilllinghospitalconfig;

import ims.admin.forms.ntpfbilllinghospitalconfig.GenForm.grdPaymentHospRow;
import ims.admin.forms.ntpfbilllinghospitalconfig.GenForm.grdTreatmentHospRow;
import ims.admin.vo.PaymentTreatmentHospitalLinkVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open(null);
	}
	private void open(PaymentTreatmentHospitalLinkVo voPayment)
	{
		form.getLocalContext().setCurrentConfiguredPaymentHOSPS(domain.listPaymentTreatmentHospitalLinks());
		
		displayAllPayment(voPayment);
	}
	
	private void displayConfiguredTreatmentItemsOnly(grdPaymentHospRow rowCurrent)
	{
		form.grdTreatmentHosp().getRows().clear();
		
		if ((rowCurrent != null
			&& rowCurrent.getValue() != null
			&& rowCurrent.getValue() instanceof PaymentTreatmentHospitalLinkVo))
		{
			PaymentTreatmentHospitalLinkVo voPayment = (PaymentTreatmentHospitalLinkVo) rowCurrent.getValue();
			for (int i = 0 ; i < voPayment.getTreatingHospital().size() ; i++)
			{
				grdTreatmentHospRow row = form.grdTreatmentHosp().getRows().newRow();
				row.setColTreatingHosp(voPayment.getTreatingHospital().get(i).getName().toString());
				row.setColSelect(true);
				row.setValue(voPayment.getTreatingHospital().get(i));
			}
		}
	}
	private void displayAllPayment(PaymentTreatmentHospitalLinkVo voPayment)
	{
		form.grdPaymentHosp().getRows().clear();
		form.grdTreatmentHosp().getRows().clear();
		
		for (int k = 0 ; form.getLocalContext().getAllTreatingHospsIsNotNull() && k < form.getLocalContext().getAllTreatingHosps().size() ; k++)
		{
			grdPaymentHospRow row = form.grdPaymentHosp().getRows().newRow();
			row.setCoHosp(form.getLocalContext().getAllTreatingHosps().get(k).getName().toString());
			row.setValue(form.getLocalContext().getAllTreatingHosps().get(k));
			
			for (int i = 0 ; i < form.getLocalContext().getCurrentConfiguredPaymentHOSPS().size() ; i++)
			{
				if (form.getLocalContext().getAllTreatingHosps().get(k).equals(form.getLocalContext().getCurrentConfiguredPaymentHOSPS().get(i).getPaymentHospital()))
					row.setValue(form.getLocalContext().getCurrentConfiguredPaymentHOSPS().get(i));

				if (voPayment != null
					&& voPayment.getID_PaymentTreatingHospitalLinkIsNotNull()
					&& voPayment.getID_PaymentTreatingHospitalLink().equals(form.getLocalContext().getCurrentConfiguredPaymentHOSPS().get(i).getID_PaymentTreatingHospitalLink()))
					displayConfiguredTreatmentItemsOnly(row);
			}
		}
		if (voPayment != null)
		{
			form.grdPaymentHosp().setValue(voPayment);
			paymentSelectionChanged();
		}

	}

	private void initialise()
	{
		form.getLocalContext().setAllTreatingHosps(domain.listHospitals());
		form.btnNew().setEnabled(false);
		form.btnEdit().setEnabled(false);
		form.btnNew().setVisible(true);
		form.btnEdit().setVisible(true);

	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdPaymentHosp().getSelectedRow() != null
			&& form.grdPaymentHosp().getSelectedRow().getValue() != null
			&& form.grdPaymentHosp().getSelectedRow().getValue() instanceof LocationLiteVo)
		{
			PaymentTreatmentHospitalLinkVo voConfig = domain.getPaymentHospitalConfig((LocationLiteVo)form.grdPaymentHosp().getSelectedRow().getValue());
			if (voConfig != null)
				form.grdPaymentHosp().getSelectedRow().setValue(voConfig);
		}
		
		displayConfiguredAndUnconfiguredTreatmentItems();
		form.setMode(FormMode.EDIT);
	}

	private boolean displayConfiguredAndUnconfiguredTreatmentItems()
	{
		form.grdTreatmentHosp().getRows().clear();

		boolean bFindMatch = false;
		
		PaymentTreatmentHospitalLinkVo voPayment = null;
		if (form.grdPaymentHosp().getSelectedRow() != null
			&& form.grdPaymentHosp().getSelectedRow().getValue() != null
			&& form.grdPaymentHosp().getSelectedRow().getValue() instanceof PaymentTreatmentHospitalLinkVo)
		{
			voPayment = (PaymentTreatmentHospitalLinkVo) form.grdPaymentHosp().getSelectedRow().getValue();
			bFindMatch = true;
		}
		else
		{
			if (form.grdPaymentHosp().getSelectedRow() != null	
				&& form.grdPaymentHosp().getSelectedRow().getValue() != null
				&& form.grdPaymentHosp().getSelectedRow().getValue() instanceof LocationLiteVo)
				voPayment = domain.getPaymentHospitalConfig((LocationLiteVo)form.grdPaymentHosp().getSelectedRow().getValue());
			
			if (voPayment != null)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open(voPayment);
				form.setMode(FormMode.VIEW);
				return false;
			}
		}

		for (int k = 0 ; k < form.getLocalContext().getAllTreatingHosps().size() ; k++)
		{
			grdTreatmentHospRow row = form.grdTreatmentHosp().getRows().newRow();
			row.setColTreatingHosp(form.getLocalContext().getAllTreatingHosps().get(k).getName().toString());
			row.setColSelect(false);
			row.setValue(form.getLocalContext().getAllTreatingHosps().get(k));
			
			if (bFindMatch)
			{
				for (int i = 0 ; i < voPayment.getTreatingHospital().size() ; i++)
				{
					if (form.getLocalContext().getAllTreatingHosps().get(k).equals(voPayment.getTreatingHospital().get(i)))
						row.setColSelect(true);
				}
			}
		}
		return true;
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PaymentTreatmentHospitalLinkVo voPayment = null;
		if (form.grdPaymentHosp().getSelectedRow() != null
			&&  form.grdPaymentHosp().getSelectedRow().getValue() != null
			&& form.grdPaymentHosp().getSelectedRow().getValue() instanceof PaymentTreatmentHospitalLinkVo)
			voPayment = (PaymentTreatmentHospitalLinkVo) form.grdPaymentHosp().getSelectedRow().getValue();
		else
		{
			if (form.grdPaymentHosp().getSelectedRow() != null	
				&& form.grdPaymentHosp().getSelectedRow().getValue() != null
				&& form.grdPaymentHosp().getSelectedRow().getValue() instanceof LocationLiteVo)
				voPayment = domain.getPaymentHospitalConfig((LocationLiteVo)form.grdPaymentHosp().getSelectedRow().getValue());

			if (voPayment != null
				&& voPayment.getID_PaymentTreatingHospitalLinkIsNotNull())
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				form.setMode(FormMode.VIEW);
				open(voPayment);
				return;
			}
			else
				voPayment = new PaymentTreatmentHospitalLinkVo();
				
			voPayment.setPaymentHospital((LocationLiteVo) form.grdPaymentHosp().getSelectedRow().getValue());
		}
		
		
		LocationLiteVoCollection voColl = new LocationLiteVoCollection();
		for (int i = 0 ; i < form.grdTreatmentHosp().getRows().size() ; i++)
		{
			if (form.grdTreatmentHosp().getRows().get(i).getColSelect())
				voColl.add(form.grdTreatmentHosp().getRows().get(i).getValue());
		}

		voPayment.setTreatingHospital(voColl);
		
		String[] errors = voPayment.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}
		try
		{
			voPayment = domain.savePaymentHospitalLink(voPayment);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
		}
		
		form.setMode(FormMode.VIEW);
		open(voPayment);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open(null);
		
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onGrdPaymentHospSelectionChanged() throws PresentationLogicException
	{
		paymentSelectionChanged();
	}
	private void paymentSelectionChanged()
	{
		displayConfiguredTreatmentItemsOnly(form.grdPaymentHosp().getSelectedRow());
		
		if (form.grdPaymentHosp().getSelectedRow() == null
				|| form.grdPaymentHosp().getSelectedRow().getValue() == null)
		return;
		
		if (form.grdPaymentHosp().getSelectedRow().getValue() instanceof LocationLiteVo)
		{
			form.btnNew().setEnabled(true);
			form.btnEdit().setEnabled(false);
		}
		else if (form.grdPaymentHosp().getSelectedRow().getValue() instanceof PaymentTreatmentHospitalLinkVo)
		{
			form.btnNew().setEnabled(false);
			form.btnEdit().setEnabled(true);
		}
	}
	@Override
	protected void onGrdTreatmentHospSelectionChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onBtnNewClick() throws PresentationLogicException
	{
		if (displayConfiguredAndUnconfiguredTreatmentItems())
			form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onFormModeChanged()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnNew().setEnabled(false);
			form.btnEdit().setEnabled(false);
			form.btnNew().setVisible(true);
			form.btnEdit().setVisible(true);
		}
		
	}
}
