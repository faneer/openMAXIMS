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

package ims.scheduling.forms.profilesslotgeneric;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTypeLookup();
	abstract protected void defaultcmbTypeLookupValue();
	abstract protected void bindcmbPriorityLookup();
	abstract protected void defaultcmbPriorityLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkShowAllDosValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCalculateNrOfSlotsEndTimeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimEndValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdClinicTypesGridCheckBoxClicked(int column, GenForm.grdClinicTypesRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDOSGridCheckBoxClicked(int column, GenForm.grdDOSRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTypeValueSet(Object value);
	abstract protected void onCmbTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbActivityValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIntNoSlotsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPriorityValueSet(Object value);
	abstract protected void onDteEffectiveFromDateValueChanged() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.chkShowAllDos().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkShowAllDosValueChanged();
			}
		});
		this.form.btnCalculateNrOfSlotsEndTime().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCalculateNrOfSlotsEndTimeClick();
			}
		});
		this.form.timEnd().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTimEndValueChanged();
			}
		});
		this.form.grdClinicTypes().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdClinicTypesGridCheckBoxClicked(column, new GenForm.grdClinicTypesRow(row), isChecked);
			}
		});
		this.form.grdDOS().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDOSGridCheckBoxClicked(column, new GenForm.grdDOSRow(row), isChecked);
			}
		});
		this.form.cmbType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeValueSet(value);
			}
		});
		this.form.cmbType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTypeValueChanged();
			}
		});
		this.form.btnOk().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOkClick();
			}
		});
		this.form.cmbActivity().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbActivityValueChanged();
			}
		});
		this.form.intNoSlots().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onIntNoSlotsValueChanged();
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
		this.form.cmbPriority().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPriorityValueSet(value);
			}
		});
		this.form.dteEffectiveFromDate().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteEffectiveFromDateValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTypeLookup();
		bindcmbPriorityLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTypeLookup();
		bindcmbPriorityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTypeLookupValue();
		defaultcmbPriorityLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
