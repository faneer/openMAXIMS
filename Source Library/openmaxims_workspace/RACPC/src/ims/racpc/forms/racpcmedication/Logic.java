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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3716.26758)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.racpc.forms.racpcmedication;

import ims.clinical.vo.RACPMedicationStatusVo;
import ims.clinical.vo.RACPMedicationStatusVoCollection;
import ims.clinical.vo.RACPMedicationVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.racpc.forms.racpcmedication.GenForm.grdMedsRow;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}
	private void open() 
	{
		clearScreen();
		
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			RACPMedicationVo voRACPMedicationVo = domain.getMedicationForCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			form.getLocalContext().setRACPMedicationVo(voRACPMedicationVo);
			if(voRACPMedicationVo!=null)
			{
				populateScreen(voRACPMedicationVo);
			}
		}
		
		form.setMode(FormMode.VIEW);//	WDEV-13437
	}
	private void populateScreen(RACPMedicationVo voRACPMedicationVo) {
		if(voRACPMedicationVo.getRAPCMedicationListIsNotNull()){
			RACPMedicationStatusVoCollection collRACPMedication = voRACPMedicationVo.getRAPCMedicationList();
			form.grdMeds().getRows().clear();
			for (int i = 0; i < collRACPMedication.size(); i++)
			{
				RACPMedicationStatusVo voRACPMedication = collRACPMedication.get(i);
				grdMedsRow row = form.grdMeds().getRows().newRow();
				row.setcolMed(voRACPMedication.getMedication());
				row.setcolStatus(voRACPMedication.getMedicationStatus());
			}
		}
		
		form.txtOther().setValue(voRACPMedicationVo.getMedicationNotes());
	}
	private void clearScreen() {
		form.grdMeds().getRows().clear();
		form.txtOther().setValue("");	
	}
	private void initialise() {
		
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		form.getLocalContext().setRACPMedicationVo(null);
		form.setMode(FormMode.EDIT);
		clearScreen();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		form.grdMeds().setValue(null);
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	private boolean save() 
	{
		if(isRACPCComplete())//	WDEV-13662
			return false;
		
		RACPMedicationVo  voRACPMedication  = populateDataFromScreen(form.getLocalContext().getRACPMedicationVo());
		
		String[] arrErrors = voRACPMedication.validate();
	
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		try
		{
			voRACPMedication = domain.saveMedicationVo(voRACPMedication);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
				
		form.getLocalContext().setRACPMedicationVo(voRACPMedication);
		
		return true;
	}
	private RACPMedicationVo populateDataFromScreen(RACPMedicationVo medicationVo) {
		if(medicationVo == null)
			medicationVo = new RACPMedicationVo();
		
		if(medicationVo.getCareContext()==null)
			medicationVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
		populateMedicationFromGrid(medicationVo);
			
		medicationVo.setMedicationNotes(form.txtOther().getValue());
		
		return medicationVo;
	}
	private void populateMedicationFromGrid(RACPMedicationVo medicationVo) {
		RACPMedicationStatusVoCollection collRACPMedicationStatusVo  = new RACPMedicationStatusVoCollection();
		for (int i = 0; i < form.grdMeds().getRows().size(); i++)
		{
			grdMedsRow row = form.grdMeds().getRows().get(i);
			
			RACPMedicationStatusVo voRACPMedicationStatus = new RACPMedicationStatusVo();
				
			voRACPMedicationStatus.setMedication(row.getcolMed());
			voRACPMedicationStatus.setMedicationStatus(row.getcolStatus());
			collRACPMedicationStatusVo.add(voRACPMedicationStatus);
		}
		
		if(collRACPMedicationStatusVo.size()>0)
			medicationVo.setRAPCMedicationList(collRACPMedicationStatusVo);
		else
			medicationVo.setRAPCMedicationList(null);
		
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException {
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				addMedication();
				form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeMedication();
				form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
				break;
			default:
				break;
		}
		
	}
	private void removeMedication() {
		if(form.grdMeds().getSelectedRow()!=null)
			form.grdMeds().getRows().remove(form.grdMeds().getSelectedRowIndex());		
	}
	private void addMedication() {
		form.grdMeds().getRows().newRow();		
	}
	@Override
	protected void onFormModeChanged() 
	{
		if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
		else
			form.getContextMenus().hideAllGenericGridMenuItems();
		
		updateControlsState();//	WDEV-13437
	}
	
	//	WDEV-13437
	private void updateControlsState() 
	{
		if(FormMode.VIEW.equals(form.getMode()))
		{
			boolean isReadOnly = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());
			
			form.btnNew().setVisible(form.getLocalContext().getRACPMedicationVo() == null && !isReadOnly);
			form.btnEdit().setVisible(form.getLocalContext().getRACPMedicationVo() != null && !isReadOnly);
		}
	}
	
	//	WDEV-13662
	private boolean isRACPCComplete() 
	{	
		boolean isRACPCSummaryComplete = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());//	WDEV-13662
		
		if(isRACPCSummaryComplete)//	WDEV-13662
		{
			engine.showMessage("RACPC Summary has already been completed. The screen will be refreshed.");
			open();
			return true;
		}
		
		return false;
	}
	
	@Override
	protected void onGrdMedsSelectionChanged() throws PresentationLogicException {
		if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getGenericGridRemoveItem().setVisible(true);
		else
			form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
	}
}
