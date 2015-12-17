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

package ims.RefMan.forms.booktheatreslotdetaildialog;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTCIOfferedMethodLookup();
	abstract protected void defaultcmbTCIOfferedMethodLookupValue();
	abstract protected void bindcmbReasonDeclinedLookup();
	abstract protected void defaultcmbReasonDeclinedLookupValue();
	abstract protected void bindcmbERODReasonLookup();
	abstract protected void defaultcmbERODReasonLookupValue();
	abstract protected void bindcmbExceededReasonLookup();
	abstract protected void defaultcmbExceededReasonLookupValue();
	abstract protected void bindcmbAnaesTypeLookup();
	abstract protected void defaultcmbAnaesTypeLookupValue();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnElectiveListDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPendingEmergencyClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkExtendedDelayValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTCIOfferedMethodValueSet(Object value);
	abstract protected void oncmbReasonDeclinedValueSet(Object value);
	abstract protected void onRadioButtonGroupReasonableOfferMadeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDteDateOfOfferValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbOtherReasonClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbERODReasonValueSet(Object value);
	abstract protected void onBtnResourceClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDashboardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbExceededReasonValueSet(Object value);
	abstract protected void onDteToComeInValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAnaesTypeValueSet(Object value);
	abstract protected void onChkErodValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
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
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnElectiveListDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnElectiveListDetailsClick();
			}
		});
		this.form.btnPendingEmergency().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPendingEmergencyClick();
			}
		});
		this.form.chkExtendedDelay().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkExtendedDelayValueChanged();
			}
		});
		this.form.cmbTCIOfferedMethod().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTCIOfferedMethodValueSet(value);
			}
		});
		this.form.cmbReasonDeclined().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReasonDeclinedValueSet(value);
			}
		});
		this.form.GroupReasonableOfferMade().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupReasonableOfferMadeValueChanged();
			}
		});
		this.form.dteDateOfOffer().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteDateOfOfferValueChanged();
			}
		});
		this.form.cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.imbOtherReason().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbOtherReasonClick();
			}
		});
		this.form.cmbERODReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbERODReasonValueSet(value);
			}
		});
		this.form.btnResource().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnResourceClick();
			}
		});
		this.form.btnDashboard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDashboardClick();
			}
		});
		this.form.cmbExceededReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbExceededReasonValueSet(value);
			}
		});
		this.form.dteToComeIn().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteToComeInValueChanged();
			}
		});
		this.form.cmbAnaesType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAnaesTypeValueSet(value);
			}
		});
		this.form.chkErod().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkErodValueChanged();
			}
		});
		this.form.btnBook().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookClick();
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
		bindcmbTCIOfferedMethodLookup();
		bindcmbReasonDeclinedLookup();
		bindcmbERODReasonLookup();
		bindcmbExceededReasonLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTCIOfferedMethodLookup();
		bindcmbReasonDeclinedLookup();
		bindcmbERODReasonLookup();
		bindcmbExceededReasonLookup();
		bindcmbAnaesTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTCIOfferedMethodLookupValue();
		defaultcmbReasonDeclinedLookupValue();
		defaultcmbERODReasonLookupValue();
		defaultcmbExceededReasonLookupValue();
		defaultcmbAnaesTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
