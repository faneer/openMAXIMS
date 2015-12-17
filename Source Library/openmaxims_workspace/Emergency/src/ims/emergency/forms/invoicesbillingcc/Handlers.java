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

package ims.emergency.forms.invoicesbillingcc;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbInvoiceAmountLookup();
	abstract protected void defaultcmbInvoiceAmountLookupValue();
	abstract protected void bindcmbPaymentRefundedLookup();
	abstract protected void defaultcmbPaymentRefundedLookupValue();
	abstract protected void bindcmbReasonForNonPaymentLookup();
	abstract protected void defaultcmbReasonForNonPaymentLookupValue();
	abstract protected void bindcmbPaymentTypeLookup();
	abstract protected void defaultcmbPaymentTypeLookupValue();
	abstract protected void bindcmbPaymentMadeLookup();
	abstract protected void defaultcmbPaymentMadeLookupValue();
	abstract protected void bindcmbExemptionReasonLookup();
	abstract protected void defaultcmbExemptionReasonLookupValue();
	abstract protected void bindcmbIsPatientExemptLookup();
	abstract protected void defaultcmbIsPatientExemptLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNextClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbInvoiceAmountValueSet(Object value);
	abstract protected void oncmbPaymentRefundedValueSet(Object value);
	abstract protected void oncmbReasonForNonPaymentValueSet(Object value);
	abstract protected void oncmbPaymentTypeValueSet(Object value);
	abstract protected void oncmbPaymentMadeValueSet(Object value);
	abstract protected void onCmbPaymentMadeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbExemptionReasonValueSet(Object value);
	abstract protected void onCmbExemptionReasonValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIsPatientExemptValueSet(Object value);
	abstract protected void onCmbIsPatientExemptValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.btnNext().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNextClick();
			}
		});
		this.form.cmbInvoiceAmount().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbInvoiceAmountValueSet(value);
			}
		});
		this.form.cmbPaymentRefunded().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPaymentRefundedValueSet(value);
			}
		});
		this.form.cmbReasonForNonPayment().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReasonForNonPaymentValueSet(value);
			}
		});
		this.form.cmbPaymentType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPaymentTypeValueSet(value);
			}
		});
		this.form.cmbPaymentMade().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPaymentMadeValueSet(value);
			}
		});
		this.form.cmbPaymentMade().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbPaymentMadeValueChanged();
			}
		});
		this.form.cmbExemptionReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbExemptionReasonValueSet(value);
			}
		});
		this.form.cmbExemptionReason().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbExemptionReasonValueChanged();
			}
		});
		this.form.cmbIsPatientExempt().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIsPatientExemptValueSet(value);
			}
		});
		this.form.cmbIsPatientExempt().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbIsPatientExemptValueChanged();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbInvoiceAmountLookup();
		bindcmbPaymentRefundedLookup();
		bindcmbReasonForNonPaymentLookup();
		bindcmbPaymentTypeLookup();
		bindcmbPaymentMadeLookup();
		bindcmbExemptionReasonLookup();
		bindcmbIsPatientExemptLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbInvoiceAmountLookup();
		bindcmbPaymentRefundedLookup();
		bindcmbReasonForNonPaymentLookup();
		bindcmbPaymentTypeLookup();
		bindcmbPaymentMadeLookup();
		bindcmbExemptionReasonLookup();
		bindcmbIsPatientExemptLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbInvoiceAmountLookupValue();
		defaultcmbPaymentRefundedLookupValue();
		defaultcmbReasonForNonPaymentLookupValue();
		defaultcmbPaymentTypeLookupValue();
		defaultcmbPaymentMadeLookupValue();
		defaultcmbExemptionReasonLookupValue();
		defaultcmbIsPatientExemptLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
