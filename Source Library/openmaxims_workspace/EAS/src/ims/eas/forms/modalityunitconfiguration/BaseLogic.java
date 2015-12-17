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

package ims.eas.forms.modalityunitconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.eas.domain.ModalityUnitConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.eas.domain.ModalityUnitConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbUnitSearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUnitSearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Unit existingInstance = (ims.ccosched.vo.lookups.Unit)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUnitSearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Unit)
		{
			ims.ccosched.vo.lookups.Unit instance = (ims.ccosched.vo.lookups.Unit)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUnitSearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Unit existingInstance = (ims.ccosched.vo.lookups.Unit)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUnitSearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUnitSearchLookup()
	{
		this.form.cmbUnitSearch().clear();
		ims.ccosched.vo.lookups.UnitCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getUnit(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUnitSearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUnitSearchLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Unit instance = ims.ccosched.vo.lookups.LookupHelper.getUnitInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUnitSearch().setValue(instance);
	}
	protected final void defaultcmbUnitSearchLookupValue()
	{
		this.form.cmbUnitSearch().setValue((ims.ccosched.vo.lookups.Unit)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Unit.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Unit.TYPE_ID));
	}
	protected final void oncmbModalitySearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbModalitySearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Modality existingInstance = (ims.ccosched.vo.lookups.Modality)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbModalitySearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Modality)
		{
			ims.ccosched.vo.lookups.Modality instance = (ims.ccosched.vo.lookups.Modality)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbModalitySearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Modality existingInstance = (ims.ccosched.vo.lookups.Modality)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbModalitySearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbModalitySearchLookup()
	{
		this.form.cmbModalitySearch().clear();
		ims.ccosched.vo.lookups.ModalityCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getModality(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbModalitySearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbModalitySearchLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Modality instance = ims.ccosched.vo.lookups.LookupHelper.getModalityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbModalitySearch().setValue(instance);
	}
	protected final void defaultcmbModalitySearchLookupValue()
	{
		this.form.cmbModalitySearch().setValue((ims.ccosched.vo.lookups.Modality)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Modality.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Modality.TYPE_ID));
	}
	protected final void oncmbUnitNewValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().cmbUnitNew().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Unit existingInstance = (ims.ccosched.vo.lookups.Unit)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUnitNewLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Unit)
		{
			ims.ccosched.vo.lookups.Unit instance = (ims.ccosched.vo.lookups.Unit)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUnitNewLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Unit existingInstance = (ims.ccosched.vo.lookups.Unit)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().cmbUnitNew().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUnitNewLookup()
	{
		this.form.ctnDetail().cmbUnitNew().clear();
		ims.ccosched.vo.lookups.UnitCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getUnit(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().cmbUnitNew().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUnitNewLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Unit instance = ims.ccosched.vo.lookups.LookupHelper.getUnitInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().cmbUnitNew().setValue(instance);
	}
	protected final void defaultcmbUnitNewLookupValue()
	{
		this.form.ctnDetail().cmbUnitNew().setValue((ims.ccosched.vo.lookups.Unit)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Unit.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Unit.TYPE_ID));
	}
	protected final void oncmbModalityNewValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().cmbModalityNew().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Modality existingInstance = (ims.ccosched.vo.lookups.Modality)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbModalityNewLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Modality)
		{
			ims.ccosched.vo.lookups.Modality instance = (ims.ccosched.vo.lookups.Modality)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbModalityNewLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Modality existingInstance = (ims.ccosched.vo.lookups.Modality)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().cmbModalityNew().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbModalityNewLookup()
	{
		this.form.ctnDetail().cmbModalityNew().clear();
		ims.ccosched.vo.lookups.ModalityCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getModality(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().cmbModalityNew().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbModalityNewLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Modality instance = ims.ccosched.vo.lookups.LookupHelper.getModalityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().cmbModalityNew().setValue(instance);
	}
	protected final void defaultcmbModalityNewLookupValue()
	{
		this.form.ctnDetail().cmbModalityNew().setValue((ims.ccosched.vo.lookups.Modality)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Modality.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Modality.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.eas.domain.ModalityUnitConfiguration domain;
}
