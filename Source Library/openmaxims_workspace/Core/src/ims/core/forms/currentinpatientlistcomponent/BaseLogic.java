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

package ims.core.forms.currentinpatientlistcomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.CurrentInpatientListComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.core.domain.CurrentInpatientListComponent domain)
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
	protected final void oncmbIDTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbIDType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbIDTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbIDTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbIDType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbIDTypeLookup()
	{
		this.form.cmbIDType().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbIDType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbIDTypeLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbIDType().setValue(instance);
	}
	protected final void defaultcmbIDTypeLookupValue()
	{
		this.form.cmbIDType().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbAlertValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAlert().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AlertType existingInstance = (ims.core.vo.lookups.AlertType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAlertLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.AlertType)
		{
			ims.core.vo.lookups.AlertType instance = (ims.core.vo.lookups.AlertType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAlertLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AlertType existingInstance = (ims.core.vo.lookups.AlertType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAlert().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAlertLookup()
	{
		this.form.cmbAlert().clear();
		ims.core.vo.lookups.AlertTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAlertType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAlert().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAlertLookupValue(int id)
	{
		ims.core.vo.lookups.AlertType instance = ims.core.vo.lookups.LookupHelper.getAlertTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAlert().setValue(instance);
	}
	protected final void defaultcmbAlertLookupValue()
	{
		this.form.cmbAlert().setValue((ims.core.vo.lookups.AlertType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.AlertType.class, engine.getFormName().getID(), ims.core.vo.lookups.AlertType.TYPE_ID));
	}
	protected final void oncmbSideWardValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSideWard().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardType existingInstance = (ims.core.vo.lookups.WardType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSideWardLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardType)
		{
			ims.core.vo.lookups.WardType instance = (ims.core.vo.lookups.WardType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSideWardLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardType existingInstance = (ims.core.vo.lookups.WardType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSideWard().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSideWardLookup()
	{
		this.form.cmbSideWard().clear();
		ims.core.vo.lookups.WardTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSideWard().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSideWardLookupValue(int id)
	{
		ims.core.vo.lookups.WardType instance = ims.core.vo.lookups.LookupHelper.getWardTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSideWard().setValue(instance);
	}
	protected final void defaultcmbSideWardLookupValue()
	{
		this.form.cmbSideWard().setValue((ims.core.vo.lookups.WardType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardType.class, engine.getFormName().getID(), ims.core.vo.lookups.WardType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.CurrentInpatientListComponent domain;
}
