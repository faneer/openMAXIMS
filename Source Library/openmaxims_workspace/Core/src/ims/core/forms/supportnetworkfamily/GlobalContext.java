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

package ims.core.forms.supportnetworkfamily;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getHideCancelButtonIsNotNull()
		{
			return !cx_CoreHideCancelButton.getValueIsNull(context);
		}
		public Boolean getHideCancelButton()
		{
			return (Boolean)cx_CoreHideCancelButton.getValue(context);
		}
		public void setHideCancelButton(Boolean value)
		{
			cx_CoreHideCancelButton.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHideCancelButton = new ims.framework.ContextVariable("Core.HideCancelButton", "_cv_Core.HideCancelButton");
		public boolean getSupportNetworkFamilySearchCriteriaIsNotNull()
		{
			return !cx_CoreSupportNetworkFamilySearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.SupportNetworkSearchCriteriaVo getSupportNetworkFamilySearchCriteria()
		{
			return (ims.core.vo.SupportNetworkSearchCriteriaVo)cx_CoreSupportNetworkFamilySearchCriteria.getValue(context);
		}
		public void setSupportNetworkFamilySearchCriteria(ims.core.vo.SupportNetworkSearchCriteriaVo value)
		{
			cx_CoreSupportNetworkFamilySearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSupportNetworkFamilySearchCriteria = new ims.framework.ContextVariable("Core.SupportNetworkFamilySearchCriteria", "_cvp_Core.SupportNetworkFamilySearchCriteria");
		public boolean getSupportNetworkFamilyAliasSearchCriteriaIsNotNull()
		{
			return !cx_CoreSupportNetworkFamilyAliasSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.SupportNetworkSearchCriteriaVo getSupportNetworkFamilyAliasSearchCriteria()
		{
			return (ims.core.vo.SupportNetworkSearchCriteriaVo)cx_CoreSupportNetworkFamilyAliasSearchCriteria.getValue(context);
		}
		public void setSupportNetworkFamilyAliasSearchCriteria(ims.core.vo.SupportNetworkSearchCriteriaVo value)
		{
			cx_CoreSupportNetworkFamilyAliasSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSupportNetworkFamilyAliasSearchCriteria = new ims.framework.ContextVariable("Core.SupportNetworkFamilyAliasSearchCriteria", "_cvp_Core.SupportNetworkFamilyAliasSearchCriteria");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
