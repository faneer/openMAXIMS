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

package ims.clinical.forms.edischargeallergiesetccomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.EDischargeAllergiesEtcComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.clinical.domain.EDischargeAllergiesEtcComponent domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbAlertSourceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnAlert().cmbAlertSource().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAlertSourceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SourceofInformation)
		{
			ims.core.vo.lookups.SourceofInformation instance = (ims.core.vo.lookups.SourceofInformation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAlertSourceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnAlert().cmbAlertSource().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAlertSourceLookup()
	{
		this.form.ctnAlert().cmbAlertSource().clear();
		ims.core.vo.lookups.SourceofInformationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceofInformation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnAlert().cmbAlertSource().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAlertSourceLookupValue(int id)
	{
		ims.core.vo.lookups.SourceofInformation instance = ims.core.vo.lookups.LookupHelper.getSourceofInformationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnAlert().cmbAlertSource().setValue(instance);
	}
	protected final void defaultcmbAlertSourceLookupValue()
	{
		this.form.ctnAlert().cmbAlertSource().setValue((ims.core.vo.lookups.SourceofInformation)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceofInformation.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceofInformation.TYPE_ID));
	}
	protected final void oncmbAllergyTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnAllergy().cmbAllergyType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AllergenType existingInstance = (ims.core.vo.lookups.AllergenType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAllergyTypeLookup();
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
					bindcmbAllergyTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AllergenType existingInstance = (ims.core.vo.lookups.AllergenType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnAllergy().cmbAllergyType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAllergyTypeLookup()
	{
		this.form.ctnAllergy().cmbAllergyType().clear();
		ims.core.vo.lookups.AllergenTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAllergenType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnAllergy().cmbAllergyType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAllergyTypeLookupValue(int id)
	{
		ims.core.vo.lookups.AllergenType instance = ims.core.vo.lookups.LookupHelper.getAllergenTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnAllergy().cmbAllergyType().setValue(instance);
	}
	protected final void defaultcmbAllergyTypeLookupValue()
	{
		this.form.ctnAllergy().cmbAllergyType().setValue((ims.core.vo.lookups.AllergenType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.AllergenType.class, engine.getFormName().getID(), ims.core.vo.lookups.AllergenType.TYPE_ID));
	}
	protected final void oncmbAllergySourceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnAllergy().cmbAllergySource().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAllergySourceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SourceofInformation)
		{
			ims.core.vo.lookups.SourceofInformation instance = (ims.core.vo.lookups.SourceofInformation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAllergySourceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnAllergy().cmbAllergySource().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAllergySourceLookup()
	{
		this.form.ctnAllergy().cmbAllergySource().clear();
		ims.core.vo.lookups.SourceofInformationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceofInformation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnAllergy().cmbAllergySource().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAllergySourceLookupValue(int id)
	{
		ims.core.vo.lookups.SourceofInformation instance = ims.core.vo.lookups.LookupHelper.getSourceofInformationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnAllergy().cmbAllergySource().setValue(instance);
	}
	protected final void defaultcmbAllergySourceLookupValue()
	{
		this.form.ctnAllergy().cmbAllergySource().setValue((ims.core.vo.lookups.SourceofInformation)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceofInformation.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceofInformation.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.EDischargeAllergiesEtcComponent domain;
}
