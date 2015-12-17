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

package ims.pci.forms.clientdemographics;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pci.domain.ClientDemographics.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pci.domain.ClientDemographics domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbConfidentialReasonValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbConfidentialReason().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ConfidentialReason existingInstance = (ims.core.vo.lookups.ConfidentialReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbConfidentialReasonLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ConfidentialReason)
		{
			ims.core.vo.lookups.ConfidentialReason instance = (ims.core.vo.lookups.ConfidentialReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbConfidentialReasonLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ConfidentialReason existingInstance = (ims.core.vo.lookups.ConfidentialReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbConfidentialReason().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbConfidentialReasonLookup()
	{
		this.form.cmbConfidentialReason().clear();
		ims.core.vo.lookups.ConfidentialReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getConfidentialReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbConfidentialReason().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbConfidentialReasonLookupValue(int id)
	{
		ims.core.vo.lookups.ConfidentialReason instance = ims.core.vo.lookups.LookupHelper.getConfidentialReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbConfidentialReason().setValue(instance);
	}
	protected final void defaultcmbConfidentialReasonLookupValue()
	{
		this.form.cmbConfidentialReason().setValue((ims.core.vo.lookups.ConfidentialReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ConfidentialReason.class, engine.getFormName().getID(), ims.core.vo.lookups.ConfidentialReason.TYPE_ID));
	}
	protected final void oncmbUserField5ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUserField5().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType5 existingInstance = (ims.pci.vo.lookups.UserDefinedType5)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUserField5Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.UserDefinedType5)
		{
			ims.pci.vo.lookups.UserDefinedType5 instance = (ims.pci.vo.lookups.UserDefinedType5)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUserField5Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType5 existingInstance = (ims.pci.vo.lookups.UserDefinedType5)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUserField5().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUserField5Lookup()
	{
		this.form.cmbUserField5().clear();
		ims.pci.vo.lookups.UserDefinedType5Collection lookupCollection = ims.pci.vo.lookups.LookupHelper.getUserDefinedType5(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUserField5().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUserField5LookupValue(int id)
	{
		ims.pci.vo.lookups.UserDefinedType5 instance = ims.pci.vo.lookups.LookupHelper.getUserDefinedType5Instance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUserField5().setValue(instance);
	}
	protected final void defaultcmbUserField5LookupValue()
	{
		this.form.cmbUserField5().setValue((ims.pci.vo.lookups.UserDefinedType5)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.UserDefinedType5.class, engine.getFormName().getID(), ims.pci.vo.lookups.UserDefinedType5.TYPE_ID));
	}
	protected final void oncmbUserField4ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUserField4().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType4 existingInstance = (ims.pci.vo.lookups.UserDefinedType4)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUserField4Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.UserDefinedType4)
		{
			ims.pci.vo.lookups.UserDefinedType4 instance = (ims.pci.vo.lookups.UserDefinedType4)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUserField4Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType4 existingInstance = (ims.pci.vo.lookups.UserDefinedType4)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUserField4().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUserField4Lookup()
	{
		this.form.cmbUserField4().clear();
		ims.pci.vo.lookups.UserDefinedType4Collection lookupCollection = ims.pci.vo.lookups.LookupHelper.getUserDefinedType4(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUserField4().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUserField4LookupValue(int id)
	{
		ims.pci.vo.lookups.UserDefinedType4 instance = ims.pci.vo.lookups.LookupHelper.getUserDefinedType4Instance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUserField4().setValue(instance);
	}
	protected final void defaultcmbUserField4LookupValue()
	{
		this.form.cmbUserField4().setValue((ims.pci.vo.lookups.UserDefinedType4)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.UserDefinedType4.class, engine.getFormName().getID(), ims.pci.vo.lookups.UserDefinedType4.TYPE_ID));
	}
	protected final void oncmbUserField3ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUserField3().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType3 existingInstance = (ims.pci.vo.lookups.UserDefinedType3)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUserField3Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.UserDefinedType3)
		{
			ims.pci.vo.lookups.UserDefinedType3 instance = (ims.pci.vo.lookups.UserDefinedType3)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUserField3Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType3 existingInstance = (ims.pci.vo.lookups.UserDefinedType3)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUserField3().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUserField3Lookup()
	{
		this.form.cmbUserField3().clear();
		ims.pci.vo.lookups.UserDefinedType3Collection lookupCollection = ims.pci.vo.lookups.LookupHelper.getUserDefinedType3(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUserField3().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUserField3LookupValue(int id)
	{
		ims.pci.vo.lookups.UserDefinedType3 instance = ims.pci.vo.lookups.LookupHelper.getUserDefinedType3Instance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUserField3().setValue(instance);
	}
	protected final void defaultcmbUserField3LookupValue()
	{
		this.form.cmbUserField3().setValue((ims.pci.vo.lookups.UserDefinedType3)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.UserDefinedType3.class, engine.getFormName().getID(), ims.pci.vo.lookups.UserDefinedType3.TYPE_ID));
	}
	protected final void oncmbUserField2ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUserField2().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType2 existingInstance = (ims.pci.vo.lookups.UserDefinedType2)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUserField2Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.UserDefinedType2)
		{
			ims.pci.vo.lookups.UserDefinedType2 instance = (ims.pci.vo.lookups.UserDefinedType2)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUserField2Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType2 existingInstance = (ims.pci.vo.lookups.UserDefinedType2)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUserField2().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUserField2Lookup()
	{
		this.form.cmbUserField2().clear();
		ims.pci.vo.lookups.UserDefinedType2Collection lookupCollection = ims.pci.vo.lookups.LookupHelper.getUserDefinedType2(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUserField2().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUserField2LookupValue(int id)
	{
		ims.pci.vo.lookups.UserDefinedType2 instance = ims.pci.vo.lookups.LookupHelper.getUserDefinedType2Instance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUserField2().setValue(instance);
	}
	protected final void defaultcmbUserField2LookupValue()
	{
		this.form.cmbUserField2().setValue((ims.pci.vo.lookups.UserDefinedType2)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.UserDefinedType2.class, engine.getFormName().getID(), ims.pci.vo.lookups.UserDefinedType2.TYPE_ID));
	}
	protected final void oncmbUserField1ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUserField1().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType1 existingInstance = (ims.pci.vo.lookups.UserDefinedType1)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUserField1Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.UserDefinedType1)
		{
			ims.pci.vo.lookups.UserDefinedType1 instance = (ims.pci.vo.lookups.UserDefinedType1)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUserField1Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.UserDefinedType1 existingInstance = (ims.pci.vo.lookups.UserDefinedType1)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUserField1().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUserField1Lookup()
	{
		this.form.cmbUserField1().clear();
		ims.pci.vo.lookups.UserDefinedType1Collection lookupCollection = ims.pci.vo.lookups.LookupHelper.getUserDefinedType1(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUserField1().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUserField1LookupValue(int id)
	{
		ims.pci.vo.lookups.UserDefinedType1 instance = ims.pci.vo.lookups.LookupHelper.getUserDefinedType1Instance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUserField1().setValue(instance);
	}
	protected final void defaultcmbUserField1LookupValue()
	{
		this.form.cmbUserField1().setValue((ims.pci.vo.lookups.UserDefinedType1)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.UserDefinedType1.class, engine.getFormName().getID(), ims.pci.vo.lookups.UserDefinedType1.TYPE_ID));
	}
	protected final void oncmbSourceOfInfoValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfInfo().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.RegistrationSourceOfInfo existingInstance = (ims.core.vo.lookups.RegistrationSourceOfInfo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfInfoLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.RegistrationSourceOfInfo)
		{
			ims.core.vo.lookups.RegistrationSourceOfInfo instance = (ims.core.vo.lookups.RegistrationSourceOfInfo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfInfoLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.RegistrationSourceOfInfo existingInstance = (ims.core.vo.lookups.RegistrationSourceOfInfo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfInfo().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfInfoLookup()
	{
		this.form.cmbSourceOfInfo().clear();
		ims.core.vo.lookups.RegistrationSourceOfInfoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getRegistrationSourceOfInfo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfInfo().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfInfoLookupValue(int id)
	{
		ims.core.vo.lookups.RegistrationSourceOfInfo instance = ims.core.vo.lookups.LookupHelper.getRegistrationSourceOfInfoInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfInfo().setValue(instance);
	}
	protected final void defaultcmbSourceOfInfoLookupValue()
	{
		this.form.cmbSourceOfInfo().setValue((ims.core.vo.lookups.RegistrationSourceOfInfo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.RegistrationSourceOfInfo.class, engine.getFormName().getID(), ims.core.vo.lookups.RegistrationSourceOfInfo.TYPE_ID));
	}
	protected final void oncmbDODSourceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDODSource().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DodSource existingInstance = (ims.core.vo.lookups.DodSource)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDODSourceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DodSource)
		{
			ims.core.vo.lookups.DodSource instance = (ims.core.vo.lookups.DodSource)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDODSourceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DodSource existingInstance = (ims.core.vo.lookups.DodSource)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDODSource().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDODSourceLookup()
	{
		this.form.cmbDODSource().clear();
		ims.core.vo.lookups.DodSourceCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDodSource(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDODSource().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDODSourceLookupValue(int id)
	{
		ims.core.vo.lookups.DodSource instance = ims.core.vo.lookups.LookupHelper.getDodSourceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDODSource().setValue(instance);
	}
	protected final void defaultcmbDODSourceLookupValue()
	{
		this.form.cmbDODSource().setValue((ims.core.vo.lookups.DodSource)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DodSource.class, engine.getFormName().getID(), ims.core.vo.lookups.DodSource.TYPE_ID));
	}
	protected final void oncmbNationalityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbNationality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Nationality existingInstance = (ims.core.vo.lookups.Nationality)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbNationalityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Nationality)
		{
			ims.core.vo.lookups.Nationality instance = (ims.core.vo.lookups.Nationality)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbNationalityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Nationality existingInstance = (ims.core.vo.lookups.Nationality)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbNationality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbNationalityLookup()
	{
		this.form.cmbNationality().clear();
		ims.core.vo.lookups.NationalityCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getNationality(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbNationality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbNationalityLookupValue(int id)
	{
		ims.core.vo.lookups.Nationality instance = ims.core.vo.lookups.LookupHelper.getNationalityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbNationality().setValue(instance);
	}
	protected final void defaultcmbNationalityLookupValue()
	{
		this.form.cmbNationality().setValue((ims.core.vo.lookups.Nationality)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Nationality.class, engine.getFormName().getID(), ims.core.vo.lookups.Nationality.TYPE_ID));
	}
	protected final void oncmbMaritalStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaritalStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaritalStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MaritalStatus)
		{
			ims.core.vo.lookups.MaritalStatus instance = (ims.core.vo.lookups.MaritalStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaritalStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaritalStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaritalStatusLookup()
	{
		this.form.cmbMaritalStatus().clear();
		ims.core.vo.lookups.MaritalStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMaritalStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaritalStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaritalStatusLookupValue(int id)
	{
		ims.core.vo.lookups.MaritalStatus instance = ims.core.vo.lookups.LookupHelper.getMaritalStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaritalStatus().setValue(instance);
	}
	protected final void defaultcmbMaritalStatusLookupValue()
	{
		this.form.cmbMaritalStatus().setValue((ims.core.vo.lookups.MaritalStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MaritalStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.MaritalStatus.TYPE_ID));
	}
	protected final void oncmbSexValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSex().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSexLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Sex)
		{
			ims.core.vo.lookups.Sex instance = (ims.core.vo.lookups.Sex)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSexLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSex().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSexLookup()
	{
		this.form.cmbSex().clear();
		ims.core.vo.lookups.SexCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSex(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSex().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSexLookupValue(int id)
	{
		ims.core.vo.lookups.Sex instance = ims.core.vo.lookups.LookupHelper.getSexInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSex().setValue(instance);
	}
	protected final void defaultcmbSexLookupValue()
	{
		this.form.cmbSex().setValue((ims.core.vo.lookups.Sex)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Sex.class, engine.getFormName().getID(), ims.core.vo.lookups.Sex.TYPE_ID));
	}
	protected final void oncmbTitleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTitle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTitleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PersonTitle)
		{
			ims.core.vo.lookups.PersonTitle instance = (ims.core.vo.lookups.PersonTitle)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTitleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTitle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTitleLookup()
	{
		this.form.cmbTitle().clear();
		ims.core.vo.lookups.PersonTitleCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPersonTitle(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTitle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTitleLookupValue(int id)
	{
		ims.core.vo.lookups.PersonTitle instance = ims.core.vo.lookups.LookupHelper.getPersonTitleInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTitle().setValue(instance);
	}
	protected final void defaultcmbTitleLookupValue()
	{
		this.form.cmbTitle().setValue((ims.core.vo.lookups.PersonTitle)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PersonTitle.class, engine.getFormName().getID(), ims.core.vo.lookups.PersonTitle.TYPE_ID));
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
	
	protected ims.pci.domain.ClientDemographics domain;
}
