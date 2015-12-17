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

package ims.admin.forms.navigationadminprot;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.NavigationAdminProt.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.NavigationAdminProt domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbStyleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStyle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.admin.vo.lookups.NavigationStyle existingInstance = (ims.admin.vo.lookups.NavigationStyle)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStyleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.admin.vo.lookups.NavigationStyle)
		{
			ims.admin.vo.lookups.NavigationStyle instance = (ims.admin.vo.lookups.NavigationStyle)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStyleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.admin.vo.lookups.NavigationStyle existingInstance = (ims.admin.vo.lookups.NavigationStyle)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStyle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStyleLookup()
	{
		this.form.cmbStyle().clear();
		ims.admin.vo.lookups.NavigationStyleCollection lookupCollection = ims.admin.vo.lookups.LookupHelper.getNavigationStyle(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStyle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStyleLookupValue(int id)
	{
		ims.admin.vo.lookups.NavigationStyle instance = ims.admin.vo.lookups.LookupHelper.getNavigationStyleInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStyle().setValue(instance);
	}
	protected final void defaultcmbStyleLookupValue()
	{
		this.form.cmbStyle().setValue((ims.admin.vo.lookups.NavigationStyle)domain.getLookupService().getDefaultInstance(ims.admin.vo.lookups.NavigationStyle.class, engine.getFormName().getID(), ims.admin.vo.lookups.NavigationStyle.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.cmbStyle().setValue(null);
		this.form.qmbNavSearchForm().setValue(null);
		this.form.qmbNavStartForm().setValue(null);
		this.form.chkIsActive().setValue(false);
		this.form.txtNavName().setValue("");
	}
	protected void populateScreenFromData(ims.admin.vo.AppNavigationVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbStyle().setValue(value.getStyleIsNotNull() ? value.getStyle() : null);
		this.form.qmbNavSearchForm().setValue(value.getPatientSearchFormIsNotNull() ? value.getPatientSearchForm() : null);
		this.form.qmbNavStartForm().setValue(value.getStartFormIsNotNull() ? value.getStartForm() : null);
		if(value.getIsActiveIsNotNull())
			this.form.chkIsActive().setValue(value.getIsActive().booleanValue());
		this.form.txtNavName().setValue(value.getNavigationNameIsNotNull() ? value.getNavigationName(): null);
	}
	protected ims.admin.vo.AppNavigationVo populateDataFromScreen(ims.admin.vo.AppNavigationVo value)
	{
		if(value == null)
			value = new ims.admin.vo.AppNavigationVo();

		value.setStyle(this.form.cmbStyle().getValue());
		value.setPatientSearchForm(this.form.qmbNavSearchForm().getValue());
		value.setStartForm(this.form.qmbNavStartForm().getValue());
		value.setIsActive(new Boolean(this.form.chkIsActive().getValue()));
		value.setNavigationName(this.form.txtNavName().getValue());

		return value;
	}
	protected ims.admin.vo.AppNavigationVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.admin.vo.AppNavigationVo());
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
	
	protected ims.admin.domain.NavigationAdminProt domain;
}
