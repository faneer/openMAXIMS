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

package ims.clinical.forms.cliniclistactionsummary;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.ClinicListActionSummary.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.ClinicListActionSummary domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbAppOutcomeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAppOutcome().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ApptOutcome existingInstance = (ims.scheduling.vo.lookups.ApptOutcome)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAppOutcomeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.ApptOutcome)
		{
			ims.scheduling.vo.lookups.ApptOutcome instance = (ims.scheduling.vo.lookups.ApptOutcome)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAppOutcomeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ApptOutcome existingInstance = (ims.scheduling.vo.lookups.ApptOutcome)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAppOutcome().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAppOutcomeLookup()
	{
		this.form.cmbAppOutcome().clear();
		ims.scheduling.vo.lookups.ApptOutcomeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getApptOutcome(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAppOutcome().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAppOutcomeLookupValue(int id)
	{
		ims.scheduling.vo.lookups.ApptOutcome instance = ims.scheduling.vo.lookups.LookupHelper.getApptOutcomeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAppOutcome().setValue(instance);
	}
	protected final void defaultcmbAppOutcomeLookupValue()
	{
		this.form.cmbAppOutcome().setValue((ims.scheduling.vo.lookups.ApptOutcome)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.ApptOutcome.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.ApptOutcome.TYPE_ID));
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
					ims.scheduling.vo.lookups.AppointmentAction existingInstance = (ims.scheduling.vo.lookups.AppointmentAction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbActionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.AppointmentAction)
		{
			ims.scheduling.vo.lookups.AppointmentAction instance = (ims.scheduling.vo.lookups.AppointmentAction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbActionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.AppointmentAction existingInstance = (ims.scheduling.vo.lookups.AppointmentAction)listOfValues.get(x);
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
		ims.scheduling.vo.lookups.AppointmentActionCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getAppointmentAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbActionLookupValue(int id)
	{
		ims.scheduling.vo.lookups.AppointmentAction instance = ims.scheduling.vo.lookups.LookupHelper.getAppointmentActionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAction().setValue(instance);
	}
	protected final void defaultcmbActionLookupValue()
	{
		this.form.cmbAction().setValue((ims.scheduling.vo.lookups.AppointmentAction)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.AppointmentAction.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.AppointmentAction.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.ClinicListActionSummary domain;
}
