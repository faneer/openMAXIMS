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

package ims.scheduling.forms.profiletheatreslotdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.domain.DomainInterface.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.domain.DomainInterface domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.chkActive().setValue(false);
		this.form.intSlotInterval().setValue(null);
		this.form.timStart().setValue(null);
		this.form.intNoSlots().setValue(null);
	}
	protected void populateScreenFromData(ims.scheduling.vo.ProfileParentChildSlotVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getIsActiveIsNotNull())
			this.form.chkActive().setValue(value.getIsActive().booleanValue());
		this.form.intSlotInterval().setValue(value.getDurationIsNotNull() ? value.getDuration() : null);
		this.form.timStart().setValue(value.getStartTimeIsNotNull() ? value.getStartTime() : null);
		this.form.intNoSlots().setValue(value.getNoOfInstancesIsNotNull() ? value.getNoOfInstances() : null);
	}
	protected ims.scheduling.vo.ProfileParentChildSlotVo populateDataFromScreen(ims.scheduling.vo.ProfileParentChildSlotVo value)
	{
		if(value == null)
			value = new ims.scheduling.vo.ProfileParentChildSlotVo();

		value.setIsActive(new Boolean(this.form.chkActive().getValue()));
		value.setDuration(this.form.intSlotInterval().getValue());
		value.setStartTime(this.form.timStart().getValue());
		value.setNoOfInstances(this.form.intNoSlots().getValue());

		return value;
	}
	protected ims.scheduling.vo.ProfileParentChildSlotVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.scheduling.vo.ProfileParentChildSlotVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.domain.DomainInterface domain;
}
