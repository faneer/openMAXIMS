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

package ims.admin.forms.rchtmanualdischargedialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.RCHTManualDischargeDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.RCHTManualDischargeDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbDestinationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDestination().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDestinationLookup();
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
					bindcmbDestinationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DischargeDestination existingInstance = (ims.coe.vo.lookups.DischargeDestination)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDestination().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDestinationLookup()
	{
		this.form.cmbDestination().clear();
		ims.coe.vo.lookups.DischargeDestinationCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDischargeDestination(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDestination().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDestinationLookupValue(int id)
	{
		ims.coe.vo.lookups.DischargeDestination instance = ims.coe.vo.lookups.LookupHelper.getDischargeDestinationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDestination().setValue(instance);
	}
	protected final void defaultcmbDestinationLookupValue()
	{
		this.form.cmbDestination().setValue((ims.coe.vo.lookups.DischargeDestination)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DischargeDestination.class, engine.getFormName().getID(), ims.coe.vo.lookups.DischargeDestination.TYPE_ID));
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
					ims.core.vo.lookups.MethodOfDischarge existingInstance = (ims.core.vo.lookups.MethodOfDischarge)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MethodOfDischarge)
		{
			ims.core.vo.lookups.MethodOfDischarge instance = (ims.core.vo.lookups.MethodOfDischarge)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MethodOfDischarge existingInstance = (ims.core.vo.lookups.MethodOfDischarge)listOfValues.get(x);
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
		ims.core.vo.lookups.MethodOfDischargeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMethodOfDischarge(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMethodLookupValue(int id)
	{
		ims.core.vo.lookups.MethodOfDischarge instance = ims.core.vo.lookups.LookupHelper.getMethodOfDischargeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMethod().setValue(instance);
	}
	protected final void defaultcmbMethodLookupValue()
	{
		this.form.cmbMethod().setValue((ims.core.vo.lookups.MethodOfDischarge)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MethodOfDischarge.class, engine.getFormName().getID(), ims.core.vo.lookups.MethodOfDischarge.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.RCHTManualDischargeDialog domain;
}
