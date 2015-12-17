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

package ims.clinical.forms.dischargeinpatient;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcomDestLookup();
	abstract protected void defaultcomDestLookupValue();
	abstract protected void bindgridFunctionalColStatusLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridActionsGridCheckBoxClicked(int column, GenForm.layerControl1Layer.tab1Container.gridActionsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomDestValueSet(Object value);
	abstract protected void onBtnDischargeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewActionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateActionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveActionsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelActionsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewFuncAssClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelFuncAssClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveFuncAssClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateFuncAssClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onbPrintClick() throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.layerControl1().tab1().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlayerControl1tab1Activated();
			}
		});
		this.form.layerControl1().tab2().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlayerControl1tab2Activated();
			}
		});
		this.form.layerControl1().tab1().gridActions().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridActionsGridCheckBoxClicked(column, new GenForm.layerControl1Layer.tab1Container.gridActionsRow(row), isChecked);
			}
		});
		this.form.layerControl1().tab1().comDest().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomDestValueSet(value);
			}
		});
		this.form.layerControl1().tab1().btnDischarge().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDischargeClick();
			}
		});
		this.form.layerControl1().tab1().btnNewAction().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewActionClick();
			}
		});
		this.form.layerControl1().tab1().btnUpdateAction().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateActionClick();
			}
		});
		this.form.layerControl1().tab1().btnSaveActions().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveActionsClick();
			}
		});
		this.form.layerControl1().tab1().btnCancelActions().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelActionsClick();
			}
		});
		this.form.layerControl1().tab2().btnNewFuncAss().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewFuncAssClick();
			}
		});
		this.form.layerControl1().tab2().btnCancelFuncAss().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelFuncAssClick();
			}
		});
		this.form.layerControl1().tab2().btnSaveFuncAss().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveFuncAssClick();
			}
		});
		this.form.layerControl1().tab2().btnUpdateFuncAss().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateFuncAssClick();
			}
		});
		this.form.layerControl1().tab2().bPrint().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onbPrintClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcomDestLookup();
		bindgridFunctionalColStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcomDestLookup();
		bindgridFunctionalColStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcomDestLookupValue();
	}
	private void onlayerControl1tab1Activated()
	{
		this.form.layerControl1().showtab1();
	}
	private void onlayerControl1tab2Activated()
	{
		this.form.layerControl1().showtab2();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
