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

package ims.correspondence.forms.glossaryadmin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.correspondence.domain.GlossaryAdmin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.correspondence.domain.GlossaryAdmin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdGlossarycolCategoryLookup()
	{
		this.form.lyrGlossary().tabGlossaryDef().grdGlossary().colCategoryComboBox().clear();
		ims.correspondence.vo.lookups.GlossaryCategoryCollection lookupCollection = ims.correspondence.vo.lookups.LookupHelper.getGlossaryCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrGlossary().tabGlossaryDef().grdGlossary().colCategoryComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdGlossaryProfilecolCategoryLookup()
	{
		this.form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().colCategoryComboBox().clear();
		ims.correspondence.vo.lookups.GlossaryCategoryCollection lookupCollection = ims.correspondence.vo.lookups.LookupHelper.getGlossaryCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().colCategoryComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbProfileTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.correspondence.vo.lookups.ProfileType existingInstance = (ims.correspondence.vo.lookups.ProfileType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbProfileTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.correspondence.vo.lookups.ProfileType)
		{
			ims.correspondence.vo.lookups.ProfileType instance = (ims.correspondence.vo.lookups.ProfileType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbProfileTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.correspondence.vo.lookups.ProfileType existingInstance = (ims.correspondence.vo.lookups.ProfileType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbProfileTypeLookup()
	{
		this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().clear();
		ims.correspondence.vo.lookups.ProfileTypeCollection lookupCollection = ims.correspondence.vo.lookups.LookupHelper.getProfileType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbProfileTypeLookupValue(int id)
	{
		ims.correspondence.vo.lookups.ProfileType instance = ims.correspondence.vo.lookups.LookupHelper.getProfileTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().setValue(instance);
	}
	protected final void defaultcmbProfileTypeLookupValue()
	{
		this.form.lyrGlossary().tabGlossaryProfile().cmbProfileType().setValue((ims.correspondence.vo.lookups.ProfileType)domain.getLookupService().getDefaultInstance(ims.correspondence.vo.lookups.ProfileType.class, engine.getFormName().getID(), ims.correspondence.vo.lookups.ProfileType.TYPE_ID));
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
	
	protected ims.correspondence.domain.GlossaryAdmin domain;
}
