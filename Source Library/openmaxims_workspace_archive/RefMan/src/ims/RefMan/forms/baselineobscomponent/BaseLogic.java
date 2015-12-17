// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.baselineobscomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.RefMan.domain.BaselineObsComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.RefMan.domain.BaselineObsComponent domain)
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
	protected final void bindgrdSpecialNeedscolNeedLookup()
	{
		this.form.grdSpecialNeeds().colNeedComboBox().clear();
		ims.core.vo.lookups.SpecialNeedCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialNeed(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdSpecialNeeds().colNeedComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbSmokeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSmoke().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SmokingStatus existingInstance = (ims.core.vo.lookups.SmokingStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSmokeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SmokingStatus)
		{
			ims.core.vo.lookups.SmokingStatus instance = (ims.core.vo.lookups.SmokingStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSmokeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SmokingStatus existingInstance = (ims.core.vo.lookups.SmokingStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSmoke().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSmokeLookup()
	{
		this.form.cmbSmoke().clear();
		ims.core.vo.lookups.SmokingStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSmokingStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSmoke().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSmokeLookupValue(int id)
	{
		ims.core.vo.lookups.SmokingStatus instance = ims.core.vo.lookups.LookupHelper.getSmokingStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSmoke().setValue(instance);
	}
	protected final void defaultcmbSmokeLookupValue()
	{
		this.form.cmbSmoke().setValue((ims.core.vo.lookups.SmokingStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SmokingStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.SmokingStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.RefMan.domain.BaselineObsComponent domain;
}
