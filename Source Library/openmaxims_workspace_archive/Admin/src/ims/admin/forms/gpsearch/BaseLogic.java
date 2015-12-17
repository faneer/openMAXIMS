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

package ims.admin.forms.gpsearch;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.GPSearch.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.admin.domain.GPSearch domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.GPStatus existingInstance = (ims.core.vo.lookups.GPStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.GPStatus)
		{
			ims.core.vo.lookups.GPStatus instance = (ims.core.vo.lookups.GPStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.GPStatus existingInstance = (ims.core.vo.lookups.GPStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.core.vo.lookups.GPStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getGPStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.core.vo.lookups.GPStatus instance = ims.core.vo.lookups.LookupHelper.getGPStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.core.vo.lookups.GPStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.GPStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.GPStatus.TYPE_ID));
	}
	protected final void oncmbSearchCodeTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSearchCodeType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TaxonomyType existingInstance = (ims.core.vo.lookups.TaxonomyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSearchCodeTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.TaxonomyType)
		{
			ims.core.vo.lookups.TaxonomyType instance = (ims.core.vo.lookups.TaxonomyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSearchCodeTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TaxonomyType existingInstance = (ims.core.vo.lookups.TaxonomyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSearchCodeType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSearchCodeTypeLookup()
	{
		this.form.cmbSearchCodeType().clear();
		ims.core.vo.lookups.TaxonomyTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTaxonomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSearchCodeType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSearchCodeTypeLookupValue(int id)
	{
		ims.core.vo.lookups.TaxonomyType instance = ims.core.vo.lookups.LookupHelper.getTaxonomyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSearchCodeType().setValue(instance);
	}
	protected final void defaultcmbSearchCodeTypeLookupValue()
	{
		this.form.cmbSearchCodeType().setValue((ims.core.vo.lookups.TaxonomyType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.TaxonomyType.class, engine.getFormName().getID(), ims.core.vo.lookups.TaxonomyType.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.txtAddressContains().setValue("");
		this.form.txtSearchPracticeName().setValue("");
		this.form.txtSearchCode().setValue("");
		this.form.cmbSearchCodeType().setValue(null);
		this.form.txtSearchForename().setValue("");
		this.form.txtSearchSurname().setValue("");
	}
	protected void populateScreenFromData(ims.admin.vo.GPSearchCriteriaVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.txtAddressContains().setValue(value.getAddressContainsIsNotNull() ? value.getAddressContains(): null);
		this.form.txtSearchPracticeName().setValue(value.getPracticeNameIsNotNull() ? value.getPracticeName(): null);
		this.form.txtSearchCode().setValue(value.getCodeIsNotNull() ? value.getCode(): null);
		this.form.cmbSearchCodeType().setValue(value.getCodeTypeIsNotNull() ? value.getCodeType() : null);
		this.form.txtSearchForename().setValue(value.getForenameIsNotNull() ? value.getForename(): null);
		this.form.txtSearchSurname().setValue(value.getSurnameIsNotNull() ? value.getSurname(): null);
	}
	protected ims.admin.vo.GPSearchCriteriaVo populateDataFromScreen(ims.admin.vo.GPSearchCriteriaVo value)
	{
		if(value == null)
			value = new ims.admin.vo.GPSearchCriteriaVo();

		value.setAddressContains(this.form.txtAddressContains().getValue());
		value.setPracticeName(this.form.txtSearchPracticeName().getValue());
		value.setCode(this.form.txtSearchCode().getValue());
		value.setCodeType(this.form.cmbSearchCodeType().getValue());
		value.setForename(this.form.txtSearchForename().getValue());
		value.setSurname(this.form.txtSearchSurname().getValue());

		return value;
	}
	protected ims.admin.vo.GPSearchCriteriaVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.admin.vo.GPSearchCriteriaVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.GPSearch domain;
}
