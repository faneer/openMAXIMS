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

package ims.eas.forms.patienteaslist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		EAS = new EASContext(context);
		Core = new CoreContext(context);
	}
	public final class EASContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EASContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getElectronicActionSheetIsNotNull()
		{
			return !cx_EASElectronicActionSheet.getValueIsNull(context);
		}
		public ims.eas.vo.ElectronicActionSheetVo getElectronicActionSheet()
		{
			return (ims.eas.vo.ElectronicActionSheetVo)cx_EASElectronicActionSheet.getValue(context);
		}
		public void setElectronicActionSheet(ims.eas.vo.ElectronicActionSheetVo value)
		{
			cx_EASElectronicActionSheet.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EASElectronicActionSheet = new ims.framework.ContextVariable("EAS.ElectronicActionSheet", "_cv_EAS.ElectronicActionSheet");
		public boolean getEasStatusHistoryIsNotNull()
		{
			return !cx_EASEasStatusHistory.getValueIsNull(context);
		}
		public ims.eas.vo.EASStatusRecordVoCollection getEasStatusHistory()
		{
			return (ims.eas.vo.EASStatusRecordVoCollection)cx_EASEasStatusHistory.getValue(context);
		}
		public void setEasStatusHistory(ims.eas.vo.EASStatusRecordVoCollection value)
		{
			cx_EASEasStatusHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EASEasStatusHistory = new ims.framework.ContextVariable("EAS.EasStatusHistory", "_cv_EAS.EasStatusHistory");
		public boolean getPatientEASListSearchCriteriaIsNotNull()
		{
			return !cx_EASPatientEASListSearchCriteria.getValueIsNull(context);
		}
		public ims.eas.vo.PatientEASListSearchCriteriaVo getPatientEASListSearchCriteria()
		{
			return (ims.eas.vo.PatientEASListSearchCriteriaVo)cx_EASPatientEASListSearchCriteria.getValue(context);
		}
		public void setPatientEASListSearchCriteria(ims.eas.vo.PatientEASListSearchCriteriaVo value)
		{
			cx_EASPatientEASListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EASPatientEASListSearchCriteria = new ims.framework.ContextVariable("EAS.PatientEASListSearchCriteria", "_cvp_EAS.PatientEASListSearchCriteria");

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
		public boolean getOutpatientAttendanceForOrderIsNotNull()
		{
			return !cx_CoreOutpatientAttendanceForOrder.getValueIsNull(context);
		}
		public ims.core.vo.OutPatientListVo getOutpatientAttendanceForOrder()
		{
			return (ims.core.vo.OutPatientListVo)cx_CoreOutpatientAttendanceForOrder.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreOutpatientAttendanceForOrder = new ims.framework.ContextVariable("Core.OutpatientAttendanceForOrder", "_cv_Core.OutpatientAttendanceForOrder");
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

		private ims.framework.Context context;
	}

	public EASContext EAS;
	public CoreContext Core;
}
