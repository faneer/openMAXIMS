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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.forms.hcpadmin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.HcpAdmin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.HcpAdmin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTitleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDemog().cmbTitle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTitleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PersonTitle)
		{
			ims.core.vo.lookups.PersonTitle instance = (ims.core.vo.lookups.PersonTitle)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTitleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDemog().cmbTitle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTitleLookup()
	{
		this.form.ctnDemog().cmbTitle().clear();
		ims.core.vo.lookups.PersonTitleCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPersonTitle(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDemog().cmbTitle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTitleLookupValue(int id)
	{
		ims.core.vo.lookups.PersonTitle instance = ims.core.vo.lookups.LookupHelper.getPersonTitleInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDemog().cmbTitle().setValue(instance);
	}
	protected final void defaultcmbTitleLookupValue()
	{
		this.form.ctnDemog().cmbTitle().setValue((ims.core.vo.lookups.PersonTitle)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PersonTitle.class, engine.getFormName().getID(), ims.core.vo.lookups.PersonTitle.TYPE_ID));
	}
	protected final void oncmbMedicGradeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabMedic().cmbMedicGrade().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicGrade existingInstance = (ims.core.vo.lookups.MedicGrade)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMedicGradeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MedicGrade)
		{
			ims.core.vo.lookups.MedicGrade instance = (ims.core.vo.lookups.MedicGrade)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMedicGradeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicGrade existingInstance = (ims.core.vo.lookups.MedicGrade)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabMedic().cmbMedicGrade().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMedicGradeLookup()
	{
		this.form.lyrDetails().tabMedic().cmbMedicGrade().clear();
		ims.core.vo.lookups.MedicGradeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicGrade(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabMedic().cmbMedicGrade().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMedicGradeLookupValue(int id)
	{
		ims.core.vo.lookups.MedicGrade instance = ims.core.vo.lookups.LookupHelper.getMedicGradeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabMedic().cmbMedicGrade().setValue(instance);
	}
	protected final void defaultcmbMedicGradeLookupValue()
	{
		this.form.lyrDetails().tabMedic().cmbMedicGrade().setValue((ims.core.vo.lookups.MedicGrade)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MedicGrade.class, engine.getFormName().getID(), ims.core.vo.lookups.MedicGrade.TYPE_ID));
	}
	protected final void oncmbMedicSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabMedic().cmbMedicSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMedicSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMedicSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabMedic().cmbMedicSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMedicSpecialtyLookup()
	{
		this.form.lyrDetails().tabMedic().cmbMedicSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabMedic().cmbMedicSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMedicSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabMedic().cmbMedicSpecialty().setValue(instance);
	}
	protected final void defaultcmbMedicSpecialtyLookupValue()
	{
		this.form.lyrDetails().tabMedic().cmbMedicSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	protected final void oncmbTherapistSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTherapistSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTherapistSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTherapistSpecialtyLookup()
	{
		this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTherapistSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().setValue(instance);
	}
	protected final void defaultcmbTherapistSpecialtyLookupValue()
	{
		this.form.lyrDetails().tabTherapist().cmbTherapistSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	protected final void oncmbNurseSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabNurse().cmbNurseSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbNurseSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbNurseSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabNurse().cmbNurseSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbNurseSpecialtyLookup()
	{
		this.form.lyrDetails().tabNurse().cmbNurseSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabNurse().cmbNurseSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbNurseSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabNurse().cmbNurseSpecialty().setValue(instance);
	}
	protected final void defaultcmbNurseSpecialtyLookupValue()
	{
		this.form.lyrDetails().tabNurse().cmbNurseSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.HcpAdmin domain;
}
