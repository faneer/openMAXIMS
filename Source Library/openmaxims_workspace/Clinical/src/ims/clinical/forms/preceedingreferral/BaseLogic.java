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

package ims.clinical.forms.preceedingreferral;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.PreceedingReferral.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.PreceedingReferral domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbReasonValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReason().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ReasonForReferral existingInstance = (ims.core.vo.lookups.ReasonForReferral)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ReasonForReferral)
		{
			ims.core.vo.lookups.ReasonForReferral instance = (ims.core.vo.lookups.ReasonForReferral)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ReasonForReferral existingInstance = (ims.core.vo.lookups.ReasonForReferral)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReason().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonLookup()
	{
		this.form.cmbReason().clear();
		ims.core.vo.lookups.ReasonForReferralCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getReasonForReferral(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReason().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonLookupValue(int id)
	{
		ims.core.vo.lookups.ReasonForReferral instance = ims.core.vo.lookups.LookupHelper.getReasonForReferralInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReason().setValue(instance);
	}
	protected final void defaultcmbReasonLookupValue()
	{
		this.form.cmbReason().setValue((ims.core.vo.lookups.ReasonForReferral)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ReasonForReferral.class, engine.getFormName().getID(), ims.core.vo.lookups.ReasonForReferral.TYPE_ID));
	}
	protected final void oncmbSpecialtyFuncCodeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialtyFuncCode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.SpecialtyFunctionCode existingInstance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyFuncCodeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.SpecialtyFunctionCode)
		{
			ims.clinical.vo.lookups.SpecialtyFunctionCode instance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyFuncCodeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.SpecialtyFunctionCode existingInstance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialtyFuncCode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyFuncCodeLookup()
	{
		this.form.cmbSpecialtyFuncCode().clear();
		ims.clinical.vo.lookups.SpecialtyFunctionCodeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getSpecialtyFunctionCode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialtyFuncCode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyFuncCodeLookupValue(int id)
	{
		ims.clinical.vo.lookups.SpecialtyFunctionCode instance = ims.clinical.vo.lookups.LookupHelper.getSpecialtyFunctionCodeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialtyFuncCode().setValue(instance);
	}
	protected final void defaultcmbSpecialtyFuncCodeLookupValue()
	{
		this.form.cmbSpecialtyFuncCode().setValue((ims.clinical.vo.lookups.SpecialtyFunctionCode)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.SpecialtyFunctionCode.class, engine.getFormName().getID(), ims.clinical.vo.lookups.SpecialtyFunctionCode.TYPE_ID));
	}
	protected final void oncmbPriortyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPriorty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ReferralPriority existingInstance = (ims.core.vo.lookups.ReferralPriority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPriortyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ReferralPriority)
		{
			ims.core.vo.lookups.ReferralPriority instance = (ims.core.vo.lookups.ReferralPriority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPriortyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ReferralPriority existingInstance = (ims.core.vo.lookups.ReferralPriority)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPriorty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPriortyLookup()
	{
		this.form.cmbPriorty().clear();
		ims.core.vo.lookups.ReferralPriorityCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getReferralPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPriorty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPriortyLookupValue(int id)
	{
		ims.core.vo.lookups.ReferralPriority instance = ims.core.vo.lookups.LookupHelper.getReferralPriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPriorty().setValue(instance);
	}
	protected final void defaultcmbPriortyLookupValue()
	{
		this.form.cmbPriorty().setValue((ims.core.vo.lookups.ReferralPriority)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ReferralPriority.class, engine.getFormName().getID(), ims.core.vo.lookups.ReferralPriority.TYPE_ID));
	}
	protected final void oncmbSourceReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralSource existingInstance = (ims.clinical.vo.lookups.ReferralSource)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.ReferralSource)
		{
			ims.clinical.vo.lookups.ReferralSource instance = (ims.clinical.vo.lookups.ReferralSource)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralSource existingInstance = (ims.clinical.vo.lookups.ReferralSource)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceReferral().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceReferralLookup()
	{
		this.form.cmbSourceReferral().clear();
		ims.clinical.vo.lookups.ReferralSourceCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getReferralSource(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceReferral().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceReferralLookupValue(int id)
	{
		ims.clinical.vo.lookups.ReferralSource instance = ims.clinical.vo.lookups.LookupHelper.getReferralSourceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceReferral().setValue(instance);
	}
	protected final void defaultcmbSourceReferralLookupValue()
	{
		this.form.cmbSourceReferral().setValue((ims.clinical.vo.lookups.ReferralSource)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.ReferralSource.class, engine.getFormName().getID(), ims.clinical.vo.lookups.ReferralSource.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.PreceedingReferral domain;
}
