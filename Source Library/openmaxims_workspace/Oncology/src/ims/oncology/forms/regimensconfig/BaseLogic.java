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

package ims.oncology.forms.regimensconfig;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.RegimensConfig.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.RegimensConfig domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbDeliveryCodeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbDeliveryCode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DeliveryCodeAllOtherDays existingInstance = (ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDeliveryCodeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)
		{
			ims.oncology.vo.lookups.DeliveryCodeAllOtherDays instance = (ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDeliveryCodeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DeliveryCodeAllOtherDays existingInstance = (ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbDeliveryCode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDeliveryCodeLookup()
	{
		this.form.ctnDetails().cmbDeliveryCode().clear();
		ims.oncology.vo.lookups.DeliveryCodeAllOtherDaysCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDeliveryCodeAllOtherDays(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbDeliveryCode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDeliveryCodeLookupValue(int id)
	{
		ims.oncology.vo.lookups.DeliveryCodeAllOtherDays instance = ims.oncology.vo.lookups.LookupHelper.getDeliveryCodeAllOtherDaysInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbDeliveryCode().setValue(instance);
	}
	protected final void defaultcmbDeliveryCodeLookupValue()
	{
		this.form.ctnDetails().cmbDeliveryCode().setValue((ims.oncology.vo.lookups.DeliveryCodeAllOtherDays)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DeliveryCodeAllOtherDays.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DeliveryCodeAllOtherDays.TYPE_ID));
	}
	protected final void oncmbDay1DeliveryCodeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbDay1DeliveryCode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DayOneDeliveryCode existingInstance = (ims.oncology.vo.lookups.DayOneDeliveryCode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDay1DeliveryCodeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DayOneDeliveryCode)
		{
			ims.oncology.vo.lookups.DayOneDeliveryCode instance = (ims.oncology.vo.lookups.DayOneDeliveryCode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDay1DeliveryCodeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DayOneDeliveryCode existingInstance = (ims.oncology.vo.lookups.DayOneDeliveryCode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbDay1DeliveryCode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDay1DeliveryCodeLookup()
	{
		this.form.ctnDetails().cmbDay1DeliveryCode().clear();
		ims.oncology.vo.lookups.DayOneDeliveryCodeCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDayOneDeliveryCode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbDay1DeliveryCode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDay1DeliveryCodeLookupValue(int id)
	{
		ims.oncology.vo.lookups.DayOneDeliveryCode instance = ims.oncology.vo.lookups.LookupHelper.getDayOneDeliveryCodeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbDay1DeliveryCode().setValue(instance);
	}
	protected final void defaultcmbDay1DeliveryCodeLookupValue()
	{
		this.form.ctnDetails().cmbDay1DeliveryCode().setValue((ims.oncology.vo.lookups.DayOneDeliveryCode)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DayOneDeliveryCode.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DayOneDeliveryCode.TYPE_ID));
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PreActiveActiveInactiveStatus)
		{
			ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.ctnDetails().cmbStatus().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.ctnDetails().cmbStatus().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	protected final void oncmbProcurementCodeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbProcurementCode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ProcurementCode existingInstance = (ims.oncology.vo.lookups.ProcurementCode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbProcurementCodeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ProcurementCode)
		{
			ims.oncology.vo.lookups.ProcurementCode instance = (ims.oncology.vo.lookups.ProcurementCode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbProcurementCodeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ProcurementCode existingInstance = (ims.oncology.vo.lookups.ProcurementCode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbProcurementCode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbProcurementCodeLookup()
	{
		this.form.ctnDetails().cmbProcurementCode().clear();
		ims.oncology.vo.lookups.ProcurementCodeCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getProcurementCode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbProcurementCode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbProcurementCodeLookupValue(int id)
	{
		ims.oncology.vo.lookups.ProcurementCode instance = ims.oncology.vo.lookups.LookupHelper.getProcurementCodeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbProcurementCode().setValue(instance);
	}
	protected final void defaultcmbProcurementCodeLookupValue()
	{
		this.form.ctnDetails().cmbProcurementCode().setValue((ims.oncology.vo.lookups.ProcurementCode)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ProcurementCode.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ProcurementCode.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.RegimensConfig domain;
}
