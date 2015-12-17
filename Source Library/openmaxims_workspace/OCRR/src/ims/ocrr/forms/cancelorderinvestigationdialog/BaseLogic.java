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

package ims.ocrr.forms.cancelorderinvestigationdialog;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ocrr.domain.CancelOrderInvestigationDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ocrr.domain.CancelOrderInvestigationDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.ocrr.vo.lookups.InvestigationStatusChangeReasonCollection.class, ims.ocrr.vo.lookups.InvestigationStatusChangeReason.class, 1161008, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'InvestigationStatusChangeReason' (ID: 1161008) must have at least one active instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	protected final void oncmbCancelReasonValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCancelReason().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.InvestigationStatusChangeReason existingInstance = (ims.ocrr.vo.lookups.InvestigationStatusChangeReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCancelReasonLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.InvestigationStatusChangeReason)
		{
			ims.ocrr.vo.lookups.InvestigationStatusChangeReason instance = (ims.ocrr.vo.lookups.InvestigationStatusChangeReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCancelReasonLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.InvestigationStatusChangeReason existingInstance = (ims.ocrr.vo.lookups.InvestigationStatusChangeReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCancelReason().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCancelReasonLookup()
	{
		this.form.cmbCancelReason().clear();
		ims.ocrr.vo.lookups.InvestigationStatusChangeReasonCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getInvestigationStatusChangeReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCancelReason().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCancelReasonLookupValue(int id)
	{
		ims.ocrr.vo.lookups.InvestigationStatusChangeReason instance = ims.ocrr.vo.lookups.LookupHelper.getInvestigationStatusChangeReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCancelReason().setValue(instance);
	}
	protected final void defaultcmbCancelReasonLookupValue()
	{
		this.form.cmbCancelReason().setValue((ims.ocrr.vo.lookups.InvestigationStatusChangeReason)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.InvestigationStatusChangeReason.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.InvestigationStatusChangeReason.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ocrr.domain.CancelOrderInvestigationDialog domain;
}
