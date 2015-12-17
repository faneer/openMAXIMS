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

package ims.RefMan.forms.secondopiniondialog;

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

		public boolean getSecondOpinionReferralStatusIsNotNull()
		{
			return !cx_RefManSecondOpinionReferralStatus.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralStatusVo getSecondOpinionReferralStatus()
		{
			return (ims.RefMan.vo.CatsReferralStatusVo)cx_RefManSecondOpinionReferralStatus.getValue(context);
		}
		public void setSecondOpinionReferralStatus(ims.RefMan.vo.CatsReferralStatusVo value)
		{
			cx_RefManSecondOpinionReferralStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSecondOpinionReferralStatus = new ims.framework.ContextVariable("RefMan.SecondOpinionReferralStatus", "_cv_RefMan.SecondOpinionReferralStatus");
		public boolean getCatsReferralStatusIsNotNull()
		{
			return !cx_RefManCatsReferralStatus.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralStatusVo getCatsReferralStatus()
		{
			return (ims.RefMan.vo.CatsReferralStatusVo)cx_RefManCatsReferralStatus.getValue(context);
		}
		public void setCatsReferralStatus(ims.RefMan.vo.CatsReferralStatusVo value)
		{
			cx_RefManCatsReferralStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferralStatus = new ims.framework.ContextVariable("RefMan.CatsReferralStatus", "_cv_RefMan.CatsReferralStatus");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
