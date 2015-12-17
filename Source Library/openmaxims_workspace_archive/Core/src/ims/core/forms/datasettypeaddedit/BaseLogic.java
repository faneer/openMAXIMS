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

package ims.core.forms.datasettypeaddedit;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.DataSetTypeAddEdit.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.DataSetTypeAddEdit domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbUnitOfMeasureValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUnitOfMeasure().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.ResultUnitOfMeasure existingInstance = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUnitOfMeasureLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.ResultUnitOfMeasure)
		{
			ims.ocrr.vo.lookups.ResultUnitOfMeasure instance = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUnitOfMeasureLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.ResultUnitOfMeasure existingInstance = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUnitOfMeasure().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUnitOfMeasureLookup()
	{
		this.form.cmbUnitOfMeasure().clear();
		ims.ocrr.vo.lookups.ResultUnitOfMeasureCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getResultUnitOfMeasure(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUnitOfMeasure().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUnitOfMeasureLookupValue(int id)
	{
		ims.ocrr.vo.lookups.ResultUnitOfMeasure instance = ims.ocrr.vo.lookups.LookupHelper.getResultUnitOfMeasureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUnitOfMeasure().setValue(instance);
	}
	protected final void defaultcmbUnitOfMeasureLookupValue()
	{
		this.form.cmbUnitOfMeasure().setValue((ims.ocrr.vo.lookups.ResultUnitOfMeasure)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.ResultUnitOfMeasure.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.ResultUnitOfMeasure.TYPE_ID));
	}
	protected final void oncmbLineTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbLineType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LineType existingInstance = (ims.core.vo.lookups.LineType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLineTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LineType)
		{
			ims.core.vo.lookups.LineType instance = (ims.core.vo.lookups.LineType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLineTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LineType existingInstance = (ims.core.vo.lookups.LineType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbLineType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLineTypeLookup()
	{
		this.form.cmbLineType().clear();
		ims.core.vo.lookups.LineTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLineType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbLineType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLineTypeLookupValue(int id)
	{
		ims.core.vo.lookups.LineType instance = ims.core.vo.lookups.LookupHelper.getLineTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbLineType().setValue(instance);
	}
	protected final void defaultcmbLineTypeLookupValue()
	{
		this.form.cmbLineType().setValue((ims.core.vo.lookups.LineType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LineType.class, engine.getFormName().getID(), ims.core.vo.lookups.LineType.TYPE_ID));
	}
	protected final void oncmbColourIconValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbColourIcon().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LineColourPointIcon existingInstance = (ims.core.vo.lookups.LineColourPointIcon)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbColourIconLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LineColourPointIcon)
		{
			ims.core.vo.lookups.LineColourPointIcon instance = (ims.core.vo.lookups.LineColourPointIcon)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbColourIconLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LineColourPointIcon existingInstance = (ims.core.vo.lookups.LineColourPointIcon)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbColourIcon().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbColourIconLookup()
	{
		this.form.cmbColourIcon().clear();
		ims.core.vo.lookups.LineColourPointIconCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLineColourPointIcon(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbColourIcon().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbColourIconLookupValue(int id)
	{
		ims.core.vo.lookups.LineColourPointIcon instance = ims.core.vo.lookups.LookupHelper.getLineColourPointIconInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbColourIcon().setValue(instance);
	}
	protected final void defaultcmbColourIconLookupValue()
	{
		this.form.cmbColourIcon().setValue((ims.core.vo.lookups.LineColourPointIcon)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LineColourPointIcon.class, engine.getFormName().getID(), ims.core.vo.lookups.LineColourPointIcon.TYPE_ID));
	}
	protected final void oncmbCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DataSetCategory existingInstance = (ims.core.vo.lookups.DataSetCategory)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DataSetCategory)
		{
			ims.core.vo.lookups.DataSetCategory instance = (ims.core.vo.lookups.DataSetCategory)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DataSetCategory existingInstance = (ims.core.vo.lookups.DataSetCategory)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCategoryLookup()
	{
		this.form.cmbCategory().clear();
		ims.core.vo.lookups.DataSetCategoryCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDataSetCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCategoryLookupValue(int id)
	{
		ims.core.vo.lookups.DataSetCategory instance = ims.core.vo.lookups.LookupHelper.getDataSetCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCategory().setValue(instance);
	}
	protected final void defaultcmbCategoryLookupValue()
	{
		this.form.cmbCategory().setValue((ims.core.vo.lookups.DataSetCategory)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DataSetCategory.class, engine.getFormName().getID(), ims.core.vo.lookups.DataSetCategory.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.cmbUnitOfMeasure().setValue(null);
		this.form.chkActive().setValue(false);
		this.form.decMinFemale().setValue(null);
		this.form.decMaxFemale().setValue(null);
		this.form.decBandMinValue().setValue(null);
		this.form.decBandMaxValue().setValue(null);
		this.form.intMinFactor().setValue(null);
		this.form.intMaxFactor().setValue(null);
		this.form.cmbLineType().setValue(null);
		this.form.cmbColourIcon().setValue(null);
		this.form.cmbCategory().setValue(null);
		this.form.txtName().setValue("");
	}
	protected void populateScreenFromData(ims.core.vo.DataSetTypeVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbUnitOfMeasure().setValue(value.getUnitOfMeasureIsNotNull() ? value.getUnitOfMeasure() : null);
		if(value.getIsActiveIsNotNull())
			this.form.chkActive().setValue(value.getIsActive().booleanValue());
		this.form.decMinFemale().setValue(value.getNormalBandMinValueFemaleIsNotNull() ? value.getNormalBandMinValueFemale() : null);
		this.form.decMaxFemale().setValue(value.getNormalBandMaxValueFemaleIsNotNull() ? value.getNormalBandMaxValueFemale() : null);
		this.form.decBandMinValue().setValue(value.getNormalBandMinValueMaleIsNotNull() ? value.getNormalBandMinValueMale() : null);
		this.form.decBandMaxValue().setValue(value.getNormalBandMaxValueMaleIsNotNull() ? value.getNormalBandMaxValueMale() : null);
		this.form.intMinFactor().setValue(value.getMinFactorIsNotNull() ? value.getMinFactor() : null);
		this.form.intMaxFactor().setValue(value.getMaxFactorIsNotNull() ? value.getMaxFactor() : null);
		this.form.cmbLineType().setValue(value.getDefaultLineTypeIsNotNull() ? value.getDefaultLineType() : null);
		this.form.cmbColourIcon().setValue(value.getDefLineColPtIconIsNotNull() ? value.getDefLineColPtIcon() : null);
		this.form.cmbCategory().setValue(value.getCategoryIsNotNull() ? value.getCategory() : null);
		this.form.txtName().setValue(value.getNameIsNotNull() ? value.getName(): null);
	}
	protected ims.core.vo.DataSetTypeVo populateDataFromScreen(ims.core.vo.DataSetTypeVo value)
	{
		if(value == null)
			value = new ims.core.vo.DataSetTypeVo();

		value.setUnitOfMeasure(this.form.cmbUnitOfMeasure().getValue());
		value.setIsActive(new Boolean(this.form.chkActive().getValue()));
		value.setNormalBandMinValueFemale(this.form.decMinFemale().getValue());
		value.setNormalBandMaxValueFemale(this.form.decMaxFemale().getValue());
		value.setNormalBandMinValueMale(this.form.decBandMinValue().getValue());
		value.setNormalBandMaxValueMale(this.form.decBandMaxValue().getValue());
		value.setMinFactor(this.form.intMinFactor().getValue());
		value.setMaxFactor(this.form.intMaxFactor().getValue());
		value.setDefaultLineType(this.form.cmbLineType().getValue());
		value.setDefLineColPtIcon(this.form.cmbColourIcon().getValue());
		value.setCategory(this.form.cmbCategory().getValue());
		value.setName(this.form.txtName().getValue());

		return value;
	}
	protected ims.core.vo.DataSetTypeVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.DataSetTypeVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.DataSetTypeAddEdit domain;
}
