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

package ims.pathways.forms.targetreadjustment;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pathways.domain.TargetReadjustment.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pathways.domain.TargetReadjustment domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbReadjustmentsValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbReadjustments().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetReadjustment existingInstance = (ims.pathways.vo.lookups.TargetReadjustment)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReadjustmentsLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.TargetReadjustment)
		{
			ims.pathways.vo.lookups.TargetReadjustment instance = (ims.pathways.vo.lookups.TargetReadjustment)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReadjustmentsLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetReadjustment existingInstance = (ims.pathways.vo.lookups.TargetReadjustment)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbReadjustments().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReadjustmentsLookup()
	{
		this.form.ctnDetails().cmbReadjustments().clear();
		ims.pathways.vo.lookups.TargetReadjustmentCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getTargetReadjustment(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbReadjustments().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReadjustmentsLookupValue(int id)
	{
		ims.pathways.vo.lookups.TargetReadjustment instance = ims.pathways.vo.lookups.LookupHelper.getTargetReadjustmentInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbReadjustments().setValue(instance);
	}
	protected final void defaultcmbReadjustmentsLookupValue()
	{
		this.form.ctnDetails().cmbReadjustments().setValue((ims.pathways.vo.lookups.TargetReadjustment)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.TargetReadjustment.class, engine.getFormName().getID(), ims.pathways.vo.lookups.TargetReadjustment.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.ctnDetails().cmbReadjustments().setValue(null);
		this.form.ctnDetails().txtReason().setValue("");
		this.form.ctnDetails().intNoOfDays().setValue(null);
	}
	protected void populateScreenFromData(ims.pathways.vo.TargetReadjustmentVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.ctnDetails().cmbReadjustments().setValue(value.getTargetReadjustmentIsNotNull() ? value.getTargetReadjustment() : null);
		this.form.ctnDetails().txtReason().setValue(value.getReasonIsNotNull() ? value.getReason(): null);
		this.form.ctnDetails().intNoOfDays().setValue(value.getNoOfDaysIsNotNull() ? value.getNoOfDays() : null);
	}
	protected ims.pathways.vo.TargetReadjustmentVo populateDataFromScreen(ims.pathways.vo.TargetReadjustmentVo value)
	{
		if(value == null)
			value = new ims.pathways.vo.TargetReadjustmentVo();

		value.setTargetReadjustment(this.form.ctnDetails().cmbReadjustments().getValue());
		value.setReason(this.form.ctnDetails().txtReason().getValue());
		value.setNoOfDays(this.form.ctnDetails().intNoOfDays().getValue());

		return value;
	}
	protected ims.pathways.vo.TargetReadjustmentVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.pathways.vo.TargetReadjustmentVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pathways.domain.TargetReadjustment domain;
}
