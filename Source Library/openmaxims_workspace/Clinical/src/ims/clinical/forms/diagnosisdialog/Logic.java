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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.65 build 3187.17423)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.diagnosisdialog;


import java.util.ArrayList;

import ims.clinical.forms.diagnosisdialog.GenForm.GroupSelectionEnumeration;
import ims.clinical.vo.PatientDiagnosisStatusVo;
import ims.clinical.vo.PatientDiagnosisStatusVoCollection;
import ims.clinicaladmin.vo.DiagnosisHotlistItemVo;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.CSPrimaryDiagnosisShortVo;
import ims.core.vo.CSPrimaryDiagnosisShortVoCollection;
import ims.core.vo.DiagLiteVo;
import ims.core.vo.DiagnosisVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientDiagnosisAtConsultationVo;
import ims.core.vo.PatientDiagnosisAtConsultationVoCollection;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.core.vo.lookups.DiagnosisDivisions;
import ims.core.vo.lookups.SourceofInformation;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.IItem;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.vo.ValueObject;
import ims.vo.ValueObjectCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
	}
	
	private void initialize(Object[] args)
	{
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof Boolean)
			{
				form.getLocalContext().setAddedDuringCoding(Boolean.TRUE);
			}
		}
		
		if(args != null && args.length > 1 && args[1] instanceof Boolean) //WDEV-21039
		{
			form.getLocalContext().setIncludeExcludedKeywords((Boolean) args[1]);	
		}
		
		initializeCustomControl();
		
		if (form.getGlobalContext().Core.getPatientDiagnosisAtConsultation()!=null)
		{
			populateScreenFromData( form.getGlobalContext().Core.getPatientDiagnosisAtConsultation());
		}
		else
		{
			AuthoringInformationVo voAuthoringInformation=new AuthoringInformationVo();
			voAuthoringInformation.setAuthoringDateTime(new DateTime());
			if (domain.getHcpLiteUser()!=null)
				voAuthoringInformation.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
			form.ccAuthoringInfo().setValue(voAuthoringInformation);
		}

		if (form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList()==null)
		{
			PatientDiagnosisAtConsultationVoCollection diagnosisCollection=new PatientDiagnosisAtConsultationVoCollection();
			form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(diagnosisCollection);
		}

		if (domain.getHcpLiteUser() == null)
		{
			form.chkMain().setEnabled(false);
			form.cmbStatus().setEnabled(false);
			form.qmbDiagnosis().setEnabled(false);
			form.setccAuthoringInfoEnabled(false);

			if (engine.hasRight(AppRight.ALLOW_EDIT_CONSULTATION_DIAGNOSIS))
			{
				form.qmbDiagnosis().setEnabled(false);
			}
		}
		
		if (form.getGlobalContext().Clinical.getDisableMainCheckboxIsNotNull() && form.getGlobalContext().Clinical.getDisableMainCheckbox())
		{
			form.chkMain().setEnabled(false);
		}
		
		//WDEV-19454
		form.chkSpecialtyHotlist().setVisible(!ConfigFlag.UI.SHOW_DIAGNOSES_DATABASE.getValue());
		form.GroupSelection().setVisible(ConfigFlag.UI.SHOW_DIAGNOSES_DATABASE.getValue());
		form.getLocalContext().setSearchBySpecialtyHotlist(true);
		if (ConfigFlag.UI.SHOW_DIAGNOSES_DATABASE.getValue())
		{
			form.GroupSelection().setValue(GroupSelectionEnumeration.rdoDiagSpec);//WDEV-19056
		}
		else
		{
			form.chkSpecialtyHotlist().setValue(true);
		}
		
		form.qmbDiagnosis().enableLiveSearch(ConfigFlag.UI.DIAGNOSIS_SEARCHING_MECHANISM.getValue().equals("Live")); //WDEV-22287
		
	}
	
	private void populateScreenFromData(PatientDiagnosisAtConsultationVo patDiagnosis)
	{
		if (patDiagnosis.getAuthoringInfoIsNotNull())
			form.ccAuthoringInfo().setValue(patDiagnosis.getAuthoringInfo());

		form.getLocalContext().setDiagnosisDescription(patDiagnosis.getDiagnosisDescription());
		
		if(patDiagnosis.getDiagnosis() != null)
		{
			form.qmbDiagnosis().newRow(patDiagnosis.getDiagnosis(), patDiagnosis.getDiagnosisDescription());
			form.qmbDiagnosis().setValue(patDiagnosis.getDiagnosis());
		}
		else
		{
			DiagLiteVo d = new DiagLiteVo();
			d.setDiagnosisName(patDiagnosis.getDiagnosisDescription());
			form.qmbDiagnosis().newRow(d, d.getDiagnosisName());
			form.qmbDiagnosis().setValue(d);
		}

		form.qmbDiagnosis().setEnabled(true);
		
		CSPrimaryDiagnosisShortVoCollection voColl = patDiagnosis.getPrimaryForCareSpells();
		form.chkMain().setValue(false);
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			if (voColl.get(i).getCareContextIsNotNull() 
					&& voColl.get(i).getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()) && Boolean.TRUE.equals(voColl.get(i).getIsActive()))//WDEV-17356
				form.chkMain().setValue(true);
		}

		if (patDiagnosis.getCurrentStatusIsNotNull())
			if (patDiagnosis.getCurrentStatus().getStatusIsNotNull())
				form.cmbStatus().setValue(patDiagnosis.getCurrentStatus().getStatus());

		form.cmbLaterality().setValue(patDiagnosis.getDiagLateralityIsNotNull() ? patDiagnosis.getDiagLaterality() : null);//WDEV-19056
		
		form.ccAuthoringInfo().setMode(FormMode.VIEW);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PatientDiagnosisAtConsultationVo diagnosisVo = populateDataFromScreen();
		
		String[] errs = validateUI();//WDEV-22906
		String[] errors = diagnosisVo.validate(errs);
		boolean equals=false;
		
		if(form.getGlobalContext().Core.getCurrentCareContext() != null)
		{
			form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(domain.listPatientDiagnosis(form.getGlobalContext().Core.getCurrentCareContext()));
		}

		if (errors == null)
		{
			for (int i=0;i<form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList().size();i++)
			{
				PatientDiagnosisAtConsultationVo patDiagnosis = form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList().get(i);
				if (diagnosisVo != null
						&& patDiagnosis != null)
				{
					//If they are the same PatientDiagnosis
					if (diagnosisVo.getID_PatientDiagnosisIsNotNull()&&patDiagnosis.getID_PatientDiagnosisIsNotNull()&&diagnosisVo.getID_PatientDiagnosis().equals(patDiagnosis.getID_PatientDiagnosis())
							||
							(
								diagnosisVo.getDiagnosisIsNotNull() && patDiagnosis.getDiagnosisIsNotNull()
								&& (diagnosisVo.getDiagnosis().getID_DiagnosisIsNotNull()&& patDiagnosis.getDiagnosis().getID_DiagnosisIsNotNull())
								&& (diagnosisVo.getDiagnosis().getID_Diagnosis().equals(patDiagnosis.getDiagnosis().getID_Diagnosis())||(patDiagnosis.getDiagnosis().getID_Diagnosis()==-1&&diagnosisVo.getDiagnosis().getID_DiagnosisIsNotNull()))
								&& (diagnosisVo.getAuthoringInfoIsNotNull()&& patDiagnosis.getAuthoringInfoIsNotNull())
								&& (diagnosisVo.getAuthoringInfo().getAuthoringDateTimeIsNotNull()&&patDiagnosis.getAuthoringInfo().getAuthoringDateTimeIsNotNull()&&diagnosisVo.getAuthoringInfo().getAuthoringDateTime().equals(patDiagnosis.getAuthoringInfo().getAuthoringDateTime()))
								&& (diagnosisVo.getAuthoringInfo().getAuthoringHcpIsNotNull()&&patDiagnosis.getAuthoringInfo().getAuthoringHcpIsNotNull()&&diagnosisVo.getAuthoringInfo().getAuthoringHcp().equals(patDiagnosis.getAuthoringInfo().getAuthoringHcp()))))

					{			
						PatientDiagnosisAtConsultationVoCollection diagnosises= form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList();
						diagnosises.remove(i);
						diagnosises.add(i,diagnosisVo);
						equals=true;

						form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(diagnosises);
					}
				}
				if (!equals)
				{
					PatientDiagnosisAtConsultationVoCollection listDiag = form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList();//.add(diagnosisVo);
					listDiag.add(diagnosisVo);
					form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(listDiag);
				}
			}
			if (form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList().size()==0)
			{
				PatientDiagnosisAtConsultationVoCollection listDiag = new PatientDiagnosisAtConsultationVoCollection();
				listDiag.add(diagnosisVo);
				form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(listDiag);
			}
			
			clearPreviousPrimaryDiagnosis(diagnosisVo);
			
			engine.close(DialogResult.OK);
		}
		else
			engine.showErrors(errors);
	}


	private String[] validateUI()
	{
		ArrayList<String> errs = new ArrayList<String>();
		
		if(form.cmbStatus().getValue() == null)
			errs.add("Status is mandatory");
		
		return errs.toArray(new String[errs.size()]);
	}
	
	private void clearPreviousPrimaryDiagnosis(PatientDiagnosisAtConsultationVo diagnosisVo) 
	{
		if(diagnosisVo == null)
			return;
		
		if(form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList() == null || form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList().size() == 0)
			return;
		
		if(!form.chkMain().getValue())
			return;
		
		for(PatientDiagnosisAtConsultationVo diag : form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList())	
		{
			if(diag == null || diag.equals(diagnosisVo))
				continue;
			
			CSPrimaryDiagnosisShortVoCollection primaryColl = diag.getPrimaryForCareSpells();
			
			if(primaryColl == null || primaryColl.size() == 0)
				continue;
				
			for(CSPrimaryDiagnosisShortVo primary : primaryColl)
			{
				if(primary == null)
					continue;
				
				if(primary.getCareContextIsNotNull() && primary.getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()))
				{
					primaryColl.remove(primary);
					diag.setPrimaryForCareSpells(primaryColl);
					break;
				}
			}
		}
	}

	private PatientDiagnosisAtConsultationVo populateDataFromScreen()
	{
		PatientDiagnosisAtConsultationVo record;
		if (form.getGlobalContext().Core.getPatientDiagnosisAtConsultation() == null)
		{
			record = new PatientDiagnosisAtConsultationVo();
			
			if(Boolean.TRUE.equals(form.getLocalContext().getAddedDuringCoding()))
			{
				record.setAddedDuringCoding(true);
			}
		}
		else
		{
			record = (PatientDiagnosisAtConsultationVo) form.getGlobalContext().Core.getPatientDiagnosisAtConsultation().clone();
		}
			
		record.setDiagnosis((DiagLiteVo) form.qmbDiagnosis().getValue()); //WDEV-19056
		record.setDiagnosisDescription(form.getLocalContext().getDiagnosisDescription());
		
		if (!record.getID_PatientDiagnosisIsNotNull())
		{
			record.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
			record.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			record.setAuthoringInfo(form.ccAuthoringInfo().getValue());
			record.setDiagnosedDate(new PartialDate());
			record.setSourceofInformation(SourceofInformation.CLINICALCONTACT);
			
			if ((form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()) && (form.getGlobalContext().Core.getCurrentClinicalContact().getSpecialtyIsNotNull()))
			{
				record.setSpecialty(form.getGlobalContext().Core.getCurrentClinicalContact().getSpecialty());
			}
			else if ((form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull()) && (form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialtyIsNotNull()))
			{
				record.setSpecialty(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
			}
		}
			
		/*PatientDiagnosisStatusVo status = record.getCurrentStatus();
		if(status == null)
		{
			status = new PatientDiagnosisStatusVo();
			status.setAuthoringHCP(record.getAuthoringInfoIsNotNull()?record.getAuthoringInfo().getAuthoringHcp():null);
			status.setAuthoringDateTime(record.getAuthoringInfoIsNotNull()?record.getAuthoringInfo().getAuthoringDateTime():null);
		}
		status.setStatus(form.cmbStatus().getValue());
		
		record.setCurrentStatus(status);*/
		//wdev-17358
		if( form.cmbStatus().getValue() != null )
		{
			PatientDiagnosisStatusVoCollection voColl = record.getStatusHistory();
			if (voColl == null)
				voColl = new PatientDiagnosisStatusVoCollection();
			
			PatientDiagnosisStatusVo status = new PatientDiagnosisStatusVo();
			status.setAuthoringHCP(record.getAuthoringInfoIsNotNull()?record.getAuthoringInfo().getAuthoringHcp():null);
			status.setAuthoringDateTime(record.getAuthoringInfoIsNotNull()?record.getAuthoringInfo().getAuthoringDateTime():null);
			status.setStatus(form.cmbStatus().getValue());
			
			if (record.getCurrentStatus() == null)
			{
				
				voColl.add(status);
				record.setStatusHistory(voColl);
				record.setCurrentStatus(status);
			}
			else
			{
				if (record.getCurrentStatus().getStatusIsNotNull() && record.getCurrentStatus().getStatus().getId() != form.cmbStatus().getValue().getId())
				{
					
					voColl.add(status);
					record.setStatusHistory(voColl);
					record.setCurrentStatus(status);
				}
			}
		}

		//---------------
		

		CSPrimaryDiagnosisShortVoCollection voColl = null;
		if (record.getPrimaryForCareSpells() == null)
			voColl = new CSPrimaryDiagnosisShortVoCollection();
		else
			voColl = record.getPrimaryForCareSpells();

		if (form.chkMain().getValue())
		{
			boolean bFound = false;
			for (int i = 0 ; i < voColl.size() ; i++)
			{
				if (voColl.get(i).getCareContextIsNotNull() 
						&& voColl.get(i).getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()) && Boolean.TRUE.equals(voColl.get(i).getIsActive()))//WDEV-17356
					bFound = true;
			}

			if ( ! bFound)
			{
				CSPrimaryDiagnosisShortVo voCPD = new CSPrimaryDiagnosisShortVo();
				// WDEV-11543
				voCPD.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
				voCPD.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
				voCPD.setDiagnosis(record);
				voCPD.setIsActive(Boolean.TRUE);
				voColl.add(voCPD);

				record.setPrimaryForCareSpells(voColl);
			}
		}
		else if ( ! form.chkMain().getValue() && voColl.size() > 0)
		{
			for (int i = 0 ; i < voColl.size() ; i++)
			{
				if (voColl.get(i).getCareContextIsNotNull() 
						&& voColl.get(i).getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()) )
					voColl.remove(i);
			}
			record.setPrimaryForCareSpells(voColl);
		}
		
		record.setDiagLaterality(form.cmbLaterality().getValue() != null ? form.cmbLaterality().getValue():null); //WDEV-19056
		return record;
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private void initializeCustomControl()
	{
		form.ccAuthoringInfo().initializeComponent();
	}
	
	@Override
	protected void onQmbDiagnosisValueChanged()	throws PresentationLogicException 
	{
		form.getLocalContext().setDiagnosisDescription(form.qmbDiagnosis().getValue() != null ? getDiagnosis(form.qmbDiagnosis().getValue()).getDiagnosisName() : null);
	}
	
	//WDEV-19056
	private DiagLiteVo getDiagnosis(ValueObject voItem) 
	{
		DiagLiteVo voDiagnosis = null;
		
		if (voItem instanceof DiagnosisHotlistItemVo)
		{
			DiagnosisHotlistItemVo hotlistItem = (DiagnosisHotlistItemVo)voItem;
			voDiagnosis = hotlistItem.getDiagnosis();			
		}	
		else if (voItem instanceof DiagLiteVo)
		{
			voDiagnosis = ((DiagLiteVo)voItem);
		}
		else if (voItem instanceof TaxonomyMap)
		{
			form.getGlobalContext().Core.setTaxonomyMap((TaxonomyMap) voItem);
			taxonomySearchOK();
			voDiagnosis = (DiagLiteVo) form.qmbDiagnosis().getValue();
		}

		return voDiagnosis;
	}

	//WDEV=19056
	private void taxonomySearchOK() 
	{
		TaxonomyMap taxonomyMap = form.getGlobalContext().Core.getTaxonomyMap();
		if (taxonomyMap != null)
		{
			TaxonomyMapCollection collTaxonomyMap = new TaxonomyMapCollection();
			collTaxonomyMap.add(taxonomyMap);				
			newDiagnosis(taxonomyMap);
		}

		form.qmbDiagnosis().setEnabled(false);
		
	}
	
	//WDEV-19056
	private void newDiagnosis(TaxonomyMap taxonomyMap )	
	{
		DiagnosisVo voDiagnosis = new DiagnosisVo();
		voDiagnosis.setDiagnosisName(taxonomyMap.getDescription());		
		voDiagnosis.setTaxonomyMap(new TaxonomyMapCollection());
		voDiagnosis.getTaxonomyMap().add(taxonomyMap);
		voDiagnosis.setIsActive(Boolean.TRUE);

		String[] errors = voDiagnosis.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}

		try
		{
			voDiagnosis = domain.saveDiagnosisVo(voDiagnosis);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			voDiagnosis = domain.getDiagnosisByName(voDiagnosis.getDiagnosisName());
		}
			

		if (voDiagnosis != null && voDiagnosis.getID_Diagnosis() != null)
		{
			form.qmbDiagnosis().clear();
			form.qmbDiagnosis().newRow(voDiagnosis, voDiagnosis.getDiagnosisName());
			form.qmbDiagnosis().setValue(voDiagnosis);		
		}
	}
	
	@Override
	protected void onQmbDiagnosisTextSubmited(String value)	throws PresentationLogicException 
	{
		form.qmbDiagnosis().clear();
		ValueObjectCollection voCollDiag = listDiagnosis(value); //WDEV-19056
		
		if (voCollDiag == null || voCollDiag.size() == 0)
		{
			form.qmbDiagnosis().showOpened();
			return;
		}
		
		//WDEV-19056
		if (voCollDiag != null && voCollDiag.getItems() != null)
		{
			IItem[] items = voCollDiag.getItems();
			for (int i=0; i < items.length; i++)
			{
				Object item = items[i];
				if (item == null) 
					continue;
				
				addRowToDiagmosisCombo(item);
				
			}
		}
			
		form.qmbDiagnosis().showOpened();
	}

	//WDEV-19056
	private void addRowToDiagmosisCombo(Object item)
	{
		if (item instanceof DiagLiteVo)
		{
			DiagLiteVo diag=(DiagLiteVo)item;
			form.qmbDiagnosis().newRow(diag,diag.getDiagnosisName());
		}
		else if (item instanceof TaxonomyMap)
		{
			TaxonomyMap voCIE = (TaxonomyMap)item;
			form.qmbDiagnosis().newRow(voCIE, voCIE.getDescription());
		}
	}

	//WDEV-19056
	private ValueObjectCollection listDiagnosis(String value)
	{
		ValueObjectCollection voCollDiag = null;
		boolean bHotlist = form.getLocalContext().getSearchBySpecialtyHotlistIsNotNull() ? form.getLocalContext().getSearchBySpecialtyHotlist().booleanValue() : false;
		
		boolean divisionSelected = form.getLocalContext().getDiagnosisDivision() == null ? false : true;
		
		boolean includeExcludedKeywords=form.getLocalContext().getIncludeExcludedKeywords()==null || Boolean.TRUE.equals(form.getLocalContext().getIncludeExcludedKeywords()) ? true : false; //WDEV-21039 //WDEV-22287
		
		try
		{
    		if (bHotlist)
    		{
    				voCollDiag = domain.listHotListDiagnosis(value, getSpecialty(),includeExcludedKeywords).sort(); //WDEV-21039
    		}
    		else if (divisionSelected)
    		{
    			voCollDiag = domain.listDivisionDiagnoses(value, form.getLocalContext().getDiagnosisDivision(), includeExcludedKeywords).sort(); //WDEV-22287
    		}
    		else if (Boolean.TRUE.equals(form.getLocalContext().getSearchDiagnosesDatabase()))
    		{
    				TaxonomyMap filter = new TaxonomyMap();
    				filter.setTaxonomyName(getTaxonomyLookupByName(ConfigFlag.GEN.EDISCHARGE_DIAGNOSIS_SEARCH_TAXONOMY_TYPE.getValue()));
    				filter.setDescription(value);
    				voCollDiag = domain.searchCodes(filter);
    		}
    		else
    			    voCollDiag =domain.listDianosis(value, null);
    				//voCollDiag = domain.listDiagnosisLiteVo(value).sort(); 
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return null;
		}		
		
		return voCollDiag;
	}
	
	//WDEV-19056
	private Specialty getSpecialty()
	{
		if ((form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()) && (form.getGlobalContext().Core.getCurrentClinicalContact().getSpecialtyIsNotNull()))
		{
			return form.getGlobalContext().Core.getCurrentClinicalContact().getSpecialty();
		}
		else if ((form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull()) && (form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialtyIsNotNull()))
		{
			return form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty();
		}
		return null;
	}
	
	//WDEV-19056
	private TaxonomyType getTaxonomyLookupByName(String name)
	{
		if (TaxonomyType.READ3.getText().toUpperCase().equals(name.toUpperCase()))
		{
			return TaxonomyType.READ3;
		}
		else if (TaxonomyType.SNOMED.getText().toUpperCase().equals(name.toUpperCase()))
		{
			return TaxonomyType.SNOMED;
		}
		else if (TaxonomyType.ICD10.getText().equals(name))
		{
			return TaxonomyType.ICD10;
		}	
		else if (TaxonomyType.NAT_SPEC_CODE.getText().equals(name.trim()))
		{
			return TaxonomyType.NAT_SPEC_CODE;
		}
		else if (TaxonomyType.NAT_TREAT_CODE.getText().equals(name.trim()))
		{
			return TaxonomyType.NAT_TREAT_CODE;
		}
		else if (TaxonomyType.OPCS4.getText().equals(name))
		{
			return TaxonomyType.OPCS4;
		}	
		else if (TaxonomyType.VTM.getText().equals(name))
		{
			return TaxonomyType.VTM;
		}
		else if (TaxonomyType.VMP.getText().equals(name))
		{
			return TaxonomyType.VMP;
		}	
		else if (TaxonomyType.AMP.getText().equals(name))
		{
			return TaxonomyType.AMP;
		}
		
		return null;
	}

	//WDEV-19056
	@Override
	protected void onRadioButtonGroupSelectionValueChanged() throws PresentationLogicException
	{
		form.cmbDivision().setValue(null);
		form.getLocalContext().setSearchBySpecialtyHotlist(form.GroupSelection().getValue().equals(GroupSelectionEnumeration.rdoDiagSpec));
		setDivisionOrDiagnosesDatabase(form.cmbDivision().getValue(), form.GroupSelection().getValue().equals(GroupSelectionEnumeration.rdoDiagDatabase));
	}

	//WDEV-19056
	private void setDivisionOrDiagnosesDatabase(DiagnosisDivisions division, boolean searchDiagnosesDatabase)
	{
		form.getLocalContext().setSearchDiagnosesDatabase(searchDiagnosesDatabase);
		form.getLocalContext().setDiagnosisDivision(division);
		
		if (division != null || Boolean.TRUE.equals(searchDiagnosesDatabase))
			form.getLocalContext().setSearchBySpecialtyHotlist(false);
	}

	//WDEV-19056
	@Override
	protected void onCmbDivisionValueChanged() throws PresentationLogicException
	{
		form.GroupSelection().setValue(null);
		form.chkSpecialtyHotlist().setValue(false);//WDEV-19454
		setDivisionOrDiagnosesDatabase(form.cmbDivision().getValue(), false);	
	}

	//WDEV-19454
	@Override
	protected void onChkSpecialtyHotlistValueChanged() throws PresentationLogicException
	{
		form.cmbDivision().setValue(null);
		form.getLocalContext().setSearchBySpecialtyHotlist(Boolean.TRUE.equals(form.chkSpecialtyHotlist().getValue()));
		form.getLocalContext().setDiagnosisDivision(null);
	}

	
	
	
}
