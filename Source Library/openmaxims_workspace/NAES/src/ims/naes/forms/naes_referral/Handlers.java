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

package ims.naes.forms.naes_referral;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbReferredByLookup();
	abstract protected void defaultcmbReferredByLookupValue();
	abstract protected void bindcmbAffectedEyeLookup();
	abstract protected void defaultcmbAffectedEyeLookupValue();
	abstract protected void bindcmbReferralReasonLookup();
	abstract protected void defaultcmbReferralReasonLookupValue();
	abstract protected void bindcmbImplantTypeLookup();
	abstract protected void defaultcmbImplantTypeLookupValue();
	abstract protected void bindcmbUnderLyingReasonLookup();
	abstract protected void defaultcmbUnderLyingReasonLookupValue();
	abstract protected void bindcmbImplantLookup();
	abstract protected void defaultcmbImplantLookupValue();
	abstract protected void bindcmbSurgeryRequiredLookup();
	abstract protected void defaultcmbSurgeryRequiredLookupValue();
	abstract protected void bindcmbLanguageLookup();
	abstract protected void defaultcmbLanguageLookupValue();
	abstract protected void bindcmbInterpreterRequiredLookup();
	abstract protected void defaultcmbInterpreterRequiredLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbReferredByValueSet(Object value);
	abstract protected void oncmbAffectedEyeValueSet(Object value);
	abstract protected void oncmbReferralReasonValueSet(Object value);
	abstract protected void onDteReceivedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbImplantTypeValueSet(Object value);
	abstract protected void oncmbUnderLyingReasonValueSet(Object value);
	abstract protected void oncmbImplantValueSet(Object value);
	abstract protected void onCmbImplantValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSurgeryRequiredValueSet(Object value);
	abstract protected void onCmbSurgeryValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLanguageValueSet(Object value);
	abstract protected void onCmbLanguageChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbInterpreterRequiredValueSet(Object value);
	abstract protected void onCmbInterpreterReqChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookApptClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRcbValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClicked() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClicked() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClicked() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.cmbReferredBy().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReferredByValueSet(value);
			}
		});
		this.form.cmbAffectedEye().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAffectedEyeValueSet(value);
			}
		});
		this.form.cmbReferralReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReferralReasonValueSet(value);
			}
		});
		this.form.dteReceived().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteReceivedValueChanged();
			}
		});
		this.form.cmbImplantType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbImplantTypeValueSet(value);
			}
		});
		this.form.cmbUnderLyingReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUnderLyingReasonValueSet(value);
			}
		});
		this.form.cmbImplant().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbImplantValueSet(value);
			}
		});
		this.form.cmbImplant().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbImplantValueChanged();
			}
		});
		this.form.cmbSurgeryRequired().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSurgeryRequiredValueSet(value);
			}
		});
		this.form.cmbSurgeryRequired().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbSurgeryValueChanged();
			}
		});
		this.form.cmbLanguage().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLanguageValueSet(value);
			}
		});
		this.form.cmbLanguage().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbLanguageChanged();
			}
		});
		this.form.cmbInterpreterRequired().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbInterpreterRequiredValueSet(value);
			}
		});
		this.form.cmbInterpreterRequired().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbInterpreterReqChanged();
			}
		});
		this.form.btnBookAppt().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookApptClick();
			}
		});
		this.form.recbrReferrals().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRcbValueChanged();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClicked();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClicked();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClicked();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbReferredByLookup();
		bindcmbAffectedEyeLookup();
		bindcmbReferralReasonLookup();
		bindcmbImplantTypeLookup();
		bindcmbUnderLyingReasonLookup();
		bindcmbImplantLookup();
		bindcmbSurgeryRequiredLookup();
		bindcmbLanguageLookup();
		bindcmbInterpreterRequiredLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbReferredByLookup();
		bindcmbAffectedEyeLookup();
		bindcmbReferralReasonLookup();
		bindcmbImplantTypeLookup();
		bindcmbUnderLyingReasonLookup();
		bindcmbImplantLookup();
		bindcmbSurgeryRequiredLookup();
		bindcmbLanguageLookup();
		bindcmbInterpreterRequiredLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbReferredByLookupValue();
		defaultcmbAffectedEyeLookupValue();
		defaultcmbReferralReasonLookupValue();
		defaultcmbImplantTypeLookupValue();
		defaultcmbUnderLyingReasonLookupValue();
		defaultcmbImplantLookupValue();
		defaultcmbSurgeryRequiredLookupValue();
		defaultcmbLanguageLookupValue();
		defaultcmbInterpreterRequiredLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
