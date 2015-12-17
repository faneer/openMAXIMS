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

package ims.therapies.forms.homevisitrooms;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Therapies = new TherapiesContext(context);
		Core = new CoreContext(context);
	}
	public final class TherapiesContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private TherapiesContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getHomeVisitIsNotNull()
		{
			return !cx_TherapiesHomeVisit.getValueIsNull(context);
		}
		public ims.therapies.homeandenvironmentalvisit.vo.HomeVisitRefVo getHomeVisit()
		{
			return (ims.therapies.homeandenvironmentalvisit.vo.HomeVisitRefVo)cx_TherapiesHomeVisit.getValue(context);
		}
		public void setHomeVisit(ims.therapies.homeandenvironmentalvisit.vo.HomeVisitRefVo value)
		{
			cx_TherapiesHomeVisit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_TherapiesHomeVisit = new ims.framework.ContextVariable("Therapies.HomeVisit", "_cv_Therapies.HomeVisit");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");

		private ims.framework.Context context;
	}

	public TherapiesContext Therapies;
	public CoreContext Core;
}
