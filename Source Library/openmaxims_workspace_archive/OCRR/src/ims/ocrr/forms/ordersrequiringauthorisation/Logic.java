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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.51 build 2461.17017)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.ordersrequiringauthorisation;

import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.place.vo.ClinicRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.PatIdType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.ocrr.forms.ordersrequiringauthorisation.GenForm.grpPatientLocationEnumeration;
import ims.ocrr.vo.OcsOrderInvVo;
import ims.ocrr.vo.OcsOrderInvVoCollection;
import ims.ocrr.vo.OrderInvestigationOcsOrderVo;
import ims.ocrr.vo.lookups.OrderInvStatus;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}
	
	private void initialise()
	{
		form.grpPatientLocation().setValue(grpPatientLocationEnumeration.rdoWard);
		form.dteTo().setNoFutureDates();
		loadHospitalCombo();
		setValueDateTime();
		setValueQmbRespClinician();
		setPatientIdentifierColumnCaption();
	}
	
	private void loadHospitalCombo()
	{
		LocShortMappingsVoCollection voCollHospitals = domain.listActiveHospitals();
		
		if (voCollHospitals != null)
		{
			for (int i = 0; i < voCollHospitals.size(); i++)
			{
				form.cmbHospital().newRow(voCollHospitals.get(i), voCollHospitals.get(i).toString());
			}
		}
		
		LocationLiteVo currentHospital = domain.getCurrentHospital(engine.getCurrentLocation());
		form.cmbHospital().setValue(currentHospital);
		
		hospitalValueChanged();
	}
	
	private void setValueQmbRespClinician()
	{
		HcpLiteVo mosLite = (HcpLiteVo) domain.getHcpLiteUser();
		if (mosLite != null)
		{
			form.qmbRespClinician().newRow(mosLite, mosLite.getName().toString());
			form.qmbRespClinician().setValue(mosLite);
		}
	}
	
	private void setValueDateTime()
	{
		Date date = new Date();
		form.dteTo().setValue(date);
		form.dteFrom().setValue(new Date().addDay(-14));
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search(true);
	}
	
	private void search(boolean bShowMessage)
	{
		if (!validateSearchCriteria())
			return;
		
		ClinicRefVo voClinRef = null;
		LocationRefVo voLocRef = null;
		if(form.grpPatientLocation().getValue().equals(grpPatientLocationEnumeration.rdoClinic))
			voClinRef = (ClinicRefVo) form.qmbPatLocation().getValue();
		else
			voLocRef = (LocationRefVo) form.qmbPatLocation().getValue();
		
		OcsOrderInvVoCollection voCollOrders = domain.listOrdersRequiringAuthorisation(form.dteFrom().getValue(), form.dteTo().getValue(), voClinRef,voLocRef, form.qmbRespClinician().getValue());
		populateGrdOrdersFromData(voCollOrders, bShowMessage);
	}

	private void populateGrdOrdersFromData(OcsOrderInvVoCollection voCollOrders, boolean bShowMessage)
	{ 
		form.grdOrders().getRows().clear();
		if(voCollOrders != null && voCollOrders.size() > 0)
		{
			for(int i=0;i<voCollOrders.size();i++)
			{
				OcsOrderInvVo voOcsOrder = voCollOrders.get(i);
				if(checkCancelledInvestions(voOcsOrder) == true)	//wdev-13275
					continue;
				GenForm.grdOrdersRow row = form.grdOrders().getRows().newRow();
				
				row.setcolDateTime(voOcsOrder.getSysInfo().getCreationDateTime().toString());
				
				PatientShort voPatient = voOcsOrder.getPatient();
				if(voPatient != null)
				{
					if (voPatient.getDisplayId() != null)
						row.setcolHospNo(voPatient.getDisplayId().getValue());
	
					if(voPatient.getNameIsNotNull())
						row.setcolPatName(voPatient.getName().toString());
					
					if(voPatient.getSexIsNotNull())
						row.setcolSex(voPatient.getSex().getText());
				}
				
				if(voOcsOrder.getPatientClinicIsNotNull())
					row.setcolLocation(voOcsOrder.getPatientClinic().getClinicName());
				else if(voOcsOrder.getPatientLocationIsNotNull())
					row.setcolLocation(voOcsOrder.getPatientLocation().getName());
				else if (voOcsOrder.getOutpatientDepartmentIsNotNull())
				{
					row.setcolLocation(voOcsOrder.getOutpatientDepartment().getName());
				}
				
				if(voOcsOrder.getOrderedByIsNotNull())
					row.setcolRequester(voOcsOrder.getOrderedBy().toString());
				
				row.setTooltip(getOrderTooltip(voOcsOrder));
				row.setValue(voOcsOrder);
			}
		}
		else
		{
			if(bShowMessage)
				engine.showMessage("No matching orders found");
		}
			
	}
	//wdev-13275
	//If all investigations are cancelled the method returns true, else return false
	private boolean checkCancelledInvestions(OcsOrderInvVo voOcsOrder)
	{
		boolean flag = true;
		if( voOcsOrder == null )
			return false;
		if(!voOcsOrder.getInvestigationsIsNotNull())
			return false;
		if(voOcsOrder.getInvestigations().size() < 1)
			return false;
		for(OrderInvestigationOcsOrderVo item : voOcsOrder.getInvestigations())
		{
			if(OrderInvStatus.CANCELLED.equals(item.getOrdInvCurrentStatusIsNotNull() ? item.getOrdInvCurrentStatus().getOrdInvStatus() : null) || OrderInvStatus.CANCEL_REQUEST.equals(item.getOrdInvCurrentStatusIsNotNull() ? item.getOrdInvCurrentStatus().getOrdInvStatus():null))
			{
				
			}
			else
			{
				flag = false;
			}
		}
		return flag;
		
	}

	private String getOrderTooltip(OcsOrderInvVo voOcsOrder)
	{
		if(voOcsOrder == null)
			return "";
		
		StringBuffer tooltip = new StringBuffer();
		String htmlSeparator = "<br>";
		for (int i = 0; voOcsOrder.getInvestigationsIsNotNull() && i < voOcsOrder.getInvestigations().size(); i++)
		{
			OrderInvestigationOcsOrderVo orderInvestigationOcsOrderVo = voOcsOrder.getInvestigations().get(i);
			if(OrderInvStatus.CANCELLED.equals(orderInvestigationOcsOrderVo.getOrdInvCurrentStatusIsNotNull() ? orderInvestigationOcsOrderVo.getOrdInvCurrentStatus().getOrdInvStatus():null) || OrderInvStatus.CANCEL_REQUEST.equals(orderInvestigationOcsOrderVo.getOrdInvCurrentStatusIsNotNull() ? orderInvestigationOcsOrderVo.getOrdInvCurrentStatus().getOrdInvStatus():null))	//wdev-13275
				continue;
			String invName = orderInvestigationOcsOrderVo.getInvestigationIsNotNull() && orderInvestigationOcsOrderVo.getInvestigation().getInvestigationIndexIsNotNull()?orderInvestigationOcsOrderVo.getInvestigation().getInvestigationIndex().getName():null;
			if(invName != null)
			{
				tooltip.append(invName);
				tooltip.append(htmlSeparator);
			}
		}

		if(tooltip.length() > 0)
		{
			tooltip.insert(0, "<b>Investigations:</b>" + htmlSeparator);
			
			//remove last <br>
			int lastIndex = tooltip.lastIndexOf(htmlSeparator);
			if (lastIndex >= 0)
				tooltip.replace(lastIndex, lastIndex + htmlSeparator.length(), "");
		}
		
		return tooltip.toString();
	}

	private boolean validateSearchCriteria()
	{
		Date dateFrom = form.dteFrom().getValue();
		Date dateTo = form.dteTo().getValue();
		
		if(dateTo != null && dateFrom != null && dateTo.isLessThan(dateFrom))
		{
			engine.showErrors(new String[]{"Date From cannot be before Date To"});
			return false;
		}
		
		if(form.cmbHospital().getValue() != null)
		{
			if(form.qmbPatLocation().getValue() == null)
			{
				engine.showErrors(new String[]{"Patient Location is a mandatory field."});
				return false;
			}
		}
		
		//ensuring some search criteria is specified
		if(form.dteFrom().getValue() == null && form.dteTo().getValue() == null && form.qmbRespClinician().getValue() == null && form.qmbPatLocation().getValue() == null)
		{
			engine.showErrors(new String[]{"Please enter some search criteria"});
			return false;
		}
		
		return true;
	}

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		//wdev-12435
		enableDisablePatientLocation(false);
		//-----------
	}
	
	private void clearScreen()
	{
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbHospital().setValue(null);
		form.qmbPatLocation().setValue(null);
		form.qmbRespClinician().setValue(null);
		form.grdOrders().getRows().clear();
	}

	protected void onQmbRespClinicianTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbRespClinician().clear();
		if (value == null || value.equals(""))
		{
			engine.showMessage("Please enter at least one character to search on");
			return;
		}

		HcpLiteVoCollection voCollHcp = domain.listHcpLiteByName(value);
		if (voCollHcp != null && voCollHcp.size() > 0)
		{
			for (int i = 0; i < voCollHcp.size(); i++)
			{
				form.qmbRespClinician().newRow(voCollHcp.get(i), voCollHcp.get(i).getMos().getName().toString());
			}
			if (voCollHcp.size() == 1)
				form.qmbRespClinician().setValue(voCollHcp.get(0));
			else if (voCollHcp.size() > 1)
				form.qmbRespClinician().showOpened();
		}
		else
			engine.showMessage("No matching records found");
	}
	 
	protected void onRadioButtongrpPatientLocationValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		 form.qmbPatLocation().clear();
	}
	
	protected void onQmbPatLocationTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital");
			return;
		}
		
		if (form.grpPatientLocation().getValue().equals(GenForm.grpPatientLocationEnumeration.None))
		{
			engine.showMessage("Please select Ward,Clinic,A&E or Other");
			return;
		}

		form.qmbPatLocation().clear();

		if (form.grpPatientLocation().getValue().equals(GenForm.grpPatientLocationEnumeration.rdoClinic))
		{
			ClinicLiteVoCollection voCollClinics = domain.listClinicsForHospitalByNameLite(form.cmbHospital().getValue(), value);
			if (voCollClinics != null && voCollClinics.size() > 0)
			{
				for (int i = 0; i < voCollClinics.size(); i++)
				{
					form.qmbPatLocation().newRow(voCollClinics.get(i), voCollClinics.get(i).getClinicName());
				}
				if (voCollClinics.size() == 1)
					form.qmbPatLocation().setValue(voCollClinics.get(0));
				else if (voCollClinics.size() > 1)
					form.qmbPatLocation().showOpened();
			}
			else
				engine.showMessage("No matching records found");

		}
		else if (form.grpPatientLocation().getValue().equals(GenForm.grpPatientLocationEnumeration.rdoWard))
		{
			LocationLiteVoCollection voCollLocLite = domain.listWardsForHospitalByNameLite(form.cmbHospital().getValue(), value);
			if (voCollLocLite != null && voCollLocLite.size() > 0)
			{
				for (int i = 0; i < voCollLocLite.size(); i++)
				{
					form.qmbPatLocation().newRow(voCollLocLite.get(i), voCollLocLite.get(i).getName().toString());
				}
				if (voCollLocLite.size() == 1)
					form.qmbPatLocation().setValue(voCollLocLite.get(0));
				else if (voCollLocLite.size() > 1)
					form.qmbPatLocation().showOpened();
			}
			else
				engine.showMessage("No matching records found");
		}
		else if (form.grpPatientLocation().getValue().equals(GenForm.grpPatientLocationEnumeration.rdoED))
		{
			LocationLiteVoCollection voCollLocLite = domain.listAandEForHospitalByNameLite(form.cmbHospital().getValue(), value);
			if (voCollLocLite != null && voCollLocLite.size() > 0)
			{
				for (int i = 0; i < voCollLocLite.size(); i++)
				{
					form.qmbPatLocation().newRow(voCollLocLite.get(i), voCollLocLite.get(i).getName().toString());
				}
				if (voCollLocLite.size() == 1)
					form.qmbPatLocation().setValue(voCollLocLite.get(0));
				else if (voCollLocLite.size() > 1)
					form.qmbPatLocation().showOpened();
			}
			else
				engine.showMessage("No matching records found");
		}
		else if (form.grpPatientLocation().getValue().equals(GenForm.grpPatientLocationEnumeration.rdoOther))
		{
			LocationLiteVoCollection voCollLocLite = domain.listUserEnteredLocationsForHospitalByNameLite(form.cmbHospital().getValue(), value);
			if (voCollLocLite != null && voCollLocLite.size() > 0)
			{
				for (int i = 0; i < voCollLocLite.size(); i++)
				{
					form.qmbPatLocation().newRow(voCollLocLite.get(i), voCollLocLite.get(i).getName().toString());
				}
				if (voCollLocLite.size() == 1)
					form.qmbPatLocation().setValue(voCollLocLite.get(0));
				else if (voCollLocLite.size() > 1)
					form.qmbPatLocation().showOpened();
			}
			else
				engine.showMessage("No matching records found");
		}
	}
	
	protected void onGrdOrdersSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-2526
		form.getGlobalContext().Core.setPatientShort(form.grdOrders().getValue().getPatient());
	
		//WDEV-13401
		if (engine.hasRight(AppRight.CAN_AUTHORIZE_CLINICAL_IMAGING_ORDERS) || engine.hasRight(AppRight.CAN_AUTHORIZE_PATHOLOGY_ORDERS))
		{
			form.getGlobalContext().OCRR.setOrderAwaitingAuthorisation(form.grdOrders().getValue());
			form.getGlobalContext().OCRR.PathologyResults.setOrder(form.grdOrders().getValue());
			engine.open(form.getForms().OCRR.OrderSummaryDialog);			
		}
		else
		{
			engine.showMessage("Your login role has not been assigned the right to authorise orders.");
		}
	}
	
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.OCRROrderAuthorisation.AUTHORISE:
				form.getGlobalContext().OCRR.setOrderAwaitingAuthorisation(form.grdOrders().getValue());
				form.getGlobalContext().OCRR.PathologyResults.setOrder(form.grdOrders().getValue());
				form.getGlobalContext().Core.setPatientShort(form.grdOrders().getValue().getPatient());
				engine.open(form.getForms().OCRR.OrderSummaryDialog);
			break;
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (form.getForms().OCRR.OrderSummaryDialog.equals(formName))
		{
			search(false);
		}
	}

	private void setPatientIdentifierColumnCaption()
	{
		form.grdOrders().setcolHospNoCaption(getPatientIdentifier());
	}
	
	private String getPatientIdentifier()
	{
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		if(dispIdType != null)
			return dispIdType.getText();
		
		return "Hospital No.";
	}
	private void enableDisablePatientLocation(boolean endis )
	{
		form.qmbPatLocation().setEnabled(endis);
		form.grpPatientLocation().setEnabled(endis);
	}

	
	protected void onCmbHospitalValueChanged()	throws PresentationLogicException 
	{
		hospitalValueChanged();
	}

	private void hospitalValueChanged() 
	{
		if(form.cmbHospital().getValue() == null)
			enableDisablePatientLocation(false);
		else
			enableDisablePatientLocation(true);
		
		form.qmbPatLocation().clear();
	}
}
