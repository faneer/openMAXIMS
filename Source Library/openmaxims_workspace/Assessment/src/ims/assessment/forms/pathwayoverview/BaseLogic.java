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

package ims.assessment.forms.pathwayoverview;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.assessment.domain.PathwayOverview.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.assessment.domain.PathwayOverview domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbPathwayValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPathway().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ContextType existingInstance = (ims.core.vo.lookups.ContextType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPathwayLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ContextType)
		{
			ims.core.vo.lookups.ContextType instance = (ims.core.vo.lookups.ContextType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPathwayLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ContextType existingInstance = (ims.core.vo.lookups.ContextType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPathway().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPathwayLookup()
	{
		this.form.cmbPathway().clear();
		ims.core.vo.lookups.ContextTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getContextType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPathway().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPathwayLookupValue(int id)
	{
		ims.core.vo.lookups.ContextType instance = ims.core.vo.lookups.LookupHelper.getContextTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPathway().setValue(instance);
	}
	protected final void defaultcmbPathwayLookupValue()
	{
		this.form.cmbPathway().setValue((ims.core.vo.lookups.ContextType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ContextType.class, engine.getFormName().getID(), ims.core.vo.lookups.ContextType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.assessment.domain.PathwayOverview domain;
}
