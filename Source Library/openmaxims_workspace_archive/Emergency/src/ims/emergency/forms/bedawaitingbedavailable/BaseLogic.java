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

package ims.emergency.forms.bedawaitingbedavailable;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.BedAwaitingBedAvailable.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.BedAwaitingBedAvailable domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbDTABedTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDTABedType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.BedTypeRequested existingInstance = (ims.core.vo.lookups.BedTypeRequested)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDTABedTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.BedTypeRequested)
		{
			ims.core.vo.lookups.BedTypeRequested instance = (ims.core.vo.lookups.BedTypeRequested)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDTABedTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.BedTypeRequested existingInstance = (ims.core.vo.lookups.BedTypeRequested)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDTABedType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDTABedTypeLookup()
	{
		this.form.cmbDTABedType().clear();
		ims.core.vo.lookups.BedTypeRequestedCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getBedTypeRequested(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDTABedType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDTABedTypeLookupValue(int id)
	{
		ims.core.vo.lookups.BedTypeRequested instance = ims.core.vo.lookups.LookupHelper.getBedTypeRequestedInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDTABedType().setValue(instance);
	}
	protected final void defaultcmbDTABedTypeLookupValue()
	{
		this.form.cmbDTABedType().setValue((ims.core.vo.lookups.BedTypeRequested)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.BedTypeRequested.class, engine.getFormName().getID(), ims.core.vo.lookups.BedTypeRequested.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.BedAwaitingBedAvailable domain;
}
