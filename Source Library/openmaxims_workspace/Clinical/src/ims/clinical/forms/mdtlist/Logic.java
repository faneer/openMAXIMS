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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.42 build 2221.27776)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.mdtlist;

import ims.clinical.vo.MDTListAndDatesVo;
import ims.clinical.vo.MDTListAndDatesVoCollection;
import ims.clinical.vo.lookups.MDTListAorB;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CareContextVo;
import ims.core.vo.PatientId;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.ContextType;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		if (form.getGlobalContext().Core.getCurrentMDTListShownIsNotNull()) //WDEV-19389 
		{
			setSearchCriteria(form.getGlobalContext().Core.getCurrentMDTListShown());
			search();
		}
	}


	private void setSearchCriteria(MDTListAorB currentMDTListShown)
	{
		form.cmbMDTList().setValue(currentMDTListShown);		
	}


	private void initialize()
	{
		if (engine.getPreviousNonDialogFormName().equals(form.getForms().Clinical.MDTNotes))
		{
			if (form.getGlobalContext().Core.getCurrentMDTListShown() != null)
			{
				form.cmbMDTList().setValue(form.getGlobalContext().Core.getCurrentMDTListShown());
				search();
			}
		}
		
		form.imbSearch().setEnabled(true);
	}

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
		form.getGlobalContext().Core.setCurrentMDTListShown(null);//WDEV-19389 
	}

	private void clear()
	{
		form.cmbMDTList().setValue(null);
		form.grdPatients().getRows().clear();
		form.grdPatients().setValue(null);
	}

	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	private void populateListControl(MDTListAndDatesVoCollection mdtColl)
	{
		form.grdPatients().getRows().clear();
		if (mdtColl != null)
		{
			GenForm.grdPatientsRow row = null;
			MDTListAndDatesVo mdt = null;
			for (int i = 0; i < mdtColl.size(); i++)
			{
				mdt = mdtColl.get(i);
				row = form.grdPatients().getRows().newRow();

				if (mdt.getPatientIsNotNull())
				{
					if (mdt.getPatient().getNameIsNotNull())
					{
						row.setcolForename(mdt.getPatient().getName().getForename());
						row.setcolSurname(mdt.getPatient().getName().getSurname());
					}

					PatientId voPatId = mdt.getPatient().getDisplayId();
					if (voPatId != null)
						row.setcolHospnum(voPatId.getValue());

					row.setcolDob(mdt.getPatient().getDobIsNotNull() ? mdt.getPatient().getDob().toString() : null);
					row.setColAge(mdt.getPatient().getDobIsNotNull() ? mdt.getPatient().calculateAge().toString() : null);

					if (mdt.getPatient().getSex() != null)
						row.setcolSex(mdt.getPatient().getSex().getText());

					if (mdt.getPatient().getIsDead() != null && mdt.getPatient().getIsDead().booleanValue())
						row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());
				}
				row.setValue(mdt);
			}

			form.lblTotal().setValue("Total : " + new Integer(mdtColl.size()).toString());
			
			if (mdtColl.size() == 0)
				engine.showMessage("No matching patients found.");
		}
	}

	private void search()
	{
		if (form.cmbMDTList().getValue() == null)
		{
			engine.showMessage("Valid search criteria must be specified - Please select a List");
			return;
		}

		form.getGlobalContext().Core.setCurrentMDTListShown(form.cmbMDTList().getValue());

		MDTListAndDatesVo voMdtListFilter = new MDTListAndDatesVo();
		MDTListAndDatesVoCollection mdtColl = null;

		voMdtListFilter.setCareContext(new CareContextVo());
		voMdtListFilter.getCareContext().setContext(ContextType.INPATIENT);

		voMdtListFilter.setListPatientisOn(form.cmbMDTList().getValue());

		if ((form.cmbMDTList().getValue() != null) && (form.cmbMDTList().getValue().equals(MDTListAorB.NOTONANYLISTYET)))
			mdtColl = domain.listCareContextsWithNoMDTList(voMdtListFilter);
		else if (form.cmbMDTList().getValue() != null)
			mdtColl = domain.listMDT(voMdtListFilter);

		populateListControl(mdtColl);
	}

	protected void onGrdPatientsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		PatientShort ps = form.grdPatients().getValue().getPatient();
		form.getGlobalContext().Core.setPatientShort(ps);
			
		setPatientInfoBar(ps);
		engine.addPatientSelectionToHistory(ps);		//wdev-12104
		form.getGlobalContext().Core.setCurrentCareContext(form.grdPatients().getValue().getCareContext());

		if (form.grdPatients().getValue().getID_MDTListandDatesIsNotNull())
			form.getGlobalContext().Clinical.setCurrentMDTListAndDates(form.grdPatients().getValue());
		else
			form.getGlobalContext().Clinical.setCurrentMDTListAndDates(null);

		engine.open(form.getForms().Clinical.MDTNotes);
	}

	private void setPatientInfoBar(PatientShort ps)
	{
		if (ps.getIsDead() != null && ps.getIsDead().booleanValue())
		{
			engine.setPatientInfo(ps.getPatientInfo(), ims.configuration.gen.ConfigFlag.UI.RIP_INFO_COLOUR.getValue());
		}
		else
		{
			engine.setPatientInfo(ps.getPatientInfo());
		}
	}

	protected void onCmbMDTListValueChanged() throws PresentationLogicException
	{
		form.grdPatients().getRows().clear();
		form.grdPatients().setValue(null);
		form.lblTotal().setValue("");
	}
}
