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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.37 build 2120.20101)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.sleepassessment;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.VSMetrics;
import ims.core.vo.VSMetricsCollection;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.lookups.VSType;
import ims.core.vo.lookups.VSTypeCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.generalmedical.vo.CognitiveFunctionVo;
import ims.generalmedical.vo.CognitiveFunctionVoCollection;
import ims.generalmedical.vo.EpworthSleepAssessmentVo;
import ims.generalmedical.vo.EpworthSleepAssessmentVoCollection;
import ims.generalmedical.vo.SleepApnoeaVo;
import ims.generalmedical.vo.SleepApnoeaVoCollection;
import ims.generalmedical.vo.SleepFindingsVo;
import ims.generalmedical.vo.SleepFindingsVoCollection;
import ims.generalmedical.vo.SleepReferralVo;
import ims.spinalinjuries.forms.sleepassessment.GenForm;
import ims.spinalinjuries.forms.sleepassessment.GenForm.cntSleepingContainer.grdApnoeaRow;
import ims.spinalinjuries.forms.sleepassessment.GenForm.cntSleepingContainer.grdEpworthRow;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.SleepApnoeaFactors;
import ims.spinalinjuries.vo.lookups.SleepApnoeaFactorsCollection;
import ims.spinalinjuries.vo.lookups.SleepCognitiveFunction;
import ims.spinalinjuries.vo.lookups.SleepCognitiveFunctionCollection;
import ims.spinalinjuries.vo.lookups.SleepEpworthScore;
import ims.spinalinjuries.vo.lookups.SleepEpworthScoreCollection;
import ims.spinalinjuries.vo.lookups.SleepFindings;
import ims.spinalinjuries.vo.lookups.SleepFindingsCollection;
import ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.setMode(FormMode.VIEW);

		PatientShort voPatShort = form.getGlobalContext().Core.getPatientShort();
		if (voPatShort == null) 
			throw new FormOpenException("Error: Patient not selected.");

		form.getLocalContext().setSelectedCareContextShort(form.getGlobalContext().Core.getCurrentCareContext());
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(true);       //wdev-13189
		open();
	}

	private void open()
	{
		form.setMode(FormMode.VIEW);
		clearScreen();
		clearGrids();
		loadLookupsIntoGrid();

		fillRecordBrowser();		
		setRecordBrowser();		
	}

	private void fillRecordBrowser()
	{
		form.recbrSleepAssessment().clear();
		boolean boolGoldenInstanceFound=false;
		CareContextShortVoCollection voCollCareContexts = domain.listSleepCareContextsByEpisodeOfCare(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare()).sort();		
		if (voCollCareContexts != null)
		{
			for (int i=0; i < voCollCareContexts.size(); i++)
			{
				if(voCollCareContexts.get(i) != null)
				{
					if (voCollCareContexts.get(i).getID_CareContext().equals(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext()))
					{
						form.recbrSleepAssessment().newRow(voCollCareContexts.get(i),voCollCareContexts.get(i).getRecordBrowserText(), Color.Green);
						form.recbrSleepAssessment().setValue(voCollCareContexts.get(i));
						form.getLocalContext().setSelectedCareContextShort(voCollCareContexts.get(i));
						boolGoldenInstanceFound = true;
						browseRecord();												
					}
					else
					{
						form.recbrSleepAssessment().newRow(voCollCareContexts.get(i), voCollCareContexts.get(i).getRecordBrowserText());						
					}
				}
			}
			
			if (boolGoldenInstanceFound == false)
			{
				clearScreen();
				clearGrids();
				form.recbrSleepAssessment().newRow(form.getGlobalContext().Core.getCurrentCareContext(), form.getGlobalContext().Core.getCurrentCareContext().getRecordBrowserText(),Color.Green);				
				form.getLocalContext().setSelectedCareContextShort((CareContextShortVo) form.recbrSleepAssessment().getValue());								
				SleepReferralVo voSleepReferral = new SleepReferralVo();
				form.getLocalContext().setvoSleep(voSleepReferral);
				voSleepReferral.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
				form.recbrSleepAssessment().setValue(form.getGlobalContext().Core.getCurrentCareContext());
				updateBrowseInformation();
			}						
		}
	}

	private void browseRecord()
	{
		updateBrowseInformation();

		if(form.recbrSleepAssessment().getValue() != null)
		{			
			form.getLocalContext().setvoSleep(domain.getSleepAssessmentByCareContext((CareContextLiteVo) form.recbrSleepAssessment().getValue()));
			form.getLocalContext().setvoVitals(domain.getVitalSignsByCareContext((CareContextLiteVo) form.recbrSleepAssessment().getValue()));

			if (form.getLocalContext().getvoSleepIsNotNull() || form.getLocalContext().getvoVitalsIsNotNull())
				populateScreenFromData();
			else
			{
				clearScreen();
				clearGrids();
			}
		}
		
		updateControlsState();		
	}


	private void updateBrowseInformation()
	{
		form.lblBrowser().setValue(form.recbrSleepAssessment().getRecordState("Assessment", "Assessments"));
	}

	private void setRecordBrowser()
	{
		// after an update need to set the record browser to display the updated record
		if(form.getLocalContext().getUpdatedInstanceIsNotNull())
		{
			if(form.getLocalContext().getUpdatedInstance() instanceof CareContextShortVo)
			{
				CareContextShortVo voCareContext = (CareContextShortVo) form.getLocalContext().getUpdatedInstance();
				form.recbrSleepAssessment().setValue(voCareContext);
			}
		}
	}		
	private boolean populateDataFromScreen()
	{
		SleepReferralVo voSleepReferral = form.getLocalContext().getvoSleep();
		VitalSignsVo voVitalSign = form.getLocalContext().getvoVitals();

		if (voSleepReferral == null)
			voSleepReferral = new SleepReferralVo();

		if (form.cntSleeping().decHeight().getValue() != null || form.cntSleeping().decWeight().getValue() != null || form.cntSleeping().decNeck().getValue() != null)
		{
			if ((form.cntSleeping().decHeight().getValue() == null && form.cntSleeping().decWeight().getValue() != null) || (form.cntSleeping().decHeight().getValue() != null && form.cntSleeping().decWeight().getValue() == null))
			{
				engine.showMessage("Please enter both Height and Weight for Metrics.");
				return false;
			}
			else
			{
				if (voVitalSign == null)
					voVitalSign = new VitalSignsVo();

				VSMetrics voMetrics;
				if (!voVitalSign.getMetricsIsNotNull())
					voMetrics = new VSMetrics();
				else
					voMetrics = voVitalSign.getMetrics();

				if (form.cntSleeping().decHeight().getValue() != null && form.cntSleeping().decWeight().getValue() != null)
				{
					voMetrics.setHeightValue(form.cntSleeping().decHeight().getValue());
					voMetrics.setWeightValue(form.cntSleeping().decWeight().getValue());
					voMetrics.setBMI(bodyMassIndex(form.cntSleeping().decHeight().getValue().floatValue(), form.cntSleeping().decWeight().getValue().floatValue()));
					voMetrics.setSurfaceArea(bodySurfaceArea(form.cntSleeping().decHeight().getValue().floatValue(), form.cntSleeping().decWeight().getValue().floatValue()));
					voMetrics.setHeightEstimatedMeasured(Boolean.TRUE); // default
																		// to
																		// measured
					voMetrics.setWeightEstimatedMeasured(Boolean.TRUE); // default
																		// to
																		// measured
					voMetrics.setPatient(form.getGlobalContext().Core.getPatientShort().toPatientRefVo());
				}

				voMetrics.setNeckSize(form.cntSleeping().decNeck().getValue());

				voVitalSign.setMetrics(voMetrics);

				VSTypeCollection recordedSignsColl = new VSTypeCollection();
				recordedSignsColl.add(VSType.METRICS);

				voVitalSign.setRecordedSigns(recordedSignsColl);
				if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
				{
					if (voVitalSign.getAuthoringInformation() == null)
						voVitalSign.setAuthoringInformation(new AuthoringInformationVo());
					
					voVitalSign.getAuthoringInformation().setAuthoringHcp(form.getGlobalContext().Core.getCurrentClinicalContact().getSeenBy());
					voVitalSign.getAuthoringInformation().setAuthoringDateTime(form.getGlobalContext().Core.getCurrentClinicalContact().getStartDateTime());
					voVitalSign.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
					voVitalSign.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					voVitalSign.setVitalsTakenDateTime(form.getGlobalContext().Core.getCurrentClinicalContact().getStartDateTime());
					
				}
				else
				{
					if (voVitalSign.getAuthoringInformation() == null)
						voVitalSign.setAuthoringInformation(new AuthoringInformationVo());
					
					if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCareIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getResponsibleHCP() instanceof HcpLiteVo)
						voVitalSign.getAuthoringInformation().setAuthoringHcp((HcpLiteVo)form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getResponsibleHCP());
					voVitalSign.getAuthoringInformation().setAuthoringDateTime(form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime());
					voVitalSign.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
					voVitalSign.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					voVitalSign.setVitalsTakenDateTime(form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime());
				}
			}
		}
		else if ((form.cntSleeping().decHeight().getValue() == null) && (form.cntSleeping().decWeight().getValue() == null) && (form.cntSleeping().decNeck().getValue() == null) && (voVitalSign != null))
		{
			voVitalSign.setMetrics(null);
		}
		
		voSleepReferral.setAuthoringInformation(form.customControlAuthoringInfo().getValue());
		voSleepReferral.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		voSleepReferral.setPulseOximetry(new Boolean(form.cntSleeping().chkBoxOximetry().getValue()));
		voSleepReferral.setOximetryValues(form.cntSleeping().cmbValues().getValue());
		voSleepReferral.setMedication(form.cntSleeping().txtMeds().getValue());

		// Findings
		SleepFindingsVoCollection findingColl = new SleepFindingsVoCollection();
		GenForm.cntSleepingContainer.grdFindingsRow rowFinding = null;
		for (int i = 0; i < form.cntSleeping().grdFindings().getRows().size(); i++)
		{
			SleepFindingsVo findingVo;
			rowFinding = form.cntSleeping().grdFindings().getRows().get(i);
			if (rowFinding.getColSelect() != null)
			{
				findingVo = new SleepFindingsVo();

				if (rowFinding.getValue() != null)
					findingVo = rowFinding.getValue();

				findingVo.setFinding(rowFinding.getColFindings());
				findingVo.setAnswer(rowFinding.getColSelect());

				findingColl.add(findingVo);
			}
		}
		voSleepReferral.setSleepFindings(findingColl);

		// EPWORTH
		EpworthSleepAssessmentVoCollection epworthColl = new EpworthSleepAssessmentVoCollection();
		GenForm.cntSleepingContainer.grdEpworthRow rowEPWORTH = null;
		for (int i = 0; i < form.cntSleeping().grdEpworth().getRows().size(); i++)
		{
			EpworthSleepAssessmentVo epworthVo;
			rowEPWORTH = form.cntSleeping().grdEpworth().getRows().get(i);
			if (rowEPWORTH.getColDozing() != null)
			{
				epworthVo = new EpworthSleepAssessmentVo();

				if (rowEPWORTH.getValue() != null)
					epworthVo = rowEPWORTH.getValue();

				epworthVo.setSleepScore(rowEPWORTH.getColSituation());
				epworthVo.setChanceOfSleep(rowEPWORTH.getColDozing());

				epworthColl.add(epworthVo);
			}
		}
		voSleepReferral.setEpworthSleepAssessment(epworthColl);

		// Cognitive Function
		CognitiveFunctionVoCollection cognitiveColl = new CognitiveFunctionVoCollection();
		GenForm.cntSleepingContainer.grdCognitiveRow rowCognitive = null;
		for (int i = 0; i < form.cntSleeping().grdCognitive().getRows().size(); i++)
		{
			CognitiveFunctionVo cognitiveVo;
			rowCognitive = form.cntSleeping().grdCognitive().getRows().get(i);
			if (rowCognitive.getColSelect() != null)
			{
				cognitiveVo = new CognitiveFunctionVo();

				if (rowCognitive.getValue() != null)
					cognitiveVo = rowCognitive.getValue();

				cognitiveVo.setFunction(rowCognitive.getColCognitive());
				cognitiveVo.setAnswer(rowCognitive.getColSelect());

				cognitiveColl.add(cognitiveVo);
			}
		}
		voSleepReferral.setCognitiveFunction(cognitiveColl);

		// Aponea
		SleepApnoeaVoCollection aponeaColl = new SleepApnoeaVoCollection();
		GenForm.cntSleepingContainer.grdApnoeaRow rowApnoea = null;
		for (int i = 0; i < form.cntSleeping().grdApnoea().getRows().size(); i++)
		{
			SleepApnoeaVo aponeaVo;
			rowApnoea = form.cntSleeping().grdApnoea().getRows().get(i);
			if (rowApnoea.getColSelect() != null)
			{
				aponeaVo = new SleepApnoeaVo();

				if (rowApnoea.getValue() != null)
					aponeaVo = rowApnoea.getValue();

				aponeaVo.setApnoeaFactors(rowApnoea.getColApnoea());
				aponeaVo.setApnoeaAnswers((SleepApnoeaFactors) rowApnoea.getColSelect().getValue());

				aponeaColl.add(aponeaVo);
			}
		}
		voSleepReferral.setSleepApnoea(aponeaColl);

		form.getLocalContext().setvoVitals(voVitalSign);
		form.getLocalContext().setvoSleep(voSleepReferral);

		return true;
	}

	private Float bodySurfaceArea(float height/* cm */, float weight/* kg */)
	{
		// we have to convert the HEIGHT from cm to m as the formula requires m
		return new Float((float) (0.20247 * Math.pow(height / 100.0, 0.725) * Math.pow(weight, 0.425)));
	}

	private Float bodyMassIndex(float height/* cm */, float weight/* kg */)
	{
		if (height == 0 || weight  ==0)
			return null;
		
		// we have to convert the HEIGHT from cm to m as the formula requires m
		return new Float((float) (weight / (height / 100.0 * height / 100.0)));
	}
	
	public static float Round(float Rval, int Rpl) 
	{
		  float p = (float)Math.pow(10,Rpl);
		  Rval = Rval * p;
		  float tmp = Math.round(Rval);
		  return (float)tmp/p;
	}

	private void clearScreen()
	{
		form.cntSleeping().chkBoxOximetry().setValue(false);
		form.cntSleeping().cmbValues().setValue(null);
		form.cntSleeping().decWeight().setValue(null);
		form.cntSleeping().decHeight().setValue(null);
		form.cntSleeping().intBMI().setValue(null);
		form.cntSleeping().decNeck().setValue(null);
		form.cntSleeping().txtMeds().setValue(null);
		form.customControlAuthoringInfo().setValue(null);
	}

	private void clearGrids()
	{
		form.cntSleeping().grdFindings().setValue(null);
		form.cntSleeping().grdFindings().getRows().clear();

		form.cntSleeping().grdEpworth().setValue(null);
		form.cntSleeping().grdEpworth().getRows().clear();

		form.cntSleeping().grdCognitive().setValue(null);
		form.cntSleeping().grdCognitive().getRows().clear();

		form.cntSleeping().grdApnoea().setValue(null);
		form.cntSleeping().grdApnoea().getRows().clear();
	}

	private void populateScreenFromData()
	{
		if (form.getLocalContext().getSelectedCareContextShortIsNotNull())
		{
			SleepReferralVo voSleepReferral = form.getLocalContext().getvoSleep();
			VitalSignsVo voVitalSign = form.getLocalContext().getvoVitals();
			
			loadLookupsIntoGrid();
	
			if (voSleepReferral == null)
				return;
			
			form.customControlAuthoringInfo().setValue(voSleepReferral.getAuthoringInformation());
			
			if ((voVitalSign != null) && (voVitalSign.getMetricsIsNotNull()))
			{
				form.cntSleeping().decHeight().setValue(voVitalSign.getMetrics().getHeightValueIsNotNull() ? voVitalSign.getMetrics().getHeightValue() : null);
				form.cntSleeping().decWeight().setValue(voVitalSign.getMetrics().getWeightValueIsNotNull() ? voVitalSign.getMetrics().getWeightValue() : null);
				form.cntSleeping().intBMI().setValue(voVitalSign.getMetrics().getBMIIsNotNull() ? new Integer(voVitalSign.getMetrics().getBMI().intValue()) : null);
				form.cntSleeping().decNeck().setValue(voVitalSign.getMetrics().getNeckSizeIsNotNull() ? voVitalSign.getMetrics().getNeckSize() : null);
			}
	
			// Sleep Assessment values
			form.cntSleeping().chkBoxOximetry().setValue(voSleepReferral.getPulseOximetryIsNotNull() ? voSleepReferral.getPulseOximetry().booleanValue() : false);
			form.cntSleeping().cmbValues().setValue(voSleepReferral.getOximetryValuesIsNotNull() ? voSleepReferral.getOximetryValues(): null);
			form.cntSleeping().txtMeds().setValue(voSleepReferral.getMedicationIsNotNull() ? voSleepReferral.getMedication(): null);
	
			// If data exists the populate the Findings
			SleepFindingsVoCollection findingColl = voSleepReferral.getSleepFindings();
			if (findingColl != null)
			{
				GenForm.cntSleepingContainer.grdFindingsRow rowFinding = null;
				for (int j = 0; j < findingColl.size(); j++)
				{
					SleepFindingsVo findingVo = findingColl.get(j);
					int i = 0;
					for (i = 0; i < form.cntSleeping().grdFindings().getRows().size(); i++)
					{
						rowFinding = form.cntSleeping().grdFindings().getRows().get(i);
						if (rowFinding.getColFindings().getId() == findingVo.getFinding().getId())
						{
							rowFinding.setValue(findingVo);
							rowFinding.setColSelect(findingVo.getAnswer());
							break;
						}
					}
					if (i == form.cntSleeping().grdFindings().getRows().size())
					{
						rowFinding = form.cntSleeping().grdFindings().getRows().newRow();
						rowFinding.setValue(findingVo);
						rowFinding.setColFindings(findingVo.getFinding());
						rowFinding.setColSelect(findingVo.getAnswer());
					}
				}
			}
	
			// EPWORTH
			GenForm.cntSleepingContainer.grdEpworthRow rowEPWORTH = null;
			EpworthSleepAssessmentVoCollection epworthColl = voSleepReferral.getEpworthSleepAssessment();
			if (epworthColl != null)
			{
				for (int j = 0; j < epworthColl.size(); j++)
				{
					EpworthSleepAssessmentVo epworthVo = epworthColl.get(j);
					int i = 0;
					for (i = 0; i < form.cntSleeping().grdEpworth().getRows().size(); i++)
					{
						rowEPWORTH = form.cntSleeping().grdEpworth().getRows().get(i);
						if (rowEPWORTH.getColSituation().getId() == epworthVo.getSleepScore().getId())
						{
							rowEPWORTH.setValue(epworthVo);
							rowEPWORTH.setColDozing(epworthVo.getChanceOfSleep());
							break;
						}
					}
					if (i == form.cntSleeping().grdEpworth().getRows().size())
					{
						rowEPWORTH = form.cntSleeping().grdEpworth().getRows().newRow();
						rowEPWORTH.setValue(epworthVo);
						rowEPWORTH.setColDozing(epworthVo.getChanceOfSleep());
						rowEPWORTH.setColSituation(epworthVo.getSleepScore());
					}
				}
			}
	
			calculateScore();
	
			// Cognitive Function
			CognitiveFunctionVoCollection cognitiveColl = voSleepReferral.getCognitiveFunction();
			if (cognitiveColl != null)
			{
				GenForm.cntSleepingContainer.grdCognitiveRow rowCognitive = null;
				for (int j = 0; j < cognitiveColl.size(); j++)
				{
					CognitiveFunctionVo cognitiveVo = cognitiveColl.get(j);
					int i = 0;
					for (i = 0; i < form.cntSleeping().grdCognitive().getRows().size(); i++)
					{
						rowCognitive = form.cntSleeping().grdCognitive().getRows().get(i);
						if (rowCognitive.getColCognitive().getId() == cognitiveVo.getFunction().getId())
						{
							rowCognitive.setValue(cognitiveVo);
							rowCognitive.setColSelect(cognitiveVo.getAnswer());
							break;
						}
					}
					if (i == form.cntSleeping().grdCognitive().getRows().size())
					{
						rowCognitive = form.cntSleeping().grdCognitive().getRows().newRow();
						rowCognitive.setValue(cognitiveVo);
						rowCognitive.setColCognitive(cognitiveVo.getFunction());
						rowCognitive.setColSelect(cognitiveVo.getAnswer());
					}
				}
			}
	
			// Aponea
			SleepApnoeaVoCollection aponeaColl = voSleepReferral.getSleepApnoea();
			if (findingColl != null)
			{
				GenForm.cntSleepingContainer.grdApnoeaRow rowAponea = null;
				for (int j = 0; j < aponeaColl.size(); j++)
				{
					SleepApnoeaVo aponeaVo = aponeaColl.get(j);
					int i = 0;
					for (i = 0; i < form.cntSleeping().grdApnoea().getRows().size(); i++)
					{
						rowAponea = form.cntSleeping().grdApnoea().getRows().get(i);
						if (rowAponea.getColApnoea().getId() == aponeaVo.getApnoeaFactors().getId())
						{
							rowAponea.setValue(aponeaVo);
							rowAponea.getColSelect().setValue(aponeaVo.getApnoeaAnswers());
							break;
						}
					}
					if (i == form.cntSleeping().grdApnoea().getRows().size())
					{
						rowAponea = form.cntSleeping().grdApnoea().getRows().newRow();
						rowAponea.setValue(aponeaVo);
						rowAponea.setColApnoea(aponeaVo.getApnoeaFactors());
						rowAponea.getColSelect().setValue(aponeaVo.getApnoeaAnswers());
					}
				}
			}
		}	
	}

	protected void onGrdEpworthGridComboBoxSelectionChanged(int column, grdEpworthRow row, Object value) throws PresentationLogicException
	{
		calculateScore();
	}

	private void calculateScore()
	{
		int intScore = 0;
		GenForm.cntSleepingContainer.grdEpworthRow rowEPWORTH = null;
		for (int i = 0; i < form.cntSleeping().grdEpworth().getRows().size(); i++)
		{
			rowEPWORTH = form.cntSleeping().grdEpworth().getRows().get(i);
			if (rowEPWORTH.getColDozing() != null)
			{
				if (rowEPWORTH.getColDozing().getId() == SleepEpworthChanceOfSleep.NEVER_DOZE.getId())
					intScore += NEVER_DOZE_SCORE;
				else if (rowEPWORTH.getColDozing().getId() == SleepEpworthChanceOfSleep.SLIGHT_CHANCE.getId())
					intScore += SLIGHT_SCORE;
				else if (rowEPWORTH.getColDozing().getId() == SleepEpworthChanceOfSleep.MODERATE_CHANCE.getId())
					intScore += MODERATE_SCORE;
				else if (rowEPWORTH.getColDozing().getId() == SleepEpworthChanceOfSleep.HIGH_CHANCE.getId())
					intScore += HIGH_SCORE;
			}
		}
		Integer nScore = new Integer(intScore);
		form.cntSleeping().lblTotalScore().setValue(nScore.toString());
	}

	private final static int	NEVER_DOZE_SCORE	= 0;
	private final static int	SLIGHT_SCORE		= 1;
	private final static int	MODERATE_SCORE		= 2;
	private final static int	HIGH_SCORE			= 3;

	protected void onGrdApnoeaMutableComboBoxSelected(int column, grdApnoeaRow row, Object value) throws PresentationLogicException
	{
	}

	protected void onRecbrSleepAssessmentValueChanged() throws PresentationLogicException
	{
		browseRecord();
	}

	private void loadLookupsIntoGrid()
	{
		clearGrids();
		// Findings...
		GenForm.cntSleepingContainer.grdFindingsRow rowFinding = null;
		SleepFindingsCollection colSleepFinding = LookupHelper.getSleepFindings(domain.getLookupService());
		for (int i = 0; i < colSleepFinding.size(); i++)
		{
			SleepFindings bSleepFindings = colSleepFinding.get(i);
			rowFinding = form.cntSleeping().grdFindings().getRows().newRow();
			rowFinding.setColFindings(bSleepFindings);
		}

		// EPWORTH
		GenForm.cntSleepingContainer.grdEpworthRow rowEPWORTH = null;
		SleepEpworthScoreCollection colEPWORTH = LookupHelper.getSleepEpworthScore(domain.getLookupService());
		for (int i = 0; i < colEPWORTH.size(); i++)
		{
			SleepEpworthScore bEPWORTH = colEPWORTH.get(i);
			rowEPWORTH = form.cntSleeping().grdEpworth().getRows().newRow();
			rowEPWORTH.setColSituation(bEPWORTH);
		}

		// Cognitive Function
		GenForm.cntSleepingContainer.grdCognitiveRow rowCognitive = null;
		SleepCognitiveFunctionCollection colCognitiveFunction = LookupHelper.getSleepCognitiveFunction(domain.getLookupService());
		for (int i = 0; i < colCognitiveFunction.size(); i++)
		{
			SleepCognitiveFunction bSleepCognitive = colCognitiveFunction.get(i);
			rowCognitive = form.cntSleeping().grdCognitive().getRows().newRow();
			rowCognitive.setColCognitive(bSleepCognitive);
		}

		// Aponea Factors
		GenForm.cntSleepingContainer.grdApnoeaRow rowAponea = null;
		SleepApnoeaFactorsCollection colAponea = LookupHelper.getSleepApnoeaFactors(domain.getLookupService());
		TreeNode[] rootNodes = null;
		ArrayList childColl = null;

		SleepApnoeaFactors childApnoeInst = null;
		rootNodes = colAponea.getRootNodes();
		for (int j = 0; j < rootNodes.length; j++)
		{
			SleepApnoeaFactors inst = (SleepApnoeaFactors) rootNodes[j];
			rowAponea = form.cntSleeping().grdApnoea().getRows().newRow();
			rowAponea.setColApnoea(inst);
			for (int p = 0; p < colAponea.size(); p++)
			{
				if (colAponea.get(p).equals(inst))
				{
					childColl = colAponea.get(p).getChildInstances();
					for (int k = 0; k < childColl.size(); k++)
					{
						childApnoeInst = (SleepApnoeaFactors) childColl.get(k);
						rowAponea.getColSelect().newRow(childApnoeInst, childApnoeInst.getText());
					}
				}
			}
		}
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newSleepReferral();		
	}

	private void newSleepReferral() 
	{
		form.setMode(FormMode.EDIT);
		clearScreen();
		clearGrids();
				
		if (form.getLocalContext().getvoSleep() == null)
			form.getLocalContext().setvoSleep(new SleepReferralVo());
		
		loadLookupsIntoGrid();
		setDefaultHcpData();				
		updateBrowseInformation();
		populateHeightWeightFields();
	}
	private void populateHeightWeightFields()
	{
		VSMetricsCollection voMetricsColl = new VSMetricsCollection();
		voMetricsColl = domain.listMetricsData(form.getGlobalContext().Core.getPatientShort());
		if(voMetricsColl.size()<= 0)
			return;
		else
		{
			VSMetrics voMetrics = voMetricsColl.get(0);
			form.cntSleeping().decHeight().setValue(voMetrics.getHeightValue());
			form.cntSleeping().decWeight().setValue(voMetrics.getWeightValue());
		}
	}


	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (!populateDataFromScreen())
			return;

		SleepReferralVo voSleepReferral = form.getLocalContext().getvoSleep();
		VitalSignsVo voVitals = form.getLocalContext().getvoVitals();
		try
		{
			if (voVitals != null)
			{
				String[] messages = voVitals.validate(validateUIRules());
				if (messages != null)
				{
					engine.showErrors("Validation Errors for VitalSignsVo", messages);
					return;
				}
				domain.saveVitalsVo(voVitals);
			}

			String[] messages1 = voSleepReferral.validate();
			if (messages1 != null)
			{
				engine.showErrors("Validation Errors for MedExamGeneralVo", messages1);
				return;
			}
			domain.saveSleepAssessmentVo(voSleepReferral);

		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			form.setMode(FormMode.VIEW);
			return;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
		}

		open();
		form.setMode(FormMode.VIEW);
	}

	private String[] validateUIRules() 
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if (form.cntSleeping().decHeight().getValue() != null || form.cntSleeping().decWeight().getValue() != null)
		{
			if (form.cntSleeping().decHeight().getValue() == null || form.cntSleeping().decWeight().getValue() == null) 
			{
				uiErrors.add("Please enter both Height and Weight for Metrics.");
			}
			else
			{
				if ((form.cntSleeping().decHeight().getValue() >= 0 && form.cntSleeping().decHeight().getValue() < 1) ||
						(form.cntSleeping().decWeight().getValue() >= 0 && form.cntSleeping().decWeight().getValue() < 1))
				{
					uiErrors.add("A non-zero and greather than 1 value needs to be specified for Height and Weight");					
				}
			}
		}	
		
		String[] voValidate = new String[uiErrors.size()];
		uiErrors.toArray(voValidate);
		
		return voValidate;
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setvoVitals(null);

		open();
		form.setMode(FormMode.VIEW);
	}
	
	private void updateControlsState()
	{		
		form.btnUpdate().setVisible(showUpdateButton());
		form.btnNew().setVisible(showNewButton());
		if (form.getMode().equals(FormMode.EDIT))
			setHcpControlVisibility();
	}


	private void setHcpControlVisibility()
	{
		if (form.getLocalContext().getvoSleep() == null) return;
		
		boolean bEnabled = form.getLocalContext().getvoSleep().getID_SleepReferral() == null;
		form.setcustomControlAuthoringInfoEnabled(bEnabled);
	}
		
	protected void onFormModeChanged() 
	{
		updateControlsState();		
	}
	
	
	
	private boolean showUpdateButton() 
	{
		if (form.recbrSleepAssessment().getValue() == null || form.getLocalContext().getvoSleep() == null)
		{
			return false;
		}
		else			
		{
			return (form.getMode().equals(FormMode.VIEW) &&
					form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext().equals(form.recbrSleepAssessment().getValue().getID_CareContext())
					&& form.getLocalContext().getvoSleep().getID_SleepReferralIsNotNull());
		}
	}

	private boolean showNewButton()
	{
		if (form.getMode().equals(FormMode.EDIT))
			return false;		
		if (form.recbrSleepAssessment().getValue() == null)
			return false;		
		if (form.recbrSleepAssessment().getValue().getID_CareContext() == null)
			return false;		
		if (form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext().equals(form.recbrSleepAssessment().getValue().getID_CareContext()) == false)
			return false;				
		if (form.getLocalContext().getvoSleep() != null && form.getLocalContext().getvoSleep().getID_SleepReferralIsNotNull())
			return false;	
		
		return true;
	}
	
	private void setDefaultHcpData()
	{
		form.customControlAuthoringInfo().initializeComponent();
	}
}
