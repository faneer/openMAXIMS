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

package ims.naes.forms.actiondialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.naes.domain.ActionDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.naes.domain.ActionDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
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
					ims.naes.vo.lookups.NaesActionStatus existingInstance = (ims.naes.vo.lookups.NaesActionStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.naes.vo.lookups.NaesActionStatus)
		{
			ims.naes.vo.lookups.NaesActionStatus instance = (ims.naes.vo.lookups.NaesActionStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.naes.vo.lookups.NaesActionStatus existingInstance = (ims.naes.vo.lookups.NaesActionStatus)listOfValues.get(x);
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
		ims.naes.vo.lookups.NaesActionStatusCollection lookupCollection = ims.naes.vo.lookups.LookupHelper.getNaesActionStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.naes.vo.lookups.NaesActionStatus instance = ims.naes.vo.lookups.LookupHelper.getNaesActionStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.naes.vo.lookups.NaesActionStatus)domain.getLookupService().getDefaultInstance(ims.naes.vo.lookups.NaesActionStatus.class, engine.getFormName().getID(), ims.naes.vo.lookups.NaesActionStatus.TYPE_ID));
	}
	protected final void oncmbActionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAction().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.naes.vo.lookups.Action existingInstance = (ims.naes.vo.lookups.Action)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbActionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.naes.vo.lookups.Action)
		{
			ims.naes.vo.lookups.Action instance = (ims.naes.vo.lookups.Action)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbActionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.naes.vo.lookups.Action existingInstance = (ims.naes.vo.lookups.Action)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAction().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbActionLookup()
	{
		this.form.cmbAction().clear();
		ims.naes.vo.lookups.ActionCollection lookupCollection = ims.naes.vo.lookups.LookupHelper.getAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbActionLookupValue(int id)
	{
		ims.naes.vo.lookups.Action instance = ims.naes.vo.lookups.LookupHelper.getActionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAction().setValue(instance);
	}
	protected final void defaultcmbActionLookupValue()
	{
		this.form.cmbAction().setValue((ims.naes.vo.lookups.Action)domain.getLookupService().getDefaultInstance(ims.naes.vo.lookups.Action.class, engine.getFormName().getID(), ims.naes.vo.lookups.Action.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.naes.domain.ActionDialog domain;
}
