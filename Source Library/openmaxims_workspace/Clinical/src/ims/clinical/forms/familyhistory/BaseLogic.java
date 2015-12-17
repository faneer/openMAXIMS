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

package ims.clinical.forms.familyhistory;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.FamilyHistory.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.FamilyHistory domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncbRelationshipValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnFamilyHistory().cbRelationship().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkRelationship existingInstance = (ims.core.vo.lookups.SupportNetworkRelationship)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcbRelationshipLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SupportNetworkRelationship)
		{
			ims.core.vo.lookups.SupportNetworkRelationship instance = (ims.core.vo.lookups.SupportNetworkRelationship)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcbRelationshipLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkRelationship existingInstance = (ims.core.vo.lookups.SupportNetworkRelationship)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnFamilyHistory().cbRelationship().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcbRelationshipLookup()
	{
		this.form.ctnFamilyHistory().cbRelationship().clear();
		ims.core.vo.lookups.SupportNetworkRelationshipCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSupportNetworkRelationship(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnFamilyHistory().cbRelationship().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcbRelationshipLookupValue(int id)
	{
		ims.core.vo.lookups.SupportNetworkRelationship instance = ims.core.vo.lookups.LookupHelper.getSupportNetworkRelationshipInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnFamilyHistory().cbRelationship().setValue(instance);
	}
	protected final void defaultcbRelationshipLookupValue()
	{
		this.form.ctnFamilyHistory().cbRelationship().setValue((ims.core.vo.lookups.SupportNetworkRelationship)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SupportNetworkRelationship.class, engine.getFormName().getID(), ims.core.vo.lookups.SupportNetworkRelationship.TYPE_ID));
	}
	protected final void oncbLivingValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnFamilyHistory().cbLiving().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcbLivingLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcbLivingLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnFamilyHistory().cbLiving().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcbLivingLookup()
	{
		this.form.ctnFamilyHistory().cbLiving().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnFamilyHistory().cbLiving().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcbLivingLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnFamilyHistory().cbLiving().setValue(instance);
	}
	protected final void defaultcbLivingLookupValue()
	{
		this.form.ctnFamilyHistory().cbLiving().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgrdListcolRelationshipLookup()
	{
		this.form.grdList().colRelationshipComboBox().clear();
		ims.core.vo.lookups.SupportNetworkRelationshipCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSupportNetworkRelationship(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdList().colRelationshipComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdListcolLivingLookup()
	{
		this.form.grdList().colLivingComboBox().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdList().colLivingComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
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
	
	protected ims.clinical.domain.FamilyHistory domain;
}
