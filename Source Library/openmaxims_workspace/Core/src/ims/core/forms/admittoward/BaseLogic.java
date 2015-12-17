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

package ims.core.forms.admittoward;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.AdmitToWard.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.AdmitToWard domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbSourceOfEmergencyReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfEmergencyReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfEmergencyReferral existingInstance = (ims.core.vo.lookups.SourceOfEmergencyReferral)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfEmergencyReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SourceOfEmergencyReferral)
		{
			ims.core.vo.lookups.SourceOfEmergencyReferral instance = (ims.core.vo.lookups.SourceOfEmergencyReferral)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfEmergencyReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfEmergencyReferral existingInstance = (ims.core.vo.lookups.SourceOfEmergencyReferral)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfEmergencyReferral().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfEmergencyReferralLookup()
	{
		this.form.cmbSourceOfEmergencyReferral().clear();
		ims.core.vo.lookups.SourceOfEmergencyReferralCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceOfEmergencyReferral(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfEmergencyReferral().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfEmergencyReferralLookupValue(int id)
	{
		ims.core.vo.lookups.SourceOfEmergencyReferral instance = ims.core.vo.lookups.LookupHelper.getSourceOfEmergencyReferralInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfEmergencyReferral().setValue(instance);
	}
	protected final void defaultcmbSourceOfEmergencyReferralLookupValue()
	{
		this.form.cmbSourceOfEmergencyReferral().setValue((ims.core.vo.lookups.SourceOfEmergencyReferral)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceOfEmergencyReferral.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceOfEmergencyReferral.TYPE_ID));
	}
	protected final void oncmbSourceOfReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfReferral existingInstance = (ims.core.vo.lookups.SourceOfReferral)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SourceOfReferral)
		{
			ims.core.vo.lookups.SourceOfReferral instance = (ims.core.vo.lookups.SourceOfReferral)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfReferral existingInstance = (ims.core.vo.lookups.SourceOfReferral)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfReferral().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfReferralLookup()
	{
		this.form.cmbSourceOfReferral().clear();
		ims.core.vo.lookups.SourceOfReferralCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceOfReferral(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfReferral().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfReferralLookupValue(int id)
	{
		ims.core.vo.lookups.SourceOfReferral instance = ims.core.vo.lookups.LookupHelper.getSourceOfReferralInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfReferral().setValue(instance);
	}
	protected final void defaultcmbSourceOfReferralLookupValue()
	{
		this.form.cmbSourceOfReferral().setValue((ims.core.vo.lookups.SourceOfReferral)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceOfReferral.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceOfReferral.TYPE_ID));
	}
	protected final void oncmbPatIDTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatIDTypeLookup();
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
					bindcmbPatIDTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatIDTypeLookup()
	{
		this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatIDTypeLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().setValue(instance);
	}
	protected final void defaultcmbPatIDTypeLookupValue()
	{
		this.form.lyrPatient().tabPagePatientSearch().cmbPatIDType().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbPatientCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPatientCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientStatus existingInstance = (ims.core.vo.lookups.PatientStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatientCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatientStatus)
		{
			ims.core.vo.lookups.PatientStatus instance = (ims.core.vo.lookups.PatientStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatientCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientStatus existingInstance = (ims.core.vo.lookups.PatientStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPatientCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatientCategoryLookup()
	{
		this.form.cmbPatientCategory().clear();
		ims.core.vo.lookups.PatientStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatientStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPatientCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatientCategoryLookupValue(int id)
	{
		ims.core.vo.lookups.PatientStatus instance = ims.core.vo.lookups.LookupHelper.getPatientStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPatientCategory().setValue(instance);
	}
	protected final void defaultcmbPatientCategoryLookupValue()
	{
		this.form.cmbPatientCategory().setValue((ims.core.vo.lookups.PatientStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatientStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PatientStatus.TYPE_ID));
	}
	protected final void oncmbMethodOfAdmissionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMethodOfAdmission().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MethodOfAdmission existingInstance = (ims.core.vo.lookups.MethodOfAdmission)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMethodOfAdmissionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MethodOfAdmission)
		{
			ims.core.vo.lookups.MethodOfAdmission instance = (ims.core.vo.lookups.MethodOfAdmission)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMethodOfAdmissionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MethodOfAdmission existingInstance = (ims.core.vo.lookups.MethodOfAdmission)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMethodOfAdmission().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMethodOfAdmissionLookup()
	{
		this.form.cmbMethodOfAdmission().clear();
		ims.core.vo.lookups.MethodOfAdmissionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMethodOfAdmission(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMethodOfAdmission().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMethodOfAdmissionLookupValue(int id)
	{
		ims.core.vo.lookups.MethodOfAdmission instance = ims.core.vo.lookups.LookupHelper.getMethodOfAdmissionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMethodOfAdmission().setValue(instance);
	}
	protected final void defaultcmbMethodOfAdmissionLookupValue()
	{
		this.form.cmbMethodOfAdmission().setValue((ims.core.vo.lookups.MethodOfAdmission)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MethodOfAdmission.class, engine.getFormName().getID(), ims.core.vo.lookups.MethodOfAdmission.TYPE_ID));
	}
	protected final void oncmbSourceOfAdmissionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfAdmission().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfAdmission existingInstance = (ims.core.vo.lookups.SourceOfAdmission)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfAdmissionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SourceOfAdmission)
		{
			ims.core.vo.lookups.SourceOfAdmission instance = (ims.core.vo.lookups.SourceOfAdmission)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfAdmissionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SourceOfAdmission existingInstance = (ims.core.vo.lookups.SourceOfAdmission)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfAdmission().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfAdmissionLookup()
	{
		this.form.cmbSourceOfAdmission().clear();
		ims.core.vo.lookups.SourceOfAdmissionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSourceOfAdmission(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfAdmission().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfAdmissionLookupValue(int id)
	{
		ims.core.vo.lookups.SourceOfAdmission instance = ims.core.vo.lookups.LookupHelper.getSourceOfAdmissionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfAdmission().setValue(instance);
	}
	protected final void defaultcmbSourceOfAdmissionLookupValue()
	{
		this.form.cmbSourceOfAdmission().setValue((ims.core.vo.lookups.SourceOfAdmission)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SourceOfAdmission.class, engine.getFormName().getID(), ims.core.vo.lookups.SourceOfAdmission.TYPE_ID));
	}
	protected final void oncmbWardTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbWardType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardType existingInstance = (ims.core.vo.lookups.WardType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbWardTypeLookup();
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
					bindcmbWardTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardType existingInstance = (ims.core.vo.lookups.WardType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbWardType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbWardTypeLookup()
	{
		this.form.cmbWardType().clear();
		ims.core.vo.lookups.WardTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbWardType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbWardTypeLookupValue(int id)
	{
		ims.core.vo.lookups.WardType instance = ims.core.vo.lookups.LookupHelper.getWardTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbWardType().setValue(instance);
	}
	protected final void defaultcmbWardTypeLookupValue()
	{
		this.form.cmbWardType().setValue((ims.core.vo.lookups.WardType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardType.class, engine.getFormName().getID(), ims.core.vo.lookups.WardType.TYPE_ID));
	}
	protected final void oncmbSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyLookup()
	{
		this.form.cmbSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialty().setValue(instance);
	}
	protected final void defaultcmbSpecialtyLookupValue()
	{
		this.form.cmbSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.AdmitToWard domain;
}
