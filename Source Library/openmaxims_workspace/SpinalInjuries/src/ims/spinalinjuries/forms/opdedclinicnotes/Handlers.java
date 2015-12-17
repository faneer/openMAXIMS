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

package ims.spinalinjuries.forms.opdedclinicnotes;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdTreatmentcolTriedLookup();
	abstract protected void bindgrdTreatmentcolScoreLookup();
	abstract protected void bindcmbMaritalStatusLookup();
	abstract protected void defaultcmbMaritalStatusLookupValue();
	abstract protected void bindcmbErectionLookup();
	abstract protected void defaultcmbErectionLookupValue();
	abstract protected void bindcmbConsentSgnLookup();
	abstract protected void defaultcmbConsentSgnLookupValue();
	abstract protected void bindcmbTxOptionsDiscLookup();
	abstract protected void defaultcmbTxOptionsDiscLookupValue();
	abstract protected void bindcmbAdviceLitGivenLookup();
	abstract protected void defaultcmbAdviceLitGivenLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrOPDEDClinicNotesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTreatmentGridComboBoxSelectionChanged(int column, GenForm.grdTreatmentRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbMaritalStatusValueSet(Object value);
	abstract protected void onCmbMaritalStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbErectionValueSet(Object value);
	abstract protected void oncmbConsentSgnValueSet(Object value);
	abstract protected void oncmbTxOptionsDiscValueSet(Object value);
	abstract protected void oncmbAdviceLitGivenValueSet(Object value);
	abstract protected void onCmbAdviceLitGivenValueChanged() throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen();
			}
		});
		this.form.recbrOPDEDClinicNotes().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrOPDEDClinicNotesValueChanged();
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
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
			}
		});
		this.form.grdTreatment().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTreatmentGridComboBoxSelectionChanged(column, new GenForm.grdTreatmentRow(row), value);
			}
		});
		this.form.cmbMaritalStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMaritalStatusValueSet(value);
			}
		});
		this.form.cmbMaritalStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbMaritalStatusValueChanged();
			}
		});
		this.form.cmbErection().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbErectionValueSet(value);
			}
		});
		this.form.cmbConsentSgn().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbConsentSgnValueSet(value);
			}
		});
		this.form.cmbTxOptionsDisc().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTxOptionsDiscValueSet(value);
			}
		});
		this.form.cmbAdviceLitGiven().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAdviceLitGivenValueSet(value);
			}
		});
		this.form.cmbAdviceLitGiven().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbAdviceLitGivenValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdTreatmentcolTriedLookup();
		bindgrdTreatmentcolScoreLookup();
		bindcmbMaritalStatusLookup();
		bindcmbErectionLookup();
		bindcmbConsentSgnLookup();
		bindcmbTxOptionsDiscLookup();
		bindcmbAdviceLitGivenLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdTreatmentcolTriedLookup();
		bindgrdTreatmentcolScoreLookup();
		bindcmbMaritalStatusLookup();
		bindcmbErectionLookup();
		bindcmbConsentSgnLookup();
		bindcmbTxOptionsDiscLookup();
		bindcmbAdviceLitGivenLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbMaritalStatusLookupValue();
		defaultcmbErectionLookupValue();
		defaultcmbConsentSgnLookupValue();
		defaultcmbTxOptionsDiscLookupValue();
		defaultcmbAdviceLitGivenLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
