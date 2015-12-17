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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.oncology.forms.chemotherapydetails;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.ChemotherapyDetails.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.ChemotherapyDetails domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbHospitalValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbHospital().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.TreatmentHospital existingInstance = (ims.oncology.vo.lookups.TreatmentHospital)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbHospitalLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.TreatmentHospital)
		{
			ims.oncology.vo.lookups.TreatmentHospital instance = (ims.oncology.vo.lookups.TreatmentHospital)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbHospitalLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.TreatmentHospital existingInstance = (ims.oncology.vo.lookups.TreatmentHospital)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbHospital().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbHospitalLookup()
	{
		this.form.lyrDetails().tabDetails().cmbHospital().clear();
		ims.oncology.vo.lookups.TreatmentHospitalCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getTreatmentHospital(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbHospital().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbHospitalLookupValue(int id)
	{
		ims.oncology.vo.lookups.TreatmentHospital instance = ims.oncology.vo.lookups.LookupHelper.getTreatmentHospitalInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbHospital().setValue(instance);
	}
	protected final void defaultcmbHospitalLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbHospital().setValue((ims.oncology.vo.lookups.TreatmentHospital)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.TreatmentHospital.class, engine.getFormName().getID(), ims.oncology.vo.lookups.TreatmentHospital.TYPE_ID));
	}
	protected final void oncmbRegimenOutcomeSummaryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.RegimenOutcomeSummary existingInstance = (ims.oncology.vo.lookups.RegimenOutcomeSummary)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRegimenOutcomeSummaryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.RegimenOutcomeSummary)
		{
			ims.oncology.vo.lookups.RegimenOutcomeSummary instance = (ims.oncology.vo.lookups.RegimenOutcomeSummary)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRegimenOutcomeSummaryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.RegimenOutcomeSummary existingInstance = (ims.oncology.vo.lookups.RegimenOutcomeSummary)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRegimenOutcomeSummaryLookup()
	{
		this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().clear();
		ims.oncology.vo.lookups.RegimenOutcomeSummaryCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getRegimenOutcomeSummary(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRegimenOutcomeSummaryLookupValue(int id)
	{
		ims.oncology.vo.lookups.RegimenOutcomeSummary instance = ims.oncology.vo.lookups.LookupHelper.getRegimenOutcomeSummaryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().setValue(instance);
	}
	protected final void defaultcmbRegimenOutcomeSummaryLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().setValue((ims.oncology.vo.lookups.RegimenOutcomeSummary)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.RegimenOutcomeSummary.class, engine.getFormName().getID(), ims.oncology.vo.lookups.RegimenOutcomeSummary.TYPE_ID));
	}
	protected final void oncmbDelay2ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbDelay2().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.SurgeryReasonForDelay existingInstance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDelay2Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)
		{
			ims.medicaloncology.vo.lookups.SurgeryReasonForDelay instance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDelay2Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.SurgeryReasonForDelay existingInstance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbDelay2().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDelay2Lookup()
	{
		this.form.lyrDetails().tabDetails().cmbDelay2().clear();
		ims.medicaloncology.vo.lookups.SurgeryReasonForDelayCollection lookupCollection = ims.medicaloncology.vo.lookups.LookupHelper.getSurgeryReasonForDelay(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbDelay2().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDelay2LookupValue(int id)
	{
		ims.medicaloncology.vo.lookups.SurgeryReasonForDelay instance = ims.medicaloncology.vo.lookups.LookupHelper.getSurgeryReasonForDelayInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbDelay2().setValue(instance);
	}
	protected final void defaultcmbDelay2LookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbDelay2().setValue((ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)domain.getLookupService().getDefaultInstance(ims.medicaloncology.vo.lookups.SurgeryReasonForDelay.class, engine.getFormName().getID(), ims.medicaloncology.vo.lookups.SurgeryReasonForDelay.TYPE_ID));
	}
	protected final void oncmbDelay1ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbDelay1().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.SurgeryReasonForDelay existingInstance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDelay1Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)
		{
			ims.medicaloncology.vo.lookups.SurgeryReasonForDelay instance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDelay1Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.SurgeryReasonForDelay existingInstance = (ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbDelay1().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDelay1Lookup()
	{
		this.form.lyrDetails().tabDetails().cmbDelay1().clear();
		ims.medicaloncology.vo.lookups.SurgeryReasonForDelayCollection lookupCollection = ims.medicaloncology.vo.lookups.LookupHelper.getSurgeryReasonForDelay(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbDelay1().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDelay1LookupValue(int id)
	{
		ims.medicaloncology.vo.lookups.SurgeryReasonForDelay instance = ims.medicaloncology.vo.lookups.LookupHelper.getSurgeryReasonForDelayInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbDelay1().setValue(instance);
	}
	protected final void defaultcmbDelay1LookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbDelay1().setValue((ims.medicaloncology.vo.lookups.SurgeryReasonForDelay)domain.getLookupService().getDefaultInstance(ims.medicaloncology.vo.lookups.SurgeryReasonForDelay.class, engine.getFormName().getID(), ims.medicaloncology.vo.lookups.SurgeryReasonForDelay.TYPE_ID));
	}
	protected final void oncmbPrefornmanceStatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.PerformanceStatus existingInstance = (ims.medicaloncology.vo.lookups.PerformanceStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPrefornmanceStatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.medicaloncology.vo.lookups.PerformanceStatus)
		{
			ims.medicaloncology.vo.lookups.PerformanceStatus instance = (ims.medicaloncology.vo.lookups.PerformanceStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPrefornmanceStatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.PerformanceStatus existingInstance = (ims.medicaloncology.vo.lookups.PerformanceStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPrefornmanceStatLookup()
	{
		this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().clear();
		ims.medicaloncology.vo.lookups.PerformanceStatusCollection lookupCollection = ims.medicaloncology.vo.lookups.LookupHelper.getPerformanceStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPrefornmanceStatLookupValue(int id)
	{
		ims.medicaloncology.vo.lookups.PerformanceStatus instance = ims.medicaloncology.vo.lookups.LookupHelper.getPerformanceStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().setValue(instance);
	}
	protected final void defaultcmbPrefornmanceStatLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().setValue((ims.medicaloncology.vo.lookups.PerformanceStatus)domain.getLookupService().getDefaultInstance(ims.medicaloncology.vo.lookups.PerformanceStatus.class, engine.getFormName().getID(), ims.medicaloncology.vo.lookups.PerformanceStatus.TYPE_ID));
	}
	protected final void oncmbTreatmentIntentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbTreatmentIntent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.CancerTreatmentIntent existingInstance = (ims.oncology.vo.lookups.CancerTreatmentIntent)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentIntentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.CancerTreatmentIntent)
		{
			ims.oncology.vo.lookups.CancerTreatmentIntent instance = (ims.oncology.vo.lookups.CancerTreatmentIntent)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentIntentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.CancerTreatmentIntent existingInstance = (ims.oncology.vo.lookups.CancerTreatmentIntent)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbTreatmentIntent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentIntentLookup()
	{
		this.form.lyrDetails().tabDetails().cmbTreatmentIntent().clear();
		ims.oncology.vo.lookups.CancerTreatmentIntentCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getCancerTreatmentIntent(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbTreatmentIntent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentIntentLookupValue(int id)
	{
		ims.oncology.vo.lookups.CancerTreatmentIntent instance = ims.oncology.vo.lookups.LookupHelper.getCancerTreatmentIntentInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbTreatmentIntent().setValue(instance);
	}
	protected final void defaultcmbTreatmentIntentLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbTreatmentIntent().setValue((ims.oncology.vo.lookups.CancerTreatmentIntent)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.CancerTreatmentIntent.class, engine.getFormName().getID(), ims.oncology.vo.lookups.CancerTreatmentIntent.TYPE_ID));
	}
	protected final void oncmbRegimeAcronymValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbRegimeAcronym().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.RegimenAcronym existingInstance = (ims.oncology.vo.lookups.RegimenAcronym)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRegimeAcronymLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.RegimenAcronym)
		{
			ims.oncology.vo.lookups.RegimenAcronym instance = (ims.oncology.vo.lookups.RegimenAcronym)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRegimeAcronymLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.RegimenAcronym existingInstance = (ims.oncology.vo.lookups.RegimenAcronym)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbRegimeAcronym().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRegimeAcronymLookup()
	{
		this.form.lyrDetails().tabDetails().cmbRegimeAcronym().clear();
		ims.oncology.vo.lookups.RegimenAcronymCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getRegimenAcronym(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbRegimeAcronym().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRegimeAcronymLookupValue(int id)
	{
		ims.oncology.vo.lookups.RegimenAcronym instance = ims.oncology.vo.lookups.LookupHelper.getRegimenAcronymInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbRegimeAcronym().setValue(instance);
	}
	protected final void defaultcmbRegimeAcronymLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbRegimeAcronym().setValue((ims.oncology.vo.lookups.RegimenAcronym)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.RegimenAcronym.class, engine.getFormName().getID(), ims.oncology.vo.lookups.RegimenAcronym.TYPE_ID));
	}
	protected final void oncmbTreatmentResponseValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbTreatmentResponse().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DrugProgramResponse existingInstance = (ims.oncology.vo.lookups.DrugProgramResponse)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentResponseLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DrugProgramResponse)
		{
			ims.oncology.vo.lookups.DrugProgramResponse instance = (ims.oncology.vo.lookups.DrugProgramResponse)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentResponseLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DrugProgramResponse existingInstance = (ims.oncology.vo.lookups.DrugProgramResponse)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbTreatmentResponse().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentResponseLookup()
	{
		this.form.lyrDetails().tabDetails().cmbTreatmentResponse().clear();
		ims.oncology.vo.lookups.DrugProgramResponseCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDrugProgramResponse(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbTreatmentResponse().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentResponseLookupValue(int id)
	{
		ims.oncology.vo.lookups.DrugProgramResponse instance = ims.oncology.vo.lookups.LookupHelper.getDrugProgramResponseInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbTreatmentResponse().setValue(instance);
	}
	protected final void defaultcmbTreatmentResponseLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbTreatmentResponse().setValue((ims.oncology.vo.lookups.DrugProgramResponse)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DrugProgramResponse.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DrugProgramResponse.TYPE_ID));
	}
	protected final void oncmbReasonForChangingValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbReasonForChanging().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ChemoTxChangeReason existingInstance = (ims.oncology.vo.lookups.ChemoTxChangeReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonForChangingLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ChemoTxChangeReason)
		{
			ims.oncology.vo.lookups.ChemoTxChangeReason instance = (ims.oncology.vo.lookups.ChemoTxChangeReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonForChangingLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ChemoTxChangeReason existingInstance = (ims.oncology.vo.lookups.ChemoTxChangeReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbReasonForChanging().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonForChangingLookup()
	{
		this.form.lyrDetails().tabDetails().cmbReasonForChanging().clear();
		ims.oncology.vo.lookups.ChemoTxChangeReasonCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getChemoTxChangeReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbReasonForChanging().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonForChangingLookupValue(int id)
	{
		ims.oncology.vo.lookups.ChemoTxChangeReason instance = ims.oncology.vo.lookups.LookupHelper.getChemoTxChangeReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbReasonForChanging().setValue(instance);
	}
	protected final void defaultcmbReasonForChangingLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbReasonForChanging().setValue((ims.oncology.vo.lookups.ChemoTxChangeReason)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ChemoTxChangeReason.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ChemoTxChangeReason.TYPE_ID));
	}
	protected final void oncmbDrugTherapyTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDetails().cmbDrugTherapyType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DrugTherapyType existingInstance = (ims.oncology.vo.lookups.DrugTherapyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDrugTherapyTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DrugTherapyType)
		{
			ims.oncology.vo.lookups.DrugTherapyType instance = (ims.oncology.vo.lookups.DrugTherapyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDrugTherapyTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DrugTherapyType existingInstance = (ims.oncology.vo.lookups.DrugTherapyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDetails().cmbDrugTherapyType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDrugTherapyTypeLookup()
	{
		this.form.lyrDetails().tabDetails().cmbDrugTherapyType().clear();
		ims.oncology.vo.lookups.DrugTherapyTypeCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDrugTherapyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDetails().cmbDrugTherapyType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDrugTherapyTypeLookupValue(int id)
	{
		ims.oncology.vo.lookups.DrugTherapyType instance = ims.oncology.vo.lookups.LookupHelper.getDrugTherapyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDetails().cmbDrugTherapyType().setValue(instance);
	}
	protected final void defaultcmbDrugTherapyTypeLookupValue()
	{
		this.form.lyrDetails().tabDetails().cmbDrugTherapyType().setValue((ims.oncology.vo.lookups.DrugTherapyType)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DrugTherapyType.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DrugTherapyType.TYPE_ID));
	}
	protected final void oncmbPerformanceStatusAtSTartCycleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.PerformanceStatus existingInstance = (ims.medicaloncology.vo.lookups.PerformanceStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPerformanceStatusAtSTartCycleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.medicaloncology.vo.lookups.PerformanceStatus)
		{
			ims.medicaloncology.vo.lookups.PerformanceStatus instance = (ims.medicaloncology.vo.lookups.PerformanceStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPerformanceStatusAtSTartCycleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.medicaloncology.vo.lookups.PerformanceStatus existingInstance = (ims.medicaloncology.vo.lookups.PerformanceStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPerformanceStatusAtSTartCycleLookup()
	{
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().clear();
		ims.medicaloncology.vo.lookups.PerformanceStatusCollection lookupCollection = ims.medicaloncology.vo.lookups.LookupHelper.getPerformanceStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPerformanceStatusAtSTartCycleLookupValue(int id)
	{
		ims.medicaloncology.vo.lookups.PerformanceStatus instance = ims.medicaloncology.vo.lookups.LookupHelper.getPerformanceStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().setValue(instance);
	}
	protected final void defaultcmbPerformanceStatusAtSTartCycleLookupValue()
	{
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().setValue((ims.medicaloncology.vo.lookups.PerformanceStatus)domain.getLookupService().getDefaultInstance(ims.medicaloncology.vo.lookups.PerformanceStatus.class, engine.getFormName().getID(), ims.medicaloncology.vo.lookups.PerformanceStatus.TYPE_ID));
	}
	protected final void oncmbTreatmentTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ChemoCycleTreatmentType existingInstance = (ims.oncology.vo.lookups.ChemoCycleTreatmentType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ChemoCycleTreatmentType)
		{
			ims.oncology.vo.lookups.ChemoCycleTreatmentType instance = (ims.oncology.vo.lookups.ChemoCycleTreatmentType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ChemoCycleTreatmentType existingInstance = (ims.oncology.vo.lookups.ChemoCycleTreatmentType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentTypeLookup()
	{
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().clear();
		ims.oncology.vo.lookups.ChemoCycleTreatmentTypeCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getChemoCycleTreatmentType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentTypeLookupValue(int id)
	{
		ims.oncology.vo.lookups.ChemoCycleTreatmentType instance = ims.oncology.vo.lookups.LookupHelper.getChemoCycleTreatmentTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().setValue(instance);
	}
	protected final void defaultcmbTreatmentTypeLookupValue()
	{
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().setValue((ims.oncology.vo.lookups.ChemoCycleTreatmentType)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ChemoCycleTreatmentType.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ChemoCycleTreatmentType.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.ChemotherapyDetails domain;
}
