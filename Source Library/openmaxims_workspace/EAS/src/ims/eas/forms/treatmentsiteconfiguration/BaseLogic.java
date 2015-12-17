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

package ims.eas.forms.treatmentsiteconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.eas.domain.TreatmentSiteConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.eas.domain.TreatmentSiteConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTreatmentSiteNameValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTreatmentSiteName().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.eas.vo.lookups.TreatmentSites existingInstance = (ims.eas.vo.lookups.TreatmentSites)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentSiteNameLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.eas.vo.lookups.TreatmentSites)
		{
			ims.eas.vo.lookups.TreatmentSites instance = (ims.eas.vo.lookups.TreatmentSites)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentSiteNameLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.eas.vo.lookups.TreatmentSites existingInstance = (ims.eas.vo.lookups.TreatmentSites)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTreatmentSiteName().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentSiteNameLookup()
	{
		this.form.cmbTreatmentSiteName().clear();
		ims.eas.vo.lookups.TreatmentSitesCollection lookupCollection = ims.eas.vo.lookups.LookupHelper.getTreatmentSites(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTreatmentSiteName().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentSiteNameLookupValue(int id)
	{
		ims.eas.vo.lookups.TreatmentSites instance = ims.eas.vo.lookups.LookupHelper.getTreatmentSitesInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTreatmentSiteName().setValue(instance);
	}
	protected final void defaultcmbTreatmentSiteNameLookupValue()
	{
		this.form.cmbTreatmentSiteName().setValue((ims.eas.vo.lookups.TreatmentSites)domain.getLookupService().getDefaultInstance(ims.eas.vo.lookups.TreatmentSites.class, engine.getFormName().getID(), ims.eas.vo.lookups.TreatmentSites.TYPE_ID));
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
	protected final void oncmbTreatmentSiteValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbTreatmentSite().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.eas.vo.lookups.TreatmentSites existingInstance = (ims.eas.vo.lookups.TreatmentSites)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentSiteLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.eas.vo.lookups.TreatmentSites)
		{
			ims.eas.vo.lookups.TreatmentSites instance = (ims.eas.vo.lookups.TreatmentSites)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentSiteLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.eas.vo.lookups.TreatmentSites existingInstance = (ims.eas.vo.lookups.TreatmentSites)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbTreatmentSite().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentSiteLookup()
	{
		this.form.ctnDetails().cmbTreatmentSite().clear();
		ims.eas.vo.lookups.TreatmentSitesCollection lookupCollection = ims.eas.vo.lookups.LookupHelper.getTreatmentSites(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbTreatmentSite().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentSiteLookupValue(int id)
	{
		ims.eas.vo.lookups.TreatmentSites instance = ims.eas.vo.lookups.LookupHelper.getTreatmentSitesInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbTreatmentSite().setValue(instance);
	}
	protected final void defaultcmbTreatmentSiteLookupValue()
	{
		this.form.ctnDetails().cmbTreatmentSite().setValue((ims.eas.vo.lookups.TreatmentSites)domain.getLookupService().getDefaultInstance(ims.eas.vo.lookups.TreatmentSites.class, engine.getFormName().getID(), ims.eas.vo.lookups.TreatmentSites.TYPE_ID));
	}
	protected final void oncmbStatusSearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatusSearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusSearchLookup();
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
					bindcmbStatusSearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatusSearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusSearchLookup()
	{
		this.form.cmbStatusSearch().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatusSearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusSearchLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatusSearch().setValue(instance);
	}
	protected final void defaultcmbStatusSearchLookupValue()
	{
		this.form.cmbStatusSearch().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.eas.domain.TreatmentSiteConfiguration domain;
}
