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

package ims.core.forms.vitalsignsbloodsugar;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.VitalSignsBloodSugar.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.VitalSignsBloodSugar domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTimePeriodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTimePeriod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CBGMTimePeriod existingInstance = (ims.core.vo.lookups.CBGMTimePeriod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTimePeriodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.CBGMTimePeriod)
		{
			ims.core.vo.lookups.CBGMTimePeriod instance = (ims.core.vo.lookups.CBGMTimePeriod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTimePeriodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CBGMTimePeriod existingInstance = (ims.core.vo.lookups.CBGMTimePeriod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTimePeriod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTimePeriodLookup()
	{
		this.form.cmbTimePeriod().clear();
		ims.core.vo.lookups.CBGMTimePeriodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getCBGMTimePeriod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTimePeriod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTimePeriodLookupValue(int id)
	{
		ims.core.vo.lookups.CBGMTimePeriod instance = ims.core.vo.lookups.LookupHelper.getCBGMTimePeriodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTimePeriod().setValue(instance);
	}
	protected final void defaultcmbTimePeriodLookupValue()
	{
		this.form.cmbTimePeriod().setValue((ims.core.vo.lookups.CBGMTimePeriod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.CBGMTimePeriod.class, engine.getFormName().getID(), ims.core.vo.lookups.CBGMTimePeriod.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.decBloodSugar().setValue(null);
	}
	protected void populateScreenFromData(ims.core.vo.VSBloodSugar value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.decBloodSugar().setValue(value.getBloodSugarValueIsNotNull() ? value.getBloodSugarValue() : null);
	}
	protected ims.core.vo.VSBloodSugar populateDataFromScreen(ims.core.vo.VSBloodSugar value)
	{
		if(value == null)
			value = new ims.core.vo.VSBloodSugar();

		value.setBloodSugarValue(this.form.decBloodSugar().getValue());

		return value;
	}
	protected ims.core.vo.VSBloodSugar populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.VSBloodSugar());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.VitalSignsBloodSugar domain;
}
