//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.dementiaassessmentform;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDementiaConfigurationIsNotNull()
		{
			return !cx_AdminDementiaConfiguration.getValueIsNull(context);
		}
		public ims.admin.vo.DementiaConfigurationVo getDementiaConfiguration()
		{
			return (ims.admin.vo.DementiaConfigurationVo)cx_AdminDementiaConfiguration.getValue(context);
		}
		public void setDementiaConfiguration(ims.admin.vo.DementiaConfigurationVo value)
		{
			cx_AdminDementiaConfiguration.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminDementiaConfiguration = new ims.framework.ContextVariable("Admin.DementiaConfiguration", "_cv_Admin.DementiaConfiguration");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAMTSRecordToViewIsNotNull()
		{
			return !cx_ClinicalAMTSRecordToView.getValueIsNull(context);
		}
		public ims.clinical.vo.DementiaAssessAndInvestigateVo getAMTSRecordToView()
		{
			return (ims.clinical.vo.DementiaAssessAndInvestigateVo)cx_ClinicalAMTSRecordToView.getValue(context);
		}
		public void setAMTSRecordToView(ims.clinical.vo.DementiaAssessAndInvestigateVo value)
		{
			cx_ClinicalAMTSRecordToView.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAMTSRecordToView = new ims.framework.ContextVariable("Clinical.AMTSRecordToView", "_cv_Clinical.AMTSRecordToView");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getRieMessageIsNotNull()
		{
			return !cx_CoreRieMessage.getValueIsNull(context);
		}
		public String getRieMessage()
		{
			return (String)cx_CoreRieMessage.getValue(context);
		}
		public void setRieMessage(String value)
		{
			cx_CoreRieMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreRieMessage = new ims.framework.ContextVariable("Core.RieMessage", "_cv_Core.RieMessage");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
	public ClinicalContext Clinical;
	public CoreContext Core;
}
