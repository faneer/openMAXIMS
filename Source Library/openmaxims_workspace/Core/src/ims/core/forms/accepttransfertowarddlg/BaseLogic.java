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

package ims.core.forms.accepttransfertowarddlg;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.AcceptTransferToWardDlg.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.AcceptTransferToWardDlg domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbPatientStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPatientStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientStatus existingInstance = (ims.core.vo.lookups.PatientStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatientStatusLookup();
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
					bindcmbPatientStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientStatus existingInstance = (ims.core.vo.lookups.PatientStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPatientStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatientStatusLookup()
	{
		this.form.cmbPatientStatus().clear();
		ims.core.vo.lookups.PatientStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatientStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPatientStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatientStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PatientStatus instance = ims.core.vo.lookups.LookupHelper.getPatientStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPatientStatus().setValue(instance);
	}
	protected final void defaultcmbPatientStatusLookupValue()
	{
		this.form.cmbPatientStatus().setValue((ims.core.vo.lookups.PatientStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatientStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PatientStatus.TYPE_ID));
	}
	protected final void oncmbTransfReasonValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransfReason().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TransferReason existingInstance = (ims.core.vo.lookups.TransferReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransfReasonLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.TransferReason)
		{
			ims.core.vo.lookups.TransferReason instance = (ims.core.vo.lookups.TransferReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransfReasonLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TransferReason existingInstance = (ims.core.vo.lookups.TransferReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransfReason().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransfReasonLookup()
	{
		this.form.cmbTransfReason().clear();
		ims.core.vo.lookups.TransferReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTransferReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransfReason().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransfReasonLookupValue(int id)
	{
		ims.core.vo.lookups.TransferReason instance = ims.core.vo.lookups.LookupHelper.getTransferReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransfReason().setValue(instance);
	}
	protected final void defaultcmbTransfReasonLookupValue()
	{
		this.form.cmbTransfReason().setValue((ims.core.vo.lookups.TransferReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.TransferReason.class, engine.getFormName().getID(), ims.core.vo.lookups.TransferReason.TYPE_ID));
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
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.AcceptTransferToWardDlg domain;
}
