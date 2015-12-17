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

package ims.oncology.forms.histopathologyreport;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.HistoPathologyReport.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.HistoPathologyReport domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbSpecimenNatureValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SpecimenNature existingInstance = (ims.oncology.vo.lookups.SpecimenNature)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecimenNatureLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.SpecimenNature)
		{
			ims.oncology.vo.lookups.SpecimenNature instance = (ims.oncology.vo.lookups.SpecimenNature)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecimenNatureLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SpecimenNature existingInstance = (ims.oncology.vo.lookups.SpecimenNature)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecimenNatureLookup()
	{
		this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().clear();
		ims.oncology.vo.lookups.SpecimenNatureCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getSpecimenNature(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecimenNatureLookupValue(int id)
	{
		ims.oncology.vo.lookups.SpecimenNature instance = ims.oncology.vo.lookups.LookupHelper.getSpecimenNatureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().setValue(instance);
	}
	protected final void defaultcmbSpecimenNatureLookupValue()
	{
		this.form.lyrDetails().tabGenDetails().cmbSpecimenNature().setValue((ims.oncology.vo.lookups.SpecimenNature)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.SpecimenNature.class, engine.getFormName().getID(), ims.oncology.vo.lookups.SpecimenNature.TYPE_ID));
	}
	protected final void oncmbReportStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabGenDetails().cmbReportStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ServiceReportStatus existingInstance = (ims.oncology.vo.lookups.ServiceReportStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReportStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ServiceReportStatus)
		{
			ims.oncology.vo.lookups.ServiceReportStatus instance = (ims.oncology.vo.lookups.ServiceReportStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReportStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ServiceReportStatus existingInstance = (ims.oncology.vo.lookups.ServiceReportStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabGenDetails().cmbReportStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReportStatusLookup()
	{
		this.form.lyrDetails().tabGenDetails().cmbReportStatus().clear();
		ims.oncology.vo.lookups.ServiceReportStatusCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getServiceReportStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabGenDetails().cmbReportStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReportStatusLookupValue(int id)
	{
		ims.oncology.vo.lookups.ServiceReportStatus instance = ims.oncology.vo.lookups.LookupHelper.getServiceReportStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabGenDetails().cmbReportStatus().setValue(instance);
	}
	protected final void defaultcmbReportStatusLookupValue()
	{
		this.form.lyrDetails().tabGenDetails().cmbReportStatus().setValue((ims.oncology.vo.lookups.ServiceReportStatus)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ServiceReportStatus.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ServiceReportStatus.TYPE_ID));
	}
	protected final void oncmbInvTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabGenDetails().cmbInvType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.InvestigationType existingInstance = (ims.oncology.vo.lookups.InvestigationType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbInvTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.InvestigationType)
		{
			ims.oncology.vo.lookups.InvestigationType instance = (ims.oncology.vo.lookups.InvestigationType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbInvTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.InvestigationType existingInstance = (ims.oncology.vo.lookups.InvestigationType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabGenDetails().cmbInvType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbInvTypeLookup()
	{
		this.form.lyrDetails().tabGenDetails().cmbInvType().clear();
		ims.oncology.vo.lookups.InvestigationTypeCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getInvestigationType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabGenDetails().cmbInvType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbInvTypeLookupValue(int id)
	{
		ims.oncology.vo.lookups.InvestigationType instance = ims.oncology.vo.lookups.LookupHelper.getInvestigationTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabGenDetails().cmbInvType().setValue(instance);
	}
	protected final void defaultcmbInvTypeLookupValue()
	{
		this.form.lyrDetails().tabGenDetails().cmbInvType().setValue((ims.oncology.vo.lookups.InvestigationType)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.InvestigationType.class, engine.getFormName().getID(), ims.oncology.vo.lookups.InvestigationType.TYPE_ID));
	}
	protected final void oncmbExcisionMargValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ExcisionMargin existingInstance = (ims.oncology.vo.lookups.ExcisionMargin)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbExcisionMargLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ExcisionMargin)
		{
			ims.oncology.vo.lookups.ExcisionMargin instance = (ims.oncology.vo.lookups.ExcisionMargin)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbExcisionMargLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ExcisionMargin existingInstance = (ims.oncology.vo.lookups.ExcisionMargin)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbExcisionMargLookup()
	{
		this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().clear();
		ims.oncology.vo.lookups.ExcisionMarginCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getExcisionMargin(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbExcisionMargLookupValue(int id)
	{
		ims.oncology.vo.lookups.ExcisionMargin instance = ims.oncology.vo.lookups.LookupHelper.getExcisionMarginInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().setValue(instance);
	}
	protected final void defaultcmbExcisionMargLookupValue()
	{
		this.form.lyrDetails().tabTumDetails().cmbExcisionMarg().setValue((ims.oncology.vo.lookups.ExcisionMargin)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ExcisionMargin.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ExcisionMargin.TYPE_ID));
	}
	protected final void oncmbVascLymphInvasionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.VascularLymphInvasion existingInstance = (ims.oncology.vo.lookups.VascularLymphInvasion)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVascLymphInvasionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.VascularLymphInvasion)
		{
			ims.oncology.vo.lookups.VascularLymphInvasion instance = (ims.oncology.vo.lookups.VascularLymphInvasion)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVascLymphInvasionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.VascularLymphInvasion existingInstance = (ims.oncology.vo.lookups.VascularLymphInvasion)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVascLymphInvasionLookup()
	{
		this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().clear();
		ims.oncology.vo.lookups.VascularLymphInvasionCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getVascularLymphInvasion(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVascLymphInvasionLookupValue(int id)
	{
		ims.oncology.vo.lookups.VascularLymphInvasion instance = ims.oncology.vo.lookups.LookupHelper.getVascularLymphInvasionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().setValue(instance);
	}
	protected final void defaultcmbVascLymphInvasionLookupValue()
	{
		this.form.lyrDetails().tabTumDetails().cmbVascLymphInvasion().setValue((ims.oncology.vo.lookups.VascularLymphInvasion)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.VascularLymphInvasion.class, engine.getFormName().getID(), ims.oncology.vo.lookups.VascularLymphInvasion.TYPE_ID));
	}
	protected final void oncmbSynchronousTumourValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SynchronousTumourIndicator existingInstance = (ims.oncology.vo.lookups.SynchronousTumourIndicator)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSynchronousTumourLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.SynchronousTumourIndicator)
		{
			ims.oncology.vo.lookups.SynchronousTumourIndicator instance = (ims.oncology.vo.lookups.SynchronousTumourIndicator)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSynchronousTumourLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.SynchronousTumourIndicator existingInstance = (ims.oncology.vo.lookups.SynchronousTumourIndicator)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSynchronousTumourLookup()
	{
		this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().clear();
		ims.oncology.vo.lookups.SynchronousTumourIndicatorCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getSynchronousTumourIndicator(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSynchronousTumourLookupValue(int id)
	{
		ims.oncology.vo.lookups.SynchronousTumourIndicator instance = ims.oncology.vo.lookups.LookupHelper.getSynchronousTumourIndicatorInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().setValue(instance);
	}
	protected final void defaultcmbSynchronousTumourLookupValue()
	{
		this.form.lyrDetails().tabTumDetails().cmbSynchronousTumour().setValue((ims.oncology.vo.lookups.SynchronousTumourIndicator)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.SynchronousTumourIndicator.class, engine.getFormName().getID(), ims.oncology.vo.lookups.SynchronousTumourIndicator.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.HistoPathologyReport domain;
}
