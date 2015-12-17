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

package ims.emergency.forms.supportservices;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.SupportServices.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.emergency.domain.SupportServices domain)
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
	protected final void oncmbEmergencyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrSupportServices().tabPageFamily().cmbEmergency().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkEmergencyContact existingInstance = (ims.core.vo.lookups.SupportNetworkEmergencyContact)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbEmergencyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SupportNetworkEmergencyContact)
		{
			ims.core.vo.lookups.SupportNetworkEmergencyContact instance = (ims.core.vo.lookups.SupportNetworkEmergencyContact)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbEmergencyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkEmergencyContact existingInstance = (ims.core.vo.lookups.SupportNetworkEmergencyContact)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrSupportServices().tabPageFamily().cmbEmergency().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbEmergencyLookup()
	{
		this.form.lyrSupportServices().tabPageFamily().cmbEmergency().clear();
		ims.core.vo.lookups.SupportNetworkEmergencyContactCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSupportNetworkEmergencyContact(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSupportServices().tabPageFamily().cmbEmergency().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbEmergencyLookupValue(int id)
	{
		ims.core.vo.lookups.SupportNetworkEmergencyContact instance = ims.core.vo.lookups.LookupHelper.getSupportNetworkEmergencyContactInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrSupportServices().tabPageFamily().cmbEmergency().setValue(instance);
	}
	protected final void defaultcmbEmergencyLookupValue()
	{
		this.form.lyrSupportServices().tabPageFamily().cmbEmergency().setValue((ims.core.vo.lookups.SupportNetworkEmergencyContact)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SupportNetworkEmergencyContact.class, engine.getFormName().getID(), ims.core.vo.lookups.SupportNetworkEmergencyContact.TYPE_ID));
	}
	protected final void oncmbRelationshipValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrSupportServices().tabPageFamily().cmbRelationship().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkRelationship existingInstance = (ims.core.vo.lookups.SupportNetworkRelationship)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRelationshipLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SupportNetworkRelationship)
		{
			ims.core.vo.lookups.SupportNetworkRelationship instance = (ims.core.vo.lookups.SupportNetworkRelationship)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRelationshipLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SupportNetworkRelationship existingInstance = (ims.core.vo.lookups.SupportNetworkRelationship)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrSupportServices().tabPageFamily().cmbRelationship().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRelationshipLookup()
	{
		this.form.lyrSupportServices().tabPageFamily().cmbRelationship().clear();
		ims.core.vo.lookups.SupportNetworkRelationshipCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSupportNetworkRelationship(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSupportServices().tabPageFamily().cmbRelationship().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRelationshipLookupValue(int id)
	{
		ims.core.vo.lookups.SupportNetworkRelationship instance = ims.core.vo.lookups.LookupHelper.getSupportNetworkRelationshipInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrSupportServices().tabPageFamily().cmbRelationship().setValue(instance);
	}
	protected final void defaultcmbRelationshipLookupValue()
	{
		this.form.lyrSupportServices().tabPageFamily().cmbRelationship().setValue((ims.core.vo.lookups.SupportNetworkRelationship)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SupportNetworkRelationship.class, engine.getFormName().getID(), ims.core.vo.lookups.SupportNetworkRelationship.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.SupportServices domain;
}
