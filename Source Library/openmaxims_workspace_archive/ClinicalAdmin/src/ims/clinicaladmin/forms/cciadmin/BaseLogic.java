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

package ims.clinicaladmin.forms.cciadmin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinicaladmin.domain.CCIAdmin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinicaladmin.domain.CCIAdmin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbHospitalCatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbHospitalCat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbHospitalCatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinicaladmin.vo.lookups.CaseTypeProcedure)
		{
			ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbHospitalCatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbHospitalCat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbHospitalCatLookup()
	{
		this.form.cmbHospitalCat().clear();
		ims.clinicaladmin.vo.lookups.CaseTypeProcedureCollection lookupCollection = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedure(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbHospitalCat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbHospitalCatLookupValue(int id)
	{
		ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbHospitalCat().setValue(instance);
	}
	protected final void defaultcmbHospitalCatLookupValue()
	{
		this.form.cmbHospitalCat().setValue((ims.clinicaladmin.vo.lookups.CaseTypeProcedure)domain.getLookupService().getDefaultInstance(ims.clinicaladmin.vo.lookups.CaseTypeProcedure.class, engine.getFormName().getID(), ims.clinicaladmin.vo.lookups.CaseTypeProcedure.TYPE_ID));
	}
	protected final void oncmbSurgeonCatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSurgeonCat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSurgeonCatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinicaladmin.vo.lookups.CaseTypeProcedure)
		{
			ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSurgeonCatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSurgeonCat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSurgeonCatLookup()
	{
		this.form.cmbSurgeonCat().clear();
		ims.clinicaladmin.vo.lookups.CaseTypeProcedureCollection lookupCollection = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedure(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSurgeonCat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSurgeonCatLookupValue(int id)
	{
		ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSurgeonCat().setValue(instance);
	}
	protected final void defaultcmbSurgeonCatLookupValue()
	{
		this.form.cmbSurgeonCat().setValue((ims.clinicaladmin.vo.lookups.CaseTypeProcedure)domain.getLookupService().getDefaultInstance(ims.clinicaladmin.vo.lookups.CaseTypeProcedure.class, engine.getFormName().getID(), ims.clinicaladmin.vo.lookups.CaseTypeProcedure.TYPE_ID));
	}
	protected final void oncmbTreatInterventionTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTreatInterventionType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TreatmentInterventionType existingInstance = (ims.clinical.vo.lookups.TreatmentInterventionType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatInterventionTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.TreatmentInterventionType)
		{
			ims.clinical.vo.lookups.TreatmentInterventionType instance = (ims.clinical.vo.lookups.TreatmentInterventionType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatInterventionTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TreatmentInterventionType existingInstance = (ims.clinical.vo.lookups.TreatmentInterventionType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTreatInterventionType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatInterventionTypeLookup()
	{
		this.form.cmbTreatInterventionType().clear();
		ims.clinical.vo.lookups.TreatmentInterventionTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getTreatmentInterventionType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTreatInterventionType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatInterventionTypeLookupValue(int id)
	{
		ims.clinical.vo.lookups.TreatmentInterventionType instance = ims.clinical.vo.lookups.LookupHelper.getTreatmentInterventionTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTreatInterventionType().setValue(instance);
	}
	protected final void defaultcmbTreatInterventionTypeLookupValue()
	{
		this.form.cmbTreatInterventionType().setValue((ims.clinical.vo.lookups.TreatmentInterventionType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.TreatmentInterventionType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.TreatmentInterventionType.TYPE_ID));
	}
	protected final void bindgrdMappingscolExtCodeTypeLookup()
	{
		this.form.lyrDetails().tabMappings().grdMappings().colExtCodeTypeComboBox().clear();
		ims.core.vo.lookups.TaxonomyTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTaxonomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabMappings().grdMappings().colExtCodeTypeComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbFrequencyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabDefaultValues().cmbFrequency().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationFrequency existingInstance = (ims.core.vo.lookups.MedicationFrequency)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFrequencyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MedicationFrequency)
		{
			ims.core.vo.lookups.MedicationFrequency instance = (ims.core.vo.lookups.MedicationFrequency)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFrequencyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationFrequency existingInstance = (ims.core.vo.lookups.MedicationFrequency)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabDefaultValues().cmbFrequency().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFrequencyLookup()
	{
		this.form.lyrDetails().tabDefaultValues().cmbFrequency().clear();
		ims.core.vo.lookups.MedicationFrequencyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicationFrequency(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabDefaultValues().cmbFrequency().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFrequencyLookupValue(int id)
	{
		ims.core.vo.lookups.MedicationFrequency instance = ims.core.vo.lookups.LookupHelper.getMedicationFrequencyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabDefaultValues().cmbFrequency().setValue(instance);
	}
	protected final void defaultcmbFrequencyLookupValue()
	{
		this.form.lyrDetails().tabDefaultValues().cmbFrequency().setValue((ims.core.vo.lookups.MedicationFrequency)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MedicationFrequency.class, engine.getFormName().getID(), ims.core.vo.lookups.MedicationFrequency.TYPE_ID));
	}
	protected final void oncmbAlgTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAlgType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AllergenType existingInstance = (ims.core.vo.lookups.AllergenType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAlgTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.AllergenType)
		{
			ims.core.vo.lookups.AllergenType instance = (ims.core.vo.lookups.AllergenType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAlgTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AllergenType existingInstance = (ims.core.vo.lookups.AllergenType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAlgType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAlgTypeLookup()
	{
		this.form.cmbAlgType().clear();
		ims.core.vo.lookups.AllergenTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAllergenType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAlgType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAlgTypeLookupValue(int id)
	{
		ims.core.vo.lookups.AllergenType instance = ims.core.vo.lookups.LookupHelper.getAllergenTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAlgType().setValue(instance);
	}
	protected final void defaultcmbAlgTypeLookupValue()
	{
		this.form.cmbAlgType().setValue((ims.core.vo.lookups.AllergenType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.AllergenType.class, engine.getFormName().getID(), ims.core.vo.lookups.AllergenType.TYPE_ID));
	}
	protected final void oncmbAnaesthetistCatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAnaesthetistCat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAnaesthetistCatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinicaladmin.vo.lookups.CaseTypeProcedure)
		{
			ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAnaesthetistCatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinicaladmin.vo.lookups.CaseTypeProcedure existingInstance = (ims.clinicaladmin.vo.lookups.CaseTypeProcedure)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAnaesthetistCat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAnaesthetistCatLookup()
	{
		this.form.cmbAnaesthetistCat().clear();
		ims.clinicaladmin.vo.lookups.CaseTypeProcedureCollection lookupCollection = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedure(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAnaesthetistCat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAnaesthetistCatLookupValue(int id)
	{
		ims.clinicaladmin.vo.lookups.CaseTypeProcedure instance = ims.clinicaladmin.vo.lookups.LookupHelper.getCaseTypeProcedureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAnaesthetistCat().setValue(instance);
	}
	protected final void defaultcmbAnaesthetistCatLookupValue()
	{
		this.form.cmbAnaesthetistCat().setValue((ims.clinicaladmin.vo.lookups.CaseTypeProcedure)domain.getLookupService().getDefaultInstance(ims.clinicaladmin.vo.lookups.CaseTypeProcedure.class, engine.getFormName().getID(), ims.clinicaladmin.vo.lookups.CaseTypeProcedure.TYPE_ID));
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
	
	protected ims.clinicaladmin.domain.CCIAdmin domain;
}
