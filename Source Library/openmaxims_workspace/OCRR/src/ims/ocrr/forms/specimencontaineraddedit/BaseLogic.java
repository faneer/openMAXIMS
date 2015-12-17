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

package ims.ocrr.forms.specimencontaineraddedit;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ocrr.domain.SpecimenContainerAddEdit.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ocrr.domain.SpecimenContainerAddEdit domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbColourValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbColour().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenColour existingInstance = (ims.ocrr.vo.lookups.SpecimenColour)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbColourLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.SpecimenColour)
		{
			ims.ocrr.vo.lookups.SpecimenColour instance = (ims.ocrr.vo.lookups.SpecimenColour)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbColourLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenColour existingInstance = (ims.ocrr.vo.lookups.SpecimenColour)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbColour().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbColourLookup()
	{
		this.form.cmbColour().clear();
		ims.ocrr.vo.lookups.SpecimenColourCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getSpecimenColour(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbColour().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbColourLookupValue(int id)
	{
		ims.ocrr.vo.lookups.SpecimenColour instance = ims.ocrr.vo.lookups.LookupHelper.getSpecimenColourInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbColour().setValue(instance);
	}
	protected final void defaultcmbColourLookupValue()
	{
		this.form.cmbColour().setValue((ims.ocrr.vo.lookups.SpecimenColour)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.SpecimenColour.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.SpecimenColour.TYPE_ID));
	}
	protected final void oncmbManufacturerValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbManufacturer().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenManufacturer existingInstance = (ims.ocrr.vo.lookups.SpecimenManufacturer)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbManufacturerLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.SpecimenManufacturer)
		{
			ims.ocrr.vo.lookups.SpecimenManufacturer instance = (ims.ocrr.vo.lookups.SpecimenManufacturer)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbManufacturerLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.SpecimenManufacturer existingInstance = (ims.ocrr.vo.lookups.SpecimenManufacturer)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbManufacturer().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbManufacturerLookup()
	{
		this.form.cmbManufacturer().clear();
		ims.ocrr.vo.lookups.SpecimenManufacturerCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getSpecimenManufacturer(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbManufacturer().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbManufacturerLookupValue(int id)
	{
		ims.ocrr.vo.lookups.SpecimenManufacturer instance = ims.ocrr.vo.lookups.LookupHelper.getSpecimenManufacturerInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbManufacturer().setValue(instance);
	}
	protected final void defaultcmbManufacturerLookupValue()
	{
		this.form.cmbManufacturer().setValue((ims.ocrr.vo.lookups.SpecimenManufacturer)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.SpecimenManufacturer.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.SpecimenManufacturer.TYPE_ID));
	}
	protected final void oncmbMaterialValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaterial().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.PathContainerMaterial existingInstance = (ims.ocrr.vo.lookups.PathContainerMaterial)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaterialLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.PathContainerMaterial)
		{
			ims.ocrr.vo.lookups.PathContainerMaterial instance = (ims.ocrr.vo.lookups.PathContainerMaterial)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaterialLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.PathContainerMaterial existingInstance = (ims.ocrr.vo.lookups.PathContainerMaterial)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaterial().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaterialLookup()
	{
		this.form.cmbMaterial().clear();
		ims.ocrr.vo.lookups.PathContainerMaterialCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getPathContainerMaterial(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaterial().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaterialLookupValue(int id)
	{
		ims.ocrr.vo.lookups.PathContainerMaterial instance = ims.ocrr.vo.lookups.LookupHelper.getPathContainerMaterialInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaterial().setValue(instance);
	}
	protected final void defaultcmbMaterialLookupValue()
	{
		this.form.cmbMaterial().setValue((ims.ocrr.vo.lookups.PathContainerMaterial)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.PathContainerMaterial.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.PathContainerMaterial.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.chkActive().setValue(false);
		this.form.txtNotes().setValue("");
		this.form.txtManufacturerRef().setValue("");
		this.form.cmbManufacturer().setValue(null);
		this.form.decAmount().setValue(null);
		this.form.txtName().setValue("");
		this.form.cmbMaterial().setValue(null);
	}
	protected void populateScreenFromData(ims.ocrr.vo.PathSpecimenContainerVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getIsActiveIsNotNull())
			this.form.chkActive().setValue(value.getIsActive().booleanValue());
		this.form.txtNotes().setValue(value.getNotesIsNotNull() ? value.getNotes(): null);
		this.form.txtManufacturerRef().setValue(value.getManufRefNoIsNotNull() ? value.getManufRefNo(): null);
		this.form.cmbManufacturer().setValue(value.getManufacturerIsNotNull() ? value.getManufacturer() : null);
		this.form.decAmount().setValue(value.getVolumeIsNotNull() ? value.getVolume() : null);
		this.form.txtName().setValue(value.getNameIsNotNull() ? value.getName(): null);
		this.form.cmbMaterial().setValue(value.getMaterialIsNotNull() ? value.getMaterial() : null);
	}
	protected ims.ocrr.vo.PathSpecimenContainerVo populateDataFromScreen(ims.ocrr.vo.PathSpecimenContainerVo value)
	{
		if(value == null)
			value = new ims.ocrr.vo.PathSpecimenContainerVo();

		value.setIsActive(new Boolean(this.form.chkActive().getValue()));
		value.setNotes(this.form.txtNotes().getValue());
		value.setManufRefNo(this.form.txtManufacturerRef().getValue());
		value.setManufacturer(this.form.cmbManufacturer().getValue());
		value.setVolume(this.form.decAmount().getValue());
		value.setName(this.form.txtName().getValue());
		value.setMaterial(this.form.cmbMaterial().getValue());

		return value;
	}
	protected ims.ocrr.vo.PathSpecimenContainerVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.ocrr.vo.PathSpecimenContainerVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ocrr.domain.SpecimenContainerAddEdit domain;
}
