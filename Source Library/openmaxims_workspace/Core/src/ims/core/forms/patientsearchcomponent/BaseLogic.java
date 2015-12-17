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

package ims.core.forms.patientsearchcomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.PatientSearchComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.core.domain.PatientSearchComponent domain)
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
	protected final void oncmbCountyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCounty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCountyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ntpf.vo.lookups.County)
		{
			ims.ntpf.vo.lookups.County instance = (ims.ntpf.vo.lookups.County)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCountyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCounty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCountyLookup()
	{
		this.form.cmbCounty().clear();
		ims.ntpf.vo.lookups.CountyCollection lookupCollection = ims.ntpf.vo.lookups.LookupHelper.getCounty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCounty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCountyLookupValue(int id)
	{
		ims.ntpf.vo.lookups.County instance = ims.ntpf.vo.lookups.LookupHelper.getCountyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCounty().setValue(instance);
	}
	protected final void defaultcmbCountyLookupValue()
	{
		this.form.cmbCounty().setValue((ims.ntpf.vo.lookups.County)domain.getLookupService().getDefaultInstance(ims.ntpf.vo.lookups.County.class, engine.getFormName().getID(), ims.ntpf.vo.lookups.County.TYPE_ID));
	}
	protected final void onPatientIDValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.PatientID().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindPatientIDLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindPatientIDLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.PatientID().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindPatientIDLookup()
	{
		this.form.PatientID().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.PatientID().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setPatientIDLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.PatientID().setValue(instance);
	}
	protected final void defaultPatientIDLookupValue()
	{
		this.form.PatientID().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void onSexValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.Sex().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindSexLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Sex)
		{
			ims.core.vo.lookups.Sex instance = (ims.core.vo.lookups.Sex)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindSexLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.Sex().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindSexLookup()
	{
		this.form.Sex().clear();
		ims.core.vo.lookups.SexCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSex(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.Sex().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setSexLookupValue(int id)
	{
		ims.core.vo.lookups.Sex instance = ims.core.vo.lookups.LookupHelper.getSexInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.Sex().setValue(instance);
	}
	protected final void defaultSexLookupValue()
	{
		this.form.Sex().setValue((ims.core.vo.lookups.Sex)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Sex.class, engine.getFormName().getID(), ims.core.vo.lookups.Sex.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.PatientSearchComponent domain;
}
