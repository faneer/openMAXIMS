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

package ims.core.forms.pdspatientdetails;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.PdsPatientDetails.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.core.domain.PdsPatientDetails domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbOccupationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOccupation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Occupation existingInstance = (ims.core.vo.lookups.Occupation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOccupationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Occupation)
		{
			ims.core.vo.lookups.Occupation instance = (ims.core.vo.lookups.Occupation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOccupationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Occupation existingInstance = (ims.core.vo.lookups.Occupation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOccupation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOccupationLookup()
	{
		this.form.cmbOccupation().clear();
		ims.core.vo.lookups.OccupationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOccupation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOccupation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOccupationLookupValue(int id)
	{
		ims.core.vo.lookups.Occupation instance = ims.core.vo.lookups.LookupHelper.getOccupationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOccupation().setValue(instance);
	}
	protected final void defaultcmbOccupationLookupValue()
	{
		this.form.cmbOccupation().setValue((ims.core.vo.lookups.Occupation)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Occupation.class, engine.getFormName().getID(), ims.core.vo.lookups.Occupation.TYPE_ID));
	}
	protected final void oncmbReligionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReligion().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Religion existingInstance = (ims.core.vo.lookups.Religion)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReligionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Religion)
		{
			ims.core.vo.lookups.Religion instance = (ims.core.vo.lookups.Religion)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReligionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Religion existingInstance = (ims.core.vo.lookups.Religion)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReligion().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReligionLookup()
	{
		this.form.cmbReligion().clear();
		ims.core.vo.lookups.ReligionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getReligion(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReligion().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReligionLookupValue(int id)
	{
		ims.core.vo.lookups.Religion instance = ims.core.vo.lookups.LookupHelper.getReligionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReligion().setValue(instance);
	}
	protected final void defaultcmbReligionLookupValue()
	{
		this.form.cmbReligion().setValue((ims.core.vo.lookups.Religion)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Religion.class, engine.getFormName().getID(), ims.core.vo.lookups.Religion.TYPE_ID));
	}
	protected final void oncmbEthnicCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbEthnicCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EthnicOrigin existingInstance = (ims.core.vo.lookups.EthnicOrigin)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbEthnicCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.EthnicOrigin)
		{
			ims.core.vo.lookups.EthnicOrigin instance = (ims.core.vo.lookups.EthnicOrigin)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbEthnicCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EthnicOrigin existingInstance = (ims.core.vo.lookups.EthnicOrigin)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbEthnicCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbEthnicCategoryLookup()
	{
		this.form.cmbEthnicCategory().clear();
		ims.core.vo.lookups.EthnicOriginCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEthnicOrigin(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbEthnicCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbEthnicCategoryLookupValue(int id)
	{
		ims.core.vo.lookups.EthnicOrigin instance = ims.core.vo.lookups.LookupHelper.getEthnicOriginInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbEthnicCategory().setValue(instance);
	}
	protected final void defaultcmbEthnicCategoryLookupValue()
	{
		this.form.cmbEthnicCategory().setValue((ims.core.vo.lookups.EthnicOrigin)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EthnicOrigin.class, engine.getFormName().getID(), ims.core.vo.lookups.EthnicOrigin.TYPE_ID));
	}
	protected final void oncmbMaritialStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaritialStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaritialStatusLookup();
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
					bindcmbMaritialStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaritialStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaritialStatusLookup()
	{
		this.form.cmbMaritialStatus().clear();
		ims.core.vo.lookups.MaritalStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMaritalStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaritialStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaritialStatusLookupValue(int id)
	{
		ims.core.vo.lookups.MaritalStatus instance = ims.core.vo.lookups.LookupHelper.getMaritalStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaritialStatus().setValue(instance);
	}
	protected final void defaultcmbMaritialStatusLookupValue()
	{
		this.form.cmbMaritialStatus().setValue((ims.core.vo.lookups.MaritalStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MaritalStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.MaritalStatus.TYPE_ID));
	}
	protected final void oncmbVisitorStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbVisitorStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OverseasVisitorStatusCassification existingInstance = (ims.core.vo.lookups.OverseasVisitorStatusCassification)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVisitorStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.OverseasVisitorStatusCassification)
		{
			ims.core.vo.lookups.OverseasVisitorStatusCassification instance = (ims.core.vo.lookups.OverseasVisitorStatusCassification)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVisitorStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OverseasVisitorStatusCassification existingInstance = (ims.core.vo.lookups.OverseasVisitorStatusCassification)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbVisitorStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVisitorStatusLookup()
	{
		this.form.cmbVisitorStatus().clear();
		ims.core.vo.lookups.OverseasVisitorStatusCassificationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOverseasVisitorStatusCassification(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbVisitorStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVisitorStatusLookupValue(int id)
	{
		ims.core.vo.lookups.OverseasVisitorStatusCassification instance = ims.core.vo.lookups.LookupHelper.getOverseasVisitorStatusCassificationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbVisitorStatus().setValue(instance);
	}
	protected final void defaultcmbVisitorStatusLookupValue()
	{
		this.form.cmbVisitorStatus().setValue((ims.core.vo.lookups.OverseasVisitorStatusCassification)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.OverseasVisitorStatusCassification.class, engine.getFormName().getID(), ims.core.vo.lookups.OverseasVisitorStatusCassification.TYPE_ID));
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
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.PdsPatientDetails domain;
}
