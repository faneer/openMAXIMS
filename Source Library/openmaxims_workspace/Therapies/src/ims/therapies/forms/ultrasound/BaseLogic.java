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

package ims.therapies.forms.ultrasound;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Ultrasound.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Ultrasound domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansWarningValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansWarning().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansWarningLookup();
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
					bindansWarningLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansWarning().addOption(instance);
		}
	}
	protected final void bindansWarningLookup()
	{
		this.form.ansWarning().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansWarning().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansWarningLookupValue()
	{
		this.form.ansWarning().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbMuscleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMuscleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)
		{
			ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect instance = (ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMuscleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMuscleLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().clear();
		ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspectCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundMuscleAspect(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMuscleLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect instance = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundMuscleAspectInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setValue(instance);
	}
	protected final void defaultcmbMuscleLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbMuscle().setValue((ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.UltrasoundMuscleAspect.TYPE_ID));
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLateralityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LateralityLRB)
		{
			ims.core.vo.lookups.LateralityLRB instance = (ims.core.vo.lookups.LateralityLRB)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLateralityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRBCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRB(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRB instance = ims.core.vo.lookups.LookupHelper.getLateralityLRBInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRB)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRB.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRB.TYPE_ID));
	}
	protected final void oncmbWaveValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundWave existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundWave)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbWaveLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.UltrasoundWave)
		{
			ims.spinalinjuries.vo.lookups.UltrasoundWave instance = (ims.spinalinjuries.vo.lookups.UltrasoundWave)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbWaveLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundWave existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundWave)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbWaveLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().clear();
		ims.spinalinjuries.vo.lookups.UltrasoundWaveCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundWave(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbWaveLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.UltrasoundWave instance = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundWaveInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().setValue(instance);
	}
	protected final void defaultcmbWaveLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbWave().setValue((ims.spinalinjuries.vo.lookups.UltrasoundWave)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.UltrasoundWave.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.UltrasoundWave.TYPE_ID));
	}
	protected final void oncmbIntensityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundIntensity existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundIntensity)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbIntensityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.UltrasoundIntensity)
		{
			ims.spinalinjuries.vo.lookups.UltrasoundIntensity instance = (ims.spinalinjuries.vo.lookups.UltrasoundIntensity)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbIntensityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundIntensity existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundIntensity)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbIntensityLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().clear();
		ims.spinalinjuries.vo.lookups.UltrasoundIntensityCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundIntensity(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbIntensityLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.UltrasoundIntensity instance = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundIntensityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().setValue(instance);
	}
	protected final void defaultcmbIntensityLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbIntensity().setValue((ims.spinalinjuries.vo.lookups.UltrasoundIntensity)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.UltrasoundIntensity.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.UltrasoundIntensity.TYPE_ID));
	}
	protected final void oncmbFreqValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundFreq existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundFreq)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFreqLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.UltrasoundFreq)
		{
			ims.spinalinjuries.vo.lookups.UltrasoundFreq instance = (ims.spinalinjuries.vo.lookups.UltrasoundFreq)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFreqLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundFreq existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundFreq)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFreqLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().clear();
		ims.spinalinjuries.vo.lookups.UltrasoundFreqCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundFreq(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFreqLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.UltrasoundFreq instance = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundFreqInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().setValue(instance);
	}
	protected final void defaultcmbFreqLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbFreq().setValue((ims.spinalinjuries.vo.lookups.UltrasoundFreq)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.UltrasoundFreq.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.UltrasoundFreq.TYPE_ID));
	}
	protected final void oncmbPulseValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundPulse existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundPulse)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPulseLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.UltrasoundPulse)
		{
			ims.spinalinjuries.vo.lookups.UltrasoundPulse instance = (ims.spinalinjuries.vo.lookups.UltrasoundPulse)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPulseLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.UltrasoundPulse existingInstance = (ims.spinalinjuries.vo.lookups.UltrasoundPulse)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPulseLookup()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().clear();
		ims.spinalinjuries.vo.lookups.UltrasoundPulseCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundPulse(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPulseLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.UltrasoundPulse instance = ims.spinalinjuries.vo.lookups.LookupHelper.getUltrasoundPulseInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().setValue(instance);
	}
	protected final void defaultcmbPulseLookupValue()
	{
		this.form.ctnUltra().lyrUltra().tabDetails().cmbPulse().setValue((ims.spinalinjuries.vo.lookups.UltrasoundPulse)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.UltrasoundPulse.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.UltrasoundPulse.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Ultrasound domain;
}
