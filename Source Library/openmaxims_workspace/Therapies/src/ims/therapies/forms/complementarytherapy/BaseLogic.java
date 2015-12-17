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

package ims.therapies.forms.complementarytherapy;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.ComplementaryTherapy.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.ComplementaryTherapy domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbComplementaryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.ComplementaryTherapy existingInstance = (ims.spinalinjuries.vo.lookups.ComplementaryTherapy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbComplementaryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.ComplementaryTherapy)
		{
			ims.spinalinjuries.vo.lookups.ComplementaryTherapy instance = (ims.spinalinjuries.vo.lookups.ComplementaryTherapy)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbComplementaryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.ComplementaryTherapy existingInstance = (ims.spinalinjuries.vo.lookups.ComplementaryTherapy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbComplementaryLookup()
	{
		this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().clear();
		ims.spinalinjuries.vo.lookups.ComplementaryTherapyCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getComplementaryTherapy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbComplementaryLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.ComplementaryTherapy instance = ims.spinalinjuries.vo.lookups.LookupHelper.getComplementaryTherapyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().setValue(instance);
	}
	protected final void defaultcmbComplementaryLookupValue()
	{
		this.form.ctnTherapy().lyrTherapy().tabDetails().cmbComplementary().setValue((ims.spinalinjuries.vo.lookups.ComplementaryTherapy)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.ComplementaryTherapy.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.ComplementaryTherapy.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.ComplementaryTherapy domain;
}
