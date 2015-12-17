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

package ims.ccosched.forms.clinicview;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTrPlanCommentsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onHistoryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTumourDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreatmentBookedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onPrintClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onArrivedPatientsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onSeenClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDNAClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onOutcomeIncompleteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onOutcomeCompleteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onArrivalClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onMainGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onListPatientsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkActiveClinicsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onListClinicDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDateValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onClinicValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onUpdateCommentClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormClosing(args);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
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
		this.form.TrPlanComments().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTrPlanCommentsClick();
			}
		});
		this.form.History().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onHistoryClick();
			}
		});
		this.form.TumourDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTumourDetailsClick();
			}
		});
		this.form.TreatmentBooked().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTreatmentBookedClick();
			}
		});
		this.form.Print().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onPrintClick();
			}
		});
		this.form.ArrivedPatients().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onArrivedPatientsClick();
			}
		});
		this.form.Seen().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onSeenClick();
			}
		});
		this.form.Cancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCancelClick();
			}
		});
		this.form.DNA().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDNAClick();
			}
		});
		this.form.OutcomeIncomplete().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onOutcomeIncompleteClick();
			}
		});
		this.form.OutcomeComplete().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onOutcomeCompleteClick();
			}
		});
		this.form.Arrival().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onArrivalClick();
			}
		});
		this.form.MainGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onMainGridSelectionChanged();
			}
		});
		this.form.ListPatients().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onListPatientsClick();
			}
		});
		this.form.chkActiveClinics().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkActiveClinicsValueChanged();
			}
		});
		this.form.ListClinicDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onListClinicDetailsClick();
			}
		});
		this.form.Date().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDateValueChanged();
			}
		});
		this.form.Clinic().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onClinicValueChanged();
			}
		});
		this.form.UpdateComment().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onUpdateCommentClick();
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
