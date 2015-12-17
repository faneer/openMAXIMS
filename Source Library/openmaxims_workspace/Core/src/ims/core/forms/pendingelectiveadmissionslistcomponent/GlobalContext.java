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

package ims.core.forms.pendingelectiveadmissionslistcomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		STHK = new STHKContext(context);
		Core = new CoreContext(context);
	}
	public final class STHKContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private STHKContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPendingElectiveAdmissionListFilterIsNotNull()
		{
			return !cx_STHKPendingElectiveAdmissionListFilter.getValueIsNull(context);
		}
		public ims.core.vo.PendingElectiveAdmissionListFilterVo getPendingElectiveAdmissionListFilter()
		{
			return (ims.core.vo.PendingElectiveAdmissionListFilterVo)cx_STHKPendingElectiveAdmissionListFilter.getValue(context);
		}
		public void setPendingElectiveAdmissionListFilter(ims.core.vo.PendingElectiveAdmissionListFilterVo value)
		{
			cx_STHKPendingElectiveAdmissionListFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_STHKPendingElectiveAdmissionListFilter = new ims.framework.ContextVariable("STHK.PendingElectiveAdmissionListFilter", "_cvp_STHK.PendingElectiveAdmissionListFilter");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getPatientToBeDisplayedIsNotNull()
		{
			return !cx_CorePatientToBeDisplayed.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientToBeDisplayed()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientToBeDisplayed.getValue(context);
		}
		public void setPatientToBeDisplayed(ims.core.vo.PatientShort value)
		{
			cx_CorePatientToBeDisplayed.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientToBeDisplayed = new ims.framework.ContextVariable("Core.PatientToBeDisplayed", "_cv_Core.PatientToBeDisplayed");
		public boolean getCommentDialogStringIsNotNull()
		{
			return !cx_CoreCommentDialogString.getValueIsNull(context);
		}
		public String getCommentDialogString()
		{
			return (String)cx_CoreCommentDialogString.getValue(context);
		}
		public void setCommentDialogString(String value)
		{
			cx_CoreCommentDialogString.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogString = new ims.framework.ContextVariable("Core.CommentDialogString", "_cv_Core.CommentDialogString");
		public boolean getSelectingPatientFormIsNotNull()
		{
			return !cx_CoreSelectingPatientForm.getValueIsNull(context);
		}
		public ims.framework.FormName getSelectingPatientForm()
		{
			return (ims.framework.FormName)cx_CoreSelectingPatientForm.getValue(context);
		}
		public void setSelectingPatientForm(ims.framework.FormName value)
		{
			cx_CoreSelectingPatientForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectingPatientForm = new ims.framework.ContextVariable("Core.SelectingPatientForm", "_cvp_Core.SelectingPatientForm");

		private ims.framework.Context context;
	}

	public STHKContext STHK;
	public CoreContext Core;
}
