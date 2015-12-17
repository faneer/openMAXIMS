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

package ims.core.forms.adtdischargedialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.AdtDischargeDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.AdtDischargeDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbMethodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMethod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeMethod existingInstance = (ims.core.vo.lookups.DischargeMethod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DischargeMethod)
		{
			ims.core.vo.lookups.DischargeMethod instance = (ims.core.vo.lookups.DischargeMethod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeMethod existingInstance = (ims.core.vo.lookups.DischargeMethod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMethod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMethodLookup()
	{
		this.form.cmbMethod().clear();
		ims.core.vo.lookups.DischargeMethodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDischargeMethod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMethodLookupValue(int id)
	{
		ims.core.vo.lookups.DischargeMethod instance = ims.core.vo.lookups.LookupHelper.getDischargeMethodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMethod().setValue(instance);
	}
	protected final void defaultcmbMethodLookupValue()
	{
		this.form.cmbMethod().setValue((ims.core.vo.lookups.DischargeMethod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DischargeMethod.class, engine.getFormName().getID(), ims.core.vo.lookups.DischargeMethod.TYPE_ID));
	}
	protected final void oncmbDestValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDest().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDestLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DischargeDestination)
		{
			ims.coe.vo.lookups.DischargeDestination instance = (ims.coe.vo.lookups.DischargeDestination)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDestLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDest().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDestLookup()
	{
		this.form.cmbDest().clear();
		ims.coe.vo.lookups.DischargeDestinationCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDischargeDestination(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDest().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDestLookupValue(int id)
	{
		ims.coe.vo.lookups.DischargeDestination instance = ims.coe.vo.lookups.LookupHelper.getDischargeDestinationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDest().setValue(instance);
	}
	protected final void defaultcmbDestLookupValue()
	{
		this.form.cmbDest().setValue((ims.coe.vo.lookups.DischargeDestination)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DischargeDestination.class, engine.getFormName().getID(), ims.coe.vo.lookups.DischargeDestination.TYPE_ID));
	}
	protected final void oncmbOutcomeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOutcome().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeOutcome existingInstance = (ims.core.vo.lookups.DischargeOutcome)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOutcomeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DischargeOutcome)
		{
			ims.core.vo.lookups.DischargeOutcome instance = (ims.core.vo.lookups.DischargeOutcome)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOutcomeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeOutcome existingInstance = (ims.core.vo.lookups.DischargeOutcome)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOutcome().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOutcomeLookup()
	{
		this.form.cmbOutcome().clear();
		ims.core.vo.lookups.DischargeOutcomeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDischargeOutcome(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOutcome().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOutcomeLookupValue(int id)
	{
		ims.core.vo.lookups.DischargeOutcome instance = ims.core.vo.lookups.LookupHelper.getDischargeOutcomeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOutcome().setValue(instance);
	}
	protected final void defaultcmbOutcomeLookupValue()
	{
		this.form.cmbOutcome().setValue((ims.core.vo.lookups.DischargeOutcome)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DischargeOutcome.class, engine.getFormName().getID(), ims.core.vo.lookups.DischargeOutcome.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.AdtDischargeDialog domain;
}
