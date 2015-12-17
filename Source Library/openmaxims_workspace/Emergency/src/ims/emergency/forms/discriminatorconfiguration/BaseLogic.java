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

package ims.emergency.forms.discriminatorconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.DiscriminatorConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.DiscriminatorConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbDefaultPriorityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDefaultPriority().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TriagePriority existingInstance = (ims.emergency.vo.lookups.TriagePriority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDefaultPriorityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.TriagePriority)
		{
			ims.emergency.vo.lookups.TriagePriority instance = (ims.emergency.vo.lookups.TriagePriority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDefaultPriorityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TriagePriority existingInstance = (ims.emergency.vo.lookups.TriagePriority)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDefaultPriority().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDefaultPriorityLookup()
	{
		this.form.cmbDefaultPriority().clear();
		ims.emergency.vo.lookups.TriagePriorityCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getTriagePriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDefaultPriority().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDefaultPriorityLookupValue(int id)
	{
		ims.emergency.vo.lookups.TriagePriority instance = ims.emergency.vo.lookups.LookupHelper.getTriagePriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDefaultPriority().setValue(instance);
	}
	protected final void defaultcmbDefaultPriorityLookupValue()
	{
		this.form.cmbDefaultPriority().setValue((ims.emergency.vo.lookups.TriagePriority)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.TriagePriority.class, engine.getFormName().getID(), ims.emergency.vo.lookups.TriagePriority.TYPE_ID));
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
	
	protected ims.emergency.domain.DiscriminatorConfiguration domain;
}
