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

package ims.ccosched.forms.pattreatmentplan;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void OnFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnComputerPlanningClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookFurtherClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void SaveOrder() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void MoveActionDown() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void MoveActionUp() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void ActionDisplayActive() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onActionsGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnViewAction() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnAddAction() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnUpdateAction() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewTreatmentPlanClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateTreatmentPlanClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewTreatmentPlanClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void TrPlanDisplayActive() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreatmentPlanGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				OnFormClosing(args);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				OnFormOpen(args);
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
		this.form.ctnDetails().btnComputerPlanning().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnComputerPlanningClick();
			}
		});
		this.form.ctnDetails().btnBookFurther().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookFurtherClick();
			}
		});
		this.form.btnSaveOrder().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				SaveOrder();
			}
		});
		this.form.btnDown().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				MoveActionDown();
			}
		});
		this.form.btnUp().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				MoveActionUp();
			}
		});
		this.form.chkActionActive().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				ActionDisplayActive();
			}
		});
		this.form.grdActionsGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onActionsGridSelectionChanged();
			}
		});
		this.form.btnViewAction().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnViewAction();
			}
		});
		this.form.btnAddAction().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnAddAction();
			}
		});
		this.form.btnUpdateAction().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnUpdateAction();
			}
		});
		this.form.btnViewTreatmentPlan().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewTreatmentPlanClick();
			}
		});
		this.form.btnUpdateTreatmentPlan().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateTreatmentPlanClick();
			}
		});
		this.form.btnNewTreatmentPlan().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewTreatmentPlanClick();
			}
		});
		this.form.chkTrPlanActive().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				TrPlanDisplayActive();
			}
		});
		this.form.grdTreatmentPlanGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreatmentPlanGridSelectionChanged();
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
