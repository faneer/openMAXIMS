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

package ims.oncology.forms.actualplandetails;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbActualTreatmentLookup();
	abstract protected void defaultcmbActualTreatmentLookupValue();
	abstract protected void bindcmbOrganisationOrganisedLookup();
	abstract protected void defaultcmbOrganisationOrganisedLookupValue();
	abstract protected void bindcmbPlannedTreatmentLookup();
	abstract protected void defaultcmbPlannedTreatmentLookupValue();
	abstract protected void bindcmbOrganisationPlannedLookup();
	abstract protected void defaultcmbOrganisationPlannedLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbActualTreatmentValueSet(Object value);
	abstract protected void oncmbOrganisationOrganisedValueSet(Object value);
	abstract protected void oncmbPlannedTreatmentValueSet(Object value);
	abstract protected void oncmbOrganisationPlannedValueSet(Object value);
	abstract protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.cmbActualTreatment().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbActualTreatmentValueSet(value);
			}
		});
		this.form.cmbOrganisationOrganised().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOrganisationOrganisedValueSet(value);
			}
		});
		this.form.cmbPlannedTreatment().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPlannedTreatmentValueSet(value);
			}
		});
		this.form.cmbOrganisationPlanned().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOrganisationPlannedValueSet(value);
			}
		});
		this.form.bNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBNewClick();
			}
		});
		this.form.bEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBEditClick();
			}
		});
		this.form.bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbActualTreatmentLookup();
		bindcmbOrganisationOrganisedLookup();
		bindcmbPlannedTreatmentLookup();
		bindcmbOrganisationPlannedLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbActualTreatmentLookup();
		bindcmbOrganisationOrganisedLookup();
		bindcmbPlannedTreatmentLookup();
		bindcmbOrganisationPlannedLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbActualTreatmentLookupValue();
		defaultcmbOrganisationOrganisedLookupValue();
		defaultcmbPlannedTreatmentLookupValue();
		defaultcmbOrganisationPlannedLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
