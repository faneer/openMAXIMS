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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.71 build 3922.16454)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.edischargeplasticsurgeryandburnscentredischargecomponent;

import ims.clinical.vo.PlasticSurgeryAndBurnsVo;
import ims.clinical.vo.enums.EDischargeLastEvent;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.YesNo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args)
	{
		
	}
	public void initialise(SummaryRefVo summary)
	{
		form.getLocalContext().setSTHKSummary(summary);
		form.getLocalContext().setisReadonly(false);
		form.setMode(FormMode.VIEW);
		if (form.getLocalContext().getbInitialised() == null)
		{
			initializeComponent();
			form.getLocalContext().setbInitialised(Boolean.TRUE);
		}
		open();
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(true);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);			
		open();

		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
	}
	
	
	public boolean save() throws PresentationLogicException 
	{
		PlasticSurgeryAndBurnsVo voPlasticSurgeryAndBurns = populateDataFromScreen();
		String[] str = voPlasticSurgeryAndBurns.validate();
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);
			return false;
		}

		try 
		{
			voPlasticSurgeryAndBurns = domain.savePlasticSurgeryAndBurnsVo(voPlasticSurgeryAndBurns, form.getLocalContext().getSTHKSummary());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			form.setMode(FormMode.VIEW);
			open();
			form.getLocalContext().setLastEvent(EDischargeLastEvent.EDISCHARGE_SAVE);
			form.fireCustomControlValueChanged();
			// Temporary fix for WDEV-8612 (this code really belongs in the open() function)
			form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		
			return false;
		} 
		
		form.setMode(FormMode.VIEW);			
		form.getLocalContext().setSelectedRecord(voPlasticSurgeryAndBurns);
		
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		form.getLocalContext().setLastEvent(EDischargeLastEvent.EDISCHARGE_SAVE);
		form.fireCustomControlValueChanged();
	
		return true;
	}

	private PlasticSurgeryAndBurnsVo populateDataFromScreen() 
	{
		PlasticSurgeryAndBurnsVo voPlasticSurgeryAndBurns = null;
		if (form.getLocalContext().getSelectedRecordIsNotNull())
			voPlasticSurgeryAndBurns = form.getLocalContext().getSelectedRecord();
		else
			voPlasticSurgeryAndBurns = new PlasticSurgeryAndBurnsVo();

		if (voPlasticSurgeryAndBurns.getCareContext() == null)
			voPlasticSurgeryAndBurns.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		voPlasticSurgeryAndBurns.setAnaestheticType(form.cmbAnaesthetic().getValue());
		if(form.Group1().getValue().equals(GenForm.Group1Enumeration.rdoSkinForStorageYes))
			voPlasticSurgeryAndBurns.setSkinForStorage(YesNo.YES);
		else if(form.Group1().getValue().equals(GenForm.Group1Enumeration.rdoSkinForStorageNo))
			voPlasticSurgeryAndBurns.setSkinForStorage(YesNo.NO);
		voPlasticSurgeryAndBurns.setScheduledFirstDressingDate(form.dteFirstdressing().getValue());
		voPlasticSurgeryAndBurns.setScheduledSutureRemoval(form.dteSutureremoval().getValue());
		voPlasticSurgeryAndBurns.setSurgeon(form.qmbSurgeon().getValue());
		voPlasticSurgeryAndBurns.setIsComplete(form.chkComplete().getValue());
				
		return voPlasticSurgeryAndBurns;
	}

	public void open()
	{
		PlasticSurgeryAndBurnsVo  voPlasticSurgeryAndBurns = domain.getPlasticSurgeryAndBurnsVo(form.getGlobalContext().Core.getCurrentCareContext());

		form.getLocalContext().setSelectedRecord(voPlasticSurgeryAndBurns);
		populateScreenFromData(voPlasticSurgeryAndBurns);
		
		manageReadOnly();
	}

	private void populateScreenFromData(PlasticSurgeryAndBurnsVo voPlasticSurgeryAndBurns)
	{
		clearInstanceControls();
		
		if (voPlasticSurgeryAndBurns == null)
			return;
		
		
		form.cmbAnaesthetic().setValue(voPlasticSurgeryAndBurns.getAnaestheticType());
		if(voPlasticSurgeryAndBurns.getSkinForStorageIsNotNull() && voPlasticSurgeryAndBurns.getSkinForStorage().equals(YesNo.YES))
			form.Group1().setValue(GenForm.Group1Enumeration.rdoSkinForStorageYes);
		else if(voPlasticSurgeryAndBurns.getSkinForStorageIsNotNull() && voPlasticSurgeryAndBurns.getSkinForStorage().equals(YesNo.NO))
			form.Group1().setValue(GenForm.Group1Enumeration.rdoSkinForStorageNo);
		form.dteFirstdressing().setValue(voPlasticSurgeryAndBurns.getScheduledFirstDressingDate());
		form.dteSutureremoval().setValue(voPlasticSurgeryAndBurns.getScheduledSutureRemoval());
		form.qmbSurgeon().newRow(voPlasticSurgeryAndBurns.getSurgeon(), voPlasticSurgeryAndBurns.getSurgeon().getIMosName());
		form.qmbSurgeon().setValue(voPlasticSurgeryAndBurns.getSurgeon());
		form.chkComplete().setValue(voPlasticSurgeryAndBurns.getIsComplete());
			
	}
	
	public void initializeComponent()
	{
		form.getLocalContext().setbInitialised(null);
		form.getLocalContext().setisReadonly(false);
	}
	
	public void clearInstanceControls()
	{
		form.cmbAnaesthetic().setValue(null);
		form.Group1().setValue(null);
		form.dteFirstdressing().setValue(null);
		form.dteSutureremoval().setValue(null);
		form.qmbSurgeon().clear();
		form.chkComplete().setValue(null);
	}
	

	public void setReadOnly() 
	{
		form.setMode(FormMode.VIEW);
		form.btnEdit().setEnabled(false);
	}

	private void manageReadOnly() 
	{
		if (form.getMode().equals(FormMode.VIEW))
			form.btnEdit().setVisible(true);

		if (form.getLocalContext().getisReadonlyIsNotNull()
			&& form.getLocalContext().getisReadonly()
			&& form.getMode().equals(FormMode.VIEW))
			form.btnEdit().setVisible(false);
	}
	public PlasticSurgeryAndBurnsVo getValue() {
		return form.getLocalContext().getSelectedRecord();
	}
	public void setValue(PlasticSurgeryAndBurnsVo voPlasticSurgeryAndBurns) {
		form.getLocalContext().setSelectedRecord(voPlasticSurgeryAndBurns);
	}
	@Override
	protected void onQmbSurgeonTextSubmited(String value) throws PresentationLogicException {
		if (value != null)
		{
			HcpFilter voHCPFilter = new HcpFilter();
			PersonName name = new PersonName();
			name.setSurname(value);
			voHCPFilter.setQueryName(name);
			voHCPFilter.setHcpType(HcpDisType.MEDICAL);
			
			HcpLiteVoCollection voColl = domain.listHCPs(voHCPFilter);

			voColl.sort();
			form.qmbSurgeon().clear();
			for (int i = 0; i < voColl.size(); i++)
			{
				form.qmbSurgeon().newRow(voColl.get(i), voColl.get(i).getIHcpName());
			}
			if (voColl.size() == 1)
				form.qmbSurgeon().setValue(voColl.get(0));
			else if (voColl.size() > 1)
				form.qmbSurgeon().showOpened();
		}		
	}
	public void clearLastEvent() {
		form.getLocalContext().setLastEvent(null);		
	}
	public EDischargeLastEvent getLastEvent()
	{
		return form.getLocalContext().getLastEvent();
	}
	@Override
	protected void onFormModeChanged() {
		updateControlState();		
	}
	private void updateControlState() {
		// TODO Auto-generated method stub
		
	}
}

