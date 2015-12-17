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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41124.1200)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.nurassessmentmobility;

import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.Transfers;
import ims.nursing.vo.TransfersCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.nursing.vo.lookups.LookupHelper;
import ims.nursing.vo.lookups.MobilityStatus;
import ims.nursing.vo.lookups.MobilityStatusCollection;
import ims.spinalinjuries.vo.NurAssessmentMobilityVo;
import ims.spinalinjuries.vo.lookups.Orthoses;
import ims.spinalinjuries.vo.lookups.OrthosesCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}

	private void open() 
	{
		//If there is an assessment in the global context, we want to call the get component
		// domain method
		// Otherwise, it is a new assessment component
		if(form.getGlobalContext().Core.getAssessmentIsReadOnly() == null || form.getGlobalContext().Core.getAssessmentIsReadOnly() == false )
			form.setMode(FormMode.EDIT);
		else
			form.setMode(FormMode.VIEW);
		form.chkCopy().setEnabled(false);
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setAssessment(assmnt);	
		NurAssessmentMobilityVo voMobility =null;

		if (assmnt != null && assmnt.getCurrentComponent() != null)
		{		
			voMobility = (NurAssessmentMobilityVo)domain.getComponent(assmnt.getCurrentComponent());
			form.getLocalContext().setAssessMobility(voMobility);
		}
		
		//Mobility Grid
		MobilityStatusCollection mColl = LookupHelper.getMobilityStatus(domain.getLookupService());
		form.grdMobilityStatus().getRows().clear();
		if(mColl != null)
		{
			GenForm.grdMobilityStatusRow row = null;
			
			for(int i=0;i<mColl.size();i++)
			{
				row = form.grdMobilityStatus().getRows().newRow();
				row.setColMobilityStatus(mColl.get(i).getText());
				row.setValue(mColl.get(i));
			}
		}
		
		//Transfers Grid
		ims.nursing.vo.lookups.TransfersCollection tColl = LookupHelper.getTransfers(domain.getLookupService());
		form.grdTransfers().getRows().clear();
		if(tColl != null)
		{
			GenForm.grdTransfersRow row = null;
			
			for(int i=0;i<tColl.size();i++)
			{
				row = form.grdTransfers().getRows().newRow();
				row.setColTransfers(tColl.get(i).getText());
				row.setValue(tColl.get(i));
			}
		}
		
		//Orthoses Grid
		OrthosesCollection oColl = ims.spinalinjuries.vo.lookups.LookupHelper.getOrthoses(domain.getLookupService());
		form.grdOrthoses().getRows().clear();
		if(oColl != null)
		{
			GenForm.grdOrthosesRow row = null;
			
			for(int i=0;i<oColl.size();i++)
			{
				row = form.grdOrthoses().getRows().newRow();
				row.setColOrthosesUsed(oColl.get(i).getText());
				row.setValue(oColl.get(i));
			}
		}
		
		//care plans
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.SPINAL_MOBILITY);
		if (tempColl != null)
		{
			form.grdCarePlan().getRows().clear();
			GenForm.grdCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.grdCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setcolCarePlans(template.getTitle());
			}
		}
		
		checkForPreviousAssessent();
		
		if(voMobility != null)
			populateScreenFromData(voMobility);
	}
	
	protected void checkForPreviousAssessent()
	{
		NurAssessmentMobilityVo assessAccMobility = (NurAssessmentMobilityVo) domain.getLastAssessmentComponentByCareContext(form.getGlobalContext().Core.getCurrentCareContext(), AssessmentComponentType.SPINAL_MOBILITY);
	
		if (assessAccMobility == null)
		{
			this.form.chkCopy().setValue(false);
			return;
		}
		
		form.getLocalContext().setPreviousAssMobility(assessAccMobility);
		if(form.getMode().equals(FormMode.EDIT))
			form.chkCopy().setEnabled(true);
	}


	private void populateScreenFromData(NurAssessmentMobilityVo voMobility) 
	{
		//Mobility Status
		MobilityStatusCollection sColl = voMobility.getMobilityStatus();
		if (sColl != null)
		{
			 GenForm.grdMobilityStatusRow rowStatus;
			 for (int j=0; j<sColl.size(); j++)
			 {
				 MobilityStatus status = sColl.get(j);
				 int i=0;
				 for (i=0; i<form.grdMobilityStatus().getRows().size(); i++)
				 {
					 rowStatus = form.grdMobilityStatus().getRows().get(i);
					 if (rowStatus.getValue().equals(status))
					 {
						rowStatus.setColSelect(true);
						 break;
					 }
				 }
				 if(i == form.grdMobilityStatus().getRows().size())
				 {
					 rowStatus = form.grdMobilityStatus().getRows().newRow();
					 rowStatus.setValue(status);
					 rowStatus.setColMobilityStatus(status.getText());
					 rowStatus.setColSelect(true);
				 }
			 }
		}	
		
		form.cmbAidsUsed().setValue(voMobility.getMobilityAids());
		form.txtNotes().setValue(voMobility.getNotes());
		//Transfers Grid
		TransfersCollection voTransfersColl = voMobility.getTransfers();
		if (voTransfersColl != null)
		{
			GenForm.grdTransfersRow tRow = null;
			for (int j=0; j<voTransfersColl.size(); j++)
			{
				Transfers voTransfer = voTransfersColl.get(j);
				int i=0;
				for (i=0; i<form.grdTransfers().getRows().size(); i++)
				{
					tRow = form.grdTransfers().getRows().get(i);
					if (tRow.getValue().equals(voTransfer.getPatientTransfers()))
					{
						if(voTransfer.getPatientTransfers() != null)
							tRow.setColTransfers(voTransfer.getPatientTransfers().getText());
						
						if(voTransfer.getAssistanceRequired() != null)
							tRow.setColAssistance(voTransfer.getAssistanceRequired());
						break;
					}
				}
			}			
		}
		
		//Orthoses
		OrthosesCollection oColl = voMobility.getOrthosesUsed();
		if (oColl != null)
		{
			 GenForm.grdOrthosesRow rowOrth;
			 for (int j=0; j<oColl.size(); j++)
			 {
				 Orthoses orth = oColl.get(j);
				 int i=0;
				 for (i=0; i<form.grdOrthoses().getRows().size(); i++)
				 {
					 rowOrth = form.grdOrthoses().getRows().get(i);
					 if (rowOrth.getValue().equals(orth))
					 {
						 rowOrth.setColSelect(true);
						 break;
					 }
				 }
				 if(i == form.grdMobilityStatus().getRows().size())
				 {
					 rowOrth = form.grdOrthoses().getRows().newRow();
					 rowOrth.setValue(orth);
					 rowOrth.setColOrthosesUsed(orth.getText());
					 rowOrth.setColSelect(true);
				 }
			 }
		}	
				
		// CarePlans
		if (voMobility.getCarePlanTemplate() != null && voMobility.getCarePlanTemplate().size() > 0)
		{
			GenForm.grdCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = voMobility.getCarePlanTemplate();
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.grdCarePlan().getRows().size(); j++)
			{
				cpRow = form.grdCarePlan().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setcolSelect(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}	
		
		form.chkSectionComplete().setValue(voMobility.getIsComplete().booleanValue());
		
		if (voMobility.getIsComplete().booleanValue() == true)  // Complete
		{
			form.setMode(FormMode.VIEW);
			form.chkSectionComplete().setValue(true);
		}
		if (voMobility.getCopy().booleanValue() == true)
		{
			form.chkCopy().setValue(true);
		}
		form.chkCopy().setEnabled(false);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);	
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		NurAssessmentMobilityVo voMobility = form.getLocalContext().getAssessMobility();
		if (voMobility == null)
			voMobility = new NurAssessmentMobilityVo();
			
		//Mobility Status Grid
		MobilityStatusCollection mColl = new MobilityStatusCollection();	
		GenForm.grdMobilityStatusRow mRow = null;	
		for (int i=0; i<form.grdMobilityStatus().getRows().size(); i++)
		{
			mRow = form.grdMobilityStatus().getRows().get(i);
			if (mRow.getColSelect())
				mColl.add(mRow.getValue());
		}
		voMobility.setMobilityStatus(mColl);
		
		//Orthoses Grid	
		OrthosesCollection oColl = new OrthosesCollection();	
		GenForm.grdOrthosesRow oRow = null;	
		for (int i=0; i<form.grdOrthoses().getRows().size(); i++)
		{
			oRow = form.grdOrthoses().getRows().get(i);
			if (oRow.getColSelect())
				oColl.add(oRow.getValue());
		}
		voMobility.setOrthosesUsed(oColl);
		
		//Transfers
		Transfers transfer = null;
		TransfersCollection transferColl = new TransfersCollection();
		GenForm.grdTransfersRow tRow = null;
		for (int i=0; i<form.grdTransfers().getRows().size(); i++)
		{
			transfer = new Transfers();
			tRow = form.grdTransfers().getRows().get(i);
			transfer.setAssistanceRequired(tRow.getColAssistance());
			transfer.setPatientTransfers(tRow.getValue());
			transferColl.add(transfer);
		}
		voMobility.setTransfers(transferColl);
					
		voMobility.setMobilityAids(form.cmbAidsUsed().getValue());	
		voMobility.setIsComplete(new Boolean(form.chkSectionComplete().getValue()));
		voMobility.setCopy(new Boolean(form.chkCopy().getValue()));	
		voMobility.setNotes(form.txtNotes().getValue());
		
		//if AssessmentHeaderInfo id == null, check if in the meantime another user from another session has created a new assessment for selected care context
		if(form.getLocalContext().getAssessment() != null)
			if(form.getLocalContext().getAssessment().getID_Assessment() == null)
				if(form.getGlobalContext().Core.getCurrentCareContext() != null)
				{
					AssessmentHeaderInfo tempvo = domain.getAssessmentHeaderInfoByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					if(tempvo != null)
					{
						form.getLocalContext().setAssessment(tempvo);
						form.getGlobalContext().Nursing.setAssessmentHeaderInfo(form.getLocalContext().getAssessment());
					}
				}

		try
		{
			String[] messages = voMobility.validate();
			if (messages != null)
			{
				engine.showErrors("Validation Errors", messages);
				return;
			}
			AssessmentHeaderInfo newAssmnt = domain.saveComponent(form.getLocalContext().getAssessment(), voMobility);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// We may need to reset the current component value in GC for onFormOpen - if there was none previously
			if (e.getStaleObject() != null)
			{
				 AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
				 if (assmnt != null && assmnt.getCurrentComponent() == null)
				 {
					 ims.nursing.vo.AssessmentComponent comp = new ims.nursing.vo.AssessmentComponent();
					 comp.setID_AssessmentComponent(e.getStaleObject().getId());
					 assmnt.setCurrentComponent(comp);
					 form.getGlobalContext().Nursing.setAssessmentHeaderInfo(assmnt);
				 }
			}

			open();
			return;				
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			AssessmentHeaderInfo newAssmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
			AssessmentHeaderInfo assessheaderinfoVo = form.getLocalContext().getAssessment();	
			newAssmnt.setCurrentComponent( domain.getAssessComponent(assessheaderinfoVo.getID_Assessment(),AssessmentComponentType.SPINAL_MOBILITY));
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
			open();
			return;
		}
		
//		If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.grdCarePlan().getReadOnly() == false)
		{
			 CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
			 GenForm.grdCarePlanRow cpRow;
			 for (int i=0; i<form.grdCarePlan().getRows().size(); i++)
			 {
				 cpRow = form.grdCarePlan().getRows().get(i);
				 if (cpRow.getcolSelect() && !cpRow.isReadOnly())
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
	
	protected void onLnkInfoClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getAssessMobility() != null && form.getLocalContext().getAssessMobility().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getAssessMobility().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}	
	}
	
	protected void onChkCopyValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.getLocalContext().getPreviousAssMobilityIsNotNull())
		{
			NurAssessmentMobilityVo previousAssMobilityVo = new NurAssessmentMobilityVo();
			previousAssMobilityVo = form.getLocalContext().getPreviousAssMobility();
			form.chkCopy().setValue(true);
			form.chkCopy().setEnabled(false);
			previousAssMobilityVo.setIsComplete(Boolean.FALSE);
			previousAssMobilityVo.setCopy(Boolean.TRUE);
			previousAssMobilityVo.setCarePlanTemplate(null);
			populateScreenFromData(previousAssMobilityVo);
		}
		else
		{
			form.chkCopy().setValue(false);
			return;
		}	
		
		
		/*NurAssessmentMobilityVo voMobility = (NurAssessmentMobilityVo)domain.getLastAssessmentComponent(form.getGlobalContext().Core.getPatientShort(), form.getGlobalContext().Core.getCurrentClinicalContact(),AssessmentComponentType.SPINAL_MOBILITY);
		if (voMobility == null)
		{
			form.chkCopy().setValue(false);
			return;
		}
		voMobility.setIsComplete(Boolean.FALSE);
		voMobility.setCopy(Boolean.TRUE);

		form.chkCopy().setValue(true);
		form.chkCopy().setEnabled(false);	

		voMobility.setCarePlanTemplate(null);
		populateScreenFromData(voMobility);*/
	}
}
