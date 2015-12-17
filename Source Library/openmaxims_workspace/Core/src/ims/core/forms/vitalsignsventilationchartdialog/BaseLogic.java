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

package ims.core.forms.vitalsignsventilationchartdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.VitalSignsVentilationChartDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.VitalSignsVentilationChartDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansProbeChangeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansProbeChange().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansProbeChangeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansProbeChangeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansProbeChange().addOption(instance);
		}
	}
	protected final void bindansProbeChangeLookup()
	{
		this.form.ansProbeChange().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansProbeChange().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansProbeChangeLookupValue()
	{
		this.form.ansProbeChange().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void oncmbCuffValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCuff().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CuffStatus existingInstance = (ims.core.vo.lookups.CuffStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCuffLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.CuffStatus)
		{
			ims.core.vo.lookups.CuffStatus instance = (ims.core.vo.lookups.CuffStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCuffLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CuffStatus existingInstance = (ims.core.vo.lookups.CuffStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCuff().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCuffLookup()
	{
		this.form.cmbCuff().clear();
		ims.core.vo.lookups.CuffStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getCuffStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCuff().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCuffLookupValue(int id)
	{
		ims.core.vo.lookups.CuffStatus instance = ims.core.vo.lookups.LookupHelper.getCuffStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCuff().setValue(instance);
	}
	protected final void defaultcmbCuffLookupValue()
	{
		this.form.cmbCuff().setValue((ims.core.vo.lookups.CuffStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.CuffStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.CuffStatus.TYPE_ID));
	}
	protected final void oncmbPainScaleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPainScale().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PainSeverity existingInstance = (ims.nursing.vo.lookups.PainSeverity)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPainScaleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.PainSeverity)
		{
			ims.nursing.vo.lookups.PainSeverity instance = (ims.nursing.vo.lookups.PainSeverity)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPainScaleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PainSeverity existingInstance = (ims.nursing.vo.lookups.PainSeverity)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPainScale().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPainScaleLookup()
	{
		this.form.cmbPainScale().clear();
		ims.nursing.vo.lookups.PainSeverityCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getPainSeverity(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPainScale().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPainScaleLookupValue(int id)
	{
		ims.nursing.vo.lookups.PainSeverity instance = ims.nursing.vo.lookups.LookupHelper.getPainSeverityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPainScale().setValue(instance);
	}
	protected final void defaultcmbPainScaleLookupValue()
	{
		this.form.cmbPainScale().setValue((ims.nursing.vo.lookups.PainSeverity)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.PainSeverity.class, engine.getFormName().getID(), ims.nursing.vo.lookups.PainSeverity.TYPE_ID));
	}
	protected final void oncmbModeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VentilationMode existingInstance = (ims.core.vo.lookups.VentilationMode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbModeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VentilationMode)
		{
			ims.core.vo.lookups.VentilationMode instance = (ims.core.vo.lookups.VentilationMode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbModeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VentilationMode existingInstance = (ims.core.vo.lookups.VentilationMode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbModeLookup()
	{
		this.form.cmbMode().clear();
		ims.core.vo.lookups.VentilationModeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVentilationMode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbModeLookupValue(int id)
	{
		ims.core.vo.lookups.VentilationMode instance = ims.core.vo.lookups.LookupHelper.getVentilationModeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMode().setValue(instance);
	}
	protected final void defaultcmbModeLookupValue()
	{
		this.form.cmbMode().setValue((ims.core.vo.lookups.VentilationMode)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VentilationMode.class, engine.getFormName().getID(), ims.core.vo.lookups.VentilationMode.TYPE_ID));
	}
	protected final void oncmbPyhsioValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPyhsio().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPyhsioLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPyhsioLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPyhsio().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPyhsioLookup()
	{
		this.form.cmbPyhsio().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPyhsio().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPyhsioLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPyhsio().setValue(instance);
	}
	protected final void defaultcmbPyhsioLookupValue()
	{
		this.form.cmbPyhsio().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbPositionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPosition().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientPosition existingInstance = (ims.core.vo.lookups.PatientPosition)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPositionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatientPosition)
		{
			ims.core.vo.lookups.PatientPosition instance = (ims.core.vo.lookups.PatientPosition)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPositionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientPosition existingInstance = (ims.core.vo.lookups.PatientPosition)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPosition().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPositionLookup()
	{
		this.form.cmbPosition().clear();
		ims.core.vo.lookups.PatientPositionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatientPosition(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPosition().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPositionLookupValue(int id)
	{
		ims.core.vo.lookups.PatientPosition instance = ims.core.vo.lookups.LookupHelper.getPatientPositionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPosition().setValue(instance);
	}
	protected final void defaultcmbPositionLookupValue()
	{
		this.form.cmbPosition().setValue((ims.core.vo.lookups.PatientPosition)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatientPosition.class, engine.getFormName().getID(), ims.core.vo.lookups.PatientPosition.TYPE_ID));
	}
	protected final void oncmbSuctionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSuction().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSuctionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSuctionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSuction().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSuctionLookup()
	{
		this.form.cmbSuction().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSuction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSuctionLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSuction().setValue(instance);
	}
	protected final void defaultcmbSuctionLookupValue()
	{
		this.form.cmbSuction().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.VitalSignsVentilationChartDialog domain;
}
