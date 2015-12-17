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

package ims.spinalinjuries.forms.nurassessmentcommunication;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.NurAssessmentCommunication.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.NurAssessmentCommunication domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansUseCallBellValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansUseCallBell().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansUseCallBellLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansUseCallBellLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansUseCallBell().addOption(instance);
		}
	}
	protected final void bindansUseCallBellLookup()
	{
		this.form.ansUseCallBell().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansUseCallBell().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansUseCallBellLookupValue()
	{
		this.form.ansUseCallBell().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onansDifficultyInCommunicationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansDifficultyInCommunication().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansDifficultyInCommunicationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansDifficultyInCommunicationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansDifficultyInCommunication().addOption(instance);
		}
	}
	protected final void bindansDifficultyInCommunicationLookup()
	{
		this.form.ansDifficultyInCommunication().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansDifficultyInCommunication().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansDifficultyInCommunicationLookupValue()
	{
		this.form.ansDifficultyInCommunication().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgrdCommunicationColSelectLookup()
	{
		this.form.grdCommunication().answerBoxColumnClear(1);
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdCommunication().answerBoxColumnNewOption(1, lookupCollection.get(x));
		}
	}
	protected void clearScreen()
	{
		this.form.ansUseCallBell().setValue(null);
		this.form.ansDifficultyInCommunication().setValue(null);
		this.form.chkSectionComplete().setValue(false);
		this.form.txtNotes().setValue("");
		this.form.chkCopy().setValue(false);
	}
	protected void populateScreenFromData(ims.spinalinjuries.vo.NurAssessmentCommunicationVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.ansUseCallBell().setValue(value.getUseTheCallBellIsNotNull() ? value.getUseTheCallBell() : null);
		this.form.ansDifficultyInCommunication().setValue(value.getDifficultyInCommunicationIsNotNull() ? value.getDifficultyInCommunication() : null);
		if(value.getIsCompleteIsNotNull())
			this.form.chkSectionComplete().setValue(value.getIsComplete().booleanValue());
		this.form.txtNotes().setValue(value.getNotesIsNotNull() ? value.getNotes(): null);
		if(value.getCopyIsNotNull())
			this.form.chkCopy().setValue(value.getCopy().booleanValue());
	}
	protected ims.spinalinjuries.vo.NurAssessmentCommunicationVo populateDataFromScreen(ims.spinalinjuries.vo.NurAssessmentCommunicationVo value)
	{
		if(value == null)
			value = new ims.spinalinjuries.vo.NurAssessmentCommunicationVo();

		value.setUseTheCallBell(this.form.ansUseCallBell().getValue());
		value.setDifficultyInCommunication(this.form.ansDifficultyInCommunication().getValue());
		value.setIsComplete(new Boolean(this.form.chkSectionComplete().getValue()));
		value.setNotes(this.form.txtNotes().getValue());
		value.setCopy(new Boolean(this.form.chkCopy().getValue()));

		return value;
	}
	protected ims.spinalinjuries.vo.NurAssessmentCommunicationVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.spinalinjuries.vo.NurAssessmentCommunicationVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.NurAssessmentCommunication domain;
}
