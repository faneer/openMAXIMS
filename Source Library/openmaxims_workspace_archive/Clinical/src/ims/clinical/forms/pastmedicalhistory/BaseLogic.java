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

package ims.clinical.forms.pastmedicalhistory;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.PastMedicalHistory.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.PastMedicalHistory domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbSourceOfInformationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfInformation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfInformationLookup();
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
					bindcmbSourceOfInformationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceofInformation existingInstance = (ims.core.vo.lookups.SourceofInformation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfInformation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfInformationLookup()
	{
		this.form.cmbSourceOfInformation().clear();
		ims.core.vo.lookups.SourceofInformationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceofInformation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfInformation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfInformationLookupValue(int id)
	{
		ims.core.vo.lookups.SourceofInformation instance = ims.core.vo.lookups.LookupHelper.getSourceofInformationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfInformation().setValue(instance);
	}
	protected final void defaultcmbSourceOfInformationLookupValue()
	{
		this.form.cmbSourceOfInformation().setValue((ims.core.vo.lookups.SourceofInformation)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceofInformation.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceofInformation.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.PastMedicalHistory domain;
}
