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

package ims.icp.forms.patienticpactionlinkeddetailscomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCompleteValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDynamicFormFormModeChanged(ims.framework.enumerations.FormMode formMode);
	abstract protected void onImbStructuralContextInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrStructuralAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbStructuralHelpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrGraphicalAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbGraphicalHelpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbGraphicalContextInfoClick() throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen(args);
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.chkComplete().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCompleteValueChanged();
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
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.lyrMain().tabPageForm().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintabPageFormActivated();
			}
		});
		this.form.lyrMain().tabPageAssessment().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintabPageAssessmentActivated();
			}
		});
		this.form.lyrMain().tabPageGraphicalAssessment().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintabPageGraphicalAssessmentActivated();
			}
		});
		this.form.lyrMain().tabPageReport().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintabPageReportActivated();
			}
		});
		this.form.lyrMain().tabPageNone().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintabPageNoneActivated();
			}
		});
		this.form.lyrMain().tabPageForm().dynamicForm().setFormModeChangedEvent(new DynamicFormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.FormMode value)
			{
				onDynamicFormFormModeChanged(value);
			}
		});
		this.form.lyrMain().tabPageAssessment().imbStructuralContextInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbStructuralContextInfoClick();
			}
		});
		this.form.lyrMain().tabPageAssessment().recbrStructuralAssessment().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrStructuralAssessmentValueChanged();
			}
		});
		this.form.lyrMain().tabPageAssessment().imbStructuralHelp().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbStructuralHelpClick();
			}
		});
		this.form.lyrMain().tabPageGraphicalAssessment().recbrGraphicalAssessment().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrGraphicalAssessmentValueChanged();
			}
		});
		this.form.lyrMain().tabPageGraphicalAssessment().imbGraphicalHelp().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbGraphicalHelpClick();
			}
		});
		this.form.lyrMain().tabPageGraphicalAssessment().imbGraphicalContextInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbGraphicalContextInfoClick();
			}
		});
	}
	private void onlyrMaintabPageFormActivated()
	{
		this.form.lyrMain().showtabPageForm();
	}
	private void onlyrMaintabPageAssessmentActivated()
	{
		this.form.lyrMain().showtabPageAssessment();
	}
	private void onlyrMaintabPageGraphicalAssessmentActivated()
	{
		this.form.lyrMain().showtabPageGraphicalAssessment();
	}
	private void onlyrMaintabPageReportActivated()
	{
		this.form.lyrMain().showtabPageReport();
	}
	private void onlyrMaintabPageNoneActivated()
	{
		this.form.lyrMain().showtabPageNone();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
