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

package ims.coe.forms.assesspersonalhygiene;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindanswerBoxHairInfestationLookup();
	abstract protected void defaultanswerBoxHairInfestationLookupValue();
	abstract protected void bindcomboBoxHairLookup();
	abstract protected void defaultcomboBoxHairLookupValue();
	abstract protected void bindgridHygienecolAbilityLookup();
	abstract protected void bindcomboBoxNailsLookup();
	abstract protected void defaultcomboBoxNailsLookupValue();
	abstract protected void bindanswerBoxBathefeetLookup();
	abstract protected void defaultanswerBoxBathefeetLookupValue();
	abstract protected void bindgridFootcolStatusLookup();
	abstract protected void bindcomboBoxFeetLookup();
	abstract protected void defaultcomboBoxFeetLookupValue();
	abstract protected void bindanswerBoxAttendPodiatristLookup();
	abstract protected void defaultanswerBoxAttendPodiatristLookupValue();
	abstract protected void bindanswerBoxAssisstancePersonalHygieneLookup();
	abstract protected void defaultanswerBoxAssisstancePersonalHygieneLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxHairInfestationValueSet(Object value);
	abstract protected void oncomboBoxHairValueSet(Object value);
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxNailsValueSet(Object value);
	abstract protected void onanswerBoxBathefeetValueSet(Object value);
	abstract protected void oncomboBoxFeetValueSet(Object value);
	abstract protected void onanswerBoxAttendPodiatristValueSet(Object value);
	abstract protected void onanswerBoxAssisstancePersonalHygieneValueSet(Object value);
	abstract protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen();
			}
		});
		this.form.container1().answerBoxHairInfestation().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxHairInfestationValueSet(value);
			}
		});
		this.form.container1().comboBoxHair().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxHairValueSet(value);
			}
		});
		this.form.container1().bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.container1().bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.container1().comboBoxNails().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxNailsValueSet(value);
			}
		});
		this.form.container1().answerBoxBathefeet().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxBathefeetValueSet(value);
			}
		});
		this.form.container1().comboBoxFeet().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxFeetValueSet(value);
			}
		});
		this.form.container1().answerBoxAttendPodiatrist().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxAttendPodiatristValueSet(value);
			}
		});
		this.form.container1().answerBoxAssisstancePersonalHygiene().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxAssisstancePersonalHygieneValueSet(value);
			}
		});
		this.form.checkBoxCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCopyPrevAssessmentValueChanged();
			}
		});
		this.form.linkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onInfoLinkClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindanswerBoxHairInfestationLookup();
		bindcomboBoxHairLookup();
		bindgridHygienecolAbilityLookup();
		bindcomboBoxNailsLookup();
		bindanswerBoxBathefeetLookup();
		bindgridFootcolStatusLookup();
		bindcomboBoxFeetLookup();
		bindanswerBoxAttendPodiatristLookup();
		bindanswerBoxAssisstancePersonalHygieneLookup();
	}
	protected void rebindAllLookups()
	{
		bindanswerBoxHairInfestationLookup();
		bindcomboBoxHairLookup();
		bindgridHygienecolAbilityLookup();
		bindcomboBoxNailsLookup();
		bindanswerBoxBathefeetLookup();
		bindgridFootcolStatusLookup();
		bindcomboBoxFeetLookup();
		bindanswerBoxAttendPodiatristLookup();
		bindanswerBoxAssisstancePersonalHygieneLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultanswerBoxHairInfestationLookupValue();
		defaultcomboBoxHairLookupValue();
		defaultcomboBoxNailsLookupValue();
		defaultanswerBoxBathefeetLookupValue();
		defaultcomboBoxFeetLookupValue();
		defaultanswerBoxAttendPodiatristLookupValue();
		defaultanswerBoxAssisstancePersonalHygieneLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
