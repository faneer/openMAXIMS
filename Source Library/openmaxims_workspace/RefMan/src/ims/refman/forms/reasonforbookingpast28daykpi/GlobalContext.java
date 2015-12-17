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

package ims.RefMan.forms.reasonforbookingpast28daykpi;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReasonRTTWeekWaitBreachIsNotNull()
		{
			return !cx_RefManReasonRTTWeekWaitBreach.getValueIsNull(context);
		}
		public ims.RefMan.vo.ReasonRTTWeekWaitBreachVo getReasonRTTWeekWaitBreach()
		{
			return (ims.RefMan.vo.ReasonRTTWeekWaitBreachVo)cx_RefManReasonRTTWeekWaitBreach.getValue(context);
		}
		public void setReasonRTTWeekWaitBreach(ims.RefMan.vo.ReasonRTTWeekWaitBreachVo value)
		{
			cx_RefManReasonRTTWeekWaitBreach.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReasonRTTWeekWaitBreach = new ims.framework.ContextVariable("RefMan.ReasonRTTWeekWaitBreach", "_cv_RefMan.ReasonRTTWeekWaitBreach");
		public boolean getReason28DayRuleBreachIsNotNull()
		{
			return !cx_RefManReason28DayRuleBreach.getValueIsNull(context);
		}
		public ims.RefMan.vo.Reason28DayRuleBreachVo getReason28DayRuleBreach()
		{
			return (ims.RefMan.vo.Reason28DayRuleBreachVo)cx_RefManReason28DayRuleBreach.getValue(context);
		}
		public void setReason28DayRuleBreach(ims.RefMan.vo.Reason28DayRuleBreachVo value)
		{
			cx_RefManReason28DayRuleBreach.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReason28DayRuleBreach = new ims.framework.ContextVariable("RefMan.Reason28DayRuleBreach", "_cv_RefMan.Reason28DayRuleBreach");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
