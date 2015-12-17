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

package ims.emergency.forms.quickregistration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.QuickRegistration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.QuickRegistration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbSourceOfReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferredBy existingInstance = (ims.emergency.vo.lookups.ReferredBy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.ReferredBy)
		{
			ims.emergency.vo.lookups.ReferredBy instance = (ims.emergency.vo.lookups.ReferredBy)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferredBy existingInstance = (ims.emergency.vo.lookups.ReferredBy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfReferral().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfReferralLookup()
	{
		this.form.cmbSourceOfReferral().clear();
		ims.emergency.vo.lookups.ReferredByCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getReferredBy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfReferral().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfReferralLookupValue(int id)
	{
		ims.emergency.vo.lookups.ReferredBy instance = ims.emergency.vo.lookups.LookupHelper.getReferredByInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfReferral().setValue(instance);
	}
	protected final void defaultcmbSourceOfReferralLookupValue()
	{
		this.form.cmbSourceOfReferral().setValue((ims.emergency.vo.lookups.ReferredBy)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.ReferredBy.class, engine.getFormName().getID(), ims.emergency.vo.lookups.ReferredBy.TYPE_ID));
	}
	protected final void oncmbRegistrationTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbRegistrationType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.QuickRegistrationType existingInstance = (ims.emergency.vo.lookups.QuickRegistrationType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRegistrationTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.QuickRegistrationType)
		{
			ims.emergency.vo.lookups.QuickRegistrationType instance = (ims.emergency.vo.lookups.QuickRegistrationType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRegistrationTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.QuickRegistrationType existingInstance = (ims.emergency.vo.lookups.QuickRegistrationType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbRegistrationType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRegistrationTypeLookup()
	{
		this.form.cmbRegistrationType().clear();
		ims.emergency.vo.lookups.QuickRegistrationTypeCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getQuickRegistrationType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbRegistrationType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRegistrationTypeLookupValue(int id)
	{
		ims.emergency.vo.lookups.QuickRegistrationType instance = ims.emergency.vo.lookups.LookupHelper.getQuickRegistrationTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbRegistrationType().setValue(instance);
	}
	protected final void defaultcmbRegistrationTypeLookupValue()
	{
		this.form.cmbRegistrationType().setValue((ims.emergency.vo.lookups.QuickRegistrationType)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.QuickRegistrationType.class, engine.getFormName().getID(), ims.emergency.vo.lookups.QuickRegistrationType.TYPE_ID));
	}
	protected final void oncmbGenderValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbGender().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbGenderLookup();
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
					bindcmbGenderLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbGender().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbGenderLookup()
	{
		this.form.cmbGender().clear();
		ims.core.vo.lookups.SexCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSex(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbGender().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbGenderLookupValue(int id)
	{
		ims.core.vo.lookups.Sex instance = ims.core.vo.lookups.LookupHelper.getSexInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbGender().setValue(instance);
	}
	protected final void defaultcmbGenderLookupValue()
	{
		this.form.cmbGender().setValue((ims.core.vo.lookups.Sex)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Sex.class, engine.getFormName().getID(), ims.core.vo.lookups.Sex.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.QuickRegistration domain;
}
